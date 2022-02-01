import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class bgek
{
  public static int a(int paramInt)
  {
    bgeh localbgeh = (bgeh)aqxe.a().a(659);
    if (localbgeh != null) {
      return localbgeh.a(paramInt);
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
  
  public static bgel a(TroopInfo paramTroopInfo, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    boolean bool2 = false;
    bgel localbgel2 = null;
    bgel localbgel1 = localbgel2;
    if (paramTroopInfo != null)
    {
      localbgel1 = localbgel2;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (paramInt1 != 0) {
          break label36;
        }
        localbgel1 = localbgel2;
      }
    }
    label36:
    boolean bool4;
    label143:
    do
    {
      return localbgel1;
      localbgel2 = new bgel();
      boolean bool3 = paramTroopInfo.isTroopOwner(paramString1);
      bool4 = paramTroopInfo.isTroopAdmin(paramString1);
      if (paramTroopInfo.cNewGroupRankUserFlag == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramTroopInfo.cGroupRankUserFlag == 1) {
          bool2 = true;
        }
        localbgel2.jdField_b_of_type_Boolean = bool2;
        localbgel2.jdField_a_of_type_Boolean = bool1;
        if ((!bool1) && (!bool2) && (!bool3))
        {
          localbgel1 = localbgel2;
          if (!bool4) {
            break;
          }
        }
        if (!paramTroopInfo.isQidianPrivateTroop()) {
          break label143;
        }
        a(localbgel2, bool4, bool3);
        return localbgel2;
      }
      if (paramTroopInfo.isHomeworkTroop())
      {
        a(localbgel2, paramInt2);
        return localbgel2;
      }
      if (bdfk.b())
      {
        a(localbgel2, bool4, bool3);
        return localbgel2;
      }
      localbgel2.jdField_a_of_type_Int = paramInt2;
      localbgel2.jdField_b_of_type_Boolean = bool2;
      localbgel2.jdField_a_of_type_ArrayOfInt = a(paramInt2);
      localbgel2.jdField_a_of_type_Boolean = bool1;
      localbgel2.jdField_b_of_type_ArrayOfInt = a();
      localbgel2.jdField_b_of_type_Int = paramInt1;
      paramInt1 = a(paramInt1);
      if ((paramInt2 < 10000) && (paramInt2 > 0)) {
        a(localbgel2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramInt2, paramString2);
      }
      while (bool3)
      {
        localbgel2.jdField_b_of_type_Boolean = true;
        localbgel2.jdField_a_of_type_ArrayOfInt = a(300);
        return localbgel2;
        a(localbgel2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramString2);
      }
      localbgel1 = localbgel2;
    } while (!bool4);
    localbgel2.jdField_b_of_type_Boolean = true;
    localbgel2.jdField_a_of_type_ArrayOfInt = a(301);
    return localbgel2;
  }
  
  public static bgel a(TroopInfo paramTroopInfo, String paramString1, String paramString2)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramString1))) {
      paramTroopInfo = null;
    }
    bgel localbgel;
    boolean bool2;
    do
    {
      return paramTroopInfo;
      localbgel = new bgel();
      localbgel.jdField_a_of_type_Boolean = false;
      localbgel.jdField_b_of_type_Int = 0;
      localbgel.jdField_b_of_type_ArrayOfInt = null;
      localbgel.jdField_b_of_type_Boolean = true;
      boolean bool1 = paramTroopInfo.isTroopOwner(paramString1);
      bool2 = paramTroopInfo.isTroopAdmin(paramString1);
      if (!TextUtils.isEmpty(paramString2))
      {
        localbgel.jdField_a_of_type_JavaLangString = paramString2;
        localbgel.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while (bool1)
      {
        localbgel.jdField_a_of_type_ArrayOfInt = a(300);
        return localbgel;
        if (bool1) {
          localbgel.jdField_a_of_type_JavaLangString = anvx.a(2131715095);
        } else if (bool2) {
          localbgel.jdField_a_of_type_JavaLangString = anvx.a(2131715084);
        } else {
          localbgel.jdField_a_of_type_JavaLangString = "";
        }
      }
      paramTroopInfo = localbgel;
    } while (!bool2);
    localbgel.jdField_a_of_type_ArrayOfInt = a(301);
    return localbgel;
  }
  
  public static String a()
  {
    bgeh localbgeh = (bgeh)aqxe.a().a(659);
    if (localbgeh != null) {
      return localbgeh.a();
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    Object localObject = (bgeh)aqxe.a().a(659);
    if (localObject != null) {}
    for (localObject = ((bgeh)localObject).a(paramInt);; localObject = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "getRankTitleByLevelInConfig: level : " + paramInt + ",rankTitle : " + (String)localObject);
      }
      return localObject;
    }
  }
  
  private static void a(bgel parambgel, int paramInt)
  {
    if (paramInt == 332)
    {
      parambgel.jdField_a_of_type_Int = 332;
      parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715091);
      parambgel.jdField_a_of_type_ArrayOfInt = a(332);
      parambgel.jdField_b_of_type_Boolean = true;
      parambgel.jdField_b_of_type_ArrayOfInt = null;
      parambgel.jdField_a_of_type_Boolean = false;
    }
    while (paramInt != 333) {
      return;
    }
    parambgel.jdField_a_of_type_Int = 333;
    parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715096);
    parambgel.jdField_a_of_type_ArrayOfInt = a(333);
    parambgel.jdField_b_of_type_Boolean = true;
    parambgel.jdField_b_of_type_ArrayOfInt = null;
    parambgel.jdField_a_of_type_Boolean = false;
  }
  
  private static void a(bgel parambgel, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramTroopInfo == null) || (parambgel == null)) {}
    do
    {
      return;
      if (paramInt2 == 302)
      {
        parambgel.jdField_a_of_type_JavaLangString = paramString;
        parambgel.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715095);
        return;
        if (paramInt2 == 300)
        {
          parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715095);
          parambgel.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramInt2 == 301)
        {
          parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715084);
          parambgel.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            parambgel.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt1)));
          }
          if (TextUtils.isEmpty(parambgel.jdField_a_of_type_JavaLangString)) {
            parambgel.jdField_a_of_type_JavaLangString = a(paramInt1);
          }
          parambgel.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715084);
  }
  
  private static void a(bgel parambgel, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString)
  {
    if ((parambgel == null) || (paramTroopInfo == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        parambgel.jdField_a_of_type_JavaLangString = paramString;
        parambgel.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715095);
        return;
        if (paramBoolean1)
        {
          parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715095);
          parambgel.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramBoolean2)
        {
          parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715084);
          parambgel.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            parambgel.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt)));
          }
          if (TextUtils.isEmpty(parambgel.jdField_a_of_type_JavaLangString)) {
            parambgel.jdField_a_of_type_JavaLangString = a(paramInt);
          }
          parambgel.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715084);
  }
  
  private static void a(bgel parambgel, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      parambgel.jdField_a_of_type_Int = 300;
      parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715095);
      parambgel.jdField_a_of_type_ArrayOfInt = a(300);
      parambgel.jdField_b_of_type_Boolean = true;
      parambgel.jdField_b_of_type_ArrayOfInt = null;
      parambgel.jdField_a_of_type_Boolean = false;
    }
    while (!paramBoolean1) {
      return;
    }
    parambgel.jdField_a_of_type_Int = 301;
    parambgel.jdField_a_of_type_JavaLangString = anvx.a(2131715084);
    parambgel.jdField_a_of_type_ArrayOfInt = a(301);
    parambgel.jdField_b_of_type_Boolean = true;
    parambgel.jdField_b_of_type_ArrayOfInt = null;
    parambgel.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a()
  {
    bgeh localbgeh = (bgeh)aqxe.a().a(659);
    if ((localbgeh != null) && (localbgeh.a()))
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
    bgeh localbgeh = (bgeh)aqxe.a().a(659);
    if ((localbgeh != null) && (localbgeh.a(paramString))) {}
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
    bgeh localbgeh = (bgeh)aqxe.a().a(659);
    if (localbgeh != null) {
      return localbgeh.a();
    }
    return null;
  }
  
  public static int[] a(int paramInt)
  {
    bgeh localbgeh = (bgeh)aqxe.a().a(659);
    if (localbgeh != null) {
      return localbgeh.a(paramInt);
    }
    return null;
  }
  
  public static int b(int paramInt)
  {
    bgeh localbgeh = (bgeh)aqxe.a().a(659);
    if (localbgeh != null) {}
    for (paramInt = localbgeh.b(paramInt);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "convertOldLevelToNewLevel : newLevel" + paramInt);
      }
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgek
 * JD-Core Version:    0.7.0.1
 */