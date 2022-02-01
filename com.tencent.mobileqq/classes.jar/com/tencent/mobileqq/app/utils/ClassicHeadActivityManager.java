package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class ClassicHeadActivityManager
  implements Manager
{
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, ClassicHeadActivityManager.HeadInfoItem> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private long jdField_b_of_type_Long = -1L;
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public ClassicHeadActivityManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
    a();
  }
  
  private void c(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = 0;
    localObject1 = ((QQAppInterface)localObject1).getQQHeadSetting(4, paramString, 0);
    int i;
    if ((localObject1 != null) && (((Pair)localObject1).second != null))
    {
      localObject1 = (Setting)((Pair)localObject1).second;
      j = ((Setting)localObject1).systemHeadID;
      i = ((Setting)localObject1).bHeadType;
    }
    else
    {
      i = 0;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" QQ 18 handle handleUpdateStrangerHeadReal uin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",localHeadID=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(",localType=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder(1000);
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(" QQ 18 handle mHeadIdMap: uin=");
        ((StringBuilder)localObject1).append((String)localEntry.getKey());
        ((StringBuilder)localObject1).append(",headid=");
        ((StringBuilder)localObject1).append(((ClassicHeadActivityManager.HeadInfoItem)localEntry.getValue()).jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(",type=");
        ((StringBuilder)localObject1).append(((ClassicHeadActivityManager.HeadInfoItem)localEntry.getValue()).b);
        ((StringBuilder)localObject1).append(",isRequest=");
        ((StringBuilder)localObject1).append(((ClassicHeadActivityManager.HeadInfoItem)localEntry.getValue()).jdField_a_of_type_Boolean);
        ((StringBuilder)localObject1).append(",saveTime=");
        ((StringBuilder)localObject1).append(((ClassicHeadActivityManager.HeadInfoItem)localEntry.getValue()).jdField_a_of_type_Long);
        ((StringBuilder)localObject1).append("\n");
        QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      localObject1 = (ClassicHeadActivityManager.HeadInfoItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localObject1 != null)
      {
        int k = ((ClassicHeadActivityManager.HeadInfoItem)localObject1).jdField_a_of_type_Int;
        int m = ((ClassicHeadActivityManager.HeadInfoItem)localObject1).b;
        if (((m == 0) && (k != j)) || ((m != i) && (!((ClassicHeadActivityManager.HeadInfoItem)localObject1).jdField_a_of_type_Boolean)))
        {
          ((ClassicHeadActivityManager.HeadInfoItem)localObject1).jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder(1000);
            ((StringBuilder)localObject2).append("QQ 18 get and update stranger update head uin = ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(",receiveSysid = ");
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append(",receiveType = ");
            ((StringBuilder)localObject2).append(m);
            ((StringBuilder)localObject2).append(",localSysid = ");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(",loaclType = ");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append("\n");
            QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject2).toString());
          }
          ((IQQAvatarHandlerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(paramString);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        if ((k == j) && (m == i) && (((ClassicHeadActivityManager.HeadInfoItem)localObject1).jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(" QQ 18 remove update map uin = ");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append(",receiveSysid = ");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(",localSysid = ");
            ((StringBuilder)localObject1).append(j);
            QLog.d("ClassicHeadActivityManager", 4, ((StringBuilder)localObject1).toString());
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        }
      }
    }
  }
  
  public long a()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("classic_head_activity_switch_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    long l = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), -1L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSwitch key=classic_head_activity_switch value= ");
      ((StringBuilder)localObject).append(l);
      QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject).toString());
    }
    return l;
  }
  
  public Setting a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQHeadSetting(1, (String)localObject, 0);
    if ((localObject != null) && (((Pair)localObject).second != null)) {
      return (Setting)((Pair)localObject).second;
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length == 2))
      {
        this.jdField_a_of_type_Long = ArMapUtil.a(localObject[0]);
        this.jdField_b_of_type_Long = ArMapUtil.a(localObject[1]);
        if (QLog.isColorLevel()) {
          QLog.d("ClassicHeadActivityManager", 2, "parseClassicHeadActivityConfig success");
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseClassicHeadActivityConfig beginTime=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" endTime=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    long l = a();
    if (l != paramLong)
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("classic_head_activity_switch_");
      localStringBuilder.append((String)localObject);
      localEditor.putLong(localStringBuilder.toString(), paramLong);
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, "save Switch Success");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qq18Switch=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" localSwitch=");
      ((StringBuilder)localObject).append(l);
      QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("handleInitValue");
    localStringBuilder.append(" sysId=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" headType=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" qq18Switch=");
    localStringBuilder.append(paramLong3);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    a(paramLong3);
    if (paramLong3 != 1L) {
      return;
    }
    IQQAvatarHandlerService localIQQAvatarHandlerService = (IQQAvatarHandlerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "");
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQHeadSetting(1, str, 0);
    if ((localObject != null) && (((Boolean)((Pair)localObject).first).booleanValue()))
    {
      localIQQAvatarHandlerService.getCustomHead(str);
      localFriendListHandler.notifyUI(3, true, str);
    }
    else if ((localObject != null) && (((Pair)localObject).second != null))
    {
      localObject = (Setting)((Pair)localObject).second;
      paramLong3 = ((Setting)localObject).systemHeadID;
      long l = ((Setting)localObject).bHeadType;
      localStringBuilder.append(" localSysId=");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(" localheadType=");
      localStringBuilder.append(l);
      if ((paramLong2 != l) || ((paramLong2 == 0L) && (paramLong1 != paramLong3)))
      {
        localStringBuilder.append(" fetch userHead");
        localIQQAvatarHandlerService.getCustomHead(str);
        localFriendListHandler.notifyUI(3, true, str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassicHeadActivityManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(ClassicHeadActivityManager.FriendHeadFlagItem paramFriendHeadFlagItem)
  {
    if ((a()) && (paramFriendHeadFlagItem != null))
    {
      StringBuilder localStringBuilder = new StringBuilder("handleFriendHeadFlagItem");
      localStringBuilder.append(" uin=");
      localStringBuilder.append(StringUtil.e(paramFriendHeadFlagItem.jdField_a_of_type_JavaLangString));
      localStringBuilder.append(" sysId=");
      localStringBuilder.append(paramFriendHeadFlagItem.jdField_b_of_type_Long);
      localStringBuilder.append(" headType=");
      localStringBuilder.append(paramFriendHeadFlagItem.c);
      localStringBuilder.append(" qq18Switch=");
      localStringBuilder.append(paramFriendHeadFlagItem.jdField_a_of_type_Long);
      if ((!TextUtils.isEmpty(paramFriendHeadFlagItem.jdField_a_of_type_JavaLangString)) && (paramFriendHeadFlagItem.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramFriendHeadFlagItem.jdField_a_of_type_Long != -1L)) {
        a(paramFriendHeadFlagItem.jdField_a_of_type_Long);
      }
      IQQAvatarHandlerService localIQQAvatarHandlerService = (IQQAvatarHandlerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "");
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQHeadSetting(1, paramFriendHeadFlagItem.jdField_a_of_type_JavaLangString, 0);
      if ((localObject != null) && (((Boolean)((Pair)localObject).first).booleanValue()))
      {
        localIQQAvatarHandlerService.getCustomHead(paramFriendHeadFlagItem.jdField_a_of_type_JavaLangString);
        localFriendListHandler.notifyUI(3, true, paramFriendHeadFlagItem.jdField_a_of_type_JavaLangString);
      }
      else if ((localObject != null) && (((Pair)localObject).second != null))
      {
        localObject = (Setting)((Pair)localObject).second;
        long l1 = ((Setting)localObject).systemHeadID;
        long l2 = ((Setting)localObject).bHeadType;
        localStringBuilder.append(" localsysId=");
        localStringBuilder.append(l1);
        localStringBuilder.append(" localheadType=");
        localStringBuilder.append(l2);
        if (((paramFriendHeadFlagItem.jdField_a_of_type_Long == 1L) && (paramFriendHeadFlagItem.c != -1L) && (paramFriendHeadFlagItem.c != l2)) || ((paramFriendHeadFlagItem.jdField_b_of_type_Long != -1L) && (paramFriendHeadFlagItem.jdField_b_of_type_Long != l1) && (l2 == 0L)))
        {
          localStringBuilder.append(" fetch userHead");
          localIQQAvatarHandlerService.getCustomHead(paramFriendHeadFlagItem.jdField_a_of_type_JavaLangString);
          localFriendListHandler.notifyUI(3, true, paramFriendHeadFlagItem.jdField_a_of_type_JavaLangString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(paramString)))
      {
        localObject = (ClassicHeadActivityManager.HeadInfoItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if ((localObject != null) && (((ClassicHeadActivityManager.HeadInfoItem)localObject).jdField_a_of_type_Boolean))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" QQ 18 handle handleGetHeadError uin=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",HeadID=");
          localStringBuilder.append(((ClassicHeadActivityManager.HeadInfoItem)localObject).jdField_a_of_type_Int);
          localStringBuilder.append(",Type=");
          localStringBuilder.append(((ClassicHeadActivityManager.HeadInfoItem)localObject).b);
          localStringBuilder.append(",IsRequest=");
          localStringBuilder.append(((ClassicHeadActivityManager.HeadInfoItem)localObject).jdField_a_of_type_Boolean);
          QLog.d("ClassicHeadActivityManager", 2, localStringBuilder.toString());
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null)
      {
        int j = 0;
        localObject = ((QQAppInterface)localObject).getQQHeadSetting(4, paramString, 0);
        int i;
        if ((localObject != null) && (((Pair)localObject).second != null))
        {
          localObject = (Setting)((Pair)localObject).second;
          j = ((Setting)localObject).systemHeadID;
          i = ((Setting)localObject).bHeadType;
        }
        else
        {
          i = 0;
        }
        if ((paramInt1 == j) && (paramInt2 == i))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" QQ 18 saveReceiveSysHeadId found same, remove uin=");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(", syid=");
              ((StringBuilder)localObject).append(paramInt1);
              ((StringBuilder)localObject).append(",headType=");
              ((StringBuilder)localObject).append(paramInt2);
              QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject).toString());
            }
          }
          return;
        }
        localObject = new ClassicHeadActivityManager.HeadInfoItem(paramString, paramInt1, paramInt2);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(" QQ 18 saveReceiveSysHeadId save uin=");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", syid=");
            ((StringBuilder)localObject).append(paramInt1);
            ((StringBuilder)localObject).append(",headType=");
            ((StringBuilder)localObject).append(paramInt2);
            QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          ClassicHeadActivityManager.HeadInfoItem localHeadInfoItem = (ClassicHeadActivityManager.HeadInfoItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localHeadInfoItem != null)
          {
            i = localHeadInfoItem.jdField_a_of_type_Int;
            j = localHeadInfoItem.b;
            if (((paramInt2 == 0) && (paramInt1 != i)) || (j != paramInt2))
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(" QQ 18 saveReceiveSysHeadId save uin=");
                ((StringBuilder)localObject).append(paramString);
                ((StringBuilder)localObject).append(", syid=");
                ((StringBuilder)localObject).append(paramInt1);
                ((StringBuilder)localObject).append(",headType=");
                ((StringBuilder)localObject).append(paramInt2);
                QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    long l1 = MessageCache.a() * 1000L;
    long l2 = this.jdField_a_of_type_Long;
    if (l2 != -1L)
    {
      long l3 = this.jdField_b_of_type_Long;
      if ((l3 != -1L) && (l1 > l2) && (l1 < l3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClassicHeadActivityManager", 2, "ClassicHeadActivityActivate is activate");
        }
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" QQ 18 handle actionB cached stranger head uin = ");
          localStringBuilder.append((String)localEntry.getKey());
          QLog.d("ClassicHeadActivityManager", 2, localStringBuilder.toString());
        }
        c((String)localEntry.getKey());
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle actionB cached stranger head update finished");
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" QQ 18 handleUpdateStrangerHead strangerUin = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (((String)localObject).equals(paramString))
      {
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        if ((paramString != null) && (paramString.containsKey(localObject))) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handleUpdateStrangerHead remove current user ");
        }
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.b()))
      {
        localObject = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        if ((localObject != null) && (!((ConcurrentHashMap)localObject).containsKey(paramString))) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, "");
        }
        return;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0)) {
        c(paramString);
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.ClassicHeadActivityManager
 * JD-Core Version:    0.7.0.1
 */