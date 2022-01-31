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

public class asxf
{
  private static int a(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
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
        paramajxl = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = asyf.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " info:" + paramMutualMarkData);
              }
              paramajxl.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                asxl.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramajxl, paramExtensionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " infos.size:" + paramajxl.size());
        }
        j = 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Add msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
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
      ajxl localajxl = (ajxl)paramQQAppInterface.getManager(51);
      Object localObject2 = localajxl.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localajxl.e(str);
      i = a(paramQQAppInterface, localajxl, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localajxl.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localajxl.a((Friends)localObject2);
        paramQQAppInterface.a(1).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("MutualMarkDataS2CHandleHelper", 1, "handleGet0x5e0MutualMarkData uin:" + str + " changeType:" + i);
  }
  
  private static boolean a(acvt paramacvt, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramacvt != null)
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
            if (paramacvt.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramacvt.jdField_a_of_type_Acvw == null);
          l = paramacvt.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramacvt.jdField_b_of_type_Acvw != null) {
        bool1 = false | a(paramacvt.jdField_b_of_type_Acvw, paramacvt.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramacvt.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramacvt.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      acvu localacvu = (acvu)localIterator.next();
      if ((localacvu != null) && (localacvu.jdField_b_of_type_Acvw != null)) {
        bool1 |= a(localacvu.jdField_b_of_type_Acvw, paramacvt.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(acvw paramacvw, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramacvw == null) || (paramExtensionInfo == null)) {}
    while (paramacvw.jdField_a_of_type_Int <= 0) {
      return false;
    }
    asye localasye1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localasye1 = (asye)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramacvw.jdField_a_of_type_Int));
    }
    asye localasye2 = localasye1;
    if (localasye1 == null) {
      localasye2 = new asye();
    }
    boolean bool = localasye2.a(paramacvw, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localasye2.a), localasye2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, acvt paramacvt, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        j = a(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  private static boolean a(ArrayList<asyf> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      asyf localasyf = (asyf)localIterator.next();
      if (localasyf != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (asye)paramExtensionInfo.mutualMarks.get(Long.valueOf(localasyf.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new asye();
        }
        ((asye)localObject).a(localasyf);
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
        localObject = (asye)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((asye)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Del msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, acvt paramacvt, ExtensionInfo paramExtensionInfo)
  {
    if (paramacvt.jdField_a_of_type_Int == 2)
    {
      if (!asxb.a(paramQQAppInterface, paramacvt.a())) {}
    }
    else {
      do
      {
        return true;
        if (paramacvt.jdField_a_of_type_Int != 10003) {
          break;
        }
      } while (asxb.a(paramQQAppInterface, paramacvt.a()));
    }
    while (!asxb.a(paramQQAppInterface, paramacvt.a(), paramacvt.c())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Modify msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Recover msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramakqm);
    }
    m(paramQQAppInterface, paramajxl, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramakqm);
    }
    if (!asxm.a(paramQQAppInterface)) {
      asxg.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, ajxl paramajxl, Friends paramFriends, ExtensionInfo paramExtensionInfo, acvt paramacvt, akqm paramakqm)
  {
    if (!a(paramQQAppInterface, paramacvt, paramExtensionInfo)) {
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable update");
      }
    }
    while (!a(paramacvt, paramExtensionInfo)) {
      return;
    }
    if (paramacvt.jdField_a_of_type_Int == 1) {
      asxd.a(paramQQAppInterface, paramacvt.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramacvt.a());
    }
    paramajxl.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramacvt.b())) && (!TextUtils.isEmpty(paramacvt.c()))) {
      asxl.a(paramQQAppInterface).a(paramacvt.b(), paramacvt.c());
    }
    if ((b(paramQQAppInterface, paramacvt, paramExtensionInfo)) && (!asxm.a(paramQQAppInterface))) {
      asxg.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramacvt, paramakqm);
    }
    for (;;)
    {
      paramQQAppInterface.a(1).notifyUI(3, true, paramacvt.jdField_b_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkDataS2CHandleHelper", 2, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxf
 * JD-Core Version:    0.7.0.1
 */