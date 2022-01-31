import android.support.annotation.VisibleForTesting;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import java.util.ArrayList;

public class bauj
{
  public static boolean a = true;
  
  public static ArrayList<bawy> a(ArrayList<bawy> paramArrayList1, ArrayList<bawy> paramArrayList2)
  {
    return a(paramArrayList1, paramArrayList2, NetConnInfoCenter.getActiveNetIpFamily(true), false);
  }
  
  @VisibleForTesting
  public static ArrayList<bawy> a(ArrayList<bawy> paramArrayList1, ArrayList<bawy> paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Ipv6Strategy", 0, "getActiveNetIpFamily type = " + paramInt);
    }
    if (paramInt == 2) {
      return paramArrayList1;
    }
    if (paramInt == 3) {
      return a(paramArrayList1, paramArrayList2, paramBoolean);
    }
    return paramArrayList2;
  }
  
  private static ArrayList<bawy> a(ArrayList<bawy> paramArrayList1, ArrayList<bawy> paramArrayList2, boolean paramBoolean)
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
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    return (i == 2) || (i == 3);
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
        if (b()) {
          break;
        }
        paramBoolean = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Ipv6Strategy", 0, "isIpv6DownFirst, getRichmediaIpv6Switch is false");
      return false;
      if (Ipv6Config.sRMDownStrategy == 2) {
        return true;
      }
      paramBoolean = bool2;
    } while (Ipv6Config.sRMDownStrategy != 3);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {}
    for (paramBoolean = bool1;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  private static boolean b()
  {
    aorl localaorl = (aorl)aoks.a().a(538);
    if (localaorl != null) {
      return localaorl.c;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bauj
 * JD-Core Version:    0.7.0.1
 */