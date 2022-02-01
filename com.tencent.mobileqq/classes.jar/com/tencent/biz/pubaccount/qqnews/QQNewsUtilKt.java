package com.tencent.biz.pubaccount.qqnews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CLICK_TYPE_HIPPY", "", "EXTRA_DATA_KEY", "", "NEWS_EXTRA_KEY", "NEWS_EXTRA_KEY_ARTICLE_URL", "NEWS_EXTRA_KEY_CLICK_TYPE", "QQ_NEWS_UIN", "TAG", "clearRedDotUnreadCount", "", "getAccountName", "getAppRuntime", "Lmqq/app/AppRuntime;", "getRedDotUnreadCount", "isQQNewsAccount", "uin", "jumpToHippyPluginPage", "context", "Landroid/content/Context;", "lastMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "openHippyPage", "openHippyInfo", "Lcom/tencent/hippy/qq/utils/HippyAccessHelper$OpenHippyInfo;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class QQNewsUtilKt
{
  public static final int a()
  {
    AppRuntime localAppRuntime = a();
    Object localObject = localAppRuntime;
    if (!(localAppRuntime instanceof QQAppInterface)) {
      localObject = null;
    }
    localObject = (QQAppInterface)localObject;
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getMessageFacade();
      if (localObject != null)
      {
        localObject = ((QQMessageFacade)localObject).a();
        if (localObject != null) {
          return ((ConversationFacade)localObject).a("2909288299", 1008);
        }
      }
    }
    else
    {
      return 0;
    }
    return 0;
  }
  
  @NotNull
  public static final String a()
  {
    Object localObject = UserInfoMgr.a();
    if (localObject != null)
    {
      localObject = ((AppInterface)localObject).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if ((localObject != null) && ((localObject instanceof PublicAccountDataManager)))
      {
        localObject = ((PublicAccountDataManager)localObject).a("2909288299");
        if (localObject != null)
        {
          localObject = ((AccountDetail)localObject).name;
          if ((localObject != null) && (TextUtils.isEmpty((CharSequence)localObject))) {
            return localObject;
          }
        }
      }
    }
    return "腾讯新闻";
  }
  
  @Nullable
  public static final AppRuntime a()
  {
    AppRuntime localAppRuntime = (AppRuntime)null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static final boolean a()
  {
    Object localObject2 = a();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof QQAppInterface)) {
      localObject1 = null;
    }
    localObject1 = (QQAppInterface)localObject1;
    if (localObject1 != null)
    {
      localObject2 = ((QQAppInterface)localObject1).getMessageFacade();
      if (localObject2 != null)
      {
        ((QQMessageFacade)localObject2).a("2909288299", 1008, true, true);
        RecentUtil.b((QQAppInterface)localObject1, "2909288299", 1008);
        ServiceAccountFolderManager.a().a((QQAppInterface)localObject1, "2909288299");
        return true;
      }
    }
    else
    {
      return false;
    }
    return false;
  }
  
  private static final boolean a(Context paramContext, HippyAccessHelper.OpenHippyInfo paramOpenHippyInfo)
  {
    if ((paramContext == null) || (paramOpenHippyInfo == null) || (TextUtils.isEmpty((CharSequence)paramOpenHippyInfo.bundleName)))
    {
      QLog.e("HippyAccessHelper", 1, "openHippyPage params error");
      return false;
    }
    QLog.i("HippyAccessHelper", 1, "openHippy bundleName:" + paramOpenHippyInfo.bundleName);
    paramOpenHippyInfo = paramOpenHippyInfo.toBundle();
    paramOpenHippyInfo.putLong("openPageStart", System.currentTimeMillis());
    Intent localIntent = new Intent();
    localIntent.putExtra("params", paramOpenHippyInfo);
    PublicFragmentActivity.a(paramContext, localIntent, QQNewsHippyFragment.class);
    return true;
  }
  
  public static final boolean a(@Nullable Context paramContext, @Nullable MessageRecord paramMessageRecord)
  {
    if ((paramContext == null) || (paramMessageRecord == null)) {
      return false;
    }
    if (!QQNewsConfigProcessor.a.a())
    {
      QLog.i("QQNewsUtil", 1, "jumpToNewMainPage return false, enableHippy=false.");
      return false;
    }
    String str = paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend");
    if (str != null) {}
    try
    {
      str = new JSONObject(str).optString("news_extra", null);
      if (str != null)
      {
        Object localObject = new JSONObject(str);
        if (1 == ((JSONObject)localObject).optInt("click_type"))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("bundleName", "newsQqPlugin");
          localBundle.putString("framework", "react");
          if (((JSONObject)localObject).has("article_url")) {
            localBundle.putString("errorUrl", ((JSONObject)localObject).optString("article_url"));
          }
          localObject = new SerializableMap();
          HashMap localHashMap = new HashMap();
          ((Map)localHashMap).put("news_extra", str);
          ((SerializableMap)localObject).wrapMap(localHashMap);
          localBundle.putSerializable("js_param_map", (Serializable)localObject);
          return a(paramContext, new HippyAccessHelper.OpenHippyInfo(localBundle));
        }
        paramContext = Unit.INSTANCE;
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        QLog.e("QQNewsUtil", 1, "parse newsData, error = " + paramContext);
        paramContext = Unit.INSTANCE;
      }
    }
    QLog.i("QQNewsUtil", 1, "jumpToNewMainPage return false, " + "newsData=" + paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend") + '.');
    return false;
  }
  
  public static final boolean a(@Nullable String paramString)
  {
    return TextUtils.equals((CharSequence)"2909288299", (CharSequence)paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.qqnews.QQNewsUtilKt
 * JD-Core Version:    0.7.0.1
 */