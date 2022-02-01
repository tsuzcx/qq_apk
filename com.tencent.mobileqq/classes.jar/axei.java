import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class axei
{
  Map<String, axeh> a = new ConcurrentHashMap();
  
  axeh a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    axeh localaxeh = (axeh)this.a.get(paramString);
    if ((localaxeh != null) && (paramBoolean)) {
      if (!a(localaxeh, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localaxeh;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localaxeh;
  }
  
  void a(axeh paramaxeh, int paramInt, axek paramaxek)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramaxek, paramaxeh, paramInt), 128, null, true);
  }
  
  boolean a(axeh paramaxeh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramaxeh.jdField_c_of_type_Int) });
    }
    return (paramaxeh != null) && (paramaxeh.jdField_c_of_type_Int == 1);
  }
  
  boolean a(axeh paramaxeh, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramaxeh.h });
    }
    if (paramInt2 == 1)
    {
      if (paramaxeh.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramaxeh.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramaxeh.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(axeh paramaxeh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramaxeh.f });
    }
    return !TextUtils.isEmpty(paramaxeh.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axei
 * JD-Core Version:    0.7.0.1
 */