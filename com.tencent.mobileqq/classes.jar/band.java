import com.tencent.qphone.base.util.QLog;

class band
  extends alsi
{
  band(banc parambanc) {}
  
  protected void a(boolean paramBoolean, ayvo paramayvo)
  {
    if ((paramayvo != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramayvo.jdField_a_of_type_JavaLangString + " seq:" + paramayvo.jdField_a_of_type_Short + " Layer:" + paramayvo.jdField_a_of_type_Int + " RespCode:" + paramayvo.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.c + " isStreamPttSuccess:" + this.a.d);
    }
    this.a.c(2);
    if ((paramayvo == null) || (paramayvo.jdField_a_of_type_JavaLangString == null) || (!paramayvo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.c))) {
      return;
    }
    if (!paramBoolean)
    {
      banc.a(this.a, false, paramayvo);
      return;
    }
    banc.a(this.a, true, paramayvo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     band
 * JD-Core Version:    0.7.0.1
 */