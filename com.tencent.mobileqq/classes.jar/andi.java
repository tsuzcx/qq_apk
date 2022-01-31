import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class andi
  implements bazz
{
  andi(andh paramandh, andn paramandn) {}
  
  public void a(bazy parambazy)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(bavf parambavf)
  {
    if (parambavf.jdField_a_of_type_Int == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((baub)parambavf.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (andh.a(this.jdField_a_of_type_Andh))
      {
        if (andh.a(this.jdField_a_of_type_Andh) != null)
        {
          i = 0;
          label67:
          if (i < andh.a(this.jdField_a_of_type_Andh).size())
          {
            if (!((andn)andh.a(this.jdField_a_of_type_Andh).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Andn.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            andh.a(this.jdField_a_of_type_Andh).remove(i);
          }
        }
      }
      synchronized (andh.a(this.jdField_a_of_type_Andh))
      {
        ??? = (andm)andh.a(this.jdField_a_of_type_Andh).get(this.jdField_a_of_type_Andn.b);
        if (parambavf.jdField_a_of_type_Int == 0)
        {
          if (andh.a(this.jdField_a_of_type_Andh) != null) {
            andh.a(this.jdField_a_of_type_Andh).a(this.jdField_a_of_type_Andn.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Andn.jdField_a_of_type_Long);
          }
          ??? = new File(((baub)parambavf.jdField_a_of_type_Bave).c);
          String str = awni.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Andn.b))) && (this.jdField_a_of_type_Andn.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((baub)parambavf.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((andm)???).a(false, this.jdField_a_of_type_Andn);
            return;
            label342:
            i += 1;
            break label67;
            parambavf = finally;
            throw parambavf;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((andm)???).a(bool, this.jdField_a_of_type_Andn);
        return;
        if (andh.a(this.jdField_a_of_type_Andh) != null) {
          andh.a(this.jdField_a_of_type_Andh).a(this.jdField_a_of_type_Andn.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(bave arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((baub)???).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (andh.a(this.jdField_a_of_type_Andh))
    {
      andm localandm = (andm)andh.a(this.jdField_a_of_type_Andh).get(this.jdField_a_of_type_Andn.b);
      if (localandm != null) {
        localandm.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andi
 * JD-Core Version:    0.7.0.1
 */