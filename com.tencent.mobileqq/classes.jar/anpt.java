import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.weiyun.utils.PreferenceUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public final class anpt
  implements Runnable
{
  public anpt(Context paramContext) {}
  
  public void run()
  {
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    boolean bool1 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_queried", false);
    boolean bool2 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_has", false);
    boolean bool3 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_verified", false);
    cooperation.weiyun.sdk.api.WeiyunApi.a()[0].set(bool1);
    cooperation.weiyun.sdk.api.WeiyunApi.a()[1].set(bool2);
    cooperation.weiyun.sdk.api.WeiyunApi.a()[2].set(bool3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpt
 * JD-Core Version:    0.7.0.1
 */