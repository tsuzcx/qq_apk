package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CardViewController
{
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private CardViewController.MayKnowListener jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController$MayKnowListener;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<MayKnowRecommend> jdField_a_of_type_JavaUtilArrayList;
  
  public CardViewController(QQAppInterface paramQQAppInterface, CardViewController.MayKnowListener paramMayKnowListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "CardViewController create");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController$MayKnowListener = paramMayKnowListener;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new CardViewController.1(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private int a()
  {
    long l1 = a().getLong("CardViewControllerdisplay_not_2", 0L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (l1 + a() < l2) {
      c();
    }
    int j = 2 - b();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadCardSize = ");
      localStringBuilder.append(i);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private long a()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCardDisplayInterval = ");
      localStringBuilder.append(l);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    return l;
  }
  
  private SharedPreferences.Editor a()
  {
    return a().edit();
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CardViewControllermay_know_sp");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decreaseCurrentDelCount ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("CardViewController", 2, ((StringBuilder)localObject).toString());
    }
    int i = b();
    Object localObject = a();
    i -= paramInt;
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    ((SharedPreferences.Editor)localObject).putInt("CardViewControllerdelete_count", paramInt);
    if (paramInt == 0) {
      ((SharedPreferences.Editor)localObject).putLong("CardViewControllerdisplay_not_2", 0L);
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  private void a(ArrayList<MayKnowRecommend> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ??? = new ArrayList(2);
      long l1 = a();
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject2).next();
        if (localMayKnowRecommend != null) {
          ((List)???).add(localMayKnowRecommend.uin);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a((List)???, l2, l1, true);
      ??? = paramArrayList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (MayKnowRecommend)((Iterator)???).next();
        if ((localObject2 != null) && (((MayKnowRecommend)localObject2).cardDisplayTimestamp + l1 < l2)) {
          ((MayKnowRecommend)localObject2).cardDisplayTimestamp = l2;
        }
      }
    }
    a(paramArrayList);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "displayMayKnowList done");
      }
      return;
    }
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  private void a(List<MayKnowRecommend> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshCardData: ");
      String str;
      if (paramList == null) {
        str = "NULL";
      } else {
        str = paramList.toString();
      }
      localStringBuilder.append(str);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController$MayKnowListener.a(paramList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reallyCheckLocalUpdate, fromNetwork = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", isSuccess = ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.excute(new CardViewController.2(this), 16, null, true);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "isTimeToUpdateMKRDataFromNetwork");
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b(2);
  }
  
  private boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getMKRDataFromNetwork");
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getMKRDataFromNetwork when network error, abort");
      }
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a(2, paramBundle);
  }
  
  private boolean a(MayKnowRecommend paramMayKnowRecommend)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean a(String paramString, List<MayKnowRecommend> paramList)
  {
    if ((paramString != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramList.next();
        if ((localMayKnowRecommend != null) && (paramString.equals(localMayKnowRecommend.uin))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private int b()
  {
    int j = a().getInt("CardViewControllerdelete_count", 0);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadCurrentDelCount = ");
      localStringBuilder.append(i);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private ArrayList<MayKnowRecommend> b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "calcDisplayingMKRList");
    }
    Object localObject = c();
    int k = a();
    int m = ((ArrayList)localObject).size();
    ArrayList localArrayList = new ArrayList(k);
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = a();
    int j = 0;
    int i = 0;
    MayKnowRecommend localMayKnowRecommend;
    while ((i < m) && (localArrayList.size() < k))
    {
      localMayKnowRecommend = (MayKnowRecommend)((ArrayList)localObject).get(i);
      if (a(localMayKnowRecommend)) {
        if ((localMayKnowRecommend.cardDisplayTimestamp + l2 > l1) && (!a(localMayKnowRecommend.uin, localArrayList)))
        {
          localArrayList.add(localMayKnowRecommend);
        }
        else
        {
          if (localMayKnowRecommend.cardDisplayTimestamp != 0L) {
            break;
          }
          localArrayList.add(localMayKnowRecommend);
        }
      }
      i += 1;
    }
    ((ArrayList)localObject).removeAll(localArrayList);
    i = ((ArrayList)localObject).size() - 1;
    while ((i >= 0) && (localArrayList.size() < k))
    {
      localMayKnowRecommend = (MayKnowRecommend)((ArrayList)localObject).get(i);
      if (a(localMayKnowRecommend))
      {
        localArrayList.add(localMayKnowRecommend);
        j = 1;
      }
      i -= 1;
    }
    localObject = localArrayList;
    if (j != 0)
    {
      localObject = localArrayList;
      if (a() != 2)
      {
        c();
        localObject = b();
      }
    }
    return localObject;
  }
  
  private ArrayList<MayKnowRecommend> c()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.c();
    Collections.sort(localArrayList, new CardViewController.3(this));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getOrderedMKRListFromLocal = ");
      localStringBuilder.append(localArrayList);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "resetCurrentDelCount");
    }
    SharedPreferences.Editor localEditor = a();
    localEditor.putInt("CardViewControllerdelete_count", 0);
    localEditor.putLong("CardViewControllerdisplay_not_2", 0L);
    localEditor.apply();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "increaseCurrentDelCount");
    }
    int i = b();
    SharedPreferences.Editor localEditor = a();
    i += 1;
    localEditor.putInt("CardViewControllerdelete_count", i);
    if (i == 1) {
      localEditor.putLong("CardViewControllerdisplay_not_2", NetConnInfoCenter.getServerTimeMillis());
    }
    localEditor.apply();
  }
  
  public ArrayList<MayKnowRecommend> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getCurrentDisplayingMKRList");
    }
    ArrayList localArrayList = new ArrayList();
    if (a() == 0) {
      return localArrayList;
    }
    int i = 0;
    int j = 0;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaLangObject;
      i = j;
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          i = j;
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
          {
            localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
            i = 1;
          }
        }
      }
      finally {}
    }
    if (i == 0)
    {
      localObject = b();
      a((ArrayList)localObject);
      localArrayList1.addAll((Collection)localObject);
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteMayKnowRecommend, uin = ");
      localStringBuilder.append(paramString);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.cancelMayKnowRecommend(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "try checkUpdate");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCardViewController$MayKnowListener.a())
    {
      if (a())
      {
        int i;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1800000L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("from", "fetch");
          if (!a(localBundle))
          {
            if (QLog.isColorLevel()) {
              QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Time is not up, network update is not allowed or network error [1]\"");
            }
            a(false, true);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "do network checkUpdate. msg: \"send network request done\"");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Update too frequently, network update is not allowed\"");
          }
          a(false, true);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Time is not up, network update is not allowed [2]\"");
        }
        a(false, true);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "try checkUpdate， closed");
      }
      a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CardViewController
 * JD-Core Version:    0.7.0.1
 */