package com.qflutter.qflutter_skin_engine;

import android.util.Log;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.view.FlutterView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class QFlutterSkinEnginePlugin
  implements MethodChannel.MethodCallHandler
{
  public static final String SKIN_PLUGIN_CHANNEL_NAME = "qflutter_skin_engine_plugin";
  public static final String TAG = "SkinEnginePlugin";
  public static ArrayList<WeakReference<QFlutterSkinEnginePlugin>> cachePlugins = new ArrayList();
  private PluginRegistry.Registrar registrar;
  
  public QFlutterSkinEnginePlugin(PluginRegistry.Registrar paramRegistrar)
  {
    this.registrar = paramRegistrar;
  }
  
  public static QFlutterSkinEnginePlugin getSkinEnginePlugin(FlutterView paramFlutterView)
  {
    if (paramFlutterView != null) {}
    for (;;)
    {
      int i;
      synchronized (cachePlugins)
      {
        i = cachePlugins.size() - 1;
        if (i >= 0)
        {
          Object localObject = (WeakReference)cachePlugins.get(i);
          if (localObject == null) {
            break label91;
          }
          localObject = (QFlutterSkinEnginePlugin)((WeakReference)localObject).get();
          if ((localObject == null) || (((QFlutterSkinEnginePlugin)localObject).registrar == null) || (!paramFlutterView.equals(((QFlutterSkinEnginePlugin)localObject).registrar.view()))) {
            break label91;
          }
          paramFlutterView = (FlutterView)localObject;
          return paramFlutterView;
        }
      }
      paramFlutterView = null;
      continue;
      return null;
      label91:
      i -= 1;
    }
  }
  
  public static void onPostThemeChanged(String paramString)
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
            Log.d("SkinEnginePlugin", localStringBuilder.toString());
            ((QFlutterSkinEnginePlugin)localObject).notifyOnPostThemeChanged(paramString);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onPostThemeChanged remove ");
            ((StringBuilder)localObject).append(i);
            Log.d("SkinEnginePlugin", ((StringBuilder)localObject).toString());
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
      Log.d("SkinEnginePlugin", "registerWith");
      return;
    }
  }
  
  public void notifyOnPostThemeChanged(String paramString)
  {
    if ((this.registrar != null) && (this.registrar.activity() != null))
    {
      Log.d("SkinEnginePlugin", "_onPostThemeChanged send to flutter");
      new MethodChannel(this.registrar.messenger(), "qflutter_skin_engine_plugin").invokeMethod("onPostThemeChanged", paramString);
    }
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("loadNativeThemeInfo"))
    {
      QFlutterSkinEngine.get().loadNativeThemeInfo(paramResult);
      return;
    }
    if (paramMethodCall.method.equals("getNativeImageInfo"))
    {
      String str = (String)paramMethodCall.argument("nativeImageID");
      paramMethodCall = (Boolean)paramMethodCall.argument("ignoreTheme");
      QFlutterSkinEngine.get().loadNativeImageInfo(str, paramMethodCall.booleanValue(), paramResult);
      return;
    }
    if (paramMethodCall.method.equals("releaseNativeImageRef"))
    {
      paramMethodCall = (String)paramMethodCall.argument("nativeImageID");
      QFlutterSkinEngine.get().deCache(paramMethodCall);
      return;
    }
    if (paramMethodCall.method.equals("getNativeImageRawByteList"))
    {
      paramMethodCall = (String)paramMethodCall.argument("nativeImageID");
      QFlutterSkinEngine.get().getNativeImageRawByteList(paramMethodCall, paramResult);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qflutter.qflutter_skin_engine.QFlutterSkinEnginePlugin
 * JD-Core Version:    0.7.0.1
 */