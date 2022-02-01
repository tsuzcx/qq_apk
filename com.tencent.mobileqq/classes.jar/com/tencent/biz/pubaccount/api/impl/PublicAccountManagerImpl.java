package com.tencent.biz.pubaccount.api.impl;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.InitDoneObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.refuseAcceptDone;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mp.mobileqq_mp.ActionInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendOrderPayEventRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPublicAccountMessageReceiptRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SetRefuseFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneRuntimeService;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountManagerImpl
  implements IPublicAccountManager
{
  public static final boolean DEBUG = false;
  public static final long DEBUG_UIN = 350749526L;
  static final long MENU_SETTING_MAX_CACHE_TIME = 21600000L;
  public static final String PA_HISTORY_MSG_PARAMS = "history_msg_params";
  public static final int PA_PICSOURCE_ALBUM = 2;
  public static final int PA_PICSOURCE_CAMERA = 1;
  public static final int PA_PICSOURCE_NONE = 0;
  public static final String SSO_COMMAND_POST_PUNCHCARD_INFO = "post_punchcard_info";
  public static final String SSO_COMMAND_PULL_BIT_APP_MSG = "lola_update_req";
  public static final int TypeGetAccountMenuSetting = 0;
  protected Runnable getLocationThread = new PublicAccountManagerImpl.4(this);
  public boolean hasPreloadWebProcessor = false;
  private long lastPreloadWebProcessorTime = 0L;
  BroadcastReceiver locationResultReceiver = null;
  public WeakReference<AppInterface> mApp = new WeakReference(null);
  private String mCurrentUin;
  boolean mIsNewMenu = false;
  private boolean mKeepOldPublicAccountData = false;
  private long mLastReportTime = 0L;
  int mPicSource = 0;
  Map<String, List<mobileqq_mp.ButtonInfo>> mPublicAccountMenuButtonLists = new HashMap();
  private WeakReference<BusinessObserver> mPublicAccountMenuEventObserver = new WeakReference(null);
  Map<String, Integer> mPublicAccountMenuType = new HashMap();
  WeakReference<Context> mTempContext = new WeakReference(null);
  String mTempKey = null;
  String mTempUin = null;
  Map<String, Long> menuSettingLastSaveDateTimeMap = new HashMap();
  Map<String, Integer> menuSettingSeqnoMap = new HashMap();
  BroadcastReceiver picResultReceiver = null;
  BroadcastReceiver scanResultReceiver = null;
  
  public static String createSendPayInfoBody(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("luin", paramLong1);
      localJSONObject.put("msg_id", paramLong2);
      String str2 = "";
      String str1 = paramString1;
      if (paramString1 == null) {
        str1 = "";
      }
      localJSONObject.put("order_id", str1);
      localJSONObject.put("ret_code", paramInt1);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localJSONObject.put("ret_str", paramString1);
      localJSONObject.put("msg_type", paramInt2);
      localJSONObject.put("pay_time", paramInt3);
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      localJSONObject.put("reserve_1", paramString1);
      if (paramString4 != null) {
        break label163;
      }
      paramString1 = str2;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        continue;
        paramString1 = paramString4;
      }
    }
    localJSONObject.put("reserve_2", paramString1);
    return localJSONObject.toString();
  }
  
  private String getRecentReportDate(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getProxyManager();
    if (localObject == null) {
      return "";
    }
    List localList = ((ProxyManager)localObject).g().a(true);
    if (localList == null) {
      return "";
    }
    int m = localList.size();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < m)
    {
      localObject = (RecentUser)localList.get(j);
      if (((RecentUser)localObject).showUpTime != 0L)
      {
        int n = getMsgType(((RecentUser)localObject).uin, ((RecentUser)localObject).getType(), paramQQAppInterface);
        int k = paramQQAppInterface.getConversationFacade().a(((RecentUser)localObject).uin, ((RecentUser)localObject).getType());
        int i;
        if (((RecentUser)localObject).getType() == 7120)
        {
          i = k;
          if (((EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).b(paramQQAppInterface) == 0) {
            break label225;
          }
        }
        else
        {
          if (((RecentUser)localObject).getType() != 7210) {
            break label196;
          }
          if (!SubscriptRecommendController.j(paramQQAppInterface)) {
            break label180;
          }
        }
        label180:
        label196:
        do
        {
          for (;;)
          {
            i = 1;
            break;
            i = k;
            if (TroopBarAssistantManager.a().f(paramQQAppInterface) == 0) {
              break;
            }
          }
          i = k;
          if (((RecentUser)localObject).getType() != 7230) {
            break;
          }
          i = k;
        } while (ServiceAccountFolderManager.a().h() != 0);
        label225:
        k = i;
        if (i != 0) {
          k = 1;
        }
        if ((n != 1) && (n != 2)) {
          localObject = "0";
        } else {
          localObject = ((RecentUser)localObject).uin;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(n);
        localStringBuilder.append("&");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("&");
        localStringBuilder.append(j + 1);
        localStringBuilder.append("&");
        localStringBuilder.append(k);
        localObject = localStringBuilder.toString();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startReport s size= ");
          localStringBuilder.append(((String)localObject).length());
          QLog.d("PublicAccountManager", 2, localStringBuilder.toString());
        }
        localArrayList.add(localObject);
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("startReport reportStr size= ");
      paramQQAppInterface.append(localArrayList.toString().length());
      paramQQAppInterface.append("  length=");
      paramQQAppInterface.append(localArrayList.size());
      QLog.d("PublicAccountManager", 2, paramQQAppInterface.toString());
    }
    if (localArrayList.size() != 0) {
      return localArrayList.toString();
    }
    return "";
  }
  
  private static void handleUrlEvent(Context paramContext, AppInterface paramAppInterface, String paramString, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if ((paramContext instanceof BaseActivity))
    {
      localObject = ((BaseActivity)paramContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).k();
        if ((localObject instanceof PublicAccountChatPie))
        {
          localObject = (PublicAccountChatPie)localObject;
          ((PublicAccountChatPie)localObject).cb += 1;
        }
      }
    }
    if (paramButtonInfo.url.has()) {
      paramButtonInfo = paramButtonInfo.url.get();
    } else {
      paramButtonInfo = "";
    }
    paramButtonInfo = new StringBuilder(paramButtonInfo);
    if (paramButtonInfo.indexOf("?") < 0) {
      paramButtonInfo.append("?");
    } else if (paramButtonInfo.indexOf("?") < paramButtonInfo.length() - 1) {
      if (paramButtonInfo.indexOf("&") < 0) {
        paramButtonInfo.append("&");
      } else if (paramButtonInfo.lastIndexOf("&") < paramButtonInfo.length() - 1) {
        paramButtonInfo.append("&");
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin=");
    ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
    paramButtonInfo.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&puin=");
    ((StringBuilder)localObject).append(paramString);
    paramButtonInfo.append(((StringBuilder)localObject).toString());
    localObject = new Intent(paramContext, PublicAccountBrowserImpl.class);
    ((Intent)localObject).putExtra("from", QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramButtonInfo.toString());
    ((Intent)localObject).putExtra("uin", paramAppInterface.getCurrentAccountUin());
    ((Intent)localObject).putExtra("puin", paramString);
    ((Intent)localObject).putExtra("assignBackText", paramContext.getResources().getString(2131887625));
    ((Intent)localObject).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
    ((Intent)localObject).putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(paramString));
    if (paramString.equalsIgnoreCase("2632129500")) {
      ((Intent)localObject).putExtra("hide_operation_bar", true);
    }
    paramContext.startActivity((Intent)localObject);
  }
  
  private mobileqq_mp.SendMenuEventRequest initSendMenuEventRequest(int paramInt, String paramString, boolean paramBoolean)
  {
    String str = this.mTempUin;
    try
    {
      long l = Long.valueOf(str).longValue();
      mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = new mobileqq_mp.SendMenuEventRequest();
      localSendMenuEventRequest.uin.set((int)l);
      localSendMenuEventRequest.type.set(paramInt);
      localSendMenuEventRequest.key.set(paramString);
      localSendMenuEventRequest.msg_id.set(0L);
      localSendMenuEventRequest.s_type.set(1);
      localSendMenuEventRequest.versionInfo.set("8.8.17,3,5770");
      localSendMenuEventRequest.menu_type.set(getPublicAccountMenuType(str));
      if (paramBoolean) {
        localSendMenuEventRequest.is_new_menu.set(paramBoolean);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("type:");
        paramString.append(localSendMenuEventRequest.type.get());
        paramString.append(" uin:");
        paramString.append(localSendMenuEventRequest.uin.get());
        paramString.append(" key:");
        paramString.append(localSendMenuEventRequest.key.get());
        paramString.append(" msg_id:");
        paramString.append(localSendMenuEventRequest.msg_id.get());
        paramString.append(" s_type:");
        paramString.append(localSendMenuEventRequest.s_type.get());
        paramString.append(" versionInfo:");
        paramString.append(localSendMenuEventRequest.versionInfo.get());
        paramString.append(" is_new_menu:");
        paramString.append(localSendMenuEventRequest.is_new_menu.get());
        QLog.d("PublicAccountManager-init:", 2, paramString.toString());
      }
      return localSendMenuEventRequest;
    }
    catch (NumberFormatException paramString)
    {
      label285:
      break label285;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("puin is invalid format:");
      paramString.append(str);
      QLog.e("PublicAccountManager", 2, paramString.toString());
    }
    return null;
  }
  
  public static boolean isFuWuHaoType(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramAppInterface.findPublicAccountInfo(paramString.toString());
    if (localPublicAccountInfo == null)
    {
      paramAppInterface = (PublicAccountDetailImpl)paramAppInterface.findAccountDetailInfo(paramString);
      if (paramAppInterface == null) {
        return false;
      }
      return (paramAppInterface.accountFlag & 0x8EA00000) == 0;
    }
    return (localPublicAccountInfo.accountFlag & 0x8EA00000) == 0;
  }
  
  private boolean isMenuSettingOutDate(String paramString, Context paramContext)
  {
    if (this.menuSettingLastSaveDateTimeMap.containsKey(paramString))
    {
      long l3 = ((Long)this.menuSettingLastSaveDateTimeMap.get(paramString)).longValue();
      long l4 = System.currentTimeMillis();
      boolean bool = false;
      long l2 = paramContext.getSharedPreferences("menuEventSharePre", 0).getLong("menuCacheTime", -1L);
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 21600000L;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("cacheTime(ms):");
        paramString.append(l1);
        QLog.d("PublicAccountManager-Menu", 2, paramString.toString());
      }
      if (l4 - l3 >= l1) {
        bool = true;
      }
      return bool;
    }
    return true;
  }
  
  private static void oldUrEventHandle(AppInterface paramAppInterface, Context paramContext, String paramString, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if ((paramContext instanceof BaseActivity))
    {
      Object localObject = (BaseActivity)paramContext;
      if (((BaseActivity)localObject).getChatFragment() != null)
      {
        localObject = ((BaseActivity)localObject).getChatFragment().k();
        if ((localObject instanceof PublicAccountChatPie)) {
          ((PublicAccountChatPie)localObject).cd.b();
        }
      }
    }
    if ((paramButtonInfo.item_id.has()) && (paramButtonInfo.item_id.get() == 5))
    {
      paramAppInterface = new Intent(paramContext, CouponActivity.class);
      paramAppInterface.putExtra("url", "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
      paramAppInterface.putExtra("source", "1");
      paramAppInterface.putExtra("from", 5);
      paramContext.startActivity(paramAppInterface);
      return;
    }
    if ((paramButtonInfo.item_id.has()) && (paramButtonInfo.item_id.get() == 6))
    {
      paramAppInterface = new Intent(paramContext, CouponActivity.class);
      if (paramButtonInfo.url.has()) {
        paramAppInterface.putExtra("url", paramButtonInfo.url.get());
      }
      paramAppInterface.putExtra("webStyle", "noBottomBar");
      paramContext.startActivity(paramAppInterface);
      return;
    }
    if ((paramButtonInfo.url.has()) && (MiniAppLauncher.isMiniAppScheme(paramButtonInfo.url.get())))
    {
      MiniAppLauncher.launchMiniAppByScheme(paramContext, paramButtonInfo.url.get(), 1209);
      return;
    }
    if ((paramButtonInfo.url.has()) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramButtonInfo.url.get())))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramButtonInfo.url.get(), 1035, null);
      return;
    }
    handleUrlEvent(paramContext, paramAppInterface, paramString, paramButtonInfo);
  }
  
  private void openAlbum(Context paramContext, AppInterface paramAppInterface, SessionInfo paramSessionInfo)
  {
    Uri localUri = CommonUtil.a();
    int i = 0;
    if (localUri != null)
    {
      ActionSheet localActionSheet = ActionSheet.create((BaseActivity)paramContext);
      String[] arrayOfString = paramContext.getResources().getStringArray(2130968670);
      int j = arrayOfString.length;
      while (i < j)
      {
        localActionSheet.addButton(arrayOfString[i]);
        i += 1;
      }
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new PublicAccountManagerImpl.11(this, paramAppInterface, paramContext, localUri, paramSessionInfo, localActionSheet));
      localActionSheet.show();
    }
    else
    {
      PlusPanelUtils.a((QQAppInterface)paramAppInterface, (Activity)paramContext, paramSessionInfo, null, null);
      paramAppInterface = (ITroopPhotoHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER);
      if ((!TextUtils.isEmpty(paramSessionInfo.b)) && (paramSessionInfo.a == 1)) {
        paramAppInterface.a(paramSessionInfo.b, true);
      }
      ((BaseActivity)paramContext).setCanLock(false);
    }
    paramAppInterface = this.picResultReceiver;
    if (paramAppInterface != null) {}
    try
    {
      paramContext.unregisterReceiver(paramAppInterface);
      label177:
      this.picResultReceiver = null;
      this.picResultReceiver = new PublicAccountManagerImpl.12(this);
      paramAppInterface = new IntentFilter("com.tencent.biz.pubaccount.picResultAction");
      paramContext.registerReceiver(this.picResultReceiver, paramAppInterface, "com.tencent.msg.permission.pushnotify", null);
      this.mPicSource = 2;
      return;
    }
    catch (Exception paramAppInterface)
    {
      break label177;
    }
  }
  
  private void openCamera(Context paramContext, AppInterface paramAppInterface, SessionInfo paramSessionInfo)
  {
    if (AudioUtil.b(0))
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131896453), paramContext.getString(2131896454), new PublicAccountManagerImpl.8(this), null).show();
      return;
    }
    if (QQAudioHelper.a(0))
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131896453), paramContext.getString(2131896455), new PublicAccountManagerImpl.9(this), null).show();
      return;
    }
    paramSessionInfo = (BaseActivity)paramContext;
    PlusPanelUtils.a(paramAppInterface, paramSessionInfo, 1, 0);
    paramSessionInfo.setCanLock(false);
    paramAppInterface = this.picResultReceiver;
    if (paramAppInterface != null) {}
    try
    {
      paramContext.unregisterReceiver(paramAppInterface);
      label113:
      this.picResultReceiver = null;
      this.picResultReceiver = new PublicAccountManagerImpl.10(this);
      paramAppInterface = new IntentFilter("com.tencent.biz.pubaccount.picResultAction");
      paramContext.registerReceiver(this.picResultReceiver, paramAppInterface, "com.tencent.msg.permission.pushnotify", null);
      this.mPicSource = 1;
      return;
    }
    catch (Exception paramAppInterface)
    {
      break label113;
    }
  }
  
  private void openInfoCard(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile(localIntent, paramAppInterface, paramContext, paramString, -1);
  }
  
  private void openLocation(Context paramContext, AppInterface paramAppInterface, SessionInfo paramSessionInfo)
  {
    paramAppInterface = this.mTempKey;
    boolean bool = this.mIsNewMenu;
    try
    {
      ((BaseActivity)paramContext).getChatFragment().k().aS();
      Intent localIntent = new Intent(paramContext, PoiMapActivity.class);
      localIntent.putExtra("uintype", paramSessionInfo.a);
      ((BaseActivity)paramContext).startActivityForResult(localIntent, 18);
    }
    catch (Exception paramSessionInfo)
    {
      paramSessionInfo.printStackTrace();
    }
    ((BaseActivity)paramContext).setCanLock(false);
    paramSessionInfo = this.locationResultReceiver;
    if (paramSessionInfo != null) {}
    try
    {
      paramContext.unregisterReceiver(paramSessionInfo);
      label91:
      this.locationResultReceiver = null;
      this.locationResultReceiver = new PublicAccountManagerImpl.13(this, paramAppInterface, bool);
      paramAppInterface = new IntentFilter("com.tencent.biz.pubaccount.locationResultAction");
      paramContext.registerReceiver(this.locationResultReceiver, paramAppInterface, "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception paramSessionInfo)
    {
      break label91;
    }
  }
  
  private void openNewCityWeather(AppInterface paramAppInterface, MqqHandler paramMqqHandler)
  {
    if (paramMqqHandler != null) {
      paramMqqHandler.sendEmptyMessage(19);
    }
    paramMqqHandler = BaseApplicationImpl.getApplication().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    float f1 = paramMqqHandler.getFloat(SearchProtocol.d, 0.0F);
    float f2 = paramMqqHandler.getFloat(SearchProtocol.c, 0.0F);
    ((PublicAccountHandlerImpl)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).sendLocRequest(0, (int)(f2 * 1000000.0F), (int)(f1 * 1000000.0F), 0);
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather((QQAppInterface)paramAppInterface, "aio_news_click");
  }
  
  private void openOtherCity(Context paramContext, AppInterface paramAppInterface)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://ti.qq.com/v2/city-selector/index?_wv=5127&redirect_url=%2F%2Fweather.mp.qq.com%2F&from=aio");
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_weather");
    paramContext.startActivity(localIntent);
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather((QQAppInterface)paramAppInterface, "aio_othercity_click");
  }
  
  private void openScanner(Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", PublicAccountManagerImpl.class.getName());
    localIntent.putExtra("scanForResult", paramBoolean);
    BroadcastReceiver localBroadcastReceiver = this.scanResultReceiver;
    if (localBroadcastReceiver != null) {}
    try
    {
      paramContext.unregisterReceiver(localBroadcastReceiver);
      label50:
      this.scanResultReceiver = null;
      this.scanResultReceiver = new PublicAccountManagerImpl.7(this, paramBoolean, paramMqqHandler);
      paramMqqHandler = new IntentFilter("com.tencent.biz.pubaccount.scanResultAction");
      paramContext.registerReceiver(this.scanResultReceiver, paramMqqHandler, "com.tencent.msg.permission.pushnotify", null);
      RouteUtils.a(paramContext, localIntent, "/qrscan/scanner");
      return;
    }
    catch (Exception localException)
    {
      break label50;
    }
  }
  
  public static void sendPayInfoRequest(Context paramContext, AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface != null) && (paramContext != null))
    {
      if (paramString == null) {
        return;
      }
      paramContext = new NewIntent(paramContext, PublicAccountServletImpl.class);
      paramContext.putExtra("cmd", "send_pay_info");
      mobileqq_mp.SendOrderPayEventRequest localSendOrderPayEventRequest = new mobileqq_mp.SendOrderPayEventRequest();
      localSendOrderPayEventRequest.versionInfo.set("8.8.17,3,5770");
      localSendOrderPayEventRequest.cmd.set(1);
      localSendOrderPayEventRequest.body.set(paramString);
      paramContext.putExtra("data", localSendOrderPayEventRequest.toByteArray());
      paramContext.setObserver(new PublicAccountManagerImpl.16(paramContext));
      paramAppInterface.startServlet(paramContext);
    }
  }
  
  private void sendReportRequest(mobileqq_mp.SendMenuEventRequest paramSendMenuEventRequest)
  {
    BusinessObserver localBusinessObserver = (BusinessObserver)this.mPublicAccountMenuEventObserver.get();
    Context localContext = (Context)this.mTempContext.get();
    AppInterface localAppInterface = (AppInterface)this.mApp.get();
    String str1 = this.mTempUin;
    NewIntent localNewIntent = new NewIntent(localContext, PublicAccountStQWebServletImpl.class);
    localNewIntent.putExtra("cmd", "CertifiedAccountSvc.certified_account_write.SendMenuEvent");
    Object localObject = new PROTOCAL.StQWebReq();
    ((PROTOCAL.StQWebReq)localObject).Seq.set(-1L);
    ((PROTOCAL.StQWebReq)localObject).qua.set(QUA.getQUA3());
    ((PROTOCAL.StQWebReq)localObject).deviceInfo.set(PlatformInfor.g().getDeviceInfor());
    ((PROTOCAL.StQWebReq)localObject).busiBuff.set(ByteStringMicro.copyFrom(paramSendMenuEventRequest.toByteArray()));
    String str2 = CertifiedAccountAbstractServlet.a();
    if (!TextUtils.isEmpty(str2)) {
      ((PROTOCAL.StQWebReq)localObject).traceid.set(str2);
    }
    localObject = ((PROTOCAL.StQWebReq)localObject).toByteArray();
    paramSendMenuEventRequest = (mobileqq_mp.SendMenuEventRequest)localObject;
    if (localObject == null) {
      paramSendMenuEventRequest = new byte[4];
    }
    localNewIntent.putExtra("traceid", str2);
    localNewIntent.putExtra("data", paramSendMenuEventRequest);
    localNewIntent.setObserver(new PublicAccountManagerImpl.14(this, localNewIntent, localContext, str1, localBusinessObserver, localAppInterface));
    if (localAppInterface != null) {
      localAppInterface.startServlet(localNewIntent);
    }
  }
  
  private static void tryHandleOpenApp(AppInterface paramAppInterface, Context paramContext, String paramString1, mobileqq_mp.ButtonInfo paramButtonInfo, String paramString2)
  {
    long l = paramButtonInfo.actionInfo.appid.get();
    Object localObject = Uri.parse(paramString2);
    paramString2 = ((Uri)localObject).getScheme();
    localObject = ((Uri)localObject).getHost();
    if ((!TextUtils.isEmpty(paramString2)) && (AppUtil.a(paramString2)))
    {
      AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
      int i = AppLaucherHelper.a((String)localObject);
      boolean bool = true;
      if (i == 0) {
        i = 0;
      } else {
        i = 1;
      }
      Bundle localBundle = AppLaucherHelper.b((String)localObject);
      int j = localBundle.getInt("a_launch_mode", 268435456);
      if (i != 0) {
        localAppLaucherHelper.a(paramAppInterface, paramContext, String.valueOf(l), (String)localObject, paramString2, j);
      } else {
        bool = AppUtil.a(paramContext, paramString2, localBundle, j);
      }
      if (!bool) {
        oldUrEventHandle(paramAppInterface, paramContext, paramString1, paramButtonInfo);
      }
    }
    else
    {
      oldUrEventHandle(paramAppInterface, paramContext, paramString1, paramButtonInfo);
    }
  }
  
  private void updateMenuSettingLocalDateTime(String paramString, long paramLong)
  {
    this.menuSettingLastSaveDateTimeMap.put(paramString, Long.valueOf(paramLong));
  }
  
  public void addPublicAccountToRu(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface == null) {
      return;
    }
    if (!isFuWuHaoType(paramAppInterface, paramString)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    RecentUserProxy localRecentUserProxy = ((QQAppInterface)paramAppInterface).getProxyManager().g();
    RecentUser localRecentUser = localRecentUserProxy.b(paramString, 1008);
    if (localRecentUser.lastmsgtime < l)
    {
      localRecentUser.lastmsgtime = l;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addPublicAccountToRu->pUin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", currentTime:");
        localStringBuilder.append(l);
        QLog.d("PublicAccountManager", 2, localStringBuilder.toString());
      }
    }
    localRecentUserProxy.b(localRecentUser);
    ThreadManager.executeOnSubThread(new PublicAccountManagerImpl.15(this, paramAppInterface, paramString));
  }
  
  public void clearBroadcastReceiver(Context paramContext)
  {
    BroadcastReceiver localBroadcastReceiver = this.scanResultReceiver;
    if (localBroadcastReceiver != null) {}
    try
    {
      paramContext.unregisterReceiver(localBroadcastReceiver);
      this.scanResultReceiver = null;
      localBroadcastReceiver = this.picResultReceiver;
      if (localBroadcastReceiver == null) {}
    }
    catch (Exception localException2)
    {
      try
      {
        paramContext.unregisterReceiver(localBroadcastReceiver);
        this.picResultReceiver = null;
        localBroadcastReceiver = this.locationResultReceiver;
        if (localBroadcastReceiver == null) {}
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            paramContext.unregisterReceiver(localBroadcastReceiver);
            label52:
            this.locationResultReceiver = null;
            return;
            localException1 = localException1;
          }
          localException2 = localException2;
        }
        catch (Exception paramContext)
        {
          break label52;
        }
      }
    }
  }
  
  public void clearOldPublicAccountData(String paramString)
  {
    if (!this.mKeepOldPublicAccountData)
    {
      this.menuSettingLastSaveDateTimeMap.remove(paramString);
      this.menuSettingSeqnoMap.remove(paramString);
      this.mPublicAccountMenuButtonLists.remove(paramString);
      this.mPublicAccountMenuType.remove(paramString);
      this.mLastReportTime = 0L;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("left menu size:");
      paramString.append(this.mPublicAccountMenuButtonLists.size());
      paramString.append(", ");
      paramString.append(this.mKeepOldPublicAccountData);
      QLog.e("PublicAccountManager", 2, paramString.toString());
    }
  }
  
  public mobileqq_mp.ButtonInfo getButtonInfoByMenuId(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    paramAppInterface = getLocalPublicAccountMenuSetting(paramAppInterface, paramString);
    if (paramAppInterface != null)
    {
      if (paramAppInterface.isEmpty()) {
        return null;
      }
      int i = 0;
      while (i < paramAppInterface.size())
      {
        paramString = (mobileqq_mp.ButtonInfo)paramAppInterface.get(i);
        if ((paramString.id.has()) && (paramString.id.get() == paramInt)) {
          return paramString;
        }
        if (paramString.sub_button.has())
        {
          paramString = paramString.sub_button.get();
          if (paramString.size() > 0)
          {
            int j = 0;
            while (j < paramString.size())
            {
              if ((((mobileqq_mp.ButtonInfo)paramString.get(j)).id.has()) && (((mobileqq_mp.ButtonInfo)paramString.get(j)).id.get() == paramInt)) {
                return (mobileqq_mp.ButtonInfo)paramString.get(j);
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String getCurrentUin()
  {
    return this.mCurrentUin;
  }
  
  List<mobileqq_mp.ButtonInfo> getLocalPublicAccountMenuSetting(AppInterface paramAppInterface, String paramString)
  {
    return (List)this.mPublicAccountMenuButtonLists.get(paramString);
  }
  
  public NewIntent getMenuSetting(Context paramContext, AppInterface paramAppInterface, String paramString, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      if (!paramBoolean)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(l);
        if (!isMenuSettingOutDate(((StringBuilder)localObject1).toString(), paramContext))
        {
          if (QLog.isColorLevel()) {
            QLog.i("PublicAccountManager", 2, "menu setting not outdate yet--");
          }
          return null;
        }
      }
      int i = 0;
      Object localObject1 = this.menuSettingSeqnoMap;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(l);
      if (((Map)localObject1).containsKey(((StringBuilder)localObject2).toString()))
      {
        localObject1 = this.menuSettingSeqnoMap;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(l);
        i = ((Integer)((Map)localObject1).get(((StringBuilder)localObject2).toString())).intValue();
      }
      localObject2 = new mobileqq_mp.GetPublicAccountMenuRequest();
      ((mobileqq_mp.GetPublicAccountMenuRequest)localObject2).seqno.set(i);
      ((mobileqq_mp.GetPublicAccountMenuRequest)localObject2).uin.set((int)l);
      NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountStQWebServletImpl.class);
      localNewIntent.putExtra("cmd", "CertifiedAccountSvc.certified_account_read.GetAccountMenu");
      localObject1 = new PROTOCAL.StQWebReq();
      ((PROTOCAL.StQWebReq)localObject1).Seq.set(-1L);
      ((PROTOCAL.StQWebReq)localObject1).qua.set(QUA.getQUA3());
      ((PROTOCAL.StQWebReq)localObject1).deviceInfo.set(PlatformInfor.g().getDeviceInfor());
      ((PROTOCAL.StQWebReq)localObject1).busiBuff.set(ByteStringMicro.copyFrom(((mobileqq_mp.GetPublicAccountMenuRequest)localObject2).toByteArray()));
      String str = CertifiedAccountAbstractServlet.a();
      if (!TextUtils.isEmpty(str)) {
        ((PROTOCAL.StQWebReq)localObject1).traceid.set(str);
      }
      localObject2 = ((PROTOCAL.StQWebReq)localObject1).toByteArray();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      localNewIntent.putExtra("traceid", str);
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.setObserver(new PublicAccountManagerImpl.2(this, localNewIntent, paramAppInterface, paramString, paramContext, paramBusinessObserver));
      if (paramAppInterface != null) {
        paramAppInterface.startServlet(localNewIntent);
      }
      return localNewIntent;
    }
    catch (NumberFormatException paramContext)
    {
      label385:
      break label385;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("puin is invalid format:");
      paramContext.append(paramString);
      QLog.e("PublicAccountManager", 2, paramContext.toString());
    }
    return null;
  }
  
  public int getMenusettingLocalSeqno(String paramString)
  {
    if (this.menuSettingSeqnoMap.containsKey(paramString)) {
      return ((Integer)this.menuSettingSeqnoMap.get(paramString)).intValue();
    }
    return 0;
  }
  
  public long getMsgID(AppInterface paramAppInterface, String paramString)
  {
    Object localObject = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("history_msg_params_");
    localStringBuilder.append(paramAppInterface.getAccount());
    paramAppInterface = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_msgid");
    return paramAppInterface.getLong(((StringBuilder)localObject).toString(), 0L);
  }
  
  protected int getMsgType(String paramString, int paramInt, AppInterface paramAppInterface)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        switch (paramInt)
        {
        default: 
          break;
        case 9000: 
          return 9;
        case 7230: 
          return 14;
        case 7220: 
          return 15;
        case 7210: 
          return 6;
        case 7120: 
          return 7;
        case 7000: 
          return 13;
        case 6000: 
          return 11;
        case 5000: 
          return 8;
        case 4000: 
          return 10;
        case 3000: 
          return 5;
        case 1024: 
          if (CrmUtils.b((QQAppInterface)paramAppInterface, paramString)) {
            return 2;
          }
        case 1008: 
          if (isFuWuHaoType(paramAppInterface, paramString)) {
            return 1;
          }
          return 0;
        }
        return 12;
      }
      return 4;
    }
    return 3;
  }
  
  public int getPublicAccountAioClass(String paramString, AppInterface paramAppInterface)
  {
    paramAppInterface = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    paramString = (PublicAccountInfo)paramAppInterface.findPublicAccountInfo(localStringBuilder.toString());
    if ((paramString != null) && (paramString.extendType == 2)) {
      return 1;
    }
    return 2;
  }
  
  public List<mobileqq_mp.ButtonInfo> getPublicAccountMenuButtonList(AppInterface paramAppInterface, String paramString)
  {
    return getLocalPublicAccountMenuSetting(paramAppInterface, paramString);
  }
  
  public int getPublicAccountMenuType(String paramString)
  {
    if (this.mPublicAccountMenuType.containsKey(paramString)) {
      return ((Integer)this.mPublicAccountMenuType.get(paramString)).intValue();
    }
    return 0;
  }
  
  public void handleButtonEvent(String paramString1, Context paramContext, AppInterface paramAppInterface, String paramString2, int paramInt1, BusinessObserver paramBusinessObserver, MqqHandler paramMqqHandler, int paramInt2, Object paramObject)
  {
    SessionInfo localSessionInfo = (SessionInfo)paramObject;
    mobileqq_mp.ButtonInfo localButtonInfo = getButtonInfoByMenuId(paramAppInterface, paramString2, paramInt1);
    if (localButtonInfo == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("Can't find menu via menu id:");
        paramString1.append(paramInt1);
        paramString1.append(".");
        QLog.e("PublicAccountManager", 2, paramString1.toString());
      }
      return;
    }
    if ((localSessionInfo.a == 1008) && (((paramInt2 == 1) && (!localButtonInfo.sub_button.has())) || (paramInt2 == 2))) {
      addPublicAccountToRu(paramAppInterface, paramString2);
    }
    int i;
    if (localButtonInfo.type.has()) {
      i = localButtonInfo.type.get();
    } else {
      i = 0;
    }
    paramObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    boolean bool = localButtonInfo.name.has();
    String str = "";
    if (bool) {
      paramString1 = localButtonInfo.name.get();
    } else {
      paramString1 = "";
    }
    paramObject.publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", paramString2, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(paramInt2), String.valueOf(paramInt1), paramString1, String.valueOf(i), false);
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportPubAioMenuAction(paramString2, paramInt1, paramInt2, localButtonInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((i == 2) && (localButtonInfo.url.has())) {
      paramString1 = AbsStructMsgElement.a(localButtonInfo.url.get());
    } else {
      paramString1 = "";
    }
    localStringBuilder.append("MENUID=");
    localStringBuilder.append(String.valueOf(paramInt1));
    localStringBuilder.append(";LEVELID=");
    localStringBuilder.append(String.valueOf(paramInt2));
    localStringBuilder.append(";NAME=");
    if (localButtonInfo.name.has()) {
      paramObject = localButtonInfo.name.get();
    } else {
      paramObject = "";
    }
    localStringBuilder.append(paramObject);
    localStringBuilder.append(";REFERRER=");
    localStringBuilder.append(paramString1);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", paramString2, "0X8005D4B", "0X8005D4B", 0, 0, localStringBuilder.toString(), "", "", "", false);
    this.mPublicAccountMenuEventObserver = new WeakReference(paramBusinessObserver);
    this.mApp = new WeakReference(paramAppInterface);
    this.mTempContext = new WeakReference(paramContext);
    this.mTempUin = paramString2;
    if (localButtonInfo.key.has()) {
      paramString1 = localButtonInfo.key.get();
    } else {
      paramString1 = "";
    }
    this.mTempKey = paramString1;
    if (localButtonInfo.is_new_menu.has()) {
      bool = localButtonInfo.is_new_menu.get();
    } else {
      bool = false;
    }
    this.mIsNewMenu = bool;
    if ((paramContext instanceof BaseActivity))
    {
      paramString1 = ((BaseActivity)paramContext).getChatFragment();
      if (paramString1 != null)
      {
        paramString1 = paramString1.k();
        if ((paramString1 instanceof PublicAccountChatPie))
        {
          paramString1 = (PublicAccountChatPie)paramString1;
          paramString1.bZ += 1;
        }
      }
    }
    paramObject = null;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if (localButtonInfo.event_id.has()) {
          paramInt1 = localButtonInfo.event_id.get();
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 != 1)
        {
          switch (paramInt1)
          {
          default: 
            switch (paramInt1)
            {
            default: 
              return;
            case 1000002: 
              openOtherCity(paramContext, paramAppInterface);
              return;
            }
            openNewCityWeather(paramAppInterface, paramMqqHandler);
            return;
          case 15: 
            openLocation(paramContext, paramAppInterface, localSessionInfo);
            return;
          case 14: 
            openAlbum(paramContext, paramAppInterface, localSessionInfo);
            return;
          case 13: 
            openCamera(paramContext, paramAppInterface, localSessionInfo);
            return;
          case 12: 
            openScanner(paramContext, paramMqqHandler, true);
            return;
          }
          openScanner(paramContext, paramMqqHandler, false);
          return;
        }
        openInfoCard(paramAppInterface, paramContext, paramString2);
        reportEventTypeMenuEvent(null, 0, 1, -1, null);
        return;
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(1001);
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(1001);
      }
      paramBusinessObserver = localButtonInfo.actionInfo.a_actionData.get();
      paramMqqHandler = localButtonInfo.actionInfo.actionData.get();
      paramString1 = paramBusinessObserver;
      if (TextUtils.isEmpty(paramBusinessObserver)) {
        paramString1 = paramMqqHandler;
      }
      paramBusinessObserver = str;
      if (localButtonInfo.url.has()) {
        paramBusinessObserver = localButtonInfo.url.get();
      }
      paramMqqHandler = paramObject;
      if (localButtonInfo.media_id.has()) {
        paramMqqHandler = localButtonInfo.media_id.get();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        oldUrEventHandle(paramAppInterface, paramContext, paramString2, localButtonInfo);
        return;
      }
      paramObject = JumpParser.a((QQAppInterface)paramAppInterface, paramContext, paramString1);
      if (paramObject == null)
      {
        if (localButtonInfo.actionInfo.appid.has())
        {
          tryHandleOpenApp(paramAppInterface, paramContext, paramString2, localButtonInfo, paramString1);
          return;
        }
        oldUrEventHandle(paramAppInterface, paramContext, paramString2, localButtonInfo);
        reportUrlTypeMenuEvent(paramBusinessObserver, (mobileqq_mp.ActionInfo)localButtonInfo.actionInfo.get(), paramMqqHandler);
        return;
      }
      if (TextUtils.isEmpty(paramObject.i()))
      {
        tryHandleOpenApp(paramAppInterface, paramContext, paramString2, localButtonInfo, paramString1);
        return;
      }
      if (!paramObject.a())
      {
        oldUrEventHandle(paramAppInterface, paramContext, paramString2, localButtonInfo);
        reportUrlTypeMenuEvent(paramBusinessObserver, (mobileqq_mp.ActionInfo)localButtonInfo.actionInfo.get(), paramMqqHandler);
      }
    }
    else
    {
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(1001);
      }
      if ((localButtonInfo.is_need_lbs.has()) && (localButtonInfo.is_need_lbs.get()))
      {
        new Thread(this.getLocationThread).start();
        return;
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(19);
      }
      if (localButtonInfo.media_id.has()) {
        paramString1 = localButtonInfo.media_id.get();
      } else {
        paramString1 = null;
      }
      reportClickTypeMenuEvent(false, 0.0D, 0.0D, null, paramString1, this.mTempKey, this.mIsNewMenu);
    }
  }
  
  public void handleUrlEvent(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountBrowserImpl.class);
    localIntent.putExtra("from", QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("click_from", paramString3);
    localIntent.putExtra("uin", paramAppInterface.getCurrentAccountUin());
    localIntent.putExtra("puin", paramString2);
    localIntent.putExtra("assignBackText", paramContext.getResources().getString(2131887625));
    localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(paramString2));
    paramContext.startActivity(localIntent);
  }
  
  public boolean hasPreloadWebProcessor()
  {
    return this.hasPreloadWebProcessor;
  }
  
  public void init(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, IPublicAccountManager.InitDoneObserver paramInitDoneObserver)
  {
    if ((paramString1 != null) && (!paramString1.equals(this.mCurrentUin))) {
      clearOldPublicAccountData(paramString1);
    }
    this.mCurrentUin = paramString1;
    ThreadManager.executeOnSubThread(new PublicAccountManagerImpl.1(this, paramString2, paramAppInterface, paramInitDoneObserver, paramContext));
  }
  
  public boolean preloadWebProcess(AppInterface paramAppInterface)
  {
    if (NetConnInfoCenter.getServerTimeMillis() < this.lastPreloadWebProcessorTime + 35000L) {
      return false;
    }
    this.lastPreloadWebProcessorTime = NetConnInfoCenter.getServerTimeMillis();
    if (!DeviceInfoUtil.U())
    {
      if (FileUtils.getAvailableInnernalMemorySize() <= 1.048576E+008F) {
        return false;
      }
      paramAppInterface = (IWebProcessManagerService)paramAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      if (paramAppInterface != null) {
        paramAppInterface.startWebProcess(-1, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager", 2, "startWebProcess  startWebProcess by userlist ad");
      }
      return true;
    }
    return false;
  }
  
  public NewIntent refuseFollowAccount(String paramString, int paramInt, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, IPublicAccountManager.refuseAcceptDone paramrefuseAcceptDone)
  {
    paramContext = new NewIntent(paramContext, PublicAccountServletImpl.class);
    paramContext.putExtra("cmd", "set_refuse_follow");
    mobileqq_mp.SetRefuseFollowRequest localSetRefuseFollowRequest = new mobileqq_mp.SetRefuseFollowRequest();
    localSetRefuseFollowRequest.luin.set(Long.parseLong(paramString));
    localSetRefuseFollowRequest.account_type.set(1);
    localSetRefuseFollowRequest.refuse_forever.set(paramBoolean);
    if (!paramBoolean) {
      localSetRefuseFollowRequest.refuse_period.set(paramInt);
    }
    paramContext.putExtra("data", localSetRefuseFollowRequest.toByteArray());
    paramContext.setObserver(new PublicAccountManagerImpl.5(this, paramContext, paramrefuseAcceptDone));
    if (paramAppInterface != null) {
      paramAppInterface.startServlet(paramContext);
    }
    return paramContext;
  }
  
  public void refuseFollowAccountCancelCallback(NewIntent paramNewIntent)
  {
    if (paramNewIntent != null) {
      paramNewIntent.setObserver(null);
    }
  }
  
  public void removeMsgID(AppInterface paramAppInterface, String paramString)
  {
    Object localObject = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("history_msg_params_");
    localStringBuilder.append(paramAppInterface.getAccount());
    paramAppInterface = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_msgid");
    paramAppInterface.remove(((StringBuilder)localObject).toString()).commit();
  }
  
  public void reportClickTypeMenuEvent(boolean paramBoolean1, double paramDouble1, double paramDouble2, String paramString1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    paramString3 = initSendMenuEventRequest(1, paramString3, paramBoolean2);
    if (paramString3 != null)
    {
      if (paramBoolean1)
      {
        paramString3.is_need_lbs.set(true);
        paramString3.latitude.set(paramDouble1);
        paramString3.longitude.set(paramDouble2);
      }
      if (paramString1 != null) {
        paramString3.lbsAddressLabel.set(paramString1);
      }
      if (paramString2 != null) {
        paramString3.media_id.set(paramString2);
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("is_need_lbs:");
        paramString1.append(paramString3.is_need_lbs.get());
        paramString1.append(" latitude:");
        paramString1.append(paramString3.latitude.get());
        paramString1.append(" longitude:");
        paramString1.append(paramString3.longitude.get());
        paramString1.append(" lbsAddressLabel:");
        paramString1.append(paramString3.lbsAddressLabel.get());
        paramString1.append(" media_id:");
        paramString1.append(paramString3.media_id.get());
        QLog.d("PublicAccountManager-Click:", 2, paramString1.toString());
      }
      sendReportRequest(paramString3);
    }
  }
  
  public void reportEventTypeMenuEvent(String paramString, int paramInt1, int paramInt2, int paramInt3, List<String> paramList)
  {
    mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = initSendMenuEventRequest(3, this.mTempKey, this.mIsNewMenu);
    if (localSendMenuEventRequest != null)
    {
      localSendMenuEventRequest.event_id.set(paramInt2);
      if (paramString != null)
      {
        localSendMenuEventRequest.scan_result.set(paramString);
        localSendMenuEventRequest.scanType.set(paramInt1);
      }
      if (paramInt3 >= 0) {
        localSendMenuEventRequest.pictureCount.set(paramInt3);
      }
      if (paramList != null) {
        localSendMenuEventRequest.picture_Md5s.set(paramList);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("event_id:");
        paramString.append(localSendMenuEventRequest.event_id.get());
        paramString.append(" scan_result:");
        paramString.append(localSendMenuEventRequest.scan_result.get());
        paramString.append(" pictureCount:");
        paramString.append(localSendMenuEventRequest.pictureCount.get());
        QLog.d("PublicAccountManager-Event:", 2, paramString.toString());
      }
      sendReportRequest(localSendMenuEventRequest);
    }
  }
  
  public void reportEventTypeMenuEventLocation(double paramDouble1, double paramDouble2, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = initSendMenuEventRequest(3, paramString2, paramBoolean);
    if (paramString2 != null)
    {
      paramString2.is_need_lbs.set(true);
      paramString2.latitude.set(paramDouble1);
      paramString2.longitude.set(paramDouble2);
      paramString2.event_id.set(15);
      if (paramString1 != null) {
        paramString2.lbsAddressLabel.set(paramString1);
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("event_id:");
        paramString1.append(paramString2.event_id.get());
        paramString1.append(" is_need_lbs:");
        paramString1.append(paramString2.is_need_lbs.get());
        paramString1.append(" latitude:");
        paramString1.append(paramString2.latitude.get());
        paramString1.append(" longitude:");
        paramString1.append(paramString2.longitude.get());
        paramString1.append(" lbsAddressLabel:");
        paramString1.append(paramString2.lbsAddressLabel.get());
        QLog.d("PublicAccountManager-Location:", 2, paramString1.toString());
      }
      sendReportRequest(paramString2);
    }
  }
  
  public void reportRecentList(AppInterface paramAppInterface)
  {
    if (this.mLastReportTime == 0L)
    {
      localObject1 = paramAppInterface.getApplication();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sp_public_account_with_cuin_");
      ((StringBuilder)localObject2).append(paramAppInterface.getCurrentAccountUin());
      localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
      if (localObject1 != null) {
        this.mLastReportTime = ((SharedPreferences)localObject1).getLong("recentlist_reported", 0L);
      }
    }
    Object localObject1 = new Date(this.mLastReportTime);
    Object localObject2 = new Date(NetConnInfoCenter.getServerTimeMillis());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportRecentList today = ");
      localStringBuilder.append(localSimpleDateFormat.format((Date)localObject2));
      localStringBuilder.append(";lastdate = ");
      localStringBuilder.append(localSimpleDateFormat.format((Date)localObject1));
      QLog.d("PublicAccountManager", 2, localStringBuilder.toString());
    }
    if (localSimpleDateFormat.format((Date)localObject2).equals(localSimpleDateFormat.format((Date)localObject1))) {
      return;
    }
    localObject1 = getRecentReportDate((QQAppInterface)paramAppInterface);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reportRecentList recentList= ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("PublicAccountManager", 2, ((StringBuilder)localObject2).toString());
    }
    ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X800661D", "0X800661D", 0, 0, "", "", (String)localObject1, "");
    this.mLastReportTime = NetConnInfoCenter.getServerTimeMillis();
    localObject1 = paramAppInterface.getApplication();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sp_public_account_with_cuin_");
    ((StringBuilder)localObject2).append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.edit();
      paramAppInterface.putLong("recentlist_reported", this.mLastReportTime);
      paramAppInterface.commit();
    }
  }
  
  public void reportUrlTypeMenuEvent(String paramString1, mobileqq_mp.ActionInfo paramActionInfo, String paramString2)
  {
    mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = initSendMenuEventRequest(2, this.mTempKey, this.mIsNewMenu);
    if (localSendMenuEventRequest != null)
    {
      localSendMenuEventRequest.url.set(paramString1);
      localSendMenuEventRequest.actionInfo.set(paramActionInfo);
      if (paramString2 != null) {
        localSendMenuEventRequest.media_id.set(paramString2);
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("url:");
        paramString1.append(localSendMenuEventRequest.url.get());
        paramString1.append(" actionInfo:");
        paramString1.append(localSendMenuEventRequest.actionInfo.get());
        paramString1.append(" media_id:");
        paramString1.append(localSendMenuEventRequest.media_id.get());
        QLog.d("PublicAccountManager-Url:", 2, paramString1.toString());
      }
      sendReportRequest(localSendMenuEventRequest);
    }
  }
  
  public void requestQidiKefu(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, BusinessObserver paramBusinessObserver)
  {
    String str = "QD";
    BaseActivity localBaseActivity = (BaseActivity)paramActivity;
    this.mTempUin = paramString1;
    this.mTempContext = new WeakReference(localBaseActivity);
    paramActivity = new JSONObject();
    try
    {
      paramActivity.put("app", "QD");
      if (paramString2 != null) {
        paramActivity.put("assignType", Long.parseLong(paramString2));
      }
      if (paramString3 != null) {
        paramActivity.put("assignKey", Long.parseLong(paramString3));
      }
      if (paramString4 != null) {
        paramActivity.put("ext", paramString4);
      }
      i = 0;
    }
    catch (Exception paramString1)
    {
      int i;
      label103:
      break label103;
    }
    i = 1;
    if (i != 0) {
      paramActivity = str;
    } else {
      paramActivity = paramActivity.toString();
    }
    paramActivity = initSendMenuEventRequest(1, paramActivity, false);
    if (paramActivity == null) {
      return;
    }
    paramActivity.menu_type.set(1001);
    paramString1 = (AppInterface)this.mApp.get();
    paramString1 = this.mTempUin;
    paramString2 = new NewIntent(localBaseActivity, PublicAccountStQWebServletImpl.class);
    paramString2.putExtra("cmd", "CertifiedAccountSvc.certified_account_write.SendMenuEvent");
    paramString1 = new PROTOCAL.StQWebReq();
    paramString1.Seq.set(-1L);
    paramString1.qua.set(QUA.getQUA3());
    paramString1.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
    paramString1.busiBuff.set(ByteStringMicro.copyFrom(paramActivity.toByteArray()));
    paramString3 = CertifiedAccountAbstractServlet.a();
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.traceid.set(paramString3);
    }
    paramString1 = paramString1.toByteArray();
    paramActivity = paramString1;
    if (paramString1 == null) {
      paramActivity = new byte[4];
    }
    paramString2.putExtra("traceid", paramString3);
    paramString2.putExtra("data", paramActivity);
    paramString2.setObserver(paramBusinessObserver);
    if (localBaseActivity.app != null) {
      localBaseActivity.app.startServlet(paramString2);
    }
  }
  
  public void savePublicAccountMenuSetting(AppInterface paramAppInterface, String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountManager", 4, "savePublicAccountMenuSetting");
    }
    if (paramGetPublicAccountMenuResponse == null) {
      return;
    }
    if (paramAppInterface == null) {
      return;
    }
    int i;
    if (paramGetPublicAccountMenuResponse.seqno.has()) {
      i = paramGetPublicAccountMenuResponse.seqno.get();
    } else {
      i = 0;
    }
    updateMenuSettingLocalSeqno(paramString, i);
    long l = System.currentTimeMillis();
    updateMenuSettingLocalDateTime(paramString, l);
    if (paramGetPublicAccountMenuResponse.toByteArray() == null) {
      return;
    }
    Object localObject = paramAppInterface.getEntityManagerFactory().createEntityManager();
    PublicAccountMenuEntity localPublicAccountMenuEntity1 = new PublicAccountMenuEntity(paramString, paramGetPublicAccountMenuResponse, l);
    if (((EntityManager)localObject).find(PublicAccountMenuEntity.class, paramString) != null)
    {
      PublicAccountMenuEntity localPublicAccountMenuEntity2 = (PublicAccountMenuEntity)((EntityManager)localObject).find(PublicAccountMenuEntity.class, paramString);
      if (localPublicAccountMenuEntity2 != null)
      {
        localPublicAccountMenuEntity2.clone(localPublicAccountMenuEntity1);
        ((EntityManager)localObject).update(localPublicAccountMenuEntity2);
      }
      else
      {
        ((EntityManager)localObject).persist(localPublicAccountMenuEntity1);
      }
    }
    else
    {
      ((EntityManager)localObject).persist(localPublicAccountMenuEntity1);
    }
    ((EntityManager)localObject).close();
    localObject = paramGetPublicAccountMenuResponse.button_info.get();
    l = localPublicAccountMenuEntity1.savedDateTime;
    this.menuSettingLastSaveDateTimeMap.put(paramString, Long.valueOf(l));
    this.mPublicAccountMenuButtonLists.put(paramString, localObject);
    if (paramGetPublicAccountMenuResponse.menu_type.has()) {
      i = paramGetPublicAccountMenuResponse.menu_type.get();
    } else {
      i = 0;
    }
    this.mPublicAccountMenuType.put(paramString, Integer.valueOf(i));
    if (i != 0)
    {
      if (i == 1) {
        paramGetPublicAccountMenuResponse = "icon";
      } else {
        paramGetPublicAccountMenuResponse = "text";
      }
      ReportController.a(paramAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC2", "0X8005EC2", 0, 0, paramString, paramGetPublicAccountMenuResponse, "", "");
      if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null) && (((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.has()) && (((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.get() != null)) {
        ReportController.a(paramAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC3", "0X8005EC3", 0, 0, paramString, String.valueOf(((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.get().size()), "", "");
      }
    }
  }
  
  public void sendMenuEventequest(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver)
  {
    sendMenuEventequest(paramContext, paramAppInterface, paramString1, paramString2, paramBoolean, paramDouble1, paramDouble2, paramBusinessObserver, 1, 0L, 0);
  }
  
  public void sendMenuEventequest(Context paramContext, AppInterface paramAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver, int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("uin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("type:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("msg_id:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("s_type");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("reportsendMenuEventequest", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      localObject = new mobileqq_mp.SendMenuEventRequest();
      ((mobileqq_mp.SendMenuEventRequest)localObject).key.set(paramString2);
      ((mobileqq_mp.SendMenuEventRequest)localObject).uin.set((int)l);
      ((mobileqq_mp.SendMenuEventRequest)localObject).type.set(paramInt1);
      ((mobileqq_mp.SendMenuEventRequest)localObject).msg_id.set(paramLong);
      ((mobileqq_mp.SendMenuEventRequest)localObject).s_type.set(paramInt2);
      ((mobileqq_mp.SendMenuEventRequest)localObject).menu_type.set(getPublicAccountMenuType(paramString1));
      if (paramBoolean)
      {
        ((mobileqq_mp.SendMenuEventRequest)localObject).is_need_lbs.set(true);
        ((mobileqq_mp.SendMenuEventRequest)localObject).latitude.set(paramDouble1);
        ((mobileqq_mp.SendMenuEventRequest)localObject).longitude.set(paramDouble2);
      }
      NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountStQWebServletImpl.class);
      localNewIntent.putExtra("cmd", "CertifiedAccountSvc.certified_account_write.SendMenuEvent");
      paramString2 = new PROTOCAL.StQWebReq();
      paramString2.Seq.set(-1L);
      paramString2.qua.set(QUA.getQUA3());
      paramString2.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
      paramString2.busiBuff.set(ByteStringMicro.copyFrom(((mobileqq_mp.SendMenuEventRequest)localObject).toByteArray()));
      String str = CertifiedAccountAbstractServlet.a();
      if (!TextUtils.isEmpty(str)) {
        paramString2.traceid.set(str);
      }
      localObject = paramString2.toByteArray();
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = new byte[4];
      }
      localNewIntent.putExtra("traceid", str);
      localNewIntent.putExtra("data", paramString2);
      localNewIntent.setObserver(new PublicAccountManagerImpl.3(this, localNewIntent, paramContext, paramString1, paramBusinessObserver, paramAppInterface));
      if (paramAppInterface != null) {
        paramAppInterface.startServlet(localNewIntent);
      }
      return;
    }
    catch (NumberFormatException paramContext)
    {
      label410:
      break label410;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("puin is invalid format:");
      paramContext.append(paramString1);
      QLog.e("PublicAccountManager", 2, paramContext.toString());
    }
  }
  
  public NewIntent sendMsgArriveReceipt(Context paramContext, AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountManager", 2, String.format("sendMsgArriveReceipt request: msgId:%d msgOp:%d pcuin:%d cuin:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt) }));
    }
    paramContext = new NewIntent(paramContext, PublicAccountServletImpl.class);
    paramContext.putExtra("cmd", "send_msg_receipt");
    mobileqq_mp.SendPublicAccountMessageReceiptRequest localSendPublicAccountMessageReceiptRequest = new mobileqq_mp.SendPublicAccountMessageReceiptRequest();
    if (paramInt == 1)
    {
      localSendPublicAccountMessageReceiptRequest.uint64_unique_id.set(paramLong1);
      localSendPublicAccountMessageReceiptRequest.uint32_op.set(paramLong2);
    }
    else if (paramInt == 2)
    {
      localSendPublicAccountMessageReceiptRequest.unique_ids.set(paramList);
    }
    localSendPublicAccountMessageReceiptRequest.receipt_type.set(paramInt);
    localSendPublicAccountMessageReceiptRequest.pcuin.set(paramLong3);
    localSendPublicAccountMessageReceiptRequest.cuin.set(paramLong4);
    paramContext.putExtra("data", localSendPublicAccountMessageReceiptRequest.toByteArray());
    paramContext.setObserver(new PublicAccountManagerImpl.6(this, paramContext));
    if (paramAppInterface != null)
    {
      paramAppInterface.startServlet(paramContext);
      if (TextUtils.equals("2290230341", String.valueOf(paramLong3))) {
        ((IQzoneRuntimeService)paramAppInterface.getRuntimeService(IQzoneRuntimeService.class, "")).preloadContentBox();
      }
    }
    return paramContext;
  }
  
  public void setHasPreloadWebProcessor(boolean paramBoolean)
  {
    this.hasPreloadWebProcessor = paramBoolean;
  }
  
  public void setKeepOldPublicAccountData(boolean paramBoolean)
  {
    this.mKeepOldPublicAccountData = paramBoolean;
  }
  
  public void setMsgID(AppInterface paramAppInterface, String paramString, long paramLong)
  {
    Object localObject = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("history_msg_params_");
    localStringBuilder.append(paramAppInterface.getAccount());
    paramAppInterface = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_msgid");
    paramAppInterface.putLong(((StringBuilder)localObject).toString(), paramLong).commit();
  }
  
  public void updateMenuSettingLocalSeqno(String paramString, int paramInt)
  {
    this.menuSettingSeqnoMap.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl
 * JD-Core Version:    0.7.0.1
 */