import com.tencent.qphone.base.util.QLog;

class aveq
  extends ayeu
{
  aveq(avep paramavep, ayeu paramayeu) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("FaceContext", 1, new Object[] { "refreshIpState onFailedResponse : ", paramString2 });
    avep.a(this.jdField_a_of_type_Avep, 11);
    if (this.jdField_a_of_type_Ayeu != null) {
      this.jdField_a_of_type_Ayeu.a(paramString1, paramInt, paramString2);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    avep localavep = this.jdField_a_of_type_Avep;
    if (paramBoolean) {}
    for (int i = 11;; i = 10)
    {
      avep.a(localavep, i);
      QLog.d("FaceContext", 1, new Object[] { "ipJudgeSuccess ", Boolean.valueOf(paramBoolean), paramString });
      if (this.jdField_a_of_type_Ayeu != null) {
        this.jdField_a_of_type_Ayeu.a(paramBoolean, paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aveq
 * JD-Core Version:    0.7.0.1
 */