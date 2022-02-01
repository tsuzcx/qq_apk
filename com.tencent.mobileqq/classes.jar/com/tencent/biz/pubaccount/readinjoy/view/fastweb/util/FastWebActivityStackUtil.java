package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class FastWebActivityStackUtil
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<FastWebActivityStackUtil.SaveState> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public FastWebActivityStackUtil(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public FastWebActivityStackUtil.SaveState a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (FastWebActivityStackUtil.SaveState)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(FastWebActivityStackUtil.PopPageListener paramPopPageListener)
  {
    if (paramPopPageListener == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        FastWebActivityStackUtil.SaveState localSaveState = a();
        if (localSaveState != null) {
          paramPopPageListener.a(localSaveState);
        }
      }
    }
  }
  
  public void a(FastWebActivityStackUtil.SaveState paramSaveState)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramSaveState);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebActivityStackUtil
 * JD-Core Version:    0.7.0.1
 */