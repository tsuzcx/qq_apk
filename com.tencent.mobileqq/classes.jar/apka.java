import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class apka
  extends bead
{
  apka(apjy paramapjy, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(beae parambeae)
  {
    boolean bool;
    int i;
    if (parambeae.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambeae = apjy.a(this.jdField_a_of_type_Apjy, this.b);
      if (this.c.equalsIgnoreCase(parambeae))
      {
        apjy.a(this.jdField_a_of_type_Apjy, this.b);
        apjy.a(this.jdField_a_of_type_Apjy, apjy.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        bdne.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambeae = new HashMap();
      parambeae.put("param_FailCode", String.valueOf(i));
      azri.a(BaseApplication.getContext()).a(null, "doutuResDownload", bool, 0L, 0L, parambeae, "");
      apjy.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      bdhb.d(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambeae.b + " code=" + parambeae.a);
      }
      i = parambeae.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apka
 * JD-Core Version:    0.7.0.1
 */