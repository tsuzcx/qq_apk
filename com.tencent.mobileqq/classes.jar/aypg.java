import com.tencent.qphone.base.util.QLog;

class aypg
  extends akav
{
  aypg(aypf paramaypf) {}
  
  protected void a(boolean paramBoolean, axai paramaxai)
  {
    if ((paramaxai != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramaxai.jdField_a_of_type_JavaLangString + " seq:" + paramaxai.jdField_a_of_type_Short + " Layer:" + paramaxai.jdField_a_of_type_Int + " RespCode:" + paramaxai.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.c + " isStreamPttSuccess:" + this.a.d);
    }
    this.a.c(2);
    if ((paramaxai == null) || (paramaxai.jdField_a_of_type_JavaLangString == null) || (!paramaxai.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.c))) {
      return;
    }
    if (!paramBoolean)
    {
      aypf.a(this.a, false, paramaxai);
      return;
    }
    aypf.a(this.a, true, paramaxai);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypg
 * JD-Core Version:    0.7.0.1
 */