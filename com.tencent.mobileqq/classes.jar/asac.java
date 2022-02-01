import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class asac
  extends bhyn
{
  asac(asaa paramasaa, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(bhyo parambhyo)
  {
    boolean bool;
    int i;
    if (parambhyo.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
      }
      parambhyo = asaa.a(this.jdField_a_of_type_Asaa, this.b);
      if (this.c.equalsIgnoreCase(parambhyo))
      {
        asaa.a(this.jdField_a_of_type_Asaa, this.b);
        asaa.a(this.jdField_a_of_type_Asaa, asaa.jdField_a_of_type_JavaLangString + "doutuResInfo", this.c);
        bhhr.d(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      parambhyo = new HashMap();
      parambhyo.put("param_FailCode", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "doutuResDownload", bool, 0L, 0L, parambhyo, "");
      asaa.jdField_a_of_type_Boolean = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.b);
      }
      i = 80704;
      FileUtils.deleteFile(this.b);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + parambhyo.b + " code=" + parambhyo.a);
      }
      i = parambhyo.a;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asac
 * JD-Core Version:    0.7.0.1
 */