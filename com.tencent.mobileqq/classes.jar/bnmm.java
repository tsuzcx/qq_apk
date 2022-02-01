import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bnmm
  extends bnnn
{
  private BroadcastReceiver a;
  
  public bnmm()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bnmn(this);
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return;
    case 1: 
      e();
      return;
    case 2: 
      b();
      return;
    case 3: 
      c();
      return;
    case 4: 
      d();
      return;
    }
    f();
  }
  
  private void g()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.syncSecretShuoshuoMsg");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QZonePublishSecretShuoShuoH5Plugin", 1, "registerMsgReceiver----", localException);
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, localException, new Object[0]);
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    default: 
      return;
    }
    if (paramInt == -1)
    {
      bmwb.a().a(paramIntent, 0);
      return;
    }
    f();
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    super.a(paramWebViewPlugin);
    g();
  }
  
  public void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("voiceTime", paramLong);
        localObject = ((JSONObject)localObject).toString();
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramString, new String[] { localObject });
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString.getMessage());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("ret", 0);
        localJSONObject.put("voiceData", paramString2);
        localJSONObject.put("voiceFormat", "amr");
        paramString2 = localJSONObject.toString();
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramString1, new String[] { paramString2 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString1.getMessage());
      }
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int k = 0;
    int j = 0;
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    do
    {
      return false;
      if (paramString3.equalsIgnoreCase("updateFeedsAndPopup"))
      {
        paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        if ((paramJsBridgeListener instanceof bnnw)) {
          ((bnnw)paramJsBridgeListener).aJ();
        }
        return true;
      }
      if (paramString3.equalsIgnoreCase("editTitleButtons"))
      {
        paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
        if ((paramJsBridgeListener instanceof bnnw)) {
          ((bnnw)paramJsBridgeListener).aK();
        }
        return true;
      }
      if (paramString3.equalsIgnoreCase("getMoodVoiceRecordTime"))
      {
        paramString1 = "";
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1;
          if (paramString2 != null) {
            paramJsBridgeListener = paramString2.optString("callback");
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
            paramJsBridgeListener = paramString1;
          }
        }
        bmwb.a().a(paramJsBridgeListener, this);
        return true;
      }
      int i;
      if (paramString3.equalsIgnoreCase("playMoodVoice"))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = j;
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            paramString1 = paramString2.optString("callback");
            paramJsBridgeListener = paramString1;
            i = paramString2.optInt("voiceID");
            paramJsBridgeListener = paramString1;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            i = j;
          }
        }
        bmwb.a().a(paramJsBridgeListener, i, this);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getMoodVoiceData"))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = k;
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            paramString1 = paramString2.optString("callback");
            paramJsBridgeListener = paramString1;
            i = paramString2.optInt("voiceID");
            paramJsBridgeListener = paramString1;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            i = k;
          }
        }
        bmwb.a().b(paramJsBridgeListener, i, this);
        return true;
      }
      if (paramString3.equalsIgnoreCase("stopPlayingMoodVoice"))
      {
        bmwb.a().d();
        return true;
      }
    } while (!paramString3.equalsIgnoreCase("didPublishMoodVoice"));
    paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((paramJsBridgeListener instanceof bnmp)) {
      ((bnmp)paramJsBridgeListener).b();
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.secret.onRightButtonClick()");
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("voiceTime", paramLong);
        localObject = ((JSONObject)localObject).toString();
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().callJs(paramString, new String[] { localObject });
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString.getMessage());
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.secret.onEditLeftButtonClick()");
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.secret.onEditRightButtonClick()");
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZMoodVoiceJSInterface.onRecordDone()");
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("try { window.QZMoodVoiceJSInterface.onRecordCancel() } catch (error) {}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmm
 * JD-Core Version:    0.7.0.1
 */