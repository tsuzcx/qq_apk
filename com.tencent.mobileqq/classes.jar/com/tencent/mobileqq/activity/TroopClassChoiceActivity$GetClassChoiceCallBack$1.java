package com.tencent.mobileqq.activity;

import acgp;
import acgq;
import android.text.TextUtils;
import basm;
import basn;
import java.util.ArrayList;

public class TroopClassChoiceActivity$GetClassChoiceCallBack$1
  implements Runnable
{
  public TroopClassChoiceActivity$GetClassChoiceCallBack$1(acgp paramacgp) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_JavaLangString)) {
      this.a.a.jdField_a_of_type_JavaUtilArrayList = basn.a(this.a.a).a();
    }
    for (;;)
    {
      TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
      return;
      this.a.a.jdField_a_of_type_JavaUtilArrayList = basn.a(this.a.a).a(this.a.a.jdField_a_of_type_JavaLangString);
      if ((this.a.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        basm localbasm = (basm)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localbasm.jdField_a_of_type_Basm != null) {
          this.a.a.setTitle(localbasm.jdField_a_of_type_Basm.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack.1
 * JD-Core Version:    0.7.0.1
 */