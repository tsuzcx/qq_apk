package com.tencent.luggage.wxa.ic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.sm.c;
import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "drawHeight", "", "drawWidth", "eglContext", "Landroid/opengl/EGLContext;", "frameDrawCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "renderOutputBuffer", "Ljava/nio/IntBuffer;", "renderer", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "getRenderer", "()Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "setRenderer", "(Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;)V", "takePicture", "", "takePictureCallback", "Landroid/graphics/Bitmap;", "bitmap", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "setView", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getFrameDataCallback", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureId", "initRender", "createSurfaceTexture", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setOnDrawListener", "frameAvailableListener", "setRender", "callback", "updateCameraConfig", "cameraConfig", "Lcom/tencent/wmpf/samelayer/recordview/camera/CameraConfig;", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public abstract class a
{
  public static final a.a a = new a.a(null);
  @Nullable
  private com.tencent.luggage.wxa.sm.f b;
  private EGLContext c;
  private Function1<? super Integer, Unit> d;
  private IntBuffer e;
  private boolean f;
  private Function1<? super Bitmap, Unit> g;
  private int h;
  private int i;
  @NotNull
  private com.tencent.luggage.wxa.ib.b j;
  
  public a(@NotNull com.tencent.luggage.wxa.ib.b paramb)
  {
    this.j = paramb;
  }
  
  @Nullable
  protected final com.tencent.luggage.wxa.sm.f a()
  {
    return this.b;
  }
  
  protected final void a(@Nullable com.tencent.luggage.wxa.sm.f paramf)
  {
    this.b = paramf;
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.sn.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "cameraConfig");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCameraConfig: ");
    ((StringBuilder)localObject).append(parama);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.CameraPreviewGLSurfaceView", ((StringBuilder)localObject).toString());
    localObject = parama.c();
    com.tencent.luggage.wxa.sm.f localf = this.b;
    if (localf != null) {
      localf.a(((Point)localObject).x, ((Point)localObject).y);
    }
    localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sm.f)localObject).c(com.tencent.luggage.wxa.g.b.a(parama.a()));
    }
    localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sm.f)localObject).c(parama.b());
    }
  }
  
  public final void a(@Nullable GL10 paramGL10)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sm.f)localObject).onDrawFrame(paramGL10);
    }
    if (this.f)
    {
      this.f = false;
      this.e = IntBuffer.allocate(this.i * this.h);
      paramGL10 = this.e;
      if (paramGL10 == null) {
        Intrinsics.throwNpe();
      }
      paramGL10.position(0);
      GLES20.glReadPixels(0, 0, this.h, this.i, 6408, 5121, (Buffer)this.e);
      paramGL10 = Bitmap.createBitmap(this.h, this.i, Bitmap.Config.ARGB_8888);
      paramGL10.copyPixelsFromBuffer((Buffer)this.e);
      localObject = new Matrix();
      ((Matrix)localObject).preScale(-1.0F, 1.0F);
      ((Matrix)localObject).preRotate(180.0F);
      localObject = Bitmap.createBitmap(paramGL10, 0, 0, this.h, this.i, (Matrix)localObject, false);
      paramGL10.recycle();
      paramGL10 = this.g;
      if (paramGL10 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "bmp");
        paramGL10 = (Unit)paramGL10.invoke(localObject);
      }
    }
  }
  
  public final void a(@Nullable GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    com.tencent.luggage.wxa.sm.f localf = this.b;
    if (localf != null) {
      localf.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public final void a(@Nullable GL10 paramGL10, @Nullable EGLConfig paramEGLConfig)
  {
    com.tencent.luggage.wxa.sm.f localf = this.b;
    if (localf != null) {
      localf.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
  }
  
  public void a(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.d = paramFunction1;
  }
  
  public final void a(boolean paramBoolean, int paramInt, @Nullable Function0<Unit> paramFunction0)
  {
    this.j.a((Function0)new a.b(this, paramFunction0, paramBoolean, paramInt));
  }
  
  public void a(@Nullable byte[] paramArrayOfByte) {}
  
  @Nullable
  public c b()
  {
    return null;
  }
  
  @CallSuper
  public void b(@NotNull com.tencent.luggage.wxa.sm.f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "renderer");
    this.b = paramf;
    com.tencent.luggage.wxa.sm.f localf = this.b;
    if (localf != null) {
      localf.a((Function0)new a.d(this, paramf));
    }
  }
  
  @Nullable
  public final SurfaceTexture c()
  {
    com.tencent.luggage.wxa.sm.f localf = this.b;
    if (localf != null) {
      return localf.f();
    }
    return null;
  }
  
  public final int d()
  {
    com.tencent.luggage.wxa.sm.f localf = this.b;
    if (localf != null) {
      return localf.g();
    }
    return -1;
  }
  
  @Nullable
  public final EGLContext e()
  {
    return this.c;
  }
  
  public final void f()
  {
    this.j.a((Function0)new a.c(this));
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.ib.b g()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ic.a
 * JD-Core Version:    0.7.0.1
 */