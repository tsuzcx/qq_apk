package com.tencent.av.opengl.effects;

import android.graphics.PointF;
import com.tencent.av.AVLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.nio.ByteBuffer;
import java.util.List;

public class FaceData
{
  public List<PointF> a = null;
  public float[] b = null;
  public int c = 0;
  public byte[] d = null;
  public byte[] e = null;
  public byte[] f = null;
  public short g;
  public short h;
  public int i;
  public int j;
  public boolean k = false;
  
  private byte[] b(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0) && (paramInt1 != 0) && (paramInt2 != 0))
    {
      float f1 = 240.0F / paramInt1;
      float f2 = 320.0F / paramInt2;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFaceFeature:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(f1);
      AVLog.printColorLog("FaceData", ((StringBuilder)localObject).toString());
      localObject = ByteBuffer.allocate(this.a.size() * 4);
      paramInt1 = 0;
      while (paramInt1 < this.a.size())
      {
        PointF localPointF = (PointF)this.a.get(paramInt1);
        short s1 = (short)(int)(localPointF.x * f1);
        short s2 = (short)(int)(localPointF.y * f2);
        ((ByteBuffer)localObject).putShort(s1);
        ((ByteBuffer)localObject).putShort(s2);
        paramInt1 += 1;
      }
      return ((ByteBuffer)localObject).array();
    }
    return null;
  }
  
  private byte[] c(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0) && (paramInt1 != 0) && (paramInt2 != 0))
    {
      float f1 = 2.4E+008F / paramInt1;
      float f2 = 3.2E+008F / paramInt2;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFaceFeature2:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(f1);
      AVLog.printColorLog("FaceData", ((StringBuilder)localObject).toString());
      localObject = ByteBuffer.allocate(this.a.size() * 8);
      paramInt1 = 0;
      while (paramInt1 < this.a.size())
      {
        PointF localPointF = (PointF)this.a.get(paramInt1);
        paramInt2 = (int)(localPointF.x * f1);
        int m = (int)(localPointF.y * f2);
        ((ByteBuffer)localObject).putInt(paramInt2);
        ((ByteBuffer)localObject).putInt(m);
        paramInt1 += 1;
      }
      return ((ByteBuffer)localObject).array();
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.a = null;
    this.b = null;
    this.c = 0;
    this.d = null;
    this.e = null;
    this.f = null;
    this.k = false;
  }
  
  public void a(PTFaceAttr paramPTFaceAttr, boolean paramBoolean)
  {
    if (paramPTFaceAttr != null) {
      this.c = paramPTFaceAttr.getFaceCount();
    } else {
      this.c = 0;
    }
    if ((this.c > 0) && (paramPTFaceAttr != null))
    {
      if (!paramBoolean)
      {
        this.a = ((List)paramPTFaceAttr.getAllFacePoints().get(0));
        this.b = ((float[])paramPTFaceAttr.getAllFaceAngles().get(0));
        this.d = b(this.j, this.i);
        this.e = c(this.j, this.i);
        return;
      }
      paramPTFaceAttr = ByteBuffer.allocate("".getBytes().length + 4);
      this.g = ((short)this.j);
      this.h = ((short)this.i);
      int i1 = this.h;
      int m = (byte)(i1 >> 8);
      int n = (byte)(i1 >> 0);
      i1 = this.g;
      paramPTFaceAttr.put(new byte[] { m, n, (byte)(i1 >> 8), (byte)(i1 >> 0) });
      paramPTFaceAttr.put("".getBytes());
      this.f = paramPTFaceAttr.array();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FaceData
 * JD-Core Version:    0.7.0.1
 */