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
  private static final String jdField_a_of_type_JavaLangString = "CommentPresenter";
  private long jdField_a_of_type_Long;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new CommentPresenter.5(this);
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new CommentPresenter.4(this);
  ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private ActionSheetDialog jdField_a_of_type_ComTencentBizSubscribeCommentActionSheetDialog;
  protected CommentBusiness a;
  private final CommentPresenter.CommentEventReceiver jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$CommentEventReceiver;
  private CommentPresenter.CommentWindowListener jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$CommentWindowListener;
  private CommentPresenter.GetFeedResponseListener jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$GetFeedResponseListener;
  private CommentPresenter.OnFeedCommentElementClickListener jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener;
  private NewCommentAdapter jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter;
  private OnCommentInputShowListener jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentInputShowListener;
  private SubscribeCommentInputPopupWindow jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow;
  private ArrayList<CertifiedAccountMeta.StComment> jdField_a_of_type_JavaUtilArrayList;
  private Map<Long, CertifiedAccountMeta.StUser> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private Map<Long, CertifiedAccountMeta.StComment> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private Map<Long, CertifiedAccountMeta.StReply> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString;
  private Map<Integer, CertifiedAccountMeta.StFeed> jdField_d_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h;
  private boolean i;
  private boolean j;
  
  public CommentPresenter(Activity paramActivity, boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed, CommentPresenter.GetFeedResponseListener paramGetFeedResponseListener, ExtraTypeInfo paramExtraTypeInfo)
  {
    super(paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$CommentEventReceiver = new CommentPresenter.CommentEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$CommentEventReceiver);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$GetFeedResponseListener = paramGetFeedResponseListener;
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    k();
    b(paramStFeed);
    l();
  }
  
  private CertifiedAccountMeta.StComment a(CertifiedAccountMeta.StComment paramStComment)
  {
    return new CertifiedAccountMeta.StComment();
  }
  
  private CertifiedAccountMeta.StFeed a()
  {
    int k = a();
    return (CertifiedAccountMeta.StFeed)this.jdField_d_of_type_JavaUtilMap.get(Integer.valueOf(k));
  }
  
  private CertifiedAccountMeta.StReply a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStComment == null) {
      return null;
    }
    return new CertifiedAccountMeta.StReply();
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
  
  private CertifiedAccountMeta.StUser a()
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
  
  private CommentBusiness a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness == null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness = new CommentBusiness();
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness.hashCode();
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness;
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(paramInt);
    if ((localObject instanceof CommentView))
    {
      localObject = (CommentView)localObject;
      paramString = ((CommentView)localObject).a(paramString);
      localObject = ((CommentView)localObject).a();
      if ((paramString != null) && (localObject != null))
      {
        int k = ((LinearLayout)localObject).getTop();
        int m = paramString.getTop();
        paramString = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollToReplyView getTop containerTop:");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append("replyViewTop:");
        ((StringBuilder)localObject).append(m);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_AndroidWidgetListView.setSelectionFromTop(paramInt, -(k + m));
      }
    }
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 0L)
    {
      QQToast.a(a(), 2, paramString1, 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(a(), 1, a().getResources().getString(2131694433), 0).a();
      return;
    }
    QQToast.a(a(), 1, paramString2, 0).a();
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (BaseApplicationImpl.getContext() != null))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow == null) {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow = new SubscribeCommentInputPopupWindow((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      Object localObject2;
      Object localObject1;
      if (paramStReply != null)
      {
        if (paramStReply.postUser != null)
        {
          localObject2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692245), new Object[] { paramStReply.postUser.nick.get() });
          localObject1 = localObject2;
          if (((String)localObject2).length() > 10)
          {
            localObject1 = ((String)localObject2).substring(0, 10);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("...");
            localObject1 = ((StringBuilder)localObject2).toString();
          }
          this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.b((String)localObject1);
        }
      }
      else if ((paramStComment != null) && (paramStComment.postUser != null))
      {
        localObject2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692245), new Object[] { paramStComment.postUser.nick.get() });
        localObject1 = localObject2;
        if (((String)localObject2).length() > 10)
        {
          localObject1 = ((String)localObject2).substring(0, 10);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("...");
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.b((String)localObject1);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.b(this.jdField_a_of_type_AndroidContentContext.getString(2131692240));
      }
      this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a(new CommentPresenter.6(this, paramStComment, paramStReply));
      c(paramStComment, paramStReply);
      this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a(paramBoolean2);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "plugin environment exception ! ");
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
      paramStReply.jdField_a_of_type_JavaLangString = "android";
      paramStReply.jdField_b_of_type_JavaLangString = AppSetting.f();
      paramStReply.jdField_c_of_type_JavaLangString = "1";
      paramStReply.jdField_d_of_type_JavaLangString = paramStComment;
      paramStReply.e = "KQQ";
      paramStReply.f = "2400002";
      paramStReply.g = "qzone_authentication_comment";
      paramStReply.h = "24000";
      paramStReply.i = "0";
      paramStReply.k = localStringBuilder.toString();
      paramStReply.l = paramStFeed;
      EvilReportUtil.a(this.jdField_a_of_type_AndroidContentContext, paramStReply);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadFeedDisplay() isRefresh => ");
    ((StringBuilder)localObject2).append(paramBoolean);
    localObject2 = ((StringBuilder)localObject2).toString();
    int k = 1;
    QLog.d((String)localObject1, 1, (String)localObject2);
    if (paramBoolean) {
      o();
    }
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      k = 0;
    }
    c(0);
    if (k != 0) {
      h();
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null) {
        ((TextView)localObject2).setText(((SubscribeCommentInputPopupWindow)localObject1).a());
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
    int k = ((Integer)paramArrayOfObject[0]).intValue();
    if (k != 9)
    {
      Object localObject3;
      Object localObject4;
      switch (k)
      {
      default: 
        return;
      case 6: 
        if (a(5, paramArrayOfObject)) {
          return;
        }
        a(((Long)localObject2).longValue(), HardCodeUtil.a(2131702381), HardCodeUtil.a(2131702388));
        if ((!(paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp)) || (!(paramArrayOfObject[4] instanceof CertifiedAccountMeta.StComment))) {
          break;
        }
        localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply.id.get();
        paramArrayOfObject = ((CertifiedAccountMeta.StComment)paramArrayOfObject[4]).id.get();
        if ((((Long)localObject2).longValue() != 0L) || (this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter == null) || (TextUtils.isEmpty(paramArrayOfObject)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.a(paramArrayOfObject, (String)localObject1);
        m();
        return;
      case 5: 
        if (a(4, paramArrayOfObject)) {
          return;
        }
        if ((((Long)localObject2).longValue() == 0L) && ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp)))
        {
          paramArrayOfObject = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment.id.get();
          localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter;
          if ((localObject1 != null) && (((NewCommentAdapter)localObject1).a(paramArrayOfObject))) {
            m();
          }
          b(-1);
        }
        a(((Long)localObject2).longValue(), HardCodeUtil.a(2131702376), HardCodeUtil.a(2131702385));
        return;
      case 4: 
        if (a(6, paramArrayOfObject)) {
          return;
        }
        localObject3 = this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow;
        if (localObject3 != null) {
          ((SubscribeCommentInputPopupWindow)localObject3).b(this.jdField_a_of_type_AndroidWidgetTextView);
        }
        if (((Long)localObject2).longValue() != 0L)
        {
          localObject3 = jdField_a_of_type_JavaLangString;
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
            localObject4 = this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter;
            if ((localObject4 != null) && (((NewCommentAdapter)localObject4).a(((CertifiedAccountMeta.StComment)localObject3).id.get(), paramArrayOfObject))) {
              m();
            }
          }
          if (((Long)localObject2).longValue() == 0L)
          {
            localObject4 = this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter;
            if ((localObject4 != null) && (((NewCommentAdapter)localObject4).a(((CertifiedAccountMeta.StComment)localObject3).id.get(), paramArrayOfObject, (CertifiedAccountMeta.StReply)localObject1))) {
              m();
            }
          }
        }
        a(((Long)localObject2).longValue(), HardCodeUtil.a(2131702375), HardCodeUtil.a(2131702386));
        return;
      case 3: 
        localObject3 = this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow;
        if (localObject3 != null) {
          ((SubscribeCommentInputPopupWindow)localObject3).b(this.jdField_a_of_type_AndroidWidgetTextView);
        }
        if (a(5, paramArrayOfObject)) {
          return;
        }
        if (((Long)localObject2).longValue() != 0L)
        {
          localObject3 = jdField_a_of_type_JavaLangString;
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
            localObject4 = this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter;
            if ((localObject4 != null) && (((NewCommentAdapter)localObject4).a(String.valueOf(paramArrayOfObject[4])))) {
              m();
            }
          }
          if (((Long)localObject2).longValue() == 0L)
          {
            localObject4 = this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter;
            if ((localObject4 != null) && (((NewCommentAdapter)localObject4).a(String.valueOf(paramArrayOfObject[4]), (CertifiedAccountMeta.StComment)localObject3))) {
              m();
            }
            b(1);
          }
        }
        a(((Long)localObject2).longValue(), HardCodeUtil.a(2131702382), (String)localObject1);
        a().a().postDelayed(new CommentPresenter.14(this), 1000L);
        return;
      case 2: 
        this.jdField_c_of_type_Boolean = false;
        if (paramArrayOfObject[3] != null)
        {
          localObject3 = (CertifiedAccountRead.StGetFeedDetailRsp)paramArrayOfObject[3];
          if (a(4, paramArrayOfObject)) {
            return;
          }
          b((CertifiedAccountMeta.StFeed)((CertifiedAccountRead.StGetFeedDetailRsp)localObject3).feed.get());
          localObject4 = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$GetFeedResponseListener;
          if (localObject4 != null) {
            ((CommentPresenter.GetFeedResponseListener)localObject4).a((CertifiedAccountRead.StGetFeedDetailRsp)localObject3, VSNetworkHelper.isProtocolCache((String)localObject1), ((Long)localObject2).longValue(), (String)localObject1);
          }
          if ((paramArrayOfObject.length >= 6) && (paramArrayOfObject[5] != null))
          {
            localObject1 = (COMM.StCommonExt)paramArrayOfObject[5];
            paramArrayOfObject = a().a(b());
            if (((COMM.StCommonExt)localObject1).mapInfo.size() > 0)
            {
              localObject1 = ((COMM.Entry)((COMM.StCommonExt)localObject1).mapInfo.get(0)).value.get();
              if ((paramArrayOfObject != null) && (paramArrayOfObject.size() > 0) && (((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0)).id.get().equals(localObject1)))
              {
                localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
                if ((localObject1 != null) && (!TextUtils.isEmpty(((ExtraTypeInfo)localObject1).getReplyId())))
                {
                  localObject1 = a((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.getReplyId());
                  if (localObject1 != null)
                  {
                    h();
                    SimpleEventBus.getInstance().dispatchEvent(new CommentReplyEvent((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), (CertifiedAccountMeta.StReply)localObject1));
                    this.i = true;
                    this.j = true;
                  }
                  else
                  {
                    a(new CommentPresenter.11(this));
                  }
                }
                else
                {
                  h();
                  SimpleEventBus.getInstance().dispatchEvent(new CommentReplyEvent((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), null));
                }
              }
              else
              {
                a(new CommentPresenter.12(this));
              }
            }
          }
          if (this.jdField_g_of_type_Boolean) {
            a(new CommentPresenter.13(this));
          }
        }
        else
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "get feed detail response failed");
          paramArrayOfObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$GetFeedResponseListener;
          if (paramArrayOfObject != null) {
            paramArrayOfObject.a(null, VSNetworkHelper.isProtocolCache((String)localObject1), ((Long)localObject2).longValue(), (String)localObject1);
          }
          if (!this.h) {
            QQToast.a(a(), (CharSequence)localObject1, 0).a();
          }
        }
        if (!this.h) {
          break;
        }
        this.h = false;
        return;
      case 1: 
        l();
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
        if (this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter != null)
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
                localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness.a((List)localObject2, (String)paramArrayOfObject[5]);
              }
            }
          }
          this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.a((Collection)localObject1);
        }
        m();
      }
    }
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return this.jdField_e_of_type_Int != ((Integer)paramArrayOfObject[paramInt]).intValue();
  }
  
  private boolean a(CertifiedAccountMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (SubscribeGlobalInfo.a() != null) && (paramStUser.id.get().equals(SubscribeGlobalInfo.a().id.get()))) {
      return true;
    }
    return (paramStUser != null) && (paramStUser.id.get().equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
  }
  
  private String b()
  {
    if (a() == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getCellId null");
      return "";
    }
    return a().id.get();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = a().a(b());
    }
    this.jdField_d_of_type_Int += paramInt;
    a(new CommentPresenter.2(this));
    StoryDispatcher.a().dispatch(new CommentEvent(5, new Object[] { b(), Integer.valueOf(this.jdField_d_of_type_Int) }));
  }
  
  private void b(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "popupComment");
    a(paramStComment, paramStReply, true, false);
  }
  
  private void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.jdField_d_of_type_JavaLangString = paramStFeed.poster.id.get();
    }
    this.jdField_d_of_type_JavaUtilMap.put(Integer.valueOf(a()), paramStFeed);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131371529);
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ((TextView)localObject).setText(2131693640);
          return;
        }
        ((TextView)localObject).setText("");
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.a(a().poster.id.get());
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  private void c(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    SubscribeCommentInputPopupWindow localSubscribeCommentInputPopupWindow = this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow;
    if (localSubscribeCommentInputPopupWindow == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mCommentInputPopupWindow == null");
      return;
    }
    localSubscribeCommentInputPopupWindow.setOnShowListener(new CommentPresenter.7(this, paramStComment, paramStReply));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a(new CommentPresenter.8(this, paramStComment, paramStReply));
  }
  
  private void k()
  {
    this.i = false;
    this.j = true;
  }
  
  private void l()
  {
    if (b() != null)
    {
      this.h = true;
      ExtraTypeInfo localExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      if ((localExtraTypeInfo != null) && (!TextUtils.isEmpty(localExtraTypeInfo.getCommentId())))
      {
        a().a(a(), false, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.getCommentId());
        return;
      }
      a().a(a(), false, "");
    }
  }
  
  private void m()
  {
    a(new CommentPresenter.1(this));
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)a(2131366563));
    this.jdField_b_of_type_AndroidViewView = a(2131364941);
    this.jdField_e_of_type_AndroidViewView = a(2131366564);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364968));
    this.jdField_c_of_type_AndroidViewView = a(2131364952);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378535));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = a(2131363924);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_AndroidWidgetListView.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener = new CommentPresenter.OnFeedCommentElementClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter = new NewCommentAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$OnFeedCommentElementClickListener);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.a(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setOnClickListener(new CommentPresenter.3(this));
    }
  }
  
  private void o()
  {
    a().a(a(), false);
  }
  
  private void p()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "innerInitData return empty because CommentBusiness is null ");
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList = a().a(b());
      this.jdField_a_of_type_NS_COMMCOMM$StCommonExt = a().a(b());
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.a();
        this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
        if (this.i) {
          this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.a(0);
        }
        this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.notifyDataSetChanged();
      }
      if ((this.jdField_a_of_type_AndroidWidgetListView != null) && (this.jdField_g_of_type_Int != a()) && (this.i))
      {
        this.jdField_g_of_type_Int = a();
        QLog.d(jdField_a_of_type_JavaLangString, 1, "mNeedShowCommentList2");
        this.jdField_a_of_type_AndroidWidgetListView.setSelection(0);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_d_of_type_Int = a().a(b());
      }
      return;
    }
    finally {}
  }
  
  private void q()
  {
    try
    {
      TextUtils.isEmpty(b());
      p();
      SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(true));
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      boolean bool = false;
      if ((localArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (this.jdField_b_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(Formatter.a(this.jdField_d_of_type_Int));
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      else if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(200L);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_e_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter.getCount() == 0) {
        bool = true;
      }
      b(bool);
      return;
    }
    finally {}
  }
  
  private void r()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772045);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_e_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(false));
    }
    this.jdField_g_of_type_Boolean = false;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected View a()
  {
    return null;
  }
  
  public void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewStub;
    if (localObject != null)
    {
      a((ViewStub)localObject);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if (b() == null)
    {
      int k = this.jdField_f_of_type_Int;
      if (k <= 3)
      {
        this.jdField_f_of_type_Int = (k + 1);
        a().a().postDelayed(new CommentPresenter.10(this, paramStComment, paramStReply), this.jdField_f_of_type_Int * 500);
        return;
      }
    }
    localObject = b();
    if ((!StringUtil.a((String)localObject)) && (a() != null) && (a().vecComment.size() == 0) && (a().commentCount.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList = a().a((String)localObject);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_c_of_type_Boolean)) {
        p();
      } else {
        a().a(a(), false);
      }
    }
    a(paramStComment, paramStReply, true, false);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    b(paramStFeed);
    l();
  }
  
  public void a(CommentPresenter.CommentWindowListener paramCommentWindowListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$CommentWindowListener = paramCommentWindowListener;
  }
  
  public void a(OnCommentInputShowListener paramOnCommentInputShowListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentInputShowListener = paramOnCommentInputShowListener;
  }
  
  public boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.id.get()));
  }
  
  protected int b()
  {
    return 2131558774;
  }
  
  protected void b() {}
  
  public void b(View paramView)
  {
    a(null, null, true, false);
  }
  
  public void b(ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
  }
  
  public boolean b()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      r();
      return true;
    }
    return false;
  }
  
  public void c(View paramView)
  {
    a(null, null, true, true);
  }
  
  public boolean c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  protected void d() {}
  
  public boolean d()
  {
    SubscribeCommentInputPopupWindow localSubscribeCommentInputPopupWindow = this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow;
    return (localSubscribeCommentInputPopupWindow != null) && (localSubscribeCommentInputPopupWindow.isShowing());
  }
  
  protected void e()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$CommentEventReceiver);
    a().a();
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness = null;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.jdField_d_of_type_JavaUtilMap.clear();
  }
  
  protected void g()
  {
    n();
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewStub;
    if (localObject != null)
    {
      a((ViewStub)localObject);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if (b() == null)
    {
      int k = this.jdField_f_of_type_Int;
      if (k <= 3)
      {
        this.jdField_f_of_type_Int = (k + 1);
        a().a().postDelayed(new CommentPresenter.9(this), this.jdField_f_of_type_Int * 500);
        return;
      }
    }
    localObject = a();
    String str = b();
    if (str != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = a().a(str);
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = true;
        a().a((CertifiedAccountMeta.StFeed)localObject, false);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        this.jdField_g_of_type_Boolean = true;
        a().a((CertifiedAccountMeta.StFeed)localObject, false);
        return;
      }
      q();
    }
  }
  
  public void i()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    int k;
    if ((localObject != null) && (((View)localObject).getVisibility() != 0)) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentNewCommentAdapter;
      if (localObject != null) {
        ((NewCommentAdapter)localObject).a(a().poster.id.get());
      }
      h();
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void j()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    int k;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      r();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      paramAnimation = this.jdField_b_of_type_AndroidViewView;
      if (paramAnimation != null) {
        paramAnimation.setVisibility(8);
      }
      paramAnimation = this.jdField_a_of_type_AndroidAppActivity;
      if ((paramAnimation != null) && ((paramAnimation instanceof BaseActivity)) && (((BaseActivity)paramAnimation).mSystemBarComp != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarMask(null);
      }
      this.jdField_f_of_type_Boolean = false;
      paramAnimation = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$CommentWindowListener;
      if (paramAnimation != null) {
        paramAnimation.i();
      }
    }
    else
    {
      paramAnimation = this.jdField_b_of_type_AndroidViewAnimationAnimation;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      this.jdField_f_of_type_Boolean = true;
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mHideCommentListAnimation onAnimationStarttrue");
      return;
    }
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation)
    {
      paramAnimation = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter$CommentWindowListener;
      if (paramAnimation != null) {
        paramAnimation.h();
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mShowCommentListAnimation onAnimationStarttrue");
      paramAnimation = this.jdField_a_of_type_AndroidAppActivity;
      if (((paramAnimation instanceof BaseActivity)) && (((BaseActivity)paramAnimation).mSystemBarComp != null))
      {
        paramAnimation = a();
        if (paramAnimation != null) {
          ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarMask(new PorterDuffColorFilter(paramAnimation.getColor(2131167249), PorterDuff.Mode.SRC_ATOP));
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
    int k = paramView.getId();
    if (k != 2131363924)
    {
      if (k == 2131378535) {
        b(paramView);
      }
    }
    else {
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter
 * JD-Core Version:    0.7.0.1
 */