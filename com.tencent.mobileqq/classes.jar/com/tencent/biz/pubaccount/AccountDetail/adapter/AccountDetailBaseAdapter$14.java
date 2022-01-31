package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import ngw;
import nhn;
import nhq;
import nhr;
import nhs;
import nht;
import orc;
import sff;
import sfg;

public class AccountDetailBaseAdapter$14
  implements Runnable
{
  public AccountDetailBaseAdapter$14(ngw paramngw, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (ngw.a(this.this$0) != this.jdField_a_of_type_Long) {}
    label25:
    LinkedList localLinkedList;
    label38:
    label80:
    label232:
    do
    {
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
          if ((j < i) && (j >= 0)) {
            break label80;
          }
        }
        for (;;)
        {
          j += 1;
          break label38;
          i = this.jdField_a_of_type_JavaUtilList.size();
          break label25;
          if (ngw.a(this.this$0) != this.jdField_a_of_type_Long) {
            break;
          }
          try
          {
            nhq localnhq = (nhq)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localnhq == null) {
              continue;
            }
            if (localnhq.jdField_a_of_type_Nhr.jdField_a_of_type_Int != 2) {
              break label232;
            }
            if (localnhq.jdField_a_of_type_Nht == null) {
              continue;
            }
            if (localnhq.jdField_a_of_type_Nht.e != 1) {
              break label201;
            }
            localLinkedList.add(nhn.a(new URL(localnhq.jdField_a_of_type_Nht.d), orc.e()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (ngw.a(this.this$0) != this.jdField_a_of_type_Long)
          {
            return;
            localLinkedList.add(nhn.a(new URL(localException.jdField_a_of_type_Nht.jdField_a_of_type_JavaLangString), orc.a()));
            continue;
            if (localException.jdField_a_of_type_Nhs != null) {
              if (localException.jdField_a_of_type_Nhs.jdField_a_of_type_Int == 1) {
                localLinkedList.add(nhn.a(new URL(localException.jdField_a_of_type_Nhs.b), orc.e()));
              } else {
                localLinkedList.add(nhn.a(new URL(localException.jdField_a_of_type_Nhs.jdField_a_of_type_JavaLangString), orc.a()));
              }
            }
          }
        }
      } while (ngw.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        nhn localnhn = (nhn)localIterator.next();
        if ((localnhn != null) && (localnhn.jdField_a_of_type_JavaNetURL != null))
        {
          sfg localsfg = new sfg();
          localsfg.jdField_a_of_type_JavaNetURL = localnhn.jdField_a_of_type_JavaNetURL;
          localsfg.jdField_a_of_type_Int = ((Integer)localnhn.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localsfg.jdField_b_of_type_Int = ((Integer)localnhn.jdField_a_of_type_AndroidUtilPair.second).intValue();
          sff.a().a(localsfg, null);
        }
      }
    } while (!QLog.isColorLevel());
    label201:
    QLog.d("AccountDetailBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.14
 * JD-Core Version:    0.7.0.1
 */