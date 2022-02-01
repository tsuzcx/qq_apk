import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class blcz
{
  bdvs jdField_a_of_type_Bdvs;
  blcx jdField_a_of_type_Blcx = null;
  bldb jdField_a_of_type_Bldb;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(blcx paramblcx, int paramInt)
  {
    String str1;
    if (!blcy.b(paramblcx))
    {
      String str2 = paramblcx.jdField_a_of_type_JavaLangString;
      str1 = paramblcx.b;
      String str3 = blcy.a(paramblcx);
      bdvs localbdvs = new bdvs();
      localbdvs.jdField_a_of_type_Bdvw = new blda(this, str1, paramblcx);
      localbdvs.a(str1);
      localbdvs.jdField_a_of_type_JavaLangString = str2;
      localbdvs.jdField_a_of_type_Int = 0;
      localbdvs.c = new File(str3).getPath();
      localbdvs.b = bgnt.a(bdwu.a().a());
      paramblcx = ampj.a().getNetEngine(0);
      if (paramblcx == null) {
        break label206;
      }
      this.jdField_a_of_type_Bdvs = localbdvs;
      paramblcx.a(this.jdField_a_of_type_Bdvs);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bldb != null)) {
        this.jdField_a_of_type_Bldb.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bldb != null) {
        this.jdField_a_of_type_Bldb.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(blcx paramblcx, bldb parambldb)
  {
    this.jdField_a_of_type_Bldb = parambldb;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Blcx == paramblcx) || (TextUtils.isEmpty(paramblcx.b)) || (paramblcx.b.equals(this.jdField_a_of_type_Blcx.b))) {
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
          parambldb = ampj.a().getNetEngine(0);
          if (parambldb != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Bdvs.a() }));
            parambldb.b(this.jdField_a_of_type_Bdvs);
          }
        }
        this.jdField_a_of_type_Blcx = paramblcx;
        this.jdField_a_of_type_Bdvs = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Blcx }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Blcx, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcz
 * JD-Core Version:    0.7.0.1
 */