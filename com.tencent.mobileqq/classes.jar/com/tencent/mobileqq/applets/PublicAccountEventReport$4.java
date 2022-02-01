package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;

final class PublicAccountEventReport$4
  implements Runnable
{
  PublicAccountEventReport$4(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = PublicAccountEventReport.a(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      int i = (int)(System.currentTimeMillis() / 1000L);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("_");
      localStringBuilder.append(i);
      localObject = new TianShuReportData(localStringBuilder.toString(), 1, this.jdField_a_of_type_Int, 1, "vab_push", "vab_push", (String)localObject, "vab_push", i);
      ((TianShuReportData)localObject).l = this.jdField_a_of_type_JavaLangString;
      ((TianShuReportData)localObject).jdField_f_of_type_JavaLangString = "vab_push";
      if (this.jdField_a_of_type_Boolean) {
        i = 6;
      } else {
        i = -1;
      }
      ((TianShuReportData)localObject).jdField_f_of_type_Int = i;
      ((TianShuReportData)localObject).m = this.c;
      ((TianShuReportData)localObject).k = this.d;
      TianShuManager.getInstance().report((TianShuReportData)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.4
 * JD-Core Version:    0.7.0.1
 */