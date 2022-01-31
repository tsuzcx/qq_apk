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

public class auoc
{
  private static int a(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
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
        paramaloz = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = aupc.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " info:" + paramMutualMarkData);
              }
              paramaloz.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                auoi.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramaloz, paramExtensionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " infos.size:" + paramaloz.size());
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
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
      aloz localaloz = (aloz)paramQQAppInterface.getManager(51);
      Object localObject2 = localaloz.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localaloz.e(str);
      i = a(paramQQAppInterface, localaloz, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localaloz.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localaloz.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGet0x5e0MutualMarkData uin:" + str + " changeType:" + i);
  }
  
  private static boolean a(aend paramaend, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramaend != null)
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
            if (paramaend.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramaend.jdField_a_of_type_Aeng == null);
          l = paramaend.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramaend.jdField_b_of_type_Aeng != null) {
        bool1 = false | a(paramaend.jdField_b_of_type_Aeng, paramaend.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramaend.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramaend.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      aene localaene = (aene)localIterator.next();
      if ((localaene != null) && (localaene.jdField_b_of_type_Aeng != null)) {
        bool1 |= a(localaene.jdField_b_of_type_Aeng, paramaend.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(aeng paramaeng, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramaeng == null) || (paramExtensionInfo == null)) {}
    while (paramaeng.jdField_a_of_type_Int <= 0) {
      return false;
    }
    aupb localaupb1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localaupb1 = (aupb)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramaeng.jdField_a_of_type_Int));
    }
    aupb localaupb2 = localaupb1;
    if (localaupb1 == null) {
      localaupb2 = new aupb();
    }
    boolean bool = localaupb2.a(paramaeng, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localaupb2.a), localaupb2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, aend paramaend, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  private static boolean a(ArrayList<aupc> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      aupc localaupc = (aupc)localIterator.next();
      if (localaupc != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (aupb)paramExtensionInfo.mutualMarks.get(Long.valueOf(localaupc.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new aupb();
        }
        ((aupb)localObject).a(localaupc);
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
        localObject = (aupb)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((aupb)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, aend paramaend, ExtensionInfo paramExtensionInfo)
  {
    if (paramaend.jdField_a_of_type_Int == 2)
    {
      if (!auny.a(paramQQAppInterface, paramaend.a())) {}
    }
    else {
      do
      {
        return true;
        if (paramaend.jdField_a_of_type_Int != 10003) {
          break;
        }
      } while (auny.a(paramQQAppInterface, paramaend.a()));
    }
    while (!auny.a(paramQQAppInterface, paramaend.a(), paramaend.c())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramamgu);
    }
    m(paramQQAppInterface, paramaloz, paramFriends, paramExtensionInfo, paramaend, paramamgu);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramamgu);
    }
    if (!auoj.a(paramQQAppInterface)) {
      auod.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaend, paramamgu);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, aloz paramaloz, Friends paramFriends, ExtensionInfo paramExtensionInfo, aend paramaend, amgu paramamgu)
  {
    if (!a(paramQQAppInterface, paramaend, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramaend, paramExtensionInfo)) {
      return;
    }
    if (paramaend.jdField_a_of_type_Int == 1) {
      auoa.a(paramQQAppInterface, paramaend.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramaend.a());
    }
    paramaloz.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramaend.b())) && (!TextUtils.isEmpty(paramaend.c()))) {
      auoi.a(paramQQAppInterface).a(paramaend.b(), paramaend.c());
    }
    if ((b(paramQQAppInterface, paramaend, paramExtensionInfo)) && (!auoj.a(paramQQAppInterface))) {
      auod.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaend, paramamgu);
    }
    for (;;)
    {
      paramQQAppInterface.a(1).notifyUI(3, true, paramaend.jdField_b_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auoc
 * JD-Core Version:    0.7.0.1
 */