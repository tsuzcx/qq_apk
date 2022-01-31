import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aojb
  implements ansr
{
  public aojb(ConfessPlugin paramConfessPlugin) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("ConfessPlugin", 4, "preLoadQQSelfHeaderBitmap onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
      if ((this.a.a != null) && (this.a.mRuntime != null) && (this.a.mRuntime.a() != null) && (TextUtils.equals(paramString1, this.a.mRuntime.a().getCurrentAccountUin())))
      {
        ThreadManager.getUIHandler().removeCallbacks(ConfessPlugin.a(this.a));
        ThreadManager.getUIHandler().post(ConfessPlugin.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojb
 * JD-Core Version:    0.7.0.1
 */