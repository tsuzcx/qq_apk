import android.text.TextUtils;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;

class anzb
{
  private asig jdField_a_of_type_Asig;
  private CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public anzb(asig paramasig, CustomEmotionData paramCustomEmotionData)
  {
    this.jdField_a_of_type_Asig = paramasig;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
  }
  
  public anzb a()
  {
    this.jdField_a_of_type_JavaLangString = antf.bl;
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Asig != null) && (this.jdField_a_of_type_Asig.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData))) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath.startsWith(antf.bl))) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath;
      }
    }
    do
    {
      return this;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Asig.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
        return this;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid))
      {
        this.jdField_a_of_type_JavaLangString += apdf.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.resid);
        return this;
      }
      this.jdField_a_of_type_JavaLangString += this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.substring(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.lastIndexOf("/") + 1);
      return this;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url.contains("qto_"))
      {
        this.jdField_a_of_type_JavaLangString += anyz.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.url);
        return this;
      }
      if (TextUtils.isEmpty(anyz.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.eId))) {
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
 * Qualified Name:     anzb
 * JD-Core Version:    0.7.0.1
 */