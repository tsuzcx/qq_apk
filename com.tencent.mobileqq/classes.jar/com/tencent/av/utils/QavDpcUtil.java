package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class QavDpcUtil
{
  private static Boolean[] a;
  
  private static void a()
  {
    a = new Boolean[4];
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qavUseSurface.name(), "1|1|1|1");
    boolean bool = TextUtils.isEmpty(str);
    int i = 0;
    Object localObject = Boolean.valueOf(false);
    if (!bool)
    {
      String[] arrayOfString = str.split("\\|");
      for (;;)
      {
        Boolean[] arrayOfBoolean = a;
        if (i >= arrayOfBoolean.length) {
          break;
        }
        if (i < arrayOfString.length) {
          arrayOfBoolean[i] = Boolean.valueOf("1".equals(arrayOfString[i]));
        } else {
          arrayOfBoolean[i] = localObject;
        }
        i += 1;
      }
    }
    Arrays.fill(a, localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initQavSurfaceDpc, dpcValue[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]");
      QLog.i("QavDpcUtil", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (a == null) {
      a();
    }
    Boolean[] arrayOfBoolean = a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfBoolean != null)
    {
      if (paramInt >= arrayOfBoolean.length) {
        return false;
      }
      bool1 = bool2;
      if (arrayOfBoolean[paramInt] != null)
      {
        bool1 = bool2;
        if (arrayOfBoolean[paramInt].booleanValue()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QavDpcUtil
 * JD-Core Version:    0.7.0.1
 */