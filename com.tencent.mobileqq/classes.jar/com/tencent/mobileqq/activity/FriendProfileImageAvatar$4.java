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

class FriendProfileImageAvatar$4
  implements Runnable
{
  FriendProfileImageAvatar$4(FriendProfileImageAvatar paramFriendProfileImageAvatar, String paramString) {}
  
  public void run()
  {
    if (FileUtil.d(FaceUtil.c(String.valueOf(this.a))))
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 1", new Object[0]);
      }
      return;
    }
    if (this.this$0.g)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 2", new Object[0]);
      }
      return;
    }
    Object localObject = this.this$0;
    ((FriendProfileImageAvatar)localObject).g = true;
    localObject = (Setting)((FriendProfileImageAvatar)localObject).l.getEntityManagerFactory().createEntityManager().find(Setting.class, this.a);
    if ((localObject != null) && (!TextUtils.isEmpty(((Setting)localObject).url)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      localMessage.obj = localObject;
      if (this.this$0.b != null) {
        this.this$0.b.sendMessage(localMessage);
      }
    }
    else
    {
      localObject = this.this$0;
      ((FriendProfileImageAvatar)localObject).c = true;
      FriendProfileImageAvatar.a((FriendProfileImageAvatar)localObject, this.a);
    }
    this.this$0.g = false;
    if (NearbyUtils.a()) {
      NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar end of makingHDUrl", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.4
 * JD-Core Version:    0.7.0.1
 */