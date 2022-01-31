import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class atzx
{
  Map<String, atzw> a = new ConcurrentHashMap();
  
  atzw a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    atzw localatzw = (atzw)this.a.get(paramString);
    if ((localatzw != null) && (paramBoolean)) {
      if (!a(localatzw, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localatzw;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localatzw;
  }
  
  void a(atzw paramatzw, int paramInt, atzz paramatzz)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramatzz, paramatzw, paramInt), 128, null, true);
  }
  
  boolean a(atzw paramatzw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramatzw.jdField_c_of_type_Int) });
    }
    return (paramatzw != null) && (paramatzw.jdField_c_of_type_Int == 1);
  }
  
  boolean a(atzw paramatzw, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramatzw.h });
    }
    if (paramInt2 == 1)
    {
      if (paramatzw.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramatzw.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramatzw.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(atzw paramatzw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramatzw.f });
    }
    return !TextUtils.isEmpty(paramatzw.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atzx
 * JD-Core Version:    0.7.0.1
 */