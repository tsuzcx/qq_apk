import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;

class anvp
{
  private asgo jdField_a_of_type_Asgo;
  private CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public anvp(asgo paramasgo, CustomEmotionData paramCustomEmotionData)
  {
    this.jdField_a_of_type_Asgo = paramasgo;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
  }
  
  public anvp a()
  {
    this.jdField_a_of_type_JavaLangString = AppConstants.SDCARD_IMG_FAVORITE;
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Asgo != null) && (this.jdField_a_of_type_Asgo.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData))) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath.startsWith(AppConstants.SDCARD_IMG_FAVORITE))) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath;
      }
    }
    do
    {
      return this;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Asgo.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
        return this;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid))
      {
        this.jdField_a_of_type_JavaLangString += aozu.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid);
        return this;
      }
      this.jdField_a_of_type_JavaLangString += this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.substring(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.lastIndexOf("/") + 1);
      return this;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.contains("qto_"))
      {
        this.jdField_a_of_type_JavaLangString += anvn.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url);
        return this;
      }
      if (TextUtils.isEmpty(anvn.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvp
 * JD-Core Version:    0.7.0.1
 */