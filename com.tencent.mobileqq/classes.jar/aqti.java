import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aqti
  implements aqtd
{
  aqti(aqtf paramaqtf, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aqtf.jdField_a_of_type_Arek.a() + "]on Error[" + paramInt + "]msg[" + paramString + "]");
    }
    if ((paramInt == -25081) || (paramInt == -6101) || (paramInt == -7003))
    {
      this.jdField_a_of_type_Aqtf.jdField_a_of_type_Arek.a(true);
      armz.a(2131692971);
    }
    if (this.jdField_a_of_type_Aqtf.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aqtd localaqtd = (aqtd)this.jdField_a_of_type_Aqtf.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaqtd != null) {
        localaqtd.a(paramInt, paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aqtf.jdField_a_of_type_Arek.a() + "]onGetUrlCookies");
    }
    this.jdField_a_of_type_Aqtf.a(this.jdField_a_of_type_Aqtf.jdField_a_of_type_Arek, this.jdField_a_of_type_Boolean);
  }
  
  public void aJ_() {}
  
  public void aK_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqti
 * JD-Core Version:    0.7.0.1
 */