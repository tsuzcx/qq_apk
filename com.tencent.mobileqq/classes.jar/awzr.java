import android.text.TextUtils;
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

public class awzr
{
  private static int a(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
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
        paramanmw = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = axar.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " info:" + paramMutualMarkData);
              }
              paramanmw.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                awzx.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramanmw, paramExtensionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " infos.size:" + paramanmw.size());
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    if (paramMutualMarkData == null) {}
    String str;
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
      anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
      Object localObject2 = localanmw.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localanmw.e(str);
      i = a(paramQQAppInterface, localanmw, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localanmw.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localanmw.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGet0x5e0MutualMarkData uin:" + str + " changeType:" + i);
  }
  
  private static boolean a(afyd paramafyd, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramafyd != null)
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
            if (paramafyd.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramafyd.jdField_a_of_type_Afyg == null);
          l = paramafyd.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramafyd.jdField_b_of_type_Afyg != null) {
        bool1 = false | a(paramafyd.jdField_b_of_type_Afyg, paramafyd.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramafyd.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramafyd.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      afye localafye = (afye)localIterator.next();
      if ((localafye != null) && (localafye.jdField_b_of_type_Afyg != null)) {
        bool1 |= a(localafye.jdField_b_of_type_Afyg, paramafyd.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(afyg paramafyg, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramafyg == null) || (paramExtensionInfo == null)) {}
    while (paramafyg.jdField_a_of_type_Int <= 0) {
      return false;
    }
    axaq localaxaq1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localaxaq1 = (axaq)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramafyg.jdField_a_of_type_Int));
    }
    axaq localaxaq2 = localaxaq1;
    if (localaxaq1 == null) {
      localaxaq2 = new axaq();
    }
    boolean bool = localaxaq2.a(paramafyg, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localaxaq2.a), localaxaq2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, afyd paramafyd, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
        i = j;
        if (!QLog.isColorLevel()) {
          break label116;
        }
        QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGetFriendListMutualMarkData uin:" + paramString + " changeType:" + j);
        i = j;
      }
      if (paramArrayOfByte == null) {
        return false;
      }
    }
    for (;;)
    {
      int j;
      label116:
      if (i != 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      int i = 0;
    }
  }
  
  private static boolean a(ArrayList<axar> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      axar localaxar = (axar)localIterator.next();
      if (localaxar != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (axaq)paramExtensionInfo.mutualMarks.get(Long.valueOf(localaxar.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new axaq();
        }
        ((axaq)localObject).a(localaxar);
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
        localObject = (axaq)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((axaq)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, afyd paramafyd, ExtensionInfo paramExtensionInfo)
  {
    if (paramafyd.jdField_a_of_type_Int == 2)
    {
      if (!awzn.a(paramQQAppInterface, paramafyd.a())) {}
    }
    else {
      do
      {
        return true;
        if (paramafyd.jdField_a_of_type_Int != 10003) {
          break;
        }
      } while (awzn.a(paramQQAppInterface, paramafyd.a()));
    }
    while (!awzn.a(paramQQAppInterface, paramafyd.a(), paramafyd.c())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramaofx);
    }
    m(paramQQAppInterface, paramanmw, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramaofx);
    }
    if (!awzy.a(paramQQAppInterface)) {
      awzs.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, anmw paramanmw, Friends paramFriends, ExtensionInfo paramExtensionInfo, afyd paramafyd, aofx paramaofx)
  {
    if (!a(paramQQAppInterface, paramafyd, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramafyd, paramExtensionInfo)) {
      return;
    }
    if (paramafyd.jdField_a_of_type_Int == 1) {
      awzp.a(paramQQAppInterface, paramafyd.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramafyd.a());
    }
    paramanmw.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramafyd.b())) && (!TextUtils.isEmpty(paramafyd.c()))) {
      awzx.a(paramQQAppInterface).a(paramafyd.b(), paramafyd.c());
    }
    if ((b(paramQQAppInterface, paramafyd, paramExtensionInfo)) && (!awzy.a(paramQQAppInterface))) {
      awzs.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafyd, paramaofx);
    }
    for (;;)
    {
      paramQQAppInterface.a(1).notifyUI(3, true, paramafyd.jdField_b_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzr
 * JD-Core Version:    0.7.0.1
 */