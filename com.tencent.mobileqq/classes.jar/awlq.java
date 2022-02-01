import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class awlq
{
  Map<String, awlp> a = new ConcurrentHashMap();
  
  awlp a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    awlp localawlp = (awlp)this.a.get(paramString);
    if ((localawlp != null) && (paramBoolean)) {
      if (!a(localawlp, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localawlp;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localawlp;
  }
  
  void a(awlp paramawlp, int paramInt, awls paramawls)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramawls, paramawlp, paramInt), 128, null, true);
  }
  
  boolean a(awlp paramawlp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramawlp.jdField_c_of_type_Int) });
    }
    return (paramawlp != null) && (paramawlp.jdField_c_of_type_Int == 1);
  }
  
  boolean a(awlp paramawlp, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramawlp.h });
    }
    if (paramInt2 == 1)
    {
      if (paramawlp.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramawlp.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramawlp.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(awlp paramawlp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramawlp.f });
    }
    return !TextUtils.isEmpty(paramawlp.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlq
 * JD-Core Version:    0.7.0.1
 */