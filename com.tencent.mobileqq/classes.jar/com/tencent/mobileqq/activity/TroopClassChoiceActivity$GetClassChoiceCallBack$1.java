package com.tencent.mobileqq.activity;

import acgl;
import acgm;
import android.text.TextUtils;
import bata;
import batb;
import java.util.ArrayList;

public class TroopClassChoiceActivity$GetClassChoiceCallBack$1
  implements Runnable
{
  public TroopClassChoiceActivity$GetClassChoiceCallBack$1(acgl paramacgl) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_JavaLangString)) {
      this.a.a.jdField_a_of_type_JavaUtilArrayList = batb.a(this.a.a).a();
    }
    for (;;)
    {
      TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
      return;
      this.a.a.jdField_a_of_type_JavaUtilArrayList = batb.a(this.a.a).a(this.a.a.jdField_a_of_type_JavaLangString);
      if ((this.a.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        bata localbata = (bata)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localbata.jdField_a_of_type_Bata != null) {
          this.a.a.setTitle(localbata.jdField_a_of_type_Bata.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack.1
 * JD-Core Version:    0.7.0.1
 */