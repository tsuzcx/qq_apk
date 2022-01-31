package com.tencent.mobileqq.addon;

import akii;
import akij;
import akik;
import android.text.TextUtils;
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
  public DiyPendantFetcher$2(akii paramakii, QQAppInterface paramQQAppInterface) {}
  
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
        localObject1 = (akik)this.a.a(114);
        localObject2 = new ArrayList();
        Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject2).add(Long.valueOf(Long.parseLong(((java.lang.String)localIterator.next()).split("_")[0])));
        }
        ((akik)localObject1).a((List)localObject2, null);
        this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
      }
    }
    if (!this.this$0.b.isEmpty()) {
      this.this$0.b();
    }
    Object localObject1 = this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (akij)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((akij)localObject2).a() == null)) {
        this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
      }
    }
    akii.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.2
 * JD-Core Version:    0.7.0.1
 */