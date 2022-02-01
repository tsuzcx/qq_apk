package com.tencent.mobileqq.apollo.view;

import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;

public class SimpleFrameZipDecoder
  implements Handler.Callback
{
  protected SimpleFrameZipDecoder.IDownloadable a;
  protected SimpleFrameZipDecoder.OnFrameDecodeListener b;
  protected int c = 0;
  String[] d;
  Bitmap e;
  String f;
  private int g;
  private boolean h;
  private String i;
  private boolean j;
  private long k;
  private int l;
  private WeakReferenceHandler m = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean n;
  
  public SimpleFrameZipDecoder(SimpleFrameZipDecoder.IDownloadable paramIDownloadable, SimpleFrameZipDecoder.OnFrameDecodeListener paramOnFrameDecodeListener)
  {
    this.a = paramIDownloadable;
    this.b = paramOnFrameDecodeListener;
  }
  
  private void a(boolean paramBoolean, File paramFile, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      a(paramFile, paramString);
      this.d = new File(paramString).list();
      this.c = 3;
      if ((this.d != null) && (this.d.length > 0))
      {
        int i1 = 0;
        while (i1 < this.d.length)
        {
          paramFile = this.d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(this.d[i1]);
          paramFile[i1] = localStringBuilder.toString();
          i1 += 1;
        }
      }
      if (this.h)
      {
        c();
        if ((!this.j) && (this.d != null) && (this.d.length > 0))
        {
          this.l = 0;
          this.j = true;
          new SimpleFrameZipDecoder.DecodeAsyncTask(this, 0).execute(new Integer[] { Integer.valueOf(this.l) });
          return;
        }
      }
    }
    catch (OutOfMemoryError paramFile)
    {
      QLog.e("[cmshow]SimpleFrameZipDecoder", 1, paramFile.getMessage());
      this.c = 2;
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("[cmshow]SimpleFrameZipDecoder", 1, paramFile.getMessage());
      this.c = 2;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.g = paramInt;
    this.h = paramBoolean;
    if (!paramString2.equals(this.i))
    {
      this.i = paramString2;
      this.c = 0;
      c();
      this.d = null;
    }
    paramInt = this.c;
    if ((paramInt == 2) || (paramInt == 0))
    {
      paramString2 = b(this.i);
      this.f = paramString2;
      Object localObject = new File(paramString2);
      ((File)localObject).mkdirs();
      localObject = ((File)localObject).list();
      File localFile = new File(this.i);
      if ((localObject != null) && (localObject.length > 0))
      {
        a(false, localFile, paramString2);
        return;
      }
      if (localFile.exists())
      {
        a(true, localFile, paramString2);
        return;
      }
      localObject = this.a;
      if (localObject != null)
      {
        ((SimpleFrameZipDecoder.IDownloadable)localObject).a(this, paramString1, this.i, paramString2);
        return;
      }
      this.c = 2;
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    if ((this.j) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.k;
      this.e = paramBitmap;
      if (l2 > this.g)
      {
        this.k = l1;
        this.m.obtainMessage(255, this.l, 0).sendToTarget();
      }
      else
      {
        paramBitmap = this.m.obtainMessage(255, this.l, 0);
        this.m.sendMessageDelayed(paramBitmap, this.g - l2);
      }
      this.l = (paramInt + 1);
    }
  }
  
  protected void a(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      ZipUtils.unZipFile(paramFile, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish，result:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" zipFile:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" folder:");
      localStringBuilder.append(paramString3);
      QLog.d("[cmshow]SimpleFrameZipDecoder", 2, localStringBuilder.toString());
    }
    paramString1 = this.i;
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("onDownloadFinish，zipFile unEqual mLocalZipPath:");
        paramString1.append(this.i);
        QLog.d("[cmshow]SimpleFrameZipDecoder", 2, paramString1.toString());
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        a(true, paramString1, paramString3);
        return;
      }
      this.c = 2;
      return;
    }
    this.c = 2;
  }
  
  protected String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (i1 > 0) {
        str = paramString.substring(0, i1);
      }
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append(File.separator);
      return paramString.toString();
    }
    return "";
  }
  
  public void b()
  {
    if (this.c == 3)
    {
      c();
      try
      {
        if ((!this.j) && (this.d != null) && (this.d.length > 0))
        {
          this.l = 0;
          this.j = true;
          new SimpleFrameZipDecoder.DecodeAsyncTask(this, 0).execute(new Integer[] { Integer.valueOf(this.l) });
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]SimpleFrameZipDecoder", 2, localException, new Object[0]);
      }
    }
  }
  
  public void c()
  {
    this.j = false;
    this.m.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 255) {
      return false;
    }
    if (!this.j) {
      return true;
    }
    SimpleFrameZipDecoder.OnFrameDecodeListener localOnFrameDecodeListener = this.b;
    if (localOnFrameDecodeListener == null) {
      return false;
    }
    localOnFrameDecodeListener.a(paramMessage.arg1, this.e);
    if (this.n)
    {
      paramMessage = this.d;
      if ((paramMessage != null) && (this.l >= paramMessage.length) && (paramMessage.length != 1)) {
        this.l = 0;
      }
    }
    paramMessage = this.d;
    if (paramMessage != null)
    {
      int i1 = paramMessage.length;
      int i2 = this.l;
      if (i1 > i2)
      {
        new SimpleFrameZipDecoder.DecodeAsyncTask(this, i2).execute(new Integer[] { Integer.valueOf(this.l) });
        break label151;
      }
    }
    this.j = false;
    this.b.b();
    label151:
    this.k = System.currentTimeMillis();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.SimpleFrameZipDecoder
 * JD-Core Version:    0.7.0.1
 */