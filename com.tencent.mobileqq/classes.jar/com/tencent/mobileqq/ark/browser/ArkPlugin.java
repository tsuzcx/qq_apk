package com.tencent.mobileqq.ark.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ark.ark.Application;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  boolean a = false;
  private ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap();
  private String d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private ConcurrentHashMap<String, String> i = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> j = new ConcurrentHashMap();
  private Dialog k = null;
  private int l = 0;
  private Context m;
  
  public ArkPlugin()
  {
    this.mPluginNameSpace = "lightapp";
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ArkPlugin", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
      return;
    }
    this.i.clear();
    this.j.clear();
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject1 = paramString.optJSONObject("web-view-jump-web-config");
      paramString = paramString.optJSONObject("web-view-open-app-config");
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          Object localObject4 = ((JSONObject)localObject1).get((String)localObject3);
          if (((localObject4 instanceof String)) && (localObject4 != null)) {
            this.i.put(localObject3, (String)localObject4);
          }
        }
      }
      if (paramString != null)
      {
        localObject1 = paramString.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = paramString.get((String)localObject2);
          if (((localObject3 instanceof String)) && (localObject3 != null)) {
            this.j.put(localObject2, (String)localObject3);
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("ArkPlugin", 1, String.format("decodeArkH5Config, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  Context a()
  {
    for (Activity localActivity = this.mRuntime.d(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  protected void a(String paramString)
  {
    Object localObject = this.k;
    if (localObject == null)
    {
      this.k = new ReportDialog(QBaseActivity.sTopActivity, 2131953338);
      this.k.setContentView(2131624611);
      localObject = (TextView)this.k.findViewById(2131431880);
      TextView localTextView1 = (TextView)this.k.findViewById(2131431876);
      TextView localTextView2 = (TextView)this.k.findViewById(2131431864);
      TextView localTextView3 = (TextView)this.k.findViewById(2131431870);
      ((TextView)localObject).setText(2131917233);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView1.setText(paramString);
      }
      localTextView3.setText(2131918066);
      localTextView3.setOnClickListener(new ArkPlugin.1(this));
      localTextView2.setOnClickListener(new ArkPlugin.2(this));
      localTextView2.setText(2131887648);
      return;
    }
    localObject = (TextView)((Dialog)localObject).findViewById(2131431876);
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        int n = paramString1.lastIndexOf(paramString2);
        bool1 = bool2;
        if (n >= 0)
        {
          bool1 = bool2;
          if (n == paramString1.length() - paramString2.length()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  protected void b()
  {
    if (this.a) {
      return;
    }
    try
    {
      ArkMultiProcUtil.a();
    }
    catch (Exception localException)
    {
      QLog.e("ArkPlugin", 1, String.format("setupArkEnvironment error, err=%s", new Object[] { localException.getMessage() }));
    }
    Object localObject = (WebViewFragment)this.mRuntime.f();
    if (localObject != null)
    {
      localObject = ((WebViewFragment)localObject).getArguments();
      if (localObject != null)
      {
        localObject = ((Intent)((Bundle)localObject).getParcelable("intent")).getExtras();
        if (localObject != null)
        {
          this.h = ((Bundle)localObject).getString("h5_ark_app_name");
          this.f = ((Bundle)localObject).getString("h5_ark_app_path");
          this.g = ((Bundle)localObject).getString("h5_ark_app_des");
          d(((Bundle)localObject).getString("h5_ark_check_config"));
          this.a = true;
        }
      }
    }
  }
  
  protected void c()
  {
    if (this.mRuntime == null) {
      return;
    }
    Activity localActivity = this.mRuntime.d();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      QQToast.makeText(localActivity, HardCodeUtil.a(2131898963), 0).show();
    }
  }
  
  protected boolean c(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    Integer localInteger = Integer.valueOf(1);
    if (bool1) {
      return true;
    }
    Object localObject1 = b(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return true;
    }
    this.e = ((String)localObject1);
    boolean bool2 = this.b.containsKey(this.e);
    bool1 = false;
    if (bool2)
    {
      localObject1 = (Integer)this.b.get(this.e);
      if (localObject1 != null)
      {
        if (((Integer)localObject1).intValue() == 1) {
          return false;
        }
        if (((Integer)localObject1).intValue() == 0)
        {
          c();
          return true;
        }
      }
    }
    b();
    localObject1 = null;
    Object localObject2 = this.mRuntime.f();
    if (localObject2 != null) {
      localObject1 = ((WebViewProvider)localObject2).getUrlFromIntent();
    }
    localObject1 = b((String)localObject1);
    if (a(this.e, (String)localObject1))
    {
      this.b.put(this.e, localInteger);
      return false;
    }
    this.d = paramString;
    localObject1 = this.k;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
      return true;
    }
    this.l = 0;
    localObject1 = this.i;
    if (localObject1 != null)
    {
      localObject1 = ((ConcurrentHashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(this.h)) && (((String)localObject2).equals(this.h)))
        {
          localObject1 = (String)this.i.get(localObject2);
          n = 1;
          break label297;
        }
      }
    }
    localObject1 = "ask";
    int n = 0;
    label297:
    if (!((String)localObject1).equals("allow"))
    {
      if (((String)localObject1).equals("ask"))
      {
        if ((n == 0) && (!TextUtils.isEmpty(this.f)))
        {
          localObject1 = ark.Application.Create(this.h, this.f);
          if ((localObject1 != null) && (!TextUtils.isEmpty(paramString)))
          {
            bool1 = ((ark.Application)localObject1).CheckUrlLegality(paramString);
            ((ark.Application)localObject1).Release();
            if (bool1)
            {
              this.b.put(this.e, localInteger);
              return false;
            }
          }
        }
        paramString = this.mRuntime.d();
        if (paramString != null)
        {
          if (paramString.isFinishing()) {
            return true;
          }
          a(paramString.getString(2131887056));
          this.k.show();
        }
        return true;
      }
      if (((String)localObject1).equals("forbidden"))
      {
        c();
        bool1 = true;
      }
    }
    this.b.put(this.e, Integer.valueOf(bool1 ^ true));
    return bool1;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 16L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 16L) {
      return c(paramString);
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (Class)paramIntent.getExtras().getSerializable("fragmentClass") == ArkBrowserFragment.class;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.m = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkPlugin
 * JD-Core Version:    0.7.0.1
 */