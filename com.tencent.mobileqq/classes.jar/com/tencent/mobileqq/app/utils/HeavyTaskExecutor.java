package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class HeavyTaskExecutor
  implements Runnable
{
  private static HeavyTaskExecutor jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor;
  private List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 25	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnull +52 -> 57
    //   8: aload_0
    //   9: monitorenter
    //   10: getstatic 25	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   13: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: invokeinterface 31 1 0
    //   21: ifle +28 -> 49
    //   24: ldc 33
    //   26: iconst_1
    //   27: ldc 35
    //   29: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: getstatic 25	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor	Lcom/tencent/mobileqq/app/utils/HeavyTaskExecutor;
    //   35: ldc2_w 42
    //   38: invokevirtual 47	java/lang/Object:wait	(J)V
    //   41: ldc 33
    //   43: iconst_1
    //   44: ldc 49
    //   46: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: return
    //   58: astore_1
    //   59: goto -18 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	51	0	localHeavyTaskExecutor	HeavyTaskExecutor
    //   52	4	1	localObject	Object
    //   58	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   10	32	52	finally
    //   32	41	52	finally
    //   41	49	52	finally
    //   49	51	52	finally
    //   53	55	52	finally
    //   32	41	58	java/lang/InterruptedException
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor == null)
        {
          jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor = new HeavyTaskExecutor();
          if (QLog.isDevelopLevel()) {
            QLog.d("HeavyTaskExecutor", 4, "init.");
          }
        }
      }
      finally {}
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("asyncExec ");
    ((StringBuilder)???).append(paramRunnable);
    QLog.d("HeavyTaskExecutor", 1, ((StringBuilder)???).toString());
    synchronized (jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor)
    {
      jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor.jdField_a_of_type_JavaUtilList.add(paramRunnable);
      if (jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor.jdField_a_of_type_JavaUtilList.size() == 1) {
        ThreadManager.getSubThreadHandler().post(jdField_a_of_type_ComTencentMobileqqAppUtilsHeavyTaskExecutor);
      }
      return;
    }
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
    //   9: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   12: invokeinterface 31 1 0
    //   17: ifle +130 -> 147
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: iconst_0
    //   27: invokeinterface 96 2 0
    //   32: checkcast 6	java/lang/Runnable
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: new 59	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: ldc 98
    //   49: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_2
    //   54: aload_1
    //   55: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 33
    //   61: iconst_1
    //   62: aload_2
    //   63: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_1
    //   70: invokeinterface 100 1 0
    //   75: aload_0
    //   76: monitorenter
    //   77: aload_0
    //   78: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   81: invokeinterface 31 1 0
    //   86: ifle +14 -> 100
    //   89: aload_0
    //   90: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   93: iconst_0
    //   94: invokeinterface 103 2 0
    //   99: pop
    //   100: aload_0
    //   101: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   104: invokeinterface 31 1 0
    //   109: ifne +18 -> 127
    //   112: ldc 33
    //   114: iconst_1
    //   115: ldc 105
    //   117: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: invokevirtual 108	java/lang/Object:notify	()V
    //   124: aload_0
    //   125: monitorexit
    //   126: return
    //   127: aload_0
    //   128: monitorexit
    //   129: goto -129 -> 0
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    //   137: astore_2
    //   138: goto +87 -> 225
    //   141: astore_2
    //   142: aload_2
    //   143: astore_3
    //   144: goto +70 -> 214
    //   147: aload_3
    //   148: astore_2
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_0
    //   152: monitorenter
    //   153: aload_0
    //   154: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   157: invokeinterface 31 1 0
    //   162: ifle +14 -> 176
    //   165: aload_0
    //   166: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   169: iconst_0
    //   170: invokeinterface 103 2 0
    //   175: pop
    //   176: aload_0
    //   177: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   180: invokeinterface 31 1 0
    //   185: ifne +18 -> 203
    //   188: ldc 33
    //   190: iconst_1
    //   191: ldc 105
    //   193: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: invokevirtual 108	java/lang/Object:notify	()V
    //   200: aload_0
    //   201: monitorexit
    //   202: return
    //   203: aload_0
    //   204: monitorexit
    //   205: return
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: astore_3
    //   212: aload_2
    //   213: astore_1
    //   214: aload_1
    //   215: astore_2
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_3
    //   219: athrow
    //   220: astore_1
    //   221: goto +108 -> 329
    //   224: astore_2
    //   225: invokestatic 55	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   228: ifeq +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 111	java/lang/Throwable:printStackTrace	()V
    //   235: new 59	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   242: astore_3
    //   243: aload_3
    //   244: ldc 113
    //   246: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_3
    //   251: aload_1
    //   252: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: ldc 33
    //   258: iconst_1
    //   259: aload_3
    //   260: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: aload_2
    //   264: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: aload_0
    //   268: monitorenter
    //   269: aload_0
    //   270: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   273: invokeinterface 31 1 0
    //   278: ifle +14 -> 292
    //   281: aload_0
    //   282: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   285: iconst_0
    //   286: invokeinterface 103 2 0
    //   291: pop
    //   292: aload_0
    //   293: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   296: invokeinterface 31 1 0
    //   301: ifne +18 -> 319
    //   304: ldc 33
    //   306: iconst_1
    //   307: ldc 105
    //   309: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_0
    //   313: invokevirtual 108	java/lang/Object:notify	()V
    //   316: aload_0
    //   317: monitorexit
    //   318: return
    //   319: aload_0
    //   320: monitorexit
    //   321: goto -321 -> 0
    //   324: astore_1
    //   325: aload_0
    //   326: monitorexit
    //   327: aload_1
    //   328: athrow
    //   329: aload_0
    //   330: monitorenter
    //   331: aload_0
    //   332: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   335: invokeinterface 31 1 0
    //   340: ifle +14 -> 354
    //   343: aload_0
    //   344: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   347: iconst_0
    //   348: invokeinterface 103 2 0
    //   353: pop
    //   354: aload_0
    //   355: getfield 21	com/tencent/mobileqq/app/utils/HeavyTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   358: invokeinterface 31 1 0
    //   363: ifne +18 -> 381
    //   366: ldc 33
    //   368: iconst_1
    //   369: ldc 105
    //   371: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload_0
    //   375: invokevirtual 108	java/lang/Object:notify	()V
    //   378: aload_0
    //   379: monitorexit
    //   380: return
    //   381: aload_0
    //   382: monitorexit
    //   383: aload_1
    //   384: athrow
    //   385: astore_1
    //   386: aload_0
    //   387: monitorexit
    //   388: goto +5 -> 393
    //   391: aload_1
    //   392: athrow
    //   393: goto -2 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	HeavyTaskExecutor
    //   1	69	1	localRunnable	Runnable
    //   132	4	1	localObject1	Object
    //   206	4	1	localObject2	Object
    //   213	2	1	localObject3	Object
    //   220	32	1	localObject4	Object
    //   324	60	1	localObject5	Object
    //   385	7	1	localObject6	Object
    //   7	56	2	localObject7	Object
    //   137	1	2	localThrowable1	java.lang.Throwable
    //   141	2	2	localObject8	Object
    //   148	68	2	localObject9	Object
    //   224	40	2	localThrowable2	java.lang.Throwable
    //   211	8	3	localObject11	Object
    //   242	18	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	100	132	finally
    //   100	126	132	finally
    //   127	129	132	finally
    //   133	135	132	finally
    //   38	75	137	java/lang/Throwable
    //   36	38	141	finally
    //   153	176	206	finally
    //   176	202	206	finally
    //   203	205	206	finally
    //   207	209	206	finally
    //   8	20	211	finally
    //   22	36	211	finally
    //   149	151	211	finally
    //   216	218	211	finally
    //   4	6	220	finally
    //   38	75	220	finally
    //   218	220	220	finally
    //   225	235	220	finally
    //   235	267	220	finally
    //   4	6	224	java/lang/Throwable
    //   218	220	224	java/lang/Throwable
    //   269	292	324	finally
    //   292	318	324	finally
    //   319	321	324	finally
    //   325	327	324	finally
    //   331	354	385	finally
    //   354	380	385	finally
    //   381	383	385	finally
    //   386	388	385	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.HeavyTaskExecutor
 * JD-Core Version:    0.7.0.1
 */