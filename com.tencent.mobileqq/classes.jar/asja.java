import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;

public class asja
{
  private boolean a(asit paramasit, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramasit.a.h });
    }
    return true;
  }
  
  asit a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
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
    return new bdtn(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(asit paramasit, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramasit, paramMiniAppOptions)) {
      return;
    }
    bbdh.a();
    paramasit.a();
  }
  
  void a(asiw paramasiw, @NonNull asiu paramasiu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramasiw.h });
    }
    paramasiu.a(paramasiw.f, "MiniAppLauncher", paramasiw.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asja
 * JD-Core Version:    0.7.0.1
 */