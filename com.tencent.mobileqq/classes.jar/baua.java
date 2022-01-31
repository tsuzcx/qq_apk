import com.tencent.TMG.utils.QLog;

class baua
  implements baug
{
  private baua(baty parambaty) {}
  
  public void onResp(bavf parambavf)
  {
    synchronized (baty.a(this.a))
    {
      baty.a(this.a, parambavf.jdField_a_of_type_Int);
      baty.b(this.a, parambavf.b);
      this.a.jdField_a_of_type_JavaLangString = parambavf.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_Int = parambavf.c;
      baty.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + baty.a(this.a) + " , errorCode = " + baty.b(this.a) + " , mErrDesc = " + this.a.jdField_a_of_type_JavaLangString + " , mHttpCode = " + this.a.jdField_a_of_type_Int);
      }
      baty.a(this.a).notify();
      return;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baua
 * JD-Core Version:    0.7.0.1
 */