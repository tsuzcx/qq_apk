import com.tencent.qphone.base.util.QLog;

class avpn
  extends ayra
{
  avpn(avpm paramavpm, ayra paramayra) {}
  
  public void ipJudgeSuccess(boolean paramBoolean, String paramString)
  {
    avpm localavpm = this.jdField_a_of_type_Avpm;
    if (paramBoolean) {}
    for (int i = 11;; i = 10)
    {
      avpm.a(localavpm, i);
      QLog.d("FaceContext", 1, new Object[] { "ipJudgeSuccess ", Boolean.valueOf(paramBoolean), paramString });
      if (this.jdField_a_of_type_Ayra != null) {
        this.jdField_a_of_type_Ayra.ipJudgeSuccess(paramBoolean, paramString);
      }
      return;
    }
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("FaceContext", 1, new Object[] { "refreshIpState onFailedResponse : ", paramString2 });
    avpm.a(this.jdField_a_of_type_Avpm, 11);
    if (this.jdField_a_of_type_Ayra != null) {
      this.jdField_a_of_type_Ayra.onFailedResponse(paramString1, paramInt, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpn
 * JD-Core Version:    0.7.0.1
 */