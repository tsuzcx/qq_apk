import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import java.io.File;

class aqsq
  implements ahbt
{
  aqsq(aqsp paramaqsp, FullPopData paramFullPopData) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      paramPathResult = new File(paramPathResult.folderPath);
      if (paramPathResult.exists())
      {
        aqsp.a(this.jdField_a_of_type_Aqsp, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData);
        aqsp.a(this.jdField_a_of_type_Aqsp).resPath = paramPathResult.getPath();
        this.jdField_a_of_type_Aqsp.a = true;
        if (QLog.isColorLevel()) {
          QLog.d("FullPopBussiness", 1, "full pop res is ready");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsq
 * JD-Core Version:    0.7.0.1
 */