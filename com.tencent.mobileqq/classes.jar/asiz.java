import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import java.io.File;

class asiz
  implements aivw
{
  asiz(asiy paramasiy, FullPopData paramFullPopData) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      paramPathResult = new File(paramPathResult.folderPath);
      if (paramPathResult.exists())
      {
        asiy.a(this.jdField_a_of_type_Asiy, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData);
        asiy.a(this.jdField_a_of_type_Asiy).resPath = paramPathResult.getPath();
        this.jdField_a_of_type_Asiy.a = true;
        if (QLog.isColorLevel()) {
          QLog.d("FullPopBussiness", 1, "full pop res is ready");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asiz
 * JD-Core Version:    0.7.0.1
 */