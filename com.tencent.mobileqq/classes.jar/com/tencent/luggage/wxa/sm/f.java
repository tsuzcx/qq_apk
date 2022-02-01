package com.tencent.luggage.wxa.sm;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.luggage.wxa.sq.a;
import com.tencent.luggage.wxa.sq.a.a;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "externalTextureObj", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLTextureObject;", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/wmpf/samelayer/recordview/proc/LuggageCameraGLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/wmpf/samelayer/recordview/proc/LuggageCameraGLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/wmpf/samelayer/recordview/proc/LuggageCameraGLTextureRenderProc;)V", "inputTexture", "getInputTexture", "()I", "setInputTexture", "(I)V", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "checkHasInit", "doInitRenderProc", "flip", "getExternalTexture", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public abstract class f
  implements GLSurfaceView.Renderer
{
  public static final f.a i = new f.a(null);
  @Nullable
  private com.tencent.luggage.wxa.sp.c a;
  private byte[] b;
  @JvmField
  public int c;
  @JvmField
  public int d;
  @JvmField
  public int e;
  @JvmField
  public int f;
  @JvmField
  protected int g;
  @JvmField
  public int h;
  @Nullable
  private SurfaceTexture j;
  private com.tencent.luggage.wxa.so.c k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private boolean p;
  @Nullable
  private Function1<? super SurfaceTexture, Unit> q;
  @Nullable
  private Function0<Unit> r;
  private boolean s;
  
  public f()
  {
    this(0, 0, 0, 0, 0, 0, 63, null);
  }
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramInt5;
    this.h = paramInt6;
    this.n = -1;
  }
  
  private final void h()
  {
    this.k = com.tencent.luggage.wxa.so.b.a(false, 12L);
    Object localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(((com.tencent.luggage.wxa.so.c)localObject).c());
    Function1 localFunction1 = this.q;
    localObject = localFunction1;
    if (localFunction1 != null) {
      localObject = new g(localFunction1);
    }
    localSurfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)localObject);
    this.j = localSurfaceTexture;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" createSurfaceTexture:");
    ((StringBuilder)localObject).append(this.k);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", ((StringBuilder)localObject).toString());
  }
  
  private final void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" exec func initGLTextureRender  mirror : ");
    localStringBuilder.append(this.p);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", localStringBuilder.toString());
    b(this.e, this.f);
    a(this.c, this.d);
    c(this.o);
    c(this.p);
  }
  
  @NotNull
  protected abstract com.tencent.luggage.wxa.sp.c a();
  
  public final void a(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" updateTextureSize ,width : ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" , height : ");
    ((StringBuilder)localObject).append(paramInt2);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", ((StringBuilder)localObject).toString());
    this.c = paramInt1;
    this.d = paramInt2;
    localObject = this.a;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sp.c)localObject).c(paramInt1, paramInt2);
    }
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.r = paramFunction0;
  }
  
  public final void a(@Nullable Function1<? super SurfaceTexture, Unit> paramFunction1)
  {
    this.q = paramFunction1;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "frame");
    byte[] arrayOfByte;
    if (paramBoolean)
    {
      if (!com.tencent.luggage.wxa.sq.b.a(this.b))
      {
        arrayOfByte = this.b;
        if ((arrayOfByte != null) && (arrayOfByte.length == paramArrayOfByte.length)) {}
      }
      else
      {
        this.b = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.b, 0, paramArrayOfByte.length);
    }
    else
    {
      this.b = paramArrayOfByte;
    }
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = this.b;
      if (arrayOfByte == null) {
        Intrinsics.throwNpe();
      }
      paramArrayOfByte.a(arrayOfByte);
    }
  }
  
  @Nullable
  protected final SurfaceTexture b()
  {
    return this.j;
  }
  
  public final void b(int paramInt)
  {
    this.n = paramInt;
    com.tencent.luggage.wxa.sp.c localc = this.a;
    if (localc != null) {
      localc.a(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" updateDrawViewSize ,width : ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" , height : ");
    ((StringBuilder)localObject).append(paramInt2);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", ((StringBuilder)localObject).toString());
    this.e = paramInt1;
    this.f = paramInt2;
    localObject = this.a;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sp.c)localObject).b(paramInt1, paramInt2);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.s)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(" initRenderProcInGlesThread, already init");
      com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", ((StringBuilder)localObject).toString());
      return;
    }
    this.m = paramBoolean;
    this.a = a();
    i();
    if ((this.m) && ((this.j == null) || (this.n <= 0)))
    {
      h();
      localObject = this.k;
      int i1;
      if (localObject != null) {
        i1 = ((com.tencent.luggage.wxa.so.c)localObject).c();
      } else {
        i1 = -1;
      }
      b(i1);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" createSurfaceTexture:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", surfaceTexture:");
    ((StringBuilder)localObject).append(this.j);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", ((StringBuilder)localObject).toString());
    this.s = true;
  }
  
  public void c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" change rotate ,old degree : ");
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append(" , new degree : ");
    ((StringBuilder)localObject).append(paramInt);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", ((StringBuilder)localObject).toString());
    this.o = paramInt;
    localObject = this.a;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sp.c)localObject).b(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" set mirror: ");
    ((StringBuilder)localObject).append(paramBoolean);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", ((StringBuilder)localObject).toString());
    this.p = paramBoolean;
    localObject = this.a;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.sp.c)localObject).a(paramBoolean);
    }
  }
  
  public final boolean c()
  {
    return this.l;
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hashCode());
    ((StringBuilder)localObject1).append(" called release, shouldDestroySurfaceTexture: ");
    ((StringBuilder)localObject1).append(paramBoolean);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", ((StringBuilder)localObject1).toString());
    localObject1 = this.a;
    if (localObject1 != null) {
      ((com.tencent.luggage.wxa.sp.c)localObject1).b();
    }
    if (paramBoolean)
    {
      localObject1 = this.j;
      if (localObject1 != null) {
        ((SurfaceTexture)localObject1).release();
      }
    }
    localObject1 = this.k;
    if (localObject1 != null) {
      ((com.tencent.luggage.wxa.so.c)localObject1).close();
    }
    try
    {
      this.j = ((SurfaceTexture)null);
      localObject1 = Unit.INSTANCE;
      this.s = false;
      return;
    }
    finally {}
  }
  
  public final boolean d()
  {
    return this.s;
  }
  
  public void e()
  {
    com.tencent.luggage.wxa.sp.c localc = this.a;
    if (localc != null) {
      localc.i();
    }
  }
  
  @Nullable
  public SurfaceTexture f()
  {
    try
    {
      SurfaceTexture localSurfaceTexture = this.j;
      return localSurfaceTexture;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int g()
  {
    com.tencent.luggage.wxa.so.c localc = this.k;
    if (localc != null) {
      return localc.c();
    }
    return -1;
  }
  
  public void onDrawFrame(@Nullable GL10 paramGL10)
  {
    if (this.l)
    {
      com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", "do clear frame");
      this.l = false;
      return;
    }
    if ((this.b == null) && (this.n == -1))
    {
      paramGL10 = new StringBuilder();
      paramGL10.append(hashCode());
      paramGL10.append(" there is no input ,do you dismiss setting input");
      com.tencent.luggage.wxa.f.f.d("MicroMsg.Media.LuggageCameraSurfaceRenderer", paramGL10.toString());
      return;
    }
    e();
    paramGL10 = this.r;
    if (paramGL10 != null) {
      paramGL10 = (Unit)paramGL10.invoke();
    }
  }
  
  public void onSurfaceChanged(@Nullable GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10 = new StringBuilder();
    paramGL10.append(hashCode());
    paramGL10.append(" onSurfaceChanged width:");
    paramGL10.append(paramInt1);
    paramGL10.append(", height:");
    paramGL10.append(paramInt2);
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", paramGL10.toString());
    b(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(@Nullable GL10 paramGL10, @Nullable EGLConfig paramEGLConfig)
  {
    paramGL10 = new StringBuilder();
    paramGL10.append(hashCode());
    paramGL10.append(" onSurfaceCreated");
    com.tencent.luggage.wxa.f.f.b("MicroMsg.Media.LuggageCameraSurfaceRenderer", paramGL10.toString());
    a.d.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.f
 * JD-Core Version:    0.7.0.1
 */