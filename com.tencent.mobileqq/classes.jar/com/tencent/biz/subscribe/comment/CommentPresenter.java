package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetCommentListRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.SubscribeGlobalInfo;
import com.tencent.biz.subscribe.baseUI.AbsUIGroup;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.CommentReplyEvent;
import com.tencent.biz.subscribe.utils.EvilReportUtil;
import com.tencent.biz.subscribe.utils.EvilReportUtil.EvilReportParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;

public class CommentPresenter
  extends AbsUIGroup<CertifiedAccountMeta.StComment>
  implements View.OnClickListener, Animation.AnimationListener, CompoundButton.OnCheckedChangeListener, IEventReceiver
{
  private static final String j = "CommentPresenter";
  private ActionSheetDialog A;
  private boolean B;
  private boolean C;
  private COMM.StCommonExt D;
  private String E;
  private String F;
  private long G;
  private boolean H;
  private boolean I = false;
  private boolean J = false;
  private Animation K;
  private Animation L;
  private boolean M = false;
  private boolean N = false;
  private Map<Integer, CertifiedAccountMeta.StFeed> O = new HashMap();
  private ArrayList<CertifiedAccountMeta.StComment> P;
  private int Q;
  private boolean R;
  private CommentPresenter.CommentWindowListener S;
  private OnCommentInputShowListener T;
  private CommentPresenter.GetFeedResponseListener U;
  private View V;
  private int W;
  private String X;
  private ExtraTypeInfo Y;
  private boolean Z;
  private boolean aa;
  private AbsListView.OnScrollListener ab = new CommentPresenter.4(this);
  private View.OnLayoutChangeListener ac = new CommentPresenter.5(this);
  private int ad;
  private int ae = -1;
  ListView g;
  View h;
  protected CommentBusiness i;
  private final CommentPresenter.CommentEventReceiver k;
  private final Activity l;
  private ViewStub m;
  private CommentPresenter.OnFeedCommentElementClickListener n;
  private View o;
  private TextView p;
  private TextView q;
  private View r;
  private SubscribeCommentInputPopupWindow s;
  private CertifiedAccountMeta.StComment t;
  private CertifiedAccountMeta.StReply u;
  private long v;
  private Map<Long, CertifiedAccountMeta.StUser> w = new HashMap();
  private Map<Long, CertifiedAccountMeta.StComment> x = new HashMap();
  private Map<Long, CertifiedAccountMeta.StReply> y = new HashMap();
  private NewCommentAdapter z;
  
  public CommentPresenter(Activity paramActivity, boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed, CommentPresenter.GetFeedResponseListener paramGetFeedResponseListener, ExtraTypeInfo paramExtraTypeInfo)
  {
    super(paramActivity, paramBoolean);
    this.l = paramActivity;
    this.k = new CommentPresenter.CommentEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.k);
    this.U = paramGetFeedResponseListener;
    this.Y = paramExtraTypeInfo;
    u();
    c(paramStFeed);
    w();
  }
  
  private String A()
  {
    if (z() == null)
    {
      QLog.e(j, 2, "getCellId null");
      return "";
    }
    return z().id.get();
  }
  
  private CertifiedAccountMeta.StUser B()
  {
    if (SubscribeGlobalInfo.a() != null) {
      return SubscribeGlobalInfo.a();
    }
    CertifiedAccountMeta.StUser localStUser = new CertifiedAccountMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    PBStringField localPBStringField = localStUser.nick;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localPBStringField.set(localBaseApplicationImpl.getProperty(localStringBuilder.toString()));
    localStUser.type.set(0);
    return localStUser;
  }
  
  private void C()
  {
    v().a(z(), false);
  }
  
  private void D()
  {
    try
    {
      if (this.i == null)
      {
        QLog.e(j, 1, "innerInitData return empty because CommentBusiness is null ");
        return;
      }
      this.P = v().c(A());
      this.D = v().a(A());
      ArrayList localArrayList = this.P;
      if (localArrayList == null) {
        return;
      }
      if (this.z != null)
      {
        this.z.a();
        this.z.a(this.P);
        if (this.Z) {
          this.z.a(0);
        }
        this.z.notifyDataSetChanged();
      }
      if ((this.g != null) && (this.ae != i()) && (this.Z))
      {
        this.ae = i();
        QLog.d(j, 1, "mNeedShowCommentList2");
        this.g.setSelection(0);
      }
      if ((this.P != null) && (this.P.size() > 0)) {
        this.Q = v().b(A());
      }
      return;
    }
    finally {}
  }
  
  private void E()
  {
    try
    {
      TextUtils.isEmpty(A());
      D();
      SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(true));
      ArrayList localArrayList = this.P;
      boolean bool = false;
      if ((localArrayList != null) && (this.P.size() > 0))
      {
        if (this.q != null)
        {
          this.q.setText(Formatter.a(this.Q));
          this.q.setVisibility(0);
        }
      }
      else if (this.q != null)
      {
        this.q.setText("");
        this.q.setVisibility(8);
      }
      if ((this.h != null) && (this.h.getVisibility() != 0))
      {
        this.h.setVisibility(0);
        this.L = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        this.L.setDuration(200L);
        this.L.setAnimationListener(this);
        this.L.setInterpolator(new AccelerateDecelerateInterpolator());
        this.V.startAnimation(this.L);
      }
      if (this.z.getCount() == 0) {
        bool = true;
      }
      b(bool);
      return;
    }
    finally {}
  }
  
  private void F()
  {
    if ((this.h != null) && (!this.M))
    {
      this.K = AnimationUtils.loadAnimation(this.a, 2130772062);
      this.K.setAnimationListener(this);
      this.V.startAnimation(this.K);
      SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(false));
    }
    this.N = false;
  }
  
  private CertifiedAccountMeta.StComment a(CertifiedAccountMeta.StComment paramStComment)
  {
    return new CertifiedAccountMeta.StComment();
  }
  
  private CertifiedAccountMeta.StReply a(CertifiedAccountMeta.StComment paramStComment, String paramString)
  {
    if ((paramStComment != null) && (paramStComment.vecReply.get() != null) && (paramStComment.vecReply.get().size() > 0))
    {
      paramStComment = paramStComment.vecReply.get().iterator();
      while (paramStComment.hasNext())
      {
        CertifiedAccountMeta.StReply localStReply = (CertifiedAccountMeta.StReply)paramStComment.next();
        if (localStReply.id.get().equals(paramString)) {
          return localStReply;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = this.g.getChildAt(paramInt);
    if ((localObject instanceof CommentView))
    {
      localObject = (CommentView)localObject;
      paramString = ((CommentView)localObject).a(paramString);
      localObject = ((CommentView)localObject).getReplyContainer();
      if ((paramString != null) && (localObject != null))
      {
        int i1 = ((LinearLayout)localObject).getTop();
        int i2 = paramString.getTop();
        paramString = j;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollToReplyView getTop containerTop:");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("replyViewTop:");
        ((StringBuilder)localObject).append(i2);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
        this.g.setSelectionFromTop(paramInt, -(i1 + i2));
      }
    }
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 0L)
    {
      QQToast.makeText(e(), 2, paramString1, 0).show();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.a))
    {
      QQToast.makeText(e(), 1, e().getResources().getString(2131892113), 0).show();
      return;
    }
    QQToast.makeText(e(), 1, paramString2, 0).show();
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a != null) && (BaseApplicationImpl.getContext() != null))
    {
      if (this.s == null) {
        this.s = new SubscribeCommentInputPopupWindow((Activity)this.a);
      }
      Object localObject2;
      Object localObject1;
      if (paramStReply != null)
      {
        if (paramStReply.postUser != null)
        {
          localObject2 = String.format(this.a.getString(2131889232), new Object[] { paramStReply.postUser.nick.get() });
          localObject1 = localObject2;
          if (((String)localObject2).length() > 10)
          {
            localObject1 = ((String)localObject2).substring(0, 10);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("...");
            localObject1 = ((StringBuilder)localObject2).toString();
          }
          this.s.b((String)localObject1);
        }
      }
      else if ((paramStComment != null) && (paramStComment.postUser != null))
      {
        localObject2 = String.format(this.a.getString(2131889232), new Object[] { paramStComment.postUser.nick.get() });
        localObject1 = localObject2;
        if (((String)localObject2).length() > 10)
        {
          localObject1 = ((String)localObject2).substring(0, 10);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("...");
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        this.s.b((String)localObject1);
      }
      else
      {
        this.s.b(this.a.getString(2131889227));
      }
      this.s.a(new CommentPresenter.6(this, paramStComment, paramStReply));
      c(paramStComment, paramStReply);
      this.s.a(paramBoolean2);
      return;
    }
    QLog.e(j, 1, "plugin environment exception ! ");
  }
  
  private void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStFeed != null)
    {
      if (paramStComment == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramStReply == null)
      {
        paramStReply = paramStComment.postUser.id.get();
        localStringBuilder.append("uin:");
        localStringBuilder.append(paramStFeed.poster.id.get());
        localStringBuilder.append("|evil_uin:");
        localStringBuilder.append(paramStReply);
        localStringBuilder.append("|feed_id:");
        localStringBuilder.append(paramStFeed.id.get());
        localStringBuilder.append("|comment_id:");
        localStringBuilder.append(paramStComment.id.get());
        paramStFeed = paramStComment.content.get();
        paramStComment = paramStReply;
      }
      else
      {
        String str = paramStReply.postUser.id.get();
        localStringBuilder.append("uin:");
        localStringBuilder.append(paramStFeed.poster.id.get());
        localStringBuilder.append("|evil_uin:");
        localStringBuilder.append(str);
        localStringBuilder.append("|feed_id:");
        localStringBuilder.append(paramStFeed.id.get());
        localStringBuilder.append("|comment_id:");
        localStringBuilder.append(paramStComment.id.get());
        localStringBuilder.append("|reply_id:");
        localStringBuilder.append(paramStReply.id.get());
        paramStFeed = paramStReply.content.get();
        paramStComment = str;
      }
      paramStReply = new EvilReportUtil.EvilReportParams();
      paramStReply.a = "android";
      paramStReply.b = AppSetting.h();
      paramStReply.c = "1";
      paramStReply.d = paramStComment;
      paramStReply.e = "KQQ";
      paramStReply.f = "2400002";
      paramStReply.g = "qzone_authentication_comment";
      paramStReply.h = "24000";
      paramStReply.i = "0";
      paramStReply.k = localStringBuilder.toString();
      paramStReply.l = paramStFeed;
      EvilReportUtil.a(this.a, paramStReply);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = j;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadFeedDisplay() isRefresh => ");
    ((StringBuilder)localObject2).append(paramBoolean);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i1 = 1;
    QLog.d((String)localObject1, 1, (String)localObject2);
    if (paramBoolean) {
      C();
    }
    if (this.h.getVisibility() == 0) {
      i1 = 0;
    }
    d(0);
    if (i1 != 0) {
      q();
    }
    localObject1 = this.s;
    if (localObject1 != null)
    {
      localObject2 = this.p;
      if (localObject2 != null) {
        ((TextView)localObject2).setText(((SubscribeCommentInputPopupWindow)localObject1).d());
      }
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    Object localObject2 = (Long)paramArrayOfObject[1];
    Object localObject1;
    if ((String)paramArrayOfObject[2] == null) {
      localObject1 = "";
    } else {
      localObject1 = (String)paramArrayOfObject[2];
    }
    int i1 = ((Integer)paramArrayOfObject[0]).intValue();
    if (i1 != 9)
    {
      Object localObject3;
      Object localObject4;
      switch (i1)
      {
      default: 
        return;
      case 6: 
        if (a(5, paramArrayOfObject)) {
          return;
        }
        a(((Long)localObject2).longValue(), HardCodeUtil.a(2131900385), HardCodeUtil.a(2131900392));
        if ((!(paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp)) || (!(paramArrayOfObject[4] instanceof CertifiedAccountMeta.StComment))) {
          break;
        }
        localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply.id.get();
        paramArrayOfObject = ((CertifiedAccountMeta.StComment)paramArrayOfObject[4]).id.get();
        if ((((Long)localObject2).longValue() != 0L) || (this.z == null) || (TextUtils.isEmpty(paramArrayOfObject)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break;
        }
        this.z.a(paramArrayOfObject, (String)localObject1);
        x();
        return;
      case 5: 
        if (a(4, paramArrayOfObject)) {
          return;
        }
        if ((((Long)localObject2).longValue() == 0L) && ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp)))
        {
          paramArrayOfObject = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment.id.get();
          localObject1 = this.z;
          if ((localObject1 != null) && (((NewCommentAdapter)localObject1).a(paramArrayOfObject))) {
            x();
          }
          c(-1);
        }
        a(((Long)localObject2).longValue(), HardCodeUtil.a(2131900380), HardCodeUtil.a(2131900389));
        return;
      case 4: 
        if (a(6, paramArrayOfObject)) {
          return;
        }
        localObject3 = this.s;
        if (localObject3 != null) {
          ((SubscribeCommentInputPopupWindow)localObject3).b(this.p);
        }
        if (((Long)localObject2).longValue() != 0L)
        {
          localObject3 = j;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("reply fail ret=");
          ((StringBuilder)localObject4).append(localObject2);
          ((StringBuilder)localObject4).append(" msg=");
          ((StringBuilder)localObject4).append((String)localObject1);
          QLog.e((String)localObject3, 1, ((StringBuilder)localObject4).toString());
        }
        if ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp))
        {
          localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply;
          localObject3 = (CertifiedAccountMeta.StComment)paramArrayOfObject[4];
          paramArrayOfObject = (String)paramArrayOfObject[5];
          if (((Long)localObject2).longValue() != 0L)
          {
            localObject4 = this.z;
            if ((localObject4 != null) && (((NewCommentAdapter)localObject4).a(((CertifiedAccountMeta.StComment)localObject3).id.get(), paramArrayOfObject))) {
              x();
            }
          }
          if (((Long)localObject2).longValue() == 0L)
          {
            localObject4 = this.z;
            if ((localObject4 != null) && (((NewCommentAdapter)localObject4).a(((CertifiedAccountMeta.StComment)localObject3).id.get(), paramArrayOfObject, (CertifiedAccountMeta.StReply)localObject1))) {
              x();
            }
          }
        }
        a(((Long)localObject2).longValue(), HardCodeUtil.a(2131900379), HardCodeUtil.a(2131900390));
        return;
      case 3: 
        localObject3 = this.s;
        if (localObject3 != null) {
          ((SubscribeCommentInputPopupWindow)localObject3).b(this.p);
        }
        if (a(5, paramArrayOfObject)) {
          return;
        }
        if (((Long)localObject2).longValue() != 0L)
        {
          localObject3 = j;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("comment fail ret=");
          ((StringBuilder)localObject4).append(localObject2);
          ((StringBuilder)localObject4).append(" msg=");
          ((StringBuilder)localObject4).append((String)localObject1);
          QLog.e((String)localObject3, 1, ((StringBuilder)localObject4).toString());
        }
        if ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp))
        {
          localObject3 = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment;
          if (((Long)localObject2).longValue() != 0L)
          {
            localObject4 = this.z;
            if ((localObject4 != null) && (((NewCommentAdapter)localObject4).a(String.valueOf(paramArrayOfObject[4])))) {
              x();
            }
          }
          if (((Long)localObject2).longValue() == 0L)
          {
            localObject4 = this.z;
            if ((localObject4 != null) && (((NewCommentAdapter)localObject4).a(String.valueOf(paramArrayOfObject[4]), (CertifiedAccountMeta.StComment)localObject3))) {
              x();
            }
            c(1);
          }
        }
        a(((Long)localObject2).longValue(), HardCodeUtil.a(2131900386), (String)localObject1);
        v().a().postDelayed(new CommentPresenter.14(this), 1000L);
        return;
      case 2: 
        this.H = false;
        if (paramArrayOfObject[3] != null)
        {
          localObject3 = (CertifiedAccountRead.StGetFeedDetailRsp)paramArrayOfObject[3];
          if (a(4, paramArrayOfObject)) {
            return;
          }
          c((CertifiedAccountMeta.StFeed)((CertifiedAccountRead.StGetFeedDetailRsp)localObject3).feed.get());
          localObject4 = this.U;
          if (localObject4 != null) {
            ((CommentPresenter.GetFeedResponseListener)localObject4).a((CertifiedAccountRead.StGetFeedDetailRsp)localObject3, VSNetworkHelper.isProtocolCache((String)localObject1), ((Long)localObject2).longValue(), (String)localObject1);
          }
          if ((paramArrayOfObject.length >= 6) && (paramArrayOfObject[5] != null))
          {
            localObject1 = (COMM.StCommonExt)paramArrayOfObject[5];
            paramArrayOfObject = v().c(A());
            if (((COMM.StCommonExt)localObject1).mapInfo.size() > 0)
            {
              localObject1 = ((COMM.Entry)((COMM.StCommonExt)localObject1).mapInfo.get(0)).value.get();
              if ((paramArrayOfObject != null) && (paramArrayOfObject.size() > 0) && (((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0)).id.get().equals(localObject1)))
              {
                localObject1 = this.Y;
                if ((localObject1 != null) && (!TextUtils.isEmpty(((ExtraTypeInfo)localObject1).getReplyId())))
                {
                  localObject1 = a((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), this.Y.getReplyId());
                  if (localObject1 != null)
                  {
                    q();
                    SimpleEventBus.getInstance().dispatchEvent(new CommentReplyEvent((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), (CertifiedAccountMeta.StReply)localObject1));
                    this.Z = true;
                    this.aa = true;
                  }
                  else
                  {
                    a(new CommentPresenter.11(this));
                  }
                }
                else
                {
                  q();
                  SimpleEventBus.getInstance().dispatchEvent(new CommentReplyEvent((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), null));
                }
              }
              else
              {
                a(new CommentPresenter.12(this));
              }
            }
          }
          if (this.N) {
            a(new CommentPresenter.13(this));
          }
        }
        else
        {
          QLog.w(j, 1, "get feed detail response failed");
          paramArrayOfObject = this.U;
          if (paramArrayOfObject != null) {
            paramArrayOfObject.a(null, VSNetworkHelper.isProtocolCache((String)localObject1), ((Long)localObject2).longValue(), (String)localObject1);
          }
          if (!this.R) {
            QQToast.makeText(e(), (CharSequence)localObject1, 0).show();
          }
        }
        if (!this.R) {
          break;
        }
        this.R = false;
        return;
      case 1: 
        w();
        return;
      }
    }
    else
    {
      if (a(4, paramArrayOfObject)) {
        return;
      }
      if ((paramArrayOfObject[3] instanceof CertifiedAccountRead.StGetCommentListRsp))
      {
        if (this.z != null)
        {
          localObject2 = ((CertifiedAccountRead.StGetCommentListRsp)paramArrayOfObject[3]).vecComment.get();
          localObject1 = localObject2;
          if (paramArrayOfObject.length >= 6)
          {
            localObject1 = localObject2;
            if (paramArrayOfObject[5] != null)
            {
              localObject1 = localObject2;
              if ((paramArrayOfObject[5] instanceof String)) {
                localObject1 = this.i.a((List)localObject2, (String)paramArrayOfObject[5]);
              }
            }
          }
          this.z.a((Collection)localObject1);
        }
        x();
      }
    }
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return this.W != ((Integer)paramArrayOfObject[paramInt]).intValue();
  }
  
  private boolean a(CertifiedAccountMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (SubscribeGlobalInfo.a() != null) && (paramStUser.id.get().equals(SubscribeGlobalInfo.a().id.get()))) {
      return true;
    }
    return (paramStUser != null) && (paramStUser.id.get().equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
  }
  
  private void b(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    QLog.e(j, 1, "popupComment");
    a(paramStComment, paramStReply, true, false);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131438908);
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ((TextView)localObject).setText(2131891215);
          return;
        }
        ((TextView)localObject).setText("");
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (this.Q == 0) {
      this.Q = v().b(A());
    }
    this.Q += paramInt;
    a(new CommentPresenter.2(this));
    StoryDispatcher.a().dispatch(new CommentEvent(5, new Object[] { A(), Integer.valueOf(this.Q) }));
  }
  
  private void c(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    SubscribeCommentInputPopupWindow localSubscribeCommentInputPopupWindow = this.s;
    if (localSubscribeCommentInputPopupWindow == null)
    {
      QLog.e(j, 1, "mCommentInputPopupWindow == null");
      return;
    }
    localSubscribeCommentInputPopupWindow.setOnShowListener(new CommentPresenter.7(this, paramStComment, paramStReply));
    this.s.a(new CommentPresenter.8(this, paramStComment, paramStReply));
  }
  
  private void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.X = paramStFeed.poster.id.get();
    }
    this.O.put(Integer.valueOf(i()), paramStFeed);
  }
  
  private CertifiedAccountMeta.StReply d(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStComment == null) {
      return null;
    }
    return new CertifiedAccountMeta.StReply();
  }
  
  private void d(int paramInt)
  {
    if (this.h == null)
    {
      QLog.d(j, 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0) {
      this.z.b(z().poster.id.get());
    }
    this.h.setVisibility(paramInt);
  }
  
  private void u()
  {
    this.Z = false;
    this.aa = true;
  }
  
  private CommentBusiness v()
  {
    if (this.i == null)
    {
      this.i = new CommentBusiness();
      this.W = this.i.hashCode();
    }
    return this.i;
  }
  
  private void w()
  {
    if (A() != null)
    {
      this.R = true;
      ExtraTypeInfo localExtraTypeInfo = this.Y;
      if ((localExtraTypeInfo != null) && (!TextUtils.isEmpty(localExtraTypeInfo.getCommentId())))
      {
        v().a(z(), false, this.Y.getCommentId());
        return;
      }
      v().a(z(), false, "");
    }
  }
  
  private void x()
  {
    a(new CommentPresenter.1(this));
  }
  
  private void y()
  {
    this.g = ((ListView)b(2131432885));
    this.h = b(2131431066);
    this.V = b(2131432886);
    this.q = ((TextView)b(2131431095));
    this.o = b(2131431078);
    this.p = ((TextView)b(2131447156));
    this.p.setOnClickListener(this);
    this.r = b(2131429880);
    this.r.setOnClickListener(this);
    this.g.setOnScrollListener(this.ab);
    this.g.addOnLayoutChangeListener(this.ac);
    this.n = new CommentPresenter.OnFeedCommentElementClickListener(this);
    this.z = new NewCommentAdapter(this.a, this.n);
    this.z.b(this.X);
    this.g.setAdapter(this.z);
    this.g.setEmptyView(this.o);
    View localView = this.h;
    if (localView != null) {
      localView.setOnClickListener(new CommentPresenter.3(this));
    }
  }
  
  private CertifiedAccountMeta.StFeed z()
  {
    int i1 = i();
    return (CertifiedAccountMeta.StFeed)this.O.get(Integer.valueOf(i1));
  }
  
  public void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      a((ViewStub)localObject);
      this.m = null;
    }
    if (A() == null)
    {
      int i1 = this.ad;
      if (i1 <= 3)
      {
        this.ad = (i1 + 1);
        v().a().postDelayed(new CommentPresenter.10(this, paramStComment, paramStReply), this.ad * 500);
        return;
      }
    }
    localObject = A();
    if ((!StringUtil.isEmpty((String)localObject)) && (z() != null) && (z().vecComment.size() == 0) && (z().commentCount.get() != 0))
    {
      this.P = v().c((String)localObject);
      if ((this.P != null) && (!this.H)) {
        D();
      } else {
        v().a(z(), false);
      }
    }
    a(paramStComment, paramStReply, true, false);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    c(paramStFeed);
    w();
  }
  
  public void a(CommentPresenter.CommentWindowListener paramCommentWindowListener)
  {
    this.S = paramCommentWindowListener;
  }
  
  public void a(OnCommentInputShowListener paramOnCommentInputShowListener)
  {
    this.T = paramOnCommentInputShowListener;
  }
  
  protected void b() {}
  
  public void b(View paramView)
  {
    a(null, null, true, false);
  }
  
  public void b(ViewStub paramViewStub)
  {
    this.m = paramViewStub;
  }
  
  public boolean b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.id.get()));
  }
  
  public void c(View paramView)
  {
    a(null, null, true, true);
  }
  
  protected void d() {}
  
  protected void g()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.k);
    v().b();
    this.i = null;
    ArrayList localArrayList = this.P;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.O.clear();
  }
  
  public int i()
  {
    return 0;
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  protected void j()
  {
    y();
  }
  
  protected int k()
  {
    return 2131624394;
  }
  
  protected View l()
  {
    return null;
  }
  
  public boolean n()
  {
    View localView = this.h;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      F();
      return true;
    }
    return false;
  }
  
  public boolean o()
  {
    View localView = this.h;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.K)
    {
      paramAnimation = this.h;
      if (paramAnimation != null) {
        paramAnimation.setVisibility(8);
      }
      paramAnimation = this.l;
      if ((paramAnimation != null) && ((paramAnimation instanceof BaseActivity)) && (((BaseActivity)paramAnimation).mSystemBarComp != null)) {
        ((BaseActivity)this.l).mSystemBarComp.setStatusBarMask(null);
      }
      this.M = false;
      paramAnimation = this.S;
      if (paramAnimation != null) {
        paramAnimation.p();
      }
    }
    else
    {
      paramAnimation = this.L;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.K)
    {
      this.M = true;
      QLog.d(j, 2, "mHideCommentListAnimation onAnimationStarttrue");
      return;
    }
    if (paramAnimation == this.L)
    {
      paramAnimation = this.S;
      if (paramAnimation != null) {
        paramAnimation.o();
      }
      QLog.d(j, 2, "mShowCommentListAnimation onAnimationStarttrue");
      paramAnimation = this.l;
      if (((paramAnimation instanceof BaseActivity)) && (((BaseActivity)paramAnimation).mSystemBarComp != null))
      {
        paramAnimation = f();
        if (paramAnimation != null) {
          ((BaseActivity)this.l).mSystemBarComp.setStatusBarMask(new PorterDuffColorFilter(paramAnimation.getColor(2131168244), PorterDuff.Mode.SRC_ATOP));
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.getId();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429880)
    {
      if (i1 == 2131447156) {
        b(paramView);
      }
    }
    else {
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean p()
  {
    SubscribeCommentInputPopupWindow localSubscribeCommentInputPopupWindow = this.s;
    return (localSubscribeCommentInputPopupWindow != null) && (localSubscribeCommentInputPopupWindow.isShowing());
  }
  
  public void q()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      a((ViewStub)localObject);
      this.m = null;
    }
    if (A() == null)
    {
      int i1 = this.ad;
      if (i1 <= 3)
      {
        this.ad = (i1 + 1);
        v().a().postDelayed(new CommentPresenter.9(this), this.ad * 500);
        return;
      }
    }
    localObject = z();
    String str = A();
    if (str != null)
    {
      this.P = v().c(str);
      if (this.H)
      {
        this.N = true;
        v().a((CertifiedAccountMeta.StFeed)localObject, false);
        return;
      }
      if (this.P == null)
      {
        this.N = true;
        v().a((CertifiedAccountMeta.StFeed)localObject, false);
        return;
      }
      E();
    }
  }
  
  public void r()
  {
    Object localObject = this.h;
    int i1;
    if ((localObject != null) && (((View)localObject).getVisibility() != 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      localObject = this.z;
      if (localObject != null) {
        ((NewCommentAdapter)localObject).b(z().poster.id.get());
      }
      q();
    }
  }
  
  public void s()
  {
    View localView = this.h;
    int i1;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter
 * JD-Core Version:    0.7.0.1
 */