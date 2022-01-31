import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class awko
  extends batl
{
  public awko(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(batm parambatm)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambatm.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambatm = awkk.a(this.b);
        if (this.c.equalsIgnoreCase(parambatm))
        {
          awkk.b(this.b);
          awkk.a(awkk.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          baig.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambatm = new HashMap();
        parambatm.put("param_FailCode", String.valueOf(i));
        awrn.a(BaseApplication.getContext()).a(null, "videoRedbagResDownload", bool, 0L, 0L, parambatm, "");
        awkk.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        bace.d(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambatm.b + " code=" + parambatm.a);
        }
        i = parambatm.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awko
 * JD-Core Version:    0.7.0.1
 */