import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class avrs
{
  private boolean a(avrl paramavrl, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramavrl.a.h });
    }
    return true;
  }
  
  avrl a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "createApp type=", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    default: 
      QLog.e("MiniAppLauncher", 1, "createApp error. unknown appType");
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
      return null;
    }
    return new bilj(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(avrl paramavrl, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramavrl, paramMiniAppOptions)) {
      return;
    }
    DeviceInfoUtil.getDesity();
    paramavrl.a();
  }
  
  void a(avro paramavro, @NonNull avrm paramavrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramavro.h });
    }
    paramavrm.a(paramavro.f, "MiniAppLauncher", paramavro.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrs
 * JD-Core Version:    0.7.0.1
 */