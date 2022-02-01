package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Timer;
import tencent.im.nearfield_friend.nearfield_friend.GPS;

public class Face2FaceAddContactPresenter
{
  private int jdField_a_of_type_Int = 60000;
  private Face2FaceAddContactHandler jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler;
  private Face2FaceAddContactObserver jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactObserver = new Face2FaceAddContactPresenter.4(this);
  private IFace2FaceAddContact jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new Face2FaceAddContactPresenter.5(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private nearfield_friend.GPS jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS;
  private int b = 1200000;
  
  public Face2FaceAddContactPresenter(Face2FaceAddContactFragment paramFace2FaceAddContactFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact = paramFace2FaceAddContactFragment;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramFace2FaceAddContactFragment.getBaseActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler = ((Face2FaceAddContactHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FACE2FACE_ADD_FRIEND_HANDLER));
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("_");
      localStringBuilder.append((int)Math.floor(Math.random() * 100000.0D) % 100000);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private nearfield_friend.GPS a(SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      nearfield_friend.GPS localGPS = new nearfield_friend.GPS();
      localGPS.lat.set((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      localGPS.lng.set((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      localGPS.type.set(1);
      localStringBuffer.append("generateGPSInfo GPS: ");
      localStringBuffer.append(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D);
      localStringBuffer.append(",");
      localStringBuffer.append(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
      this.jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS = localGPS;
      if (QLog.isColorLevel()) {
        QLog.i("Face2FaceAddContactPresenter", 2, localStringBuffer.toString());
      }
    }
    return this.jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS;
  }
  
  private void a(BaseActivity paramBaseActivity, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        paramBaseActivity.requestPermissions(new Face2FaceAddContactPresenter.2(this, paramBoolean, paramString1, paramString2), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      if (paramBoolean) {
        a(paramString1, paramString2);
      }
    }
    else if (paramBoolean)
    {
      a(paramString1, paramString2);
    }
  }
  
  private void a(SosoLbsInfo paramSosoLbsInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = a();
    nearfield_friend.GPS localGPS = a(paramSosoLbsInfo);
    if (!TextUtils.isEmpty(paramString2)) {
      paramSosoLbsInfo = paramString2.getBytes();
    } else {
      paramSosoLbsInfo = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler.a(this.jdField_a_of_type_JavaLangString, paramString1, localGPS, paramSosoLbsInfo);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadManager.post(new Face2FaceAddContactPresenter.3(this, paramString1, paramString2), 8, null, false);
  }
  
  private void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (paramInt2 == 2)
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
        if (paramString1 != null) {
          paramString1.f();
        }
      }
      else if (paramInt2 == 3)
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
        if (paramString1 != null) {
          paramString1.b(paramString3);
        }
      }
      else if (paramInt1 != 0)
      {
        switch (paramInt1)
        {
        default: 
          return;
        case 10007: 
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
          if (paramString1 == null) {
            break;
          }
          paramString1.g();
          return;
        case 10006: 
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
          if (paramString1 == null) {
            break;
          }
          paramString1.c();
          return;
        case 10005: 
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
          if (paramString1 == null) {
            break;
          }
          paramString1.d();
          return;
        case 10004: 
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
          if (paramString1 == null) {
            break;
          }
          paramString1.e();
          return;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = Math.max(paramInt3 * 1000, 10000);
        this.b = Math.max(paramInt4 * 1000, 10000);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
        if (paramString1 != null)
        {
          paramString1.a(this.b);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.b(this.jdField_a_of_type_Int);
        }
        c();
      }
    }
    else
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
      if (paramString1 != null) {
        paramString1.e();
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.jdField_a_of_type_JavaLangString))) {
      if (paramInt != 0)
      {
        if (paramInt != 10005)
        {
          if (paramInt != 10006) {
            return;
          }
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
          if (paramString1 != null) {
            paramString1.c();
          }
        }
        else
        {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact;
          if (paramString1 != null) {
            paramString1.d();
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact != null)
      {
        if ((paramList != null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.a(paramList);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.b(this.jdField_a_of_type_Int);
      }
    }
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new Face2FaceAddContactPresenter.1(this), 300000L);
  }
  
  private void d()
  {
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      b();
    }
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact = null;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    a(paramBaseActivity, false, "", "");
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString1, String paramString2)
  {
    a(paramBaseActivity, true, paramString1, paramString2);
  }
  
  public void a(List<String> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendFace2FaceAddContactHeartBeatReq mSessionId:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" faceFriends:");
      localStringBuilder.append(paramList);
      QLog.d("Face2FaceAddContactPresenter", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler.a(this.jdField_a_of_type_JavaLangString, paramList);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendExitFace2FaceAddContactReq mSessionId:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("Face2FaceAddContactPresenter", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter
 * JD-Core Version:    0.7.0.1
 */