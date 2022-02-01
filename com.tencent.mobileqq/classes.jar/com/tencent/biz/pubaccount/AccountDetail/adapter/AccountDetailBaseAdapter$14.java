package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import npm;
import nqe;
import nqh;
import nqi;
import nqj;
import nqk;
import pgk;
import tdv;
import tdw;

public class AccountDetailBaseAdapter$14
  implements Runnable
{
  public AccountDetailBaseAdapter$14(npm paramnpm, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (npm.a(this.this$0) != this.jdField_a_of_type_Long) {}
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
          if (npm.a(this.this$0) != this.jdField_a_of_type_Long) {
            break;
          }
          try
          {
            nqh localnqh = (nqh)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localnqh == null) {
              continue;
            }
            if (localnqh.jdField_a_of_type_Nqi.jdField_a_of_type_Int != 2) {
              break label232;
            }
            if (localnqh.jdField_a_of_type_Nqk == null) {
              continue;
            }
            if (localnqh.jdField_a_of_type_Nqk.e != 1) {
              break label201;
            }
            localLinkedList.add(nqe.a(new URL(localnqh.jdField_a_of_type_Nqk.d), pgk.e()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (npm.a(this.this$0) != this.jdField_a_of_type_Long)
          {
            return;
            localLinkedList.add(nqe.a(new URL(localException.jdField_a_of_type_Nqk.jdField_a_of_type_JavaLangString), pgk.a()));
            continue;
            if (localException.jdField_a_of_type_Nqj != null) {
              if (localException.jdField_a_of_type_Nqj.jdField_a_of_type_Int == 1) {
                localLinkedList.add(nqe.a(new URL(localException.jdField_a_of_type_Nqj.b), pgk.e()));
              } else {
                localLinkedList.add(nqe.a(new URL(localException.jdField_a_of_type_Nqj.jdField_a_of_type_JavaLangString), pgk.a()));
              }
            }
          }
        }
      } while (npm.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        nqe localnqe = (nqe)localIterator.next();
        if ((localnqe != null) && (localnqe.jdField_a_of_type_JavaNetURL != null))
        {
          tdw localtdw = new tdw();
          localtdw.jdField_a_of_type_JavaNetURL = localnqe.jdField_a_of_type_JavaNetURL;
          localtdw.jdField_a_of_type_Int = ((Integer)localnqe.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localtdw.jdField_b_of_type_Int = ((Integer)localnqe.jdField_a_of_type_AndroidUtilPair.second).intValue();
          tdv.a().a(localtdw, null);
        }
      }
    } while (!QLog.isColorLevel());
    label201:
    QLog.d("AccountDetailBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.14
 * JD-Core Version:    0.7.0.1
 */