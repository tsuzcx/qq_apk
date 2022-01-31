package com.tencent.av.random;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lvh;
import lvi;
import lvn;
import lvo;
import lvq;
import lvr;
import lvs;

class RandomWebProtocol$MatchTask
  extends Thread
{
  List<lvh> jdField_a_of_type_JavaUtilList = new ArrayList();
  lvi jdField_a_of_type_Lvi;
  lvn jdField_a_of_type_Lvn;
  boolean jdField_a_of_type_Boolean = false;
  
  RandomWebProtocol$MatchTask(RandomWebProtocol paramRandomWebProtocol, lvi paramlvi)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramRandomWebProtocol.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Lvi = paramlvi;
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
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Lvn != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((lvh)localIterator.next()).a(paramInt, this.jdField_a_of_type_Lvn);
      }
    }
    a();
    if (this.jdField_a_of_type_Lvi != null) {
      RandomWebProtocol.a(this.this$0).remove(this.jdField_a_of_type_Lvi.d);
    }
  }
  
  public void run()
  {
    this.jdField_a_of_type_Lvn = null;
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[random room owner] realRequest.reqtype:" + this.jdField_a_of_type_Lvi.a);
    }
    if (this.jdField_a_of_type_Lvi != null)
    {
      if (1 != this.jdField_a_of_type_Lvi.a) {
        break label106;
      }
      this.jdField_a_of_type_Lvn = new lvo();
    }
    while ((this.jdField_a_of_type_Lvi == null) || (this.jdField_a_of_type_Lvn == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Lvi.c)))
    {
      a(true, -2);
      return;
      label106:
      if (2 == this.jdField_a_of_type_Lvi.a) {
        this.jdField_a_of_type_Lvn = new lvq(this.this$0);
      } else if (3 == this.jdField_a_of_type_Lvi.a) {
        this.jdField_a_of_type_Lvn = new lvr(this.this$0);
      } else if ((4 == this.jdField_a_of_type_Lvi.a) || (5 == this.jdField_a_of_type_Lvi.a)) {
        this.jdField_a_of_type_Lvn = new lvs(this.this$0);
      }
    }
    String str1 = this.jdField_a_of_type_Lvi.a();
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] [random room owner][1v1] json post:" + str1);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(false, -2);
      return;
    }
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - l < this.jdField_a_of_type_Lvn.c)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(false, -2);
        return;
      }
      String str2 = RandomWebProtocol.a(this.jdField_a_of_type_Lvi.c, str1, null);
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb][random room owner][1v1] json result:" + str2);
      }
      this.jdField_a_of_type_Lvn.a(str2);
      int i = this.jdField_a_of_type_Lvn.b;
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
            Thread.sleep(this.jdField_a_of_type_Lvn.d);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          break;
          if (((this.jdField_a_of_type_Lvn instanceof lvo)) && (i == 1))
          {
            a(true, 1);
            return;
          }
          a(true, 0);
          return;
          if ((this.jdField_a_of_type_Lvn instanceof lvs)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.MatchTask
 * JD-Core Version:    0.7.0.1
 */