import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x983.oidb_cmd0x983.AddonItem;
import tencent.im.oidb.cmd0x983.oidb_cmd0x983.ReqBody;
import tencent.im.oidb.cmd0x983.oidb_cmd0x983.RspBody;
import tencent.im.oidb.lbspack.MqqLbsPack.LBSSig;
import tencent.im.oidb.lbspack.MqqLbsPack.PoiInfo;
import tencent.im.oidb.lbspack.MqqLbsPack.ReqGetLBSPID;
import tencent.im.oidb.lbspack.MqqLbsPack.ReqGetPOIList;
import tencent.im.oidb.lbspack.MqqLbsPack.ReqOpenLBSRPReport;
import tencent.im.oidb.lbspack.MqqLbsPack.RspGetLBSPID;
import tencent.im.oidb.lbspack.MqqLbsPack.RspGetPOIList;
import tencent.im.oidb.lbspack.MqqLbsPack.RspHead;
import tencent.im.oidb.lbspack.MqqLbsPack.RspOpenLBSRPReport;
import tencent.im.oidb.lbspack.MqqLbsPack.SelectedUinInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bhws
  extends MSFServlet
{
  public static ByteStringMicro a(String paramString)
  {
    ByteStringMicro localByteStringMicro = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = paramString.getBytes();; paramString = null)
    {
      if (paramString != null) {
        localByteStringMicro = ByteStringMicro.copyFrom(paramString);
      }
      return localByteStringMicro;
    }
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 2: 
      return 3;
    case 3: 
      return 1;
    }
    return 7;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    boolean bool1;
    int i;
    Bundle localBundle;
    int j;
    Object localObject;
    if (paramFromServiceMsg == null)
    {
      bool1 = false;
      i = paramIntent.getIntExtra("k_cmd", 0);
      localBundle = new Bundle();
      j = a(i);
      if (!bool1) {
        break label984;
      }
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        switch (i)
        {
        case 1: 
          label96:
          throw new RuntimeException("unknow cmd: " + i);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("LbsPack", 2, "LbsPackPoiListServlet onReceive exception:" + i);
          bool1 = bool2;
        }
      }
    }
    label768:
    label984:
    label1115:
    label1130:
    for (;;)
    {
      notifyObserver(paramIntent, j, bool1, localBundle, bhwr.class);
      return;
      bool1 = paramFromServiceMsg.isSuccess();
      break;
      localObject = new MqqLbsPack.RspGetPOIList();
      ((MqqLbsPack.RspGetPOIList)localObject).mergeFrom(paramFromServiceMsg);
      if (((MqqLbsPack.RspGetPOIList)localObject).rpt_msg_poi_info_list.has())
      {
        paramFromServiceMsg = ((MqqLbsPack.RspGetPOIList)localObject).rpt_msg_poi_info_list.get();
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_POI_LIST_REQ poiList.size = " + paramFromServiceMsg.size());
        }
      }
      if (((MqqLbsPack.RspGetPOIList)localObject).msg_head.has())
      {
        paramFromServiceMsg = (MqqLbsPack.RspHead)((MqqLbsPack.RspGetPOIList)localObject).msg_head.get();
        int k = paramFromServiceMsg.uint32_result.get();
        if (k != 0) {
          bhwt.a("actLbsSendPoiListFailure", k);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_POI_LIST_REQ result = " + k);
          }
          localBundle.putInt("key_receive_result", k);
          paramFromServiceMsg = paramFromServiceMsg.bytes_err_msg.get().toStringUtf8();
          if (paramFromServiceMsg == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_POI_LIST_REQ errMsg = " + paramFromServiceMsg);
          }
          localBundle.putString("key_erro_msg", paramFromServiceMsg);
          break;
          bhwt.a("actLbsSendPoiListFailure");
        }
        localObject = new MqqLbsPack.RspOpenLBSRPReport();
        ((MqqLbsPack.RspOpenLBSRPReport)localObject).mergeFrom(paramFromServiceMsg);
        if (((MqqLbsPack.RspOpenLBSRPReport)localObject).msg_head.has())
        {
          paramFromServiceMsg = ((MqqLbsPack.RspOpenLBSRPReport)localObject).msg_head;
          k = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_REPORT_OPEN_LBS_PACK_REQ result = " + k);
          }
          localBundle.putInt("key_receive_result", k);
          paramFromServiceMsg = paramFromServiceMsg.bytes_err_msg.get().toStringUtf8();
          if (paramFromServiceMsg != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive  CMD_REPORT_OPEN_LBS_PACK_REQ errMsg = " + paramFromServiceMsg);
            }
            localBundle.putString("key_erro_msg", paramFromServiceMsg);
            break label1130;
            localObject = new MqqLbsPack.RspGetLBSPID();
            ((MqqLbsPack.RspGetLBSPID)localObject).mergeFrom(paramFromServiceMsg);
            if (((MqqLbsPack.RspGetLBSPID)localObject).msg_head.has())
            {
              k = ((MqqLbsPack.RspHead)((MqqLbsPack.RspGetLBSPID)localObject).msg_head.get()).uint32_result.get();
              if (QLog.isColorLevel()) {
                QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_PID result = " + k);
              }
              if (k != 0) {
                break label768;
              }
              bhwt.a("actLbsSendGetPidFailure");
            }
            for (;;)
            {
              localBundle.putInt("key_receive_result", k);
              paramFromServiceMsg = ((MqqLbsPack.RspGetLBSPID)localObject).msg_head.bytes_err_msg.get().toStringUtf8();
              if (paramFromServiceMsg != null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive  CMD_GET_PID errMsg = " + paramFromServiceMsg);
                }
                localBundle.putString("key_erro_msg", paramFromServiceMsg);
              }
              if (!((MqqLbsPack.RspGetLBSPID)localObject).bytes_pid.has()) {
                break;
              }
              paramFromServiceMsg = ((MqqLbsPack.RspGetLBSPID)localObject).bytes_pid.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_PID pid = " + paramFromServiceMsg);
              }
              localBundle.putString("key_pid", paramFromServiceMsg);
              break;
              bhwt.a("actLbsSendGetPidFailure", k);
            }
            localObject = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
            if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() == 0) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null))
            {
              paramFromServiceMsg = new oidb_cmd0x983.RspBody();
              paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
              if (paramFromServiceMsg.rpt_addon_list.has())
              {
                localObject = paramFromServiceMsg.rpt_addon_list.get();
                if (localObject != null)
                {
                  paramFromServiceMsg = new ArrayList(((List)localObject).size());
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    oidb_cmd0x983.AddonItem localAddonItem = (oidb_cmd0x983.AddonItem)((Iterator)localObject).next();
                    paramFromServiceMsg.add(localAddonItem.uint32_addon_id.get() + "");
                  }
                  localBundle.putStringArrayList("key_lbs_template_ids", paramFromServiceMsg);
                }
              }
            }
            localBundle.putInt("key_lbs_template_cookie", paramIntent.getIntExtra("key_lbs_template_cookie", -1));
            break label1130;
            switch (i)
            {
            default: 
              break;
            case 1: 
              bhwt.a("actLbsSendPoiListFailure", -10006);
              break;
            case 2: 
              break;
            case 3: 
              bhwt.a("actLbsSendGetPidFailure", -10006);
              break;
            case 4: 
              if (QLog.isColorLevel())
              {
                if (paramFromServiceMsg == null) {
                  break label1115;
                }
                QLog.d("LbsPack", 2, "onReceive. LBSTemplate. resultCode:" + paramFromServiceMsg.getResultCode() + " errorMsg:" + paramFromServiceMsg.getBusinessFailMsg());
              }
              for (;;)
              {
                localBundle.putInt("key_lbs_template_cookie", paramIntent.getIntExtra("key_lbs_template_cookie", -1));
                break;
                QLog.d("LbsPack", 2, "onReceive. LBSTemplate fail");
              }
              break label96;
            }
          }
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject2;
    int j;
    Object localObject1;
    Object localObject3;
    int k;
    int m;
    switch (i)
    {
    default: 
      throw new RuntimeException("unknow cmd: " + i);
    case 1: 
      localObject2 = "LBSRedPack.ReqGetPOIList";
      i = paramIntent.getIntExtra("key_longitude", 0);
      j = paramIntent.getIntExtra("key_latitude", 0);
      localObject1 = new MqqLbsPack.LBSSig();
      ((MqqLbsPack.LBSSig)localObject1).int32_lon.set(i);
      ((MqqLbsPack.LBSSig)localObject1).int32_lat.set(j);
      ((MqqLbsPack.LBSSig)localObject1).uint32_time.set(paramIntent.getIntExtra("key_time", 0));
      localObject3 = paramIntent.getStringExtra("key_verify_key");
      if (localObject3 != null) {
        ((MqqLbsPack.LBSSig)localObject1).bytes_verify_key.set(a((String)localObject3));
      }
      k = paramIntent.getIntExtra("key_longitude_cur", 0);
      m = paramIntent.getIntExtra("key_latitude_cur", 0);
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsPackPoiListServlet onSend CMD_GET_POI_LIST_REQ  longitude_cur = " + k + ", latitude_cur = " + m + ", longitude = " + i + ", latitude = " + j);
      }
      localObject3 = new MqqLbsPack.ReqGetPOIList();
      ((MqqLbsPack.ReqGetPOIList)localObject3).int32_lon.set(k);
      ((MqqLbsPack.ReqGetPOIList)localObject3).int32_lat.set(m);
      ((MqqLbsPack.ReqGetPOIList)localObject3).msg_lbs_sig.set((MessageMicro)localObject1);
      ((MqqLbsPack.ReqGetPOIList)localObject3).uint32_lbs_accuracy.set(paramIntent.getIntExtra("key_accuracy", 0));
      paramIntent = paramIntent.getStringExtra("key_encrypt_sig");
      if (paramIntent != null) {
        ((MqqLbsPack.ReqGetPOIList)localObject3).bytes_encrypt_sig.set(a(paramIntent));
      }
      localObject1 = ((MqqLbsPack.ReqGetPOIList)localObject3).toByteArray();
      paramIntent = (Intent)localObject2;
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        localObject2 = ByteBuffer.allocate(localObject1.length + 4);
        ((ByteBuffer)localObject2).putInt(localObject1.length + 4).put((byte[])localObject1);
        localObject1 = ((ByteBuffer)localObject2).array();
        paramPacket.setSSOCommand(paramIntent);
        paramPacket.putSendData((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "LbsPackPoiListServlet onSend ssoCmd:" + paramIntent);
        }
      }
      return;
      localObject1 = "LBSRedPack.ReqOpenLBSRPReport";
      long l = paramIntent.getLongExtra("key_poi_id", 0L);
      localObject2 = paramIntent.getStringExtra("key_pid");
      i = paramIntent.getIntExtra("key_pack_status", 0);
      paramIntent = new MqqLbsPack.ReqOpenLBSRPReport();
      paramIntent.uint64_poi_id.set(l);
      if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        paramIntent.bytes_pid.set(a((String)localObject2), true);
      }
      paramIntent.uint32_status.set(i);
      localObject2 = paramIntent.toByteArray();
      paramIntent = (Intent)localObject1;
      localObject1 = localObject2;
      continue;
      localObject1 = "LBSRedPack.ReqGetLBSPID";
      i = paramIntent.getIntExtra("key_longitude", 0);
      j = paramIntent.getIntExtra("key_latitude", 0);
      localObject2 = new MqqLbsPack.LBSSig();
      ((MqqLbsPack.LBSSig)localObject2).int32_lon.set(i);
      ((MqqLbsPack.LBSSig)localObject2).int32_lat.set(j);
      ((MqqLbsPack.LBSSig)localObject2).uint32_time.set(paramIntent.getIntExtra("key_time", 0));
      localObject3 = paramIntent.getStringExtra("key_verify_key");
      if (localObject3 != null) {
        ((MqqLbsPack.LBSSig)localObject2).bytes_verify_key.set(a((String)localObject3));
      }
      MqqLbsPack.SelectedUinInfo localSelectedUinInfo = new MqqLbsPack.SelectedUinInfo();
      localSelectedUinInfo.uint32_all_frd.set(paramIntent.getIntExtra("key_all_friends_flag", 0));
      l = paramIntent.getLongExtra("key_group_id", 0L);
      if (l != 0L) {
        localSelectedUinInfo.uint64_group_code.set(l);
      }
      l = paramIntent.getLongExtra("key_dicuss_id", 0L);
      if (l != 0L) {
        localSelectedUinInfo.uint64_discuss_uin.set(l);
      }
      l = paramIntent.getLongExtra("key_friend_uin", 0L);
      if (l != 0L) {
        localSelectedUinInfo.uint64_uin.set(l);
      }
      k = paramIntent.getIntExtra("key_poi_latitude", 0);
      m = paramIntent.getIntExtra("key_poi_longitude", 0);
      localObject3 = new MqqLbsPack.PoiInfo();
      ((MqqLbsPack.PoiInfo)localObject3).int32_lat.set(k);
      ((MqqLbsPack.PoiInfo)localObject3).int32_lon.set(m);
      Object localObject4 = paramIntent.getStringExtra("key_poi_NAME");
      if (localObject4 != null) {
        ((MqqLbsPack.PoiInfo)localObject3).bytes_name.set(a((String)localObject4));
      }
      localObject4 = paramIntent.getStringExtra("key_poi_address");
      if (localObject4 != null) {
        ((MqqLbsPack.PoiInfo)localObject3).bytes_addr.set(a((String)localObject4));
      }
      ((MqqLbsPack.PoiInfo)localObject3).uint64_poi_id.set(paramIntent.getLongExtra("key_poi_id", 0L));
      int n = paramIntent.getIntExtra("key_longitude_cur", 0);
      int i1 = paramIntent.getIntExtra("key_latitude_cur", 0);
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsPackPoiListServlet onSend CMD_GET_PID  longitude_cur1 = " + n + ", latitude_cur1 = " + i1 + ", longitude1 = " + i + ", latitude1 = " + j + ", latitude_poi = " + k + ", longitude_poi = " + m);
      }
      localObject4 = new MqqLbsPack.ReqGetLBSPID();
      ((MqqLbsPack.ReqGetLBSPID)localObject4).int32_lon.set(n);
      ((MqqLbsPack.ReqGetLBSPID)localObject4).int32_lat.set(i1);
      ((MqqLbsPack.ReqGetLBSPID)localObject4).uin_grp_dis_info.set(localSelectedUinInfo);
      ((MqqLbsPack.ReqGetLBSPID)localObject4).msg_lbs_sig.set((MessageMicro)localObject2);
      ((MqqLbsPack.ReqGetLBSPID)localObject4).uint32_lbs_accuracy.set(paramIntent.getIntExtra("key_accuracy", 0));
      localObject2 = paramIntent.getStringExtra("key_encrypt_sig");
      if (localObject2 != null) {
        ((MqqLbsPack.ReqGetLBSPID)localObject4).bytes_encrypt_sig.set(a((String)localObject2));
      }
      ((MqqLbsPack.ReqGetLBSPID)localObject4).uint32_qa.set(paramIntent.getIntExtra("key_posion_flag", 0));
      ((MqqLbsPack.ReqGetLBSPID)localObject4).msg_poi_info.set((MessageMicro)localObject3);
      localObject2 = ((MqqLbsPack.ReqGetLBSPID)localObject4).toByteArray();
      paramIntent = (Intent)localObject1;
      localObject1 = localObject2;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "onSend. LBSTemplate");
      }
      localObject1 = "OidbSvc.0x983";
      double d1 = paramIntent.getDoubleExtra("key_longitude", 0.0D);
      double d2 = paramIntent.getDoubleExtra("key_latitude", 0.0D);
      i = paramIntent.getIntExtra("key_lbs_template_network_type", 0);
      paramIntent = new oidb_cmd0x983.ReqBody();
      localObject2 = new appoint_define.LBSInfo();
      localObject3 = new appoint_define.GPS();
      ((appoint_define.GPS)localObject3).int32_lon.set((int)(d1 * 1000000.0D));
      ((appoint_define.GPS)localObject3).int32_lat.set((int)(d2 * 1000000.0D));
      ((appoint_define.GPS)localObject3).int32_type.set(1);
      ((appoint_define.LBSInfo)localObject2).msg_gps.set((MessageMicro)localObject3);
      paramIntent.msg_lbs_info.set((MessageMicro)localObject2);
      paramIntent.uint32_network.set(i);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2435);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      localObject2 = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
      paramIntent = (Intent)localObject1;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhws
 * JD-Core Version:    0.7.0.1
 */