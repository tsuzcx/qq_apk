import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class amxx
  extends batl
{
  amxx(amxv paramamxv, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(batm parambatm)
  {
    boolean bool;
    int i;
    if (parambatm.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambatm = amxv.a(this.jdField_a_of_type_Amxv, this.b);
      if (this.c.equalsIgnoreCase(parambatm))
      {
        amxv.a(this.jdField_a_of_type_Amxv, this.b);
        amxv.a(this.jdField_a_of_type_Amxv, amxv.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        baig.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambatm = new HashMap();
      parambatm.put("param_FailCode", String.valueOf(i));
      awrn.a(BaseApplication.getContext()).a(null, "doutuResDownload", bool, 0L, 0L, parambatm, "");
      amxv.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      bace.d(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambatm.b + " code=" + parambatm.a);
      }
      i = parambatm.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amxx
 * JD-Core Version:    0.7.0.1
 */