package com.tencent.biz.troopplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import axqy;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mzb;
import mzh;
import nau;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xdk;
import xdm;
import xdn;
import xdo;

public class PluginJumpManager
{
  public static final String BID_INFO = "bidinfo";
  public static final String BID_VERSION = "bid_version";
  public static final String CONFIG_BID = "1007";
  public static final String CONFIG_FILE_VERSION = "config_file_version";
  public static final String CONFIG_VERSION = "version";
  public static final String TAG = "PluginJumpManager";
  public static final String URL_MAPPING = "urlmaping";
  public static final String WEB_PLUGIN_CONFIG = "web_plugin_config";
  public static PluginJumpManager sInstance;
  public boolean isLoadedPlugin;
  public HashMap<String, xdn> mBidInfos;
  public int mConfigVersion;
  public Context mContext;
  public PluginManagerClient mPluginManager;
  public SharedPreferences mPref;
  public HashMap<String, xdo> mUrlmappingInfos;
  
  public PluginJumpManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPref = this.mContext.getSharedPreferences("web_plugin_config", 4);
    this.mBidInfos = new HashMap();
    this.mUrlmappingInfos = new HashMap();
  }
  
  public static PluginJumpManager getInstance()
  {
    if (sInstance == null) {
      sInstance = new PluginJumpManager(BaseApplication.getContext());
    }
    return sInstance;
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    axqy.b(null, "P_CliOper", paramString1, "", paramString2, paramString3, 0, paramInt, paramString4, paramString5, paramString6, paramString7);
  }
  
  public boolean checkQVerAndModel(xdo paramxdo)
  {
    boolean bool2 = true;
    int i;
    boolean bool1;
    int j;
    try
    {
      i = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode;
      if (TextUtils.isEmpty(paramxdo.e)) {
        if (TextUtils.isEmpty(paramxdo.d))
        {
          bool1 = bool2;
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramxdo.f))
          {
            Object localObject = Build.BRAND;
            String str2 = Build.MODEL;
            String str1 = Build.VERSION.RELEASE;
            paramxdo = paramxdo.f.split(",");
            localObject = new StringBuffer((String)localObject);
            ((StringBuffer)localObject).append(" ").append(str2);
            str2 = ((StringBuffer)localObject).toString().toLowerCase();
            str1 = (" " + str1).toLowerCase();
            j = paramxdo.length;
            i = 0;
            label147:
            bool2 = bool1;
            if (i < j)
            {
              localObject = paramxdo[i].toLowerCase();
              if ((!((String)localObject).contains(str2)) || (!str1.startsWith((String)localObject))) {
                break label281;
              }
              bool2 = false;
            }
          }
          return bool2;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        i = 0;
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.valueOf(paramxdo.d).intValue();
        if (i < j) {
          break label294;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        bool1 = false;
        continue;
      }
      String[] arrayOfString = paramxdo.e.split(",");
      int k = arrayOfString.length;
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          bool1 = bool2;
          if (String.valueOf(i).equals(arrayOfString[j])) {
            break;
          }
          j += 1;
          continue;
          label281:
          i += 1;
          break label147;
        }
      }
      bool1 = false;
      break;
      label294:
      bool1 = false;
    }
  }
  
  public void launchPlugin(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, boolean paramBoolean)
  {
    QLog.e("PluginJumpManager", 1, "TroopBarProxyActivity 已在725下架");
  }
  
  public void loadConfig()
  {
    int j = 0;
    try
    {
      i = Integer.valueOf(this.mPref.getString("version", "0")).intValue();
      if (i <= this.mConfigVersion) {
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginJumpManager", 2, "version parse error!");
        }
        int i = 0;
        continue;
        this.mConfigVersion = i;
        Object localObject2 = this.mPref.getString("bidinfo", "");
        Object localObject1 = this.mPref.getString("urlmaping", "");
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          int k = ((JSONArray)localObject2).length();
          i = 0;
          Object localObject3;
          while (i < k)
          {
            localObject3 = new xdn(this);
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            ((xdn)localObject3).jdField_a_of_type_JavaLangString = localJSONObject.optString("bid");
            ((xdn)localObject3).b = localJSONObject.optString("pluginid");
            ((xdn)localObject3).c = localJSONObject.optString("pluginname");
            this.mBidInfos.put(((xdn)localObject3).jdField_a_of_type_JavaLangString, localObject3);
            i += 1;
          }
          localObject1 = new JSONArray((String)localObject1);
          k = ((JSONArray)localObject1).length();
          i = j;
          while (i < k)
          {
            localObject2 = new xdo(this);
            localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            ((xdo)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("url");
            ((xdo)localObject2).b = ((JSONObject)localObject3).optString("activity");
            ((xdo)localObject2).c = ((JSONObject)localObject3).optString("bid");
            ((xdo)localObject2).f = ((JSONObject)localObject3).optString("a_black_ver");
            ((xdo)localObject2).d = ((JSONObject)localObject3).optString("q_min_ver");
            ((xdo)localObject2).e = ((JSONObject)localObject3).optString("q_white_ver");
            ((xdo)localObject2).jdField_a_of_type_Boolean = ((JSONObject)localObject3).optBoolean("useiphonetitlebar");
            ((xdo)localObject2).g = ((JSONObject)localObject3).optString("extra");
            this.mUrlmappingInfos.put(((xdo)localObject2).jdField_a_of_type_JavaLangString, localObject2);
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      QLog.d("PluginJumpManager", 2, "config parse error!");
    }
  }
  
  public void loadConfigFromFile()
  {
    Object localObject1 = new File(mzh.a("1007") + "1007" + "/urlplugin.cfg");
    InputStream localInputStream;
    if (((File)localObject1).exists())
    {
      try
      {
        localObject1 = new FileInputStream((File)localObject1);
        if (localObject1 != null) {
          break label103;
        }
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          report("BizTechReport", "native_plugin", "read_config", 1, null, null, null, null);
          localIOException.printStackTrace();
          localInputStream = null;
        }
      }
    }
    else
    {
      report("BizTechReport", "native_plugin", "read_config", 2, null, null, null, null);
      return;
    }
    label103:
    Object localObject2 = nau.a(localInputStream);
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      SharedPreferences.Editor localEditor = this.mPref.edit();
      localEditor.putString("config_file_version", mzb.a("1007"));
      localEditor.putString("version", ((JSONObject)localObject2).optString("version"));
      localEditor.putString("bidinfo", ((JSONObject)localObject2).optString("bidinfo"));
      localEditor.putString("urlmaping", ((JSONObject)localObject2).optString("urlmaping")).commit();
      report("BizTechReport", "native_plugin", "read_config", 0, null, null, null, null);
      try
      {
        localInputStream.close();
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  public final void openLinkInNewWebView(Activity paramActivity, String paramString1, String paramString2)
  {
    Bundle localBundle;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localBundle = paramActivity.getIntent().getExtras();
      if (localBundle != null) {
        break label130;
      }
      localBundle = new Bundle();
    }
    try
    {
      for (;;)
      {
        i = Integer.valueOf(paramString2).intValue();
        switch (i)
        {
        default: 
          if (!(paramActivity instanceof mqq.app.BaseActivity)) {
            break label268;
          }
          paramString2 = new Intent(paramActivity, paramActivity.getClass());
          paramString2.putExtras(localBundle);
          paramString2.putExtra("url", paramString1);
          paramString2.setFlags(0);
          paramActivity.startActivityForResult(paramString2, 100);
          return;
          label130:
          localBundle.remove("title");
          localBundle.remove("leftViewText");
          localBundle.remove("post_data");
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i = 0;
        continue;
        localBundle.putBoolean("hide_more_button", false);
        localBundle.putBoolean("hide_operation_bar", true);
        continue;
        localBundle.putBoolean("hide_more_button", true);
        localBundle.putBoolean("hide_operation_bar", true);
        continue;
        localBundle.putBoolean("hide_more_button", false);
        localBundle.putBoolean("hide_operation_bar", false);
        localBundle.putString("webStyle", "");
        continue;
        localBundle.putBoolean("hide_more_button", true);
        localBundle.putBoolean("hide_operation_bar", false);
        localBundle.putString("webStyle", "");
        continue;
        label268:
        paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
      }
    }
  }
  
  public boolean openView(Activity paramActivity, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return false;
      AppRuntime localAppRuntime = null;
      if ((paramActivity instanceof mqq.app.BaseActivity)) {
        localAppRuntime = ((mqq.app.BaseActivity)paramActivity).getAppRuntime();
      }
      while (localAppRuntime != null)
      {
        String str = localAppRuntime.getAccount();
        return openView(paramActivity, paramString1, paramString2, str, ((TicketManager)localAppRuntime.getManager(2)).getSkey(str), false);
        if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity)) {
          localAppRuntime = ((com.tencent.mobileqq.app.BaseActivity)paramActivity).getAppRuntime();
        }
      }
    }
  }
  
  public boolean openView(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (!Uri.parse(paramString1).isHierarchical()) {
      return false;
    }
    int i = paramString1.indexOf("?");
    if (i > 0) {}
    for (Object localObject1 = paramString1.substring(0, i); !this.mUrlmappingInfos.containsKey(localObject1); localObject1 = paramString1) {
      return false;
    }
    localObject1 = (xdo)this.mUrlmappingInfos.get(localObject1);
    Object localObject2 = ((xdo)localObject1).c;
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!this.mBidInfos.containsKey(localObject2))) {
      return false;
    }
    if (!checkQVerAndModel((xdo)localObject1)) {
      return false;
    }
    if (!TextUtils.isEmpty(((xdo)localObject1).g))
    {
      String[] arrayOfString;
      int j;
      if (((xdo)localObject1).g.contains(","))
      {
        arrayOfString = ((xdo)localObject1).g.split(",");
        int k = arrayOfString.length;
        j = 0;
        i = 0;
        while (i < k)
        {
          if (paramString1.contains(arrayOfString[i])) {
            j = 1;
          }
          i += 1;
        }
        if (j == 0) {
          return false;
        }
      }
      else
      {
        if (((xdo)localObject1).g.contains(";"))
        {
          arrayOfString = ((xdo)localObject1).g.split(";");
          i = 0;
          j = arrayOfString.length;
          while (i < j)
          {
            if (!paramString1.contains(arrayOfString[i])) {
              return false;
            }
            i += 1;
          }
        }
        if (!paramString1.contains(((xdo)localObject1).g)) {
          return false;
        }
      }
    }
    localObject2 = (xdn)this.mBidInfos.get(localObject2);
    PluginManagerHelper.getPluginInterface(paramActivity.getApplicationContext(), new xdm(this, (xdn)localObject2, paramActivity, paramString3, paramString1, paramString4, l, (xdo)localObject1, paramString2));
    return true;
  }
  
  public void updateConfig(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    mzb.a();
    if (paramAppRuntime.getLongAccountUin() % 10L == 6L) {}
    for (boolean bool = true;; bool = false)
    {
      mzb.jdField_a_of_type_Boolean = bool;
      mzb.b("1007", paramAppRuntime, true, new xdk(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopplugin.PluginJumpManager
 * JD-Core Version:    0.7.0.1
 */