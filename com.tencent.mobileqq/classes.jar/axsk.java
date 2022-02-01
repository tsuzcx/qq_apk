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

public class axsk
{
  private static int a(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
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
        paramanyw = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = axtl.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " info:" + paramMutualMarkData);
              }
              paramanyw.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                axsq.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramanyw, paramExtensionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " infos.size:" + paramanyw.size());
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
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
      anyw localanyw = (anyw)paramQQAppInterface.getManager(51);
      Object localObject2 = localanyw.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localanyw.e(str);
      i = a(paramQQAppInterface, localanyw, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localanyw.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localanyw.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGet0x5e0MutualMarkData uin:" + str + " changeType:" + i);
  }
  
  private static boolean a(aghx paramaghx, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramaghx != null)
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
            if (paramaghx.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramaghx.jdField_a_of_type_Agia == null);
          l = paramaghx.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramaghx.jdField_b_of_type_Agia != null) {
        bool1 = false | a(paramaghx.jdField_b_of_type_Agia, paramaghx.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramaghx.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramaghx.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      aghy localaghy = (aghy)localIterator.next();
      if ((localaghy != null) && (localaghy.jdField_b_of_type_Agia != null)) {
        bool1 |= a(localaghy.jdField_b_of_type_Agia, paramaghx.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(agia paramagia, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramagia == null) || (paramExtensionInfo == null)) {}
    while (paramagia.jdField_a_of_type_Int <= 0) {
      return false;
    }
    axtk localaxtk1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localaxtk1 = (axtk)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramagia.jdField_a_of_type_Int));
    }
    axtk localaxtk2 = localaxtk1;
    if (localaxtk1 == null) {
      localaxtk2 = new axtk();
    }
    boolean bool = localaxtk2.a(paramagia, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localaxtk2.a), localaxtk2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, aghx paramaghx, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  private static boolean a(ArrayList<axtl> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      axtl localaxtl = (axtl)localIterator.next();
      if (localaxtl != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (axtk)paramExtensionInfo.mutualMarks.get(Long.valueOf(localaxtl.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new axtk();
        }
        ((axtk)localObject).a(localaxtl);
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
        localObject = (axtk)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((axtk)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, aghx paramaghx, ExtensionInfo paramExtensionInfo)
  {
    if (paramaghx.jdField_a_of_type_Int == 2)
    {
      if (!axsg.a(paramQQAppInterface, paramaghx.a())) {}
    }
    else {
      do
      {
        return true;
        if ((paramaghx.jdField_a_of_type_Int != 10003) && (paramaghx.jdField_a_of_type_Int != 11001)) {
          break;
        }
      } while (axsg.a(paramQQAppInterface, paramaghx.a()));
    }
    while (!axsg.a(paramQQAppInterface, paramaghx.a(), paramaghx.d())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramaotc);
    }
    m(paramQQAppInterface, paramanyw, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramaotc);
    }
    if (!axsr.a(paramQQAppInterface)) {
      axsl.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, anyw paramanyw, Friends paramFriends, ExtensionInfo paramExtensionInfo, aghx paramaghx, aotc paramaotc)
  {
    if (!a(paramQQAppInterface, paramaghx, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramaghx, paramExtensionInfo)) {
      return;
    }
    if (paramaghx.jdField_a_of_type_Int == 1) {
      axsi.a(paramQQAppInterface, paramaghx.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramaghx.a());
    }
    paramanyw.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramaghx.b())) && (!TextUtils.isEmpty(paramaghx.c()))) {
      axsq.a(paramQQAppInterface).a(paramaghx.b(), paramaghx.c());
    }
    if ((b(paramQQAppInterface, paramaghx, paramExtensionInfo)) && (!axsr.a(paramQQAppInterface))) {
      axsl.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaghx, paramaotc);
    }
    for (;;)
    {
      paramQQAppInterface.a(1).notifyUI(3, true, paramaghx.jdField_b_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsk
 * JD-Core Version:    0.7.0.1
 */