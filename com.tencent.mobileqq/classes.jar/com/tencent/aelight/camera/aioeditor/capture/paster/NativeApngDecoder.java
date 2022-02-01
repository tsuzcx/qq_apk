package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class NativeApngDecoder
  implements Handler.Callback
{
  int[] a = new int[7];
  public int b = 0;
  public int c = 0;
  long d;
  int e;
  protected Bitmap f;
  protected Bitmap g;
  protected int h = -1;
  protected int i;
  private int j = 0;
  private Paint k = new Paint();
  private Paint l = new Paint();
  private volatile long m = 0L;
  private HandlerThread n;
  private Handler o;
  private long p = 0L;
  private boolean q = false;
  
  public NativeApngDecoder(File paramFile)
  {
    int i1;
    int i2;
    if (paramFile != null)
    {
      this.n = new HandlerThread("gif_decode_thread");
      this.n.start();
      this.o = new Handler(this.n.getLooper(), this);
      this.k.setAntiAlias(true);
      this.l.setAntiAlias(true);
      this.l.setColor(0);
      a(paramFile);
      i1 = this.b;
      if (i1 > 0)
      {
        i2 = this.c;
        if (i2 <= 0) {}
      }
    }
    try
    {
      this.f = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      this.g = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError paramFile)
    {
      label192:
      label234:
      break label192;
    }
    URLDrawable.clearMemoryCache();
    try
    {
      this.f = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
      this.g = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError paramFile)
    {
      break label234;
    }
    QLog.e("NativeApngDecoder", 1, "APNG create Bitmap OOM");
    this.m = ApngImage.nativeGetNextFrame(this.d, this.m, this.f, this.a);
    paramFile = this.a;
    if (paramFile[5] == 0) {
      this.i = paramFile[4];
    }
    this.h = 0;
    return;
    throw new NullPointerException("Source is null");
  }
  
  private void a(File paramFile)
  {
    this.d = ApngImage.nativeStartDecode(paramFile.getAbsolutePath(), this.a, this.e);
    paramFile = this.a;
    if (paramFile[5] == 0)
    {
      this.b = paramFile[0];
      this.c = paramFile[1];
      this.j = paramFile[2];
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("start decode success width = ");
        paramFile.append(this.b);
        paramFile.append(" height = ");
        paramFile.append(this.c);
        paramFile.append(" frameCount = ");
        paramFile.append(this.j);
        QLog.d("NativeApngDecoder", 2, paramFile.toString());
      }
    }
    else
    {
      paramFile = new StringBuilder();
      paramFile.append("start decode error: ");
      paramFile.append(this.a[5]);
      QLog.e("NativeApngDecoder", 1, paramFile.toString());
    }
  }
  
  public Bitmap a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.i * 1000 * 1000;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNextFrameBitmap| timestamp = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("NativeApngDecoder", 2, ((StringBuilder)localObject).toString());
    }
    long l3 = paramLong - this.p;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNextFrameBitmap| interval = ");
      boolean bool;
      if (l3 < l2) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("NativeApngDecoder", 2, ((StringBuilder)localObject).toString());
    }
    if (l3 < l2)
    {
      if (!this.q)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 2;
        ((Message)localObject).arg1 = this.h;
        ((Message)localObject).arg2 = 0;
        this.o.sendMessage((Message)localObject);
      }
    }
    else if (this.q)
    {
      if (this.h == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.h = i1;
      this.p = paramLong;
      this.q = false;
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = this.h;
      ((Message)localObject).arg2 = 1;
      this.o.sendMessage((Message)localObject);
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("NativeApngDecoder", 2, "getNextFrameBitmap| had not preLoad ");
    }
    Object localObject = null;
    int i1 = this.h;
    if (i1 == 0) {
      localObject = this.f;
    } else if (i1 == 1) {
      localObject = this.g;
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNextFrameBitmap| gifTime= ");
      localStringBuilder.append(l2);
      localStringBuilder.append(",cost=");
      localStringBuilder.append(paramLong - l1);
      QLog.d("NativeApngDecoder", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  protected void finalize()
  {
    if (this.m != 0L) {
      ApngImage.nativeFreeFrame(this.m);
    }
    long l1 = this.d;
    if (l1 != 0L) {
      ApngImage.nativeFreeImage(l1);
    }
    super.finalize();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1;
    if (paramMessage.what == 1)
    {
      i1 = this.h;
      if ((i1 != -1) && (i1 != 1))
      {
        if (i1 == 0)
        {
          this.m = ApngImage.nativeGetNextFrame(this.d, this.m, this.g, this.a);
          this.h = 1;
          return false;
        }
      }
      else
      {
        this.m = ApngImage.nativeGetNextFrame(this.d, this.m, this.f, this.a);
        this.h = 0;
        return false;
      }
    }
    else if (paramMessage.what == 2)
    {
      long l1 = System.currentTimeMillis();
      i1 = paramMessage.arg1;
      int i2 = paramMessage.arg2;
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("getNextFrameBitmap| PRE_LOAD_FRAME Begin + type:");
        paramMessage.append(i2);
        QLog.d("NativeApngDecoder", 2, paramMessage.toString());
      }
      if (i1 == 0) {
        this.m = ApngImage.nativeGetNextFrame(this.d, this.m, this.g, this.a);
      } else if (i1 == 1) {
        this.m = ApngImage.nativeGetNextFrame(this.d, this.m, this.f, this.a);
      }
      paramMessage = this.a;
      if (paramMessage[5] == 0) {
        this.i = paramMessage[4];
      } else if (QLog.isColorLevel()) {
        QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap|error");
      }
      this.q = true;
      i1 = this.a[3];
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("getNextFrameBitmap| PRE_LOAD_FRAME END curIndex= ");
        paramMessage.append(i1);
        paramMessage.append(", cost=");
        paramMessage.append(l2 - l1);
        QLog.d("NativeApngDecoder", 2, paramMessage.toString());
      }
    }
    return false;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", new Object[] { Integer.valueOf(this.a[0]), Integer.valueOf(this.a[1]), Integer.valueOf(this.a[2]), Integer.valueOf(this.a[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.NativeApngDecoder
 * JD-Core Version:    0.7.0.1
 */