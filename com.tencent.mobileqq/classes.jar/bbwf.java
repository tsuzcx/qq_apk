import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bbwf
  extends bgod
{
  public bbwf(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bgoe parambgoe)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (parambgoe.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        parambgoe = bbwb.a(this.b);
        if (this.c.equalsIgnoreCase(parambgoe))
        {
          bbwb.b(this.b);
          bbwb.a(bbwb.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          bfyz.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        parambgoe = new HashMap();
        parambgoe.put("param_FailCode", String.valueOf(i));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "videoRedbagResDownload", bool, 0L, 0L, parambgoe, "");
        bbwb.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        FileUtils.deleteFile(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambgoe.b + " code=" + parambgoe.a);
        }
        i = parambgoe.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwf
 * JD-Core Version:    0.7.0.1
 */