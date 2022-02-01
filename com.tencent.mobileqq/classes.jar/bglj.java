import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.vas.watchword.VasWatchWord.shareWatchWord.1.1;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
public final class bglj
  implements EIPCResultCallback
{
  bglj(String paramString1, String paramString2) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    int i = paramEIPCResult.data.getInt("ret");
    String str = paramEIPCResult.data.getString("sharemsg");
    if (QLog.isColorLevel()) {
      QLog.d("VasWatchWord", 2, "bid:" + this.a + " id:" + this.b + ", ret:" + paramEIPCResult.data.getInt("ret") + ", shareMsg:" + str);
    }
    if (i == 0) {
      new Handler(Looper.getMainLooper()).post((Runnable)new VasWatchWord.shareWatchWord.1.1(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglj
 * JD-Core Version:    0.7.0.1
 */