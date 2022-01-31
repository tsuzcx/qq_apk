import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class apfr
  extends bdvu
{
  apfr(apfp paramapfp, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bdvv parambdvv)
  {
    boolean bool;
    int i;
    if (parambdvv.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambdvv = apfp.a(this.jdField_a_of_type_Apfp, this.b);
      if (this.c.equalsIgnoreCase(parambdvv))
      {
        apfp.a(this.jdField_a_of_type_Apfp, this.b);
        apfp.a(this.jdField_a_of_type_Apfp, apfp.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        bdiv.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambdvv = new HashMap();
      parambdvv.put("param_FailCode", String.valueOf(i));
      azmz.a(BaseApplication.getContext()).a(null, "doutuResDownload", bool, 0L, 0L, parambdvv, "");
      apfp.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      bdcs.d(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambdvv.b + " code=" + parambdvv.a);
      }
      i = parambdvv.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfr
 * JD-Core Version:    0.7.0.1
 */