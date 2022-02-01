package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramFace2FaceAddContactFragment.getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler = ((Face2FaceAddContactHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FACE2FACE_ADD_FRIEND_HANDLER));
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + System.currentTimeMillis() + "_" + (int)Math.floor(Math.random() * 100000.0D) % 100000;
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
      localStringBuffer.append("generateGPSInfo GPS: ").append(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).append(",").append(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
      this.jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS = localGPS;
      if (QLog.isColorLevel()) {
        QLog.i("Face2FaceAddContactPresenter", 2, localStringBuffer.toString());
      }
    }
    return this.jdField_a_of_type_TencentImNearfield_friendNearfield_friend$GPS;
  }
  
  private void a(FragmentActivity paramFragmentActivity, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      if (paramFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        paramFragmentActivity.requestPermissions(new Face2FaceAddContactPresenter.2(this, paramBoolean, paramString1, paramString2), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
    }
    while (!paramBoolean)
    {
      do
      {
        return;
      } while (!paramBoolean);
      a(paramString1, paramString2);
      return;
    }
    a(paramString1, paramString2);
  }
  
  private void a(SosoLbsInfo paramSosoLbsInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = a();
    nearfield_friend.GPS localGPS = a(paramSosoLbsInfo);
    paramSosoLbsInfo = null;
    if (!TextUtils.isEmpty(paramString2)) {
      paramSosoLbsInfo = paramString2.getBytes();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler.a(this.jdField_a_of_type_JavaLangString, paramString1, localGPS, paramSosoLbsInfo);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadManager.post(new Face2FaceAddContactPresenter.3(this, paramString1, paramString2), 8, null, false);
  }
  
  private void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      if (paramInt2 == 2) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.f();
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null)
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt2 != 3) {
                  break;
                }
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null);
              this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.b(paramString3);
              return;
              switch (paramInt1)
              {
              default: 
                return;
              case 0: 
                this.jdField_a_of_type_Int = Math.max(paramInt3 * 1000, 10000);
                this.b = Math.max(paramInt4 * 1000, 10000);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.a(this.b);
                  this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.b(this.jdField_a_of_type_Int);
                }
                c();
                return;
              }
            } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.g();
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.c();
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.d();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.e();
  }
  
  private void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.jdField_a_of_type_JavaLangString))) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null);
        if ((paramList != null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.a(paramList);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.b(this.jdField_a_of_type_Int);
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.c();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceIFace2FaceAddContact.d();
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new Face2FaceAddContactPresenter.1(this), 300000L);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void a(FragmentActivity paramFragmentActivity)
  {
    a(paramFragmentActivity, false, "", "");
  }
  
  public void a(FragmentActivity paramFragmentActivity, String paramString1, String paramString2)
  {
    a(paramFragmentActivity, true, paramString1, paramString2);
  }
  
  public void a(List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "sendFace2FaceAddContactHeartBeatReq mSessionId:" + this.jdField_a_of_type_JavaLangString + " faceFriends:" + paramList);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler.a(this.jdField_a_of_type_JavaLangString, paramList);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "sendExitFace2FaceAddContactReq mSessionId:" + this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactHandler.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter
 * JD-Core Version:    0.7.0.1
 */