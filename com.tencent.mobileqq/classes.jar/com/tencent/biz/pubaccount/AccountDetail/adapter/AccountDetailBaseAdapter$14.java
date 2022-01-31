package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import nea;
import ner;
import neu;
import nev;
import new;
import nex;
import omr;
import rpg;
import rph;

public class AccountDetailBaseAdapter$14
  implements Runnable
{
  public AccountDetailBaseAdapter$14(nea paramnea, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (nea.a(this.this$0) != this.jdField_a_of_type_Long) {}
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
          if (nea.a(this.this$0) != this.jdField_a_of_type_Long) {
            break;
          }
          try
          {
            neu localneu = (neu)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localneu == null) {
              continue;
            }
            if (localneu.jdField_a_of_type_Nev.jdField_a_of_type_Int != 2) {
              break label232;
            }
            if (localneu.jdField_a_of_type_Nex == null) {
              continue;
            }
            if (localneu.jdField_a_of_type_Nex.e != 1) {
              break label201;
            }
            localLinkedList.add(ner.a(new URL(localneu.jdField_a_of_type_Nex.d), omr.e()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (nea.a(this.this$0) != this.jdField_a_of_type_Long)
          {
            return;
            localLinkedList.add(ner.a(new URL(localException.jdField_a_of_type_Nex.jdField_a_of_type_JavaLangString), omr.a()));
            continue;
            if (localException.jdField_a_of_type_New != null) {
              if (localException.jdField_a_of_type_New.jdField_a_of_type_Int == 1) {
                localLinkedList.add(ner.a(new URL(localException.jdField_a_of_type_New.b), omr.e()));
              } else {
                localLinkedList.add(ner.a(new URL(localException.jdField_a_of_type_New.jdField_a_of_type_JavaLangString), omr.a()));
              }
            }
          }
        }
      } while (nea.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        ner localner = (ner)localIterator.next();
        if ((localner != null) && (localner.jdField_a_of_type_JavaNetURL != null))
        {
          rph localrph = new rph();
          localrph.jdField_a_of_type_JavaNetURL = localner.jdField_a_of_type_JavaNetURL;
          localrph.jdField_a_of_type_Int = ((Integer)localner.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localrph.jdField_b_of_type_Int = ((Integer)localner.jdField_a_of_type_AndroidUtilPair.second).intValue();
          rpg.a().a(localrph, null);
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