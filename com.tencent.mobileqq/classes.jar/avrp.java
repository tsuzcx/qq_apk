import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class avrp
{
  Map<String, avro> a = new ConcurrentHashMap();
  
  avro a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    avro localavro = (avro)this.a.get(paramString);
    if ((localavro != null) && (paramBoolean)) {
      if (!a(localavro, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localavro;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localavro;
  }
  
  void a(avro paramavro, int paramInt, avrr paramavrr)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramavrr, paramavro, paramInt), 128, null, true);
  }
  
  boolean a(avro paramavro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramavro.jdField_c_of_type_Int) });
    }
    return (paramavro != null) && (paramavro.jdField_c_of_type_Int == 1);
  }
  
  boolean a(avro paramavro, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramavro.h });
    }
    if (paramInt2 == 1)
    {
      if (paramavro.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramavro.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramavro.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(avro paramavro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramavro.f });
    }
    return !TextUtils.isEmpty(paramavro.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrp
 * JD-Core Version:    0.7.0.1
 */