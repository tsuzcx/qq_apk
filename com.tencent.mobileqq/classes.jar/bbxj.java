import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class bbxj
  implements Comparable<bbxj>
{
  public int a;
  public MessageForScribble a;
  
  bbxj(MessageForScribble paramMessageForScribble, int paramInt)
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
  
  public int a(bbxj parambbxj)
  {
    if (this.jdField_a_of_type_Int < parambbxj.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > parambbxj.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxj
 * JD-Core Version:    0.7.0.1
 */