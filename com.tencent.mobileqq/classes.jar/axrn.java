import com.tencent.TMG.utils.QLog;

class axrn
  implements axrt
{
  private axrn(axrl paramaxrl) {}
  
  public void onResp(axsq paramaxsq)
  {
    synchronized (axrl.a(this.a))
    {
      axrl.a(this.a, paramaxsq.jdField_a_of_type_Int);
      axrl.b(this.a, paramaxsq.b);
      this.a.jdField_a_of_type_JavaLangString = paramaxsq.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_Int = paramaxsq.c;
      axrl.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + axrl.a(this.a) + " , errorCode = " + axrl.b(this.a) + " , mErrDesc = " + this.a.jdField_a_of_type_JavaLangString + " , mHttpCode = " + this.a.jdField_a_of_type_Int);
      }
      axrl.a(this.a).notify();
      return;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axrn
 * JD-Core Version:    0.7.0.1
 */