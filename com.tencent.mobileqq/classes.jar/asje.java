import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

final class asje
  implements aivw
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asje
 * JD-Core Version:    0.7.0.1
 */