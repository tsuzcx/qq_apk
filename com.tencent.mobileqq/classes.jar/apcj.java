import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class apcj
  implements bdvw
{
  apcj(apci paramapci, apcm paramapcm, apcl paramapcl) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.jdField_a_of_type_Int == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((bdvs)parambdwt.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
      return;
    }
    synchronized (apci.a(this.jdField_a_of_type_Apci))
    {
      int i;
      if (apci.a(this.jdField_a_of_type_Apci) != null)
      {
        i = 0;
        if (i < apci.a(this.jdField_a_of_type_Apci).size())
        {
          if (!((apcm)apci.a(this.jdField_a_of_type_Apci).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Apcm.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          apci.a(this.jdField_a_of_type_Apci).remove(i);
        }
      }
      if (parambdwt.jdField_a_of_type_Int == 0)
      {
        ??? = new File(((bdvs)parambdwt.jdField_a_of_type_Bdws).c);
        String str = azby.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Apcm.b))) && (this.jdField_a_of_type_Apcm.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((bdvs)parambdwt.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Apcl.a(false, this.jdField_a_of_type_Apcm);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Apcl.a(bool, this.jdField_a_of_type_Apcm);
      return;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((bdvs)parambdws).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Apcl.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcj
 * JD-Core Version:    0.7.0.1
 */