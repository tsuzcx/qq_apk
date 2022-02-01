import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anmm
{
  anmk jdField_a_of_type_Anmk = null;
  anmo jdField_a_of_type_Anmo;
  beum jdField_a_of_type_Beum;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(anmk paramanmk, int paramInt)
  {
    String str1;
    if (!anml.b(paramanmk))
    {
      String str2 = paramanmk.jdField_a_of_type_JavaLangString;
      str1 = paramanmk.b;
      String str3 = anml.a(paramanmk);
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new anmn(this, str1, paramanmk);
      localbeum.a(str1);
      localbeum.jdField_a_of_type_JavaLangString = str2;
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.c = new File(str3).getPath();
      localbeum.b = bhnv.a(bevn.a().a());
      paramanmk = anbd.a().getNetEngine(0);
      if (paramanmk == null) {
        break label206;
      }
      this.jdField_a_of_type_Beum = localbeum;
      paramanmk.a(this.jdField_a_of_type_Beum);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Anmo != null)) {
        this.jdField_a_of_type_Anmo.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Anmo != null) {
        this.jdField_a_of_type_Anmo.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(anmk paramanmk, anmo paramanmo)
  {
    this.jdField_a_of_type_Anmo = paramanmo;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Anmk == paramanmk) || (TextUtils.isEmpty(paramanmk.b)) || (paramanmk.b.equals(this.jdField_a_of_type_Anmk.b))) {
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
          paramanmo = anbd.a().getNetEngine(0);
          if (paramanmo != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Beum.a() }));
            paramanmo.b(this.jdField_a_of_type_Beum);
          }
        }
        this.jdField_a_of_type_Anmk = paramanmk;
        this.jdField_a_of_type_Beum = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Anmk }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Anmk, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmm
 * JD-Core Version:    0.7.0.1
 */