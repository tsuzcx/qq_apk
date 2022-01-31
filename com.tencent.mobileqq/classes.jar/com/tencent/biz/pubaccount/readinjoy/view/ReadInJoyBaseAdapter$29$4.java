package com.tencent.biz.pubaccount.readinjoy.view;

import qtu;
import qvd;
import rap;
import rbe;

public class ReadInJoyBaseAdapter$29$4
  implements Runnable
{
  public ReadInJoyBaseAdapter$29$4(rbe paramrbe) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    if (this.a.a.jdField_a_of_type_Qtu.b())
    {
      this.a.a.jdField_a_of_type_Qtu.e(true);
      this.a.a.jdField_a_of_type_Qtu.a().j();
    }
    while ((this.a.a.jdField_a_of_type_Boolean) || (!this.a.a.jdField_a_of_type_Qtu.d())) {
      return;
    }
    this.a.a.jdField_a_of_type_Qtu.d(true);
    this.a.a.jdField_a_of_type_Qtu.a().j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.4
 * JD-Core Version:    0.7.0.1
 */