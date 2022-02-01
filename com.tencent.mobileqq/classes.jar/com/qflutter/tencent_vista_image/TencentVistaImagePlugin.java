package com.qflutter.tencent_vista_image;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.view.TextureRegistry;

public class TencentVistaImagePlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final String CHANNEL_NAME = "tencent_vista_image";
  public static final String TAG = "TencentVistaImagePlugin";
  private static IVistaImage vistaImageImpl;
  private TencentVistaImage pluginProxy;
  private TextureRegistry textureRegistry;
  
  public static void init(IVistaImage paramIVistaImage)
  {
    if (PLog.isColorLevel()) {
      PLog.d("TencentVistaImagePlugin", "[init]");
    }
    vistaImageImpl = paramIVistaImage;
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAttachedToEngine] hashCode=");
      localStringBuilder.append(hashCode());
      PLog.d("TencentVistaImagePlugin", localStringBuilder.toString());
    }
    new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "tencent_vista_image").setMethodCallHandler(this);
    this.pluginProxy = new TencentVistaImage();
    this.pluginProxy.setVistaImageImpl(vistaImageImpl);
    this.textureRegistry = paramFlutterPluginBinding.getTextureRegistry();
    this.pluginProxy.setTextureRegistry(this.textureRegistry);
    float f = paramFlutterPluginBinding.getApplicationContext().getResources().getDisplayMetrics().density;
    this.pluginProxy.setDensity(f);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    if (PLog.isColorLevel())
    {
      paramFlutterPluginBinding = new StringBuilder();
      paramFlutterPluginBinding.append("[onDetachedFromEngine] this=");
      paramFlutterPluginBinding.append(this);
      paramFlutterPluginBinding.append(", hashCode=");
      paramFlutterPluginBinding.append(hashCode());
      PLog.d("TencentVistaImagePlugin", paramFlutterPluginBinding.toString());
    }
    this.textureRegistry = null;
    this.pluginProxy.clear();
    this.pluginProxy = null;
  }
  
  public void onMethodCall(MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    Object localObject;
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onMethodCall] method=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", hashCode=");
      ((StringBuilder)localObject).append(hashCode());
      PLog.d("TencentVistaImagePlugin", ((StringBuilder)localObject).toString());
    }
    if (this.pluginProxy == null) {
      PLog.w("TencentVistaImagePlugin", "[onMethodCall] invalid pluginProxy");
    }
    Integer localInteger1;
    Integer localInteger2;
    int i;
    int j;
    label283:
    label317:
    label327:
    label584:
    do
    {
      StringBuilder localStringBuilder;
      do
      {
        return;
        if ("createTexture".equals(str))
        {
          str = (String)paramMethodCall.argument("uri");
          localObject = (Integer)paramMethodCall.argument("requiredWidth");
          localInteger1 = (Integer)paramMethodCall.argument("requiredHeight");
          localInteger2 = (Integer)paramMethodCall.argument("fitType");
          paramMethodCall = (String)paramMethodCall.argument("widgetKey");
          if (PLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[onMethodCall] createTexture uri=");
            localStringBuilder.append(str);
            localStringBuilder.append(", width=");
            localStringBuilder.append(localObject);
            localStringBuilder.append(", height=");
            localStringBuilder.append(localInteger1);
            localStringBuilder.append(", fitType=");
            localStringBuilder.append(localInteger2);
            localStringBuilder.append(", widgetKey=");
            localStringBuilder.append(paramMethodCall);
            PLog.d("TencentVistaImagePlugin", localStringBuilder.toString());
          }
          if (TextUtils.isEmpty(str))
          {
            paramResult.error("-6", "no uri", null);
            return;
          }
          if (localObject == null)
          {
            i = -1;
            if (localInteger1 != null) {
              break label317;
            }
            j = -1;
            if (localInteger2 != null) {
              break label327;
            }
          }
          for (k = -1;; k = localInteger2.intValue())
          {
            this.pluginProxy.createTexture(paramMethodCall, str, i, j, k, paramResult);
            return;
            i = ((Integer)localObject).intValue();
            break;
            j = localInteger1.intValue();
            break label283;
          }
        }
        if ("releaseTexture".equals(str))
        {
          str = (String)paramMethodCall.argument("uri");
          localObject = (Integer)paramMethodCall.argument("requiredWidth");
          localInteger1 = (Integer)paramMethodCall.argument("requiredHeight");
          localInteger2 = (Integer)paramMethodCall.argument("fitType");
          paramMethodCall = (String)paramMethodCall.argument("widgetKey");
          if (PLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[onMethodCall] releaseTexture uri=");
            localStringBuilder.append(str);
            localStringBuilder.append(", width=");
            localStringBuilder.append(localObject);
            localStringBuilder.append(", height=");
            localStringBuilder.append(localInteger1);
            localStringBuilder.append(", fitType=");
            localStringBuilder.append(localInteger2);
            localStringBuilder.append(", widgetKey=");
            localStringBuilder.append(paramMethodCall);
            PLog.d("TencentVistaImagePlugin", localStringBuilder.toString());
          }
          if (TextUtils.isEmpty(str))
          {
            paramResult.error("-6", "no uri", null);
            return;
          }
          if (localObject == null)
          {
            i = -1;
            if (localInteger1 != null) {
              break label574;
            }
            j = -1;
            if (localInteger2 != null) {
              break label584;
            }
          }
          for (k = -1;; k = localInteger2.intValue())
          {
            this.pluginProxy.releaseTexture(paramMethodCall, str, i, j, k, paramResult);
            return;
            i = ((Integer)localObject).intValue();
            break;
            j = localInteger1.intValue();
            break label540;
          }
        }
      } while (!"updateTexture".equals(str));
      str = (String)paramMethodCall.argument("uri");
      localObject = (Integer)paramMethodCall.argument("requiredWidth");
      localInteger1 = (Integer)paramMethodCall.argument("requiredHeight");
      localInteger2 = (Integer)paramMethodCall.argument("fitType");
      paramMethodCall = (String)paramMethodCall.argument("widgetKey");
      if (PLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onMethodCall] releaseTexture uri=");
        localStringBuilder.append(str);
        localStringBuilder.append(", width=");
        localStringBuilder.append(localObject);
        localStringBuilder.append(", height=");
        localStringBuilder.append(localInteger1);
        localStringBuilder.append(", fitType=");
        localStringBuilder.append(localInteger2);
        localStringBuilder.append(", widgetKey=");
        localStringBuilder.append(paramMethodCall);
        PLog.d("TencentVistaImagePlugin", localStringBuilder.toString());
      }
    } while (TextUtils.isEmpty(str));
    label540:
    label574:
    if (localObject == null)
    {
      i = -1;
      if (localInteger1 != null) {
        break label819;
      }
      j = -1;
      if (localInteger2 != null) {
        break label829;
      }
    }
    label785:
    label819:
    label829:
    for (int k = -1;; k = localInteger2.intValue())
    {
      this.pluginProxy.updateTexture(paramMethodCall, str, i, j, k, paramResult);
      return;
      i = ((Integer)localObject).intValue();
      break;
      j = localInteger1.intValue();
      break label785;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.TencentVistaImagePlugin
 * JD-Core Version:    0.7.0.1
 */