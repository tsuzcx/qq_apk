import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class awxx
{
  private boolean a(awxq paramawxq, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramawxq.a.h });
    }
    return true;
  }
  
  awxq a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
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
    return new bjwl(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(awxq paramawxq, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramawxq, paramMiniAppOptions)) {
      return;
    }
    DeviceInfoUtil.getDesity();
    paramawxq.a();
  }
  
  void a(awxt paramawxt, @NonNull awxr paramawxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramawxt.h });
    }
    paramawxr.a(paramawxt.f, "MiniAppLauncher", paramawxt.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxx
 * JD-Core Version:    0.7.0.1
 */