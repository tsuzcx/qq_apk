package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoPTVItemBuilder$PtvPlayConfig
{
  public static boolean a = false;
  public static boolean b = true;
  public static int c = 15;
  public static int d = 20;
  
  public static void a()
  {
    Object localObject;
    if (!a)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.PtvConfig.name(), null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initConfig(), ptvConfig=");
        localStringBuilder.append((String)localObject);
        QLog.d("ShortVideo.PtvPlayConfig", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3) && (TextUtils.isEmpty(localObject[0]))) {}
      }
    }
    label150:
    try
    {
      d = Integer.parseInt(localObject[0]);
    }
    catch (Exception localException2)
    {
      label109:
      break label109;
    }
    if (!TextUtils.isEmpty(localObject[1])) {
      b = localObject[1].equals("1");
    }
    if (!TextUtils.isEmpty(localObject[2])) {}
    try
    {
      c = Integer.parseInt(localObject[2]);
    }
    catch (Exception localException1)
    {
      break label150;
    }
    c = 15;
    a = true;
    break label171;
    b = true;
    c = 15;
    label171:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initConfig(), sReadFromDPC=");
      ((StringBuilder)localObject).append(a);
      ((StringBuilder)localObject).append(", sAutoPlayInAIO:");
      ((StringBuilder)localObject).append(b);
      ((StringBuilder)localObject).append(", sRequestedFPS:");
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append(",sPtvMaxTime:");
      ((StringBuilder)localObject).append(d);
      QLog.d("ShortVideo.PtvPlayConfig", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.PtvPlayConfig
 * JD-Core Version:    0.7.0.1
 */