package com.tencent.biz.pubaccount.readinjoy.view;

import olh;
import pqg;
import qcu;
import sze;

public class ReadInJoyBaseAdapter$1$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$1$1(sze paramsze, long paramLong, qcu paramqcu) {}
  
  public void run()
  {
    pqg localpqg1 = new pqg();
    pqg localpqg2 = localpqg1.a("cost", this.jdField_a_of_type_Long).b("type", this.jdField_a_of_type_Sze.jdField_a_of_type_Int);
    Object localObject;
    if (this.jdField_a_of_type_Sze.jdField_a_of_type_JavaLangObject == null)
    {
      localObject = "0";
      localObject = localpqg2.b("result", (String)localObject).b("handleID", this.jdField_a_of_type_Qcu.a());
      if (this.jdField_a_of_type_Sze.jdField_a_of_type_AndroidViewView != null) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 0)
    {
      ((pqg)localObject).b("isNewCreate", i).b("isDebugVersion", 0).b("isPublicVersion", 1);
      olh.a("0X800AF90", localpqg1.a());
      return;
      localObject = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */