import android.text.TextUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.TianshuBigInsertPage.4.1;

public class bkzb
  implements akbj
{
  bkzb(bkyx parambkyx) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TianshuBigInsertPage", 2, "onResult: " + paramInt + ", path: " + paramPathResult.filePath);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.filePath))) {
      bkyx.a(this.a).a().runOnUiThread(new TianshuBigInsertPage.4.1(this, paramPathResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzb
 * JD-Core Version:    0.7.0.1
 */