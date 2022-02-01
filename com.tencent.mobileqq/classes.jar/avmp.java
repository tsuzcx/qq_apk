import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;

public class avmp
  implements Manager
{
  bdrk jdField_a_of_type_Bdrk = new avmq(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter;
  String jdField_a_of_type_JavaLangString = "mqqapi://miniapp/open?_atype=0&_mappid=1109894538&_mvid=&_path=pages%2Findex%2Findex&_vt=3&_sig=71cba9e2ab0f0e779a62ecf6705e0f5cf65a4f764d755e8fc07b537e655c70ad";
  HashMap<Integer, avls> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Map<String, NewTogetherRoomMessageData> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public avmp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(2, (avhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236));
    a(1, (avju)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(306));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  }
  
  private int a(String paramString)
  {
    paramString = (NewTogetherRoomMessageData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  private long a(String paramString)
  {
    paramString = (NewTogetherRoomMessageData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  private NewTogetherRoomMessageData a(WatchTogetherSession paramWatchTogetherSession)
  {
    if (paramWatchTogetherSession == null) {
      return null;
    }
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.jdField_a_of_type_Int = paramWatchTogetherSession.jdField_a_of_type_Int;
    localNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString = paramWatchTogetherSession.e;
    localNewTogetherRoomMessageData.f = paramWatchTogetherSession.jdField_c_of_type_JavaLangString;
    localNewTogetherRoomMessageData.e = paramWatchTogetherSession.jdField_a_of_type_JavaLangString;
    localNewTogetherRoomMessageData.jdField_a_of_type_Long = paramWatchTogetherSession.jdField_a_of_type_Long;
    localNewTogetherRoomMessageData.d = paramWatchTogetherSession.jdField_b_of_type_JavaLangString;
    Object localObject = Uri.parse(paramWatchTogetherSession.jdField_a_of_type_JavaLangString);
    paramWatchTogetherSession = ((Uri)localObject).getQueryParameter("roomid");
    String str1 = ((Uri)localObject).getQueryParameter("room_show_number");
    String str2 = ((Uri)localObject).getQueryParameter("fromid");
    localObject = ((Uri)localObject).getQueryParameter("room_group_code");
    if (!TextUtils.isEmpty(paramWatchTogetherSession)) {
      localNewTogetherRoomMessageData.jdField_a_of_type_Long = Integer.parseInt(paramWatchTogetherSession);
    }
    if (!TextUtils.isEmpty(str1)) {
      localNewTogetherRoomMessageData.jdField_b_of_type_Int = Integer.parseInt(str1);
    }
    localNewTogetherRoomMessageData.jdField_c_of_type_JavaLangString = ((String)localObject);
    localNewTogetherRoomMessageData.g = str2;
    return localNewTogetherRoomMessageData;
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  troopUin is null");
      return "";
    }
    Object localObject;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("TOGETHER_BUNDLE_KEY_OWNER_UIN");
      QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  from extrainfo ownerUin=" + (String)localObject);
    }
    for (;;)
    {
      QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  extraInfo = " + paramBundle + ";troopUin=" + paramString + ";ownerUin=" + (String)localObject);
      return localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString);
        if (localObject != null)
        {
          localObject = ((TroopInfo)localObject).troopowneruin;
          continue;
        }
      }
      localObject = "";
    }
  }
  
  private void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    if ((paramNewTogetherRoomMessageData.jdField_c_of_type_Int == paramNewTogetherRoomMessageData.jdField_a_of_type_Int) || (paramNewTogetherRoomMessageData.jdField_c_of_type_Int == 0))
    {
      b(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString, paramNewTogetherRoomMessageData);
      c(paramNewTogetherRoomMessageData);
    }
    Bundle localBundle;
    avls localavls;
    do
    {
      return;
      b(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString, paramNewTogetherRoomMessageData);
      localBundle = new Bundle();
      localBundle.putString("close_reason", "switch_room");
      localBundle.putInt("old_room_type", paramNewTogetherRoomMessageData.jdField_c_of_type_Int);
      localBundle.putInt("new_room_type", paramNewTogetherRoomMessageData.jdField_a_of_type_Int);
      localavls = (avls)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramNewTogetherRoomMessageData.jdField_c_of_type_Int));
    } while (localavls == null);
    localavls.b(paramNewTogetherRoomMessageData, localBundle, new avms(this));
  }
  
  private void c(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (avls)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (localObject != null)
      {
        localObject = ((avls)localObject).a();
        if (localObject != null) {
          ((avlv)localObject).b(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  private void d(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (avls)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (localObject != null)
      {
        localObject = ((avls)localObject).a();
        if (localObject != null) {
          ((avlv)localObject).c(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  private void e(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    b(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString, paramNewTogetherRoomMessageData);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      avls localavls = (avls)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (localavls != null)
      {
        if (((Integer)localObject).intValue() == paramNewTogetherRoomMessageData.jdField_a_of_type_Int)
        {
          QLog.i("WatchTogetherManager", 1, "preload roomtype =  " + paramNewTogetherRoomMessageData.jdField_a_of_type_Int);
          paramNewTogetherRoomMessageData.g = "101";
          localavls.a(paramNewTogetherRoomMessageData);
        }
        localObject = localavls.a();
        if (localObject != null) {
          ((avlv)localObject).a(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdrk);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, avls paramavls)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramavls);
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    if (paramNewTogetherRoomMessageData == null) {
      biti.a().a("roomInfo is null!");
    }
    label277:
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString)))
      {
        biti.a().a("group info is null!");
        return;
      }
      if ((paramNewTogetherRoomMessageData.jdField_a_of_type_Int != 2) && (paramNewTogetherRoomMessageData.jdField_a_of_type_Int != 1))
      {
        biti.a().a("invalid roomtype!");
        return;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("intervideo").opName("open_together_room_entry").opType(String.valueOf(paramNewTogetherRoomMessageData.jdField_a_of_type_Int)).d1(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString).d2(paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString).d3(paramNewTogetherRoomMessageData.g).d4(String.valueOf(paramNewTogetherRoomMessageData.jdField_a_of_type_Long));
      int i;
      if (Boolean.valueOf(bool).booleanValue())
      {
        i = 1;
        ((IVPluginDataReporter)localObject).opIn(i).report();
        QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  roominfo = " + paramNewTogetherRoomMessageData.toString());
        if (paramNewTogetherRoomMessageData.jdField_a_of_type_Int != 2) {
          break label246;
        }
        localObject = (avls)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
      }
      for (;;)
      {
        if (localObject == null) {
          break label277;
        }
        ((avls)localObject).a(paramNewTogetherRoomMessageData, null, new avmr(this));
        return;
        i = 0;
        break;
        label246:
        if (paramNewTogetherRoomMessageData.jdField_a_of_type_Int == 1) {
          localObject = (avls)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void a(WatchTogetherSession paramWatchTogetherSession, int paramInt)
  {
    QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  pushActionType = " + paramInt);
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString = paramWatchTogetherSession.f;
    localNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString = paramWatchTogetherSession.e;
    localNewTogetherRoomMessageData.jdField_a_of_type_Int = paramWatchTogetherSession.jdField_a_of_type_Int;
    localNewTogetherRoomMessageData.jdField_a_of_type_Long = paramWatchTogetherSession.jdField_a_of_type_Long;
    localNewTogetherRoomMessageData.jdField_c_of_type_Int = a(paramWatchTogetherSession.e);
    localNewTogetherRoomMessageData.e = paramWatchTogetherSession.jdField_a_of_type_JavaLangString;
    localNewTogetherRoomMessageData.d = paramWatchTogetherSession.jdField_b_of_type_JavaLangString;
    localNewTogetherRoomMessageData.f = paramWatchTogetherSession.jdField_c_of_type_JavaLangString;
    localNewTogetherRoomMessageData.jdField_b_of_type_Long = a(paramWatchTogetherSession.e);
    QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  pushContent = " + localNewTogetherRoomMessageData.toString());
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 1: 
      e(localNewTogetherRoomMessageData);
      return;
    case 5: 
      b(localNewTogetherRoomMessageData);
      return;
    }
    d(localNewTogetherRoomMessageData);
  }
  
  public void a(WatchTogetherSession paramWatchTogetherSession, Bundle paramBundle)
  {
    if (paramWatchTogetherSession == null)
    {
      biti.a().a("watchTogetherSession == null!");
      return;
    }
    paramWatchTogetherSession = a(paramWatchTogetherSession);
    paramWatchTogetherSession.jdField_b_of_type_JavaLangString = a(paramBundle, paramWatchTogetherSession.jdField_a_of_type_JavaLangString);
    a(paramWatchTogetherSession);
  }
  
  public void a(String paramString, int paramInt, WatchTogetherSession paramWatchTogetherSession)
  {
    avls localavls = (avls)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localavls == null)
    {
      QLog.i("WatchTogetherManager", 1, "preloadBizRoom  fail!  roomtype is not registered");
      return;
    }
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = a(paramWatchTogetherSession);
    paramWatchTogetherSession = localNewTogetherRoomMessageData;
    if (localNewTogetherRoomMessageData == null)
    {
      paramWatchTogetherSession = new NewTogetherRoomMessageData();
      paramWatchTogetherSession.g = paramString;
    }
    paramWatchTogetherSession.jdField_b_of_type_JavaLangString = a(null, paramWatchTogetherSession.jdField_a_of_type_JavaLangString);
    QLog.i("WatchTogetherManager", 1, "preloadRoom  roomtype = " + paramInt);
    localavls.a(paramWatchTogetherSession);
  }
  
  public void a(String paramString, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString);
    boolean bool2 = bfup.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    a(paramString, paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString, paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool1).booleanValue(), Boolean.valueOf(bool2).booleanValue());
  }
  
  public void a(String paramString, WatchTogetherSession paramWatchTogetherSession, Bundle paramBundle)
  {
    if (paramWatchTogetherSession == null) {
      return;
    }
    boolean bool1;
    boolean bool2;
    if (paramBundle != null)
    {
      bool1 = paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER");
      bool2 = paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN");
      paramBundle = a(paramBundle, paramWatchTogetherSession.e);
      a(paramString, paramWatchTogetherSession.e, paramBundle, bool1, bool2);
      paramString = this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("intervideo").opName("open_together_miniapp").opType(String.valueOf(paramWatchTogetherSession.jdField_a_of_type_Int)).d1(paramWatchTogetherSession.e).d2(paramBundle).d3(paramString);
      if (!bool1) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 0)
    {
      paramString.opIn(i).report();
      return;
      bool1 = bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramWatchTogetherSession.e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bool2 = bfup.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramWatchTogetherSession.e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(paramString3)) {
      if (paramBoolean1)
      {
        paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("&group_uin=" + paramString2);
        localStringBuilder.append("&user_uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append("&source_id=" + paramString1);
        localStringBuilder.append("&owner_uin=" + paramString3);
        localStringBuilder.append("&isowner=");
        if (!paramBoolean1) {
          break label279;
        }
        paramString1 = "1";
        label164:
        localStringBuilder.append(paramString1);
        localStringBuilder.append("&isadmain=");
        if (!paramBoolean2) {
          break label286;
        }
        paramString1 = "1";
        label189:
        localStringBuilder.append(paramString1);
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty("8.4.1")) {
          break label452;
        }
        paramString1 = "8.4.1".split("\\.");
        if (paramString1.length <= 0) {
          break label452;
        }
        int j = 0;
        i = j;
        if (k < paramString1.length)
        {
          if (k == 0)
          {
            i = Integer.parseInt(paramString1[k]);
            i = j + i * 100000;
            k += 1;
            j = i;
            continue;
            paramString3 = "0";
            break;
            label279:
            paramString1 = "0";
            break label164;
            label286:
            paramString1 = "0";
            break label189;
          }
          if (k == 1)
          {
            i = j + Integer.parseInt(paramString1[k]) * 100;
            continue;
          }
          i = j;
          if (k != 2) {
            continue;
          }
          i = j + Integer.parseInt(paramString1[k]);
          continue;
        }
        localStringBuilder.append("&versioncode=" + i);
      }
      catch (Exception paramString1)
      {
        localStringBuilder.append("&versioncode=0");
        continue;
      }
      QLog.i("WatchTogetherManager", 1, "openMiniAPP  scheme = " + localStringBuilder.toString());
      paramString1 = new Intent();
      paramString1.setData(Uri.parse(localStringBuilder.toString()));
      paramString1.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(paramString1);
      return;
      break;
      label452:
      int i = 0;
    }
  }
  
  public void b(String paramString, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramNewTogetherRoomMessageData);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmp
 * JD-Core Version:    0.7.0.1
 */