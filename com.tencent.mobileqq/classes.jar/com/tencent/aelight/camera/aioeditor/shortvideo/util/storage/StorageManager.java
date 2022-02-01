package com.tencent.aelight.camera.aioeditor.shortvideo.util.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class StorageManager
{
  public static long a = 57671680L;
  static StorageManager jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager;
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static long b = 209715200L;
  final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new StorageManager.1(this);
  StorageManager.OnSdCardChangedListener jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager$OnSdCardChangedListener;
  public String a;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean;
  public String b = "";
  long c = 0L;
  
  StorageManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    b();
    a();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addDataScheme("file");
    VideoEnvironment.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static StorageManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager = new StorageManager();
        }
      }
    }
    return jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager;
  }
  
  /* Error */
  static boolean a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 101	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: invokevirtual 105	java/lang/Thread:getId	()J
    //   6: lstore_1
    //   7: new 107	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   14: astore 5
    //   16: aload 5
    //   18: aload_0
    //   19: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 5
    //   25: ldc 114
    //   27: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 5
    //   33: lload_1
    //   34: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: new 119	java/io/File
    //   41: dup
    //   42: aload 5
    //   44: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_0
    //   51: iconst_0
    //   52: istore 4
    //   54: aload_0
    //   55: invokevirtual 129	java/io/File:exists	()Z
    //   58: ifeq +21 -> 79
    //   61: iload 4
    //   63: istore_3
    //   64: aload_0
    //   65: invokevirtual 132	java/io/File:delete	()Z
    //   68: ifeq +34 -> 102
    //   71: aload_0
    //   72: invokevirtual 135	java/io/File:createNewFile	()Z
    //   75: istore_3
    //   76: goto +26 -> 102
    //   79: aload_0
    //   80: invokevirtual 135	java/io/File:createNewFile	()Z
    //   83: istore_3
    //   84: goto +18 -> 102
    //   87: astore 5
    //   89: goto +20 -> 109
    //   92: astore 5
    //   94: aload 5
    //   96: invokevirtual 138	java/lang/Throwable:printStackTrace	()V
    //   99: iload 4
    //   101: istore_3
    //   102: aload_0
    //   103: invokevirtual 132	java/io/File:delete	()Z
    //   106: pop
    //   107: iload_3
    //   108: ireturn
    //   109: aload_0
    //   110: invokevirtual 132	java/io/File:delete	()Z
    //   113: pop
    //   114: aload 5
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   6	28	1	l	long
    //   63	45	3	bool1	boolean
    //   52	48	4	bool2	boolean
    //   14	29	5	localStringBuilder	StringBuilder
    //   87	1	5	localObject	Object
    //   92	23	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   54	61	87	finally
    //   64	76	87	finally
    //   79	84	87	finally
    //   94	99	87	finally
    //   54	61	92	java/lang/Throwable
    //   64	76	92	java/lang/Throwable
    //   79	84	92	java/lang/Throwable
  }
  
  void a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("/Android/data/com.tencent.mobileqq/qq/video");
    this.b = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateStorePath:storeVideoPath=");
      ((StringBuilder)localObject).append(this.b);
      QLog.e("TAG", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateStorePath:maxAvailableSizePath=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.e("TAG", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new File(this.b);
      if (((File)localObject).exists()) {
        break label147;
      }
      ((File)localObject).mkdirs();
      return;
    }
    catch (Exception localException)
    {
      label142:
      label147:
      break label142;
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaLangString = "";
      this.c = 0L;
      Object localObject1 = Environment.getExternalStorageDirectory().getAbsolutePath();
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(localObject1)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("external_card", localObject1);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        try
        {
          Object localObject3 = new File(str);
          if ((((File)localObject3).exists()) && (((File)localObject3).canWrite()) && (a(str)))
          {
            localObject3 = new StatFs(str);
            long l = ((StatFs)localObject3).getAvailableBlocks() * ((StatFs)localObject3).getBlockSize();
            if ((l > 0L) && (this.c < l))
            {
              this.c = l;
              this.jdField_a_of_type_JavaLangString = str;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.storage.StorageManager
 * JD-Core Version:    0.7.0.1
 */