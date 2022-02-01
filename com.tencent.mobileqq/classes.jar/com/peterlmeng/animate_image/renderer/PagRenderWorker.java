package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.peterlmeng.animate_image.AnimateImgInitManager;
import com.peterlmeng.animate_image.QueuingEventSink;
import com.peterlmeng.animate_image.RenderUtils;
import com.peterlmeng.animate_image.Size;
import com.peterlmeng.animate_image.ThreadManager;
import com.peterlmeng.animate_image.model.ReplaceImageModel;
import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.plugin.common.EventChannel;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.libpag.PAGFile;
import org.libpag.PAGPlayer;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;

public class PagRenderWorker
  implements RenderWorker
{
  private static final String TAG = "PagRenderWorker";
  private ValueAnimator animator;
  Size canvasSize;
  long duration;
  TextureRegistry.SurfaceTextureEntry entry;
  EventChannel eventChannel;
  private QueuingEventSink eventSink = new QueuingEventSink();
  boolean firstFrame;
  Handler handler;
  HandlerThread handlerThread;
  boolean isPagSoReady;
  private boolean isPlaying = false;
  int loopCount;
  int loopedCount = 0;
  RenderWorker.OnResourceLoadListener onResourceLoadListener;
  String packagePath;
  int pagFileHeight;
  int pagFileWidth;
  PAGPlayer pagPlayer;
  PAGRenderer pagRenderer;
  PAGSurface pagSurface;
  private int playStatus;
  WeakReference<Context> registrarWeakReference;
  ReplaceImageModel replaceImageModel;
  boolean resourceLoaded;
  int scaleType;
  Runnable sourceRunnable;
  Surface surface;
  SurfaceTexture surfaceTexture;
  String url;
  
  PagRenderWorker(TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, String paramString1, Context paramContext, int paramInt1, int paramInt2, int paramInt3, Size paramSize, EventChannel paramEventChannel, String paramString2)
  {
    this.entry = paramSurfaceTextureEntry;
    this.url = paramString1;
    this.registrarWeakReference = new WeakReference(paramContext);
    this.surfaceTexture = paramSurfaceTextureEntry.surfaceTexture();
    this.playStatus = paramInt1;
    this.loopCount = paramInt2;
    this.canvasSize = paramSize;
    this.scaleType = paramInt3;
    this.eventChannel = paramEventChannel;
    this.packagePath = paramString2;
    setUpPagPlayer();
    paramSurfaceTextureEntry = new StringBuilder();
    paramSurfaceTextureEntry.append("loopCount:");
    paramSurfaceTextureEntry.append(paramInt2);
    LogUtils.c("PagRenderWorker", paramSurfaceTextureEntry.toString());
  }
  
  private void destroyHandlerThread(Object paramObject)
  {
    if ((this.handler != null) && (this.handlerThread.isAlive()))
    {
      this.handler.removeCallbacksAndMessages(null);
      if (Build.VERSION.SDK_INT <= 18) {
        break label52;
      }
      this.handlerThread.quitSafely();
    }
    for (;;)
    {
      this.handlerThread = null;
      this.handler = null;
      return;
      label52:
      this.handlerThread.quit();
    }
  }
  
  private void initPlay(PAGFile paramPAGFile)
  {
    if (paramPAGFile == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pagefile load for ");
      ((StringBuilder)localObject).append(this.url);
      ((StringBuilder)localObject).append(" is null");
      LogUtils.b("PagRenderWorker", ((StringBuilder)localObject).toString());
    }
    this.pagFileWidth = paramPAGFile.width();
    this.pagFileHeight = paramPAGFile.height();
    Object localObject = RenderUtils.getScaledImgSize(new Size(this.pagFileWidth, this.pagFileHeight), this.canvasSize);
    this.surfaceTexture.setDefaultBufferSize(((Size)localObject).width, ((Size)localObject).height);
    if (this.scaleType == 0) {
      this.pagPlayer.setScaleMode(1);
    }
    for (;;)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadtime file path success:width::");
      ((StringBuilder)localObject).append(paramPAGFile.width());
      ((StringBuilder)localObject).append(", height:");
      ((StringBuilder)localObject).append(paramPAGFile.height());
      LogUtils.c("PagRenderWorker", ((StringBuilder)localObject).toString());
      this.surface = new Surface(this.surfaceTexture);
      this.pagSurface = PAGSurface.FromSurface(this.surface);
      this.pagPlayer.setSurface(this.pagSurface);
      this.pagPlayer.setComposition(paramPAGFile);
      this.duration = this.pagPlayer.duration();
      ThreadManager.getsInstance().execute(3, new PagRenderWorker.8(this));
      doStartPlay();
      return;
      if (this.scaleType == 1) {
        this.pagPlayer.setScaleMode(3);
      } else if (this.scaleType == 2) {
        this.pagPlayer.setScaleMode(2);
      }
    }
  }
  
  private void notifyErrorEvent(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "single_completed");
    localHashMap.put("data", Integer.valueOf(paramInt));
    if (this.eventSink != null) {
      this.eventSink.success(localHashMap);
    }
  }
  
  private void notifySingleEndEvent()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "single_completed");
    if (this.eventSink != null) {
      this.eventSink.success(localHashMap);
    }
  }
  
  private void setUpHandler()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pagThread");
    localStringBuilder.append(this.entry.id());
    this.handlerThread = new HandlerThread(localStringBuilder.toString());
    this.handlerThread.start();
    this.handler = new Handler(this.handlerThread.getLooper(), new PagRenderWorker.PAGRenderHandler());
  }
  
  private void startHandlerThread()
  {
    setUpHandler();
  }
  
  public void dispose()
  {
    stop();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parender dispose");
    localStringBuilder.append(this.url);
    LogUtils.c("PagRenderWorker", localStringBuilder.toString());
    ThreadManager.getsInstance().execute(3, new PagRenderWorker.3(this));
    this.eventChannel = null;
    this.eventSink = null;
  }
  
  public void doStartPlay()
  {
    this.loopedCount = 0;
    ThreadManager.getsInstance().execute(3, new PagRenderWorker.1(this));
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isPagSoReady()
  {
    return this.isPagSoReady;
  }
  
  public boolean isResourceLoaded()
  {
    return this.firstFrame;
  }
  
  public void pause()
  {
    this.isPlaying = false;
    ThreadManager.getsInstance().execute(3, new PagRenderWorker.10(this));
  }
  
  public void replaceImage(int paramInt, String paramString)
  {
    this.replaceImageModel = new ReplaceImageModel(paramInt, paramString);
  }
  
  public void replay()
  {
    ThreadManager.getsInstance().execute(3, new PagRenderWorker.2(this));
  }
  
  public void setOnResourceLoadListener(RenderWorker.OnResourceLoadListener paramOnResourceLoadListener)
  {
    this.onResourceLoadListener = paramOnResourceLoadListener;
  }
  
  public void setRepeatCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 0;
    }
    if (this.animator != null) {
      this.animator.setRepeatCount(i - 1);
    }
  }
  
  public void setUpPagPlayer()
  {
    if (this.eventChannel != null) {
      this.eventChannel.setStreamHandler(new PagRenderWorker.6(this));
    }
    if (!AnimateImgInitManager.getsInstance().isSoLoad)
    {
      if (!AnimateImgInitManager.getsInstance().soFileExist())
      {
        notifyErrorEvent(1);
        LogUtils.e("PagRenderWorker", "setUpPagPlayer so not found");
        return;
      }
      boolean bool = AnimateImgInitManager.getsInstance().reloadSo();
      LogUtils.e("PagRenderWorker", "so exist but not load");
      if (!bool)
      {
        LogUtils.b("PagRenderWorker", "so exist and load error");
        notifyErrorEvent(2);
        return;
      }
    }
    for (this.isPagSoReady = true;; this.isPagSoReady = true)
    {
      this.pagPlayer = new PAGPlayer();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUpPagPlayer before");
      localStringBuilder.append(this.url);
      LogUtils.c("PagRenderWorker", localStringBuilder.toString());
      startHandlerThread();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUpPagPlayer after");
      localStringBuilder.append(this.url);
      LogUtils.c("PagRenderWorker", localStringBuilder.toString());
      ThreadManager.getsInstance().execute(3, new PagRenderWorker.7(this));
      return;
      LogUtils.c("PagRenderWorker", "setUpPagPlayer so found");
    }
  }
  
  public void startLoadResource()
  {
    this.sourceRunnable = new PagRenderWorker.4(this);
    ThreadManager.getsInstance().execute(1, this.sourceRunnable);
  }
  
  public void stop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop");
    localStringBuilder.append(this.url);
    LogUtils.c("PagRenderWorker", localStringBuilder.toString());
    ThreadManager.getsInstance().execute(3, new PagRenderWorker.9(this));
  }
  
  public void updateFile(String paramString)
  {
    this.url = paramString;
    ThreadManager.getsInstance().execute(3, new PagRenderWorker.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker
 * JD-Core Version:    0.7.0.1
 */