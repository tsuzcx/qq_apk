package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.qphone.base.util.QLog;

class FunnyPicHelper$CalcPath
{
  private CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  private IVipComicMqqManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiIVipComicMqqManagerService;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public FunnyPicHelper$CalcPath(IVipComicMqqManagerService paramIVipComicMqqManagerService, CustomEmotionData paramCustomEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIVipComicMqqManagerService = paramIVipComicMqqManagerService;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
  }
  
  public CalcPath a()
  {
    this.jdField_a_of_type_JavaLangString = AppConstants.SDCARD_IMG_FAVORITE;
    this.jdField_a_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmApiIVipComicMqqManagerService;
    if ((localObject != null) && (((IVipComicMqqManagerService)localObject).isComicEmoticon(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData)))
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath.startsWith(AppConstants.SDCARD_IMG_FAVORITE)))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath;
        return this;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqEmosmApiIVipComicMqqManagerService.getFilePath(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
        return this;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(DiySecureFileHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid));
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.substring(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.lastIndexOf("/") + 1));
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      return this;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.contains("qto_"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(FunnyPicHelperConstant.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url));
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      return this;
    }
    if (!TextUtils.isEmpty(FunnyPicHelperConstant.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("emotion is FunnyPic path download from server->");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId);
        QLog.d("FunyPicHelper", 2, ((StringBuilder)localObject).toString());
        return this;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FunnyPicHelper.CalcPath
 * JD-Core Version:    0.7.0.1
 */