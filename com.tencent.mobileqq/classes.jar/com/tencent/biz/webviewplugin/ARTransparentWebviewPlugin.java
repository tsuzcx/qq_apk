package com.tencent.biz.webviewplugin;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.armap.ShopScanActivity;
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
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
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
    QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime startRender. isStartRender = " + b);
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin.callJs(jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true) });
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 1, "stop motion");
    }
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener);
      this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener = null;
    }
    jdField_a_of_type_Boolean = false;
    b = false;
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime notifyRenderReady. callbackStartRender = " + jdField_a_of_type_JavaLangString);
    paramString = this.mRuntime.a();
    if (paramString != null)
    {
      if (!(paramString instanceof ScanTorchActivity)) {
        break label64;
      }
      ((ScanTorchActivity)paramString).j();
      AREngine.b().p();
    }
    label64:
    while (!(paramString instanceof ShopScanActivity)) {
      return;
    }
    ((ShopScanActivity)paramString).b();
    AREngine.b().p();
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
    if (SensorTrackManager.a())
    {
      i = 15;
      localObject = ((SensorManager)localObject).getSensorList(i);
      Sensor localSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(4);
      if ((((List)localObject).size() <= 0) || (localSensor == null)) {
        break label211;
      }
      localObject = (Sensor)((List)localObject).get(0);
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener != null) {
        a();
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener = new ARTransparentWebviewPlugin.QQSensorEventListener(this, (byte)3, paramString);
      if (!Build.MODEL.equalsIgnoreCase("Nexus 5X")) {
        break label194;
      }
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener, (Sensor)localObject, 3);
      label141:
      if (QLog.isColorLevel()) {
        QLog.d("ARTransparentWebviewPlugin", 2, "support gyroscope");
      }
    }
    for (;;)
    {
      jdField_a_of_type_Boolean = true;
      QLog.d("ARTransparentWebviewPlugin", 1, "WebViewTime startMotion. isRenderReady = " + jdField_a_of_type_Boolean);
      return true;
      i = 11;
      break;
      label194:
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin$QQSensorEventListener, (Sensor)localObject, 1);
      break label141;
      label211:
      callJs(paramString, new String[] { "false" });
      if (QLog.isColorLevel()) {
        QLog.d("ARTransparentWebviewPlugin", 2, "not support gyroscope");
      }
    }
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
          QLog.d("ARTransparentWebviewPlugin", 2, "handleJsRequest jsonobject is " + paramJsBridgeListener.toString());
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
          QLog.d("ARTransparentWebviewPlugin", 2, "handleJsRequest jsonobject is " + paramJsBridgeListener.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */