import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class aybz
  implements Comparable<aybz>
{
  public int a;
  public MessageForScribble a;
  
  aybz(MessageForScribble paramMessageForScribble, int paramInt)
  {
    this.jdField_a_of_type_Int = 200;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble = paramMessageForScribble;
    if (paramInt >= 200)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    QLog.e("ScribbleDownloadInfo", 1, "err priority");
  }
  
  public int a(aybz paramaybz)
  {
    if (this.jdField_a_of_type_Int < paramaybz.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramaybz.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybz
 * JD-Core Version:    0.7.0.1
 */