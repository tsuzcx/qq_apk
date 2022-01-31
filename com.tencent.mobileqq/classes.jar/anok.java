import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class anok
  extends bbwt
{
  anok(anoi paramanoi, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bbwu parambbwu)
  {
    boolean bool;
    int i;
    if (parambbwu.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambbwu = anoi.a(this.jdField_a_of_type_Anoi, this.b);
      if (this.c.equalsIgnoreCase(parambbwu))
      {
        anoi.a(this.jdField_a_of_type_Anoi, this.b);
        anoi.a(this.jdField_a_of_type_Anoi, anoi.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        bbkb.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambbwu = new HashMap();
      parambbwu.put("param_FailCode", String.valueOf(i));
      axrn.a(BaseApplication.getContext()).a(null, "doutuResDownload", bool, 0L, 0L, parambbwu, "");
      anoi.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      bbdx.d(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambbwu.b + " code=" + parambbwu.a);
      }
      i = parambbwu.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anok
 * JD-Core Version:    0.7.0.1
 */