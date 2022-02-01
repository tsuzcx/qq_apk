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
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
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

public class axac
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
  private ajka jdField_a_of_type_Ajka;
  baou jdField_a_of_type_Baou = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_a_of_type_JavaLangString = "";
    jdField_c_of_type_Long = -1L;
  }
  
  public axac(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_JavaLangString = AppSetting.c;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Ajka == null) {
      this.jdField_a_of_type_Ajka = ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    }
    if (this.jdField_a_of_type_Baou == null) {
      this.jdField_a_of_type_Baou = ((baou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38));
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
    blhf.a(paramQQAppInterface, paramMessageRecord);
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
          if (((blhs)paramQQAppInterface.a(146)).a(paramString, paramInt1)) {
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
        if ((!mtd.d(BaseApplicationImpl.getApplication())) && ((!jdField_b_of_type_Boolean) || (paramBoolean)))
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
            bdmc.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "qqlsReprotTag", true, 0L, 0L, paramString, "");
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
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        int k = this.jdField_a_of_type_Baou.c(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        if (localRecentBaseData.getRecentUserUin().equals(antf.H))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(antf.H, localRecentBaseData.getRecentUserType());
          if ((i != 0) || (k != 0)) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.getRecentUserUin() + localRecentBaseData.getRecentUserType());
        }
      }
      if (localRecentBaseData.getRecentUserUin().equals(antf.D))
      {
        i = ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
      }
      else if (localRecentBaseData.getRecentUserUin().equals(antf.ab))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(antf.ab, localRecentBaseData.getRecentUserType());
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
      localObject3 = paramQQAppInterface.a().b(paramString, paramInt1);
      if ((paramInt1 != 1001) || (asbc.b((MessageRecord)localObject3))) {
        break label2549;
      }
      paramString = antf.I;
      if ((!antf.ai.equals(paramString)) && (!antf.ah.equals(paramString)) && (!antf.I.equals(paramString))) {
        break label314;
      }
      paramQQAppInterface = almc.a(new RecentUser(paramString, paramInt1), paramQQAppInterface, paramQQAppInterface.getApp());
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
    apaw localapaw;
    label536:
    boolean bool;
    label564:
    label597:
    label598:
    label606:
    int j;
    if ((!bnrf.a(paramQQAppInterface)) && (paramInt1 == 7220) && (antf.aA.equals(paramString)))
    {
      localObject1 = antf.az;
      i = 1008;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "threadId =" + Thread.currentThread().getId());
      }
      if ((FriendsStatusUtil.a((String)localObject1, paramQQAppInterface)) || (aguy.a((String)localObject1, i, paramQQAppInterface))) {
        return false;
      }
      if (TextUtils.equals((CharSequence)localObject1, antf.O))
      {
        QLog.e("QQLSActivity", 1, "已过滤群通知被过滤: " + QLog.getStackTraceString(new Throwable()));
        return false;
      }
      localapaw = paramQQAppInterface.a().a();
      localObject2 = localapaw.getRecentList(true, false).iterator();
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
              break label2552;
            }
            localObject2 = new StringBuilder().append("updateLSRencentUser curUser is not null: ");
            if (paramString == null) {
              break label2642;
            }
            bool = true;
            QLog.d("QQLSActivity", 2, bool + "threadId =" + Thread.currentThread().getId());
            break label2552;
            break label1087;
            localObject2 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localRecentBaseData = (RecentBaseData)((Iterator)localObject2).next();
            } while ((TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.ai)) || (TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.ah)));
            paramInt1 = 0;
            if (!TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.H)) {
              break label1111;
            }
            paramInt1 = paramQQAppInterface.a().a(antf.H, localRecentBaseData.getRecentUserType());
          }
          for (;;)
          {
            label688:
            label752:
            Object localObject4;
            if ((localRecentBaseData.getRecentUserType() == 3000) || (localRecentBaseData.getRecentUserType() == 0) || (localRecentBaseData.getRecentUserType() == 8))
            {
              localRecentBaseData.update(paramQQAppInterface, BaseApplication.getContext());
              if (this.jdField_a_of_type_Baou == null) {
                break label2524;
              }
              j = this.jdField_a_of_type_Baou.c(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
              if (!QLog.isColorLevel()) {
                break label2631;
              }
              localObject4 = localRecentBaseData.getRecentUserUin();
              int k = localRecentBaseData.getRecentUserType();
              if (this.jdField_a_of_type_Baou == null) {
                break label2654;
              }
              bool = true;
              label782:
              QLog.d("QQLSActivity", 2, String.format("QQLSRecentManager.updateLSRencentUser miscallUnread[%s], Uin[%s], type[%s]", new Object[] { Integer.valueOf(j), localObject4, Integer.valueOf(k), Boolean.valueOf(bool) }));
              break label2631;
            }
            label830:
            if (paramInt1 != 0) {
              break label2637;
            }
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.getRecentUserUin() + localRecentBaseData.getRecentUserType());
            break label606;
            if ((paramString != null) && (((String)localObject1).equals(paramString.uin)) && (paramString.getType() == i)) {
              break label536;
            }
            if ((paramString != null) && (paramString.getType() == i) && (antf.x.equals(paramString.uin)))
            {
              paramString = new RecentUser((String)localObject1, i);
              break label536;
            }
            if (((paramString != null) && (paramString.getType() == i) && (antf.H.equals(paramString.uin))) || ((paramString != null) && (paramString.getType() == i) && (antf.ab.equals(paramString.uin)))) {
              break label536;
            }
            if ((paramString != null) && (antf.D.equals(paramString.uin)) && ((antf.M.equals(localObject1)) || (antf.ax.equals(localObject1)) || (antf.aE.equals(localObject1)))) {
              break label2639;
            }
            if ((paramString == null) || (paramString.getType() != 1032) || (adak.a(i) != 1032)) {
              break;
            }
            break label536;
            label1087:
            if (((baou)paramQQAppInterface.getManager(38)).c((String)localObject1, i) != 0) {
              break label598;
            }
            return false;
            label1111:
            if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.D))
            {
              if (((String)localObject1).equals(antf.M)) {
                paramInt1 = paramQQAppInterface.a().a(antf.M, localRecentBaseData.getRecentUserType());
              } else {
                paramInt1 = ((ajka)paramQQAppInterface.getManager(34)).d();
              }
            }
            else if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.ab))
            {
              paramInt1 = paramQQAppInterface.a().a(antf.ab, localRecentBaseData.getRecentUserType());
            }
            else
            {
              if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.af))
              {
                localObject4 = (asak)paramQQAppInterface.getManager(71);
                if (localObject4 == null) {
                  break label2530;
                }
                paramInt1 = ((asak)localObject4).a().a();
                break label2648;
              }
              if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.aw))
              {
                localObject4 = (awzz)paramQQAppInterface.getManager(145);
                if (localObject4 == null) {
                  break label2651;
                }
                paramInt1 = ((awzz)localObject4).a();
                break label2651;
              }
              paramInt1 = paramQQAppInterface.a().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
            }
          }
          j = 0;
          localObject2 = null;
          if (paramString == null) {
            break label2660;
          }
          if (paramString.uin.equals(antf.H))
          {
            paramInt1 = paramQQAppInterface.a().a(antf.H, paramString.getType());
            paramString = almc.a(paramString, paramQQAppInterface, paramQQAppInterface.getApp());
          }
          for (;;)
          {
            label1355:
            if ((paramInt1 <= 0) || (paramString == null)) {
              break label2429;
            }
            if ((ajka.a(paramQQAppInterface, paramString.getRecentUserUin())) && (antf.ad.equals(paramString.getRecentUserUin()))) {
              paramString.mTitleName = paramQQAppInterface.getApp().getString(2131689533);
            }
            localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            label1409:
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (RecentBaseData)((Iterator)localObject1).next();
              if ((!ajka.a(paramQQAppInterface, ((RecentBaseData)localObject2).getRecentUserUin())) || (!ajka.a(paramQQAppInterface, paramString.getRecentUserUin()))) {
                break label2075;
              }
              jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
            }
            label1494:
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
            if (paramBoolean2) {
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.getRecentUserUin() + paramString.getRecentUserType(), Integer.valueOf(paramInt2));
            }
            label1543:
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
            }
            if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0) {
              break label2515;
            }
            return true;
            if (paramString.uin.equals(antf.D))
            {
              if (((String)localObject1).equals(antf.M))
              {
                paramInt1 = paramQQAppInterface.a().a(antf.M, paramString.getType());
                break;
              }
              paramInt1 = ((ajka)paramQQAppInterface.getManager(34)).d();
              bdll.b(paramQQAppInterface, "dc00898", "", "", "0X80077D5", "0X80077D5", 0, 0, "", "", "", "");
              break;
            }
            if (paramString.uin.equals(antf.ab))
            {
              paramInt1 = paramQQAppInterface.a().a(antf.ab, paramString.getType());
              break;
            }
            paramInt1 = paramQQAppInterface.a().a(paramString.uin, paramString.getType());
            break;
            label1729:
            paramString = (String)localObject2;
            paramInt1 = j;
            if (!bduy.a())
            {
              i = paramQQAppInterface.a().a((String)localObject1, i);
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
                  label1803:
                  if (i == 1012)
                  {
                    paramString = (asak)paramQQAppInterface.getManager(71);
                    if (paramString == null) {
                      break label2517;
                    }
                    paramInt1 = paramString.a().a();
                    paramString = paramString.a().a();
                    break label2679;
                  }
                  if (i == 1030)
                  {
                    paramString = (String)localObject2;
                    paramInt1 = j;
                    if (paramQQAppInterface.a(240))
                    {
                      paramString = (aqqq)paramQQAppInterface.getManager(240);
                      paramInt1 = paramString.a();
                      paramString = paramString.a();
                    }
                  }
                  else
                  {
                    if (i != 9653) {
                      break label2682;
                    }
                    paramString = (awzz)paramQQAppInterface.getManager(145);
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
    label1924:
    label2075:
    label2515:
    label2517:
    label2524:
    label2530:
    label2549:
    label2552:
    label2682:
    for (;;)
    {
      paramString = (String)localObject2;
      paramInt1 = j;
      if (!paramQQAppInterface.a(284)) {
        break label1355;
      }
      paramString = (axaa)paramQQAppInterface.getManager(284);
      paramInt1 = 1;
      paramString = paramString.a();
      break label1355;
      label2429:
      do
      {
        localObject3 = (RecentUser)localapaw.findRecentUserByUin((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject3 == null) {
          break label1355;
        }
        ((RecentUser)localObject3).lastmsgtime = bcrg.a();
        localObject2 = almc.a((RecentUser)localObject3, paramQQAppInterface, paramQQAppInterface.getApp());
        paramString = (String)localObject2;
        paramInt1 = j;
        if (i != 8) {
          break label1355;
        }
        localObject1 = paramQQAppInterface.a().a().a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject1 == null) {
          break label1355;
        }
        ((RecentBaseData)localObject2).mExtraType = ((QCallRecent)localObject1).extraType;
        ((RecentBaseData)localObject2).mPhoneNumber = ((QCallRecent)localObject1).phoneNumber;
        paramString = (String)localObject2;
        paramInt1 = j;
        break label1355;
        if ((TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())) && (((RecentBaseData)localObject2).getRecentUserType() == paramString.getRecentUserType()))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1494;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), antf.H)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1494;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), antf.aq)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1494;
        }
        if ((TextUtils.equals(paramString.getRecentUserUin(), antf.ab)) && (TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
          break label1494;
        }
        if ((!TextUtils.equals(paramString.getRecentUserUin(), antf.D)) || (!TextUtils.equals(((RecentBaseData)localObject2).getRecentUserUin(), paramString.getRecentUserUin()))) {
          break label1409;
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.getRecentUserUin() + paramString.getRecentUserType());
        break label1494;
        if ((!paramBoolean1) || (paramString == null) || (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString))) {
          break label1543;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        if (!paramBoolean2) {
          break label1543;
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.getRecentUserUin() + paramString.getRecentUserType(), Integer.valueOf(paramInt2));
        break label1543;
        return false;
        paramString = null;
        paramInt1 = 0;
        break label2679;
        j = 0;
        break label752;
        paramInt1 = 0;
        break label2648;
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
          break label1729;
        }
        if (i != 1045) {
          break label1803;
        }
        break label1729;
        break label1355;
        if ((i == 1035) || (i == 1041)) {
          break label1924;
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
    if (this.jdField_a_of_type_Ajka != null) {
      this.jdField_a_of_type_Ajka = null;
    }
    if (this.jdField_a_of_type_Baou != null) {
      this.jdField_a_of_type_Baou = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof ajmf)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
      }
      if (bhrl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
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
          i = ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
        } while ((TextUtils.isEmpty(((ajmf)paramObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || (((ajmf)paramObject).a == 0L));
        if ((i != 0) && (!f)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + f);
      return;
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693438), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131717560), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, antf.D, 4000, false, awzy.a(antf.D, 4000, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axac
 * JD-Core Version:    0.7.0.1
 */