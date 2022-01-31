import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

final class aqsv
  implements ahbt
{
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, "dowloadFullPopRes complete! rescpde=" + paramInt);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)) && (QLog.isColorLevel())) {
      QLog.d("QQGameHelper", 1, "dowloadFullPopRes fileUrl=" + paramPathResult.url + " unzipPath=" + paramPathResult.folderPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsv
 * JD-Core Version:    0.7.0.1
 */