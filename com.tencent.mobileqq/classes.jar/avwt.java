import com.tencent.qphone.base.util.QLog;

class avwt
  extends ayxn
{
  avwt(avws paramavws, ayxn paramayxn) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("FaceContext", 1, new Object[] { "refreshIpState onFailedResponse : ", paramString2 });
    avws.a(this.jdField_a_of_type_Avws, 11);
    if (this.jdField_a_of_type_Ayxn != null) {
      this.jdField_a_of_type_Ayxn.a(paramString1, paramInt, paramString2);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    avws localavws = this.jdField_a_of_type_Avws;
    if (paramBoolean) {}
    for (int i = 11;; i = 10)
    {
      avws.a(localavws, i);
      QLog.d("FaceContext", 1, new Object[] { "ipJudgeSuccess ", Boolean.valueOf(paramBoolean), paramString });
      if (this.jdField_a_of_type_Ayxn != null) {
        this.jdField_a_of_type_Ayxn.a(paramBoolean, paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwt
 * JD-Core Version:    0.7.0.1
 */