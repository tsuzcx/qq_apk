import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class axmw
  implements ahbt
{
  axmw(axmu paramaxmu, axnb paramaxnb) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] download resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    VACDReportUtil.a(axmu.a(this.jdField_a_of_type_Axmu).a, null, "load.item.download.end", "sc=" + paramPathResult.subErrCode, paramInt, null);
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      axmu.a(this.jdField_a_of_type_Axmu, true);
      paramPathResult = new File(paramPathResult.folderPath, this.jdField_a_of_type_Axnb.b).getAbsolutePath();
      axmu.a(this.jdField_a_of_type_Axmu, paramPathResult, this.jdField_a_of_type_Axnb);
      return;
    }
    if (axmu.a(this.jdField_a_of_type_Axmu, this.jdField_a_of_type_Axnb))
    {
      axmu.a(this.jdField_a_of_type_Axmu, 0);
      return;
    }
    if (paramInt == 2)
    {
      axmu.a(this.jdField_a_of_type_Axmu, 4);
      return;
    }
    if (paramPathResult.subErrCode == 404)
    {
      axmu.a(this.jdField_a_of_type_Axmu, 9);
      return;
    }
    axmu.a(this.jdField_a_of_type_Axmu, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmw
 * JD-Core Version:    0.7.0.1
 */