import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class aume
  implements ayzm
{
  aume(ault paramault, aulo paramaulo, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aulo.a != null) && (this.jdField_a_of_type_Aulo.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Aulo.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_Aulo, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Aulo.a != null) && (this.jdField_a_of_type_Aulo.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Aulo.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Aulo.a != null)
    {
      String str = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_Aulo.a.jdField_a_of_type_Ayyx);
      aulp localaulp = this.jdField_a_of_type_Ault.a(str);
      if ((localaulp != null) && (!localaulp.a))
      {
        localaulp.c = paramInt;
        this.jdField_a_of_type_Ault.a(str, localaulp);
        ault.a(this.jdField_a_of_type_Ault, localaulp, localaulp.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aume
 * JD-Core Version:    0.7.0.1
 */