package com.tencent.biz.pubaccount.readinjoy.view;

import qhp;
import qiy;
import qoe;
import qot;

public class ReadInJoyBaseAdapter$29$4
  implements Runnable
{
  public ReadInJoyBaseAdapter$29$4(qot paramqot) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    if (this.a.a.jdField_a_of_type_Qhp.a())
    {
      this.a.a.jdField_a_of_type_Qhp.e(true);
      this.a.a.jdField_a_of_type_Qhp.a().j();
    }
    while ((this.a.a.jdField_a_of_type_Boolean) || (!this.a.a.jdField_a_of_type_Qhp.c())) {
      return;
    }
    this.a.a.jdField_a_of_type_Qhp.d(true);
    this.a.a.jdField_a_of_type_Qhp.a().j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.4
 * JD-Core Version:    0.7.0.1
 */