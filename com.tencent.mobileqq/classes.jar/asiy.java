import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;

public class asiy
{
  private boolean a(asir paramasir, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramasir.a.h });
    }
    return true;
  }
  
  asir a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
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
    return new bdsw(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(asir paramasir, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramasir, paramMiniAppOptions)) {
      return;
    }
    bbct.a();
    paramasir.a();
  }
  
  void a(asiu paramasiu, @NonNull asis paramasis)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramasiu.h });
    }
    paramasis.a(paramasiu.f, "MiniAppLauncher", paramasiu.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asiy
 * JD-Core Version:    0.7.0.1
 */