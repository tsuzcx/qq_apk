package com.tencent.mobileqq.activity;

import afca;
import afcb;
import android.text.TextUtils;
import bgss;
import bgst;
import java.util.ArrayList;

public class TroopClassChoiceActivity$GetClassChoiceCallBack$1
  implements Runnable
{
  public TroopClassChoiceActivity$GetClassChoiceCallBack$1(afca paramafca) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_JavaLangString)) {
      this.a.a.jdField_a_of_type_JavaUtilArrayList = bgst.a(this.a.a).a();
    }
    for (;;)
    {
      TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
      return;
      this.a.a.jdField_a_of_type_JavaUtilArrayList = bgst.a(this.a.a).a(this.a.a.jdField_a_of_type_JavaLangString);
      if ((this.a.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        bgss localbgss = (bgss)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localbgss.jdField_a_of_type_Bgss != null) {
          this.a.a.setTitle(localbgss.jdField_a_of_type_Bgss.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack.1
 * JD-Core Version:    0.7.0.1
 */