import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class arys
  implements apaq
{
  arys(aryq paramaryq, apap paramapap) {}
  
  public void a()
  {
    Message localMessage = aryq.a(this.jdField_a_of_type_Aryq).obtainMessage(1);
    arym localarym = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Apap.a());
    if (localarym != null)
    {
      localarym.jdField_a_of_type_Int = 0;
      localMessage.obj = localarym;
      aryq.a(this.jdField_a_of_type_Aryq).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    arym localarym = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Apap.a());
    if (localarym != null)
    {
      localarym.jdField_a_of_type_Int = -1;
      localarym.b = paramInt;
      localarym.jdField_a_of_type_JavaLangString = paramString;
      aryq.a(this.jdField_a_of_type_Aryq, localarym);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     arys
 * JD-Core Version:    0.7.0.1
 */