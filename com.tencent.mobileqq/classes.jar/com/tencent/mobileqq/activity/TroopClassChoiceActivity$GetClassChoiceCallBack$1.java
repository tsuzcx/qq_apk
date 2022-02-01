package com.tencent.mobileqq.activity;

import afrz;
import afsa;
import android.text.TextUtils;
import bhap;
import bhaq;
import java.util.ArrayList;

public class TroopClassChoiceActivity$GetClassChoiceCallBack$1
  implements Runnable
{
  public TroopClassChoiceActivity$GetClassChoiceCallBack$1(afrz paramafrz) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_JavaLangString)) {
      this.a.a.jdField_a_of_type_JavaUtilArrayList = bhaq.a(this.a.a).a();
    }
    for (;;)
    {
      TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
      return;
      this.a.a.jdField_a_of_type_JavaUtilArrayList = bhaq.a(this.a.a).a(this.a.a.jdField_a_of_type_JavaLangString);
      if ((this.a.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        bhap localbhap = (bhap)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localbhap.jdField_a_of_type_Bhap != null) {
          this.a.a.setTitle(localbhap.jdField_a_of_type_Bhap.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack.1
 * JD-Core Version:    0.7.0.1
 */