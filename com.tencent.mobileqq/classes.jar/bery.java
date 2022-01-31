import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bery
  implements agpe
{
  bery(berw paramberw, besd parambesd) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] download resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    VACDReportUtil.a(berw.a(this.jdField_a_of_type_Berw).a, null, "load.item.download.end", "sc=" + paramPathResult.subErrCode, paramInt, null);
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      berw.a(this.jdField_a_of_type_Berw, true);
      paramPathResult = new File(paramPathResult.folderPath, this.jdField_a_of_type_Besd.b).getAbsolutePath();
      berw.a(this.jdField_a_of_type_Berw, paramPathResult, this.jdField_a_of_type_Besd);
      return;
    }
    if (berw.a(this.jdField_a_of_type_Berw, this.jdField_a_of_type_Besd))
    {
      berw.a(this.jdField_a_of_type_Berw, 0);
      return;
    }
    if (paramInt == 2)
    {
      berw.a(this.jdField_a_of_type_Berw, 4);
      return;
    }
    if (paramPathResult.subErrCode == 404)
    {
      berw.a(this.jdField_a_of_type_Berw, 9);
      return;
    }
    berw.a(this.jdField_a_of_type_Berw, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bery
 * JD-Core Version:    0.7.0.1
 */