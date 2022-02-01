package com.tencent.av.wtogether.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.av.wtogether.api.IFileChooser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;

public class WTBusinessForWebPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  public static final String a = "WTBusinessForWebPlugin";
  public static final Stack<Activity> a;
  private static final Stack<Activity> b = new Stack();
  private final BroadcastReceiver a;
  
  static
  {
    jdField_a_of_type_JavaUtilStack = new Stack();
  }
  
  public WTBusinessForWebPlugin()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new WTBusinessForWebPlugin.1(this);
    this.mPluginNameSpace = "c2c_together_business";
  }
  
  private void a()
  {
    Object localObject = this.mRuntime.a().getIntent();
    int i = ((Intent)localObject).getIntExtra("key_from_type", 0);
    int j = ((Intent)localObject).getIntExtra("watch_together_uinType", -1);
    localObject = ((Intent)localObject).getStringExtra("watch_together_uin");
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleLaunchQFileChooser, fromType[");
      localStringBuilder.append(i);
      localStringBuilder.append("], uinType[");
      localStringBuilder.append(j);
      localStringBuilder.append("], uin[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    ((IFileChooser)QRoute.api(IFileChooser.class)).startAVRecentFileSelectFragment(this.mRuntime.a(), i, j, (String)localObject, SwiftWebViewUtils.a(110, WebViewUtil.a(this)));
  }
  
  private void a(String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean a()
  {
    return CallStatusClient.a().a();
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (paramString.contains("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2")) && (paramString.contains("fromid="));
  }
  
  private boolean b(String paramString)
  {
    return (paramString != null) && (paramString.contains("https://film.qq.com/h5/qq-together/detail.html")) && (paramString.contains("aioId"));
  }
  
  private boolean c(String paramString)
  {
    return (paramString != null) && (paramString.contains("https://ti.qq.com/sportslive/")) && (paramString.contains("fromid="));
  }
  
  private boolean d(String paramString)
  {
    return (paramString != null) && (paramString.contains("https://film.qq.com/h5/qq-together/")) && (paramString.contains("aioId"));
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder("Call WTBusinessForWebPlugin handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(" pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(" method=");
      paramJsBridgeListener.append(paramString3);
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramJsBridgeListener.toString());
    }
    if (this.mPluginNameSpace.equalsIgnoreCase(paramString2))
    {
      if ("push_to_local_file_controller".equalsIgnoreCase(paramString3))
      {
        a();
        return true;
      }
      if ("select_file_info".equalsIgnoreCase(paramString3)) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("resourceId");
          paramString1 = paramString2.optString("isPay");
          int i = paramString2.optInt("from");
          if (!TextUtils.isEmpty(paramJsBridgeListener)) {
            if (i == 2) {
              a(paramJsBridgeListener, paramString1, i);
            } else {
              a(paramJsBridgeListener, paramString1);
            }
          }
          if (!QLog.isColorLevel()) {
            break label516;
          }
          paramString2 = jdField_a_of_type_JavaLangString;
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("handleJsRequest ");
          paramVarArgs.append(paramString3);
          paramVarArgs.append(", resourceId[");
          paramVarArgs.append(paramJsBridgeListener);
          paramVarArgs.append("], isPay[");
          paramVarArgs.append(paramString1);
          paramVarArgs.append("]");
          QLog.d(paramString2, 2, paramVarArgs.toString());
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          paramString1 = jdField_a_of_type_JavaLangString;
          paramString2 = new StringBuilder();
          paramString2.append("handleJsRequest ");
          paramString2.append(paramString3);
          paramString2.append(" exception[");
          paramString2.append(paramJsBridgeListener.getMessage());
          paramString2.append("]");
          QLog.d(paramString1, 1, paramString2.toString());
          return true;
        }
      } else if ("fetch_qav_status".equalsIgnoreCase(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          boolean bool = a();
          paramString1 = new StringBuilder();
          paramString1.append("{\"isInCall\":");
          paramString1.append(bool);
          paramString1.append("}");
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = jdField_a_of_type_JavaLangString;
            paramString1 = new StringBuilder();
            paramString1.append("handleJsRequest ");
            paramString1.append(paramString3);
            paramString1.append(", isInCall[");
            paramString1.append(bool);
            paramString1.append("]");
            QLog.d(paramJsBridgeListener, 2, paramString1.toString());
            return true;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          paramString1 = jdField_a_of_type_JavaLangString;
          paramString2 = new StringBuilder();
          paramString2.append("handleJsRequest ");
          paramString2.append(paramString3);
          paramString2.append(" exception[");
          paramString2.append(paramJsBridgeListener.getMessage());
          paramString2.append("]");
          QLog.d(paramString1, 1, paramString2.toString());
        }
      }
      label516:
      return true;
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (c(paramString1)) || (d(paramString1));
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramInt == -1) && (paramByte == 110) && (paramIntent != null))
    {
      this.mRuntime.a().setResult(4660, paramIntent);
      this.mRuntime.a().finish();
    }
  }
  
  protected void onCreate()
  {
    String str = this.mRuntime.a().getIntent().getStringExtra("url");
    if ((a(str)) || (b(str)))
    {
      CallStatusClient.a().a(this.mRuntime.a());
      CallStatusClient.a().b();
      if (a(str)) {
        this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.av.v2q.StopVideoChat"));
      }
    }
    b.push(this.mRuntime.a());
  }
  
  protected void onDestroy()
  {
    String str = this.mRuntime.a().getIntent().getStringExtra("url");
    if ((a(str)) || (b(str)))
    {
      CallStatusClient.a().c();
      CallStatusClient.a().a();
      if (a(str)) {
        this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
    }
    b.pop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTBusinessForWebPlugin
 * JD-Core Version:    0.7.0.1
 */