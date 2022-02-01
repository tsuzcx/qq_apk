package com.peterlmeng.animate_image;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import com.peterlmeng.animate_image.model.ReplaceImageModel;
import com.peterlmeng.animate_image.renderer.IRenderWorkerFactory;
import com.peterlmeng.animate_image.renderer.OpenGlRenderer2;
import com.peterlmeng.animate_image.renderer.PagRenderWorker;
import com.peterlmeng.animate_image.renderer.RenderWorker;
import com.peterlmeng.animate_image.renderer.RenderWorkerFactory;
import com.peterlmeng.animate_image.support.log.ILog;
import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;
import java.util.Map;

public class AnimateImagePlugin
  implements FlutterPlugin, EventChannel.StreamHandler, MethodChannel.MethodCallHandler
{
  private static final String TAG = "ImgStPlugin";
  private Context context;
  EventChannel.EventSink eventSink;
  final Handler mUIHandler = new Handler(Looper.getMainLooper());
  private BinaryMessenger messenger;
  private PluginRegistry.Registrar registrar;
  private LongSparseArray<OpenGlRenderer2> renders = new LongSparseArray();
  private Map<String, Size> resourceInfoMap = new HashMap();
  private TextureRegistry textures;
  private LongSparseArray<RenderWorker> workers = new LongSparseArray();
  
  public AnimateImagePlugin() {}
  
  public AnimateImagePlugin(PluginRegistry.Registrar paramRegistrar) {}
  
  public static void registerRenderFactory(String paramString, IRenderWorkerFactory paramIRenderWorkerFactory)
  {
    RenderWorkerFactory.registerRenderFactory(paramString, paramIRenderWorkerFactory);
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new AnimateImagePlugin(paramRegistrar);
  }
  
  public static void setLog(ILog paramILog)
  {
    LogUtils.a(paramILog);
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.textures = paramFlutterPluginBinding.getTextureRegistry();
    this.messenger = paramFlutterPluginBinding.getBinaryMessenger();
    this.context = paramFlutterPluginBinding.getApplicationContext();
    LogUtils.b("ImgStPlugin", "onAttachedToEngine()");
    paramFlutterPluginBinding = paramFlutterPluginBinding.getBinaryMessenger();
    new MethodChannel(paramFlutterPluginBinding, "animate_image").setMethodCallHandler(this);
    new EventChannel(paramFlutterPluginBinding, "animate_image_event").setStreamHandler(this);
  }
  
  public void onCancel(Object paramObject) {}
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    LogUtils.b("ImgStPlugin", "onDetachedFromEngine()");
    int j = this.workers.size();
    int i = 0;
    while (i < j)
    {
      long l = this.workers.keyAt(i);
      paramFlutterPluginBinding = (RenderWorker)this.workers.get(l);
      if (paramFlutterPluginBinding != null) {
        paramFlutterPluginBinding.dispose();
      }
      i += 1;
    }
    this.workers.clear();
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    this.eventSink = paramEventSink;
    if (!(paramObject instanceof String)) {}
    for (;;)
    {
      return;
      paramObject = (String)paramObject;
      int i = -1;
      if (paramObject.hashCode() != 942712596) {}
      while (i == 0)
      {
        this.eventSink = paramEventSink;
        return;
        if (paramObject.equals("loadResource")) {
          i = 0;
        }
      }
    }
  }
  
  @RequiresApi(api=26)
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    LogUtils.a("raymond", paramMethodCall.method);
    if (paramMethodCall.method.equals("getPlatformVersion"))
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("Android ");
      paramMethodCall.append(Build.VERSION.RELEASE);
      paramResult.success(paramMethodCall.toString());
      return;
    }
    if (paramMethodCall.method.equals("test"))
    {
      LogUtils.a("raymond", "native flutter test");
      return;
    }
    boolean bool = paramMethodCall.method.equals("initNative");
    int i = 0;
    TextureRegistry.SurfaceTextureEntry localSurfaceTextureEntry;
    int m;
    int n;
    Size localSize;
    String str;
    int j;
    int k;
    label266:
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      paramMethodCall = (Map)paramMethodCall.arguments;
      localSurfaceTextureEntry = this.textures.createSurfaceTexture();
      localSurfaceTextureEntry.surfaceTexture();
      m = ((Double)paramMethodCall.get("width")).intValue();
      n = ((Double)paramMethodCall.get("height")).intValue();
      localSize = new Size(m, n);
      str = (String)paramMethodCall.get("file");
      i = -1;
      if (paramMethodCall.containsKey("loop")) {
        i = ((Integer)paramMethodCall.get("loop")).intValue();
      }
      if (paramMethodCall.containsKey("playStatus"))
      {
        j = ((Integer)paramMethodCall.get("playStatus")).intValue();
        if (!paramMethodCall.containsKey("scaleType")) {
          break label772;
        }
        k = ((Integer)paramMethodCall.get("scaleType")).intValue();
        localObject1 = "";
        if (paramMethodCall.containsKey("package")) {
          localObject1 = (String)paramMethodCall.get("package");
        }
        if (!paramMethodCall.containsKey("replaceImage")) {
          break label829;
        }
        localObject2 = (Map)paramMethodCall.get("replaceImage");
        if (localObject2 == null) {
          break label829;
        }
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          if (((Map)localObject2).get("package") == null) {
            break label1577;
          }
          paramMethodCall = (String)((Map)localObject2).get("package");
          paramMethodCall = new ReplaceImageModel(((Integer)((Map)localObject2).get("index")).intValue(), (String)((Map)localObject2).get("path"), paramMethodCall);
          label772:
          try
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("map ");
            localStringBuilder.append(localObject2);
            localStringBuilder.append(", values:");
            localStringBuilder.append(((Map)localObject2).get("index"));
            localStringBuilder.append(", ");
            localStringBuilder.append(((Map)localObject2).get("path"));
            LogUtils.a("ImgStPlugin", localStringBuilder.toString());
            localObject2 = this.messenger;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("animate_image_event.");
            localStringBuilder.append(localSurfaceTextureEntry.id());
            localObject2 = new EventChannel((BinaryMessenger)localObject2, localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("loadtime widthStr");
            localStringBuilder.append(m);
            localStringBuilder.append(", height:");
            localStringBuilder.append(n);
            localStringBuilder.append(", url:");
            localStringBuilder.append(str);
            localStringBuilder.append(", entry:");
            localStringBuilder.append(localSurfaceTextureEntry.id());
            localStringBuilder.append("auto start:");
            localStringBuilder.append(j);
            localStringBuilder.append(" loop ");
            localStringBuilder.append(i);
            LogUtils.a("ImgStPlugin", localStringBuilder.toString());
            localObject1 = RenderWorkerFactory.createRenderWorker(localSurfaceTextureEntry, this.context, str, i, j, k, localSize, (EventChannel)localObject2, (String)localObject1);
            if (paramMethodCall != null) {
              ((RenderWorker)localObject1).replaceImage(paramMethodCall.index, paramMethodCall.path);
            }
            if (localObject1 == null) {
              break;
            }
            ((RenderWorker)localObject1).setOnResourceLoadListener(new AnimateImagePlugin.1(this, localSurfaceTextureEntry, paramResult));
            if (!(localObject1 instanceof PagRenderWorker)) {
              break label834;
            }
            if (((PagRenderWorker)localObject1).isPagSoReady()) {
              ((RenderWorker)localObject1).startLoadResource();
            }
            this.workers.put(localSurfaceTextureEntry.id(), localObject1);
            return;
          }
          catch (Exception localException1) {}
        }
        j = 0;
      }
      catch (Exception localException2)
      {
        StringBuilder localStringBuilder;
        paramMethodCall = null;
        continue;
      }
      k = 0;
      break label266;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("relace error:");
      localStringBuilder.append(localException1.getMessage());
      LogUtils.b("ImgStPlugin", localStringBuilder.toString());
      continue;
      label829:
      paramMethodCall = null;
      continue;
      label834:
      ((RenderWorker)localObject1).startLoadResource();
      continue;
      if (paramMethodCall.method.equals("replay"))
      {
        l = ((Number)((Map)paramMethodCall.arguments).get("textureId")).longValue();
        paramMethodCall = (RenderWorker)this.workers.get(l);
        if (paramMethodCall == null) {
          break;
        }
        paramMethodCall.replay();
        return;
      }
      if (paramMethodCall.method.equals("dispose"))
      {
        paramMethodCall = (Map)paramMethodCall.arguments;
        l = ((Integer)paramMethodCall.get("textureId")).intValue();
        paramMethodCall = (String)paramMethodCall.get("file");
        paramResult = new StringBuilder();
        paramResult.append("dispose:");
        paramResult.append(l);
        paramResult.append(", url");
        paramResult.append(paramMethodCall);
        LogUtils.a("ImgStPlugin", paramResult.toString());
        if (l == -1L)
        {
          while (i < this.workers.size())
          {
            l = this.workers.keyAt(i);
            paramResult = (RenderWorker)this.workers.get(l);
            if ((paramResult.getUrl().equals(paramMethodCall)) && (!paramResult.isResourceLoaded()))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("delete :");
              ((StringBuilder)localObject1).append(paramMethodCall);
              ((StringBuilder)localObject1).append("byhand");
              LogUtils.a("ImgStPlugin", ((StringBuilder)localObject1).toString());
              paramResult.dispose();
              this.workers.delete(l);
            }
            i += 1;
          }
          break;
        }
        paramMethodCall = (RenderWorker)this.workers.get(l);
        if (paramMethodCall == null) {
          break;
        }
        paramMethodCall.dispose();
        this.workers.delete(l);
        return;
      }
      if (paramMethodCall.method.equals("start"))
      {
        l = ((Number)((Map)paramMethodCall.arguments).get("textureId")).longValue();
        paramMethodCall = (RenderWorker)this.workers.get(l);
        paramResult = new StringBuilder();
        paramResult.append("start:");
        paramResult.append(l);
        LogUtils.a("ImgStPlugin", paramResult.toString());
        if (paramMethodCall == null) {
          break;
        }
        paramMethodCall.doStartPlay();
        return;
      }
      if (paramMethodCall.method.equals("stop"))
      {
        l = ((Number)((Map)paramMethodCall.arguments).get("textureId")).longValue();
        paramMethodCall = new StringBuilder();
        paramMethodCall.append("stop:");
        paramMethodCall.append(l);
        LogUtils.a("ImgStPlugin", paramMethodCall.toString());
        paramMethodCall = (RenderWorker)this.workers.get(l);
        if (paramMethodCall != null)
        {
          paramMethodCall.stop();
          return;
        }
        paramResult.notImplemented();
        return;
      }
      if (paramMethodCall.method.equals("pause"))
      {
        l = ((Number)((Map)paramMethodCall.arguments).get("textureId")).longValue();
        paramMethodCall = new StringBuilder();
        paramMethodCall.append("pause:");
        paramMethodCall.append(l);
        LogUtils.a("ImgStPlugin", paramMethodCall.toString());
        paramMethodCall = (RenderWorker)this.workers.get(l);
        if (paramMethodCall != null)
        {
          paramMethodCall.pause();
          return;
        }
        paramResult.notImplemented();
        return;
      }
      if (!paramMethodCall.method.equals("updateFile")) {
        break;
      }
      paramMethodCall = (Map)paramMethodCall.arguments;
      long l = ((Integer)paramMethodCall.get("textureId")).intValue();
      paramMethodCall = (String)paramMethodCall.get("file");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateFile:");
      ((StringBuilder)localObject1).append(l);
      LogUtils.a("ImgStPlugin", ((StringBuilder)localObject1).toString());
      localObject1 = (RenderWorker)this.workers.get(l);
      if (localObject1 != null)
      {
        ((RenderWorker)localObject1).updateFile(paramMethodCall);
        return;
      }
      paramResult.notImplemented();
      return;
      label1577:
      paramMethodCall = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.AnimateImagePlugin
 * JD-Core Version:    0.7.0.1
 */