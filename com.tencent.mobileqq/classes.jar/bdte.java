import com.tencent.qphone.base.util.QLog;

class bdte
  extends anqd
{
  bdte(bdtd parambdtd) {}
  
  protected void a(boolean paramBoolean, bbza parambbza)
  {
    if ((parambbza != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + parambbza.jdField_a_of_type_JavaLangString + " seq:" + parambbza.jdField_a_of_type_Short + " Layer:" + parambbza.jdField_a_of_type_Int + " RespCode:" + parambbza.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.c + " isStreamPttSuccess:" + this.a.d);
    }
    this.a.c(2);
    if ((parambbza == null) || (parambbza.jdField_a_of_type_JavaLangString == null) || (!parambbza.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.c))) {
      return;
    }
    if (!paramBoolean)
    {
      bdtd.a(this.a, false, parambbza);
      return;
    }
    bdtd.a(this.a, true, parambbza);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdte
 * JD-Core Version:    0.7.0.1
 */