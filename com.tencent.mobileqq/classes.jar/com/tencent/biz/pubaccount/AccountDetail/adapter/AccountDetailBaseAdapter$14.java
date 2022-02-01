package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import nrk;
import nsc;
import nsf;
import nsg;
import nsh;
import nsi;
import ozc;
import sun;
import suo;

public class AccountDetailBaseAdapter$14
  implements Runnable
{
  public AccountDetailBaseAdapter$14(nrk paramnrk, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (nrk.a(this.this$0) != this.jdField_a_of_type_Long) {}
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
          if (nrk.a(this.this$0) != this.jdField_a_of_type_Long) {
            break;
          }
          try
          {
            nsf localnsf = (nsf)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localnsf == null) {
              continue;
            }
            if (localnsf.jdField_a_of_type_Nsg.jdField_a_of_type_Int != 2) {
              break label232;
            }
            if (localnsf.jdField_a_of_type_Nsi == null) {
              continue;
            }
            if (localnsf.jdField_a_of_type_Nsi.e != 1) {
              break label201;
            }
            localLinkedList.add(nsc.a(new URL(localnsf.jdField_a_of_type_Nsi.d), ozc.e()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (nrk.a(this.this$0) != this.jdField_a_of_type_Long)
          {
            return;
            localLinkedList.add(nsc.a(new URL(localException.jdField_a_of_type_Nsi.jdField_a_of_type_JavaLangString), ozc.a()));
            continue;
            if (localException.jdField_a_of_type_Nsh != null) {
              if (localException.jdField_a_of_type_Nsh.jdField_a_of_type_Int == 1) {
                localLinkedList.add(nsc.a(new URL(localException.jdField_a_of_type_Nsh.b), ozc.e()));
              } else {
                localLinkedList.add(nsc.a(new URL(localException.jdField_a_of_type_Nsh.jdField_a_of_type_JavaLangString), ozc.a()));
              }
            }
          }
        }
      } while (nrk.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        nsc localnsc = (nsc)localIterator.next();
        if ((localnsc != null) && (localnsc.jdField_a_of_type_JavaNetURL != null))
        {
          suo localsuo = new suo();
          localsuo.jdField_a_of_type_JavaNetURL = localnsc.jdField_a_of_type_JavaNetURL;
          localsuo.jdField_a_of_type_Int = ((Integer)localnsc.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localsuo.jdField_b_of_type_Int = ((Integer)localnsc.jdField_a_of_type_AndroidUtilPair.second).intValue();
          sun.a().a(localsuo, null);
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