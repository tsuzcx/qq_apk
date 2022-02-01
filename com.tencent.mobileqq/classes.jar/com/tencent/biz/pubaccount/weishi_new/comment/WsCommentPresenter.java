package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentSuccessEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalDialogListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide.WSCommentAtHelper;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.subscribe.SubscribeGlobalInfo;
import com.tencent.biz.subscribe.comment.Formatter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class WsCommentPresenter
  implements View.OnClickListener, IEventReceiver
{
  private String A;
  private int B;
  private int C = -1;
  private int D = 0;
  private long E;
  private long F;
  private boolean G = false;
  private boolean H = false;
  private boolean I;
  private boolean J = false;
  private AbsListView.OnScrollListener K = new WsCommentPresenter.5(this);
  WSOnGetReportInfo a = new WsCommentPresenter.1(this);
  private BaseFragment b;
  private Activity c;
  private Context d;
  private WSCommentEventReceiver e;
  private WsCommentBusiness f;
  private WSVerticalDialogListener g;
  private stSimpleMetaReply h;
  private ArrayList<stSimpleMetaComment> i;
  private HashMap<Integer, stSimpleMetaFeed> j = new HashMap();
  private WSCommentPopupWindow k;
  private WsCommentInputPopupWindow l;
  private ListView m;
  private View n;
  private FrameLayout o;
  private WsCommentAdapter p;
  private TextView q;
  private TextView r;
  private TextView s;
  private View t;
  private View u;
  private String v = "";
  private String w = "";
  private String x = "";
  private String y;
  private String z;
  
  public WsCommentPresenter(BaseFragment paramBaseFragment, int paramInt)
  {
    this.b = paramBaseFragment;
    this.c = paramBaseFragment.getActivity();
    this.d = paramBaseFragment.getActivity().getApplicationContext();
    this.f = new WsCommentBusiness(this);
    if (this.e == null)
    {
      this.e = new WSCommentEventReceiver(this);
      StoryDispatcher.a().registerSubscriber(this.e);
      paramBaseFragment = new StringBuilder();
      paramBaseFragment.append("注册一次评论监听器 , currentPage:");
      paramBaseFragment.append(paramInt);
      WSLog.d("comment", paramBaseFragment.toString());
      return;
    }
    paramBaseFragment = new StringBuilder();
    paramBaseFragment.append("复用评论监听器 , currentPage:");
    paramBaseFragment.append(paramInt);
    WSLog.d("comment", paramBaseFragment.toString());
  }
  
  private void A()
  {
    String str = WSCommentBeaconReport.c(this.x);
    Object localObject = str;
    if (!str.equals("comment_page"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(m());
      localObject = ((StringBuilder)localObject).toString();
    }
    WSCommentBeaconReport.a(this.x, b(), (String)localObject, n(), p());
  }
  
  private void B()
  {
    if (this.J)
    {
      this.J = false;
      WSLog.d("comment", "请求结束 preLoading = false");
    }
  }
  
  private void C()
  {
    Activity localActivity = this.c;
    if (localActivity != null) {
      localActivity.runOnUiThread(new WsCommentPresenter.12(this));
    }
  }
  
  private WSCommentSuccessEvent a(@NonNull stPostCommentReplyV2Rsp paramstPostCommentReplyV2Rsp)
  {
    String str;
    if (paramstPostCommentReplyV2Rsp.reply != null) {
      str = paramstPostCommentReplyV2Rsp.reply.id;
    } else {
      str = "";
    }
    int i1 = paramstPostCommentReplyV2Rsp.sendArk;
    boolean bool2 = false;
    boolean bool1;
    if (i1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramstPostCommentReplyV2Rsp.arkPopWindow == 1) {
      bool2 = true;
    }
    return new WSCommentSuccessEvent(bool1, bool2, "", str);
  }
  
  private WSCommentSuccessEvent a(@NonNull stPostFeedCommentV2Rsp paramstPostFeedCommentV2Rsp)
  {
    String str;
    if (paramstPostFeedCommentV2Rsp.comment != null) {
      str = paramstPostFeedCommentV2Rsp.comment.id;
    } else {
      str = "";
    }
    int i1 = paramstPostFeedCommentV2Rsp.sendArk;
    boolean bool2 = false;
    boolean bool1;
    if (i1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramstPostFeedCommentV2Rsp.arkPopWindow == 1) {
      bool2 = true;
    }
    return new WSCommentSuccessEvent(bool1, bool2, str, "");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    WSCommentBeaconReport.a(a(), b(), l(), paramInt1, paramInt2, n(), p());
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 1000L)
    {
      QQToast.makeText(this.d, 2, paramString1, 0).show();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.d))
    {
      paramString1 = this.d;
      QQToast.makeText(paramString1, 1, paramString1.getResources().getString(2131892113), 0).show();
      return;
    }
    QQToast.makeText(this.d, 1, paramString2, 0).show();
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if ((paramstSimpleMetaReply != null) && (paramstSimpleMetaReply.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.d.getString(2131889232), new Object[] { paramstSimpleMetaReply.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaReply = new StringBuilder();
        paramstSimpleMetaReply.append(paramstSimpleMetaComment);
        paramstSimpleMetaReply.append("...");
        paramstSimpleMetaComment = paramstSimpleMetaReply.toString();
      }
      this.l.a(paramstSimpleMetaComment);
      return;
    }
    if ((paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.d.getString(2131889232), new Object[] { paramstSimpleMetaComment.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaReply = new StringBuilder();
        paramstSimpleMetaReply.append(paramstSimpleMetaComment);
        paramstSimpleMetaReply.append("...");
        paramstSimpleMetaComment = paramstSimpleMetaReply.toString();
      }
      this.l.a(paramstSimpleMetaComment);
      return;
    }
    paramstSimpleMetaComment = WSGlobalConfig.a().p();
    this.l.a(paramstSimpleMetaComment);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.d != null) && (BaseApplicationImpl.getContext() != null))
    {
      if (this.l == null) {
        this.l = new WsCommentInputPopupWindow(this.c, this.a);
      }
      this.l.a(new WsCommentPresenter.8(this, paramstSimpleMetaComment, paramBoolean1, paramstSimpleMetaReply));
      a(paramstSimpleMetaComment, paramstSimpleMetaReply, paramBoolean1);
      this.l.a(paramInt);
      if (paramBoolean2)
      {
        this.l.b();
        return;
      }
      a(paramstSimpleMetaComment, paramstSimpleMetaReply);
      return;
    }
    WSLog.d("comment", 1, "plugin environment exception ! ");
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, boolean paramBoolean)
  {
    WsCommentInputPopupWindow localWsCommentInputPopupWindow = this.l;
    if (localWsCommentInputPopupWindow == null)
    {
      WSLog.d("comment", "mCommentInputPopupWindow == null");
      return;
    }
    localWsCommentInputPopupWindow.a(new WsCommentPresenter.9(this, paramstSimpleMetaComment, paramstSimpleMetaReply, paramBoolean));
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean, stSimpleMetaReply paramstSimpleMetaReply)
  {
    boolean bool = true;
    WSLog.b("comment", 1, "onCommentSend()");
    Object localObject = this.l;
    if (localObject == null)
    {
      WSLog.b("comment", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    localObject = ((WsCommentInputPopupWindow)localObject).d();
    if (TextUtils.isEmpty(((String)localObject).trim()))
    {
      paramstSimpleMetaComment = this.d;
      QQToast.makeText(paramstSimpleMetaComment, paramstSimpleMetaComment.getString(2131889233), 0).show();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.d))
    {
      paramstSimpleMetaComment = this.d;
      QQToast.makeText(paramstSimpleMetaComment, 1, paramstSimpleMetaComment.getString(2131892113), 0).show();
      return;
    }
    if (n() == null)
    {
      WSLog.d("comment", 1, "feed is null");
      return;
    }
    if (paramstSimpleMetaComment != null) {
      bool = false;
    }
    ArrayList localArrayList = this.l.e();
    WSCommentBeaconReport.a(a(), b(), m(), n(), paramBoolean, bool, a(paramstSimpleMetaComment, localArrayList));
    if (bool) {
      a((String)localObject, localArrayList);
    } else {
      a((String)localObject, paramstSimpleMetaReply, paramstSimpleMetaComment, localArrayList);
    }
    this.l.b("");
    this.l.dismiss();
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView)
  {
    if (WSCommentAtHelper.a.b())
    {
      paramKandianUrlImageView.setVisibility(0);
      String str = WSCommentAtHelper.a.c();
      WSPicLoader.a().a(paramKandianUrlImageView, str, WSFeedUtils.f(2130853504));
      return;
    }
    paramKandianUrlImageView.setVisibility(8);
  }
  
  private void a(String paramString, stSimpleMetaReply paramstSimpleMetaReply, stSimpleMetaComment paramstSimpleMetaComment, ArrayList<String> paramArrayList)
  {
    if (this.h == null) {
      this.h = new stSimpleMetaReply();
    }
    this.h.wording = paramString;
    stSimpleMetaReply localstSimpleMetaReply = new stSimpleMetaReply();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeId_");
    localStringBuilder.append(System.currentTimeMillis());
    localstSimpleMetaReply.id = localStringBuilder.toString();
    localstSimpleMetaReply.wording = paramString;
    localstSimpleMetaReply.createtime = ((int)(System.currentTimeMillis() / 1000L));
    localstSimpleMetaReply.poster = z();
    if (paramstSimpleMetaReply != null)
    {
      localstSimpleMetaReply.receiver = paramstSimpleMetaReply.poster;
      localstSimpleMetaReply.beReplyReplyId = paramstSimpleMetaReply.id;
    }
    else
    {
      localstSimpleMetaReply.receiver = paramstSimpleMetaComment.poster;
    }
    paramString = new StringBuilder();
    paramString.append("回复请求前,发送者:");
    paramString.append(localstSimpleMetaReply.poster.nick);
    paramString.append(",接受者:");
    paramString.append(localstSimpleMetaReply.receiver.nick);
    WSLog.d("comment", paramString.toString());
    this.F = h().a(n(), paramstSimpleMetaComment, localstSimpleMetaReply, paramArrayList);
    this.G = true;
    paramString = new StringBuilder();
    paramString.append("1 mCommentListChanged:");
    paramString.append(this.G);
    paramString.append(", hashCode");
    paramString.append(hashCode());
    WSLog.d("comment", paramString.toString());
    this.I = true;
    this.h = null;
    paramString = this.p;
    if (paramString != null)
    {
      paramString.a(paramstSimpleMetaComment.id, localstSimpleMetaReply);
      this.p.notifyDataSetChanged();
    }
  }
  
  private void a(String paramString, ArrayList<String> paramArrayList)
  {
    stSimpleMetaComment localstSimpleMetaComment = new stSimpleMetaComment();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeId_");
    localStringBuilder.append(System.currentTimeMillis());
    localstSimpleMetaComment.id = localStringBuilder.toString();
    localstSimpleMetaComment.wording = paramString;
    localstSimpleMetaComment.createtime = ((int)(System.currentTimeMillis() / 1000L));
    localstSimpleMetaComment.poster = z();
    localstSimpleMetaComment.replyList = new ArrayList();
    h().a(n(), localstSimpleMetaComment, paramArrayList);
    this.G = true;
    paramString = new StringBuilder();
    paramString.append("2 mCommentListChanged:");
    paramString.append(this.G);
    paramString.append(", hashCode");
    paramString.append(hashCode());
    WSLog.c("comment", paramString.toString());
    paramString = this.b;
    if ((paramString instanceof WSFollowFragment)) {
      ((WSFollowFragment)paramString).a(o(), n());
    }
    this.I = true;
    paramString = this.p;
    if (paramString != null)
    {
      paramString.a(0, localstSimpleMetaComment);
      this.p.notifyDataSetChanged();
    }
    paramString = new StringBuilder();
    paramString.append("onCommentSend, lastPosition:");
    paramString.append(this.C);
    paramString.append(",currentPosition:");
    paramString.append(o());
    WSLog.d("comment", paramString.toString());
    paramString = this.m;
    if (paramString != null) {
      paramString.setSelection(0);
    }
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    int i1 = paramArrayOfObject.length;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt < i1)
    {
      bool1 = bool2;
      if ((paramArrayOfObject[paramInt] instanceof Integer))
      {
        bool1 = bool2;
        if (h().hashCode() != ((Integer)paramArrayOfObject[paramInt]).intValue()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private int b(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    int i3 = 0;
    int i2 = 0;
    int i1 = i3;
    if (paramstSimpleMetaReply != null)
    {
      ArrayList localArrayList = this.i;
      if (localArrayList == null) {
        return 0;
      }
      i1 = localArrayList.indexOf(paramstSimpleMetaComment);
      int i4 = paramstSimpleMetaComment.replyList.indexOf(paramstSimpleMetaReply);
      paramstSimpleMetaComment = new StringBuilder();
      paramstSimpleMetaComment.append("indexOfReply:");
      paramstSimpleMetaComment.append(i4);
      WSLog.a("commentnel-log", paramstSimpleMetaComment.toString());
      int i5 = this.m.getFirstVisiblePosition();
      paramstSimpleMetaComment = this.m.getChildAt(i1 - i5);
      paramstSimpleMetaReply = new StringBuilder();
      paramstSimpleMetaReply.append("commentChild:");
      paramstSimpleMetaReply.append(paramstSimpleMetaComment);
      WSLog.a("commentnel-log", paramstSimpleMetaReply.toString());
      i1 = i3;
      if ((paramstSimpleMetaComment instanceof WsCommentView))
      {
        paramstSimpleMetaComment = (WsCommentView)paramstSimpleMetaComment;
        if (paramstSimpleMetaComment.a == null) {
          return 0;
        }
        i3 = paramstSimpleMetaComment.a.getHeight();
        paramstSimpleMetaComment = paramstSimpleMetaComment.e.getChildAt(i4);
        paramstSimpleMetaReply = new StringBuilder();
        paramstSimpleMetaReply.append("replyChild:");
        paramstSimpleMetaReply.append(paramstSimpleMetaComment);
        WSLog.a("commentnel-log", paramstSimpleMetaReply.toString());
        i1 = i2;
        if (paramstSimpleMetaComment != null) {
          i1 = paramstSimpleMetaComment.getTop() + i3;
        }
        paramstSimpleMetaComment = new StringBuilder();
        paramstSimpleMetaComment.append("offset:");
        paramstSimpleMetaComment.append(i1);
        WSLog.a("commentnel-log", paramstSimpleMetaComment.toString());
      }
    }
    return i1;
  }
  
  @NotNull
  private Runnable b(int paramInt1, int paramInt2)
  {
    return new WsCommentPresenter.7(this, paramInt2, paramInt1);
  }
  
  private void b(int paramInt)
  {
    if (this.E == 0L) {
      this.E = h().b(g());
    }
    this.E += paramInt;
    Activity localActivity = this.c;
    if (localActivity != null) {
      localActivity.runOnUiThread(new WsCommentPresenter.11(this));
    }
    StoryDispatcher.a().dispatch(new WSCommentEvent(5, new Object[] { g(), Long.valueOf(this.E) }));
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.u;
    if ((localView != null) && (!this.H))
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.q.setText(2131891215);
        return;
      }
      localView.setVisibility(8);
      this.q.setText("");
    }
  }
  
  private void c(String paramString)
  {
    TextView localTextView = this.r;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  private void t()
  {
    for (;;)
    {
      try
      {
        u();
        ArrayList localArrayList = this.i;
        bool = true;
        if ((localArrayList == null) || (this.i.size() <= 0)) {
          break label129;
        }
        i1 = 1;
        if (i1 != 0)
        {
          if (this.s != null)
          {
            this.s.setText(Formatter.a(this.E));
            this.s.setVisibility(0);
          }
        }
        else if (this.s != null)
        {
          this.s.setText("");
          this.s.setVisibility(8);
        }
      }
      finally {}
      b(bool);
      y();
      boolean bool = j();
      if (bool) {
        return;
      }
      A();
      return;
      label129:
      int i1 = 0;
      continue;
      if (i1 != 0) {
        bool = false;
      }
    }
  }
  
  private void u()
  {
    try
    {
      if (this.f == null)
      {
        WSLog.d("comment", "innerInitData return empty because WsCommentBusiness is null ");
        return;
      }
      this.i = h().c(g());
      this.w = h().a(g());
      Object localObject1 = this.i;
      if (localObject1 == null) {
        return;
      }
      if (this.p != null)
      {
        this.p.b();
        this.p.a(this.i);
        this.p.notifyDataSetChanged();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("innerInitData, lastPosition:");
      ((StringBuilder)localObject1).append(this.C);
      ((StringBuilder)localObject1).append(",currentPosition:");
      ((StringBuilder)localObject1).append(o());
      WSLog.d("comment", ((StringBuilder)localObject1).toString());
      if ((this.m != null) && (this.C != o()))
      {
        this.C = o();
        this.m.post(new WsCommentPresenter.4(this));
      }
      if ((this.i != null) && (this.i.size() > 0)) {
        this.E = h().b(g());
      }
      return;
    }
    finally {}
  }
  
  private void v()
  {
    this.m = ((ListView)this.t.findViewById(2131432885));
    this.n = new View(this.d);
    Object localObject = new ViewGroup.LayoutParams(100, ScreenUtil.dip2px(491.0F));
    this.n.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.o = new FrameLayout(this.d);
    this.o.addView(this.n);
    this.m.addFooterView(this.o);
    this.n.setVisibility(8);
    this.s = ((TextView)this.t.findViewById(2131431095));
    this.u = this.t.findViewById(2131431078);
    this.q = ((TextView)this.u.findViewById(2131438908));
    this.r = ((TextView)this.t.findViewById(2131447156));
    this.r.setOnClickListener(this);
    this.t.findViewById(2131429880).setOnClickListener(this);
    localObject = (KandianUrlImageView)this.t.findViewById(2131429804);
    ((KandianUrlImageView)localObject).setOnClickListener(this);
    a((KandianUrlImageView)localObject);
    this.m.setOnScrollListener(this.K);
    if (this.p == null)
    {
      WSLog.a("comment", "create mCommentAdapter ...");
      this.p = new WsCommentAdapter(this.d, new WsCommentPresenter.OnFeedCommentElementClickListener(this), this.a);
      this.p.a(n());
      this.p.a(a(), b());
    }
    else
    {
      WSLog.a("comment", "复用 mCommentAdapter ...");
    }
    this.p.b(this.v);
    this.p.a(n());
    this.m.setAdapter(this.p);
    localObject = new WsCommentPresenter.6(this);
    View localView = this.t;
    if (localView != null) {
      localView.setOnClickListener((View.OnClickListener)localObject);
    }
    w();
  }
  
  private void w()
  {
    String str = WSGlobalConfig.a().p();
    if (!TextUtils.isEmpty(str)) {
      this.r.setHint(str);
    }
  }
  
  private void x()
  {
    WSVerticalDialogListener localWSVerticalDialogListener = this.g;
    if (localWSVerticalDialogListener != null) {
      localWSVerticalDialogListener.b(1);
    }
  }
  
  private void y()
  {
    WSVerticalDialogListener localWSVerticalDialogListener = this.g;
    if (localWSVerticalDialogListener != null) {
      localWSVerticalDialogListener.a(1);
    }
  }
  
  private stSimpleMetaPerson z()
  {
    if (SubscribeGlobalInfo.a() != null)
    {
      localObject1 = SubscribeGlobalInfo.a();
      localObject2 = new stSimpleMetaPerson();
      ((stSimpleMetaPerson)localObject2).id = ((CertifiedAccountMeta.StUser)localObject1).id.get();
      ((stSimpleMetaPerson)localObject2).nick = ((CertifiedAccountMeta.StUser)localObject1).nick.get();
      ((stSimpleMetaPerson)localObject2).type = ((CertifiedAccountMeta.StUser)localObject1).type.get();
      return localObject2;
    }
    Object localObject1 = new stSimpleMetaPerson();
    ((stSimpleMetaPerson)localObject1).id = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {
      ((stSimpleMetaPerson)localObject1).nick = ContactUtils.f((QQAppInterface)localObject2, ((stSimpleMetaPerson)localObject1).id);
    } else {
      ((stSimpleMetaPerson)localObject1).nick = "";
    }
    ((stSimpleMetaPerson)localObject1).type = 0;
    return localObject1;
  }
  
  public String a()
  {
    return this.x;
  }
  
  public Map<String, String> a(stSimpleMetaComment paramstSimpleMetaComment, ArrayList<String> paramArrayList)
  {
    Map localMap = p();
    if (paramArrayList.isEmpty()) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    localMap.put("is_reply_at_friends", localObject);
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList.size() > 0)
    {
      ((StringBuilder)localObject).append((String)paramArrayList.get(0));
      localStringBuilder.append("2");
      int i1 = 1;
      while (i1 < paramArrayList.size())
      {
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append((String)paramArrayList.get(i1));
        localStringBuilder.append(",");
        localStringBuilder.append("2");
        i1 += 1;
      }
    }
    localMap.put("uid", ((StringBuilder)localObject).toString());
    localMap.put("uid_type", localStringBuilder.toString());
    if (paramstSimpleMetaComment == null) {
      paramstSimpleMetaComment = "";
    } else {
      paramstSimpleMetaComment = paramstSimpleMetaComment.id;
    }
    localMap.put("comment_id", paramstSimpleMetaComment);
    return localMap;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.D)
    {
      WsCommentAdapter localWsCommentAdapter = this.p;
      if (localWsCommentAdapter != null)
      {
        localWsCommentAdapter.b.clear();
        this.p.a.clear();
      }
    }
    this.D = paramInt;
    WsCommentAdapter.c = m();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Map<String, String> paramMap)
  {
    WSCommentBeaconReport.a(a(), paramString, "comment_page_explicit", 1000001, paramInt2, n(), paramMap);
    i();
    h().a().postDelayed(b(paramInt1, paramInt2), 200L);
  }
  
  public void a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = n();
    int i1 = 0;
    if (localstSimpleMetaFeed != null)
    {
      localstSimpleMetaFeed.total_comment_num += 1;
      i1 = localstSimpleMetaFeed.total_comment_num;
      localstSimpleMetaFeed.simpleComments.add(0, WSCommentUtil.a(paramstSimpleMetaComment, z()));
    }
    if (n() != null) {
      paramstSimpleMetaComment = n().id;
    } else {
      paramstSimpleMetaComment = "";
    }
    paramstSimpleMetaComment = new WSAddCommentEvent(paramstSimpleMetaComment, o(), i1);
    WSSimpleEventBus.a().a(paramstSimpleMetaComment);
  }
  
  void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt)
  {
    a(paramstSimpleMetaComment, paramstSimpleMetaReply, paramInt, false, false);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      this.v = paramstSimpleMetaFeed.poster.id;
      WsCommentAdapter localWsCommentAdapter = this.p;
      if (localWsCommentAdapter != null) {
        localWsCommentAdapter.a(paramstSimpleMetaFeed);
      }
    }
    this.j.put(Integer.valueOf(o()), paramstSimpleMetaFeed);
  }
  
  public void a(View paramView)
  {
    this.t = paramView;
    v();
  }
  
  public void a(WSVerticalDialogListener paramWSVerticalDialogListener)
  {
    this.g = paramWSVerticalDialogListener;
  }
  
  public void a(@Nullable String paramString)
  {
    this.z = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.x = paramString1;
    this.y = paramString2;
    WsCommentAdapter localWsCommentAdapter = this.p;
    if (localWsCommentAdapter != null) {
      localWsCommentAdapter.a(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    int i1 = ((Integer)paramArrayOfObject[0]).intValue();
    Integer localInteger = (Integer)paramArrayOfObject[1];
    Object localObject1;
    if (paramArrayOfObject[2] == null) {
      localObject1 = "";
    } else {
      localObject1 = (String)paramArrayOfObject[2];
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleResponseEvent, action: ");
    ((StringBuilder)localObject2).append(paramArrayOfObject[0]);
    ((StringBuilder)localObject2).append(",resultCode:");
    ((StringBuilder)localObject2).append(localInteger);
    ((StringBuilder)localObject2).append(",msg:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this);
    WSLog.c("comment", ((StringBuilder)localObject2).toString());
    Object localObject3;
    if (i1 != 3)
    {
      if (i1 != 4)
      {
        if (i1 != 5)
        {
          if (i1 != 6)
          {
            if (i1 != 9) {
              return;
            }
            WSLog.d("comment", "onEvent: ACTION_GET_MORE_COMMENT！");
            B();
            if (((paramArrayOfObject[6] instanceof String)) && (!((String)paramArrayOfObject[6]).equals(g())))
            {
              WSLog.d("comment", "不是当前feedId的数据，不响应！！！！！！！！！！！！！！！！");
              return;
            }
            if (a(4, paramArrayOfObject))
            {
              B();
              return;
            }
            boolean bool1;
            if ((paramArrayOfObject[5] instanceof Boolean))
            {
              boolean bool2 = ((Boolean)paramArrayOfObject[5]).booleanValue();
              bool1 = bool2;
              if (!bool2)
              {
                this.G = false;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("---------------------------------------- if(!loadMore) mCommentListChanged = false, hashCode");
                ((StringBuilder)localObject1).append(hashCode());
                WSLog.c("comment", ((StringBuilder)localObject1).toString());
                bool1 = bool2;
              }
            }
            else
            {
              bool1 = true;
            }
            if ((paramArrayOfObject[3] instanceof stGetFeedCommentListV2Rsp))
            {
              if (this.p != null)
              {
                paramArrayOfObject = ((stGetFeedCommentListV2Rsp)paramArrayOfObject[3]).comments;
                if (paramArrayOfObject.size() == 0)
                {
                  b(true);
                }
                else
                {
                  if (!bool1) {
                    this.p.b();
                  }
                  this.p.a(paramArrayOfObject);
                  C();
                  b(0);
                }
              }
              if ((this.H) && (!bool1))
              {
                paramArrayOfObject = this.b.getBaseActivity();
                if (paramArrayOfObject != null) {
                  paramArrayOfObject.runOnUiThread(new WsCommentPresenter.10(this));
                }
              }
            }
            else
            {
              WSLog.d("comment", "获取评论response失败");
            }
          }
          else
          {
            if (a(5, paramArrayOfObject))
            {
              WSLog.d("comment", 1, "handleResponseEvent delete reply isInterceptEvent");
              return;
            }
            a(localInteger.intValue(), HardCodeUtil.a(2131900385), HardCodeUtil.a(2131900392));
            if (((paramArrayOfObject[3] instanceof String)) && ((paramArrayOfObject[4] instanceof stSimpleMetaReply)))
            {
              localObject1 = (String)paramArrayOfObject[3];
              paramArrayOfObject = ((stSimpleMetaReply)paramArrayOfObject[4]).id;
              if ((localInteger.intValue() == 1000) && (this.p != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramArrayOfObject)))
              {
                this.p.b((String)localObject1, paramArrayOfObject);
                C();
              }
            }
          }
        }
        else
        {
          if (a(4, paramArrayOfObject))
          {
            WSLog.d("comment", 1, "handleResponseEvent delete isInterceptEvent");
            return;
          }
          if ((localInteger.intValue() == 1000) && ((paramArrayOfObject[3] instanceof stDeleteFeedCommentRsp)))
          {
            paramArrayOfObject = (String)paramArrayOfObject[4];
            localObject1 = this.p;
            if ((localObject1 != null) && (((WsCommentAdapter)localObject1).a(paramArrayOfObject))) {
              C();
            }
            b(-1);
          }
          a(localInteger.intValue(), HardCodeUtil.a(2131900380), HardCodeUtil.a(2131900389));
        }
      }
      else
      {
        if (a(6, paramArrayOfObject))
        {
          WSLog.d("comment", 1, "handleResponseEvent add reply isInterceptEvent");
          return;
        }
        this.G = true;
        localObject2 = this.l;
        if (localObject2 != null) {
          ((WsCommentInputPopupWindow)localObject2).b(this.r);
        }
        if (localInteger.intValue() != 1000)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reply fail ret=");
          ((StringBuilder)localObject2).append(localInteger);
          ((StringBuilder)localObject2).append(" msg=");
          ((StringBuilder)localObject2).append((String)localObject1);
          WSLog.d("comment", 1, ((StringBuilder)localObject2).toString());
        }
        localObject3 = (stPostCommentReplyV2Rsp)paramArrayOfObject[3];
        localObject1 = ((stPostCommentReplyV2Rsp)localObject3).reply;
        localObject2 = (String)paramArrayOfObject[5];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fakeReplyId:");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(",reply toString :");
        localStringBuilder.append(((stSimpleMetaReply)localObject1).toString());
        WSLog.d("comment", localStringBuilder.toString());
        if (localInteger.intValue() == 1000)
        {
          if (h().hashCode() == ((Integer)paramArrayOfObject[6]).intValue()) {
            WSSimpleEventBus.a().a(a((stPostCommentReplyV2Rsp)localObject3));
          }
          paramArrayOfObject = this.p;
          if ((paramArrayOfObject != null) && (paramArrayOfObject.a(((stSimpleMetaReply)localObject1).id, (String)localObject2, (stSimpleMetaReply)localObject1))) {
            C();
          }
        }
        else
        {
          paramArrayOfObject = this.p;
          if ((paramArrayOfObject != null) && (paramArrayOfObject.b(((stSimpleMetaReply)localObject1).id, (String)localObject2))) {
            C();
          }
        }
        a(localInteger.intValue(), HardCodeUtil.a(2131900379), HardCodeUtil.a(2131900390));
      }
    }
    else
    {
      localObject2 = this.l;
      if (localObject2 != null) {
        ((WsCommentInputPopupWindow)localObject2).b(this.r);
      }
      if (a(5, paramArrayOfObject))
      {
        WSLog.d("comment", 1, "handleResponseEvent add comment isInterceptEvent");
        return;
      }
      if (localInteger.intValue() != 1000)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("comment fail ret=");
        ((StringBuilder)localObject2).append(localInteger);
        ((StringBuilder)localObject2).append(" msg=");
        ((StringBuilder)localObject2).append((String)localObject1);
        WSLog.d("comment", 1, ((StringBuilder)localObject2).toString());
      }
      localObject2 = (stPostFeedCommentV2Rsp)paramArrayOfObject[3];
      if (localInteger.intValue() == 1000)
      {
        WSSimpleEventBus.a().a(a((stPostFeedCommentV2Rsp)localObject2));
        localObject3 = this.p;
        if ((localObject3 != null) && (((WsCommentAdapter)localObject3).a(String.valueOf(paramArrayOfObject[4]), ((stPostFeedCommentV2Rsp)localObject2).comment))) {
          C();
        }
        this.G = true;
        b(1);
      }
      else
      {
        localObject2 = this.p;
        if ((localObject2 != null) && (((WsCommentAdapter)localObject2).a(String.valueOf(paramArrayOfObject[4])))) {
          C();
        }
      }
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("ACTION_ADD_FEED_COMMENT, result =");
      paramArrayOfObject.append(localInteger);
      paramArrayOfObject.append(" msg=");
      paramArrayOfObject.append((String)localObject1);
      WSLog.d("comment", 1, paramArrayOfObject.toString());
      a(localInteger.intValue(), HardCodeUtil.a(2131900386), (String)localObject1);
    }
  }
  
  public String b()
  {
    return this.y;
  }
  
  public void b(@Nullable String paramString)
  {
    this.A = paramString;
  }
  
  BaseFragment c()
  {
    return this.b;
  }
  
  WsCommentAdapter d()
  {
    return this.p;
  }
  
  public void e()
  {
    WSLog.c("comment", "comment onRecycle");
    if (this.e != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.e);
    }
    h().b();
    this.f = null;
    Object localObject = this.i;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    this.j.clear();
    localObject = this.l;
    if (localObject != null) {
      ((WsCommentInputPopupWindow)localObject).f();
    }
    WSCommentRestoreManager.a().c();
  }
  
  public void f()
  {
    if (g() != null)
    {
      if (this.J)
      {
        WSLog.d("comment", "已经有预加载进行中，拦截---------------------------------------------------------------------》》》》》》》》");
        return;
      }
      if (!TextUtils.isEmpty(h().a(g())))
      {
        WSLog.d("comment", "已经看过的视频，attachInfo不为空，选择拦截---------------------------------------------------------------------");
        return;
      }
      this.J = true;
      WSLog.d("comment", "请求开始 preLoading = true");
      h().a(n(), false, this.z, this.A);
    }
  }
  
  public String g()
  {
    if (n() == null)
    {
      WSLog.d("comment", 2, "getFeedId is null");
      return "";
    }
    return n().id;
  }
  
  public WsCommentBusiness h()
  {
    if (this.f == null) {
      this.f = new WsCommentBusiness(this);
    }
    return this.f;
  }
  
  public void i()
  {
    if (!TextUtils.equals(g(), WSCommentRestoreManager.a().b()))
    {
      WSCommentRestoreManager.a().c();
      localObject1 = this.r;
      if (localObject1 != null) {
        ((TextView)localObject1).setText("");
      }
    }
    if (this.k == null) {
      this.k = WSCommentPopupWindow.a(this.c, -1, -1);
    }
    Object localObject1 = this.c.getWindow();
    if (localObject1 != null)
    {
      ((Window)localObject1).setDimAmount(0.5F);
      this.k.d();
      this.k.showAtLocation(((Window)localObject1).getDecorView(), 80, 0, 0);
    }
    this.k.setOnDismissListener(new WsCommentPresenter.2(this));
    if (this.t == null) {
      a(this.k.c());
    }
    int i1;
    if (g() == null)
    {
      i1 = this.B;
      if (i1 <= 3)
      {
        this.B = (i1 + 1);
        h().a().postDelayed(new WsCommentPresenter.3(this), this.B * 500);
        return;
      }
    }
    localObject1 = n();
    if (localObject1 == null)
    {
      WSLog.d("comment", "showCommentListWithAnim, but feed is null");
      return;
    }
    String str = g();
    if (str != null)
    {
      this.i = h().c(str);
      Object localObject2 = this.i;
      if (localObject2 == null) {
        i1 = 0;
      } else {
        i1 = ((ArrayList)localObject2).size();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("position:");
      ((StringBuilder)localObject2).append(o());
      ((StringBuilder)localObject2).append(",feedId:");
      ((StringBuilder)localObject2).append(((stSimpleMetaFeed)localObject1).id);
      ((StringBuilder)localObject2).append(",cellId:");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(",loadedComments size:");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(",mCommentListChanged:");
      ((StringBuilder)localObject2).append(this.G);
      ((StringBuilder)localObject2).append(",hashCode:");
      ((StringBuilder)localObject2).append(hashCode());
      WSLog.c("comment", ((StringBuilder)localObject2).toString());
      if (this.G)
      {
        WSLog.c("comment", "11111111111111111111111111 mCommentListChanged");
        h().a((stSimpleMetaFeed)localObject1, false, this.z, this.A);
        this.H = true;
      }
      else if (this.i == null)
      {
        if (this.J)
        {
          WSLog.c("comment", "444444444444444444444444 loadedComments == null and preloading is true");
        }
        else
        {
          WSLog.c("comment", "2222222222222222222222222 loadedComments == null and preloading is false");
          h().a((stSimpleMetaFeed)localObject1, false, this.z, this.A);
        }
        this.H = true;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("333333333333333333333 读取评论");
        ((StringBuilder)localObject1).append(this.i.size());
        ((StringBuilder)localObject1).append("条");
        WSLog.c("comment", ((StringBuilder)localObject1).toString());
        this.H = false;
      }
      t();
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public boolean j()
  {
    WSCommentPopupWindow localWSCommentPopupWindow = this.k;
    return (localWSCommentPopupWindow != null) && (localWSCommentPopupWindow.isShowing());
  }
  
  public void k()
  {
    WSCommentPopupWindow localWSCommentPopupWindow = this.k;
    if ((localWSCommentPopupWindow != null) && (localWSCommentPopupWindow.isShowing())) {
      this.k.dismiss();
    }
    if (this.t != null)
    {
      this.p.c();
      this.p.b();
      this.p.notifyDataSetChanged();
      b(false);
      x();
    }
    this.H = false;
  }
  
  @NotNull
  protected String l()
  {
    if (WSCommentBeaconReport.b(a())) {
      return WSCommentBeaconReport.c(a());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(WSCommentBeaconReport.c(a()));
    localStringBuilder.append(m());
    return localStringBuilder.toString();
  }
  
  public int m()
  {
    if (WSCommentBeaconReport.b(a())) {
      return this.D;
    }
    return WSFeedDataManager.a().f.get(this.D) + 1;
  }
  
  public stSimpleMetaFeed n()
  {
    int i1 = o();
    return (stSimpleMetaFeed)this.j.get(Integer.valueOf(i1));
  }
  
  int o()
  {
    return this.D;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    paramView = WSCommentRestoreManager.a().a(g());
    stSimpleMetaReply localstSimpleMetaReply = WSCommentRestoreManager.a().b(g());
    if (i1 != 2131429804)
    {
      if (i1 != 2131429880)
      {
        if (i1 != 2131447156) {
          return;
        }
        a(1000001, 4);
        a(paramView, localstSimpleMetaReply, 0, false, false);
        return;
      }
      a(1000001, 7);
      a(paramView, localstSimpleMetaReply, 1);
      return;
    }
    a(1000001, 8);
    a(paramView, localstSimpleMetaReply, 0, false, true);
  }
  
  Map<String, String> p()
  {
    BaseFragment localBaseFragment = this.b;
    if ((localBaseFragment instanceof WSVerticalPageFragment)) {
      return ((WSVerticalPageContract.Presenter)((WSVerticalPageFragment)localBaseFragment).aO_()).n();
    }
    return new HashMap();
  }
  
  public boolean q()
  {
    return true;
  }
  
  public boolean r()
  {
    boolean bool = j();
    if (bool) {
      k();
    }
    return bool;
  }
  
  public void s()
  {
    this.i = null;
    this.w = "";
    this.E = 0L;
    this.H = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter
 * JD-Core Version:    0.7.0.1
 */