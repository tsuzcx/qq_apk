package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import wjj;
import wjk;
import wjl;
import wjm;
import wjn;
import wjo;
import wjp;

public class CardViewController
  extends BaseViewController
{
  private int jdField_a_of_type_Int;
  SharedPreferences.OnSharedPreferenceChangeListener jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener = new wjk(this);
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private CardConfigManager.CardConfigs jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs;
  private CardConfigManager jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager;
  private CardController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wjj(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public CardViewController(Activity paramActivity, CardController paramCardController)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController = paramCardController;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)a()).app;
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager = new CardConfigManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private int a()
  {
    return a().getInt("card_ignore_times_sp", 0);
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("contact_recommend_card_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    }
    return this.jdField_b_of_type_AndroidContentSharedPreferences;
  }
  
  private HashMap a(String paramString)
  {
    int j = 0;
    HashMap localHashMap = new HashMap();
    Object localObject = a("card_displaying_list_sp");
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      localStringBuilder = new StringBuilder();
      i = 0;
      while (i < localObject.length)
      {
        if (!paramString.equals(localObject[i]))
        {
          localStringBuilder.append(localObject[i]);
          localStringBuilder.append(";");
        }
        i += 1;
      }
      localObject = localStringBuilder.toString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label216;
      }
      localHashMap.put("displayingStr ", localObject);
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getDisplayResultList 正在展示列表 displayingStr = ");
      }
    }
    localObject = a().getString("card_displayed_list_sp", null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(";");
    if (localObject != null)
    {
      paramString = ((String)localObject).split(";");
      i = j;
      if (paramString.length >= 100) {
        break label228;
      }
      localStringBuilder.append((String)localObject);
    }
    for (;;)
    {
      paramString = localStringBuilder.toString();
      if (TextUtils.isEmpty(paramString)) {
        break label258;
      }
      localHashMap.put("displayedStr ", paramString);
      return localHashMap;
      label216:
      localHashMap.put("displayingStr ", null);
      break;
      label228:
      while (i < 50)
      {
        localStringBuilder.append(paramString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
    }
    label258:
    localHashMap.put("displayedStr ", null);
    return localHashMap;
  }
  
  private List a(List paramList)
  {
    int j = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs.jdField_a_of_type_Int != 0)) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs.jdField_b_of_type_Int;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getDisplayList cardCount =" + i);
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString = a("card_displayed_list_sp");
      for (;;)
      {
        if ((j >= paramList.size()) || (localArrayList.size() == i)) {
          return localArrayList;
        }
        if (!a(((MayKnowRecommend)paramList.get(j)).uin, arrayOfString)) {
          localArrayList.add(paramList.get(j));
        }
        j += 1;
      }
    }
  }
  
  private void a(long paramLong)
  {
    a().edit().putLong("card_last_update_timestamp_sp", paramLong).commit();
  }
  
  private void a(String paramString)
  {
    a().edit().putString("card_displaying_list_sp", paramString).commit();
  }
  
  private void a(String paramString, wjp paramwjp)
  {
    new wjl(this, paramString, paramwjp).execute(new Void[] { null, null, null });
  }
  
  private void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramList.get(0);
      if ((localMayKnowRecommend != null) && (localMayKnowRecommend.uin != null)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007F14", "0X8007F14", 0, 0, "", "", "", localMayKnowRecommend.uin);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(paramList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!NetworkUtil.d(a())) {}
    boolean bool;
    do
    {
      return;
      if (!CardState.a(this.jdField_b_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardViewController", 2, "getData not idle mCardState = " + this.jdField_b_of_type_Int);
        }
        c(paramBoolean1, paramBoolean2);
        this.c = true;
      }
      bool = b();
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getData isTimeToUpdate " + bool);
      }
      if (a()) {
        break;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(null);
    return;
    QLog.d("CardViewController", 1, "isTimeToUpdate=" + bool);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getData set isRefreshingRemote = true");
      }
      this.jdField_a_of_type_Boolean = true;
      MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(158);
      paramBoolean1 = localMayknowRecommendManager.a();
      QLog.d("CardViewController", 1, "isTimeToObtainRemote=" + paramBoolean1);
      if (paramBoolean1)
      {
        localMayknowRecommendManager.b();
        this.jdField_b_of_type_Int = 1;
        return;
      }
      this.jdField_b_of_type_Int = 1;
      f();
      return;
    }
    b(paramBoolean1, paramBoolean2);
    this.jdField_b_of_type_Int = 2;
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs.jdField_a_of_type_Int == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getData mConfigration = null");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs.jdField_a_of_type_Boolean) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("CardViewController", 2, "getData mConfigration isOpen false");
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CardViewController", 2, "getData mConfigration isOpen true but user turn off the switch");
      return false;
      if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager$CardConfigs)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardViewController", 2, "getData mConfigration isLimitToShow");
    return false;
    return true;
  }
  
  private boolean a(CardConfigManager.CardConfigs paramCardConfigs)
  {
    return (a() >= paramCardConfigs.c) && (!b(paramCardConfigs));
  }
  
  private boolean a(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private String[] a(String paramString)
  {
    paramString = a().getString(paramString, null);
    if (paramString == null) {
      return null;
    }
    return paramString.split(";");
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      a(false, false);
      return;
    }
    if (paramInt == 1)
    {
      a(false, true);
      return;
    }
    if (paramInt == 2)
    {
      a(true, true);
      return;
    }
    a(false, false);
  }
  
  private void b(String paramString)
  {
    a().edit().putString("card_displayed_list_sp", paramString).commit();
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getLocalDisplayingList ");
    }
    new wjo(this, paramBoolean2, paramBoolean1).execute(new Void[] { null, null, null });
  }
  
  private boolean b()
  {
    long l1 = a().getLong("card_last_update_timestamp_sp", 0L);
    long l2 = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l2);
    localCalendar.set(11, 8);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l3 = localCalendar.getTimeInMillis();
    if (l1 < l3)
    {
      if (l2 > l3) {}
      while (l1 < l3 - 86400000L) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(CardConfigManager.CardConfigs paramCardConfigs)
  {
    long l = a().getLong("card_last_update_timestamp_sp", 0L);
    return System.currentTimeMillis() - l >= 86400000L * paramCardConfigs.d;
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "onCancelMayKnowRecommend  refresh local mState =" + this.jdField_b_of_type_Int);
      }
      if (CardState.a(this.jdField_b_of_type_Int))
      {
        this.jdField_b_of_type_Int = 4;
        g();
      }
    }
    else
    {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(4), null);
    this.jdField_a_of_type_JavaUtilLinkedList.add(localHashMap);
  }
  
  private void f()
  {
    a(System.currentTimeMillis());
    i();
    Object localObject = a("card_displaying_list_sp");
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getDisplayListAsync  moveUin  start");
      }
      a((String)localObject, new wjm(this));
      return;
    }
    g();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getDisplayListAsync  dealSourceList ");
    }
    new wjn(this).execute(new Void[] { null, null, null });
  }
  
  private void h()
  {
    int i;
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilLinkedList.remove();
      if (localHashMap != null)
      {
        i = ((Integer)localHashMap.keySet().iterator().next()).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("CardViewController", 2, "turnNextState key = " + i);
        }
        if (i != 13) {
          break label154;
        }
        this.jdField_b_of_type_Int = 3;
        i();
        int j = a();
        if (QLog.isColorLevel()) {
          QLog.d("CardViewController", 2, "turnNextState increaseIgnore times now = " + j);
        }
        a((String)localHashMap.get(Integer.valueOf(i)), null);
      }
    }
    label154:
    do
    {
      do
      {
        return;
      } while (i != 14);
      this.jdField_b_of_type_Int = 4;
      g();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "turnNextState mCardState set IDEL");
      }
      this.jdField_b_of_type_Int = 0;
    } while (!this.c);
    b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = 0;
    this.c = false;
  }
  
  private void i()
  {
    a(a() + 1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_AndroidContentSharedPreferences.registerOnSharedPreferenceChangeListener(this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener);
  }
  
  public void a(int paramInt)
  {
    a().edit().putInt("card_ignore_times_sp", paramInt).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardConfigManager = new CardConfigManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentSharedPreferences.registerOnSharedPreferenceChangeListener(this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener);
    this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("contact_recommend_card_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    this.d = true;
    a(false, false);
  }
  
  public void a(MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "clearCardRecord mayKnowRecommend null ");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "clearCardRecord deleteUin  ,mCardState = " + this.jdField_b_of_type_Int);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(paramMayKnowRecommend.uin);
    this.jdField_b_of_type_Boolean = true;
    if (CardState.a(this.jdField_b_of_type_Int))
    {
      this.jdField_b_of_type_Int = 3;
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(3), paramMayKnowRecommend.uin);
    this.jdField_a_of_type_JavaUtilLinkedList.add(localHashMap);
  }
  
  public void b(boolean paramBoolean)
  {
    a(false, false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.unregisterOnSharedPreferenceChangeListener(this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.unregisterOnSharedPreferenceChangeListener(this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener);
      this.jdField_a_of_type_AndroidContentSharedPreferences = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.CardViewController
 * JD-Core Version:    0.7.0.1
 */