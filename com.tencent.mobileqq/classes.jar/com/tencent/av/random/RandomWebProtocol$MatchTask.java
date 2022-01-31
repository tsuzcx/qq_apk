package com.tencent.av.random;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lio;
import lip;
import liu;
import liv;
import lix;
import liy;
import liz;

class RandomWebProtocol$MatchTask
  extends Thread
{
  List<lio> jdField_a_of_type_JavaUtilList = new ArrayList();
  lip jdField_a_of_type_Lip;
  liu jdField_a_of_type_Liu;
  boolean jdField_a_of_type_Boolean = false;
  
  RandomWebProtocol$MatchTask(RandomWebProtocol paramRandomWebProtocol, lip paramlip)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramRandomWebProtocol.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Lip = paramlip;
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
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Liu != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((lio)localIterator.next()).a(paramInt, this.jdField_a_of_type_Liu);
      }
    }
    a();
    if (this.jdField_a_of_type_Lip != null) {
      RandomWebProtocol.a(this.this$0).remove(this.jdField_a_of_type_Lip.d);
    }
  }
  
  public void run()
  {
    this.jdField_a_of_type_Liu = null;
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[random room owner] realRequest.reqtype:" + this.jdField_a_of_type_Lip.a);
    }
    if (this.jdField_a_of_type_Lip != null)
    {
      if (1 != this.jdField_a_of_type_Lip.a) {
        break label106;
      }
      this.jdField_a_of_type_Liu = new liv();
    }
    while ((this.jdField_a_of_type_Lip == null) || (this.jdField_a_of_type_Liu == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Lip.c)))
    {
      a(true, -2);
      return;
      label106:
      if (2 == this.jdField_a_of_type_Lip.a) {
        this.jdField_a_of_type_Liu = new lix(this.this$0);
      } else if (3 == this.jdField_a_of_type_Lip.a) {
        this.jdField_a_of_type_Liu = new liy(this.this$0);
      } else if ((4 == this.jdField_a_of_type_Lip.a) || (5 == this.jdField_a_of_type_Lip.a)) {
        this.jdField_a_of_type_Liu = new liz(this.this$0);
      }
    }
    String str1 = this.jdField_a_of_type_Lip.a();
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] [random room owner][1v1] json post:" + str1);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(false, -2);
      return;
    }
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - l < this.jdField_a_of_type_Liu.c)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(false, -2);
        return;
      }
      String str2 = RandomWebProtocol.a(this.jdField_a_of_type_Lip.c, str1, null);
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb][random room owner][1v1] json result:" + str2);
      }
      this.jdField_a_of_type_Liu.a(str2);
      int i = this.jdField_a_of_type_Liu.b;
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
            Thread.sleep(this.jdField_a_of_type_Liu.d);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          break;
          if (((this.jdField_a_of_type_Liu instanceof liv)) && (i == 1))
          {
            a(true, 1);
            return;
          }
          a(true, 0);
          return;
          if ((this.jdField_a_of_type_Liu instanceof liz)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.MatchTask
 * JD-Core Version:    0.7.0.1
 */