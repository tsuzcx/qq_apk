package com.tencent.biz.pubaccount.readinjoy.view;

import ocd;
import paa;
import pmk;
import sfv;

public class ReadInJoyBaseAdapter$5$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$5$1(sfv paramsfv, long paramLong, pmk parampmk) {}
  
  public void run()
  {
    paa localpaa1 = new paa();
    paa localpaa2 = localpaa1.a("cost", this.jdField_a_of_type_Long).b("type", this.jdField_a_of_type_Sfv.jdField_a_of_type_Int);
    Object localObject;
    if (this.jdField_a_of_type_Sfv.jdField_a_of_type_JavaLangObject == null)
    {
      localObject = "0";
      localObject = localpaa2.b("result", (String)localObject).b("handleID", this.jdField_a_of_type_Pmk.a());
      if (this.jdField_a_of_type_Sfv.jdField_a_of_type_AndroidViewView != null) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 0)
    {
      ((paa)localObject).b("isNewCreate", i).b("isDebugVersion", 0).b("isPublicVersion", 1);
      ocd.a("0X800AF90", localpaa1.a());
      return;
      localObject = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */