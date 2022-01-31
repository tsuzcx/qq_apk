import com.tencent.qphone.base.util.QLog;

class barm
  extends alwx
{
  barm(barl parambarl) {}
  
  protected void a(boolean paramBoolean, ayzx paramayzx)
  {
    if ((paramayzx != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramayzx.jdField_a_of_type_JavaLangString + " seq:" + paramayzx.jdField_a_of_type_Short + " Layer:" + paramayzx.jdField_a_of_type_Int + " RespCode:" + paramayzx.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.c + " isStreamPttSuccess:" + this.a.d);
    }
    this.a.c(2);
    if ((paramayzx == null) || (paramayzx.jdField_a_of_type_JavaLangString == null) || (!paramayzx.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.c))) {
      return;
    }
    if (!paramBoolean)
    {
      barl.a(this.a, false, paramayzx);
      return;
    }
    barl.a(this.a, true, paramayzx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     barm
 * JD-Core Version:    0.7.0.1
 */