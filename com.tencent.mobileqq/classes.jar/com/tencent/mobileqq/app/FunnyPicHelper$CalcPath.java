package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.qphone.base.util.QLog;

class FunnyPicHelper$CalcPath
{
  private CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  private VipComicMqqManager jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqManager;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public FunnyPicHelper$CalcPath(VipComicMqqManager paramVipComicMqqManager, CustomEmotionData paramCustomEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqManager = paramVipComicMqqManager;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
  }
  
  public CalcPath a()
  {
    this.jdField_a_of_type_JavaLangString = AppConstants.SDCARD_IMG_FAVORITE;
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqManager != null) && (this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqManager.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData))) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath.startsWith(AppConstants.SDCARD_IMG_FAVORITE))) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath;
      }
    }
    do
    {
      return this;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqManager.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
        return this;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid))
      {
        this.jdField_a_of_type_JavaLangString += DiySecureFileHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid);
        return this;
      }
      this.jdField_a_of_type_JavaLangString += this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.substring(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.lastIndexOf("/") + 1);
      return this;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.contains("qto_"))
      {
        this.jdField_a_of_type_JavaLangString += FunnyPicHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url);
        return this;
      }
      if (TextUtils.isEmpty(FunnyPicHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId))) {
        break;
      }
      this.jdField_a_of_type_JavaLangString += this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId;
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("FunyPicHelper", 2, "emotion is FunnyPic path download from server->" + this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId);
    return this;
    this.jdField_a_of_type_JavaLangString += this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FunnyPicHelper.CalcPath
 * JD-Core Version:    0.7.0.1
 */