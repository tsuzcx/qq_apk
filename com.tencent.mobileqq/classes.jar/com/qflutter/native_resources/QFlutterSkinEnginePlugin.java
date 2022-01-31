package com.qflutter.native_resources;

import android.text.TextUtils;
import android.util.Log;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class QFlutterSkinEnginePlugin
  implements MethodChannel.MethodCallHandler
{
  public static final String SKIN_PLUGIN_CHANNEL_NAME = "qflutter_skin_engine_plugin";
  public static final String TAG = "QFlutterSkinEngine";
  private static ArrayList<WeakReference<QFlutterSkinEnginePlugin>> cachePlugins = new ArrayList();
  private static String sCurrentThemeId = null;
  private PluginRegistry.Registrar registrar;
  
  public QFlutterSkinEnginePlugin(PluginRegistry.Registrar paramRegistrar)
  {
    this.registrar = paramRegistrar;
  }
  
  private static void onPostThemeChanged(String paramString)
  {
    for (;;)
    {
      int i;
      synchronized (cachePlugins)
      {
        i = cachePlugins.size() - 1;
        if (i >= 0)
        {
          localObject = (WeakReference)cachePlugins.get(i);
          if (localObject == null) {
            break label139;
          }
          localObject = (QFlutterSkinEnginePlugin)((WeakReference)localObject).get();
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onPostThemeChanged call ");
            localStringBuilder.append(i);
            Log.d("QFlutterSkinEngine", localStringBuilder.toString());
            ((QFlutterSkinEnginePlugin)localObject).notifyOnPostThemeChanged(paramString);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onPostThemeChanged remove ");
            ((StringBuilder)localObject).append(i);
            Log.d("QFlutterSkinEngine", ((StringBuilder)localObject).toString());
            cachePlugins.remove(i);
          }
        }
      }
      return;
      label139:
      Object localObject = null;
      continue;
      i -= 1;
    }
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    ??? = new MethodChannel(paramRegistrar.messenger(), "qflutter_skin_engine_plugin");
    paramRegistrar = new QFlutterSkinEnginePlugin(paramRegistrar);
    ((MethodChannel)???).setMethodCallHandler(paramRegistrar);
    synchronized (cachePlugins)
    {
      cachePlugins.add(new WeakReference(paramRegistrar));
      Log.d("QFlutterSkinEngine", "registerWith");
      return;
    }
  }
  
  public static void setCurrentThemeId(String paramString)
  {
    if (!TextUtils.equals(sCurrentThemeId, paramString))
    {
      sCurrentThemeId = paramString;
      onPostThemeChanged(paramString);
    }
  }
  
  public void notifyOnPostThemeChanged(String paramString)
  {
    if ((this.registrar != null) && (this.registrar.activity() != null))
    {
      Log.d("QFlutterSkinEngine", "_onPostThemeChanged send to flutter");
      new MethodChannel(this.registrar.messenger(), "qflutter_skin_engine_plugin").invokeMethod("onPostThemeChanged", paramString);
    }
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qflutter.native_resources.QFlutterSkinEnginePlugin
 * JD-Core Version:    0.7.0.1
 */