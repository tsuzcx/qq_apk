import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfig;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfigExtraVal;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class avpw
{
  private static Object a;
  public static final HashMap a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    NearbyMyTabCard.NearbyMyTabConfigExtraVal localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100511";
    localNearbyMyTabConfigExtraVal.pathId = 100511;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10001), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100514";
    localNearbyMyTabConfigExtraVal.pathId = 100514;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10002), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100520";
    localNearbyMyTabConfigExtraVal.pathId = 100520;
    localNearbyMyTabConfigExtraVal.actionName = "0X80049F3";
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10003), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100521";
    localNearbyMyTabConfigExtraVal.pathId = 100521;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10004), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100517";
    localNearbyMyTabConfigExtraVal.pathId = 100517;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10005), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100513";
    localNearbyMyTabConfigExtraVal.pathId = 100513;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10006), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100524";
    localNearbyMyTabConfigExtraVal.pathId = 100524;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10010), localNearbyMyTabConfigExtraVal);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "100510.100511", "100510.100513", "100510.100514", "100510.100519", "100510.100521", "100510.100520", "100510.100516", "100510.100517", "100510.100524", "100510.100523" };
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    int i;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 100511: 
    case 100519: 
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NewNearbyMyTab", 2, "getUnCountByPathID|pathId=" + paramInt + " unreadCount=" + i);
        }
        return i;
        j = aush.a(paramQQAppInterface.getAccount(), "unread_count_date");
        i = j;
        if (QLog.isColorLevel())
        {
          ausq.a(2, "NearbyMineHelper", "getUnCountByPathIDMain", new Object[] { "dating", Integer.valueOf(j) });
          i = j;
          continue;
          j = aush.a(paramQQAppInterface.getAccount(), "unread_count_freshnews");
          i = j;
          if (QLog.isColorLevel())
          {
            ausq.a(2, "NearbyMineHelper", "getUnCountByPathIDMain", new Object[] { "freshnews", Integer.valueOf(j) });
            i = j;
          }
        }
      }
    }
    if (aush.a(paramQQAppInterface.getAccount(), "unread_count_rank") > 0) {}
    for (int j = 1;; j = 0)
    {
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      ausq.a(2, "NearbyMineHelper", "getUnCountByPathIDMain", new Object[] { "ranking", Integer.valueOf(j) });
      i = j;
      break;
    }
  }
  
  public static NearbyMyTabCard a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Object.class;
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        paramAppInterface = bdcs.a(paramAppInterface.getCurrentAccountUin() + "NewNearbyMyTab.nbr", arrayOfClass);
        if ((paramAppInterface == null) || (paramAppInterface.length != arrayOfClass.length)) {
          break label171;
        }
        paramAppInterface = (NearbyMyTabCard)paramAppInterface[0];
        if ((paramAppInterface != null) && (paramAppInterface.configList != null))
        {
          i = 0;
          if (i < paramAppInterface.configList.size())
          {
            if (((NearbyMyTabCard.NearbyMyTabConfig)paramAppInterface.configList.get(i)).configId != 10001) {
              break label164;
            }
            paramAppInterface.configList.remove(i);
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby", 2, "handleGetNearbyMyTab|shield date entrance");
            }
          }
        }
        ausq.a("Q.nearby", "readNearbyMyTabCardFromLocal", new Object[] { paramAppInterface });
        return paramAppInterface;
      }
      label164:
      i += 1;
      continue;
      label171:
      paramAppInterface = null;
    }
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    return a(paramInt1, paramInt2, paramString1, paramString2, -1);
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString1);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    localAppInfo.appset.set(-1);
    if (paramInt1 != -1)
    {
      localAppInfo.uiAppId.set(paramInt2);
      localAppInfo.type.set(paramInt1);
      localAppInfo.iNewFlag.set(1);
      localAppInfo.appset.set(paramInt3);
      localAppInfo.mission_level.set(0);
      paramString1 = new BusinessInfoCheckUpdate.RedDisplayInfo();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(9);
      localRedTypeInfo.red_content.set("-1");
      localRedTypeInfo.red_desc.set("");
      paramString1.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(paramInt1);
      if (!TextUtils.isEmpty(paramString2)) {
        localRedTypeInfo.red_content.set(paramString2);
      }
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      paramString1.tab_display_info.set(localRedTypeInfo);
      paramString1.red_type_info.add(localRedTypeInfo);
      localAppInfo.red_display_info.set(paramString1);
    }
    return localAppInfo;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramAppInterface == null) {
      return new BusinessInfoCheckUpdate.AppInfo();
    }
    paramString1 = a(paramInt1, paramInt2, paramString1, paramString2);
    if ((paramBoolean) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (axho)paramAppInterface.getManager(36);
      if (paramAppInterface != null) {
        paramAppInterface.a(paramString1, true);
      }
    }
    return paramString1;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "updateNearbyNumAppinfo main. start");
    }
    axho localaxho = (axho)paramQQAppInterface.getManager(36);
    if ((!localaxho.a) || (!localaxho.b(100510)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewNearbyMyTab", 2, "updateNearbyNumAppinfo main. return");
      }
      return null;
    }
    if (((Boolean)aush.a(paramQQAppInterface.getAccount(), "nearby_event_file", 4, "config_show_date", Boolean.valueOf(false))).booleanValue()) {}
    for (int i = a(paramQQAppInterface, 100511) + 0;; i = 0)
    {
      int j = i;
      if (((Boolean)aush.a(paramQQAppInterface.getAccount(), "nearby_event_file", 4, "config_show_rank", Boolean.valueOf(false))).booleanValue()) {
        j = i + a(paramQQAppInterface, 100517);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NewNearbyMyTab", 2, "updateNearbyNumAppinfo main. count:" + j);
      }
      if (j > 0)
      {
        paramQQAppInterface = localaxho.a(String.valueOf(100510));
        if ((paramQQAppInterface != null) && (paramQQAppInterface.red_display_info != null) && (paramQQAppInterface.red_display_info.red_type_info != null) && (paramQQAppInterface.red_display_info.red_type_info.size() == 2) && (paramQQAppInterface.red_display_info.red_type_info.get(1) != null)) {}
        for (;;)
        {
          try
          {
            i = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)paramQQAppInterface.red_display_info.red_type_info.get(1)).red_content.get());
            if (i == j) {
              break;
            }
            return localaxho.a(0, 100510, String.valueOf(100510), j);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("NewNearbyMyTab", 2, "get cache redpoint failed, e = " + localException);
            }
          }
          i = 0;
        }
        return paramQQAppInterface;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localaxho.a("100510");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1) && (localAppInfo.type.get() == 5))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NewNearbyMyTab", 2, "updateNearbyNumAppinfo Main, old is num, clear.");
        }
        localaxho.b(String.valueOf(100510));
        if (paramBoolean) {
          alwx.a(paramQQAppInterface);
        }
      }
      return localAppInfo;
    }
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, Object[] paramArrayOfObject)
  {
    if ((paramQQAppInterface == null) || (paramArrayOfObject == null) || (paramArrayOfObject.length != 2)) {
      paramQQAppInterface = null;
    }
    int i1;
    String str;
    int i;
    do
    {
      return paramQQAppInterface;
      i1 = ((Integer)paramArrayOfObject[0]).intValue();
      str = (String)paramArrayOfObject[1];
      localObject3 = (axho)paramQQAppInterface.getManager(36);
      int m = 0;
      paramArrayOfObject = "";
      i = 0;
      int k = 0;
      if (k < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        int i2 = Integer.parseInt(jdField_a_of_type_ArrayOfJavaLangString[k].substring(jdField_a_of_type_ArrayOfJavaLangString[k].lastIndexOf(".") + 1));
        Object localObject1 = ((axho)localObject3).a(jdField_a_of_type_ArrayOfJavaLangString[k]);
        int n = 0;
        int j = n;
        if (((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info != null)
        {
          j = n;
          if (((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info != null)
          {
            List localList = ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.get();
            j = n;
            if (localList != null)
            {
              j = n;
              if (localList.size() >= 2) {
                j = ((BusinessInfoCheckUpdate.RedTypeInfo)localList.get(1)).red_type.get();
              }
            }
          }
        }
        n = j;
        if (i2 == 100524)
        {
          n = j;
          if (j == 4) {
            n = 0;
          }
        }
        if ((n == 4) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {
          m = 1;
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject1 = ((BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.get(1)).red_content.get();
              paramArrayOfObject = (Object[])localObject1;
            }
            catch (Exception localException2)
            {
              Object localObject2;
              continue;
              continue;
            }
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("NewNearbyMyTab", 2, "buildRedTouchAppInfo| pathId=" + i2 + " redTouchType=RED_TOUCH_TEXT text=" + paramArrayOfObject);
              }
              k += 1;
            }
            catch (Exception localException1) {}
          }
          if (QLog.isColorLevel()) {
            QLog.d("NewNearbyMyTab", 2, "buildRedTouchAppInfo| exception=" + localException1.getMessage());
          }
          continue;
          if ((n == 0) && (localException1.iNewFlag.get() != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NewNearbyMyTab", 2, "buildRedTouchAppInfo| pathId=" + i2 + " redTouchType=RED_TOUCH_RED_POINT text=" + paramArrayOfObject);
            }
            i = 1;
          }
          else
          {
            if ((i2 != 100523) || (localException1.iNewFlag.get() == 0)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("NewNearbyMyTab", 2, "buildRedTouchAppInfo| pathId=" + i2 + ", UIAPPID_NEARBY_VISITOR RED_TOUCH");
            }
            i = 1;
          }
        }
      }
      if (m == 0) {
        break;
      }
      localObject2 = a(paramQQAppInterface, 4, i1, str, paramArrayOfObject + "", true);
      paramQQAppInterface = (QQAppInterface)localObject2;
    } while (!QLog.isColorLevel());
    Object localObject3 = new StringBuilder().append("buildRedTouchAppInfo| path=").append(str).append(" redTouchType=");
    if (localObject2 != null) {}
    for (paramQQAppInterface = ((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get() + "";; paramQQAppInterface = "-1")
    {
      QLog.d("NewNearbyMyTab", 2, paramQQAppInterface + " count=" + 0 + " text=" + paramArrayOfObject);
      return localObject2;
      if (i != 0)
      {
        localObject2 = a(paramQQAppInterface, 0, i1, str, "", true);
        break;
      }
      localObject3 = ((axho)localObject3).a(str);
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (((BusinessInfoCheckUpdate.AppInfo)localObject3).type.get() == -1) {
          break;
        }
      }
      localObject2 = a(paramQQAppInterface, -1, i1, str, "", true);
      break;
    }
  }
  
  public static void a(AppInterface paramAppInterface, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if ((paramAppInterface == null) || (paramNearbyMyTabCard == null)) {
      return;
    }
    ausq.a("Q.nearby", "storeNearbyMyTabCard", new Object[] { paramNearbyMyTabCard });
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      bdcs.a(paramAppInterface.getCurrentAccountUin() + "NewNearbyMyTab.nbr", new Object[] { paramNearbyMyTabCard });
      return;
    }
  }
  
  public static void a(NearbyAppInterface paramNearbyAppInterface, int paramInt, boolean paramBoolean)
  {
    if (paramNearbyAppInterface == null) {}
    NearbyMyTabCard localNearbyMyTabCard;
    do
    {
      return;
      localNearbyMyTabCard = paramNearbyAppInterface.b();
      if (localNearbyMyTabCard != null)
      {
        localNearbyMyTabCard.newLikeNum = paramInt;
        a(paramNearbyAppInterface, localNearbyMyTabCard);
      }
    } while (!paramBoolean);
    ((alta)paramNearbyAppInterface.a(3)).a(localNearbyMyTabCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avpw
 * JD-Core Version:    0.7.0.1
 */