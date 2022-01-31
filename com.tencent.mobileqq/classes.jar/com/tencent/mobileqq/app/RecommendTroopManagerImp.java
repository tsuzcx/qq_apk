package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecTroopBusinessItem;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.RecommendTroopMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.AddFeedbackHateGroupCmd;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.ReqBody;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.GroupLabel;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.ReqBody;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.RgroupInfo;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.qun.group_activity.group_activity.GroupAct;
import zit;
import ziu;
import ziv;

public class RecommendTroopManagerImp
  implements Manager
{
  protected int a;
  SharedPreferences a;
  public SparseArray a;
  protected QQAppInterface a;
  protected TroopHandler a;
  protected EntityManager a;
  protected Object a;
  protected final String a;
  protected List a;
  protected SparseArray b;
  protected final String b;
  
  public RecommendTroopManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangString = "recommendtroop_notification";
    this.jdField_b_of_type_JavaLangString = "recommendtroop_notification_status";
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("recommend_troop_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().b(AppConstants.U, 4001);
    int j;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      j = 0;
      return j;
    }
    paramQQAppInterface = paramQQAppInterface.iterator();
    int i = 0;
    label40:
    if (paramQQAppInterface.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.next();
      String str = localMessageRecord.msg;
      if ((str == null) || (str.length() <= 0) || ((localMessageRecord.msgtype != -1039) && (localMessageRecord.msgtype != -1040)) || (localMessageRecord.extStr == null) || (localMessageRecord.extStr.length() <= 0) || (localMessageRecord.isread)) {
        break label164;
      }
      i += 1;
    }
    label164:
    for (;;)
    {
      break label40;
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecommendTroopManagerImp", 2, "getRecommendUnreadCount" + i);
      return i;
    }
  }
  
  private void a(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecommendTroopManagerImp", 2, "parseRecommendTroop OIDBSSOPkg error");
        }
      }
      else
      {
        paramArrayOfByte = new oidb_0x9fb.RspBody();
        paramArrayOfByte.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.d("RecommendTroopManagerImp", 2, "parseRecommendTroop uint32_result=" + paramArrayOfByte.uint32_result.get());
        }
        if ((paramArrayOfByte.uint32_result.get() == 0) && (paramInt != 1) && (paramInt == 2))
        {
          ThreadManager.post(new ziu(this, paramLong, paramArrayOfByte), 8, null, true);
          return;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("RecommendTroopManagerImp", 2, "parseRecommendTroop sso error");
      }
    }
  }
  
  private void a(long paramLong, oidb_0x9fb.RspBody paramRspBody)
  {
    Object localObject2 = paramRspBody.msg_groups.get();
    if (localObject2 == null) {
      return;
    }
    if (paramLong == 0L) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NotificationRecommendTroopItem.class);
    }
    paramRspBody = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    paramRspBody.a();
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      oidb_0x9fb.RgroupInfo localRgroupInfo = (oidb_0x9fb.RgroupInfo)((Iterator)localObject2).next();
      NotificationRecommendTroopItem localNotificationRecommendTroopItem = new NotificationRecommendTroopItem();
      if (localRgroupInfo.uint64_group_code.has())
      {
        localNotificationRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
        if (localRgroupInfo.bytes_group_name.has()) {
          localNotificationRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
        }
        if (localRgroupInfo.bytes_group_memo.has()) {
          localNotificationRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
        }
        if (localRgroupInfo.bytes_recommend_reason.has()) {
          localNotificationRecommendTroopItem.recommendReason = new String(localRgroupInfo.bytes_recommend_reason.get().toByteArray());
        }
        localNotificationRecommendTroopItem.labelList = localRgroupInfo.rpt_group_label.get();
        localNotificationRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
        localNotificationRecommendTroopItem.x9fbRgroupInfo = localRgroupInfo.toByteArray();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localNotificationRecommendTroopItem);
        localArrayList.add(localNotificationRecommendTroopItem);
      }
    }
    try
    {
      paramRspBody.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecommendTroopManagerImp", 2, "saveNotificationRecommendTroop commit errror");
        }
        paramRspBody.b();
      }
    }
    finally
    {
      paramRspBody.b();
    }
    if (localArrayList.size() > 0)
    {
      a(localArrayList);
      a(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(29, true, localArrayList);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new ziv(paramAppInterface, paramInt, paramString), 5, null, true);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      long l = Long.valueOf(paramString).longValue();
      Object localObject1 = new oidb_0x9fa.ReqBody();
      ((oidb_0x9fa.ReqBody)localObject1).uint32_appid.set(1);
      ((oidb_0x9fa.ReqBody)localObject1).int32_channel.set(paramInt);
      Object localObject2 = new oidb_0x9fa.AddFeedbackHateGroupCmd();
      ((oidb_0x9fa.AddFeedbackHateGroupCmd)localObject2).uint64_group_code.add(Long.valueOf(l));
      ((oidb_0x9fa.ReqBody)localObject1).msg_add_hate_group.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2554);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9fa.ReqBody)localObject1).toByteArray()));
      localObject1 = new NewIntent(paramAppInterface.getApplication(), ProtoServlet.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x9fa_0");
      ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(paramBusinessObserver);
      paramAppInterface.startServlet((NewIntent)localObject1);
      a(paramAppInterface, paramInt, paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("recommend_troop_info" + paramQQAppInterface.getAccount(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_recommend_troop_count", 0);
    }
    return i;
  }
  
  private void c()
  {
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    try
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("unread_recommend_troop_count", i).commit();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.S, 9000, b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      Object localObject = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
      MessageRecord localMessageRecord = a();
      if ((localMessageRecord != null) && (!((RecentManagerFor3rdPart)localObject).a(AppConstants.S, 9000, localMessageRecord.time))) {
        ((RecentManagerFor3rdPart)localObject).a(AppConstants.S, 9000, "群通知", localMessageRecord.time, localMessageRecord.time);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1009));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(RecommendTroopView.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(105));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendTroopManagerImp", 2, "update troopRecommendUnreadCount failed! + msg = " + localException.getMessage());
        }
      }
    }
  }
  
  private void d()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ContactListView.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(1);
      localMqqHandler.sendEmptyMessageDelayed(1, 100L);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int != -1) {
      return this.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("recommendtroop_notification", 0).getInt("recommendtroop_notification_status", 0);
    }
    return this.jdField_a_of_type_Int;
  }
  
  public MessageRecord a()
  {
    try
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.U, 4001);
      if ((localList != null) && (localList.size() > 0))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
          if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null))
          {
            int j = localMessageRecord.msg.length();
            if (j > 0) {
              return localMessageRecord;
            }
          }
          i -= 1;
        }
      }
      return null;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public String a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.U, 4001);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i);
          if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null) && (localMessageRecord.msg.length() > 0))
          {
            localObject = localMessageRecord.msg;
            return localObject;
          }
          i -= 1;
        }
      }
      return "";
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public List a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.U, 4001);
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = localList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      Object localObject = localMessageRecord.msg;
      RecommendTroopMsg localRecommendTroopMsg;
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if ((localMessageRecord.msgtype != -1039) || (localMessageRecord.extStr == null) || (localMessageRecord.extStr.length() <= 0)) {
          break label240;
        }
        localObject = (RecommendTroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class, localMessageRecord.extStr);
        if (localObject == null) {
          break label212;
        }
        localRecommendTroopMsg = new RecommendTroopMsg();
        localRecommendTroopMsg.uniseq = localMessageRecord.uniseq;
        localRecommendTroopMsg.msgtype = localMessageRecord.msgtype;
        localRecommendTroopMsg.isRead = localMessageRecord.isread;
        localRecommendTroopMsg.timeStamp = localMessageRecord.time;
        localRecommendTroopMsg.troop = ((RecommendTroopInfo)localObject);
        localArrayList.add(localRecommendTroopMsg);
      }
      for (;;)
      {
        i -= 1;
        break;
        label212:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        continue;
        label240:
        if ((localMessageRecord.msgtype == -1040) && (localMessageRecord.extStr != null) && (localMessageRecord.extStr.length() > 0))
        {
          localObject = (RecTroopBusinessItem)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecTroopBusinessItem.class, localMessageRecord.extStr);
          if (localObject != null)
          {
            localRecommendTroopMsg = new RecommendTroopMsg();
            localRecommendTroopMsg.uniseq = localMessageRecord.uniseq;
            localRecommendTroopMsg.msgtype = localMessageRecord.msgtype;
            localRecommendTroopMsg.isRead = localMessageRecord.isread;
            localRecommendTroopMsg.timeStamp = localMessageRecord.time;
            localRecommendTroopMsg.rtbItem = ((RecTroopBusinessItem)localObject);
            localArrayList.add(localRecommendTroopMsg);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(-1039);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(-1040);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("unread_recommend_troop_count", 0).commit();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "updateDBStatsus:" + paramInt);
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("recommendtroop_notification", 0).edit();
    localEditor.putInt("recommendtroop_notification_status", paramInt);
    localEditor.commit();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "getRecommendTroopFromServer() start getRecommendTroopFromServer");
    }
    if ((this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1) != null) && (((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1)).booleanValue())) {}
    long l;
    do
    {
      return;
      paramLong = 0L;
      if (this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1) != null) {
        paramLong = ((Long)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1)).longValue();
      }
      l = System.currentTimeMillis() / 1000L;
    } while ((paramLong > 0L) && (l - paramLong < 60L));
    this.jdField_b_of_type_AndroidUtilSparseArray.append(paramInt1, Long.valueOf(l));
    this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt1, Boolean.valueOf(true));
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "getRecommendTroopFromServer() start");
    }
    Object localObject2 = new oidb_0x9fb.GroupLabel();
    ((oidb_0x9fb.GroupLabel)localObject2).uint32_label_style.set(1);
    Object localObject1 = new oidb_0x9fb.ReqBody();
    ((oidb_0x9fb.ReqBody)localObject1).uint32_appid.set(1);
    ((oidb_0x9fb.ReqBody)localObject1).int32_channel.set(paramInt1);
    ((oidb_0x9fb.ReqBody)localObject1).uint32_reason.set(paramInt2);
    ((oidb_0x9fb.ReqBody)localObject1).msg_group_label.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2555);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9fb.ReqBody)localObject1).toByteArray()));
    localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject1).setWithouLogin(true);
    ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x9fb_0");
    ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((NewIntent)localObject1).setObserver(paramBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    a(2, paramLong, paramInt, new zit(this, paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.U, 4001);
    if ((localList != null) && (localList.size() > 0))
    {
      i = localList.size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
        if ((localMessageRecord.msgtype == -1039) && (!TextUtils.isEmpty(localMessageRecord.extStr)) && (localMessageRecord.extStr.equals(paramString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          localList.remove(i);
        }
        i -= 1;
      }
    }
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("unread_recommend_troop_count", i).commit();
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1039);
    ArrayList localArrayList = new ArrayList();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject1 = new HashMap();
    int i = localArrayList.size();
    int j = paramArrayList.size() - 1;
    Object localObject2;
    int k;
    if (j >= 0)
    {
      localObject2 = (RecommendTroopItem)paramArrayList.get(j);
      if (localObject2 == null) {}
      do
      {
        j -= 1;
        break;
        MessageRecord localMessageRecord = MessageRecordFactory.a(-1039);
        String str = ((RecommendTroopItem)localObject2).name;
        localMessageRecord.extStr = ((RecommendTroopItem)localObject2).uin;
        localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), AppConstants.U, "0", str, l, -1039, 4001, 0L);
        localArrayList.add(localMessageRecord);
        ((HashMap)localObject1).put(((RecommendTroopItem)localObject2).uin, Integer.valueOf(1));
        k = i + 1;
        i = k;
      } while (k < 60);
    }
    int m;
    if ((localArrayList.size() >= 1) || (localArrayList.size() == 1))
    {
      m = 60 - localArrayList.size();
      if (m > 0) {
        break label285;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1039);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      c();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Grp_recom_push", 0, 0, "", "", "", "");
      return;
      label285:
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.U, 4001);
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        i = paramArrayList.size() - 1;
        while (i >= 0)
        {
          localObject2 = (MessageRecord)paramArrayList.get(i);
          if ((((MessageRecord)localObject2).msgtype == -1039) && (((HashMap)localObject1).containsKey(((MessageRecord)localObject2).extStr)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
            paramArrayList.remove(i);
          }
          i -= 1;
        }
        j = 0;
        k = paramArrayList.size() - 1;
        while (k >= 0)
        {
          localObject1 = (MessageRecord)paramArrayList.get(k);
          i = j;
          if (((MessageRecord)localObject1).msgtype == -1039)
          {
            j += 1;
            i = j;
            if (j > m)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
              localObject1 = (RecommendTroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class, ((MessageRecord)localObject1).extStr);
              i = j;
              if (localObject1 != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
                i = j;
              }
            }
          }
          k -= 1;
          j = i;
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramList != null)
    {
      localObject1 = localObject3;
      if (paramList.size() != 0)
      {
        paramList = (group_activity.GroupAct)paramList.get(0);
        localObject1 = localObject3;
        if (paramList != null)
        {
          localObject1 = new RecTroopBusinessItem();
          ((RecTroopBusinessItem)localObject1).id = String.valueOf(paramList.uint32_act_id.get());
          ((RecTroopBusinessItem)localObject1).title = paramList.string_title.get();
          ((RecTroopBusinessItem)localObject1).des = paramList.string_des.get();
          ((RecTroopBusinessItem)localObject1).jumpType = paramList.uint32_jumptype.get();
          ((RecTroopBusinessItem)localObject1).jumpUrl = paramList.string_url.get();
          ((RecTroopBusinessItem)localObject1).jumpParam = paramList.string_jumpparam.get();
          ((RecTroopBusinessItem)localObject1).iconUrl = paramList.string_iconurl.get();
          ((RecTroopBusinessItem)localObject1).btnText = paramList.string_btntext.get();
          ((RecTroopBusinessItem)localObject1).startTime = paramList.uint32_start_time.get();
          ((RecTroopBusinessItem)localObject1).endTime = paramList.uint32_end_time.get();
          ((RecTroopBusinessItem)localObject1).timeStamp = l;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
        }
      }
    }
    int i;
    EntityTransaction localEntityTransaction;
    if (localObject1 == null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecTroopBusinessItem.class, false, null, null, null, null, "timeStamp desc", null);
      if ((localObject3 != null) && (((List)localObject3).size() != 0))
      {
        paramList = (RecTroopBusinessItem)((List)localObject3).get(0);
        if (((List)localObject3).size() > 60)
        {
          i = ((List)localObject3).size() - 1;
          while (i >= 60)
          {
            localObject1 = (RecTroopBusinessItem)((List)localObject3).get(i);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
            i -= 1;
          }
        }
        if (paramList != null)
        {
          localObject1 = MessageRecordFactory.a(-1040);
          ((MessageRecord)localObject1).extStr = paramList.id;
          ((MessageRecord)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), AppConstants.U, "0", paramList.title, l, -1040, 4001, 0L);
          localArrayList.add(localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1040);
        }
        localObject3 = new HashMap();
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      }
    }
    for (;;)
    {
      int j;
      int k;
      int m;
      try
      {
        localEntityTransaction.a();
        i = localArrayList.size();
        j = 0;
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject4 = (SearchGroup.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localObject4 == null) || ((localObject4 != null) && (((SearchGroup.GroupInfo)localObject4).dwGroupUin.get() == 0) && (((SearchGroup.GroupInfo)localObject4).dwGroupCode.get() == 0))) {
            break label1383;
          }
          localObject1 = (RecommendTroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class, String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupCode.get()));
          if (localObject1 != null) {
            break label1371;
          }
          localObject1 = new RecommendTroopInfo();
          k = 0;
          ((RecommendTroopInfo)localObject1).code = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupUin.get());
          ((RecommendTroopInfo)localObject1).uin = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupCode.get());
          ((RecommendTroopInfo)localObject1).ownerUin = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupOwnerId.get());
          ((RecommendTroopInfo)localObject1).curMemberNum = ((SearchGroup.GroupInfo)localObject4).dwCurMemberNum.get();
          ((RecommendTroopInfo)localObject1).maxMemberNum = ((SearchGroup.GroupInfo)localObject4).dwMaxMemberNum.get();
          ((RecommendTroopInfo)localObject1).name = ((SearchGroup.GroupInfo)localObject4).sGroupName.get();
          ((RecommendTroopInfo)localObject1).fingerMemo = ((SearchGroup.GroupInfo)localObject4).sGroupFingerMem.get();
          ((RecommendTroopInfo)localObject1).faceId = ((SearchGroup.GroupInfo)localObject4).dwGroupFaceId.get();
          ((RecommendTroopInfo)localObject1).faceUrl = ((SearchGroup.GroupInfo)localObject4).sGroupFaceUrl.get();
          ((RecommendTroopInfo)localObject1).tag = ((SearchGroup.GroupInfo)localObject4).sGroupTag.get();
          ((RecommendTroopInfo)localObject1).classId = ((SearchGroup.GroupInfo)localObject4).dwGroupClass.get();
          ((RecommendTroopInfo)localObject1).classText = ((SearchGroup.GroupInfo)localObject4).sGroupClassText.get();
          ((RecommendTroopInfo)localObject1).level = ((SearchGroup.GroupInfo)localObject4).dwGroupLevel.get();
          ((RecommendTroopInfo)localObject1).isSameCity = ((SearchGroup.GroupInfo)localObject4).bSameCity.get();
          ((RecommendTroopInfo)localObject1).isTroopFull = ((SearchGroup.GroupInfo)localObject4).bGroupFull.get();
          ((RecommendTroopInfo)localObject1).isTroopAllow = ((SearchGroup.GroupInfo)localObject4).bGroupAllow.get();
          ((RecommendTroopInfo)localObject1).isTroopIn = ((SearchGroup.GroupInfo)localObject4).bGroupIn.get();
          ((RecommendTroopInfo)localObject1).hotDegree = ((SearchGroup.GroupInfo)localObject4).dwGroupHotDegree.get();
          ((RecommendTroopInfo)localObject1).flagExt = ((SearchGroup.GroupInfo)localObject4).dwGroupFlagExt.get();
          ((RecommendTroopInfo)localObject1).authType = ((SearchGroup.GroupInfo)localObject4).dwAuthGroupType.get();
          ((RecommendTroopInfo)localObject1).location = ((SearchGroup.GroupInfo)localObject4).sGroupLocation.get();
          ((RecommendTroopInfo)localObject1).option = ((short)((SearchGroup.GroupInfo)localObject4).dwGroupOption.get());
          if (k != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
          localObject4 = MessageRecordFactory.a(-1039);
          String str = ((RecommendTroopInfo)localObject1).name;
          ((MessageRecord)localObject4).extStr = ((RecommendTroopInfo)localObject1).uin;
          ((MessageRecord)localObject4).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), AppConstants.U, "0", str, l, -1039, 4001, 0L);
          localArrayList.add(localObject4);
          ((HashMap)localObject3).put(((RecommendTroopInfo)localObject1).uin, Integer.valueOf(1));
          k = i + 1;
          i = k;
          if (k < 60) {
            break label1383;
          }
        }
        localEntityTransaction.c();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      if ((localArrayList.size() >= 1) || ((localArrayList.size() == 1) && (paramList == null)))
      {
        m = 60 - localArrayList.size();
        if (m <= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1039);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        d();
        c();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Grp_recom_push", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
        continue;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.U, 4001);
      if ((paramList != null) && (paramList.size() > 0))
      {
        i = paramList.size() - 1;
        Object localObject2;
        while (i >= 0)
        {
          localObject2 = (MessageRecord)paramList.get(i);
          if ((((MessageRecord)localObject2).msgtype == -1039) && (((HashMap)localObject3).containsKey(((MessageRecord)localObject2).extStr)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
            paramList.remove(i);
          }
          i -= 1;
        }
        j = 0;
        k = paramList.size() - 1;
        while (k >= 0)
        {
          localObject2 = (MessageRecord)paramList.get(k);
          i = j;
          if (((MessageRecord)localObject2).msgtype == -1039)
          {
            j += 1;
            i = j;
            if (j > m)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
              localObject2 = (RecommendTroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class, ((MessageRecord)localObject2).extStr);
              i = j;
              if (localObject2 != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject2);
                i = j;
              }
            }
          }
          k -= 1;
          j = i;
        }
        continue;
        label1371:
        k = 1;
        continue;
        paramList = (List)localObject2;
        break;
        label1383:
        j += 1;
      }
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(0L, 2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "push", 0, 0, "", "", "", "");
      return true;
    }
  }
  
  public List b()
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NotificationRecommendTroopItem.class, false, null, new String[0], null, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    return localList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NotificationRecommendTroopItem.class);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1039);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1040);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("unread_recommend_troop_count", 0).commit();
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    a(paramList);
  }
  
  public boolean b()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.U, 4001);
    if (localList == null) {
      return false;
    }
    int i = localList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if (localMessageRecord == null) {}
      String str;
      do
      {
        i -= 1;
        break;
        str = localMessageRecord.msg;
      } while ((str == null) || (str.length() <= 0) || (localMessageRecord.msgtype != -1039) || (localMessageRecord.isread));
      return true;
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecommendTroopManagerImp
 * JD-Core Version:    0.7.0.1
 */