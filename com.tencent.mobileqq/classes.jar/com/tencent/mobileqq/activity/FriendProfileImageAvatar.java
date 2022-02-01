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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.d))) {
      return FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.d);
    }
    return null;
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
    Object localObject;
    if (paramProfileImageInfo.jdField_a_of_type_Int == 0)
    {
      paramProfileImageInfo.jdField_a_of_type_Int = 1;
    }
    else if ((!paramBoolean) && (paramProfileImageInfo.jdField_a_of_type_Int == 3))
    {
      paramProfileImageInfo.jdField_a_of_type_Int = 4;
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessageDelayed(4, 400L);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load: uin=");
      ((StringBuilder)localObject).append(paramProfileImageInfo.d);
      ((StringBuilder)localObject).append(",state=");
      ((StringBuilder)localObject).append(paramProfileImageInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", bState=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", bGetHeadInfo=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", isFromClickEvent=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    paramBaseActivity = this.jdField_a_of_type_MqqOsMqqHandler;
    if (paramBaseActivity != null) {
      paramBaseActivity.removeCallbacksAndMessages(null);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHttpStart() url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaNetURL;
    if ((localObject != null) && (((URL)localObject).toString().equals(paramString)))
    {
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt;
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_JavaNetURL;
    if ((localObject != null) && (((URL)localObject).toString().equals(paramString)))
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      if ((paramString != null) && (paramString.hasMessages(1))) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      paramString = Message.obtain();
      paramString.what = 1;
      paramString.arg1 = ((int)((float)paramLong2 / (float)paramLong1 * 100.0F));
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(paramString);
      }
    }
  }
  
  void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    try
    {
      int i = paramProfileImageInfo.jdField_a_of_type_Int;
      if (FileUtil.b(paramProfileImageInfo.c))
      {
        paramProfileImageInfo.jdField_a_of_type_Int = 6;
        paramProfileImageInfo.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
        }
      }
      else if (FileUtil.b(paramProfileImageInfo.jdField_b_of_type_JavaLangString))
      {
        paramProfileImageInfo.jdField_a_of_type_Int = 3;
      }
      else
      {
        paramProfileImageInfo.jdField_a_of_type_Int = 0;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateState: uin=");
        localStringBuilder.append(paramProfileImageInfo.d);
        localStringBuilder.append(",state=");
        localStringBuilder.append(paramProfileImageInfo.jdField_a_of_type_Int);
        localStringBuilder.append(", beforeState=");
        localStringBuilder.append(i);
        QLog.d("Q.profilecard.Avatar", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
  }
  
  public void b(String paramString, int paramInt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        localObject = null;
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return true;
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("MSG_DOWNLOAD_HD_AVATAR ");
              localStringBuilder.append(paramMessage.obj);
              QLog.i("Q.profilecard.Avatar", 2, localStringBuilder.toString());
            }
            if ((paramMessage.obj instanceof Setting)) {
              localObject = (Setting)paramMessage.obj;
            }
            if ((localObject != null) && (!((Setting)localObject).url.equals(this.jdField_a_of_type_JavaLangString)))
            {
              this.jdField_a_of_type_JavaLangString = ((Setting)localObject).url;
              a(((Setting)localObject).uin, ((Setting)localObject).bFaceFlags, ((Setting)localObject).url);
              return true;
            }
            if (QLog.isColorLevel())
            {
              paramMessage = new StringBuilder();
              paramMessage.append("MSG_DOWNLOAD_HD_AVATAR | has download path = ");
              paramMessage.append(this.jdField_a_of_type_JavaLangString);
              QLog.i("Q.profilecard.Avatar", 2, paramMessage.toString());
              return true;
            }
          }
          else
          {
            a(this.jdField_b_of_type_JavaLangString);
            return true;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("end result : ");
            ((StringBuilder)localObject).append(paramMessage.arg1);
            QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
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
          i = this.jdField_a_of_type_Int;
          if (i < 3)
          {
            this.jdField_a_of_type_Int = (i + 1);
            this.jdField_a_of_type_JavaLangString = null;
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start progress : ");
          ((StringBuilder)localObject).append(paramMessage.arg1);
          QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_b_of_type_Int = 0;
        c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refresh progress : ");
        ((StringBuilder)localObject).append(paramMessage.arg1);
        QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.jdField_b_of_type_Int = paramMessage.arg1;
      c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar
 * JD-Core Version:    0.7.0.1
 */