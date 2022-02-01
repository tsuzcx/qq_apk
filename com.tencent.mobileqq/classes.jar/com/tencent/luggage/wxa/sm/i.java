package com.tencent.luggage.wxa.sm;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/LuggageXwebCameraPreviewRenderView;", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraPreviewGLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "mContext", "Landroid/content/Context;", "texture", "Landroid/graphics/SurfaceTexture;", "mWidth", "", "mHeight", "(Landroid/content/Context;Landroid/graphics/SurfaceTexture;II)V", "TAG", "", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMHeight", "()I", "setMHeight", "(I)V", "getMWidth", "setMWidth", "getTexture", "()Landroid/graphics/SurfaceTexture;", "setTexture", "(Landroid/graphics/SurfaceTexture;)V", "view", "Lcom/tencent/wmpf/samelayer/recordview/CameraPreviewGLTextureRender;", "clearFrame", "", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraFrameDataCallback;", "getPreviewTextureId", "queueEvent", "r", "Lkotlin/Function0;", "release", "requestRender", "setOnDrawListener", "frameAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "renderer", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "cpuCrop", "", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/wmpf/samelayer/recordview/camera/CameraConfig;", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class i
  extends d
  implements com.tencent.luggage.wxa.ib.a
{
  private a b;
  private String c;
  @NotNull
  private Context d;
  @NotNull
  private SurfaceTexture e;
  private int f;
  private int g;
  
  public i(@NotNull Context paramContext, @NotNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super(paramContext, null);
    this.d = paramContext;
    this.e = paramSurfaceTexture;
    this.f = paramInt1;
    this.g = paramInt2;
    this.c = "MicroMsg.CameraPreviewSurfaceRenderView";
    this.b = new a();
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.f.f.b(this.c, "tryStopCameraPreview");
    a locala = this.b;
    if (locala != null) {
      locala.c();
    }
  }
  
  public void a(@NotNull f paramf, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "renderer");
    a locala = this.b;
    if (locala != null) {
      locala.a(paramf, paramBoolean);
    }
    paramf = this.b;
    if (paramf != null) {
      paramf.onSurfaceTextureAvailable(this.e, this.f, this.g);
    }
    paramf = this.b;
    if (paramf != null) {
      paramf.onSurfaceTextureSizeChanged(this.e, this.f, this.g);
    }
    paramf = this.b;
    if (paramf != null) {
      paramf.onSurfaceTextureUpdated(this.e);
    }
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.sn.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "cameraConfig");
    Object localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCameraConfig:");
    localStringBuilder.append(parama);
    com.tencent.luggage.wxa.f.f.b((String)localObject, localStringBuilder.toString());
    localObject = this.b;
    if (localObject != null) {
      ((a)localObject).a(parama);
    }
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "r");
    a locala = this.b;
    if (locala != null) {
      locala.a(paramFunction0);
    }
  }
  
  public void a(@Nullable Function1<? super SurfaceTexture, Unit> paramFunction1)
  {
    a locala = this.b;
    if (locala != null) {
      locala.a(paramFunction1);
    }
  }
  
  public void b()
  {
    a locala = this.b;
    if (locala != null) {
      locala.onSurfaceTextureDestroyed(this.e);
    }
    locala = this.b;
    if (locala != null) {
      locala.b();
    }
    this.b = ((a)null);
  }
  
  @Nullable
  public EGLContext getEGLContext()
  {
    a locala = this.b;
    if (locala != null) {
      return locala.d();
    }
    return null;
  }
  
  @Nullable
  public c getFrameDataCallback()
  {
    a locala = this.b;
    if (locala != null) {
      return locala.f();
    }
    return null;
  }
  
  @NotNull
  public final Context getMContext()
  {
    return this.d;
  }
  
  public final int getMHeight()
  {
    return this.g;
  }
  
  public final int getMWidth()
  {
    return this.f;
  }
  
  public int getPreviewTextureId()
  {
    a locala = this.b;
    if (locala != null) {
      return locala.e();
    }
    return -1;
  }
  
  @NotNull
  public final SurfaceTexture getTexture()
  {
    return this.e;
  }
  
  public void requestRender()
  {
    a locala = this.b;
    if (locala != null) {
      locala.requestRender();
    }
  }
  
  public final void setMContext(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<set-?>");
    this.d = paramContext;
  }
  
  public final void setMHeight(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void setMWidth(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setOnDrawListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    com.tencent.luggage.wxa.f.f.b(this.c, "setOnDrawListener");
    a locala = this.b;
    if (locala != null) {
      locala.b(paramFunction1);
    }
  }
  
  public final void setTexture(@NotNull SurfaceTexture paramSurfaceTexture)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "<set-?>");
    this.e = paramSurfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.i
 * JD-Core Version:    0.7.0.1
 */