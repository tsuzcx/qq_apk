import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bgjo
{
  ayrv jdField_a_of_type_Ayrv;
  bgjm jdField_a_of_type_Bgjm = null;
  bgjq jdField_a_of_type_Bgjq;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(bgjm parambgjm, int paramInt)
  {
    String str1;
    if (!bgjn.b(parambgjm))
    {
      String str2 = parambgjm.jdField_a_of_type_JavaLangString;
      str1 = parambgjm.b;
      String str3 = bgjn.a(parambgjm);
      ayrv localayrv = new ayrv();
      localayrv.jdField_a_of_type_Aysa = new bgjp(this, str1, parambgjm);
      localayrv.a(str1);
      localayrv.jdField_a_of_type_JavaLangString = str2;
      localayrv.jdField_a_of_type_Int = 0;
      localayrv.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localayrv.jdField_c_of_type_Int = bbev.a(aysy.a().a());
      parambgjm = ajae.a().getNetEngine(0);
      if (parambgjm == null) {
        break label206;
      }
      this.jdField_a_of_type_Ayrv = localayrv;
      parambgjm.a(this.jdField_a_of_type_Ayrv);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bgjq != null)) {
        this.jdField_a_of_type_Bgjq.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bgjq != null) {
        this.jdField_a_of_type_Bgjq.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(bgjm parambgjm, bgjq parambgjq)
  {
    this.jdField_a_of_type_Bgjq = parambgjq;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Bgjm == parambgjm) || (TextUtils.isEmpty(parambgjm.b)) || (parambgjm.b.equals(this.jdField_a_of_type_Bgjm.b))) {
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
        if (this.jdField_a_of_type_Ayrv != null)
        {
          parambgjq = ajae.a().getNetEngine(0);
          if (parambgjq != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Ayrv.a() }));
            parambgjq.b(this.jdField_a_of_type_Ayrv);
          }
        }
        this.jdField_a_of_type_Bgjm = parambgjm;
        this.jdField_a_of_type_Ayrv = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Bgjm }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Bgjm, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgjo
 * JD-Core Version:    0.7.0.1
 */