import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class armv
  extends bhhe
{
  armv(armt paramarmt, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bhhf parambhhf)
  {
    boolean bool;
    int i;
    if (parambhhf.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambhhf = armt.a(this.jdField_a_of_type_Armt, this.b);
      if (this.c.equalsIgnoreCase(parambhhf))
      {
        armt.a(this.jdField_a_of_type_Armt, this.b);
        armt.a(this.jdField_a_of_type_Armt, armt.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        bgsg.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambhhf = new HashMap();
      parambhhf.put("param_FailCode", String.valueOf(i));
      bctj.a(BaseApplication.getContext()).a(null, "doutuResDownload", bool, 0L, 0L, parambhhf, "");
      armt.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      bgmg.d(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambhhf.b + " code=" + parambhhf.a);
      }
      i = parambhhf.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armv
 * JD-Core Version:    0.7.0.1
 */