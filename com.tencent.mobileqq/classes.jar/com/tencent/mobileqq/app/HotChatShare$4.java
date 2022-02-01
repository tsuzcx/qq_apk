package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;

class HotChatShare$4
  implements Runnable
{
  HotChatShare$4(HotChatShare paramHotChatShare) {}
  
  public void run()
  {
    Object localObject = "stranger_" + String.valueOf(200) + "_" + this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin;
    localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSettingFromDb((String)localObject);
    if ((localObject != null) && (!TextUtils.isEmpty(((Setting)localObject).url))) {
      this.this$0.b = (((Setting)localObject).url + "140");
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.fromdb.ownerHeadUrl=" + this.this$0.b);
    }
    if (!TextUtils.isEmpty(this.this$0.b)) {
      if (this.this$0.jdField_a_of_type_Int == 0) {
        this.this$0.jdField_a_of_type_Int = 2;
      }
    }
    for (;;)
    {
      if (this.this$0.jdField_a_of_type_Int == 3) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new HotChatShare.4.1(this));
      }
      return;
      if (this.this$0.jdField_a_of_type_Int == 1)
      {
        this.this$0.jdField_a_of_type_Int = 3;
        continue;
        ((IQQAvatarHandlerService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getStrangerHead(this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin, 200, (byte)1, (byte)3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatShare.4
 * JD-Core Version:    0.7.0.1
 */