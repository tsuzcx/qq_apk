package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.os.MqqHandler;

public class FriendProfileImageAvatar
  extends FriendProfileImageModel
  implements Handler.Callback, HttpDownloadUtil.HttpDownloadListener
{
  int jdField_a_of_type_Int;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new FriendProfileImageAvatar.2(this);
  String jdField_a_of_type_JavaLangString;
  URL jdField_a_of_type_JavaNetURL = null;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  boolean c = false;
  
  public FriendProfileImageAvatar(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public int a()
  {
    return 1;
  }
  
  public Drawable a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.d)) {
          localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.d);
        }
      }
    }
    return localObject1;
  }
  
  public FriendProfileImageModel.ProfileImageInfo a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo;
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 0) {
      i = 0;
    }
    this.jdField_b_of_type_Int = i;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo, true);
      c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
    }
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = paramProfileImageInfo;
  }
  
  void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, boolean paramBoolean)
  {
    int i = paramProfileImageInfo.jdField_a_of_type_Int;
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && ((paramProfileImageInfo.jdField_a_of_type_Int == 0) || (paramProfileImageInfo.jdField_a_of_type_Int == 3)))
    {
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.postImmediately(new FriendProfileImageAvatar.1(this, paramProfileImageInfo), null, false);
    }
    if (paramProfileImageInfo.jdField_a_of_type_Int == 0) {
      paramProfileImageInfo.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "load: uin=" + paramProfileImageInfo.d + ",state=" + paramProfileImageInfo.jdField_a_of_type_Int + ", bState=" + i + ", bGetHeadInfo=" + this.jdField_a_of_type_Boolean + ", isFromClickEvent=" + paramBoolean);
      }
      return;
      if ((!paramBoolean) && (paramProfileImageInfo.jdField_a_of_type_Int == 3))
      {
        paramProfileImageInfo.jdField_a_of_type_Int = 4;
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(4, 400L);
        }
      }
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_MqqOsMqqHandler = null;
  }
  
  public void a(BaseActivity paramBaseActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    paramProfileImageInfo.jdField_a_of_type_JavaLangString = null;
    paramProfileImageInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCustomFaceFilePath(false, this.jdField_b_of_type_JavaLangString);
    paramProfileImageInfo.c = FaceUtil.b(this.jdField_b_of_type_JavaLangString);
    b(paramProfileImageInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = paramProfileImageInfo;
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar", new Object[] { paramString });
    }
    if (this.c)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 1", new Object[0]);
      }
      return;
    }
    ThreadManager.post(new FriendProfileImageAvatar.3(this, paramString), 5, null, true);
  }
  
  void a(String paramString1, byte paramByte, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_a_of_type_Boolean = true;
    c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
    if (this.jdField_b_of_type_Boolean)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar is downloading and return 1", new Object[0]);
      }
      return;
    }
    ThreadManager.post(new FriendProfileImageAvatar.4(this, paramString1, paramByte, paramString2), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "onHttpStart() url = " + paramString);
    }
    if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.toString().equals(paramString)))
    {
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt;
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.toString().equals(paramString)))
    {
      if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1))) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      paramString = Message.obtain();
      paramString.what = 1;
      paramString.arg1 = ((int)((float)paramLong2 / (float)paramLong1 * 100.0F));
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramString);
      }
    }
  }
  
  void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    for (;;)
    {
      try
      {
        int i = paramProfileImageInfo.jdField_a_of_type_Int;
        if (FileUtil.a(paramProfileImageInfo.c))
        {
          paramProfileImageInfo.jdField_a_of_type_Int = 6;
          paramProfileImageInfo.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
            this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Avatar", 2, "updateState: uin=" + paramProfileImageInfo.d + ",state=" + paramProfileImageInfo.jdField_a_of_type_Int + ", beforeState=" + i);
          }
          return;
        }
        if (FileUtil.a(paramProfileImageInfo.jdField_b_of_type_JavaLangString)) {
          paramProfileImageInfo.jdField_a_of_type_Int = 3;
        } else {
          paramProfileImageInfo.jdField_a_of_type_Int = 0;
        }
      }
      finally {}
    }
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
  }
  
  public void b(String paramString, int paramInt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Setting localSetting = null;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "refresh progress : " + paramMessage.arg1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_b_of_type_Int = paramMessage.arg1;
        c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "start progress : " + paramMessage.arg1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_b_of_type_Int = 0;
        c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        return true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "end result : " + paramMessage.arg1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_b_of_type_Int = 100;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_a_of_type_Boolean = false;
        b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        if (paramMessage.arg1 == 1)
        {
          c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_a_of_type_Int = 5;
        c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
      } while (this.jdField_a_of_type_Int >= 3);
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_JavaLangString = null;
      return true;
      a(this.jdField_b_of_type_JavaLangString);
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "MSG_DOWNLOAD_HD_AVATAR " + paramMessage.obj);
      }
      if ((paramMessage.obj instanceof Setting)) {
        localSetting = (Setting)paramMessage.obj;
      }
      if ((localSetting != null) && (!localSetting.url.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaLangString = localSetting.url;
        a(localSetting.uin, localSetting.bFaceFlags, localSetting.url);
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.Avatar", 2, "MSG_DOWNLOAD_HD_AVATAR | has download path = " + this.jdField_a_of_type_JavaLangString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar
 * JD-Core Version:    0.7.0.1
 */