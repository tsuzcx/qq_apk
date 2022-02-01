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

public class bfal
  extends bfae
{
  void a(int paramInt, bfbf parambfbf, cmd0x388.ReqBody paramReqBody)
  {
    parambfbf = (bfay)parambfbf;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(parambfbf.c).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(parambfbf.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambfbf.jdField_a_of_type_ArrayOfByte));
    if (parambfbf.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(parambfbf.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (parambfbf.f == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bews.a()));
      localGetPttUrlReq.uint32_codec.set(parambfbf.jdField_a_of_type_Int);
      if (parambfbf.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = parambfbf.jdField_a_of_type_JavaLangString.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(parambfbf.b);
        localGetPttUrlReq.uint32_req_transfer_type.set(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + parambfbf.toString());
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
  
  public void a(bevy parambevy, bevx parambevx)
  {
    FromServiceMsg localFromServiceMsg = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bfau localbfau = (bfau)parambevx.jdField_a_of_type_JavaLangObject;
    bfbj localbfbj = localbfau.jdField_a_of_type_Bfbj;
    aock localaock = parambevy.jdField_a_of_type_Aock;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        parambevx = localFromServiceMsg.getBusinessFailMsg();
        parambevy = parambevx;
        if (parambevx == null) {
          parambevy = "";
        }
        a(-1, 9311, (String)localObject1, parambevy, localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      bfca.a(localbfau, localbfbj);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      parambevx = localFromServiceMsg.getBusinessFailMsg();
      parambevy = parambevx;
      if (parambevx == null) {
        parambevy = "";
      }
      a(-1, 9044, (String)localObject1, parambevy, localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambevy = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getptt_url_rsp.get();
        if ((parambevy != null) && (parambevy.size() != 0)) {
          break label263;
        }
        throw new Exception("resps size is 0");
      }
      catch (Exception parambevy)
      {
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label263:
      Iterator localIterator = parambevy.iterator();
      while (localIterator.hasNext())
      {
        parambevy = (cmd0x388.GetPttUrlRsp)localIterator.next();
        try
        {
          localObject1 = (bfbp)localbfbj.jdField_a_of_type_JavaUtilList.get((int)parambevy.uint64_file_id.get());
          if ((localObject1 == null) || (localFromServiceMsg == null)) {}
        }
        catch (Exception parambevy)
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
          ((bfbp)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((bfbp)localObject1).d);
          }
          if (localObject1 != null)
          {
            if (parambevy.uint32_transfer_type.get() != 1) {
              break label861;
            }
            bool = true;
            ((bfbp)localObject1).jdField_a_of_type_Boolean = bool;
          }
          i = parambevy.uint32_result.get();
          if (i != 0) {
            break label765;
          }
          ((bfbp)localObject1).jdField_a_of_type_JavaLangString = parambevy.bytes_down_para.get().toStringUtf8();
          localList = parambevy.rpt_uint32_down_ip.get();
          localObject2 = parambevy.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            bewy localbewy = new bewy();
            localbewy.jdField_a_of_type_JavaLangString = bhvd.a(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localbewy.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
            ((bfbp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbewy);
            i += 1;
            break label458;
          }
          if ((parambevy.rpt_msg_down_ip6.has()) && (parambevy.rpt_msg_down_ip6.size() > 0))
          {
            localList = parambevy.rpt_msg_down_ip6.get();
            i = 0;
            while (i < localList.size())
            {
              localObject2 = new bewy();
              ((bewy)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((bewy)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((bewy)localObject2).jdField_a_of_type_Boolean = true;
              ((bfbp)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
            }
          }
          if (parambevy.rpt_str_domain.has()) {
            ((bfbp)localObject1).jdField_b_of_type_JavaLangString = parambevy.rpt_str_domain.get();
          }
          a(0, 0, "", "", localaock, (bfbw)localObject1);
        }
        catch (Exception parambevy)
        {
          a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localaock, (bfbw)localObject1);
        }
        continue;
        label765:
        if (parambevy.uint32_allow_retry.get() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.GroupPttDownHandler", 2, "onProtoResp :group ptt server not allow retry");
          }
          ((bfbp)localObject1).e = false;
        }
        if (bfak.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambevx);
            return;
          }
        }
        a(-1, -9527, berp.a(i), "", localaock, (bfbw)localObject1);
      }
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
  
  byte[] a(List<bfbf> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bfbf)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (bevn.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = bevn.a().a();
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
  
  void b(bfau parambfau)
  {
    bfbj localbfbj = parambfau.jdField_a_of_type_Bfbj;
    localbfbj.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambfau.jdField_a_of_type_JavaUtilList.size())
    {
      bfbp localbfbp = new bfbp();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, localbfbp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfal
 * JD-Core Version:    0.7.0.1
 */