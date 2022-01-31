import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;

public class armv
{
  private boolean a(armo paramarmo, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramarmo.a.h });
    }
    return true;
  }
  
  armo a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
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
    return new bcov(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(armo paramarmo, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramarmo, paramMiniAppOptions)) {
      return;
    }
    babp.a();
    paramarmo.a();
  }
  
  void a(armr paramarmr, @NonNull armp paramarmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramarmr.h });
    }
    paramarmp.a(paramarmr.f, "MiniAppLauncher", paramarmr.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     armv
 * JD-Core Version:    0.7.0.1
 */