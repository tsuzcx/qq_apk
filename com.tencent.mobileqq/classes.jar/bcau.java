import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.AppClient.1;
import com.tencent.open.appcommon.AppClient.2;
import com.tencent.open.appcommon.AppClient.3;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class bcau
{
  public static Class a(String paramString)
  {
    try
    {
      Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
      if (paramString.equals("detail")) {
        return QZoneAppListActivity.class;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      if (paramString.equals("index")) {
        return QZoneAppListActivity.class;
      }
      if (!paramString.equals("online")) {}
    }
    return QZoneAppListActivity.class;
  }
  
  protected static String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    bcds.c("AppClient", "getFeedsChannelId >>> qzoneAppid = " + paramInt1 + "| " + paramInt2 + " | " + paramInt3);
    if (paramInt1 == 352) {}
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "";
    case 1: 
    case 3: 
      return "100_1";
    case 7: 
    case 8: 
      if ((paramInt3 == 0) || (paramInt3 == 2)) {
        return "200_1";
      }
      if (paramInt3 == 1) {
        return "200_2";
      }
      break;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("\\.");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 2;
    if ((paramString != null) && (paramString.length > 2))
    {
      if (i < paramString.length)
      {
        if (i == paramString.length - 1) {
          localStringBuilder.append(paramString[i]);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append(paramString[i] + ".");
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    bcax.a();
    int i = paramBundle.getInt("qzoneAppid");
    int j = paramBundle.getInt("qzoneSubId");
    int k = paramBundle.getInt("op_type");
    int m = paramBundle.getInt("from");
    boolean bool = paramBundle.getBoolean("is_can_open_yyb_native", true);
    paramActivity = paramBundle.getString("schemaUrl");
    Object localObject6;
    Object localObject2;
    if ((!TextUtils.isEmpty(paramActivity)) && (paramActivity.contains("&")))
    {
      localObject6 = new Bundle();
      if (paramActivity.startsWith("http://")) {}
      String str2;
      for (;;)
      {
        try
        {
          localObject2 = new URL(paramActivity).getQuery();
          HashMap localHashMap = bcax.a((String)localObject2);
          str1 = (String)localHashMap.get("appid");
          if (TextUtils.isEmpty(str1))
          {
            str1 = (String)localHashMap.get(bcgl.b);
            localObject4 = (String)localHashMap.get(bcgl.jdField_c_of_type_JavaLangString);
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              break label416;
            }
            localObject4 = (String)localHashMap.get("ta");
            localObject5 = (String)localHashMap.get(bcgl.d);
            if (!TextUtils.isEmpty((CharSequence)localObject5)) {
              break label419;
            }
            localObject5 = (String)localHashMap.get("tk");
            str2 = (String)localHashMap.get(bcgl.e);
            localObject7 = (String)localHashMap.get("via");
            localObject3 = (String)localHashMap.get("packName");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label422;
            }
            localObject3 = (String)localHashMap.get(bcgl.f);
            paramActivity = (String)localHashMap.get(bcgl.B);
            bcds.d("AppClient", " feedChannel:" + paramActivity + "   schemaUrl:" + (String)localObject2);
            if ((!TextUtils.isEmpty(paramActivity)) && (!paramActivity.startsWith("0;"))) {
              break label425;
            }
            paramActivity = "";
            bcds.d("AppClient", " finalFeedChannel:" + paramActivity);
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!bcev.a((String)localObject3))) {
              break;
            }
            paramActivity = (String)localHashMap.get("appCustom");
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          String str1;
          localMalformedURLException.printStackTrace();
        }
        try
        {
          paramBundle = URLDecoder.decode(paramActivity, "UTF-8");
          paramActivity = paramBundle;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            CharSequence localCharSequence;
            Object localObject1;
            break;
          }
        }
        bcev.a(bbtm.a().a(), str1, (String)localObject3, paramActivity);
        return;
        localObject2 = paramActivity;
        continue;
        continue;
        label416:
        continue;
        label419:
        continue;
        label422:
        continue;
        label425:
        paramActivity = paramActivity.split(";");
        if (paramActivity == null)
        {
          paramActivity = "";
        }
        else if (paramActivity.length <= 0)
        {
          paramActivity = "";
        }
        else
        {
          localCharSequence = paramActivity[0];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            paramActivity = localCharSequence;
            if (!localCharSequence.equals("0")) {}
          }
          else
          {
            paramActivity = "";
          }
        }
      }
      ((Bundle)localObject6).putString(bcgl.b, localMalformedURLException);
      ((Bundle)localObject6).putString(bcgl.jdField_c_of_type_JavaLangString, (String)localObject4);
      ((Bundle)localObject6).putString(bcgl.d, (String)localObject5);
      ((Bundle)localObject6).putString(bcgl.e, str2);
      ((Bundle)localObject6).putString(bcgl.f, (String)localObject3);
      ((Bundle)localObject6).putString(bcgl.i, (String)localObject7);
      ((Bundle)localObject6).putString(bcgl.B, paramActivity);
      ((Bundle)localObject6).putString("schemaUrl", (String)localObject2);
      paramActivity = (Activity)localObject6;
      localObject5 = str2;
      localObject4 = localObject3;
      localObject3 = paramActivity;
      paramActivity = (Activity)localObject7;
      if (k != 7) {
        break label735;
      }
      localObject7 = a(i, j, m, localMalformedURLException);
      if (!TextUtils.isEmpty(paramActivity)) {
        break label1256;
      }
      paramActivity = bcfb.a(i, j, m);
      bcfn.a().a(String.valueOf(bbtm.a().a()), localMalformedURLException, paramActivity, "200", false);
      localObject6 = paramActivity;
    }
    for (paramActivity = (Activity)localObject7;; paramActivity = (Activity)localObject7)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject4)) || ("0".equals(localObject5)) || (localObject3 == null) || (!bchb.a().c()) || (!bool)) {
        break label749;
      }
      ThreadManager.getSubThreadHandler().post(new AppClient.2(paramBundle, (Bundle)localObject3, localMalformedURLException, (String)localObject2, paramActivity, (String)localObject6));
      return;
      localObject3 = null;
      localObject4 = null;
      localObject5 = "0";
      localObject6 = null;
      localObject1 = paramActivity;
      localObject2 = paramActivity;
      paramActivity = (Activity)localObject6;
      break;
      label735:
      localObject7 = "2410";
      localObject6 = paramActivity;
    }
    label749:
    Object localObject3 = bcax.f() + File.separator + "qapp_center_detail.htm";
    Object localObject4 = new File((String)localObject3);
    if (!((File)localObject4).exists())
    {
      bcds.d("AppClient", "file" + (String)localObject3 + " not exist copyassets.");
      bcdp.a("Page/system", bcax.g());
    }
    Object localObject5 = new Intent();
    Object localObject7 = new Bundle();
    if (((File)localObject4).exists())
    {
      localObject3 = "file:///" + (String)localObject3;
      localObject4 = "&from=-10&id=" + (String)localObject1 + "&channelId=" + paramActivity;
      paramActivity = (Activity)localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!((String)localObject2).equals(localObject1)) {
          break label1206;
        }
        paramActivity = (Activity)localObject4;
      }
      label945:
      if (bcax.a(paramBundle.getString("schemaUrl")).get("auto_download") == null) {
        break label1235;
      }
      i = 1;
      label965:
      localObject1 = paramActivity;
      if (i != 0)
      {
        localObject1 = paramActivity;
        if (!paramActivity.contains("auto_download")) {
          localObject1 = paramActivity + "&auto_download=1";
        }
      }
      ((Intent)localObject5).setClass(bbtm.a().a(), QZoneAppListActivity.class);
      ((Bundle)localObject7).putString("APP_URL", (String)localObject3);
      ((Bundle)localObject7).putBoolean("FROM_FEED", true);
      ((Bundle)localObject7).putString("APP_PARAMS", (String)localObject1);
      if (!DownloadSDKConfigManager.canGotoNewDetailPage((String)localObject6)) {
        break label1240;
      }
      ((Bundle)localObject7).putInt("goto_type", 7);
    }
    for (;;)
    {
      if (paramBundle.getInt("process_id") == 2) {
        ((Bundle)localObject7).putInt("process_id", 2);
      }
      bcds.b("Jie", "APP_URL:" + (String)localObject3 + " |  PARAMS >>> " + ((Bundle)localObject7).getString("APP_PARAMS"));
      ((Intent)localObject5).putExtras((Bundle)localObject7);
      ((Intent)localObject5).putExtra("adapter_action", "action_app_detail");
      ((Intent)localObject5).addFlags(872415232);
      bbtm.a().a().startActivity((Intent)localObject5);
      return;
      localObject3 = bcax.l() + File.separator + "qapp_center_detail.htm";
      break;
      label1206:
      paramActivity = (String)localObject4 + "&" + (String)localObject2;
      break label945;
      label1235:
      i = 0;
      break label965;
      label1240:
      ((Bundle)localObject7).putInt("goto_type", 2);
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaUrl", paramString);
    a(paramActivity, localBundle);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaUrl", paramString);
    localBundle.putInt("qzoneAppid", paramInt1);
    localBundle.putInt("qzoneSubId", paramInt2);
    localBundle.putInt("from", paramInt3);
    a(paramActivity, localBundle);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Bundle paramBundle)
  {
    String str1 = bcax.f() + File.separator + "qapp_center_detail.htm";
    bcax.a();
    Object localObject = new File(str1);
    if (!((File)localObject).exists())
    {
      bcds.d("AppClient", "file" + str1 + " not exist copyassets.");
      bcdp.a("Page/system", bcax.g());
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    String str2;
    if (((File)localObject).exists())
    {
      str2 = "file:///" + str1;
      localIntent.setClass(bbtm.a().a(), QZoneAppListActivity.class);
      str1 = "&from=-10&id=" + paramString + "&channelId=" + paramInt;
      paramString = null;
      if (paramBundle != null) {
        paramString = paramBundle.getString("via");
      }
      if (!DownloadSDKConfigManager.canGotoNewDetailPage(paramString)) {
        break label554;
      }
      localBundle.putInt("goto_type", 7);
      label218:
      if (!TextUtils.isEmpty(paramString)) {
        break label566;
      }
    }
    for (;;)
    {
      int i = 0;
      paramString = str1;
      if (paramBundle != null)
      {
        boolean bool = paramBundle.getBoolean("autoDownload");
        paramString = paramBundle.getString("packageName");
        localObject = str1;
        if (!TextUtils.isEmpty(paramString)) {
          localObject = str1 + "&packageName=" + paramString;
        }
        str1 = paramBundle.getString("subpagetype");
        paramString = (String)localObject;
        i = bool;
        if (!TextUtils.isEmpty(str1))
        {
          paramString = (String)localObject + "&subpagetype=" + str1;
          i = bool;
        }
      }
      str1 = paramString;
      if (i != 0) {
        str1 = paramString + "&msgType=56";
      }
      localBundle.putString("APP_PARAMS", str1);
      if (paramBundle != null)
      {
        localBundle.putString("uin", paramBundle.getString("uin"));
        localBundle.putString("sid", paramBundle.getString("vkey"));
      }
      localBundle.putString("APP_URL", str2);
      localBundle.putBoolean("FROM_FEED", true);
      bcds.b("Jie", "APP_URL:" + str2 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
      localIntent.putExtras(localBundle);
      localIntent.putExtra("adapter_action", "action_app_detail");
      localIntent.addFlags(603979776);
      paramActivity.startActivityForResult(localIntent, 200);
      return;
      str2 = bcax.l() + File.separator + "qapp_center_detail.htm";
      break;
      label554:
      localBundle.putInt("goto_type", 3);
      break label218;
      label566:
      str1 = str1 + "&via=" + paramString;
    }
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4)
  {
    bcax.a();
    int i = 1;
    Object localObject;
    if (!paramString3.equals("online"))
    {
      paramString4 = bcax.f() + File.separator + paramString4;
      localObject = new File(paramString4);
      if (!((File)localObject).exists())
      {
        bcds.d("AppClient", "file" + paramString4 + " not exist copyassets.");
        bcdp.a("Page/system", bcax.g());
      }
      if (((File)localObject).exists()) {
        paramString4 = "file:///" + paramString4;
      }
    }
    Intent localIntent;
    Bundle localBundle;
    String str1;
    for (;;)
    {
      localIntent = new Intent();
      localBundle = new Bundle();
      Class localClass = a(paramString3);
      localIntent.setClass(paramActivity, localClass);
      String str5 = paramBundle.getString("installedVersion");
      String str6 = paramBundle.getString("localVersion");
      String str7 = paramBundle.getString("typeid");
      String str8 = paramBundle.getString("serverApkVersion");
      String str9 = paramBundle.getString("msgType");
      String str10 = paramBundle.getString("sendTime");
      str1 = paramBundle.getString("via");
      String str3 = paramBundle.getString("splitvia");
      String str4 = paramBundle.getString("subPageType");
      String str2 = paramBundle.getString("appCustom");
      localObject = paramString2;
      if (paramString2 == "2460") {
        localObject = paramString2 + "_" + str9;
      }
      paramString2 = "&from=-10&id=" + paramString1 + "&channelId=" + (String)localObject + "&installedVersion=" + str5 + "&localVersion=" + str6 + "&serverApkVersion=" + str8 + "&typeId=" + str7 + "&msgType=" + str9 + "&sendTime=" + str10;
      str5 = paramBundle.getString("schemaUrl");
      if (TextUtils.isEmpty(str4))
      {
        label409:
        if (!TextUtils.isEmpty(str1)) {
          break label967;
        }
        label417:
        if (!TextUtils.isEmpty(str3)) {
          break label996;
        }
        label425:
        if (!TextUtils.isEmpty(str2)) {
          break label1025;
        }
        label433:
        if (!TextUtils.isEmpty(str5)) {
          break label1054;
        }
        label441:
        localBundle.putString("APP_PARAMS", paramString2);
        localBundle.putString("uin", paramBundle.getString("uin"));
        localBundle.putString("sid", paramBundle.getString("vkey"));
        localBundle.putString("APP_URL", paramString4);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString(bcgl.i, str1);
        if (!"detail".equals(paramString3)) {
          break label1082;
        }
        localBundle.putInt("goto_type", 2);
        label528:
        if ((!paramString3.equals("custom")) || (i == 0)) {}
      }
      try
      {
        paramString2 = paramBundle.getString("pageTitles");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = new ArrayList(Arrays.asList(paramString2.split("&")));
          localBundle.putStringArrayList("titleName", paramString2);
          if (paramString2.size() > 0)
          {
            bool = true;
            localBundle.putBoolean("showTitle", bool);
            bcds.b("AppClient", "titles = " + paramString2);
          }
        }
        else
        {
          bcds.b("TAG", "APP_URL:" + paramString4 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
          localIntent.putExtras(localBundle);
          localIntent.putExtra("adapter_action", "action_app_detail");
          localIntent.addFlags(603979776);
        }
      }
      catch (Exception paramString2)
      {
        try
        {
          for (;;)
          {
            paramString2 = Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
            if ((paramString2 == null) || (!localClass.getName().equals(paramString2.getName()))) {
              break label1167;
            }
            if (!((String)localObject).equals("2457")) {
              break label1143;
            }
            paramString1 = bcgo.a().a(paramString1);
            if ((!bchb.a().c()) || (paramString1 == null) || (paramString1.jdField_c_of_type_Int != 1)) {
              break label1133;
            }
            bcds.d("AppClient", ">>>appid=" + paramString1.jdField_c_of_type_JavaLangString + " myAppid=" + paramString1.j);
            localBundle.putString(bcgl.b, paramString1.jdField_c_of_type_JavaLangString);
            localBundle.putString(bcgl.jdField_c_of_type_JavaLangString, paramString1.j);
            localBundle.putString(bcgl.d, paramString1.k);
            localBundle.putString(bcgl.i, str1);
            localBundle.putString(bcgl.f, paramString1.e);
            localBundle.putInt(bcgl.e, paramString1.b);
            bchb.a().a(paramActivity, localBundle, ((String)localObject).equals("2457"), true);
            return;
            i = 0;
            paramString4 = bcax.l() + File.separator + "qapp_center_detail.htm";
            break;
            break;
            paramString2 = paramString2 + "&subPageType=" + str4;
            break label409;
            label967:
            paramString2 = paramString2 + "&via=" + str1;
            break label417;
            label996:
            paramString2 = paramString2 + "&splitVia=" + str3;
            break label425;
            label1025:
            paramString2 = paramString2 + "&appCustom=" + str2;
            break label433;
            label1054:
            paramString2 = paramString2 + "&" + str5;
            break label441;
            label1082:
            if (!"index".equals(paramString3)) {
              break label528;
            }
            localBundle.putInt("goto_type", 1);
            break label528;
            boolean bool = false;
          }
          paramString2 = paramString2;
          bcds.c("AppClient", "get push title error>>>", paramString2);
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramString2.printStackTrace();
            paramString2 = null;
          }
          label1133:
          paramActivity.startActivityForResult(localIntent, 200);
          return;
        }
      }
    }
    label1143:
    ThreadManager.getSubThreadHandler().post(new AppClient.1(paramString1, localBundle, str1, paramActivity, localIntent, paramBundle));
    return;
    label1167:
    paramActivity.startActivityForResult(localIntent, 200);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, "2457");
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bcds.b("AppClient", "shcemaUrlAnd:" + paramString1);
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      return;
      Object localObject2 = bcax.a(paramString1);
      String str8 = (String)((HashMap)localObject2).get("appid");
      String str10 = (String)((HashMap)localObject2).get("sendtime");
      String str9 = (String)((HashMap)localObject2).get("packname");
      String str13 = (String)((HashMap)localObject2).get("packetversion");
      String str11 = (String)((HashMap)localObject2).get("msgtype");
      String str14 = (String)((HashMap)localObject2).get("type");
      Object localObject1 = (String)((HashMap)localObject2).get("downurl");
      String str12 = (String)((HashMap)localObject2).get("via");
      String str15 = a(str12);
      String str7 = (String)((HashMap)localObject2).get("appCustom");
      String str2 = (String)((HashMap)localObject2).get("nativepage");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = (String)((HashMap)localObject2).get("np");
      }
      str2 = (String)((HashMap)localObject2).get("htmlpage");
      label236:
      label370:
      String str16;
      label270:
      label304:
      label337:
      int i;
      if (TextUtils.isEmpty(str2))
      {
        str2 = (String)((HashMap)localObject2).get("hp");
        String str3 = (String)((HashMap)localObject2).get("subpagetype");
        if (!TextUtils.isEmpty(str3)) {
          break label864;
        }
        str3 = (String)((HashMap)localObject2).get("sp");
        String str4 = (String)((HashMap)localObject2).get("pagetitles");
        if (!TextUtils.isEmpty(str4)) {
          break label867;
        }
        str4 = (String)((HashMap)localObject2).get("pt");
        String str5 = (String)((HashMap)localObject2).get(bcgl.jdField_c_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str5)) {
          break label870;
        }
        str5 = (String)((HashMap)localObject2).get("ta");
        String str6 = (String)((HashMap)localObject2).get(bcgl.d);
        if (!TextUtils.isEmpty(str6)) {
          break label873;
        }
        str6 = (String)((HashMap)localObject2).get("tk");
        str16 = (String)((HashMap)localObject2).get("minvercode");
        localObject2 = (String)((HashMap)localObject2).get("backurl");
        bcds.b("AppClient", "appid=" + str8 + " ,sendtime=" + str10 + " ,packname=" + str9 + " ,packetversion=" + str13 + " ,msgtype=" + str11 + " ,type=" + str14 + " ,downUrl=" + (String)localObject1 + " ,nativePage=" + str1 + " ,htmlPage=" + str2 + " ,subPageType=" + str3 + " ,pageTitles=" + str4 + " ,minvercode=" + str16 + " ,backUrl=" + (String)localObject2);
        i = bcev.a(str9);
        int j = bcev.b(bcgo.a().a(str8));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("installedVersion", String.valueOf(i));
        ((Bundle)localObject1).putString("localVersion", String.valueOf(j));
        ((Bundle)localObject1).putString("serverApkVersion", str13);
        ((Bundle)localObject1).putString("typeid", str14);
        ((Bundle)localObject1).putString("msgType", str11);
        ((Bundle)localObject1).putString("sendTime", str10);
        ((Bundle)localObject1).putString("subPageType", str3);
        ((Bundle)localObject1).putString("pageTitles", str4);
        ((Bundle)localObject1).putString("appCustom", str7);
        ((Bundle)localObject1).putString("schemaUrl", paramString1);
        if (!TextUtils.isEmpty(str12))
        {
          ((Bundle)localObject1).putString("via", str12);
          ((Bundle)localObject1).putString("splitvia", str15);
        }
        ((Bundle)localObject1).putString("uin", paramString2);
        ((Bundle)localObject1).putString("vkey", paramString3);
        ((Bundle)localObject1).putString(bcgl.b, str8);
        ((Bundle)localObject1).putString(bcgl.jdField_c_of_type_JavaLangString, str5);
        ((Bundle)localObject1).putString(bcgl.d, str6);
        if (!TextUtils.isEmpty(str9)) {
          ((Bundle)localObject1).putString(bcgl.f, str9);
        }
        ((Bundle)localObject1).putString(bcgl.e, str13);
      }
      try
      {
        bbtm.a().a(Integer.parseInt(paramString2));
        label800:
        bbtm.a().a(paramString3);
        b(paramString4, str11, str8, str12);
        if ("2460".equals(paramString4))
        {
          a(paramString2, paramString3, str8, str10);
          if (i <= 0) {}
        }
        try
        {
          paramString1 = URLDecoder.decode(str7, "UTF-8");
          bcev.a(paramActivity, str8, str9, paramString1);
          return;
          break label236;
          label864:
          break label270;
          label867:
          break label304;
          label870:
          break label337;
          label873:
          break label370;
          if (TextUtils.isEmpty(str1))
          {
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "detail", "qapp_center_detail.htm");
            return;
          }
          if (str1.equals("tmast"))
          {
            if (TextUtils.isEmpty(str2)) {
              continue;
            }
            i = bcev.a("com.tencent.android.qqdownloader");
            if ((!TextUtils.isEmpty(str16)) && (i > 0) && (i >= Integer.valueOf(str16).intValue()))
            {
              paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
              paramString1.setFlags(268435456);
              paramActivity.startActivity(paramString1);
              return;
            }
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "online", (String)localObject2);
            return;
          }
          if (str1.equals("detail"))
          {
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "detail", "qapp_center_detail.htm");
            return;
          }
          a(paramActivity, str8, paramString4, (Bundle)localObject1, str1, str2);
          return;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1 = str7;
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        break label800;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("process_id", 2);
    localBundle.putString("schemaUrl", paramString);
    localBundle.putBoolean("is_can_open_yyb_native", paramBoolean);
    if ((paramContext instanceof Activity))
    {
      a((Activity)paramContext, localBundle);
      return;
    }
    a(null, localBundle);
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("huin", paramString1);
    localBundle.putString("keytype", "256");
    localBundle.putString("keystr", paramString2);
    localBundle.putString("appid", paramString3);
    localBundle.putString("platform", bbtm.a().g());
    localBundle.putString("requestkeys", paramString4);
    localBundle.putString("mode", "1");
    localBundle.putString("v", bbtm.a().e());
    new bcen("http://appic.qq.com/cgi-bin/appstage/mapp_setrequest.cgi", "GET", null).execute(new Bundle[] { localBundle });
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("packageName");
    String str2 = paramBundle.getString("appId");
    boolean bool = paramBundle.getBoolean("autoDownload");
    paramBundle = paramBundle.getString("big_brother_source_key");
    bcfb.a("200", "ANDROIDQQ.SHARESOURCE", str2);
    ThreadManager.executeOnSubThread(new AppClient.3(str2, str1, paramBundle, paramActivity, bool));
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, "2460");
  }
  
  protected static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("2457".equals(paramString1)) {
      if (!TextUtils.isEmpty(paramString4)) {
        break label67;
      }
    }
    for (String str = "ANDROIDQQ.PCPUSH.AIOMSG";; str = paramString4)
    {
      bcfb.a("200", str, paramString3);
      if ("2460".equals(paramString1)) {}
      label67:
      try
      {
        paramString2 = bcfb.a(Integer.parseInt(paramString2));
        paramString1 = paramString4;
        if (TextUtils.isEmpty(paramString4)) {
          paramString1 = paramString2;
        }
        bcfb.a("200", paramString1, paramString3);
        return;
      }
      catch (NumberFormatException paramString1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcau
 * JD-Core Version:    0.7.0.1
 */