package com.tencent.av.ui;

import android.os.Build;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class PadOrientationRotateChecker
{
  private static final String[][] jdField_a_of_type_Array2dOfJavaLangString = { { "Lenovo", "Lenovo TB-J606F" }, { "Lenovo", "Lenovo TB-J706F" } };
  private Integer jdField_a_of_type_JavaLangInteger = null;
  
  private void a()
  {
    String str;
    if (this.jdField_a_of_type_JavaLangInteger == null)
    {
      str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qavPadOrientationRotateFlag.name(), String.valueOf(0));
      if (!String.valueOf(1).equals(str)) {
        break label81;
      }
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
    }
    for (;;)
    {
      QLog.i("PadOrientationRotateChecker", 1, "initPadOrientationRotateFlag, value[" + str + "]");
      return;
      label81:
      if (String.valueOf(2).equals(str)) {
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(2);
      } else if (b()) {
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(2);
      } else {
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    String[][] arrayOfString = jdField_a_of_type_Array2dOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString1 = arrayOfString[i];
      if ((!arrayOfString1[0].equalsIgnoreCase(str1)) || (!arrayOfString1[1].equalsIgnoreCase(str2))) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PadOrientationRotateChecker", 2, "isDisableDevice, manufacturer[" + str1 + "], model[" + str2 + "], isDisableDevice[" + bool + "]");
      }
      return bool;
      i += 1;
      break;
      bool = false;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangInteger == null) {
      a();
    }
    return 2 != this.jdField_a_of_type_JavaLangInteger.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.PadOrientationRotateChecker
 * JD-Core Version:    0.7.0.1
 */