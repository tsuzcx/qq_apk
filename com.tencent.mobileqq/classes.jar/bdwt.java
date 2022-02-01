import QQService.BindUin;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.System;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SubAccountBaseActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.subaccount.SubAccountControll.4;
import com.tencent.mobileqq.subaccount.SubAccountControll.5;
import com.tencent.mobileqq.subaccount.SubAccountControll.6;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class bdwt
  implements Manager
{
  public static long a;
  public static String a;
  public QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new SubAccountControll.4(this);
  private ArrayList<bhpc> jdField_a_of_type_JavaUtilArrayList;
  Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public boolean a;
  public long b;
  Runnable jdField_b_of_type_JavaLangRunnable = new SubAccountControll.5(this);
  private ArrayList<Pair<String, Integer>> jdField_b_of_type_JavaUtilArrayList;
  Lock jdField_b_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private boolean jdField_b_of_type_Boolean = true;
  public long c;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  private ArrayList<bdwx> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private long d = 300L;
  private long e = 300L;
  
  static
  {
    jdField_a_of_type_Long = 600L;
    jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  }
  
  public bdwt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Long = 600L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    try
    {
      str = Settings.System.getString(BaseApplication.getContext().getContentResolver(), "date_format");
      if (!TextUtils.isEmpty(str)) {
        jdField_a_of_type_JavaLangString = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "subaccountMsgFreq");
          if ((str != null) && (!TextUtils.isEmpty(str)))
          {
            this.d = Long.parseLong(str);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "init msgDelayTime = " + this.d);
            }
          }
          int i = a(paramQQAppInterface.c() + "_unread_msg_num_interval");
          if (i != 0) {
            a(i);
          }
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int j;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c())))
    {
      j = 0;
      return j;
    }
    bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    if (localbdwt != null) {}
    for (int i = localbdwt.a(paramQQAppInterface.c() + "_all_third_last_msg_time");; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getAllThirdQQMsgUnreadLastTime() lastTime=" + i);
      }
      long l = bcrg.a();
      j = i;
      if (i <= l) {
        break;
      }
      i = (int)l;
      a(paramQQAppInterface, i);
      return i;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, adab paramadab)
  {
    int i;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (paramadab == null))
    {
      i = 0;
      return i;
    }
    bdxc localbdxc = (bdxc)paramQQAppInterface.getManager(61);
    Object localObject;
    if (localbdxc != null)
    {
      Iterator localIterator = localbdxc.b().iterator();
      i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label191;
      }
      localObject = (SubAccountInfo)localIterator.next();
      if ((localObject == null) || (TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)) || (localbdxc.a(((SubAccountInfo)localObject).subuin) != 1)) {
        break label238;
      }
    }
    label179:
    label191:
    label238:
    for (int j = paramadab.a(((SubAccountInfo)localObject).subuin, 7000);; j = 0)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("getAllSubAccountMsgUnreadNum() subuin=");
        if (localObject != null) {
          break label179;
        }
      }
      for (localObject = Integer.valueOf(0);; localObject = ((SubAccountInfo)localObject).subuin)
      {
        QLog.d("SUB_ACCOUNT", 2, localObject + " num=" + j);
        i += j;
        break;
      }
      j = 0;
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "getAllSubAccountMsgUnreadNum() currentUin=" + paramQQAppInterface.c() + " allNum=" + j);
      return j;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramQQAppInterface.c()))) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
      if (localbdwt == null) {
        break;
      }
      j = localbdwt.a(paramQQAppInterface.c() + "_" + paramString + "_msgNum");
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getLocalThirdUnreadMsgNum() currentUin=" + paramQQAppInterface.c() + " thirdUin=" + paramString + " num=" + j);
    return j;
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int j;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString1)) || (!TextUtils.equals(paramString1, paramQQAppInterface.c())))
    {
      j = 0;
      return j;
    }
    paramQQAppInterface = (bdwt)paramQQAppInterface.getManager(62);
    if (paramQQAppInterface != null) {}
    for (int i = paramQQAppInterface.a(paramString1 + "_" + paramString2 + "_spcares_sysTime");; i = 0)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "getReqSubAccountSpecialCareListSysTime mainUin=" + paramString1 + " subUin=" + paramString2 + " sysTime=" + i);
      return i;
    }
  }
  
  private int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {
      return 0;
    }
    this.jdField_b_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = a(paramString);
      int i;
      if (localObject != null)
      {
        i = ((Integer)((bdwx)localObject).jdField_a_of_type_JavaLangObject).intValue();
        return i;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
      if (localObject != null)
      {
        i = ((SharedPreferences)localObject).getInt(paramString, 0);
        if (this.jdField_c_of_type_JavaUtilArrayList != null) {
          this.jdField_c_of_type_JavaUtilArrayList.add(new bdwx(paramString, Integer.valueOf(i)));
        }
        return i;
      }
      return 0;
    }
    finally
    {
      this.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private bdwx a(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilArrayList != null) {
      try
      {
        int j = this.jdField_c_of_type_JavaUtilArrayList.size();
        int i = 0;
        while (i < j)
        {
          if (i < this.jdField_c_of_type_JavaUtilArrayList.size()) {}
          for (bdwx localbdwx = (bdwx)this.jdField_c_of_type_JavaUtilArrayList.get(i); localbdwx != null; localbdwx = null)
          {
            boolean bool = TextUtils.equals(localbdwx.jdField_a_of_type_JavaLangString, paramString);
            if (!bool) {
              break;
            }
            return localbdwx;
          }
          i += 1;
        }
        return null;
      }
      catch (Exception paramString)
      {
        QLog.i("SUB_ACCOUNT", 1, " findAssociatedQQCacheItemByKey error: " + paramString.getMessage());
      }
    }
  }
  
  public static bdwy a(QQAppInterface paramQQAppInterface, String paramString)
  {
    bdwy localbdwy = new bdwy();
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return localbdwy;
    }
    paramQQAppInterface = (bdxc)paramQQAppInterface.getManager(61);
    int i = paramQQAppInterface.c(paramString);
    if (i > 0)
    {
      localbdwy.jdField_a_of_type_Int = i;
      return localbdwy;
    }
    arjg localarjg = (arjg)aran.a().a(607);
    if ((localarjg == null) || (localarjg.jdField_a_of_type_Boolean)) {
      return localbdwy;
    }
    i = paramQQAppInterface.d(paramString);
    if (i > 0)
    {
      localbdwy.jdField_a_of_type_Int = i;
      localbdwy.jdField_a_of_type_Boolean = true;
    }
    return localbdwy;
  }
  
  public static Pair<Boolean, Boolean> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool4 = false;
    Object localObject;
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("checkSubAccountLoginStatus() app is null?=>");
        if (paramQQAppInterface != null) {
          break label96;
        }
        bool1 = true;
        paramQQAppInterface = ((StringBuilder)localObject).append(bool1).append(" subUin is null?=>");
        if (paramString != null) {
          break label101;
        }
      }
      label96:
      label101:
      for (bool1 = bool2;; bool1 = false)
      {
        QLog.d("SUB_ACCOUNT", 2, bool1);
        return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        bool1 = false;
        break;
      }
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getAllAccounts();
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("checkSubAccountLoginStatus() app.getAllAccounts() is null? =>");
        if (paramQQAppInterface != null) {
          break label181;
        }
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, bool1);
        return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        label181:
        bool1 = false;
      }
    }
    int i = 0;
    if (i < paramQQAppInterface.size())
    {
      localObject = (SimpleAccount)paramQQAppInterface.get(i);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount == null");
        }
      }
      label263:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (((SimpleAccount)localObject).getUin() != null) {
            break label263;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount.getUin() == null");
          }
        }
      } while (!((SimpleAccount)localObject).getUin().equalsIgnoreCase(paramString));
      bool1 = bool3;
      bool2 = bool4;
      if (((SimpleAccount)localObject).isLogined())
      {
        bool2 = true;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() hasAccount=" + bool1 + " isLogin=" + bool2);
      }
      return new Pair(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      bool1 = false;
      bool2 = bool4;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, SimpleAccount paramSimpleAccount)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c())) || (paramSimpleAccount == null)) {
      paramSimpleAccount = "";
    }
    do
    {
      return paramSimpleAccount;
      String str2 = a(paramQQAppInterface, paramSimpleAccount.getUin());
      String str1 = str2;
      if (paramSimpleAccount.isLogined()) {
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (!str2.equals(paramSimpleAccount.getUin())) {}
        }
        else
        {
          str1 = b(paramQQAppInterface, paramSimpleAccount.getUin());
        }
      }
      paramQQAppInterface = str1;
      if (TextUtils.isEmpty(str1)) {
        paramQQAppInterface = paramSimpleAccount.getUin();
      }
      paramSimpleAccount = paramQQAppInterface;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getShowName() showName=" + paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = null;
    }
    label91:
    label94:
    for (;;)
    {
      return paramString;
      String str = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
      if (TextUtils.isEmpty(str))
      {
        paramQQAppInterface = (anyw)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = localObject;
          if (paramQQAppInterface == null) {
            break label91;
          }
        }
      }
      for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = str)
      {
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label94;
        }
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.b(paramString);
        break;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramString1 = null;
    Object localObject = null;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    if (SystemMsg.isSystemMessage(paramInt)) {
      switch (paramInt)
      {
      default: 
        paramString1 = localObject;
      }
    }
    for (;;)
    {
      paramQQAppInterface = bhlg.b(paramQQAppInterface, paramString2, true);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramString2))) {
        break;
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramQQAppInterface).append(paramString1);
      paramString1 = paramString2.toString();
      return paramString1;
      paramString1 = localBaseApplication.getString(2131689584);
      continue;
      paramString1 = localBaseApplication.getString(2131689498);
      continue;
      paramString1 = localBaseApplication.getString(2131689497);
      continue;
      paramString1 = localBaseApplication.getString(2131717421);
      continue;
      paramString1 = localBaseApplication.getString(2131689621);
    }
    return paramString2 + paramString1;
  }
  
  private String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {
      return "";
    }
    this.jdField_b_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Object localObject = a(paramString);
      if (localObject != null)
      {
        paramString = (String)((bdwx)localObject).jdField_a_of_type_JavaLangObject;
        return paramString;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).getString(paramString, "");
        if (this.jdField_c_of_type_JavaUtilArrayList != null) {
          this.jdField_c_of_type_JavaUtilArrayList.add(new bdwx(paramString, localObject));
        }
        return localObject;
      }
      return "";
    }
    finally
    {
      this.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public static ArrayList<String> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c())) || (TextUtils.isEmpty(paramString))) {
      return localArrayList;
    }
    bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    if (localbdwt != null)
    {
      paramString = paramQQAppInterface.c() + "_" + paramString + "_spcares";
      localbdwt.jdField_b_of_type_JavaUtilConcurrentLocksLock.lock();
    }
    for (;;)
    {
      try
      {
        bdwx localbdwx = localbdwt.a(paramString);
        if (localbdwx != null)
        {
          localArrayList.addAll((ArrayList)localbdwx.jdField_a_of_type_JavaLangObject);
          localbdwt.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareList  list=" + localArrayList);
          }
          return localArrayList;
        }
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0).getString(paramString, "").split(";");
        if ((paramQQAppInterface != null) && (i < paramQQAppInterface.length))
        {
          if ((!TextUtils.isEmpty(paramQQAppInterface[i])) && (!TextUtils.equals("0", paramQQAppInterface[i]))) {
            localArrayList.add(paramQQAppInterface[i]);
          }
        }
        else
        {
          localbdwt.jdField_c_of_type_JavaUtilArrayList.add(new bdwx(paramString, localArrayList));
          continue;
        }
        i += 1;
      }
      finally
      {
        localbdwt.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt > 86400L)
    {
      this.e = 86400L;
      return;
    }
    if (paramInt < 60L)
    {
      this.e = 60L;
      return;
    }
    this.e = paramInt;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() return, app == null");
      }
    }
    label428:
    label474:
    do
    {
      do
      {
        return;
        localObject2 = (bdxc)paramQQAppInterface.getManager(61);
      } while (localObject2 == null);
      long l1 = bhlk.a().a(paramQQAppInterface.getApp());
      long l2 = arta.a(paramQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData()..start, historyVersion=" + l1 + " thisApkVersion=" + l2);
      }
      boolean bool;
      Object localObject1;
      SubAccountInfo localSubAccountInfo;
      if (l1 < l2)
      {
        if (l1 == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() need to update (v5.0 or lower) data");
          }
          bool = bhlk.a().a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
          localObject1 = ((bdxc)localObject2).a("sub.uin.default");
          if ((localObject1 != null) && (((SubAccountInfo)localObject1).subuin != null))
          {
            ((bdxc)localObject2).h(((SubAccountInfo)localObject1).subuin);
            i = ((bdxc)localObject2).c(((SubAccountInfo)localObject1).subuin) - paramQQAppInterface.a().a(((SubAccountInfo)localObject1).subuin, 7000);
            if (i != 0)
            {
              paramQQAppInterface.a().d(((SubAccountInfo)localObject1).subuin, 7000, i);
              paramQQAppInterface.a().a(new String[] { antf.x, ((SubAccountInfo)localObject1).subuin });
            }
            if (bool)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "initAllData(), setTopInRecentList, isTop=" + bool);
              }
              a(paramQQAppInterface, ((SubAccountInfo)localObject1).subuin, true);
            }
          }
          bhlk.a().a(paramQQAppInterface.getApp());
        }
      }
      else
      {
        if (!bhlk.a().b(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() showedBefore:false, isFirstTime to user SubAccount.");
          }
          bhlk.a().a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), true);
          a(paramQQAppInterface, 7);
        }
        localObject1 = paramQQAppInterface.a().a();
        localObject3 = (RecentUser)((apaw)localObject1).findRecentUser(antf.x, 7000);
        if (((bdxc)localObject2).a() <= 0) {
          break label791;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "initAllData() getBindedNumber > 0, go to initAllData");
        }
        localObject4 = ((bdxc)localObject2).b();
        int k = ((ArrayList)localObject4).size();
        i = 0;
        if (i >= k) {
          break label791;
        }
        localSubAccountInfo = (SubAccountInfo)((ArrayList)localObject4).get(i);
        if (localSubAccountInfo != null) {
          break label474;
        }
      }
      for (;;)
      {
        i += 1;
        break label428;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "initAllData() (v5.1 or later) update..");
        break;
        if ((localObject3 != null) && (QLog.isColorLevel())) {
          QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() delete defaultRU:" + ((RecentUser)localObject3).uin + " type=" + ((RecentUser)localObject3).getType());
        }
        if ((localObject3 != null) && (l1 == 0L))
        {
          a(paramQQAppInterface, localSubAccountInfo.subuin, 7);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() add RU:" + localSubAccountInfo.subuin);
          }
          int m = paramQQAppInterface.a().a(localSubAccountInfo.subuin, 7000);
          j = 0;
          if (localObject2 != null) {
            j = ((bdxc)localObject2).c(localSubAccountInfo.subuin);
          }
          int n = j - m;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() setReaded subaccount,old:" + m + " target:" + j + " increase:" + n);
          }
          if (n != 0)
          {
            paramQQAppInterface.a().d(localSubAccountInfo.subuin, 7000, n);
            paramQQAppInterface.a().a(new String[] { antf.x, localSubAccountInfo.subuin });
          }
        }
        bool = false;
        Pair localPair = a(paramQQAppInterface, localSubAccountInfo.subuin);
        if (localPair != null) {
          bool = ((Boolean)localPair.second).booleanValue();
        }
        if (bool) {
          paramQQAppInterface.getSubAccountKey(paramQQAppInterface.getAccount(), localSubAccountInfo.subuin, new bdwu(paramQQAppInterface));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() delete subaccount recentuser, add default subaccount box");
      }
      Object localObject2 = ((bdxc)localObject2).b();
      int j = ((ArrayList)localObject2).size();
      int i = 0;
      if (i < j)
      {
        localObject3 = (SubAccountInfo)((ArrayList)localObject2).get(i);
        if ((localObject3 == null) || (antf.x.equals(((SubAccountInfo)localObject3).subuin))) {}
        for (;;)
        {
          i += 1;
          break;
          localObject3 = (RecentUser)((apaw)localObject1).findRecentUser(((SubAccountInfo)localObject3).subuin, 7000);
          if (localObject3 != null) {
            ((apaw)localObject1).delRecentUser((BaseRecentUser)localObject3);
          }
        }
      }
      localObject2 = (RecentUser)((apaw)localObject1).findRecentUser(antf.x, 7000);
      Object localObject3 = paramQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
      Object localObject4 = paramQQAppInterface.getAccount() + "_initDataTimes";
      i = ((SharedPreferences)localObject3).getInt((String)localObject4, 0);
      if (((localObject2 == null) && (i == 0)) || ((localObject2 != null) && (i < 3)))
      {
        a(paramQQAppInterface, (apaw)localObject1, antf.x, 7);
        ((SharedPreferences)localObject3).edit().putInt((String)localObject4, i + 1).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() end");
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    } while (paramQQAppInterface == null);
    label791:
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() subUin=" + paramString + " cmd=" + paramByte);
    }
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramQQAppInterface, paramByte, localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte paramByte, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("setBindUinStatus() return, listSubUin:");
        if (paramArrayList != null) {
          break label56;
        }
        paramQQAppInterface = "null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    label56:
    do
    {
      return;
      paramQQAppInterface = "size=0";
      break;
      if ((paramByte == 0) || (paramByte == 1)) {
        break label105;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, cmd=" + paramByte);
    return;
    label105:
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    label120:
    if (localIterator.hasNext()) {}
    for (paramArrayList = (String)localIterator.next();; paramArrayList = null)
    {
      try
      {
        l1 = Long.parseLong(paramArrayList);
        if ((l1 == 0L) || (l1 <= 10000L)) {
          break label120;
        }
        long l2 = 21L;
        if (paramByte == 1) {
          l2 = paramQQAppInterface.getApp().getSharedPreferences("acc_info" + paramArrayList, 0).getLong("getProfileStatusNew", 11L);
        }
        Object localObject2 = (bdxc)paramQQAppInterface.getManager(61);
        if (localObject2 == null) {
          continue;
        }
        paramArrayList = ((bdxc)localObject2).a(paramArrayList);
        if (paramArrayList == null)
        {
          paramArrayList = new byte[0];
          localObject2 = new BindUin();
          ((BindUin)localObject2).lUin = l1;
          ((BindUin)localObject2).iStatus = ((int)l2);
          ((BindUin)localObject2).sKey = paramArrayList;
          ((ArrayList)localObject1).add(localObject2);
          if (!QLog.isColorLevel()) {
            break label120;
          }
          localObject2 = new StringBuilder().append("setBindUinStatus() add<QQService.BindUin>:lUin=").append(l1).append(" cmd=").append(paramByte).append(" status=").append(l2).append(" sKey=");
          if (paramArrayList != null) {
            break label377;
          }
          paramArrayList = "null";
          QLog.d("SUB_ACCOUNT", 2, paramArrayList);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          long l1 = 0L;
          continue;
          paramArrayList = bhml.a(paramArrayList);
          continue;
          label377:
          paramArrayList = Integer.valueOf(paramArrayList.length);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.a(paramByte, (ArrayList)localObject1);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, ArrayList<QQService.BindUin> list.size=0");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unbindAllRecentitem() defAct=" + paramInt);
    }
    apaw localapaw = paramQQAppInterface.a().a();
    Object localObject = localapaw.getRecentList(false);
    int i = paramInt;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        i = paramInt;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((localRecentUser != null) && (localRecentUser.getType() == 7000) && (!antf.x.equals(localRecentUser.uin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "RecentUserProxy.deleteRecentUserByType, uin=" + localRecentUser.uin + " type=" + localRecentUser.getType());
          }
          paramQQAppInterface.a().c(localRecentUser.uin, localRecentUser.getType());
          localapaw.delRecentUser(localRecentUser);
          paramInt = 7;
        }
      }
    }
    a(paramQQAppInterface, localapaw, antf.x, i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, RecentItemSubAccount paramRecentItemSubAccount, MsgSummary paramMsgSummary)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (paramRecentItemSubAccount == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() params error");
      }
    }
    bdxc localbdxc;
    do
    {
      return;
      localbdxc = (bdxc)paramQQAppInterface.getManager(61);
      if (localbdxc != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() subMgr == null");
    return;
    ArrayList localArrayList = localbdxc.b();
    Object localObject1 = new ArrayList();
    Object localObject3 = paramQQAppInterface.getApplication().getAllAccounts();
    if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
      ((List)localObject1).addAll((Collection)localObject3);
    }
    paramRecentItemSubAccount.mMsgExtroInfo = "";
    if ((localArrayList.size() == 0) && (((List)localObject1).size() <= 1))
    {
      paramMsgSummary.strContent = paramContext.getString(2131718430);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() no sub & other account");
      }
      paramRecentItemSubAccount.showSubUin = null;
      return;
    }
    long l = 0L;
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (SubAccountInfo)((Iterator)localObject1).next();
      if ((localObject3 != null) && (l < ((SubAccountInfo)localObject3).lasttime)) {
        l = ((SubAccountInfo)localObject3).lasttime;
      }
    }
    a(paramQQAppInterface);
    adab localadab = paramQQAppInterface.a();
    int k = a(paramQQAppInterface, localadab);
    int m = b(paramQQAppInterface, localadab);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subUnreadNum=" + k + " subTroopUnreadNum=" + m);
    }
    Object localObject5 = null;
    localObject3 = null;
    Object localObject4 = null;
    localObject1 = null;
    int j = 0;
    int i = 0;
    for (;;)
    {
      SubAccountInfo localSubAccountInfo;
      try
      {
        Iterator localIterator = localArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label1391;
        }
        localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if ((localSubAccountInfo == null) || (TextUtils.isEmpty(localSubAccountInfo.subuin)) || (localbdxc.a(localSubAccountInfo.subuin) != 1)) {
          continue;
        }
        localObject8 = localbdxc.a(localSubAccountInfo.subuin);
        localObject9 = localObject4;
        localObject10 = localObject5;
        localObject11 = localObject1;
        localObject12 = localObject3;
        if (localObject8 != null)
        {
          localObject9 = localObject4;
          localObject10 = localObject5;
          localObject11 = localObject1;
          localObject12 = localObject3;
          if (((List)localObject8).size() > 0)
          {
            localObject7 = (SubAccountMessage)((List)localObject8).get(0);
            localObject6 = null;
            if (!antf.aD.equals(((SubAccountMessage)localObject7).senderuin)) {
              break label1381;
            }
            localObject9 = localObject7;
            if (((List)localObject8).size() > 1)
            {
              localObject6 = (SubAccountMessage)((List)localObject8).get(1);
              localObject9 = localObject7;
            }
            if (localObject3 == null) {
              break label1332;
            }
            localObject7 = localObject5;
            localObject8 = localObject3;
            if (localObject9 != null)
            {
              localObject7 = localObject5;
              localObject8 = localObject3;
              if (((SubAccountMessage)localObject3).time < ((SubAccountMessage)localObject9).time) {
                break label1332;
              }
            }
            if (localObject1 == null) {
              break label1343;
            }
            localObject9 = localObject4;
            localObject10 = localObject7;
            localObject11 = localObject1;
            localObject12 = localObject8;
            if (localObject6 != null)
            {
              localObject9 = localObject4;
              localObject10 = localObject7;
              localObject11 = localObject1;
              localObject12 = localObject8;
              if (((SubAccountMessage)localObject1).time < ((SubAccountMessage)localObject6).time) {
                break label1343;
              }
            }
          }
        }
        localObject1 = a(paramQQAppInterface, localSubAccountInfo.subuin);
        if (((bdwy)localObject1).jdField_a_of_type_Boolean)
        {
          i = ((bdwy)localObject1).jdField_a_of_type_Int + i;
          break label1362;
        }
        j = ((bdwy)localObject1).jdField_a_of_type_Int + j;
        break label1362;
        if ((localObject1 != null) && (localObject3 != null))
        {
          paramMsgSummary.strContent = paramContext.getString(2131718392);
          paramRecentItemSubAccount.mUnreadNum = 0;
          paramRecentItemSubAccount.mUnreadFlag = 0;
          paramRecentItemSubAccount.showSubUin = null;
          localObject6 = new SpannableStringBuilder();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() subUin=" + ((SubAccountInfo)localObject1).subuin + " mMsgExtroInfo=" + paramRecentItemSubAccount.mMsgExtroInfo);
          }
          localObject4 = (arjg)aran.a().a(607);
          if ((j <= 0) && ((j != 0) || (i != 0))) {
            continue;
          }
          localObject5 = ((SubAccountMessage)localObject3).frienduin;
          localObject4 = ((SubAccountMessage)localObject3).sendername;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            continue;
          }
          ((SpannableStringBuilder)localObject6).append((CharSequence)localObject4);
          ((SpannableStringBuilder)localObject6).append(": ");
          if (((((SubAccountMessage)localObject3).mEmoRecentMsg == null) || (((SubAccountMessage)localObject3).mEmoRecentMsg.length() == 0)) && (((SubAccountMessage)localObject3).msg != null)) {
            ((SubAccountMessage)localObject3).mEmoRecentMsg = new begp(((SubAccountMessage)localObject3).msg, 3, 16);
          }
          ((SpannableStringBuilder)localObject6).append(((SubAccountMessage)localObject3).mEmoRecentMsg);
          if (((SubAccountMessage)localObject3).isread) {
            continue;
          }
          if (!a(paramQQAppInterface, ((SubAccountInfo)localObject1).subuin).contains(((SubAccountMessage)localObject3).senderuin)) {
            continue;
          }
          paramRecentItemSubAccount.mMsgExtroInfo = ("[" + paramContext.getString(2131716142) + "]");
          paramMsgSummary.strContent = ((CharSequence)localObject6);
          paramRecentItemSubAccount.showSubUin = ((SubAccountInfo)localObject1).subuin;
          paramRecentItemSubAccount.mUnreadNum = k;
          paramRecentItemSubAccount.mUnreadFlag = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SUB_ACCOUNT", 1, localThrowable, new Object[0]);
        if ((k > 0) && (localadab != null))
        {
          localObject2 = localArrayList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
            if ((localObject3 == null) || (TextUtils.isEmpty(((SubAccountInfo)localObject3).subuin))) {
              continue;
            }
            i = localadab.a(((SubAccountInfo)localObject3).subuin, 7000);
            if (i > 0)
            {
              localObject4 = paramQQAppInterface.a();
              if (localObject4 != null) {
                ((QQMessageFacade)localObject4).a(((SubAccountInfo)localObject3).subuin, 7000, true, false);
              }
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountContentAndUnread some error clean unread subuin= " + ((SubAccountInfo)localObject3).subuin + "  num=" + i);
            continue;
            if ((j == 0) && (i > 0))
            {
              localObject2 = localObject5;
              continue;
            }
            if ((j != 0) || (i != 0)) {
              break label1323;
            }
            localObject3 = localObject2;
            localObject2 = localObject4;
            continue;
            localObject4 = localObject5;
            if (localObject5 == null) {
              localObject4 = "";
            }
            ((SpannableStringBuilder)localObject6).append((CharSequence)localObject4);
            ((SpannableStringBuilder)localObject6).append(": ");
            continue;
            if ("RED_PACKET".equals(((SubAccountMessage)localObject3).subExtr))
            {
              paramRecentItemSubAccount.mMsgExtroInfo = ((CharSequence)localObject6);
              continue;
            }
            paramMsgSummary.strContent = ((CharSequence)localObject6);
            continue;
            paramMsgSummary.strContent = ((CharSequence)localObject6);
            continue;
            if ((i <= 0) || (localObject4 == null) || (((arjg)localObject4).jdField_a_of_type_Boolean)) {
              break;
            }
            paramMsgSummary.strContent = "有新的群消息";
            paramRecentItemSubAccount.showSubUin = ((SubAccountInfo)localObject2).subuin;
            paramRecentItemSubAccount.mUnreadNum = m;
            paramRecentItemSubAccount.mUnreadFlag = 2;
            return;
          }
        }
        paramRecentItemSubAccount.showSubUin = null;
        paramRecentItemSubAccount.mUnreadNum = 0;
        paramRecentItemSubAccount.mUnreadFlag = 0;
        paramMsgSummary.strContent = paramContext.getString(2131718392);
        return;
      }
      label1323:
      localObject3 = null;
      Object localObject2 = null;
      continue;
      label1332:
      Object localObject8 = localObject9;
      Object localObject7 = localSubAccountInfo;
      continue;
      label1343:
      Object localObject9 = localSubAccountInfo;
      Object localObject10 = localObject7;
      Object localObject11 = localObject6;
      Object localObject12 = localObject8;
      continue;
      label1362:
      localObject4 = localObject9;
      localObject5 = localObject10;
      localObject2 = localObject11;
      localObject3 = localObject12;
      continue;
      label1381:
      Object localObject6 = localObject7;
      localObject9 = null;
      continue;
      label1391:
      if (j > 0)
      {
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, apaw paramapaw, String paramString, int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() subUin=" + paramString + " actionType=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramInt == 0)) {
      if (QLog.isColorLevel())
      {
        paramapaw = new StringBuilder().append("updateRecentUser() return,");
        if (paramString != null) {
          break label103;
        }
        paramQQAppInterface = "subUin==null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    label103:
    do
    {
      do
      {
        return;
        paramQQAppInterface = "subUin.len=0 action=" + paramInt;
        break;
        if (paramapaw != null) {
          break label147;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() return, ruProxy==null");
      return;
      if (!antf.x.equals(paramString))
      {
        localRecentUser = (RecentUser)paramapaw.findRecentUser(paramString, 7000);
        if (localRecentUser != null) {
          paramapaw.delRecentUser(localRecentUser);
        }
      }
      localRecentUser = (RecentUser)paramapaw.findRecentUser(antf.x, 7000);
      if (localRecentUser != null) {
        break label661;
      }
    } while ((paramInt == 5) || (paramInt == 0));
    label147:
    RecentUser localRecentUser = new RecentUser();
    localRecentUser.setType(7000);
    label658:
    label661:
    for (;;)
    {
      localRecentUser.uin = antf.x;
      long l1;
      long l2;
      if (antf.x.equals(paramString))
      {
        paramQQAppInterface = (bdxc)paramQQAppInterface.getManager(61);
        paramString = paramQQAppInterface.a().iterator();
        l1 = 0L;
        while (paramString.hasNext())
        {
          l2 = paramQQAppInterface.a((String)paramString.next());
          if (l1 < l2) {
            l1 = l2;
          }
        }
        if (l1 > 0L) {
          break label658;
        }
        l1 = bcrg.a();
      }
      for (;;)
      {
        switch (paramInt)
        {
        case 3: 
        default: 
          paramInt = 0;
        }
        while (paramInt != 0)
        {
          paramapaw.saveRecentUser(localRecentUser);
          return;
          if (paramInt == 7) {
            l1 = bcrg.a();
          }
          localRecentUser.lastmsgtime = l1;
          paramInt = 1;
          continue;
          localRecentUser.lastmsgtime = l1;
          localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
          paramInt = 1;
          continue;
          localRecentUser.showUpTime = 0L;
          paramInt = 1;
          continue;
          paramQQAppInterface = (bdxc)paramQQAppInterface.getManager(61);
          l2 = paramQQAppInterface.a(paramString);
          l1 = l2;
          if (l2 <= 0L) {
            l1 = bcrg.a();
          }
          switch (paramInt)
          {
          case 3: 
          default: 
            paramInt = 0;
            break;
          case 1: 
          case 2: 
          case 6: 
          case 7: 
            l2 = bcrg.a();
            ArrayList localArrayList = (ArrayList)paramQQAppInterface.a.get(paramString);
            l1 = l2;
            if (paramInt == 6)
            {
              l1 = l2;
              if (localArrayList != null)
              {
                l1 = l2;
                if (localArrayList.size() != 0) {
                  l1 = ((SubAccountMessage)localArrayList.get(0)).time;
                }
              }
            }
            paramQQAppInterface.a(paramString, l1);
            paramInt = i;
            if (localRecentUser.lastmsgtime < l1)
            {
              localRecentUser.lastmsgtime = l1;
              paramInt = i;
            }
            break;
          case 5: 
            if (localRecentUser.lastmsgtime < l1) {
              localRecentUser.lastmsgtime = l1;
            }
            localRecentUser.showUpTime = 0L;
            paramInt = i;
            break;
          case 4: 
            localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
            paramInt = i;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("showMaxHintDialog() actCaller=");
      if (paramBaseActivity != null) {
        break label47;
      }
    }
    label47:
    for (Object localObject1 = "null";; localObject1 = paramBaseActivity.getClass().getSimpleName())
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      if (paramBaseActivity != null) {
        break;
      }
      return;
    }
    localObject1 = paramBaseActivity.getString(2131718434);
    Object localObject2 = paramBaseActivity.getString(2131718410, new Object[] { Integer.valueOf(2) });
    localObject1 = bhlq.a(paramBaseActivity, 230).setTitle((String)localObject1).setMessage((CharSequence)localObject2);
    ((bhpc)localObject1).setOwnerActivity(paramBaseActivity);
    ((bhpc)localObject1).setPositiveButton(paramBaseActivity.getString(2131718422), new bdww(paramQQAppInterface, paramBaseActivity));
    ((bhpc)localObject1).setCancelable(false);
    ((bhpc)localObject1).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearAllData() subUin=" + paramString);
    }
    if ("sub.uin.all".equals(paramString))
    {
      paramString = (bdxc)paramQQAppInterface.getManager(61);
      if (paramString == null) {
        break label183;
      }
    }
    label183:
    for (paramString = paramString.a();; paramString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "clearAllData() clear all_sub_uin. list=" + paramString);
      }
      if (paramString != null)
      {
        paramString = paramString.iterator();
        int i = 0;
        while (paramString.hasNext())
        {
          Object localObject = (String)paramString.next();
          if (!"sub.uin.all".equals(localObject))
          {
            i += 1;
            a(paramQQAppInterface, (String)localObject);
            continue;
            if (paramQQAppInterface != null)
            {
              localObject = (bdxc)paramQQAppInterface.getManager(61);
              if (localObject != null)
              {
                ((bdxc)localObject).a(paramString);
                ((bdxc)localObject).d(paramString);
                if (bhlg.c(paramQQAppInterface, paramString, false) != null) {
                  break;
                }
              }
            }
          }
        }
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() subUin=" + paramString + " actionType=" + paramInt);
    }
    if ((!antf.x.equals(paramString)) && ((paramString == null) || (paramString.length() < 5))) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() return, subUin==null || subUin.length()<5");
      }
    }
    do
    {
      return;
      apaw localapaw = paramQQAppInterface.a().a();
      if (((RecentUser)localapaw.findRecentUser(antf.x, 7000) != null) && (QLog.isColorLevel())) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
      }
      a(paramQQAppInterface, localapaw, paramString, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "storeSubAccountSpecialCare mainUin=" + paramString1 + " subUin=" + paramString2 + "  specialCareList=" + paramArrayList + " sysTime=" + paramInt1);
    }
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString1)) || (!TextUtils.equals(paramString1, paramQQAppInterface.c())) || (paramArrayList == null)) {}
    bdwt localbdwt;
    do
    {
      return;
      localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    } while (localbdwt == null);
    paramString1 = paramString1 + "_" + paramString2 + "_spcares";
    localbdwt.jdField_b_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        paramString2 = localbdwt.a(paramString1);
        if ((paramString2 != null) && (paramString2.jdField_a_of_type_JavaLangObject != null) && ((paramString2.jdField_a_of_type_JavaLangObject instanceof ArrayList)))
        {
          paramString2 = (ArrayList)paramString2.jdField_a_of_type_JavaLangObject;
          paramString2.clear();
          paramString2.addAll(paramArrayList);
          localbdwt.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
          paramString2 = new StringBuilder();
          int i = 0;
          if (i >= paramArrayList.size()) {
            break;
          }
          if (i > 0) {
            paramString2.append(";");
          }
          paramString2.append((String)paramArrayList.get(i));
          i += 1;
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(paramArrayList);
        if (paramString2 != null) {
          paramString2.jdField_a_of_type_JavaLangObject = localArrayList;
        } else {
          localbdwt.jdField_c_of_type_JavaUtilArrayList.add(new bdwx(paramString1, localArrayList));
        }
      }
      finally
      {
        localbdwt.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
    paramQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0).edit().putString(paramString1, paramString2.toString()).commit();
    localbdwt.a(paramString1 + "_sysTime", Integer.valueOf(paramInt1));
    localbdwt.jdField_b_of_type_Long = paramInt2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString2)) || (!TextUtils.equals(paramString1, paramQQAppInterface.c()))) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "storeThirdQQUnreadInfo mainAccount=" + paramString1 + " thirdUin=" + paramString2 + " msgNum=" + paramInt1 + " msgFlag=" + paramInt2 + " lastMsgTime=" + paramInt5);
        }
        paramString1 = (bdwt)paramQQAppInterface.getManager(62);
      } while (paramString1 == null);
      paramQQAppInterface = paramQQAppInterface.c() + "_" + paramString2;
      paramString2 = bhvd.a(paramArrayOfByte);
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.a(paramQQAppInterface + "_last_cookie", paramString2);
      }
      paramString1.a(paramQQAppInterface + "_msgNum", Integer.valueOf(paramInt1));
      paramString1.a(paramQQAppInterface + "_msgFlag", Integer.valueOf(paramInt2));
      paramString1.a(paramQQAppInterface + "_redBagTime", Integer.valueOf(paramInt3));
      paramString1.a(paramQQAppInterface + "_status", Integer.valueOf(paramInt4));
    } while (paramInt5 == 0);
    paramString1.a(paramQQAppInterface + "_lastMsgTime", Integer.valueOf(paramInt5));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("setSBTopInRecentList() return, ");
        if (paramQQAppInterface != null) {
          break label51;
        }
      }
      label51:
      for (paramQQAppInterface = "app==null";; paramQQAppInterface = "subUin==null")
      {
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
        return;
      }
    }
    if (antf.x.equals(paramString)) {
      if (paramBoolean) {
        a(paramQQAppInterface, paramQQAppInterface.a().a(), antf.x, 7);
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface.sendEmptyMessage(1009);
      return;
      ((bdxc)paramQQAppInterface.getManager(61)).a(paramString, paramBoolean);
      apaw localapaw = paramQQAppInterface.a().a();
      if (paramBoolean) {
        a(paramQQAppInterface, localapaw, paramString, 4);
      } else {
        a(paramQQAppInterface, localapaw, paramString, 5);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList<String> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() list=" + String.valueOf(paramArrayList) + " actionType=" + paramInt);
    }
    Object localObject;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("bindRecentItem() return, list=");
        if (paramArrayList != null) {
          break label99;
        }
        paramQQAppInterface = "null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    for (;;)
    {
      return;
      label99:
      paramQQAppInterface = Integer.valueOf(paramArrayList.size());
      break;
      localObject = paramQQAppInterface.a().a();
      if (((RecentUser)((apaw)localObject).findRecentUser(antf.x, 7000) != null) && (QLog.isColorLevel())) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        a(paramQQAppInterface, (apaw)localObject, str, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + str);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c()))) {}
    bdwt localbdwt;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setDisplayThirdQQChecked checked=" + paramBoolean);
      }
      localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    } while (localbdwt == null);
    localbdwt.a(paramQQAppInterface.c() + "_display_third_qq_checked", String.valueOf(paramBoolean));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {}
    for (;;)
    {
      return;
      bdxc localbdxc = (bdxc)paramQQAppInterface.getManager(61);
      paramQQAppInterface = (MessageHandler)paramQQAppInterface.a(0);
      if ((localbdxc != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = localbdxc.a().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!TextUtils.isEmpty(str))
          {
            int i = localbdxc.c(str);
            localbdxc.b(str);
            if ((paramBoolean) || (i > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "cleanAllSubAccountMessageUnread confirmSubAccountMsgNumReaded once subuin=" + str + " needConfirm=" + paramBoolean);
              }
              aote localaote = paramQQAppInterface.a();
              if (localaote != null) {
                localaote.a(str, paramString);
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {}
    label11:
    do
    {
      int i;
      do
      {
        bdxc localbdxc;
        do
        {
          break label11;
          do
          {
            return;
          } while (TextUtils.isEmpty(paramString2));
          localbdxc = (bdxc)paramQQAppInterface.getManager(61);
          paramQQAppInterface = (MessageHandler)paramQQAppInterface.a(0);
        } while ((localbdxc == null) || (paramQQAppInterface == null));
        i = localbdxc.c(paramString2);
        localbdxc.b(paramString2);
      } while ((!paramBoolean) && (i <= 0));
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "cleanAllSubAccountMessageUnread confirmSubAccountMsgNumReaded once subuin=" + paramString2 + " needConfirm=" + paramBoolean);
      }
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramString2, paramString1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (bdxc)paramQQAppInterface.getManager(61);
    if (paramQQAppInterface != null) {}
    for (int i = paramQQAppInterface.a();; i = 0)
    {
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "checkAccountBind, bindedNum=" + i + " ret=" + bool);
        }
        return bool;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c()))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateAllThirdQQMsgUnreadLastTime() lastMsgTime=" + paramInt);
    }
    bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    if (localbdwt != null) {
      return localbdwt.a(paramQQAppInterface.c() + "_all_third_last_msg_time", Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SimpleAccount paramSimpleAccount)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c())) || (paramSimpleAccount == null)) {
      return false;
    }
    bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    if (localbdwt == null) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.c();
    paramQQAppInterface = paramQQAppInterface + "_" + paramSimpleAccount.getUin();
    paramSimpleAccount = localbdwt.a(paramQQAppInterface + "_last_cookie");
    if (!TextUtils.isEmpty(paramSimpleAccount)) {
      localbdwt.a(paramQQAppInterface + "_cookie", paramSimpleAccount);
    }
    localbdwt.a(paramQQAppInterface + "_msgNum", Integer.valueOf(0));
    localbdwt.a(paramQQAppInterface + "_msgFlag", Integer.valueOf(0));
    localbdwt.a(paramQQAppInterface + "_redBagTime", Integer.valueOf(0));
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "cleanAllThirdQQUnreadMsgNum()");
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramString == null)
    {
      bool2 = bool1;
      return bool2;
    }
    bool1 = bool2;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = (bdxc)paramQQAppInterface.getManager(61);
      if (localObject == null) {
        break label344;
      }
      localObject = ((bdxc)localObject).a();
      label45:
      paramQQAppInterface = (bdwt)paramQQAppInterface.getManager(62);
      bool1 = bool2;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if ((paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList == null) || (paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
          break label339;
        }
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          i = paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            Pair localPair = (Pair)paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.get(i);
            if (((ArrayList)localObject).contains(localPair.first))
            {
              if (((Integer)localPair.second).intValue() == 1) {
                paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.remove(i);
              }
            }
            else if (((Integer)localPair.second).intValue() == 0) {
              paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.remove(i);
            }
          }
        }
      }
      finally
      {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if ((paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList != null) && (paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        bool1 = "sub.uin.all".equals(paramString);
        if (bool1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "needShowHintDialog() subUin=" + paramString + " bool=" + bool1);
        return bool1;
        localObject = paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            bool1 = paramString.equals(((Pair)((Iterator)localObject).next()).first);
            if (bool1)
            {
              bool1 = true;
              break;
            }
          }
        }
        label339:
        bool1 = false;
      }
      label344:
      localObject = null;
      break label45;
      i -= 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() subUin=" + paramString + " isFromPush=" + paramBoolean);
    }
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning()))
    {
      localObject = (bdxc)paramQQAppInterface.getManager(61);
      if (localObject == null) {
        break label381;
      }
    }
    label381:
    for (Object localObject = ((bdxc)localObject).a(paramString);; localObject = null)
    {
      bdwz localbdwz = (bdwz)paramQQAppInterface.getManager(28);
      if (localbdwz != null)
      {
        paramBoolean = localbdwz.a();
        if (!paramBoolean)
        {
          localObject = new bdxd();
          ((bdxd)localObject).jdField_a_of_type_JavaLangString = "";
          ((bdxd)localObject).b = paramQQAppInterface.getAccount();
          ((bdxd)localObject).c = paramString;
          ((bdxd)localObject).jdField_a_of_type_Int = 1009;
          paramQQAppInterface.a().notifyUI(8003, false, localObject);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() return, get bind subaccount isFinish = " + paramBoolean);
          }
          return false;
        }
      }
      if ((paramString == null) || (paramString.length() == 0) || (localObject == null) || (((String)localObject).length() == 0) || (((String)localObject).trim().equals("")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() return, subUin=" + paramString + " a2=" + (String)localObject);
        }
        localObject = new bdxd();
        ((bdxd)localObject).jdField_a_of_type_JavaLangString = "";
        ((bdxd)localObject).b = paramQQAppInterface.getAccount();
        ((bdxd)localObject).c = paramString;
        ((bdxd)localObject).jdField_a_of_type_Int = 1010;
        paramQQAppInterface.a().notifyUI(8003, false, localObject);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() lockMsg later really start get subaccount message account = " + paramQQAppInterface.getAccount() + "; sAccount = " + paramString);
      }
      paramQQAppInterface = (MessageHandler)paramQQAppInterface.a(0);
      if (paramQQAppInterface.a() != null) {
        paramQQAppInterface.a().a((byte)3, 0, paramString, (String)localObject, null);
      }
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startGetThirdQQUnreadNum()");
    }
    bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    if (localbdwt != null)
    {
      if (!localbdwt.jdField_b_of_type_Boolean) {
        return false;
      }
      if (BaseActivity.mAppForground)
      {
        bool = localbdwt.d(paramQQAppInterface, paramBoolean);
        paramBoolean = bool;
        if (bool) {
          localbdwt.b(paramQQAppInterface);
        }
      }
      for (paramBoolean = bool;; paramBoolean = bool)
      {
        if ((!paramBoolean) && (localbdwt.jdField_c_of_type_JavaLangRunnable != null)) {
          ThreadManager.getSubThreadHandler().removeCallbacks(localbdwt.jdField_c_of_type_JavaLangRunnable);
        }
        return paramBoolean;
        localbdwt.jdField_a_of_type_Boolean = true;
      }
    }
    return false;
  }
  
  private boolean a(String paramString, Object paramObject)
  {
    boolean bool2;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null))
    {
      bool2 = false;
      return bool2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "putAssociatedQQCache key=" + paramString + " value=" + paramObject);
    }
    this.jdField_b_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      Object localObject;
      boolean bool1;
      try
      {
        if (this.jdField_c_of_type_JavaUtilArrayList == null) {
          break label306;
        }
        localObject = a(paramString);
        if (localObject == null)
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(new bdwx(paramString, paramObject));
          bool1 = true;
          this.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
          bool2 = bool1;
          if (localObject == null) {
            break;
          }
          if (!(paramObject instanceof Integer)) {
            break label311;
          }
          ((SharedPreferences)localObject).edit().putInt(paramString, ((Integer)paramObject).intValue()).commit();
          return bool1;
        }
        if (((paramObject instanceof Integer)) && ((((bdwx)localObject).jdField_a_of_type_JavaLangObject instanceof Integer)))
        {
          if ((Integer)((bdwx)localObject).jdField_a_of_type_JavaLangObject == (Integer)paramObject) {
            break label346;
          }
          bool2 = true;
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          ((bdwx)localObject).jdField_a_of_type_JavaLangObject = paramObject;
          bool1 = bool2;
          continue;
        }
        if (!(paramObject instanceof String)) {
          break label346;
        }
      }
      finally
      {
        this.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if ((((bdwx)localObject).jdField_a_of_type_JavaLangObject instanceof String))
      {
        bool1 = TextUtils.equals((String)((bdwx)localObject).jdField_a_of_type_JavaLangObject, (String)paramObject);
        if (!bool1)
        {
          bool2 = true;
          continue;
          label306:
          bool1 = true;
          continue;
          label311:
          bool2 = bool1;
          if (!(paramObject instanceof String)) {
            break;
          }
          ((SharedPreferences)localObject).edit().putString(paramString, (String)paramObject).commit();
          return bool1;
        }
      }
      label346:
      bool2 = false;
    }
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramQQAppInterface.c()))) {
      return null;
    }
    bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    if (localbdwt != null)
    {
      paramQQAppInterface = localbdwt.a(paramQQAppInterface.c() + "_" + paramString + "_cookie");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return bhvd.a(paramQQAppInterface);
      }
    }
    return null;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, adab paramadab)
  {
    int i;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (paramadab == null))
    {
      i = 0;
      return i;
    }
    bdxc localbdxc = (bdxc)paramQQAppInterface.getManager(61);
    Object localObject;
    if (localbdxc != null)
    {
      Iterator localIterator = localbdxc.b().iterator();
      i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label192;
      }
      localObject = (SubAccountInfo)localIterator.next();
      if ((localObject == null) || (TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)) || (localbdxc.a(((SubAccountInfo)localObject).subuin) != 1)) {
        break label240;
      }
    }
    label180:
    label192:
    label240:
    for (int j = paramadab.b(((SubAccountInfo)localObject).subuin, 7000);; j = 0)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("getAllSubAccountTroopMsgUnreadNum() subuin=");
        if (localObject != null) {
          break label180;
        }
      }
      for (localObject = Integer.valueOf(0);; localObject = ((SubAccountInfo)localObject).subuin)
      {
        QLog.d("SUB_ACCOUNT", 2, localObject + " num=" + j);
        i += j;
        break;
      }
      j = 0;
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "getAllSubAccountTroopMsgUnreadNum() currentUin=" + paramQQAppInterface.c() + " allNum=" + j);
      return j;
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (anyw)paramQQAppInterface.getManager(51);
    Object localObject = paramQQAppInterface.b(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
      paramQQAppInterface = ((Friends)localObject).name;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = paramQQAppInterface.a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(((Card)localObject).strNick));
    return ((Card)localObject).strNick;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_JavaLangString = paramString;
      paramQQAppInterface = (bdxc)paramQQAppInterface.getManager(61);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.e(jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString)) || (!TextUtils.equals(paramString, paramQQAppInterface.c()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "storeThirdQQUnreadMsgNumInterval mainAccount=" + paramString + " interval=" + paramInt);
      }
      paramString = (bdwt)paramQQAppInterface.getManager(62);
    } while (paramString == null);
    paramString.a(paramQQAppInterface.c() + "_unread_msg_num_interval", Integer.valueOf(paramInt));
    paramString.a(paramInt);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {}
    Object localObject1;
    label110:
    do
    {
      long l1;
      long l2;
      do
      {
        return;
        localObject1 = (bdwt)paramQQAppInterface.getManager(62);
        if (localObject1 == null) {
          break label110;
        }
        l1 = System.currentTimeMillis();
        l2 = (l1 - ((bdwt)localObject1).jdField_c_of_type_Long) / 1000L;
        if (l2 >= ((bdwt)localObject1).jdField_b_of_type_Long) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareListFromService skip adviseGap=" + ((bdwt)localObject1).jdField_b_of_type_Long + "  realGap=" + l2);
      return;
      ((bdwt)localObject1).jdField_c_of_type_Long = l1;
      localObject1 = (bdxc)paramQQAppInterface.getManager(61);
    } while (localObject1 == null);
    Object localObject2 = new ArrayList();
    if (paramBoolean) {
      ((List)localObject2).addAll(((bdxc)localObject1).b());
    }
    for (;;)
    {
      paramString = ((List)localObject2).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (SubAccountInfo)paramString.next();
        if ((localObject1 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareListFromService uin=" + ((SubAccountInfo)localObject1).subuin);
          }
          localObject2 = (MessageHandler)paramQQAppInterface.a(0);
          if (((MessageHandler)localObject2).a() != null) {
            ((MessageHandler)localObject2).a().a((SubAccountInfo)localObject1);
          }
        }
      }
      break;
      ((List)localObject2).add(((bdxc)localObject1).a(paramString));
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (bdxc)paramQQAppInterface.getManager(61);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)paramQQAppInterface.next();
          if ((localSubAccountInfo != null) && (localSubAccountInfo.isTop)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c()))) {}
    for (;;)
    {
      return;
      Object localObject1 = (bdxc)paramQQAppInterface.getManager(61);
      if (localObject1 != null)
      {
        Object localObject2 = new ArrayList();
        ((List)localObject2).addAll(((bdxc)localObject1).b());
        localObject1 = paramQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
        if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
            localObject3 = ((SubAccountInfo)localObject3).subuin + "_" + paramQQAppInterface.c() + "_spcares_sysTime";
            ((SharedPreferences)localObject1).edit().putInt((String)localObject3, 0).commit();
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "cleanReqSubAccountSpecialCareListSysTime key=" + (String)localObject3);
            }
          }
        }
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unbindRecentItem subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() < 4)) {}
    do
    {
      apaw localapaw;
      do
      {
        return;
        paramQQAppInterface.a().c(paramString, 7000);
        localapaw = paramQQAppInterface.a().a();
        paramString = (RecentUser)localapaw.findRecentUser(paramString, 7000);
        if (paramString != null)
        {
          localapaw.delRecentUser(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "unbindRecentItem() unbind,delete subUin:" + paramString.uin + " type=" + paramString.getType());
          }
        }
      } while (((bdxc)paramQQAppInterface.getManager(61)).a() != 0);
      a(paramQQAppInterface, localapaw, antf.x, 7);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() unbind, add default RecentUser");
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c()))) {
      return false;
    }
    Object localObject1 = (bdxc)paramQQAppInterface.getManager(61);
    bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    if ((localObject1 == null) || (localbdwt == null)) {
      return false;
    }
    localObject1 = ((bdxc)localObject1).a();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramQQAppInterface.getApplication().getAllAccounts();
    if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
      ((List)localObject2).addAll((Collection)localObject3);
    }
    paramQQAppInterface = paramQQAppInterface.c();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (SimpleAccount)((Iterator)localObject2).next();
      if ((localObject3 != null) && (!TextUtils.isEmpty(((SimpleAccount)localObject3).getUin())) && (!((SimpleAccount)localObject3).getUin().equals(paramQQAppInterface)) && (!((List)localObject1).contains(((SimpleAccount)localObject3).getUin())))
      {
        localObject3 = paramQQAppInterface + "_" + ((SimpleAccount)localObject3).getUin();
        String str = localbdwt.a((String)localObject3 + "_last_cookie");
        if (!TextUtils.isEmpty(str)) {
          localbdwt.a((String)localObject3 + "_cookie", str);
        }
        localbdwt.a((String)localObject3 + "_msgNum", Integer.valueOf(0));
        localbdwt.a((String)localObject3 + "_msgFlag", Integer.valueOf(0));
        localbdwt.a((String)localObject3 + "_redBagTime", Integer.valueOf(0));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "cleanAllThirdQQUnreadMsgNum()");
    }
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c()))) {
      return false;
    }
    paramQQAppInterface = (bdwt)paramQQAppInterface.getManager(62);
    if (paramQQAppInterface != null)
    {
      if (paramBoolean)
      {
        Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.aio_config.name());
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "aioConfig:" + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          if ((localObject != null) && (localObject.length > 11) && (!TextUtils.isEmpty(localObject[11])))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "subAccountConfig:" + localObject[11]);
            }
            localObject = localObject[11].split("_");
            if ((localObject == null) || (localObject.length <= 0) || (!TextUtils.equals("1", localObject[0]))) {
              break label233;
            }
          }
        }
      }
      label233:
      for (paramQQAppInterface.jdField_c_of_type_Boolean = true;; paramQQAppInterface.jdField_c_of_type_Boolean = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "isHeadIconLongClickFunc isHeadIconLongClick=" + paramQQAppInterface.jdField_c_of_type_Boolean);
        }
        return paramQQAppInterface.jdField_c_of_type_Boolean;
      }
    }
    return false;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.c()))) {
      return true;
    }
    bdwt localbdwt = (bdwt)paramQQAppInterface.getManager(62);
    return (localbdwt == null) || (!TextUtils.equals(localbdwt.a(paramQQAppInterface.c() + "_display_third_qq_checked"), String.valueOf(false)));
  }
  
  private boolean d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {
      return false;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = paramQQAppInterface.getApplication().getAllAccounts();
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      ((List)localObject2).addAll((Collection)localObject1);
    }
    Object localObject3 = (bdxc)paramQQAppInterface.getManager(61);
    if ((((List)localObject2).size() >= 1) && (localObject3 != null))
    {
      localObject1 = new ArrayList();
      String str = paramQQAppInterface.c();
      localObject3 = ((bdxc)localObject3).a();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
        if ((localSimpleAccount != null) && (!TextUtils.isEmpty(localSimpleAccount.getUin())) && (!localSimpleAccount.getUin().equals(str)) && (!((List)localObject3).contains(localSimpleAccount.getUin())) && (localSimpleAccount.isLogined())) {
          ((ArrayList)localObject1).add(localSimpleAccount);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "requestThirdQQUnreadMsgNum() really start get other qq unread message mainUin=" + str + " isCronJob=" + paramBoolean);
        }
        paramQQAppInterface = (MessageHandler)paramQQAppInterface.a(0);
        if (paramQQAppInterface.a() != null) {
          paramQQAppInterface.a().a(paramBoolean, (ArrayList)localObject1);
        }
        return true;
      }
    }
    return false;
  }
  
  public Pair<String, Integer> a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "addHintPair() subUin=" + paramString + " type=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() < 5) || ((paramInt != 0) && (paramInt != 1))) {
      return null;
    }
    Pair localPair1 = new Pair(paramString, Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          paramInt = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
          if (paramInt >= 0)
          {
            Pair localPair2 = (Pair)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
            if (!paramString.equals(localPair2.first)) {
              break label248;
            }
            this.jdField_b_of_type_JavaUtilArrayList.remove(paramInt);
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.d("SUB_ACCOUNT", 2, "addHintPair() remove old, subUin=" + (String)localPair2.first + " type=" + localPair2.second);
            break label248;
          }
        }
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(localPair1);
        return localPair1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label248:
      paramInt -= 1;
    }
  }
  
  /* Error */
  public ArrayList<Pair<String, Integer>> a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 130
    //   8: iconst_2
    //   9: new 132	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1230
    //   19: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: new 57	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 58	java/util/ArrayList:<init>	()V
    //   39: astore_3
    //   40: aload_1
    //   41: ifnonnull +5 -> 46
    //   44: aload_3
    //   45: areturn
    //   46: aload_0
    //   47: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   50: invokeinterface 264 1 0
    //   55: aload_0
    //   56: getfield 1069	bdwt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   59: ifnull +29 -> 88
    //   62: ldc_w 954
    //   65: aload_1
    //   66: invokevirtual 400	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +30 -> 99
    //   72: aload_3
    //   73: aload_0
    //   74: getfield 1069	bdwt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   77: invokevirtual 463	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   80: pop
    //   81: aload_0
    //   82: getfield 1069	bdwt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: invokevirtual 79	java/util/ArrayList:clear	()V
    //   88: aload_0
    //   89: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   92: invokeinterface 279 1 0
    //   97: aload_3
    //   98: areturn
    //   99: aload_0
    //   100: getfield 1069	bdwt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   103: invokevirtual 300	java/util/ArrayList:size	()I
    //   106: iconst_1
    //   107: isub
    //   108: istore_2
    //   109: iload_2
    //   110: iflt -22 -> 88
    //   113: aload_0
    //   114: getfield 1069	bdwt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   117: iload_2
    //   118: invokevirtual 304	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   121: checkcast 346	com/tencent/util/Pair
    //   124: astore 4
    //   126: aload_1
    //   127: aload 4
    //   129: getfield 1072	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   132: invokevirtual 400	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +19 -> 154
    //   138: aload_3
    //   139: aload 4
    //   141: invokevirtual 297	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   144: pop
    //   145: aload_0
    //   146: getfield 1069	bdwt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: iload_2
    //   150: invokevirtual 1076	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   153: pop
    //   154: iload_2
    //   155: iconst_1
    //   156: isub
    //   157: istore_2
    //   158: goto -49 -> 109
    //   161: astore_1
    //   162: aload_0
    //   163: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   166: invokeinterface 279 1 0
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	bdwt
    //   0	173	1	paramString	String
    //   108	50	2	i	int
    //   39	100	3	localArrayList	ArrayList
    //   124	16	4	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   55	88	161	finally
    //   99	109	161	finally
    //   113	154	161	finally
  }
  
  public void a(SubAccountBaseActivity paramSubAccountBaseActivity)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("cancelUnbindDialog() act=");
      if (paramSubAccountBaseActivity == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, (String)localObject);
      }
    }
    else
    {
      if (paramSubAccountBaseActivity != null) {
        break label60;
      }
    }
    label60:
    while (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      return;
      localObject = paramSubAccountBaseActivity.getClass().getSimpleName();
      break;
    }
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      localObject = (bhpc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localObject == null) || (((bhpc)localObject).getOwnerActivity() != paramSubAccountBaseActivity) || (((bhpc)localObject).isShowing())) {}
      try
      {
        ((bhpc)localObject).dismiss();
        label116:
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        for (;;)
        {
          i -= 1;
          break;
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        }
      }
      catch (Exception localException)
      {
        break label116;
      }
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Pair<String, Integer> paramPair, android.content.DialogInterface.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +116 -> 119
    //   6: new 132	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 1249
    //   16: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 9
    //   21: aload_3
    //   22: ifnonnull +115 -> 137
    //   25: ldc_w 657
    //   28: astore 8
    //   30: aload 9
    //   32: aload 8
    //   34: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1251
    //   40: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 9
    //   45: aload_2
    //   46: ifnonnull +129 -> 175
    //   49: ldc_w 657
    //   52: astore 8
    //   54: aload 9
    //   56: aload 8
    //   58: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1253
    //   64: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: astore 9
    //   69: aload_1
    //   70: ifnonnull +117 -> 187
    //   73: ldc_w 657
    //   76: astore 8
    //   78: aload 9
    //   80: aload 8
    //   82: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 1255
    //   88: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: astore 9
    //   93: aload 4
    //   95: ifnonnull +100 -> 195
    //   98: ldc_w 657
    //   101: astore 8
    //   103: ldc 130
    //   105: iconst_2
    //   106: aload 9
    //   108: aload 8
    //   110: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_1
    //   120: ifnull +16 -> 136
    //   123: aload_2
    //   124: ifnull +12 -> 136
    //   127: aload_3
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: ifnonnull +70 -> 203
    //   136: return
    //   137: new 132	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   144: aload_3
    //   145: getfield 1072	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   148: checkcast 379	java/lang/String
    //   151: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 1257
    //   157: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_3
    //   161: getfield 597	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   164: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 8
    //   172: goto -142 -> 30
    //   175: aload_2
    //   176: invokevirtual 901	java/lang/Object:getClass	()Ljava/lang/Class;
    //   179: invokevirtual 906	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   182: astore 8
    //   184: goto -130 -> 54
    //   187: ldc_w 1259
    //   190: astore 8
    //   192: goto -114 -> 78
    //   195: ldc_w 1259
    //   198: astore 8
    //   200: goto -97 -> 103
    //   203: aload_3
    //   204: getfield 1072	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   207: checkcast 379	java/lang/String
    //   210: astore 8
    //   212: aload_3
    //   213: getfield 597	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   216: checkcast 221	java/lang/Integer
    //   219: invokevirtual 276	java/lang/Integer:intValue	()I
    //   222: istore 6
    //   224: aload_0
    //   225: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   228: invokeinterface 264 1 0
    //   233: aload_0
    //   234: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   237: ifnull +141 -> 378
    //   240: aload_0
    //   241: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   244: invokevirtual 300	java/util/ArrayList:size	()I
    //   247: iconst_1
    //   248: isub
    //   249: istore 5
    //   251: iload 5
    //   253: iflt +125 -> 378
    //   256: aload_0
    //   257: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   260: iload 5
    //   262: invokevirtual 304	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   265: checkcast 921	bhpc
    //   268: astore 10
    //   270: aload 10
    //   272: ifnull +298 -> 570
    //   275: aload 10
    //   277: invokevirtual 1262	bhpc:getTag	()Ljava/lang/Object;
    //   280: instanceof 346
    //   283: ifeq +287 -> 570
    //   286: aload 10
    //   288: invokevirtual 1262	bhpc:getTag	()Ljava/lang/Object;
    //   291: checkcast 346	com/tencent/util/Pair
    //   294: astore 9
    //   296: aload 8
    //   298: aload 9
    //   300: getfield 1072	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   303: invokevirtual 400	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifeq +264 -> 570
    //   309: aload 10
    //   311: invokevirtual 1243	bhpc:isShowing	()Z
    //   314: istore 7
    //   316: iload 7
    //   318: ifeq +8 -> 326
    //   321: aload 10
    //   323: invokevirtual 1246	bhpc:dismiss	()V
    //   326: aload_0
    //   327: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   330: iload 5
    //   332: invokevirtual 1076	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   335: pop
    //   336: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +231 -> 570
    //   342: ldc 130
    //   344: iconst_2
    //   345: new 132	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 1264
    //   355: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 9
    //   360: getfield 1072	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   363: checkcast 379	java/lang/String
    //   366: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto +195 -> 570
    //   378: aload_2
    //   379: ldc_w 907
    //   382: invokevirtual 910	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   385: astore 10
    //   387: aload_1
    //   388: aload 8
    //   390: iconst_0
    //   391: invokestatic 964	bhlg:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   394: astore 9
    //   396: aload 9
    //   398: ifnull +181 -> 579
    //   401: aload 9
    //   403: astore_1
    //   404: aload 9
    //   406: invokevirtual 443	java/lang/String:length	()I
    //   409: ifne +6 -> 415
    //   412: goto +167 -> 579
    //   415: iload 6
    //   417: ifne +117 -> 534
    //   420: aload_2
    //   421: ldc_w 1265
    //   424: iconst_1
    //   425: anewarray 4	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload_1
    //   431: aastore
    //   432: invokevirtual 914	com/tencent/mobileqq/app/BaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   435: astore_1
    //   436: aload_2
    //   437: sipush 230
    //   440: invokestatic 919	bhlq:a	(Landroid/content/Context;I)Lbhpc;
    //   443: aload 10
    //   445: invokevirtual 925	bhpc:setTitle	(Ljava/lang/String;)Lbhpc;
    //   448: aload_1
    //   449: invokevirtual 929	bhpc:setMessage	(Ljava/lang/CharSequence;)Lbhpc;
    //   452: astore_1
    //   453: aload_1
    //   454: aload_3
    //   455: invokevirtual 1268	bhpc:setTag	(Ljava/lang/Object;)V
    //   458: aload_1
    //   459: aload_2
    //   460: invokevirtual 933	bhpc:setOwnerActivity	(Landroid/app/Activity;)V
    //   463: aload_1
    //   464: aload_2
    //   465: ldc_w 934
    //   468: invokevirtual 910	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   471: aload 4
    //   473: invokevirtual 942	bhpc:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbhpc;
    //   476: pop
    //   477: aload_1
    //   478: new 1270	bdwv
    //   481: dup
    //   482: aload_0
    //   483: aload 8
    //   485: iload 6
    //   487: invokespecial 1273	bdwv:<init>	(Lbdwt;Ljava/lang/String;I)V
    //   490: invokevirtual 1277	bhpc:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   493: aload_1
    //   494: invokevirtual 949	bhpc:show	()V
    //   497: aload_0
    //   498: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   501: ifnonnull +14 -> 515
    //   504: aload_0
    //   505: new 57	java/util/ArrayList
    //   508: dup
    //   509: invokespecial 58	java/util/ArrayList:<init>	()V
    //   512: putfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   515: aload_0
    //   516: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   519: aload_1
    //   520: invokevirtual 297	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   523: pop
    //   524: aload_0
    //   525: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   528: invokeinterface 279 1 0
    //   533: return
    //   534: aload_2
    //   535: ldc_w 1278
    //   538: iconst_1
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: aload_1
    //   545: aastore
    //   546: invokevirtual 914	com/tencent/mobileqq/app/BaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   549: astore_1
    //   550: goto -114 -> 436
    //   553: astore_1
    //   554: aload_0
    //   555: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   558: invokeinterface 279 1 0
    //   563: aload_1
    //   564: athrow
    //   565: astore 10
    //   567: goto -241 -> 326
    //   570: iload 5
    //   572: iconst_1
    //   573: isub
    //   574: istore 5
    //   576: goto -325 -> 251
    //   579: aload 8
    //   581: astore_1
    //   582: goto -167 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	bdwt
    //   0	585	1	paramQQAppInterface	QQAppInterface
    //   0	585	2	paramBaseActivity	BaseActivity
    //   0	585	3	paramPair	Pair<String, Integer>
    //   0	585	4	paramOnClickListener	android.content.DialogInterface.OnClickListener
    //   249	326	5	i	int
    //   222	264	6	j	int
    //   314	3	7	bool	boolean
    //   28	552	8	str	String
    //   19	386	9	localObject1	Object
    //   268	176	10	localObject2	Object
    //   565	1	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   233	251	553	finally
    //   256	270	553	finally
    //   275	316	553	finally
    //   321	326	553	finally
    //   326	375	553	finally
    //   378	396	553	finally
    //   404	412	553	finally
    //   420	436	553	finally
    //   436	515	553	finally
    //   515	524	553	finally
    //   534	550	553	finally
    //   321	326	565	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 130
    //   8: iconst_2
    //   9: new 132	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1282
    //   19: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 578
    //   29: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_2
    //   33: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnull +11 -> 54
    //   46: aload_1
    //   47: invokevirtual 443	java/lang/String:length	()I
    //   50: iconst_5
    //   51: if_icmpge +4 -> 55
    //   54: return
    //   55: aload_0
    //   56: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   59: invokeinterface 264 1 0
    //   64: aload_0
    //   65: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: ifnull +253 -> 321
    //   71: aload_0
    //   72: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   75: invokevirtual 300	java/util/ArrayList:size	()I
    //   78: iconst_1
    //   79: isub
    //   80: istore 5
    //   82: iload 5
    //   84: iflt +237 -> 321
    //   87: aload_0
    //   88: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   91: iload 5
    //   93: invokevirtual 304	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   96: checkcast 921	bhpc
    //   99: astore 7
    //   101: aload 7
    //   103: ifnull +162 -> 265
    //   106: aload 7
    //   108: invokevirtual 1262	bhpc:getTag	()Ljava/lang/Object;
    //   111: astore 8
    //   113: aload 8
    //   115: ifnull +193 -> 308
    //   118: aload 8
    //   120: instanceof 346
    //   123: ifeq +185 -> 308
    //   126: aload 8
    //   128: checkcast 346	com/tencent/util/Pair
    //   131: astore 8
    //   133: iload_3
    //   134: ifeq +156 -> 290
    //   137: aload_1
    //   138: aload 8
    //   140: getfield 1072	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   143: invokevirtual 400	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +190 -> 336
    //   149: iload_2
    //   150: aload 8
    //   152: getfield 597	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   155: checkcast 221	java/lang/Integer
    //   158: invokevirtual 276	java/lang/Integer:intValue	()I
    //   161: if_icmpne +175 -> 336
    //   164: iconst_1
    //   165: istore 4
    //   167: iload 4
    //   169: ifeq +173 -> 342
    //   172: aload 7
    //   174: invokevirtual 1243	bhpc:isShowing	()Z
    //   177: istore 6
    //   179: iload 6
    //   181: ifeq +8 -> 189
    //   184: aload 7
    //   186: invokevirtual 1246	bhpc:dismiss	()V
    //   189: aload_0
    //   190: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   193: iload 5
    //   195: invokevirtual 1076	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   198: pop
    //   199: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +140 -> 342
    //   205: ldc 130
    //   207: iconst_2
    //   208: new 132	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 1284
    //   218: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 8
    //   223: getfield 1072	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   226: checkcast 379	java/lang/String
    //   229: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 578
    //   235: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 8
    //   240: getfield 597	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   243: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: ldc_w 1286
    //   249: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_3
    //   253: invokevirtual 342	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto +80 -> 342
    //   265: aload_0
    //   266: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   269: iload 5
    //   271: invokevirtual 1076	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   274: pop
    //   275: goto +67 -> 342
    //   278: astore_1
    //   279: aload_0
    //   280: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   283: invokeinterface 279 1 0
    //   288: aload_1
    //   289: athrow
    //   290: aload_1
    //   291: aload 8
    //   293: getfield 1072	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   296: invokevirtual 400	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +37 -> 336
    //   302: iconst_1
    //   303: istore 4
    //   305: goto -138 -> 167
    //   308: aload_0
    //   309: getfield 1236	bdwt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   312: iload 5
    //   314: invokevirtual 1076	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   317: pop
    //   318: goto +24 -> 342
    //   321: aload_0
    //   322: getfield 43	bdwt:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   325: invokeinterface 279 1 0
    //   330: return
    //   331: astore 7
    //   333: goto -144 -> 189
    //   336: iconst_0
    //   337: istore 4
    //   339: goto -172 -> 167
    //   342: iload 5
    //   344: iconst_1
    //   345: isub
    //   346: istore 5
    //   348: goto -266 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	bdwt
    //   0	351	1	paramString	String
    //   0	351	2	paramInt	int
    //   0	351	3	paramBoolean	boolean
    //   165	173	4	i	int
    //   80	267	5	j	int
    //   177	3	6	bool	boolean
    //   99	86	7	localbhpc	bhpc
    //   331	1	7	localException	Exception
    //   111	181	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   64	82	278	finally
    //   87	101	278	finally
    //   106	113	278	finally
    //   118	133	278	finally
    //   137	164	278	finally
    //   172	179	278	finally
    //   184	189	278	finally
    //   189	262	278	finally
    //   265	275	278	finally
    //   290	302	278	finally
    //   308	318	278	finally
    //   184	189	331	java/lang/Exception
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {}
    do
    {
      return;
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      if (this.jdField_c_of_type_JavaLangRunnable == null) {
        this.jdField_c_of_type_JavaLangRunnable = new SubAccountControll.6(this, paramQQAppInterface);
      }
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_c_of_type_JavaLangRunnable, this.e * 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "launchTimedThirdQQUnreadNumTask() next req after " + this.e + "s.");
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("launchTimedMsgTask() app.isRunning=");
      if (paramQQAppInterface == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject + " fetchMsgType=" + paramInt);
      }
    }
    else
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning())) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      localObject = Boolean.valueOf(paramQQAppInterface.isRunning());
      break;
      c(paramQQAppInterface, paramInt);
      if (paramInt != 2) {
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.d * 1000L);
      }
      if (paramInt != 1) {
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, jdField_a_of_type_Long * 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "launchTimedMsgTask() schedule msgTimer after " + this.d + "*1000 ms.");
  }
  
  public void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("cancelTimedMsgTask() app.isRunning=");
      if (paramQQAppInterface == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject + " fetchMsgType=" + paramInt);
      }
    }
    else
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning())) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      localObject = Boolean.valueOf(paramQQAppInterface.isRunning());
      break;
      if (paramInt != 2) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (paramInt == 1);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          bhpc localbhpc = (bhpc)localIterator.next();
          try
          {
            if (localbhpc.isShowing()) {
              localbhpc.dismiss();
            }
          }
          catch (Exception localException) {}
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_JavaUtilArrayList = null;
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_b_of_type_JavaUtilArrayList = null;
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      if (this.jdField_c_of_type_JavaLangRunnable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_c_of_type_JavaLangRunnable = null;
      }
      if (this.jdField_c_of_type_JavaUtilArrayList != null) {
        this.jdField_c_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwt
 * JD-Core Version:    0.7.0.1
 */