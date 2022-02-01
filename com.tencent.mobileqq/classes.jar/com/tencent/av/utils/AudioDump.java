package com.tencent.av.utils;

import android.os.Environment;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.qav.log.AVLog;
import java.io.File;
import java.util.Calendar;

public class AudioDump
  implements SdkAudioFrameCallback
{
  private static volatile AudioDump l;
  private VcControllerImpl a = null;
  private QQGAudioCtrl b = null;
  private boolean c = false;
  private int d = 0;
  private byte[] e = null;
  private byte[] f = null;
  private int g = 0;
  private int h = 0;
  private String i = "";
  private String j = "";
  private final Object k = new Object();
  
  public AudioDump()
  {
    g();
  }
  
  public static AudioDump a()
  {
    if (l == null) {
      try
      {
        if (l == null) {
          l = new AudioDump();
        }
      }
      finally {}
    }
    return l;
  }
  
  /* Error */
  private static void a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifgt +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: new 69	java/io/DataOutputStream
    //   13: dup
    //   14: new 71	java/io/FileOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 74	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 77	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: iconst_0
    //   29: iload_1
    //   30: invokevirtual 81	java/io/DataOutputStream:write	([BII)V
    //   33: ldc 83
    //   35: ldc 85
    //   37: invokestatic 90	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_2
    //   41: invokevirtual 93	java/io/DataOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aload_2
    //   47: astore_3
    //   48: goto +38 -> 86
    //   51: astore_3
    //   52: aload_2
    //   53: astore_0
    //   54: aload_3
    //   55: astore_2
    //   56: goto +11 -> 67
    //   59: astore_0
    //   60: goto +26 -> 86
    //   63: astore_2
    //   64: aload 4
    //   66: astore_0
    //   67: aload_0
    //   68: astore_3
    //   69: ldc 83
    //   71: ldc 95
    //   73: aload_2
    //   74: invokestatic 98	com/tencent/qav/log/AVLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 93	java/io/DataOutputStream:close	()V
    //   85: return
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 93	java/io/DataOutputStream:close	()V
    //   94: aload_0
    //   95: athrow
    //   96: astore_0
    //   97: return
    //   98: astore_2
    //   99: goto -5 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramArrayOfByte	byte[]
    //   0	102	1	paramInt	int
    //   0	102	2	paramString	String
    //   9	39	3	str	String
    //   51	4	3	localException	Exception
    //   68	23	3	arrayOfByte	byte[]
    //   6	59	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	40	45	finally
    //   26	40	51	java/lang/Exception
    //   10	26	59	finally
    //   69	77	59	finally
    //   10	26	63	java/lang/Exception
    //   40	44	96	java/io/IOException
    //   81	85	96	java/io/IOException
    //   90	94	98	java/io/IOException
  }
  
  private static boolean a(int paramInt)
  {
    return false;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.b;
    int m = -1;
    int n;
    if (localObject != null)
    {
      m = ((QQGAudioCtrl)localObject).registerAudioDataCallback(paramInt, paramBoolean);
      n = this.b.setAudioDataFormat(paramInt, 16000, 1, 16);
    }
    else
    {
      localObject = this.a;
      if (localObject != null)
      {
        m = ((VcControllerImpl)localObject).registerAudioDataCallback(paramInt, paramBoolean);
        n = this.a.setAudioDataFormat(paramInt, 16000, 1, 16);
      }
      else
      {
        n = -1;
      }
    }
    if ((m == 0) && (n == 0)) {
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("registerAudioDataCallback failed. srcType = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ret1 = ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(", ret2 = ");
    ((StringBuilder)localObject).append(n);
    AVLog.a("AudioDump", ((StringBuilder)localObject).toString());
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((QQGAudioCtrl)localObject).enableDumpAudioData(paramBoolean);
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        ((VcControllerImpl)localObject).enableDumpAudioData(paramBoolean);
      }
    }
    return true;
  }
  
  public static void b()
  {
    if (l != null) {
      try
      {
        if (l != null) {
          l.d();
        }
        l = null;
        AVLog.c("AudioDump", "destroyInstance.", new Throwable("打印调用栈"));
        return;
      }
      finally {}
    }
  }
  
  private boolean b(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((QQGAudioCtrl)localObject).unregisterAudioDataCallback(paramInt);
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        ((VcControllerImpl)localObject).unregisterAudioDataCallback(paramInt);
      }
    }
    return true;
  }
  
  public static boolean c()
  {
    return false;
  }
  
  private boolean g()
  {
    if (this.c) {
      return true;
    }
    this.c = true;
    AVLog.d("AudioDump", "init successfully.");
    return true;
  }
  
  public boolean a(VcControllerImpl arg1, QQGAudioCtrl paramQQGAudioCtrl)
  {
    if (!this.c)
    {
      AVLog.a("AudioDump", "startSave failed. !mIsInited.");
      return false;
    }
    if (f()) {
      return true;
    }
    this.a = ???;
    this.b = paramQQGAudioCtrl;
    if (a(35))
    {
      a(true);
      a(0, false);
      a(2, false);
    }
    else if (a(36))
    {
      a(true);
    }
    else if (a(37))
    {
      a(0, false);
    }
    else
    {
      if (!a(38)) {
        break label552;
      }
      a(2, false);
    }
    synchronized (this.k)
    {
      this.e = new byte[52428800];
      this.f = new byte[52428800];
      this.g = 0;
      this.h = 0;
      paramQQGAudioCtrl = Calendar.getInstance();
      int m = paramQQGAudioCtrl.get(1);
      int n = paramQQGAudioCtrl.get(2) + 1;
      int i1 = paramQQGAudioCtrl.get(5);
      int i2 = paramQQGAudioCtrl.get(11);
      int i3 = paramQQGAudioCtrl.get(12);
      int i4 = paramQQGAudioCtrl.get(13);
      paramQQGAudioCtrl = new StringBuilder();
      paramQQGAudioCtrl.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramQQGAudioCtrl.append(File.separator);
      paramQQGAudioCtrl.append(String.format("trae-dump-%04d-%02d-%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
      paramQQGAudioCtrl.append(File.separator);
      paramQQGAudioCtrl.append(String.format("%04d-%02d-%02d-%02d-%02d-%02d-%s-%d_%d.pcm", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), "after3A", Integer.valueOf(16000), Integer.valueOf(1) }));
      this.i = paramQQGAudioCtrl.toString();
      paramQQGAudioCtrl = new StringBuilder();
      paramQQGAudioCtrl.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramQQGAudioCtrl.append(File.separator);
      paramQQGAudioCtrl.append(String.format("trae-dump-%04d-%02d-%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
      paramQQGAudioCtrl.append(File.separator);
      paramQQGAudioCtrl.append(String.format("%04d-%02d-%02d-%02d-%02d-%02d-%s-%d_%d.pcm", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), "afterVAD", Integer.valueOf(16000), Integer.valueOf(1) }));
      this.j = paramQQGAudioCtrl.toString();
      this.d = 1;
      AVLog.d("AudioDump", "startSave successfully. ");
      return true;
    }
    label552:
    return false;
  }
  
  public void d()
  {
    if (!this.c) {
      return;
    }
    e();
    this.a = null;
    this.b = null;
    this.c = false;
    AVLog.d("AudioDump", "uninit successfully.");
  }
  
  public void e()
  {
    if (!this.c) {
      return;
    }
    if (!f()) {
      return;
    }
    this.d = 0;
    synchronized (this.k)
    {
      a(this.e, this.g, this.i);
      a(this.f, this.h, this.j);
      this.e = null;
      this.f = null;
      this.g = 0;
      this.h = 0;
      try
      {
        a(false);
        b(0);
        b(2);
        AVLog.d("AudioDump", "stopSave sucessfully.");
        return;
      }
      catch (Exception localException)
      {
        AVLog.a("AudioDump", "stopSave failed.", localException);
        return;
      }
    }
  }
  
  public boolean f()
  {
    return this.d != 0;
  }
  
  public void onReceiveAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.c)
    {
      if (this.d != 1) {
        return;
      }
      localObject = this.k;
      if (paramInt1 != 0) {}
    }
    try
    {
      if (this.e != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.e, this.g, paramInt2);
        this.g += paramInt2;
        break label99;
        if ((paramInt1 == 2) && (this.f != null))
        {
          System.arraycopy(paramArrayOfByte, 0, this.f, this.h, paramInt2);
          this.h += paramInt2;
        }
      }
      label99:
      return;
    }
    finally
    {
      label103:
      break label103;
    }
    throw paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AudioDump
 * JD-Core Version:    0.7.0.1
 */