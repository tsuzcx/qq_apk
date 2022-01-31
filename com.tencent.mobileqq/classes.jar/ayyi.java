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

public class ayyi
  extends ayyb
{
  void a(int paramInt, ayza paramayza, cmd0x388.ReqBody paramReqBody)
  {
    paramayza = (ayyt)paramayza;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(paramayza.c).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(paramayza.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayza.jdField_a_of_type_ArrayOfByte));
    if (paramayza.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(paramayza.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (paramayza.f == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayuk.a()));
      localGetPttUrlReq.uint32_codec.set(paramayza.jdField_a_of_type_Int);
      if (paramayza.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = paramayza.jdField_a_of_type_JavaLangString.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(paramayza.b);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + paramayza.toString());
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
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    FromServiceMsg localFromServiceMsg = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyp localayyp = (ayyp)paramaytk.jdField_a_of_type_JavaLangObject;
    ayze localayze = localayyp.jdField_a_of_type_Ayze;
    akau localakau = paramaytl.jdField_a_of_type_Akau;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramaytk = localFromServiceMsg.getBusinessFailMsg();
        paramaytl = paramaytk;
        if (paramaytk == null) {
          paramaytl = "";
        }
        a(-1, 9311, (String)localObject1, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      for (;;)
      {
        ayzv.a(localayyp, localayze);
        return;
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramaytk = localFromServiceMsg.getBusinessFailMsg();
        paramaytl = paramaytk;
        if (paramaytk == null) {
          paramaytl = "";
        }
        a(-1, 9044, (String)localObject1, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
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
        paramaytl = (cmd0x388.GetPttUrlRsp)localIterator.next();
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      try
      {
        localObject1 = (ayzk)localayze.jdField_a_of_type_JavaUtilList.get((int)paramaytl.uint64_file_id.get());
        if ((localObject1 != null) && (localFromServiceMsg != null)) {}
        try
        {
          ((ayzk)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((ayzk)localObject1).d);
          }
          i = paramaytl.uint32_result.get();
          if (i != 0) {
            break label714;
          }
          ((ayzk)localObject1).jdField_a_of_type_JavaLangString = paramaytl.bytes_down_para.get().toStringUtf8();
          List localList = paramaytl.rpt_uint32_down_ip.get();
          Object localObject2 = paramaytl.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            ayuq localayuq = new ayuq();
            localayuq.jdField_a_of_type_JavaLangString = bbmx.a(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localayuq.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
            ((ayzk)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localayuq);
            i += 1;
            continue;
          }
          if ((paramaytl.rpt_msg_down_ip6.has()) && (paramaytl.rpt_msg_down_ip6.size() > 0))
          {
            localList = paramaytl.rpt_msg_down_ip6.get();
            i = 0;
            if (i < localList.size())
            {
              localObject2 = new ayuq();
              ((ayuq)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((ayuq)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((ayuq)localObject2).jdField_a_of_type_Boolean = true;
              ((ayzk)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
              continue;
            }
          }
          if (paramaytl.rpt_str_domain.has()) {
            ((ayzk)localObject1).jdField_b_of_type_JavaLangString = paramaytl.rpt_str_domain.get();
          }
          a(0, 0, "", "", localakau, (ayzr)localObject1);
        }
        catch (Exception paramaytl) {}
      }
      catch (Exception paramaytl)
      {
        localObject1 = null;
        continue;
      }
      a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, (ayzr)localObject1);
      continue;
      break;
      label714:
      if (paramaytl.uint32_allow_retry.get() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp :group ptt server not allow retry");
        }
        ((ayzk)localObject1).e = false;
      }
      if (ayyh.a(i))
      {
        this.b += 1;
        if (this.b < 2)
        {
          localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaytk);
          return;
        }
      }
      a(-1, -9527, aypb.a(i), "", localakau, (ayzr)localObject1);
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      localaytk.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
    }
  }
  
  byte[] a(List<ayza> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (ayza)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (ayta.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = ayta.a().a();
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
  
  void b(ayyp paramayyp)
  {
    ayze localayze = paramayyp.jdField_a_of_type_Ayze;
    localayze.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyp.jdField_a_of_type_JavaUtilList.size())
    {
      ayzk localayzk = new ayzk();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzk);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyi
 * JD-Core Version:    0.7.0.1
 */