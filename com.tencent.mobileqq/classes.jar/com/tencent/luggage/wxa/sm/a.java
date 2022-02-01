package com.tencent.luggage.wxa.sm;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/CameraPreviewGLTextureRender;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "()V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/wmpf/samelayer/recordview/util/LuggageGLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Landroid/os/Handler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "getRenderer", "()Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "setRenderer", "(Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraFrameDataCallback;", "getPreviewTextureId", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/wmpf/samelayer/recordview/camera/CameraConfig;", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public class a
  implements TextureView.SurfaceTextureListener, com.tencent.luggage.wxa.ib.a
{
  public static final a.a a = new a.a(null);
  private com.tencent.luggage.wxa.sq.a.b b;
  private SurfaceTexture c;
  private Surface d;
  private int e;
  private int f;
  private HandlerThread g;
  private Handler h;
  @Nullable
  private f i;
  private com.tencent.luggage.wxa.ic.a j;
  private boolean k;
  private Function1<? super SurfaceTexture, Unit> l;
  private ArrayList<Function0<Unit>> m = new ArrayList();
  
  public a()
  {
    g();
  }
  
  private final void g()
  {
    HandlerThread localHandlerThread = new HandlerThread("CameraPreviewTextureView_renderThread", -2);
    localHandlerThread.start();
    this.h = new Handler(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.m);
    this.m.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((Function0)((Iterator)localObject).next());
    }
    this.g = localHandlerThread;
  }
  
  private final void h()
  {
    HandlerThread localHandlerThread = this.g;
    if (localHandlerThread != null) {
      localHandlerThread.quit();
    }
    this.g = ((HandlerThread)null);
    this.h = ((Handler)null);
  }
  
  @Nullable
  protected final f a()
  {
    return this.i;
  }
  
  protected final void a(@Nullable f paramf)
  {
    this.i = paramf;
  }
  
  public void a(@NotNull f paramf, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "renderer");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setRenderer:");
    ((StringBuilder)localObject).append(paramf.hashCode());
    ((StringBuilder)localObject).append("  cpuCrop:");
    ((StringBuilder)localObject).append(paramBoolean);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLTextureRender", ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ic.a)localObject).f();
    }
    if (paramBoolean) {
      localObject = (com.tencent.luggage.wxa.ic.a)new com.tencent.luggage.wxa.ic.b((com.tencent.luggage.wxa.ib.a)this);
    } else {
      localObject = (com.tencent.luggage.wxa.ic.a)new com.tencent.luggage.wxa.ic.c((com.tencent.luggage.wxa.ib.b)this);
    }
    this.j = ((com.tencent.luggage.wxa.ic.a)localObject);
    localObject = this.j;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ic.a)localObject).b(paramf);
    }
    this.i = paramf;
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.sn.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "cameraConfig");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCameraConfig: ");
    ((StringBuilder)localObject).append(parama);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLTextureRender", ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ic.a)localObject).a(parama);
    }
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "r");
    Handler localHandler = this.h;
    if (localHandler != null)
    {
      if (localHandler != null) {
        localHandler.post((Runnable)new b(paramFunction0));
      }
      return;
    }
    this.m.add(paramFunction0);
  }
  
  public void a(@Nullable Function1<? super SurfaceTexture, Unit> paramFunction1)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tryCameraPreview canPreview:");
    ((StringBuilder)localObject).append(this.k);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLTextureRender", ((StringBuilder)localObject).toString());
    if (this.k)
    {
      if (paramFunction1 != null)
      {
        localObject = this.j;
        if (localObject != null) {
          localObject = ((com.tencent.luggage.wxa.ic.a)localObject).c();
        } else {
          localObject = null;
        }
        paramFunction1 = (Unit)paramFunction1.invoke(localObject);
      }
      return;
    }
    this.l = paramFunction1;
  }
  
  public void b()
  {
    a((Function0)new a.e(this));
  }
  
  public void b(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    com.tencent.luggage.wxa.ic.a locala = this.j;
    if (locala != null) {
      locala.a(paramFunction1);
    }
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLTextureRender", "tryStopCameraPreview");
    this.l = ((Function1)null);
  }
  
  @Nullable
  public EGLContext d()
  {
    com.tencent.luggage.wxa.sq.a.b localb = this.b;
    if (localb != null) {
      return localb.c;
    }
    return null;
  }
  
  public int e()
  {
    f localf = this.i;
    if (localf != null) {
      return localf.g();
    }
    return -1;
  }
  
  @Nullable
  public c f()
  {
    com.tencent.luggage.wxa.ic.a locala = this.j;
    if (locala != null) {
      return locala.b();
    }
    return null;
  }
  
  public void onSurfaceTextureAvailable(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureAvailable, surfaceTexture:");
    localStringBuilder.append(paramSurfaceTexture);
    localStringBuilder.append(", width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", handler: ");
    localStringBuilder.append(this.h);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLTextureRender", localStringBuilder.toString());
    if (this.h == null) {
      g();
    }
    if (paramSurfaceTexture != null) {
      a((Function0)new a.b(paramSurfaceTexture, this, paramInt1, paramInt2));
    }
  }
  
  public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureDestroyed");
    this.k = false;
    a((Function0)new a.c(this));
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureSizeChanged, surfaceTexture:");
    localStringBuilder.append(paramSurfaceTexture);
    localStringBuilder.append(", width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLTextureRender", localStringBuilder.toString());
    a((Function0)new a.d(this, paramInt1, paramInt2));
  }
  
  public void onSurfaceTextureUpdated(@Nullable SurfaceTexture paramSurfaceTexture) {}
  
  public void requestRender()
  {
    a((Function0)new a.f(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.a
 * JD-Core Version:    0.7.0.1
 */