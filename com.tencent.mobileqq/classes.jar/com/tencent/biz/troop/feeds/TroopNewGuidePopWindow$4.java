package com.tencent.biz.troop.feeds;

import aagb;
import android.os.Handler;
import bdla;
import bfid;
import bglm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TroopNewGuidePopWindow$4
  implements Runnable
{
  public TroopNewGuidePopWindow$4(aagb paramaagb, JSONObject paramJSONObject, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    int j = 1;
    this.this$0.jdField_a_of_type_Bfid = bfid.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b, this.jdField_a_of_type_OrgJsonJSONObject);
    this.this$0.g = this.jdField_a_of_type_Boolean;
    String str1;
    if (this.this$0.jdField_a_of_type_Bfid != null)
    {
      boolean bool = bglm.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b, this.this$0.jdField_a_of_type_Bfid.i);
      bglm.d(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, isRead = " + bool + ", mTroopNotify. mTroopNotify.isShowTipWindow = " + this.this$0.jdField_a_of_type_Bfid.b + ", isRemindNotice = " + this.jdField_a_of_type_Boolean);
      }
      if ((!this.this$0.jdField_a_of_type_Bfid.g.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (((this.this$0.jdField_a_of_type_Bfid.b) && (!bool) && (!this.this$0.jdField_a_of_type_Bfid.d)) || (this.jdField_a_of_type_Boolean)))
      {
        localObject = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        str1 = "";
        if (localObject == null) {
          break label436;
        }
      }
    }
    label436:
    for (Object localObject = ((TroopManager)localObject).b(this.this$0.b);; localObject = null)
    {
      if (localObject != null) {
        str1 = "" + ((TroopInfo)localObject).dwGroupClassExt;
      }
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str2 = this.this$0.b;
      if (this.this$0.jdField_a_of_type_Bfid.c) {}
      for (int i = 2;; i = 1)
      {
        if (this.this$0.g) {
          j = 2;
        }
        bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X800AAC7", "0X800AAC7", 0, 0, str2, str1, String.valueOf(i), String.valueOf(j));
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "initViewInThread showing popup window for troopNotice");
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopNewGuidePopWindow.4.1(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, mTroopNotify is null!");
      }
      bglm.d(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.4
 * JD-Core Version:    0.7.0.1
 */