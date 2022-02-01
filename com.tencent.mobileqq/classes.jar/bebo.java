import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg.ExternMsg;
import tencent.im.longconn.multimsg.MultiMsg.Ipv4Info;
import tencent.im.longconn.multimsg.MultiMsg.Ipv6Info;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownReq;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class bebo
  extends bebf
{
  int a;
  
  private void a(int paramInt, becg parambecg, MultiMsg.ReqBody paramReqBody)
  {
    parambecg = (becb)parambecg;
    MultiMsg.MultiMsgApplyDownReq localMultiMsgApplyDownReq = new MultiMsg.MultiMsgApplyDownReq();
    localMultiMsgApplyDownReq.setHasFlag(true);
    localMultiMsgApplyDownReq.bytes_msg_resid.set(ByteStringMicro.copyFrom(parambecg.jdField_a_of_type_ArrayOfByte));
    localMultiMsgApplyDownReq.uint32_msg_type.set(bebp.b(parambecg.f));
    localMultiMsgApplyDownReq.uint64_src_uin.set(Long.valueOf(parambecg.c).longValue());
    try
    {
      localMultiMsgApplyDownReq.bytes_msg_key.set(ByteStringMicro.copyFrom(bdsp.b()));
      localMultiMsgApplyDownReq.bytes_msg_sig.set(ByteStringMicro.copyFrom(bdsp.c()));
      List localList = bdsp.a(false);
      if (QLog.isDevelopLevel()) {
        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler addone bdh serverIP4.size  " + localList.size());
      }
      if (localList.size() > 0)
      {
        localObject1 = localList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label312;
          }
          localObject2 = (ExcitingTransferHostInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            MultiMsg.Ipv4Info localIpv4Info = new MultiMsg.Ipv4Info();
            localIpv4Info.uint32_ip_v4_addr.set(awqu.a(((ExcitingTransferHostInfo)localObject2).mstrIp));
            if (QLog.isDevelopLevel()) {
              QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler ipv4:  " + ((ExcitingTransferHostInfo)localObject2).mstrIp);
            }
            localIpv4Info.uint32_ip_v4_port.set(((ExcitingTransferHostInfo)localObject2).mport);
            if (!((ExcitingTransferHostInfo)localObject2).mIsHttps) {
              break;
            }
            paramInt = 1;
            localIpv4Info.uint32_is_https_addr.set(paramInt);
            localMultiMsgApplyDownReq.rpt_ip_v4_info.add(localIpv4Info);
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        QLog.e("MultiMsg_TAG", 1, localException, new Object[0]);
        continue;
        paramInt = 0;
      }
      label312:
      Object localObject1 = bdsp.a(true);
      if (QLog.isDevelopLevel()) {
        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler addone bdh serverIP6.size  " + localException.size());
      }
      if (((List)localObject1).size() > 0)
      {
        Iterator localIterator = ((List)localObject1).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (ExcitingTransferHostInfo)localIterator.next();
            if (localObject1 == null) {
              continue;
            }
            localObject2 = new MultiMsg.Ipv6Info();
            try
            {
              ((MultiMsg.Ipv6Info)localObject2).bytes_ip_v6_addr.set(ByteStringMicro.copyFrom(Inet6Address.getByName(((ExcitingTransferHostInfo)localObject1).mstrIp).getAddress()));
              if (QLog.isDevelopLevel()) {
                QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler ipv6:  " + ((ExcitingTransferHostInfo)localObject1).mstrIp);
              }
              ((MultiMsg.Ipv6Info)localObject2).uint32_ip_v6_port.set(((ExcitingTransferHostInfo)localObject1).mport);
              if (((ExcitingTransferHostInfo)localObject1).mIsHttps)
              {
                paramInt = 1;
                ((MultiMsg.Ipv6Info)localObject2).uint32_is_https_addr.set(paramInt);
                localMultiMsgApplyDownReq.rpt_ip_v6_info.add((MessageMicro)localObject2);
              }
            }
            catch (UnknownHostException localUnknownHostException)
            {
              for (;;)
              {
                localUnknownHostException.printStackTrace();
                continue;
                paramInt = 0;
              }
            }
          }
        }
      }
      paramReqBody.rpt_multimsg_applydown_req.add(localMultiMsgApplyDownReq);
      if ((parambecg.jdField_a_of_type_Int == 0) && (awwt.b)) {
        paramReqBody.uint32_bu_type.set(2);
      }
    }
  }
  
  private byte[] a(List<becg> paramList)
  {
    int i = bdwu.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 255;
    }
    Object localObject;
    for (;;)
    {
      localObject = bdwu.a().a();
      int j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localObject = new MultiMsg.ReqBody();
      ((MultiMsg.ReqBody)localObject).setHasFlag(true);
      ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(2);
      ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
      ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
      ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bdxz.a()));
      ((MultiMsg.ReqBody)localObject).uint32_req_channel_type.set(2);
      i = 0;
      while (i < paramList.size())
      {
        a(i, (becg)paramList.get(i), (MultiMsg.ReqBody)localObject);
        i += 1;
      }
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
    return ((MultiMsg.ReqBody)localObject).toByteArray();
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    localObject1 = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bebv localbebv = (bebv)parambdxe.jdField_a_of_type_JavaLangObject;
    beck localbeck = localbebv.jdField_a_of_type_Beck;
    anqe localanqe = parambdxf.jdField_a_of_type_Anqe;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      }
    }
    List localList;
    for (;;)
    {
      bedb.a(localbebv, localbeck);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte)).rpt_multimsg_applydown_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambdxf)
      {
        a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      }
    }
    int i = 0;
    label235:
    Object localObject2;
    if (i < localList.size()) {
      localObject2 = (MultiMsg.MultiMsgApplyDownRsp)localList.get(i);
    }
    try
    {
      localObject1 = (bect)localbeck.jdField_a_of_type_JavaUtilList.get(i);
      try
      {
        j = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).uint32_result.get();
        if (j != 0) {
          break label899;
        }
        if (((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.has()) {
          break label372;
        }
        throw new Exception("bytes_thumb_down_para NOT exists");
      }
      catch (Exception parambdxf) {}
    }
    catch (Exception parambdxf)
    {
      for (;;)
      {
        int j;
        localObject1 = null;
      }
    }
    a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanqe, (becx)localObject1);
    for (;;)
    {
      i += 1;
      break label235;
      break;
      label372:
      parambdxf = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.get();
      if (parambdxf == null) {}
      for (parambdxf = null; (parambdxf == null) || (parambdxf.equals("")); parambdxf = parambdxf.toStringUtf8()) {
        throw new Exception("urlParam == null || empty");
      }
      if (!((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_resid.has()) {
        throw new Exception("bytes_msg_resid NOT exists");
      }
      Object localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_resid.get().toByteArray();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        throw new Exception("resid_bs == null || empty");
      }
      if (!((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_key.has()) {
        throw new Exception("bytes_msg_key NOT exists");
      }
      Object localObject4 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_key.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 0)) {
        throw new Exception("ukey_bs == null || empty");
      }
      j = 0;
      if (((MultiMsg.MultiMsgApplyDownRsp)localObject2).msg_extern_info.has()) {
        j = ((MultiMsg.ExternMsg)((MultiMsg.MultiMsgApplyDownRsp)localObject2).msg_extern_info.get()).uint32_channel_type.get();
      }
      ((bect)localObject1).jdField_a_of_type_Int = j;
      ((bect)localObject1).jdField_a_of_type_JavaLangString = parambdxf;
      ((bect)localObject1).jdField_a_of_type_ArrayOfByte = ((byte[])localObject3);
      ((bect)localObject1).jdField_b_of_type_ArrayOfByte = ((byte[])localObject4);
      parambdxf = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_ip.get();
      localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_port.get();
      if ((parambdxf == null) || (parambdxf.size() == 0)) {
        throw new Exception("check iplist");
      }
      if ((parambdxf != null) && (parambdxf.size() > 0))
      {
        j = 0;
        while (j < parambdxf.size())
        {
          long l1 = ((Integer)parambdxf.get(j)).intValue();
          long l2 = ((Integer)((List)localObject3).get(j)).intValue();
          localObject4 = new bdyf();
          ((bdyf)localObject4).jdField_a_of_type_JavaLangString = bgva.a(l1 & 0xFFFFFFFF);
          ((bdyf)localObject4).jdField_a_of_type_Int = ((int)l2);
          ((bect)localObject1).jdField_a_of_type_JavaUtilArrayList.add(j, localObject4);
          j += 1;
        }
      }
      parambdxf = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_bytes_down_ip_v6.get();
      localObject2 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_v6_port.get();
      if ((parambdxf != null) && (parambdxf.size() > 0))
      {
        j = 0;
        while (j < parambdxf.size())
        {
          localObject3 = new bdyf();
          ((bdyf)localObject3).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((ByteStringMicro)parambdxf.get(j)).toByteArray()).getHostAddress();
          ((bdyf)localObject3).jdField_a_of_type_Int = ((int)((Integer)((List)localObject2).get(j)).intValue());
          ((bdyf)localObject3).jdField_a_of_type_Boolean = true;
          ((bect)localObject1).jdField_b_of_type_JavaUtilArrayList.add(j, localObject3);
          j += 1;
        }
      }
      a(0, 0, "", "", localanqe, (becx)localObject1);
      continue;
      label899:
      if (j == 196) {
        bcst.b(null, "CliOper", "", "", "0X8006627", "0X8006627", 0, 1, 0, "", "", "", "");
      }
      if (bebl.a(j))
      {
        this.b += 1;
        if (this.b < 2)
        {
          localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambdxe);
          return;
        }
      }
      a(-1, -9527, bdsx.a(j), "", localanqe, (becx)localObject1);
    }
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "MultiMsg.ApplyDown";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
    }
  }
  
  void b(bebv parambebv)
  {
    beck localbeck = parambebv.jdField_a_of_type_Beck;
    localbeck.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambebv.jdField_a_of_type_JavaUtilList.size())
    {
      bect localbect = new bect();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbect);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebo
 * JD-Core Version:    0.7.0.1
 */