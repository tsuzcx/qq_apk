package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import aqhg;
import aqhh;
import aqjb;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class BubbleDiyFetcher$4
  implements Runnable
{
  public BubbleDiyFetcher$4(aqhg paramaqhg, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "now query mUnCacheDiyId: " + TextUtils.join(",", this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet));
      }
      this.this$0.c(this.a);
      if (!this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
      {
        ((aqhh)this.a.getBusinessHandler(BusinessHandlerFactory.BUBBLE_DIYTEXT_HANDLER)).a(new ArrayList(this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet), null);
        this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
      }
    }
    if (!this.this$0.b.isEmpty()) {
      this.this$0.b();
    }
    Object localObject;
    if (!this.this$0.c.isEmpty())
    {
      localIterator = this.this$0.c.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.this$0.c((String)localObject);
        }
      }
    }
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (aqjb)localIterator.next();
      if ((localObject == null) || (((aqjb)localObject).getCallback() == null)) {
        this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
      }
    }
    aqhg.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.4
 * JD-Core Version:    0.7.0.1
 */