package com.tencent.mobileqq.armap;

import com.tencent.qphone.base.util.QLog;

class FrameBmpCache$CancelAbleRunnable
  implements Runnable
{
  public int a;
  volatile boolean a;
  
  public FrameBmpCache$CancelAbleRunnable(FrameBmpCache paramFrameBmpCache, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameBmpCache", 2, "cancel");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:jdField_a_of_type_Boolean	Z
    //   4: ifne +118 -> 122
    //   7: aload_0
    //   8: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   11: getfield 47	com/tencent/mobileqq/armap/FrameBmpCache:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   14: aload_0
    //   15: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   18: aload_0
    //   19: getfield 22	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:jdField_a_of_type_Int	I
    //   22: invokestatic 50	com/tencent/mobileqq/armap/FrameBmpCache:a	(Lcom/tencent/mobileqq/armap/FrameBmpCache;I)I
    //   25: invokeinterface 56 2 0
    //   30: checkcast 58	java/lang/String
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   38: getfield 61	com/tencent/mobileqq/armap/FrameBmpCache:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   41: aload_1
    //   42: invokevirtual 66	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: ifnonnull +138 -> 183
    //   48: aload_0
    //   49: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   52: aload_1
    //   53: invokestatic 69	com/tencent/mobileqq/armap/FrameBmpCache:a	(Lcom/tencent/mobileqq/armap/FrameBmpCache;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   56: astore_2
    //   57: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +49 -> 109
    //   63: ldc 31
    //   65: iconst_2
    //   66: new 71	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   73: ldc 74
    //   75: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: getfield 22	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:jdField_a_of_type_Int	I
    //   82: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc 83
    //   87: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 85
    //   96: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 37	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   113: getfield 61	com/tencent/mobileqq/armap/FrameBmpCache:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   116: aload_1
    //   117: aload_2
    //   118: invokevirtual 96	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +31 -> 156
    //   128: ldc 31
    //   130: iconst_2
    //   131: new 71	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   138: ldc 98
    //   140: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: getfield 22	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:jdField_a_of_type_Int	I
    //   147: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 37	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: getfield 20	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:jdField_a_of_type_Boolean	Z
    //   160: ifne +22 -> 182
    //   163: aload_0
    //   164: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   167: getfield 101	com/tencent/mobileqq/armap/FrameBmpCache:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   170: astore_1
    //   171: aload_1
    //   172: monitorenter
    //   173: aload_0
    //   174: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   177: invokestatic 104	com/tencent/mobileqq/armap/FrameBmpCache:a	(Lcom/tencent/mobileqq/armap/FrameBmpCache;)V
    //   180: aload_1
    //   181: monitorexit
    //   182: return
    //   183: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq -64 -> 122
    //   189: ldc 31
    //   191: iconst_2
    //   192: new 71	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   199: ldc 74
    //   201: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: getfield 22	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:jdField_a_of_type_Int	I
    //   208: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc 106
    //   213: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_1
    //   217: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 37	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -104 -> 122
    //   229: astore_1
    //   230: aload_0
    //   231: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   234: iconst_1
    //   235: invokestatic 109	com/tencent/mobileqq/armap/FrameBmpCache:b	(Lcom/tencent/mobileqq/armap/FrameBmpCache;I)I
    //   238: pop
    //   239: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq -120 -> 122
    //   245: ldc 31
    //   247: iconst_2
    //   248: new 71	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   255: ldc 111
    //   257: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_0
    //   261: getfield 22	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:jdField_a_of_type_Int	I
    //   264: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: goto -151 -> 122
    //   276: astore_1
    //   277: aload_0
    //   278: getfield 15	com/tencent/mobileqq/armap/FrameBmpCache$CancelAbleRunnable:this$0	Lcom/tencent/mobileqq/armap/FrameBmpCache;
    //   281: iconst_2
    //   282: invokestatic 109	com/tencent/mobileqq/armap/FrameBmpCache:b	(Lcom/tencent/mobileqq/armap/FrameBmpCache;I)I
    //   285: pop
    //   286: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq -167 -> 122
    //   292: ldc 31
    //   294: iconst_2
    //   295: ldc 116
    //   297: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: goto -178 -> 122
    //   303: astore_2
    //   304: aload_1
    //   305: monitorexit
    //   306: aload_2
    //   307: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	CancelAbleRunnable
    //   229	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   276	29	1	localThrowable	java.lang.Throwable
    //   56	62	2	localBitmap	android.graphics.Bitmap
    //   303	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	109	229	java/lang/OutOfMemoryError
    //   109	122	229	java/lang/OutOfMemoryError
    //   183	226	229	java/lang/OutOfMemoryError
    //   7	109	276	java/lang/Throwable
    //   109	122	276	java/lang/Throwable
    //   183	226	276	java/lang/Throwable
    //   173	182	303	finally
    //   304	306	303	finally
  }
  
  public String toString()
  {
    return Integer.toString(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.FrameBmpCache.CancelAbleRunnable
 * JD-Core Version:    0.7.0.1
 */