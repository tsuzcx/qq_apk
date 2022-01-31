package com.tencent.mobileqq.app.utils;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.ContentElement;
import com.trunk.Qworkflow.Qworkflow.Notification;
import com.trunk.Qworkflow.Qworkflow.Observer;
import com.trunk.Qworkflow.Qworkflow.RemindTimer;
import com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.UserSource;
import com.trunk.Qworkflow.Qworkflow.Workflow;
import com.trunk.Qworkflow.Qworkflow.WorkflowContent;
import cooperation.dingdong.DingdongCalendarSyncUtil;
import cooperation.dingdong.DingdongPluginDataFactory;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x4f2.oidb_0x4f2.RspBody;
import tencent.im.oidb.cmd0x508.oidb_0x508.RspBody;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.AppNoticeInfo;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.GetAppNoticeRsp;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.GetOfficeNoticeRsp;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.NoticeInfo;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.ReqBody;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.RspBody;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdRsp;
import tencent.im.oidb.cmd0x589.oidb_0x589.RspBody;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleByIDReq;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleByIDRsp;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleResult;
import tencent.im.oidb.cmd0x592.oidb_0x592.ReqBody;
import tencent.im.oidb.cmd0x592.oidb_0x592.RspBody;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.DecreaseUnreadMailCountReq;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.GetUnreadMailCountRsp;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.ReqBody;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.RspBody;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.UnreadMailCountInfo;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetLatestNodeInfoRsp;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.LiteMailBrief;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ResultMsg;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.RspBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.SourceID;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.UnreadMailCountInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.PbOfficeNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x9c.SubMsgType0x9c.MsgBody;
import zww;

public class DingdongPluginBizHandler
  extends BusinessHandler
{
  public DingdongPluginBizHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private DingdongPluginBizObserver.ScheduleMoreSummaryData a(long paramLong, oidb_0x592.GetScheduleResult paramGetScheduleResult)
  {
    if (paramGetScheduleResult.msg_schedule.has()) {}
    for (Object localObject1 = (Qworkflow.Workflow)paramGetScheduleResult.msg_schedule.get(); localObject1 == null; localObject1 = null) {
      return null;
    }
    DingdongPluginBizObserver.ScheduleMoreSummaryData localScheduleMoreSummaryData = new DingdongPluginBizObserver.ScheduleMoreSummaryData();
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
    if (((Qworkflow.Workflow)localObject1).bytes_workflow_id.has()) {
      localScheduleSummaryData.id = ((Qworkflow.Workflow)localObject1).bytes_workflow_id.get().toStringUtf8();
    }
    if (((Qworkflow.Workflow)localObject1).uint64_author_uin.has()) {
      localScheduleSummaryData.authorUin = Long.toString(((Qworkflow.Workflow)localObject1).uint64_author_uin.get());
    }
    Object localObject4;
    Object localObject3;
    if (((Qworkflow.Workflow)localObject1).msg_workflow_content.has())
    {
      if (((Qworkflow.Workflow)localObject1).msg_workflow_content.bytes_title.has()) {
        localScheduleSummaryData.title = ((Qworkflow.Workflow)localObject1).msg_workflow_content.bytes_title.get().toStringUtf8();
      }
      if (((Qworkflow.Workflow)localObject1).msg_workflow_content.rpt_content_list.has())
      {
        localObject2 = ((Qworkflow.Workflow)localObject1).msg_workflow_content.rpt_content_list.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Qworkflow.ContentElement)((Iterator)localObject2).next();
          if ((((Qworkflow.ContentElement)localObject4).bytes_userdef.has()) && (((Qworkflow.ContentElement)localObject4).rpt_text_list.has()) && (((Qworkflow.Text)((Qworkflow.ContentElement)localObject4).rpt_text_list.get(0)).bytes_content.has()))
          {
            localObject3 = ((Qworkflow.Text)((Qworkflow.ContentElement)localObject4).rpt_text_list.get(0)).bytes_content.get().toStringUtf8();
            localObject4 = ((Qworkflow.ContentElement)localObject4).bytes_userdef.get().toStringUtf8();
            if ("loc".equals(localObject4)) {
              localScheduleSummaryData.location = ((String)localObject3);
            } else if ("mark".equals(localObject4)) {
              localScheduleSummaryData.mark = ((String)localObject3);
            }
          }
        }
      }
    }
    if (((Qworkflow.Workflow)localObject1).msg_remind_timer.has())
    {
      localScheduleSummaryData.beginTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint64_start_time.get();
      localScheduleSummaryData.endTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint64_end_time.get();
      if (((Qworkflow.Workflow)localObject1).msg_remind_timer.uint32_remind_flag.get() != 0) {
        localScheduleSummaryData.offsetTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint32_remind_offset.get();
      }
    }
    Object localObject2 = new ArrayList();
    if (((Qworkflow.Workflow)localObject1).rpt_msg_observers.has())
    {
      localObject1 = ((Qworkflow.Workflow)localObject1).rpt_msg_observers.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Qworkflow.Observer)((Iterator)localObject1).next();
        if (((Qworkflow.Observer)localObject3).msg_observer_source.has())
        {
          localObject4 = new DingdongPluginBizObserver.ConcernUinData();
          ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_a_of_type_JavaLangString = String.valueOf(((Qworkflow.Observer)localObject3).uint64_uin.get());
          ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_b_of_type_JavaLangString = String.valueOf(((Qworkflow.Observer)localObject3).msg_observer_source.uint64_source_code.get());
          switch (((Qworkflow.Observer)localObject3).msg_observer_source.enum_source_type.get())
          {
          }
          for (;;)
          {
            ((ArrayList)localObject2).add(localObject4);
            break;
            ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_a_of_type_Int = 3;
            continue;
            ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_a_of_type_Int = 2;
            continue;
            ((DingdongPluginBizObserver.ConcernUinData)localObject4).jdField_a_of_type_Int = 1;
          }
        }
      }
    }
    localScheduleSummaryData.specialFlag = paramGetScheduleResult.uint32_result.get();
    localScheduleMoreSummaryData.jdField_a_of_type_Long = paramLong;
    localScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData = localScheduleSummaryData;
    localScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
    return localScheduleMoreSummaryData;
  }
  
  private String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    c();
    Object localObject = new Qworkflow.Notification();
    int j;
    boolean bool;
    label155:
    int i;
    try
    {
      ((Qworkflow.Notification)localObject).mergeFrom(paramArrayOfByte);
      localObject = (Qworkflow.ScheduleChangeNotification)((Qworkflow.Notification)localObject).msg_schedule_change.get();
      j = ((Qworkflow.ScheduleChangeNotification)localObject).enum_change_type.get();
      if (!QLog.isColorLevel()) {
        break label328;
      }
      QLog.i("DingdongPluginBizHandler", 2, "change_type = " + j);
    }
    catch (Exception paramArrayOfByte)
    {
      label166:
      return paramArrayOfByte.toString();
    }
    if (((Qworkflow.ScheduleChangeNotification)localObject).msg_summary.has())
    {
      paramArrayOfByte = DingdongPluginDataFactory.a((Qworkflow.Text)((Qworkflow.ScheduleChangeNotification)localObject).msg_summary.get());
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.id = ((Qworkflow.ScheduleChangeNotification)localObject).bytes_workflow_id.get().toStringUtf8();
        paramArrayOfByte.authorUin = String.valueOf(((Qworkflow.ScheduleChangeNotification)localObject).uint64_author_uin.get());
        if (((Qworkflow.ScheduleChangeNotification)localObject).uint32_remind_bell_switch.get() != 1) {
          break label345;
        }
        bool = true;
        paramArrayOfByte.hasAlarm = bool;
        i = paramArrayOfByte.type;
        if (1 == j)
        {
          localObject = new DingdongPluginBizObserver.ScheduleNotificationData();
          ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData = paramArrayOfByte;
          ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_Boolean = paramBoolean;
          if (((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData == null) {
            ((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_Int = -1;
          }
          if (((DingdongPluginBizObserver.ScheduleNotificationData)localObject).jdField_a_of_type_Int != 0) {
            break label351;
          }
        }
      }
    }
    label328:
    label343:
    label345:
    label351:
    for (paramBoolean = true;; paramBoolean = false)
    {
      super.a(10, paramBoolean, localObject);
      break label343;
      if ((5 == j) && (1 == i))
      {
        DingdongCalendarSyncUtil.a(paramArrayOfByte);
      }
      else
      {
        paramArrayOfByte = new DingdongPluginBizObserver.ScheduleChangeNotifyData();
        paramArrayOfByte.jdField_a_of_type_Int = 0;
        paramArrayOfByte.jdField_a_of_type_JavaLangString = ((Qworkflow.ScheduleChangeNotification)localObject).bytes_workflow_id.get().toStringUtf8();
        paramArrayOfByte.jdField_a_of_type_Long = ((Qworkflow.ScheduleChangeNotification)localObject).uint64_author_uin.get();
        paramArrayOfByte.jdField_b_of_type_Int = ((Qworkflow.ScheduleChangeNotification)localObject).enum_change_type.get();
        super.a(9, true, paramArrayOfByte);
        break label343;
        i = 0;
        break label166;
        do
        {
          i = 0;
          paramArrayOfByte = null;
          break label166;
          if (1 == j) {
            break;
          }
        } while (5 != j);
        break;
      }
      return null;
      bool = false;
      break label155;
    }
  }
  
  private void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = 0;
    label7:
    int j;
    if (i < paramList.size())
    {
      Object localObject = (oidb_0x51d.AppNoticeInfo)paramList.get(i);
      long l = ((oidb_0x51d.AppNoticeInfo)localObject).opt_uint64_appdid.get();
      localObject = (oidb_0x51d.NoticeInfo)((oidb_0x51d.AppNoticeInfo)localObject).opt_msg_app_notice.get();
      j = ((oidb_0x51d.NoticeInfo)localObject).opt_uint32_notice_count.get();
      ((oidb_0x51d.NoticeInfo)localObject).opt_uint32_notice_version.get();
      if (l != 1800000002L) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (j <= 0) {
          break;
        }
        OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + this.b.getLongAccountUin(), true);
        a(5, true, null);
        ((DingdongPluginManager)this.b.getManager(114)).a(j);
        return;
        i += 1;
        break label7;
      }
      OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + this.b.getLongAccountUin(), false);
      a(5, true, null);
      return;
      j = 0;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    Object localObject = new oidb_0x589.RspBody();
    int j;
    if (1000 == i)
    {
      j = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      i = j;
      if (j == 0) {
        break label410;
      }
      QLog.e("DingdongPluginBizHandler", 1, "0x589 respond oidb error:retCode[" + j + "].");
      i = j;
    }
    for (;;)
    {
      paramFromServiceMsg = new DingdongPluginBizObserver.GetOpenIdNotifyData();
      paramFromServiceMsg.jdField_a_of_type_Long = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
      if (i != 0) {
        break label489;
      }
      try
      {
        paramToServiceMsg = ((oidb_0x589.RspBody)localObject).rpt_msg_open_id.get();
        paramFromServiceMsg.jdField_b_of_type_Long = ((oidb_0x589.RspBody)localObject).uint64_app_id.get();
        paramFromServiceMsg.jdField_b_of_type_Int = paramToServiceMsg.size();
        paramObject = new DingdongPluginBizObserver.GetOpenIdNotifyData.GetOpenIdData[paramFromServiceMsg.jdField_b_of_type_Int];
        j = 0;
        for (;;)
        {
          if (j < paramFromServiceMsg.jdField_b_of_type_Int)
          {
            localObject = (oidb_0x589.GetUserOpenIdRsp)paramToServiceMsg.get(j);
            paramObject[j] = new DingdongPluginBizObserver.GetOpenIdNotifyData.GetOpenIdData();
            paramObject[j].jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData = new DingdongPluginBizObserver.GetOpenIdNotifyData.ReqData();
            paramObject[j].jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Int = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint32_req_flag.get();
            paramObject[j].jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_a_of_type_Long = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint64_req_uin.get();
            paramObject[j].jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$ReqData.jdField_b_of_type_Long = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint64_req_host_uin.get();
            paramObject[j].jdField_a_of_type_Int = ((oidb_0x589.GetUserOpenIdRsp)localObject).uint32_result.get();
            paramObject[j].jdField_a_of_type_JavaLangString = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_open_id.get().toStringUtf8();
            paramObject[j].jdField_b_of_type_JavaLangString = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_group_open_id.get().toStringUtf8();
            paramObject[j].jdField_c_of_type_JavaLangString = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_discuss_open_id.get().toStringUtf8();
            paramObject[j].d = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_token.get().toStringUtf8();
            j += 1;
            continue;
            QLog.e("DingdongPluginBizHandler", 1, "0x589 respond msf error:retCode[" + i + "],errMsg[" + paramFromServiceMsg.getBusinessFailMsg() + "]");
            label410:
            break;
          }
        }
        paramFromServiceMsg.jdField_a_of_type_ArrayOfComTencentMobileqqAppUtilsDingdongPluginBizObserver$GetOpenIdNotifyData$GetOpenIdData = paramObject;
        paramFromServiceMsg.jdField_a_of_type_Int = 1;
      }
      catch (NullPointerException paramToServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.jdField_a_of_type_Int = -1;
          QLog.e("DingdongPluginBizHandler", 1, "0x589 handleRsp nullPointer error:[" + paramToServiceMsg.toString() + "]");
          i = -1;
        }
      }
    }
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.a(6, bool, paramFromServiceMsg);
      return;
      label489:
      paramFromServiceMsg.jdField_a_of_type_Int = -1;
      break;
    }
  }
  
  private void c()
  {
    if (!OfficeCenterSharedPref.a().a("officecenter_always_show_flag", false)) {
      OfficeCenterSharedPref.a().b("officecenter_always_show_flag", true);
    }
    a(13, true, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    oidb_0x508.RspBody localRspBody = new oidb_0x508.RspBody();
    if (1000 == i)
    {
      i = a(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        int j = localRspBody.opt_uint32_result.get();
        i = j;
        if (j == 0) {
          break label297;
        }
        QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond biz error: retCode[" + j + "].");
        i = j;
        paramFromServiceMsg = new DingdongPluginBizObserver.GetAppListData();
        paramFromServiceMsg.jdField_a_of_type_Long = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
        if (i != 0) {
          break label300;
        }
        paramFromServiceMsg.jdField_a_of_type_Int = localRspBody.opt_uint32_result.get();
        paramFromServiceMsg.jdField_a_of_type_JavaLangString = localRspBody.opt_bytes_errinfo.get().toStringUtf8();
        paramFromServiceMsg.jdField_b_of_type_Long = localRspBody.opt_uint64_update_seq.get();
        paramToServiceMsg = localRspBody.rpt_uint64_appid_list.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramToServiceMsg.size());
          paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList.addAll(paramToServiceMsg);
        }
        label208:
        if (i != 0) {
          break label308;
        }
      }
    }
    label297:
    label300:
    label308:
    for (boolean bool = true;; bool = false)
    {
      super.a(11, bool, paramFromServiceMsg);
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond oidb error: retCode[" + i + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond msf error: retCode[" + i + "].");
      break;
      paramFromServiceMsg.jdField_a_of_type_Int = -1;
      break label208;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    oidb_0x4f2.RspBody localRspBody = new oidb_0x4f2.RspBody();
    if (1000 == i)
    {
      i = a(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        int j = localRspBody.opt_uint32_result.get();
        i = j;
        if (j == 0) {
          break label297;
        }
        QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond biz error: retCode[" + j + "].");
        i = j;
        paramFromServiceMsg = new DingdongPluginBizObserver.SetAppListData();
        paramFromServiceMsg.jdField_a_of_type_Long = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
        if (i != 0) {
          break label300;
        }
        paramFromServiceMsg.jdField_a_of_type_Int = localRspBody.opt_uint32_result.get();
        paramFromServiceMsg.jdField_a_of_type_JavaLangString = localRspBody.opt_bytes_errinfo.get().toStringUtf8();
        paramFromServiceMsg.jdField_b_of_type_Long = localRspBody.opt_uint64_update_seq.get();
        paramToServiceMsg = localRspBody.rpt_uint64_appid_list.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramToServiceMsg.size());
          paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList.addAll(paramToServiceMsg);
        }
        label208:
        if (i != 0) {
          break label308;
        }
      }
    }
    label297:
    label300:
    label308:
    for (boolean bool = true;; bool = false)
    {
      super.a(12, bool, paramFromServiceMsg);
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond oidb error: retCode[" + i + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond msf error: retCode[" + i + "].");
      break;
      paramFromServiceMsg.jdField_a_of_type_Int = -1;
      break label208;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    int k = ((Integer)paramToServiceMsg.getAttribute("OidbSvc.0x8f6_1_subCmd")).intValue();
    paramToServiceMsg = new oidb_cmd0x8f6.RspBody();
    if (1000 == i)
    {
      i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        int j = paramToServiceMsg.uint32_result.get();
        i = j;
        if (j != 0)
        {
          QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond biz error:subCmd[" + k + "],retCode[" + j + "].");
          i = j;
        }
        switch (k)
        {
        }
      }
    }
    label365:
    do
    {
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond oidb error:subCmd[" + k + "],retCode[" + i + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond msf error:subCmd[" + k + "],retCode[" + i + "].");
      break;
      paramFromServiceMsg = new DingdongPluginBizObserver.UnreadNumUpdateData();
      if (i == 0) {}
      for (;;)
      {
        try
        {
          paramToServiceMsg = (oidb_cmd0x8f6.UnreadMailCountInfo)((oidb_cmd0x8f6.GetUnreadMailCountRsp)paramToServiceMsg.msg_get_umc.get()).msg_unread.get();
          paramFromServiceMsg.jdField_b_of_type_Int = paramToServiceMsg.uint32_unread_count.get();
          paramFromServiceMsg.jdField_c_of_type_Int = paramToServiceMsg.uint32_data_version.get();
          if (paramFromServiceMsg.jdField_a_of_type_Int != 0) {
            break label365;
          }
          bool = true;
          super.a(1, bool, paramFromServiceMsg);
          return;
        }
        catch (NullPointerException paramToServiceMsg)
        {
          QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond biz package error:subCmd[0x1],errMsg[" + paramToServiceMsg.toString() + "].");
          paramFromServiceMsg.jdField_a_of_type_Int = -1;
          continue;
        }
        paramFromServiceMsg.jdField_a_of_type_Int = i;
        continue;
        boolean bool = false;
      }
    } while (i != 0);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    int k = ((Integer)paramToServiceMsg.getAttribute("OidbSvc.0x8f9_13_subCmd")).intValue();
    paramToServiceMsg = new oidb_0x8f9.RspBody();
    if (1000 == i)
    {
      i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i != 0) {}
    }
    for (;;)
    {
      try
      {
        int j = paramToServiceMsg.msg_result_msg.uint32_result.get();
        i = j;
        if (j != 0)
        {
          i = j;
          paramFromServiceMsg = paramToServiceMsg.msg_result_msg.bytes_err_msg.get().toStringUtf8();
          i = j;
          QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond biz package error -> subCmd" + k + "retCode[" + j + "],errMsg[" + paramFromServiceMsg + "].");
          i = j;
        }
      }
      catch (NullPointerException paramFromServiceMsg)
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond biz package error -> subCmd" + k + "retCode[" + i + "],errMsg[" + paramFromServiceMsg.toString() + "].");
        i = -1;
        continue;
      }
      switch (k)
      {
      default: 
        return;
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond oidb package error -> subCmd" + k + "retCode[" + i + "].");
        continue;
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond msf error -> subCmd" + k + "retCode[" + i + "].");
      }
    }
    paramFromServiceMsg = new DingdongPluginBizObserver.NodeUpdateData();
    if (i == 0) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg.jdField_a_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.uint32_result.get();
        if (132 == paramFromServiceMsg.jdField_a_of_type_Int)
        {
          paramFromServiceMsg.jdField_a_of_type_Int = 0;
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$LastMsgUpdateData = new DingdongPluginBizObserver.LastMsgUpdateData();
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData = new DingdongPluginBizObserver.UnreadNumUpdateData();
          if (QLog.isColorLevel()) {
            QLog.i("DingdongPluginBizHandler", 2, "0x8f9_13 respond no feed data.");
          }
          if (paramFromServiceMsg.jdField_a_of_type_Int != 0) {
            break label853;
          }
          bool = true;
          super.a(2, bool, paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.jdField_a_of_type_Int == 0)
        {
          paramObject = new DingdongPluginBizObserver.LastMsgUpdateData();
          if (paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.has())
          {
            paramObject.jdField_a_of_type_JavaLangString = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.bytes_feeds_id.get().toStringUtf8();
            paramObject.jdField_c_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint32_last_modify_time.get();
            paramObject.jdField_b_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.msg_source_id.uint32_source_type.get();
            paramObject.jdField_b_of_type_JavaLangString = String.valueOf(paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.msg_source_id.uint64_source_code.get());
            paramObject.jdField_c_of_type_JavaLangString = String.valueOf(paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint64_author_uin.get());
            paramObject.d = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.bytes_feeds_summary.get().toStringUtf8();
            if (1 == paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint32_summary_truncate_flag.get()) {
              paramObject.d = (paramObject.d.substring(0, paramObject.d.length() - 1) + "...");
            }
          }
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$LastMsgUpdateData = paramObject;
          if (!paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.has()) {
            continue;
          }
          paramObject = new DingdongPluginBizObserver.UnreadNumUpdateData();
          paramObject.jdField_b_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.uint32_unread_count.get();
          paramObject.jdField_c_of_type_Int = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.uint32_data_version.get();
          paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData = paramObject;
          continue;
        }
      }
      catch (NullPointerException paramToServiceMsg)
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_13 respond biz error:errMsg[" + paramToServiceMsg.toString() + "].");
        paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$UnreadNumUpdateData = null;
        paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver$LastMsgUpdateData = null;
        paramFromServiceMsg.jdField_a_of_type_Int = -1;
        continue;
      }
      if (paramToServiceMsg.msg_rsp_get_latest_node_info.bytes_err_msg.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.msg_rsp_get_latest_node_info.bytes_err_msg.get().toStringUtf8();; paramToServiceMsg = "serveUnknownError")
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_13 respond biz error -> retCode[" + paramFromServiceMsg.jdField_a_of_type_Int + ",errMsg[" + paramToServiceMsg + "].");
        break;
      }
      paramFromServiceMsg.jdField_a_of_type_Int = i;
      continue;
      label853:
      boolean bool = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x508.RspBody();
    if (1000 == i)
    {
      i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        i = paramToServiceMsg.opt_uint32_result.get();
        if (i != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond biz error: retCode[" + i + "].");
        }
      }
    }
    for (;;)
    {
      new zww(this, paramToServiceMsg).execute(new Void[] { null, null, null });
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond oidb error: retCode[" + i + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond msf error: retCode[" + i + "].");
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x51d.RspBody();
    if (1000 == i)
    {
      i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        i = paramToServiceMsg.opt_uint32_result.get();
        if (i != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond biz error: retCode[" + i + "].");
        }
      }
    }
    for (;;)
    {
      if (paramToServiceMsg.opt_msg_office_notice_rsp.has())
      {
        paramToServiceMsg = (oidb_0x51d.GetOfficeNoticeRsp)paramToServiceMsg.opt_msg_office_notice_rsp.get();
        if (paramToServiceMsg.opt_msg_office_notice.has())
        {
          paramToServiceMsg = (oidb_0x51d.NoticeInfo)paramToServiceMsg.opt_msg_office_notice.get();
          i = paramToServiceMsg.opt_uint32_notice_count.get();
          int j = paramToServiceMsg.opt_uint32_notice_version.get();
          QLog.e("DingdongPluginBizHandler", 4, "handleRspMsg_0x51d_1 cnt: " + i + " ver: " + j);
          if (i > 0)
          {
            OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + this.b.getLongAccountUin(), true);
            OfficeCenterSharedPref.a().a("officecenter_red_point_cnt_" + this.b.getLongAccountUin(), i);
            OfficeCenterSharedPref.a().a("officecenter_red_point_ver_" + this.b.getLongAccountUin(), j);
            a(5, true, null);
          }
        }
      }
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond oidb error: retCode[" + i + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond msf error: retCode[" + i + "].");
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x51d.RspBody();
    if (1000 == i)
    {
      i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        i = paramToServiceMsg.opt_uint32_result.get();
        if (i != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond biz error: retCode[" + i + "].");
        }
      }
    }
    for (;;)
    {
      if (paramToServiceMsg.opt_msg_app_notice_rsp.has())
      {
        paramToServiceMsg = (oidb_0x51d.GetAppNoticeRsp)paramToServiceMsg.opt_msg_app_notice_rsp.get();
        if (paramToServiceMsg.has()) {
          a(paramToServiceMsg.rpt_msg_app_notice.get());
        }
      }
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond oidb error: retCode[" + i + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond msf error: retCode[" + i + "].");
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = null;
    int i = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg.getResultCode();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    if (1000 == i)
    {
      try
      {
        localOIDBSSOPkg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        i = localOIDBSSOPkg.uint32_result.get();
        if (i != 0)
        {
          paramFromServiceMsg = localOIDBSSOPkg.str_error_msg.get();
          QLog.e("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]" + paramToServiceMsg.getServiceCmd() + "." + localOIDBSSOPkg.uint32_service_type.get() + " ssoPkg biz return error(" + i + ") -> " + paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          try
          {
            paramFromServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            paramFromServiceMsg = (oidb_0x592.GetScheduleByIDRsp)paramFromServiceMsg.msg_get_schedule_by_id_rsp.get();
            if (paramFromServiceMsg != null) {
              break;
            }
            i = -1;
            l = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
            if (i != 0) {
              break label469;
            }
            if (QLog.isColorLevel()) {
              QLog.i("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]0x592.FETCH_DETAIL rsp success.],serviceType = " + j + ", seq = " + l);
            }
            paramToServiceMsg = a(l, (oidb_0x592.GetScheduleResult)paramFromServiceMsg.msg_schedule_result.get());
            if (paramToServiceMsg == null) {
              break label558;
            }
            a(14, true, paramToServiceMsg);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            int j;
            QLog.e("DingdongPluginBizHandler", 1, "reqSeq[" + paramToServiceMsg + "]0x592." + j + " decode pkg error -> " + paramFromServiceMsg.toString());
            return;
          }
          paramFromServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg.toString();
          QLog.e("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]" + paramToServiceMsg.getServiceCmd() + " decode ssoPkg error -> " + paramFromServiceMsg.toString());
        }
      }
      j = localOIDBSSOPkg.uint32_service_type.get();
      paramFromServiceMsg = new oidb_0x592.RspBody();
    }
    long l;
    for (;;)
    {
      QLog.e("DingdongPluginBizHandler", 2, "0x592 respond msf error: retCode[" + i + "].");
      break;
      i = paramFromServiceMsg.uint32_result.get();
    }
    label469:
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.bytes_error_msg.has())) {}
    for (paramFromServiceMsg = paramFromServiceMsg.bytes_error_msg.get().toStringUtf8();; paramFromServiceMsg = null)
    {
      QLog.e("DingdongPluginBizHandler", 1, "reqSeq[" + paramToServiceMsg + "]0x592.FETCH_DETAIL rsp error retCode:" + i + ",retMsg:" + paramFromServiceMsg + ", seq = " + l);
      paramToServiceMsg = paramObject;
      break;
      label558:
      ((DingdongPluginManager)this.b.getManager(114)).a(l);
      return;
    }
  }
  
  public Class a()
  {
    return DingdongPluginBizObserver.class;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_cmd0x8f6.ReqBody();
    ((oidb_cmd0x8f6.ReqBody)localObject).uint32_subcmd.set(2);
    oidb_cmd0x8f6.DecreaseUnreadMailCountReq localDecreaseUnreadMailCountReq = new oidb_cmd0x8f6.DecreaseUnreadMailCountReq();
    localDecreaseUnreadMailCountReq.uint32_type.set(1);
    localDecreaseUnreadMailCountReq.uint32_amount.set(paramInt1);
    localDecreaseUnreadMailCountReq.uint32_data_version.set(paramInt2);
    ((oidb_cmd0x8f6.ReqBody)localObject).msg_dec_umc.set(localDecreaseUnreadMailCountReq, true);
    localObject = super.a("OidbSvc.0x8f6_1", 2294, 1, ((oidb_cmd0x8f6.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("OidbSvc.0x8f6_1_subCmd", Integer.valueOf(2));
    super.b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong)
  {
    oidb_0x51d.ReqBody localReqBody = new oidb_0x51d.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.opt_uint64_handled_uin.set(this.b.getLongAccountUin());
    if (paramLong > 0L) {
      localReqBody.opt_uint64_office_appid.set(paramLong);
    }
    super.b(super.a("OidbSvc.0x51d_2", 1309, 2, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginBizHandler", 2, "getScheduleDetail workFlowId = " + paramString + " req =" + paramLong + ",serviceType = " + 3);
    }
    oidb_0x592.GetScheduleByIDReq localGetScheduleByIDReq = new oidb_0x592.GetScheduleByIDReq();
    localGetScheduleByIDReq.bytes_workflow_id.set(ByteStringMicro.copyFrom(paramString.getBytes()), true);
    paramString = new oidb_0x592.ReqBody();
    paramString.msg_appid.setHasFlag(true);
    paramString.msg_appid.uint64_appid.set(1800000002L);
    paramString.msg_appid.uint32_type.set(3);
    paramString.msg_get_schedule_by_id_req.set(localGetScheduleByIDReq, true);
    paramString = super.a("OidbSvc.0x592", 1426, 3, paramString.toByteArray());
    paramString.addAttribute("ReqSeq", Long.valueOf(paramLong));
    paramString.setTimeout(20000L);
    super.b(paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0x8f6_1".equals(str)) {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0x8f9_13".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x51d_1".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x51d_2".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x508_1".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x589".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x508_2".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f2".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x592".equals(str));
    j(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(SubMsgType0x9b.MsgBody paramMsgBody)
  {
    c();
    int i = paramMsgBody.uint32_main_type.get();
    String str = paramMsgBody.bytes_workflow_id.get().toStringUtf8();
    boolean bool = OfficeCenterSharedPref.a().a("officecenter_mark_leave_activity", true);
    if (i == 1) {
      if (!bool)
      {
        paramMsgBody = new Intent();
        paramMsgBody.putExtra("reqCode", 4);
        paramMsgBody.putExtra("serviceType", i);
        DingdongPluginHelper.a(2, paramMsgBody);
      }
    }
    for (;;)
    {
      return;
      if (i == 2)
      {
        SubMsgType0x9b.PbOfficeNotify localPbOfficeNotify = new SubMsgType0x9b.PbOfficeNotify();
        paramMsgBody = paramMsgBody.bytes_ext_msg.get().toByteArray();
        try
        {
          localPbOfficeNotify.mergeFrom(paramMsgBody);
          int j = localPbOfficeNotify.opt_uint32_myoffice_flag.get();
          paramMsgBody = localPbOfficeNotify.rpt_uint64_appid.get();
          QLog.i("DingdongPluginBizHandler", 4, "0x210_0x9b push msg, serviceType: " + i + " workId: " + str + " flag: " + j + " id list: " + paramMsgBody.toString());
          if ((j == 1) && (bool)) {
            b();
          }
          if (paramMsgBody.size() > 0)
          {
            paramMsgBody = new Intent();
            paramMsgBody.putExtra("reqCode", 4);
            paramMsgBody.putExtra("serviceType", i);
            paramMsgBody.putExtra("hasAppNotice", true);
            DingdongPluginHelper.a(2, paramMsgBody);
            a(0L);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsgBody)
        {
          paramMsgBody.printStackTrace();
        }
      }
    }
  }
  
  public void a(SubMsgType0x9b.MsgBody paramMsgBody, boolean paramBoolean)
  {
    long l = paramMsgBody.uint64_app_id.get();
    if (QLog.isColorLevel()) {
      QLog.i("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b. appid = " + l + "  beoffline = " + paramBoolean);
    }
    if (1800000000L == l) {
      a(paramMsgBody);
    }
    do
    {
      do
      {
        return;
      } while ((1800000002L != l) || (!paramMsgBody.uint32_main_type.has()) || (!paramMsgBody.uint32_sub_type.has()) || (paramMsgBody.uint32_main_type.get() != 100) || (paramMsgBody.uint32_sub_type.get() != 1));
      paramMsgBody = a(paramMsgBody.bytes_ext_msg.get().toByteArray(), paramBoolean);
    } while (paramMsgBody == null);
    QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b.100 error(-1):" + paramMsgBody + ".");
  }
  
  public void a(SubMsgType0x9c.MsgBody paramMsgBody, boolean paramBoolean)
  {
    switch (paramMsgBody.uint32_main_type.get())
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMsgBody.uint32_sub_type.get() != 1);
      paramMsgBody = a(paramMsgBody.bytes_ext_msg.get().toByteArray(), paramBoolean);
    } while (paramMsgBody == null);
    QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b.100 error(-1):" + paramMsgBody + ".");
  }
  
  public void b()
  {
    oidb_0x51d.ReqBody localReqBody = new oidb_0x51d.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.opt_uint64_handled_uin.set(this.b.getLongAccountUin());
    super.b(super.a("OidbSvc.0x51d_1", 1309, 1, localReqBody.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.DingdongPluginBizHandler
 * JD-Core Version:    0.7.0.1
 */