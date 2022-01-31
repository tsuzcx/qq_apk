package com.tencent.mobileqq.activity.weather;

import aikh;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.List;

public class SessionClearFragment$1$1
  implements Runnable
{
  public SessionClearFragment$1$1(aikh paramaikh, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aikh.a.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Aikh.a.b();
    SessionClearFragment.a(this.jdField_a_of_type_Aikh.a).setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      SessionClearFragment.a(this.jdField_a_of_type_Aikh.a).setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Aikh.a.a(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */