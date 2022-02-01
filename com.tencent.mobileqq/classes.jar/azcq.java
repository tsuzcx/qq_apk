import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class azcq
  extends azby
{
  azcq(azco paramazco) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    long l1;
    if (paramBoolean)
    {
      l1 = azbj.a().a(azco.a(this.a));
      if (l1 <= 40000L) {
        break label176;
      }
      if (!azco.a(this.a)) {
        break label114;
      }
      l2 = paramBundle.getLong("autoStatusInterval");
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + azcv.a((int)l1) + " autoStatusInterval: " + l2);
      }
      if (l2 > 60L) {
        azco.a(this.a, azcv.a((int)l2));
      }
    }
    label114:
    while (!azco.a(this.a))
    {
      long l2;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + azcv.a((int)l1) + " startDetector");
      }
      azco.a(this.a).a((int)l1);
      this.a.a("statusChange");
      return;
    }
    label176:
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + azcv.a((int)l1) + " stopDetector");
    }
    this.a.b("statusChange");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcq
 * JD-Core Version:    0.7.0.1
 */