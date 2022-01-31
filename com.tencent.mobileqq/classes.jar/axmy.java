import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class axmy
  implements ahbr
{
  axmy(axmw paramaxmw, axnd paramaxnd) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] download resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    VACDReportUtil.a(axmw.a(this.jdField_a_of_type_Axmw).a, null, "load.item.download.end", "sc=" + paramPathResult.subErrCode, paramInt, null);
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      axmw.a(this.jdField_a_of_type_Axmw, true);
      paramPathResult = new File(paramPathResult.folderPath, this.jdField_a_of_type_Axnd.b).getAbsolutePath();
      axmw.a(this.jdField_a_of_type_Axmw, paramPathResult, this.jdField_a_of_type_Axnd);
      return;
    }
    if (axmw.a(this.jdField_a_of_type_Axmw, this.jdField_a_of_type_Axnd))
    {
      axmw.a(this.jdField_a_of_type_Axmw, 0);
      return;
    }
    if (paramInt == 2)
    {
      axmw.a(this.jdField_a_of_type_Axmw, 4);
      return;
    }
    if (paramPathResult.subErrCode == 404)
    {
      axmw.a(this.jdField_a_of_type_Axmw, 9);
      return;
    }
    axmw.a(this.jdField_a_of_type_Axmw, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmy
 * JD-Core Version:    0.7.0.1
 */