import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class azjl
  extends bead
{
  public azjl(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(beae parambeae)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambeae.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambeae = azjh.a(this.b);
        if (this.c.equalsIgnoreCase(parambeae))
        {
          azjh.b(this.b);
          azjh.a(azjh.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          bdne.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambeae = new HashMap();
        parambeae.put("param_FailCode", String.valueOf(i));
        azri.a(BaseApplication.getContext()).a(null, "videoRedbagResDownload", bool, 0L, 0L, parambeae, "");
        azjh.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        bdhb.d(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambeae.b + " code=" + parambeae.a);
        }
        i = parambeae.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjl
 * JD-Core Version:    0.7.0.1
 */