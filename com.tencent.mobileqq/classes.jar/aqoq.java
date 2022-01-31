import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class aqoq
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public aqot a;
  aqou jdField_a_of_type_Aqou;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  String jdField_a_of_type_JavaLangString;
  int b = 0;
  
  aqoq(aqnw paramaqnw, long paramLong, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_Aqot = new aqor(this, paramaqnw, paramMessageRecord, paramString, paramInt);
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_Aqou != null) && (this.b == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task suc. status[" + this.b + "]");
      }
      this.b = 1;
      this.jdField_a_of_type_Aqou.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqot);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task fail. status[" + this.b + "]");
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_Aqou != null) && ((this.b == 1) || (this.b == 0)))
    {
      this.jdField_a_of_type_Aqou.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.b = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqoq
 * JD-Core Version:    0.7.0.1
 */