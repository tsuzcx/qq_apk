package com.tencent.av.ui.viewcontroller;

import java.util.ArrayList;
import java.util.Iterator;

public class QavOperationMenuViewController
{
  ArrayList<OperationBtnItem> a = new ArrayList();
  boolean b = false;
  public int c = -1;
  
  public ArrayList<OperationBtnItem> a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    b(b(paramInt));
  }
  
  public void a(OperationBtnItem paramOperationBtnItem)
  {
    if (paramOperationBtnItem == null) {
      return;
    }
    this.a.add(paramOperationBtnItem);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public OperationBtnItem b(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      OperationBtnItem localOperationBtnItem = (OperationBtnItem)localIterator.next();
      if (localOperationBtnItem.a() == paramInt) {
        return localOperationBtnItem;
      }
    }
    return null;
  }
  
  public ArrayList<OperationBtnItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      if (((OperationBtnItem)this.a.get(i)).h()) {
        localArrayList.add(this.a.get(i));
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
    this.a.remove(paramOperationBtnItem);
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.viewcontroller.QavOperationMenuViewController
 * JD-Core Version:    0.7.0.1
 */