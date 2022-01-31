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

public class axxz
  extends axxs
{
  void a(int paramInt, axyr paramaxyr, cmd0x388.ReqBody paramReqBody)
  {
    paramaxyr = (axyk)paramaxyr;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(paramaxyr.c).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(paramaxyr.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramaxyr.jdField_a_of_type_ArrayOfByte));
    if (paramaxyr.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(paramaxyr.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (paramaxyr.f == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(axub.a()));
      localGetPttUrlReq.uint32_codec.set(paramaxyr.jdField_a_of_type_Int);
      if (paramaxyr.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = paramaxyr.jdField_a_of_type_JavaLangString.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(paramaxyr.b);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + paramaxyr.toString());
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
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    FromServiceMsg localFromServiceMsg = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    axyg localaxyg = (axyg)paramaxtb.jdField_a_of_type_JavaLangObject;
    axyv localaxyv = localaxyg.jdField_a_of_type_Axyv;
    ajmn localajmn = paramaxtc.jdField_a_of_type_Ajmn;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramaxtb = localFromServiceMsg.getBusinessFailMsg();
        paramaxtc = paramaxtb;
        if (paramaxtb == null) {
          paramaxtc = "";
        }
        a(-1, 9311, (String)localObject1, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      for (;;)
      {
        axzm.a(localaxyg, localaxyv);
        return;
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramaxtb = localFromServiceMsg.getBusinessFailMsg();
        paramaxtc = paramaxtb;
        if (paramaxtb == null) {
          paramaxtc = "";
        }
        a(-1, 9044, (String)localObject1, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getptt_url_rsp.get().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        paramaxtc = (cmd0x388.GetPttUrlRsp)localIterator.next();
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      try
      {
        localObject1 = (axzb)localaxyv.jdField_a_of_type_JavaUtilList.get((int)paramaxtc.uint64_file_id.get());
        if ((localObject1 != null) && (localFromServiceMsg != null)) {}
        try
        {
          ((axzb)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((axzb)localObject1).d);
          }
          i = paramaxtc.uint32_result.get();
          if (i != 0) {
            break label714;
          }
          ((axzb)localObject1).jdField_a_of_type_JavaLangString = paramaxtc.bytes_down_para.get().toStringUtf8();
          List localList = paramaxtc.rpt_uint32_down_ip.get();
          Object localObject2 = paramaxtc.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            axuh localaxuh = new axuh();
            localaxuh.jdField_a_of_type_JavaLangString = bakz.a(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localaxuh.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
            ((axzb)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localaxuh);
            i += 1;
            continue;
          }
          if ((paramaxtc.rpt_msg_down_ip6.has()) && (paramaxtc.rpt_msg_down_ip6.size() > 0))
          {
            localList = paramaxtc.rpt_msg_down_ip6.get();
            i = 0;
            if (i < localList.size())
            {
              localObject2 = new axuh();
              ((axuh)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((axuh)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((axuh)localObject2).jdField_a_of_type_Boolean = true;
              ((axzb)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
              continue;
            }
          }
          if (paramaxtc.rpt_str_domain.has()) {
            ((axzb)localObject1).jdField_b_of_type_JavaLangString = paramaxtc.rpt_str_domain.get();
          }
          a(0, 0, "", "", localajmn, (axzi)localObject1);
        }
        catch (Exception paramaxtc) {}
      }
      catch (Exception paramaxtc)
      {
        localObject1 = null;
        continue;
      }
      a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, (axzi)localObject1);
      continue;
      break;
      label714:
      if (paramaxtc.uint32_allow_retry.get() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp :group ptt server not allow retry");
        }
        ((axzb)localObject1).e = false;
      }
      if (axxy.a(i))
      {
        this.b += 1;
        if (this.b < 2)
        {
          localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaxtb);
          return;
        }
      }
      a(-1, -9527, axou.a(i), "", localajmn, (axzi)localObject1);
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
    }
  }
  
  byte[] a(List<axyr> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (axyr)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (axsr.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = axsr.a().a();
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
  
  void b(axyg paramaxyg)
  {
    axyv localaxyv = paramaxyg.jdField_a_of_type_Axyv;
    localaxyv.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramaxyg.jdField_a_of_type_JavaUtilList.size())
    {
      axzb localaxzb = new axzb();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxzb);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxz
 * JD-Core Version:    0.7.0.1
 */