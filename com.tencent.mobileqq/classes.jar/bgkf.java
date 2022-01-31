import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bgkf
{
  ayrx jdField_a_of_type_Ayrx;
  bgkd jdField_a_of_type_Bgkd = null;
  bgkh jdField_a_of_type_Bgkh;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(bgkd parambgkd, int paramInt)
  {
    String str1;
    if (!bgke.b(parambgkd))
    {
      String str2 = parambgkd.jdField_a_of_type_JavaLangString;
      str1 = parambgkd.b;
      String str3 = bgke.a(parambgkd);
      ayrx localayrx = new ayrx();
      localayrx.jdField_a_of_type_Aysc = new bgkg(this, str1, parambgkd);
      localayrx.a(str1);
      localayrx.jdField_a_of_type_JavaLangString = str2;
      localayrx.jdField_a_of_type_Int = 0;
      localayrx.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localayrx.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
      parambgkd = ajac.a().getNetEngine(0);
      if (parambgkd == null) {
        break label206;
      }
      this.jdField_a_of_type_Ayrx = localayrx;
      parambgkd.a(this.jdField_a_of_type_Ayrx);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bgkh != null)) {
        this.jdField_a_of_type_Bgkh.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bgkh != null) {
        this.jdField_a_of_type_Bgkh.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(bgkd parambgkd, bgkh parambgkh)
  {
    this.jdField_a_of_type_Bgkh = parambgkh;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Bgkd == parambgkd) || (TextUtils.isEmpty(parambgkd.b)) || (parambgkd.b.equals(this.jdField_a_of_type_Bgkd.b))) {
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
        if (this.jdField_a_of_type_Ayrx != null)
        {
          parambgkh = ajac.a().getNetEngine(0);
          if (parambgkh != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Ayrx.a() }));
            parambgkh.b(this.jdField_a_of_type_Ayrx);
          }
        }
        this.jdField_a_of_type_Bgkd = parambgkd;
        this.jdField_a_of_type_Ayrx = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Bgkd }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Bgkd, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkf
 * JD-Core Version:    0.7.0.1
 */