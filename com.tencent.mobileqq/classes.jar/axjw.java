import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class axjw
  extends bbwt
{
  public axjw(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bbwu parambbwu)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambbwu.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambbwu = axjs.a(this.b);
        if (this.c.equalsIgnoreCase(parambbwu))
        {
          axjs.b(this.b);
          axjs.a(axjs.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          bbkb.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambbwu = new HashMap();
        parambbwu.put("param_FailCode", String.valueOf(i));
        axrn.a(BaseApplication.getContext()).a(null, "videoRedbagResDownload", bool, 0L, 0L, parambbwu, "");
        axjs.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        bbdx.d(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambbwu.b + " code=" + parambbwu.a);
        }
        i = parambbwu.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axjw
 * JD-Core Version:    0.7.0.1
 */