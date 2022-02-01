import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;

public class axel
{
  private boolean a(axee paramaxee, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramaxee.a.h });
    }
    return true;
  }
  
  axee a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
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
    return new bkgb(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(axee paramaxee, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramaxee, paramMiniAppOptions)) {
      return;
    }
    bhlo.a();
    paramaxee.a();
  }
  
  void a(axeh paramaxeh, @NonNull axef paramaxef)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramaxeh.h });
    }
    paramaxef.a(paramaxeh.f, "MiniAppLauncher", paramaxeh.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axel
 * JD-Core Version:    0.7.0.1
 */