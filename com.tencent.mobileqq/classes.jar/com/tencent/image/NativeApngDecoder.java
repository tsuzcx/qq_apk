package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class NativeApngDecoder
  implements Handler.Callback
{
  public int a;
  long jdField_a_of_type_Long;
  protected Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt = new int[6];
  public int b;
  private volatile long jdField_b_of_type_Long;
  protected Bitmap b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  protected int d = -1;
  protected int e;
  private int f;
  
  public NativeApngDecoder(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("Source is null");
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("gif_decode_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(0);
    a(paramFile);
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0)) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
      if (this.jdField_a_of_type_ArrayOfInt[5] == 0) {
        this.e = this.jdField_a_of_type_ArrayOfInt[4];
      }
      this.d = 0;
      return;
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
          this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramFile)
        {
          QLog.e("NativeApngDecoder", 1, "APNG create Bitmap OOM");
        }
      }
    }
  }
  
  private void a(File paramFile)
  {
    this.jdField_a_of_type_Long = ApngImage.nativeStartDecode(paramFile.getAbsolutePath(), this.jdField_a_of_type_ArrayOfInt, this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ArrayOfInt[5] == 0)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfInt[0];
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
      this.f = this.jdField_a_of_type_ArrayOfInt[2];
      if (QLog.isColorLevel()) {
        QLog.d("NativeApngDecoder", 2, "start decode success width = " + this.jdField_a_of_type_Int + " height = " + this.jdField_b_of_type_Int + " frameCount = " + this.f);
      }
      return;
    }
    QLog.e("NativeApngDecoder", 1, "start decode error: " + this.jdField_a_of_type_ArrayOfInt[5]);
  }
  
  public Bitmap a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.e * 1000 * 1000;
    if (QLog.isColorLevel()) {
      QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| timestamp = " + paramLong);
    }
    Object localObject;
    if (paramLong - this.jdField_c_of_type_Long < l2)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 2;
        ((Message)localObject).arg1 = this.d;
        ((Message)localObject).arg2 = 0;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
      localObject = null;
      if (this.d != 0) {
        break label271;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    for (;;)
    {
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| gifTime= " + l2 + ",cost=" + (paramLong - l1));
      }
      return localObject;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.d == 0) {}
        for (int i = 1;; i = 0)
        {
          this.d = i;
          this.jdField_c_of_type_Long += l2;
          this.jdField_a_of_type_Boolean = false;
          localObject = Message.obtain();
          ((Message)localObject).what = 2;
          ((Message)localObject).arg1 = this.d;
          ((Message)localObject).arg2 = 1;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
          break;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("NativeApngDecoder", 2, "getNextFrameBitmap| had not preLoad ");
      break;
      label271:
      if (this.d == 1) {
        localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
    }
  }
  
  protected void finalize()
  {
    if (this.jdField_b_of_type_Long != 0L) {
      ApngImage.nativeFreeFrame(this.jdField_b_of_type_Long);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      ApngImage.nativeFreeImage(this.jdField_a_of_type_Long);
    }
    super.finalize();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if ((this.d == -1) || (this.d == 1))
      {
        this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
        this.d = 0;
      }
    }
    while (paramMessage.what != 2)
    {
      do
      {
        return false;
      } while (this.d != 0);
      this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
      this.d = 1;
      return false;
    }
    long l1 = System.currentTimeMillis();
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    if (QLog.isColorLevel()) {
      QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| PRE_LOAD_FRAME Begin + type:" + j);
    }
    if (i == 0)
    {
      this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
      label172:
      if (this.jdField_a_of_type_ArrayOfInt[5] != 0) {
        break label285;
      }
      this.e = this.jdField_a_of_type_ArrayOfInt[4];
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      i = this.jdField_a_of_type_ArrayOfInt[3];
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| PRE_LOAD_FRAME END curIndex= " + i + ", cost=" + (l2 - l1));
      return false;
      if (i != 1) {
        break label172;
      }
      this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
      break label172;
      label285:
      if (QLog.isColorLevel()) {
        QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap|error");
      }
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[2]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.image.NativeApngDecoder
 * JD-Core Version:    0.7.0.1
 */