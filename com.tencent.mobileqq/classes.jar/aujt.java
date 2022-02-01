import com.tencent.qphone.base.util.QLog;

class aujt
  extends axkv
{
  aujt(aujs paramaujs, axkv paramaxkv) {}
  
  public void ipJudgeSuccess(boolean paramBoolean, String paramString)
  {
    aujs localaujs = this.jdField_a_of_type_Aujs;
    if (paramBoolean) {}
    for (int i = 11;; i = 10)
    {
      aujs.a(localaujs, i);
      QLog.d("FaceContext", 1, new Object[] { "ipJudgeSuccess ", Boolean.valueOf(paramBoolean), paramString });
      if (this.jdField_a_of_type_Axkv != null) {
        this.jdField_a_of_type_Axkv.ipJudgeSuccess(paramBoolean, paramString);
      }
      return;
    }
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("FaceContext", 1, new Object[] { "refreshIpState onFailedResponse : ", paramString2 });
    aujs.a(this.jdField_a_of_type_Aujs, 11);
    if (this.jdField_a_of_type_Axkv != null) {
      this.jdField_a_of_type_Axkv.onFailedResponse(paramString1, paramInt, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujt
 * JD-Core Version:    0.7.0.1
 */