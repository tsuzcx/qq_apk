package com.tencent.mobileqq.applets;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletItem.Builder;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.applets.data.AppletsSetting;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.Item;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.ReqBody;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.RspBody;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.Setting;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.GetUinInfoReq;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.GetUinInfoRsp;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.ReqBody;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.RspBody;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.UinInfo;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowReq;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.ReqBody;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.UnFollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.UnfollowReq;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqconnect.Appinfo;

public class AppletsHandler
  extends BusinessHandler
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public AppletsHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.mExJsonObject != null)) {
      return paramMessageRecord.mExJsonObject.optString("appid");
    }
    return null;
  }
  
  private List<MessageRecord> a()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a((String)localObject, 1038);
    long l1 = l2;
    if (l2 > System.currentTimeMillis()) {
      l1 = -1L;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(1038).a((String)localObject, 1038, l1);
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (ChatMessage)localIterator.next();
        if (!((ChatMessage)localObject).isread) {
          localArrayList.add(localObject);
        }
      }
    }
    localObject = null;
    return localObject;
  }
  
  private <T extends MessageRecord> Map<String, Integer> a(List<T> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localHashMap;
        if (!localIterator.hasNext()) {
          break;
        }
        String str = a((MessageRecord)localIterator.next());
        if (!TextUtils.isEmpty(str))
        {
          paramList = (Integer)localHashMap.get(str);
          if (paramList != null) {
            paramList = Integer.valueOf(paramList.intValue() + 1);
          } else {
            paramList = Integer.valueOf(1);
          }
          localHashMap.put(str, paramList);
        }
      }
    }
    paramList = null;
    return paramList;
  }
  
  private oidb_sso.OIDBSSOPkg a(ArrayList<AppletItem> paramArrayList, boolean paramBoolean)
  {
    oidb_cmd0xc76.ReqBody localReqBody = new oidb_cmd0xc76.ReqBody();
    localReqBody.cmd.set(2);
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AppletItem localAppletItem = (AppletItem)paramArrayList.next();
      oidb_cmd0xc76.Item localItem = new oidb_cmd0xc76.Item();
      if (paramBoolean)
      {
        localItem.puin.set(Long.parseLong(localAppletItem.c()));
        localItem.name.set(localAppletItem.a());
        localItem.value.set(localAppletItem.b());
      }
      else
      {
        localItem.id.set(localAppletItem.a());
        localItem.type.set(localAppletItem.a());
        localItem.value.set(localAppletItem.b());
      }
      localArrayList.add(localItem);
    }
    localReqBody.apps.set(localArrayList);
    paramArrayList = new oidb_sso.OIDBSSOPkg();
    paramArrayList.uint32_command.set(3190);
    paramArrayList.uint32_result.set(0);
    paramArrayList.uint32_service_type.set(0);
    paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    return paramArrayList;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      }
      catch (Exception paramObject)
      {
        QLog.w("AppletsHandler", 4, paramObject.getMessage(), paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        QLog.w("AppletsHandler", 4, paramObject.getMessage(), paramObject);
      }
      paramObject = localObject;
      int j = -1;
      int i = j;
      if (paramObject != null)
      {
        i = j;
        if (paramObject.uint32_result.has())
        {
          j = paramObject.uint32_result.get();
          i = j;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handle OidbSvc.0xc76|OIDBSSOPke.result=");
            ((StringBuilder)localObject).append(j);
            QLog.i("AppletsHandler", 2, ((StringBuilder)localObject).toString());
            i = j;
          }
        }
      }
      if (paramToServiceMsg.extraData.getBoolean("public_account_state_changed_flag", false))
      {
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AppletsHandler", 2, "handle OidbSvc.0xc76|OIDBSSOPke  pubacc report successfully!");
          }
          paramObject = paramObject.bytes_bodybuffer.get().toByteArray();
          localObject = new oidb_cmd0xc76.RspBody();
          try
          {
            ((oidb_cmd0xc76.RspBody)localObject).mergeFrom(paramObject);
            if (((oidb_cmd0xc76.RspBody)localObject).cmd.has())
            {
              if (((oidb_cmd0xc76.RspBody)localObject).cmd.get() == 2)
              {
                paramObject = paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
                notifyUI(7, paramFromServiceMsg.isSuccess(), paramObject);
              }
              return;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
          }
        }
        notifyUI(7, false, paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list"));
        return;
      }
      if ((i == 0) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
      {
        paramObject = paramObject.bytes_bodybuffer.get().toByteArray();
        localObject = new oidb_cmd0xc76.RspBody();
        try
        {
          ((oidb_cmd0xc76.RspBody)localObject).mergeFrom(paramObject);
          if (!((oidb_cmd0xc76.RspBody)localObject).cmd.has()) {
            return;
          }
          i = ((oidb_cmd0xc76.RspBody)localObject).cmd.get();
          if (i == 1)
          {
            a(paramToServiceMsg, paramFromServiceMsg, (oidb_cmd0xc76.RspBody)localObject);
            return;
          }
          if (i != 2) {
            return;
          }
          b(paramToServiceMsg, paramFromServiceMsg, (oidb_cmd0xc76.RspBody)localObject);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          QLog.w("AppletsHandler", 4, paramToServiceMsg.getMessage(), paramToServiceMsg);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          QLog.w("AppletsHandler", 4, paramToServiceMsg.getMessage(), paramToServiceMsg);
          return;
        }
      }
      else
      {
        paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          notifyUI(3, false, paramToServiceMsg);
          return;
        }
        notifyUI(2, false, null);
      }
    }
    else
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        notifyUI(3, false, paramToServiceMsg);
        return;
      }
      notifyUI(2, false, null);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_cmd0xc76.RspBody paramRspBody)
  {
    paramToServiceMsg = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramRspBody.main.has())
    {
      paramFromServiceMsg = (oidb_cmd0xc76.Setting)paramRspBody.main.get();
      localObject1 = new ArrayList();
      localObject2 = new AppletsSetting();
      if (paramFromServiceMsg.item.has())
      {
        localObject3 = paramFromServiceMsg.item.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (oidb_cmd0xc76.Item)((Iterator)localObject3).next();
          AppletItem.Builder localBuilder = new AppletItem.Builder();
          if (((oidb_cmd0xc76.Item)localObject4).id.has()) {
            localBuilder.a(((oidb_cmd0xc76.Item)localObject4).id.get());
          }
          if (((oidb_cmd0xc76.Item)localObject4).icon.has()) {
            localBuilder.b(((oidb_cmd0xc76.Item)localObject4).icon.get());
          }
          if (((oidb_cmd0xc76.Item)localObject4).type.has()) {
            localBuilder.a(((oidb_cmd0xc76.Item)localObject4).type.get());
          }
          if (((oidb_cmd0xc76.Item)localObject4).name.has()) {
            localBuilder.a(((oidb_cmd0xc76.Item)localObject4).name.get());
          }
          if (((oidb_cmd0xc76.Item)localObject4).value.has()) {
            localBuilder.b(((oidb_cmd0xc76.Item)localObject4).value.get());
          }
          ((List)localObject1).add(localBuilder.a());
        }
      }
      ((AppletsSetting)localObject2).jdField_a_of_type_JavaUtilList = ((List)localObject1);
      if (paramFromServiceMsg.desc.has()) {
        ((AppletsSetting)localObject2).jdField_a_of_type_JavaLangString = paramFromServiceMsg.desc.get();
      }
      paramToServiceMsg.add(localObject2);
    }
    if (paramRspBody.apps.has())
    {
      paramFromServiceMsg = new ArrayList();
      localObject1 = new AppletsSetting();
      paramRspBody = (oidb_cmd0xc76.Setting)paramRspBody.apps.get();
      if (paramRspBody.item.has())
      {
        localObject2 = paramRspBody.item.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (oidb_cmd0xc76.Item)((Iterator)localObject2).next();
          localObject4 = new AppletItem.Builder();
          if (((oidb_cmd0xc76.Item)localObject3).id.has()) {
            ((AppletItem.Builder)localObject4).a(((oidb_cmd0xc76.Item)localObject3).id.get());
          }
          if (((oidb_cmd0xc76.Item)localObject3).icon.has()) {
            ((AppletItem.Builder)localObject4).b(((oidb_cmd0xc76.Item)localObject3).icon.get());
          }
          if (((oidb_cmd0xc76.Item)localObject3).type.has()) {
            ((AppletItem.Builder)localObject4).a(((oidb_cmd0xc76.Item)localObject3).type.get());
          }
          if (((oidb_cmd0xc76.Item)localObject3).name.has()) {
            ((AppletItem.Builder)localObject4).a(((oidb_cmd0xc76.Item)localObject3).name.get());
          }
          if (((oidb_cmd0xc76.Item)localObject3).value.has()) {
            ((AppletItem.Builder)localObject4).b(((oidb_cmd0xc76.Item)localObject3).value.get());
          }
          paramFromServiceMsg.add(((AppletItem.Builder)localObject4).a());
        }
      }
      ((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList = paramFromServiceMsg;
      if (paramRspBody.desc.has()) {
        ((AppletsSetting)localObject1).jdField_a_of_type_JavaLangString = paramRspBody.desc.get();
      }
      paramToServiceMsg.add(localObject1);
    }
    if (paramToServiceMsg.size() > 0)
    {
      notifyUI(2, true, paramToServiceMsg);
      return;
    }
    notifyUI(2, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
      }
      int j = -1;
      int i = j;
      if (paramToServiceMsg != null)
      {
        i = j;
        if (paramToServiceMsg.uint32_result.has())
        {
          j = paramToServiceMsg.uint32_result.get();
          i = j;
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handle OidbSvc.0xc7a|OIDBSSOPke.result=");
            paramFromServiceMsg.append(j);
            QLog.i("AppletsHandler", 2, paramFromServiceMsg.toString());
            i = j;
          }
        }
      }
      if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramFromServiceMsg = new oidb_cmd0xc7a.RspBody();
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppletsHandler", 2, "onReceive handleGetAppletDetail: onReceive parse fail");
          }
          paramToServiceMsg.printStackTrace();
        }
        if (paramFromServiceMsg.wording.has()) {
          paramToServiceMsg = paramFromServiceMsg.wording.get();
        } else {
          paramToServiceMsg = "";
        }
        if (paramFromServiceMsg.next_req_duration.has()) {
          i = paramFromServiceMsg.next_req_duration.get();
        } else {
          i = 0;
        }
        ((AppletsFolderManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(paramToServiceMsg, i);
        if (paramFromServiceMsg.get_uin_info_rsp.has()) {
          paramToServiceMsg = (oidb_cmd0xc7a.GetUinInfoRsp)paramFromServiceMsg.get_uin_info_rsp.get();
        } else {
          paramToServiceMsg = null;
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uin_infos.has())) {
          paramToServiceMsg = paramToServiceMsg.uin_infos.get();
        } else {
          paramToServiceMsg = null;
        }
        paramFromServiceMsg = new ArrayList();
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg = paramToServiceMsg.iterator();
          while (paramToServiceMsg.hasNext())
          {
            paramObject = (oidb_cmd0xc7a.UinInfo)paramToServiceMsg.next();
            AppletsAccountInfo localAppletsAccountInfo = new AppletsAccountInfo();
            if (paramObject.uin.has()) {
              localAppletsAccountInfo.uin = String.valueOf(paramObject.uin.get());
            }
            if (paramObject.face_url.has()) {
              localAppletsAccountInfo.faceUrl = paramObject.face_url.get();
            }
            if (paramObject.face_url_simple.has()) {
              localAppletsAccountInfo.faceUrlSimple = paramObject.face_url_simple.get();
            }
            if (paramObject.nick.has()) {
              localAppletsAccountInfo.nick = paramObject.nick.get();
            }
            if (paramObject.appinfo.has()) {
              localAppletsAccountInfo.appInfo = localAppletsAccountInfo.convertToAppletInfo((qqconnect.Appinfo)paramObject.appinfo.get());
            }
            paramFromServiceMsg.add(localAppletsAccountInfo);
          }
        }
        notifyUI(1, true, paramFromServiceMsg);
      }
      notifyUI(1, false, null);
      return;
    }
    notifyUI(1, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_cmd0xc76.RspBody paramRspBody)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
    if (paramFromServiceMsg.isSuccess())
    {
      notifyUI(3, true, paramToServiceMsg);
      return;
    }
    notifyUI(3, false, paramToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    oidb_cmd0xc96.ReqBody localReqBody = new oidb_cmd0xc96.ReqBody();
    int k = -1;
    int i;
    try
    {
      localOIDBSSOPkg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      localReqBody.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      i = localReqBody.cmd_type.get();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      i = -1;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
      }
      int j = k;
      if (paramToServiceMsg != null)
      {
        j = k;
        if (paramToServiceMsg.uint32_result.has())
        {
          k = paramToServiceMsg.uint32_result.get();
          j = k;
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handle OidbSvc.0xc96|OIDBSSOPke.result=");
            paramFromServiceMsg.append(k);
            QLog.i("AppletsHandler", 2, paramFromServiceMsg.toString());
            j = k;
          }
        }
      }
      if ((j == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          notifyUI(5, true, paramToServiceMsg);
          return;
        }
        notifyUI(4, true, paramToServiceMsg);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppletsHandler", 2, "0xc96 fail");
      }
      notifyUI(i + 3, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletsHandler", 2, "handleGetAppletPublicAccount res.isSuccess=false");
    }
    notifyUI(i, false, null);
  }
  
  public void a()
  {
    Object localObject = new oidb_cmd0xc76.ReqBody();
    ((oidb_cmd0xc76.ReqBody)localObject).cmd.set(1);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3190);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xc76.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xc76");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString)
  {
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = a();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        if (localObject1 != null)
        {
          ??? = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
          int i = 0;
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
            if (paramString.equals(a(localMessageRecord)))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((String)???, 1038, localMessageRecord.uniseq, "isread", Boolean.valueOf(true));
              i -= 1;
            }
          }
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d((String)???, 1038, i);
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("setAppletsMsgReadedByAppid: ");
          ((StringBuilder)???).append(paramString);
          ((StringBuilder)???).append("  increaseCount: ");
          ((StringBuilder)???).append(i);
          ((StringBuilder)???).append("  unreadMsgList size:");
          ((StringBuilder)???).append(((List)localObject1).size());
          QLog.d("AppletsHandler", 2, ((StringBuilder)???).toString());
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("setAppletsMsgReadedByAppid: ");
        ((StringBuilder)???).append(paramString);
        ((StringBuilder)???).append("  unreadMsgList size:");
        ((StringBuilder)???).append(((List)localObject1).size());
        QLog.d("AppletsHandler", 2, ((StringBuilder)???).toString());
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setAppletsMsgReadedByAppid: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("AppletsHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    AppletItem.Builder localBuilder = new AppletItem.Builder();
    localBuilder.a(paramString2);
    localBuilder.a(paramString1);
    localBuilder.b(paramInt);
    localArrayList.add(localBuilder.a());
    a(localArrayList, true);
  }
  
  public void a(ArrayList<AppletItem> paramArrayList)
  {
    a(paramArrayList, false);
  }
  
  public void a(ArrayList<AppletItem> paramArrayList, boolean paramBoolean)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = a(paramArrayList, paramBoolean);
    ToServiceMsg localToServiceMsg = createToServiceMsg("OidbSvc.0xc76");
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putBoolean("public_account_state_changed_flag", true);
      localToServiceMsg.extraData.putParcelableArrayList("unreceived_uin_list", paramArrayList);
    }
    else
    {
      localToServiceMsg.extraData.putParcelableArrayList("unreceived_uin_list", paramArrayList);
    }
    sendPbReq(localToServiceMsg);
  }
  
  public void a(List<Long> paramList)
  {
    Object localObject = new oidb_cmd0xc7a.ReqBody();
    ((oidb_cmd0xc7a.ReqBody)localObject).cmd.set(1);
    oidb_cmd0xc7a.GetUinInfoReq localGetUinInfoReq = new oidb_cmd0xc7a.GetUinInfoReq();
    localGetUinInfoReq.uins.set(paramList);
    ((oidb_cmd0xc7a.ReqBody)localObject).get_uin_info_req.set(localGetUinInfoReq);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(3194);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xc7a.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xc7a");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    Object localObject1 = new oidb_cmd0xc96.ReqBody();
    if ((paramInt1 != -1) && (paramLong1 != -1L))
    {
      ((oidb_cmd0xc96.ReqBody)localObject1).app_type.set(paramInt1);
      ((oidb_cmd0xc96.ReqBody)localObject1).appid.set(paramLong1);
    }
    else
    {
      if (paramLong2 == -1L) {
        break label263;
      }
      ((oidb_cmd0xc96.ReqBody)localObject1).puin.set(paramLong2);
    }
    Object localObject3;
    if (paramBoolean)
    {
      localObject2 = new oidb_cmd0xc96.FollowExt();
      ((oidb_cmd0xc96.FollowExt)localObject2).source_from.set(paramInt2);
      localObject3 = new oidb_cmd0xc96.FollowReq();
      ((oidb_cmd0xc96.FollowReq)localObject3).ext.set((MessageMicro)localObject2);
      ((oidb_cmd0xc96.ReqBody)localObject1).follow_req.set((MessageMicro)localObject3);
      ((oidb_cmd0xc96.ReqBody)localObject1).cmd_type.set(1);
    }
    else
    {
      localObject2 = new oidb_cmd0xc96.UnFollowExt();
      ((oidb_cmd0xc96.UnFollowExt)localObject2).source_from.set(paramInt2);
      localObject3 = new oidb_cmd0xc96.UnfollowReq();
      ((oidb_cmd0xc96.UnfollowReq)localObject3).ext.set((MessageMicro)localObject2);
      ((oidb_cmd0xc96.ReqBody)localObject1).unfollow_req.set((MessageMicro)localObject3);
      ((oidb_cmd0xc96.ReqBody)localObject1).cmd_type.set(2);
    }
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3222);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xc96.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xc96");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
    return;
    label263:
    if (QLog.isColorLevel()) {
      QLog.d("AppletsHandler", 2, "report info error, all is none!");
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilSet.clear();
      notifyUI(8, true, null);
      return;
    }
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject2 = new LinkedList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      Object localObject3;
      while (paramList.hasNext())
      {
        localObject3 = (MessageRecord)paramList.next();
        if (!this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(((MessageRecord)localObject3).msgUid)))
        {
          ((List)localObject2).add(localObject3);
          this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(((MessageRecord)localObject3).msgUid));
        }
      }
      if (((List)localObject2).size() < 1) {
        return;
      }
      paramList = a((List)localObject2);
      if ((paramList != null) && (paramList.size() > 0)) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          localObject2 = paramList.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramList = (Map.Entry)((Iterator)localObject2).next();
            localObject3 = (String)paramList.getKey();
            Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject3);
            if (localInteger != null) {
              paramList = Integer.valueOf(localInteger.intValue() + ((Integer)paramList.getValue()).intValue());
            } else {
              paramList = (Integer)paramList.getValue();
            }
            this.jdField_a_of_type_JavaUtilMap.put(localObject3, paramList);
          }
          notifyUI(8, true, this.jdField_a_of_type_JavaUtilMap);
          return;
        }
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void c()
  {
    QLog.d("AppletsHandler", 1, "requestGetAppletsMsgUnreadInfo");
    ??? = a();
    if ((??? != null) && (((List)???).size() > 0))
    {
      Map localMap = a((List)???);
      if ((localMap == null) || (localMap.size() <= 0)) {
        break label118;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap.putAll(localMap);
        notifyUI(8, true, this.jdField_a_of_type_JavaUtilMap);
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      notifyUI(8, true, null);
      label118:
      return;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xc76");
      this.allowCmdSet.add("OidbSvc.0xc7a");
      this.allowCmdSet.add("OidbSvc.0xc96");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AppletsObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("AppletsHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("OidbSvc.0xc7a".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc76".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc96".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.AppletsHandler
 * JD-Core Version:    0.7.0.1
 */