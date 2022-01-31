package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mtc;
import mtt;
import mtw;
import mtx;
import mty;
import mtz;
import obj;
import rcv;
import rcw;

public class AccountDetailBaseAdapter$14
  implements Runnable
{
  public AccountDetailBaseAdapter$14(mtc parammtc, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (mtc.a(this.this$0) != this.jdField_a_of_type_Long) {}
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
          if (mtc.a(this.this$0) != this.jdField_a_of_type_Long) {
            break;
          }
          try
          {
            mtw localmtw = (mtw)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localmtw == null) {
              continue;
            }
            if (localmtw.jdField_a_of_type_Mtx.jdField_a_of_type_Int != 2) {
              break label232;
            }
            if (localmtw.jdField_a_of_type_Mtz == null) {
              continue;
            }
            if (localmtw.jdField_a_of_type_Mtz.e != 1) {
              break label201;
            }
            localLinkedList.add(mtt.a(new URL(localmtw.jdField_a_of_type_Mtz.d), obj.e()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (mtc.a(this.this$0) != this.jdField_a_of_type_Long)
          {
            return;
            localLinkedList.add(mtt.a(new URL(localException.jdField_a_of_type_Mtz.jdField_a_of_type_JavaLangString), obj.a()));
            continue;
            if (localException.jdField_a_of_type_Mty != null) {
              if (localException.jdField_a_of_type_Mty.jdField_a_of_type_Int == 1) {
                localLinkedList.add(mtt.a(new URL(localException.jdField_a_of_type_Mty.b), obj.e()));
              } else {
                localLinkedList.add(mtt.a(new URL(localException.jdField_a_of_type_Mty.jdField_a_of_type_JavaLangString), obj.a()));
              }
            }
          }
        }
      } while (mtc.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        mtt localmtt = (mtt)localIterator.next();
        if ((localmtt != null) && (localmtt.jdField_a_of_type_JavaNetURL != null))
        {
          rcw localrcw = new rcw();
          localrcw.jdField_a_of_type_JavaNetURL = localmtt.jdField_a_of_type_JavaNetURL;
          localrcw.jdField_a_of_type_Int = ((Integer)localmtt.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localrcw.jdField_b_of_type_Int = ((Integer)localmtt.jdField_a_of_type_AndroidUtilPair.second).intValue();
          rcv.a().a(localrcw, null);
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