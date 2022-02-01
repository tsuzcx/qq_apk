import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bdgk
  implements aldq
{
  bdgk(bdgh parambdgh, boolean paramBoolean1, boolean paramBoolean2, bdhi parambdhi) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[downloadSo] resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    VACDReportUtil.a(this.jdField_a_of_type_Bdgh.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.download.end", "sc=" + paramPathResult.subErrCode, paramInt, null);
    this.jdField_a_of_type_Bdgh.jdField_a_of_type_Int = paramPathResult.subErrCode;
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      this.jdField_a_of_type_Bdgh.jdField_a_of_type_Boolean = true;
      paramPathResult = new File(paramPathResult.folderPath, this.jdField_a_of_type_Bdgh.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.soFileName).getAbsolutePath();
      bdgh.a(this.jdField_a_of_type_Bdgh, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_Bdhi, paramPathResult, this.jdField_a_of_type_Bdgh.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.crc, 2);
      return;
    }
    if (paramInt == 2)
    {
      bdgh.a(this.jdField_a_of_type_Bdgh, 4);
      return;
    }
    if (paramPathResult.subErrCode == 404)
    {
      bdgh.a(this.jdField_a_of_type_Bdgh, 9);
      return;
    }
    bdgh.a(this.jdField_a_of_type_Bdgh, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgk
 * JD-Core Version:    0.7.0.1
 */