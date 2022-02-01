package com.tencent.av.camera;

import com.tencent.qphone.base.util.QLog;

public class FrameBufMgr
{
  static int jdField_a_of_type_Int;
  private static volatile FrameBufMgr jdField_a_of_type_ComTencentAvCameraFrameBufMgr;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private FrameBufMgr.FrameBuf[] jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf = new FrameBufMgr.FrameBuf[4];
  
  public static FrameBufMgr a()
  {
    if (jdField_a_of_type_ComTencentAvCameraFrameBufMgr == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvCameraFrameBufMgr == null) {
          jdField_a_of_type_ComTencentAvCameraFrameBufMgr = new FrameBufMgr();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvCameraFrameBufMgr;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf.length;
  }
  
  public void a()
  {
    QLog.i("FrameBufMgr", 1, "clear.");
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf.length)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i] != null)
          {
            this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_ArrayOfByte = null;
            this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_Int = 0;
          }
        }
        else {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    int j = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf.length)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_Int == paramInt1)
          {
            this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_Int = paramInt2;
            j = 1;
          }
        }
        else
        {
          if (j == 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("setFrameBufState failed. oldState = ");
            ((StringBuilder)localObject1).append(paramInt1);
            ((StringBuilder)localObject1).append(", newState = ");
            ((StringBuilder)localObject1).append(paramInt2);
            QLog.i("FrameBufMgr", 1, ((StringBuilder)localObject1).toString());
          }
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf.length)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_ArrayOfByte == paramArrayOfByte) {
            this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_Int = paramInt;
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setFrameBufState failed. dataBuf = ");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          ((StringBuilder)localObject).append(", state = ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.i("FrameBufMgr", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      finally
      {
        continue;
        throw paramArrayOfByte;
        continue;
        i += 1;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init. bufSize = ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.i("FrameBufMgr", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i] == null) {
          this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i] = new FrameBufMgr.FrameBuf(this);
        }
        if ((this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_ArrayOfByte.length != paramInt)) {
          this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_ArrayOfByte = new byte[paramInt];
        }
        this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_Int = 0;
        i += 1;
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public byte[] a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf.length)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_Int == paramInt)
          {
            byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfComTencentAvCameraFrameBufMgr$FrameBuf[i].jdField_a_of_type_ArrayOfByte;
            return arrayOfByte;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getFrameBufByState failed. state = ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.i("FrameBufMgr", 1, ((StringBuilder)localObject1).toString());
          return null;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.FrameBufMgr
 * JD-Core Version:    0.7.0.1
 */