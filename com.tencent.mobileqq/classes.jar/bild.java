import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bild
{
  baps jdField_a_of_type_Baps;
  bilb jdField_a_of_type_Bilb = null;
  bilf jdField_a_of_type_Bilf;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(bilb parambilb, int paramInt)
  {
    String str1;
    if (!bilc.b(parambilb))
    {
      String str2 = parambilb.jdField_a_of_type_JavaLangString;
      str1 = parambilb.b;
      String str3 = bilc.a(parambilb);
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = new bile(this, str1, parambilb);
      localbaps.a(str1);
      localbaps.jdField_a_of_type_JavaLangString = str2;
      localbaps.jdField_a_of_type_Int = 0;
      localbaps.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      parambilb = akro.a().getNetEngine(0);
      if (parambilb == null) {
        break label206;
      }
      this.jdField_a_of_type_Baps = localbaps;
      parambilb.a(this.jdField_a_of_type_Baps);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bilf != null)) {
        this.jdField_a_of_type_Bilf.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bilf != null) {
        this.jdField_a_of_type_Bilf.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(bilb parambilb, bilf parambilf)
  {
    this.jdField_a_of_type_Bilf = parambilf;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Bilb == parambilb) || (TextUtils.isEmpty(parambilb.b)) || (parambilb.b.equals(this.jdField_a_of_type_Bilb.b))) {
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
        if (this.jdField_a_of_type_Baps != null)
        {
          parambilf = akro.a().getNetEngine(0);
          if (parambilf != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Baps.a() }));
            parambilf.b(this.jdField_a_of_type_Baps);
          }
        }
        this.jdField_a_of_type_Bilb = parambilb;
        this.jdField_a_of_type_Baps = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Bilb }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Bilb, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bild
 * JD-Core Version:    0.7.0.1
 */