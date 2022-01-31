import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class ands
  implements baug
{
  ands(andr paramandr, andv paramandv, andu paramandu) {}
  
  public void onResp(bavf parambavf)
  {
    if (parambavf.jdField_a_of_type_Int == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((baub)parambavf.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
      return;
    }
    synchronized (andr.a(this.jdField_a_of_type_Andr))
    {
      int i;
      if (andr.a(this.jdField_a_of_type_Andr) != null)
      {
        i = 0;
        if (i < andr.a(this.jdField_a_of_type_Andr).size())
        {
          if (!((andv)andr.a(this.jdField_a_of_type_Andr).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Andv.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          andr.a(this.jdField_a_of_type_Andr).remove(i);
        }
      }
      if (parambavf.jdField_a_of_type_Int == 0)
      {
        ??? = new File(((baub)parambavf.jdField_a_of_type_Bave).c);
        String str = awni.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Andv.b))) && (this.jdField_a_of_type_Andv.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((baub)parambavf.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Andu.a(false, this.jdField_a_of_type_Andv);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Andu.a(bool, this.jdField_a_of_type_Andv);
      return;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((baub)parambave).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Andu.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ands
 * JD-Core Version:    0.7.0.1
 */