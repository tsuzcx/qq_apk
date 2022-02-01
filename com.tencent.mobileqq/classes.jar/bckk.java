import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bckk
  extends bhhe
{
  public bckk(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bhhf parambhhf)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambhhf.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambhhf = bckg.a(this.b);
        if (this.c.equalsIgnoreCase(parambhhf))
        {
          bckg.b(this.b);
          bckg.a(bckg.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          bgsg.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambhhf = new HashMap();
        parambhhf.put("param_FailCode", String.valueOf(i));
        bctj.a(BaseApplication.getContext()).a(null, "videoRedbagResDownload", bool, 0L, 0L, parambhhf, "");
        bckg.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        bgmg.d(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambhhf.b + " code=" + parambhhf.a);
        }
        i = parambhhf.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckk
 * JD-Core Version:    0.7.0.1
 */