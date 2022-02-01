package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoySpEventReportUtil;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.HotWordInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.HotWordItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.BasePublicAccountUtil;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.NewPublicAccountServlet;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.applets.PublicAccountIntent;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpResponseBean;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.RetInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class PublicAccountUtilImpl
  implements IPublicAccountUtil
{
  public static final String AB_TEST_LOADTIME = "ab_test_loadtime_";
  public static final String AB_TEST_SHAREPRE = "ab_test_sharePre";
  public static final String AB_TEST_SWITCH = "ab_test_switch_";
  private static volatile int DELETE_OLDKANDIAN_FLAG;
  private static Object LOCK = new Object();
  private static String TAG_DELETE_OLDKANDIAN_FLAG;
  private static boolean isComeFromReadInjoy;
  public static long lastRequestLbsTime = 0L;
  static QQCustomDialog mOpenIdConfirmDlg;
  public static MqqHandler publicAccountAIOuiHandler = null;
  private static WeakReference<Handler> qqLsHandler;
  
  static
  {
    isComeFromReadInjoy = false;
    qqLsHandler = null;
    DELETE_OLDKANDIAN_FLAG = -1;
    TAG_DELETE_OLDKANDIAN_FLAG = "tag_delete_oldkandian_flag";
  }
  
  private static boolean WenHao(String paramString1, String paramString2)
  {
    if (paramString1.length() != paramString2.length()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramString2.length()) {
        break label53;
      }
      if ((paramString1.charAt(i) != paramString2.charAt(i)) && (paramString2.charAt(i) != '?')) {
        break;
      }
      i += 1;
    }
    label53:
    return true;
  }
  
  private static boolean XingHao(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    int m = paramString1.length();
    int k = paramString2.length();
    int n = paramString2.indexOf("*");
    int i;
    boolean bool1;
    switch (n)
    {
    default: 
      i = 0;
      if (i < n) {
        if (paramString1.charAt(i) != paramString2.charAt(i)) {
          bool1 = false;
        }
      }
      break;
    case -1: 
    case 0: 
      label72:
      do
      {
        do
        {
          return bool1;
          if (m != k) {
            break;
          }
          bool1 = bool2;
        } while (m == 0);
        i = 0;
        for (;;)
        {
          bool1 = bool2;
          if (i >= k) {
            break;
          }
          if (paramString1.charAt(i) != paramString2.charAt(i)) {
            return false;
          }
          i += 1;
        }
        return false;
        bool1 = bool2;
      } while (k == 1);
      i = 0;
      label139:
      if (i < m) {
        if ((paramString1.charAt(i) != paramString2.charAt(n + 1)) && (paramString2.charAt(n + 1) != '*')) {}
      }
      break;
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        return false;
        i += 1;
        break label139;
      }
      bool1 = bool2;
      if (i == m) {
        break label72;
      }
      return XingHao(paramString1.substring(i, m), paramString2.substring(n + 1, k));
      i += 1;
      break;
      return XingHao(paramString1.substring(n, m), paramString2.substring(n, k));
      i = 0;
    }
  }
  
  public static String bytesToString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(paramArrayOfByte[i]).append(",");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static boolean cantGotoProfile(Context paramContext, ProfileParams paramProfileParams)
  {
    return (paramContext == null) || (paramProfileParams == null) || (paramProfileParams.a() == null) || (TextUtils.isEmpty(paramProfileParams.a()));
  }
  
  private static MessageForStructing configureStructingMsgWithFields(MessageForStructing paramMessageForStructing, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMessageForStructing == null) || (!(paramMessageForStructing instanceof MessageForStructing)) || (!paramMessageForStructing.isread)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(paramMessageForStructing.msgtype);
    localMessageForStructing.copyStructingMsg(paramMessageForStructing);
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramMessageForStructing)
    {
      for (;;)
      {
        paramMessageForStructing.printStackTrace();
      }
    }
  }
  
  private static boolean containLbsUin(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localPublicAccountHandler.jdField_a_of_type_JavaUtilList == null)
    {
      EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      localPublicAccountHandler.jdField_a_of_type_JavaUtilList = localEntityManager.query(UinPair.class, false, "userUin=? ", new String[] { paramQQAppInterface.getCurrentAccountUin() }, null, null, null, null);
      localEntityManager.close();
      if (localPublicAccountHandler.jdField_a_of_type_JavaUtilList == null) {
        localPublicAccountHandler.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
    }
    return localPublicAccountHandler.jdField_a_of_type_JavaUtilList.contains(paramString);
  }
  
  private static void createFakeStructingMsgWithFields(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (ReadInJoyHelper.a(paramQQAppInterface))
    {
      localObject = (KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      paramQQAppInterface = paramString1;
      if (!TextUtils.isEmpty(paramString3)) {
        paramQQAppInterface = paramString3 + ": " + paramString1;
      }
      ((KandianMergeManager)localObject).a(paramQQAppInterface, paramString2, paramInt, paramBoolean);
    }
    do
    {
      return;
      localObject = paramQQAppInterface.getMessageFacade();
    } while (localObject == null);
    ThreadManager.post(new PublicAccountUtilImpl.18((QQMessageFacade)localObject, paramString3, paramString1, paramString2, paramQQAppInterface), 10, null, false);
  }
  
  private static void displayToast(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  private int getAccountType(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int j = getAccountType(paramQQAppInterface, paramString);
    int i = j;
    if (j == -1) {
      i = getAccountType(paramInt);
    }
    return i;
  }
  
  private static PaConfigAttr.PaConfigInfo getConfigInfo(AccountDetail paramAccountDetail, int paramInt1, int paramInt2)
  {
    if ((paramAccountDetail.paConfigAttrs == null) || (paramAccountDetail.paConfigAttrs.isEmpty())) {
      return null;
    }
    PaConfigAttr.PaConfigInfo localPaConfigInfo;
    do
    {
      paramAccountDetail = paramAccountDetail.paConfigAttrs.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!paramAccountDetail.hasNext()) {
            break;
          }
          localObject = (PaConfigAttr)paramAccountDetail.next();
        } while (((PaConfigAttr)localObject).jdField_a_of_type_Int != paramInt1);
        localObject = ((PaConfigAttr)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPaConfigInfo = (PaConfigAttr.PaConfigInfo)((Iterator)localObject).next();
    } while (localPaConfigInfo.c != paramInt2);
    return localPaConfigInfo;
    return null;
  }
  
  private static String getNonNullObejct(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return String.valueOf(paramObject);
  }
  
  private static int getSubscriptCount(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (paramQQAppInterface == null) {}
    }
    for (int i = paramQQAppInterface.c().size();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "getSubscriptCount count: " + i);
      }
      return i;
    }
  }
  
  private void gotoAIO(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoAIO app: " + paramQQAppInterface + " | context: " + paramContext + " | uin: " + paramString + " | accountFlag: " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject1 != null)
    {
      localObject1 = ((PublicAccountDataManager)localObject1).c(paramString);
      if (localObject1 == null) {}
    }
    for (localObject1 = ((PublicAccountInfo)localObject1).name;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramString;
      }
      int i = getAccountType(paramQQAppInterface, paramString, paramInt);
      paramQQAppInterface = new Intent(paramContext, ChatActivity.class);
      paramInt = 1008;
      if (i == -7)
      {
        paramQQAppInterface.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      paramQQAppInterface.putExtra("uin", paramString);
      paramQQAppInterface.putExtra("uintype", paramInt);
      paramQQAppInterface.putExtra("uinname", (String)localObject2);
      paramQQAppInterface.putExtra("leftViewText", paramContext.getString(2131690778));
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
  }
  
  private void gotoProfile(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (cantGotoProfile(paramActivity, paramProfileParams)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, PublicAccountDetailActivityImpl.class);
    localIntent.addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("profile_params", paramProfileParams);
    localBundle.putString("pkg_name", paramActivity.getIntent().getStringExtra("pkg_name"));
    localIntent.putExtras(localBundle);
    gotoProfileDueToAccountFlag(paramActivity, paramQQAppInterface, paramProfileParams.b(), paramProfileParams.a(), localIntent);
  }
  
  private void gotoProfileAndFinishActivity(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    gotoProfile(paramActivity, paramQQAppInterface, paramProfileParams);
    paramActivity.finish();
  }
  
  private void gotoProfileDueToAccountFlag(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    switch (getAccountType(paramQQAppInterface, paramString, paramInt))
    {
    default: 
      openPublicAccountProfile(paramIntent, paramContext, paramString);
    case -6: 
      return;
    }
    CrmUtils.a(paramContext, paramIntent, paramString, false, -1, true, -1);
  }
  
  private static boolean isLike(String paramString1, String paramString2)
  {
    if (paramString2.indexOf("?") != -1) {
      return WenHao(paramString1, paramString2);
    }
    if (paramString2.indexOf("*") != -1) {
      return XingHao(paramString1, paramString2);
    }
    return false;
  }
  
  private boolean isMediaAndOtherSubscript(int paramInt)
  {
    boolean bool = false;
    paramInt = getAccountType(paramInt);
    if ((paramInt == -3) || (paramInt == -4)) {
      bool = true;
    }
    return bool;
  }
  
  private static long macToLong(String paramString)
  {
    try
    {
      paramString = paramString.split(":");
      if (paramString.length == 6)
      {
        int j = 40;
        int i = 0;
        long l1 = 0L;
        while (i < paramString.length)
        {
          long l2 = Long.parseLong(paramString[i], 16);
          long l3 = l2;
          if (j > 0) {
            l3 = l2 << j;
          }
          l1 += l3;
          j -= 8;
          i += 1;
        }
        return l1;
      }
    }
    catch (Exception paramString)
    {
      return 0L;
    }
    return 0L;
  }
  
  private static void newKanDianOidbReport(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = paramQQAppInterface.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mAlgorithmId = paramInt1;
    localReportInfo.mOperation = paramInt3;
    localReportInfo.mOpSource = 3;
    localReportInfo.mStrategyId = paramInt2;
    localArrayList.add(localReportInfo);
    new UserOperationModule(paramQQAppInterface, null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
  }
  
  private static MessageForStructing newStructingMsgWithFields(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
    localMessageForStructing.structingMsg = StructMsgFactory.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.selfuin = paramQQAppInterface.getCurrentUin();
    localMessageForStructing.frienduin = AppConstants.NEW_KANDIAN_UIN;
    localMessageForStructing.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageForStructing.istroop = 1008;
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private static void openBmqqProfile(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 104));
      paramIntent.putExtra("uin", paramString);
      paramContext.startActivity(paramIntent);
      return;
      paramIntent.setClassName(paramContext, QidianProfileCardActivity.class.getName());
    }
  }
  
  private static void openBmqqProfileForResult(Intent paramIntent, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 104));
      paramIntent.putExtra("uin", paramString);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      return;
      paramIntent.setClassName(paramActivity, QidianProfileCardActivity.class.getName());
    }
  }
  
  private static void openPublicAccountProfileForResult(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt2)
    {
    }
    while (paramBoolean)
    {
      paramQQAppInterface = ReadInJoyConstants.k + Base64Util.encodeToString(paramString.getBytes(), 0);
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (ViolaAccessHelper.b(paramQQAppInterface)))
      {
        ViolaAccessHelper.a(paramActivity, null, ViolaAccessHelper.c(paramQQAppInterface), null);
        return;
        PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
      }
      else
      {
        paramIntent = new Intent(paramActivity, PublicAccountBrowserImpl.class);
        paramIntent.putExtra("url", paramQQAppInterface);
        paramActivity.startActivityForResult(paramIntent, paramInt1);
        return;
      }
    }
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, PublicAccountDetailActivityImpl.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.putExtra("source", 5);
      paramIntent.addFlags(67108864);
      break;
      paramIntent.setClassName(paramActivity, PublicAccountDetailActivityImpl.class.getName());
    }
  }
  
  private static void removeMail(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new PublicAccountUtilImpl.1(paramQQAppInterface, paramContext, paramString));
  }
  
  private static void reportPublicAccountPushRedDotExposure(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {}
    MessageRecord localMessageRecord;
    String str;
    do
    {
      do
      {
        return;
        localMessageRecord = localQQAppInterface.getMessageFacade().b(paramString, 1008);
      } while ((localMessageRecord == null) || (localMessageRecord.isread));
      str = localMessageRecord.getExtInfoFromExtStr("has_report");
    } while ((!TextUtils.isEmpty(str)) && ("1".equals(str)));
    localMessageRecord.saveExtInfoToExtStr("has_report", "1");
    localQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 1008, localMessageRecord.uniseq, "extStr", localMessageRecord.extStr);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009A7C", "0X8009A7C", 0, 0, paramString, "", "", "", false);
  }
  
  private static void saveLbsUin(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localPublicAccountHandler.jdField_a_of_type_JavaUtilList == null) {
      localPublicAccountHandler.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    localPublicAccountHandler.jdField_a_of_type_JavaUtilList.add(paramString);
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.persist(paramString);
    paramQQAppInterface.close();
  }
  
  private static void sendDelMailReq(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    label40:
    label302:
    label309:
    for (;;)
    {
      return;
      int i = paramString.indexOf("?");
      if (i != -1)
      {
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        if (i < paramString.length) {
          if (!paramString[i].startsWith("url=")) {}
        }
        for (paramString = URLDecoder.decode(paramString[i].split("=")[1]);; paramString = "")
        {
          if (TextUtils.isEmpty(paramString)) {
            break label309;
          }
          i = paramString.indexOf("?");
          if (i == -1) {
            break;
          }
          paramString = paramString.substring(i + 1).split("&");
          paramQQAppInterface.getCurrentAccountUin();
          i = 0;
          label114:
          if (i < paramString.length) {
            if (!paramString[i].startsWith("mailid=")) {}
          }
          for (paramString = paramString[i].split("=")[1];; paramString = "")
          {
            if (TextUtils.isEmpty(paramString)) {
              break label302;
            }
            paramQQAppInterface = String.format("https://w.mail.qq.com/cgi-bin/login?mailid=%1$s&target=mobileqqdel&fwd=mq&uin=%2$s&fun=from3g", new Object[] { paramString, paramQQAppInterface.getCurrentAccountUin() });
            try
            {
              paramQQAppInterface = HttpBaseUtil.a(paramQQAppInterface, "GET", new Bundle(), null).a;
              i = j;
              if (paramQQAppInterface.getStatusLine().getStatusCode() == 200)
              {
                paramQQAppInterface = new JSONObject(HttpBaseUtil.a(paramQQAppInterface));
                i = j;
                if (paramQQAppInterface.has("ret"))
                {
                  int k = paramQQAppInterface.getInt("ret");
                  i = j;
                  if (k == 0) {
                    i = 1;
                  }
                }
              }
            }
            catch (Exception paramQQAppInterface)
            {
              for (;;)
              {
                i = j;
              }
            }
            if (i != 0) {
              break;
            }
            ThreadManager.getUIHandler().post(new PublicAccountUtilImpl.2(paramContext));
            return;
            i += 1;
            break label40;
            i += 1;
            break label114;
          }
          break;
        }
      }
    }
  }
  
  private static void sendDetailInfoRequest(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.5.5,3,5105");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      label92:
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new PublicAccountUtilImpl.9(paramContext, paramAppInterface, paramInt, paramString));
      paramAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception localException)
    {
      break label92;
    }
  }
  
  private final void showAcntNotCoherentDlg(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (mOpenIdConfirmDlg != null)
    {
      mOpenIdConfirmDlg.dismiss();
      mOpenIdConfirmDlg = null;
    }
    paramQQAppInterface = new PublicAccountUtilImpl.12(this, paramActivity, paramProfileParams, paramQQAppInterface);
    paramProfileParams = new PublicAccountUtilImpl.13(this, paramActivity, paramProfileParams);
    mOpenIdConfirmDlg = DialogUtil.a(paramActivity, 230);
    mOpenIdConfirmDlg.setMessage(2131695214);
    mOpenIdConfirmDlg.setTitle(2131692187);
    mOpenIdConfirmDlg.setNegativeButton(2131690800, paramQQAppInterface);
    mOpenIdConfirmDlg.setPositiveButton(2131719158, paramQQAppInterface);
    mOpenIdConfirmDlg.setOnCancelListener(paramProfileParams);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      mOpenIdConfirmDlg.show();
      return;
    }
    catch (Exception paramActivity) {}
    mOpenIdConfirmDlg.dismiss();
    mOpenIdConfirmDlg = null;
    return;
  }
  
  private boolean showDialogIfOpenIdNotEqual(Activity paramActivity, OpenID paramOpenID, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if ((paramOpenID != null) && (!TextUtils.isEmpty(paramOpenID.openID)))
    {
      if (!paramOpenID.openID.equals(paramProfileParams.a().jdField_a_of_type_JavaLangString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        showAcntNotCoherentDlg(paramActivity, paramQQAppInterface, paramProfileParams);
        return true;
      }
    }
    return false;
  }
  
  public static byte[] stringToBytes(String paramString)
  {
    paramString = paramString.split(",");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.put((byte)Integer.parseInt(paramString[i]));
      i += 1;
    }
    return localByteBuffer.array();
  }
  
  public String addSkinParams(String paramString)
  {
    SkinData localSkinData = null;
    Object localObject1 = paramString;
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject1 = SharedPreUtils.q(BaseApplicationImpl.getApplication(), str);
      if (localObject1 == null) {
        break label126;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null) {
          localSkinData = new SkinData((JSONObject)localObject1);
        }
        localObject1 = paramString;
        if (localSkinData != null)
        {
          paramString = HtmlOffline.a(paramString, "_kdSkinID=" + localSkinData.id);
          if (SharedPreUtils.t(BaseApplicationImpl.getApplication(), str)) {
            localObject1 = HtmlOffline.a(paramString, "_kdSkinVoice=1");
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = null;
        continue;
      }
      return HtmlOffline.a(paramString, "_kdSkinVoice=0");
      label126:
      Object localObject2 = null;
    }
  }
  
  public boolean articleReport(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 0) {}
    do
    {
      return false;
      paramString1 = Uri.parse(paramString1);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getHost())) || ((!"article.mp.qq.com".equalsIgnoreCase(paramString1.getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(paramString1.getHost()))));
    ThreadManager.post(new PublicAccountUtilImpl.14(this, paramString1, paramInt, paramString2), 5, null, false);
    return true;
  }
  
  public int caculateMsgTabRedPntExcludeSelf(String paramString)
  {
    int i = 0;
    int k = 0;
    Object localObject1 = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
    if (localObject1 == null) {}
    int j;
    do
    {
      return k;
      localObject1 = new ArrayList((Collection)localObject1);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
        if ((localRecentUserBaseData == null) || (localRecentUserBaseData.mUser == null)) {
          ((Iterator)localObject2).remove();
        } else if ((localRecentUserBaseData.mUser.getType() == 1008) && (ServiceAccountFolderManager.b((QQAppInterface)ReadInJoyUtils.a(), localRecentUserBaseData.mUser.uin))) {
          ((Iterator)localObject2).remove();
        }
      }
      j = 0;
      k = i;
    } while (j >= ((List)localObject1).size());
    Object localObject2 = (RecentUserBaseData)((List)localObject1).get(j);
    if (((RecentUserBaseData)localObject2).mUser.getType() == 1008)
    {
      k = i;
      if (!TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, paramString))
      {
        if (!TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, AppConstants.TROOP_ASSISTANT_UIN)) {
          break label221;
        }
        k = i;
      }
    }
    for (;;)
    {
      j += 1;
      i = k;
      break;
      label221:
      k = i;
      if (((RecentUserBaseData)localObject2).getUnreadNum() > 0) {
        k = i + ((RecentUserBaseData)localObject2).getUnreadNum();
      }
    }
  }
  
  public void checkGotoProfileOrShowAcntNotCoherentDlg(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    Object localObject = paramProfileParams.a();
    if ((TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))) {
      gotoProfileAndFinishActivity(paramActivity, paramQQAppInterface, paramProfileParams);
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))
      {
        String str = paramQQAppInterface.getCurrentAccountUin();
        if (!((ProfileParams.CurLoginUsr)localObject).b.equals(str))
        {
          showAcntNotCoherentDlg(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
        gotoProfileAndFinishActivity(paramActivity, paramQQAppInterface, paramProfileParams);
        return;
      }
      localObject = new PublicAccountUtilImpl.11(this, paramActivity, paramQQAppInterface, paramProfileParams);
      localObject = QZoneShareManager.getOpenID(paramQQAppInterface, paramProfileParams.a(), (BusinessObserver)localObject);
      if (localObject != null)
      {
        if (!showDialogIfOpenIdNotEqual(paramActivity, (OpenID)localObject, paramQQAppInterface, paramProfileParams)) {}
        for (int i = 1; i != 0; i = 0)
        {
          gotoProfileAndFinishActivity(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
      }
    }
  }
  
  public void cleanPublicAccountObserver()
  {
    try
    {
      publicAccountAIOuiHandler = null;
      return;
    }
    finally {}
  }
  
  public String constructAttributeL()
  {
    String str1 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localObject1 = ReadInJoyUtils.b();
        localObject2 = DeviceInfoUtil.d(BaseApplication.getContext());
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        String str2;
        int i;
        localException.printStackTrace();
        continue;
      }
      localJSONObject.put("adcode", str1);
      localJSONObject.put("deviceCode", localObject1);
      localJSONObject.put("macAddress", localObject2);
      str2 = DeviceInfoUtil.f();
      if ((!TextUtils.isEmpty(str2)) && (str2.length() == 16)) {
        localJSONObject.put("android_id", str2);
      }
      ReadInJoySpEventReportUtil.a(localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "constructAttributeL,adCode:" + str1 + ",deviceID:" + (String)localObject1 + ",macAddress:" + (String)localObject2 + ",androidID : " + str2);
      }
      localObject1 = localJSONObject.toString().getBytes();
      Object localObject2 = new byte[localObject1.length];
      i = 0;
      if (i < localObject1.length)
      {
        localObject2[i] = ((byte)(localObject1[i] ^ 0xB6));
        i += 1;
        continue;
        localObject1 = "";
        break label246;
        localObject2 = "";
      }
      else
      {
        return Base64Util.encodeToString((byte[])localObject2, 2);
      }
      label246:
      if (localObject2 == null) {}
    }
  }
  
  public boolean convert0xcf8ToMobileMP(byte[] paramArrayOfByte, oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse1)
  {
    if (paramGetPublicAccountDetailInfoResponse == null) {
      return false;
    }
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    Object localObject2;
    ArrayList localArrayList;
    oidb_cmd0xcf8.ConfigInfo localConfigInfo;
    mobileqq_mp.ConfigInfo localConfigInfo1;
    for (;;)
    {
      try
      {
        paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramArrayOfByte);
        int i = -1;
        if (paramArrayOfByte.uint32_result.has())
        {
          int j = paramArrayOfByte.uint32_result.get();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("PublicAccountUtil", 2, "handle OidbSvc.0xcf8|OIDBSSOPke.result=" + j);
            i = j;
          }
        }
        if ((i == 0) && (paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null))
        {
          paramGetPublicAccountDetailInfoResponse.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
          if (paramGetPublicAccountDetailInfoResponse.ret_info.has())
          {
            paramArrayOfByte = new mobileqq_mp.RetInfo();
            paramArrayOfByte.ret_code.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get());
            paramArrayOfByte.err_info.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).err_info.get());
            paramGetPublicAccountDetailInfoResponse1.ret_info.set(paramArrayOfByte);
          }
          paramGetPublicAccountDetailInfoResponse1.seqno.set(paramGetPublicAccountDetailInfoResponse.seqno.get());
          paramGetPublicAccountDetailInfoResponse1.uin.set((int)paramGetPublicAccountDetailInfoResponse.luin.get());
          paramGetPublicAccountDetailInfoResponse1.name.set(paramGetPublicAccountDetailInfoResponse.name.get());
          paramGetPublicAccountDetailInfoResponse1.display_number.set(paramGetPublicAccountDetailInfoResponse.display_number.get());
          paramGetPublicAccountDetailInfoResponse1.summary.set(paramGetPublicAccountDetailInfoResponse.summary.get());
          paramGetPublicAccountDetailInfoResponse1.is_recv_msg.set(paramGetPublicAccountDetailInfoResponse.is_recv_msg.get());
          paramGetPublicAccountDetailInfoResponse1.is_recv_push.set(paramGetPublicAccountDetailInfoResponse.is_recv_push.get());
          paramGetPublicAccountDetailInfoResponse1.certified_grade.set(paramGetPublicAccountDetailInfoResponse.certified_grade.get());
          if (!paramGetPublicAccountDetailInfoResponse.config_group_info.has()) {
            break label667;
          }
          paramArrayOfByte = new ArrayList();
          localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info.get().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
          localArrayList = new ArrayList();
          localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
            localConfigInfo1 = new mobileqq_mp.ConfigInfo();
            localConfigInfo1.type.set(localConfigInfo.type.get());
            localConfigInfo1.title.set(localConfigInfo.title.get());
            localConfigInfo1.content.set(localConfigInfo.content.get());
            localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
            localConfigInfo1.url.set(localConfigInfo.url.get());
            localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
            localConfigInfo1.state.set(localConfigInfo.state.get());
            localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
            localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
            localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
            localArrayList.add(localConfigInfo1);
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.w("PublicAccountUtil", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
        return false;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.w("PublicAccountUtil", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
        return false;
      }
      localObject2 = new mobileqq_mp.ConfigGroupInfo();
      ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
      paramArrayOfByte.add(localObject2);
    }
    paramGetPublicAccountDetailInfoResponse1.config_group_info.set(paramArrayOfByte);
    label667:
    paramGetPublicAccountDetailInfoResponse1.is_show_share_button.set(paramGetPublicAccountDetailInfoResponse.is_show_share_button.get());
    paramGetPublicAccountDetailInfoResponse1.is_show_follow_button.set(paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get());
    paramGetPublicAccountDetailInfoResponse1.follow_type.set(paramGetPublicAccountDetailInfoResponse.follow_type.get());
    paramGetPublicAccountDetailInfoResponse1.is_sync_lbs.set(paramGetPublicAccountDetailInfoResponse.is_sync_lbs.get());
    paramGetPublicAccountDetailInfoResponse1.group_id.set(paramGetPublicAccountDetailInfoResponse.group_id.get());
    paramGetPublicAccountDetailInfoResponse1.show_flag.set(paramGetPublicAccountDetailInfoResponse.show_flag.get());
    paramGetPublicAccountDetailInfoResponse1.account_flag.set(paramGetPublicAccountDetailInfoResponse.account_flag.get());
    paramGetPublicAccountDetailInfoResponse1.luin.set(paramGetPublicAccountDetailInfoResponse.luin.get());
    paramGetPublicAccountDetailInfoResponse1.config_background_color.set(paramGetPublicAccountDetailInfoResponse.config_background_color.get());
    paramGetPublicAccountDetailInfoResponse1.config_background_img.set(paramGetPublicAccountDetailInfoResponse.config_background_img.get());
    if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has())
    {
      paramArrayOfByte = new ArrayList();
      localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
        localArrayList = new ArrayList();
        localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
          localConfigInfo1 = new mobileqq_mp.ConfigInfo();
          localConfigInfo1.type.set(localConfigInfo.type.get());
          localConfigInfo1.title.set(localConfigInfo.title.get());
          localConfigInfo1.content.set(localConfigInfo.content.get());
          localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
          localConfigInfo1.url.set(localConfigInfo.url.get());
          localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
          localConfigInfo1.state.set(localConfigInfo.state.get());
          localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
          localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
          localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
          localArrayList.add(localConfigInfo1);
        }
        localObject2 = new mobileqq_mp.ConfigGroupInfo();
        ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
        paramArrayOfByte.add(localObject2);
      }
      paramGetPublicAccountDetailInfoResponse1.config_group_info_new.set(paramArrayOfByte);
    }
    paramGetPublicAccountDetailInfoResponse1.certified_description.set(paramGetPublicAccountDetailInfoResponse.certified_description.get());
    paramGetPublicAccountDetailInfoResponse1.unified_account_descrpition.set(paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get());
    paramGetPublicAccountDetailInfoResponse1.account_flag2.set(paramGetPublicAccountDetailInfoResponse.account_flag2.get());
    return true;
  }
  
  public void createFakeStructingMsgWithFields(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    createFakeStructingMsgWithFields(paramQQAppInterface, paramString1, paramString2, paramString3, 0, paramBoolean);
  }
  
  public String createStructMsgBriefFromArticleInfo(ArticleInfo paramArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    Object localObject2 = null;
    if (paramArticleInfo == null)
    {
      QLog.d("PublicAccountUtil", 2, "create msg brief for fail, article info is null");
      return "";
    }
    QLog.d("PublicAccountUtil", 2, "createStructingMsgBrief article : " + paramArticleInfo + ", briefPrefix : " + paramArticleInfo.msgBoxBriefPreFix + ", briefContent : " + paramArticleInfo.msgBoxBriefContent);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramArticleInfo.msgBoxBriefPreFix))
    {
      localObject1 = localObject2;
      if (paramArticleInfo.msgBoxBriefPreFixType > 0)
      {
        if (paramArticleInfo.msgBoxBriefPreFixType != 1) {
          break label156;
        }
        localObject1 = paramArticleInfo.msgBoxBriefPreFix + ": ";
      }
    }
    if (!TextUtils.isEmpty(paramArticleInfo.msgBoxBriefContent))
    {
      paramArticleInfo = paramArticleInfo.msgBoxBriefContent;
      label144:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label260;
      }
    }
    for (;;)
    {
      return EmotionCodecUtils.b(paramArticleInfo);
      label156:
      localObject1 = localObject2;
      if (paramArticleInfo.msgBoxBriefPreFixType != 2) {
        break;
      }
      localObject1 = localObject2;
      if (!TextUtils.isDigitsOnly(paramArticleInfo.msgBoxBriefPreFix)) {
        break;
      }
      paramRefreshUserInfoCallBack = ReadInJoyUserInfoModule.a(Long.valueOf(paramArticleInfo.msgBoxBriefPreFix).longValue(), paramRefreshUserInfoCallBack);
      if (paramRefreshUserInfoCallBack == null)
      {
        localObject1 = ReadInJoyUserInfoModule.a() + ": ";
        break;
      }
      localObject1 = paramRefreshUserInfoCallBack.nick + ": ";
      break;
      paramArticleInfo = paramArticleInfo.mTitle;
      break label144;
      label260:
      paramArticleInfo = (String)localObject1 + paramArticleInfo;
    }
  }
  
  public String createStructingMsgBrief(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = createStructingMsgBriefPrefix(paramQQAppInterface, paramBaseArticleInfo);
      paramBaseArticleInfo = createStructingMsgBriefSuffix(paramBaseArticleInfo);
      paramQQAppInterface = paramBaseArticleInfo;
    } while (TextUtils.isEmpty(str));
    return str + ": " + paramBaseArticleInfo;
  }
  
  public String createStructingMsgBrief(QQAppInterface paramQQAppInterface, BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    if (paramBaseVideoArticleInfo == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = paramBaseVideoArticleInfo.subscribeName;
      paramBaseVideoArticleInfo = paramBaseVideoArticleInfo.title;
      paramQQAppInterface = paramBaseVideoArticleInfo;
    } while (TextUtils.isEmpty(str));
    return str + ": " + paramBaseVideoArticleInfo;
  }
  
  public String createStructingMsgBriefPrefix(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    paramQQAppInterface = new StringBuilder();
    if ((paramBaseArticleInfo.mFeedType != 17) && (paramBaseArticleInfo.mFeedType != 16) && (paramBaseArticleInfo.mFeedType != 19)) {
      if (paramBaseArticleInfo.mFeedType != 18) {}
    }
    label313:
    for (;;)
    {
      return paramQQAppInterface.toString();
      if ((paramBaseArticleInfo.mFeedType == 4) || (paramBaseArticleInfo.mFeedType == 5))
      {
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountUtil", 2, "articleInfo.mTitle is null");
          }
        }
        else
        {
          paramBaseArticleInfo = ReadInJoyUserInfoModule.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a, null);
          if (paramBaseArticleInfo != null) {}
          for (paramBaseArticleInfo = paramBaseArticleInfo.nick;; paramBaseArticleInfo = ReadInJoyUserInfoModule.a())
          {
            paramQQAppInterface.append(paramBaseArticleInfo);
            break;
          }
        }
      }
      else
      {
        if (RIJItemViewType.f((ArticleInfo)paramBaseArticleInfo))
        {
          paramBaseArticleInfo = ReadInJoyUserInfoModule.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a, null);
          if (paramBaseArticleInfo != null) {}
          for (paramBaseArticleInfo = paramBaseArticleInfo.nick;; paramBaseArticleInfo = ReadInJoyUserInfoModule.a())
          {
            paramQQAppInterface.append(paramBaseArticleInfo).append(" Biu了");
            break;
          }
        }
        if (paramBaseArticleInfo.mFeedType == 28)
        {
          paramQQAppInterface = new StringBuilder(HardCodeUtil.a(2131708743));
          if (paramBaseArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList == null) {
            break label313;
          }
          int i = 0;
          while (i < paramBaseArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList.size())
          {
            paramQQAppInterface.append(i + 1).append(".").append(((HotWordItem)paramBaseArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString).append("  ");
            i += 1;
          }
          continue;
        }
        paramQQAppInterface.append(paramBaseArticleInfo.mSubscribeName);
      }
    }
  }
  
  public String createStructingMsgBriefSuffix(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject;
    if (paramBaseArticleInfo == null)
    {
      localObject = "";
      return localObject;
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          if ((paramBaseArticleInfo.mFeedType != 17) && (paramBaseArticleInfo.mFeedType != 16) && (paramBaseArticleInfo.mFeedType != 19) && (paramBaseArticleInfo.mFeedType != 18)) {
            break label224;
          }
          String str2 = "";
          String str3 = "";
          String str1 = str3;
          localObject = str2;
          if (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null)
          {
            str1 = str3;
            localObject = str2;
            if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a != null)
            {
              str1 = str3;
              localObject = str2;
              if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)
              {
                localObject = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c;
                str1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).jdField_a_of_type_JavaLangString;
              }
            }
          }
          paramBaseArticleInfo = (String)localObject + str1 + (String)localObject + " " + paramBaseArticleInfo.mTitle;
          localObject = paramBaseArticleInfo;
          try
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PublicAccountUtil", 2, new Object[] { "createStructingMsgBriefSuffix suffix = ", paramBaseArticleInfo });
            return paramBaseArticleInfo;
          }
          catch (Throwable localThrowable1) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        label224:
        paramBaseArticleInfo = "";
        continue;
      }
      localThrowable1.printStackTrace();
      QLog.d("PublicAccountUtil", 1, "createStructingMsgBriefSuffix throw Throwable, create failed.");
      return paramBaseArticleInfo;
      if ((TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) && (paramBaseArticleInfo.isSocialFeed())) {
        paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString;
      } else {
        paramBaseArticleInfo = paramBaseArticleInfo.mTitle;
      }
    }
  }
  
  public void deletePubAccountMsg(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.setMainTitle(paramContext.getResources().getString(2131696078));
    localActionSheet.addButton(2131691558, 3);
    if (paramString.equals("2010741172")) {
      localActionSheet.addButton(2131695188);
    }
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new PublicAccountUtilImpl.3(this, paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean, paramContext, localActionSheet));
    localActionSheet.show();
  }
  
  public void doVideoPlayRealtimeReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "doVideoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    ThreadManager.post(new PublicAccountUtilImpl.19(this, paramString2, paramString1, paramInt1, paramInt2), 5, null, true);
  }
  
  public void enterTimTeam(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool = ((Boolean)SharedPreUtils.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_is_web", Boolean.valueOf(false))).booleanValue();
    String str = (String)SharedPreUtils.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_url", "https://m.q.qq.com/a/p/1109953074?s=pages%2Fnotification%2Findex%3FenterType%3DqqMiniHelper");
    Object localObject = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if ((!bool) && (((IMiniAppService)localObject).isMiniAppUrl(str))) {
      ((IMiniAppService)localObject).startMiniApp(paramContext, str, 1043, null);
    }
    for (;;)
    {
      paramQQAppInterface.getMessageFacade().a(AppConstants.TIM_TEAM_UIN, 1008, true, true);
      return;
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", str);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("webStyle", "noBottomBar");
      paramContext.startActivity((Intent)localObject);
    }
  }
  
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver)
  {
    followUin(paramAppInterface, paramContext, paramString, paramPublicAccountObserver, true, 0);
  }
  
  @Deprecated
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, int paramInt)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
    localQQAppInterface.addObserver(new NewPublicAccountObserver(new PublicAccountUtilImpl.8(this, paramPublicAccountObserver, paramString, paramAppInterface, paramContext), localQQAppInterface));
    PublicAccountStateReporter.a(localQQAppInterface, true, paramString, 0);
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramAppInterface = (QQAppInterface)paramAppInterface;
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(paramAppInterface, paramString, 0);
      return;
      paramAppInterface = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface))) {
        paramAppInterface = (QQAppInterface)paramAppInterface;
      } else {
        paramAppInterface = null;
      }
    }
  }
  
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean)
  {
    followUin(paramAppInterface, paramContext, paramString, paramPublicAccountObserver, paramBoolean, 0);
  }
  
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean, int paramInt)
  {
    followUin(paramAppInterface, paramContext, paramString, paramPublicAccountObserver, paramBoolean, paramInt, false);
  }
  
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramContext = BaseApplicationImpl.getContext();
    if (paramBoolean2) {
      paramBoolean2 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "followUin() uin: " + paramString + "  useNewProtocol: " + paramBoolean2);
      }
      Object localObject;
      if ((!(paramAppInterface instanceof QQAppInterface)) || (paramBoolean2))
      {
        paramPublicAccountObserver = new NewPublicAccountObserver(new PublicAccountUtilImpl.4(this, paramPublicAccountObserver, paramString, paramAppInterface, paramContext, paramInt, paramBoolean1));
        paramContext = new PublicAccountIntent(paramContext.getApplicationContext(), NewPublicAccountServlet.class);
        paramContext.a(paramPublicAccountObserver);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_CMD", "newFollow");
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_UIN", paramString);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", true);
        paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", paramInt);
        paramAppInterface.startServlet(paramContext);
        return;
        localObject = (PublicAccountDataManager)paramAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        if (localObject != null)
        {
          localObject = ((PublicAccountDataManager)localObject).a(paramString);
          if ((localObject == null) || (getAccountType(((AccountDetail)localObject).accountFlag) == -4))
          {
            paramBoolean2 = false;
            continue;
          }
          paramBoolean2 = true;
        }
      }
      else
      {
        localObject = new NewIntent(paramContext.getApplicationContext(), PublicAccountServletImpl.class);
        ((NewIntent)localObject).putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.ext.set("" + paramInt);
        try
        {
          localFollowRequest.uin.set((int)Long.parseLong(paramString));
          ((NewIntent)localObject).setObserver(new PublicAccountUtilImpl.5(this, paramPublicAccountObserver, paramString, paramBoolean1, paramContext, paramAppInterface, paramInt));
          ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
          paramAppInterface.startServlet((NewIntent)localObject);
          return;
        }
        catch (NumberFormatException paramAppInterface) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountUtil", 2, "Follow Request got wrong uin:" + paramString);
        return;
      }
      paramBoolean2 = false;
    }
  }
  
  public int getAccountType(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt;
    }
    if ((0x200000 & paramInt) != 0) {
      return -2;
    }
    if ((0x4000000 & paramInt) != 0) {
      return -3;
    }
    if ((0x2000000 & paramInt) != 0) {
      return -4;
    }
    if ((0x800000 & paramInt) != 0) {
      return -5;
    }
    if ((0x8000000 & paramInt) != 0) {
      return -6;
    }
    if ((0x80000000 & paramInt) != 0) {
      return -9;
    }
    return -11;
  }
  
  public int getAccountType(AppInterface paramAppInterface, String paramString)
  {
    int j = -1;
    int k = j;
    if (paramAppInterface != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label25;
      }
      k = j;
    }
    label25:
    do
    {
      int i;
      do
      {
        do
        {
          return k;
          localObject = (PublicAccountDataManager)paramAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
          k = j;
        } while (localObject == null);
        Object localObject = ((PublicAccountDataManager)localObject).b(paramString);
        if (localObject != null)
        {
          if (((PublicAccountInfo)localObject).extendType == 2) {
            return -7;
          }
          return getAccountType(((PublicAccountInfo)localObject).accountFlag);
        }
        localObject = ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((TroopInfo)localObject).associatePubAccount != 0L) {
            i = -4;
          }
        }
        paramAppInterface = (EqqDetailDataManager)paramAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
        k = i;
      } while (paramAppInterface == null);
      k = i;
    } while (paramAppInterface.a(paramString) == null);
    return -7;
  }
  
  public long getAccountType2(long paramLong)
  {
    long l = -1L;
    if ((0x200 & paramLong) != 0L) {
      l = -8L;
    }
    while ((0x100000 & paramLong) == 0L) {
      return l;
    }
    return -10L;
  }
  
  public PaConfigAttr.PaConfigInfo getMessageHistoryInfo(AccountDetail paramAccountDetail)
  {
    PaConfigAttr.PaConfigInfo localPaConfigInfo = getConfigInfo(paramAccountDetail, 0, 9);
    if (localPaConfigInfo == null)
    {
      paramAccountDetail = getConfigInfo(paramAccountDetail, 0, 0);
      if ((paramAccountDetail != null) && ("历史消息".equals(paramAccountDetail.jdField_a_of_type_JavaLangString))) {
        return paramAccountDetail;
      }
    }
    return localPaConfigInfo;
  }
  
  public Integer getMessageSetting(AccountDetail paramAccountDetail)
  {
    paramAccountDetail = getConfigInfo(paramAccountDetail, 0, 10);
    if (paramAccountDetail == null) {
      return null;
    }
    return Integer.valueOf(paramAccountDetail.d);
  }
  
  public String getNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      str = paramString;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        str = paramString;
        if (paramQQAppInterface != null) {
          str = paramQQAppInterface.name;
        }
      }
    }
    return str;
  }
  
  public int getPubAccountRecentUserPosInMessageList(String paramString)
  {
    Object localObject1 = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
    int j;
    if (localObject1 == null)
    {
      j = 2147483647;
      return j;
    }
    localObject1 = new ArrayList((Collection)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
      if ((localRecentUserBaseData == null) || (localRecentUserBaseData.mUser == null)) {
        ((Iterator)localObject2).remove();
      } else if ((localRecentUserBaseData.mUser.getType() == 1008) && (ServiceAccountFolderManager.b((QQAppInterface)ReadInJoyUtils.a(), localRecentUserBaseData.mUser.uin))) {
        ((Iterator)localObject2).remove();
      }
    }
    int i = 0;
    for (;;)
    {
      if (i >= ((List)localObject1).size()) {
        break label192;
      }
      localObject2 = (RecentUserBaseData)((List)localObject1).get(i);
      if (((RecentUserBaseData)localObject2).mUser.getType() == 1008)
      {
        j = i;
        if (TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, paramString)) {
          break;
        }
      }
      i += 1;
    }
    label192:
    return -1;
  }
  
  /* Error */
  public NewIntent getPublicAccountDetailRequest(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, String paramString)
  {
    // Byte code:
    //   0: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc_w 401
    //   9: iconst_2
    //   10: new 299	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1818
    //   20: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload 4
    //   25: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 410	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: ldc 2
    //   36: monitorenter
    //   37: aload_3
    //   38: ifnull +7 -> 45
    //   41: aload_3
    //   42: putstatic 36	com/tencent/biz/pubaccount/util/api/impl/PublicAccountUtilImpl:publicAccountAIOuiHandler	Lmqq/os/MqqHandler;
    //   45: ldc 2
    //   47: monitorexit
    //   48: new 833	mqq/app/NewIntent
    //   51: dup
    //   52: aload_2
    //   53: ldc_w 835
    //   56: invokespecial 836	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   59: astore_2
    //   60: aload_2
    //   61: ldc_w 838
    //   64: ldc_w 840
    //   67: invokevirtual 841	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   70: pop
    //   71: new 843	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest
    //   74: dup
    //   75: invokespecial 844	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:<init>	()V
    //   78: astore_3
    //   79: aload_3
    //   80: getfield 859	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:seqno	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: iconst_0
    //   84: invokevirtual 864	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   87: aload_3
    //   88: getfield 867	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   91: iconst_1
    //   92: invokevirtual 864	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   95: aload_3
    //   96: getfield 848	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:versionInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   99: ldc_w 850
    //   102: invokevirtual 855	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   105: aload_3
    //   106: getfield 869	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:uin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: aload 4
    //   111: invokestatic 211	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   114: l2i
    //   115: invokevirtual 864	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   118: aload_2
    //   119: ldc_w 871
    //   122: aload_3
    //   123: invokevirtual 874	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:toByteArray	()[B
    //   126: invokevirtual 877	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   129: pop
    //   130: aload_2
    //   131: new 1820	com/tencent/biz/pubaccount/util/api/impl/PublicAccountUtilImpl$10
    //   134: dup
    //   135: aload_0
    //   136: aload_1
    //   137: invokespecial 1823	com/tencent/biz/pubaccount/util/api/impl/PublicAccountUtilImpl$10:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountUtilImpl;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   140: invokevirtual 886	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   143: aload_1
    //   144: aload_2
    //   145: invokevirtual 1824	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   148: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +13 -> 164
    //   154: ldc_w 401
    //   157: iconst_2
    //   158: ldc_w 894
    //   161: invokestatic 410	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_2
    //   165: areturn
    //   166: astore_1
    //   167: ldc 2
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    //   172: astore 4
    //   174: goto -56 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	PublicAccountUtilImpl
    //   0	177	1	paramQQAppInterface	QQAppInterface
    //   0	177	2	paramContext	Context
    //   0	177	3	paramMqqHandler	MqqHandler
    //   0	177	4	paramString	String
    // Exception table:
    //   from	to	target	type
    //   41	45	166	finally
    //   45	48	166	finally
    //   167	170	166	finally
    //   105	118	172	java/lang/Exception
  }
  
  public String getSourceId(String paramString)
  {
    String str = "biz_src_gzh";
    if ("2105640434".equals(paramString)) {
      str = "biz_src_gzh_bodong";
    }
    do
    {
      return str;
      if ("2747277822".equals(paramString)) {
        return "biz_src_gzh_games";
      }
      if ("2080578142".equals(paramString)) {
        return "biz_src_gwh";
      }
      if ("3046055438".equals(paramString)) {
        return "biz_src_gzh_qqgw";
      }
      if ("2993250418".equals(paramString)) {
        return "biz_src_gzh_qqmusic";
      }
      if ("2909288299".equals(paramString)) {
        return "biz_src_gzh_news";
      }
      if ("2711679534".equals(paramString)) {
        return "biz_src_gzh_qianbao";
      }
      if ("2632129500".equals(paramString)) {
        return "biz_src_gzh_chwl";
      }
      if ("1816533856".equals(paramString)) {
        return "biz_src_gzh_qqzb";
      }
      if ("3288261892".equals(paramString)) {
        return "biz_src_gzh_ketang";
      }
      if ("3383393803".equals(paramString)) {
        return "biz_src_gzh_fudao";
      }
      if ("3026775809".equals(paramString)) {
        return "biz_src_gzh_sport";
      }
    } while (!"2658655094".equals(paramString));
    return "biz_src_gzh_weather";
  }
  
  public int getUinType(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.extendType == 2) {
          return 1024;
        }
        return 1008;
      }
    }
    return 1008;
  }
  
  public String getVersionInfo()
  {
    return "8.5.5,3,5105";
  }
  
  public void gotoProfile(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfile app: " + paramQQAppInterface + " | context: " + paramContext + " | uin: " + paramString + " | accountFlag: " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString))
    {
      KandianSubscribeManager.a(paramContext, 3);
      return;
    }
    paramInt = getAccountType(paramQQAppInterface, paramString, paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4))
    {
      if (paramIntent != null) {
        break label246;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("source", 105);
    }
    label246:
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        openPublicAccountProfile(paramIntent, paramContext, paramString);
        return;
        if ((paramInt == -1) && (paramIntent == null))
        {
          paramIntent = new Intent();
          paramIntent.putExtra("source", 104);
        }
        break;
      case -6: 
        if (!BmqqSegmentUtil.a(paramContext, paramString)) {
          break;
        }
        openBmqqProfile(paramIntent, paramContext, paramString);
        return;
      case -7: 
        CrmUtils.a(paramContext, paramIntent, paramString, false, -1, true, -1);
        return;
      }
    }
  }
  
  public void gotoProfileForResult(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfileForResult app: " + paramQQAppInterface + " | activity: " + paramActivity + " | uin: " + paramString + " | accountFlag: " + paramInt1 + " | requestCode: " + paramInt2 + " | source: " + paramInt3);
    }
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      switch (getAccountType(paramQQAppInterface, paramString, paramInt1))
      {
      default: 
        openPublicAccountProfileForResult(paramIntent, paramQQAppInterface, paramActivity, paramString, paramInt2, paramInt3, paramBoolean);
        return;
      }
    } while (!BmqqSegmentUtil.a(paramActivity, paramString));
    openBmqqProfileForResult(paramIntent, paramActivity, paramString, paramInt2, paramInt3);
    return;
    CrmUtils.a(paramActivity, paramIntent, paramString, false, 5, true, paramInt2);
  }
  
  public boolean isComeFromReadInJoy()
  {
    return isComeFromReadInjoy;
  }
  
  public boolean isDeleteOldKandian(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    synchronized (LOCK)
    {
      if (DELETE_OLDKANDIAN_FLAG == -1) {
        DELETE_OLDKANDIAN_FLAG = localSharedPreferences.getInt(TAG_DELETE_OLDKANDIAN_FLAG + paramQQAppInterface.getCurrentAccountUin(), 0);
      }
      if (DELETE_OLDKANDIAN_FLAG != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean isFollowUin(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramAppInterface = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
    if ((PublicAccountInfo)paramAppInterface.find(PublicAccountInfo.class, paramString) != null)
    {
      paramAppInterface.close();
      return true;
    }
    paramString = (AccountDetail)paramAppInterface.find(AccountDetail.class, paramString);
    paramAppInterface.close();
    try
    {
      paramAppInterface = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      paramAppInterface.mergeFrom(paramString.accountData);
      int i = paramAppInterface.follow_type.get();
      if (i == 1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public boolean isInterestAccount(QQAppInterface paramQQAppInterface, String paramString)
  {
    return getAccountType(paramQQAppInterface, paramString) == -2;
  }
  
  public boolean isInterestAccountOrUnSupportMsgType(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    if (ReadInJoyHelper.d(paramQQAppInterface)) {
      if ((paramInt == -2000) || (paramInt == -1000)) {
        bool = true;
      }
    }
    while ((!isInterestAccount(paramQQAppInterface, paramString)) && (paramInt != -2000) && (paramInt != -1000)) {
      return bool;
    }
    return true;
  }
  
  public boolean isKandianHost(String paramString)
  {
    return BasePublicAccountUtil.a(paramString);
  }
  
  public boolean isKandianNeedAddSkinParamsUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if ((paramString != null) && (("kandian.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)) || ("act.kandian.qq.com".equalsIgnoreCase(paramString)) || ("node.kandian.qq.com".equalsIgnoreCase(paramString)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isKandianUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null) {
        return isKandianHost(paramString.getHost());
      }
    }
    return false;
  }
  
  public boolean isMediaAndOtherSubscript(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i = getAccountType(paramQQAppInterface, paramString);
    if ((i == -3) || (i == -4)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isMsgTabStoryNodeListVisible()
  {
    if ((BaseActivity.sTopActivity == null) || (!(BaseActivity.sTopActivity instanceof SplashActivity))) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
        } while (localObject == null);
        localObject = (Conversation)((FrameHelperActivity)localObject).a(Conversation.class);
      } while (localObject == null);
      localObject = ((Conversation)localObject).a();
    } while (localObject == null);
    if (((MsgTabStoryNodeListManager)localObject).getMode() != 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isPublicAccountUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if ((paramString != null) && (("article.mp.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isQWalletPubAccount(SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_JavaLangString != null)) {
      return "2711679534".equals(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public boolean isQZoneWithReadInJoyUrl(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://www.urlshare.cn")))
    {
      paramString = Uri.parse(paramString).getQueryParameter("url");
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        try
        {
          String str = URLDecoder.decode(paramString);
          paramString = str;
          if ((TextUtils.isEmpty(paramString)) || (!((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianUrl(paramString))) {
            break;
          }
          return true;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PublicAccountUtil", 2, localException.toString());
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public boolean isShopOrServiceAccount(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {}
    int i;
    do
    {
      return false;
      i = getAccountType(paramAccountDetail.accountFlag);
    } while ((i != -5) && (i != -11));
    return true;
  }
  
  public boolean isSubscribeAccount(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = getAccountType(paramQQAppInterface, paramString);
    return (i == -3) || (i == -4) || (i == -2);
  }
  
  public boolean isSubscript(int paramInt, long paramLong)
  {
    paramInt = getAccountType(paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4)) {}
    while (getAccountType2(paramLong) == -8L) {
      return true;
    }
    return false;
  }
  
  public void modifyIntentForSpecificBrowserIfNeeded(Intent paramIntent, String paramString)
  {
    modifyIntentForSpecificBrowserIfNeeded(null, paramIntent, paramString);
  }
  
  public void modifyIntentForSpecificBrowserIfNeeded(MessageRecord paramMessageRecord, Intent paramIntent, String paramString)
  {
    if (paramMessageRecord != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramMessageRecord.istroop == 1)
        {
          paramIntent.putExtra("groupUin", paramMessageRecord.frienduin);
          Object localObject = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
          if (localObject != null)
          {
            localObject = ((TroopManager)localObject).b(paramMessageRecord.frienduin);
            if (localObject != null) {
              paramIntent.putExtra("isAdmin", ((TroopInfo)localObject).isAdmin());
            }
          }
        }
        if (paramMessageRecord.istroop == 3000) {
          paramIntent.putExtra("dicussgroup_uin", paramMessageRecord.frienduin);
        }
        paramIntent.putExtra("friend_uin", paramMessageRecord.frienduin);
        paramIntent.putExtra("friendUin", paramMessageRecord.senderuin);
        paramIntent.putExtra("uinType", paramMessageRecord.istroop);
        paramIntent.putExtra("is_send", paramMessageRecord.isSend());
        paramIntent.putExtra("fromAio", true);
        paramMessageRecord = paramIntent.getComponent();
        if (paramMessageRecord == null) {
          break;
        }
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        i = paramString.indexOf("?");
        if (i == -1) {
          break;
        }
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        if (i >= paramString.length) {
          break;
        }
        if (paramString[i].startsWith("_webviewtype="))
        {
          paramString = paramString[i].split("=");
          if (paramString.length != 2) {
            break;
          }
          boolean bool = TextUtils.isEmpty(paramString[1]);
          if (bool) {
            break;
          }
          try
          {
            switch (Integer.parseInt(paramString[1]))
            {
            case 1: 
              paramIntent.setComponent(new ComponentName(paramMessageRecord.getPackageName(), CouponActivity.class.getName()));
              return;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            return;
          }
        }
        if (paramString[i].startsWith("url="))
        {
          paramMessageRecord = paramString[i].split("=");
          if ((paramMessageRecord.length != 2) || (TextUtils.isEmpty(paramMessageRecord[1]))) {
            break;
          }
          modifyIntentForSpecificBrowserIfNeeded(paramIntent, URLDecoder.decode(paramMessageRecord[1]));
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      i += 1;
    }
    return;
  }
  
  public void newKanDianOidbReport(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, int paramInt)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j;
    int i;
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))
    {
      localObject = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|");
      j = localObject.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          String str1 = localObject[i];
          try
          {
            localArrayList.add(Integer.valueOf(Integer.parseInt(str1)));
            i += 1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
        }
      }
    }
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))
    {
      String[] arrayOfString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|");
      j = arrayOfString.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          String str2 = arrayOfString[i];
          try
          {
            ((ArrayList)localObject).add(Integer.valueOf(Integer.parseInt(str2)));
            i += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
    {
      paramMessageForStructing = parseString2Json(paramMessageForStructing.structingMsg.mMsgActionData);
      if (paramMessageForStructing == null) {}
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramMessageForStructing.getString("id"));
        if ((l == -1L) || (localArrayList.size() <= 0) || (((ArrayList)localObject).size() <= 0)) {
          break;
        }
        newKanDianOidbReport(paramQQAppInterface, l, ((Integer)localArrayList.get(0)).intValue(), ((Integer)((ArrayList)localObject).get(0)).intValue(), paramInt);
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        paramMessageForStructing.printStackTrace();
      }
      long l = -1L;
    }
  }
  
  public void onPublicAccountArkMsgClick(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null)) {
      return;
    }
    String str = "";
    if (paramChatMessage.mExJsonObject != null) {
      str = paramChatMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
    }
    PublicAccountEventReport.a(paramQQAppInterface, paramChatMessage.senderuin, 0, 6, paramChatMessage.msgId, str);
  }
  
  public void onRecentConversationPublicAccountFolderClick(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    paramRecentUser = new Intent();
    if (paramRecentBaseData != null) {
      paramRecentUser.putExtra("serviceUnReadNumber", paramRecentBaseData.mUnreadNum);
    }
    SubscribeLaucher.a(paramActivity, 9004, paramRecentUser);
    if (QLog.isColorLevel()) {
      QLog.d("RecentUtil", 2, "enterServiceAccountFolderActivityFromMsgTab");
    }
    if (paramRecentBaseData == null) {}
    for (paramInt = -1;; paramInt = paramRecentBaseData.mPosition)
    {
      ThreadManager.executeOnSubThread(new PublicAccountUtilImpl.23(this, paramQQAppInterface, paramInt));
      return;
    }
  }
  
  public void openPublicAccountProfile(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, PublicAccountDetailActivityImpl.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.addFlags(67108864);
      paramContext.startActivity(paramIntent);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130771994, 2130771995);
      }
      return;
      paramIntent.setClassName(paramContext, PublicAccountDetailActivityImpl.class.getName());
    }
  }
  
  public JSONObject parseString2Json(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException paramString)
    {
      return null;
    }
    catch (NullPointerException paramString)
    {
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String pickOutFreakingPhoneNumber(AccountDetail paramAccountDetail)
  {
    paramAccountDetail = getConfigInfo(paramAccountDetail, 0, 8);
    if (paramAccountDetail == null) {
      return null;
    }
    return paramAccountDetail.h;
  }
  
  public AccountDetail queryAccountDetail(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (AccountDetail)paramQQAppInterface.find(AccountDetail.class, paramString);
    paramQQAppInterface.close();
    return paramString;
  }
  
  public void removeLbsUin(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if ((localPublicAccountHandler.jdField_a_of_type_JavaUtilList != null) && (localPublicAccountHandler.jdField_a_of_type_JavaUtilList.contains(paramString))) {
      localPublicAccountHandler.jdField_a_of_type_JavaUtilList.remove(paramString);
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.remove(paramString);
    paramQQAppInterface.close();
  }
  
  public void reportForPublicAccountExposure(String paramString)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtilImpl.22(this, paramString));
  }
  
  public void reportPAShareButtonEvent(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.post(new PublicAccountUtilImpl.15(this, localUri, paramString), 5, null, false);
  }
  
  public void reportPAShareItemEvent(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.post(new PublicAccountUtilImpl.16(this, localUri, paramInt2, paramInt1, paramString), 5, null, false);
  }
  
  public void reportPAShareItemEvent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          i = Integer.parseInt(paramString2);
          paramString2 = Uri.parse(paramString1);
          if (paramString2 == null) {
            continue;
          }
          String str = paramString2.getHost();
          if ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str)))) {
            continue;
          }
          ThreadManager.post(new PublicAccountUtilImpl.17(this, paramString2, i, paramString3, paramString4, paramInt, paramString1), 5, null, false);
          return;
        }
      }
      catch (NumberFormatException paramString2)
      {
        for (;;)
        {
          int i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public void reportPushEffectEvent(int paramInt, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtilImpl.20(this, paramList, paramInt));
  }
  
  public void reportPushEffectEventForTaskManager(int paramInt1, int paramInt2, List<oidb_cmd0x80a.AttributeList> paramList)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtilImpl.21(this, paramList, paramInt1, paramInt2));
  }
  
  public void resetDeleteOldKandian()
  {
    synchronized (LOCK)
    {
      DELETE_OLDKANDIAN_FLAG = -1;
      return;
    }
  }
  
  public void sendDetailInfoRequest(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    sendDetailInfoRequest(paramAppInterface, paramContext, paramString, -1);
  }
  
  public void setComeFromReadInJoy(boolean paramBoolean)
  {
    isComeFromReadInjoy = paramBoolean;
  }
  
  public void setLSAccountDetailRequestHandler(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      try
      {
        qqLsHandler = new WeakReference(paramHandler);
        return;
      }
      finally {}
      qqLsHandler = null;
    }
  }
  
  public void setMessageSetting(AccountDetail paramAccountDetail, int paramInt)
  {
    paramAccountDetail = getConfigInfo(paramAccountDetail, 0, 10);
    if (paramAccountDetail == null) {
      return;
    }
    paramAccountDetail.d = paramInt;
  }
  
  public boolean shouldPreloadWebProcess(String paramString)
  {
    return ("3046055438".equals(paramString)) || ("3026775809".equals(paramString)) || ("2711679534".equals(paramString));
  }
  
  public boolean shouldUseWebviewSwitchFunction()
  {
    return false;
  }
  
  public boolean showPubAccUin(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public void unfollowUin(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, PublicAccountObserver paramPublicAccountObserver)
  {
    unfollowUin(paramQQAppInterface, paramContext, paramString, paramBoolean, paramPublicAccountObserver, false);
  }
  
  public void unfollowUin(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean1, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    paramContext = null;
    NewIntent localNewIntent = null;
    Object localObject3 = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    Object localObject1 = localNewIntent;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = ((PublicAccountDataManager)localObject3).a(paramString);
      ((PublicAccountDataManager)localObject3).b(paramString);
      paramContext = (Context)localObject2;
      localObject1 = localNewIntent;
      if (localObject2 == null)
      {
        localObject3 = (EqqDetailDataManager)paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
        paramContext = (Context)localObject2;
        localObject1 = localNewIntent;
        if (localObject3 != null)
        {
          localObject1 = ((EqqDetailDataManager)localObject3).a(paramString);
          paramContext = (Context)localObject2;
        }
      }
    }
    boolean bool;
    if ((paramBoolean2) || (paramContext == null) || (getAccountType(paramContext.accountFlag) != -4))
    {
      bool = true;
      label134:
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "unFollowUin() uin: " + paramString + "  useNewProtocol: " + bool);
      }
      if ((!paramBoolean2) && (paramContext != null) && (getAccountType(paramContext.accountFlag) == -4))
      {
        localNewIntent = new NewIntent(paramQQAppInterface.getApp().getApplicationContext(), PublicAccountServletImpl.class);
        localNewIntent.putExtra("cmd", "unfollow");
        localObject2 = new mobileqq_mp.UnFollowRequest();
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          ((mobileqq_mp.UnFollowRequest)localObject2).uin.set((int)Long.parseLong(paramString));
          if (localObject1 != null) {
            break label345;
          }
          paramContext = new PublicAccountUtilImpl.6(this, paramPublicAccountObserver, paramString, paramBoolean1, localBaseApplication, localObject1, paramQQAppInterface);
          localNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject2).toByteArray());
          localNewIntent.setObserver(paramContext);
          paramQQAppInterface.startServlet(localNewIntent);
          return;
        }
        catch (NumberFormatException paramQQAppInterface) {}
        bool = false;
        break label134;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountUtil", 2, "Unfollow Request got wrong uin:" + paramString);
        return;
        label345:
        localObject1 = paramContext;
      }
    }
    if (localObject1 == null) {}
    for (;;)
    {
      paramContext = new NewPublicAccountObserver(new PublicAccountUtilImpl.7(this, localObject1, paramQQAppInterface, paramString, paramPublicAccountObserver, paramBoolean1, localBaseApplication), paramQQAppInterface);
      paramContext.a(paramQQAppInterface);
      paramQQAppInterface.removeObserver(paramContext);
      paramQQAppInterface.addObserver(paramContext);
      PublicAccountStateReporter.a(paramQQAppInterface, false, paramString, 0);
      return;
      localObject1 = paramContext;
    }
  }
  
  public void updateDeleteOldKandian(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i = 1;
    Object localObject2 = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    for (;;)
    {
      synchronized (LOCK)
      {
        if (DELETE_OLDKANDIAN_FLAG == -1) {
          DELETE_OLDKANDIAN_FLAG = ((SharedPreferences)localObject2).getInt(TAG_DELETE_OLDKANDIAN_FLAG + paramQQAppInterface.getCurrentAccountUin(), 0);
        }
        boolean bool;
        if (DELETE_OLDKANDIAN_FLAG == 0)
        {
          bool = true;
          break label307;
          DELETE_OLDKANDIAN_FLAG = i;
          ((SharedPreferences)localObject2).edit().putInt(TAG_DELETE_OLDKANDIAN_FLAG + paramQQAppInterface.getCurrentAccountUin(), DELETE_OLDKANDIAN_FLAG).commit();
          if ((bool) && (paramBoolean))
          {
            ??? = paramQQAppInterface.getProxyManager().a();
            if (??? != null)
            {
              localObject2 = ((RecentUserProxy)???).b(AppConstants.OLD_KANDIAN_UIN, 1008);
              if (localObject2 != null)
              {
                ((RecentUserProxy)???).a((RecentUser)localObject2);
                ??? = paramQQAppInterface.getHandler(Conversation.class);
                if (??? != null) {
                  ((MqqHandler)???).sendEmptyMessage(1009);
                }
              }
            }
            ??? = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
            if (??? != null)
            {
              ((PublicAccountDataManager)???).c(AppConstants.OLD_KANDIAN_UIN);
              paramQQAppInterface = paramQQAppInterface.getHandler(PublicAccountFragment.class);
              if (paramQQAppInterface != null) {
                paramQQAppInterface.sendEmptyMessage(0);
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("PublicAccountUtil", 2, "updateDeleteOldKandian notDeleteState = " + bool + ", isDelete = " + paramBoolean);
          }
        }
        else
        {
          bool = false;
          break label307;
          i = 0;
        }
      }
      label307:
      if (!paramBoolean) {}
    }
  }
  
  public void videoPlayRealtimeReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "videoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface)))
    {
      doVideoPlayRealtimeReport(paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    localObject = new Intent("readInJoy_video_play_real_time_report");
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_AID", paramString1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_VID", paramString2);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RTYPE", paramInt1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RCODE", paramInt2);
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl
 * JD-Core Version:    0.7.0.1
 */