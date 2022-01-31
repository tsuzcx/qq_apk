import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class anof
  extends bbwf
{
  anof(anod paramanod, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bbwg parambbwg)
  {
    boolean bool;
    int i;
    if (parambbwg.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambbwg = anod.a(this.jdField_a_of_type_Anod, this.b);
      if (this.c.equalsIgnoreCase(parambbwg))
      {
        anod.a(this.jdField_a_of_type_Anod, this.b);
        anod.a(this.jdField_a_of_type_Anod, anod.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        bbjn.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambbwg = new HashMap();
      parambbwg.put("param_FailCode", String.valueOf(i));
      axrl.a(BaseApplication.getContext()).a(null, "doutuResDownload", bool, 0L, 0L, parambbwg, "");
      anod.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      bbdj.d(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambbwg.b + " code=" + parambbwg.a);
      }
      i = parambbwg.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anof
 * JD-Core Version:    0.7.0.1
 */