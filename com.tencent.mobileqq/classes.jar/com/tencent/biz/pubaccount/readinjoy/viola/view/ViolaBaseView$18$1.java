package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import uce;

public class ViolaBaseView$18$1
  implements Runnable
{
  public ViolaBaseView$18$1(uce paramuce, String paramString) {}
  
  public void run()
  {
    String str2 = ViolaBaseView.a();
    StringBuilder localStringBuilder = new StringBuilder().append("loadJSSource process from downJsFromOfflineForNext url: ").append(this.jdField_a_of_type_Uce.a.jdField_a_of_type_JavaLangString).append(" , js source Md5 :");
    if (!TextUtils.isEmpty(ViolaBaseView.b(this.jdField_a_of_type_Uce.a))) {}
    for (String str1 = ViolaBaseView.b(this.jdField_a_of_type_Uce.a);; str1 = "")
    {
      QLog.d(str2, 2, MD5Utils.toMD5(str1) + " js down source MD5 " + MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.18.1
 * JD-Core Version:    0.7.0.1
 */