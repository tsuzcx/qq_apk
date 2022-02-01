package com.tencent.biz.publicAccountImageCollection;

import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sun;
import suo;
import uwt;
import uxk;
import uye;

class PublicAccountImageCollectionListView$2
  implements Runnable
{
  PublicAccountImageCollectionListView$2(PublicAccountImageCollectionListView paramPublicAccountImageCollectionListView, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long) {}
    label25:
    LinkedList localLinkedList;
    label39:
    label82:
    do
    {
      Object localObject;
      do
      {
        return;
        int i;
        int j;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          localLinkedList = new LinkedList();
          j = this.jdField_a_of_type_Int;
          if (j >= this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) {
            continue;
          }
          if ((j <= i) && (j >= 1)) {
            break label82;
          }
        }
        do
        {
          for (;;)
          {
            j += 1;
            break label39;
            i = this.jdField_a_of_type_JavaUtilList.size();
            break label25;
            if (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long) {
              break;
            }
            try
            {
              uye localuye = (uye)this.jdField_a_of_type_JavaUtilList.get(j - 1);
              if (localuye != null)
              {
                localObject = ((uwt)this.this$0.getAdapter()).a(localuye.a);
                if (localObject == null) {
                  break;
                }
                int k = ((uwt)this.this$0.getAdapter()).a(localuye)[0];
                int m = ((uwt)this.this$0.getAdapter()).a(localuye)[1];
                localLinkedList.add(uxk.a((URL)localObject, k, m));
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg index:" + j + "  reqWidth = " + k + " reqHeight = " + m);
                }
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        } while (PublicAccountImageCollectionListView.a(this.this$0) == this.jdField_a_of_type_Long);
        return;
      } while (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (uxk)localIterator.next();
        if ((localObject != null) && (((uxk)localObject).jdField_a_of_type_JavaNetURL != null))
        {
          suo localsuo = new suo();
          localsuo.jdField_a_of_type_JavaNetURL = ((uxk)localObject).jdField_a_of_type_JavaNetURL;
          localsuo.jdField_a_of_type_Int = ((uxk)localObject).jdField_a_of_type_Int;
          localsuo.jdField_b_of_type_Int = ((uxk)localObject).jdField_b_of_type_Int;
          sun.a().a(localsuo, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.2
 * JD-Core Version:    0.7.0.1
 */