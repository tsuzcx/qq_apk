import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class arms
{
  Map<String, armr> a = new ConcurrentHashMap();
  
  armr a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    armr localarmr = (armr)this.a.get(paramString);
    if ((localarmr != null) && (paramBoolean)) {
      if (!a(localarmr, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localarmr;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localarmr;
  }
  
  void a(armr paramarmr, int paramInt, armu paramarmu)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramarmu, paramarmr, paramInt), 128, null, true);
  }
  
  boolean a(armr paramarmr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramarmr.jdField_c_of_type_Int) });
    }
    return (paramarmr != null) && (paramarmr.jdField_c_of_type_Int == 1);
  }
  
  boolean a(armr paramarmr, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramarmr.h });
    }
    if (paramInt2 == 1)
    {
      if (paramarmr.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramarmr.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramarmr.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(armr paramarmr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramarmr.f });
    }
    return !TextUtils.isEmpty(paramarmr.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     arms
 * JD-Core Version:    0.7.0.1
 */