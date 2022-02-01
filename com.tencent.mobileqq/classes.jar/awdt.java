import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class awdt
  implements bbqw
{
  awdt(awdi paramawdi, awdd paramawdd, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Awdd.a != null) && (this.jdField_a_of_type_Awdd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Awdd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_Awdd, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Awdd.a != null) && (this.jdField_a_of_type_Awdd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Awdd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Awdd.a != null)
    {
      String str = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_Awdd.a.jdField_a_of_type_Bbqh);
      awde localawde = this.jdField_a_of_type_Awdi.a(str);
      if ((localawde != null) && (!localawde.a))
      {
        localawde.c = paramInt;
        this.jdField_a_of_type_Awdi.a(str, localawde);
        awdi.a(this.jdField_a_of_type_Awdi, localawde, localawde.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdt
 * JD-Core Version:    0.7.0.1
 */