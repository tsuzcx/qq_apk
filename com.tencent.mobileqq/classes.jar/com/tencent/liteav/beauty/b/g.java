package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.j;
import java.util.Iterator;
import java.util.List;

public class g
  extends j
{
  protected List<j> r;
  protected List<j> s;
  private int[] t;
  private int[] u;
  private j v;
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = this.s.size();
    k();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j localj = (j)this.s.get(i);
      if (j != 0) {
        paramInt1 = localj.a(paramInt1, paramInt2, paramInt3);
      } else {
        paramInt1 = localj.a(paramInt1, this.t[0], this.u[0]);
      }
      j ^= 0x1;
      i += 1;
    }
    if (j != 0) {
      this.v.a(paramInt1, paramInt2, paramInt3);
    }
    return paramInt3;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.e == paramInt1) && (this.f == paramInt2)) {
      return;
    }
    if (this.t != null) {
      f();
    }
    super.a(paramInt1, paramInt2);
    int j = this.s.size();
    int i = 0;
    while (i < j)
    {
      ((j)this.s.get(i)).a(paramInt1, paramInt2);
      i += 1;
    }
    this.v.a(paramInt1, paramInt2);
    List localList = this.s;
    if ((localList != null) && (localList.size() > 0))
    {
      this.s.size();
      this.t = new int[2];
      this.u = new int[2];
      i = 0;
      while (i < 2)
      {
        GLES20.glGenFramebuffers(1, this.t, i);
        GLES20.glGenTextures(1, this.u, i);
        GLES20.glBindTexture(3553, this.u[i]);
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.t[i]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u[i], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        i += 1;
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = super.b();
    boolean bool1 = bool2;
    if (bool2)
    {
      Iterator localIterator = this.r.iterator();
      j localj;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localj = (j)localIterator.next();
        localj.a();
      } while (localj.n());
      bool1 = this.v.a();
    }
    return (bool1) && (GLES20.glGetError() == 0);
  }
  
  public void e()
  {
    super.e();
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).d();
    }
  }
  
  public void f()
  {
    super.f();
    int[] arrayOfInt = this.u;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteTextures(2, arrayOfInt, 0);
      this.u = null;
    }
    arrayOfInt = this.t;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteFramebuffers(2, arrayOfInt, 0);
      this.t = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.g
 * JD-Core Version:    0.7.0.1
 */