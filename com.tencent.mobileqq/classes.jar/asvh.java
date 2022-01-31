import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class asvh
  implements axeg
{
  asvh(asuw paramasuw, asur paramasur, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Asur.a != null) && (this.jdField_a_of_type_Asur.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Asur.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Asur, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Asur.a != null) && (this.jdField_a_of_type_Asur.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Asur.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Asur.a != null)
    {
      String str = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Asur.a.jdField_a_of_type_Axdt);
      asus localasus = this.jdField_a_of_type_Asuw.a(str);
      if ((localasus != null) && (!localasus.a))
      {
        localasus.c = paramInt;
        this.jdField_a_of_type_Asuw.a(str, localasus);
        asuw.a(this.jdField_a_of_type_Asuw, localasus, localasus.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asvh
 * JD-Core Version:    0.7.0.1
 */