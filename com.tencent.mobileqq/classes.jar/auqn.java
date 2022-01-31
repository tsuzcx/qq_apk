import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class auqn
  implements azdv
{
  auqn(auqc paramauqc, aupx paramaupx, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aupx.a != null) && (this.jdField_a_of_type_Aupx.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Aupx.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Aupx, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Aupx.a != null) && (this.jdField_a_of_type_Aupx.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Aupx.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Aupx.a != null)
    {
      String str = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Aupx.a.jdField_a_of_type_Azdg);
      aupy localaupy = this.jdField_a_of_type_Auqc.a(str);
      if ((localaupy != null) && (!localaupy.a))
      {
        localaupy.c = paramInt;
        this.jdField_a_of_type_Auqc.a(str, localaupy);
        auqc.a(this.jdField_a_of_type_Auqc, localaupy, localaupy.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqn
 * JD-Core Version:    0.7.0.1
 */