import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class axju
  extends bbwf
{
  public axju(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bbwg parambbwg)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambbwg.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambbwg = axjq.a(this.b);
        if (this.c.equalsIgnoreCase(parambbwg))
        {
          axjq.b(this.b);
          axjq.a(axjq.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          bbjn.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambbwg = new HashMap();
        parambbwg.put("param_FailCode", String.valueOf(i));
        axrl.a(BaseApplication.getContext()).a(null, "videoRedbagResDownload", bool, 0L, 0L, parambbwg, "");
        axjq.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        bbdj.d(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambbwg.b + " code=" + parambbwg.a);
        }
        i = parambbwg.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axju
 * JD-Core Version:    0.7.0.1
 */