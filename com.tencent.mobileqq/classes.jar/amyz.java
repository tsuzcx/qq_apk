import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class amyz
  implements bavq
{
  amyz(amyy paramamyy, amze paramamze) {}
  
  public void a(bavp parambavp)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((baps)parambaqw.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (amyy.a(this.jdField_a_of_type_Amyy))
      {
        if (amyy.a(this.jdField_a_of_type_Amyy) != null)
        {
          i = 0;
          label67:
          if (i < amyy.a(this.jdField_a_of_type_Amyy).size())
          {
            if (!((amze)amyy.a(this.jdField_a_of_type_Amyy).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Amze.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            amyy.a(this.jdField_a_of_type_Amyy).remove(i);
          }
        }
      }
      synchronized (amyy.a(this.jdField_a_of_type_Amyy))
      {
        ??? = (amzd)amyy.a(this.jdField_a_of_type_Amyy).get(this.jdField_a_of_type_Amze.b);
        if (parambaqw.jdField_a_of_type_Int == 0)
        {
          if (amyy.a(this.jdField_a_of_type_Amyy) != null) {
            amyy.a(this.jdField_a_of_type_Amyy).a(this.jdField_a_of_type_Amze.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Amze.jdField_a_of_type_Long);
          }
          ??? = new File(((baps)parambaqw.jdField_a_of_type_Baqv).c);
          String str = awiz.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Amze.b))) && (this.jdField_a_of_type_Amze.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((baps)parambaqw.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((amzd)???).a(false, this.jdField_a_of_type_Amze);
            return;
            label342:
            i += 1;
            break label67;
            parambaqw = finally;
            throw parambaqw;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((amzd)???).a(bool, this.jdField_a_of_type_Amze);
        return;
        if (amyy.a(this.jdField_a_of_type_Amyy) != null) {
          amyy.a(this.jdField_a_of_type_Amyy).a(this.jdField_a_of_type_Amze.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(baqv arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((baps)???).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (amyy.a(this.jdField_a_of_type_Amyy))
    {
      amzd localamzd = (amzd)amyy.a(this.jdField_a_of_type_Amyy).get(this.jdField_a_of_type_Amze.b);
      if (localamzd != null) {
        localamzd.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyz
 * JD-Core Version:    0.7.0.1
 */