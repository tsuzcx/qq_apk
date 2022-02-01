import com.tencent.TMG.utils.QLog;

class bdvr
  implements bdvw
{
  private bdvr(bdvp parambdvp) {}
  
  public void onResp(bdwt parambdwt)
  {
    synchronized (bdvp.a(this.a))
    {
      bdvp.a(this.a, parambdwt.jdField_a_of_type_Int);
      bdvp.b(this.a, parambdwt.b);
      this.a.jdField_a_of_type_JavaLangString = parambdwt.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_Int = parambdwt.c;
      bdvp.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + bdvp.a(this.a) + " , errorCode = " + bdvp.b(this.a) + " , mErrDesc = " + this.a.jdField_a_of_type_JavaLangString + " , mHttpCode = " + this.a.jdField_a_of_type_Int);
      }
      bdvp.a(this.a).notify();
      return;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvr
 * JD-Core Version:    0.7.0.1
 */