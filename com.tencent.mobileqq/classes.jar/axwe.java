import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class axwe
  extends axvm
{
  axwe(axwc paramaxwc) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    long l1;
    if (paramBoolean)
    {
      l1 = axuy.a().a(axwc.a(this.a));
      if (l1 <= 40000L) {
        break label176;
      }
      if (!axwc.a(this.a)) {
        break label114;
      }
      l2 = paramBundle.getLong("autoStatusInterval");
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + axwj.a((int)l1) + " autoStatusInterval: " + l2);
      }
      if (l2 > 60L) {
        axwc.a(this.a, axwj.a((int)l2));
      }
    }
    label114:
    while (!axwc.a(this.a))
    {
      long l2;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + axwj.a((int)l1) + " startDetector");
      }
      axwc.a(this.a).a((int)l1);
      this.a.a("statusChange");
      return;
    }
    label176:
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] onSetOnlineStatus status: " + axwj.a((int)l1) + " stopDetector");
    }
    this.a.b("statusChange");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwe
 * JD-Core Version:    0.7.0.1
 */