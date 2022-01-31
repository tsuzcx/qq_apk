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

public class asxd
{
  private static int a(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
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
        paramajxn = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = asyd.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " info:" + paramMutualMarkData);
              }
              paramajxn.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                asxj.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramajxn, paramExtensionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " infos.size:" + paramajxn.size());
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
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
      ajxn localajxn = (ajxn)paramQQAppInterface.getManager(51);
      Object localObject2 = localajxn.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localajxn.e(str);
      i = a(paramQQAppInterface, localajxn, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localajxn.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localajxn.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGet0x5e0MutualMarkData uin:" + str + " changeType:" + i);
  }
  
  private static boolean a(acvx paramacvx, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramacvx != null)
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
            if (paramacvx.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramacvx.jdField_a_of_type_Acwa == null);
          l = paramacvx.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramacvx.jdField_b_of_type_Acwa != null) {
        bool1 = false | a(paramacvx.jdField_b_of_type_Acwa, paramacvx.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramacvx.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramacvx.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      acvy localacvy = (acvy)localIterator.next();
      if ((localacvy != null) && (localacvy.jdField_b_of_type_Acwa != null)) {
        bool1 |= a(localacvy.jdField_b_of_type_Acwa, paramacvx.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(acwa paramacwa, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramacwa == null) || (paramExtensionInfo == null)) {}
    while (paramacwa.jdField_a_of_type_Int <= 0) {
      return false;
    }
    asyc localasyc1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localasyc1 = (asyc)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramacwa.jdField_a_of_type_Int));
    }
    asyc localasyc2 = localasyc1;
    if (localasyc1 == null) {
      localasyc2 = new asyc();
    }
    boolean bool = localasyc2.a(paramacwa, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localasyc2.a), localasyc2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, acvx paramacvx, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  private static boolean a(ArrayList<asyd> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      asyd localasyd = (asyd)localIterator.next();
      if (localasyd != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (asyc)paramExtensionInfo.mutualMarks.get(Long.valueOf(localasyd.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new asyc();
        }
        ((asyc)localObject).a(localasyd);
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
        localObject = (asyc)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((asyc)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, acvx paramacvx, ExtensionInfo paramExtensionInfo)
  {
    if (paramacvx.jdField_a_of_type_Int == 2)
    {
      if (!aswz.a(paramQQAppInterface, paramacvx.a())) {}
    }
    else {
      do
      {
        return true;
        if (paramacvx.jdField_a_of_type_Int != 10003) {
          break;
        }
      } while (aswz.a(paramQQAppInterface, paramacvx.a()));
    }
    while (!aswz.a(paramQQAppInterface, paramacvx.a(), paramacvx.c())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramakqn);
    }
    m(paramQQAppInterface, paramajxn, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramakqn);
    }
    if (!asxk.a(paramQQAppInterface)) {
      asxe.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, ajxn paramajxn, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvx paramacvx, akqn paramakqn)
  {
    if (!a(paramQQAppInterface, paramacvx, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramacvx, paramExtensionInfo)) {
      return;
    }
    if (paramacvx.jdField_a_of_type_Int == 1) {
      asxb.a(paramQQAppInterface, paramacvx.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramacvx.a());
    }
    paramajxn.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramacvx.b())) && (!TextUtils.isEmpty(paramacvx.c()))) {
      asxj.a(paramQQAppInterface).a(paramacvx.b(), paramacvx.c());
    }
    if ((b(paramQQAppInterface, paramacvx, paramExtensionInfo)) && (!asxk.a(paramQQAppInterface))) {
      asxe.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacvx, paramakqn);
    }
    for (;;)
    {
      paramQQAppInterface.a(1).notifyUI(3, true, paramacvx.jdField_b_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxd
 * JD-Core Version:    0.7.0.1
 */