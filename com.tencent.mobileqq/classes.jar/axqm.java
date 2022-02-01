import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class axqm
  implements bcxm
{
  axqm(axqb paramaxqb, axpw paramaxpw, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Axpw.a != null) && (this.jdField_a_of_type_Axpw.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Axpw.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Axpw, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Axpw.a != null) && (this.jdField_a_of_type_Axpw.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Axpw.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Axpw.a != null)
    {
      String str = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Axpw.a.jdField_a_of_type_Bcwx);
      axpx localaxpx = this.jdField_a_of_type_Axqb.a(str);
      if ((localaxpx != null) && (!localaxpx.a))
      {
        localaxpx.c = paramInt;
        this.jdField_a_of_type_Axqb.a(str, localaxpx);
        axqb.a(this.jdField_a_of_type_Axqb, localaxpx, localaxpx.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqm
 * JD-Core Version:    0.7.0.1
 */