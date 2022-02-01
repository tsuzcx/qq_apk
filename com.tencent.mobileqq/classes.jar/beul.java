import com.tencent.TMG.utils.QLog;

class beul
  implements beuq
{
  private beul(beuj parambeuj) {}
  
  public void onResp(bevm parambevm)
  {
    synchronized (beuj.a(this.a))
    {
      beuj.a(this.a, parambevm.jdField_a_of_type_Int);
      beuj.b(this.a, parambevm.b);
      this.a.jdField_a_of_type_JavaLangString = parambevm.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_Int = parambevm.c;
      beuj.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + beuj.a(this.a) + " , errorCode = " + beuj.b(this.a) + " , mErrDesc = " + this.a.jdField_a_of_type_JavaLangString + " , mHttpCode = " + this.a.jdField_a_of_type_Int);
      }
      beuj.a(this.a).notify();
      return;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beul
 * JD-Core Version:    0.7.0.1
 */