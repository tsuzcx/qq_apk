import com.tencent.qphone.base.util.QLog;

class berw
  extends aocj
{
  berw(berv paramberv) {}
  
  protected void a(boolean paramBoolean, bcrr parambcrr)
  {
    if ((parambcrr != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + parambcrr.jdField_a_of_type_JavaLangString + " seq:" + parambcrr.jdField_a_of_type_Short + " Layer:" + parambcrr.jdField_a_of_type_Int + " RespCode:" + parambcrr.b);
    }
    if ((this.a.a != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.a.a.c + " isStreamPttSuccess:" + this.a.d);
    }
    this.a.c(2);
    if ((parambcrr == null) || (parambcrr.jdField_a_of_type_JavaLangString == null) || (!parambcrr.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.c))) {
      return;
    }
    if (!paramBoolean)
    {
      berv.a(this.a, false, parambcrr);
      return;
    }
    berv.a(this.a, true, parambcrr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berw
 * JD-Core Version:    0.7.0.1
 */