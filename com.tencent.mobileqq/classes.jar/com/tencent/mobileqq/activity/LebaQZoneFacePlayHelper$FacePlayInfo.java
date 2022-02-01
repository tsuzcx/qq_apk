package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

class LebaQZoneFacePlayHelper$FacePlayInfo
{
  private static int jdField_a_of_type_Int = 0;
  private static FacePlayInfo jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  FaceDrawable jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean;
  private FacePlayInfo b;
  
  static FacePlayInfo a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo != null)
      {
        FacePlayInfo localFacePlayInfo = jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
        jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = localFacePlayInfo.b;
        localFacePlayInfo.b = null;
        jdField_a_of_type_Int -= 1;
        return localFacePlayInfo;
      }
      return new FacePlayInfo();
    }
  }
  
  static FacePlayInfo a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    FacePlayInfo localFacePlayInfo = a();
    localFacePlayInfo.jdField_a_of_type_JavaLangString = paramString;
    FaceDrawable localFaceDrawable = localFacePlayInfo.a();
    if (localFaceDrawable != null) {
      localFaceDrawable.cancel();
    }
    localFacePlayInfo.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable = FaceDrawable.getUserFaceDrawable(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localFacePlayInfo.jdField_a_of_type_Boolean = false;
    return localFacePlayInfo;
  }
  
  FaceDrawable a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Boolean = true;
    ??? = a();
    if (??? != null) {
      ((FaceDrawable)???).cancel();
    }
    this.jdField_a_of_type_JavaLangString = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 3)
      {
        this.b = jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo;
        jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper$FacePlayInfo = this;
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean a(String paramString)
  {
    return (!this.jdField_a_of_type_Boolean) && (paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper.FacePlayInfo
 * JD-Core Version:    0.7.0.1
 */