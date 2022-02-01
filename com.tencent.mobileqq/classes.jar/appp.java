import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class appp
  implements bezu
{
  appp(appo paramappo, appu paramappu) {}
  
  public void a(bezt parambezt)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_Int == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((beum)parambevm.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (appo.a(this.jdField_a_of_type_Appo))
      {
        if (appo.a(this.jdField_a_of_type_Appo) != null)
        {
          i = 0;
          label67:
          if (i < appo.a(this.jdField_a_of_type_Appo).size())
          {
            if (!((appu)appo.a(this.jdField_a_of_type_Appo).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Appu.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            appo.a(this.jdField_a_of_type_Appo).remove(i);
          }
        }
      }
      synchronized (appo.a(this.jdField_a_of_type_Appo))
      {
        ??? = (appt)appo.a(this.jdField_a_of_type_Appo).get(this.jdField_a_of_type_Appu.b);
        if (parambevm.jdField_a_of_type_Int == 0)
        {
          if (appo.a(this.jdField_a_of_type_Appo) != null) {
            appo.a(this.jdField_a_of_type_Appo).a(this.jdField_a_of_type_Appu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Appu.jdField_a_of_type_Long);
          }
          ??? = new File(((beum)parambevm.jdField_a_of_type_Bevl).c);
          String str = azul.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Appu.b))) && (this.jdField_a_of_type_Appu.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((beum)parambevm.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((appt)???).a(false, this.jdField_a_of_type_Appu);
            return;
            label342:
            i += 1;
            break label67;
            parambevm = finally;
            throw parambevm;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((appt)???).a(bool, this.jdField_a_of_type_Appu);
        return;
        if (appo.a(this.jdField_a_of_type_Appo) != null) {
          appo.a(this.jdField_a_of_type_Appo).a(this.jdField_a_of_type_Appu.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(bevl arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((beum)???).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (appo.a(this.jdField_a_of_type_Appo))
    {
      appt localappt = (appt)appo.a(this.jdField_a_of_type_Appo).get(this.jdField_a_of_type_Appu.b);
      if (localappt != null) {
        localappt.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appp
 * JD-Core Version:    0.7.0.1
 */