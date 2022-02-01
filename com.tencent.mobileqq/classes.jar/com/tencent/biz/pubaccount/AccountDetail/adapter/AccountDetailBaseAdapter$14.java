package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import nzu;
import oam;
import oap;
import oaq;
import oar;
import oas;
import pjr;
import tlv;
import tlw;

public class AccountDetailBaseAdapter$14
  implements Runnable
{
  public AccountDetailBaseAdapter$14(nzu paramnzu, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (nzu.a(this.this$0) != this.jdField_a_of_type_Long) {}
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
          if (nzu.a(this.this$0) != this.jdField_a_of_type_Long) {
            break;
          }
          try
          {
            oap localoap = (oap)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localoap == null) {
              continue;
            }
            if (localoap.jdField_a_of_type_Oaq.jdField_a_of_type_Int != 2) {
              break label232;
            }
            if (localoap.jdField_a_of_type_Oas == null) {
              continue;
            }
            if (localoap.jdField_a_of_type_Oas.e != 1) {
              break label201;
            }
            localLinkedList.add(oam.a(new URL(localoap.jdField_a_of_type_Oas.d), pjr.e()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (nzu.a(this.this$0) != this.jdField_a_of_type_Long)
          {
            return;
            localLinkedList.add(oam.a(new URL(localException.jdField_a_of_type_Oas.jdField_a_of_type_JavaLangString), pjr.a()));
            continue;
            if (localException.jdField_a_of_type_Oar != null) {
              if (localException.jdField_a_of_type_Oar.jdField_a_of_type_Int == 1) {
                localLinkedList.add(oam.a(new URL(localException.jdField_a_of_type_Oar.b), pjr.e()));
              } else {
                localLinkedList.add(oam.a(new URL(localException.jdField_a_of_type_Oar.jdField_a_of_type_JavaLangString), pjr.a()));
              }
            }
          }
        }
      } while (nzu.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        oam localoam = (oam)localIterator.next();
        if ((localoam != null) && (localoam.jdField_a_of_type_JavaNetURL != null))
        {
          tlw localtlw = new tlw();
          localtlw.jdField_a_of_type_JavaNetURL = localoam.jdField_a_of_type_JavaNetURL;
          localtlw.jdField_a_of_type_Int = ((Integer)localoam.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localtlw.jdField_b_of_type_Int = ((Integer)localoam.jdField_a_of_type_AndroidUtilPair.second).intValue();
          tlv.a().a(localtlw, null);
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