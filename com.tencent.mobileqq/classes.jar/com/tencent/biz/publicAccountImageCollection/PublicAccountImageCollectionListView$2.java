package com.tencent.biz.publicAccountImageCollection;

import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rpj;
import rpk;
import snq;
import soh;
import spb;

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
              spb localspb = (spb)this.jdField_a_of_type_JavaUtilList.get(j - 1);
              if (localspb != null)
              {
                localObject = ((snq)this.this$0.getAdapter()).a(localspb.a);
                if (localObject == null) {
                  break;
                }
                int k = ((snq)this.this$0.getAdapter()).a(localspb)[0];
                int m = ((snq)this.this$0.getAdapter()).a(localspb)[1];
                localLinkedList.add(soh.a((URL)localObject, k, m));
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
        localObject = (soh)localIterator.next();
        if ((localObject != null) && (((soh)localObject).jdField_a_of_type_JavaNetURL != null))
        {
          rpk localrpk = new rpk();
          localrpk.jdField_a_of_type_JavaNetURL = ((soh)localObject).jdField_a_of_type_JavaNetURL;
          localrpk.jdField_a_of_type_Int = ((soh)localObject).jdField_a_of_type_Int;
          localrpk.jdField_b_of_type_Int = ((soh)localObject).jdField_b_of_type_Int;
          rpj.a().a(localrpk, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.2
 * JD-Core Version:    0.7.0.1
 */