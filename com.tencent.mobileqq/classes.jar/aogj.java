import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_0xdea.GetBarrageListReqBody;
import tencent.im.oidb.oidb_0xdea.GetBarrageListRspBody;
import tencent.im.oidb.oidb_0xdea.ReqBody;
import tencent.im.oidb.oidb_0xdea.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aogj
  extends MSFServlet
{
  private oidb_0xdea.GetBarrageListRspBody a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = paramFromServiceMsg.getWupBuffer();
    if ((localObject == null) || (localObject.length == 0)) {
      return null;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    localObject = ByteBuffer.wrap((byte[])localObject);
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject).getInt() - 4];
    ((ByteBuffer)localObject).get(arrayOfByte);
    try
    {
      paramFromServiceMsg.mergeFrom(arrayOfByte);
      int i = paramFromServiceMsg.uint32_result.get();
      localObject = paramFromServiceMsg.str_error_msg.get();
      if (QLog.isColorLevel())
      {
        localObject = " oidbHeader: " + i + " errorStr: " + (String)localObject;
        QLog.d("DanmuDataHolder", 2, "parseDanmuRspBody, errorStr:" + (String)localObject);
      }
      paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      return null;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      try
      {
        localObject = new oidb_0xdea.RspBody();
        ((oidb_0xdea.RspBody)localObject).mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = (oidb_0xdea.GetBarrageListRspBody)((oidb_0xdea.RspBody)localObject).get_barrage_list_rsp.get();
        return paramFromServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.d("DanmuDataHolder", 1, "parseDanmuRspBody, e: " + paramFromServiceMsg);
      }
      paramFromServiceMsg = paramFromServiceMsg;
      QLog.d("DanmuDataHolder", 1, "parseDanmuRspBody: mergeFrom:" + paramFromServiceMsg);
      return null;
    }
  }
  
  private void a(aogd paramaogd, oidb_0xdea.GetBarrageListRspBody paramGetBarrageListRspBody)
  {
    int i = paramGetBarrageListRspBody.int32_ret_code.get();
    String str1 = paramGetBarrageListRspBody.str_err_msg.get();
    String str2 = paramGetBarrageListRspBody.str_wording.get();
    boolean bool = paramGetBarrageListRspBody.bool_is_end.get();
    int j = paramGetBarrageListRspBody.uint32_total_count.get();
    int k = paramGetBarrageListRspBody.uint32_next_start_index.get();
    List localList1 = paramGetBarrageListRspBody.rpt_comment_list.get();
    List localList2 = paramGetBarrageListRspBody.rpt_recall_del_seq_list.get();
    int m = paramGetBarrageListRspBody.uint32_last_update_time.get();
    int n = paramGetBarrageListRspBody.uint32_time_interval.get();
    if (QLog.isColorLevel())
    {
      paramGetBarrageListRspBody = "lastUpdateTime:" + m + ", intervalTime:" + n + ", retCode:" + i + ", errInfo:" + str1 + ", errInfoShow:" + str2 + ", isFinish:" + bool + ", totalCount:" + j + ", nextStartIdx:" + k + ", danmuItemListSize:" + localList1.size() + ", recallDeleteList:" + localList2.toString();
      QLog.d("DanmuDataHolder", 2, "handleDanmuRspPack barrInfo:" + paramGetBarrageListRspBody);
    }
    paramaogd.a(aogc.a().a(localList1, paramaogd.jdField_a_of_type_Aogb.b)).b(localList2).a(m).b(n).c(k).a(bool).a();
  }
  
  void a(aogd paramaogd)
  {
    if (paramaogd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataHolder", 2, "request called, reqHolder null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataHolder", 2, "request called, param:" + paramaogd.a());
    }
    Object localObject = new oidb_0xdea.GetBarrageListReqBody();
    ((oidb_0xdea.GetBarrageListReqBody)localObject).uint64_group_code.set(paramaogd.jdField_a_of_type_Aogb.b);
    ((oidb_0xdea.GetBarrageListReqBody)localObject).uint64_barrage_seq.set(paramaogd.jdField_a_of_type_Aogb.jdField_a_of_type_Long);
    ((oidb_0xdea.GetBarrageListReqBody)localObject).uint32_last_update_time.set(paramaogd.jdField_a_of_type_Int);
    ((oidb_0xdea.GetBarrageListReqBody)localObject).uint32_start_index.set(paramaogd.e);
    ((oidb_0xdea.GetBarrageListReqBody)localObject).uint32_barrage_count.set(paramaogd.f);
    int i;
    if ((paramaogd.jdField_a_of_type_Aogb.jdField_a_of_type_Int == 101) || (paramaogd.jdField_a_of_type_Aogb.jdField_a_of_type_Int == 103))
    {
      i = 1;
      if (i == 0) {
        break label327;
      }
      ((oidb_0xdea.GetBarrageListReqBody)localObject).uint32_video_start_time.set(paramaogd.jdField_c_of_type_Int);
      ((oidb_0xdea.GetBarrageListReqBody)localObject).uint32_video_end_time.set(paramaogd.jdField_d_of_type_Int);
      label182:
      ((oidb_0xdea.GetBarrageListReqBody)localObject).terminal.set(0);
      switch (paramaogd.jdField_a_of_type_Aogb.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      oidb_0xdea.ReqBody localReqBody = new oidb_0xdea.ReqBody();
      localReqBody.get_barrage_list_req.set((MessageMicro)localObject);
      localObject = aogc.a().a();
      NewIntent localNewIntent = new NewIntent(((QQAppInterface)localObject).getApp(), aogj.class);
      localNewIntent.putExtra("KEY_SEND_DATA", localReqBody.toByteArray());
      localNewIntent.putExtra("KEY_GROUP_UIN", paramaogd.jdField_a_of_type_Aogb.b);
      localNewIntent.putExtra("KEY_TOPIC_UIN", paramaogd.jdField_a_of_type_Aogb.jdField_a_of_type_Long);
      ((QQAppInterface)localObject).startServlet(localNewIntent);
      return;
      i = 0;
      break;
      label327:
      ((oidb_0xdea.GetBarrageListReqBody)localObject).uint32_video_start_time.set(0);
      ((oidb_0xdea.GetBarrageListReqBody)localObject).uint32_video_end_time.set(0);
      break label182;
      ((oidb_0xdea.GetBarrageListReqBody)localObject).entrance.set(4);
      continue;
      ((oidb_0xdea.GetBarrageListReqBody)localObject).entrance.set(3);
      continue;
      ((oidb_0xdea.GetBarrageListReqBody)localObject).entrance.set(2);
      continue;
      ((oidb_0xdea.GetBarrageListReqBody)localObject).entrance.set(1);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataHolder", 2, "onReceive:" + paramFromServiceMsg);
    }
    int i = paramFromServiceMsg.getResultCode();
    long l1 = paramIntent.getLongExtra("KEY_TOPIC_UIN", 0L);
    long l2 = paramIntent.getLongExtra("KEY_GROUP_UIN", 0L);
    if ((l1 == 0L) || (l2 == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataHolder", 2, "onReceive, topicUin:0, groupUin:0");
      }
      if (i == 1000) {}
      for (;;)
      {
        aogl.a(bool1, i, -1, false, "onReceive, topicUin:0, groupUin:0");
        return;
        bool1 = false;
      }
    }
    paramIntent = aogc.a().a(l2, l1);
    aogd localaogd = aogc.a().a(paramIntent);
    if (localaogd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataHolder", 2, "onReceive, holder null");
      }
      if (i == 1000) {}
      for (bool1 = bool2;; bool1 = false)
      {
        aogl.a(bool1, i, -1, false, "onReceive, holder null");
        return;
      }
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramIntent = a(paramFromServiceMsg);
      if (paramIntent != null) {
        a(localaogd, paramIntent);
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      if (i == 1000)
      {
        bool2 = true;
        int j = localaogd.jdField_a_of_type_Aogb.jdField_a_of_type_Int;
        if (!bool1) {
          break label379;
        }
        paramIntent = "DanmuRsp Valid";
        label246:
        aogl.a(bool2, i, j, bool1, paramIntent);
        if (!bool1) {
          break label395;
        }
        paramFromServiceMsg = localaogd.jdField_a_of_type_Aogh;
        aogb localaogb = localaogd.jdField_a_of_type_Aogb;
        bool2 = localaogd.jdField_a_of_type_Boolean;
        i = localaogd.b;
        if (!localaogd.jdField_a_of_type_Aogb.jdField_a_of_type_Boolean) {
          break label386;
        }
        paramIntent = localaogd.jdField_c_of_type_JavaUtilList;
        label305:
        paramFromServiceMsg.a(localaogb, true, bool2, i, (ArrayList)paramIntent, localaogd.jdField_a_of_type_JavaUtilList);
        localaogd.jdField_a_of_type_Aogb.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        if ((!bool1) || (localaogd.jdField_a_of_type_Boolean)) {
          break label424;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DanmuDataHolder", 2, "onReceive, 没有结束，接力拉取");
        }
        a(localaogd);
        return;
        bool2 = false;
        break;
        label379:
        paramIntent = "DanmuRsp Null";
        break label246;
        label386:
        paramIntent = localaogd.jdField_d_of_type_JavaUtilList;
        break label305;
        label395:
        localaogd.jdField_a_of_type_Aogh.a(localaogd.jdField_a_of_type_Aogb, false, localaogd.jdField_a_of_type_Boolean, localaogd.b, null, null);
      }
      label424:
      break;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getByteArrayExtra("KEY_SEND_DATA");
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3562);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent));
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.f());
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = new byte[paramIntent.length + 4];
    bdqa.a((byte[])localObject, 0, paramIntent.length + 4);
    bdqa.a((byte[])localObject, 4, paramIntent, paramIntent.length);
    paramPacket.setSSOCommand("OidbSvc.0xdea");
    paramPacket.putSendData((byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogj
 * JD-Core Version:    0.7.0.1
 */