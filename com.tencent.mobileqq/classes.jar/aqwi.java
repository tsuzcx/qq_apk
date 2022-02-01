import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aqwi
  extends bgod
{
  aqwi(aqwg paramaqwg, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bgoe parambgoe)
  {
    boolean bool;
    int i;
    if (parambgoe.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambgoe = aqwg.a(this.jdField_a_of_type_Aqwg, this.b);
      if (this.c.equalsIgnoreCase(parambgoe))
      {
        aqwg.a(this.jdField_a_of_type_Aqwg, this.b);
        aqwg.a(this.jdField_a_of_type_Aqwg, aqwg.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        bfyz.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambgoe = new HashMap();
      parambgoe.put("param_FailCode", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "doutuResDownload", bool, 0L, 0L, parambgoe, "");
      aqwg.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      FileUtils.deleteFile(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambgoe.b + " code=" + parambgoe.a);
      }
      i = parambgoe.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwi
 * JD-Core Version:    0.7.0.1
 */