package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationHandler;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyApplicantInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public class TroopNotificationApplicantInfoController
  extends ITroopNotificationController
{
  private Map<Long, TroopNotifyApplicantInfo> a;
  private Map<String, ConcurrentHashMap<Long, Integer>> b = new ConcurrentHashMap();
  
  public TroopNotificationApplicantInfoController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private List<TroopNotifyApplicantInfo> a(List<oidb_0x5eb.UdcUinData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (oidb_0x5eb.UdcUinData)localIterator.next();
        if (localObject != null)
        {
          long l = ((oidb_0x5eb.UdcUinData)localObject).uint64_uin.get();
          int i = ((oidb_0x5eb.UdcUinData)localObject).uint32_age.get();
          label99:
          String str1;
          label123:
          String str2;
          label147:
          int j;
          if (((oidb_0x5eb.UdcUinData)localObject).bytes_country.has())
          {
            paramList = ((oidb_0x5eb.UdcUinData)localObject).bytes_country.get().toStringUtf8();
            if (!((oidb_0x5eb.UdcUinData)localObject).bytes_province.has()) {
              break label261;
            }
            str1 = ((oidb_0x5eb.UdcUinData)localObject).bytes_province.get().toStringUtf8();
            if (!((oidb_0x5eb.UdcUinData)localObject).bytes_city.has()) {
              break label268;
            }
            str2 = ((oidb_0x5eb.UdcUinData)localObject).bytes_city.get().toStringUtf8();
            j = ((oidb_0x5eb.UdcUinData)localObject).uint32_gender.get();
            if ((((oidb_0x5eb.UdcUinData)localObject).uint32_400_flag.get() != 1) && (((oidb_0x5eb.UdcUinData)localObject).uint32_business_user.get() != 1)) {
              break label275;
            }
          }
          label261:
          label268:
          label275:
          for (boolean bool = true;; bool = false)
          {
            localObject = (TroopNotifyApplicantInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
            if (localObject == null) {
              break label281;
            }
            ((TroopNotifyApplicantInfo)localObject).b(j);
            ((TroopNotifyApplicantInfo)localObject).c(str2);
            ((TroopNotifyApplicantInfo)localObject).a(paramList);
            ((TroopNotifyApplicantInfo)localObject).b(str1);
            ((TroopNotifyApplicantInfo)localObject).a(i);
            ((TroopNotifyApplicantInfo)localObject).a(true);
            ((TroopNotifyApplicantInfo)localObject).c(bool);
            break;
            paramList = "";
            break label99;
            str1 = "";
            break label123;
            str2 = "";
            break label147;
          }
          label281:
          localArrayList.add(new TroopNotifyApplicantInfo(l, i, paramList, str1, str2, j, bool, true));
        }
      }
    }
    return localArrayList;
  }
  
  private void c(String paramString, List<Long> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramString = (ConcurrentHashMap)this.b.get(paramString);
      if (paramString != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          paramString.remove((Long)paramList.next());
        }
      }
    }
  }
  
  public TroopNotifyApplicantInfo a(Long paramLong)
  {
    TroopNotifyApplicantInfo localTroopNotifyApplicantInfo = (TroopNotifyApplicantInfo)this.jdField_a_of_type_JavaUtilMap.get(paramLong);
    paramLong = localTroopNotifyApplicantInfo;
    if (localTroopNotifyApplicantInfo != null) {
      paramLong = localTroopNotifyApplicantInfo.a();
    }
    return paramLong;
  }
  
  public ArrayList<Long> a(List<oidb_0x5eb.UdcUinData> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return null;
      localObject = a(paramList);
    } while ((localObject == null) || (((List)localObject).isEmpty()));
    paramList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopNotifyApplicantInfo localTroopNotifyApplicantInfo = (TroopNotifyApplicantInfo)((Iterator)localObject).next();
      if (localTroopNotifyApplicantInfo != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localTroopNotifyApplicantInfo.a()), localTroopNotifyApplicantInfo);
        paramList.add(Long.valueOf(localTroopNotifyApplicantInfo.a()));
      }
    }
    return paramList;
  }
  
  public List<Long> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = (ConcurrentHashMap)this.b.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if ((localLong != null) && (((Integer)paramString.get(localLong)).intValue() == 0))
      {
        localArrayList.add(localLong);
        paramString.put(localLong, Integer.valueOf(1));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(long paramLong, int paramInt)
  {
    TroopNotifyApplicantInfo localTroopNotifyApplicantInfo = (TroopNotifyApplicantInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localTroopNotifyApplicantInfo != null)
    {
      localTroopNotifyApplicantInfo.c(paramInt);
      localTroopNotifyApplicantInfo.b(true);
      return;
    }
    localTroopNotifyApplicantInfo = new TroopNotifyApplicantInfo(paramLong, paramInt, true);
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localTroopNotifyApplicantInfo);
  }
  
  public void a(Long paramLong, int paramInt, String paramString)
  {
    if ((paramLong == null) || (TextUtils.isEmpty(paramString))) {}
    ConcurrentHashMap localConcurrentHashMap1;
    do
    {
      return;
      ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.b.get(paramString);
      localConcurrentHashMap1 = localConcurrentHashMap2;
      if (localConcurrentHashMap2 == null)
      {
        localConcurrentHashMap1 = new ConcurrentHashMap();
        this.b.put(paramString, localConcurrentHashMap1);
      }
    } while (localConcurrentHashMap1.contains(paramLong));
    localConcurrentHashMap1.put(paramLong, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, List<Long> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ThreadManager.postImmediately(new TroopNotificationApplicantInfoController.1(this, paramString, paramList), null, false);
  }
  
  public void a(List<Long> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      b(paramString, paramList);
      return;
    }
    TroopNotificationHandler localTroopNotificationHandler = (TroopNotificationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_NOTIFICATION_HANDLER);
    if (localTroopNotificationHandler == null)
    {
      b(paramString, paramList);
      return;
    }
    int i = paramList.size();
    if (i > 70)
    {
      label68:
      ArrayList localArrayList;
      if (i > 0)
      {
        if (i <= 70) {
          break label114;
        }
        localArrayList = new ArrayList(paramList.subList(i - 70, i));
        i -= 70;
      }
      for (;;)
      {
        localTroopNotificationHandler.a(localArrayList, paramString);
        break label68;
        break;
        label114:
        localArrayList = new ArrayList(paramList.subList(0, i));
        i = 0;
      }
    }
    localTroopNotificationHandler.a(paramList, paramString);
  }
  
  public void b()
  {
    super.b();
    this.b.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(String paramString, List<Long> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    Object localObject = (ConcurrentHashMap)this.b.get(paramString);
    if (localObject == null)
    {
      localObject = new ConcurrentHashMap();
      this.b.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (Long)paramList.next();
        if (localObject != null) {
          paramString.put(localObject, Integer.valueOf(0));
        }
      }
      break;
    }
  }
  
  public void c()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationApplicantInfoController
 * JD-Core Version:    0.7.0.1
 */