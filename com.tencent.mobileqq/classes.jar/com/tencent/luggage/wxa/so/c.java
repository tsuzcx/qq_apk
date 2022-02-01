package com.tencent.luggage.wxa.so;

import android.opengl.GLES20;
import android.os.Process;
import com.tencent.luggage.wxa.f.f;
import com.tencent.luggage.wxa.sq.a;
import com.tencent.luggage.wxa.sq.a.a;
import java.io.Closeable;
import java.nio.Buffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLTextureObject;", "Ljava/io/Closeable;", "sampler2D", "", "scene", "", "(ZJ)V", "height", "", "internalFormat", "memRelease", "texID", "tid", "width", "allocTexMem", "", "pixels", "Ljava/nio/Buffer;", "minMagFilter", "wrapST", "allocTexMemFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "allocatedTid", "bind", "bindFrameBuffer", "frameBuffer", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLFrameBufferObject;", "checkFrameBufferStatus", "close", "finalize", "initInGLThread", "isClosed", "isExternalTexture", "isSample2DTexture", "texFormatByteSize", "texMemorySize", "toString", "", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class c
  implements Closeable
{
  public static final c.a a = new c.a(null);
  private volatile boolean b = true;
  private int c = -1;
  private boolean d;
  private long e;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = 6408;
  
  public c(boolean paramBoolean, long paramLong)
  {
    this.e = paramLong;
    if (this.e < 0L) {
      this.e = 0L;
    }
    a(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" create texID:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("  sampler2D:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" tid:");
    localStringBuilder.append(this.f);
    f.b("WMPF.LuggageGLTextureObject", localStringBuilder.toString());
  }
  
  private final void a(boolean paramBoolean)
  {
    this.b = false;
    this.f = Process.myTid();
    this.d = paramBoolean;
    if (paramBoolean)
    {
      this.c = a.d.a();
      return;
    }
    this.c = a.d.b();
  }
  
  private final int d()
  {
    int k = this.i;
    int j = 32;
    switch (k)
    {
    case 6407: 
    default: 
      j = 24;
    }
    return j;
  }
  
  public final int a()
  {
    if (b()) {
      return this.g * this.h * d();
    }
    return this.g * this.h * 3 / 2;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, @Nullable Buffer paramBuffer, int paramInt4, int paramInt5)
  {
    if ((paramInt1 != this.g) || (paramInt2 != this.h) || (paramInt3 != this.i))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" allocTexMem, width:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", height:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", internalFormat:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", memorySize:");
      localStringBuilder.append(a());
      f.b("WMPF.LuggageGLTextureObject", localStringBuilder.toString());
    }
    GLES20.glBindTexture(3553, c());
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramBuffer);
    float f1 = paramInt4;
    GLES20.glTexParameterf(3553, 10241, f1);
    GLES20.glTexParameterf(3553, 10240, f1);
    f1 = paramInt5;
    GLES20.glTexParameterf(3553, 10242, f1);
    GLES20.glTexParameterf(3553, 10243, f1);
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
  }
  
  public final boolean b()
  {
    return this.d;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public void close()
  {
    if (this.b)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" close already close");
      f.b("WMPF.LuggageGLTextureObject", localStringBuilder.toString());
      return;
    }
    int j = Process.myTid();
    if (this.f != j)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" Leaked by different thread!!!  scene：");
      localStringBuilder.append(this.e);
      localStringBuilder.append("  created in:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" release in:");
      localStringBuilder.append(j);
      f.d("WMPF.LuggageGLTextureObject", localStringBuilder.toString());
      this.b = false;
      return;
    }
    this.b = true;
    a.d.a(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" close texID:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("  sampler2D:");
    localStringBuilder.append(this.d);
    f.b("WMPF.LuggageGLTextureObject", localStringBuilder.toString());
  }
  
  protected final void finalize()
  {
    if (!this.b)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" Leaked !!!  scene：");
      localStringBuilder.append(this.e);
      f.d("WMPF.LuggageGLTextureObject", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" release success!");
    f.b("WMPF.LuggageGLTextureObject", localStringBuilder.toString());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hashcode:");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" texID:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" sampler2D:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" memRelease:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" scene:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" create-tid:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.so.c
 * JD-Core Version:    0.7.0.1
 */