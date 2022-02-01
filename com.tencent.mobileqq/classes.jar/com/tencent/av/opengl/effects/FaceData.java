package com.tencent.av.opengl.effects;

import android.graphics.PointF;
import com.tencent.av.AVLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.nio.ByteBuffer;
import java.util.List;

public class FaceData
{
  public int a;
  public List<PointF> a;
  public short a;
  public boolean a;
  public byte[] a;
  public float[] a;
  public int b;
  public short b;
  public byte[] b;
  public int c;
  public byte[] c;
  
  public FaceData()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
  }
  
  private byte[] a(int paramInt1, int paramInt2)
  {
    PointF localPointF = null;
    Object localObject = localPointF;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = localPointF;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject = localPointF;
        if (paramInt1 != 0)
        {
          localObject = localPointF;
          if (paramInt2 != 0)
          {
            float f1 = 240.0F / paramInt1;
            float f2 = 320.0F / paramInt2;
            AVLog.printColorLog("FaceData", "getFaceFeature:" + paramInt1 + "|" + paramInt2 + "|" + f1);
            localObject = ByteBuffer.allocate(this.jdField_a_of_type_JavaUtilList.size() * 4);
            paramInt1 = 0;
            while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
            {
              localPointF = (PointF)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
              short s1 = (short)(int)(localPointF.x * f1);
              short s2 = (short)(int)(localPointF.y * f2);
              ((ByteBuffer)localObject).putShort(s1);
              ((ByteBuffer)localObject).putShort(s2);
              paramInt1 += 1;
            }
            localObject = ((ByteBuffer)localObject).array();
          }
        }
      }
    }
    return localObject;
  }
  
  private byte[] b(int paramInt1, int paramInt2)
  {
    PointF localPointF = null;
    Object localObject = localPointF;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = localPointF;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject = localPointF;
        if (paramInt1 != 0)
        {
          localObject = localPointF;
          if (paramInt2 != 0)
          {
            float f1 = 2.4E+008F / paramInt1;
            float f2 = 3.2E+008F / paramInt2;
            AVLog.printColorLog("FaceData", "getFaceFeature2:" + paramInt1 + "|" + paramInt2 + "|" + f1);
            localObject = ByteBuffer.allocate(this.jdField_a_of_type_JavaUtilList.size() * 8);
            paramInt1 = 0;
            while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
            {
              localPointF = (PointF)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
              paramInt2 = (int)(localPointF.x * f1);
              int i = (int)(localPointF.y * f2);
              ((ByteBuffer)localObject).putInt(paramInt2);
              ((ByteBuffer)localObject).putInt(i);
              paramInt1 += 1;
            }
            localObject = ((ByteBuffer)localObject).array();
          }
        }
      }
    }
    return localObject;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(PTFaceAttr paramPTFaceAttr, boolean paramBoolean)
  {
    if (paramPTFaceAttr != null)
    {
      this.jdField_a_of_type_Int = paramPTFaceAttr.getFaceCount();
      if ((this.jdField_a_of_type_Int > 0) && (paramPTFaceAttr != null))
      {
        if (paramBoolean) {
          break label102;
        }
        this.jdField_a_of_type_JavaUtilList = ((List)paramPTFaceAttr.getAllFacePoints().get(0));
        this.jdField_a_of_type_ArrayOfFloat = ((float[])paramPTFaceAttr.getAllFaceAngles().get(0));
        this.jdField_a_of_type_ArrayOfByte = a(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_ArrayOfByte = b(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
    label102:
    while ("" == null)
    {
      return;
      this.jdField_a_of_type_Int = 0;
      break;
    }
    paramPTFaceAttr = ByteBuffer.allocate("".getBytes().length + 4);
    this.jdField_a_of_type_Short = ((short)this.jdField_c_of_type_Int);
    this.jdField_b_of_type_Short = ((short)this.jdField_b_of_type_Int);
    paramPTFaceAttr.put(new byte[] { (byte)(this.jdField_b_of_type_Short >> 8), (byte)(this.jdField_b_of_type_Short >> 0), (byte)(this.jdField_a_of_type_Short >> 8), (byte)(this.jdField_a_of_type_Short >> 0) });
    paramPTFaceAttr.put("".getBytes());
    this.jdField_c_of_type_ArrayOfByte = paramPTFaceAttr.array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FaceData
 * JD-Core Version:    0.7.0.1
 */