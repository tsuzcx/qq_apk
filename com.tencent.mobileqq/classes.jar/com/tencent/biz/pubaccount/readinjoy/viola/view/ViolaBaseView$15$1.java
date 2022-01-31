package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import bcdu;
import com.tencent.qphone.base.util.QLog;
import rnb;

public class ViolaBaseView$15$1
  implements Runnable
{
  public ViolaBaseView$15$1(rnb paramrnb, String paramString) {}
  
  public void run()
  {
    String str2 = ViolaBaseView.a();
    StringBuilder localStringBuilder = new StringBuilder().append("loadJSSource process from downJsFromNet url: ").append(this.jdField_a_of_type_Rnb.a.jdField_a_of_type_JavaLangString).append(" , js source Md5 :");
    if (!TextUtils.isEmpty(ViolaBaseView.b(this.jdField_a_of_type_Rnb.a))) {}
    for (String str1 = ViolaBaseView.b(this.jdField_a_of_type_Rnb.a);; str1 = "")
    {
      QLog.d(str2, 2, bcdu.d(str1) + " js down source MD5 " + bcdu.d(this.jdField_a_of_type_JavaLangString));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.15.1
 * JD-Core Version:    0.7.0.1
 */