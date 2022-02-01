package com.tencent.mobileqq.addon;

import amks;
import amkt;
import amku;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class DiyPendantFetcher$2
  implements Runnable
{
  public DiyPendantFetcher$2(amks paramamks, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2;
    if (!this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "now query mUnCacheDiyId: " + TextUtils.join(",", this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet));
      }
      this.this$0.c(this.a);
      if (!this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
      {
        localObject1 = (amku)this.a.getBusinessHandler(BusinessHandlerFactory.DIY_PENDANT_HANDLER);
        localObject2 = new ArrayList();
        Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject2).add(Long.valueOf(Long.parseLong(((java.lang.String)localIterator.next()).split("_")[0])));
        }
        ((amku)localObject1).a((List)localObject2, null);
        this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
      }
    }
    if (!this.this$0.b.isEmpty()) {
      this.this$0.b();
    }
    Object localObject1 = this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (amkt)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((amkt)localObject2).a() == null)) {
        this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
      }
    }
    amks.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.2
 * JD-Core Version:    0.7.0.1
 */