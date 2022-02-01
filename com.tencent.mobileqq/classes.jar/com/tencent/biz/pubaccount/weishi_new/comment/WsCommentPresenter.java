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
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalDialogListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.subscribe.SubscribeGlobalInfo;
import com.tencent.biz.subscribe.comment.Formatter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
  public int a;
  private long jdField_a_of_type_Long;
  private stSimpleMetaComment jdField_a_of_type_UserGrowthStSimpleMetaComment;
  private stSimpleMetaReply jdField_a_of_type_UserGrowthStSimpleMetaReply;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new WsCommentPresenter.4(this);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  WSCommentPopupWindow jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow;
  private WsCommentAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
  private WsCommentBusiness jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness;
  private WsCommentInputPopupWindow jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow;
  private WsCommentPresenter.CommentEventReceiver jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$CommentEventReceiver;
  private WsCommentPresenter.OnFeedCommentElementClickListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$OnFeedCommentElementClickListener;
  private WSVerticalDialogListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalDialogListener;
  private BaseFragment jdField_a_of_type_ComTencentMobileqqAppBaseFragment;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<stSimpleMetaComment> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, stSimpleMetaFeed> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<Long, stSimpleMetaPerson> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<Long, stSimpleMetaReply> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private int f = 140;
  
  public WsCommentPresenter(BaseFragment paramBaseFragment, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment = paramBaseFragment;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseFragment.getActivity();
    this.jdField_a_of_type_AndroidContentContext = paramBaseFragment.getActivity().getApplicationContext();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness = new WsCommentBusiness(this);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$CommentEventReceiver == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$CommentEventReceiver = new WsCommentPresenter.CommentEventReceiver(this, this.jdField_a_of_type_Int);
      StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$CommentEventReceiver);
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
  
  private int a()
  {
    if (WSCommentBeaconReport.a(a())) {
      return this.jdField_e_of_type_Int;
    }
    return WSFeedDataManager.a().a.get(this.jdField_e_of_type_Int) + 1;
  }
  
  private stSimpleMetaFeed a()
  {
    int i = b();
    return (stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
  }
  
  private stSimpleMetaPerson a()
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
      ((stSimpleMetaPerson)localObject1).nick = ContactUtils.e((QQAppInterface)localObject2, ((stSimpleMetaPerson)localObject1).id);
    } else {
      ((stSimpleMetaPerson)localObject1).nick = "";
    }
    ((stSimpleMetaPerson)localObject1).type = 0;
    return localObject1;
  }
  
  @NotNull
  private WSDownloadParams a(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = WeishiUtils.a(1);
    localWSDownloadParams.mStReportItem = UserActionReportPresenter.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private Map<String, String> a(BaseFragment paramBaseFragment)
  {
    if ((paramBaseFragment instanceof WSVerticalPageFragment)) {
      return ((WSVerticalPageContract.Presenter)((WSVerticalPageFragment)paramBaseFragment).b()).b();
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    WSCommentBeaconReport.a(a(), b(), d(), paramInt1, paramInt2, a(), a(this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment));
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 1000L)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, paramString1, 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      paramString1 = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramString1, 1, paramString1.getResources().getString(2131694433), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, paramString2, 0).a();
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if ((paramstSimpleMetaReply != null) && (paramstSimpleMetaReply.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692245), new Object[] { paramstSimpleMetaReply.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaReply = new StringBuilder();
        paramstSimpleMetaReply.append(paramstSimpleMetaComment);
        paramstSimpleMetaReply.append("...");
        paramstSimpleMetaComment = paramstSimpleMetaReply.toString();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.a(paramstSimpleMetaComment);
      return;
    }
    if ((paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692245), new Object[] { paramstSimpleMetaComment.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaReply = new StringBuilder();
        paramstSimpleMetaReply.append(paramstSimpleMetaComment);
        paramstSimpleMetaReply.append("...");
        paramstSimpleMetaComment = paramstSimpleMetaReply.toString();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.a(paramstSimpleMetaComment);
      return;
    }
    paramstSimpleMetaComment = WSGlobalConfig.a().f();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.a(paramstSimpleMetaComment);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt)
  {
    a(paramstSimpleMetaComment, paramstSimpleMetaReply, paramInt, false);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (BaseApplicationImpl.getContext() != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow = new WsCommentInputPopupWindow(this.jdField_a_of_type_AndroidAppActivity);
      }
      a(paramstSimpleMetaComment, paramstSimpleMetaReply);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.a(new WsCommentPresenter.6(this, paramstSimpleMetaComment, paramBoolean, paramstSimpleMetaReply));
      b(paramBoolean);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.a(paramInt);
      return;
    }
    WSLog.d("comment", 1, "plugin environment exception ! ");
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean, stSimpleMetaReply paramstSimpleMetaReply)
  {
    boolean bool = true;
    WSLog.b("comment", 1, "onCommentSend()");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow;
    if (localObject == null)
    {
      WSLog.b("comment", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    localObject = ((WsCommentInputPopupWindow)localObject).a();
    if (TextUtils.isEmpty(((String)localObject).trim()))
    {
      paramstSimpleMetaComment = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramstSimpleMetaComment, paramstSimpleMetaComment.getString(2131692246), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      paramstSimpleMetaComment = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramstSimpleMetaComment, 1, paramstSimpleMetaComment.getString(2131694433), 0).a();
      return;
    }
    if (a() == null)
    {
      WSLog.d("comment", 1, "feed is null");
      return;
    }
    if (paramstSimpleMetaComment != null) {
      bool = false;
    }
    WSCommentBeaconReport.a(a(), b(), a(), a(), paramBoolean, bool, a(this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment));
    if (bool) {
      a((String)localObject);
    } else {
      a((String)localObject, paramstSimpleMetaReply, paramstSimpleMetaComment);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.b("");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.dismiss();
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment == null) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaComment = new stSimpleMetaComment();
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment.wording = paramString;
    stSimpleMetaComment localstSimpleMetaComment = new stSimpleMetaComment();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeId_");
    localStringBuilder.append(System.currentTimeMillis());
    localstSimpleMetaComment.id = localStringBuilder.toString();
    localstSimpleMetaComment.wording = paramString;
    localstSimpleMetaComment.createtime = ((int)(System.currentTimeMillis() / 1000L));
    localstSimpleMetaComment.poster = a();
    localstSimpleMetaComment.replyList = new ArrayList();
    a().a(a(), localstSimpleMetaComment);
    this.jdField_a_of_type_Boolean = true;
    paramString = new StringBuilder();
    paramString.append("2 mCommentListChanged:");
    paramString.append(this.jdField_a_of_type_Boolean);
    paramString.append(", hashCode");
    paramString.append(hashCode());
    WSLog.c("comment", paramString.toString());
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment;
    if ((paramString instanceof WSFollowFragment)) {
      ((WSFollowFragment)paramString).a(b(), a());
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment = null;
    paramString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
    if (paramString != null)
    {
      paramString.a(0, localstSimpleMetaComment);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.notifyDataSetChanged();
    }
    paramString = new StringBuilder();
    paramString.append("onCommentSend, lastPosition:");
    paramString.append(this.jdField_d_of_type_Int);
    paramString.append(",currentPosition:");
    paramString.append(b());
    WSLog.d("comment", paramString.toString());
    paramString = this.jdField_a_of_type_AndroidWidgetListView;
    if (paramString != null) {
      paramString.setSelection(0);
    }
  }
  
  private void a(String paramString, stSimpleMetaReply paramstSimpleMetaReply, stSimpleMetaComment paramstSimpleMetaComment)
  {
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaReply == null) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaReply = new stSimpleMetaReply();
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaReply.wording = paramString;
    stSimpleMetaReply localstSimpleMetaReply = new stSimpleMetaReply();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeId_");
    localStringBuilder.append(System.currentTimeMillis());
    localstSimpleMetaReply.id = localStringBuilder.toString();
    localstSimpleMetaReply.wording = paramString;
    localstSimpleMetaReply.createtime = ((int)(System.currentTimeMillis() / 1000L));
    localstSimpleMetaReply.poster = a();
    if (paramstSimpleMetaReply != null)
    {
      localstSimpleMetaReply.receiver = paramstSimpleMetaReply.poster;
      localstSimpleMetaReply.beReplyReplyId = paramstSimpleMetaReply.id;
    }
    else
    {
      localstSimpleMetaReply.receiver = paramstSimpleMetaComment.poster;
    }
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaReply.receiver != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), this.jdField_a_of_type_UserGrowthStSimpleMetaReply.receiver);
    }
    paramString = new StringBuilder();
    paramString.append("回复请求前,发送者:");
    paramString.append(localstSimpleMetaReply.poster.nick);
    paramString.append(",接受者:");
    paramString.append(localstSimpleMetaReply.receiver.nick);
    WSLog.d("comment", paramString.toString());
    this.jdField_b_of_type_Long = a().a(a(), paramstSimpleMetaComment, localstSimpleMetaReply);
    this.jdField_a_of_type_Boolean = true;
    paramString = new StringBuilder();
    paramString.append("1 mCommentListChanged:");
    paramString.append(this.jdField_a_of_type_Boolean);
    paramString.append(", hashCode");
    paramString.append(hashCode());
    WSLog.d("comment", paramString.toString());
    this.jdField_c_of_type_Boolean = true;
    paramString = this.jdField_b_of_type_JavaUtilMap;
    if (paramString != null) {
      paramString.put(Long.valueOf(this.jdField_b_of_type_Long), this.jdField_a_of_type_UserGrowthStSimpleMetaReply);
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaReply = null;
    paramString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
    if (paramString != null)
    {
      paramString.a(paramstSimpleMetaComment.id, localstSimpleMetaReply);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (!this.jdField_b_of_type_Boolean))
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693640);
        return;
      }
      localView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return false;
  }
  
  private int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      WSLog.b("comment", 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a(a().poster.id);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a(a());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    WsCommentInputPopupWindow localWsCommentInputPopupWindow = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow;
    if (localWsCommentInputPopupWindow == null)
    {
      WSLog.d("comment", "mCommentInputPopupWindow == null");
      return;
    }
    localWsCommentInputPopupWindow.a(new WsCommentPresenter.7(this, paramBoolean));
  }
  
  private String c()
  {
    if (a() == null)
    {
      WSLog.d("comment", 2, "getFeedId is null");
      return "";
    }
    return a().id;
  }
  
  private void c()
  {
    if (c() != null)
    {
      if (this.jdField_e_of_type_Boolean)
      {
        WSLog.d("comment", "已经有预加载进行中，拦截---------------------------------------------------------------------》》》》》》》》");
        return;
      }
      if (!TextUtils.isEmpty(a().a(c())))
      {
        WSLog.d("comment", "已经看过的视频，attachInfo不为空，选择拦截---------------------------------------------------------------------");
        return;
      }
      this.jdField_e_of_type_Boolean = true;
      WSLog.d("comment", "请求开始 preLoading = true");
      a().a(a(), false);
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = a().a(c());
    }
    this.jdField_a_of_type_Long += paramInt;
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null) {
      localActivity.runOnUiThread(new WsCommentPresenter.9(this));
    }
    StoryDispatcher.a().dispatch(new WSCommentEvent(5, new Object[] { c(), Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  private boolean c()
  {
    return true;
  }
  
  @NotNull
  private String d()
  {
    if (WSCommentBeaconReport.a(a())) {
      return WSCommentBeaconReport.b(a());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(WSCommentBeaconReport.b(a()));
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        e();
        ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        bool = true;
        if ((localArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label129;
        }
        i = 1;
        if (i != 0)
        {
          if (this.jdField_c_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(Formatter.a(this.jdField_a_of_type_Long));
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          }
        }
        else if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText("");
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      finally {}
      a(bool);
      j();
      boolean bool = a();
      if (bool) {
        return;
      }
      l();
      return;
      label129:
      int i = 0;
      continue;
      if (i != 0) {
        bool = false;
      }
    }
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness == null)
      {
        WSLog.d("comment", "innerInitData return empty because WsCommentBusiness is null ");
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList = a().a(c());
      this.jdField_b_of_type_JavaLangString = a().a(c());
      Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject1 == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a();
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.notifyDataSetChanged();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("innerInitData, lastPosition:");
      ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
      ((StringBuilder)localObject1).append(",currentPosition:");
      ((StringBuilder)localObject1).append(b());
      WSLog.d("comment", ((StringBuilder)localObject1).toString());
      if ((this.jdField_a_of_type_AndroidWidgetListView != null) && (this.jdField_d_of_type_Int != b()))
      {
        this.jdField_d_of_type_Int = b();
        this.jdField_a_of_type_AndroidWidgetListView.post(new WsCommentPresenter.3(this));
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_Long = a().a(c());
      }
      return;
    }
    finally {}
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366563));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364968));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363954));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363937));
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364952);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371529));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378535));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363924);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$OnFeedCommentElementClickListener = new WsCommentPresenter.OnFeedCommentElementClickListener(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter == null)
    {
      WSLog.a("comment", "create mCommentAdapter ...");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter = new WsCommentAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$OnFeedCommentElementClickListener);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a(a());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a(a(), b());
    }
    else
    {
      WSLog.a("comment", "复用 mCommentAdapter ...");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a(a());
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter);
    WsCommentPresenter.5 local5 = new WsCommentPresenter.5(this);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setOnClickListener(local5);
    }
    g();
  }
  
  private void g()
  {
    String str = WSGlobalConfig.a().f();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setHint(str);
    }
  }
  
  private void h()
  {
    WSCommentPopupWindow localWSCommentPopupWindow = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow;
    if ((localWSCommentPopupWindow != null) && (localWSCommentPopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow.dismiss();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.b();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.notifyDataSetChanged();
      a(false);
      i();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void i()
  {
    WSVerticalDialogListener localWSVerticalDialogListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalDialogListener;
    if (localWSVerticalDialogListener != null) {
      localWSVerticalDialogListener.b(1);
    }
  }
  
  private void j()
  {
    WSVerticalDialogListener localWSVerticalDialogListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalDialogListener;
    if (localWSVerticalDialogListener != null) {
      localWSVerticalDialogListener.a(1);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewView.getVisibility();
    b(0);
    b();
    WsCommentInputPopupWindow localWsCommentInputPopupWindow = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow;
    if (localWsCommentInputPopupWindow != null)
    {
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setText(localWsCommentInputPopupWindow.a());
      }
    }
  }
  
  private void l()
  {
    String str = WSCommentBeaconReport.b(this.jdField_c_of_type_JavaLangString);
    Object localObject = str;
    if (!str.equals("comment_page"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(a());
      localObject = ((StringBuilder)localObject).toString();
    }
    WSCommentBeaconReport.a(this.jdField_c_of_type_JavaLangString, b(), (String)localObject, a(), a(this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment));
  }
  
  private void m()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      WSLog.d("comment", "请求结束 preLoading = false");
    }
  }
  
  private void n()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null) {
      localActivity.runOnUiThread(new WsCommentPresenter.10(this));
    }
  }
  
  public WsCommentBusiness a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness = new WsCommentBusiness(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    WSLog.c("comment", "comment onRecycle");
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$CommentEventReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter$CommentEventReceiver);
    }
    a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentBusiness = null;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_e_of_type_Int)
    {
      WsCommentAdapter localWsCommentAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
      if (localWsCommentAdapter != null)
      {
        localWsCommentAdapter.b.clear();
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.jdField_a_of_type_JavaUtilHashSet.clear();
      }
    }
    this.jdField_e_of_type_Int = paramInt;
    WsCommentAdapter.jdField_a_of_type_Int = a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    WSCommentBeaconReport.a(a(), paramString, "comment_page_explicit", 1000001, paramInt2, a(), a(this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment));
    a(null, null, paramInt1, true);
    j();
  }
  
  public void a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    int i = 0;
    if (localstSimpleMetaFeed != null)
    {
      localstSimpleMetaFeed.total_comment_num += 1;
      i = localstSimpleMetaFeed.total_comment_num;
      localstSimpleMetaFeed.simpleComments.add(0, WSCommentUtil.a(paramstSimpleMetaComment, a()));
    }
    if (a() != null) {
      paramstSimpleMetaComment = a().id;
    } else {
      paramstSimpleMetaComment = "";
    }
    paramstSimpleMetaComment = new WSAddCommentEvent(paramstSimpleMetaComment, b(), i);
    WSSimpleEventBus.a().a(paramstSimpleMetaComment);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      this.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.poster.id;
      WsCommentAdapter localWsCommentAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
      if (localWsCommentAdapter != null) {
        localWsCommentAdapter.a(paramstSimpleMetaFeed);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b()), paramstSimpleMetaFeed);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    f();
  }
  
  public void a(WSVerticalDialogListener paramWSVerticalDialogListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalDialogListener = paramWSVerticalDialogListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    WsCommentAdapter localWsCommentAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
    if (localWsCommentAdapter != null) {
      localWsCommentAdapter.a(paramString1, paramString2);
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
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
    WSLog.c("comment", ((StringBuilder)localObject2).toString());
    if (i != 1)
    {
      if (i != 9)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 6) {
                return;
              }
              if (a(5, paramArrayOfObject))
              {
                WSLog.d("comment", 1, "handleResponseEvent delete reply isInterceptEvent");
                return;
              }
              a(localInteger.intValue(), HardCodeUtil.a(2131702381), HardCodeUtil.a(2131702388));
              if (((paramArrayOfObject[3] instanceof String)) && ((paramArrayOfObject[4] instanceof stSimpleMetaReply)))
              {
                localObject1 = (String)paramArrayOfObject[3];
                paramArrayOfObject = ((stSimpleMetaReply)paramArrayOfObject[4]).id;
                if ((localInteger.intValue() == 1000) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramArrayOfObject)))
                {
                  this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a((String)localObject1, paramArrayOfObject);
                  n();
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
                localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
                if ((localObject1 != null) && (((WsCommentAdapter)localObject1).a(paramArrayOfObject))) {
                  n();
                }
                c(-1);
              }
              a(localInteger.intValue(), HardCodeUtil.a(2131702376), HardCodeUtil.a(2131702385));
            }
          }
          else
          {
            if (a(6, paramArrayOfObject))
            {
              WSLog.d("comment", 1, "handleResponseEvent add reply isInterceptEvent");
              return;
            }
            this.jdField_a_of_type_Boolean = true;
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow;
            if (localObject2 != null) {
              ((WsCommentInputPopupWindow)localObject2).b(this.jdField_b_of_type_AndroidWidgetTextView);
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
            localObject1 = ((stPostCommentReplyV2Rsp)paramArrayOfObject[3]).reply;
            paramArrayOfObject = (String)paramArrayOfObject[5];
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("fakeReplyId:");
            ((StringBuilder)localObject2).append(paramArrayOfObject);
            ((StringBuilder)localObject2).append(",reply toString :");
            ((StringBuilder)localObject2).append(((stSimpleMetaReply)localObject1).toString());
            WSLog.d("comment", ((StringBuilder)localObject2).toString());
            if (localInteger.intValue() == 1000)
            {
              localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
              if ((localObject2 != null) && (((WsCommentAdapter)localObject2).a(((stSimpleMetaReply)localObject1).id, paramArrayOfObject, (stSimpleMetaReply)localObject1))) {
                n();
              }
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
              if ((localObject2 != null) && (((WsCommentAdapter)localObject2).a(((stSimpleMetaReply)localObject1).id, paramArrayOfObject))) {
                n();
              }
            }
            a(localInteger.intValue(), HardCodeUtil.a(2131702375), HardCodeUtil.a(2131702386));
          }
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow;
          if (localObject2 != null) {
            ((WsCommentInputPopupWindow)localObject2).b(this.jdField_b_of_type_AndroidWidgetTextView);
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
            WsCommentAdapter localWsCommentAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
            if ((localWsCommentAdapter != null) && (localWsCommentAdapter.a(String.valueOf(paramArrayOfObject[4]), ((stPostFeedCommentV2Rsp)localObject2).comment))) {
              n();
            }
            this.jdField_a_of_type_Boolean = true;
            c(1);
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter;
            if ((localObject2 != null) && (((WsCommentAdapter)localObject2).a(String.valueOf(paramArrayOfObject[4])))) {
              n();
            }
          }
          paramArrayOfObject = new StringBuilder();
          paramArrayOfObject.append("ACTION_ADD_FEED_COMMENT, result =");
          paramArrayOfObject.append(localInteger);
          paramArrayOfObject.append(" msg=");
          paramArrayOfObject.append((String)localObject1);
          WSLog.d("comment", 1, paramArrayOfObject.toString());
          a(localInteger.intValue(), HardCodeUtil.a(2131702382), (String)localObject1);
        }
      }
      else
      {
        WSLog.d("comment", "onEvent: ACTION_GET_MORE_COMMENT！");
        m();
        if (((paramArrayOfObject[6] instanceof String)) && (!((String)paramArrayOfObject[6]).equals(c())))
        {
          WSLog.d("comment", "不是当前feedId的数据，不响应！！！！！！！！！！！！！！！！");
          return;
        }
        if (a(4, paramArrayOfObject))
        {
          m();
          return;
        }
        boolean bool1;
        if ((paramArrayOfObject[5] instanceof Boolean))
        {
          boolean bool2 = ((Boolean)paramArrayOfObject[5]).booleanValue();
          bool1 = bool2;
          if (!bool2)
          {
            this.jdField_a_of_type_Boolean = false;
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
          if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter != null)
          {
            paramArrayOfObject = ((stGetFeedCommentListV2Rsp)paramArrayOfObject[3]).comments;
            if (paramArrayOfObject.size() == 0)
            {
              a(true);
            }
            else
            {
              if (!bool1) {
                this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a();
              }
              this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentAdapter.a(paramArrayOfObject);
              n();
              c(0);
            }
          }
          if ((this.jdField_b_of_type_Boolean) && (!bool1))
          {
            paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment.getBaseActivity();
            if (paramArrayOfObject != null) {
              paramArrayOfObject.runOnUiThread(new WsCommentPresenter.8(this));
            }
          }
        }
        else
        {
          WSLog.d("comment", "获取评论response失败");
        }
      }
    }
    else {
      c();
    }
  }
  
  public boolean a()
  {
    WSCommentPopupWindow localWSCommentPopupWindow = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow;
    return (localWSCommentPopupWindow != null) && (localWSCommentPopupWindow.isShowing());
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow = WSCommentPopupWindow.a(this.jdField_a_of_type_AndroidAppActivity, -1, -1);
    }
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (localObject1 != null)
    {
      ((Window)localObject1).setDimAmount(0.5F);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow.b();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow.showAtLocation(((Window)localObject1).getDecorView(), 80, 0, 0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow.setOnDismissListener(new WsCommentPresenter.1(this));
    if (this.jdField_a_of_type_AndroidViewView == null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWSCommentPopupWindow.a());
    }
    int i;
    if (c() == null)
    {
      i = this.jdField_c_of_type_Int;
      if (i <= 3)
      {
        this.jdField_c_of_type_Int = (i + 1);
        a().a().postDelayed(new WsCommentPresenter.2(this), this.jdField_c_of_type_Int * 500);
        return;
      }
    }
    localObject1 = a();
    if (localObject1 == null)
    {
      WSLog.d("comment", "showCommentListWithAnim, but feed is null");
      return;
    }
    String str = c();
    if (str != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = a().a(str);
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = ((ArrayList)localObject2).size();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("position:");
      ((StringBuilder)localObject2).append(b());
      ((StringBuilder)localObject2).append(",feedId:");
      ((StringBuilder)localObject2).append(((stSimpleMetaFeed)localObject1).id);
      ((StringBuilder)localObject2).append(",cellId:");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(",loadedComments size:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",mCommentListChanged:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject2).append(",hashCode:");
      ((StringBuilder)localObject2).append(hashCode());
      WSLog.c("comment", ((StringBuilder)localObject2).toString());
      if (this.jdField_a_of_type_Boolean)
      {
        WSLog.c("comment", "11111111111111111111111111 mCommentListChanged");
        a().a((stSimpleMetaFeed)localObject1, false);
        this.jdField_b_of_type_Boolean = true;
      }
      else if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        if (this.jdField_e_of_type_Boolean)
        {
          WSLog.c("comment", "444444444444444444444444 loadedComments == null and preloading is true");
        }
        else
        {
          WSLog.c("comment", "2222222222222222222222222 loadedComments == null and preloading is false");
          a().a((stSimpleMetaFeed)localObject1, false);
        }
        this.jdField_b_of_type_Boolean = true;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("333333333333333333333 读取评论");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilArrayList.size());
        ((StringBuilder)localObject1).append("条");
        WSLog.c("comment", ((StringBuilder)localObject1).toString());
        this.jdField_b_of_type_Boolean = false;
      }
      d();
    }
  }
  
  public boolean b()
  {
    boolean bool = a();
    if (bool) {
      h();
    }
    return bool;
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131378535: 
      a(1000001, 4);
      a(null, null, 0, false);
      return;
    case 2131363954: 
      a(1000001, 7);
      a(null, null, 2);
      return;
    case 2131363937: 
      a(1000001, 7);
      a(null, null, 3);
      return;
    }
    a(1000001, 7);
    a(null, null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter
 * JD-Core Version:    0.7.0.1
 */