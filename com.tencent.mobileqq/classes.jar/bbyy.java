import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bbyy
  implements akbj
{
  bbyy(bbyv parambbyv, boolean paramBoolean1, boolean paramBoolean2, bbzx parambbzx) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[downloadSo] resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    bbzi.a(this.jdField_a_of_type_Bbyv.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_Bbyv.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.download.end", "sc=" + paramPathResult.subErrCode, paramInt, null);
    this.jdField_a_of_type_Bbyv.jdField_a_of_type_Int = paramPathResult.subErrCode;
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      this.jdField_a_of_type_Bbyv.jdField_a_of_type_Boolean = true;
      paramPathResult = new File(paramPathResult.folderPath, this.jdField_a_of_type_Bbyv.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.soFileName).getAbsolutePath();
      bbyv.a(this.jdField_a_of_type_Bbyv, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_Bbzx, paramPathResult, this.jdField_a_of_type_Bbyv.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.crc, 2);
      return;
    }
    if (paramInt == 2)
    {
      bbyv.a(this.jdField_a_of_type_Bbyv, 4);
      return;
    }
    if (paramPathResult.subErrCode == 404)
    {
      bbyv.a(this.jdField_a_of_type_Bbyv, 9);
      return;
    }
    bbyv.a(this.jdField_a_of_type_Bbyv, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyy
 * JD-Core Version:    0.7.0.1
 */