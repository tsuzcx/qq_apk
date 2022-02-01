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
  public int a;
  long jdField_a_of_type_Long;
  protected Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[7];
  public int b;
  private volatile long jdField_b_of_type_Long = 0L;
  protected Bitmap b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  protected int d = -1;
  protected int e;
  private int f = 0;
  
  public NativeApngDecoder(File paramFile)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    int i;
    int j;
    if (paramFile != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("gif_decode_thread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(0);
      a(paramFile);
      i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        j = this.jdField_b_of_type_Int;
        if (j <= 0) {}
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
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
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError paramFile)
    {
      break label234;
    }
    QLog.e("NativeApngDecoder", 1, "APNG create Bitmap OOM");
    this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
    paramFile = this.jdField_a_of_type_ArrayOfInt;
    if (paramFile[5] == 0) {
      this.e = paramFile[4];
    }
    this.d = 0;
    return;
    throw new NullPointerException("Source is null");
  }
  
  private void a(File paramFile)
  {
    this.jdField_a_of_type_Long = ApngImage.nativeStartDecode(paramFile.getAbsolutePath(), this.jdField_a_of_type_ArrayOfInt, this.jdField_c_of_type_Int);
    paramFile = this.jdField_a_of_type_ArrayOfInt;
    if (paramFile[5] == 0)
    {
      this.jdField_a_of_type_Int = paramFile[0];
      this.jdField_b_of_type_Int = paramFile[1];
      this.f = paramFile[2];
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("start decode success width = ");
        paramFile.append(this.jdField_a_of_type_Int);
        paramFile.append(" height = ");
        paramFile.append(this.jdField_b_of_type_Int);
        paramFile.append(" frameCount = ");
        paramFile.append(this.f);
        QLog.d("NativeApngDecoder", 2, paramFile.toString());
      }
    }
    else
    {
      paramFile = new StringBuilder();
      paramFile.append("start decode error: ");
      paramFile.append(this.jdField_a_of_type_ArrayOfInt[5]);
      QLog.e("NativeApngDecoder", 1, paramFile.toString());
    }
  }
  
  public Bitmap a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.e * 1000 * 1000;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNextFrameBitmap| timestamp = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("NativeApngDecoder", 2, ((StringBuilder)localObject).toString());
    }
    long l3 = paramLong - this.jdField_c_of_type_Long;
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
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 2;
        ((Message)localObject).arg1 = this.d;
        ((Message)localObject).arg2 = 0;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      if (this.d == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.d = i;
      this.jdField_c_of_type_Long = paramLong;
      this.jdField_a_of_type_Boolean = false;
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = this.d;
      ((Message)localObject).arg2 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("NativeApngDecoder", 2, "getNextFrameBitmap| had not preLoad ");
    }
    Object localObject = null;
    int i = this.d;
    if (i == 0) {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    } else if (i == 1) {
      localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
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
    if (this.jdField_b_of_type_Long != 0L) {
      ApngImage.nativeFreeFrame(this.jdField_b_of_type_Long);
    }
    long l = this.jdField_a_of_type_Long;
    if (l != 0L) {
      ApngImage.nativeFreeImage(l);
    }
    super.finalize();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 1)
    {
      i = this.d;
      if ((i != -1) && (i != 1))
      {
        if (i == 0)
        {
          this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
          this.d = 1;
          return false;
        }
      }
      else
      {
        this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
        this.d = 0;
        return false;
      }
    }
    else if (paramMessage.what == 2)
    {
      long l1 = System.currentTimeMillis();
      i = paramMessage.arg1;
      int j = paramMessage.arg2;
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("getNextFrameBitmap| PRE_LOAD_FRAME Begin + type:");
        paramMessage.append(j);
        QLog.d("NativeApngDecoder", 2, paramMessage.toString());
      }
      if (i == 0) {
        this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
      } else if (i == 1) {
        this.jdField_b_of_type_Long = ApngImage.nativeGetNextFrame(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ArrayOfInt);
      }
      paramMessage = this.jdField_a_of_type_ArrayOfInt;
      if (paramMessage[5] == 0) {
        this.e = paramMessage[4];
      } else if (QLog.isColorLevel()) {
        QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap|error");
      }
      this.jdField_a_of_type_Boolean = true;
      i = this.jdField_a_of_type_ArrayOfInt[3];
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("getNextFrameBitmap| PRE_LOAD_FRAME END curIndex= ");
        paramMessage.append(i);
        paramMessage.append(", cost=");
        paramMessage.append(l2 - l1);
        QLog.d("NativeApngDecoder", 2, paramMessage.toString());
      }
    }
    return false;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[2]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.NativeApngDecoder
 * JD-Core Version:    0.7.0.1
 */