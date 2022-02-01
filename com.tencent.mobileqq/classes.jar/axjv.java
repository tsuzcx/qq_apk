import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class axjv
  implements bcxq
{
  axjv(axjk paramaxjk, axjf paramaxjf, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Axjf.a != null) && (this.jdField_a_of_type_Axjf.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Axjf.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Axjf, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Axjf.a != null) && (this.jdField_a_of_type_Axjf.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Axjf.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Axjf.a != null)
    {
      String str = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Axjf.a.jdField_a_of_type_Bcxb);
      axjg localaxjg = this.jdField_a_of_type_Axjk.a(str);
      if ((localaxjg != null) && (!localaxjg.a))
      {
        localaxjg.c = paramInt;
        this.jdField_a_of_type_Axjk.a(str, localaxjg);
        axjk.a(this.jdField_a_of_type_Axjk, localaxjg, localaxjg.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjv
 * JD-Core Version:    0.7.0.1
 */