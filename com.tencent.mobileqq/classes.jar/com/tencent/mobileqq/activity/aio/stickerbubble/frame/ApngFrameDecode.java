package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.image.ApngImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApngFrameDecode
  implements IFrameDecode
{
  public int a;
  private volatile long jdField_a_of_type_Long = 0L;
  int[] jdField_a_of_type_ArrayOfInt = new int[7];
  public int b;
  private long b;
  int c = -1;
  private int d = 0;
  private int e = 0;
  
  public ApngFrameDecode(File paramFile)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    a(paramFile.getAbsolutePath());
    a();
    paramFile = this.jdField_a_of_type_ArrayOfInt;
    if (paramFile[5] == 0)
    {
      this.e = paramFile[4];
      return;
    }
    paramFile = new StringBuilder();
    paramFile.append("start decode error, errCode");
    paramFile.append(this.jdField_a_of_type_ArrayOfInt[5]);
    QLog.e("StickerBubble_ApngDecode", 1, paramFile.toString());
  }
  
  public int a()
  {
    return this.e;
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, localBitmap, this.jdField_a_of_type_ArrayOfInt);
    this.c += 1;
    return localBitmap;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_Long = ApngImage.nativeStartDecode(paramString, this.jdField_a_of_type_ArrayOfInt, 0);
    paramString = this.jdField_a_of_type_ArrayOfInt;
    if (paramString[5] == 0)
    {
      this.jdField_a_of_type_Int = paramString[0];
      this.jdField_b_of_type_Int = paramString[1];
      this.d = paramString[2];
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("start decode success, width = ");
        paramString.append(this.jdField_a_of_type_Int);
        paramString.append(" height = ");
        paramString.append(this.jdField_b_of_type_Int);
        paramString.append(" frameCount = ");
        paramString.append(this.d);
        QLog.d("StickerBubble_ApngDecode", 2, paramString.toString());
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("start decode error, errCode");
      paramString.append(this.jdField_a_of_type_ArrayOfInt[5]);
      QLog.e("StickerBubble_ApngDecode", 1, paramString.toString());
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      ApngImage.nativeFreeFrame(this.jdField_a_of_type_Long);
    }
    long l = this.jdField_b_of_type_Long;
    if (l != 0L) {
      ApngImage.nativeFreeImage(l);
    }
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.ApngFrameDecode
 * JD-Core Version:    0.7.0.1
 */