package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import nst;
import ntl;
import nto;
import ntp;
import ntq;
import ntr;
import pai;
import syn;
import syo;

public class AccountDetailBaseAdapter$14
  implements Runnable
{
  public AccountDetailBaseAdapter$14(nst paramnst, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (nst.a(this.this$0) != this.jdField_a_of_type_Long) {}
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
          if (nst.a(this.this$0) != this.jdField_a_of_type_Long) {
            break;
          }
          try
          {
            nto localnto = (nto)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localnto == null) {
              continue;
            }
            if (localnto.jdField_a_of_type_Ntp.jdField_a_of_type_Int != 2) {
              break label232;
            }
            if (localnto.jdField_a_of_type_Ntr == null) {
              continue;
            }
            if (localnto.jdField_a_of_type_Ntr.e != 1) {
              break label201;
            }
            localLinkedList.add(ntl.a(new URL(localnto.jdField_a_of_type_Ntr.d), pai.e()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (nst.a(this.this$0) != this.jdField_a_of_type_Long)
          {
            return;
            localLinkedList.add(ntl.a(new URL(localException.jdField_a_of_type_Ntr.jdField_a_of_type_JavaLangString), pai.a()));
            continue;
            if (localException.jdField_a_of_type_Ntq != null) {
              if (localException.jdField_a_of_type_Ntq.jdField_a_of_type_Int == 1) {
                localLinkedList.add(ntl.a(new URL(localException.jdField_a_of_type_Ntq.b), pai.e()));
              } else {
                localLinkedList.add(ntl.a(new URL(localException.jdField_a_of_type_Ntq.jdField_a_of_type_JavaLangString), pai.a()));
              }
            }
          }
        }
      } while (nst.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        ntl localntl = (ntl)localIterator.next();
        if ((localntl != null) && (localntl.jdField_a_of_type_JavaNetURL != null))
        {
          syo localsyo = new syo();
          localsyo.jdField_a_of_type_JavaNetURL = localntl.jdField_a_of_type_JavaNetURL;
          localsyo.jdField_a_of_type_Int = ((Integer)localntl.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localsyo.jdField_b_of_type_Int = ((Integer)localntl.jdField_a_of_type_AndroidUtilPair.second).intValue();
          syn.a().a(localsyo, null);
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