package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

@Deprecated
public class ParallelStepExecutor
  extends SimpleStepExector
  implements Handler.Callback
{
  public volatile int a;
  protected Handler a;
  protected ErrorMessage a;
  private String a;
  protected LinkedHashMap a;
  protected Vector a;
  protected boolean a;
  private Handler b = new Handler(paramLooper, this);
  private Handler c;
  
  public ParallelStepExecutor(Looper paramLooper)
  {
    this.jdField_a_of_type_JavaLangString = "ParallelStepExecutor";
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Int = 0;
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {
      SLog.e("Q.qqstory.home.ParallelStepExecutor", "occur error ! step key is null!!");
    }
    do
    {
      return;
      SLog.e("Q.qqstory.home.ParallelStepExecutor", "%s have been finish", new Object[] { paramString });
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
    } while (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() != 0);
    SLog.b("Q.qqstory.home.ParallelStepExecutor", "all step have finish");
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler != null)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      if (!this.jdField_a_of_type_Boolean) {
        break label99;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$ErrorHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    }
    for (;;)
    {
      d();
      return;
      label99:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler.a();
    }
  }
  
  public ParallelStepExecutor a(SimpleStepExector.CompletedHandler paramCompletedHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler = paramCompletedHandler;
    return this;
  }
  
  public ParallelStepExecutor a(SimpleStepExector.ErrorHandler paramErrorHandler)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$ErrorHandler = paramErrorHandler;
    return this;
  }
  
  public ParallelStepExecutor a(Step paramStep)
  {
    SLog.a("Q.qqstory.home.ParallelStepExecutor", "add Step:%s", paramStep.a());
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramStep.a(), paramStep);
    this.jdField_a_of_type_Int = 0;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 59
    //   4: ldc 131
    //   6: iconst_1
    //   7: anewarray 71	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 31	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/ParallelStepExecutor:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   16: invokevirtual 82	java/util/LinkedHashMap:size	()I
    //   19: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic 139	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 50	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/ParallelStepExecutor:jdField_a_of_type_Int	I
    //   30: iconst_2
    //   31: if_icmpne +13 -> 44
    //   34: ldc 59
    //   36: ldc 141
    //   38: invokestatic 67	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 50	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/ParallelStepExecutor:jdField_a_of_type_Int	I
    //   49: aload_0
    //   50: getfield 143	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/ParallelStepExecutor:c	Landroid/os/Handler;
    //   53: ifnonnull +18 -> 71
    //   56: aload_0
    //   57: new 38	android/os/Handler
    //   60: dup
    //   61: invokestatic 146	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   64: aload_0
    //   65: invokespecial 53	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   68: putfield 143	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/ParallelStepExecutor:c	Landroid/os/Handler;
    //   71: aload_0
    //   72: getfield 31	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/ParallelStepExecutor:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   75: invokevirtual 150	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   78: invokeinterface 156 1 0
    //   83: astore_1
    //   84: aload_1
    //   85: invokeinterface 162 1 0
    //   90: ifeq -49 -> 41
    //   93: aload_1
    //   94: invokeinterface 166 1 0
    //   99: checkcast 168	java/util/Map$Entry
    //   102: invokeinterface 171 1 0
    //   107: checkcast 119	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/Step
    //   110: astore_2
    //   111: aload_2
    //   112: aload_0
    //   113: invokeinterface 174 2 0
    //   118: aload_2
    //   119: aload_0
    //   120: invokeinterface 177 2 0
    //   125: aload_0
    //   126: getfield 55	com/tencent/biz/qqstory/storyHome/qqstorylist/model/request/ParallelStepExecutor:b	Landroid/os/Handler;
    //   129: iconst_2
    //   130: aload_2
    //   131: invokevirtual 181	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   134: invokevirtual 186	android/os/Message:sendToTarget	()V
    //   137: goto -53 -> 84
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	ParallelStepExecutor
    //   83	11	1	localIterator	Iterator
    //   140	4	1	localObject	Object
    //   110	21	2	localStep	Step
    // Exception table:
    //   from	to	target	type
    //   2	41	140	finally
    //   44	71	140	finally
    //   71	84	140	finally
    //   84	137	140	finally
  }
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("Q.qqstory.home.ParallelStepExecutor", "occur error:%s", new Object[] { paramErrorMessage.getErrorMessage() });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    a(paramErrorMessage.extraMsg);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_Int;
        if (i == 3) {
          return;
        }
        if (this.c != null)
        {
          this.c.obtainMessage(1, paramString).sendToTarget();
          continue;
        }
        SLog.e("Q.qqstory.home.ParallelStepExecutor", "there is no mCompletedHandler !!!!");
      }
      finally {}
      b(paramString);
    }
  }
  
  public void b() {}
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      if (this.c != null) {
        this.c.removeMessages(1);
      }
      if (this.b != null) {
        this.b.removeMessages(2);
      }
      SLog.b("Q.qqstory.home.ParallelStepExecutor", "reset!");
      if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
      {
        SLog.b("Q.qqstory.home.ParallelStepExecutor", "reset premissSteps");
        ((Step)this.jdField_a_of_type_JavaUtilVector.get(0)).c();
        this.jdField_a_of_type_JavaUtilVector.clear();
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Step localStep = (Step)((Map.Entry)localIterator.next()).getValue();
        if (localStep != null) {
          localStep.c();
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    finally {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b((String)paramMessage.obj);
      continue;
      ((Step)paramMessage.obj).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.ParallelStepExecutor
 * JD-Core Version:    0.7.0.1
 */