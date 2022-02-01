package com.tencent.mobileqq.activity;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import mqq.os.MqqHandler;

class FriendProfileImageAvatar$3
  implements Runnable
{
  FriendProfileImageAvatar$3(FriendProfileImageAvatar paramFriendProfileImageAvatar, String paramString) {}
  
  public void run()
  {
    if (FileUtil.b(FaceUtil.b(String.valueOf(this.a))))
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 1", new Object[0]);
      }
      return;
    }
    if (this.this$0.c)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 2", new Object[0]);
      }
      return;
    }
    Object localObject = this.this$0;
    ((FriendProfileImageAvatar)localObject).c = true;
    localObject = (Setting)((FriendProfileImageAvatar)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().find(Setting.class, this.a);
    if ((localObject != null) && (!TextUtils.isEmpty(((Setting)localObject).url)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      localMessage.obj = localObject;
      if (this.this$0.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
    }
    else
    {
      localObject = this.this$0;
      ((FriendProfileImageAvatar)localObject).jdField_a_of_type_Boolean = true;
      ((FriendProfileImageAvatar)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshFace(this.a);
    }
    this.this$0.c = false;
    if (NearbyUtils.a()) {
      NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar end of makingHDUrl", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.3
 * JD-Core Version:    0.7.0.1
 */