import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class awxu
{
  Map<String, awxt> a = new ConcurrentHashMap();
  
  awxt a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    awxt localawxt = (awxt)this.a.get(paramString);
    if ((localawxt != null) && (paramBoolean)) {
      if (!a(localawxt, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localawxt;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localawxt;
  }
  
  void a(awxt paramawxt, int paramInt, awxw paramawxw)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramawxw, paramawxt, paramInt), 128, null, true);
  }
  
  boolean a(awxt paramawxt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramawxt.jdField_c_of_type_Int) });
    }
    return (paramawxt != null) && (paramawxt.jdField_c_of_type_Int == 1);
  }
  
  boolean a(awxt paramawxt, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramawxt.h });
    }
    if (paramInt2 == 1)
    {
      if (paramawxt.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramawxt.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramawxt.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(awxt paramawxt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramawxt.f });
    }
    return !TextUtils.isEmpty(paramawxt.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxu
 * JD-Core Version:    0.7.0.1
 */