import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.ipv6.Ipv6Flags;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;

public class bezp
{
  public static bezn a()
  {
    if (!b()) {
      return new bezq();
    }
    Ipv6Flags localIpv6Flags = Ipv6Config.getFlags();
    if (localIpv6Flags.mRMDownStrategy == 2) {
      return new bezr();
    }
    if (localIpv6Flags.mRMDownStrategy == 3) {
      return new bezm(MsfServiceSdk.get().getConnectedIPFamily());
    }
    return new bezq();
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IpStrategyFactory", 0, "isIpv6Selected ");
    }
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    if (i == 2) {
      return true;
    }
    if (i == 3) {
      return c();
    }
    return false;
  }
  
  private static boolean b()
  {
    arix localarix = (arix)aran.a().a(538);
    if (localarix != null) {
      return localarix.c;
    }
    return false;
  }
  
  private static boolean c()
  {
    boolean bool = true;
    if (!b()) {
      if (QLog.isColorLevel()) {
        QLog.d("IpStrategyFactory", 0, "isIpv6DownFirst, getRichmediaIpv6Switch is false");
      }
    }
    do
    {
      return false;
      if (Ipv6Config.getFlags().mRMDownStrategy == 2) {
        return true;
      }
    } while (Ipv6Config.getFlags().mRMDownStrategy != 3);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezp
 * JD-Core Version:    0.7.0.1
 */