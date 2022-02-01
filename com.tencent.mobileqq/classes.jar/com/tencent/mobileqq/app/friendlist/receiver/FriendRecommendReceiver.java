package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.RspBody;
import tencent.im.oidb.oidb_0xc26.RspBody;
import tencent.im.oidb.oidb_0xc34.RspBody;
import tencent.im.oidb.oidb_0xc35.RspBody;
import tencent.im.oidb.oidb_0xc36.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FriendRecommendReceiver
  extends BaseHandlerReceiver
{
  public FriendRecommendReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(List<oidb_0x7df.FriendScore> paramList)
  {
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        oidb_0x7df.FriendScore localFriendScore = (oidb_0x7df.FriendScore)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FriendListHandler.handleSpecialCareRecommend uin: ");
        boolean bool = localFriendScore.uint64_friend_uin.has();
        String str = "";
        if (bool) {
          paramList = String.valueOf(localFriendScore.uint64_friend_uin.get());
        } else {
          paramList = "";
        }
        localStringBuilder.append(paramList);
        localStringBuilder.append(", score: ");
        bool = localFriendScore.uint32_friend_score.has();
        int j = -1;
        if (bool) {
          i = localFriendScore.uint32_friend_score.get();
        } else {
          i = -1;
        }
        localStringBuilder.append(i);
        localStringBuilder.append(", relation: ");
        if (localFriendScore.bytes_relation_name.has()) {
          paramList = localFriendScore.bytes_relation_name.get().toStringUtf8();
        } else {
          paramList = "";
        }
        localStringBuilder.append(paramList);
        localStringBuilder.append(", rank: ");
        int i = j;
        if (localFriendScore.uint32_rank.has()) {
          i = localFriendScore.uint32_rank.get();
        }
        localStringBuilder.append(i);
        localStringBuilder.append(", nick: ");
        paramList = str;
        if (localFriendScore.bytes_nick.has()) {
          paramList = localFriendScore.bytes_nick.get().toStringUtf8();
        }
        localStringBuilder.append(paramList);
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, localStringBuilder.toString());
      }
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean, oidb_0x7df.RspBody paramRspBody)
  {
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    paramToServiceMsg = FriendListHandler.parseSSOPkg(paramToServiceMsg, paramFromServiceMsg, paramObject);
    if (paramToServiceMsg != null) {
      try
      {
        paramRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        return paramBoolean;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend RspBody mergeFrom failed.");
        }
        paramToServiceMsg.printStackTrace();
      }
    }
    return false;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    oidb_0xc26.RspBody localRspBody = new oidb_0xc26.RspBody();
    int i = -1;
    boolean bool1 = bool2;
    int j;
    if (bool2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      j = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      bool1 = bool2;
      i = j;
      if (j != 0)
      {
        bool1 = false;
        i = j;
      }
    }
    Object localObject1 = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null)) {
      paramToServiceMsg = paramToServiceMsg.extraData.getBundle("EXTRA:OidbSvc.0xc26_0");
    } else {
      paramToServiceMsg = null;
    }
    boolean bool2 = bool3;
    if (bool1)
    {
      Object localObject2 = localRspBody.rpt_msg_persons.get();
      localRspBody.rpt_entry_close.get();
      paramFromServiceMsg = localRspBody.rpt_entry_inuse.get();
      paramObject = localRspBody.rpt_entry_delays.get();
      j = localRspBody.uint32_timestamp.get();
      localRspBody.uint32_next_gap.get();
      int k = localRspBody.uint32_msg_up.get();
      int m = localRspBody.uint32_list_switch.get();
      int n = localRspBody.uint32_add_page_list_switch.get();
      int i1 = localRspBody.em_rsp_data_type.get();
      List localList = localRspBody.rpt_msg_rgroup_items.get();
      localObject2 = MayKnowRecommend.covServerDataToLocal((List)localObject2, j, 23);
      ((MayknowRecommendManager)localObject1).a(paramFromServiceMsg);
      ((MayknowRecommendManager)localObject1).b(paramObject);
      if (i1 == 1)
      {
        if (localRspBody.rpt_msg_tables.has()) {
          paramFromServiceMsg = localRspBody.rpt_msg_tables.get();
        } else {
          paramFromServiceMsg = null;
        }
        if (localRspBody.bytes_cookies.has()) {
          paramObject = localRspBody.bytes_cookies.get().toByteArray();
        } else {
          paramObject = null;
        }
        ((MayknowRecommendManager)localObject1).a(bool1, (ArrayList)localObject2, j, k, m, n, paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      else
      {
        ((MayknowRecommendManager)localObject1).a(bool1, localList);
      }
      ((MayknowRecommendManager)localObject1).d(i1);
      bool2 = bool1;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetMayKnowRecommend, isSuc=");
      paramFromServiceMsg.append(bool2);
      paramFromServiceMsg.append(",oidbesult=");
      paramFromServiceMsg.append(i);
      QLog.i("FriendListHandler.BaseHandlerReceiver", 1, paramFromServiceMsg.toString());
    }
    a(90, bool2, paramToServiceMsg);
    a(110, bool2, paramToServiceMsg);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i = -1;
    boolean bool1 = bool2;
    if (bool2)
    {
      oidb_0xc36.RspBody localRspBody = new oidb_0xc36.RspBody();
      FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      int j = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      bool1 = bool2;
      i = j;
      if (j != 0)
      {
        bool1 = false;
        i = j;
      }
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("uin");
    boolean bool2 = bool3;
    if (bool1) {
      bool2 = bool1;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleCancelMayKnowRecommend, isSuc=");
      paramFromServiceMsg.append(bool2);
      paramFromServiceMsg.append(",oidbesult=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(", uin=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("FriendListHandler.BaseHandlerReceiver", 1, paramFromServiceMsg.toString());
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = -1;
    boolean bool2 = bool1;
    if (bool1)
    {
      paramToServiceMsg = new oidb_0xc35.RspBody();
      FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      int j = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      bool2 = bool1;
      i = j;
      if (j != 0)
      {
        bool2 = false;
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleReportMayknowExplosure, isSuc=");
      paramToServiceMsg.append(bool2);
      paramToServiceMsg.append(",oidbesult=");
      paramToServiceMsg.append(i);
      QLog.i("FriendListHandler.BaseHandlerReceiver", 1, paramToServiceMsg.toString());
    }
    ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(bool2);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramToServiceMsg = new oidb_0xc34.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int i = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleReqHideConversationMayknowRecommend, isSuc=");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(",oidbesult=");
      paramToServiceMsg.append(i);
      QLog.i("FriendListHandler.BaseHandlerReceiver", 1, paramToServiceMsg.toString());
    }
    if (bool) {
      ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).g();
    }
    a(113, bool, null);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramToServiceMsg = new oidb_0xc34.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int i = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleReqHideConversationTroopRecommend, isSuc=");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(",oidbesult=");
      paramToServiceMsg.append(i);
      QLog.i("FriendListHandler.BaseHandlerReceiver", 1, paramToServiceMsg.toString());
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FriendListHandler.handleSpecialCareRecommend resp: ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(", data: ");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      FriendListHandler.getSpecialRecommendStat = 0;
      localObject = new oidb_0x7df.RspBody();
      bool = a(paramToServiceMsg, paramFromServiceMsg, paramObject, bool, (oidb_0x7df.RspBody)localObject);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("FriendListHandler.handleSpecialCareRecommend isSuccess: ");
        paramToServiceMsg.append(bool);
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
      }
      if (bool)
      {
        a(93, true, localObject);
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("FriendListHandler.handleSpecialCareRecommend isOver: ");
          bool = ((oidb_0x7df.RspBody)localObject).uint32_over.has();
          int j = -1;
          if (bool) {
            i = ((oidb_0x7df.RspBody)localObject).uint32_over.get();
          } else {
            i = -1;
          }
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(", next: ");
          if (((oidb_0x7df.RspBody)localObject).uint32_next_start.has()) {
            i = ((oidb_0x7df.RspBody)localObject).uint32_next_start.get();
          } else {
            i = -1;
          }
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(", total: ");
          if (((oidb_0x7df.RspBody)localObject).uint32_total.has()) {
            i = ((oidb_0x7df.RspBody)localObject).uint32_total.get();
          } else {
            i = -1;
          }
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(", lowest: ");
          int i = j;
          if (((oidb_0x7df.RspBody)localObject).uint32_low_score.has()) {
            i = ((oidb_0x7df.RspBody)localObject).uint32_low_score.get();
          }
          paramToServiceMsg.append(i);
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
        }
        if (!((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend rpt_msg_friend_score has no data.");
          }
          return;
        }
        paramToServiceMsg = ((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          a(paramToServiceMsg);
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.onGetSpecialCareRecommend(paramToServiceMsg);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend friendList is null or has no data.");
        }
        return;
      }
    }
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    FriendListHandler.getSpecialRecommendStat = 1;
    a(93, false, null);
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0xc26_0".equals(paramString)) || ("OidbSvc.0xc36_0".equals(paramString)) || ("OidbSvc.0xc35_0".equals(paramString)) || ("OidbSvc.0xc34_0".equals(paramString)) || ("OidbSvc.0xc26_1".equals(paramString)) || ("OidbSvc.0xc34_1".equals(paramString)) || ("OidbSvc.0x7df_3".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0xc26_0".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc36_0".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc35_0".equals(str))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc34_0".equals(str))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc26_1".equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc34_1".equals(str))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x7df_3".equals(str)) {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      int j = ((Integer)paramToServiceMsg.getAttribute("tabID", Integer.valueOf(0))).intValue();
      boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isFirstPage", Boolean.valueOf(true))).booleanValue();
      Bundle localBundle = (Bundle)paramToServiceMsg.getAttribute("extra_bd", new Bundle());
      int k = localBundle.getInt("load_biz_type", 0);
      Object localObject = new oidb_0xc26.RspBody();
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      int m = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (m == 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetConnectionsPerson sus ");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(" ");
          paramToServiceMsg.append(bool);
          QLog.i("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
        }
        if (((oidb_0xc26.RspBody)localObject).em_rsp_data_type.get() == 1)
        {
          paramObject = ((oidb_0xc26.RspBody)localObject).rpt_msg_persons.get();
          if (((oidb_0xc26.RspBody)localObject).rpt_msg_tables.has()) {
            paramToServiceMsg = ((oidb_0xc26.RspBody)localObject).rpt_msg_tables.get();
          } else {
            paramToServiceMsg = null;
          }
          if (((oidb_0xc26.RspBody)localObject).bytes_cookies.has()) {
            paramFromServiceMsg = ((oidb_0xc26.RspBody)localObject).bytes_cookies.get().toByteArray();
          } else {
            paramFromServiceMsg = null;
          }
          int i = ((oidb_0xc26.RspBody)localObject).uint32_timestamp.get();
          localObject = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
          if (!bool) {
            i = ((MayknowRecommendManager)localObject).a(j) - 1;
          }
          ((MayknowRecommendManager)localObject).a(j, MayKnowRecommend.covServerDataToLocal(paramObject, i, j), paramToServiceMsg, paramFromServiceMsg, bool, localBundle);
          if (!bool) {
            ((MayknowRecommendManager)localObject).a(j);
          }
          a(129, true, new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) });
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetConnectionsPerson failed result:");
          paramToServiceMsg.append(m);
          paramToServiceMsg.append(" ");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(", bizType=");
          paramToServiceMsg.append(k);
          QLog.i("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
        }
        paramToServiceMsg = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        if (m == 1205) {
          paramToServiceMsg.b(j);
        }
        if (!bool) {
          paramToServiceMsg.a(j);
        }
        a(129, false, new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.FriendRecommendReceiver
 * JD-Core Version:    0.7.0.1
 */