import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bdda
  extends bhyn
{
  public bdda(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bhyo parambhyo)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambhyo.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambhyo = bdcw.a(this.b);
        if (this.c.equalsIgnoreCase(parambhyo))
        {
          bdcw.b(this.b);
          bdcw.a(bdcw.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          bhhr.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambhyo = new HashMap();
        parambhyo.put("param_FailCode", String.valueOf(i));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "videoRedbagResDownload", bool, 0L, 0L, parambhyo, "");
        bdcw.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        FileUtils.deleteFile(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambhyo.b + " code=" + parambhyo.a);
        }
        i = parambhyo.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdda
 * JD-Core Version:    0.7.0.1
 */