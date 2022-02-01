import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class bebm
  extends bebf
{
  void a(int paramInt, becg parambecg, cmd0x388.ReqBody paramReqBody)
  {
    parambecg = (bebz)parambecg;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(parambecg.c).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(parambecg.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambecg.jdField_a_of_type_ArrayOfByte));
    if (parambecg.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(parambecg.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (parambecg.f == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bdxz.a()));
      localGetPttUrlReq.uint32_codec.set(parambecg.jdField_a_of_type_Int);
      if (parambecg.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = parambecg.jdField_a_of_type_JavaLangString.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(parambecg.b);
        localGetPttUrlReq.uint32_req_transfer_type.set(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + parambecg.toString());
        }
        paramReqBody.rpt_msg_getptt_url_req.add(localGetPttUrlReq);
        return;
        paramInt = 4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label207;
      }
    }
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    FromServiceMsg localFromServiceMsg = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bebv localbebv = (bebv)parambdxe.jdField_a_of_type_JavaLangObject;
    beck localbeck = localbebv.jdField_a_of_type_Beck;
    anqe localanqe = parambdxf.jdField_a_of_type_Anqe;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        parambdxe = localFromServiceMsg.getBusinessFailMsg();
        parambdxf = parambdxe;
        if (parambdxe == null) {
          parambdxf = "";
        }
        a(-1, 9311, (String)localObject1, parambdxf, localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      bedb.a(localbebv, localbeck);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      parambdxe = localFromServiceMsg.getBusinessFailMsg();
      parambdxf = parambdxe;
      if (parambdxe == null) {
        parambdxf = "";
      }
      a(-1, 9044, (String)localObject1, parambdxf, localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambdxf = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getptt_url_rsp.get();
        if ((parambdxf != null) && (parambdxf.size() != 0)) {
          break label263;
        }
        throw new Exception("resps size is 0");
      }
      catch (Exception parambdxf)
      {
        a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label263:
      Iterator localIterator = parambdxf.iterator();
      while (localIterator.hasNext())
      {
        parambdxf = (cmd0x388.GetPttUrlRsp)localIterator.next();
        try
        {
          localObject1 = (becq)localbeck.jdField_a_of_type_JavaUtilList.get((int)parambdxf.uint64_file_id.get());
          if ((localObject1 == null) || (localFromServiceMsg == null)) {}
        }
        catch (Exception parambdxf)
        {
          for (;;)
          {
            List localList;
            Object localObject2;
            label458:
            localObject1 = null;
            continue;
            boolean bool = false;
          }
        }
        try
        {
          ((becq)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((becq)localObject1).d);
          }
          if (localObject1 != null)
          {
            if (parambdxf.uint32_transfer_type.get() != 1) {
              break label862;
            }
            bool = true;
            ((becq)localObject1).jdField_a_of_type_Boolean = bool;
          }
          i = parambdxf.uint32_result.get();
          if (i != 0) {
            break label765;
          }
          ((becq)localObject1).jdField_a_of_type_JavaLangString = parambdxf.bytes_down_para.get().toStringUtf8();
          localList = parambdxf.rpt_uint32_down_ip.get();
          localObject2 = parambdxf.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            bdyf localbdyf = new bdyf();
            localbdyf.jdField_a_of_type_JavaLangString = bgva.a(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localbdyf.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
            ((becq)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbdyf);
            i += 1;
            break label458;
          }
          if ((parambdxf.rpt_msg_down_ip6.has()) && (parambdxf.rpt_msg_down_ip6.size() > 0))
          {
            localList = parambdxf.rpt_msg_down_ip6.get();
            i = 0;
            while (i < localList.size())
            {
              localObject2 = new bdyf();
              ((bdyf)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((bdyf)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((bdyf)localObject2).jdField_a_of_type_Boolean = true;
              ((becq)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
            }
          }
          if (parambdxf.rpt_str_domain.has()) {
            ((becq)localObject1).jdField_b_of_type_JavaLangString = parambdxf.rpt_str_domain.get();
          }
          a(0, 0, "", "", localanqe, (becx)localObject1);
        }
        catch (Exception parambdxf)
        {
          a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanqe, (becx)localObject1);
        }
        continue;
        label765:
        if (parambdxf.uint32_allow_retry.get() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp :group ptt server not allow retry");
          }
          ((becq)localObject1).e = false;
        }
        if (bebl.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambdxe);
            return;
          }
        }
        a(-1, -9527, bdsx.a(i), "", localanqe, (becx)localObject1);
      }
    }
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
    }
  }
  
  byte[] a(List<becg> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (becg)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (bdwu.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = bdwu.a().a();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  void b(bebv parambebv)
  {
    beck localbeck = parambebv.jdField_a_of_type_Beck;
    localbeck.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambebv.jdField_a_of_type_JavaUtilList.size())
    {
      becq localbecq = new becq();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbecq);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebm
 * JD-Core Version:    0.7.0.1
 */