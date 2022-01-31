import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class aoeu
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public aoex a;
  aoey jdField_a_of_type_Aoey;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  String jdField_a_of_type_JavaLangString;
  int b = 0;
  
  aoeu(aoea paramaoea, long paramLong, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_Aoex = new aoev(this, paramaoea, paramMessageRecord, paramString, paramInt);
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_Aoey != null) && (this.b == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task suc. status[" + this.b + "]");
      }
      this.b = 1;
      this.jdField_a_of_type_Aoey.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aoex);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task fail. status[" + this.b + "]");
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_Aoey != null) && ((this.b == 1) || (this.b == 0)))
    {
      this.jdField_a_of_type_Aoey.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.b = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoeu
 * JD-Core Version:    0.7.0.1
 */