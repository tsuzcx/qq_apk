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
  private static volatile AudioDump jdField_a_of_type_ComTencentAvUtilsAudioDump;
  private int jdField_a_of_type_Int = 0;
  private VcControllerImpl jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
  private QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private byte[] jdField_b_of_type_ArrayOfByte = null;
  private int c = 0;
  
  public AudioDump()
  {
    c();
  }
  
  public static AudioDump a()
  {
    if (jdField_a_of_type_ComTencentAvUtilsAudioDump == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvUtilsAudioDump == null) {
          jdField_a_of_type_ComTencentAvUtilsAudioDump = new AudioDump();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvUtilsAudioDump;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentAvUtilsAudioDump != null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvUtilsAudioDump != null) {
          jdField_a_of_type_ComTencentAvUtilsAudioDump.b();
        }
        jdField_a_of_type_ComTencentAvUtilsAudioDump = null;
        AVLog.c("AudioDump", "destroyInstance.", new Throwable("打印调用栈"));
        return;
      }
      finally {}
    }
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
    //   10: new 78	java/io/DataOutputStream
    //   13: dup
    //   14: new 80	java/io/FileOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 84	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: iconst_0
    //   29: iload_1
    //   30: invokevirtual 88	java/io/DataOutputStream:write	([BII)V
    //   33: ldc 57
    //   35: ldc 90
    //   37: invokestatic 94	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_2
    //   41: invokevirtual 97	java/io/DataOutputStream:close	()V
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
    //   69: ldc 57
    //   71: ldc 99
    //   73: aload_2
    //   74: invokestatic 101	com/tencent/qav/log/AVLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 97	java/io/DataOutputStream:close	()V
    //   85: return
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 97	java/io/DataOutputStream:close	()V
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
  
  public static boolean a()
  {
    return false;
  }
  
  private static boolean a(int paramInt)
  {
    return false;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    int i = -1;
    int j;
    if (localObject != null)
    {
      i = ((QQGAudioCtrl)localObject).registerAudioDataCallback(paramInt, paramBoolean);
      j = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioDataFormat(paramInt, 16000, 1, 16);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
      if (localObject != null)
      {
        i = ((VcControllerImpl)localObject).registerAudioDataCallback(paramInt, paramBoolean);
        j = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioDataFormat(paramInt, 16000, 1, 16);
      }
      else
      {
        j = -1;
      }
    }
    if ((i == 0) && (j == 0)) {
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("registerAudioDataCallback failed. srcType = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ret1 = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", ret2 = ");
    ((StringBuilder)localObject).append(j);
    AVLog.a("AudioDump", ((StringBuilder)localObject).toString());
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localObject != null)
    {
      ((QQGAudioCtrl)localObject).enableDumpAudioData(paramBoolean);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
      if (localObject != null) {
        ((VcControllerImpl)localObject).enableDumpAudioData(paramBoolean);
      }
    }
    return true;
  }
  
  private boolean b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localObject != null)
    {
      ((QQGAudioCtrl)localObject).unregisterAudioDataCallback(paramInt);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
      if (localObject != null) {
        ((VcControllerImpl)localObject).unregisterAudioDataCallback(paramInt);
      }
    }
    return true;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    AVLog.d("AudioDump", "init successfully.");
    return true;
  }
  
  public boolean a(VcControllerImpl arg1, QQGAudioCtrl paramQQGAudioCtrl)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AVLog.a("AudioDump", "startSave failed. !mIsInited.");
      return false;
    }
    if (b()) {
      return true;
    }
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = ???;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = paramQQGAudioCtrl;
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[52428800];
      this.jdField_b_of_type_ArrayOfByte = new byte[52428800];
      this.jdField_b_of_type_Int = 0;
      this.c = 0;
      paramQQGAudioCtrl = Calendar.getInstance();
      int i = paramQQGAudioCtrl.get(1);
      int j = paramQQGAudioCtrl.get(2) + 1;
      int k = paramQQGAudioCtrl.get(5);
      int m = paramQQGAudioCtrl.get(11);
      int n = paramQQGAudioCtrl.get(12);
      int i1 = paramQQGAudioCtrl.get(13);
      paramQQGAudioCtrl = new StringBuilder();
      paramQQGAudioCtrl.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramQQGAudioCtrl.append(File.separator);
      paramQQGAudioCtrl.append(String.format("trae-dump-%04d-%02d-%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      paramQQGAudioCtrl.append(File.separator);
      paramQQGAudioCtrl.append(String.format("%04d-%02d-%02d-%02d-%02d-%02d-%s-%d_%d.pcm", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), "after3A", Integer.valueOf(16000), Integer.valueOf(1) }));
      this.jdField_a_of_type_JavaLangString = paramQQGAudioCtrl.toString();
      paramQQGAudioCtrl = new StringBuilder();
      paramQQGAudioCtrl.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      paramQQGAudioCtrl.append(File.separator);
      paramQQGAudioCtrl.append(String.format("trae-dump-%04d-%02d-%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      paramQQGAudioCtrl.append(File.separator);
      paramQQGAudioCtrl.append(String.format("%04d-%02d-%02d-%02d-%02d-%02d-%s-%d_%d.pcm", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), "afterVAD", Integer.valueOf(16000), Integer.valueOf(1) }));
      this.jdField_b_of_type_JavaLangString = paramQQGAudioCtrl.toString();
      this.jdField_a_of_type_Int = 1;
      AVLog.d("AudioDump", "startSave successfully. ");
      return true;
    }
    label552:
    return false;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    c();
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    this.jdField_a_of_type_Boolean = false;
    AVLog.d("AudioDump", "uninit successfully.");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!b()) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      a(this.jdField_b_of_type_ArrayOfByte, this.c, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ArrayOfByte = null;
      this.jdField_b_of_type_ArrayOfByte = null;
      this.jdField_b_of_type_Int = 0;
      this.c = 0;
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
  
  public void onReceiveAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int != 1) {
        return;
      }
      localObject = this.jdField_a_of_type_JavaLangObject;
      if (paramInt1 != 0) {}
    }
    try
    {
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_Int, paramInt2);
        this.jdField_b_of_type_Int += paramInt2;
        break label99;
        if ((paramInt1 == 2) && (this.jdField_b_of_type_ArrayOfByte != null))
        {
          System.arraycopy(paramArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte, this.c, paramInt2);
          this.c += paramInt2;
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