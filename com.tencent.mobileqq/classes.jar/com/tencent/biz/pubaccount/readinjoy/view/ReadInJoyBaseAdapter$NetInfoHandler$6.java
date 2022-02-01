package com.tencent.biz.pubaccount.readinjoy.view;

import rvy;
import rwu;
import sel;
import sgb;

public class ReadInJoyBaseAdapter$NetInfoHandler$6
  implements Runnable
{
  public ReadInJoyBaseAdapter$NetInfoHandler$6(sgb paramsgb) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    if (this.a.a.jdField_a_of_type_Rvy.b())
    {
      this.a.a.jdField_a_of_type_Rvy.e(true);
      this.a.a.jdField_a_of_type_Rvy.a().m();
    }
    while ((this.a.a.jdField_a_of_type_Boolean) || (!this.a.a.jdField_a_of_type_Rvy.d())) {
      return;
    }
    this.a.a.jdField_a_of_type_Rvy.d(true);
    this.a.a.jdField_a_of_type_Rvy.a().m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.6
 * JD-Core Version:    0.7.0.1
 */