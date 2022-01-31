package com.tencent.biz.pubaccount.readinjoy.view;

import rjg;
import rkp;
import rqj;
import rqy;

public class ReadInJoyBaseAdapter$29$4
  implements Runnable
{
  public ReadInJoyBaseAdapter$29$4(rqy paramrqy) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    if (this.a.a.jdField_a_of_type_Rjg.b())
    {
      this.a.a.jdField_a_of_type_Rjg.e(true);
      this.a.a.jdField_a_of_type_Rjg.a().l();
    }
    while ((this.a.a.jdField_a_of_type_Boolean) || (!this.a.a.jdField_a_of_type_Rjg.d())) {
      return;
    }
    this.a.a.jdField_a_of_type_Rjg.d(true);
    this.a.a.jdField_a_of_type_Rjg.a().l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.4
 * JD-Core Version:    0.7.0.1
 */