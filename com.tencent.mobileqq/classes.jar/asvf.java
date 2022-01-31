import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class asvf
  implements axee
{
  asvf(asuu paramasuu, asup paramasup, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Asup.a != null) && (this.jdField_a_of_type_Asup.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Asup.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Asup, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Asup.a != null) && (this.jdField_a_of_type_Asup.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Asup.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Asup.a != null)
    {
      String str = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Asup.a.jdField_a_of_type_Axdr);
      asuq localasuq = this.jdField_a_of_type_Asuu.a(str);
      if ((localasuq != null) && (!localasuq.a))
      {
        localasuq.c = paramInt;
        this.jdField_a_of_type_Asuu.a(str, localasuq);
        asuu.a(this.jdField_a_of_type_Asuu, localasuq, localasuq.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvf
 * JD-Core Version:    0.7.0.1
 */