package com.tencent.mobileqq.activity.aio.doodle;

import acud;
import acue;
import acui;
import android.graphics.Path;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class HalfAlgorithm$TransPathJob
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<acui> jdField_a_of_type_JavaLangRefWeakReference;
  private List<acue> jdField_a_of_type_JavaUtilList;
  
  public HalfAlgorithm$TransPathJob(int paramInt, List<acue> paramList, acui paramacui)
  {
    this.jdField_a_of_type_Int = paramList;
    this.jdField_a_of_type_JavaUtilList = paramacui;
    Object localObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (acui)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((acui)localObject).a(this.jdField_a_of_type_Int, false, null, null);
        }
      }
      return;
    }
    QLog.d("TransPathJob", 2, "TransPathJob begin:" + this.jdField_a_of_type_Int + " - " + System.currentTimeMillis());
    Path localPath1 = new Path();
    localPath1.reset();
    ArrayList localArrayList1 = new ArrayList();
    Path localPath2 = new Path();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject = null;
    acue localacue;
    if (localIterator.hasNext())
    {
      localacue = (acue)localIterator.next();
      if (localObject == null) {
        break label488;
      }
      localacue.b((acue)localObject);
      localObject = null;
    }
    label321:
    label483:
    label488:
    for (;;)
    {
      if (HalfAlgorithm.a(this.this$0, localacue.a.jdField_a_of_type_Float, localacue.a.b, localacue.a.c, localacue.a.jdField_a_of_type_Long, localacue.c.jdField_a_of_type_Float, localacue.c.b, localacue.b.jdField_a_of_type_Float, localacue.b.b, localacue.b.c, localacue.b.jdField_a_of_type_Long, localPath2, localArrayList2)) {
        if (localArrayList2.size() > 0)
        {
          localPath1.addPath(localPath2);
          HalfAlgorithm.a(this.this$0, localArrayList1, localArrayList2);
          localPath2.reset();
          localArrayList2.clear();
        }
      }
      for (;;)
      {
        break;
        QLog.d("TransPathJob", 2, "TransPathJob segment == 0:" + System.currentTimeMillis());
        break label321;
        QLog.d("TransPathJob", 2, "TransPathJob no segment:" + System.currentTimeMillis());
        localObject = localacue;
      }
      localObject = (acui)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      int i;
      if (localObject != null)
      {
        i = this.jdField_a_of_type_Int;
        if (localArrayList1.size() <= 0) {
          break label483;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((acui)localObject).a(i, bool, localPath1, localArrayList1);
        QLog.d("TransPathJob", 2, "TransPathJob end:" + this.jdField_a_of_type_Int + "-" + System.currentTimeMillis());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm.TransPathJob
 * JD-Core Version:    0.7.0.1
 */