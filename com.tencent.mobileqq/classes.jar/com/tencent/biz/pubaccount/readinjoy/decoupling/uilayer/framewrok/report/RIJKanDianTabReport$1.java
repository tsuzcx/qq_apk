package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import bmhv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import pqc;
import prp;

public final class RIJKanDianTabReport$1
  implements Runnable
{
  public RIJKanDianTabReport$1(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str3 = "";
    String str1 = "";
    int i;
    String str4;
    label33:
    String str2;
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo == null)
    {
      i = 1;
      if (i != 3) {
        break label81;
      }
      str4 = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_content.get();
      str2 = "";
      if (bmhv.m()) {
        break label163;
      }
      localMessageRecord = prp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localMessageRecord != null) {
        break label88;
      }
    }
    label81:
    label88:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_type.get() == 5)
        {
          i = 3;
          break;
        }
        i = 2;
        break;
        str4 = "0";
        break label33;
      } while (!prp.a(localMessageRecord));
      if (!prp.a(localMessageRecord)) {
        break label141;
      }
      str2 = pqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
      str3 = pqc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
      str1 = pqc.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
    } while (pqc.a());
    for (;;)
    {
      label141:
      pqc.a(str3, str1, i, str4, str2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      pqc.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo);
      return;
      label163:
      if (i == 1) {
        break;
      }
      str3 = "";
      str2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport.1
 * JD-Core Version:    0.7.0.1
 */