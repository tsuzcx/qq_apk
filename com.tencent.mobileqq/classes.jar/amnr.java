import com.tencent.qphone.base.util.QLog;

class amnr
  extends bgod
{
  amnr(amnq paramamnq, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (3 == parambgoe.a()) {
      this.jdField_a_of_type_Amnq.a(true, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleFrameZipDecoder", 2, "downloadZip onDone task.getStatus()->" + parambgoe.a());
      }
      return;
      this.jdField_a_of_type_Amnq.a = 2;
      this.jdField_a_of_type_Amnq.a(false, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnr
 * JD-Core Version:    0.7.0.1
 */