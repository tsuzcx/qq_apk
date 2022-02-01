package com.tencent.biz.officialaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/officialaccount/OfficialAccountReporter$Reporter;", "", "()V", "ACTION_AIO", "", "ACTION_ARTICLE", "ACTION_LOCK_SCREEN_PUSH", "ACTION_MENU", "ACTION_MSG", "ACTION_MSG_LIST", "ACTION_PROFILE", "ACTION_PROFILE_DOTS", "ACTION_PROFILE_ENTER_AIO", "ACTION_PROFILE_FOLLOW", "ACTION_PROFILE_MENU", "ACTION_PROFILE_UNFOLLOW", "ACTION_SETTING_CLOSE", "ACTION_SETTING_OPEN", "ACTION_SHOP_LIST", "ACTION_SUBSCRIBE_LIST", "ACTION_SUB_PROFILE", "ACTION_TO_UIN", "ACTION_UIN", "DATONG_KEY", "DEBUG_KEY", "EVENT_ID", "IS_DEBUG", "", "KEY", "KEY_ACTION_TYPE", "KEY_DURATION", "KEY_LOCATION_ID", "KEY_MENU_CONTENT", "KEY_MENU_ID", "KEY_MSG_CONTENT", "KEY_MSG_ID", "KEY_MSG_TYPE", "KEY_OAC_TRIGGLE", "KEY_RED_NUM", "KEY_SUBACTION_TYPE", "SUB_ACTION_ACCEPT", "SUB_ACTION_CLICK", "SUB_ACTION_EXPO", "SUB_ACTION_STAY", "TAG", "mAioExpoRecordSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mAioListExpoInitTimeLimit", "mAioResidentStartTime", "", "mArticleResidentStartTime", "mExpoTimeLimit", "mLastPushClickReportTime", "mLastRefreshAioExpoRecordTime", "mOacMessageOnListClick", "mProfileMenuExpoRecordMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mReporterInitTime", "doReport", "", "toUin", "paramsMap", "getAioListExpoInitTimeLimit", "getExpoTimeLimit", "getExtInfoFromExtStr", "extStr", "key", "getOacTriggle", "oacMessageExtend", "isAioListExpoEnabled", "onAioMsgClick", "location", "url", "oacMessage", "onAioMsgExpo", "msgId", "msgType", "onAioResidentEnd", "onAioResidentStart", "onArticleResidentEnd", "onArticleResidentStart", "onLockScreenPushClick", "onLockScreenPushExpo", "onMenuClick", "menuId", "menuContent", "onMenuExpo", "onMsgListClick", "messageContent", "", "redNum", "onMsgListExpo", "onProfileEnterAio", "onProfileExpo", "onProfileFollow", "onProfileMenuClick", "onProfileMenuExpo", "onProfileSetting", "onProfileSettingAccept", "onProfileSettingReject", "onProfileUnfollow", "onShopListClick", "onShopListExpo", "onSubProfileClick", "onSubscribeListClick", "onSubscribeListExpo", "refreshAioExpoRecord", "report", "action", "subActionType", "extra", "", "reportAioClickIfNeed", "data", "reportAioExpoIfNeed", "Lcom/tencent/mobileqq/activity/recent/RecentBaseData;", "reportAioMsgClickIfNeed", "element", "Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;", "reportAioMsgExpoIfNeed", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportLockScreenPushClickIfNeed", "activity", "Landroid/app/Activity;", "reportLockScreenPushExpoIfNeed", "showMsgContent", "intent", "Landroid/content/Intent;", "reportMsgReceiveIfNeed", "list", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class OfficialAccountReporter$Reporter
{
  private final int a()
  {
    if (OfficialAccountReporter.a() > 0) {
      return OfficialAccountReporter.a();
    }
    OfficialAccountReporter.a(QzoneConfig.getInstance().getConfig("OfficialAccount", "OfficialAccountReportTimeLimit", 3000));
    return OfficialAccountReporter.a();
  }
  
  private final String a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty((CharSequence)paramString))
      {
        String str = new JSONObject(paramString).optString("oac_triggle");
        Intrinsics.checkExpressionValueIsNotNull(str, "json.optString(\"oac_triggle\")");
        return str;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OfficialAccountReporter", 2, "getOacTriggle error: " + paramString, (Throwable)localException);
    }
    return "";
  }
  
  private final void a(String paramString1, String paramString2, CharSequence paramCharSequence, long paramLong, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramString2 != null) {
      ((Map)localHashMap).put("tianshu_transfer", ((Reporter)this).a(paramString2));
    }
    if (paramCharSequence != null) {
      ((Map)localHashMap).put("msg_content", paramCharSequence.toString());
    }
    if (paramLong > 0L) {
      ((Map)localHashMap).put("msg_id", String.valueOf(paramLong));
    }
    if (paramInt1 != 0) {
      ((Map)localHashMap).put("msg_type", String.valueOf(paramInt1));
    }
    ((Map)localHashMap).put("reddot_num", String.valueOf(paramInt2));
    ((Reporter)this).a("gouwu_list", "expo", paramString1, (Map)localHashMap);
  }
  
  private final void a(String paramString1, String paramString2, CharSequence paramCharSequence, String paramString3, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramString2 != null) {
      ((Map)localHashMap).put("tianshu_transfer", ((Reporter)this).a(paramString2));
    }
    if (paramCharSequence != null) {
      ((Map)localHashMap).put("msg_content", paramCharSequence.toString());
    }
    if (paramString3 != null) {
      ((Map)localHashMap).put("msg_id", paramString3);
    }
    if (paramInt1 != 0) {
      ((Map)localHashMap).put("msg_type", String.valueOf(paramInt1));
    }
    ((Map)localHashMap).put("reddot_num", String.valueOf(paramInt2));
    ((Reporter)this).a("msg_list", "expo", paramString1, (Map)localHashMap);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (paramString2 != null) {
      ((Map)localHashMap).put("tianshu_transfer", ((Reporter)this).a(paramString2));
    }
    if (paramString3 != null) {
      ((Map)localHashMap).put("msg_id", paramString3);
    }
    if (paramInt != 0) {
      ((Map)localHashMap).put("msg_type", String.valueOf(paramInt));
    }
    ((Reporter)this).a("gzh_aio", "expo", paramString1, (Map)localHashMap);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    if (paramString1 != null) {
      ((Map)localHashMap).put("location_id", paramString1);
    }
    if (paramString2 != null) {
      ((Map)localHashMap).put("msg_content", paramString2);
    }
    if (paramString4 != null) {
      ((Map)localHashMap).put("tianshu_transfer", ((Reporter)this).a(paramString4));
    }
    ((Reporter)this).a("gzh_aio", "click", paramString3, (Map)localHashMap);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      if (paramString1 != null) {
        ((Map)localHashMap).put("object_id", paramString1);
      }
      if (paramString2 != null) {
        ((Map)localHashMap).put("code", paramString2);
      }
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramMap = (Map.Entry)paramString1.next();
        paramString2 = (String)paramMap.getKey();
        paramMap = (String)paramMap.getValue();
        ((Map)localHashMap).put(paramString2, paramMap);
      }
      ((Reporter)this).a(paramString3, localHashMap);
    }
    catch (Exception paramString1)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString1, new Object[0]);
      return;
    }
  }
  
  private final void a(String paramString, HashMap<String, String> paramHashMap)
  {
    ThreadManager.getSubThreadHandler().post((Runnable)new OfficialAccountReporter.Reporter.doReport.1(paramHashMap, paramString));
  }
  
  private final boolean a()
  {
    return QzoneConfig.getInstance().getConfig("OfficialAccount", "OfficialAccountReportAioListExpoEnable", true);
  }
  
  private final int b()
  {
    if (OfficialAccountReporter.b() > 0) {
      return OfficialAccountReporter.b();
    }
    OfficialAccountReporter.b(QzoneConfig.getInstance().getConfig("OfficialAccount", "OfficialAccountReportAioListExpoInitTimeLimit", 12000));
    return OfficialAccountReporter.b();
  }
  
  private final void b(String paramString1, String paramString2, CharSequence paramCharSequence, long paramLong, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramString2 != null) {
      ((Map)localHashMap).put("tianshu_transfer", ((Reporter)this).a(paramString2));
    }
    if (paramCharSequence != null) {
      ((Map)localHashMap).put("msg_content", paramCharSequence.toString());
    }
    if (paramLong > 0L) {
      ((Map)localHashMap).put("msg_id", String.valueOf(paramLong));
    }
    if (paramInt1 != 0) {
      ((Map)localHashMap).put("msg_type", String.valueOf(paramInt1));
    }
    ((Map)localHashMap).put("reddot_num", String.valueOf(paramInt2));
    a((Reporter)this, "gouwu_list", "click", paramString1, null, 8, null);
  }
  
  private final void b(String paramString1, String paramString2, CharSequence paramCharSequence, String paramString3, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramString2 != null)
    {
      paramString2 = ((Reporter)this).a(paramString2);
      ((Map)localHashMap).put("tianshu_transfer", paramString2);
      OfficialAccountReporter.a(paramString2);
    }
    if (paramCharSequence != null) {
      ((Map)localHashMap).put("msg_content", paramCharSequence.toString());
    }
    if (paramString3 != null) {
      ((Map)localHashMap).put("msg_id", paramString3);
    }
    if (paramInt1 != 0) {
      ((Map)localHashMap).put("msg_type", String.valueOf(paramInt1));
    }
    ((Map)localHashMap).put("reddot_num", String.valueOf(paramInt2));
    ((Reporter)this).a("msg_list", "click", paramString1, (Map)localHashMap);
  }
  
  private final void c(String paramString1, String paramString2, CharSequence paramCharSequence, long paramLong, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramString2 != null) {
      ((Map)localHashMap).put("tianshu_transfer", ((Reporter)this).a(paramString2));
    }
    if (paramCharSequence != null) {
      ((Map)localHashMap).put("msg_content", paramCharSequence.toString());
    }
    if (paramLong > 0L) {
      ((Map)localHashMap).put("msg_id", String.valueOf(paramLong));
    }
    if (paramInt1 != 0) {
      ((Map)localHashMap).put("msg_type", String.valueOf(paramInt1));
    }
    ((Map)localHashMap).put("reddot_num", String.valueOf(paramInt2));
    ((Reporter)this).a("dingyue_list", "expo", paramString1, (Map)localHashMap);
  }
  
  private final void d(String paramString1, String paramString2, CharSequence paramCharSequence, long paramLong, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramString2 != null)
    {
      paramString2 = ((Reporter)this).a(paramString2);
      ((Map)localHashMap).put("tianshu_transfer", paramString2);
      OfficialAccountReporter.a(paramString2);
    }
    if (paramCharSequence != null) {
      ((Map)localHashMap).put("msg_content", paramCharSequence.toString());
    }
    if (paramLong > 0L) {
      ((Map)localHashMap).put("msg_id", String.valueOf(paramLong));
    }
    if (paramInt1 != 0) {
      ((Map)localHashMap).put("msg_type", String.valueOf(paramInt1));
    }
    ((Map)localHashMap).put("reddot_num", String.valueOf(paramInt2));
    a((Reporter)this, "dingyue_list", "click", paramString1, null, 8, null);
  }
  
  private final void k(String paramString)
  {
    a((Reporter)this, "lockscreen_push", "expo", paramString, null, 8, null);
  }
  
  private final void l(String paramString)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = OfficialAccountReporter.c();
    if (l1 > ((Reporter)this).a() + l2)
    {
      a((Reporter)this, "lockscreen_push", "click", paramString, null, 8, null);
      OfficialAccountReporter.c(SystemClock.elapsedRealtime());
    }
  }
  
  @Nullable
  public final String a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (TextUtils.isEmpty((CharSequence)paramString1)) {
      return "";
    }
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1.has(paramString2)) {
        return paramString1.getString(paramString2);
      }
      return "";
    }
    catch (Exception paramString1)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString1, new Object[0]);
    }
    return "";
  }
  
  public final void a()
  {
    OfficialAccountReporter.a(SystemClock.elapsedRealtime());
  }
  
  public final void a(@Nullable Activity paramActivity)
  {
    try
    {
      if ((paramActivity instanceof SplashActivity))
      {
        paramActivity = ((SplashActivity)paramActivity).getIntent();
        if (paramActivity.getBooleanExtra("key_notification_click_action", false))
        {
          int i = paramActivity.getIntExtra("uintype", 0);
          paramActivity = paramActivity.getStringExtra("uin");
          if ((i == 1008) || (i == 7230) || (i == 7120)) {
            ((Reporter)this).l(paramActivity);
          }
        }
      }
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramActivity, new Object[0]);
    }
  }
  
  public final void a(@Nullable RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData != null)
    {
      int i;
      Object localObject1;
      Object localObject2;
      try
      {
        i = paramRecentBaseData.hashCode();
        if (OfficialAccountReporter.a().contains(Integer.valueOf(i))) {
          return;
        }
        if (!((Reporter)this).a()) {
          return;
        }
        OfficialAccountReporter.a().add(Integer.valueOf(i));
        if ((paramRecentBaseData instanceof RecentItemPublicAccountChatMsgData))
        {
          localObject1 = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).a();
          if (localObject1 == null) {
            return;
          }
          localObject2 = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).getRecentUserUin();
          CharSequence localCharSequence = paramRecentBaseData.mLastMsg;
          String str = ((Reporter)this).a(((Message)localObject1).extStr, "public_account_msg_id");
          i = ((Message)localObject1).msgtype;
          int j = paramRecentBaseData.mUnreadNum;
          ((Reporter)this).a((String)localObject2, ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).mReportKeyBytesOacMsgxtend, localCharSequence, str, i, j);
          return;
        }
      }
      catch (Exception paramRecentBaseData)
      {
        QLog.e("OfficialAccountReporter", 2, (Throwable)paramRecentBaseData, new Object[0]);
        return;
      }
      if ((paramRecentBaseData instanceof RecentItemServiceAccountFolderData))
      {
        localObject1 = ((RecentItemServiceAccountFolderData)paramRecentBaseData).getRecentUserUin();
        localObject2 = paramRecentBaseData.mLastMsg;
        i = paramRecentBaseData.mUnreadNum;
        ((Reporter)this).c((String)localObject1, ((RecentItemServiceAccountFolderData)paramRecentBaseData).mReportKeyBytesOacMsgxtend, (CharSequence)localObject2, 0L, 0, i);
        return;
      }
      if ((paramRecentBaseData instanceof RecentItemEcShopAssitant))
      {
        localObject1 = ((RecentItemEcShopAssitant)paramRecentBaseData).getRecentUserUin();
        localObject2 = paramRecentBaseData.mLastMsg;
        i = paramRecentBaseData.mUnreadNum;
        ((Reporter)this).a((String)localObject1, null, (CharSequence)localObject2, 0L, 0, i);
      }
    }
  }
  
  public final void a(@Nullable MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = paramMessageRecord.istroop;
        String str1 = paramMessageRecord.frienduin;
        String str2 = new JSONObject(paramMessageRecord.extStr).optString("report_key_bytes_oac_msg_extend");
        String str3 = ((Reporter)this).a(paramMessageRecord.extStr, "public_account_msg_id");
        int j = paramMessageRecord.msgtype;
        if ((i == 1008) || (i == 7230) || (i == 7120))
        {
          ((Reporter)this).a(str1, str2, str3, j);
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("OfficialAccountReporter", 2, (Throwable)paramMessageRecord, new Object[0]);
      }
    }
  }
  
  public final void a(@Nullable AbsStructMsgElement paramAbsStructMsgElement, @Nullable String paramString)
  {
    if (paramAbsStructMsgElement != null) {}
    try
    {
      ((Reporter)this).a(paramAbsStructMsgElement.aa, paramAbsStructMsgElement.b, paramAbsStructMsgElement.ab, paramString);
      return;
    }
    catch (Exception paramAbsStructMsgElement)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramAbsStructMsgElement, new Object[0]);
    }
  }
  
  public final void a(@Nullable Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    int i;
    try
    {
      Object localObject3;
      if ((paramObject instanceof RecentItemPublicAccountChatMsgData))
      {
        localObject1 = ((RecentItemPublicAccountChatMsgData)paramObject).a();
        if (localObject1 == null) {
          return;
        }
        localObject2 = ((RecentItemPublicAccountChatMsgData)paramObject).getRecentUserUin();
        localObject3 = ((RecentItemPublicAccountChatMsgData)paramObject).mReportKeyBytesOacMsgxtend;
        CharSequence localCharSequence = ((RecentItemPublicAccountChatMsgData)paramObject).mLastMsg;
        String str = ((Reporter)this).a(((Message)localObject1).extStr, "public_account_msg_id");
        i = ((Message)localObject1).msgtype;
        int j = ((RecentItemPublicAccountChatMsgData)paramObject).mUnreadNum;
        ((Reporter)this).b((String)localObject2, (String)localObject3, localCharSequence, str, i, j);
        return;
      }
      if ((paramObject instanceof RecentItemServiceAccountFolderData))
      {
        localObject1 = ((RecentItemServiceAccountFolderData)paramObject).getRecentUserUin();
        localObject2 = ((RecentItemServiceAccountFolderData)paramObject).mReportKeyBytesOacMsgxtend;
        localObject3 = ((RecentItemServiceAccountFolderData)paramObject).mLastMsg;
        i = ((RecentItemServiceAccountFolderData)paramObject).mUnreadNum;
        ((Reporter)this).d((String)localObject1, (String)localObject2, (CharSequence)localObject3, 0L, 0, i);
        return;
      }
    }
    catch (Exception paramObject)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramObject, new Object[0]);
      return;
    }
    if ((paramObject instanceof RecentItemEcShopAssitant))
    {
      localObject1 = ((RecentItemEcShopAssitant)paramObject).getRecentUserUin();
      localObject2 = ((RecentItemEcShopAssitant)paramObject).mLastMsg;
      i = ((RecentItemEcShopAssitant)paramObject).mUnreadNum;
      ((Reporter)this).b((String)localObject1, null, (CharSequence)localObject2, 0L, 0, i);
    }
  }
  
  public final void a(@Nullable String paramString)
  {
    try
    {
      if (OfficialAccountReporter.a() > 0L)
      {
        HashMap localHashMap = new HashMap();
        ((Map)localHashMap).put("duration_ms", String.valueOf(SystemClock.elapsedRealtime() - OfficialAccountReporter.a()));
        if (OfficialAccountReporter.a() != null)
        {
          Map localMap = (Map)localHashMap;
          String str = OfficialAccountReporter.a();
          if (str == null) {
            Intrinsics.throwNpe();
          }
          localMap.put("tianshu_transfer", str);
        }
        OfficialAccountReporter.a((String)null);
        ((Reporter)this).a("gzh_aio", "stay", paramString, (Map)localHashMap);
      }
      OfficialAccountReporter.a(0L);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void a(@Nullable String paramString1, int paramInt, @Nullable String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("menu_id", String.valueOf(paramInt));
      if (paramString2 != null) {
        ((Map)localHashMap).put("menu_content", paramString2);
      }
      ((Reporter)this).a("gzh_menu", "expo", paramString1, (Map)localHashMap);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString1, new Object[0]);
    }
  }
  
  public final void a(@Nullable List<? extends MessageRecord> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.isEmpty()) {
          return;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramList.next();
          if ((localMessageRecord.istroop == 1008) || (localMessageRecord.istroop == 7230) || (localMessageRecord.istroop == 7120))
          {
            String str1 = localMessageRecord.frienduin;
            String str2 = localMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
            String str3 = new JSONObject(localMessageRecord.extStr).optString("report_key_bytes_oac_msg_extend");
            HashMap localHashMap = new HashMap();
            Map localMap = (Map)localHashMap;
            Intrinsics.checkExpressionValueIsNotNull(str2, "msgId");
            localMap.put("msg_id", str2);
            ((Map)localHashMap).put("msg_type", String.valueOf(localMessageRecord.msgtype));
            ((Map)localHashMap).put("tianshu_transfer", ((Reporter)this).a(str3));
            ((Reporter)this).a("gzh_msg", "accept", str1, (Map)localHashMap);
          }
        }
        return;
      }
      catch (Exception paramList)
      {
        QLog.e("OfficialAccountReporter", 2, (Throwable)paramList, new Object[0]);
      }
    }
  }
  
  public final void a(boolean paramBoolean, @Nullable Intent paramIntent)
  {
    if ((!paramBoolean) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      try
      {
        int i = paramIntent.getIntExtra("uintype", -1);
        paramIntent = paramIntent.getStringExtra("uin");
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "intent.getStringExtra(\"uin\")");
        if ((i == 1008) || (i == 7230) || (i == 7120))
        {
          ((Reporter)this).k(paramIntent);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("OfficialAccountReporter", 2, (Throwable)paramIntent, new Object[0]);
      }
    }
  }
  
  public final void b()
  {
    OfficialAccountReporter.b(SystemClock.elapsedRealtime());
  }
  
  public final void b(@Nullable String paramString)
  {
    try
    {
      if (OfficialAccountReporter.b() > 0L)
      {
        HashMap localHashMap = new HashMap();
        ((Map)localHashMap).put("duration_ms", String.valueOf(SystemClock.elapsedRealtime() - OfficialAccountReporter.b()));
        ((Reporter)this).a("gzh_article", "stay", paramString, (Map)localHashMap);
      }
      OfficialAccountReporter.b(0L);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void b(@Nullable String paramString1, int paramInt, @Nullable String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("menu_id", String.valueOf(paramInt));
      if (paramString2 != null) {
        ((Map)localHashMap).put("menu_content", paramString2);
      }
      ((Reporter)this).a("gzh_menu", "click", paramString1, (Map)localHashMap);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString1, new Object[0]);
    }
  }
  
  public final void c()
  {
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      int i = ((Reporter)this).b();
      long l2 = OfficialAccountReporter.d();
      if (l1 <= i + l2) {
        return;
      }
      i = ((Reporter)this).a();
      if (OfficialAccountReporter.e() > 0L)
      {
        l2 = OfficialAccountReporter.e();
        if (l1 <= i + l2) {}
      }
      else
      {
        OfficialAccountReporter.a().clear();
        OfficialAccountReporter.d(SystemClock.elapsedRealtime());
        QLog.d("OfficialAccountReporter", 2, "refreshAioExpoRecord " + (OfficialAccountReporter.e() - l1));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)localException, new Object[0]);
    }
  }
  
  public final void c(@Nullable String paramString)
  {
    try
    {
      a((Reporter)this, "gzh_profile", "expo", paramString, null, 8, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void c(@Nullable String paramString1, int paramInt, @Nullable String paramString2)
  {
    try
    {
      int i = ("" + paramString1 + paramInt + paramString2).hashCode();
      long l1 = SystemClock.elapsedRealtime();
      Object localObject = (Long)OfficialAccountReporter.a().get(Integer.valueOf(i));
      if (localObject != null)
      {
        long l2 = ((Long)localObject).longValue();
        if (l1 <= ((Reporter)this).a() + l2) {
          return;
        }
      }
      localObject = new HashMap();
      ((Map)localObject).put("menu_id", String.valueOf(paramInt));
      if (paramString2 != null) {
        ((Map)localObject).put("menu_content", paramString2);
      }
      ((Reporter)this).a("gzh_profile_menu", "expo", paramString1, (Map)localObject);
      ((Map)OfficialAccountReporter.a()).put(Integer.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()));
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString1, new Object[0]);
    }
  }
  
  public final void d(@Nullable String paramString)
  {
    try
    {
      a((Reporter)this, "gzh_profile_follow", "click", paramString, null, 8, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void d(@Nullable String paramString1, int paramInt, @Nullable String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("menu_id", String.valueOf(paramInt));
      if (paramString2 != null) {
        ((Map)localHashMap).put("menu_content", paramString2);
      }
      ((Reporter)this).a("gzh_profile_menu", "click", paramString1, (Map)localHashMap);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString1, new Object[0]);
    }
  }
  
  public final void e(@Nullable String paramString)
  {
    try
    {
      a((Reporter)this, "gzh_profile_unfollow", "click", paramString, null, 8, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void f(@Nullable String paramString)
  {
    try
    {
      a((Reporter)this, "gzh_sub_profile", "click", paramString, null, 8, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void g(@Nullable String paramString)
  {
    try
    {
      a((Reporter)this, "gzh_profile_dots", "click", paramString, null, 8, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void h(@Nullable String paramString)
  {
    try
    {
      a((Reporter)this, "gzh_profile_aio_entrance", "click", paramString, null, 8, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void i(@Nullable String paramString)
  {
    try
    {
      a((Reporter)this, "gzh_msg_setting_open", "click", paramString, null, 8, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
  
  public final void j(@Nullable String paramString)
  {
    try
    {
      a((Reporter)this, "gzh_msg_setting_close", "click", paramString, null, 8, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("OfficialAccountReporter", 2, (Throwable)paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter
 * JD-Core Version:    0.7.0.1
 */