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
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString = null;
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = null;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private String jdField_c_of_type_JavaLangString = null;
  private ConcurrentHashMap<String, String> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private String jdField_d_of_type_JavaLangString = null;
  private ConcurrentHashMap<String, String> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private String e = null;
  
  public ArkPlugin()
  {
    this.mPluginNameSpace = "lightapp";
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ArkPlugin", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
      return;
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
            this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject3, (String)localObject4);
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
            this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, (String)localObject3);
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
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  protected String a(String paramString)
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
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
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
    Object localObject = (WebViewFragment)this.mRuntime.a();
    if (localObject != null)
    {
      localObject = ((WebViewFragment)localObject).getArguments();
      if (localObject != null)
      {
        localObject = ((Intent)((Bundle)localObject).getParcelable("intent")).getExtras();
        if (localObject != null)
        {
          this.e = ((Bundle)localObject).getString("h5_ark_app_name");
          this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("h5_ark_app_path");
          this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("h5_ark_app_des");
          b(((Bundle)localObject).getString("h5_ark_check_config"));
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(QBaseActivity.sTopActivity, 2131756189);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558978);
      localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365648);
      TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365633);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365639);
      ((TextView)localObject).setText(2131719632);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView1.setText(paramString);
      }
      localTextView3.setText(2131720390);
      localTextView3.setOnClickListener(new ArkPlugin.1(this));
      localTextView2.setOnClickListener(new ArkPlugin.2(this));
      localTextView2.setText(2131690728);
      return;
    }
    localObject = (TextView)((Dialog)localObject).findViewById(2131365644);
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(paramString);
    }
  }
  
  protected boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    Integer localInteger = Integer.valueOf(1);
    if (bool1) {
      return true;
    }
    Object localObject1 = a(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return true;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject1);
    boolean bool2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_b_of_type_JavaLangString);
    bool1 = false;
    if (bool2)
    {
      localObject1 = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_b_of_type_JavaLangString);
      if (localObject1 != null)
      {
        if (((Integer)localObject1).intValue() == 1) {
          return false;
        }
        if (((Integer)localObject1).intValue() == 0)
        {
          b();
          return true;
        }
      }
    }
    a();
    localObject1 = null;
    Object localObject2 = this.mRuntime.a();
    if (localObject2 != null) {
      localObject1 = ((WebViewProvider)localObject2).getUrlFromIntent();
    }
    localObject1 = a((String)localObject1);
    if (a(this.jdField_b_of_type_JavaLangString, (String)localObject1))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_b_of_type_JavaLangString, localInteger);
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    localObject1 = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
      return true;
    }
    this.jdField_a_of_type_Int = 0;
    localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject1 != null)
    {
      localObject1 = ((ConcurrentHashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(this.e)) && (((String)localObject2).equals(this.e)))
        {
          localObject1 = (String)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
          i = 1;
          break label297;
        }
      }
    }
    localObject1 = "ask";
    int i = 0;
    label297:
    if (!((String)localObject1).equals("allow"))
    {
      if (((String)localObject1).equals("ask"))
      {
        if ((i == 0) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
        {
          localObject1 = ark.Application.Create(this.e, this.jdField_c_of_type_JavaLangString);
          if ((localObject1 != null) && (!TextUtils.isEmpty(paramString)))
          {
            bool1 = ((ark.Application)localObject1).CheckUrlLegality(paramString);
            ((ark.Application)localObject1).Release();
            if (bool1)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_b_of_type_JavaLangString, localInteger);
              return false;
            }
          }
        }
        paramString = this.mRuntime.a();
        if (paramString != null)
        {
          if (paramString.isFinishing()) {
            return true;
          }
          a(paramString.getString(2131690157));
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        return true;
      }
      if (((String)localObject1).equals("forbidden"))
      {
        b();
        bool1 = true;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_b_of_type_JavaLangString, Integer.valueOf(bool1 ^ true));
    return bool1;
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
        int i = paramString1.lastIndexOf(paramString2);
        bool1 = bool2;
        if (i >= 0)
        {
          bool1 = bool2;
          if (i == paramString1.length() - paramString2.length()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected void b()
  {
    if (this.mRuntime == null) {
      return;
    }
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      QQToast.a(localActivity, HardCodeUtil.a(2131700939), 0).a();
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 16L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 16L) {
      return a(paramString);
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
    this.jdField_a_of_type_AndroidContentContext = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkPlugin
 * JD-Core Version:    0.7.0.1
 */