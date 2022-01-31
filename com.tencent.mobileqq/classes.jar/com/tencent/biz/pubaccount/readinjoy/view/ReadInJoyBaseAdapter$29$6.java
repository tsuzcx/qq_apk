package com.tencent.biz.pubaccount.readinjoy.view;

import qtr;
import qva;
import ram;
import rbb;

public class ReadInJoyBaseAdapter$29$6
  implements Runnable
{
  public ReadInJoyBaseAdapter$29$6(rbb paramrbb) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    if (this.a.a.jdField_a_of_type_Qtr.b())
    {
      this.a.a.jdField_a_of_type_Qtr.e(true);
      this.a.a.jdField_a_of_type_Qtr.a().j();
    }
    while ((this.a.a.jdField_a_of_type_Boolean) || (!this.a.a.jdField_a_of_type_Qtr.d())) {
      return;
    }
    this.a.a.jdField_a_of_type_Qtr.d(true);
    this.a.a.jdField_a_of_type_Qtr.a().j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.6
 * JD-Core Version:    0.7.0.1
 */