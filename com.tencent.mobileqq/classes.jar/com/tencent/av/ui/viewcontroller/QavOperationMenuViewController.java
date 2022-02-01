package com.tencent.av.ui.viewcontroller;

import java.util.ArrayList;
import java.util.Iterator;

public class QavOperationMenuViewController
{
  public int a;
  ArrayList<OperationBtnItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public QavOperationMenuViewController()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public OperationBtnItem a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      OperationBtnItem localOperationBtnItem = (OperationBtnItem)localIterator.next();
      if (localOperationBtnItem.a() == paramInt) {
        return localOperationBtnItem;
      }
    }
    return null;
  }
  
  public ArrayList<OperationBtnItem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    b(a(paramInt));
  }
  
  public void a(OperationBtnItem paramOperationBtnItem)
  {
    if (paramOperationBtnItem == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramOperationBtnItem);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList<OperationBtnItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((OperationBtnItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(OperationBtnItem paramOperationBtnItem)
  {
    if (paramOperationBtnItem == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramOperationBtnItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.viewcontroller.QavOperationMenuViewController
 * JD-Core Version:    0.7.0.1
 */