import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class azmn
  implements ajal
{
  azmn(azml paramazml, azmt paramazmt, SoConfig.SoDetailInfo paramSoDetailInfo, DownloadParam paramDownloadParam) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] download resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    VACDReportUtil.a(azml.a(this.jdField_a_of_type_Azml).a, null, "load.item.download.end", "sc=" + paramPathResult.subErrCode, paramInt, null);
    azml.a(this.jdField_a_of_type_Azml, paramPathResult.subErrCode);
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      azml.a(this.jdField_a_of_type_Azml, true);
      paramPathResult = new File(paramPathResult.folderPath, this.jdField_a_of_type_Azmt.b).getAbsolutePath();
      if (azml.a(this.jdField_a_of_type_Azml, paramPathResult, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.crc, this.jdField_a_of_type_Azmt, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo, 2))
      {
        azml.a(this.jdField_a_of_type_Azml, paramPathResult, this.jdField_a_of_type_Azmt, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url);
        return;
      }
      azml.a(this.jdField_a_of_type_Azml, 10);
      return;
    }
    if (azml.a(this.jdField_a_of_type_Azml, this.jdField_a_of_type_Azmt))
    {
      azml.a(this.jdField_a_of_type_Azml, 0);
      return;
    }
    if (paramInt == 2)
    {
      azml.a(this.jdField_a_of_type_Azml, 4);
      return;
    }
    if (paramPathResult.subErrCode == 404)
    {
      azml.a(this.jdField_a_of_type_Azml, 9, paramPathResult.url);
      return;
    }
    azml.a(this.jdField_a_of_type_Azml, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmn
 * JD-Core Version:    0.7.0.1
 */