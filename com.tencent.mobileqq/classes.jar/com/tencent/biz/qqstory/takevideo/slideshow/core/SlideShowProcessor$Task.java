package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import zga;
import zgv;
import zgz;
import zha;
import zhb;
import zhd;
import zhe;
import zhg;

public class SlideShowProcessor$Task
  implements Runnable
{
  long jdField_a_of_type_Long;
  private Queue<zhb> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  protected AtomicLong a;
  private zgv jdField_a_of_type_Zgv = new zgv(true);
  public zhb a;
  private zhd jdField_a_of_type_Zhd = new zhd();
  private zhg jdField_a_of_type_Zhg = new zhg();
  private boolean jdField_a_of_type_Boolean = true;
  long b;
  
  public SlideShowProcessor$Task()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  }
  
  /* Error */
  private zhb a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 33	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   21: invokeinterface 60 1 0
    //   26: ifeq +13 -> 39
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 33	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   34: ldc 62
    //   36: invokespecial 65	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:a	(Ljava/util/Queue;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 33	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   43: invokeinterface 68 1 0
    //   48: checkcast 70	zhb
    //   51: astore_1
    //   52: goto -39 -> 13
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	Task
    //   6	46	1	localObject1	Object
    //   55	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   17	39	55	finally
    //   39	52	55	finally
  }
  
  private void a(Queue<zhb> paramQueue, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PendingTask : " + paramString);
    if ((paramQueue != null) && (paramQueue.size() > 0))
    {
      paramQueue = paramQueue.iterator();
      while (paramQueue.hasNext())
      {
        paramString = (zhb)paramQueue.next();
        localStringBuilder.append("\n");
        if ((paramString instanceof zgz))
        {
          paramString = (zgz)paramString;
          if ((paramString.a != null) && (paramString.a.jdField_b_of_type_JavaLangString != null)) {
            localStringBuilder.append(paramString.a.jdField_b_of_type_JavaLangString);
          } else {
            localStringBuilder.append("null");
          }
        }
        else if ((paramString instanceof zhe))
        {
          paramString = new zhe();
          localStringBuilder.append("merge task");
          if ((paramString.a != null) && (paramString.a.size() > 0))
          {
            localStringBuilder.append(" : ");
            paramString = paramString.a.iterator();
            while (paramString.hasNext())
            {
              localStringBuilder.append(((SlideItemInfo)paramString.next()).jdField_b_of_type_JavaLangString);
              localStringBuilder.append("  ----  ");
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessorTask", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    for (;;)
    {
      zhb localzhb;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localzhb = (zhb)localIterator.next();
        zga localzga = new zga();
        localzga.jdField_a_of_type_Int = 2;
        localzga.jdField_a_of_type_Long = localzhb.b;
        localzga.jdField_a_of_type_Boolean = false;
        localzga.jdField_b_of_type_Int = 1;
        if (localzhb.a != null)
        {
          localzhb.a.a(localzga);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.d("SlideShowProcessorTask", 2, "listener is null, taskContext Type : " + localzhb.getClass().getSimpleName());
    }
    a(this.jdField_a_of_type_JavaUtilQueue, "stopAll");
    this.jdField_a_of_type_JavaUtilQueue.clear();
    b();
  }
  
  public void a(String paramString)
  {
    boolean bool;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowProcessorTask", 2, "stopByPath begin");
        }
        bool = TextUtils.isEmpty(paramString);
        if (bool) {
          label25:
          return;
        }
        if ((this.jdField_a_of_type_Zhb != null) && ((this.jdField_a_of_type_Zhb instanceof zgz)) && (((zgz)this.jdField_a_of_type_Zhb).a.jdField_b_of_type_JavaLangString.equals(paramString)))
        {
          b();
          label68:
          a(this.jdField_a_of_type_JavaUtilQueue, "stopByPath");
          break label25;
        }
        localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      }
      finally {}
      Iterator localIterator;
      if (localIterator.hasNext())
      {
        zhb localzhb = (zhb)localIterator.next();
        if ((!(localzhb instanceof zgz)) || (!((zgz)localzhb).a.jdField_b_of_type_JavaLangString.equals(paramString))) {
          break label68;
        }
        this.jdField_a_of_type_JavaUtilQueue.remove(localzhb);
      }
    }
  }
  
  public void a(List<zhb> paramList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilQueue.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void a(zhb paramzhb)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilQueue.add(paramzhb);
        if (QLog.isColorLevel())
        {
          if ((paramzhb instanceof zhe)) {
            QLog.d("SlideShowProcessorTask", 2, "add merge context");
          }
        }
        else {
          return;
        }
        if ((paramzhb instanceof zgz)) {
          if (((zgz)paramzhb).a == null) {
            QLog.d("SlideShowProcessorTask", 2, "add convertContext itemInfo is null");
          } else {
            QLog.d("SlideShowProcessorTask", 2, "add convertContext : " + ((zgz)paramzhb).a.jdField_b_of_type_JavaLangString);
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   21: ifnull +51 -> 72
    //   24: aload_0
    //   25: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   28: instanceof 100
    //   31: ifeq +41 -> 72
    //   34: aload_0
    //   35: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   38: checkcast 100	zgz
    //   41: getfield 103	zgz:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
    //   44: ifnull +28 -> 72
    //   47: aload_1
    //   48: aload_0
    //   49: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   52: checkcast 100	zgz
    //   55: getfield 103	zgz:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
    //   58: getfield 108	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   61: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   64: ifeq +8 -> 72
    //   67: iconst_1
    //   68: istore_2
    //   69: goto -56 -> 13
    //   72: aload_0
    //   73: getfield 33	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   76: invokeinterface 87 1 0
    //   81: astore_3
    //   82: aload_3
    //   83: invokeinterface 93 1 0
    //   88: ifeq +47 -> 135
    //   91: aload_3
    //   92: invokeinterface 96 1 0
    //   97: checkcast 70	zhb
    //   100: astore 4
    //   102: aload 4
    //   104: instanceof 100
    //   107: ifeq -25 -> 82
    //   110: aload 4
    //   112: checkcast 100	zgz
    //   115: getfield 103	zgz:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
    //   118: getfield 108	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   121: aload_1
    //   122: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: istore_2
    //   126: iload_2
    //   127: ifeq -45 -> 82
    //   130: iconst_1
    //   131: istore_2
    //   132: goto -119 -> 13
    //   135: iconst_0
    //   136: istore_2
    //   137: goto -124 -> 13
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	Task
    //   0	145	1	paramString	String
    //   6	131	2	bool	boolean
    //   81	11	3	localIterator	Iterator
    //   100	11	4	localzhb	zhb
    // Exception table:
    //   from	to	target	type
    //   2	7	140	finally
    //   17	67	140	finally
    //   72	82	140	finally
    //   82	126	140	finally
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessorTask", 2, "stopPeek begin");
      }
      if ((this.jdField_a_of_type_Zhb != null) && (this.jdField_a_of_type_Zhb.d == true) && (this.jdField_a_of_type_Boolean))
      {
        zhb localzhb = this.jdField_a_of_type_Zhb;
        this.jdField_a_of_type_Zhb.d = false;
        zga localzga = new zga();
        localzga.jdField_a_of_type_Long = localzhb.b;
        localzga.jdField_a_of_type_Boolean = false;
        localzga.jdField_b_of_type_Int = 1;
        if (localzhb.a != null) {
          localzhb.a.a(localzga);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessorTask", 2, "stopPeek end");
      }
      a(this.jdField_a_of_type_JavaUtilQueue, "stopPeek");
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 133
    //   8: iconst_2
    //   9: ldc 232
    //   11: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 35	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Boolean	Z
    //   18: ifeq +510 -> 528
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: aload_0
    //   25: invokespecial 234	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:a	()Lzhb;
    //   28: putfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   37: ifnull +132 -> 169
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   46: iconst_1
    //   47: putfield 221	zhb:d	Z
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_0
    //   53: getfield 28	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   56: lconst_1
    //   57: invokevirtual 238	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   60: lstore_1
    //   61: aload_0
    //   62: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   65: lload_1
    //   66: putfield 147	zhb:b	J
    //   69: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +28 -> 100
    //   75: ldc 133
    //   77: iconst_2
    //   78: new 72	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   85: ldc 240
    //   87: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: lload_1
    //   91: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   104: instanceof 112
    //   107: ifeq +219 -> 326
    //   110: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +11 -> 124
    //   116: ldc 133
    //   118: iconst_2
    //   119: ldc 245
    //   121: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_0
    //   125: getfield 52	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhd	Lzhd;
    //   128: aload_0
    //   129: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   132: checkcast 112	zhe
    //   135: invokevirtual 248	zhd:a	(Lzhe;)V
    //   138: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +11 -> 152
    //   144: ldc 133
    //   146: iconst_2
    //   147: ldc 250
    //   149: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_0
    //   153: monitorenter
    //   154: aload_0
    //   155: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   158: iconst_0
    //   159: putfield 221	zhb:d	Z
    //   162: aload_0
    //   163: aconst_null
    //   164: putfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_0
    //   170: monitorenter
    //   171: aload_0
    //   172: invokevirtual 253	java/lang/Object:notifyAll	()V
    //   175: aload_0
    //   176: monitorexit
    //   177: ldc2_w 254
    //   180: invokestatic 260	java/lang/Thread:sleep	(J)V
    //   183: goto -169 -> 14
    //   186: astore_3
    //   187: aload_3
    //   188: invokestatic 265	bkgg:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   191: astore_3
    //   192: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -181 -> 14
    //   198: ldc 133
    //   200: iconst_2
    //   201: aload_3
    //   202: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: goto -191 -> 14
    //   208: astore_3
    //   209: aload_3
    //   210: invokestatic 265	bkgg:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   213: astore_3
    //   214: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +29 -> 246
    //   220: ldc 133
    //   222: iconst_2
    //   223: new 72	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 267
    //   233: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_3
    //   237: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload_0
    //   247: monitorenter
    //   248: aload_0
    //   249: invokevirtual 253	java/lang/Object:notifyAll	()V
    //   252: aload_0
    //   253: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   256: ifnull +16 -> 272
    //   259: aload_0
    //   260: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   263: iconst_0
    //   264: putfield 221	zhb:d	Z
    //   267: aload_0
    //   268: aconst_null
    //   269: putfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   272: aload_0
    //   273: monitorexit
    //   274: aload_0
    //   275: iconst_0
    //   276: putfield 35	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Boolean	Z
    //   279: return
    //   280: astore_3
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_3
    //   284: athrow
    //   285: astore_3
    //   286: aload_0
    //   287: monitorenter
    //   288: aload_0
    //   289: invokevirtual 253	java/lang/Object:notifyAll	()V
    //   292: aload_0
    //   293: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   296: ifnull +16 -> 312
    //   299: aload_0
    //   300: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   303: iconst_0
    //   304: putfield 221	zhb:d	Z
    //   307: aload_0
    //   308: aconst_null
    //   309: putfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   312: aload_0
    //   313: monitorexit
    //   314: aload_0
    //   315: iconst_0
    //   316: putfield 35	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Boolean	Z
    //   319: aload_3
    //   320: athrow
    //   321: astore_3
    //   322: aload_0
    //   323: monitorexit
    //   324: aload_3
    //   325: athrow
    //   326: aload_0
    //   327: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   330: checkcast 100	zgz
    //   333: getfield 103	zgz:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
    //   336: getfield 268	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Int	I
    //   339: ifne +91 -> 430
    //   342: aload_0
    //   343: invokestatic 274	java/lang/System:currentTimeMillis	()J
    //   346: putfield 275	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Long	J
    //   349: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +29 -> 381
    //   355: ldc 133
    //   357: iconst_2
    //   358: new 72	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 277
    //   368: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: lload_1
    //   372: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload_0
    //   382: getfield 42	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zgv	Lzgv;
    //   385: aload_0
    //   386: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   389: checkcast 100	zgz
    //   392: invokevirtual 280	zgv:a	(Lzgz;)V
    //   395: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq -246 -> 152
    //   401: ldc 133
    //   403: iconst_2
    //   404: new 72	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 282
    //   414: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: lload_1
    //   418: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   421: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: goto -275 -> 152
    //   430: aload_0
    //   431: invokestatic 274	java/lang/System:currentTimeMillis	()J
    //   434: putfield 283	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:b	J
    //   437: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +29 -> 469
    //   443: ldc 133
    //   445: iconst_2
    //   446: new 72	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 285
    //   456: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: lload_1
    //   460: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_0
    //   470: getfield 47	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhg	Lzhg;
    //   473: aload_0
    //   474: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   477: checkcast 100	zgz
    //   480: invokevirtual 286	zhg:a	(Lzgz;)V
    //   483: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq -334 -> 152
    //   489: ldc 133
    //   491: iconst_2
    //   492: new 72	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 288
    //   502: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: lload_1
    //   506: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   509: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: goto -363 -> 152
    //   518: astore_3
    //   519: aload_0
    //   520: monitorexit
    //   521: aload_3
    //   522: athrow
    //   523: astore_3
    //   524: aload_0
    //   525: monitorexit
    //   526: aload_3
    //   527: athrow
    //   528: aload_0
    //   529: monitorenter
    //   530: aload_0
    //   531: invokevirtual 253	java/lang/Object:notifyAll	()V
    //   534: aload_0
    //   535: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   538: ifnull +16 -> 554
    //   541: aload_0
    //   542: getfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   545: iconst_0
    //   546: putfield 221	zhb:d	Z
    //   549: aload_0
    //   550: aconst_null
    //   551: putfield 189	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Zhb	Lzhb;
    //   554: aload_0
    //   555: monitorexit
    //   556: aload_0
    //   557: iconst_0
    //   558: putfield 35	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Boolean	Z
    //   561: return
    //   562: astore_3
    //   563: aload_0
    //   564: monitorexit
    //   565: aload_3
    //   566: athrow
    //   567: astore_3
    //   568: aload_0
    //   569: monitorexit
    //   570: aload_3
    //   571: athrow
    //   572: astore_3
    //   573: aload_0
    //   574: monitorexit
    //   575: aload_3
    //   576: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	Task
    //   60	446	1	l	long
    //   186	2	3	localInterruptedException	java.lang.InterruptedException
    //   191	11	3	str1	String
    //   208	2	3	localException	java.lang.Exception
    //   213	24	3	str2	String
    //   280	4	3	localObject1	Object
    //   285	35	3	localObject2	Object
    //   321	4	3	localObject3	Object
    //   518	4	3	localObject4	Object
    //   523	4	3	localObject5	Object
    //   562	4	3	localObject6	Object
    //   567	4	3	localObject7	Object
    //   572	4	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   177	183	186	java/lang/InterruptedException
    //   14	23	208	java/lang/Exception
    //   33	42	208	java/lang/Exception
    //   52	100	208	java/lang/Exception
    //   100	124	208	java/lang/Exception
    //   124	152	208	java/lang/Exception
    //   152	154	208	java/lang/Exception
    //   169	171	208	java/lang/Exception
    //   177	183	208	java/lang/Exception
    //   187	205	208	java/lang/Exception
    //   283	285	208	java/lang/Exception
    //   324	326	208	java/lang/Exception
    //   326	381	208	java/lang/Exception
    //   381	427	208	java/lang/Exception
    //   430	469	208	java/lang/Exception
    //   469	515	208	java/lang/Exception
    //   521	523	208	java/lang/Exception
    //   526	528	208	java/lang/Exception
    //   23	33	280	finally
    //   281	283	280	finally
    //   14	23	285	finally
    //   33	42	285	finally
    //   52	100	285	finally
    //   100	124	285	finally
    //   124	152	285	finally
    //   152	154	285	finally
    //   169	171	285	finally
    //   177	183	285	finally
    //   187	205	285	finally
    //   209	246	285	finally
    //   283	285	285	finally
    //   324	326	285	finally
    //   326	381	285	finally
    //   381	427	285	finally
    //   430	469	285	finally
    //   469	515	285	finally
    //   521	523	285	finally
    //   526	528	285	finally
    //   42	52	321	finally
    //   322	324	321	finally
    //   154	169	518	finally
    //   519	521	518	finally
    //   171	177	523	finally
    //   524	526	523	finally
    //   530	554	562	finally
    //   554	556	562	finally
    //   563	565	562	finally
    //   248	272	567	finally
    //   272	274	567	finally
    //   568	570	567	finally
    //   288	312	572	finally
    //   312	314	572	finally
    //   573	575	572	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.Task
 * JD-Core Version:    0.7.0.1
 */