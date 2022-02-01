package com.tencent.luggage.wxa.sp;

import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.luggage.wxa.f.f;
import com.tencent.luggage.wxa.sq.a.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/proc/LuggageCameraGLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "glFrameBufferObject", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLFrameBufferObject;", "getGlFrameBufferObject", "()Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLFrameBufferObject;", "setGlFrameBufferObject", "(Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLFrameBufferObject;)V", "glTextureObject", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLTextureObject;", "getGlTextureObject", "()Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLTextureObject;", "setGlTextureObject", "(Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLTextureObject;)V", "mirror", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "buffer", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "snapShotBuffer", "getSnapShotBuffer", "setSnapShotBuffer", "snapShotHeight", "getSnapShotHeight", "setSnapShotHeight", "snapShotWidth", "getSnapShotWidth", "setSnapShotWidth", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "validLeftTopPoint", "Landroid/graphics/Point;", "validRightBottomPoint", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputByteBuffer", "getOutputTexture", "getRotate", "getSnapshotOutputByteBuffer", "initMatrix", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "width", "height", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateTextureSize", "updateTextureValidPoint", "leftTop", "rightBottom", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public abstract class c
{
  public static final c.a b = new c.a(null);
  @NotNull
  private FloatBuffer a;
  @NotNull
  private FloatBuffer c;
  @Nullable
  private com.tencent.luggage.wxa.so.c d;
  @Nullable
  private com.tencent.luggage.wxa.so.a e;
  @Nullable
  private ByteBuffer f;
  @NotNull
  private float[] g;
  private int h;
  private boolean i;
  private boolean j;
  private Rect k;
  @Nullable
  private Function1<? super com.tencent.luggage.wxa.so.c, Unit> l;
  @Nullable
  private Function1<? super IntBuffer, Unit> m;
  private boolean n;
  private boolean o;
  private int p;
  private int q;
  @Nullable
  private ByteBuffer r;
  private Point s;
  private Point t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private final int z;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.u = paramInt1;
    this.v = paramInt2;
    this.w = paramInt3;
    this.x = paramInt4;
    this.y = paramInt5;
    this.z = paramInt6;
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.luggage.wxa.sq.a.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Intrinsics.checkExpressionValueIsNotNull(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.a = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.luggage.wxa.sq.a.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Intrinsics.checkExpressionValueIsNotNull(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.c = localFloatBuffer;
    this.g = new float[16];
    this.p = -1;
    this.q = -1;
    this.s = new Point(0, this.v);
    this.t = new Point(this.u, 0);
    paramInt1 = this.y;
    if (paramInt1 == 2)
    {
      this.d = com.tencent.luggage.wxa.so.b.a(true, 3L);
      this.e = com.tencent.luggage.wxa.so.b.a.a(3L);
      return;
    }
    if (paramInt1 == 3) {
      f();
    }
  }
  
  private final void o()
  {
    Matrix.setIdentityM(this.g, 0);
    Matrix.setRotateM(this.g, 0, this.h, 0.0F, 0.0F, -1.0F);
    int i1;
    if ((!this.i) && (this.y != 3))
    {
      Matrix.scaleM(this.g, 0, 1.0F, 1.0F, 1.0F);
    }
    else
    {
      i1 = this.h;
      if ((i1 != 90) && (i1 != 270)) {
        Matrix.scaleM(this.g, 0, 1.0F, -1.0F, 1.0F);
      } else {
        Matrix.scaleM(this.g, 0, -1.0F, 1.0F, 1.0F);
      }
    }
    if (this.j)
    {
      i1 = this.h;
      if ((i1 != 90) && (i1 != 270))
      {
        Matrix.scaleM(this.g, 0, -1.0F, 1.0F, 1.0F);
        return;
      }
      Matrix.scaleM(this.g, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  private final void p()
  {
    if (this.n)
    {
      if (this.d == null)
      {
        this.d = com.tencent.luggage.wxa.so.b.a(true, 3L);
        this.e = com.tencent.luggage.wxa.so.b.a.a(3L);
      }
      com.tencent.luggage.wxa.sq.a.d.a(this.e, this.d, this.p, this.q);
      GLES20.glViewport(0, 0, this.p, this.q);
      int i1 = this.h;
      if ((i1 != 90) && (i1 != 270)) {
        Matrix.scaleM(this.g, 0, 1.0F, -1.0F, 1.0F);
      } else {
        Matrix.scaleM(this.g, 0, -1.0F, 1.0F, 1.0F);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rotateDegree ");
      localStringBuilder.append(this.h);
      localStringBuilder.append("  transformMatrix:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" snapShotWidth:");
      localStringBuilder.append(this.p);
      localStringBuilder.append(" snapShotHeight:");
      localStringBuilder.append(this.q);
      f.b("MicroMsg.GLTextureRenderProc", localStringBuilder.toString());
      this.o = true;
    }
  }
  
  protected abstract void a();
  
  public void a(int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSnapshotSize:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" x ");
    localStringBuilder.append(paramInt2);
    f.b("MicroMsg.GLTextureRenderProc", localStringBuilder.toString());
    this.p = paramInt1;
    this.q = paramInt2;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "frame");
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(" release renderOutputTexture:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", renderOutputTextureFbo:");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(", drawWidth:");
    ((StringBuilder)localObject).append(this.w);
    ((StringBuilder)localObject).append(", drawHeight:");
    ((StringBuilder)localObject).append(this.x);
    f.b("MicroMsg.GLTextureRenderProc", ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.so.c)localObject).close();
    }
    localObject = this.e;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.so.a)localObject).close();
    }
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.x = paramInt2;
    this.w = paramInt1;
    a(paramInt1, paramInt2);
    if (this.y == 3) {
      f();
    }
  }
  
  @NotNull
  protected final FloatBuffer c()
  {
    return this.a;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.u = paramInt1;
    this.v = paramInt2;
    if ((this.s.x == 0) && (this.s.y == 0))
    {
      Point localPoint = this.s;
      localPoint.x = 0;
      localPoint.y = paramInt2;
      localPoint = this.t;
      localPoint.x = paramInt1;
      localPoint.y = 0;
    }
  }
  
  @NotNull
  protected final FloatBuffer d()
  {
    return this.c;
  }
  
  @NotNull
  public final float[] e()
  {
    return this.g;
  }
  
  protected final void f()
  {
    int i1 = this.w;
    if (i1 > 0)
    {
      int i2 = this.x;
      if ((i2 > 0) && (this.f == null)) {
        this.f = ByteBuffer.allocateDirect(i1 * i2 * 4).order(ByteOrder.nativeOrder());
      }
    }
  }
  
  protected final void g()
  {
    int i1 = this.p;
    if (i1 > 0)
    {
      int i2 = this.q;
      if ((i2 > 0) && (this.r == null)) {
        this.r = ByteBuffer.allocateDirect(i1 * i2 * 4).order(ByteOrder.nativeOrder());
      }
    }
  }
  
  protected void h()
  {
    o();
    float f4 = this.s.x / this.u;
    float f2 = this.s.y;
    float f1 = 1;
    float f3 = (f2 + f1) / this.v;
    float f6 = (this.t.x + f1) / this.u;
    float f5 = this.t.y / this.v;
    int i1 = this.z;
    if (i1 == 1)
    {
      this.a.position(0);
      this.a.put(new float[] { f4, f3, f6, f3, f4, f5, f6, f5 });
      this.a.position(0);
    }
    else
    {
      Object localObject1;
      int i2;
      int i3;
      if (i1 == 2)
      {
        localObject1 = Arrays.copyOf(com.tencent.luggage.wxa.sq.a.b, com.tencent.luggage.wxa.sq.a.b.length);
        i1 = this.h;
        if ((i1 != 90) && (i1 != 270)) {
          i2 = 0;
        } else {
          i2 = 1;
        }
        int i4 = this.t.x - this.s.x;
        i1 = this.s.y - this.t.y;
        if (i2 != 0) {
          i3 = i1;
        } else {
          i3 = i4;
        }
        if (i2 == 0) {
          i4 = i1;
        }
        i1 = this.w;
        f2 = i1;
        f1 = i3;
        f2 /= f1;
        int i5 = this.x;
        float f8 = i5;
        float f7 = i4;
        f8 /= f7;
        if (f2 < f8)
        {
          i1 = i3 - (int)(i1 / f8);
        }
        else
        {
          if (f2 > f8)
          {
            i5 = i4 - (int)(i5 / f2);
            i1 = 0;
            break label367;
          }
          i1 = 0;
        }
        i5 = 0;
        label367:
        this.p = (i3 - i1);
        this.q = (i4 - i5);
        if (i2 != 0)
        {
          f2 = i5 / 2.0F / f7;
          f1 = i1 / 2.0F / f1;
        }
        else
        {
          f2 = i1 / 2.0F / f1;
          f1 = i5 / 2.0F / f7;
        }
        f4 += f2;
        f2 = f6 - f2;
        f5 += f1;
        f1 = f3 - f1;
        localObject1[0] = f4;
        localObject1[1] = f1;
        localObject1[2] = f2;
        localObject1[3] = f1;
        localObject1[4] = f4;
        localObject1[5] = f5;
        localObject1[6] = f2;
        localObject1[7] = f5;
        this.a.put(com.tencent.luggage.wxa.sq.a.b);
        this.a.position(0);
        this.a.put((float[])localObject1);
        this.a.position(0);
        this.c.position(0);
      }
      else if ((i1 == 3) && (this.k != null))
      {
        float[] arrayOfFloat = Arrays.copyOf(com.tencent.luggage.wxa.sq.a.b, com.tencent.luggage.wxa.sq.a.b.length);
        localObject1 = this.k;
        Object localObject2 = null;
        if (localObject1 != null) {
          localObject1 = Integer.valueOf(((Rect)localObject1).width());
        } else {
          localObject1 = null;
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        i2 = ((Integer)localObject1).intValue();
        Rect localRect = this.k;
        localObject1 = localObject2;
        if (localRect != null) {
          localObject1 = Integer.valueOf(localRect.height());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        i1 = ((Integer)localObject1).intValue();
        localObject1 = this.k;
        if ((localObject1 != null) && (((Rect)localObject1).left == 0))
        {
          i3 = this.u;
          f1 = (i3 - i2) / i3;
          f2 = 1.0F - f1;
        }
        else
        {
          i3 = this.u;
          f2 = (i3 - i2) / i3;
          f1 = 1.0F - f2;
        }
        localObject1 = this.k;
        if ((localObject1 != null) && (((Rect)localObject1).top == 0))
        {
          i2 = this.v;
          f3 = (i2 - i1) / i2;
          f4 = 1.0F - f3;
        }
        else
        {
          i2 = this.v;
          f4 = (i2 - i1) / i2;
          f3 = f4;
          f5 = 1.0F - f4;
          f4 = f3;
          f3 = f5;
        }
        arrayOfFloat[0] = f1;
        arrayOfFloat[1] = f3;
        arrayOfFloat[2] = f2;
        arrayOfFloat[3] = f3;
        arrayOfFloat[4] = f1;
        arrayOfFloat[5] = f4;
        arrayOfFloat[6] = f2;
        arrayOfFloat[7] = f4;
        this.a.put(com.tencent.luggage.wxa.sq.a.b);
        this.a.position(0);
        this.a.put(arrayOfFloat);
        this.a.position(0);
        this.c.position(0);
      }
    }
    this.c.position(0);
    this.c.put(com.tencent.luggage.wxa.sq.a.a);
    this.c.position(0);
    if (this.y == 2)
    {
      if (this.d == null)
      {
        this.d = com.tencent.luggage.wxa.so.b.a(true, 3L);
        this.e = com.tencent.luggage.wxa.so.b.a.a(3L);
      }
      com.tencent.luggage.wxa.sq.a.d.a(this.e, this.d, this.w, this.x);
    }
    GLES20.glViewport(0, 0, this.w, this.x);
    p();
  }
  
  public final void i()
  {
    h();
    a();
    j();
  }
  
  protected void j()
  {
    boolean bool = this.n;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if ((bool) && (this.o))
    {
      long l1 = com.tencent.luggage.wxa.sq.b.a();
      this.o = false;
      if (this.r == null) {
        g();
      }
      if (this.r == null)
      {
        this.n = false;
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(hashCode());
      ((StringBuilder)localObject2).append(" after render takeSnapshot, renderOutputTextureFbo:");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(", renderOutputTexture:");
      ((StringBuilder)localObject2).append(this.d);
      f.b("MicroMsg.GLTextureRenderProc", ((StringBuilder)localObject2).toString());
      localObject2 = this.e;
      if (localObject2 != null) {
        ((com.tencent.luggage.wxa.so.a)localObject2).a();
      }
      localObject2 = this.r;
      if (localObject2 != null) {
        ((ByteBuffer)localObject2).position(0);
      }
      GLES20.glReadPixels(0, 0, this.p, this.q, 6408, 5121, (Buffer)this.r);
      GLES20.glFinish();
      localObject2 = this.m;
      if (localObject2 != null)
      {
        localObject3 = this.r;
        if (localObject3 != null) {
          localObject1 = ((ByteBuffer)localObject3).asIntBuffer();
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = (Unit)((Function1)localObject2).invoke(localObject1);
      }
      com.tencent.luggage.wxa.sq.a.d.d();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(hashCode());
      ((StringBuilder)localObject1).append(" takeSnapShot cost ");
      ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.sq.b.a(l1));
      ((StringBuilder)localObject1).append(", size:");
      ((StringBuilder)localObject1).append(this.p);
      ((StringBuilder)localObject1).append('x');
      ((StringBuilder)localObject1).append(this.q);
      ((StringBuilder)localObject1).append("  rotate: ");
      ((StringBuilder)localObject1).append(this.h);
      f.b("MicroMsg.GLTextureRenderProc", ((StringBuilder)localObject1).toString());
      this.n = false;
      return;
    }
    int i1 = this.y;
    if (i1 == 3)
    {
      if (this.f == null) {
        f();
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        ((ByteBuffer)localObject1).clear();
      }
      GLES20.glReadPixels(0, 0, this.w, this.x, 6408, 5121, (Buffer)this.f);
      GLES20.glFinish();
      localObject3 = this.m;
      if (localObject3 != null)
      {
        ByteBuffer localByteBuffer = this.f;
        localObject1 = localObject2;
        if (localByteBuffer != null) {
          localObject1 = localByteBuffer.asIntBuffer();
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = (Unit)((Function1)localObject3).invoke(localObject1);
      }
    }
    else if (i1 == 2)
    {
      GLES20.glBindFramebuffer(36160, 0);
      localObject1 = this.l;
      if (localObject1 != null) {
        localObject1 = (Unit)((Function1)localObject1).invoke(this.d);
      }
    }
    GLES20.glUseProgram(0);
    if (this.y != 1) {
      com.tencent.luggage.wxa.sq.a.d.d();
    }
  }
  
  protected final int k()
  {
    return this.u;
  }
  
  protected final int l()
  {
    return this.v;
  }
  
  protected final int m()
  {
    return this.w;
  }
  
  protected final int n()
  {
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sp.c
 * JD-Core Version:    0.7.0.1
 */