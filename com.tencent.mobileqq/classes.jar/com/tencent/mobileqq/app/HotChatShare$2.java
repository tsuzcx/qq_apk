package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class HotChatShare$2
  extends FriendListObserver
{
  HotChatShare$2(HotChatShare paramHotChatShare) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "onGetFriendDateNick.isSuccess=" + paramBoolean + ",uin=" + paramString1 + ",nick=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin)) || (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        this.a.jdField_a_of_type_JavaLangString = paramString2;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        if (this.a.jdField_a_of_type_Int == 0) {
          this.a.jdField_a_of_type_Int = 1;
        }
        while (this.a.jdField_a_of_type_Int == 3)
        {
          this.a.c();
          HotChatShare.a(this.a);
          return;
          if (this.a.jdField_a_of_type_Int == 2) {
            this.a.jdField_a_of_type_Int = 3;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatShare.2
 * JD-Core Version:    0.7.0.1
 */