import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.downloadnew.common.NoticeParam;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class bjoq
{
  public static String a;
  public static ArrayList<String> a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.open.download.start";
    b = "com.tencent.open.download.pause";
    c = "com.tencent.open.download.restart";
    d = "com.tencent.open.download.complete";
    e = "com.tencent.open.download.open";
    f = "com.tencent.open.download.yyb";
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(d);
    jdField_a_of_type_JavaUtilArrayList.add(e);
    jdField_a_of_type_JavaUtilArrayList.add(b);
    jdField_a_of_type_JavaUtilArrayList.add(f);
    jdField_a_of_type_JavaUtilArrayList.add(c);
    jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_JavaLangString);
  }
  
  public static PendingIntent a(int paramInt, NoticeParam paramNoticeParam)
  {
    Intent localIntent = new Intent();
    if (paramNoticeParam != null)
    {
      localIntent.putExtra("noticeParam", paramNoticeParam);
      localIntent.putExtra("param_notifyid", bjom.a().a(paramNoticeParam.f, paramNoticeParam.b, paramNoticeParam.jdField_a_of_type_JavaLangString));
    }
    paramNoticeParam = bjht.r();
    if (!TextUtils.isEmpty(paramNoticeParam)) {
      localIntent.putExtra("processName", paramNoticeParam);
    }
    paramNoticeParam = paramNoticeParam.replace(":", ".");
    switch (paramInt)
    {
    }
    for (;;)
    {
      localIntent.setPackage(MobileQQ.getContext().getPackageName());
      return PendingIntent.getBroadcast(bizw.a().a(), (int)(System.currentTimeMillis() & 0xFFFFFFF), localIntent, 134217728);
      localIntent.setAction(b + "." + paramNoticeParam);
      continue;
      localIntent.setAction(jdField_a_of_type_JavaLangString + "." + paramNoticeParam);
      continue;
      localIntent.setAction(d + "." + paramNoticeParam);
      continue;
      localIntent.setAction(f + "." + paramNoticeParam);
      continue;
      localIntent.setAction(e + "." + paramNoticeParam);
    }
  }
  
  public static Intent a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("adapter_action", "action_push_app_detail");
    localIntent.setClassName("com.tencent.plugin.qappcenter", "com.tencent.open.appcenter.QZoneAppWebViewActivity");
    localIntent.putExtras(paramBundle);
    Object localObject1 = new StringBuffer("sd://qapp_center_detail.htm?");
    Object localObject2 = paramBundle.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str1 = (String)((Iterator)localObject2).next();
      String str2 = paramBundle.getString(str1);
      ((StringBuffer)localObject1).append(str1).append("=").append(str2).append("&");
    }
    localObject2 = bjht.a(((StringBuffer)localObject1).toString());
    localObject1 = localObject2[0];
    localObject2 = "" + localObject2[1];
    String str1 = paramBundle.getString("from");
    localIntent.putExtra("uinRestore", bizw.a().a());
    localIntent.putExtra("APP_URL_NOTICE", (String)localObject1);
    if (a(str1)) {}
    for (localObject1 = a(paramBundle);; localObject1 = localObject2)
    {
      localIntent.putExtra("APP_PARAMS_NOTICE", (String)localObject1);
      bjko.b("IntentFactory", "params=" + (String)localObject2 + "\n pushParams=" + a(paramBundle));
      if (paramBundle.containsKey("friendUin"))
      {
        localIntent.putExtra("friendUin", paramBundle.getString("friendUin"));
        localIntent.putExtra("isTroop", paramBundle.getInt("isTroop"));
      }
      localIntent.addFlags(603979776);
      return localIntent;
    }
  }
  
  public static Intent a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return null;
    }
    Object localObject = bjht.a(paramString1);
    paramString1 = (String)((HashMap)localObject).get("appid");
    String str1 = (String)((HashMap)localObject).get("sendtime");
    String str2 = (String)((HashMap)localObject).get("packname");
    String str3 = (String)((HashMap)localObject).get("packetversion");
    String str4 = (String)((HashMap)localObject).get("msgtype");
    String str5 = (String)((HashMap)localObject).get("type");
    String str6 = (String)((HashMap)localObject).get("downurl");
    localObject = (String)((HashMap)localObject).get("via");
    String str7 = bjhq.a((String)localObject);
    bjko.b("IntentFactory", "appid=" + paramString1 + "&sendtime=" + str1 + "&packname=" + str2 + "&packetversion=" + str3 + "&msgtype=" + str4 + "&type=" + str5 + "&downUrl=" + str6 + "&via=" + (String)localObject);
    int i = bjlo.a(str2);
    int j = bjlo.b(bjna.a().a(paramString1));
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putString("from", "2458");
    localBundle.putString("downloadUrl", str6);
    localBundle.putString("packageName", str2);
    localBundle.putString("installedVersion", String.valueOf(i));
    localBundle.putString("localVersion", String.valueOf(j));
    localBundle.putString("serverApkVersion", str3);
    localBundle.putString("typeid", str5);
    localBundle.putString("msgType", str4);
    localBundle.putString("sendTime", str1);
    localBundle.putString("via", (String)localObject);
    localBundle.putString("splitvia", str7);
    localBundle.putString("friendUin", paramString2);
    localBundle.putInt("isTroop", paramInt);
    return a(localBundle);
  }
  
  protected static String a(Bundle paramBundle)
  {
    Object localObject1;
    if (paramBundle == null)
    {
      localObject1 = "";
      return localObject1;
    }
    String str3 = paramBundle.getString("id");
    bjko.b("IntentFactory", "appId=" + str3);
    String str5;
    if (!TextUtils.isEmpty(str3))
    {
      Object localObject2 = paramBundle.getString("downloadUrl");
      String str4 = paramBundle.getString("packageName");
      String str1 = paramBundle.getString("serverApkVersion");
      localObject1 = str1;
      if (str1 == null) {
        localObject1 = "0";
      }
      str5 = paramBundle.getString("via");
      String str2 = paramBundle.getString("splitvia");
      int j = bjlo.a(str4);
      int k = bjlo.b(bjna.a().a(str3));
      if (bjkj.c(bizw.a().a())) {}
      for (int i = 1;; i = 0)
      {
        try
        {
          str1 = URLEncoder.encode((String)localObject2, "utf-8");
          localObject2 = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            continue;
            paramBundle = paramBundle + "&via=" + str5;
          }
        }
        paramBundle = "&from=-10&id=" + str3 + "&channelId=" + paramBundle.getString("from") + "&installedVersion=" + String.valueOf(j) + "&localVersion=" + k + "&serverApkVersion=" + (String)localObject1 + "&typeId=" + "0" + "&msgType=" + "56" + "&sendTime=" + str3 + "&downloadUrl=" + (String)localObject2 + "&packageName=" + str4 + "&nt=" + i;
        if (!TextUtils.isEmpty(str5)) {
          break label357;
        }
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        return paramBundle + "&splitvia=" + str2;
      }
    }
    label357:
    return "";
  }
  
  protected static boolean a(String paramString)
  {
    return ("2457".equals(paramString)) || ("2458".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoq
 * JD-Core Version:    0.7.0.1
 */