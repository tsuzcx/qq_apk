package com.tencent.biz.qqstory.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import nbr;
import nbt;
import nbu;
import nbv;

public class TroopNickNameManager
  implements IManager
{
  public static final String a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  public TroopManager a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new nbr(this);
  public Map a;
  Map b;
  
  static
  {
    jdField_a_of_type_JavaLangString = PlayModeUtils.b;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + '_' + paramString2;
  }
  
  public String a(QQUserUIItem paramQQUserUIItem, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable())) {
      return jdField_a_of_type_JavaLangString;
    }
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
        ThreadManager.post(new nbt(this, paramString, paramQQUserUIItem, paramBoolean1, paramBoolean2), 8, null, true);
      }
    }
    return paramQQUserUIItem.getDisplayName();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    QQStoryContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c()
  {
    if (Looper.myLooper() != ThreadManager.getSubThreadLooper())
    {
      ThreadManager.executeOnSubThread(new nbu(this));
      return;
    }
    long l = System.currentTimeMillis();
    Iterator localIterator = this.b.entrySet().iterator();
    int i = 0;
    Object localObject1;
    String str1;
    TroopInfo localTroopInfo;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        str1 = (String)((Map.Entry)localObject1).getKey();
        Object localObject2 = (Set)((Map.Entry)localObject1).getValue();
        localIterator.remove();
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(str1);
        if (localTroopInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNickNameManager", 2, "troopInfo not found:" + str1);
          }
        }
        else
        {
          localObject1 = new ArrayList(20);
          localObject2 = ((Set)localObject2).iterator();
          label167:
          if (((Iterator)localObject2).hasNext())
          {
            String str2 = (String)((Iterator)localObject2).next();
            this.jdField_a_of_type_JavaUtilMap.put(a(str1, str2), Long.valueOf(l));
            ((ArrayList)localObject1).add(str2);
            if (((ArrayList)localObject1).size() < 20) {
              break label316;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(str1, localTroopInfo.troopcode, (ArrayList)localObject1);
            localObject1 = new ArrayList(20);
            i = 1;
          }
        }
      }
    }
    label314:
    label316:
    for (;;)
    {
      break label167;
      if (((ArrayList)localObject1).size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(str1, localTroopInfo.troopcode, (ArrayList)localObject1);
        i = 1;
      }
      for (;;)
      {
        break;
        if (i == 0) {
          break label314;
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new nbv(this), 30000L);
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager
 * JD-Core Version:    0.7.0.1
 */