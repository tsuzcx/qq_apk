package com.tencent.biz.qqstory.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TroopNickNameManager
  implements IManager
{
  public static final String a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  ITroopMemberCardHandler jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMemberCardHandler;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopNickNameManager.1(this);
  Map<String, Long> jdField_a_of_type_JavaUtilMap;
  Map<String, Set<String>> b;
  
  static
  {
    jdField_a_of_type_JavaLangString = PlayModeUtils.b;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('_');
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public String a(QQUserUIItem paramQQUserUIItem, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isAvailable()))
    {
      if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
        return paramQQUserUIItem.nickName;
      }
      if ((!TextUtils.isEmpty(paramQQUserUIItem.qq)) && (!TextUtils.isEmpty(paramString)))
      {
        TroopMemberInfo localTroopMemberInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString, paramQQUserUIItem.qq);
        if (localTroopMemberInfo != null)
        {
          if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)) {
            return localTroopMemberInfo.troopnick;
          }
        }
        else {
          ThreadManager.post(new TroopNickNameManager.2(this, paramString, paramQQUserUIItem, paramBoolean1, paramBoolean2), 8, null, true);
        }
      }
      return paramQQUserUIItem.getDisplayName();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    QQStoryContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMemberCardHandler = ((ITroopMemberCardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void a(QQUserUIItem paramQQUserUIItem, String paramString, boolean paramBoolean)
  {
    String str = a(paramString, paramQQUserUIItem.qq);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
      a(paramString, paramQQUserUIItem.qq);
    }
    if (paramBoolean) {
      c();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Set localSet = (Set)this.b.get(paramString1);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.b.put(paramString1, localObject);
    }
    ((Set)localObject).add(paramString2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c()
  {
    if (Looper.myLooper() != ThreadManager.getSubThreadLooper())
    {
      ThreadManager.executeOnSubThread(new TroopNickNameManager.3(this));
      return;
    }
    long l = System.currentTimeMillis();
    int i = 0;
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject1).getKey();
      Object localObject2 = (Set)((Map.Entry)localObject1).getValue();
      localIterator.remove();
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(str);
      if (localTroopInfo == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("troopInfo not found:");
          ((StringBuilder)localObject1).append(str);
          QLog.d("TroopNickNameManager", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        localObject1 = new ArrayList(20);
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (String)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilMap.put(a(str, (String)localObject3), Long.valueOf(l));
          ((ArrayList)localObject1).add(localObject3);
          if (((ArrayList)localObject1).size() >= 20)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMemberCardHandler;
            if (localObject3 != null) {
              ((ITroopMemberCardHandler)localObject3).a(str, localTroopInfo.troopcode, (ArrayList)localObject1);
            }
            localObject1 = new ArrayList(20);
            i = 1;
          }
        }
        if (((ArrayList)localObject1).size() > 0)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMemberCardHandler;
          if (localObject2 != null) {
            ((ITroopMemberCardHandler)localObject2).a(str, localTroopInfo.troopcode, (ArrayList)localObject1);
          }
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopNickNameManager.4(this), 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager
 * JD-Core Version:    0.7.0.1
 */