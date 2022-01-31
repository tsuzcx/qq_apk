import com.tencent.TMG.utils.QLog;

class bapr
  implements bapx
{
  private bapr(bapp parambapp) {}
  
  public void onResp(baqw parambaqw)
  {
    synchronized (bapp.a(this.a))
    {
      bapp.a(this.a, parambaqw.jdField_a_of_type_Int);
      bapp.b(this.a, parambaqw.b);
      this.a.jdField_a_of_type_JavaLangString = parambaqw.jdField_a_of_type_JavaLangString;
      this.a.jdField_a_of_type_Int = parambaqw.c;
      bapp.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + bapp.a(this.a) + " , errorCode = " + bapp.b(this.a) + " , mErrDesc = " + this.a.jdField_a_of_type_JavaLangString + " , mHttpCode = " + this.a.jdField_a_of_type_Int);
      }
      bapp.a(this.a).notify();
      return;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapr
 * JD-Core Version:    0.7.0.1
 */