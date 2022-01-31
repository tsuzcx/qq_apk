package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import bcdu;
import com.tencent.qphone.base.util.QLog;
import rnc;

public class ViolaBaseView$16$1
  implements Runnable
{
  public ViolaBaseView$16$1(rnc paramrnc, String paramString) {}
  
  public void run()
  {
    String str2 = ViolaBaseView.a();
    StringBuilder localStringBuilder = new StringBuilder().append("loadJSSource process from downJsFromOfflineForNext url: ").append(this.jdField_a_of_type_Rnc.a.jdField_a_of_type_JavaLangString).append(" , js source Md5 :");
    if (!TextUtils.isEmpty(ViolaBaseView.b(this.jdField_a_of_type_Rnc.a))) {}
    for (String str1 = ViolaBaseView.b(this.jdField_a_of_type_Rnc.a);; str1 = "")
    {
      QLog.d(str2, 2, bcdu.d(str1) + " js down source MD5 " + bcdu.d(this.jdField_a_of_type_JavaLangString));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.16.1
 * JD-Core Version:    0.7.0.1
 */