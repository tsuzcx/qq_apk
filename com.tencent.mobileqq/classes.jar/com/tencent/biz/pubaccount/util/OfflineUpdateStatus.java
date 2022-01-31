package com.tencent.biz.pubaccount.util;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.util.LoadedBack2;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineUpdateStatus
  implements AsyncBack
{
  public int a;
  public String a;
  private ArrayList a;
  private int b;
  public String b;
  private int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public OfflineUpdateStatus(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(LoadedBack2 paramLoadedBack2)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramLoadedBack2)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramLoadedBack2);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LoadedBack2)localIterator.next()).a(paramString, paramInt);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(LoadedBack2 paramLoadedBack2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramLoadedBack2);
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.OfflineUpdateStatus
 * JD-Core Version:    0.7.0.1
 */