import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class apag
  implements apab
{
  apag(apad paramapad, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Apad.jdField_a_of_type_Aplh.a() + "]on Error[" + paramInt + "]msg[" + paramString + "]");
    }
    if ((paramInt == -25081) || (paramInt == -6101) || (paramInt == -7003))
    {
      this.jdField_a_of_type_Apad.jdField_a_of_type_Aplh.a(true);
      aptv.a(2131692888);
    }
    if (this.jdField_a_of_type_Apad.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      apab localapab = (apab)this.jdField_a_of_type_Apad.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localapab != null) {
        localapab.a(paramInt, paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Apad.jdField_a_of_type_Aplh.a() + "]onGetUrlCookies");
    }
    this.jdField_a_of_type_Apad.a(this.jdField_a_of_type_Apad.jdField_a_of_type_Aplh, this.jdField_a_of_type_Boolean);
  }
  
  public void aC_() {}
  
  public void aD_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apag
 * JD-Core Version:    0.7.0.1
 */