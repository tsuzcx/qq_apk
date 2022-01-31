import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class asix
{
  Map<String, asiw> a = new ConcurrentHashMap();
  
  asiw a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    asiw localasiw = (asiw)this.a.get(paramString);
    if ((localasiw != null) && (paramBoolean)) {
      if (!a(localasiw, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localasiw;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localasiw;
  }
  
  void a(asiw paramasiw, int paramInt, asiz paramasiz)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramasiz, paramasiw, paramInt), 128, null, true);
  }
  
  boolean a(asiw paramasiw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramasiw.jdField_c_of_type_Int) });
    }
    return (paramasiw != null) && (paramasiw.jdField_c_of_type_Int == 1);
  }
  
  boolean a(asiw paramasiw, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramasiw.h });
    }
    if (paramInt2 == 1)
    {
      if (paramasiw.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramasiw.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramasiw.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(asiw paramasiw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramasiw.f });
    }
    return !TextUtils.isEmpty(paramasiw.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asix
 * JD-Core Version:    0.7.0.1
 */