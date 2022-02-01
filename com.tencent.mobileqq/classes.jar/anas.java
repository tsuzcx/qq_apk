import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anas
{
  anaq jdField_a_of_type_Anaq = null;
  anau jdField_a_of_type_Anau;
  bdvs jdField_a_of_type_Bdvs;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(anaq paramanaq, int paramInt)
  {
    String str1;
    if (!anar.b(paramanaq))
    {
      String str2 = paramanaq.jdField_a_of_type_JavaLangString;
      str1 = paramanaq.b;
      String str3 = anar.a(paramanaq);
      bdvs localbdvs = new bdvs();
      localbdvs.jdField_a_of_type_Bdvw = new anat(this, str1, paramanaq);
      localbdvs.a(str1);
      localbdvs.jdField_a_of_type_JavaLangString = str2;
      localbdvs.jdField_a_of_type_Int = 0;
      localbdvs.c = new File(str3).getPath();
      localbdvs.b = bgnt.a(bdwu.a().a());
      paramanaq = ampj.a().getNetEngine(0);
      if (paramanaq == null) {
        break label206;
      }
      this.jdField_a_of_type_Bdvs = localbdvs;
      paramanaq.a(this.jdField_a_of_type_Bdvs);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Anau != null)) {
        this.jdField_a_of_type_Anau.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Anau != null) {
        this.jdField_a_of_type_Anau.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(anaq paramanaq, anau paramanau)
  {
    this.jdField_a_of_type_Anau = paramanau;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Anaq == paramanaq) || (TextUtils.isEmpty(paramanaq.b)) || (paramanaq.b.equals(this.jdField_a_of_type_Anaq.b))) {
        break label214;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_Bdvs != null)
        {
          paramanau = ampj.a().getNetEngine(0);
          if (paramanau != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Bdvs.a() }));
            paramanau.b(this.jdField_a_of_type_Bdvs);
          }
        }
        this.jdField_a_of_type_Anaq = paramanaq;
        this.jdField_a_of_type_Bdvs = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Anaq }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Anaq, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anas
 * JD-Core Version:    0.7.0.1
 */