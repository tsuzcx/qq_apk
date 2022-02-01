package com.tencent.biz.pubaccount.qqnews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CLICK_TYPE_HIPPY", "", "EXTRA_DATA_KEY", "", "NEWS_EXTRA_KEY", "NEWS_EXTRA_KEY_ARTICLE_URL", "NEWS_EXTRA_KEY_CLICK_TYPE", "QQ_NEWS_UIN", "TAG", "clearRedDotUnreadCount", "", "getAccountName", "getAppRuntime", "Lmqq/app/AppRuntime;", "getRedDotUnreadCount", "isQQNewsAccount", "uin", "jumpToHippyPluginPage", "context", "Landroid/content/Context;", "lastMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "openHippyPage", "openHippyInfo", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class QQNewsUtilKt
{
  public static final int a()
  {
    AppRuntime localAppRuntime = c();
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
    return 0;
  }
  
  private static final boolean a(Context paramContext, OpenHippyInfo paramOpenHippyInfo)
  {
    if ((paramContext != null) && (paramOpenHippyInfo != null) && (!TextUtils.isEmpty((CharSequence)paramOpenHippyInfo.bundleName)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openHippy bundleName:");
      ((StringBuilder)localObject).append(paramOpenHippyInfo.bundleName);
      QLog.i("HippyAccessHelper", 1, ((StringBuilder)localObject).toString());
      paramOpenHippyInfo = paramOpenHippyInfo.toBundle();
      paramOpenHippyInfo.putLong("openPageStart", System.currentTimeMillis());
      localObject = new Intent();
      ((Intent)localObject).putExtra("params", paramOpenHippyInfo);
      QPublicFragmentActivity.start(paramContext, (Intent)localObject, QQNewsHippyFragment.class);
      return true;
    }
    QLog.e("HippyAccessHelper", 1, "openHippyPage params error");
    return false;
  }
  
  public static final boolean a(@Nullable Context paramContext, @Nullable MessageRecord paramMessageRecord)
  {
    if (paramContext != null)
    {
      if (paramMessageRecord == null) {
        return false;
      }
      if (!QQNewsConfigProcessor.a.a())
      {
        QLog.i("QQNewsUtil", 1, "jumpToNewMainPage return false, enableHippy=false.");
        return false;
      }
      Object localObject1 = paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend");
      if (localObject1 != null) {
        try
        {
          localObject1 = new JSONObject((String)localObject1).optString("news_extra", null);
          if (localObject1 != null)
          {
            Object localObject2 = new JSONObject((String)localObject1);
            if (1 == ((JSONObject)localObject2).optInt("click_type"))
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("bundleName", "newsQqPlugin");
              localBundle.putString("framework", "react");
              if (((JSONObject)localObject2).has("article_url")) {
                localBundle.putString("errorUrl", ((JSONObject)localObject2).optString("article_url"));
              }
              localObject2 = new SerializableMap();
              HashMap localHashMap = new HashMap();
              ((Map)localHashMap).put("news_extra", localObject1);
              ((SerializableMap)localObject2).wrapMap(localHashMap);
              localBundle.putSerializable("js_param_map", (Serializable)localObject2);
              return a(paramContext, new OpenHippyInfo(localBundle));
            }
            paramContext = Unit.INSTANCE;
          }
        }
        catch (JSONException paramContext)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parse newsData, error = ");
          ((StringBuilder)localObject1).append(paramContext);
          QLog.e("QQNewsUtil", 1, ((StringBuilder)localObject1).toString());
          paramContext = Unit.INSTANCE;
        }
      }
      paramContext = new StringBuilder();
      paramContext.append("jumpToNewMainPage return false, ");
      paramContext.append("newsData=");
      paramContext.append(paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend"));
      paramContext.append('.');
      QLog.i("QQNewsUtil", 1, paramContext.toString());
    }
    return false;
  }
  
  public static final boolean a(@Nullable String paramString)
  {
    return TextUtils.equals((CharSequence)"2909288299", (CharSequence)paramString);
  }
  
  public static final boolean b()
  {
    Object localObject2 = c();
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
        ServiceAccountFolderManager.a().c((AppInterface)localObject1, "2909288299");
        return true;
      }
    }
    return false;
  }
  
  @Nullable
  public static final AppRuntime c()
  {
    AppRuntime localAppRuntime = (AppRuntime)null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  @NotNull
  public static final String d()
  {
    return "腾讯新闻";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.qqnews.QQNewsUtilKt
 * JD-Core Version:    0.7.0.1
 */