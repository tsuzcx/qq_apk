import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;

public class auaa
{
  private boolean a(atzt paramatzt, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramatzt.a.h });
    }
    return true;
  }
  
  atzt a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
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
    return new bfti(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(atzt paramatzt, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramatzt, paramMiniAppOptions)) {
      return;
    }
    bdcb.a();
    paramatzt.a();
  }
  
  void a(atzw paramatzw, @NonNull atzu paramatzu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramatzw.h });
    }
    paramatzu.a(paramatzw.f, "MiniAppLauncher", paramatzw.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auaa
 * JD-Core Version:    0.7.0.1
 */