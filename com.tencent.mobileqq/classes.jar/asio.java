import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.2.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.IteApkInfoResp;
import com.tencent.turingfd.sdk.xq.IteApkInfoRespCallback;
import java.util.Map;

public class asio
  implements IteApkInfoRespCallback
{
  asio(asim paramasim) {}
  
  public void onResult(long paramLong, Map<Integer, IteApkInfoResp> paramMap)
  {
    int k = 2;
    int m = 0;
    String str3 = "";
    String str4 = "";
    int j = k;
    int i = m;
    String str2 = str3;
    String str1 = str4;
    if (paramMap != null)
    {
      paramMap = (IteApkInfoResp)paramMap.get(Integer.valueOf(this.a.a));
      j = k;
      i = m;
      str2 = str3;
      str1 = str4;
      if (paramMap != null)
      {
        j = (int)paramMap.getErrorCode();
        i = paramMap.getSafeLevel();
        str2 = paramMap.getRiskTips();
        str1 = paramMap.getHandleUrl();
      }
    }
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.a.a + "> on checkresult. errCode:" + j + " safeLevel:" + i + " tipString:" + str2 + " jumpDetailUrl:" + str1);
    new Handler(Looper.getMainLooper()).post(new MMApkFileSafeChecker.CheckTask.2.1(this, j, i, str2, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asio
 * JD-Core Version:    0.7.0.1
 */