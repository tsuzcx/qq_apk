import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bddc
  extends biht
{
  public bddc(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bihu parambihu)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambihu.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambihu = bdcy.a(this.b);
        if (this.c.equalsIgnoreCase(parambihu))
        {
          bdcy.b(this.b);
          bdcy.a(bdcy.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          bhsi.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambihu = new HashMap();
        parambihu.put("param_FailCode", String.valueOf(i));
        bdmc.a(BaseApplication.getContext()).a(null, "videoRedbagResDownload", bool, 0L, 0L, parambihu, "");
        bdcy.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        bhmi.d(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambihu.b + " code=" + parambihu.a);
        }
        i = parambihu.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddc
 * JD-Core Version:    0.7.0.1
 */