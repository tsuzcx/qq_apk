import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class amzj
  implements bapx
{
  amzj(amzi paramamzi, amzm paramamzm, amzl paramamzl) {}
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((baps)parambaqw.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString);
      return;
    }
    synchronized (amzi.a(this.jdField_a_of_type_Amzi))
    {
      int i;
      if (amzi.a(this.jdField_a_of_type_Amzi) != null)
      {
        i = 0;
        if (i < amzi.a(this.jdField_a_of_type_Amzi).size())
        {
          if (!((amzm)amzi.a(this.jdField_a_of_type_Amzi).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Amzm.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          amzi.a(this.jdField_a_of_type_Amzi).remove(i);
        }
      }
      if (parambaqw.jdField_a_of_type_Int == 0)
      {
        ??? = new File(((baps)parambaqw.jdField_a_of_type_Baqv).c);
        String str = awiz.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Amzm.b))) && (this.jdField_a_of_type_Amzm.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((baps)parambaqw.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Amzl.a(false, this.jdField_a_of_type_Amzm);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Amzl.a(bool, this.jdField_a_of_type_Amzm);
      return;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((baps)parambaqv).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Amzl.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzj
 * JD-Core Version:    0.7.0.1
 */