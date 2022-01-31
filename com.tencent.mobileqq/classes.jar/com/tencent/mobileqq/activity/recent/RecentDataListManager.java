package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RecentDataListManager
{
  private static RecentDataListManager jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public final List a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(109);
  public List b;
  
  private RecentDataListManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
  }
  
  public static RecentDataListManager a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager = new RecentDataListManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "-" + paramInt;
  }
  
  private void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    TraceUtils.a("splitRecents");
    ArrayList localArrayList1 = new ArrayList(4);
    ArrayList localArrayList2 = new ArrayList(4);
    ArrayList localArrayList3 = new ArrayList(4);
    localArrayList1.add(paramQQAppInterface.getCurrentAccountUin());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      switch (localRecentUser.type)
      {
      default: 
        break;
      case 0: 
        localArrayList1.add(localRecentUser.uin);
        break;
      case 1: 
        localArrayList2.add(localRecentUser.uin);
        break;
      case 3000: 
        localArrayList3.add(localRecentUser.uin);
      }
    }
    TraceUtils.a();
    if (localArrayList1.size() > 2) {
      ((FriendsManager)paramQQAppInterface.getManager(50)).a(localArrayList1);
    }
    if (localArrayList3.size() > 2) {
      ((DiscussionManager)paramQQAppInterface.getManager(52)).a(localArrayList3);
    }
    if (localArrayList2.size() > 2) {
      ((TroopManager)paramQQAppInterface.getManager(51)).a(localArrayList2);
    }
  }
  
  public RecentBaseData a(String paramString)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = (RecentBaseData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, paramString.toString());
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)) && (paramRecentBaseData != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramRecentBaseData);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramQQAppInterface == null)
    {
      localObject = null;
      if (localObject == null) {
        break label207;
      }
    }
    label31:
    label207:
    for (Object localObject = ((RecentUserProxy)localObject).a(true);; localObject = null)
    {
      int i;
      int j;
      if (localObject == null)
      {
        i = 0;
        j = Math.min(8, i);
        if (j > 0)
        {
          if (paramBoolean) {
            break label118;
          }
          a(paramQQAppInterface, (List)localObject);
          this.b = new ArrayList(j);
          ConversationDataFactory.a((List)localObject, paramQQAppInterface, paramContext, this.b, j);
        }
      }
      for (;;)
      {
        paramBoolean = bool;
        if (j > 0) {
          paramBoolean = true;
        }
        return paramBoolean;
        localObject = paramQQAppInterface.a().a();
        break;
        i = ((List)localObject).size();
        break label31;
        label118:
        paramContext = new RecentFaceDecoder(paramQQAppInterface);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.isLogin()) && (Friends.isValidUin(paramQQAppInterface.getCurrentAccountUin()))) {
          paramContext.a(0, paramQQAppInterface.getCurrentAccountUin());
        }
        i = 0;
        while (i < j)
        {
          paramQQAppInterface = (RecentUser)((List)localObject).get(i);
          if (paramQQAppInterface != null) {
            paramContext.a(paramQQAppInterface.type, paramQQAppInterface.uin);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDataListManager
 * JD-Core Version:    0.7.0.1
 */