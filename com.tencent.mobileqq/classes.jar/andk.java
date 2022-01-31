import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class andk
  extends bazy
{
  andk(andh paramandh, QQAppInterface paramQQAppInterface, String paramString, bazz parambazz, baub parambaub, andn paramandn, andm paramandm)
  {
    super(paramQQAppInterface, paramString, parambazz, parambaub);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (andh.a(this.jdField_a_of_type_Andh))
    {
      andm localandm = (andm)andh.a(this.jdField_a_of_type_Andh).get(this.jdField_a_of_type_Andn.b);
      if (localandm != null) {
        localandm.b();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (andh.a(this.jdField_a_of_type_Andh))
    {
      andm localandm = (andm)andh.a(this.jdField_a_of_type_Andh).get(this.jdField_a_of_type_Andn.b);
      if (localandm != null) {
        this.jdField_a_of_type_Andm.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andk
 * JD-Core Version:    0.7.0.1
 */