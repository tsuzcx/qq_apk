package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

class FriendProfileImageAvatar$4
  implements Runnable
{
  FriendProfileImageAvatar$4(FriendProfileImageAvatar paramFriendProfileImageAvatar, String paramString1, byte paramByte, String paramString2) {}
  
  public void run()
  {
    Object localObject2 = FaceUtil.b(String.valueOf(this.jdField_a_of_type_JavaLangString));
    if (FileUtil.b((String)localObject2))
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 2", new Object[0]);
      }
      return;
    }
    if (this.this$0.b)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar is downloading and return 2", new Object[0]);
      }
      return;
    }
    Object localObject1 = this.this$0;
    int j = 1;
    ((FriendProfileImageAvatar)localObject1).b = true;
    int i = this.jdField_a_of_type_Byte;
    if ((i & 0x20) != 0) {
      i = 0;
    } else if ((i & 0x10) != 0) {
      i = 640;
    } else if ((i & 0x8) != 0) {
      i = 140;
    } else if ((i & 0x4) != 0) {
      i = 100;
    } else {
      i = 40;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(i);
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      this.this$0.jdField_a_of_type_JavaNetURL = new URL((String)localObject1);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.Avatar", 2, localMalformedURLException.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("downloadHDAvatar()  uin=");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(", mgSize=");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(", url = ");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject3).toString());
    }
    localObject2 = new File((String)localObject2);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((File)localObject2).getPath());
    ((StringBuilder)localObject3).append(Long.toString(System.currentTimeMillis()));
    localObject3 = new File(((StringBuilder)localObject3).toString());
    boolean bool1;
    if (HttpDownloadUtil.downloadData(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new DownloadInfo(MsfSdkUtils.insertMtype("friendlist", (String)localObject1), (File)localObject3, 0), this.this$0) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = ((File)localObject3).renameTo((File)localObject2);
    }
    if (this.this$0.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      localObject1 = Message.obtain();
      ((Message)localObject1).what = 3;
      if (bool2) {
        i = j;
      } else {
        i = 0;
      }
      ((Message)localObject1).arg1 = i;
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject1);
    }
    this.this$0.b = false;
    if (NearbyUtils.a()) {
      NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar end of downloading", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.4
 * JD-Core Version:    0.7.0.1
 */