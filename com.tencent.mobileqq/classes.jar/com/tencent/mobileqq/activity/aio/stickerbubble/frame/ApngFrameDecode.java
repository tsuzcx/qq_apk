package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.image.ApngImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApngFrameDecode
  implements IFrameDecode
{
  int[] a = new int[7];
  public int b = 0;
  public int c = 0;
  int d = -1;
  private int e = 0;
  private int f = 0;
  private volatile long g = 0L;
  private long h;
  
  public ApngFrameDecode(File paramFile)
  {
    a(paramFile.getAbsolutePath());
    d();
    paramFile = this.a;
    if (paramFile[5] == 0)
    {
      this.f = paramFile[4];
      return;
    }
    paramFile = new StringBuilder();
    paramFile.append("start decode error, errCode");
    paramFile.append(this.a[5]);
    QLog.e("StickerBubble_ApngDecode", 1, paramFile.toString());
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(String paramString)
  {
    this.h = ApngImage.nativeStartDecode(paramString, this.a, 0);
    paramString = this.a;
    if (paramString[5] == 0)
    {
      this.b = paramString[0];
      this.c = paramString[1];
      this.e = paramString[2];
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("start decode success, width = ");
        paramString.append(this.b);
        paramString.append(" height = ");
        paramString.append(this.c);
        paramString.append(" frameCount = ");
        paramString.append(this.e);
        QLog.d("StickerBubble_ApngDecode", 2, paramString.toString());
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("start decode error, errCode");
      paramString.append(this.a[5]);
      QLog.e("StickerBubble_ApngDecode", 1, paramString.toString());
    }
  }
  
  public int b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public Bitmap d()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
    this.g = ApngImage.nativeGetNextFrame(this.h, this.g, localBitmap, this.a);
    this.d += 1;
    return localBitmap;
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.g != 0L) {
      ApngImage.nativeFreeFrame(this.g);
    }
    long l = this.h;
    if (l != 0L) {
      ApngImage.nativeFreeImage(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.ApngFrameDecode
 * JD-Core Version:    0.7.0.1
 */