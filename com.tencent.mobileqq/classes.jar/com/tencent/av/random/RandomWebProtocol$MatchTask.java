package com.tencent.av.random;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lsj;
import lsk;
import lsp;
import lsq;
import lss;
import lst;
import lsu;

class RandomWebProtocol$MatchTask
  extends Thread
{
  List<lsj> jdField_a_of_type_JavaUtilList = new ArrayList();
  lsk jdField_a_of_type_Lsk;
  lsp jdField_a_of_type_Lsp;
  boolean jdField_a_of_type_Boolean = false;
  
  RandomWebProtocol$MatchTask(RandomWebProtocol paramRandomWebProtocol, lsk paramlsk)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramRandomWebProtocol.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Lsk = paramlsk;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] quitMatch. result: " + paramInt);
    }
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Lsp != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((lsj)localIterator.next()).a(paramInt, this.jdField_a_of_type_Lsp);
      }
    }
    a();
    if (this.jdField_a_of_type_Lsk != null) {
      RandomWebProtocol.a(this.this$0).remove(this.jdField_a_of_type_Lsk.d);
    }
  }
  
  public void run()
  {
    this.jdField_a_of_type_Lsp = null;
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[random room owner] realRequest.reqtype:" + this.jdField_a_of_type_Lsk.a);
    }
    if (this.jdField_a_of_type_Lsk != null)
    {
      if (1 != this.jdField_a_of_type_Lsk.a) {
        break label106;
      }
      this.jdField_a_of_type_Lsp = new lsq();
    }
    while ((this.jdField_a_of_type_Lsk == null) || (this.jdField_a_of_type_Lsp == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Lsk.c)))
    {
      a(true, -2);
      return;
      label106:
      if (2 == this.jdField_a_of_type_Lsk.a) {
        this.jdField_a_of_type_Lsp = new lss(this.this$0);
      } else if (3 == this.jdField_a_of_type_Lsk.a) {
        this.jdField_a_of_type_Lsp = new lst(this.this$0);
      } else if ((4 == this.jdField_a_of_type_Lsk.a) || (5 == this.jdField_a_of_type_Lsk.a)) {
        this.jdField_a_of_type_Lsp = new lsu(this.this$0);
      }
    }
    String str1 = this.jdField_a_of_type_Lsk.a();
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] [random room owner][1v1] json post:" + str1);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(false, -2);
      return;
    }
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - l < this.jdField_a_of_type_Lsp.c)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(false, -2);
        return;
      }
      String str2 = RandomWebProtocol.a(this.jdField_a_of_type_Lsk.c, str1, null);
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb][random room owner][1v1] json result:" + str2);
      }
      this.jdField_a_of_type_Lsp.a(str2);
      int i = this.jdField_a_of_type_Lsp.b;
      switch (i)
      {
      default: 
        i = 1;
      case 0: 
      case 1: 
      case 1000: 
      case 2: 
      case -1002: 
      case -1: 
      case 7: 
        while (i != 0)
        {
          try
          {
            Thread.sleep(this.jdField_a_of_type_Lsp.d);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          break;
          if (((this.jdField_a_of_type_Lsp instanceof lsq)) && (i == 1))
          {
            a(true, 1);
            return;
          }
          a(true, 0);
          return;
          if ((this.jdField_a_of_type_Lsp instanceof lsu)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      case -1003: 
      case -1000: 
      case 6: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
        a(true, -2);
        return;
      case -1015: 
      case 13: 
        a(true, -3);
        return;
      case 4: 
        a(true, -1);
        return;
      }
      a(true, 100);
      return;
    }
    a(true, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.MatchTask
 * JD-Core Version:    0.7.0.1
 */