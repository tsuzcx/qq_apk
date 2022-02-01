import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class apbz
  implements beav
{
  apbz(apby paramapby, apce paramapce) {}
  
  public void a(beau parambeau)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.jdField_a_of_type_Int == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((bdvs)parambdwt.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (apby.a(this.jdField_a_of_type_Apby))
      {
        if (apby.a(this.jdField_a_of_type_Apby) != null)
        {
          i = 0;
          label67:
          if (i < apby.a(this.jdField_a_of_type_Apby).size())
          {
            if (!((apce)apby.a(this.jdField_a_of_type_Apby).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Apce.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            apby.a(this.jdField_a_of_type_Apby).remove(i);
          }
        }
      }
      synchronized (apby.a(this.jdField_a_of_type_Apby))
      {
        ??? = (apcd)apby.a(this.jdField_a_of_type_Apby).get(this.jdField_a_of_type_Apce.b);
        if (parambdwt.jdField_a_of_type_Int == 0)
        {
          if (apby.a(this.jdField_a_of_type_Apby) != null) {
            apby.a(this.jdField_a_of_type_Apby).a(this.jdField_a_of_type_Apce.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apce.jdField_a_of_type_Long);
          }
          ??? = new File(((bdvs)parambdwt.jdField_a_of_type_Bdws).c);
          String str = azby.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Apce.b))) && (this.jdField_a_of_type_Apce.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((bdvs)parambdwt.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((apcd)???).a(false, this.jdField_a_of_type_Apce);
            return;
            label342:
            i += 1;
            break label67;
            parambdwt = finally;
            throw parambdwt;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((apcd)???).a(bool, this.jdField_a_of_type_Apce);
        return;
        if (apby.a(this.jdField_a_of_type_Apby) != null) {
          apby.a(this.jdField_a_of_type_Apby).a(this.jdField_a_of_type_Apce.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(bdws arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((bdvs)???).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (apby.a(this.jdField_a_of_type_Apby))
    {
      apcd localapcd = (apcd)apby.a(this.jdField_a_of_type_Apby).get(this.jdField_a_of_type_Apce.b);
      if (localapcd != null) {
        localapcd.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbz
 * JD-Core Version:    0.7.0.1
 */