package com.tencent.av.random;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lsn;
import lso;
import lst;
import lsu;
import lsw;
import lsx;
import lsy;

class RandomWebProtocol$MatchTask
  extends Thread
{
  List<lsn> jdField_a_of_type_JavaUtilList = new ArrayList();
  lso jdField_a_of_type_Lso;
  lst jdField_a_of_type_Lst;
  boolean jdField_a_of_type_Boolean = false;
  
  RandomWebProtocol$MatchTask(RandomWebProtocol paramRandomWebProtocol, lso paramlso)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramRandomWebProtocol.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Lso = paramlso;
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
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Lst != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((lsn)localIterator.next()).a(paramInt, this.jdField_a_of_type_Lst);
      }
    }
    a();
    if (this.jdField_a_of_type_Lso != null) {
      RandomWebProtocol.a(this.this$0).remove(this.jdField_a_of_type_Lso.d);
    }
  }
  
  public void run()
  {
    this.jdField_a_of_type_Lst = null;
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[random room owner] realRequest.reqtype:" + this.jdField_a_of_type_Lso.a);
    }
    if (this.jdField_a_of_type_Lso != null)
    {
      if (1 != this.jdField_a_of_type_Lso.a) {
        break label106;
      }
      this.jdField_a_of_type_Lst = new lsu();
    }
    while ((this.jdField_a_of_type_Lso == null) || (this.jdField_a_of_type_Lst == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Lso.c)))
    {
      a(true, -2);
      return;
      label106:
      if (2 == this.jdField_a_of_type_Lso.a) {
        this.jdField_a_of_type_Lst = new lsw(this.this$0);
      } else if (3 == this.jdField_a_of_type_Lso.a) {
        this.jdField_a_of_type_Lst = new lsx(this.this$0);
      } else if ((4 == this.jdField_a_of_type_Lso.a) || (5 == this.jdField_a_of_type_Lso.a)) {
        this.jdField_a_of_type_Lst = new lsy(this.this$0);
      }
    }
    String str1 = this.jdField_a_of_type_Lso.a();
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] [random room owner][1v1] json post:" + str1);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(false, -2);
      return;
    }
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - l < this.jdField_a_of_type_Lst.c)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(false, -2);
        return;
      }
      String str2 = RandomWebProtocol.a(this.jdField_a_of_type_Lso.c, str1, null);
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb][random room owner][1v1] json result:" + str2);
      }
      this.jdField_a_of_type_Lst.a(str2);
      int i = this.jdField_a_of_type_Lst.b;
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
            Thread.sleep(this.jdField_a_of_type_Lst.d);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          break;
          if (((this.jdField_a_of_type_Lst instanceof lsu)) && (i == 1))
          {
            a(true, 1);
            return;
          }
          a(true, 0);
          return;
          if ((this.jdField_a_of_type_Lst instanceof lsy)) {
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