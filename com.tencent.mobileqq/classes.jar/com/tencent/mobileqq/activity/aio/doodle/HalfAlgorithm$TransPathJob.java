package com.tencent.mobileqq.activity.aio.doodle;

import afbk;
import afbl;
import afbp;
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
  private WeakReference<afbp> jdField_a_of_type_JavaLangRefWeakReference;
  private List<afbl> jdField_a_of_type_JavaUtilList;
  
  public HalfAlgorithm$TransPathJob(int paramInt, List<afbl> paramList, afbp paramafbp)
  {
    this.jdField_a_of_type_Int = paramList;
    this.jdField_a_of_type_JavaUtilList = paramafbp;
    Object localObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (afbp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((afbp)localObject).a(this.jdField_a_of_type_Int, false, null, null);
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
    afbl localafbl;
    if (localIterator.hasNext())
    {
      localafbl = (afbl)localIterator.next();
      if (localObject == null) {
        break label488;
      }
      localafbl.b((afbl)localObject);
      localObject = null;
    }
    label321:
    label483:
    label488:
    for (;;)
    {
      if (HalfAlgorithm.a(this.this$0, localafbl.a.jdField_a_of_type_Float, localafbl.a.b, localafbl.a.c, localafbl.a.jdField_a_of_type_Long, localafbl.c.jdField_a_of_type_Float, localafbl.c.b, localafbl.b.jdField_a_of_type_Float, localafbl.b.b, localafbl.b.c, localafbl.b.jdField_a_of_type_Long, localPath2, localArrayList2)) {
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
        localObject = localafbl;
      }
      localObject = (afbp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
        ((afbp)localObject).a(i, bool, localPath1, localArrayList1);
        QLog.d("TransPathJob", 2, "TransPathJob end:" + this.jdField_a_of_type_Int + "-" + System.currentTimeMillis());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm.TransPathJob
 * JD-Core Version:    0.7.0.1
 */