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

public class atvs
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
  private altc jdField_a_of_type_Altc;
  awwg jdField_a_of_type_Awwg = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_a_of_type_JavaLangString = "";
    jdField_c_of_type_Long = -1L;
  }
  
  public atvs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_JavaLangString = AppSetting.c;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Altc == null) {
      this.jdField_a_of_type_Altc = ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    }
    if (this.jdField_a_of_type_Awwg == null) {
      this.jdField_a_of_type_Awwg = ((awwg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38));
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
    bhok.a(paramQQAppInterface, paramMessageRecord);
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
          if (((bhoy)paramQQAppInterface.a(146)).a(paramString, paramInt1)) {
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
        if ((!muz.d(BaseApplicationImpl.getApplication())) && ((!jdField_b_of_type_Boolean) || (paramBoolean)))
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
            azmz.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "qqlsReprotTag", true, 0L, 0L, paramString, "");
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
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
        int k = this.jdField_a_of_type_Awwg.c(localRecentBaseData.a(), localRecentBaseData.a());
        if (localRecentBaseData.a().equals(aljq.H))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(aljq.H, localRecentBaseData.a());
          if ((i != 0) || (k != 0)) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.a() + localRecentBaseData.a());
        }
      }
      if (localRecentBaseData.a().equals(aljq.D))
      {
        i = ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
      }
      else if (localRecentBaseData.a().equals(aljq.ab))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(aljq.ab, localRecentBaseData.a());
      }
      else
      {
        i = j;
        if (localRecentBaseData.a().equals(paramString))
        {
          i = j;
          if (paramInt == localRecentBaseData.a())
          {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.a() + localRecentBaseData.a());
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
      if ((paramInt1 != 1001) || (apei.b((MessageRecord)localObject3))) {
        break label2495;
      }
      paramString = aljq.I;
      if ((!aljq.ai.equals(paramString)) && (!aljq.ah.equals(paramString)) && (!aljq.I.equals(paramString))) {
        break label314;
      }
      paramQQAppInterface = ajdp.a(new RecentUser(paramString, paramInt1), paramQQAppInterface, paramQQAppInterface.getApp());
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (((RecentBaseData)localObject2).a().equals(paramString))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((RecentBaseData)localObject2).a() + ((RecentBaseData)localObject2).a());
        }
      }
    }
    if (paramQQAppInterface != null)
    {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramQQAppInterface);
      if (paramBoolean2) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQAppInterface.a() + paramQQAppInterface.a(), Integer.valueOf(paramInt2));
      }
    }
    return true;
    label314:
    int i;
    label348:
    amjk localamjk;
    label485:
    boolean bool;
    label513:
    label546:
    label547:
    label555:
    label637:
    int j;
    if ((!bjxj.a(paramQQAppInterface)) && (paramInt1 == 7220) && (aljq.aA.equals(paramString)))
    {
      localObject1 = aljq.az;
      i = 1008;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "threadId =" + Thread.currentThread().getId());
      }
      if ((FriendsStatusUtil.a((String)localObject1, paramQQAppInterface)) || (afai.a((String)localObject1, i, paramQQAppInterface))) {
        return false;
      }
      localamjk = paramQQAppInterface.a().a();
      localObject2 = localamjk.a(true, false).iterator();
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
              break label2498;
            }
            localObject2 = new StringBuilder().append("updateLSRencentUser curUser is not null: ");
            if (paramString == null) {
              break label2588;
            }
            bool = true;
            QLog.d("QQLSActivity", 2, bool + "threadId =" + Thread.currentThread().getId());
            break label2498;
            break label1036;
            localObject2 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localRecentBaseData = (RecentBaseData)((Iterator)localObject2).next();
            } while ((localRecentBaseData.a().equals(aljq.ai)) || (localRecentBaseData.a().equals(aljq.ah)));
            paramInt1 = 0;
            if (!localRecentBaseData.a().equals(aljq.H)) {
              break label1060;
            }
            paramInt1 = paramQQAppInterface.a().a(aljq.H, localRecentBaseData.a());
          }
          for (;;)
          {
            label701:
            Object localObject4;
            if ((localRecentBaseData.a() == 3000) || (localRecentBaseData.a() == 0) || (localRecentBaseData.a() == 8))
            {
              localRecentBaseData.a(paramQQAppInterface, BaseApplication.getContext());
              if (this.jdField_a_of_type_Awwg == null) {
                break label2470;
              }
              j = this.jdField_a_of_type_Awwg.c(localRecentBaseData.a(), localRecentBaseData.a());
              if (!QLog.isColorLevel()) {
                break label2577;
              }
              localObject4 = localRecentBaseData.a();
              int k = localRecentBaseData.a();
              if (this.jdField_a_of_type_Awwg == null) {
                break label2600;
              }
              bool = true;
              label731:
              QLog.d("QQLSActivity", 2, String.format("QQLSRecentManager.updateLSRencentUser miscallUnread[%s], Uin[%s], type[%s]", new Object[] { Integer.valueOf(j), localObject4, Integer.valueOf(k), Boolean.valueOf(bool) }));
              break label2577;
            }
            label779:
            if (paramInt1 != 0) {
              break label2583;
            }
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localRecentBaseData.a() + localRecentBaseData.a());
            break label555;
            if ((paramString != null) && (((String)localObject1).equals(paramString.uin)) && (paramString.getType() == i)) {
              break label485;
            }
            if ((paramString != null) && (paramString.getType() == i) && (aljq.x.equals(paramString.uin)))
            {
              paramString = new RecentUser((String)localObject1, i);
              break label485;
            }
            if (((paramString != null) && (paramString.getType() == i) && (aljq.H.equals(paramString.uin))) || ((paramString != null) && (paramString.getType() == i) && (aljq.ab.equals(paramString.uin)))) {
              break label485;
            }
            if ((paramString != null) && (aljq.D.equals(paramString.uin)) && ((aljq.M.equals(localObject1)) || (aljq.ax.equals(localObject1)) || (aljq.aF.equals(localObject1)))) {
              break label2585;
            }
            if ((paramString == null) || (paramString.getType() != 1032) || (abot.a(i) != 1032)) {
              break;
            }
            break label485;
            label1036:
            if (((awwg)paramQQAppInterface.getManager(38)).c((String)localObject1, i) != 0) {
              break label547;
            }
            return false;
            label1060:
            if (localRecentBaseData.a().equals(aljq.D))
            {
              if (((String)localObject1).equals(aljq.M)) {
                paramInt1 = paramQQAppInterface.a().a(aljq.M, localRecentBaseData.a());
              } else {
                paramInt1 = ((altc)paramQQAppInterface.getManager(34)).d();
              }
            }
            else if (localRecentBaseData.a().equals(aljq.ab))
            {
              paramInt1 = paramQQAppInterface.a().a(aljq.ab, localRecentBaseData.a());
            }
            else
            {
              if (localRecentBaseData.a().equals(aljq.af))
              {
                localObject4 = (apdq)paramQQAppInterface.getManager(71);
                if (localObject4 == null) {
                  break label2476;
                }
                paramInt1 = ((apdq)localObject4).a().a();
                break label2594;
              }
              if (localRecentBaseData.a().equals(aljq.aw))
              {
                localObject4 = (atvp)paramQQAppInterface.getManager(145);
                if (localObject4 == null) {
                  break label2597;
                }
                paramInt1 = ((atvp)localObject4).a();
                break label2597;
              }
              paramInt1 = paramQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
            }
          }
          j = 0;
          localObject2 = null;
          if (paramString == null) {
            break label2606;
          }
          if (paramString.uin.equals(aljq.H))
          {
            paramInt1 = paramQQAppInterface.a().a(aljq.H, paramString.getType());
            paramString = ajdp.a(paramString, paramQQAppInterface, paramQQAppInterface.getApp());
          }
          for (;;)
          {
            label1304:
            if ((paramInt1 <= 0) || (paramString == null)) {
              break label2375;
            }
            if ((altc.a(paramQQAppInterface, paramString.a())) && (aljq.ad.equals(paramString.a()))) {
              paramString.mTitleName = paramQQAppInterface.getApp().getString(2131689608);
            }
            localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            label1358:
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (RecentBaseData)((Iterator)localObject1).next();
              if ((!altc.a(paramQQAppInterface, ((RecentBaseData)localObject2).a())) || (!altc.a(paramQQAppInterface, paramString.a()))) {
                break label2021;
              }
              jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.a() + paramString.a());
            }
            label1443:
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
            if (paramBoolean2) {
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.a() + paramString.a(), Integer.valueOf(paramInt2));
            }
            label1492:
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
            }
            if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0) {
              break label2461;
            }
            return true;
            if (paramString.uin.equals(aljq.D))
            {
              if (((String)localObject1).equals(aljq.M))
              {
                paramInt1 = paramQQAppInterface.a().a(aljq.M, paramString.getType());
                break;
              }
              paramInt1 = ((altc)paramQQAppInterface.getManager(34)).d();
              azmj.b(paramQQAppInterface, "dc00898", "", "", "0X80077D5", "0X80077D5", 0, 0, "", "", "", "");
              break;
            }
            if (paramString.uin.equals(aljq.ab))
            {
              paramInt1 = paramQQAppInterface.a().a(aljq.ab, paramString.getType());
              break;
            }
            paramInt1 = paramQQAppInterface.a().a(paramString.uin, paramString.getType());
            break;
            label1678:
            paramString = (String)localObject2;
            paramInt1 = j;
            if (!azwu.a())
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
                  paramString.a(paramQQAppInterface, BaseApplication.getContext());
                  paramInt1 = i;
                  continue;
                  label1752:
                  if (i == 1012)
                  {
                    paramString = (apdq)paramQQAppInterface.getManager(71);
                    if (paramString == null) {
                      break label2463;
                    }
                    paramInt1 = paramString.a().a();
                    paramString = paramString.a().a();
                    break label2625;
                  }
                  if (i == 1030)
                  {
                    paramString = (String)localObject2;
                    paramInt1 = j;
                    if (paramQQAppInterface.a(240))
                    {
                      paramString = (anxa)paramQQAppInterface.getManager(240);
                      paramInt1 = paramString.a();
                      paramString = paramString.a();
                    }
                  }
                  else
                  {
                    if (i != 9653) {
                      break label2628;
                    }
                    paramString = (atvp)paramQQAppInterface.getManager(145);
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
    label2375:
    for (;;)
    {
      label1873:
      paramString = (String)localObject2;
      paramInt1 = j;
      if (!paramQQAppInterface.a(284)) {
        break label1304;
      }
      paramString = (atvq)paramQQAppInterface.getManager(284);
      paramInt1 = 1;
      paramString = paramString.a();
      break label1304;
      label2021:
      do
      {
        localObject3 = localamjk.a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject3 == null) {
          break label1304;
        }
        ((RecentUser)localObject3).lastmsgtime = ayvc.a();
        localObject2 = ajdp.a((RecentUser)localObject3, paramQQAppInterface, paramQQAppInterface.getApp());
        paramString = (String)localObject2;
        paramInt1 = j;
        if (i != 8) {
          break label1304;
        }
        localObject1 = paramQQAppInterface.a().a().a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject1 == null) {
          break label1304;
        }
        ((RecentBaseData)localObject2).mExtraType = ((QCallRecent)localObject1).extraType;
        ((RecentBaseData)localObject2).mPhoneNumber = ((QCallRecent)localObject1).phoneNumber;
        paramString = (String)localObject2;
        paramInt1 = j;
        break label1304;
        if ((((RecentBaseData)localObject2).a().equals(paramString.a())) && (((RecentBaseData)localObject2).a() == paramString.a()))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.a() + paramString.a());
          break label1443;
        }
        if ((paramString.a().equals(aljq.H)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.a() + paramString.a());
          break label1443;
        }
        if ((paramString.a().equals(aljq.aq)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.a() + paramString.a());
          break label1443;
        }
        if ((paramString.a().equals(aljq.ab)) && (((RecentBaseData)localObject2).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.a() + paramString.a());
          break label1443;
        }
        if ((!paramString.a().equals(aljq.D)) || (!((RecentBaseData)localObject2).a().equals(paramString.a()))) {
          break label1358;
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString.a() + paramString.a());
        break label1443;
        if ((!paramBoolean1) || (paramString == null) || (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString))) {
          break label1492;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        if (!paramBoolean2) {
          break label1492;
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.a() + paramString.a(), Integer.valueOf(paramInt2));
        break label1492;
        return false;
        paramString = null;
        paramInt1 = 0;
        break label2625;
        j = 0;
        break label701;
        paramInt1 = 0;
        break label2594;
        paramString = null;
        break label485;
        localObject1 = paramString;
        i = paramInt1;
        break label348;
        break;
        if ((paramString != null) || (i == 1012) || (i == 7432) || (i == 9653) || (i == 1030) || (i == 1035) || (i == 1041) || (i == 1042) || (i == 1044)) {
          break label547;
        }
        if (i != 1045) {
          break label546;
        }
        break label547;
        if (j > 0) {
          break label555;
        }
        break label779;
        break label555;
        break label485;
        bool = false;
        break label513;
        break label637;
        break label637;
        bool = false;
        break label731;
        if (i == 1044) {
          break label1678;
        }
        if (i != 1045) {
          break label1752;
        }
        break label1678;
        break label1304;
        if ((i == 1035) || (i == 1041)) {
          break label1873;
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
    if (this.jdField_a_of_type_Altc != null) {
      this.jdField_a_of_type_Altc = null;
    }
    if (this.jdField_a_of_type_Awwg != null) {
      this.jdField_a_of_type_Awwg = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof avqe)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
      }
      if (bdhy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
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
          i = ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).d();
        } while ((TextUtils.isEmpty(((avqe)paramObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) || (((avqe)paramObject).a == 0L));
        if ((i != 0) && (!f)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + f);
      return;
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694136), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719346), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aljq.D, 4000, false, atvo.a(aljq.D, 4000, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvs
 * JD-Core Version:    0.7.0.1
 */