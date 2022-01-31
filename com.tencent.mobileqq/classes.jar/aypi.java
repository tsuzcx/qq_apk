import com.tencent.qphone.base.util.QLog;

class aypi
  extends akat
{
  aypi(ayph paramayph) {}
  
  protected void a(boolean paramBoolean, axak paramaxak)
  {
    if ((paramaxak != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramaxak.jdField_a_of_type_JavaLangString + " seq:" + paramaxak.jdField_a_of_type_Short + " Layer:" + paramaxak.jdField_a_of_type_Int + " RespCode:" + paramaxak.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.c + " isStreamPttSuccess:" + this.a.d);
    }
    this.a.c(2);
    if ((paramaxak == null) || (paramaxak.jdField_a_of_type_JavaLangString == null) || (!paramaxak.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.c))) {
      return;
    }
    if (!paramBoolean)
    {
      ayph.a(this.a, false, paramaxak);
      return;
    }
    ayph.a(this.a, true, paramaxak);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypi
 * JD-Core Version:    0.7.0.1
 */