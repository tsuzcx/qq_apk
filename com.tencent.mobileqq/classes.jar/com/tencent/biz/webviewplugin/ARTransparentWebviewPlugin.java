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
  private static String e = "";
  private static ARTransparentWebviewPlugin f;
  private static boolean g = false;
  private static boolean h = false;
  protected final byte a = 3;
  protected SensorManager b;
  protected ARTransparentWebviewPlugin.QQSensorEventListener c;
  private float[] d = new float[4];
  
  public ARTransparentWebviewPlugin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 2, "init");
    }
    f = this;
  }
  
  public static final void b()
  {
    h = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebViewTime startRender. isStartRender = ");
    localStringBuilder.append(h);
    QLog.d("ARTransparentWebviewPlugin", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(e)) {
      f.callJs(e, new String[] { String.valueOf(true) });
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 1, "stop motion");
    }
    SensorManager localSensorManager = this.b;
    if (localSensorManager != null)
    {
      ARTransparentWebviewPlugin.QQSensorEventListener localQQSensorEventListener = this.c;
      if (localQQSensorEventListener != null)
      {
        localSensorManager.unregisterListener(localQQSensorEventListener);
        this.c = null;
      }
    }
    g = false;
    h = false;
  }
  
  public final boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransparentWebviewPlugin", 1, "start motion");
    }
    if (this.b == null) {
      this.b = ((SensorManager)BaseApplication.getContext().getSystemService("sensor"));
    }
    Object localObject = this.b;
    int i;
    if (SensorTrackManager.a()) {
      i = 15;
    } else {
      i = 11;
    }
    localObject = ((SensorManager)localObject).getSensorList(i);
    Sensor localSensor = this.b.getDefaultSensor(4);
    if ((((List)localObject).size() > 0) && (localSensor != null))
    {
      localObject = (Sensor)((List)localObject).get(0);
      if (this.c != null) {
        a();
      }
      this.c = new ARTransparentWebviewPlugin.QQSensorEventListener(this, (byte)3, paramString);
      if (Build.MODEL.equalsIgnoreCase("Nexus 5X")) {
        this.b.registerListener(this.c, (Sensor)localObject, 3);
      } else {
        this.b.registerListener(this.c, (Sensor)localObject, 1);
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
    g = true;
    paramString = new StringBuilder();
    paramString.append("WebViewTime startMotion. isRenderReady = ");
    paramString.append(g);
    QLog.d("ARTransparentWebviewPlugin", 1, paramString.toString());
    return true;
  }
  
  public void b(String paramString)
  {
    e = paramString;
    paramString = new StringBuilder();
    paramString.append("WebViewTime notifyRenderReady. callbackStartRender = ");
    paramString.append(e);
    QLog.d("ARTransparentWebviewPlugin", 1, paramString.toString());
    paramString = this.mRuntime.d();
    if ((paramString != null) && ((paramString instanceof ScanTorchActivity))) {
      ((ScanTorchActivity)paramString).notifyRenderReady();
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
          b(paramJsBridgeListener.optString("callback"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */