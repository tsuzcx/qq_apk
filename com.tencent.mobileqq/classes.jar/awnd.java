import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.videoplayer.TencentVideoSDKManager.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class awnd
{
  private static awnd jdField_a_of_type_Awnd;
  private static CopyOnWriteArraySet<awng> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static boolean jdField_a_of_type_Boolean;
  
  public static awnd a()
  {
    if (jdField_a_of_type_Awnd == null) {
      jdField_a_of_type_Awnd = new awnd();
    }
    return jdField_a_of_type_Awnd;
  }
  
  private void a(Context paramContext)
  {
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TencentVideoSDKManager", 2, "initSDK(): TVK_SDKMgr not inited, TVK_SDKMgr.initSdk");
        }
        TVK_SDKMgr.setDebugEnable(true);
        TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
        TVK_SDKMgr.setOnLogListener(new awne(null));
        jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private void b(Context paramContext, awng paramawng)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 87	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:isInstalled	(Landroid/content/Context;)Z
    //   6: ifne +74 -> 80
    //   9: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +30 -> 42
    //   15: ldc 45
    //   17: iconst_2
    //   18: new 89	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   25: ldc 92
    //   27: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: getstatic 20	awnd:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   33: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: getstatic 26	awnd:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   45: aload_2
    //   46: invokevirtual 107	java/util/concurrent/CopyOnWriteArraySet:add	(Ljava/lang/Object;)Z
    //   49: pop
    //   50: getstatic 20	awnd:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   53: invokevirtual 110	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   56: istore_3
    //   57: iload_3
    //   58: ifne +22 -> 80
    //   61: aload_1
    //   62: new 112	awnf
    //   65: dup
    //   66: aconst_null
    //   67: invokespecial 113	awnf:<init>	(Lcom/tencent/mobileqq/shortvideo/videoplayer/TencentVideoSDKManager$1;)V
    //   70: invokestatic 117	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:installPlugin	(Landroid/content/Context;Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;)V
    //   73: getstatic 20	awnd:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   76: iconst_1
    //   77: invokevirtual 120	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -7 -> 80
    //   90: ldc 45
    //   92: iconst_2
    //   93: ldc 122
    //   95: aload_1
    //   96: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: goto -19 -> 80
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	awnd
    //   0	107	1	paramContext	Context
    //   0	107	2	paramawng	awng
    //   56	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   61	80	83	java/lang/Exception
    //   2	42	102	finally
    //   42	57	102	finally
    //   61	80	102	finally
    //   84	99	102	finally
  }
  
  public void a(Context paramContext, awng paramawng)
  {
    ThreadManagerV2.excute(new TencentVideoSDKManager.1(this, paramContext, paramawng), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awnd
 * JD-Core Version:    0.7.0.1
 */