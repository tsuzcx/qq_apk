import android.text.TextUtils;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class bfnl
{
  public static int a(int paramInt)
  {
    bfni localbfni = (bfni)aqlk.a().a(659);
    if (localbfni != null) {
      return localbfni.a(paramInt);
    }
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "data error");
      }
    }
    for (;;)
    {
      return 0;
      try
      {
        troop_honor.GroupUserCardHonor localGroupUserCardHonor = new troop_honor.GroupUserCardHonor();
        localGroupUserCardHonor.mergeFrom(paramArrayOfByte);
        if (localGroupUserCardHonor.level.has())
        {
          int i = localGroupUserCardHonor.level.get();
          return i;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberLevelUtils", 2, "parseRspToNewRealLevel exception");
        }
        paramArrayOfByte.printStackTrace();
      }
    }
    return 0;
  }
  
  public static bfnm a(TroopInfo paramTroopInfo, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    boolean bool2 = false;
    bfnm localbfnm2 = null;
    bfnm localbfnm1 = localbfnm2;
    if (paramTroopInfo != null)
    {
      localbfnm1 = localbfnm2;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (paramInt1 != 0) {
          break label36;
        }
        localbfnm1 = localbfnm2;
      }
    }
    label36:
    boolean bool4;
    label143:
    do
    {
      return localbfnm1;
      localbfnm2 = new bfnm();
      boolean bool3 = paramTroopInfo.isTroopOwner(paramString1);
      bool4 = paramTroopInfo.isTroopAdmin(paramString1);
      if (paramTroopInfo.cNewGroupRankUserFlag == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramTroopInfo.cGroupRankUserFlag == 1) {
          bool2 = true;
        }
        localbfnm2.jdField_b_of_type_Boolean = bool2;
        localbfnm2.jdField_a_of_type_Boolean = bool1;
        if ((!bool1) && (!bool2) && (!bool3))
        {
          localbfnm1 = localbfnm2;
          if (!bool4) {
            break;
          }
        }
        if (!paramTroopInfo.isQidianPrivateTroop()) {
          break label143;
        }
        a(localbfnm2, bool4, bool3);
        return localbfnm2;
      }
      if (paramTroopInfo.isHomeworkTroop())
      {
        a(localbfnm2, paramInt2);
        return localbfnm2;
      }
      if (bcnj.b())
      {
        a(localbfnm2, bool4, bool3);
        return localbfnm2;
      }
      localbfnm2.jdField_a_of_type_Int = paramInt2;
      localbfnm2.jdField_b_of_type_Boolean = bool2;
      localbfnm2.jdField_a_of_type_ArrayOfInt = a(paramInt2);
      localbfnm2.jdField_a_of_type_Boolean = bool1;
      localbfnm2.jdField_b_of_type_ArrayOfInt = a();
      localbfnm2.jdField_b_of_type_Int = paramInt1;
      paramInt1 = a(paramInt1);
      if ((paramInt2 < 10000) && (paramInt2 > 0)) {
        a(localbfnm2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramInt2, paramString2);
      }
      while (bool3)
      {
        localbfnm2.jdField_b_of_type_Boolean = true;
        localbfnm2.jdField_a_of_type_ArrayOfInt = a(300);
        return localbfnm2;
        a(localbfnm2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramString2);
      }
      localbfnm1 = localbfnm2;
    } while (!bool4);
    localbfnm2.jdField_b_of_type_Boolean = true;
    localbfnm2.jdField_a_of_type_ArrayOfInt = a(301);
    return localbfnm2;
  }
  
  public static bfnm a(TroopInfo paramTroopInfo, String paramString1, String paramString2)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramString1))) {
      paramTroopInfo = null;
    }
    bfnm localbfnm;
    boolean bool2;
    do
    {
      return paramTroopInfo;
      localbfnm = new bfnm();
      localbfnm.jdField_a_of_type_Boolean = false;
      localbfnm.jdField_b_of_type_Int = 0;
      localbfnm.jdField_b_of_type_ArrayOfInt = null;
      localbfnm.jdField_b_of_type_Boolean = true;
      boolean bool1 = paramTroopInfo.isTroopOwner(paramString1);
      bool2 = paramTroopInfo.isTroopAdmin(paramString1);
      if (!TextUtils.isEmpty(paramString2))
      {
        localbfnm.jdField_a_of_type_JavaLangString = paramString2;
        localbfnm.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while (bool1)
      {
        localbfnm.jdField_a_of_type_ArrayOfInt = a(300);
        return localbfnm;
        if (bool1) {
          localbfnm.jdField_a_of_type_JavaLangString = anni.a(2131714406);
        } else if (bool2) {
          localbfnm.jdField_a_of_type_JavaLangString = anni.a(2131714395);
        } else {
          localbfnm.jdField_a_of_type_JavaLangString = "";
        }
      }
      paramTroopInfo = localbfnm;
    } while (!bool2);
    localbfnm.jdField_a_of_type_ArrayOfInt = a(301);
    return localbfnm;
  }
  
  public static String a()
  {
    bfni localbfni = (bfni)aqlk.a().a(659);
    if (localbfni != null) {
      return localbfni.a();
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    Object localObject = (bfni)aqlk.a().a(659);
    if (localObject != null) {}
    for (localObject = ((bfni)localObject).a(paramInt);; localObject = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "getRankTitleByLevelInConfig: level : " + paramInt + ",rankTitle : " + (String)localObject);
      }
      return localObject;
    }
  }
  
  private static void a(bfnm parambfnm, int paramInt)
  {
    if (paramInt == 332)
    {
      parambfnm.jdField_a_of_type_Int = 332;
      parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714402);
      parambfnm.jdField_a_of_type_ArrayOfInt = a(332);
      parambfnm.jdField_b_of_type_Boolean = true;
      parambfnm.jdField_b_of_type_ArrayOfInt = null;
      parambfnm.jdField_a_of_type_Boolean = false;
    }
    while (paramInt != 333) {
      return;
    }
    parambfnm.jdField_a_of_type_Int = 333;
    parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714407);
    parambfnm.jdField_a_of_type_ArrayOfInt = a(333);
    parambfnm.jdField_b_of_type_Boolean = true;
    parambfnm.jdField_b_of_type_ArrayOfInt = null;
    parambfnm.jdField_a_of_type_Boolean = false;
  }
  
  private static void a(bfnm parambfnm, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramTroopInfo == null) || (parambfnm == null)) {}
    do
    {
      return;
      if (paramInt2 == 302)
      {
        parambfnm.jdField_a_of_type_JavaLangString = paramString;
        parambfnm.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714406);
        return;
        if (paramInt2 == 300)
        {
          parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714406);
          parambfnm.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramInt2 == 301)
        {
          parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714395);
          parambfnm.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            parambfnm.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt1)));
          }
          if (TextUtils.isEmpty(parambfnm.jdField_a_of_type_JavaLangString)) {
            parambfnm.jdField_a_of_type_JavaLangString = a(paramInt1);
          }
          parambfnm.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714395);
  }
  
  private static void a(bfnm parambfnm, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString)
  {
    if ((parambfnm == null) || (paramTroopInfo == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        parambfnm.jdField_a_of_type_JavaLangString = paramString;
        parambfnm.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714406);
        return;
        if (paramBoolean1)
        {
          parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714406);
          parambfnm.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramBoolean2)
        {
          parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714395);
          parambfnm.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            parambfnm.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt)));
          }
          if (TextUtils.isEmpty(parambfnm.jdField_a_of_type_JavaLangString)) {
            parambfnm.jdField_a_of_type_JavaLangString = a(paramInt);
          }
          parambfnm.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714395);
  }
  
  private static void a(bfnm parambfnm, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      parambfnm.jdField_a_of_type_Int = 300;
      parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714406);
      parambfnm.jdField_a_of_type_ArrayOfInt = a(300);
      parambfnm.jdField_b_of_type_Boolean = true;
      parambfnm.jdField_b_of_type_ArrayOfInt = null;
      parambfnm.jdField_a_of_type_Boolean = false;
    }
    while (!paramBoolean1) {
      return;
    }
    parambfnm.jdField_a_of_type_Int = 301;
    parambfnm.jdField_a_of_type_JavaLangString = anni.a(2131714395);
    parambfnm.jdField_a_of_type_ArrayOfInt = a(301);
    parambfnm.jdField_b_of_type_Boolean = true;
    parambfnm.jdField_b_of_type_ArrayOfInt = null;
    parambfnm.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a()
  {
    bfni localbfni = (bfni)aqlk.a().a(659);
    if ((localbfni != null) && (localbfni.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "hasNewGroupMemberLevelJumpUrl= true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelUtils", 2, "hasNewGroupMemberLevelJumpUrl= false");
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    bfni localbfni = (bfni)aqlk.a().a(659);
    if ((localbfni != null) && (localbfni.a(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "isNewRealLevelGrayTroop troopUin = " + paramString + ", isGrayTroop = " + bool);
      }
      return bool;
    }
  }
  
  public static int[] a()
  {
    bfni localbfni = (bfni)aqlk.a().a(659);
    if (localbfni != null) {
      return localbfni.a();
    }
    return null;
  }
  
  public static int[] a(int paramInt)
  {
    bfni localbfni = (bfni)aqlk.a().a(659);
    if (localbfni != null) {
      return localbfni.a(paramInt);
    }
    return null;
  }
  
  public static int b(int paramInt)
  {
    bfni localbfni = (bfni)aqlk.a().a(659);
    if (localbfni != null) {}
    for (paramInt = localbfni.b(paramInt);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "convertOldLevelToNewLevel : newLevel" + paramInt);
      }
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnl
 * JD-Core Version:    0.7.0.1
 */