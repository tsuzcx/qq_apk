import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;

public class amse
{
  public static int a(int paramInt)
  {
    if (a(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public static int a(int paramInt, long paramLong)
  {
    int i = paramInt * 400 / 540;
    if (i <= paramLong * 0.7D)
    {
      paramInt = i;
      if (i > 0) {}
    }
    else
    {
      paramInt = (int)(paramLong * 0.7D);
    }
    return paramInt;
  }
  
  public static ammu a(QQAppInterface paramQQAppInterface, String paramString, ApolloBaseInfo paramApolloBaseInfo, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramApolloBaseInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloDrawerInfoManager", 1, "checkDrawerRoleDressInfo param err");
      return null;
    }
    int i = 0;
    int[] arrayOfInt = null;
    int j = 0;
    ammu localammu = null;
    int k = amme.a(paramQQAppInterface, paramString);
    int m = paramApolloBaseInfo.apolloStatus;
    ApolloDress localApolloDress = paramApolloBaseInfo.getApolloDress();
    if (localApolloDress != null)
    {
      i = localApolloDress.jdField_a_of_type_Int;
      arrayOfInt = localApolloDress.a();
    }
    localApolloDress = paramApolloBaseInfo.getApolloDress3D();
    paramApolloBaseInfo = localammu;
    if (localApolloDress != null)
    {
      j = localApolloDress.jdField_a_of_type_Int;
      paramApolloBaseInfo = localApolloDress.a();
    }
    localammu = new ammu();
    localammu.jdField_a_of_type_Int = i;
    localammu.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    localammu.jdField_b_of_type_Int = j;
    localammu.jdField_b_of_type_ArrayOfInt = paramApolloBaseInfo;
    localammu.c = m;
    localammu.d = k;
    localammu.e = anck.b(paramInt);
    boolean bool;
    if (m != 1)
    {
      bool = true;
      QLog.e("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo apollo not open from:", Integer.valueOf(paramInt), ",apolloFeatureFlag:", Integer.valueOf(m) });
      anis.a(localammu.e, 10, 101, new Object[] { "apollo not open, flag:", Integer.valueOf(m) });
    }
    for (;;)
    {
      localammu.jdField_a_of_type_Boolean = bool;
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.d("ApolloDrawerInfoManager", 2, new Object[] { "checkDrawerRoleDressInfo from:", Integer.valueOf(paramInt), ",result:", localammu.toString() });
      }
      anis.a(localammu.e, 10, new Object[] { localammu.toString() });
      return localammu;
      if ((k == 1) && ((i <= 0) || (arrayOfInt == null) || (arrayOfInt.length <= 0) || ((i > 0) && (!anhm.a(paramString, i, arrayOfInt, paramQQAppInterface)))))
      {
        bool = true;
        QLog.e("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo basic not ready, from:", Integer.valueOf(paramInt), ",result:", localammu.toString() });
        anis.a(localammu.e, 10, 111, new Object[] { "basic not ready:" + localammu.toString() });
      }
      else
      {
        if ((k == 2) && ((j <= 0) || (paramApolloBaseInfo == null) || (paramApolloBaseInfo.length <= 0) || ((j > anka.jdField_b_of_type_Int) && (!anhm.a(paramString, j, paramApolloBaseInfo, paramQQAppInterface)))))
        {
          QLog.d("ApolloDrawerInfoManager", 1, new Object[] { "checkDrawerRoleDressInfo 3D not ready, from:", Integer.valueOf(paramInt), ",result:", localammu.toString() });
          anis.a(localammu.e, 10, new Object[] { "3D role/dress not ready but show basic" });
        }
        if (!ApolloEngine.a())
        {
          QLog.d("ApolloDrawerInfoManager", 1, "so is not ready");
          anis.a(localammu.e, 10, 102, new Object[] { "so not ready" });
          bool = true;
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static int b(int paramInt)
  {
    if (a(paramInt)) {
      return 3;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amse
 * JD-Core Version:    0.7.0.1
 */