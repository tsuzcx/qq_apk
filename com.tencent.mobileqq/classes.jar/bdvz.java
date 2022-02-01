import android.support.annotation.VisibleForTesting;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import java.util.ArrayList;

public class bdvz
{
  public static boolean a = true;
  
  public static ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    return a(paramArrayList1, paramArrayList2, NetConnInfoCenter.getActiveNetIpFamily(true), false);
  }
  
  @VisibleForTesting
  public static ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Ipv6Strategy", 0, "selectIpList netType = " + paramInt);
    }
    if (paramInt == 2) {
      return paramArrayList1;
    }
    if (paramInt == 3) {
      return a(paramArrayList1, paramArrayList2, paramBoolean);
    }
    return paramArrayList2;
  }
  
  private static ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramBoolean))
    {
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
        localArrayList.add(paramArrayList1.get(0));
      }
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {
        localArrayList.addAll(paramArrayList2);
      }
    }
    do
    {
      return localArrayList;
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {
        localArrayList.addAll(paramArrayList2);
      }
    } while ((paramArrayList1 == null) || (paramArrayList1.size() <= 0));
    localArrayList.add(paramArrayList1.get(0));
    return localArrayList;
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Ipv6Strategy", 0, "isIpv6Selected ");
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
  
  private static boolean a(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramBoolean) {
      paramBoolean = a;
    }
    do
    {
      do
      {
        return paramBoolean;
        if (d()) {
          break;
        }
        paramBoolean = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Ipv6Strategy", 0, "isIpv6DownFirst, getRichmediaIpv6Switch is false");
      return false;
      if (Ipv6Config.getInstance().mRMDownStrategy == 2) {
        return true;
      }
      paramBoolean = bool2;
    } while (Ipv6Config.getInstance().mRMDownStrategy != 3);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {}
    for (paramBoolean = bool1;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static boolean b()
  {
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    return (i == 2) || (i == 3);
  }
  
  public static boolean c()
  {
    return a(false);
  }
  
  private static boolean d()
  {
    aqtl localaqtl = (aqtl)aqlk.a().a(538);
    if (localaqtl != null) {
      return localaqtl.c;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvz
 * JD-Core Version:    0.7.0.1
 */