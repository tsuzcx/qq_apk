package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import bdik;
import com.tencent.qphone.base.util.QLog;
import rzr;

public class ViolaBaseView$16$1
  implements Runnable
{
  public ViolaBaseView$16$1(rzr paramrzr, String paramString) {}
  
  public void run()
  {
    String str2 = ViolaBaseView.a();
    StringBuilder localStringBuilder = new StringBuilder().append("loadJSSource process from downJsFromNet url: ").append(this.jdField_a_of_type_Rzr.a.jdField_a_of_type_JavaLangString).append(" , js source Md5 :");
    if (!TextUtils.isEmpty(ViolaBaseView.b(this.jdField_a_of_type_Rzr.a))) {}
    for (String str1 = ViolaBaseView.b(this.jdField_a_of_type_Rzr.a);; str1 = "")
    {
      QLog.d(str2, 2, bdik.d(str1) + " js down source MD5 " + bdik.d(this.jdField_a_of_type_JavaLangString));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.16.1
 * JD-Core Version:    0.7.0.1
 */