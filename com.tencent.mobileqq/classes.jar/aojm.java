import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aojm
  implements aojh
{
  aojm(aojj paramaojj, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aojj.jdField_a_of_type_Aotv.a() + "]on Error[" + paramInt + "]msg[" + paramString + "]");
    }
    if ((paramInt == -25081) || (paramInt == -6101) || (paramInt == -7003))
    {
      this.jdField_a_of_type_Aojj.jdField_a_of_type_Aotv.a(true);
      apcb.a(2131627250);
    }
    if (this.jdField_a_of_type_Aojj.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aojh localaojh = (aojh)this.jdField_a_of_type_Aojj.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaojh != null) {
        localaojh.a(paramInt, paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aojj.jdField_a_of_type_Aotv.a() + "]onGetUrlCookies");
    }
    this.jdField_a_of_type_Aojj.a(this.jdField_a_of_type_Aojj.jdField_a_of_type_Aotv, this.jdField_a_of_type_Boolean);
  }
  
  public void aF_() {}
  
  public void aG_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aojm
 * JD-Core Version:    0.7.0.1
 */