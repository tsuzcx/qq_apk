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
import java.util.ArrayList;
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpReq;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class bawk
  extends bawa
{
  int a;
  
  private void a(int paramInt, bawz parambawz, MultiMsg.ReqBody paramReqBody)
  {
    parambawz = (bawv)parambawz;
    MultiMsg.MultiMsgApplyUpReq localMultiMsgApplyUpReq = new MultiMsg.MultiMsgApplyUpReq();
    localMultiMsgApplyUpReq.setHasFlag(true);
    localMultiMsgApplyUpReq.uint64_dst_uin.set(Long.valueOf(parambawz.d).longValue());
    localMultiMsgApplyUpReq.uint64_msg_size.set(parambawz.jdField_a_of_type_Long);
    localMultiMsgApplyUpReq.bytes_msg_md5.set(ByteStringMicro.copyFrom(parambawz.jdField_a_of_type_ArrayOfByte));
    localMultiMsgApplyUpReq.uint32_msg_type.set(b(parambawz.f));
    localMultiMsgApplyUpReq.uint32_apply_id.set(0);
    paramReqBody.rpt_multimsg_applyup_req.add(localMultiMsgApplyUpReq);
    if (parambawz.jdField_a_of_type_Int == 1) {
      paramReqBody.uint32_bu_type.set(1);
    }
    if ((parambawz.jdField_a_of_type_Int == 0) && (aule.b)) {
      paramReqBody.uint32_bu_type.set(2);
    }
  }
  
  private byte[] a(List<bawz> paramList)
  {
    int i = baqx.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 255;
    }
    Object localObject;
    for (;;)
    {
      localObject = baqx.a().a();
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
      ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(1);
      ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
      ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
      ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(basj.a()));
      ((MultiMsg.ReqBody)localObject).uint32_bu_type.set(0);
      i = 0;
      while (i < paramList.size())
      {
        a(i, (bawz)paramList.get(i), (MultiMsg.ReqBody)localObject);
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
  
  public static int b(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      i = 1;
    case 1: 
    case 3000: 
      return i;
    case 1040: 
      return 15;
    }
    return 255;
  }
  
  public void a(bari parambari, barh parambarh)
  {
    localObject1 = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte1 = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bawo localbawo = (bawo)parambarh.jdField_a_of_type_JavaLangObject;
    baxd localbaxd = localbawo.jdField_a_of_type_Baxd;
    alsj localalsj = parambari.jdField_a_of_type_Alsj;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
    }
    List localList;
    for (;;)
    {
      baxu.a(localbawo, localbaxd);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte1)).rpt_multimsg_applyup_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
    }
    int i = 0;
    label231:
    if (i < localList.size()) {
      parambari = (MultiMsg.MultiMsgApplyUpRsp)localList.get(i);
    }
    try
    {
      localObject1 = (baxn)localbaxd.jdField_a_of_type_JavaUtilList.get(i);
      try
      {
        j = parambari.uint32_result.get();
        if (j != 0) {
          break label778;
        }
        if (parambari.bytes_msg_resid.has()) {
          break label364;
        }
        throw new Exception("bytes_msg_resid NOT exists");
      }
      catch (Exception parambari) {}
    }
    catch (Exception parambari)
    {
      for (;;)
      {
        localObject1 = null;
        continue;
        int j = 0;
      }
    }
    a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), localalsj, (baxq)localObject1);
    for (;;)
    {
      i += 1;
      break label231;
      break;
      label364:
      Object localObject2 = parambari.bytes_msg_resid.get().toByteArray();
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        throw new Exception("resid_bs == null || empty");
      }
      if (!parambari.bytes_msg_ukey.has()) {
        throw new Exception("bytes_msg_ukey NOT exists");
      }
      Object localObject3 = parambari.bytes_msg_ukey.get().toByteArray();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        throw new Exception("ukey_bs == null || empty");
      }
      if (!parambari.bytes_msg_key.has()) {
        throw new Exception("bytes_msg_key NOT exists");
      }
      Object localObject4 = parambari.bytes_msg_key.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 0)) {
        throw new Exception("msgkey_bs == null || empty");
      }
      if (!parambari.bytes_msg_sig.has()) {
        throw new Exception("bytes_msg_sig NOT exists");
      }
      byte[] arrayOfByte2 = parambari.bytes_msg_sig.get().toByteArray();
      if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
        throw new Exception("msgsig_bs == null || empty");
      }
      ((baxn)localObject1).jdField_a_of_type_ArrayOfByte = ((byte[])localObject2);
      ((baxn)localObject1).jdField_b_of_type_ArrayOfByte = ((byte[])localObject3);
      ((baxn)localObject1).c = ((byte[])localObject4);
      ((baxn)localObject1).d = arrayOfByte2;
      localObject2 = parambari.rpt_uint32_up_ip.get();
      localObject3 = parambari.rpt_uint32_up_port.get();
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        break label844;
      }
      throw new Exception("check iplist");
      while (j < ((List)localObject2).size())
      {
        long l1 = ((Integer)((List)localObject2).get(j)).intValue();
        long l2 = ((Integer)((List)localObject3).get(j)).intValue();
        localObject4 = new basp();
        ((basp)localObject4).jdField_a_of_type_JavaLangString = bdlr.a(l1 & 0xFFFFFFFF);
        ((basp)localObject4).jdField_a_of_type_Int = ((int)l2);
        ((baxn)localObject1).jdField_a_of_type_JavaUtilArrayList.add(j, localObject4);
        j += 1;
      }
      ((baxn)localObject1).jdField_a_of_type_Int = ((int)parambari.uint64_block_size.get());
      ((baxn)localObject1).jdField_b_of_type_Int = ((int)parambari.uint64_up_offset.get());
      a(0, 0, "", "", localalsj, (baxq)localObject1);
      continue;
      label778:
      if (bawg.a(j))
      {
        this.jdField_b_of_type_Int += 1;
        if (this.jdField_b_of_type_Int < 2)
        {
          localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambarh);
          return;
        }
      }
      a(-1, -9527, bamw.a(j), "", localalsj, (baxq)localObject1);
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      localbarh.jdField_a_of_type_JavaLangString = "MultiMsg.ApplyUp";
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
    }
  }
  
  void b(bawo parambawo)
  {
    baxd localbaxd = parambawo.jdField_a_of_type_Baxd;
    localbaxd.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambawo.jdField_a_of_type_JavaUtilList.size())
    {
      baxn localbaxn = new baxn();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, localbaxn);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawk
 * JD-Core Version:    0.7.0.1
 */