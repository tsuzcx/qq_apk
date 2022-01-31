import com.tencent.TMG.utils.QLog;

class ayrw
  implements aysc
{
  private ayrw(ayru paramayru) {}
  
  public void onResp(aysz paramaysz)
  {
    synchronized (ayru.a(this.a))
    {
      ayru.a(this.a, paramaysz.jdField_a_of_type_Int);
      ayru.b(this.a, paramaysz.b);
      this.a.jdField_a_of_type_JavaLangString = paramaysz.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_Int = paramaysz.c;
      ayru.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + ayru.a(this.a) + " , errorCode = " + ayru.b(this.a) + " , mErrDesc = " + this.a.jdField_a_of_type_JavaLangString + " , mHttpCode = " + this.a.jdField_a_of_type_Int);
      }
      ayru.a(this.a).notify();
      return;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrw
 * JD-Core Version:    0.7.0.1
 */