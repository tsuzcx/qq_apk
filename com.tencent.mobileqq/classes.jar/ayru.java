import com.tencent.TMG.utils.QLog;

class ayru
  implements aysa
{
  private ayru(ayrs paramayrs) {}
  
  public void onResp(aysx paramaysx)
  {
    synchronized (ayrs.a(this.a))
    {
      ayrs.a(this.a, paramaysx.jdField_a_of_type_Int);
      ayrs.b(this.a, paramaysx.b);
      this.a.jdField_a_of_type_JavaLangString = paramaysx.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_Int = paramaysx.c;
      ayrs.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + ayrs.a(this.a) + " , errorCode = " + ayrs.b(this.a) + " , mErrDesc = " + this.a.jdField_a_of_type_JavaLangString + " , mHttpCode = " + this.a.jdField_a_of_type_Int);
      }
      ayrs.a(this.a).notify();
      return;
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayru
 * JD-Core Version:    0.7.0.1
 */