package com.tencent.av.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.ReqGroupVideo.ReqCreateShareUrl;
import com.tencent.av.ReqGroupVideo.ReqPushShareArk;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.business.handler.MessageHandler.MsgListener;
import com.tencent.av.utils.DataReport.ShareChat;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.ConfigInfo;
import com.tencent.mobileqq.utils.QAVGroupConfig.URLInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareChat
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ShareChat.MyTroopObserver jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver = null;
  ShareChat.SharePanel jdField_a_of_type_ComTencentAvShareShareChat$SharePanel;
  protected BaseActivity a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopInfoData a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  protected String b;
  protected String c;
  
  public ShareChat()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  }
  
  public static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    JumpAction localJumpAction = new JumpAction(paramQQAppInterface, paramContext);
    if ((paramContext instanceof JumpActivity))
    {
      paramQQAppInterface = ((JumpActivity)paramContext).getIntent();
      if (paramQQAppInterface != null) {
        localJumpAction.a("from_url_InternalCheck", paramQQAppInterface.getStringExtra("url"));
      }
    }
    paramContext = JumpParser.a(paramString, "?");
    paramQQAppInterface = paramContext[0];
    paramContext = paramContext[1];
    paramQQAppInterface = paramQQAppInterface.split("//");
    if (paramQQAppInterface.length != 2) {
      return null;
    }
    localJumpAction.jdField_a_of_type_JavaLangString = paramString;
    localJumpAction.b = "mqqavshare://";
    localJumpAction.c = paramQQAppInterface[1];
    paramQQAppInterface = "parser, jumpStr[" + paramString + "], server_name[" + localJumpAction.b + "], action_name[" + localJumpAction.c + "]";
    paramString = paramContext.split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      paramContext = paramQQAppInterface;
      if (arrayOfString.length == 2)
      {
        paramContext = JumpParser.a(arrayOfString[1], false);
        localJumpAction.a(arrayOfString[0], paramContext);
        paramContext = paramQQAppInterface + ", [" + arrayOfString[0] + "]=[" + paramContext + "]";
      }
      i += 1;
      paramQQAppInterface = paramContext;
    }
    QLog.w("ShareChat", 1, paramQQAppInterface);
    return localJumpAction;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.b;
    }
    return this.c;
  }
  
  static String a(Context paramContext)
  {
    return paramContext.getString(2131693151);
  }
  
  static String a(ShareChat.SharePanel.IHandle paramIHandle)
  {
    String str = null;
    if (paramIHandle != null) {
      str = paramIHandle.a();
    }
    return str;
  }
  
  static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    String str = ContactUtils.g(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
    paramString = ContactUtils.a(paramQQAppInterface, paramString, true);
    return str + String.format(paramQQAppInterface.getApp().getString(2131693154), new Object[] { paramString });
  }
  
  static String a(String paramString)
  {
    ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    return localITroopAvatarUtilApi.getAvatarAddress("", paramString, 0) + "100";
  }
  
  static void a(long paramLong, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    QLog.w("ShareChat", 1, "finishJumpActivity, seq[" + paramLong + "]");
    Intent localIntent = new Intent();
    localIntent.setAction("BroadcastReceiverFinishActivity");
    paramContext.sendBroadcast(localIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    long l = AudioHelper.b();
    Object localObject = new StringBuilder().append("forward, url[").append(paramString2).append("], fromchannel[").append(paramInt).append("], seq[").append(l).append("], app[");
    if (paramQQAppInterface != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("ShareChat", 1, bool + "], context[" + paramContext + "]");
      if ((paramQQAppInterface != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
      return;
    }
    localObject = new ShareChat.SharePanel(l, 0);
    WeakReference localWeakReference = new WeakReference(paramContext);
    if (paramContext != null) {
      ((Activity)paramContext).getIntent().putExtra("big_brother_source_key", "biz_src_jc_yinshipin");
    }
    ((ShareChat.SharePanel)localObject).a(paramContext, paramString1, paramInt, new ShareChat.3(paramString2, paramQQAppInterface, paramString1, paramInt, l, localWeakReference));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("param_entrance", 0);
    String str = paramIntent.getStringExtra("group_uin");
    if (i == 35)
    {
      DataReport.ShareChat.g();
      a(paramQQAppInterface, paramBaseActivity, paramView, str);
      return;
    }
    long l = paramIntent.getLongExtra("room_id", 0L);
    i = paramIntent.getIntExtra("room_create_time", 0);
    DataReport.ShareChat.b();
    new ShareChat().a(paramQQAppInterface, paramBaseActivity, str, l, i);
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, String paramString)
  {
    RobotUtils.a(paramBaseActivity, paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    String str2;
    label109:
    String str3;
    label130:
    boolean bool1;
    boolean bool2;
    String str1;
    try
    {
      localJSONObject = new JSONObject(paramString1).getJSONObject("news");
      if ((localJSONObject.isNull("gav_ark_from_type")) || (!"gav_ark_share_from_chatting".equalsIgnoreCase(localJSONObject.getString("gav_ark_from_type")))) {
        break label610;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShareChat", 2, "shareGAVArkMsg");
      }
      local4 = new ShareChat.4();
      if (localJSONObject.isNull("gav_ark_group_name_key")) {
        break label640;
      }
      str2 = localJSONObject.getString("gav_ark_group_name_key");
      if (localJSONObject.isNull("gav_ark_group_card_key")) {
        break label647;
      }
      paramString1 = localJSONObject.getString("gav_ark_group_card_key");
      if (localJSONObject.isNull("gav_ark_group_uin_key")) {
        break label653;
      }
      str3 = localJSONObject.getString("gav_ark_group_uin_key");
      bool1 = localJSONObject.getBoolean("gav_ark_group_owner_key");
      bool2 = localJSONObject.getBoolean("gav_ark_group_admin_key");
      str1 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str1 = ContactUtils.c(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), true);
      }
      if (!TextUtils.isEmpty(str1)) {
        break label618;
      }
      paramString1 = paramQQAppInterface.getCurrentAccountUin();
    }
    catch (JSONException paramQQAppInterface)
    {
      JSONObject localJSONObject;
      ShareChat.4 local4;
      label187:
      long l2;
      int j;
      long l3;
      label268:
      QLog.e("ShareChat", 1, "json error[" + paramQQAppInterface.getMessage() + "]");
    }
    l2 = localJSONObject.getLong("gav_ark_room_id_key");
    j = localJSONObject.getInt("gav_ark_room_create_time_key");
    l3 = StringUtil.a("ShareChat", paramString2);
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject;
      if ((l3 == 0L) || (localObject == -1L) || (str2.isEmpty()) || (paramString1.isEmpty()) || (str3.isEmpty()))
      {
        QLog.e("ShareChat", 1, "shareGAVArkMsg failed : sendUin[" + l3 + "], sessionType[" + paramInt + "] troopName[" + str2 + "] shareName[" + paramString1 + "]");
        return false;
      }
      paramString2 = new ReqGroupVideo.ReqPushShareArk();
      paramString2.uin.set(paramQQAppInterface.getLongAccountUin());
      paramString2.room_id.set(l2);
      paramString2.room_create_time.set(j);
      paramString2.send_type.set(localObject);
      paramString2.recv_uin.set(l3);
      paramString2.group_name.set(ByteStringMicro.copyFromUtf8(str2));
      paramString2.share_name.set(ByteStringMicro.copyFromUtf8(paramString1));
      paramString2.role.set(i);
      paramString2.group_code.set(StringUtil.a("ShareChat", str3));
      MessageHandler.a(AudioHelper.b(), paramQQAppInterface, "QQRTCSvc.push_share_ark", paramString2, local4);
      QLog.d("ShareChat", 1, String.format(Locale.ENGLISH, "shareGAVArkMsg success : uin[%d], roomId[%d], room_create_time[%d], send_type[%d], recv_uin[%d], group_name[%s], share_name[%s], role[%d], groupUin[%s]", new Object[] { Long.valueOf(paramQQAppInterface.getLongAccountUin()), Long.valueOf(l2), Integer.valueOf(j), Long.valueOf(localObject), Long.valueOf(l3), str2, paramString1, Integer.valueOf(i), str3 }));
      return true;
      label610:
      return false;
      label618:
      do
      {
        i = 3;
        break label187;
        paramString1 = str1;
        if (bool1)
        {
          i = 1;
          break label187;
          l1 = -1L;
          break label268;
          str2 = "";
          break;
          paramString1 = "";
          break label109;
          str3 = "";
          break label130;
        }
      } while (!bool2);
      label640:
      label647:
      label653:
      int i = 2;
      break label187;
      long l1 = 0L;
      continue;
      l1 = 1L;
      continue;
      l1 = 2L;
    }
  }
  
  public static boolean a(JumpAction paramJumpAction)
  {
    if ("avshare/group".equals(paramJumpAction.c)) {
      return b(paramJumpAction);
    }
    if ("avshare/forward".equals(paramJumpAction.c)) {
      return d(paramJumpAction);
    }
    return false;
  }
  
  static String b(ShareChat.SharePanel.IHandle paramIHandle)
  {
    if (paramIHandle != null) {
      return paramIHandle.b();
    }
    return null;
  }
  
  public static boolean b(JumpAction paramJumpAction)
  {
    if (!"avshare/group".equals(paramJumpAction.c)) {
      return false;
    }
    String str = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("guid");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    AudioHelper.b("handle_startGAudio");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("guid", str);
    PublicFragmentActivity.Launcher.a(paramJumpAction.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, AVSchema.class);
    DataReport.ShareChat.c();
    return true;
  }
  
  static boolean c(JumpAction paramJumpAction)
  {
    if (!paramJumpAction.j())
    {
      paramJumpAction = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("from_url_InternalCheck");
      QLog.w("ShareChat", 1, "handle_forward, KEY_CurrentUrl[" + paramJumpAction + "]");
      if (!TextUtils.isEmpty(paramJumpAction))
      {
        paramJumpAction = paramJumpAction.replace('\\', '/');
        if ((paramJumpAction.startsWith("https://web.qun.qq.com/")) || (paramJumpAction.startsWith("http://web.qun.qq.com/"))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public static boolean d(JumpAction paramJumpAction)
  {
    if (!"avshare/forward".equals(paramJumpAction.c)) {
      return false;
    }
    if (!c(paramJumpAction)) {
      return false;
    }
    String str1 = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("url");
    Object localObject1 = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("exp");
    String str2 = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("guin");
    Object localObject2 = (String)paramJumpAction.jdField_a_of_type_JavaUtilHashMap.get("fromchannel");
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    int i = (int)StringUtil.a("ShareChat", (String)localObject2);
    if (i == 0) {
      return false;
    }
    DataReport.ShareChat.a(i, str2);
    AudioHelper.b("handle_forward");
    long l1 = StringUtil.a("ShareChat", (String)localObject1);
    long l2 = AudioHelper.a();
    if (l1 < l2)
    {
      paramJumpAction = QQToast.a(paramJumpAction.jdField_a_of_type_AndroidContentContext, 2131693155, 1);
      paramJumpAction.a();
      paramJumpAction.a();
      QLog.w("ShareChat", 1, "handle_forward, expTime[" + l1 + "], curTime[" + l2 + "]");
      return true;
    }
    if (((TroopManager)paramJumpAction.a().getManager(QQManagerFactory.TROOP_MANAGER)).b(str2) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShareChat", 1, "handle_forward, troopUin[" + str2 + "]");
      }
      paramJumpAction = QQToast.a(paramJumpAction.jdField_a_of_type_AndroidContentContext, 2131693155, 1);
      paramJumpAction.a();
      paramJumpAction.a();
      return true;
    }
    localObject1 = paramJumpAction.a();
    localObject2 = (TroopGagMgr)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    boolean bool1 = ((TroopGagMgr)localObject2).a(str2);
    boolean bool2 = ((TroopGagMgr)localObject2).b(str2);
    if ((!bool1) && (!bool2))
    {
      if (AudioHelper.e()) {
        QLog.w("ShareChat", 1, "handle_forward, troopUin[" + str2 + "], isAdmin[" + bool1 + "], isOwner[" + bool2 + "]");
      }
      paramJumpAction = QQToast.a(paramJumpAction.jdField_a_of_type_AndroidContentContext, 2131693156, 1);
      paramJumpAction.a();
      paramJumpAction.a();
      return true;
    }
    paramJumpAction.f = false;
    if ((paramJumpAction.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) {
      ((JumpActivity)paramJumpAction.jdField_a_of_type_AndroidContentContext).b();
    }
    a((QQAppInterface)localObject1, paramJumpAction.jdField_a_of_type_AndroidContentContext, str2, str1, i);
    return true;
  }
  
  void a(long paramLong1, long paramLong2, int paramInt)
  {
    QLog.w("ShareChat", 1, "reRequest, mIsRequesting[" + this.jdField_a_of_type_Boolean + "], seq[" + paramLong1 + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    b(paramLong1, paramLong2, paramInt);
  }
  
  void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString, long paramLong, int paramInt)
  {
    int i = 1;
    int j = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    if (!a()) {
      return;
    }
    a(paramQQAppInterface, paramString);
    paramQQAppInterface = QAVGroupConfig.a().a(paramString);
    long l = AudioHelper.b();
    if (paramQQAppInterface == null)
    {
      b(l, paramLong, paramInt);
      label74:
      if (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime() instanceof QQAppInterface)) {
        break label383;
      }
    }
    label178:
    label189:
    label365:
    label371:
    label377:
    label383:
    for (boolean bool = ((TroopManager)((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);; bool = false)
    {
      paramInt = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        paramInt = j;
        if (!bool)
        {
          if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
            break label365;
          }
          paramInt = 1;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) {
            break label371;
          }
          if ((paramInt | i) == 0) {
            break label377;
          }
        }
      }
      for (paramInt = j;; paramInt = -1)
      {
        this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel = new ShareChat.SharePanel(l, paramInt);
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_yinshipin");
        this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, 99, new ShareChat.1(this, l));
        return;
        this.b = paramQQAppInterface.jdField_a_of_type_JavaLangString;
        this.c = paramQQAppInterface.b;
        QLog.w("ShareChat", 1, "ShareChat, 从缓存中找到url, groupUin[" + paramString + "], m_share_url_with_no_sig[" + this.b + "], m_share_url[" + this.c + "], seq[" + l + "], mSharePanel[" + this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel + "]");
        break label74;
        paramInt = 0;
        break label178;
        i = 0;
        break label189;
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((TroopInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(paramString, false);
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver == null)
    {
      this.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver = new ShareChat.MyTroopObserver(this, null);
      this.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver.jdField_a_of_type_JavaLangString = paramString;
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvShareShareChat$MyTroopObserver);
    }
  }
  
  boolean a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null)
    {
      QLog.w("ShareChat", 1, "initData fail, mGroupUin[" + this.jdField_a_of_type_JavaLangString + "]");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(localTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return true;
  }
  
  void b(long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    long l = StringUtil.a("ShareChat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    int i = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
      i = 1;
    }
    for (;;)
    {
      localObject1 = new ShareChat.2(this);
      QLog.w("ShareChat", 1, "requestGetUrlFromServer, share_name[" + (String)localObject2 + "], role[" + i + "], troopUin[" + l + "], roomID[" + paramLong2 + "], roomCreateTime[" + paramInt + "], seq[" + paramLong1 + "]");
      ReqGroupVideo.ReqCreateShareUrl localReqCreateShareUrl = new ReqGroupVideo.ReqCreateShareUrl();
      localReqCreateShareUrl.uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      localReqCreateShareUrl.uint64_group_code.set(l);
      localReqCreateShareUrl.uint64_room_id.set(paramLong2);
      localReqCreateShareUrl.uint32_room_create_time.set(paramInt);
      localReqCreateShareUrl.group_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName));
      localReqCreateShareUrl.share_name.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localReqCreateShareUrl.role.set(i);
      MessageHandler.a(paramLong1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQRTCSvc.group_video_create_share_url", localReqCreateShareUrl, (MessageHandler.MsgListener)localObject1);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.ShareChat
 * JD-Core Version:    0.7.0.1
 */