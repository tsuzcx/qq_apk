import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class aueg
{
  Map<String, auef> a = new ConcurrentHashMap();
  
  auef a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    auef localauef = (auef)this.a.get(paramString);
    if ((localauef != null) && (paramBoolean)) {
      if (!a(localauef, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localauef;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localauef;
  }
  
  void a(auef paramauef, int paramInt, auei paramauei)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramauei, paramauef, paramInt), 128, null, true);
  }
  
  boolean a(auef paramauef)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramauef.jdField_c_of_type_Int) });
    }
    return (paramauef != null) && (paramauef.jdField_c_of_type_Int == 1);
  }
  
  boolean a(auef paramauef, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramauef.h });
    }
    if (paramInt2 == 1)
    {
      if (paramauef.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramauef.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramauef.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(auef paramauef)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramauef.f });
    }
    return !TextUtils.isEmpty(paramauef.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aueg
 * JD-Core Version:    0.7.0.1
 */