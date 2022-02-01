package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import apau;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;

public final class PublicAccountEventReport$4
  implements Runnable
{
  public PublicAccountEventReport$4(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = apau.a(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = (int)(System.currentTimeMillis() / 1000L);
      localObject = new TianShuReportData(this.b + "_" + i, 1, this.jdField_a_of_type_Int, 1, "vab_push", "vab_push", (String)localObject, "vab_push", i);
      ((TianShuReportData)localObject).mTriggerInfo = this.jdField_a_of_type_JavaLangString;
      ((TianShuReportData)localObject).mPageId = "vab_push";
      if (!this.jdField_a_of_type_Boolean) {
        break label125;
      }
    }
    label125:
    for (int i = 6;; i = -1)
    {
      ((TianShuReportData)localObject).mActionAttr = i;
      ((TianShuReportData)localObject).mBusiInfo = this.c;
      ((TianShuReportData)localObject).mPositionId = this.d;
      TianShuManager.getInstance().report((TianShuReportData)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.4
 * JD-Core Version:    0.7.0.1
 */