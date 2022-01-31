import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class azie
  implements aivw
{
  azie(azic paramazic, azik paramazik, SoConfig.SoDetailInfo paramSoDetailInfo, DownloadParam paramDownloadParam) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] download resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    VACDReportUtil.a(azic.a(this.jdField_a_of_type_Azic).a, null, "load.item.download.end", "sc=" + paramPathResult.subErrCode, paramInt, null);
    azic.a(this.jdField_a_of_type_Azic, paramPathResult.subErrCode);
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      azic.a(this.jdField_a_of_type_Azic, true);
      paramPathResult = new File(paramPathResult.folderPath, this.jdField_a_of_type_Azik.b).getAbsolutePath();
      if (azic.a(this.jdField_a_of_type_Azic, paramPathResult, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.crc, this.jdField_a_of_type_Azik, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo, 2))
      {
        azic.a(this.jdField_a_of_type_Azic, paramPathResult, this.jdField_a_of_type_Azik, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url);
        return;
      }
      azic.a(this.jdField_a_of_type_Azic, 10);
      return;
    }
    if (azic.a(this.jdField_a_of_type_Azic, this.jdField_a_of_type_Azik))
    {
      azic.a(this.jdField_a_of_type_Azic, 0);
      return;
    }
    if (paramInt == 2)
    {
      azic.a(this.jdField_a_of_type_Azic, 4);
      return;
    }
    if (paramPathResult.subErrCode == 404)
    {
      azic.a(this.jdField_a_of_type_Azic, 9, paramPathResult.url);
      return;
    }
    azic.a(this.jdField_a_of_type_Azic, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azie
 * JD-Core Version:    0.7.0.1
 */