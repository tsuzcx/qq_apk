package com.tencent.luggage.wxa.so;

import android.opengl.GLES20;
import android.os.Process;
import com.tencent.luggage.wxa.f.f;
import java.io.Closeable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class a
  implements Closeable
{
  public static final a.a a = new a.a(null);
  private volatile boolean b = true;
  private int c = -1;
  private long d;
  private int e = -1;
  
  public a(long paramLong)
  {
    this.d = paramLong;
    this.e = Process.myTid();
    this.c = com.tencent.luggage.wxa.sq.a.d.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create frameBuffer:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" tid:");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    f.b("WMPF.LuggageGLFrameBufferObject", localStringBuilder.toString());
  }
  
  public final void a()
  {
    GLES20.glBindFramebuffer(36160, b());
  }
  
  public final int b()
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
      f.b("WMPF.LuggageGLFrameBufferObject", localStringBuilder.toString());
      return;
    }
    int i = Process.myTid();
    if (this.e != i)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" Leaked by different thread!!!  scene：");
      localStringBuilder.append(this.d);
      localStringBuilder.append("  created in:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" release in:");
      localStringBuilder.append(i);
      f.d("WMPF.LuggageGLFrameBufferObject", localStringBuilder.toString());
      return;
    }
    this.b = true;
    com.tencent.luggage.wxa.sq.a.d.b(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" close framebuffer:");
    localStringBuilder.append(this.c);
    f.b("WMPF.LuggageGLFrameBufferObject", localStringBuilder.toString());
  }
  
  protected final void finalize()
  {
    if (!this.b)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" Leaked !!!  scene：");
      localStringBuilder.append(this.d);
      f.d("WMPF.LuggageGLFrameBufferObject", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" release success!");
    f.b("WMPF.LuggageGLFrameBufferObject", localStringBuilder.toString());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hashcode:");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" frameBufferId:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" memRelease:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" scene:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" create-tid:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.so.a
 * JD-Core Version:    0.7.0.1
 */