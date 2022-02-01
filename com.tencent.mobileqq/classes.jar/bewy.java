import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class bewy
{
  public static int a(int paramInt)
  {
    bewv localbewv = (bewv)apub.a().a(659);
    if (localbewv != null) {
      return localbewv.a(paramInt);
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
  
  public static bewz a(TroopInfo paramTroopInfo, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    boolean bool2 = false;
    bewz localbewz2 = null;
    bewz localbewz1 = localbewz2;
    if (paramTroopInfo != null)
    {
      localbewz1 = localbewz2;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (paramInt1 != 0) {
          break label36;
        }
        localbewz1 = localbewz2;
      }
    }
    label36:
    boolean bool4;
    label143:
    do
    {
      return localbewz1;
      localbewz2 = new bewz();
      boolean bool3 = paramTroopInfo.isTroopOwner(paramString1);
      bool4 = paramTroopInfo.isTroopAdmin(paramString1);
      if (paramTroopInfo.cNewGroupRankUserFlag == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramTroopInfo.cGroupRankUserFlag == 1) {
          bool2 = true;
        }
        localbewz2.jdField_b_of_type_Boolean = bool2;
        localbewz2.jdField_a_of_type_Boolean = bool1;
        if ((!bool1) && (!bool2) && (!bool3))
        {
          localbewz1 = localbewz2;
          if (!bool4) {
            break;
          }
        }
        if (!paramTroopInfo.isQidianPrivateTroop()) {
          break label143;
        }
        a(localbewz2, bool4, bool3);
        return localbewz2;
      }
      if (paramTroopInfo.isHomeworkTroop())
      {
        a(localbewz2, paramInt2);
        return localbewz2;
      }
      if (bbyp.b())
      {
        a(localbewz2, bool4, bool3);
        return localbewz2;
      }
      localbewz2.jdField_a_of_type_Int = paramInt2;
      localbewz2.jdField_b_of_type_Boolean = bool2;
      localbewz2.jdField_a_of_type_ArrayOfInt = a(paramInt2);
      localbewz2.jdField_a_of_type_Boolean = bool1;
      localbewz2.jdField_b_of_type_ArrayOfInt = a();
      localbewz2.jdField_b_of_type_Int = paramInt1;
      paramInt1 = a(paramInt1);
      if ((paramInt2 < 10000) && (paramInt2 > 0)) {
        a(localbewz2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramInt2, paramString2);
      }
      while (bool3)
      {
        localbewz2.jdField_b_of_type_Boolean = true;
        localbewz2.jdField_a_of_type_ArrayOfInt = a(300);
        return localbewz2;
        a(localbewz2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramString2);
      }
      localbewz1 = localbewz2;
    } while (!bool4);
    localbewz2.jdField_b_of_type_Boolean = true;
    localbewz2.jdField_a_of_type_ArrayOfInt = a(301);
    return localbewz2;
  }
  
  public static bewz a(TroopInfo paramTroopInfo, String paramString1, String paramString2)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramString1))) {
      paramTroopInfo = null;
    }
    bewz localbewz;
    boolean bool2;
    do
    {
      return paramTroopInfo;
      localbewz = new bewz();
      localbewz.jdField_a_of_type_Boolean = false;
      localbewz.jdField_b_of_type_Int = 0;
      localbewz.jdField_b_of_type_ArrayOfInt = null;
      localbewz.jdField_b_of_type_Boolean = true;
      boolean bool1 = paramTroopInfo.isTroopOwner(paramString1);
      bool2 = paramTroopInfo.isTroopAdmin(paramString1);
      if (!TextUtils.isEmpty(paramString2))
      {
        localbewz.jdField_a_of_type_JavaLangString = paramString2;
        localbewz.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while (bool1)
      {
        localbewz.jdField_a_of_type_ArrayOfInt = a(300);
        return localbewz;
        if (bool1) {
          localbewz.jdField_a_of_type_JavaLangString = amtj.a(2131714747);
        } else if (bool2) {
          localbewz.jdField_a_of_type_JavaLangString = amtj.a(2131714736);
        } else {
          localbewz.jdField_a_of_type_JavaLangString = "";
        }
      }
      paramTroopInfo = localbewz;
    } while (!bool2);
    localbewz.jdField_a_of_type_ArrayOfInt = a(301);
    return localbewz;
  }
  
  public static String a()
  {
    bewv localbewv = (bewv)apub.a().a(659);
    if (localbewv != null) {
      return localbewv.a();
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    Object localObject = (bewv)apub.a().a(659);
    if (localObject != null) {}
    for (localObject = ((bewv)localObject).a(paramInt);; localObject = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "getRankTitleByLevelInConfig: level : " + paramInt + ",rankTitle : " + (String)localObject);
      }
      return localObject;
    }
  }
  
  private static void a(bewz parambewz, int paramInt)
  {
    if (paramInt == 332)
    {
      parambewz.jdField_a_of_type_Int = 332;
      parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714743);
      parambewz.jdField_a_of_type_ArrayOfInt = a(332);
      parambewz.jdField_b_of_type_Boolean = true;
      parambewz.jdField_b_of_type_ArrayOfInt = null;
      parambewz.jdField_a_of_type_Boolean = false;
    }
    while (paramInt != 333) {
      return;
    }
    parambewz.jdField_a_of_type_Int = 333;
    parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714748);
    parambewz.jdField_a_of_type_ArrayOfInt = a(333);
    parambewz.jdField_b_of_type_Boolean = true;
    parambewz.jdField_b_of_type_ArrayOfInt = null;
    parambewz.jdField_a_of_type_Boolean = false;
  }
  
  private static void a(bewz parambewz, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramTroopInfo == null) || (parambewz == null)) {}
    do
    {
      return;
      if (paramInt2 == 302)
      {
        parambewz.jdField_a_of_type_JavaLangString = paramString;
        parambewz.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714747);
        return;
        if (paramInt2 == 300)
        {
          parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714747);
          parambewz.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramInt2 == 301)
        {
          parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714736);
          parambewz.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            parambewz.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt1)));
          }
          if (TextUtils.isEmpty(parambewz.jdField_a_of_type_JavaLangString)) {
            parambewz.jdField_a_of_type_JavaLangString = a(paramInt1);
          }
          parambewz.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714736);
  }
  
  private static void a(bewz parambewz, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString)
  {
    if ((parambewz == null) || (paramTroopInfo == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        parambewz.jdField_a_of_type_JavaLangString = paramString;
        parambewz.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714747);
        return;
        if (paramBoolean1)
        {
          parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714747);
          parambewz.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramBoolean2)
        {
          parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714736);
          parambewz.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            parambewz.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt)));
          }
          if (TextUtils.isEmpty(parambewz.jdField_a_of_type_JavaLangString)) {
            parambewz.jdField_a_of_type_JavaLangString = a(paramInt);
          }
          parambewz.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714736);
  }
  
  private static void a(bewz parambewz, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      parambewz.jdField_a_of_type_Int = 300;
      parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714747);
      parambewz.jdField_a_of_type_ArrayOfInt = a(300);
      parambewz.jdField_b_of_type_Boolean = true;
      parambewz.jdField_b_of_type_ArrayOfInt = null;
      parambewz.jdField_a_of_type_Boolean = false;
    }
    while (!paramBoolean1) {
      return;
    }
    parambewz.jdField_a_of_type_Int = 301;
    parambewz.jdField_a_of_type_JavaLangString = amtj.a(2131714736);
    parambewz.jdField_a_of_type_ArrayOfInt = a(301);
    parambewz.jdField_b_of_type_Boolean = true;
    parambewz.jdField_b_of_type_ArrayOfInt = null;
    parambewz.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a()
  {
    bewv localbewv = (bewv)apub.a().a(659);
    if ((localbewv != null) && (localbewv.a()))
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
    bewv localbewv = (bewv)apub.a().a(659);
    if ((localbewv != null) && (localbewv.a(paramString))) {}
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
    bewv localbewv = (bewv)apub.a().a(659);
    if (localbewv != null) {
      return localbewv.a();
    }
    return null;
  }
  
  public static int[] a(int paramInt)
  {
    bewv localbewv = (bewv)apub.a().a(659);
    if (localbewv != null) {
      return localbewv.a(paramInt);
    }
    return null;
  }
  
  public static int b(int paramInt)
  {
    bewv localbewv = (bewv)apub.a().a(659);
    if (localbewv != null) {}
    for (paramInt = localbewv.b(paramInt);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "convertOldLevelToNewLevel : newLevel" + paramInt);
      }
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bewy
 * JD-Core Version:    0.7.0.1
 */