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

public class bbat
  extends bbaj
{
  int a;
  
  private void a(int paramInt, bbbi parambbbi, MultiMsg.ReqBody paramReqBody)
  {
    parambbbi = (bbbe)parambbbi;
    MultiMsg.MultiMsgApplyUpReq localMultiMsgApplyUpReq = new MultiMsg.MultiMsgApplyUpReq();
    localMultiMsgApplyUpReq.setHasFlag(true);
    localMultiMsgApplyUpReq.uint64_dst_uin.set(Long.valueOf(parambbbi.d).longValue());
    localMultiMsgApplyUpReq.uint64_msg_size.set(parambbbi.jdField_a_of_type_Long);
    localMultiMsgApplyUpReq.bytes_msg_md5.set(ByteStringMicro.copyFrom(parambbbi.jdField_a_of_type_ArrayOfByte));
    localMultiMsgApplyUpReq.uint32_msg_type.set(b(parambbbi.f));
    localMultiMsgApplyUpReq.uint32_apply_id.set(0);
    paramReqBody.rpt_multimsg_applyup_req.add(localMultiMsgApplyUpReq);
    if (parambbbi.jdField_a_of_type_Int == 1) {
      paramReqBody.uint32_bu_type.set(1);
    }
    if ((parambbbi.jdField_a_of_type_Int == 0) && (aupn.b)) {
      paramReqBody.uint32_bu_type.set(2);
    }
  }
  
  private byte[] a(List<bbbi> paramList)
  {
    int i = bavg.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 255;
    }
    Object localObject;
    for (;;)
    {
      localObject = bavg.a().a();
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
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(baws.a()));
      ((MultiMsg.ReqBody)localObject).uint32_bu_type.set(0);
      i = 0;
      while (i < paramList.size())
      {
        a(i, (bbbi)paramList.get(i), (MultiMsg.ReqBody)localObject);
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
  
  public void a(bavr parambavr, bavq parambavq)
  {
    localObject1 = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte1 = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bbax localbbax = (bbax)parambavq.jdField_a_of_type_JavaLangObject;
    bbbm localbbbm = localbbax.jdField_a_of_type_Bbbm;
    alwy localalwy = parambavr.jdField_a_of_type_Alwy;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
    }
    List localList;
    for (;;)
    {
      bbcd.a(localbbax, localbbbm);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte1)).rpt_multimsg_applyup_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
    }
    int i = 0;
    label231:
    if (i < localList.size()) {
      parambavr = (MultiMsg.MultiMsgApplyUpRsp)localList.get(i);
    }
    try
    {
      localObject1 = (bbbw)localbbbm.jdField_a_of_type_JavaUtilList.get(i);
      try
      {
        j = parambavr.uint32_result.get();
        if (j != 0) {
          break label778;
        }
        if (parambavr.bytes_msg_resid.has()) {
          break label364;
        }
        throw new Exception("bytes_msg_resid NOT exists");
      }
      catch (Exception parambavr) {}
    }
    catch (Exception parambavr)
    {
      for (;;)
      {
        localObject1 = null;
        continue;
        int j = 0;
      }
    }
    a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), localalwy, (bbbz)localObject1);
    for (;;)
    {
      i += 1;
      break label231;
      break;
      label364:
      Object localObject2 = parambavr.bytes_msg_resid.get().toByteArray();
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        throw new Exception("resid_bs == null || empty");
      }
      if (!parambavr.bytes_msg_ukey.has()) {
        throw new Exception("bytes_msg_ukey NOT exists");
      }
      Object localObject3 = parambavr.bytes_msg_ukey.get().toByteArray();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        throw new Exception("ukey_bs == null || empty");
      }
      if (!parambavr.bytes_msg_key.has()) {
        throw new Exception("bytes_msg_key NOT exists");
      }
      Object localObject4 = parambavr.bytes_msg_key.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 0)) {
        throw new Exception("msgkey_bs == null || empty");
      }
      if (!parambavr.bytes_msg_sig.has()) {
        throw new Exception("bytes_msg_sig NOT exists");
      }
      byte[] arrayOfByte2 = parambavr.bytes_msg_sig.get().toByteArray();
      if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
        throw new Exception("msgsig_bs == null || empty");
      }
      ((bbbw)localObject1).jdField_a_of_type_ArrayOfByte = ((byte[])localObject2);
      ((bbbw)localObject1).jdField_b_of_type_ArrayOfByte = ((byte[])localObject3);
      ((bbbw)localObject1).c = ((byte[])localObject4);
      ((bbbw)localObject1).d = arrayOfByte2;
      localObject2 = parambavr.rpt_uint32_up_ip.get();
      localObject3 = parambavr.rpt_uint32_up_port.get();
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        break label844;
      }
      throw new Exception("check iplist");
      while (j < ((List)localObject2).size())
      {
        long l1 = ((Integer)((List)localObject2).get(j)).intValue();
        long l2 = ((Integer)((List)localObject3).get(j)).intValue();
        localObject4 = new bawy();
        ((bawy)localObject4).jdField_a_of_type_JavaLangString = bdqa.a(l1 & 0xFFFFFFFF);
        ((bawy)localObject4).jdField_a_of_type_Int = ((int)l2);
        ((bbbw)localObject1).jdField_a_of_type_JavaUtilArrayList.add(j, localObject4);
        j += 1;
      }
      ((bbbw)localObject1).jdField_a_of_type_Int = ((int)parambavr.uint64_block_size.get());
      ((bbbw)localObject1).jdField_b_of_type_Int = ((int)parambavr.uint64_up_offset.get());
      a(0, 0, "", "", localalwy, (bbbz)localObject1);
      continue;
      label778:
      if (bbap.a(j))
      {
        this.jdField_b_of_type_Int += 1;
        if (this.jdField_b_of_type_Int < 2)
        {
          localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambavq);
          return;
        }
      }
      a(-1, -9527, barf.a(j), "", localalwy, (bbbz)localObject1);
    }
  }
  
  public void a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bavq localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = "MultiMsg.ApplyUp";
      localbavq.jdField_a_of_type_ArrayOfByte = a(parambbax.jdField_a_of_type_JavaUtilList);
      localbavq.jdField_a_of_type_JavaLangObject = parambbax;
      localbavq.jdField_a_of_type_Bavp = this;
      a(parambbax, localbavq);
    }
  }
  
  void b(bbax parambbax)
  {
    bbbm localbbbm = parambbax.jdField_a_of_type_Bbbm;
    localbbbm.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambbax.jdField_a_of_type_JavaUtilList.size())
    {
      bbbw localbbbw = new bbbw();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbbw);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbat
 * JD-Core Version:    0.7.0.1
 */