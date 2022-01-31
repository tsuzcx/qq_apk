import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class asiv
{
  Map<String, asiu> a = new ConcurrentHashMap();
  
  asiu a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    asiu localasiu = (asiu)this.a.get(paramString);
    if ((localasiu != null) && (paramBoolean)) {
      if (!a(localasiu, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localasiu;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localasiu;
  }
  
  void a(asiu paramasiu, int paramInt, asix paramasix)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramasix, paramasiu, paramInt), 128, null, true);
  }
  
  boolean a(asiu paramasiu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramasiu.jdField_c_of_type_Int) });
    }
    return (paramasiu != null) && (paramasiu.jdField_c_of_type_Int == 1);
  }
  
  boolean a(asiu paramasiu, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramasiu.h });
    }
    if (paramInt2 == 1)
    {
      if (paramasiu.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramasiu.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramasiu.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(asiu paramasiu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramasiu.f });
    }
    return !TextUtils.isEmpty(paramasiu.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asiv
 * JD-Core Version:    0.7.0.1
 */