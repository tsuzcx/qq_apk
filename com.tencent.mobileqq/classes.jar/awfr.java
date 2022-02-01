import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.mutualmark.mutualmark.MutualMark;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.MutualMarkData;

public class awfr
{
  private static int a(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    int k = 0;
    int i = -1;
    if (paramMutualMarkData.uint32_result.has()) {
      i = paramMutualMarkData.uint32_result.get();
    }
    int j = k;
    if (i == 0)
    {
      j = k;
      if (paramExtensionInfo != null)
      {
        paramamsw = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = awgs.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              paramamsw.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                awfx.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramamsw, paramExtensionInfo);
        if (!paramamsw.isEmpty()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " pullInfos:" + paramamsw);
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    if (paramMutualMarkData == null) {}
    String str;
    amsw localamsw;
    Object localObject2;
    int i;
    do
    {
      long l;
      do
      {
        return;
        l = paramMutualMarkData.uint64_frd_uin.get();
      } while (l <= 0L);
      str = String.valueOf(l);
      localamsw = (amsw)paramQQAppInterface.getManager(51);
      localObject2 = localamsw.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localamsw.e(str);
      i = a(paramQQAppInterface, localamsw, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localamsw.a((ExtensionInfo)localObject1);
      }
    } while ((localObject2 == null) || ((i & 0x2) == 0));
    localamsw.a((Friends)localObject2);
    paramQQAppInterface.getBusinessHandler(1).notifyUI(3, true, str);
  }
  
  private static boolean a(afat paramafat, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramafat != null)
    {
      if (paramExtensionInfo != null) {
        break label19;
      }
      bool2 = bool1;
    }
    label19:
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            return bool2;
            if (paramafat.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramafat.jdField_a_of_type_Afaw == null);
          l = paramafat.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramafat.jdField_b_of_type_Afaw != null) {
        bool1 = false | a(paramafat.jdField_b_of_type_Afaw, paramafat.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramafat.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramafat.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      afau localafau = (afau)localIterator.next();
      if ((localafau != null) && (localafau.jdField_b_of_type_Afaw != null)) {
        bool1 |= a(localafau.jdField_b_of_type_Afaw, paramafat.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(afaw paramafaw, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramafaw == null) || (paramExtensionInfo == null)) {}
    while (paramafaw.jdField_a_of_type_Int <= 0) {
      return false;
    }
    awgr localawgr1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localawgr1 = (awgr)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramafaw.jdField_a_of_type_Int));
    }
    awgr localawgr2 = localawgr1;
    if (localawgr1 == null) {
      localawgr2 = new awgr();
    }
    boolean bool = localawgr2.a(paramafaw, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localawgr2.a), localawgr2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, afat paramafat, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      Oidb_0xd6b.MutualMarkData localMutualMarkData = new Oidb_0xd6b.MutualMarkData();
      try
      {
        localMutualMarkData.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localMutualMarkData;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramArrayOfByte = null;
          localException.printStackTrace();
        }
        i = a(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
      }
      if (paramArrayOfByte == null) {
        return false;
      }
    }
    for (;;)
    {
      if (i != 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      int i = 0;
    }
  }
  
  private static boolean a(ArrayList<awgs> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      awgs localawgs = (awgs)localIterator.next();
      if (localawgs != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (awgr)paramExtensionInfo.mutualMarks.get(Long.valueOf(localawgs.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new awgr();
        }
        ((awgr)localObject).a(localawgs);
        localArrayList.add(localObject);
      }
    }
    if (paramExtensionInfo.mutualMarks == null) {}
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      if (!paramExtensionInfo.mutualMarks.isEmpty()) {
        paramExtensionInfo.mutualMarks.clear();
      }
      paramArrayList = localArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (awgr)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((awgr)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, afat paramafat, ExtensionInfo paramExtensionInfo)
  {
    if (paramafat.jdField_a_of_type_Int == 2)
    {
      if (!awfn.a(paramQQAppInterface, paramafat.a())) {}
    }
    else {
      do
      {
        return true;
        if ((paramafat.jdField_a_of_type_Int != 10003) && (paramafat.jdField_a_of_type_Int != 11001)) {
          break;
        }
      } while (awfn.a(paramQQAppInterface, paramafat.a()));
    }
    while (!awfn.a(paramQQAppInterface, paramafat.a(), paramafat.d())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramanlx);
    }
    m(paramQQAppInterface, paramamsw, paramFriends, paramExtensionInfo, paramafat, paramanlx);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramanlx);
    }
    if (!awfy.a(paramQQAppInterface)) {
      awfs.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafat, paramanlx);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, amsw paramamsw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afat paramafat, anlx paramanlx)
  {
    if (!a(paramQQAppInterface, paramafat, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramafat, paramExtensionInfo)) {
      return;
    }
    if (paramafat.jdField_a_of_type_Int == 1) {
      awfp.a(paramQQAppInterface, paramafat.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramafat.a());
    }
    paramamsw.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramafat.b())) && (!TextUtils.isEmpty(paramafat.c()))) {
      awfx.a(paramQQAppInterface).a(paramafat.b(), paramafat.c());
    }
    if ((b(paramQQAppInterface, paramafat, paramExtensionInfo)) && (!awfy.a(paramQQAppInterface))) {
      awfs.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafat, paramanlx);
    }
    for (;;)
    {
      paramQQAppInterface.getBusinessHandler(1).notifyUI(3, true, paramafat.jdField_b_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfr
 * JD-Core Version:    0.7.0.1
 */