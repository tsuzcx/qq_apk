package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.AccountMoreDetailController;
import com.tencent.biz.pubaccount.AccountSettingFragment;
import com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper;
import com.tencent.biz.pubaccount.accountdetail.activity.PubAccountMoreInfoActivity;
import com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailDynamicListModel;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView.RefreshCallback;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountObserverImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.api.IKanDianDailyReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.open.base.MD5Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

@RoutePage(desc="PublicAccountDetailActivity", path="/pubaccount/detail")
public class PublicAccountDetailActivityImpl
  extends BaseActivity
  implements View.OnClickListener, IPublicAccountDetailActivity, AccountDetailXListView.RefreshCallback
{
  public static final int ARTICLE_ID = 111;
  static final String ATTENTION_ACTION_FOR_REPORT_FROM_OTHER_APP = "0X8005B6D";
  protected static final int BOTTON_ITEM = 2;
  public static final int BUSY_FLODER = 108;
  public static final int BUSY_SERRCH = 109;
  public static final String DOMAIN_MP_ARTICLE = "article.mp.qq.com";
  public static final String DOMAIN_MP_FIND = "find.mp.qq.com";
  public static final String DOMAIN_MP_POST = "post.mp.qq.com";
  public static final int FOLLOWED = 1;
  public static final String FROM_BROWSER = "fromBrowser";
  public static final String IS_USE_STYLE_839 = "is_use_style_839";
  protected static final int MIDDLE_ITEM = 3;
  static final int MSG_HD_FACE_UPDATE = 3;
  static final int MSG_REPORT = 4;
  protected static final int MSG_REQUEST_UPDATE = 1;
  static final int MSG_TOPFOL = 5;
  protected static final int MSG_UNFOLLOW_UPDATE = 2;
  public static int NETWORK_ERROR = -1;
  public static int NETWORK_UNKNOW = 0;
  public static int NO_MORE_DATA = 1;
  protected static final int SINGLE_ITEM = 0;
  public static final int SOURCE_CENTRE = 104;
  public static final int SOURCE_FEEDS = 116;
  public static final int SOURCE_MULTIVIDEO = 114;
  public static final int SOURCE_QR = 1;
  public static final int SOURCE_WEISHI_VIDEO_FEEDS = 120;
  protected static final int SPECIAL_BOTTON_ITEM = 5;
  protected static final int SPECIAL_TOP_ITEM = 4;
  public static final int SUBSCRIPTION_FLODER = 105;
  public static final int SUBSCRIPTION_GUESS = 106;
  public static final String TAG = "com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity";
  public static final String TAG_TROOP = "AccountDetailActivity.bindTroop";
  protected static final int TOP_ITEM = 1;
  protected static final int UIN_TYPE = 1008;
  static final String UN_ATTENTION_ACTION_FOR_REPORT_FROM_OTHER_APP = "0X8005B6E";
  PublicAccountDetailImpl accountDetail = null;
  private AccountMoreDetailController accountMoreDetailController;
  ActionSheet actionSheet = null;
  protected QQAppInterface app;
  Drawable bigFace = null;
  protected View bottomContainer;
  int bottomHeight = 0;
  protected View btnsDivider1;
  View btnsDivider2;
  View btnsDivider3;
  protected View callBtn;
  public String cuin;
  protected float density;
  protected NewIntent detailIntent;
  protected mqq.observer.BusinessObserver detailObserver;
  private ViewGroup detailRootView;
  long enterTime;
  LinearLayout errorContainer;
  protected int errorStatus = NETWORK_UNKNOW;
  protected View followBtn;
  protected NewIntent followIntent;
  protected mqq.observer.BusinessObserver followObserver;
  boolean fromJS = false;
  protected int fromwhere = 0;
  mobileqq_mp.GetPublicAccountDetailInfoResponse gAccountData;
  private boolean hasReport2 = false;
  boolean hdFaceLoaded = false;
  public ImageView iconCertifiedTop;
  public ImageView iconCicleTop;
  public ImageView iconTop;
  private boolean isClickingWSFollow;
  boolean isDestroy = false;
  boolean isDownCancel = false;
  protected boolean isFirst;
  boolean isFirstDataComplate = false;
  private boolean isFromBrowser = false;
  boolean isGetPanelHeight = false;
  public boolean isNewSubscriptAIOUser = false;
  protected boolean isShowGroupList = false;
  boolean isSubscriptAccount = false;
  private boolean isUseStyleAfter839 = false;
  private AdapterView.OnItemClickListener itemClickListener = new PublicAccountDetailActivityImpl.29(this);
  long leaveTime;
  protected AccountDetailBaseAdapter mAccountDetailAdapter = null;
  protected AccountDetailXListView mAccountDetailListView;
  private float mDensity;
  PublicAccountDetailActivityImpl.AvatarObserver mFaceObserver;
  protected Handler mHandler = new PublicAccountDetailActivityImpl.20(this);
  protected Intent mIntent;
  boolean mIsChangedFromOutSide = true;
  protected boolean mIsReportMessage = false;
  protected boolean mIsSendMessage = false;
  protected ProfileParams mProfileParams;
  QQProgressDialog mProgress;
  private MqqHandler mQQUiHandler;
  protected String mSendMessage;
  protected com.tencent.biz.troopbar.ShareActionSheet mShareActionSheet;
  ShareAioResultDialog mShareAttentionSuccessDlg;
  protected ShareActionSheetBuilder mShareDialogBuilder;
  boolean mShouldNotStayAtThisApp = true;
  int mSource = 0;
  protected AccountDetailTopGestureLayout mTopGestureLayout;
  protected String mTypeMessage;
  private View mask;
  PublicAccountDetailActivityImpl.FriendAvatarWeakReference model;
  protected boolean needUpdateView = false;
  NewPublicAccountObserver newFollowObserver;
  NewPublicAccountObserver newUnFollowObserver;
  JSONObject postData;
  protected PublicAccountHandlerImpl publicAccountHandler;
  PublicAccountObserverImpl publicAccountObserver;
  protected ImageView rightViewImg;
  TextView rightViewText;
  int screenHeight = 0;
  Button searchBtn;
  protected Button sendMsgBtn;
  protected String shareUrl;
  public String sopName;
  public String sopType;
  int titleHeight = 0;
  ImageView titleLeftIcon;
  public RelativeLayout titleViewLayout;
  Button topFollowed;
  protected String uin;
  ActionSheet unFollowActionSheet = null;
  boolean unFollowActionSheetHasClick;
  protected Button unfollowBtn;
  NewIntent unfollowIntent;
  mqq.observer.BusinessObserver unfollowObserver;
  protected int waitingCount = 0;
  public int weatherOutsideFollowState;
  public String weatherShareUrl;
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] getActionSheetItems()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131894171);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839221;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 2;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131894185);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839222;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 3;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131894192);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839225;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131894174);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839219;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 10;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    QidianManager.a(this, localArrayList);
    localObject = new ArrayList();
    if (needShowUnFollowBtnInActionSheet())
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = super.getString(2131892927);
      localActionSheetItem.icon = 2130843696;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 30;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = super.getString(2131892985);
    localActionSheetItem.icon = 2130843688;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 31;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = super.getString(2131892972);
    localActionSheetItem.icon = 2130843680;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 11;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    if (needShowUnFollowBtnInActionSheet())
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = super.getString(2131893006);
      localActionSheetItem.icon = 2130843706;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 32;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> getShareActionSheetOperations()
  {
    return new ArrayList();
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> getShareActionSheetPaths()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  private void gotoMiniGamePublicAccountActivity()
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount(this);
  }
  
  private void gotoNowQQLiveActivity()
  {
    NowQQLiveHelper.a(this, this.uin, 2);
  }
  
  private void gotoWeiShiAfterFollow()
  {
    if (this.isClickingWSFollow)
    {
      ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(this, "from_account_detail", true);
      this.isClickingWSFollow = false;
    }
  }
  
  private boolean isNoTransparentTitleBar()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private boolean isPublicAccountMsgTabSetTop(String paramString)
  {
    Object localObject = this.app.getProxyManager().g();
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, this.uin);
    RecentUser localRecentUser = ((RecentUserProxy)localObject).c(paramString, i);
    localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPublicAccoutMsgTabSetTop pUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" userType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" not in the msglist");
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, ((StringBuilder)localObject).toString());
      localObject = new RecentUser(this.uin, i);
    }
    return ((RecentUser)localObject).showUpTime != 0L;
  }
  
  protected static boolean isSubscriptAccount(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    if (paramPublicAccountDetailImpl == null) {
      return false;
    }
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramPublicAccountDetailImpl.accountFlag);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != -2)
    {
      bool1 = bool2;
      if (i != -3)
      {
        if (i == -4) {
          return true;
        }
        if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramPublicAccountDetailImpl.accountFlag2) == -8L) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static void reportEvents(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!paramIntent.hasExtra("source")) {
        return;
      }
      int i = paramIntent.getIntExtra("source", 0);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800589D", "0X800589D", 0, 0, paramString, "", "", "", false);
            return;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574E", "0X800574E", 0, 0, paramString, "", "", "", false);
          return;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574D", "0X800574D", 0, 0, paramString, "", "", "", false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574C", "0X800574C", 0, 0, paramString, "", "", "", false);
    }
  }
  
  private void reportShareDetail(String paramString, ShareActionSheet.Detail paramDetail)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramDetail.f == ShareActionSheet.Detail.b))
    {
      QQAppInterface localQQAppInterface = this.app;
      String str2 = paramDetail.a();
      String str1;
      if (paramDetail.g) {
        str1 = "02";
      } else {
        str1 = "01";
      }
      ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str2, "0X8007CA6", "0X8007CA6", 0, 0, str1, paramString, String.valueOf(paramDetail.h), "");
      return;
    }
  }
  
  private boolean sendSystemMsgAction(int paramInt)
  {
    Object localObject = GroupSystemMsgController.a().f();
    localObject = GroupSystemMsgController.a().b((String)localObject);
    if (localObject != null)
    {
      int i = ((structmsg.StructMsg)localObject).msg_type.get();
      long l1 = ((structmsg.StructMsg)localObject).msg_seq.get();
      long l2 = ((structmsg.StructMsg)localObject).req_uin.get();
      int j = ((structmsg.StructMsg)localObject).msg.sub_type.get();
      int k = ((structmsg.StructMsg)localObject).msg.src_id.get();
      int m = ((structmsg.StructMsg)localObject).msg.sub_src_id.get();
      int n = ((structmsg.StructMsg)localObject).msg.group_msg_type.get();
      localObject = ((structmsg.StructMsg)localObject).msg.actions.get();
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        this.app.getMsgHandler().B().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
        return true;
      }
    }
    return false;
  }
  
  public static void setDatatongElement(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("target_qq", paramString2);
      localHashMap.put("area", "2");
      localHashMap.put("dt_appkey", "0P000B1E6X38P6V3");
      VideoReport.setElementParams(paramObject, localHashMap);
      VideoReport.setElementId(paramObject, paramString1);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      QLog.e("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "setDatatongElement", paramObject);
    }
  }
  
  private void setDatongParam()
  {
    try
    {
      VideoReport.addToDetectionWhitelist(this);
      VideoReport.setPageId(this, "gzh_pg_profile");
      HashMap localHashMap = new HashMap();
      localHashMap.put("page_type", "2");
      localHashMap.put("target_qq", this.uin);
      localHashMap.put("dt_appkey", "0P000B1E6X38P6V3");
      VideoReport.setPageParams(this, new PageParams(localHashMap));
      setDatatongElement(this.sendMsgBtn, "gzh_ele_enter_aio", this.uin);
      setDatatongElement(this.followBtn, "gzh_ele_follow", this.uin);
      setDatatongElement(this.unfollowBtn, "gzh_ele_unfollow", this.uin);
      setDatatongElement(this.rightViewImg, "gzh_ele_three_dot", this.uin);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "setDatongParam", localException);
    }
  }
  
  private void setOrCancelSetTop(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet setOrCancelSetTop");
    }
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, this.uin);
    if (i == 1024)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOrCancelTop pUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" userType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" is UIN_TYPE_BUSINESS_CMR_TMP");
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, ((StringBuilder)localObject).toString());
    }
    RecentUserProxy localRecentUserProxy = this.app.getProxyManager().g();
    RecentUser localRecentUser = localRecentUserProxy.c(paramString, i);
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOrCancelTop pUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" userType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" not in the msglist");
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, ((StringBuilder)localObject).toString());
      localObject = new RecentUser(this.uin, i);
    }
    boolean bool = isPublicAccountMsgTabSetTop(paramString);
    if (bool) {
      ((RecentUser)localObject).showUpTime = 0L;
    } else {
      ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
    }
    localRecentUserProxy.b((RecentUser)localObject);
    localObject = this.app.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1009);
    }
    ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reportSetTopOrCancelSetTop(i, paramString, bool ^ true);
    ((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).reportSetTopOrCancleSetTop(i, paramString, bool ^ true);
  }
  
  private void setShareActionSheetOnClickListener(com.tencent.mobileqq.widget.share.ShareActionSheet paramShareActionSheet, Activity paramActivity)
  {
    paramShareActionSheet.setItemClickListenerV2(new PublicAccountDetailActivityImpl.25(this, paramActivity));
  }
  
  @NotNull
  private String shareToFriends(ShareActionSheet.Detail paramDetail, String paramString1, int paramInt, String paramString2, BaseActivity paramBaseActivity)
  {
    com.tencent.biz.troopbar.ShareActionSheet.b(paramBaseActivity, paramDetail, paramInt, paramString2);
    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, paramString1, "Grp_tribe", "interest_data", "share_qq");
    return "01";
  }
  
  @NotNull
  private String shareToQZone(ShareActionSheet.Detail paramDetail, String paramString1, int paramInt, String paramString2, BaseActivity paramBaseActivity)
  {
    com.tencent.biz.troopbar.ShareActionSheet.a(paramBaseActivity, paramDetail, paramInt, paramString2);
    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, paramString1, "Grp_tribe", "interest_data", "share_qzone");
    return "02";
  }
  
  @NotNull
  private String shareToSpecifiedFriend(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet.Detail paramDetail, String paramString1, int paramInt, String paramString2, Activity paramActivity)
  {
    com.tencent.biz.troopbar.ShareActionSheet.a(paramActivity, paramDetail, paramInt, paramString2, paramActionSheetItem);
    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, paramString1, "Grp_tribe", "interest_data", "share_qq");
    return "01";
  }
  
  @NotNull
  private String shareToWX(int paramInt1, ShareActionSheet.Detail paramDetail, String paramString1, int paramInt2, String paramString2, BaseActivity paramBaseActivity)
  {
    com.tencent.biz.troopbar.ShareActionSheet.a(paramBaseActivity, paramDetail, paramInt2, paramString2, paramInt1);
    if (paramInt1 == 9)
    {
      paramDetail = "share_wechat";
      paramString2 = "03";
    }
    else
    {
      paramDetail = "share_circle";
      paramString2 = "04";
    }
    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, paramString1, "Grp_tribe", "interest_data", paramDetail);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", paramString1, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
    return paramString2;
  }
  
  private void toSettingFragment()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet toSettingFragment");
    }
    Object localObject = this.accountDetail;
    if (localObject == null) {
      return;
    }
    localObject = PublicAccountUtilImpl.getMessageSetting((PublicAccountDetailImpl)localObject);
    if (localObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.uin);
    localIntent.putExtra("name", this.accountDetail.name);
    localIntent.putExtra("push_type", (Serializable)localObject);
    PublicFragmentActivity.a(getActivity(), localIntent, AccountSettingFragment.class);
  }
  
  private void updateViewInMain()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mQQUiHandler.post(new PublicAccountDetailActivityImpl.16(this));
      return;
    }
    updateView();
  }
  
  protected void delayShowLoading(int paramInt)
  {
    this.followBtn.postDelayed(new PublicAccountDetailActivityImpl.2(this, paramInt), 500L);
  }
  
  void deleteAccount(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    if (paramPublicAccountDetailImpl == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "deleteAccount");
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    localEntityManager.remove(paramPublicAccountDetailImpl);
    localEntityManager.close();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 2) || (i == 3)) && (this.isDownCancel))
      {
        this.isDownCancel = false;
        return true;
      }
    }
    else if (this.needUpdateView)
    {
      this.isDownCancel = true;
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void displayToast(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  public void doOnBackPressed()
  {
    int i;
    if (this.mProfileParams != null) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = this.mShouldNotStayAtThisApp;
    if ((i != 0) && (bool)) {
      moveTaskToBack(true);
    } else if ((i != 0) && ((bool ^ true)) && (super.isTaskRoot())) {
      super.startActivity(new Intent(this, SplashActivity.class));
    }
    if (!isFollowed()) {
      reportEventIfFromOtherApp("0X8005B6E");
    }
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("has_operation", isFollowed());
      ((Intent)localObject).putExtra("uin", this.uin);
      setResult(-1, (Intent)localObject);
    }
    Object localObject = this.mAccountDetailAdapter;
    if ((localObject != null) && (((AccountDetailBaseAdapter)localObject).k() != null)) {
      this.mAccountDetailAdapter.k().b();
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.enterTime = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    this.mQQUiHandler = new MqqHandler(Looper.getMainLooper());
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.mTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.mTopGestureLayout);
    }
    this.mIntent = getIntent();
    init(this.mIntent);
    if (this.uin != null)
    {
      if ((getClass().equals(PublicAccountDetailActivityImpl.class)) && ((CrmUtils.b(this.app, this.uin)) || (QidianManager.a(this.app, this.uin))))
      {
        paramBundle = this.mIntent;
        CrmUtils.a(this, paramBundle, paramBundle.getStringExtra("uin"), this.mIntent.getBooleanExtra("need_finish", false), this.mIntent.getIntExtra("source", -1), true, -1);
        finish();
        return true;
      }
      initData();
    }
    reportSource2(this.mIntent);
    this.fromJS = this.mIntent.getBooleanExtra("from_js", false);
    if (this.fromJS)
    {
      gotoMoreInfoActivity();
      finish();
    }
    setDatongParam();
    this.publicAccountObserver = new PublicAccountObserverImpl();
    this.publicAccountObserver.setOnCallback(new PublicAccountDetailActivityImpl.1(this));
    super.addObserver(this.publicAccountObserver);
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setKeepOldPublicAccountData(true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.publicAccountObserver);
    super.removeObserver(this.newFollowObserver);
    super.removeObserver(this.newUnFollowObserver);
    super.removeObserver(this.mFaceObserver);
    this.leaveTime = System.currentTimeMillis();
    long l = (this.leaveTime - this.enterTime) / 1000L;
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1 = this.uin;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("");
    String str2 = ((StringBuilder)localObject).toString();
    if (isFollowed()) {
      localObject = "02";
    } else {
      localObject = "01";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X8007800", "0X8007800", 0, 0, str2, "", (String)localObject, String.valueOf(PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), false);
    localObject = this.mAccountDetailAdapter;
    if ((localObject != null) && (((AccountDetailBaseAdapter)localObject).k() != null)) {
      this.mAccountDetailAdapter.k().b();
    }
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setKeepOldPublicAccountData(false);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.bigFace = null;
    this.mIntent = paramIntent;
    init(this.mIntent);
    if (this.uin != null) {
      initData();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.mShouldNotStayAtThisApp = false;
    Object localObject = this.mProgress;
    if (localObject != null) {
      ((QQProgressDialog)localObject).dismiss();
    }
    this.mProgress = null;
    localObject = this.mAccountDetailAdapter;
    if ((localObject != null) && (((AccountDetailBaseAdapter)localObject).k() != null)) {
      this.mAccountDetailAdapter.k().a();
    }
    AbstractGifImage.pauseAll();
  }
  
  void firstFetch()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "firstFetch");
    }
    sendDetailInfoRequest();
    updateViewInMain();
  }
  
  protected void follow()
  {
    PAStartupTracker.a(null, "pubAcc_follow_confirm", this.uin);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("follow uin=");
      ((StringBuilder)localObject).append(this.uin);
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.needUpdateView = true;
    this.followBtn.postDelayed(new PublicAccountDetailActivityImpl.7(this), 3000L);
    delayShowLoading(2131892923);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag) == -4)
    {
      this.followIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
      this.followIntent.putExtra("cmd", "follow");
      localObject = new mobileqq_mp.FollowRequest();
      ((mobileqq_mp.FollowRequest)localObject).ext.set("1");
      ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.uin));
      ((mobileqq_mp.FollowRequest)localObject).account_type.set(getAccountType());
      this.followIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
      this.followIntent.putExtra("source", 1);
      this.followObserver = new PublicAccountDetailActivityImpl.8(this);
      this.followIntent.setObserver(this.followObserver);
      this.app.startServlet(this.followIntent);
    }
    else
    {
      this.isClickingWSFollow = true;
      this.app.removeObserver(this.newFollowObserver);
      this.newFollowObserver = new NewPublicAccountObserver(new PublicAccountDetailActivityImpl.9(this));
      this.app.addObserver(this.newFollowObserver);
      PublicAccountStateReporter.a(this.app, true, this.accountDetail.uin, 1);
    }
    this.waitingCount += 1;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.app, this.uin, 1);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "follow exit");
    }
  }
  
  protected String getAccountName()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl != null) {
      return localPublicAccountDetailImpl.name;
    }
    return "";
  }
  
  protected int getAccountType()
  {
    return 1;
  }
  
  public int[] getAccurateScreenDpi()
  {
    int[] arrayOfInt = new int[2];
    Display localDisplay = getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { localDisplayMetrics });
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt;
  }
  
  public String getArticleId(String paramString)
  {
    if (paramString != null) {}
    try
    {
      int i = paramString.indexOf("article_id=");
      if (i > 0)
      {
        String str = paramString.substring(i + 11);
        i = str.indexOf("&");
        paramString = str;
        if (i >= 0) {
          paramString = str.substring(0, i);
        }
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      label48:
      break label48;
    }
    return "";
  }
  
  Drawable getBackgroundForMainPanel()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl == null) {
      return null;
    }
    if (!TextUtils.isEmpty(localPublicAccountDetailImpl.configBackgroundImg)) {
      return URLDrawable.getDrawable(this.accountDetail.configBackgroundImg);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.19(this), 10L);
    return null;
  }
  
  protected int getCertifiedGrade()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl != null) {
      return localPublicAccountDetailImpl.certifiedGrade;
    }
    return 0;
  }
  
  public int getContainerListviewHeight()
  {
    return this.screenHeight - this.titleHeight - this.bottomHeight - 1;
  }
  
  protected Drawable getFace()
  {
    Object localObject = this.bigFace;
    if (localObject != null) {
      return localObject;
    }
    localObject = new File(FaceUtil.b(this.uin));
    if (((File)localObject).isFile())
    {
      loadHDFace(((File)localObject).getAbsolutePath());
      return FaceDrawable.getFaceDrawable(this.app, 115, this.uin);
    }
    localObject = FaceDrawable.getFaceDrawable(this.app, 115, this.uin);
    if (this.mFaceObserver == null)
    {
      this.mFaceObserver = new PublicAccountDetailActivityImpl.AvatarObserver(this);
      addObserver(this.mFaceObserver);
    }
    return localObject;
  }
  
  Drawable getGaussianBlurPic(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      paramBitmap = getMidBitmap(paramBitmap);
      StackBlur.a(paramBitmap, 1);
      paramBitmap = new BitmapDrawable(paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  Drawable getImageForMainPanel()
  {
    Object localObject = this.accountDetail;
    if (localObject == null) {
      return null;
    }
    if (TextUtils.isEmpty(((PublicAccountDetailImpl)localObject).configBackgroundColor)) {
      this.accountDetail.configBackgroundColor = "3d7fe3";
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#E6");
      ((StringBuilder)localObject).append(this.accountDetail.configBackgroundColor.substring(0, 6));
      localObject = new ColorDrawable(Color.parseColor(((StringBuilder)localObject).toString()));
      return localObject;
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
    {
      label82:
      break label82;
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "configBackgroundColor length is not 6!");
    }
    return null;
  }
  
  public JSONObject getMessageList(BaseActivity paramBaseActivity, String paramString)
  {
    try
    {
      localObject1 = paramBaseActivity.app.getMessageFacade().a(paramString, 0, new int[] { -1000, -2000, -2002, -2011, -2022 }, 40);
      paramBaseActivity = new ArrayList();
      if (localObject1 == null) {
        break label126;
      }
      i = ((List)localObject1).size();
    }
    catch (Exception paramBaseActivity)
    {
      for (;;)
      {
        Object localObject1;
        int j;
        label126:
        JSONArray localJSONArray;
        JSONObject localJSONObject1;
        JSONObject localJSONObject2;
        Object localObject2;
        Object localObject4;
        Object localObject3;
        continue;
        label773:
        i -= 1;
        continue;
        label780:
        int i = 0;
      }
    }
    if (i > 0)
    {
      j = i - 1;
      if (((MessageRecord)((List)localObject1).get(j)).issend != 0) {
        break label773;
      }
      paramBaseActivity.add(((List)localObject1).get(j));
      if (paramBaseActivity.size() <= 4) {
        break label773;
      }
    }
    localObject1 = new JSONObject();
    localJSONArray = new JSONArray();
    localJSONObject1 = new JSONObject();
    localJSONObject2 = new JSONObject();
    localObject2 = this.app.getAccount();
    localJSONObject2.put("qq", localObject2);
    localObject4 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
    localObject3 = String.valueOf(NetConnInfoCenter.getServerTime());
    localJSONObject2.put("skey", localObject4);
    localJSONObject2.put("mpUin", paramString);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("");
    ((StringBuilder)localObject4).append((String)localObject3);
    localJSONObject2.put("timestamp", ((StringBuilder)localObject4).toString());
    localJSONObject2.put("scene", "201");
    localJSONObject2.put("subAppname", "profile");
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append(201);
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append("jubao@article@123");
    localJSONObject2.put("sign", MD5Utils.encodeHexStr(((StringBuilder)localObject4).toString()).toLowerCase());
    j = 0;
    for (;;)
    {
      i = paramBaseActivity.size();
      if (j >= i) {
        break;
      }
      paramString = new JSONObject();
      localObject2 = new JSONObject();
      localObject3 = (MessageRecord)paramBaseActivity.get(j);
      boolean bool = localObject3 instanceof MessageForText;
      if (bool)
      {
        ((JSONObject)localObject2).put("text", ((MessageRecord)localObject3).msg);
        i = 1;
      }
      else
      {
        bool = localObject3 instanceof MessageForPic;
        if (bool)
        {
          ((JSONObject)localObject2).put("fileUuid", ((MessageForPic)localObject3).uuid);
          i = 2;
        }
        else if ((localObject3 instanceof MessageForPtt))
        {
          ((JSONObject)localObject2).put("fileUuid", ((MessageForPtt)localObject3).urlAtServer);
          ((JSONObject)localObject2).put("fileType", ((MessageForPtt)localObject3).busiType);
          i = 3;
        }
        else if ((localObject3 instanceof MessageForShortVideo))
        {
          ((JSONObject)localObject2).put("fileUuid", ((MessageForShortVideo)localObject3).uuid.substring(1));
          i = 4;
        }
        else
        {
          if (!(localObject3 instanceof MessageForStructing)) {
            break label780;
          }
          ((JSONObject)localObject2).put("text", new String(StructMsgUtils.a(QfavUtil.a(StructMsgFactory.a(((MessageRecord)localObject3).msgData).getXmlBytes()), 0), "utf-8"));
          i = 5;
        }
      }
      paramString.put("content", localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i);
      paramString.put("messageType", ((StringBuilder)localObject2).toString());
      localJSONArray.put(j, paramString);
      j += 1;
    }
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(paramBaseActivity.size());
    ((JSONObject)localObject1).put("msgNum", paramString.toString());
    ((JSONObject)localObject1).put("messageList", Base64Util.encodeToString(localJSONArray.toString().getBytes("utf-8"), 0));
    localJSONObject1.put("Verify", localJSONObject2);
    localJSONObject1.put("reportData", localObject1);
    return localJSONObject1;
    return null;
  }
  
  Bitmap getMidBitmap(Bitmap paramBitmap)
  {
    int i = getWindowManager().getDefaultDisplay().getWidth();
    int n = (int)(this.density * 140.0F);
    int k = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    int i1 = j * n;
    int i2 = k * i;
    int m = 0;
    if (i1 > i2)
    {
      i = i2 / n;
      n = (j - i) / 2;
      j = i;
      i = n;
    }
    else
    {
      i = i1 / i;
      m = (k - i) / 2;
      n = 0;
      k = i;
      i = n;
    }
    return Bitmap.createBitmap(paramBitmap, i, m, j, k);
  }
  
  public PublicAccountObserverImpl getPublicAccountObserver()
  {
    return this.publicAccountObserver;
  }
  
  public int getScreenHeight()
  {
    return this.screenHeight;
  }
  
  protected ShareActionSheet.Detail getShareDetail()
  {
    Object localObject = this.accountDetail;
    if (localObject != null)
    {
      localObject = new ShareActionSheet.Detail(((PublicAccountDetailImpl)localObject).uin, this.accountDetail.name, this.accountDetail.summary);
      ((ShareActionSheet.Detail)localObject).f = ShareActionSheet.Detail.b;
      ((ShareActionSheet.Detail)localObject).g = isFollowed();
      ((ShareActionSheet.Detail)localObject).h = PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail);
      return localObject;
    }
    return null;
  }
  
  public String getShareUrl()
  {
    if (this.shareUrl == null)
    {
      int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag);
      StringBuilder localStringBuilder;
      if ((i != -2) && (i != -5))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=");
        localStringBuilder.append(this.uin);
        this.shareUrl = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://share.mp.qq.com/cgi/share.php?uin=");
        localStringBuilder.append(this.uin);
        localStringBuilder.append("&account_flag=");
        localStringBuilder.append(this.accountDetail.accountFlag);
        localStringBuilder.append("&jumptype=1&card_type=public_account");
        this.shareUrl = localStringBuilder.toString();
      }
    }
    return this.shareUrl;
  }
  
  String getUin(Intent paramIntent)
  {
    if (paramIntent != null) {
      return paramIntent.getStringExtra("uin");
    }
    paramIntent = this.mProfileParams;
    if (paramIntent != null) {
      return paramIntent.d().b;
    }
    return null;
  }
  
  protected void gotoChatActivity()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl != null) {
      open(this.uin, 1008, localPublicAccountDetailImpl.name, ChatActivity.class);
    }
  }
  
  public void gotoMoreInfoActivity()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet gotoMoreInfoActivity");
    }
    Intent localIntent = new Intent(getActivity(), PubAccountMoreInfoActivity.class);
    localIntent.putExtra("uin", this.uin);
    startActivity(localIntent);
  }
  
  protected void gotoQQGameActivity()
  {
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(this, 0);
  }
  
  protected void gotoWeiShiFlowActivity()
  {
    if (this.mSource == 119)
    {
      doOnBackPressed();
      return;
    }
    ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(this, "from_account_detail", true);
  }
  
  void init(Intent paramIntent)
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    Object localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      localObject = (ProfileParams)((Bundle)localObject).getParcelable("profile_params");
      if (localObject != null) {
        this.mProfileParams = ((ProfileParams)localObject);
      }
    }
    this.uin = getUin(paramIntent);
    this.isUseStyleAfter839 = this.mIntent.getBooleanExtra("is_use_style_839", true);
    this.sopType = paramIntent.getStringExtra("report_src_param_type");
    this.sopName = paramIntent.getStringExtra("report_src_param_name");
    this.weatherShareUrl = paramIntent.getStringExtra("weather_share_url");
    this.weatherOutsideFollowState = paramIntent.getIntExtra("weather_outside_follow_state", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[sopType]:");
      ((StringBuilder)localObject).append(this.sopType);
      ((StringBuilder)localObject).append(",[sopName]:");
      ((StringBuilder)localObject).append(this.sopName);
      ((StringBuilder)localObject).append(",[weatherShareUrl]:");
      ((StringBuilder)localObject).append(this.weatherShareUrl);
      ((StringBuilder)localObject).append(",[weatherOutsideFollowState]:");
      ((StringBuilder)localObject).append(this.weatherOutsideFollowState);
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.mSendMessage = paramIntent.getStringExtra("extvalue");
    this.mTypeMessage = paramIntent.getStringExtra("exttype");
    if (!TextUtils.isEmpty(this.mSendMessage)) {
      if ("2".equals(this.mTypeMessage)) {
        this.mIsSendMessage = true;
      } else if ("1".equals(this.mTypeMessage)) {
        this.mIsReportMessage = true;
      }
    }
    if (this.uin != null)
    {
      localObject = this.app;
      if (localObject == null) {
        return;
      }
      this.cuin = ((QQAppInterface)localObject).getCurrentUin();
      this.publicAccountHandler = ((PublicAccountHandlerImpl)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      initView();
      updateHDFace();
      reportSource(paramIntent);
      this.mDensity = getResources().getDisplayMetrics().density;
    }
  }
  
  @TargetApi(9)
  protected void initAccountDetailListView()
  {
    this.mAccountDetailListView = ((AccountDetailXListView)super.findViewById(2131427418));
    this.screenHeight = getWindowManager().getDefaultDisplay().getHeight();
    if (Build.VERSION.SDK_INT >= 9) {
      this.mAccountDetailListView.setOverScrollMode(2);
    }
    this.mAccountDetailListView.setDividerHeight(0);
    this.mAccountDetailListView.setRefreshCallback(this);
    updateListView();
  }
  
  void initBottomContainer()
  {
    this.bottomContainer = super.findViewById(2131427477);
    this.bottomContainer.setVisibility(8);
    this.bottomHeight = this.bottomContainer.getLayoutParams().height;
    this.btnsDivider1 = super.findViewById(2131427434);
    this.callBtn = super.findViewById(2131430247);
    this.btnsDivider1.setVisibility(8);
    this.callBtn.setVisibility(8);
    this.followBtn = super.findViewById(2131433514);
    this.followBtn.setVisibility(8);
    this.btnsDivider2 = super.findViewById(2131427435);
    this.btnsDivider2.setVisibility(8);
    super.setTitle(2131892915);
    this.mProgress = new QQProgressDialog(this, super.getTitleBarHeight());
    this.mProgress.setCanceledOnTouchOutside(true);
    this.searchBtn = ((Button)super.findViewById(2131445409));
    this.searchBtn.setOnClickListener(this);
    this.sendMsgBtn = ((Button)super.findViewById(2131445604));
    this.sendMsgBtn.setText(2131891193);
    this.sendMsgBtn.setOnClickListener(this);
    this.sendMsgBtn.setVisibility(8);
    this.unfollowBtn = ((Button)super.findViewById(2131449080));
    this.unfollowBtn.setText(2131891194);
    this.unfollowBtn.setOnClickListener(this);
    this.unfollowBtn.setVisibility(8);
    this.btnsDivider3 = super.findViewById(2131427436);
    this.btnsDivider3.setVisibility(8);
  }
  
  void initData()
  {
    if (loadCache())
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "initData hasCache");
      }
      this.isFirst = false;
      updateViewInMain();
      sendDetailInfoRequest();
      return;
    }
    ThreadManager.getSubThreadHandler().post(new PublicAccountDetailActivityImpl.12(this));
  }
  
  void initTitleView()
  {
    this.titleViewLayout = ((RelativeLayout)super.findViewById(2131437168));
    this.titleViewLayout.setOnClickListener(null);
    float f1;
    float f2;
    if (isNoTransparentTitleBar())
    {
      f1 = 64.0F;
      f2 = this.density;
    }
    else
    {
      f1 = 75.0F;
      f2 = this.density;
    }
    int i = (int)(f2 * f1);
    Object localObject = new RelativeLayout.LayoutParams(-1, i);
    this.titleViewLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.titleViewLayout.setPadding(0, 0, 0, 0);
    this.titleHeight = i;
    localObject = this.mTopGestureLayout;
    if (localObject != null) {
      ((AccountDetailTopGestureLayout)localObject).setTitleHeight(this.titleHeight);
    }
    this.titleLeftIcon = ((ImageView)super.findViewById(2131437167));
    this.titleLeftIcon.setOnClickListener(this);
    this.rightViewText = ((TextView)super.findViewById(2131436211));
    this.rightViewText.setText("");
    this.rightViewImg = ((ImageView)super.findViewById(2131436194));
    this.rightViewImg.setImageResource(2130844816);
    this.rightViewImg.setContentDescription(getString(2131895296));
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setOnClickListener(this);
    this.iconTop = ((ImageView)super.findViewById(2131435263));
    this.iconCicleTop = ((ImageView)super.findViewById(2131435233));
    this.iconCertifiedTop = ((ImageView)super.findViewById(2131430461));
    this.topFollowed = ((Button)super.findViewById(2131427451));
    this.topFollowed.setOnClickListener(this);
    updateTitleStyle();
  }
  
  void initView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "initView");
    }
    super.setContentView(2131623965);
    this.density = super.getResources().getDisplayMetrics().density;
    View localView = super.findViewById(2131427446);
    if (this.isUseStyleAfter839) {
      localView.setBackgroundColor(-657926);
    } else {
      localView.setBackgroundColor(-1);
    }
    initTitleView();
    initBottomContainer();
    initAccountDetailListView();
    this.mask = super.findViewById(2131442126);
    if (QQTheme.isNowThemeIsNight())
    {
      localView = this.mask;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.mask;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    this.errorContainer = ((LinearLayout)super.findViewById(2131432591));
    this.detailRootView = ((ViewGroup)findViewById(2131427450));
    this.accountMoreDetailController = new AccountMoreDetailController(this, this, this.detailRootView);
  }
  
  protected boolean isFollowed()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    int i;
    if (localPublicAccountDetailImpl != null) {
      i = localPublicAccountDetailImpl.followType;
    } else {
      i = -1;
    }
    return i == 1;
  }
  
  protected void jumpWebView(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this, PublicAccountBrowserImpl.class);
    if ((this.app != null) && (!TextUtils.isEmpty(this.uin)))
    {
      if (TextUtils.isEmpty(this.app.getAccount())) {
        return;
      }
      paramString = paramString.replace("${puin}", this.uin).replace("${uin}", this.app.getAccount());
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("url", paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jumpWebView url=");
        localStringBuilder.append(paramString);
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, localStringBuilder.toString());
      }
      localIntent.putExtra("puin", this.uin);
      localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.uin));
      paramString = getAccountName();
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("source_name", paramString);
      }
      super.startActivity(localIntent);
    }
  }
  
  protected boolean loadCache()
  {
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localIPublicAccountDataManager != null)
    {
      this.accountDetail = ((PublicAccountDetailImpl)localIPublicAccountDataManager.findAccountDetailInfoCache(this.uin));
      updateViewInMain();
    }
    if (this.accountDetail == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "loadCache = null");
      }
      return false;
    }
    parseAccountDetail();
    return true;
  }
  
  protected boolean loadDatabase()
  {
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localIPublicAccountDataManager != null)
    {
      this.accountDetail = ((PublicAccountDetailImpl)localIPublicAccountDataManager.findAccountDetailInfo(this.uin));
      updateViewInMain();
    }
    if (this.accountDetail == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "loadDatabase = null");
      }
      return false;
    }
    parseAccountDetail();
    return true;
  }
  
  void loadHDFace(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateCurrentImage currentImage is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCurrentImage uin=");
      localStringBuilder.append(paramProfileImageInfo.g);
      localStringBuilder.append(", state=");
      localStringBuilder.append(paramProfileImageInfo.d);
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, localStringBuilder.toString());
    }
    if (paramProfileImageInfo.d == 6) {
      loadHDFace(paramProfileImageInfo.c);
    }
  }
  
  void loadHDFace(String paramString)
  {
    if (!this.hdFaceLoaded)
    {
      if (this.bigFace != null) {
        return;
      }
      this.hdFaceLoaded = true;
      ThreadManager.getSubThreadHandler().post(new PublicAccountDetailActivityImpl.28(this, paramString));
    }
  }
  
  protected boolean needShowQQCall()
  {
    return false;
  }
  
  protected boolean needShowUnFollowBtnInActionSheet()
  {
    return (isFollowed()) && (this.accountDetail.isShowFollowButton);
  }
  
  protected boolean onBackEvent()
  {
    if (this.detailRootView.getVisibility() != 8)
    {
      this.detailRootView.setVisibility(8);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.searchBtn)
    {
      startSearchActivity();
      return;
    }
    if (paramView != this.followBtn)
    {
      localObject = this.mAccountDetailAdapter;
      if (((localObject == null) || (paramView != ((AccountDetailBaseAdapter)localObject).E) || (isFollowed())) && ((paramView != this.topFollowed) || (isFollowed())))
      {
        if (paramView == this.sendMsgBtn)
        {
          int j = getIntent().getIntExtra("source", 0);
          paramView = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
          int i;
          if ((paramView.isWeatherPA(this.uin)) && (paramView.startNewWeatherWebPageActivity(this, this.app))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isWeiShiAccount(this.uin))
            {
              gotoWeiShiFlowActivity();
            }
            else if (AppConstants.TIM_TEAM_UIN.equals(this.uin))
            {
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).enterTimTeam(this, this.app);
            }
            else if (j == 120)
            {
              doOnBackPressed();
            }
            else if (TextUtils.equals(AppConstants.KANDIAN_DAILY_UIN, this.uin))
            {
              ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).launchKandianDaily(this, true, null, 5);
              if (AppConstants.KANDIAN_DAILY_UIN.equals(this.uin)) {
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009945", "0X8009945", 0, 0, "", "", "", "", false);
              }
            }
            else if ((TextUtils.equals("2747277822", this.uin)) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
            {
              if ((getIntent() != null) && (getIntent().getBooleanExtra("fromQGamePub", false))) {
                doOnBackPressed();
              } else {
                gotoQQGameActivity();
              }
            }
            else if (TextUtils.equals(NowQQLiveConstant.a, this.uin))
            {
              if (!NowQQLiveHelper.a(this, this.uin, 2)) {
                gotoChatActivity();
              }
            }
            else if (TextUtils.equals("3046055438", this.uin))
            {
              if (this.mSource == 5) {
                doOnBackPressed();
              } else {
                ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).jump(this);
              }
            }
            else if (TextUtils.equals("2909288299", this.uin))
            {
              if ((getIntent() != null) && (getIntent().getBooleanExtra("fromQQNewsPubNew", false))) {
                doOnBackPressed();
              } else {
                gotoChatActivity();
              }
            }
            else if (((IMiniAppService)QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(this.uin))
            {
              if ((getIntent() != null) && (getIntent().getBooleanExtra("fromMiniGamePub", false))) {
                doOnBackPressed();
              } else {
                gotoMiniGamePublicAccountActivity();
              }
            }
            else if ((TextUtils.equals(AppConstants.QQ_VIP_UIN, this.uin)) && (QQVipHelper.d(getApplicationContext())))
            {
              QQVipHelper.b(getApplicationContext());
            }
            else if (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isNeedRedirectAIOToMainPage(this.uin))
            {
              if (!((IQQHealthService)this.app.getRuntimeService(IQQHealthService.class, "multi")).redirectAIOToMainPage(this, 162)) {
                gotoChatActivity();
              }
            }
            else
            {
              gotoChatActivity();
            }
          }
          paramView = this.app;
          localObject = this.uin;
          ReportController.b(paramView, "P_CliOper", "Pb_account_lifeservice", (String)localObject, "0X8004E44", "0X8004E44", 0, 0, (String)localObject, "", "", "");
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A26", "0X8005A26", 0, 0, "", "", "", "", false);
          OfficialAccountReporter.a.h(this.uin);
          return;
        }
        if (paramView == this.callBtn)
        {
          CrmUtils.a(this.app, this, getAccountName(), this.uin, "IvrEnterpriseDetailEngineFalse");
          ReportController.b(this.app, "CliOper", "", "", "0X8004653", "0X8004653", 0, 0, "", "", "", "");
          return;
        }
        if (paramView == this.titleLeftIcon)
        {
          doOnBackPressed();
          return;
        }
        if ((paramView != this.rightViewImg) && ((paramView == null) || (paramView.getId() != 2131436194)))
        {
          if (paramView == this.unfollowBtn)
          {
            showUnFollowActionSheet();
            OfficialAccountReporter.a.e(this.uin);
            return;
          }
          if ((paramView != null) && (paramView.getId() == 2131446629))
          {
            this.detailRootView.setVisibility(0);
            this.accountMoreDetailController.a(this.accountDetail);
            OfficialAccountReporter.a.f(this.uin);
            return;
          }
          if ((paramView == null) || (paramView.getId() != 2131435062)) {
            return;
          }
          paramView = PublicAccountUtilImpl.getMessageHistoryInfo(this.accountDetail);
          if (paramView == null) {
            return;
          }
          jumpWebView(paramView.h);
          return;
        }
        if (this.isSubscriptAccount) {
          showActionSheetSub();
        } else {
          showActionSheet();
        }
        localObject = this.app;
        str = this.uin;
        if (isFollowed()) {
          paramView = "02";
        } else {
          paramView = "01";
        }
        ReportController.b((AppRuntime)localObject, "dc01160", "Pb_account_lifeservice", str, "0X8007CA5", "0X8007CA5", 0, 0, paramView, String.valueOf(PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "", "");
        OfficialAccountReporter.a.g(this.uin);
        return;
      }
    }
    reportEventIfFromOtherApp("0X8005B6D");
    this.mIsChangedFromOutSide = false;
    follow();
    setFollowStatus();
    this.followBtn.setEnabled(false);
    this.followBtn.postDelayed(new PublicAccountDetailActivityImpl.24(this), 1000L);
    if (ServiceAccountFolderManager.c(this.app, this.uin)) {
      ((EcshopReportHandler)this.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134243868, this.uin, null, null, null, 1L, false);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A25", "0X8005A25", this.fromwhere, 0, "", "", "", "", false);
    ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrSearchAttention(4, this.uin, 0, UniteSearchActivity.f, PAOfflineSearchManager.a().a(this.uin));
    Object localObject = this.app;
    String str = this.uin;
    if (isFollowed()) {
      paramView = "02";
    } else {
      paramView = "01";
    }
    ReportController.b((AppRuntime)localObject, "dc01160", "Pb_account_lifeservice", str, "0X8007CA1", "0X8007CA1", 0, 0, paramView, String.valueOf(this.fromwhere), String.valueOf(PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "");
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.uin))
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("channel_id", ((IKanDianDailyReportUtils)QRoute.api(IKanDianDailyReportUtils.class)).getChannelId());
      }
      catch (Exception localException)
      {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, localException.getMessage());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009946", "0X8009946", 0, 0, "", "", "", paramView.toString(), false);
    }
    OfficialAccountReporter.a.d(this.uin);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.isDestroy = true;
    Object localObject = this.mProgress;
    if (localObject != null) {
      ((QQProgressDialog)localObject).dismiss();
    }
    this.mProgress = null;
    localObject = this.mFaceObserver;
    if (localObject != null)
    {
      this.app.removeObserver((com.tencent.mobileqq.app.BusinessObserver)localObject);
      this.mFaceObserver = null;
    }
    localObject = this.detailIntent;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    localObject = this.unfollowIntent;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    localObject = this.followIntent;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    localObject = this.model;
    if (localObject != null) {
      ((PublicAccountDetailActivityImpl.FriendAvatarWeakReference)localObject).b();
    }
    localObject = this.mShareAttentionSuccessDlg;
    if (localObject != null) {
      ((ShareAioResultDialog)localObject).dismiss();
    }
    localObject = this.mAccountDetailAdapter;
    if (localObject != null) {
      ((AccountDetailBaseAdapter)localObject).d();
    }
    localObject = this.mAccountDetailListView;
    if (localObject != null) {
      ((AccountDetailXListView)localObject).a();
    }
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (isInMultiWindow())
    {
      QQToast.makeText(this, getString(2131892957), 0).show();
      finish();
      return;
    }
    AccountDetailBaseAdapter localAccountDetailBaseAdapter = this.mAccountDetailAdapter;
    if ((localAccountDetailBaseAdapter != null) && (localAccountDetailBaseAdapter.k() != null)) {
      this.mAccountDetailAdapter.k().a(true);
    }
    AbstractGifImage.resumeAll();
    OfficialAccountReporter.a.c(this.uin);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      PAStartupTracker.a("pubAcc_profile_display", null, this.uin);
      this.isGetPanelHeight = true;
      return;
    }
    this.isGetPanelHeight = false;
  }
  
  protected void open(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass)
  {
    open(paramString1, paramInt, paramString2, paramClass, false);
  }
  
  protected void open(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass, boolean paramBoolean)
  {
    if ((TextUtils.equals("2290230341", paramString1)) && (((IQzoneMsgApi)QRoute.api(IQzoneMsgApi.class)).open(this, this.app))) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((getIntent().hasExtra("qidian_chat")) && (getIntent().getBooleanExtra("qidian_chat", false)))
    {
      localIntent.setComponent(new ComponentName(this, SplashActivity.class));
      localBundle.putBoolean("open_chatfragment", true);
    }
    else
    {
      localIntent.setComponent(new ComponentName(this, paramClass));
    }
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", paramInt);
    localBundle.putString("uinname", paramString2);
    localIntent.putExtras(localBundle);
    localIntent.setFlags(67108864);
    boolean bool = this.mIntent.getBooleanExtra("need_finish", false);
    if (this.mIsSendMessage)
    {
      localIntent.putExtra("forward_type", -1);
      localIntent.putExtra("forward_text", this.mSendMessage);
      this.mIsSendMessage = false;
    }
    if (bool) {
      super.finish();
    }
    localIntent.putExtra("isforceRequestDetail", paramBoolean);
    localIntent.putExtra("jump_from", 2);
    super.startActivity(localIntent);
  }
  
  protected void parseAccountDetail()
  {
    try
    {
      this.gAccountData = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      this.gAccountData.mergeFrom(this.accountDetail.accountData);
      this.accountDetail.newGroupInfoList = this.gAccountData.config_group_info_new.get();
      if (this.gAccountData.unified_account_descrpition.has())
      {
        this.accountDetail.unifiedDesrpition = this.gAccountData.unified_account_descrpition.get();
        this.accountDetail.parser();
        return;
      }
      this.accountDetail.seqno = 0;
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void removeLoading()
  {
    QQProgressDialog localQQProgressDialog = this.mProgress;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.mProgress.dismiss();
    }
  }
  
  void report()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet report");
    }
    ThreadManager.getSubThreadHandler().post(new PublicAccountDetailActivityImpl.11(this));
  }
  
  void reportEventIfFromOtherApp(String paramString)
  {
    int i;
    if (this.mProfileParams != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject2 = this.mProfileParams.e();
      Object localObject3 = this.mProfileParams.a();
      Object localObject4 = this.mProfileParams.b();
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = "";
      }
      localObject3 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject3 = "";
      }
      long l = System.currentTimeMillis();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append("app");
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append(l);
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", paramString, paramString, 0, 1, 0, ((StringBuilder)localObject4).toString(), "", "", "");
    }
  }
  
  protected void reportItemEvent(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A27", "0X8005A27", 0, 0, str, "", "", "", false);
  }
  
  void reportSource(Intent paramIntent)
  {
    this.isFromBrowser = paramIntent.getBooleanExtra("fromBrowser", false);
    this.mSource = paramIntent.getIntExtra("source", 0);
    int i = this.mSource;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 108)
              {
                if (i != 109)
                {
                  if (i != 111)
                  {
                    if (i != 112)
                    {
                      if (i != 114) {
                        switch (i)
                        {
                        default: 
                          break;
                        case 106: 
                          this.fromwhere = 6;
                          break;
                        case 105: 
                          this.fromwhere = 5;
                          break;
                        case 104: 
                          this.fromwhere = 4;
                          break;
                        }
                      } else {
                        this.fromwhere = 13;
                      }
                    }
                    else {
                      this.fromwhere = 50;
                    }
                  }
                  else {
                    this.fromwhere = 11;
                  }
                }
                else {
                  this.fromwhere = 9;
                }
              }
              else {
                this.fromwhere = 8;
              }
            }
            else {
              this.fromwhere = 1;
            }
          }
          else {
            this.fromwhere = 0;
          }
        }
        else {
          this.fromwhere = 12;
        }
      }
      else {
        this.fromwhere = 3;
      }
    }
    else {
      this.fromwhere = 2;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("[fromwhere]:");
      paramIntent.append(this.fromwhere);
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, paramIntent.toString());
    }
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A24", "0X8005A24", this.fromwhere, 0, "", "", "", "");
  }
  
  void reportSource2(Intent paramIntent)
  {
    if (!this.hasReport2)
    {
      if (this.accountDetail == null) {
        return;
      }
      this.hasReport2 = true;
      this.isFromBrowser = paramIntent.getBooleanExtra("fromBrowser", false);
      this.mSource = paramIntent.getIntExtra("source", 0);
      int i = this.mSource;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                if (i != 111)
                {
                  if (i != 114) {
                    switch (i)
                    {
                    default: 
                      break;
                    case 118: 
                      this.fromwhere = 21;
                      break;
                    case 117: 
                      this.fromwhere = 15;
                      break;
                    case 116: 
                      this.fromwhere = 17;
                      break;
                    }
                  } else {
                    this.fromwhere = 16;
                  }
                }
                else {
                  this.fromwhere = 18;
                }
              }
              else {
                this.fromwhere = 11;
              }
            }
            else {
              this.fromwhere = 14;
            }
          }
          else {
            this.fromwhere = 19;
          }
        }
        else {
          this.fromwhere = 13;
        }
      }
      else {
        this.fromwhere = 12;
      }
      if (this.isFromBrowser) {
        this.fromwhere = 20;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("[fromwhere]:");
        paramIntent.append(this.fromwhere);
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, paramIntent.toString());
      }
      QQAppInterface localQQAppInterface = this.app;
      String str = this.uin;
      i = this.fromwhere;
      if (isFollowed()) {
        paramIntent = "02";
      } else {
        paramIntent = "01";
      }
      ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X8007CA0", "0X8007CA0", i, 0, paramIntent, String.valueOf(this.fromwhere), String.valueOf(PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  protected List<IPublicAccountConfigAttr.PaConfigInfo> resetConfigInfoListForUnfollow(List<IPublicAccountConfigAttr.PaConfigInfo> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(2);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)paramList.get(i);
      if ((localPaConfigInfo.a == 3) && ((localPaConfigInfo.e == 7) || (localPaConfigInfo.e == 8))) {
        localArrayList.add(localPaConfigInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  void resetFootView()
  {
    if (this.mAccountDetailAdapter.N)
    {
      this.mAccountDetailListView.setAdapter(null);
      this.mAccountDetailListView.a(true);
      this.mAccountDetailListView.setAdapter(this.mAccountDetailAdapter);
    }
    this.mAccountDetailAdapter.N = false;
  }
  
  protected void saveAccountDetailInSubThread()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.13(this), 10L);
  }
  
  void saveAccountDetailToDBAndCache(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "saveAccountDetailToDBAndCache");
    }
    Object localObject = this.app.getEntityManagerFactory().createEntityManager();
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, paramPublicAccountDetailImpl.name);
      }
      this.accountDetail.clone(paramPublicAccountDetailImpl);
      if (!((EntityManager)localObject).update(this.accountDetail)) {
        ((EntityManager)localObject).drop(PublicAccountDetailImpl.class);
      }
    }
    else
    {
      this.accountDetail = paramPublicAccountDetailImpl;
      ((EntityManager)localObject).persist(paramPublicAccountDetailImpl);
    }
    ((EntityManager)localObject).close();
    localObject = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    if ((localObject != null) && (paramPublicAccountDetailImpl != null))
    {
      ((IPublicAccountDataManager)localObject).saveAccountDetailInfoCache(this.accountDetail);
      if (paramPublicAccountDetailImpl.followType == 1) {
        ((IPublicAccountDataManager)localObject).savePublicAccountInfo(PublicAccountInfo.createPublicAccount(paramPublicAccountDetailImpl, 0L));
      }
    }
    updateViewInMain();
  }
  
  protected void saveDetailForStateChange(int paramInt, boolean paramBoolean)
  {
    this.accountDetail.accountData = this.gAccountData.toByteArray();
    if (paramInt == 3)
    {
      PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
      localPublicAccountDetailImpl.isSyncLbs = true;
      localPublicAccountDetailImpl.isAgreeSyncLbs = paramBoolean;
    }
    saveAccountDetailInSubThread();
  }
  
  void send839PublicAccountDetailInfoRequest()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "send839PublicAccountDetailInfoRequest");
    }
    PublicAccountStQWebServletWrapper.getAccountDetail(Long.valueOf(Long.parseLong(this.uin)), "", new PublicAccountDetailActivityImpl.22(this));
  }
  
  protected void sendDetailInfoRequest()
  {
    sendPublicAccountDetailInfoRequest();
  }
  
  void sendPublicAccountDetailInfoRequest()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest");
    }
    Object localObject = this.detailIntent;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    this.detailIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
    this.detailIntent.putExtra("cmd", "get_detail_info");
    localObject = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).versionInfo.set("8.8.17,3,5770");
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).version.set(1);
    if (this.accountDetail != null) {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).seqno.set(this.accountDetail.seqno);
    } else {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).seqno.set(0);
    }
    try
    {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).uin.set((int)Long.parseLong(this.uin));
      label134:
      this.detailIntent.putExtra("data", ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).toByteArray());
      this.detailObserver = new PublicAccountDetailActivityImpl.23(this);
      this.detailIntent.setObserver(this.detailObserver);
      this.app.startServlet(this.detailIntent);
      this.waitingCount += 1;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception localException)
    {
      break label134;
    }
  }
  
  protected void setAccountData()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl != null) {
      localPublicAccountDetailImpl.accountData = this.gAccountData.toByteArray();
    }
  }
  
  protected void setFollowStatus()
  {
    if (isFollowed())
    {
      this.isShowGroupList = true;
      return;
    }
    this.isShowGroupList = false;
  }
  
  public void setHDFace()
  {
    if (TextUtils.isEmpty(this.uin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "setHDFace uin is null");
      }
      return;
    }
    if (this.mAccountDetailAdapter != null)
    {
      Drawable localDrawable = getFace();
      this.mAccountDetailAdapter.c(localDrawable);
      this.mAccountDetailAdapter.notifyDataSetChanged();
    }
  }
  
  void setInfoForAdapter()
  {
    this.mAccountDetailAdapter.a(getBackgroundForMainPanel());
    this.mAccountDetailAdapter.b(getImageForMainPanel());
    this.mAccountDetailAdapter.c(getFace());
    this.mAccountDetailAdapter.a(this.isSubscriptAccount);
    this.mAccountDetailAdapter.a(getContainerListviewHeight());
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl != null) {
      this.mAccountDetailAdapter.a(localPublicAccountDetailImpl);
    }
  }
  
  protected void setIsConfirmed(boolean paramBoolean)
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl != null) {
      localPublicAccountDetailImpl.isConfirmed = paramBoolean;
    }
  }
  
  protected void setShowMsgFlag(int paramInt)
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl != null) {
      localPublicAccountDetailImpl.mShowMsgFlag = paramInt;
    }
  }
  
  protected void share()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "share");
    }
    if (!TextUtils.isEmpty(this.uin))
    {
      if (this.accountDetail == null) {
        return;
      }
      showNewShareActionSheet();
      PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, this.uin, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
    }
  }
  
  protected void showActionSheet()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet showActionSheet");
    }
    PublicAccountDetailActivityImpl.ActionSheetBuilder localActionSheetBuilder = new PublicAccountDetailActivityImpl.ActionSheetBuilder(this, (ActionSheet)ActionSheetHelper.b(this, null));
    localActionSheetBuilder.a();
    localActionSheetBuilder.b();
    if ((!this.uin.equals("1770946116")) && (!CrmUtils.b(this.app, this.uin)))
    {
      if ((!ServiceAccountFolderManager.b(this.app, this.uin)) && (!ServiceAccountFolderManager.c(this.app, this.uin)))
      {
        if (ServiceAccountFolderManager.a(this.app, this.uin))
        {
          localActionSheetBuilder.d();
          localActionSheetBuilder.e();
        }
        else
        {
          localActionSheetBuilder.c();
          localActionSheetBuilder.e();
        }
      }
      else {
        localActionSheetBuilder.e();
      }
    }
    else {
      localActionSheetBuilder.c();
    }
    localActionSheetBuilder.f();
    this.actionSheet = localActionSheetBuilder.g();
    if (!this.actionSheet.isShowing()) {
      this.actionSheet.show();
    }
  }
  
  protected void showActionSheetSub()
  {
    ShareActionSheetBuilder localShareActionSheetBuilder = this.mShareDialogBuilder;
    if (localShareActionSheetBuilder == null)
    {
      this.mShareDialogBuilder = new ShareActionSheetBuilder(this);
      this.mShareDialogBuilder.setActionSheetTitle(getString(2131916565));
      this.mShareDialogBuilder.setActionSheetItems(getActionSheetItems());
      this.mShareDialogBuilder.setItemClickListener(this.itemClickListener);
    }
    else
    {
      localShareActionSheetBuilder.setActionSheetItems(getActionSheetItems());
    }
    try
    {
      this.mShareDialogBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("ShareActionSheet", 2, localStringBuilder.toString());
      }
    }
  }
  
  void showAttentionSuccessDlg(Activity paramActivity)
  {
    if (this.mShareAttentionSuccessDlg == null) {
      this.mShareAttentionSuccessDlg = new ShareAioResultDialog(paramActivity);
    }
    this.mShareAttentionSuccessDlg.a(HardCodeUtil.a(2131898014));
    String str = this.app.getApplication().getString(2131916399);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(HardCodeUtil.a(2131898015));
    str = localStringBuilder.toString();
    paramActivity = new PublicAccountDetailActivityImpl.10(this, paramActivity);
    this.mShareAttentionSuccessDlg.a(str, paramActivity);
    this.mShareAttentionSuccessDlg.a(paramActivity);
    this.mShareAttentionSuccessDlg.show();
  }
  
  protected void showAttentionSuccessDlgIfJumpFromOtherApp()
  {
    int i;
    if (this.mProfileParams != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      showAttentionSuccessDlg(this);
    }
  }
  
  void showErrorTip()
  {
    this.searchBtn.setVisibility(0);
    this.errorContainer.setVisibility(0);
    this.titleViewLayout.setBackgroundColor(0);
    this.iconTop.setVisibility(8);
    this.iconCicleTop.setVisibility(8);
    this.mAccountDetailListView.setVisibility(8);
  }
  
  void showLoading(int paramInt)
  {
    QQProgressDialog localQQProgressDialog = this.mProgress;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.c(paramInt);
      if (!this.mProgress.isShowing()) {
        this.mProgress.show();
      }
    }
  }
  
  protected void showNewShareActionSheet()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet showNewShareActionSheet");
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = this;
    ((ShareActionSheetV2.Param)localObject).fullScreen = false;
    localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    ((com.tencent.mobileqq.widget.share.ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(getIntent());
    ((com.tencent.mobileqq.widget.share.ShareActionSheet)localObject).setActionSheetItems(getShareActionSheetPaths(), getShareActionSheetOperations());
    ((com.tencent.mobileqq.widget.share.ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
    setShareActionSheetOnClickListener((com.tencent.mobileqq.widget.share.ShareActionSheet)localObject, this);
    getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh");
    ((com.tencent.mobileqq.widget.share.ShareActionSheet)localObject).show();
    ((com.tencent.mobileqq.widget.share.ShareActionSheet)localObject).refresh();
  }
  
  protected void showPhoneConfirm(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131953338);
    localDialog.setContentView(2131627374);
    ((TextView)localDialog.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131431902);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131431900);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131431907);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131887648);
    localTextView3.setText(2131888562);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new PublicAccountDetailActivityImpl.26(this, localDialog));
    localTextView3.setOnClickListener(new PublicAccountDetailActivityImpl.27(this, paramString));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  void showUnFollowActionSheet()
  {
    this.unFollowActionSheet = ActionSheet.create(this);
    String str = getString(2131893008, new Object[] { getAccountName() });
    this.unFollowActionSheet.setMainTitle(str);
    this.unFollowActionSheet.addButton(2131894218, 3);
    this.unFollowActionSheet.addCancelButton(2131887648);
    this.unFollowActionSheet.setOnDismissListener(new PublicAccountDetailActivityImpl.14(this));
    this.unFollowActionSheet.setOnButtonClickListener(new PublicAccountDetailActivityImpl.15(this));
    if (!this.unFollowActionSheet.isShowing())
    {
      this.unFollowActionSheetHasClick = false;
      this.unFollowActionSheet.show();
    }
  }
  
  public void startLoadMore(ListView paramListView)
  {
    if (this.isFirstDataComplate)
    {
      if (QLog.isColorLevel())
      {
        paramListView = new StringBuilder();
        paramListView.append("startLoadMore: uin=");
        paramListView.append(this.uin);
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, paramListView.toString());
      }
      AccountDetailDynamicListModel.b(this.app, Long.parseLong(this.uin), this.publicAccountObserver);
    }
  }
  
  void startSearchActivity()
  {
    super.finish();
    PublicAccountSearchActivity.a(this, "");
  }
  
  public boolean tryGoToWeatherWhenFollow(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    if (paramPublicAccountDetailImpl == null) {
      return false;
    }
    if (this.weatherOutsideFollowState != 2) {
      return false;
    }
    IWeatherCommApi localIWeatherCommApi = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
    if ((!TextUtils.isEmpty(this.weatherShareUrl)) && (localIWeatherCommApi.isWeatherPA(this.uin)) && (paramPublicAccountDetailImpl.followType == 1))
    {
      paramPublicAccountDetailImpl = new StringBuilder();
      paramPublicAccountDetailImpl.append("handleIfWeatherShare");
      paramPublicAccountDetailImpl.append(this.weatherShareUrl);
      QLog.i("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, paramPublicAccountDetailImpl.toString());
      runOnUiThread(new PublicAccountDetailActivityImpl.31(this, localIWeatherCommApi));
      return true;
    }
    return false;
  }
  
  public boolean tryGoToWeatherWhenGetInfo(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    if (paramPublicAccountDetailImpl == null) {
      return false;
    }
    if (this.weatherOutsideFollowState != 3) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.weatherShareUrl)) && (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.uin)) && (paramPublicAccountDetailImpl.followType == 1))
    {
      paramPublicAccountDetailImpl = new StringBuilder();
      paramPublicAccountDetailImpl.append("handleIfWeatherShare");
      paramPublicAccountDetailImpl.append(this.weatherShareUrl);
      QLog.i("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, paramPublicAccountDetailImpl.toString());
      this.weatherOutsideFollowState = 1;
      runOnUiThread(new PublicAccountDetailActivityImpl.30(this));
      return true;
    }
    this.weatherOutsideFollowState = 2;
    return false;
  }
  
  void unfollow()
  {
    Object localObject;
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.uin))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("channel_id", ((IKanDianDailyReportUtils)QRoute.api(IKanDianDailyReportUtils.class)).getChannelId());
      }
      catch (Exception localException)
      {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, localException.getMessage());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009944", "0X8009944", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
    }
    PAStartupTracker.a(null, " pubAcc_follow_cancel", this.uin);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "unfollow");
    }
    delayShowLoading(2131893007);
    if ((this.accountDetail != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag) != -4))
    {
      localObject = this.newUnFollowObserver;
      if (localObject != null) {
        this.app.removeObserver((com.tencent.mobileqq.app.BusinessObserver)localObject);
      }
      this.newUnFollowObserver = new NewPublicAccountObserver(new PublicAccountDetailActivityImpl.5(this));
      this.app.addObserver(this.newUnFollowObserver);
      PublicAccountStateReporter.a(this.app, false, this.accountDetail.uin, 1);
      this.waitingCount += 1;
    }
    else
    {
      localObject = this.unfollowIntent;
      if (localObject != null) {
        ((NewIntent)localObject).setObserver(null);
      }
      this.unfollowIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
      this.unfollowIntent.putExtra("cmd", "unfollow");
      localObject = new mobileqq_mp.UnFollowRequest();
      ((mobileqq_mp.UnFollowRequest)localObject).uin.set((int)Long.parseLong(this.uin));
      ((mobileqq_mp.UnFollowRequest)localObject).account_type.set(getAccountType());
      this.unfollowIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject).toByteArray());
      this.unfollowIntent.putExtra("source", 1);
      this.unfollowObserver = new PublicAccountDetailActivityImpl.4(this);
      this.unfollowIntent.setObserver(this.unfollowObserver);
      this.app.startServlet(this.unfollowIntent);
      this.waitingCount += 1;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.app, this.uin);
    if (ServiceAccountFolderManager.c(this.app, this.uin))
    {
      int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, this.uin);
      RecentUtil.b(this.app, String.valueOf(this.uin), i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "unfollow exit");
    }
  }
  
  void updateBottomContainer()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.accountDetail;
    if (localPublicAccountDetailImpl != null)
    {
      if (this.isSubscriptAccount) {
        return;
      }
      boolean bool = localPublicAccountDetailImpl.isShowFollowButton;
      if (this.accountDetail.followType == 1)
      {
        if ((!this.uin.equals("1770946116")) && (!CrmUtils.b(this.app, this.uin)))
        {
          this.sendMsgBtn.setVisibility(0);
          this.followBtn.setVisibility(8);
          this.btnsDivider3.setVisibility(0);
          this.unfollowBtn.setVisibility(0);
          this.bottomContainer.setVisibility(0);
        }
        else
        {
          this.sendMsgBtn.setVisibility(0);
          this.followBtn.setVisibility(8);
          this.bottomContainer.setVisibility(0);
        }
      }
      else
      {
        if (bool)
        {
          this.followBtn.setVisibility(0);
          this.followBtn.setOnClickListener(this);
        }
        this.sendMsgBtn.setVisibility(8);
        this.btnsDivider3.setVisibility(8);
        this.unfollowBtn.setVisibility(8);
        this.bottomContainer.setVisibility(0);
      }
      if (needShowQQCall())
      {
        this.btnsDivider1.setVisibility(0);
        this.callBtn.setVisibility(0);
        this.callBtn.setOnClickListener(this);
      }
      else
      {
        this.btnsDivider1.setVisibility(8);
        this.callBtn.setVisibility(8);
      }
      if ((this.sendMsgBtn.getVisibility() == 8) && (this.followBtn.getVisibility() == 8)) {
        this.bottomContainer.setVisibility(8);
      }
    }
  }
  
  void updateDetailInfo(PublicAccountDetailImpl paramPublicAccountDetailImpl, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.21(this, paramPublicAccountDetailImpl, paramBoolean), 10L);
  }
  
  protected void updateFollowInfo()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.6(this), 10L);
  }
  
  protected void updateHDFace()
  {
    if (TextUtils.isEmpty(this.uin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateHDFace uin is null");
      }
      return;
    }
    if (!NetworkUtil.isWifiConnected(this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateHDFace not wifi, so need't update");
      }
      return;
    }
    this.model = new PublicAccountDetailActivityImpl.FriendAvatarWeakReference(this.app, this);
    this.model.a();
  }
  
  void updateListView()
  {
    if ((this.mAccountDetailAdapter != null) && (this.mAccountDetailListView.getAdapter() != null) && ((this.accountDetail == null) || (this.mAccountDetailAdapter.b() != null)))
    {
      setInfoForAdapter();
      this.mAccountDetailAdapter.notifyDataSetChanged();
      return;
    }
    if (this.mAccountDetailListView.getAdapter() != null)
    {
      ((AccountDetailBaseAdapter)this.mAccountDetailListView.getAdapter()).d();
      this.mAccountDetailListView.setAdapter(null);
    }
    this.mAccountDetailAdapter = new AccountDetailBaseAdapter(this.app, this, this.accountDetail, this.uin, this.isSubscriptAccount, this.mAccountDetailListView, this.mTopGestureLayout);
    this.mAccountDetailAdapter.a(this.iconTop, this.iconCicleTop, this.titleViewLayout, this.iconCertifiedTop, this.topFollowed);
    setInfoForAdapter();
    if (!this.isSubscriptAccount) {
      this.mAccountDetailListView.a(false);
    }
    this.mAccountDetailAdapter.a(new PublicAccountDetailActivityImpl.18(this));
    this.mAccountDetailListView.setAdapter(this.mAccountDetailAdapter);
  }
  
  void updateTitleStyle()
  {
    if (this.isUseStyleAfter839)
    {
      this.titleLeftIcon.setImageResource(2130852236);
      this.rightViewImg.setImageResource(2130843504);
      return;
    }
    this.titleLeftIcon.setImageResource(2130853298);
    this.rightViewImg.setImageResource(2130844816);
  }
  
  @TargetApi(16)
  void updateTopContainer()
  {
    if (this.accountDetail != null)
    {
      if (!this.isSubscriptAccount) {
        return;
      }
      if (isFollowed())
      {
        this.topFollowed.setBackgroundDrawable(null);
        this.topFollowed.setText(2131893004);
        this.topFollowed.setAlpha(0.5F);
        ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.17(this), 0L);
      }
    }
  }
  
  protected void updateUnfollowInfo()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.3(this), 10L);
  }
  
  protected void updateView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateView");
    }
    this.isUseStyleAfter839 = PublicAccountUtilImpl.isShopOrServiceAccount(this.accountDetail);
    boolean bool = this.isUseStyleAfter839;
    int j = 0;
    if (bool) {
      this.mActNeedImmersive = true;
    } else {
      this.mActNeedImmersive = false;
    }
    setImmersiveStatus();
    if (!this.mActNeedImmersive)
    {
      i = getResources().getColor(2131168092);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, i);
        if (QQTheme.isDefaultOrDIYTheme()) {
          this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130847834));
        } else {
          this.mSystemBarComp.setStatusDrawable(null);
        }
      }
    }
    this.isSubscriptAccount = isSubscriptAccount(this.accountDetail);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSubscriptAccount = ");
      ((StringBuilder)localObject).append(this.isSubscriptAccount);
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.isSubscriptAccount) && (!TextUtils.isEmpty(this.uin))) {
      AccountDetailDynamicListModel.a(this.app, Long.parseLong(this.uin), this.publicAccountObserver);
    }
    Object localObject = this.gAccountData;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((mobileqq_mp.GetPublicAccountDetailInfoResponse)localObject).show_flag.has())
      {
        i = j;
        if (this.gAccountData.show_flag.get() == 2) {
          i = 1;
        }
      }
    }
    updateTitleStyle();
    if (i != 0)
    {
      showErrorTip();
      return;
    }
    updateTopContainer();
    updateBottomContainer();
    updateListView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl
 * JD-Core Version:    0.7.0.1
 */