package com.tencent.biz.pubaccount.readinjoy.view;

import seu;
import sfq;
import snh;
import sox;

public class ReadInJoyBaseAdapter$NetInfoHandler$4
  implements Runnable
{
  public ReadInJoyBaseAdapter$NetInfoHandler$4(sox paramsox) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    if (this.a.a.jdField_a_of_type_Seu.b())
    {
      this.a.a.jdField_a_of_type_Seu.e(true);
      this.a.a.jdField_a_of_type_Seu.a().m();
    }
    while ((this.a.a.jdField_a_of_type_Boolean) || (!this.a.a.jdField_a_of_type_Seu.d())) {
      return;
    }
    this.a.a.jdField_a_of_type_Seu.d(true);
    this.a.a.jdField_a_of_type_Seu.a().m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.4
 * JD-Core Version:    0.7.0.1
 */