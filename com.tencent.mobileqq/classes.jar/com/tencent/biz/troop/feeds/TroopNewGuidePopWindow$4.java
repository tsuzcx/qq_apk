package com.tencent.biz.troop.feeds;

import android.os.Handler;
import axqw;
import azpe;
import balq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import wzw;

public class TroopNewGuidePopWindow$4
  implements Runnable
{
  public TroopNewGuidePopWindow$4(wzw paramwzw, JSONObject paramJSONObject, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    int j = 1;
    this.this$0.jdField_a_of_type_Azpe = azpe.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b, this.jdField_a_of_type_OrgJsonJSONObject);
    this.this$0.g = this.jdField_a_of_type_Boolean;
    String str1;
    if (this.this$0.jdField_a_of_type_Azpe != null)
    {
      boolean bool = balq.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b, this.this$0.jdField_a_of_type_Azpe.i);
      balq.d(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, isRead = " + bool + ", mTroopNotify. mTroopNotify.isShowTipWindow = " + this.this$0.jdField_a_of_type_Azpe.b + ", isRemindNotice = " + this.jdField_a_of_type_Boolean);
      }
      if ((!this.this$0.jdField_a_of_type_Azpe.g.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) && (((this.this$0.jdField_a_of_type_Azpe.b) && (!bool)) || (this.jdField_a_of_type_Boolean)))
      {
        localObject = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        str1 = "";
        if (localObject == null) {
          break label422;
        }
      }
    }
    label422:
    for (Object localObject = ((TroopManager)localObject).b(this.this$0.b);; localObject = null)
    {
      if (localObject != null) {
        str1 = "" + ((TroopInfo)localObject).dwGroupClassExt;
      }
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str2 = this.this$0.b;
      if (this.this$0.jdField_a_of_type_Azpe.c) {}
      for (int i = 2;; i = 1)
      {
        if (this.this$0.g) {
          j = 2;
        }
        axqw.b((QQAppInterface)localObject, "dc00898", "", "", "0X800AAC7", "0X800AAC7", 0, 0, str2, str1, String.valueOf(i), String.valueOf(j));
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "initViewInThread showing popup window for troopNotice");
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopNewGuidePopWindow.4.1(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, mTroopNotify is null!");
      }
      balq.d(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.4
 * JD-Core Version:    0.7.0.1
 */