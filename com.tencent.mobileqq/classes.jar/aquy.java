import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class aquy
{
  int jdField_a_of_type_Int;
  public aqva a;
  aqvc jdField_a_of_type_Aqvc;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  
  aquy(aque paramaque, String paramString1, String paramString2, int paramInt, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_Aqva = new aquz(this, paramaque, paramMessageRecord);
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_Aqvc != null) && (this.jdField_b_of_type_Int == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task suc. status[" + this.jdField_b_of_type_Int + "]");
      }
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_Aqvc.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqva);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task fail. status[" + this.jdField_b_of_type_Int + "]");
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_Aqvc != null) && ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 0)))
    {
      this.jdField_a_of_type_Aqvc.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.jdField_b_of_type_Int = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquy
 * JD-Core Version:    0.7.0.1
 */