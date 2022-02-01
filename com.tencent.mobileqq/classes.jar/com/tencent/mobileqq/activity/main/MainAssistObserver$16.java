package com.tencent.mobileqq.activity.main;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.concurrent.atomic.AtomicInteger;

class MainAssistObserver$16
  implements LebaTabRedTouch.RefreshCallback
{
  MainAssistObserver$16(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    boolean bool = true;
    Object localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)localObject).obj = paramRedTypeInfo;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    localObject = ReadinjoySPEventReport.a();
    if (paramRedTypeInfo != null) {}
    for (;;)
    {
      ((ReadinjoySPEventReport)localObject).b(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.16
 * JD-Core Version:    0.7.0.1
 */