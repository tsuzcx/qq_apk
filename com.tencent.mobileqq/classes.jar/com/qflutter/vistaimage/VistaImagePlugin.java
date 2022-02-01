package com.qflutter.vistaimage;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.qflutter.superchannel.IModule;
import com.qflutter.superchannel.SuperChannelRegister;
import com.qflutter.superchannel.SuperChannelResult;
import com.qflutter.superchannel.SuperChannelTask;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.view.TextureRegistry;
import java.util.concurrent.atomic.AtomicInteger;

public class VistaImagePlugin
  implements IModule, FlutterPlugin
{
  public static final String CHANNEL_NAME = "com.tencent.vista_image";
  public static final String TAG = "VistaImagePlugin";
  static AtomicInteger pluginCount = new AtomicInteger(0);
  private TextureRegistry textureRegistry;
  private VistaImageProcessor vistaImageProcessor;
  
  public SuperChannelResult handleTask(SuperChannelTask paramSuperChannelTask)
  {
    paramSuperChannelTask = VistaImageTask.transformTask(paramSuperChannelTask);
    VistaImageProcessor localVistaImageProcessor = this.vistaImageProcessor;
    if ((localVistaImageProcessor != null) && (paramSuperChannelTask != null))
    {
      localVistaImageProcessor.processTask(paramSuperChannelTask);
      return null;
    }
    VistaImageLog.w("VistaImagePlugin", "[handleTask] invalid vistaImageTask");
    paramSuperChannelTask = new SuperChannelResult();
    paramSuperChannelTask.fail("-9999", "cannot transform SuperChannelTask");
    return paramSuperChannelTask;
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    if (VistaImageLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAttachedToEngine] hashCode=");
      localStringBuilder.append(hashCode());
      VistaImageLog.d("VistaImagePlugin", localStringBuilder.toString());
    }
    this.vistaImageProcessor = new VistaImageProcessor();
    this.textureRegistry = paramFlutterPluginBinding.getTextureRegistry();
    this.vistaImageProcessor.setTextureRegistry(this.textureRegistry);
    float f = paramFlutterPluginBinding.getApplicationContext().getResources().getDisplayMetrics().density;
    this.vistaImageProcessor.setDensity(f);
    SuperChannelRegister.registerModule("com.tencent.vista_image", this);
    int i = pluginCount.incrementAndGet();
    if (VistaImageLog.isColorLevel())
    {
      paramFlutterPluginBinding = new StringBuilder();
      paramFlutterPluginBinding.append("[onAttachedToEngine] pluginCount=");
      paramFlutterPluginBinding.append(i);
      VistaImageLog.d("VistaImagePlugin", paramFlutterPluginBinding.toString());
    }
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    if (VistaImageLog.isColorLevel())
    {
      paramFlutterPluginBinding = new StringBuilder();
      paramFlutterPluginBinding.append("[onDetachedFromEngine] hashCode=");
      paramFlutterPluginBinding.append(hashCode());
      VistaImageLog.d("VistaImagePlugin", paramFlutterPluginBinding.toString());
    }
    SuperChannelRegister.unregisterModule("com.tencent.vista_image");
    this.textureRegistry = null;
    this.vistaImageProcessor.clear();
    this.vistaImageProcessor = null;
    int i = pluginCount.decrementAndGet();
    if (VistaImageLog.isColorLevel())
    {
      paramFlutterPluginBinding = new StringBuilder();
      paramFlutterPluginBinding.append("[onDetachedFromEngine] pluginCount=");
      paramFlutterPluginBinding.append(i);
      VistaImageLog.d("VistaImagePlugin", paramFlutterPluginBinding.toString());
    }
    if (i == 0) {
      SchemeService.getInstance().clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImagePlugin
 * JD-Core Version:    0.7.0.1
 */