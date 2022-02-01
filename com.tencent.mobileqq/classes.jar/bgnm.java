import android.text.TextUtils;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class bgnm
{
  public static int a(int paramInt)
  {
    bgnj localbgnj = (bgnj)aran.a().a(659);
    if (localbgnj != null) {
      return localbgnj.a(paramInt);
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
  
  public static bgnn a(TroopInfo paramTroopInfo, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    boolean bool2 = false;
    bgnn localbgnn2 = null;
    bgnn localbgnn1 = localbgnn2;
    if (paramTroopInfo != null)
    {
      localbgnn1 = localbgnn2;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (paramInt1 != 0) {
          break label36;
        }
        localbgnn1 = localbgnn2;
      }
    }
    label36:
    boolean bool4;
    label143:
    do
    {
      return localbgnn1;
      localbgnn2 = new bgnn();
      boolean bool3 = paramTroopInfo.isTroopOwner(paramString1);
      bool4 = paramTroopInfo.isTroopAdmin(paramString1);
      if (paramTroopInfo.cNewGroupRankUserFlag == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramTroopInfo.cGroupRankUserFlag == 1) {
          bool2 = true;
        }
        localbgnn2.jdField_b_of_type_Boolean = bool2;
        localbgnn2.jdField_a_of_type_Boolean = bool1;
        if ((!bool1) && (!bool2) && (!bool3))
        {
          localbgnn1 = localbgnn2;
          if (!bool4) {
            break;
          }
        }
        if (!paramTroopInfo.isQidianPrivateTroop()) {
          break label143;
        }
        a(localbgnn2, bool4, bool3);
        return localbgnn2;
      }
      if (paramTroopInfo.isHomeworkTroop())
      {
        a(localbgnn2, paramInt2);
        return localbgnn2;
      }
      if (bdgb.b())
      {
        a(localbgnn2, bool4, bool3);
        return localbgnn2;
      }
      localbgnn2.jdField_a_of_type_Int = paramInt2;
      localbgnn2.jdField_b_of_type_Boolean = bool2;
      localbgnn2.jdField_a_of_type_ArrayOfInt = a(paramInt2);
      localbgnn2.jdField_a_of_type_Boolean = bool1;
      localbgnn2.jdField_b_of_type_ArrayOfInt = a();
      localbgnn2.jdField_b_of_type_Int = paramInt1;
      paramInt1 = a(paramInt1);
      if ((paramInt2 < 10000) && (paramInt2 > 0)) {
        a(localbgnn2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramInt2, paramString2);
      }
      while (bool3)
      {
        localbgnn2.jdField_b_of_type_Boolean = true;
        localbgnn2.jdField_a_of_type_ArrayOfInt = a(300);
        return localbgnn2;
        a(localbgnn2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramString2);
      }
      localbgnn1 = localbgnn2;
    } while (!bool4);
    localbgnn2.jdField_b_of_type_Boolean = true;
    localbgnn2.jdField_a_of_type_ArrayOfInt = a(301);
    return localbgnn2;
  }
  
  public static bgnn a(TroopInfo paramTroopInfo, String paramString1, String paramString2)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramString1))) {
      paramTroopInfo = null;
    }
    bgnn localbgnn;
    boolean bool2;
    do
    {
      return paramTroopInfo;
      localbgnn = new bgnn();
      localbgnn.jdField_a_of_type_Boolean = false;
      localbgnn.jdField_b_of_type_Int = 0;
      localbgnn.jdField_b_of_type_ArrayOfInt = null;
      localbgnn.jdField_b_of_type_Boolean = true;
      boolean bool1 = paramTroopInfo.isTroopOwner(paramString1);
      bool2 = paramTroopInfo.isTroopAdmin(paramString1);
      if (!TextUtils.isEmpty(paramString2))
      {
        localbgnn.jdField_a_of_type_JavaLangString = paramString2;
        localbgnn.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while (bool1)
      {
        localbgnn.jdField_a_of_type_ArrayOfInt = a(300);
        return localbgnn;
        if (bool1) {
          localbgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714515);
        } else if (bool2) {
          localbgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714504);
        } else {
          localbgnn.jdField_a_of_type_JavaLangString = "";
        }
      }
      paramTroopInfo = localbgnn;
    } while (!bool2);
    localbgnn.jdField_a_of_type_ArrayOfInt = a(301);
    return localbgnn;
  }
  
  public static String a()
  {
    bgnj localbgnj = (bgnj)aran.a().a(659);
    if (localbgnj != null) {
      return localbgnj.a();
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    Object localObject = (bgnj)aran.a().a(659);
    if (localObject != null) {}
    for (localObject = ((bgnj)localObject).a(paramInt);; localObject = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "getRankTitleByLevelInConfig: level : " + paramInt + ",rankTitle : " + (String)localObject);
      }
      return localObject;
    }
  }
  
  private static void a(bgnn parambgnn, int paramInt)
  {
    if (paramInt == 332)
    {
      parambgnn.jdField_a_of_type_Int = 332;
      parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714511);
      parambgnn.jdField_a_of_type_ArrayOfInt = a(332);
      parambgnn.jdField_b_of_type_Boolean = true;
      parambgnn.jdField_b_of_type_ArrayOfInt = null;
      parambgnn.jdField_a_of_type_Boolean = false;
    }
    while (paramInt != 333) {
      return;
    }
    parambgnn.jdField_a_of_type_Int = 333;
    parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714516);
    parambgnn.jdField_a_of_type_ArrayOfInt = a(333);
    parambgnn.jdField_b_of_type_Boolean = true;
    parambgnn.jdField_b_of_type_ArrayOfInt = null;
    parambgnn.jdField_a_of_type_Boolean = false;
  }
  
  private static void a(bgnn parambgnn, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramTroopInfo == null) || (parambgnn == null)) {}
    do
    {
      return;
      if (paramInt2 == 302)
      {
        parambgnn.jdField_a_of_type_JavaLangString = paramString;
        parambgnn.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714515);
        return;
        if (paramInt2 == 300)
        {
          parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714515);
          parambgnn.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramInt2 == 301)
        {
          parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714504);
          parambgnn.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            parambgnn.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt1)));
          }
          if (TextUtils.isEmpty(parambgnn.jdField_a_of_type_JavaLangString)) {
            parambgnn.jdField_a_of_type_JavaLangString = a(paramInt1);
          }
          parambgnn.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714504);
  }
  
  private static void a(bgnn parambgnn, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString)
  {
    if ((parambgnn == null) || (paramTroopInfo == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        parambgnn.jdField_a_of_type_JavaLangString = paramString;
        parambgnn.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714515);
        return;
        if (paramBoolean1)
        {
          parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714515);
          parambgnn.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramBoolean2)
        {
          parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714504);
          parambgnn.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            parambgnn.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt)));
          }
          if (TextUtils.isEmpty(parambgnn.jdField_a_of_type_JavaLangString)) {
            parambgnn.jdField_a_of_type_JavaLangString = a(paramInt);
          }
          parambgnn.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714504);
  }
  
  private static void a(bgnn parambgnn, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      parambgnn.jdField_a_of_type_Int = 300;
      parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714515);
      parambgnn.jdField_a_of_type_ArrayOfInt = a(300);
      parambgnn.jdField_b_of_type_Boolean = true;
      parambgnn.jdField_b_of_type_ArrayOfInt = null;
      parambgnn.jdField_a_of_type_Boolean = false;
    }
    while (!paramBoolean1) {
      return;
    }
    parambgnn.jdField_a_of_type_Int = 301;
    parambgnn.jdField_a_of_type_JavaLangString = anzj.a(2131714504);
    parambgnn.jdField_a_of_type_ArrayOfInt = a(301);
    parambgnn.jdField_b_of_type_Boolean = true;
    parambgnn.jdField_b_of_type_ArrayOfInt = null;
    parambgnn.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a()
  {
    bgnj localbgnj = (bgnj)aran.a().a(659);
    if ((localbgnj != null) && (localbgnj.a()))
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
    bgnj localbgnj = (bgnj)aran.a().a(659);
    if ((localbgnj != null) && (localbgnj.a(paramString))) {}
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
    bgnj localbgnj = (bgnj)aran.a().a(659);
    if (localbgnj != null) {
      return localbgnj.a();
    }
    return null;
  }
  
  public static int[] a(int paramInt)
  {
    bgnj localbgnj = (bgnj)aran.a().a(659);
    if (localbgnj != null) {
      return localbgnj.a(paramInt);
    }
    return null;
  }
  
  public static int b(int paramInt)
  {
    bgnj localbgnj = (bgnj)aran.a().a(659);
    if (localbgnj != null) {}
    for (paramInt = localbgnj.b(paramInt);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "convertOldLevelToNewLevel : newLevel" + paramInt);
      }
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnm
 * JD-Core Version:    0.7.0.1
 */