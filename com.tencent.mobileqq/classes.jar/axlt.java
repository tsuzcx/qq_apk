import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class axlt
{
  private static int a(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
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
        paramanvk = new ArrayList();
        if ((paramMutualMarkData.mutualmark_info.has()) && (paramMutualMarkData.mutualmark_info.size() > 0))
        {
          paramFriends = paramMutualMarkData.mutualmark_info.get().iterator();
          while (paramFriends.hasNext())
          {
            paramMutualMarkData = axmu.a((mutualmark.MutualMark)paramFriends.next());
            if (paramMutualMarkData != null)
            {
              paramanvk.add(paramMutualMarkData);
              if ((!TextUtils.isEmpty(paramMutualMarkData.c)) && (!TextUtils.isEmpty(paramMutualMarkData.d))) {
                axlz.a(paramQQAppInterface).a(paramMutualMarkData.c, paramMutualMarkData.d);
              }
            }
          }
        }
        a(paramanvk, paramExtensionInfo);
        if (!paramanvk.isEmpty()) {
          QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " pullInfos:" + paramanvk);
        }
        j = 1;
      }
    }
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkData friendUin:" + paramString + " changeType:" + j + " retCode:" + i);
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Add msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd6b.MutualMarkData paramMutualMarkData)
  {
    if (paramMutualMarkData == null) {}
    String str;
    anvk localanvk;
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
      localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = localanvk.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localanvk.e(str);
      i = a(paramQQAppInterface, localanvk, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramMutualMarkData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localanvk.a((ExtensionInfo)localObject1);
      }
    } while ((localObject2 == null) || ((i & 0x2) == 0));
    localanvk.a((Friends)localObject2);
    paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
  }
  
  private static boolean a(afsf paramafsf, ExtensionInfo paramExtensionInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramafsf != null)
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
            if (paramafsf.jdField_a_of_type_Int != 2) {
              break;
            }
            bool2 = bool1;
          } while (paramafsf.jdField_a_of_type_Afsi == null);
          l = paramafsf.a();
          bool2 = bool1;
        } while (paramExtensionInfo.mutualMarks == null);
        bool2 = bool1;
      } while (!paramExtensionInfo.mutualMarks.containsKey(Long.valueOf(l)));
      paramExtensionInfo.mutualMarks.remove(Long.valueOf(l));
      return true;
      bool1 = bool3;
      if (paramafsf.jdField_b_of_type_Afsi != null) {
        bool1 = false | a(paramafsf.jdField_b_of_type_Afsi, paramafsf.jdField_a_of_type_Int, paramExtensionInfo);
      }
      bool2 = bool1;
    } while (paramafsf.jdField_a_of_type_JavaUtilArrayList == null);
    Iterator localIterator = paramafsf.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      afsg localafsg = (afsg)localIterator.next();
      if ((localafsg != null) && (localafsg.jdField_b_of_type_Afsi != null)) {
        bool1 |= a(localafsg.jdField_b_of_type_Afsi, paramafsf.jdField_a_of_type_Int, paramExtensionInfo);
      }
      for (;;)
      {
        break;
      }
    }
    return bool1;
  }
  
  private static boolean a(afsi paramafsi, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if ((paramafsi == null) || (paramExtensionInfo == null)) {}
    while (paramafsi.jdField_a_of_type_Int <= 0) {
      return false;
    }
    axmt localaxmt1 = null;
    if (paramExtensionInfo.mutualMarks != null) {
      localaxmt1 = (axmt)paramExtensionInfo.mutualMarks.get(Long.valueOf(paramafsi.jdField_a_of_type_Int));
    }
    axmt localaxmt2 = localaxmt1;
    if (localaxmt1 == null) {
      localaxmt2 = new axmt();
    }
    boolean bool = localaxmt2.a(paramafsi, paramLong);
    if (bool) {
      if (paramExtensionInfo.mutualMarks != null) {}
    }
    try
    {
      if (paramExtensionInfo.mutualMarks == null) {
        paramExtensionInfo.mutualMarks = new ConcurrentHashMap();
      }
      paramExtensionInfo.mutualMarks.put(Long.valueOf(localaxmt2.a), localaxmt2);
      return bool;
    }
    finally {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, afsf paramafsf, ExtensionInfo paramExtensionInfo)
  {
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, byte[] paramArrayOfByte)
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
        i = a(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramString, paramArrayOfByte);
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
  
  private static boolean a(ArrayList<axmu> paramArrayList, ExtensionInfo paramExtensionInfo)
  {
    if ((paramArrayList == null) || (paramExtensionInfo == null)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      axmu localaxmu = (axmu)localIterator.next();
      if (localaxmu != null)
      {
        paramArrayList = null;
        if (paramExtensionInfo.mutualMarks != null) {
          paramArrayList = (axmt)paramExtensionInfo.mutualMarks.get(Long.valueOf(localaxmu.a));
        }
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new axmt();
        }
        ((axmt)localObject).a(localaxmu);
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
        localObject = (axmt)paramArrayList.next();
        if (localObject != null) {
          paramExtensionInfo.mutualMarks.put(Long.valueOf(((axmt)localObject).a), localObject);
        }
      }
      return true;
    }
    finally {}
  }
  
  public static void b(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Del msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, afsf paramafsf, ExtensionInfo paramExtensionInfo)
  {
    if (paramafsf.jdField_a_of_type_Int == 2)
    {
      if (!axlp.a(paramQQAppInterface, paramafsf.a())) {}
    }
    else {
      do
      {
        return true;
        if ((paramafsf.jdField_a_of_type_Int != 10003) && (paramafsf.jdField_a_of_type_Int != 11001)) {
          break;
        }
      } while (axlp.a(paramQQAppInterface, paramafsf.a()));
    }
    while (!axlp.a(paramQQAppInterface, paramafsf.a(), paramafsf.d())) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Modify msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Downgrade msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Upgrade msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Recover msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Icon_Light msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_Icon_Twinkle msginfo:" + paramaooq);
    m(paramQQAppInterface, paramanvk, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + paramaooq);
    if (!axma.a(paramQQAppInterface)) {
      axlu.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
    }
  }
  
  private static void m(QQAppInterface paramQQAppInterface, anvk paramanvk, Friends paramFriends, ExtensionInfo paramExtensionInfo, afsf paramafsf, aooq paramaooq)
  {
    if (!a(paramQQAppInterface, paramafsf, paramExtensionInfo)) {
      QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushCommonUpdate not enable update");
    }
    while (!a(paramafsf, paramExtensionInfo)) {
      return;
    }
    if (paramafsf.jdField_a_of_type_Int == 1) {
      axlr.a(paramQQAppInterface, paramafsf.jdField_b_of_type_JavaLangString, paramExtensionInfo, paramafsf.a());
    }
    paramanvk.a(paramExtensionInfo);
    if ((!TextUtils.isEmpty(paramafsf.b())) && (!TextUtils.isEmpty(paramafsf.c()))) {
      axlz.a(paramQQAppInterface).a(paramafsf.b(), paramafsf.c());
    }
    if ((b(paramQQAppInterface, paramafsf, paramExtensionInfo)) && (!axma.a(paramQQAppInterface))) {
      axlu.a(paramQQAppInterface, paramFriends, paramExtensionInfo, paramafsf, paramaooq);
    }
    for (;;)
    {
      paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramafsf.jdField_b_of_type_JavaLangString);
      return;
      QLog.i("MutualMarkDataS2CHandleHelper", 1, "handleMutualMarkDataPushCommonUpdate not enable insert grayTips");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlt
 * JD-Core Version:    0.7.0.1
 */