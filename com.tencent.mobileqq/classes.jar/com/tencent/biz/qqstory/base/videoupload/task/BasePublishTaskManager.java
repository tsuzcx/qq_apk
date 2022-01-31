package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ney;

public abstract class BasePublishTaskManager
  extends BaseManger
  implements OnPublishTaskListener
{
  public BasePublishTask a;
  public ArrayList a;
  public ArrayList b = new ArrayList();
  
  public BasePublishTaskManager()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a(ErrorMessage paramErrorMessage)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseTaskInfo localBaseTaskInfo = (BaseTaskInfo)localIterator.next();
        localBaseTaskInfo.jdField_a_of_type_Int = 6;
        localBaseTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
        this.b.add(localBaseTaskInfo);
        a(localBaseTaskInfo);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    finally {}
  }
  
  public abstract BasePublishTask a(BaseTaskInfo paramBaseTaskInfo);
  
  public void a() {}
  
  protected void a(BasePublishTask paramBasePublishTask)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == paramBasePublishTask) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask = null;
      }
      return;
    }
    finally
    {
      paramBasePublishTask = finally;
      throw paramBasePublishTask;
    }
  }
  
  public final void a(BasePublishTask paramBasePublishTask, ErrorMessage paramErrorMessage)
  {
    if (paramBasePublishTask == null)
    {
      SLog.e("Q.qqstory.publish.upload:BasePublishTaskManager", "running publish task is null, when finish publish");
      return;
    }
    BaseTaskInfo localBaseTaskInfo = paramBasePublishTask.a();
    paramBasePublishTask.a().jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((localBaseTaskInfo.jdField_a_of_type_Int == 6) || (localBaseTaskInfo.jdField_a_of_type_Int == 5) || (localBaseTaskInfo.jdField_a_of_type_Int == 3) || (localBaseTaskInfo.jdField_a_of_type_Int == 7))
    {
      SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "finish task:" + paramBasePublishTask);
      if (localBaseTaskInfo.jdField_a_of_type_Int != 5) {
        SLog.d("Q.qqstory.publish.upload:BasePublishTaskManager", "task fail:" + paramBasePublishTask);
      }
      if (paramErrorMessage.errorCode != 10406) {
        break label147;
      }
      a(paramBasePublishTask);
      a(paramErrorMessage);
    }
    for (;;)
    {
      b(localBaseTaskInfo, paramErrorMessage);
      a(localBaseTaskInfo);
      return;
      label147:
      a(paramBasePublishTask);
      d();
    }
  }
  
  public abstract void a(BaseTaskInfo paramBaseTaskInfo);
  
  public abstract void a(BaseTaskInfo paramBaseTaskInfo, ErrorMessage paramErrorMessage);
  
  public void a(List paramList)
  {
    try
    {
      this.b.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void b()
  {
    super.b();
    c();
  }
  
  /* Error */
  public void b(BaseTaskInfo paramBaseTaskInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTaskManager:b	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 125	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield 19	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTaskManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   15: aload_1
    //   16: invokevirtual 128	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   19: ifeq +13 -> 32
    //   22: ldc 62
    //   24: ldc 130
    //   26: invokestatic 99	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 19	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTaskManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: aload_1
    //   37: invokevirtual 49	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   40: pop
    //   41: goto -12 -> 29
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	BasePublishTaskManager
    //   0	49	1	paramBaseTaskInfo	BaseTaskInfo
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   32	41	44	finally
  }
  
  protected void b(BaseTaskInfo paramBaseTaskInfo, ErrorMessage paramErrorMessage)
  {
    if (b())
    {
      SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
      return;
    }
    try
    {
      this.b.add(paramBaseTaskInfo);
      a(paramBaseTaskInfo, paramErrorMessage);
      return;
    }
    finally {}
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(BaseTaskInfo paramBaseTaskInfo)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramBaseTaskInfo);
      this.b.remove(paramBaseTaskInfo);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a().equals(paramBaseTaskInfo))) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a();
      }
      return;
    }
    finally
    {
      paramBaseTaskInfo = finally;
      throw paramBaseTaskInfo;
    }
  }
  
  public void d()
  {
    Bosses.get().postLightWeightJob(new ney(this), 10);
  }
  
  public void e()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask != null)
        {
          SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "task waiting list size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
          return;
        }
        if (b())
        {
          SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "manager had stopped");
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label137;
        }
      }
      finally {}
      BaseTaskInfo localBaseTaskInfo = (BaseTaskInfo)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask = a(localBaseTaskInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.a(this);
      SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "start publish task:" + localBaseTaskInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask.run();
      continue;
      label137:
      SLog.c("Q.qqstory.publish.upload:BasePublishTaskManager", "--- no feeds need to post");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BasePublishTaskManager
 * JD-Core Version:    0.7.0.1
 */