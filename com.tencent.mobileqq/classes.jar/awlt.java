import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;

public class awlt
{
  private boolean a(awlm paramawlm, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramawlm.a.h });
    }
    return true;
  }
  
  awlm a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
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
    return new bjfb(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(awlm paramawlm, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramawlm, paramMiniAppOptions)) {
      return;
    }
    bgln.a();
    paramawlm.a();
  }
  
  void a(awlp paramawlp, @NonNull awln paramawln)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramawlp.h });
    }
    paramawln.a(paramawlp.f, "MiniAppLauncher", paramawlp.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlt
 * JD-Core Version:    0.7.0.1
 */