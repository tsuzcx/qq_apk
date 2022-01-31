import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class avha
  implements Comparable<avha>
{
  public int a;
  public MessageForScribble a;
  
  avha(MessageForScribble paramMessageForScribble, int paramInt)
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
  
  public int a(avha paramavha)
  {
    if (this.jdField_a_of_type_Int < paramavha.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramavha.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avha
 * JD-Core Version:    0.7.0.1
 */