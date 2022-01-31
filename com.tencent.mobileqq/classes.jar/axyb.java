import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg.ExternMsg;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownReq;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class axyb
  extends axxs
{
  int a;
  
  private void a(int paramInt, axyr paramaxyr, MultiMsg.ReqBody paramReqBody)
  {
    paramaxyr = (axym)paramaxyr;
    MultiMsg.MultiMsgApplyDownReq localMultiMsgApplyDownReq = new MultiMsg.MultiMsgApplyDownReq();
    localMultiMsgApplyDownReq.setHasFlag(true);
    localMultiMsgApplyDownReq.bytes_msg_resid.set(ByteStringMicro.copyFrom(paramaxyr.jdField_a_of_type_ArrayOfByte));
    localMultiMsgApplyDownReq.uint32_msg_type.set(axyc.b(paramaxyr.f));
    localMultiMsgApplyDownReq.uint64_src_uin.set(Long.valueOf(paramaxyr.c).longValue());
    paramReqBody.rpt_multimsg_applydown_req.add(localMultiMsgApplyDownReq);
    if ((paramaxyr.jdField_a_of_type_Int == 0) && (aryb.b)) {
      paramReqBody.uint32_bu_type.set(2);
    }
  }
  
  private byte[] a(List<axyr> paramList)
  {
    int i = axsr.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 255;
    }
    Object localObject;
    for (;;)
    {
      localObject = axsr.a().a();
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
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(axub.a()));
      ((MultiMsg.ReqBody)localObject).uint32_req_channel_type.set(2);
      i = 0;
      while (i < paramList.size())
      {
        a(i, (axyr)paramList.get(i), (MultiMsg.ReqBody)localObject);
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
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    localObject1 = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    axyg localaxyg = (axyg)paramaxtb.jdField_a_of_type_JavaLangObject;
    axyv localaxyv = localaxyg.jdField_a_of_type_Axyv;
    ajmn localajmn = paramaxtc.jdField_a_of_type_Ajmn;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
    }
    List localList;
    for (;;)
    {
      axzm.a(localaxyg, localaxyv);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte)).rpt_multimsg_applydown_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
    }
    int i = 0;
    label231:
    Object localObject2;
    if (i < localList.size()) {
      localObject2 = (MultiMsg.MultiMsgApplyDownRsp)localList.get(i);
    }
    try
    {
      localObject1 = (axze)localaxyv.jdField_a_of_type_JavaUtilList.get(i);
      try
      {
        j = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).uint32_result.get();
        if (j != 0) {
          break label891;
        }
        if (((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.has()) {
          break label367;
        }
        throw new Exception("bytes_thumb_down_para NOT exists");
      }
      catch (Exception paramaxtc) {}
    }
    catch (Exception paramaxtc)
    {
      for (;;)
      {
        int j;
        localObject1 = null;
      }
    }
    a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, (axzi)localObject1);
    for (;;)
    {
      i += 1;
      break label231;
      break;
      label367:
      paramaxtc = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.get();
      if (paramaxtc == null) {}
      for (paramaxtc = null; (paramaxtc == null) || (paramaxtc.equals("")); paramaxtc = paramaxtc.toStringUtf8()) {
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
      ((axze)localObject1).jdField_a_of_type_Int = j;
      ((axze)localObject1).jdField_a_of_type_JavaLangString = paramaxtc;
      ((axze)localObject1).jdField_a_of_type_ArrayOfByte = ((byte[])localObject3);
      ((axze)localObject1).jdField_b_of_type_ArrayOfByte = ((byte[])localObject4);
      paramaxtc = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_ip.get();
      localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_port.get();
      if ((paramaxtc == null) || (paramaxtc.size() == 0)) {
        throw new Exception("check iplist");
      }
      if ((paramaxtc != null) && (paramaxtc.size() > 0))
      {
        j = 0;
        while (j < paramaxtc.size())
        {
          long l1 = ((Integer)paramaxtc.get(j)).intValue();
          long l2 = ((Integer)((List)localObject3).get(j)).intValue();
          localObject4 = new axuh();
          ((axuh)localObject4).jdField_a_of_type_JavaLangString = bakz.a(l1 & 0xFFFFFFFF);
          ((axuh)localObject4).jdField_a_of_type_Int = ((int)l2);
          ((axze)localObject1).jdField_a_of_type_JavaUtilArrayList.add(j, localObject4);
          j += 1;
        }
      }
      paramaxtc = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_bytes_down_ip_v6.get();
      localObject2 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_v6_port.get();
      if ((paramaxtc != null) && (paramaxtc.size() > 0))
      {
        j = 0;
        while (j < paramaxtc.size())
        {
          localObject3 = new axuh();
          ((axuh)localObject3).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((ByteStringMicro)paramaxtc.get(j)).toByteArray()).getHostAddress();
          ((axuh)localObject3).jdField_a_of_type_Int = ((int)((Integer)((List)localObject2).get(j)).intValue());
          ((axuh)localObject3).jdField_a_of_type_Boolean = true;
          ((axze)localObject1).jdField_b_of_type_JavaUtilArrayList.add(j, localObject3);
          j += 1;
        }
      }
      a(0, 0, "", "", localajmn, (axzi)localObject1);
      continue;
      label891:
      if (j == 196) {
        awqx.b(null, "CliOper", "", "", "0X8006627", "0X8006627", 0, 1, 0, "", "", "", "");
      }
      if (axxy.a(j))
      {
        this.b += 1;
        if (this.b < 2)
        {
          localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaxtb);
          return;
        }
      }
      a(-1, -9527, axou.a(j), "", localajmn, (axzi)localObject1);
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "MultiMsg.ApplyDown";
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
    }
  }
  
  void b(axyg paramaxyg)
  {
    axyv localaxyv = paramaxyg.jdField_a_of_type_Axyv;
    localaxyv.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramaxyg.jdField_a_of_type_JavaUtilList.size())
    {
      axze localaxze = new axze();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxze);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axyb
 * JD-Core Version:    0.7.0.1
 */