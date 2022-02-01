import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class awxt
  implements bceu
{
  awxt(awxi paramawxi, awxd paramawxd, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Awxd.a != null) && (this.jdField_a_of_type_Awxd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Awxd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_Awxd, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Awxd.a != null) && (this.jdField_a_of_type_Awxd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_Awxd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_Awxd.a != null)
    {
      String str = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_Awxd.a.jdField_a_of_type_Bcef);
      awxe localawxe = this.jdField_a_of_type_Awxi.a(str);
      if ((localawxe != null) && (!localawxe.a))
      {
        localawxe.c = paramInt;
        this.jdField_a_of_type_Awxi.a(str, localawxe);
        awxi.a(this.jdField_a_of_type_Awxi, localawxe, localawxe.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxt
 * JD-Core Version:    0.7.0.1
 */