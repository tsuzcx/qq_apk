package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.tencent.biz.pubaccount.AccountDetail.activity.PubAccountMoreInfoActivity;
import com.tencent.biz.pubaccount.AccountDetail.activity.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView.RefreshCallback;
import com.tencent.biz.pubaccount.AccountMoreDetailController;
import com.tencent.biz.pubaccount.AccountSettingFragment;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountReportUtilsImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.JumpUtil;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
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
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vashealth.VSHealthUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.open.base.MD5Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqfav.QfavUtil;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
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
  AccountDetail accountDetail = null;
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
  protected BusinessObserver detailObserver;
  private ViewGroup detailRootView;
  long enterTime;
  LinearLayout errorContainer;
  protected int errorStatus = NETWORK_UNKNOW;
  protected View followBtn;
  protected NewIntent followIntent;
  protected BusinessObserver followObserver;
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
  protected PublicAccountHandler publicAccountHandler;
  final PublicAccountObserver publicAccountObserver = new PublicAccountDetailActivityImpl.1(this);
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
  BusinessObserver unfollowObserver;
  protected int waitingCount = 0;
  public int weatherOutsideFollowState;
  public String weatherShareUrl;
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] getActionSheetItems()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131696380);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839214;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 2;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131696394);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839215;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 3;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131696401);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839218;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131696383);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839212;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 10;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    QidianManager.a(this, localArrayList);
    localObject = new ArrayList();
    if (needShowUnFollowBtnInActionSheet())
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = super.getString(2131695202);
      localActionSheetItem.icon = 2130842843;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 30;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = super.getString(2131695255);
    localActionSheetItem.icon = 2130842835;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 31;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = super.getString(2131695242);
    localActionSheetItem.icon = 2130842827;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 11;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    if (needShowUnFollowBtnInActionSheet())
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = super.getString(2131695268);
      localActionSheetItem.icon = 2130842853;
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
    Object localObject = this.app.getProxyManager().a();
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, this.uin);
    RecentUser localRecentUser = ((RecentUserProxy)localObject).b(paramString, i);
    localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "isPublicAccoutMsgTabSetTop pUin = " + paramString + " userType = " + i + " not in the msglist");
      localObject = new RecentUser(this.uin, i);
    }
    return ((RecentUser)localObject).showUpTime != 0L;
  }
  
  protected static boolean isSubscriptAccount(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return false;
    }
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramAccountDetail.accountFlag);
    boolean bool;
    if ((i == -2) || (i == -3) || (i == -4)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramAccountDetail.accountFlag2) == -8L) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static void reportEvents(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("source"))) {
      return;
    }
    switch (paramIntent.getIntExtra("source", 0))
    {
    default: 
      return;
    case 1: 
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574C", "0X800574C", 0, 0, paramString, "", "", "", false);
      return;
    case 2: 
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574D", "0X800574D", 0, 0, paramString, "", "", "", false);
      return;
    case 3: 
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574E", "0X800574E", 0, 0, paramString, "", "", "", false);
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800589D", "0X800589D", 0, 0, paramString, "", "", "", false);
  }
  
  private void reportShareDetail(String paramString, ShareActionSheet.Detail paramDetail)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if ((!TextUtils.isEmpty(paramString)) && (paramDetail.jdField_c_of_type_Int == ShareActionSheet.Detail.b))
    {
      localQQAppInterface = this.app;
      str2 = paramDetail.a();
      if (!paramDetail.a) {
        break label74;
      }
    }
    label74:
    for (String str1 = "02";; str1 = "01")
    {
      ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str2, "0X8007CA6", "0X8007CA6", 0, 0, str1, paramString, String.valueOf(paramDetail.d), "");
      return;
    }
  }
  
  private boolean sendSystemMsgAction(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = GroupSystemMsgController.a().b();
    localObject = GroupSystemMsgController.a().a((String)localObject);
    boolean bool1 = bool2;
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
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramInt < ((List)localObject).size())
        {
          this.app.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
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
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet setOrCancelSetTop");
    }
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, this.uin);
    if (i == 1024) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i + " is UIN_TYPE_BUSINESS_CMR_TMP");
    }
    RecentUserProxy localRecentUserProxy = this.app.getProxyManager().a();
    RecentUser localRecentUser = localRecentUserProxy.b(paramString, i);
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i + " not in the msglist");
      localObject = new RecentUser(this.uin, i);
    }
    boolean bool3 = isPublicAccountMsgTabSetTop(paramString);
    if (bool3)
    {
      ((RecentUser)localObject).showUpTime = 0L;
      localRecentUserProxy.b((RecentUser)localObject);
      localObject = this.app.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      if (bool3) {
        break label274;
      }
      bool1 = true;
      label238:
      ReadinjoyReportUtils.a(i, paramString, bool1);
      if (bool3) {
        break label279;
      }
    }
    label274:
    label279:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      EcshopUtils.a(i, paramString, bool1);
      return;
      ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
      break;
      bool1 = false;
      break label238;
    }
  }
  
  private void setShareActionSheetOnClickListener(com.tencent.mobileqq.widget.share.ShareActionSheet paramShareActionSheet, Activity paramActivity)
  {
    paramShareActionSheet.setItemClickListenerV2(new PublicAccountDetailActivityImpl.25(this, paramActivity));
  }
  
  @NotNull
  private String shareToFriends(ShareActionSheet.Detail paramDetail, String paramString1, int paramInt, String paramString2, BaseActivity paramBaseActivity)
  {
    com.tencent.biz.troopbar.ShareActionSheet.b(paramBaseActivity, paramDetail, paramInt, paramString2);
    PublicAccountHandler.a(this.app, paramString1, "Grp_tribe", "interest_data", "share_qq");
    return "01";
  }
  
  @NotNull
  private String shareToQZone(ShareActionSheet.Detail paramDetail, String paramString1, int paramInt, String paramString2, BaseActivity paramBaseActivity)
  {
    com.tencent.biz.troopbar.ShareActionSheet.a(paramBaseActivity, paramDetail, paramInt, paramString2);
    PublicAccountHandler.a(this.app, paramString1, "Grp_tribe", "interest_data", "share_qzone");
    return "02";
  }
  
  @NotNull
  private String shareToSpecifiedFriend(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet.Detail paramDetail, String paramString1, int paramInt, String paramString2, Activity paramActivity)
  {
    com.tencent.biz.troopbar.ShareActionSheet.a(paramActivity, paramDetail, paramInt, paramString2, paramActionSheetItem);
    PublicAccountHandler.a(this.app, paramString1, "Grp_tribe", "interest_data", "share_qq");
    return "01";
  }
  
  @NotNull
  private String shareToWX(int paramInt1, ShareActionSheet.Detail paramDetail, String paramString1, int paramInt2, String paramString2, BaseActivity paramBaseActivity)
  {
    com.tencent.biz.troopbar.ShareActionSheet.a(paramBaseActivity, paramDetail, paramInt2, paramString2, paramInt1);
    if (paramInt1 == 9) {
      paramString2 = "03";
    }
    for (paramDetail = "share_wechat";; paramDetail = "share_circle")
    {
      PublicAccountHandler.a(this.app, paramString1, "Grp_tribe", "interest_data", paramDetail);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", paramString1, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
      return paramString2;
      paramString2 = "04";
    }
  }
  
  private void toSettingFragment()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet toSettingFragment");
    }
    if (this.accountDetail == null) {}
    Integer localInteger;
    do
    {
      return;
      localInteger = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getMessageSetting(this.accountDetail);
    } while (localInteger == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.uin);
    localIntent.putExtra("name", this.accountDetail.name);
    localIntent.putExtra("push_type", localInteger);
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
  
  void deleteAccount(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "deleteAccount");
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    localEntityManager.remove(paramAccountDetail);
    localEntityManager.close();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      if (!this.needUpdateView) {
        break;
      }
      this.isDownCancel = true;
      continue;
      if (!this.isDownCancel) {
        break;
      }
      this.isDownCancel = false;
    }
  }
  
  public void displayToast(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  public void doOnBackPressed()
  {
    int i;
    int j;
    if (this.mProfileParams != null)
    {
      i = 1;
      if (this.mShouldNotStayAtThisApp) {
        break label137;
      }
      j = 1;
      label18:
      if ((i == 0) || (!this.mShouldNotStayAtThisApp)) {
        break label142;
      }
      moveTaskToBack(true);
    }
    for (;;)
    {
      if (!isFollowed()) {
        reportEventIfFromOtherApp("0X8005B6E");
      }
      if (getIntent().getBooleanExtra("from_newer_guide", false))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("has_operation", isFollowed());
        localIntent.putExtra("uin", this.uin);
        setResult(-1, localIntent);
      }
      if ((this.mAccountDetailAdapter != null) && (this.mAccountDetailAdapter.a() != null)) {
        this.mAccountDetailAdapter.a().b();
      }
      super.doOnBackPressed();
      return;
      i = 0;
      break;
      label137:
      j = 0;
      break label18;
      label142:
      if ((i != 0) && (j != 0) && (super.isTaskRoot())) {
        super.startActivity(new Intent(this, SplashActivity.class));
      }
    }
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
      if ((getClass().equals(PublicAccountDetailActivityImpl.class)) && ((CrmUtils.b(this.app, this.uin)) || (QidianManager.b(this.app, this.uin))))
      {
        CrmUtils.a(this, this.mIntent, this.mIntent.getStringExtra("uin"), this.mIntent.getBooleanExtra("need_finish", false), this.mIntent.getIntExtra("source", -1), true, -1);
        finish();
        return true;
      }
      initData();
    }
    reportSource2(this.mIntent);
    super.addObserver(this.publicAccountObserver);
    this.fromJS = this.mIntent.getBooleanExtra("from_js", false);
    if (this.fromJS)
    {
      gotoMoreInfoActivity();
      finish();
    }
    setDatongParam();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.publicAccountObserver);
    super.removeObserver(this.newFollowObserver);
    super.removeObserver(this.newUnFollowObserver);
    super.removeObserver(this.mFaceObserver);
    this.leaveTime = System.currentTimeMillis();
    long l = (this.leaveTime - this.enterTime) / 1000L;
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str2 = this.uin;
    String str3 = l + "";
    if (isFollowed()) {}
    for (String str1 = "02";; str1 = "01")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007800", "0X8007800", 0, 0, str3, "", str1, String.valueOf(PublicAccountReportUtilsImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), false);
      if ((this.mAccountDetailAdapter != null) && (this.mAccountDetailAdapter.a() != null)) {
        this.mAccountDetailAdapter.a().b();
      }
      return;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.bigFace = null;
    this.mIntent = paramIntent;
    init(this.mIntent);
    if (this.uin != null) {
      initData();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.mShouldNotStayAtThisApp = false;
    if (this.mProgress != null) {
      this.mProgress.dismiss();
    }
    this.mProgress = null;
    if ((this.mAccountDetailAdapter != null) && (this.mAccountDetailAdapter.a() != null)) {
      this.mAccountDetailAdapter.a().a();
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
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "follow uin=" + this.uin);
    }
    this.needUpdateView = true;
    this.followBtn.postDelayed(new PublicAccountDetailActivityImpl.7(this), 3000L);
    delayShowLoading(2131695198);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag) == -4)
    {
      this.followIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
      this.followIntent.putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.ext.set("1");
      localFollowRequest.uin.set((int)Long.parseLong(this.uin));
      localFollowRequest.account_type.set(getAccountType());
      this.followIntent.putExtra("data", localFollowRequest.toByteArray());
      this.followIntent.putExtra("source", 1);
      this.followObserver = new PublicAccountDetailActivityImpl.8(this);
      this.followIntent.setObserver(this.followObserver);
      this.app.startServlet(this.followIntent);
    }
    for (;;)
    {
      this.waitingCount += 1;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.app, this.uin, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "follow exit");
      }
      return;
      this.isClickingWSFollow = true;
      this.app.removeObserver(this.newFollowObserver);
      this.newFollowObserver = new NewPublicAccountObserver(new PublicAccountDetailActivityImpl.9(this));
      this.app.addObserver(this.newFollowObserver);
      PublicAccountStateReporter.a(this.app, true, this.accountDetail.uin, 1);
    }
  }
  
  protected String getAccountName()
  {
    String str = "";
    if (this.accountDetail != null) {
      str = this.accountDetail.name;
    }
    return str;
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
    if (paramString != null) {
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
      catch (Exception paramString) {}
    }
    return "";
  }
  
  Drawable getBackgroundForMainPanel()
  {
    if (this.accountDetail == null) {
      return null;
    }
    if (!TextUtils.isEmpty(this.accountDetail.configBackgroundImg)) {
      return URLDrawable.getDrawable(this.accountDetail.configBackgroundImg);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.19(this), 10L);
    return null;
  }
  
  protected int getCertifiedGrade()
  {
    if (this.accountDetail != null) {
      return this.accountDetail.certifiedGrade;
    }
    return 0;
  }
  
  public int getContainerListviewHeight()
  {
    return this.screenHeight - this.titleHeight - this.bottomHeight - 1;
  }
  
  protected Drawable getFace()
  {
    Object localObject;
    if (this.bigFace != null) {
      localObject = this.bigFace;
    }
    FaceDrawable localFaceDrawable;
    do
    {
      return localObject;
      localObject = new File(FaceUtil.a(this.uin));
      if (((File)localObject).isFile())
      {
        loadHDFace(((File)localObject).getAbsolutePath());
        return FaceDrawable.getFaceDrawable(this.app, 115, this.uin);
      }
      localFaceDrawable = FaceDrawable.getFaceDrawable(this.app, 115, this.uin);
      localObject = localFaceDrawable;
    } while (this.mFaceObserver != null);
    this.mFaceObserver = new PublicAccountDetailActivityImpl.AvatarObserver(this);
    addObserver(this.mFaceObserver);
    return localFaceDrawable;
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
    if (this.accountDetail == null) {}
    do
    {
      return null;
      if (TextUtils.isEmpty(this.accountDetail.configBackgroundColor)) {
        this.accountDetail.configBackgroundColor = "3d7fe3";
      }
      try
      {
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#E6" + this.accountDetail.configBackgroundColor.substring(0, 6)));
        return localColorDrawable;
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException) {}
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "configBackgroundColor length is not 6!");
    return null;
  }
  
  public JSONObject getMessageList(BaseActivity paramBaseActivity, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramBaseActivity.app.getMessageFacade().a(paramString, 0, new int[] { -1000, -2000, -2002, -2011, -2022 }, 40);
        paramBaseActivity = new ArrayList();
        if (localObject1 != null)
        {
          i = ((List)localObject1).size();
          if (i > 0)
          {
            if (((MessageRecord)((List)localObject1).get(i - 1)).issend != 0) {
              break label715;
            }
            paramBaseActivity.add(((List)localObject1).get(i - 1));
            if (paramBaseActivity.size() <= 4) {
              break label715;
            }
          }
        }
        localObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        Object localObject2 = this.app.getAccount();
        localJSONObject2.put("qq", localObject2);
        Object localObject3 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
        String str = String.valueOf(NetConnInfoCenter.getServerTime());
        localJSONObject2.put("skey", localObject3);
        localJSONObject2.put("mpUin", paramString);
        localJSONObject2.put("timestamp", "" + str);
        localJSONObject2.put("scene", "201");
        localJSONObject2.put("subAppname", "profile");
        localJSONObject2.put("sign", MD5Utils.encodeHexStr((String)localObject2 + paramString + 201 + str + "jubao@article@123").toLowerCase());
        if (paramBaseActivity != null)
        {
          int j = 0;
          if (j < paramBaseActivity.size())
          {
            paramString = new JSONObject();
            localObject2 = new JSONObject();
            localObject3 = (MessageRecord)paramBaseActivity.get(j);
            if ((localObject3 instanceof MessageForText))
            {
              ((JSONObject)localObject2).put("text", ((MessageRecord)localObject3).msg);
              i = 1;
              paramString.put("content", localObject2);
              paramString.put("messageType", "" + i);
              localJSONArray.put(j, paramString);
              j += 1;
              continue;
            }
            if ((localObject3 instanceof MessageForPic))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPic)localObject3).uuid);
              i = 2;
              continue;
            }
            if ((localObject3 instanceof MessageForPtt))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPtt)localObject3).urlAtServer);
              ((JSONObject)localObject2).put("fileType", ((MessageForPtt)localObject3).busiType);
              i = 3;
              continue;
            }
            if ((localObject3 instanceof MessageForShortVideo))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForShortVideo)localObject3).uuid.substring(1));
              i = 4;
              continue;
            }
            if ((localObject3 instanceof MessageForStructing))
            {
              ((JSONObject)localObject2).put("text", new String(StructMsgUtils.a(QfavUtil.a(StructMsgFactory.a(((MessageRecord)localObject3).msgData).getXmlBytes()), 0), "utf-8"));
              i = 5;
              continue;
            }
          }
          else
          {
            ((JSONObject)localObject1).put("msgNum", "" + paramBaseActivity.size());
            ((JSONObject)localObject1).put("messageList", Base64Util.encodeToString(localJSONArray.toString().getBytes("utf-8"), 0));
          }
        }
        else
        {
          localJSONObject1.put("Verify", localJSONObject2);
          localJSONObject1.put("reportData", localObject1);
          return localJSONObject1;
        }
      }
      catch (Exception paramBaseActivity)
      {
        return null;
      }
      int i = 0;
      continue;
      label715:
      i -= 1;
    }
  }
  
  Bitmap getMidBitmap(Bitmap paramBitmap)
  {
    int k = 0;
    int m = getWindowManager().getDefaultDisplay().getWidth();
    int n = (int)(140.0F * this.density);
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    if (j * n > i * m)
    {
      n = m * i / n;
      m = (j - n) / 2;
      j = n;
    }
    for (;;)
    {
      return Bitmap.createBitmap(paramBitmap, m, k, j, i);
      m = n * j / m;
      k = (i - m) / 2;
      i = m;
      m = 0;
    }
  }
  
  public PublicAccountObserver getPublicAccountObserver()
  {
    return this.publicAccountObserver;
  }
  
  public int getScreenHeight()
  {
    return this.screenHeight;
  }
  
  protected ShareActionSheet.Detail getShareDetail()
  {
    ShareActionSheet.Detail localDetail = null;
    if (this.accountDetail != null)
    {
      localDetail = new ShareActionSheet.Detail(this.accountDetail.uin, this.accountDetail.name, this.accountDetail.summary);
      localDetail.jdField_c_of_type_Int = ShareActionSheet.Detail.b;
      localDetail.a = isFollowed();
      localDetail.d = PublicAccountReportUtilsImpl.getReportAccountType(this.app, this.uin, this.accountDetail);
    }
    return localDetail;
  }
  
  public String getShareUrl()
  {
    if (this.shareUrl == null)
    {
      int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag);
      if ((i != -2) && (i != -5)) {
        break label95;
      }
    }
    label95:
    for (this.shareUrl = ("https://share.mp.qq.com/cgi/share.php?uin=" + this.uin + "&account_flag=" + this.accountDetail.accountFlag + "&jumptype=1&card_type=public_account");; this.shareUrl = ("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.uin)) {
      return this.shareUrl;
    }
  }
  
  String getUin(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("uin");
    }
    do
    {
      return paramIntent;
      paramIntent = localObject;
    } while (this.mProfileParams == null);
    return this.mProfileParams.a().b;
  }
  
  protected void gotoChatActivity()
  {
    if (this.accountDetail != null) {
      open(this.uin, 1008, this.accountDetail.name, ChatActivity.class);
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
    QQGameHelper.a(this);
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
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "[sopType]:" + this.sopType + ",[sopName]:" + this.sopName + ",[weatherShareUrl]:" + this.weatherShareUrl + ",[weatherOutsideFollowState]:" + this.weatherOutsideFollowState);
    }
    this.mSendMessage = paramIntent.getStringExtra("extvalue");
    this.mTypeMessage = paramIntent.getStringExtra("exttype");
    if (!TextUtils.isEmpty(this.mSendMessage))
    {
      if (!"2".equals(this.mTypeMessage)) {
        break label247;
      }
      this.mIsSendMessage = true;
    }
    while ((this.uin == null) || (this.app == null))
    {
      return;
      label247:
      if ("1".equals(this.mTypeMessage)) {
        this.mIsReportMessage = true;
      }
    }
    this.cuin = this.app.getCurrentUin();
    this.publicAccountHandler = ((PublicAccountHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
    initView();
    updateHDFace();
    reportSource(paramIntent);
    this.mDensity = getResources().getDisplayMetrics().density;
  }
  
  @TargetApi(9)
  protected void initAccountDetailListView()
  {
    this.mAccountDetailListView = ((AccountDetailXListView)super.findViewById(2131361859));
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
    this.bottomContainer = super.findViewById(2131361917);
    this.bottomContainer.setVisibility(8);
    this.bottomHeight = this.bottomContainer.getLayoutParams().height;
    this.btnsDivider1 = super.findViewById(2131361874);
    this.callBtn = super.findViewById(2131364323);
    this.btnsDivider1.setVisibility(8);
    this.callBtn.setVisibility(8);
    this.followBtn = super.findViewById(2131367278);
    this.followBtn.setVisibility(8);
    this.btnsDivider2 = super.findViewById(2131361875);
    this.btnsDivider2.setVisibility(8);
    super.setTitle(2131695190);
    this.mProgress = new QQProgressDialog(this, super.getTitleBarHeight());
    this.mProgress.setCanceledOnTouchOutside(true);
    this.searchBtn = ((Button)super.findViewById(2131377599));
    this.searchBtn.setOnClickListener(this);
    this.sendMsgBtn = ((Button)super.findViewById(2131377793));
    this.sendMsgBtn.setText(2131693665);
    this.sendMsgBtn.setOnClickListener(this);
    this.sendMsgBtn.setVisibility(8);
    this.unfollowBtn = ((Button)super.findViewById(2131380900));
    this.unfollowBtn.setText(2131693666);
    this.unfollowBtn.setOnClickListener(this);
    this.unfollowBtn.setVisibility(8);
    this.btnsDivider3 = super.findViewById(2131361876);
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
    this.titleViewLayout = ((RelativeLayout)super.findViewById(2131370346));
    this.titleViewLayout.setOnClickListener(null);
    int j;
    if (isNoTransparentTitleBar()) {
      j = (int)(64.0F * this.density);
    }
    for (int i = (int)(4.0F * this.density);; i = (int)(25.0F * this.density))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, j);
      this.titleViewLayout.setLayoutParams(localLayoutParams);
      this.titleViewLayout.setPadding(0, i, 0, 0);
      this.titleHeight = j;
      if (this.mTopGestureLayout != null) {
        this.mTopGestureLayout.setTitleHeight(this.titleHeight);
      }
      this.titleLeftIcon = ((ImageView)super.findViewById(2131370345));
      this.titleLeftIcon.setOnClickListener(this);
      this.rightViewText = ((TextView)super.findViewById(2131369518));
      this.rightViewText.setText("");
      this.rightViewImg = ((ImageView)super.findViewById(2131369501));
      this.rightViewImg.setImageResource(2130843941);
      this.rightViewImg.setContentDescription(getString(2131697517));
      this.rightViewImg.setVisibility(0);
      this.rightViewImg.setOnClickListener(this);
      this.iconTop = ((ImageView)super.findViewById(2131368648));
      this.iconCicleTop = ((ImageView)super.findViewById(2131368616));
      this.iconCertifiedTop = ((ImageView)super.findViewById(2131364542));
      this.topFollowed = ((Button)super.findViewById(2131361891));
      this.topFollowed.setOnClickListener(this);
      updateTitleStyle();
      return;
      j = (int)(75.0F * this.density);
    }
  }
  
  void initView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "initView");
    }
    super.setContentView(2131558401);
    this.density = super.getResources().getDisplayMetrics().density;
    View localView = super.findViewById(2131361886);
    if (this.isUseStyleAfter839)
    {
      localView.setBackgroundColor(-657926);
      initTitleView();
      initBottomContainer();
      initAccountDetailListView();
      this.mask = super.findViewById(2131374494);
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label160;
      }
      if (this.mask != null) {
        this.mask.setVisibility(0);
      }
    }
    for (;;)
    {
      this.errorContainer = ((LinearLayout)super.findViewById(2131366411));
      this.detailRootView = ((ViewGroup)findViewById(2131361890));
      this.accountMoreDetailController = new AccountMoreDetailController(this, this, this.detailRootView);
      return;
      localView.setBackgroundColor(-1);
      break;
      label160:
      if (this.mask != null) {
        this.mask.setVisibility(8);
      }
    }
  }
  
  protected boolean isFollowed()
  {
    int i = -1;
    if (this.accountDetail != null) {
      i = this.accountDetail.followType;
    }
    return i == 1;
  }
  
  protected void jumpWebView(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(this, PublicAccountBrowserImpl.class);
    } while ((this.app == null) || (TextUtils.isEmpty(this.uin)) || (TextUtils.isEmpty(this.app.getAccount())));
    paramString = paramString.replace("${puin}", this.uin).replace("${uin}", this.app.getAccount());
    localIntent.putExtra("uin", this.app.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.uin);
    localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.uin));
    paramString = getAccountName();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    super.startActivity(localIntent);
  }
  
  protected boolean loadCache()
  {
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localPublicAccountDataManager != null)
    {
      this.accountDetail = localPublicAccountDataManager.b(this.uin);
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
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localPublicAccountDataManager != null)
    {
      this.accountDetail = localPublicAccountDataManager.a(this.uin);
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
    if (paramProfileImageInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateCurrentImage currentImage is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateCurrentImage uin=" + paramProfileImageInfo.d + ", state=" + paramProfileImageInfo.a);
      }
    } while (paramProfileImageInfo.a != 6);
    loadHDFace(paramProfileImageInfo.jdField_c_of_type_JavaLangString);
  }
  
  void loadHDFace(String paramString)
  {
    if ((this.hdFaceLoaded) || (this.bigFace != null)) {
      return;
    }
    this.hdFaceLoaded = true;
    ThreadManager.getSubThreadHandler().post(new PublicAccountDetailActivityImpl.28(this, paramString));
  }
  
  protected boolean needShowQQCall()
  {
    return false;
  }
  
  protected boolean needShowUnFollowBtnInActionSheet()
  {
    return (isFollowed()) && (this.accountDetail.isShowFollowButton);
  }
  
  public boolean onBackEvent()
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
    if (paramView == this.searchBtn) {
      startSearchActivity();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str;
      Object localObject;
      if ((paramView == this.followBtn) || ((this.mAccountDetailAdapter != null) && (paramView == this.mAccountDetailAdapter.a) && (!isFollowed())) || ((paramView == this.topFollowed) && (!isFollowed())))
      {
        reportEventIfFromOtherApp("0X8005B6D");
        this.mIsChangedFromOutSide = false;
        follow();
        setFollowStatus();
        this.followBtn.setEnabled(false);
        this.followBtn.postDelayed(new PublicAccountDetailActivityImpl.24(this), 1000L);
        if (ServiceAccountFolderManager.e(this.app, this.uin)) {
          ((EcshopReportHandler)this.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134243868, this.uin, null, null, null, 1L, false);
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A25", "0X8005A25", this.fromwhere, 0, "", "", "", "", false);
        PADetailReportUtil.a().a(4, this.uin, 0, UniteSearchActivity.d, PAOfflineSearchManager.a().a(this.uin));
        QQAppInterface localQQAppInterface1 = this.app;
        str = this.uin;
        if (isFollowed())
        {
          localObject = "02";
          ReportController.b(localQQAppInterface1, "dc01160", "Pb_account_lifeservice", str, "0X8007CA1", "0X8007CA1", 0, 0, (String)localObject, String.valueOf(this.fromwhere), String.valueOf(PublicAccountReportUtilsImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "");
          if (AppConstants.KANDIAN_DAILY_UIN.equals(this.uin)) {
            localObject = new JSONObject();
          }
        }
        try
        {
          ((JSONObject)localObject).put("channel_id", KandianDailyReportUtils.b());
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009946", "0X8009946", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
          OfficialAccountReporter.a.d(this.uin);
          continue;
          localObject = "01";
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, localException.getMessage());
          }
        }
      }
      else
      {
        if (paramView == this.sendMsgBtn)
        {
          int j = getIntent().getIntExtra("source", 0);
          int i;
          if ((PAWeatherItemBuilder.a(this.uin)) && (WeatherWebPageHelperKt.a(this, this.app)))
          {
            i = 1;
            label463:
            if (i == 0)
            {
              if (!ReadInJoyUtils.a(this.uin)) {
                break label586;
              }
              gotoWeiShiFlowActivity();
            }
          }
          for (;;)
          {
            ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8004E44", "0X8004E44", 0, 0, this.uin, "", "", "");
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A26", "0X8005A26", 0, 0, "", "", "", "", false);
            OfficialAccountReporter.a.h(this.uin);
            break;
            i = 0;
            break label463;
            label586:
            if (AppConstants.TIM_TEAM_UIN.equals(this.uin))
            {
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).enterTimTeam(this, this.app);
            }
            else if (j == 120)
            {
              doOnBackPressed();
            }
            else if (TextUtils.equals(AppConstants.KANDIAN_DAILY_UIN, this.uin))
            {
              KandianDailyManager.a(this, true, null, 5);
              if (AppConstants.KANDIAN_DAILY_UIN.equals(this.uin)) {
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009945", "0X8009945", 0, 0, "", "", "", "", false);
              }
            }
            else if ((TextUtils.equals("2747277822", this.uin)) && (QQGameConfigUtil.b()))
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
                JumpUtil.a(this.app, this);
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
            else if ((TextUtils.equals(AppConstants.QQ_VIP_UIN, this.uin)) && (QQVipHelper.b(getApplicationContext())))
            {
              QQVipHelper.b(getApplicationContext());
            }
            else if (VSHealthUtil.a(this.uin))
            {
              if (!VSHealthUtil.a(this, this.app, getAccountName(), 162)) {
                gotoChatActivity();
              }
            }
            else
            {
              gotoChatActivity();
            }
          }
        }
        if (paramView == this.callBtn)
        {
          CrmUtils.a(this.app, this, getAccountName(), this.uin, "IvrEnterpriseDetailEngineFalse");
          ReportController.b(this.app, "CliOper", "", "", "0X8004653", "0X8004653", 0, 0, "", "", "", "");
        }
        else if (paramView == this.titleLeftIcon)
        {
          doOnBackPressed();
        }
        else
        {
          if ((paramView == this.rightViewImg) || ((paramView != null) && (paramView.getId() == 2131369501)))
          {
            label1127:
            QQAppInterface localQQAppInterface2;
            if (this.isSubscriptAccount)
            {
              showActionSheetSub();
              localQQAppInterface2 = this.app;
              str = this.uin;
              if (!isFollowed()) {
                break label1218;
              }
            }
            label1218:
            for (localObject = "02";; localObject = "01")
            {
              ReportController.b(localQQAppInterface2, "dc01160", "Pb_account_lifeservice", str, "0X8007CA5", "0X8007CA5", 0, 0, (String)localObject, String.valueOf(PublicAccountReportUtilsImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "", "");
              OfficialAccountReporter.a.g(this.uin);
              break;
              showActionSheet();
              break label1127;
            }
          }
          if (paramView == this.unfollowBtn)
          {
            showUnFollowActionSheet();
            OfficialAccountReporter.a.e(this.uin);
          }
          else if ((paramView != null) && (paramView.getId() == 2131378727))
          {
            this.detailRootView.setVisibility(0);
            this.accountMoreDetailController.a(this.accountDetail);
            OfficialAccountReporter.a.f(this.uin);
          }
          else if ((paramView != null) && (paramView.getId() == 2131368447))
          {
            localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getMessageHistoryInfo(this.accountDetail);
            if (localObject != null) {
              jumpWebView(((PaConfigAttr.PaConfigInfo)localObject).jdField_c_of_type_JavaLangString);
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.isDestroy = true;
    if (this.mProgress != null) {
      this.mProgress.dismiss();
    }
    this.mProgress = null;
    if (this.mFaceObserver != null)
    {
      this.app.removeObserver(this.mFaceObserver);
      this.mFaceObserver = null;
    }
    if (this.detailIntent != null) {
      this.detailIntent.setObserver(null);
    }
    if (this.unfollowIntent != null) {
      this.unfollowIntent.setObserver(null);
    }
    if (this.followIntent != null) {
      this.followIntent.setObserver(null);
    }
    if (this.model != null) {
      this.model.b();
    }
    if (this.mShareAttentionSuccessDlg != null) {
      this.mShareAttentionSuccessDlg.dismiss();
    }
    if (this.mAccountDetailAdapter != null) {
      this.mAccountDetailAdapter.a();
    }
    if (this.mAccountDetailListView != null) {
      this.mAccountDetailListView.a();
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
      QQToast.a(this, getString(2131695227), 0).a();
      finish();
      return;
    }
    if ((this.mAccountDetailAdapter != null) && (this.mAccountDetailAdapter.a() != null)) {
      this.mAccountDetailAdapter.a().a(true);
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
    if ((TextUtils.equals("2290230341", paramString1)) && (QZoneMsgActivity.open(this, this.app))) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((getIntent().hasExtra("qidian_chat")) && (getIntent().getBooleanExtra("qidian_chat", false)))
    {
      localIntent.setComponent(new ComponentName(this, SplashActivity.class));
      localBundle.putBoolean("open_chatfragment", true);
    }
    for (;;)
    {
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
      return;
      localIntent.setComponent(new ComponentName(this, paramClass));
    }
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
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {
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
    if (this.mProfileParams != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = this.mProfileParams.c();
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
        ((StringBuilder)localObject4).append((String)localObject1).append(",").append("app").append(",").append((String)localObject2).append(",").append((String)localObject3).append(",").append(l);
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", paramString, paramString, 0, 1, 0, ((StringBuilder)localObject4).toString(), "", "", "");
      }
      return;
    }
  }
  
  protected void reportItemEvent(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  void reportSource(Intent paramIntent)
  {
    this.isFromBrowser = paramIntent.getBooleanExtra("fromBrowser", false);
    this.mSource = paramIntent.getIntExtra("source", 0);
    switch (this.mSource)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "[fromwhere]:" + this.fromwhere);
      }
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A24", "0X8005A24", this.fromwhere, 0, "", "", "", "");
      return;
      this.fromwhere = 2;
      continue;
      this.fromwhere = 1;
      continue;
      this.fromwhere = 0;
      continue;
      this.fromwhere = 3;
      continue;
      this.fromwhere = 4;
      continue;
      this.fromwhere = 5;
      continue;
      this.fromwhere = 6;
      continue;
      this.fromwhere = 8;
      continue;
      this.fromwhere = 9;
      continue;
      this.fromwhere = 11;
      continue;
      this.fromwhere = 50;
      continue;
      this.fromwhere = 12;
      continue;
      this.fromwhere = 13;
    }
  }
  
  void reportSource2(Intent paramIntent)
  {
    if ((this.hasReport2) || (this.accountDetail == null)) {
      return;
    }
    this.hasReport2 = true;
    this.isFromBrowser = paramIntent.getBooleanExtra("fromBrowser", false);
    this.mSource = paramIntent.getIntExtra("source", 0);
    QQAppInterface localQQAppInterface;
    String str;
    int i;
    switch (this.mSource)
    {
    default: 
      if (this.isFromBrowser) {
        this.fromwhere = 20;
      }
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "[fromwhere]:" + this.fromwhere);
      }
      localQQAppInterface = this.app;
      str = this.uin;
      i = this.fromwhere;
      if (!isFollowed()) {
        break;
      }
    }
    for (paramIntent = "02";; paramIntent = "01")
    {
      ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X8007CA0", "0X8007CA0", i, 0, paramIntent, String.valueOf(this.fromwhere), String.valueOf(PublicAccountReportUtilsImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "");
      return;
      this.fromwhere = 11;
      break;
      this.fromwhere = 12;
      break;
      this.fromwhere = 13;
      break;
      this.fromwhere = 14;
      break;
      this.fromwhere = 15;
      break;
      this.fromwhere = 16;
      break;
      this.fromwhere = 17;
      break;
      this.fromwhere = 18;
      break;
      this.fromwhere = 19;
      break;
      this.fromwhere = 21;
      break;
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  protected List<PaConfigAttr.PaConfigInfo> resetConfigInfoListForUnfollow(List<PaConfigAttr.PaConfigInfo> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(2);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)paramList.get(i);
      if ((localPaConfigInfo.a == 3) && ((localPaConfigInfo.jdField_c_of_type_Int == 7) || (localPaConfigInfo.jdField_c_of_type_Int == 8))) {
        localArrayList.add(localPaConfigInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  void resetFootView()
  {
    if (this.mAccountDetailAdapter.d)
    {
      this.mAccountDetailListView.setAdapter(null);
      this.mAccountDetailListView.a(true);
      this.mAccountDetailListView.setAdapter(this.mAccountDetailAdapter);
    }
    this.mAccountDetailAdapter.d = false;
  }
  
  protected void saveAccountDetailInSubThread()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.13(this), 10L);
  }
  
  void saveAccountDetailToDBAndCache(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "saveAccountDetailToDBAndCache");
    }
    Object localObject = this.app.getEntityManagerFactory().createEntityManager();
    if ((this.accountDetail != null) && (this.accountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, paramAccountDetail.name);
      }
      this.accountDetail.clone(paramAccountDetail);
      if (!((EntityManager)localObject).update(this.accountDetail)) {
        ((EntityManager)localObject).drop(AccountDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      localObject = (PublicAccountDataManager)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if ((localObject != null) && (paramAccountDetail != null))
      {
        ((PublicAccountDataManager)localObject).a(this.accountDetail);
        if (paramAccountDetail.followType == 1) {
          ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      updateViewInMain();
      return;
      this.accountDetail = paramAccountDetail;
      ((EntityManager)localObject).persist(paramAccountDetail);
    }
  }
  
  protected void saveDetailForStateChange(int paramInt, boolean paramBoolean)
  {
    this.accountDetail.accountData = this.gAccountData.toByteArray();
    if (paramInt == 3)
    {
      this.accountDetail.isSyncLbs = true;
      this.accountDetail.isAgreeSyncLbs = paramBoolean;
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
    if (this.detailIntent != null) {
      this.detailIntent.setObserver(null);
    }
    this.detailIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
    this.detailIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.5.5,3,5105");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    if (this.accountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.accountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.uin));
        label124:
        this.detailIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        this.detailObserver = new PublicAccountDetailActivityImpl.23(this);
        this.detailIntent.setObserver(this.detailObserver);
        this.app.startServlet(this.detailIntent);
        this.waitingCount += 1;
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest exit");
        }
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label124;
    }
  }
  
  protected void setAccountData()
  {
    if (this.accountDetail != null) {
      this.accountDetail.accountData = this.gAccountData.toByteArray();
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
    if (TextUtils.isEmpty(this.uin)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "setHDFace uin is null");
      }
    }
    while (this.mAccountDetailAdapter == null) {
      return;
    }
    Drawable localDrawable = getFace();
    this.mAccountDetailAdapter.c(localDrawable);
    this.mAccountDetailAdapter.notifyDataSetChanged();
  }
  
  void setInfoForAdapter()
  {
    this.mAccountDetailAdapter.a(getBackgroundForMainPanel());
    this.mAccountDetailAdapter.b(getImageForMainPanel());
    this.mAccountDetailAdapter.c(getFace());
    this.mAccountDetailAdapter.a(this.isSubscriptAccount);
    this.mAccountDetailAdapter.a(getContainerListviewHeight());
    if (this.accountDetail != null) {
      this.mAccountDetailAdapter.a(this.accountDetail);
    }
  }
  
  protected void setIsConfirmed(boolean paramBoolean)
  {
    if (this.accountDetail != null) {
      this.accountDetail.isConfirmed = paramBoolean;
    }
  }
  
  protected void setShowMsgFlag(int paramInt)
  {
    if (this.accountDetail != null) {
      this.accountDetail.mShowMsgFlag = paramInt;
    }
  }
  
  protected void share()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "share");
    }
    if ((TextUtils.isEmpty(this.uin)) || (this.accountDetail == null)) {
      return;
    }
    showNewShareActionSheet();
    PublicAccountHandler.a(this.app, this.uin, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
  
  protected void showActionSheet()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "ActionSheet showActionSheet");
    }
    PublicAccountDetailActivityImpl.ActionSheetBuilder localActionSheetBuilder = new PublicAccountDetailActivityImpl.ActionSheetBuilder(this, (ActionSheet)ActionSheetHelper.a(this, null));
    localActionSheetBuilder.a();
    localActionSheetBuilder.b();
    if ((this.uin.equals("1770946116")) || (CrmUtils.b(this.app, this.uin))) {
      localActionSheetBuilder.c();
    }
    for (;;)
    {
      localActionSheetBuilder.f();
      this.actionSheet = localActionSheetBuilder.a();
      if (!this.actionSheet.isShowing()) {
        this.actionSheet.show();
      }
      return;
      if ((ServiceAccountFolderManager.b(this.app, this.uin)) || (ServiceAccountFolderManager.e(this.app, this.uin)))
      {
        localActionSheetBuilder.e();
      }
      else if (ServiceAccountFolderManager.a(this.app, this.uin))
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
  }
  
  protected void showActionSheetSub()
  {
    if (this.mShareDialogBuilder == null)
    {
      this.mShareDialogBuilder = new ShareActionSheetBuilder(this);
      this.mShareDialogBuilder.setActionSheetTitle(getString(2131719311));
      this.mShareDialogBuilder.setActionSheetItems(getActionSheetItems());
      this.mShareDialogBuilder.setItemClickListener(this.itemClickListener);
    }
    try
    {
      for (;;)
      {
        this.mShareDialogBuilder.show();
        return;
        this.mShareDialogBuilder.setActionSheetItems(getActionSheetItems());
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  void showAttentionSuccessDlg(Activity paramActivity)
  {
    if (this.mShareAttentionSuccessDlg == null) {
      this.mShareAttentionSuccessDlg = new ShareAioResultDialog(paramActivity);
    }
    this.mShareAttentionSuccessDlg.a(HardCodeUtil.a(2131699827));
    String str = this.app.getApplication().getString(2131719148);
    str = str + HardCodeUtil.a(2131699828);
    paramActivity = new PublicAccountDetailActivityImpl.10(this, paramActivity);
    this.mShareAttentionSuccessDlg.a(str, paramActivity);
    this.mShareAttentionSuccessDlg.a(paramActivity);
    this.mShareAttentionSuccessDlg.show();
  }
  
  protected void showAttentionSuccessDlgIfJumpFromOtherApp()
  {
    if (this.mProfileParams != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        showAttentionSuccessDlg(this);
      }
      return;
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
    if (this.mProgress != null)
    {
      this.mProgress.c(paramInt);
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
    ReportDialog localReportDialog = new ReportDialog(this, 2131755842);
    localReportDialog.setContentView(2131561170);
    ((TextView)localReportDialog.findViewById(2131365845)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365832);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365830);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365836);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690800);
    localTextView3.setText(2131691678);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new PublicAccountDetailActivityImpl.26(this, localReportDialog));
    localTextView3.setOnClickListener(new PublicAccountDetailActivityImpl.27(this, paramString));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  void showUnFollowActionSheet()
  {
    this.unFollowActionSheet = ActionSheet.create(this);
    String str = getString(2131695270, new Object[] { getAccountName() });
    this.unFollowActionSheet.setMainTitle(str);
    this.unFollowActionSheet.addButton(2131696427, 3);
    this.unFollowActionSheet.addCancelButton(2131690800);
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
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "startLoadMore: uin=" + this.uin);
      }
      AccountDetailDynamicListModel.b(this.app, Long.parseLong(this.uin), this.publicAccountObserver);
    }
  }
  
  void startSearchActivity()
  {
    super.finish();
    PublicAccountSearchActivity.a(this, "");
  }
  
  public boolean tryGoToWeatherWhenFollow(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {}
    while ((this.weatherOutsideFollowState != 2) || (TextUtils.isEmpty(this.weatherShareUrl)) || (!PAWeatherItemBuilder.a(this.uin)) || (paramAccountDetail.followType != 1)) {
      return false;
    }
    QLog.i("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "handleIfWeatherShare" + this.weatherShareUrl);
    runOnUiThread(new PublicAccountDetailActivityImpl.31(this));
    return true;
  }
  
  public boolean tryGoToWeatherWhenGetInfo(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {}
    while (this.weatherOutsideFollowState != 3) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.weatherShareUrl)) && (PAWeatherItemBuilder.a(this.uin)) && (paramAccountDetail.followType == 1))
    {
      QLog.i("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "handleIfWeatherShare" + this.weatherShareUrl);
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
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.uin)) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("channel_id", KandianDailyReportUtils.b());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009944", "0X8009944", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      PAStartupTracker.a(null, " pubAcc_follow_cancel", this.uin);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "unfollow");
      }
      delayShowLoading(2131695269);
      if ((this.accountDetail == null) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag) == -4))
      {
        if (this.unfollowIntent != null) {
          this.unfollowIntent.setObserver(null);
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
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.app, this.uin);
        if (ServiceAccountFolderManager.e(this.app, this.uin))
        {
          int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, this.uin);
          RecentUtil.b(this.app, String.valueOf(this.uin), i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "unfollow exit");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, localException.getMessage());
        continue;
        if (this.newUnFollowObserver != null) {
          this.app.removeObserver(this.newUnFollowObserver);
        }
        this.newUnFollowObserver = new NewPublicAccountObserver(new PublicAccountDetailActivityImpl.5(this));
        this.app.addObserver(this.newUnFollowObserver);
        PublicAccountStateReporter.a(this.app, false, this.accountDetail.uin, 1);
        this.waitingCount += 1;
      }
    }
  }
  
  void updateBottomContainer()
  {
    if ((this.accountDetail == null) || (this.isSubscriptAccount)) {}
    label272:
    for (;;)
    {
      return;
      boolean bool = this.accountDetail.isShowFollowButton;
      if (this.accountDetail.followType == 1) {
        if ((this.uin.equals("1770946116")) || (CrmUtils.b(this.app, this.uin)))
        {
          this.sendMsgBtn.setVisibility(0);
          this.followBtn.setVisibility(8);
          this.bottomContainer.setVisibility(0);
          if (!needShowQQCall()) {
            break label253;
          }
          this.btnsDivider1.setVisibility(0);
          this.callBtn.setVisibility(0);
          this.callBtn.setOnClickListener(this);
        }
      }
      for (;;)
      {
        if ((this.sendMsgBtn.getVisibility() != 8) || (this.followBtn.getVisibility() != 8)) {
          break label272;
        }
        this.bottomContainer.setVisibility(8);
        return;
        this.sendMsgBtn.setVisibility(0);
        this.followBtn.setVisibility(8);
        this.btnsDivider3.setVisibility(0);
        this.unfollowBtn.setVisibility(0);
        this.bottomContainer.setVisibility(0);
        break;
        if (bool)
        {
          this.followBtn.setVisibility(0);
          this.followBtn.setOnClickListener(this);
        }
        this.sendMsgBtn.setVisibility(8);
        this.btnsDivider3.setVisibility(8);
        this.unfollowBtn.setVisibility(8);
        this.bottomContainer.setVisibility(0);
        break;
        label253:
        this.btnsDivider1.setVisibility(8);
        this.callBtn.setVisibility(8);
      }
    }
  }
  
  void updateDetailInfo(AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.21(this, paramAccountDetail, paramBoolean), 10L);
  }
  
  protected void updateFollowInfo()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.6(this), 10L);
  }
  
  protected void updateHDFace()
  {
    if (TextUtils.isEmpty(this.uin)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateHDFace uin is null");
      }
    }
    do
    {
      return;
      if (NetworkUtil.h(this)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateHDFace not wifi, so need't update");
    return;
    this.model = new PublicAccountDetailActivityImpl.FriendAvatarWeakReference(this.app, this);
    this.model.a();
  }
  
  void updateListView()
  {
    if ((this.mAccountDetailAdapter == null) || (this.mAccountDetailListView.getAdapter() == null) || ((this.accountDetail != null) && (this.mAccountDetailAdapter.a() == null)))
    {
      if (this.mAccountDetailListView.getAdapter() != null)
      {
        ((AccountDetailBaseAdapter)this.mAccountDetailListView.getAdapter()).a();
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
      return;
    }
    setInfoForAdapter();
    this.mAccountDetailAdapter.notifyDataSetChanged();
  }
  
  void updateTitleStyle()
  {
    if (this.isUseStyleAfter839)
    {
      this.titleLeftIcon.setImageResource(2130850514);
      this.rightViewImg.setImageResource(2130842652);
      return;
    }
    this.titleLeftIcon.setImageResource(2130851151);
    this.rightViewImg.setImageResource(2130843941);
  }
  
  @TargetApi(16)
  void updateTopContainer()
  {
    if ((this.accountDetail == null) || (!this.isSubscriptAccount)) {}
    while (!isFollowed()) {
      return;
    }
    this.topFollowed.setBackgroundDrawable(null);
    this.topFollowed.setText(2131695266);
    this.topFollowed.setAlpha(0.5F);
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountDetailActivityImpl.17(this), 0L);
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
    this.isUseStyleAfter839 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isShopOrServiceAccount(this.accountDetail);
    if (this.isUseStyleAfter839)
    {
      this.mActNeedImmersive = true;
      setImmersiveStatus();
      if (!this.mActNeedImmersive)
      {
        i = getResources().getColor(2131167091);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, i);
          if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
            break label254;
          }
          this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130846481));
        }
      }
      label116:
      this.isSubscriptAccount = isSubscriptAccount(this.accountDetail);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "isSubscriptAccount = " + this.isSubscriptAccount);
      }
      if ((this.isSubscriptAccount) && (!TextUtils.isEmpty(this.uin))) {
        AccountDetailDynamicListModel.a(this.app, Long.parseLong(this.uin), this.publicAccountObserver);
      }
      if ((this.gAccountData == null) || (!this.gAccountData.show_flag.has()) || (this.gAccountData.show_flag.get() != 2)) {
        break label265;
      }
    }
    label265:
    for (int i = 1;; i = 0)
    {
      updateTitleStyle();
      if (i == 0) {
        break label270;
      }
      showErrorTip();
      return;
      this.mActNeedImmersive = false;
      break;
      label254:
      this.mSystemBarComp.setStatusDrawable(null);
      break label116;
    }
    label270:
    updateTopContainer();
    updateBottomContainer();
    updateListView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl
 * JD-Core Version:    0.7.0.1
 */