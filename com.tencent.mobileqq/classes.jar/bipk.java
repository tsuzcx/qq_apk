import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bipk
{
  baub jdField_a_of_type_Baub;
  bipi jdField_a_of_type_Bipi = null;
  bipm jdField_a_of_type_Bipm;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(bipi parambipi, int paramInt)
  {
    String str1;
    if (!bipj.b(parambipi))
    {
      String str2 = parambipi.jdField_a_of_type_JavaLangString;
      str1 = parambipi.b;
      String str3 = bipj.a(parambipi);
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Baug = new bipl(this, str1, parambipi);
      localbaub.a(str1);
      localbaub.jdField_a_of_type_JavaLangString = str2;
      localbaub.jdField_a_of_type_Int = 0;
      localbaub.jdField_c_of_type_JavaLangString = new File(str3).getPath();
      localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      parambipi = akwd.a().getNetEngine(0);
      if (parambipi == null) {
        break label206;
      }
      this.jdField_a_of_type_Baub = localbaub;
      parambipi.a(this.jdField_a_of_type_Baub);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bipm != null)) {
        this.jdField_a_of_type_Bipm.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bipm != null) {
        this.jdField_a_of_type_Bipm.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(bipi parambipi, bipm parambipm)
  {
    this.jdField_a_of_type_Bipm = parambipm;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Bipi == parambipi) || (TextUtils.isEmpty(parambipi.b)) || (parambipi.b.equals(this.jdField_a_of_type_Bipi.b))) {
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
        if (this.jdField_a_of_type_Baub != null)
        {
          parambipm = akwd.a().getNetEngine(0);
          if (parambipm != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Baub.a() }));
            parambipm.b(this.jdField_a_of_type_Baub);
          }
        }
        this.jdField_a_of_type_Bipi = parambipi;
        this.jdField_a_of_type_Baub = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Bipi }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Bipi, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bipk
 * JD-Core Version:    0.7.0.1
 */