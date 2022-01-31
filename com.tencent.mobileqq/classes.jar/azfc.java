import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class azfc
  extends bdvu
{
  public azfc(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bdvv parambdvv)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambdvv.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambdvv = azey.a(this.b);
        if (this.c.equalsIgnoreCase(parambdvv))
        {
          azey.b(this.b);
          azey.a(azey.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          bdiv.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambdvv = new HashMap();
        parambdvv.put("param_FailCode", String.valueOf(i));
        azmz.a(BaseApplication.getContext()).a(null, "videoRedbagResDownload", bool, 0L, 0L, parambdvv, "");
        azey.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        bdcs.d(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambdvv.b + " code=" + parambdvv.a);
        }
        i = parambdvv.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfc
 * JD-Core Version:    0.7.0.1
 */