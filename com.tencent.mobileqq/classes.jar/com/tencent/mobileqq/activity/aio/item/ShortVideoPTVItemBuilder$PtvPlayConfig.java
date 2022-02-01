package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoPTVItemBuilder$PtvPlayConfig
{
  public static int a = 15;
  public static boolean a = false;
  public static int b = 20;
  public static boolean b = true;
  
  public static void a()
  {
    Object localObject;
    if (!jdField_a_of_type_Boolean)
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
      jdField_b_of_type_Int = Integer.parseInt(localObject[0]);
    }
    catch (Exception localException2)
    {
      label109:
      break label109;
    }
    if (!TextUtils.isEmpty(localObject[1])) {
      jdField_b_of_type_Boolean = localObject[1].equals("1");
    }
    if (!TextUtils.isEmpty(localObject[2])) {}
    try
    {
      jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
    }
    catch (Exception localException1)
    {
      break label150;
    }
    jdField_a_of_type_Int = 15;
    jdField_a_of_type_Boolean = true;
    break label171;
    jdField_b_of_type_Boolean = true;
    jdField_a_of_type_Int = 15;
    label171:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initConfig(), sReadFromDPC=");
      ((StringBuilder)localObject).append(jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", sAutoPlayInAIO:");
      ((StringBuilder)localObject).append(jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(", sRequestedFPS:");
      ((StringBuilder)localObject).append(jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",sPtvMaxTime:");
      ((StringBuilder)localObject).append(jdField_b_of_type_Int);
      QLog.d("ShortVideo.PtvPlayConfig", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.PtvPlayConfig
 * JD-Core Version:    0.7.0.1
 */