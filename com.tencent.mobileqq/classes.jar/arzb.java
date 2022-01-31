import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class arzb
  implements awew
{
  arzb(aryq paramaryq, aryl paramaryl, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aryl.a != null) && (this.jdField_a_of_type_Aryl.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Aryl.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Aryl, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Aryl.a != null) && (this.jdField_a_of_type_Aryl.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Aryl.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Aryl.a != null)
    {
      String str = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Aryl.a.jdField_a_of_type_Awej);
      arym localarym = this.jdField_a_of_type_Aryq.a(str);
      if ((localarym != null) && (!localarym.a))
      {
        localarym.c = paramInt;
        this.jdField_a_of_type_Aryq.a(str, localarym);
        aryq.a(this.jdField_a_of_type_Aryq, localarym, localarym.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     arzb
 * JD-Core Version:    0.7.0.1
 */