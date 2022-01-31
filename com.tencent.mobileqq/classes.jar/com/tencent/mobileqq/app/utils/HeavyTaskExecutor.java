package com.tencent.mobileqq.app.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class HeavyTaskExecutor
  implements Runnable
{
  private static HeavyTaskExecutor jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor != null)
    {
      synchronized (jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor)
      {
        if (jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor.jdField_a_of_type_JavaUtilList.size() > 0) {
          QLog.d("HeavyTaskExecutor", 1, "wait begin.");
        }
      }
      try
      {
        jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor.wait(3000L);
        label43:
        QLog.d("HeavyTaskExecutor", 1, "wait over.");
        return;
        localObject = finally;
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label43;
      }
    }
  }
  
  /* Error */
  public static void a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: getstatic 23	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   3: ifnonnull +39 -> 42
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 23	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   12: ifnonnull +27 -> 39
    //   15: new 2	com/tencent/mobileqq/app/utils/HeavyTaskExecutor
    //   18: dup
    //   19: invokespecial 49	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:<init>	()V
    //   22: putstatic 23	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   25: invokestatic 53	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 31
    //   33: iconst_4
    //   34: ldc 55
    //   36: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: ldc 2
    //   41: monitorexit
    //   42: ldc 31
    //   44: iconst_1
    //   45: new 57	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   52: ldc 60
    //   54: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: getstatic 23	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   70: astore_1
    //   71: aload_1
    //   72: monitorenter
    //   73: getstatic 23	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   76: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   79: aload_0
    //   80: invokeinterface 75 2 0
    //   85: pop
    //   86: getstatic 23	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   89: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   92: invokeinterface 29 1 0
    //   97: iconst_1
    //   98: if_icmpne +13 -> 111
    //   101: invokestatic 81	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   104: getstatic 23	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   107: invokevirtual 87	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   110: pop
    //   111: aload_1
    //   112: monitorexit
    //   113: return
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: aload_1
    //   122: monitorexit
    //   123: aload_0
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   9	39	114	finally
    //   39	42	114	finally
    //   115	118	114	finally
    //   73	111	120	finally
    //   111	113	120	finally
    //   121	123	120	finally
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_3
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   12: invokeinterface 29 1 0
    //   17: ifle +104 -> 121
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: iconst_0
    //   27: invokeinterface 94 2 0
    //   32: checkcast 6	java/lang/Runnable
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: ldc 31
    //   40: iconst_1
    //   41: new 57	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   48: ldc 96
    //   50: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_1
    //   64: invokeinterface 98 1 0
    //   69: aload_0
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   75: invokeinterface 29 1 0
    //   80: ifle +14 -> 94
    //   83: aload_0
    //   84: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   87: iconst_0
    //   88: invokeinterface 101 2 0
    //   93: pop
    //   94: aload_0
    //   95: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   98: invokeinterface 29 1 0
    //   103: ifne +185 -> 288
    //   106: ldc 31
    //   108: iconst_1
    //   109: ldc 103
    //   111: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_0
    //   115: invokevirtual 106	java/lang/Object:notify	()V
    //   118: aload_0
    //   119: monitorexit
    //   120: return
    //   121: aload_3
    //   122: astore_2
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_0
    //   126: monitorenter
    //   127: aload_0
    //   128: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   131: invokeinterface 29 1 0
    //   136: ifle +14 -> 150
    //   139: aload_0
    //   140: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   143: iconst_0
    //   144: invokeinterface 101 2 0
    //   149: pop
    //   150: aload_0
    //   151: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   154: invokeinterface 29 1 0
    //   159: ifne +23 -> 182
    //   162: ldc 31
    //   164: iconst_1
    //   165: ldc 103
    //   167: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 106	java/lang/Object:notify	()V
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: aload_0
    //   183: monitorexit
    //   184: return
    //   185: astore_3
    //   186: aload_2
    //   187: astore_1
    //   188: aload_1
    //   189: astore_2
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_3
    //   193: athrow
    //   194: astore_2
    //   195: invokestatic 53	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   198: ifeq +7 -> 205
    //   201: aload_2
    //   202: invokevirtual 109	java/lang/Throwable:printStackTrace	()V
    //   205: ldc 31
    //   207: iconst_1
    //   208: new 57	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   215: ldc 111
    //   217: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: aload_2
    //   228: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_0
    //   232: monitorenter
    //   233: aload_0
    //   234: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   237: invokeinterface 29 1 0
    //   242: ifle +14 -> 256
    //   245: aload_0
    //   246: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   249: iconst_0
    //   250: invokeinterface 101 2 0
    //   255: pop
    //   256: aload_0
    //   257: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   260: invokeinterface 29 1 0
    //   265: ifne +33 -> 298
    //   268: ldc 31
    //   270: iconst_1
    //   271: ldc 103
    //   273: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: invokevirtual 106	java/lang/Object:notify	()V
    //   280: aload_0
    //   281: monitorexit
    //   282: return
    //   283: astore_1
    //   284: aload_0
    //   285: monitorexit
    //   286: aload_1
    //   287: athrow
    //   288: aload_0
    //   289: monitorexit
    //   290: goto -290 -> 0
    //   293: astore_1
    //   294: aload_0
    //   295: monitorexit
    //   296: aload_1
    //   297: athrow
    //   298: aload_0
    //   299: monitorexit
    //   300: goto -300 -> 0
    //   303: astore_1
    //   304: aload_0
    //   305: monitorenter
    //   306: aload_0
    //   307: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   310: invokeinterface 29 1 0
    //   315: ifle +14 -> 329
    //   318: aload_0
    //   319: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   322: iconst_0
    //   323: invokeinterface 101 2 0
    //   328: pop
    //   329: aload_0
    //   330: getfield 18	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   333: invokeinterface 29 1 0
    //   338: ifne +23 -> 361
    //   341: ldc 31
    //   343: iconst_1
    //   344: ldc 103
    //   346: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_0
    //   350: invokevirtual 106	java/lang/Object:notify	()V
    //   353: aload_0
    //   354: monitorexit
    //   355: return
    //   356: astore_1
    //   357: aload_0
    //   358: monitorexit
    //   359: aload_1
    //   360: athrow
    //   361: aload_0
    //   362: monitorexit
    //   363: aload_1
    //   364: athrow
    //   365: astore_2
    //   366: goto -171 -> 195
    //   369: astore_3
    //   370: goto -182 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	HeavyTaskExecutor
    //   1	63	1	localRunnable	Runnable
    //   177	4	1	localObject1	Object
    //   187	34	1	localObject2	Object
    //   283	4	1	localObject3	Object
    //   293	4	1	localObject4	Object
    //   303	1	1	localObject5	Object
    //   356	8	1	localObject6	Object
    //   7	183	2	localObject7	Object
    //   194	34	2	localThrowable1	java.lang.Throwable
    //   365	1	2	localThrowable2	java.lang.Throwable
    //   3	119	3	localObject8	Object
    //   185	8	3	localObject9	Object
    //   369	1	3	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   127	150	177	finally
    //   150	176	177	finally
    //   178	180	177	finally
    //   182	184	177	finally
    //   8	20	185	finally
    //   22	36	185	finally
    //   123	125	185	finally
    //   190	192	185	finally
    //   4	6	194	java/lang/Throwable
    //   192	194	194	java/lang/Throwable
    //   233	256	283	finally
    //   256	282	283	finally
    //   284	286	283	finally
    //   298	300	283	finally
    //   71	94	293	finally
    //   94	120	293	finally
    //   288	290	293	finally
    //   294	296	293	finally
    //   4	6	303	finally
    //   38	69	303	finally
    //   192	194	303	finally
    //   195	205	303	finally
    //   205	231	303	finally
    //   306	329	356	finally
    //   329	355	356	finally
    //   357	359	356	finally
    //   361	363	356	finally
    //   38	69	365	java/lang/Throwable
    //   36	38	369	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.HeavyTaskExecutor
 * JD-Core Version:    0.7.0.1
 */