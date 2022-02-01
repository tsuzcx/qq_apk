import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class awto
  implements Observer, Manager
{
  public static int a;
  public static long a;
  public static String a;
  private static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static CopyOnWriteArrayList<RecentBaseData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public static boolean a;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  public static int b;
  public static long b;
  public static volatile boolean b;
  public static long c;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g = true;
  public static boolean h;
  private aizi jdField_a_of_type_Aizi;
  bapk jdField_a_of_type_Bapk = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_a_of_type_JavaLangString = "";
    jdField_c_of_type_Long = -1L;
  }
  
  public awto(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_JavaLangString = AppSetting.c;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Aizi == null) {
      this.jdField_a_of_type_Aizi = ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    }
    if (this.jdField_a_of_type_Bapk == null) {
      this.jdField_a_of_type_Bapk = ((bapk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE));
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      d = true;
      return d;
    }
    d = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.lock_screen.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "isPhoneNeedBright need bright before sensor = " + d);
    }
    return d;
  }
  
  public int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "getNotifyIDForUin mNotifyIdList.size = " + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localInteger != null) {}
      for (int i = localInteger.intValue();; i = -1)
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return i;
      }
    }
    return -1;
  }
  
  public CopyOnWriteArrayList<RecentBaseData> a()
  {
    return jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mDataList clear");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    bkyh.a(paramQQAppInterface, paramMessageRecord);
    a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramBoolean, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "startQQLs but  app is null ,return");
      }
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramQQAppInterface.isLogin()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("QQLSActivity", 2, "startQQLs but is not login ,return");
          return;
          if (((bkyu)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER)).a(paramString, paramInt1)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQLSActivity", 2, "startQQLs but is Notification not permitted ,return");
        return;
      } while (jdField_a_of_type_JavaLangString.equalsIgnoreCase("HUAWEI-HUAWEI T8833"));
      bool = b();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, String.format("needStartQQLS frienduin[%s], uitype[%s], isFromMisscall[%s], isStartTime[%s]", new Object[] { paramString, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
      }
    } while (!bool);
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label686;
      }
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "locking activity:" + (String)localObject);
      }
      if ((!((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) && (!((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) && (!((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        break label648;
      }
      i = 1;
    }
    for (;;)
    {
      label269:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager.getInstance().isLSalive:" + jdField_b_of_type_Boolean);
      }
      if (paramInt1 == 1)
      {
        jdField_c_of_type_Boolean = true;
        label312:
        if (i != 0) {
          break label659;
        }
        if ((!mtj.e(BaseApplicationImpl.getApplication())) && ((!jdField_b_of_type_Boolean) || (paramBoolean)))
        {
          if ((!a(paramQQAppInterface, paramString, paramInt1, paramBoolean, paramInt2, true)) || (Build.VERSION.SDK_INT > 28)) {
            break label661;
          }
          localObject = new Intent(paramQQAppInterface.getApp(), QQLSActivity.class);
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).addFlags(262144);
          ((Intent)localObject).putExtra("notifyId", paramInt2);
          ((Intent)localObject).putExtra("uitype", paramInt1);
          ((Intent)localObject).putExtra("frienduin", paramString);
          paramQQAppInterface.getApp().startActivity((Intent)localObject);
          e = true;
          jdField_b_of_type_Int += 1;
          if (QLog.isColorLevel()) {
            QLog.d("qqls", 2, "need report  LS report needReport=" + g + "hasReport=" + h + "startTimes=" + jdField_b_of_type_Int);
          }
          if ((!h) && (jdField_b_of_type_Int > 2))
          {
            paramString = new HashMap();
            paramString.put("param_hasshowedLs", g + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "qqlsReprotTag", true, 0L, 0L, paramString, "");
            if (QLog.isColorLevel()) {
              QLog.d("qqls", 2, "need report  LS report needReport=" + g);
            }
            h = true;
          }
        }
      }
      for (;;)
      {
        if (!QLog.isDevelopLevel()) {
          break label684;
        }
        QLog.d("QQLSActivity", 4, String.format("needStartQQLS end...", new Object[0]));
        return;
        label648:
        i = 0;
        break label269;
        jdField_c_of_type_Boolean = false;
        break label312;
        label659:
        break;
        label661:
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, String.format("needStartQQLS updateLSRencentUser fail...", new Object[0]));
        }
      }
      label684:
      break;
      label686:
      i = 0;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      RecentBaseData localRecentBaseData;
      int j;
      int i;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localRecentBaseData = (RecentBaseData)localIterator.next();
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        int k = this.jdField_a_of_type_Bapk.c(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        if (localRecentBaseData.getRecentUserUin().equals(AppConstants.LBS_HELLO_UIN))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.LBS_HELLO_UIN, localRecentBaseData.getRecentUserType());
          if ((i != 0) || (k != 0)) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.getRecentUserUin() + localRecentBaseData.getRecentUserType());
        }
      }
      if (localRecentBaseData.getRecentUserUin().equals(AppConstants.RECOMMEND_CONTACT_UIN))
      {
        i = ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
      }
      else if (localRecentBaseData.getRecentUserUin().equals(AppConstants.DATE_UIN))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.DATE_UIN, localRecentBaseData.getRecentUserType());
      }
      else
      {
        i = j;
        if (localRecentBaseData.getRecentUserUin().equals(paramString))
        {
          i = j;
          if (paramInt == localRecentBaseData.getRecentUserType())
          {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.getRecentUserUin() + localRecentBaseData.getRecentUserType());
            i = j;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "after removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject3;
    Object localObject1;
    Object localObject2;
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!, thread[" + Thread.currentThread().getId() + "], uin[" + paramString + "], uinType[" + paramInt1 + "], isFromMisscall[" + paramBoolean1);
      }
      localObject3 = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(paramString, paramInt1);
      if ((paramInt1 != 1001) || (aryo.b((MessageRecord)localObject3))) {
        break label2554;
      }
      paramString = AppConstants.NEARBY_LBS_HELLO_UIN;
      if ((!AppConstants.LOCK_SCREEN_DATE_UIN.equals(paramString)) && (!AppConstants.LOCK_SCREEN_LBS_HELLO_UIN.equals(paramString)) && (!AppConstants.NEARBY_LBS_HELLO_UIN.equals(paramString))) {
        break label314;
      }
      paramQQAppInterface = alfm.a(new RecentUser(paramString, paramInt1), paramQQAppInterface, paramQQAppInterface.getApp());
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((RecentBaseData)localObject2).getRecentUserUin() + ((RecentBaseData)localObject2).getRecentUserType());
        }
      }
    }
    if (paramQQAppInterface != null)
    {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramQQAppInterface);
      if (paramBoolean2) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQAppInterface.getRecentUserUin() + paramQQAppInterface.getRecentUserType(), Integer.valueOf(paramInt2));
      }
    }
    return true;
    label314:
    int i;
    label348:
    aoxz localaoxz;
    label536:
    boolean bool;
    label564:
    label597:
    label598:
    label606:
    int j;
    if ((!bmhv.a(paramQQAppInterface)) && (paramInt1 == 7220) && (AppConstants.KANDIAN_MERGE_UIN.equals(paramString)))
    {
      localObject1 = AppConstants.NEW_KANDIAN_UIN;
      i = 1008;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "threadId =" + Thread.currentThread().getId());
      }
      if ((FriendsStatusUtil.a((String)localObject1, paramQQAppInterface)) || (agij.a((String)localObject1, i, paramQQAppInterface))) {
        return false;
      }
      if (TextUtils.equals((CharSequence)localObject1, AppConstants.TROOP_SUSPICIOUS_MSG_UIN))
      {
        QLog.e("QQLSActivity", 1, "已过滤群通知被过滤: " + QLog.getStackTraceString(new Throwable()));
        return false;
      }
      localaoxz = paramQQAppInterface.getProxyManager().a();
      localObject2 = localaoxz.getRecentList(true, false).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        paramString = (RecentUser)((Iterator)localObject2).next();
        if (paramString != null)
        {
          RecentBaseData localRecentBaseData;
          if (TextUtils.isEmpty(paramString.uin))
          {
            paramString = null;
            if (!QLog.isColorLevel()) {
              break label2557;
            }
            localObject2 = new StringBuilder().append("updateLSRencentUser curUser is not null: ");
            if (paramString == null) {
              break label2647;
            }
            bool = true;
            QLog.d("QQLSActivity", 2, bool + "threadId =" + Thread.currentThread().getId());
            break label2557;
            break label1087;
            localObject2 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localRecentBaseData = (RecentBaseData)((Iterator)localObject2).next();
            } while ((TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LOCK_SCREEN_DATE_UIN)) || (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)));
            paramInt1 = 0;
            if (!TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.LBS_HELLO_UIN)) {
              break label1112;
            }
            paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.LBS_HELLO_UIN, localRecentBaseData.getRecentUserType());
          }
          for (;;)
          {
            label688:
            label752:
            Object localObject4;
            if ((localRecentBaseData.getRecentUserType() == 3000) || (localRecentBaseData.getRecentUserType() == 0) || (localRecentBaseData.getRecentUserType() == 8))
            {
              localRecentBaseData.update(paramQQAppInterface, BaseApplication.getContext());
              if (this.jdField_a_of_type_Bapk == null) {
                break label2529;
              }
              j = this.jdField_a_of_type_Bapk.c(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
              if (!QLog.isColorLevel()) {
                break label2636;
              }
              localObject4 = localRecentBaseData.getRecentUserUin();
              int k = localRecentBaseData.getRecentUserType();
              if (this.jdField_a_of_type_Bapk == null) {
                break label2659;
              }
              bool = true;
              label782:
              QLog.d("QQLSActivity", 2, String.format("QQLSRecentManager.updateLSRencentUser miscallUnread[%s], Uin[%s], type[%s]", new Object[] { Integer.valueOf(j), localObject4, Integer.valueOf(k), Boolean.valueOf(bool) }));
              break label2636;
            }
            label830:
            if (paramInt1 != 0) {
              break label2642;
            }
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.getRecentUserUin() + localRecentBaseData.getRecentUserType());
            break label606;
            if ((paramString != null) && (((String)localObject1).equals(paramString.uin)) && (paramString.getType() == i)) {
              break label536;
            }
            if ((paramString != null) && (paramString.getType() == i) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString.uin)))
            {
              paramString = new RecentUser((String)localObject1, i);
              break label536;
            }
            if (((paramString != null) && (paramString.getType() == i) && (AppConstants.LBS_HELLO_UIN.equals(paramString.uin))) || ((paramString != null) && (paramString.getType() == i) && (AppConstants.DATE_UIN.equals(paramString.uin)))) {
              break label536;
            }
            if ((paramString != null) && (AppConstants.RECOMMEND_CONTACT_UIN.equals(paramString.uin)) && ((AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(localObject1)) || (AppConstants.MAYKNOW_RECOMMEND_UIN.equals(localObject1)) || (AppConstants.FRIEND_ANNIVER_UIN.equals(localObject1)))) {
              break label2644;
            }
            if ((paramString == null) || (paramString.getType() != 1032) || (acnh.a(i) != 1032)) {
              break;
            }
            break label536;
            label1087:
            if (((bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)).c((String)localObject1, i) != 0) {
              break label598;
            }
            return false;
            label1112:
            if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.RECOMMEND_CONTACT_UIN))
            {
              if (((String)localObject1).equals(AppConstants.FRIEND_SYSTEM_MSG_UIN)) {
                paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, localRecentBaseData.getRecentUserType());
              } else {
                paramInt1 = ((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
              }
            }
            else if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.DATE_UIN))
            {
              paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.DATE_UIN, localRecentBaseData.getRecentUserType());
            }
            else
            {
              if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.VOTE_UIN))
              {
                localObject4 = (arxv)paramQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                if (localObject4 == null) {
                  break label2535;
                }
                paramInt1 = ((arxv)localObject4).a().a();
                break label2653;
              }
              if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.PULL_ACTIVE_PUSH_UIN))
              {
                localObject4 = (awtl)paramQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                if (localObject4 == null) {
                  break label2656;
                }
                paramInt1 = ((awtl)localObject4).a();
                break label2656;
              }
              paramInt1 = paramQQAppInterface.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
            }
          }
          j = 0;
          localObject2 = null;
          if (paramString == null) {
            break label2665;
          }
          if (paramString.uin.equals(AppConstants.LBS_HELLO_UIN))
          {
            paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.LBS_HELLO_UIN, paramString.getType());
            paramString = alfm.a(paramString, paramQQAppInterface, paramQQAppInterface.getApp());
          }
          for (;;)
          {
            label1358:
            if ((paramInt1 <= 0) || (paramString == null)) {
              break label2434;
            }
            if ((aizi.a(paramQQAppInterface, paramString.getRecentUserUin())) && (AppConstants.ACTIVATE_FRIENDS_UIN.equals(paramString.getRecentUserUin()))) {
              paramString.mTitleName = paramQQAppInterface.getApp().getString(2131689532);
            }
            localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            label1412:
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (RecentBaseData)((Iterator)localObject1).next();
              if ((!aizi.a(paramQQAppInterface, ((RecentBaseData)localObject2).getRecentUserUin())) || (!aizi.a(paramQQAppInterface, paramString.getRecentUserUin()))) {
                break label2080;
              }
              jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
            }
            label1497:
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
            if (paramBoolean2) {
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.getRecentUserUin() + paramString.getRecentUserType(), Integer.valueOf(paramInt2));
            }
            label1546:
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
            }
            if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0) {
              break label2520;
            }
            return true;
            if (paramString.uin.equals(AppConstants.RECOMMEND_CONTACT_UIN))
            {
              if (((String)localObject1).equals(AppConstants.FRIEND_SYSTEM_MSG_UIN))
              {
                paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, paramString.getType());
                break;
              }
              paramInt1 = ((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
              bdla.b(paramQQAppInterface, "dc00898", "", "", "0X80077D5", "0X80077D5", 0, 0, "", "", "", "");
              break;
            }
            if (paramString.uin.equals(AppConstants.DATE_UIN))
            {
              paramInt1 = paramQQAppInterface.getConversationFacade().a(AppConstants.DATE_UIN, paramString.getType());
              break;
            }
            paramInt1 = paramQQAppInterface.getConversationFacade().a(paramString.uin, paramString.getType());
            break;
            label1733:
            paramString = (String)localObject2;
            paramInt1 = j;
            if (!bdvn.a())
            {
              i = paramQQAppInterface.getConversationFacade().a((String)localObject1, i);
              paramString = (String)localObject2;
              paramInt1 = i;
              if (localObject3 != null)
              {
                paramString = (String)localObject2;
                paramInt1 = i;
                if (((MessageRecord)localObject3).senderuin != null)
                {
                  paramString = new RecentMatchChatListItem((MessageRecord)localObject3);
                  paramString.update(paramQQAppInterface, BaseApplication.getContext());
                  paramInt1 = i;
                  continue;
                  label1807:
                  if (i == 1012)
                  {
                    paramString = (arxv)paramQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                    if (paramString == null) {
                      break label2522;
                    }
                    paramInt1 = paramString.a().a();
                    paramString = paramString.a().a();
                    break label2684;
                  }
                  if (i == 1030)
                  {
                    paramString = (String)localObject2;
                    paramInt1 = j;
                    if (paramQQAppInterface.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER))
                    {
                      paramString = (aqnd)paramQQAppInterface.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER);
                      paramInt1 = paramString.a();
                      paramString = paramString.a();
                    }
                  }
                  else
                  {
                    if (i != 9653) {
                      break label2687;
                    }
                    paramString = (awtl)paramQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                    paramInt1 = paramString.a();
                    paramString = paramString.a;
                  }
                }
              }
            }
          }
        }
      }
    }
    label1929:
    label2080:
    label2520:
    label2522:
    label2529:
    label2535:
    label2554:
    label2684:
    for (;;)
    {
      paramString = (String)localObject2;
      paramInt1 = j;
      if (!paramQQAppInterface.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)) {
        break label1358;
      }
      paramString = (awtm)paramQQAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER);
      paramInt1 = 1;
      paramString = paramString.a();
      break label1358;
      label2557:
      label2687:
      do
      {
        localObject3 = (RecentUser)localaoxz.findRecentUserByUin((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject3 == null) {
          break label1358;
        }
        ((RecentUser)localObject3).lastmsgtime = bcrg.a();
        localObject2 = alfm.a((RecentUser)localObject3, paramQQAppInterface, paramQQAppInterface.getApp());
        paramString = (String)localObject2;
        paramInt1 = j;
        if (i != 8) {
          break label1358;
        }
        localObject1 = paramQQAppInterface.getProxyManager().a().a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject1 == null) {
          break label1358;
        }
        ((RecentBaseData)localObject2).mExtraType = ((QCallRecent)localObject1).extraType;
        ((RecentBaseData)localObject2).mPhoneNumber = ((QCallRecent)localObject1).phoneNumber;
        paramString = (String)localObject2;
        paramInt1 = j;
        break label1358;
        if ((TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())) && (((RecentBaseData)localObject2).getRecentUserType() == paramString.getRecentUserType()))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1497;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.LBS_HELLO_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1497;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.SCHEDULE_NOTIFY_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1497;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), AppConstants.DATE_UIN)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1497;
        }
        if ((!TextUtils.equals(paramString.getRecentUserUin(), AppConstants.RECOMMEND_CONTACT_UIN)) || (!TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin()))) {
          break label1412;
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
        break label1497;
        if ((!paramBoolean1) || (paramString == null) || (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString))) {
          break label1546;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        if (!paramBoolean2) {
          break label1546;
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.getRecentUserUin() + paramString.getRecentUserType(), Integer.valueOf(paramInt2));
        break label1546;
        return false;
        paramString = null;
        paramInt1 = 0;
        break label2684;
        j = 0;
        break label752;
        paramInt1 = 0;
        break label2653;
        paramString = null;
        break label536;
        localObject1 = paramString;
        i = paramInt1;
        break label348;
        break;
        if ((paramString != null) || (i == 1012) || (i == 7432) || (i == 9653) || (i == 1030) || (i == 1035) || (i == 1041) || (i == 1042) || (i == 1044)) {
          break label598;
        }
        if (i != 1045) {
          break label597;
        }
        break label598;
        if (j > 0) {
          break label606;
        }
        break label830;
        break label606;
        break label536;
        bool = false;
        break label564;
        break label688;
        break label688;
        bool = false;
        break label782;
        if (i == 1044) {
          break label1733;
        }
        if (i != 1045) {
          break label1807;
        }
        break label1733;
        break label1358;
        if ((i == 1035) || (i == 1041)) {
          break label1929;
        }
      } while (i != 1042);
    }
  }
  
  public boolean b()
  {
    long l = System.currentTimeMillis();
    if ((jdField_c_of_type_Long > 0L) && (l - jdField_c_of_type_Long < 5000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "isNeedStart false ,less than 5sec");
      }
      return false;
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aizi != null) {
      this.jdField_a_of_type_Aizi = null;
    }
    if (this.jdField_a_of_type_Bapk != null) {
      this.jdField_a_of_type_Bapk = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof ajbn)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
      }
      if (bhgy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        break label77;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun ");
      }
    }
    label77:
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).d();
        } while ((TextUtils.isEmpty(((ajbn)paramObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || (((ajbn)paramObject).a == 0L));
        if ((i != 0) && (!f)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + f);
      return;
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693714), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718178), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.RECOMMEND_CONTACT_UIN, 4000, false, awtk.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awto
 * JD-Core Version:    0.7.0.1
 */