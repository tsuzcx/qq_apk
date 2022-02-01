package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.GetUserFollowListRet;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse;
import com.tencent.crmqq.structmsg.StructMsg.GetCrmQQMenuRequest;
import com.tencent.crmqq.structmsg.StructMsg.RetInfo;
import com.tencent.crmqq.structmsg.StructMsg.SendMenuEventRequest;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.mp.mobileqq_mp.CRMSendLBSInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserEqqListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserEqqListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class EnterpriseQQHandler
  extends BusinessHandler
{
  public static final Long a;
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2202087152L);
  }
  
  EnterpriseQQHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("eqq_data_seq2", 0L);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getEqqList: start");
    }
    mobileqq_mp.GetUserEqqListRequest localGetUserEqqListRequest = new mobileqq_mp.GetUserEqqListRequest();
    localGetUserEqqListRequest.version.set(1);
    localGetUserEqqListRequest.begin.set(Utils.a(paramLong1));
    localGetUserEqqListRequest.limit.set(Utils.a(paramLong2));
    localGetUserEqqListRequest.seqno.set(Utils.a(paramLong3));
    ToServiceMsg localToServiceMsg = createToServiceMsg("EqqAccountSvc.get_eqq_list");
    localToServiceMsg.putWupBuffer(localGetUserEqqListRequest.toByteArray());
    localToServiceMsg.extraData.putLong("begin", paramLong1);
    localToServiceMsg.extraData.putLong("limit", paramLong2);
    localToServiceMsg.extraData.putLong("seqno", paramLong3);
    localToServiceMsg.extraData.putLong("time", paramLong4);
    sendPbReq(localToServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetList, ts=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("crmtest", 4, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handleGetList begin.");
    }
    Object localObject = new IPublicAccountObserver.GetUserFollowListRet();
    int i;
    long l1;
    long l2;
    boolean bool2;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetList result=");
        paramFromServiceMsg.append(i);
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, paramFromServiceMsg.toString());
      }
      if (i != 1000)
      {
        ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Int = -1;
        ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Boolean = true;
        return;
      }
      l1 = paramToServiceMsg.extraData.getLong("begin");
      paramToServiceMsg.extraData.getLong("seqno");
      l2 = paramToServiceMsg.extraData.getLong("time");
      paramToServiceMsg = new mobileqq_mp.GetUserEqqListResponse();
      bool2 = false;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((!paramToServiceMsg.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.has())) {
          break label629;
        }
        i = ((mobileqq_mp.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get();
        ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Int = i;
        if (i != 0)
        {
          ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Boolean = true;
          bool1 = bool2;
        }
        else
        {
          if (!paramToServiceMsg.seqno.has()) {
            break label635;
          }
          i = paramToServiceMsg.seqno.get();
          long l3 = Utils.a(i);
          paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoListFromEqq(paramToServiceMsg.accountInfo.get(), l2);
          ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_JavaLangObject = paramFromServiceMsg;
          if ((!paramToServiceMsg.is_over.has()) || (!paramToServiceMsg.is_over.get())) {
            break label641;
          }
          bool1 = true;
          ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Boolean = bool1;
          paramObject = (List)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).saveEqqAccountInfos(paramFromServiceMsg, l2);
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
          paramObject = paramObject.iterator();
          i = 0;
          if (paramObject.hasNext())
          {
            RecentUser localRecentUser = paramFromServiceMsg.b(((PublicAccountInfo)paramObject.next()).getUin(), 0);
            if (localRecentUser == null) {
              continue;
            }
            paramFromServiceMsg.a(localRecentUser);
            i = 1;
            continue;
          }
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if ((i != 0) && (paramFromServiceMsg != null)) {
            paramFromServiceMsg.sendEmptyMessage(1009);
          }
          if (!((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Boolean)
          {
            if (!paramToServiceMsg.next_pos.has()) {
              break label647;
            }
            l1 = paramToServiceMsg.next_pos.get();
            a(l1, 20L, 0L, l2);
          }
          else
          {
            b(l3);
          }
          bool1 = true;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Int = -1;
        ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Boolean = true;
        paramToServiceMsg.printStackTrace();
        bool1 = bool2;
      }
      notifyUI(100, bool1, localObject);
      ((IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).notifyUI(100, true, localObject);
      return;
      ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Int = -1;
      ((IPublicAccountObserver.GetUserFollowListRet)localObject).jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handleGetList error");
      }
      return;
      label629:
      i = 0;
      continue;
      label635:
      i = 0;
      continue;
      label641:
      boolean bool1 = false;
      continue;
      label647:
      l1 += 20L;
    }
  }
  
  private void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("eqq_data_seq2", paramLong);
    localEditor.commit();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handlerGetMenu,begin.");
    }
    if (paramToServiceMsg != null) {
      if (paramFromServiceMsg == null) {
        return;
      }
    }
    try
    {
      int i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handlerGetMenu. result=");
        paramToServiceMsg.append(i);
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, paramToServiceMsg.toString());
      }
      if (i == 1000)
      {
        i = -1;
        paramToServiceMsg = new StructMsg.GetCRMMenuResponse();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
        }
        int j = i;
        if (paramToServiceMsg.ret_info.has())
        {
          paramFromServiceMsg = (StructMsg.RetInfo)paramToServiceMsg.ret_info.get();
          if (paramFromServiceMsg.ret_code.has()) {
            i = paramFromServiceMsg.ret_code.get();
          }
          j = i;
          if (i != 0)
          {
            j = i;
            if (paramFromServiceMsg.err_info.has())
            {
              paramFromServiceMsg.err_info.get();
              j = i;
            }
          }
        }
        if (j == 0)
        {
          paramFromServiceMsg = String.valueOf(paramToServiceMsg.uin.get());
          i = paramToServiceMsg.seqno.get();
          EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg, i, paramToServiceMsg);
          notifyUI(1, true, paramFromServiceMsg);
        }
      }
      return;
    }
    catch (Exception paramToServiceMsg) {}
  }
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 61
    //   8: iconst_2
    //   9: ldc_w 399
    //   12: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +104 -> 120
    //   19: aload_2
    //   20: ifnonnull +4 -> 24
    //   23: return
    //   24: aload_2
    //   25: invokevirtual 172	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   28: sipush 1000
    //   31: if_icmpne +89 -> 120
    //   34: iconst_m1
    //   35: istore 4
    //   37: new 401	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse
    //   40: dup
    //   41: invokespecial 402	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_3
    //   47: checkcast 191	[B
    //   50: checkcast 191	[B
    //   53: invokevirtual 403	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   56: pop
    //   57: aload_1
    //   58: getfield 404	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse:ret_info	Lcom/tencent/crmqq/structmsg/StructMsg$RetInfo;
    //   61: invokevirtual 363	com/tencent/crmqq/structmsg/StructMsg$RetInfo:has	()Z
    //   64: ifeq +56 -> 120
    //   67: aload_1
    //   68: getfield 404	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse:ret_info	Lcom/tencent/crmqq/structmsg/StructMsg$RetInfo;
    //   71: invokevirtual 364	com/tencent/crmqq/structmsg/StructMsg$RetInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   74: checkcast 362	com/tencent/crmqq/structmsg/StructMsg$RetInfo
    //   77: astore_1
    //   78: aload_1
    //   79: getfield 365	com/tencent/crmqq/structmsg/StructMsg$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 212	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   85: ifeq +12 -> 97
    //   88: aload_1
    //   89: getfield 365	com/tencent/crmqq/structmsg/StructMsg$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   92: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   95: istore 4
    //   97: iload 4
    //   99: ifeq +21 -> 120
    //   102: aload_1
    //   103: getfield 369	com/tencent/crmqq/structmsg/StructMsg$RetInfo:err_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   106: invokevirtual 372	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   109: ifeq +11 -> 120
    //   112: aload_1
    //   113: getfield 369	com/tencent/crmqq/structmsg/StructMsg$RetInfo:err_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   116: invokevirtual 374	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   119: pop
    //   120: return
    //   121: astore_1
    //   122: return
    //   123: astore_2
    //   124: goto -67 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	EnterpriseQQHandler
    //   0	127	1	paramToServiceMsg	ToServiceMsg
    //   0	127	2	paramFromServiceMsg	FromServiceMsg
    //   0	127	3	paramObject	Object
    //   35	63	4	i	int
    // Exception table:
    //   from	to	target	type
    //   24	34	121	java/lang/Exception
    //   37	45	121	java/lang/Exception
    //   57	78	121	java/lang/Exception
    //   78	97	121	java/lang/Exception
    //   102	120	121	java/lang/Exception
    //   45	57	123	java/lang/Exception
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handelCrmSendLBSInfo(): BEGIN");
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
      {
        paramToServiceMsg = new mobileqq_mp.CRMSendLBSInfoResponse();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
        }
        int i;
        if ((paramToServiceMsg.ret_info.has()) && (((mobileqq_mp.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.has())) {
          i = ((mobileqq_mp.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get();
        } else {
          i = -1;
        }
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handelCrmSendLBSInfo(): errCode=");
        paramToServiceMsg.append(i);
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, paramToServiceMsg.toString());
        return;
      }
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handelCrmSendLBSInfo(): FAILED");
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEqqList, ts=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("crmtest", 4, localStringBuilder.toString());
    }
    a(0L, 20L, a(), paramLong);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getMenu: start");
    }
    try
    {
      long l = Long.valueOf(paramString).longValue();
      paramString = new StructMsg.GetCrmQQMenuRequest();
      paramString.seqno.set(0);
      paramString.uin.set(l);
      ToServiceMsg localToServiceMsg = createToServiceMsg("mq_crm.get_menu");
      localToServiceMsg.putWupBuffer(paramString.toByteArray());
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getMenu: arg uin error.");
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, mqq.observer.BusinessObserver paramBusinessObserver)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      paramString = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      paramString.putExtra("cmd", "set_function_flag");
      mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
      localSetFunctionFlagRequset.luin.set(l);
      localSetFunctionFlagRequset.type.set(paramInt1);
      localSetFunctionFlagRequset.value.set(paramInt2);
      localSetFunctionFlagRequset.account_type.set(paramInt3);
      localSetFunctionFlagRequset.version.set(1);
      paramString.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: start");
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        long l = Long.valueOf(paramString1).longValue();
        paramString1 = new StructMsg.SendMenuEventRequest();
        paramString1.uin.set(l);
        paramString1.key.set(paramString2);
        paramString1.type.set(paramInt);
        paramString1.is_need_lbs.set(paramBoolean);
        if (paramBoolean)
        {
          paramString1.latitude.set(paramDouble1);
          paramString1.longitude.set(paramDouble2);
        }
        paramString2 = createToServiceMsg("mq_crm.send_key");
        paramString2.putWupBuffer(paramString1.toByteArray());
        sendPbReq(paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: arg uin error.");
        }
        paramString1.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: arg error.");
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return EnterpriseQQObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      if ("mq_crm.get_menu".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("mq_crm.send_key".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("EqqAccountSvc.get_eqq_list".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("CrmSvcEx.ReportLbs".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, paramToServiceMsg.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.EnterpriseQQHandler
 * JD-Core Version:    0.7.0.1
 */