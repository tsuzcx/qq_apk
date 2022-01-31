import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.gmersdk_warper.GMEAVEngineWalper.2.1;

public class biox
  implements bipf
{
  biox(biov parambiov) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      QLog.e("AVEngineWalper", 1, "enter room successfully!!!");
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.b(paramInt, paramString);
      }
      new Handler(Looper.getMainLooper()).postDelayed(new GMEAVEngineWalper.2.1(this), 500L);
      return;
      QLog.e("AVEngineWalper", 1, "enter room failed. result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biox
 * JD-Core Version:    0.7.0.1
 */