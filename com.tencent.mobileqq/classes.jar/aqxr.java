import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aqxr
  implements aqxm
{
  aqxr(aqxo paramaqxo, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aqxo.jdField_a_of_type_Arit.a() + "]on Error[" + paramInt + "]msg[" + paramString + "]");
    }
    if ((paramInt == -25081) || (paramInt == -6101) || (paramInt == -7003))
    {
      this.jdField_a_of_type_Aqxo.jdField_a_of_type_Arit.a(true);
      arri.a(2131692973);
    }
    if (this.jdField_a_of_type_Aqxo.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aqxm localaqxm = (aqxm)this.jdField_a_of_type_Aqxo.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaqxm != null) {
        localaqxm.a(paramInt, paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aqxo.jdField_a_of_type_Arit.a() + "]onGetUrlCookies");
    }
    this.jdField_a_of_type_Aqxo.a(this.jdField_a_of_type_Aqxo.jdField_a_of_type_Arit, this.jdField_a_of_type_Boolean);
  }
  
  public void aG_() {}
  
  public void aH_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxr
 * JD-Core Version:    0.7.0.1
 */