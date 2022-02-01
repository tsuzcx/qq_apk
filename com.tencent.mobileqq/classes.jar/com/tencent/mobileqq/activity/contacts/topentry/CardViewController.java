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
  private QQAppInterface a;
  private MayknowRecommendManager b;
  private FriendsManager c;
  private FriendListHandler d;
  private CardViewController.MayKnowListener e;
  private SharedPreferences f;
  private FriendListObserver g;
  private final Object h = new Object();
  private ArrayList<MayKnowRecommend> i;
  private long j = 0L;
  
  public CardViewController(QQAppInterface paramQQAppInterface, CardViewController.MayKnowListener paramMayKnowListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "CardViewController create");
    }
    this.a = paramQQAppInterface;
    this.b = ((MayknowRecommendManager)this.a.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.c = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.d = ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.e = paramMayKnowListener;
    this.g = new CardViewController.1(this);
    this.i = new ArrayList();
    this.a.addObserver(this.g);
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
    int k = f();
    Object localObject = m();
    k -= paramInt;
    paramInt = k;
    if (k < 0) {
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
      long l1 = i();
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject2).next();
        if (localMayKnowRecommend != null) {
          ((List)???).add(localMayKnowRecommend.uin);
        }
      }
      this.b.a((List)???, l2, l1, true);
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
    synchronized (this.h)
    {
      this.i.clear();
      if (paramArrayList != null) {
        this.i.addAll(paramArrayList);
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
    this.e.a(paramList);
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
    return this.b.a(2, paramBundle);
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
  
  private ArrayList<MayKnowRecommend> d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "calcDisplayingMKRList");
    }
    Object localObject = k();
    int n = e();
    int i1 = ((ArrayList)localObject).size();
    ArrayList localArrayList = new ArrayList(n);
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = i();
    int m = 0;
    int k = 0;
    MayKnowRecommend localMayKnowRecommend;
    while ((k < i1) && (localArrayList.size() < n))
    {
      localMayKnowRecommend = (MayKnowRecommend)((ArrayList)localObject).get(k);
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
      k += 1;
    }
    ((ArrayList)localObject).removeAll(localArrayList);
    k = ((ArrayList)localObject).size() - 1;
    while ((k >= 0) && (localArrayList.size() < n))
    {
      localMayKnowRecommend = (MayKnowRecommend)((ArrayList)localObject).get(k);
      if (a(localMayKnowRecommend))
      {
        localArrayList.add(localMayKnowRecommend);
        m = 1;
      }
      k -= 1;
    }
    localObject = localArrayList;
    if (m != 0)
    {
      localObject = localArrayList;
      if (e() != 2)
      {
        g();
        localObject = d();
      }
    }
    return localObject;
  }
  
  private int e()
  {
    long l1 = l().getLong("CardViewControllerdisplay_not_2", 0L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (l1 + i() < l2) {
      g();
    }
    int m = 2 - f();
    int k = m;
    if (m < 0) {
      k = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadCardSize = ");
      localStringBuilder.append(k);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    return k;
  }
  
  private int f()
  {
    int m = l().getInt("CardViewControllerdelete_count", 0);
    int k = m;
    if (m < 0) {
      k = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadCurrentDelCount = ");
      localStringBuilder.append(k);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    return k;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "resetCurrentDelCount");
    }
    SharedPreferences.Editor localEditor = m();
    localEditor.putInt("CardViewControllerdelete_count", 0);
    localEditor.putLong("CardViewControllerdisplay_not_2", 0L);
    localEditor.apply();
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "increaseCurrentDelCount");
    }
    int k = f();
    SharedPreferences.Editor localEditor = m();
    k += 1;
    localEditor.putInt("CardViewControllerdelete_count", k);
    if (k == 1) {
      localEditor.putLong("CardViewControllerdisplay_not_2", NetConnInfoCenter.getServerTimeMillis());
    }
    localEditor.apply();
  }
  
  private long i()
  {
    long l = this.b.g(2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCardDisplayInterval = ");
      localStringBuilder.append(l);
      QLog.d("CardViewController", 2, localStringBuilder.toString());
    }
    return l;
  }
  
  private boolean j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "isTimeToUpdateMKRDataFromNetwork");
    }
    return this.b.h(2);
  }
  
  private ArrayList<MayKnowRecommend> k()
  {
    ArrayList localArrayList = this.b.f();
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
  
  private SharedPreferences l()
  {
    if (this.f == null)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CardViewControllermay_know_sp");
      localStringBuilder.append(this.a.getCurrentAccountUin());
      this.f = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    return this.f;
  }
  
  private SharedPreferences.Editor m()
  {
    return l().edit();
  }
  
  public void a()
  {
    this.a.removeObserver(this.g);
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
    h();
    this.d.cancelMayKnowRecommend(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "try checkUpdate");
    }
    if (this.e.a())
    {
      if (j())
      {
        int k;
        if (System.currentTimeMillis() - this.j > 1800000L) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
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
  
  public ArrayList<MayKnowRecommend> c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getCurrentDisplayingMKRList");
    }
    ArrayList localArrayList = new ArrayList();
    if (e() == 0) {
      return localArrayList;
    }
    int k = 0;
    int m = 0;
    Object localObject;
    if (this.i != null)
    {
      localObject = this.h;
      k = m;
      try
      {
        if (this.i != null)
        {
          k = m;
          if (!this.i.isEmpty())
          {
            localArrayList.addAll(this.i);
            k = 1;
          }
        }
      }
      finally {}
    }
    if (k == 0)
    {
      localObject = d();
      a((ArrayList)localObject);
      localArrayList1.addAll((Collection)localObject);
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CardViewController
 * JD-Core Version:    0.7.0.1
 */