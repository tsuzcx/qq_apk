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

public class ausl
{
  private static int a(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
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
        paramalto = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = autl.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " info:" + paramMutualMarkData);
              }
              paramalto.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                ausr.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramalto, paramExtensionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " infos.size:" + paramalto.size());
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
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
      alto localalto = (alto)paramQQAppInterface.getManager(51);
      Object localObject2 = localalto.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localalto.e(str);
      i = a(paramQQAppInterface, localalto, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localalto.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localalto.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGet0x5e0MutualMarkData uin:" + str + " changeType:" + i);
  }
  
  private static boolean a(aers paramaers, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramaers != null)
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
            if (paramaers.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramaers.jdField_a_of_type_Aerv == null);
          l = paramaers.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramaers.jdField_b_of_type_Aerv != null) {
        bool1 = false | a(paramaers.jdField_b_of_type_Aerv, paramaers.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramaers.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramaers.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      aert localaert = (aert)localIterator.next();
      if ((localaert != null) && (localaert.jdField_b_of_type_Aerv != null)) {
        bool1 |= a(localaert.jdField_b_of_type_Aerv, paramaers.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(aerv paramaerv, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramaerv == null) || (paramExtensionInfo == null)) {}
    while (paramaerv.jdField_a_of_type_Int <= 0) {
      return false;
    }
    autk localautk1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localautk1 = (autk)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramaerv.jdField_a_of_type_Int));
    }
    autk localautk2 = localautk1;
    if (localautk1 == null) {
      localautk2 = new autk();
    }
    boolean bool = localautk2.a(paramaerv, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localautk2.a), localautk2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, aers paramaers, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  private static boolean a(ArrayList<autl> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      autl localautl = (autl)localIterator.next();
      if (localautl != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (autk)paramExtensionInfo.mutualMarks.get(Long.valueOf(localautl.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new autk();
        }
        ((autk)localObject).a(localautl);
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
        localObject = (autk)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((autk)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, aers paramaers, ExtensionInfo paramExtensionInfo)
  {
    if (paramaers.jdField_a_of_type_Int == 2)
    {
      if (!aush.a(paramQQAppInterface, paramaers.a())) {}
    }
    else {
      do
      {
        return true;
        if (paramaers.jdField_a_of_type_Int != 10003) {
          break;
        }
      } while (aush.a(paramQQAppInterface, paramaers.a()));
    }
    while (!aush.a(paramQQAppInterface, paramaers.a(), paramaers.c())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramamlj);
    }
    m(paramQQAppInterface, paramalto, paramFriends, paramExtensionInfo, paramaers, paramamlj);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramamlj);
    }
    if (!auss.a(paramQQAppInterface)) {
      ausm.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaers, paramamlj);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, alto paramalto, Friends paramFriends, ExtensionInfo paramExtensionInfo, aers paramaers, amlj paramamlj)
  {
    if (!a(paramQQAppInterface, paramaers, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramaers, paramExtensionInfo)) {
      return;
    }
    if (paramaers.jdField_a_of_type_Int == 1) {
      ausj.a(paramQQAppInterface, paramaers.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramaers.a());
    }
    paramalto.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramaers.b())) && (!TextUtils.isEmpty(paramaers.c()))) {
      ausr.a(paramQQAppInterface).a(paramaers.b(), paramaers.c());
    }
    if ((b(paramQQAppInterface, paramaers, paramExtensionInfo)) && (!auss.a(paramQQAppInterface))) {
      ausm.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramaers, paramamlj);
    }
    for (;;)
    {
      paramQQAppInterface.a(1).notifyUI(3, true, paramaers.jdField_b_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausl
 * JD-Core Version:    0.7.0.1
 */