import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;

public class auej
{
  private boolean a(auec paramauec, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramauec.a.h });
    }
    return true;
  }
  
  auec a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
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
    return new bfxp(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(auec paramauec, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramauec, paramMiniAppOptions)) {
      return;
    }
    bdgk.a();
    paramauec.a();
  }
  
  void a(auef paramauef, @NonNull aued paramaued)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramauef.h });
    }
    paramaued.a(paramauef.f, "MiniAppLauncher", paramauef.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auej
 * JD-Core Version:    0.7.0.1
 */