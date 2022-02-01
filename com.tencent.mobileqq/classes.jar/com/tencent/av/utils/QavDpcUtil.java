package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class QavDpcUtil
{
  private static Boolean[] a = null;
  
  private static void a()
  {
    a = new Boolean[4];
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qavUseSurface.name(), "1|1|1|1");
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      int i = 0;
      if (i < a.length)
      {
        if (i < arrayOfString.length) {
          a[i] = Boolean.valueOf("1".equals(arrayOfString[i]));
        }
        for (;;)
        {
          i += 1;
          break;
          a[i] = Boolean.valueOf(false);
        }
      }
    }
    else
    {
      Arrays.fill(a, Boolean.valueOf(false));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavDpcUtil", 2, "initQavSurfaceDpc, dpcValue[" + str + "]");
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (a == null) {
      a();
    }
    if ((a == null) || (paramInt >= a.length)) {}
    while ((a[paramInt] == null) || (!a[paramInt].booleanValue())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.QavDpcUtil
 * JD-Core Version:    0.7.0.1
 */