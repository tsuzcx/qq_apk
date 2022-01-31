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

public class asaz
{
  private static int a(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
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
        paramajjj = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = asbz.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " info:" + paramMutualMarkData);
              }
              paramajjj.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                asbf.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramajjj, paramExtensionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " infos.size:" + paramajjj.size());
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
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
      ajjj localajjj = (ajjj)paramQQAppInterface.getManager(51);
      Object localObject2 = localajjj.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localajjj.e(str);
      i = a(paramQQAppInterface, localajjj, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localajjj.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localajjj.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGet0x5e0MutualMarkData uin:" + str + " changeType:" + i);
  }
  
  private static boolean a(acle paramacle, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramacle != null)
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
            if (paramacle.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramacle.jdField_a_of_type_Aclh == null);
          l = paramacle.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramacle.jdField_b_of_type_Aclh != null) {
        bool1 = false | a(paramacle.jdField_b_of_type_Aclh, paramacle.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramacle.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramacle.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      aclf localaclf = (aclf)localIterator.next();
      if ((localaclf != null) && (localaclf.jdField_b_of_type_Aclh != null)) {
        bool1 |= a(localaclf.jdField_b_of_type_Aclh, paramacle.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(aclh paramaclh, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramaclh == null) || (paramExtensionInfo == null)) {}
    while (paramaclh.jdField_a_of_type_Int <= 0) {
      return false;
    }
    asby localasby1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localasby1 = (asby)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramaclh.jdField_a_of_type_Int));
    }
    asby localasby2 = localasby1;
    if (localasby1 == null) {
      localasby2 = new asby();
    }
    boolean bool = localasby2.a(paramaclh, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localasby2.a), localasby2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, acle paramacle, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  private static boolean a(ArrayList<asbz> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      asbz localasbz = (asbz)localIterator.next();
      if (localasbz != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (asby)paramExtensionInfo.mutualMarks.get(Long.valueOf(localasbz.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new asby();
        }
        ((asby)localObject).a(localasbz);
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
        localObject = (asby)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((asby)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, acle paramacle, ExtensionInfo paramExtensionInfo)
  {
    if (paramacle.jdField_a_of_type_Int == 2)
    {
      if (!asav.a(paramQQAppInterface, paramacle.a())) {}
    }
    else {
      do
      {
        return true;
        if (paramacle.jdField_a_of_type_Int != 10003) {
          break;
        }
      } while (asav.a(paramQQAppInterface, paramacle.a()));
    }
    while (!asav.a(paramQQAppInterface, paramacle.a(), paramacle.c())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramakcb);
    }
    m(paramQQAppInterface, paramajjj, paramFriends, paramExtensionInfo, paramacle, paramakcb);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramakcb);
    }
    if (!asbg.a(paramQQAppInterface)) {
      asba.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacle, paramakcb);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, ajjj paramajjj, Friends paramFriends, ExtensionInfo paramExtensionInfo, acle paramacle, akcb paramakcb)
  {
    if (!a(paramQQAppInterface, paramacle, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramacle, paramExtensionInfo)) {
      return;
    }
    if (paramacle.jdField_a_of_type_Int == 1) {
      asax.a(paramQQAppInterface, paramacle.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramacle.a());
    }
    paramajjj.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramacle.b())) && (!TextUtils.isEmpty(paramacle.c()))) {
      asbf.a(paramQQAppInterface).a(paramacle.b(), paramacle.c());
    }
    if ((b(paramQQAppInterface, paramacle, paramExtensionInfo)) && (!asbg.a(paramQQAppInterface))) {
      asba.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacle, paramakcb);
    }
    for (;;)
    {
      paramQQAppInterface.a(1).notifyUI(3, true, paramacle.jdField_b_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asaz
 * JD-Core Version:    0.7.0.1
 */