import android.os.Handler;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArConfigService.8.1;
import com.tencent.mobileqq.ar.ArConfigService.8.2;
import com.tencent.mobileqq.ar.ArConfigService.8.3;
import com.tencent.qphone.base.util.QLog;

public class amwy
  implements andm
{
  public amwy(ArConfigService paramArConfigService) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "mARFeatureDownloadCallBack");
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("mARFeatureDownloadCallBack onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    ArConfigService.e(this.a, (int)(100L * paramLong1 / paramLong2));
    int i = (ArConfigService.a(this.a) + ArConfigService.b(this.a) + ArConfigService.c(this.a) + ArConfigService.d(this.a) + ArConfigService.e(this.a)) / 5;
    if (!ArConfigService.e(this.a)) {
      ArConfigService.a(this.a).post(new ArConfigService.8.1(this, i));
    }
  }
  
  public void a(boolean paramBoolean, andn paramandn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("mARFeatureDownloadCallBack  result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      ArConfigService.f(this.a, true);
      if ((ArConfigService.f(this.a)) && (ArConfigService.g(this.a)) && (ArConfigService.h(this.a)) && (ArConfigService.i(this.a)) && (ArConfigService.j(this.a))) {
        ArConfigService.a(this.a).post(new ArConfigService.8.2(this));
      }
    }
    while (ArConfigService.e(this.a)) {
      return;
    }
    ArConfigService.a(this.a).post(new ArConfigService.8.3(this));
    ArConfigService.a(this.a, true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwy
 * JD-Core Version:    0.7.0.1
 */