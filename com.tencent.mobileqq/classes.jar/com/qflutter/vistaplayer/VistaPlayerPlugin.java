package com.qflutter.vistaplayer;

import androidx.annotation.NonNull;
import com.qflutter.superchannel.IModule;
import com.qflutter.superchannel.SuperChannelRegister;
import com.qflutter.superchannel.SuperChannelResult;
import com.qflutter.superchannel.SuperChannelTask;
import com.qflutter.superchannel.misc.RegisterService;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;

public class VistaPlayerPlugin
  implements IModule, FlutterPlugin
{
  static final String CHANNEL_NAME = "com.qflutter.vista_player";
  public static final String TAG = "VistaPlayerPlugin";
  private VistaPlayerProcessor processor;
  
  public static void register(Class<? extends IVistaPlayer> paramClass)
  {
    RegisterService.register("com.qflutter.vista_player", paramClass);
  }
  
  public SuperChannelResult handleTask(SuperChannelTask paramSuperChannelTask)
  {
    if (VistaPlayerLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleTask] cmd=");
      ((StringBuilder)localObject).append(paramSuperChannelTask.getCommand());
      VistaPlayerLog.d("VistaPlayerPlugin", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.processor;
    if (localObject == null)
    {
      VistaPlayerLog.w("VistaPlayerPlugin", "invalid processor");
      return null;
    }
    return ((VistaPlayerProcessor)localObject).dispatch(paramSuperChannelTask);
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onAttachedToEngine] ");
    ((StringBuilder)localObject).append(hashCode());
    VistaPlayerLog.i("VistaPlayerPlugin", ((StringBuilder)localObject).toString());
    localObject = (IVistaPlayer)RegisterService.createAlways("com.qflutter.vista_player");
    if (localObject == null)
    {
      VistaPlayerLog.w("VistaPlayerPlugin", "no IVistaPlayer impl created");
      return;
    }
    this.processor = new VistaPlayerProcessor(paramFlutterPluginBinding.getTextureRegistry(), (IVistaPlayer)localObject);
    SuperChannelRegister.registerModule("com.qflutter.vista_player", this);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    paramFlutterPluginBinding = new StringBuilder();
    paramFlutterPluginBinding.append("[onDetachedFromEngine] ");
    paramFlutterPluginBinding.append(hashCode());
    VistaPlayerLog.i("VistaPlayerPlugin", paramFlutterPluginBinding.toString());
    paramFlutterPluginBinding = this.processor;
    if (paramFlutterPluginBinding != null)
    {
      paramFlutterPluginBinding.clear();
      this.processor = null;
    }
    SuperChannelRegister.unregisterModule("com.qflutter.vista_player");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaplayer.VistaPlayerPlugin
 * JD-Core Version:    0.7.0.1
 */