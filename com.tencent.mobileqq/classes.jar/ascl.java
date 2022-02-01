import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ascl
  extends biht
{
  ascl(ascj paramascj, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bihu parambihu)
  {
    boolean bool;
    int i;
    if (parambihu.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambihu = ascj.a(this.jdField_a_of_type_Ascj, this.b);
      if (this.c.equalsIgnoreCase(parambihu))
      {
        ascj.a(this.jdField_a_of_type_Ascj, this.b);
        ascj.a(this.jdField_a_of_type_Ascj, ascj.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        bhsi.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambihu = new HashMap();
      parambihu.put("param_FailCode", String.valueOf(i));
      bdmc.a(BaseApplication.getContext()).a(null, "doutuResDownload", bool, 0L, 0L, parambihu, "");
      ascj.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      bhmi.d(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambihu.b + " code=" + parambihu.a);
      }
      i = parambihu.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascl
 * JD-Core Version:    0.7.0.1
 */