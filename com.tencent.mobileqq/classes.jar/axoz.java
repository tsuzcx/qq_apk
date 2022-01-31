import com.tencent.qphone.base.util.QLog;

class axoz
  extends ajmm
{
  axoz(axoy paramaxoy) {}
  
  protected void a(boolean paramBoolean, awba paramawba)
  {
    if ((paramawba != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramawba.jdField_a_of_type_JavaLangString + " seq:" + paramawba.jdField_a_of_type_Short + " Layer:" + paramawba.jdField_a_of_type_Int + " RespCode:" + paramawba.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.c + " isStreamPttSuccess:" + this.a.d);
    }
    this.a.c(2);
    if ((paramawba == null) || (paramawba.jdField_a_of_type_JavaLangString == null) || (!paramawba.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.c))) {
      return;
    }
    if (!paramBoolean)
    {
      axoy.a(this.a, false, paramawba);
      return;
    }
    axoy.a(this.a, true, paramawba);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axoz
 * JD-Core Version:    0.7.0.1
 */