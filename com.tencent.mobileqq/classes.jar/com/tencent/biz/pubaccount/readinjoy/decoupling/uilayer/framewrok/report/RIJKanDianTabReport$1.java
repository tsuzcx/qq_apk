package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import cooperation.readinjoy.ReadInJoyHelper;

final class RIJKanDianTabReport$1
  implements Runnable
{
  RIJKanDianTabReport$1(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str3 = "";
    String str1 = "";
    int i;
    String str4;
    label33:
    String str2;
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo == null)
    {
      i = 1;
      if (i != 3) {
        break label81;
      }
      str4 = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo.red_content.get();
      str2 = "";
      if (ReadInJoyHelper.n()) {
        break label163;
      }
      localMessageRecord = RIJKanDianFolderStatus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo.red_type.get() == 5)
        {
          i = 3;
          break;
        }
        i = 2;
        break;
        str4 = "0";
        break label33;
      } while (!RIJKanDianFolderStatus.a(localMessageRecord));
      if (!RIJKanDianFolderStatus.a(localMessageRecord)) {
        break label141;
      }
      str2 = RIJKanDianTabReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
      str3 = RIJKanDianTabReport.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
      str1 = RIJKanDianTabReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
    } while (RIJKanDianTabReport.a());
    for (;;)
    {
      label141:
      RIJKanDianTabReport.a(str3, str1, i, str4, str2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      RIJKanDianTabReport.a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport.1
 * JD-Core Version:    0.7.0.1
 */