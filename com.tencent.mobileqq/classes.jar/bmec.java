import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bmec
{
  beum jdField_a_of_type_Beum;
  bmea jdField_a_of_type_Bmea = null;
  bmee jdField_a_of_type_Bmee;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(bmea parambmea, int paramInt)
  {
    String str1;
    if (!bmeb.b(parambmea))
    {
      String str2 = parambmea.jdField_a_of_type_JavaLangString;
      str1 = parambmea.b;
      String str3 = bmeb.a(parambmea);
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new bmed(this, str1, parambmea);
      localbeum.a(str1);
      localbeum.jdField_a_of_type_JavaLangString = str2;
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.c = new File(str3).getPath();
      localbeum.b = bhnv.a(bevn.a().a());
      parambmea = anbd.a().getNetEngine(0);
      if (parambmea == null) {
        break label206;
      }
      this.jdField_a_of_type_Beum = localbeum;
      parambmea.a(this.jdField_a_of_type_Beum);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bmee != null)) {
        this.jdField_a_of_type_Bmee.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bmee != null) {
        this.jdField_a_of_type_Bmee.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(bmea parambmea, bmee parambmee)
  {
    this.jdField_a_of_type_Bmee = parambmee;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Bmea == parambmea) || (TextUtils.isEmpty(parambmea.b)) || (parambmea.b.equals(this.jdField_a_of_type_Bmea.b))) {
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
        if (this.jdField_a_of_type_Beum != null)
        {
          parambmee = anbd.a().getNetEngine(0);
          if (parambmee != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Beum.a() }));
            parambmee.b(this.jdField_a_of_type_Beum);
          }
        }
        this.jdField_a_of_type_Bmea = parambmea;
        this.jdField_a_of_type_Beum = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Bmea }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Bmea, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmec
 * JD-Core Version:    0.7.0.1
 */