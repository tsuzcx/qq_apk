package com.tencent.biz.webviewplugin;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ARTransparentWebviewPlugin
  extends WebViewPlugin
{
  private static ARTransparentWebviewPlugin jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin;
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean = false;
  private static boolean b = false;
  protected final byte a;
  protected SensorManager a;
  protected ARTransparentWebviewPlugin.QQSensorEventListener a;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[4];
  
  public ARTransparentWebviewPlugin()
  {
    this.jdField_a_of_type_Byte = 3;
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 2, "init");
    }
    jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin = this;
  }
  
  public static final void b()
  {
    b = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebViewTime startRender. isStartRender = ");
    localStringBuilder.append(b);
    QLog.d("ARTransparentWebviewPlugin", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin.callJs(jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true) });
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 1, "stop motion");
    }
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localSensorManager != null)
    {
      ARTransparentWebviewPlugin.QQSensorEventListener localQQSensorEventListener = this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener;
      if (localQQSensorEventListener != null)
      {
        localSensorManager.unregisterListener(localQQSensorEventListener);
        this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener = null;
      }
    }
    jdField_a_of_type_Boolean = false;
    b = false;
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    paramString = new StringBuilder();
    paramString.append("WebViewTime notifyRenderReady. callbackStartRender = ");
    paramString.append(jdField_a_of_type_JavaLangString);
    QLog.d("ARTransparentWebviewPlugin", 1, paramString.toString());
    paramString = this.mRuntime.a();
    if ((paramString != null) && ((paramString instanceof ScanTorchActivity))) {
      ((ScanTorchActivity)paramString).c();
    }
  }
  
  public final boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 1, "start motion");
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)BaseApplication.getContext().getSystemService("sensor"));
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareSensorManager;
    int i;
    if (SensorTrackManager.a()) {
      i = 15;
    } else {
      i = 11;
    }
    localObject = ((SensorManager)localObject).getSensorList(i);
    Sensor localSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(4);
    if ((((List)localObject).size() > 0) && (localSensor != null))
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener != null) {
        a();
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener = new ARTransparentWebviewPlugin.QQSensorEventListener(this, (byte)3, paramString);
      if (Build.MODEL.equalsIgnoreCase("Nexus 5X")) {
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener, (Sensor)localObject, 3);
      } else {
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener, (Sensor)localObject, 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARTransparentWebviewPlugin", 2, "support gyroscope");
      }
    }
    else
    {
      callJs(paramString, new String[] { "false" });
      if (QLog.isColorLevel()) {
        QLog.d("ARTransparentWebviewPlugin", 2, "not support gyroscope");
      }
    }
    jdField_a_of_type_Boolean = true;
    paramString = new StringBuilder();
    paramString.append("WebViewTime startMotion. isRenderReady = ");
    paramString.append(jdField_a_of_type_Boolean);
    QLog.d("ARTransparentWebviewPlugin", 1, paramString.toString());
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("sensor".equals(paramString2))
    {
      if ("startMotion".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = new StringBuilder();
          paramString1.append("handleJsRequest jsonobject is ");
          paramString1.append(paramJsBridgeListener.toString());
          QLog.d("ARTransparentWebviewPlugin", 2, paramString1.toString());
          return a(paramJsBridgeListener.optString("callback"));
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return false;
        }
      }
      if ("stopMotion".equals(paramString3))
      {
        a();
        return true;
      }
      if ("notifyRenderReady".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = new StringBuilder();
          paramString1.append("handleJsRequest jsonobject is ");
          paramString1.append(paramJsBridgeListener.toString());
          QLog.d("ARTransparentWebviewPlugin", 2, paramString1.toString());
          a(paramJsBridgeListener.optString("callback"));
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return false;
        }
      }
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */