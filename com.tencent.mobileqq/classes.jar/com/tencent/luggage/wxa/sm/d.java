package com.tencent.luggage.wxa.sm;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraPreviewGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canPreview", "", "frameRotate", "", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraFrameDataCallback;", "getPreviewTextureId", "queueEvent", "r", "Lkotlin/Function0;", "release", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "cpuCrop", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "w", "h", "surfaceCreated", "surfaceDestroyed", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/wmpf/samelayer/recordview/camera/CameraConfig;", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public class d
  extends GLSurfaceView
  implements com.tencent.luggage.wxa.ib.a
{
  public static final d.a a = new d.a(null);
  private Function1<? super SurfaceTexture, Unit> b;
  private com.tencent.luggage.wxa.ic.a c;
  private int d;
  private boolean e;
  
  public d(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getHolder().addCallback((SurfaceHolder.Callback)this);
    try
    {
      getHolder().setType(2);
    }
    catch (Exception paramContext)
    {
      try
      {
        getHolder().setType(1);
      }
      catch (Exception paramContext)
      {
        try
        {
          for (;;)
          {
            getHolder().setType(0);
            label55:
            setEGLContextFactory((GLSurfaceView.EGLContextFactory)new com.tencent.luggage.wxa.ia.b());
            setEGLContextClientVersion(com.tencent.luggage.wxa.f.e.a().d());
            setEGLConfigChooser((GLSurfaceView.EGLConfigChooser)new com.tencent.luggage.wxa.ia.a(5, 6, 5, 0, 0, 0));
            setPreserveEGLContextOnPause(false);
            setRenderer((GLSurfaceView.Renderer)new d.1(this));
            setRenderMode(0);
            com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", "init create LuggageCameraPreviewGLSurfaceView");
            return;
            paramContext = paramContext;
            continue;
            paramContext = paramContext;
          }
        }
        catch (Exception paramContext)
        {
          break label55;
        }
      }
    }
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", "tryStopCameraPreview");
    this.b = ((Function1)null);
  }
  
  public void a(@NotNull f paramf, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "renderer");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setPreviewRenderer cpuCrop:");
    ((StringBuilder)localObject).append(paramBoolean);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ic.a)localObject).f();
    }
    if (paramBoolean) {
      localObject = (com.tencent.luggage.wxa.ic.a)new com.tencent.luggage.wxa.ic.b((com.tencent.luggage.wxa.ib.a)this);
    } else {
      localObject = (com.tencent.luggage.wxa.ic.a)new com.tencent.luggage.wxa.ic.c((com.tencent.luggage.wxa.ib.b)this);
    }
    this.c = ((com.tencent.luggage.wxa.ic.a)localObject);
    localObject = this.c;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ic.a)localObject).b(paramf);
    }
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.sn.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "cameraConfig");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCameraConfig:");
    ((StringBuilder)localObject).append(parama);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ic.a)localObject).a(parama);
    }
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "r");
    queueEvent((Runnable)new e(paramFunction0));
  }
  
  public void a(@Nullable Function1<? super SurfaceTexture, Unit> paramFunction1)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tryCameraPreview  canPreview:");
    ((StringBuilder)localObject1).append(this.e);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", ((StringBuilder)localObject1).toString());
    if (this.e)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("callback.invoke  ");
      localObject1 = this.c;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((com.tencent.luggage.wxa.ic.a)localObject1).c();
      } else {
        localObject1 = null;
      }
      ((StringBuilder)localObject3).append(localObject1);
      com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", ((StringBuilder)localObject3).toString());
      if (paramFunction1 != null)
      {
        localObject3 = this.c;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.luggage.wxa.ic.a)localObject3).c();
        }
        paramFunction1 = (Unit)paramFunction1.invoke(localObject1);
      }
      return;
    }
    this.b = paramFunction1;
  }
  
  public void b()
  {
    getHolder().removeCallback((SurfaceHolder.Callback)this);
    com.tencent.luggage.wxa.ic.a locala = this.c;
    if (locala != null) {
      locala.f();
    }
    this.e = false;
  }
  
  @Nullable
  public EGLContext getEGLContext()
  {
    com.tencent.luggage.wxa.ic.a locala = this.c;
    if (locala != null) {
      return locala.e();
    }
    return null;
  }
  
  @Nullable
  public c getFrameDataCallback()
  {
    com.tencent.luggage.wxa.ic.a locala = this.c;
    if (locala != null) {
      return locala.b();
    }
    return null;
  }
  
  public int getPreviewTextureId()
  {
    com.tencent.luggage.wxa.ic.a locala = this.c;
    if (locala != null) {
      return locala.d();
    }
    return -1;
  }
  
  public void setOnDrawListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", "setOnDrawListener");
    com.tencent.luggage.wxa.ic.a locala = this.c;
    if (locala != null) {
      locala.a(paramFunction1);
    }
  }
  
  public void surfaceChanged(@Nullable SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceChanged:");
    Surface localSurface;
    if (paramSurfaceHolder != null) {
      localSurface = paramSurfaceHolder.getSurface();
    } else {
      localSurface = null;
    }
    localStringBuilder.append(localSurface);
    localStringBuilder.append(", format:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", w:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", h:");
    localStringBuilder.append(paramInt3);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", localStringBuilder.toString());
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(@Nullable SurfaceHolder paramSurfaceHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceCreated: ");
    Surface localSurface;
    if (paramSurfaceHolder != null) {
      localSurface = paramSurfaceHolder.getSurface();
    } else {
      localSurface = null;
    }
    localStringBuilder.append(localSurface);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", localStringBuilder.toString());
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(@Nullable SurfaceHolder paramSurfaceHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceDestroyed: ");
    Surface localSurface;
    if (paramSurfaceHolder != null) {
      localSurface = paramSurfaceHolder.getSurface();
    } else {
      localSurface = null;
    }
    localStringBuilder.append(localSurface);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.LuggageCameraPreviewGLSurfaceView", localStringBuilder.toString());
    a((Function0)new d.b(this));
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.d
 * JD-Core Version:    0.7.0.1
 */