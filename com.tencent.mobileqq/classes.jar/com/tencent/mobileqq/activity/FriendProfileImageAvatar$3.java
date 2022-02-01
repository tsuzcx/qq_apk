package com.tencent.mobileqq.activity;

import aeqv;
import android.os.Message;
import android.text.TextUtils;
import auog;
import axxb;
import bhhz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.os.MqqHandler;

public class FriendProfileImageAvatar$3
  implements Runnable
{
  public FriendProfileImageAvatar$3(aeqv paramaeqv, String paramString) {}
  
  public void run()
  {
    if (auog.a(bhhz.b(String.valueOf(this.a)))) {
      if (axxb.a()) {
        axxb.a("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 1", new Object[0]);
      }
    }
    do
    {
      return;
      if (!this.this$0.c) {
        break;
      }
    } while (!axxb.a());
    axxb.a("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 2", new Object[0]);
    return;
    this.this$0.c = true;
    Setting localSetting = (Setting)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().find(Setting.class, this.a);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      localMessage.obj = localSetting;
      if (this.this$0.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
    }
    for (;;)
    {
      this.this$0.c = false;
      if (!axxb.a()) {
        break;
      }
      axxb.a("Q.profilecard.Avatar", "downloadHDAvatar end of makingHDUrl", new Object[0]);
      return;
      this.this$0.jdField_a_of_type_Boolean = true;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.3
 * JD-Core Version:    0.7.0.1
 */