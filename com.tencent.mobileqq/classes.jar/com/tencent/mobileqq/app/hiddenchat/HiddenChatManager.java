package com.tencent.mobileqq.app.hiddenchat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.hiddenchat.data.HiddenChatEntity;
import com.tencent.mobileqq.settings.util.PrivacySettingUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class HiddenChatManager
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ConcurrentHashMap<String, HiddenChatEntity> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public HiddenChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = HiddenChatUtil.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static HiddenChatManager a(QQAppInterface paramQQAppInterface)
  {
    return (HiddenChatManager)paramQQAppInterface.getManager(QQManagerFactory.HIDDENCHAT_MANAGER);
  }
  
  HiddenChatEntity a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      HiddenChatEntity localHiddenChatEntity2 = (HiddenChatEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      HiddenChatEntity localHiddenChatEntity1 = localHiddenChatEntity2;
      if (localHiddenChatEntity2 == null)
      {
        localHiddenChatEntity1 = new HiddenChatEntity();
        localHiddenChatEntity1.jdField_a_of_type_JavaLangString = paramString;
        localHiddenChatEntity1.jdField_a_of_type_Int = paramInt;
      }
      return localHiddenChatEntity1;
    }
  }
  
  public ArrayList<HiddenChatEntity> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("KeyHiddenChatList", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String[] arrayOfString = localObject[i].split("\\|");
            if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
            try
            {
              HiddenChatEntity localHiddenChatEntity = new HiddenChatEntity();
              localHiddenChatEntity.jdField_a_of_type_JavaLangString = arrayOfString[0];
              localHiddenChatEntity.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[1]);
              localArrayList.add(localHiddenChatEntity);
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e("tag_hidden_chat", 2, localThrowable, new Object[0]);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      HiddenChatEntity localHiddenChatEntity = (HiddenChatEntity)localIterator.next();
      localStringBuilder.append(localHiddenChatEntity.jdField_a_of_type_JavaLangString).append("|").append(localHiddenChatEntity.jdField_a_of_type_Int).append(";");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("KeyHiddenChatList", localStringBuilder.toString()).commit();
  }
  
  public void a(Activity paramActivity)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (!((SharedPreferences)localObject).getBoolean("FirstSetHidden", false))
    {
      ((SharedPreferences)localObject).edit().putBoolean("FirstSetHidden", true).commit();
      if (!PrivacySettingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label141;
      }
    }
    label141:
    for (localObject = paramActivity.getString(2131696331);; localObject = paramActivity.getString(2131696330))
    {
      DialogUtil.a(paramActivity, 230, paramActivity.getString(2131696333), (CharSequence)localObject, paramActivity.getString(2131719347), paramActivity.getString(2131696332), new HiddenChatManager.1(this, paramActivity), new DialogUtil.DialogOnClickAdapter()).show();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A349", "0X800A349", 0, 0, "0", "0", "", "");
      return;
    }
  }
  
  void a(HiddenChatEntity paramHiddenChatEntity)
  {
    if ((paramHiddenChatEntity == null) || (TextUtils.isEmpty(paramHiddenChatEntity.jdField_a_of_type_JavaLangString))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramHiddenChatEntity.jdField_a_of_type_JavaLangString, paramHiddenChatEntity);
      a();
      return;
    }
  }
  
  void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      a();
      return;
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      a(a(paramString, paramInt));
      return;
    }
    a(paramString);
  }
  
  boolean a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a();
        if (QLog.isColorLevel())
        {
          if (localObject1 != null)
          {
            i = ((List)localObject1).size();
            QLog.d("tag_hidden_chat", 2, new Object[] { "doInitAllHidden(), dataList.size is ", Integer.valueOf(i) });
          }
        }
        else
        {
          if (localObject1 == null) {
            break label158;
          }
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            HiddenChatEntity localHiddenChatEntity = (HiddenChatEntity)((Iterator)localObject1).next();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localHiddenChatEntity.jdField_a_of_type_JavaLangString, localHiddenChatEntity);
          }
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("tag_hidden_chat", 2, "doInitAllHidden exception:" + localException.getMessage());
        }
        return false;
      }
    }
    label158:
    return true;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatManager
 * JD-Core Version:    0.7.0.1
 */