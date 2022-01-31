import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bfbx
{
  axro jdField_a_of_type_Axro;
  bfbv jdField_a_of_type_Bfbv = null;
  bfbz jdField_a_of_type_Bfbz;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(bfbv parambfbv, int paramInt)
  {
    String str1;
    if (!bfbw.b(parambfbv))
    {
      String str2 = parambfbv.jdField_a_of_type_JavaLangString;
      str1 = parambfbv.b;
      String str3 = bfbw.a(parambfbv);
      axro localaxro = new axro();
      localaxro.jdField_a_of_type_Axrt = new bfby(this, str1, parambfbv);
      localaxro.a(str1);
      localaxro.jdField_a_of_type_JavaLangString = str2;
      localaxro.jdField_a_of_type_Int = 0;
      localaxro.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
      parambfbv = aing.a().getNetEngine(0);
      if (parambfbv == null) {
        break label206;
      }
      this.jdField_a_of_type_Axro = localaxro;
      parambfbv.a(this.jdField_a_of_type_Axro);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bfbz != null)) {
        this.jdField_a_of_type_Bfbz.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bfbz != null) {
        this.jdField_a_of_type_Bfbz.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(bfbv parambfbv, bfbz parambfbz)
  {
    this.jdField_a_of_type_Bfbz = parambfbz;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Bfbv == parambfbv) || (TextUtils.isEmpty(parambfbv.b)) || (parambfbv.b.equals(this.jdField_a_of_type_Bfbv.b))) {
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
        if (this.jdField_a_of_type_Axro != null)
        {
          parambfbz = aing.a().getNetEngine(0);
          if (parambfbz != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Axro.a() }));
            parambfbz.b(this.jdField_a_of_type_Axro);
          }
        }
        this.jdField_a_of_type_Bfbv = parambfbv;
        this.jdField_a_of_type_Axro = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Bfbv }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Bfbv, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfbx
 * JD-Core Version:    0.7.0.1
 */