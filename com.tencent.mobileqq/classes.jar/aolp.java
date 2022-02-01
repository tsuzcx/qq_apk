import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
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

public class aolp
  extends aolh
{
  public aolp(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    oidb_0xc26.RspBody localRspBody;
    int i;
    Object localObject1;
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool = true;
      localRspBody = new oidb_0xc26.RspBody();
      i = -1;
      if (!bool) {
        break label408;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      j = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      i = j;
      if (j == 0) {
        break label408;
      }
      i = j;
      bool = false;
    }
    label258:
    label390:
    label402:
    label408:
    for (;;)
    {
      localObject1 = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      label98:
      List localList;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
      {
        paramToServiceMsg = paramToServiceMsg.extraData.getBundle("EXTRA:OidbSvc.0xc26_0");
        if (!bool) {
          break label402;
        }
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
        localList = localRspBody.rpt_msg_rgroup_items.get();
        localObject2 = MayKnowRecommend.covServerDataToLocal((List)localObject2, j, 23);
        ((anyb)localObject1).a(paramFromServiceMsg);
        ((anyb)localObject1).b(paramObject);
        if (i1 != 1) {
          break label390;
        }
        if (!localRspBody.rpt_msg_tables.has()) {
          break label380;
        }
        paramFromServiceMsg = localRspBody.rpt_msg_tables.get();
        if (!localRspBody.bytes_cookies.has()) {
          break label385;
        }
        paramObject = localRspBody.bytes_cookies.get().toByteArray();
        label281:
        ((anyb)localObject1).a(bool, (ArrayList)localObject2, j, k, m, n, paramToServiceMsg, paramFromServiceMsg, paramObject);
        label301:
        ((anyb)localObject1).d(i1);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler.BaseHandlerReceiver", 1, "handleGetMayKnowRecommend, isSuc=" + bool + ",oidbesult=" + i);
        }
        a(92, bool, paramToServiceMsg);
        a(113, bool, paramToServiceMsg);
        return;
        bool = false;
        break;
        paramToServiceMsg = null;
        break label98;
        label380:
        paramFromServiceMsg = null;
        break label258;
        paramObject = null;
        break label281;
        ((anyb)localObject1).a(bool, localList);
        break label301;
        bool = false;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      i = -1;
      bool2 = bool1;
      if (bool1)
      {
        oidb_0xc36.RspBody localRspBody = new oidb_0xc36.RspBody();
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        int j = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
        i = j;
        bool2 = bool1;
        if (j != 0)
        {
          bool2 = false;
          i = j;
        }
      }
      paramToServiceMsg = paramToServiceMsg.extraData.getString("uin");
      if (!bool2) {
        break label143;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler.BaseHandlerReceiver", 1, "handleCancelMayKnowRecommend, isSuc=" + bool2 + ",oidbesult=" + i + ", uin=" + paramToServiceMsg);
      }
      return;
      bool1 = false;
      break;
      label143:
      bool2 = false;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      i = -1;
      if (!bool1) {
        break label131;
      }
      paramToServiceMsg = new oidb_0xc35.RspBody();
      FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      int j = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      i = j;
      if (j == 0) {
        break label131;
      }
      bool1 = bool2;
      i = j;
    }
    label131:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler.BaseHandlerReceiver", 1, "handleReportMayknowExplosure, isSuc=" + bool1 + ",oidbesult=" + i);
      }
      ((anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramToServiceMsg = new oidb_0xc34.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int i = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler.BaseHandlerReceiver", 1, "handleReqHideConversationMayknowRecommend, isSuc=" + bool + ",oidbesult=" + i);
      }
      if (bool) {
        ((anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).g();
      }
      a(116, bool, null);
      return;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    int j;
    boolean bool;
    Bundle localBundle;
    int k;
    Object localObject;
    int m;
    do
    {
      return;
      j = ((Integer)paramToServiceMsg.getAttribute("tabID", Integer.valueOf(0))).intValue();
      bool = ((Boolean)paramToServiceMsg.getAttribute("isFirstPage", Boolean.valueOf(true))).booleanValue();
      localBundle = (Bundle)paramToServiceMsg.getAttribute("extra_bd", null);
      k = localBundle.getInt("load_biz_type", 0);
      localObject = new oidb_0xc26.RspBody();
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      m = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (m != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetConnectionsPerson sus " + j + " " + bool);
      }
    } while (((oidb_0xc26.RspBody)localObject).em_rsp_data_type.get() != 1);
    paramObject = ((oidb_0xc26.RspBody)localObject).rpt_msg_persons.get();
    if (((oidb_0xc26.RspBody)localObject).rpt_msg_tables.has())
    {
      paramToServiceMsg = ((oidb_0xc26.RspBody)localObject).rpt_msg_tables.get();
      if (!((oidb_0xc26.RspBody)localObject).bytes_cookies.has()) {
        break label320;
      }
    }
    label320:
    for (paramFromServiceMsg = ((oidb_0xc26.RspBody)localObject).bytes_cookies.get().toByteArray();; paramFromServiceMsg = null)
    {
      int i = ((oidb_0xc26.RspBody)localObject).uint32_timestamp.get();
      localObject = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (!bool) {
        i = ((anyb)localObject).a(j) - 1;
      }
      ((anyb)localObject).a(j, MayKnowRecommend.covServerDataToLocal(paramObject, i, j), paramToServiceMsg, paramFromServiceMsg, bool, localBundle);
      if (!bool) {
        ((anyb)localObject).a(j);
      }
      a(132, true, new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) });
      return;
      paramToServiceMsg = null;
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetConnectionsPerson failed result:" + m + " " + j + ", bizType=" + k);
    }
    paramToServiceMsg = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (m == 1205) {
      paramToServiceMsg.b(j);
    }
    if (!bool) {
      paramToServiceMsg.a(j);
    }
    a(132, false, new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) });
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
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler.BaseHandlerReceiver", 1, "handleReqHideConversationTroopRecommend, isSuc=" + bool + ",oidbesult=" + i);
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend resp: " + paramFromServiceMsg + ", data: " + paramObject);
    }
    boolean bool;
    Object localObject1;
    Object localObject2;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label726;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      FriendListHandler.getSpecialRecommendStat = 0;
      localObject1 = new oidb_0x7df.RspBody();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      paramToServiceMsg = FriendListHandler.parseSSOPkg(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (paramToServiceMsg == null) {
        break label385;
      }
    }
    int i;
    label385:
    label391:
    label397:
    label403:
    label409:
    label415:
    do
    {
      for (;;)
      {
        try
        {
          ((oidb_0x7df.RspBody)localObject1).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend isSuccess: " + bool);
          }
          if (!bool) {
            break label726;
          }
          a(95, true, localObject1);
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend isOver: ");
            if (!((oidb_0x7df.RspBody)localObject1).uint32_over.has()) {
              break label391;
            }
            i = ((oidb_0x7df.RspBody)localObject1).uint32_over.get();
            paramToServiceMsg = paramToServiceMsg.append(i).append(", next: ");
            if (!((oidb_0x7df.RspBody)localObject1).uint32_next_start.has()) {
              break label397;
            }
            i = ((oidb_0x7df.RspBody)localObject1).uint32_next_start.get();
            paramToServiceMsg = paramToServiceMsg.append(i).append(", total: ");
            if (!((oidb_0x7df.RspBody)localObject1).uint32_total.has()) {
              break label403;
            }
            i = ((oidb_0x7df.RspBody)localObject1).uint32_total.get();
            paramToServiceMsg = paramToServiceMsg.append(i).append(", lowest: ");
            if (!((oidb_0x7df.RspBody)localObject1).uint32_low_score.has()) {
              break label409;
            }
            i = ((oidb_0x7df.RspBody)localObject1).uint32_low_score.get();
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, i);
          }
          if (((oidb_0x7df.RspBody)localObject1).rpt_msg_friend_score.has()) {
            break label415;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend rpt_msg_friend_score has no data.");
          }
          return;
          bool = false;
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend RspBody mergeFrom failed.");
          }
          paramToServiceMsg.printStackTrace();
          bool = false;
          continue;
        }
        bool = false;
        continue;
        i = -1;
        continue;
        i = -1;
        continue;
        i = -1;
        continue;
        i = -1;
      }
      paramFromServiceMsg = ((oidb_0x7df.RspBody)localObject1).rpt_msg_friend_score.get();
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0)) {
        break label453;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend friendList is null or has no data.");
    return;
    label453:
    paramObject = paramFromServiceMsg.iterator();
    while (paramObject.hasNext())
    {
      localObject1 = (oidb_0x7df.FriendScore)paramObject.next();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend uin: ");
        if (((oidb_0x7df.FriendScore)localObject1).uint64_friend_uin.has())
        {
          paramToServiceMsg = String.valueOf(((oidb_0x7df.FriendScore)localObject1).uint64_friend_uin.get());
          label524:
          paramToServiceMsg = ((StringBuilder)localObject2).append(paramToServiceMsg).append(", score: ");
          if (!((oidb_0x7df.FriendScore)localObject1).uint32_friend_score.has()) {
            break label691;
          }
          i = ((oidb_0x7df.FriendScore)localObject1).uint32_friend_score.get();
          label558:
          localObject2 = paramToServiceMsg.append(i).append(", relation: ");
          if (!((oidb_0x7df.FriendScore)localObject1).bytes_relation_name.has()) {
            break label697;
          }
          paramToServiceMsg = ((oidb_0x7df.FriendScore)localObject1).bytes_relation_name.get().toStringUtf8();
          label595:
          paramToServiceMsg = ((StringBuilder)localObject2).append(paramToServiceMsg).append(", rank: ");
          if (!((oidb_0x7df.FriendScore)localObject1).uint32_rank.has()) {
            break label704;
          }
          i = ((oidb_0x7df.FriendScore)localObject1).uint32_rank.get();
          label629:
          localObject2 = paramToServiceMsg.append(i).append(", nick: ");
          if (!((oidb_0x7df.FriendScore)localObject1).bytes_nick.has()) {
            break label710;
          }
        }
        label691:
        label697:
        label704:
        label710:
        for (paramToServiceMsg = ((oidb_0x7df.FriendScore)localObject1).bytes_nick.get().toStringUtf8();; paramToServiceMsg = "")
        {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg);
          break;
          paramToServiceMsg = "";
          break label524;
          i = -1;
          break label558;
          paramToServiceMsg = "";
          break label595;
          i = -1;
          break label629;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.onGetSpecialCareRecommend(paramFromServiceMsg);
    return;
    label726:
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    FriendListHandler.getSpecialRecommendStat = 1;
    a(95, false, null);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0xc26_0".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0xc36_0".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc35_0".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc34_0".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc26_1".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc34_1".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x7df_3".equals(str));
    i(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0xc26_0".equals(paramString)) || ("OidbSvc.0xc36_0".equals(paramString)) || ("OidbSvc.0xc35_0".equals(paramString)) || ("OidbSvc.0xc34_0".equals(paramString)) || ("OidbSvc.0xc26_1".equals(paramString)) || ("OidbSvc.0xc34_1".equals(paramString)) || ("OidbSvc.0x7df_3".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolp
 * JD-Core Version:    0.7.0.1
 */