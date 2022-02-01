package com.tencent.av.ui;

import android.os.Build;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class PadOrientationRotateChecker
{
  private static final String[][] a;
  private Integer b = null;
  
  static
  {
    String[] arrayOfString = { "LENOVO", "Lenovo TB-J607F" };
    a = new String[][] { { "LENOVO", "Lenovo TB-J606F" }, { "LENOVO", "Lenovo TB-J706F" }, { "LENOVO", "Lenovo YT-K606F" }, { "LENOVO", "Lenovo TB-J716F" }, arrayOfString };
  }
  
  private void b()
  {
    if (this.b == null)
    {
      String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qavPadOrientationRotateFlag.name(), String.valueOf(0));
      if (String.valueOf(1).equals(str)) {
        this.b = Integer.valueOf(1);
      } else if (String.valueOf(2).equals(str)) {
        this.b = Integer.valueOf(2);
      } else if (c()) {
        this.b = Integer.valueOf(2);
      } else {
        this.b = Integer.valueOf(0);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initPadOrientationRotateFlag, value[");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.i("PadOrientationRotateChecker", 1, localStringBuilder.toString());
    }
  }
  
  private boolean c()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    Object localObject1 = a;
    int j = localObject1.length;
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      Object localObject2 = localObject1[i];
      if ((localObject2[0].equalsIgnoreCase(str1)) && (localObject2[1].equalsIgnoreCase(str2)))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isDisableDevice, manufacturer[");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("], model[");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("], isDisableDevice[");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("]");
      QLog.i("PadOrientationRotateChecker", 2, ((StringBuilder)localObject1).toString());
    }
    return bool1;
  }
  
  public boolean a()
  {
    if (this.b == null) {
      b();
    }
    return 2 != this.b.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.PadOrientationRotateChecker
 * JD-Core Version:    0.7.0.1
 */