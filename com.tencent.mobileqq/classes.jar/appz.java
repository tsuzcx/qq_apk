import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class appz
  implements beuq
{
  appz(appy paramappy, apqc paramapqc, apqb paramapqb) {}
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_Int == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((beum)parambevm.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
      return;
    }
    synchronized (appy.a(this.jdField_a_of_type_Appy))
    {
      int i;
      if (appy.a(this.jdField_a_of_type_Appy) != null)
      {
        i = 0;
        if (i < appy.a(this.jdField_a_of_type_Appy).size())
        {
          if (!((apqc)appy.a(this.jdField_a_of_type_Appy).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Apqc.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          appy.a(this.jdField_a_of_type_Appy).remove(i);
        }
      }
      if (parambevm.jdField_a_of_type_Int == 0)
      {
        ??? = new File(((beum)parambevm.jdField_a_of_type_Bevl).c);
        String str = azul.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Apqc.b))) && (this.jdField_a_of_type_Apqc.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((beum)parambevm.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Apqb.a(false, this.jdField_a_of_type_Apqc);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Apqb.a(bool, this.jdField_a_of_type_Apqc);
      return;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((beum)parambevl).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Apqb.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appz
 * JD-Core Version:    0.7.0.1
 */