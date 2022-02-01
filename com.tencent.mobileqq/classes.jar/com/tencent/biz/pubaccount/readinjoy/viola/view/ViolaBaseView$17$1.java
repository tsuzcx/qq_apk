package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import bita;
import com.tencent.qphone.base.util.QLog;
import tsi;

public class ViolaBaseView$17$1
  implements Runnable
{
  public ViolaBaseView$17$1(tsi paramtsi, String paramString) {}
  
  public void run()
  {
    String str2 = ViolaBaseView.a();
    StringBuilder localStringBuilder = new StringBuilder().append("loadJSSource process from downJsFromOfflineForNext url: ").append(this.jdField_a_of_type_Tsi.a.jdField_a_of_type_JavaLangString).append(" , js source Md5 :");
    if (!TextUtils.isEmpty(ViolaBaseView.b(this.jdField_a_of_type_Tsi.a))) {}
    for (String str1 = ViolaBaseView.b(this.jdField_a_of_type_Tsi.a);; str1 = "")
    {
      QLog.d(str2, 2, bita.d(str1) + " js down source MD5 " + bita.d(this.jdField_a_of_type_JavaLangString));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.17.1
 * JD-Core Version:    0.7.0.1
 */