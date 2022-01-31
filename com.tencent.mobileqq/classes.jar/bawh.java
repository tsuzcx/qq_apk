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

public class bawh
  extends bawa
{
  void a(int paramInt, bawz parambawz, cmd0x388.ReqBody paramReqBody)
  {
    parambawz = (baws)parambawz;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(parambawz.c).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(parambawz.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambawz.jdField_a_of_type_ArrayOfByte));
    if (parambawz.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(parambawz.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (parambawz.f == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(basj.a()));
      localGetPttUrlReq.uint32_codec.set(parambawz.jdField_a_of_type_Int);
      if (parambawz.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = parambawz.jdField_a_of_type_JavaLangString.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(parambawz.b);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + parambawz.toString());
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
  
  public void a(bari parambari, barh parambarh)
  {
    FromServiceMsg localFromServiceMsg = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bawo localbawo = (bawo)parambarh.jdField_a_of_type_JavaLangObject;
    baxd localbaxd = localbawo.jdField_a_of_type_Baxd;
    alsj localalsj = parambari.jdField_a_of_type_Alsj;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        parambarh = localFromServiceMsg.getBusinessFailMsg();
        parambari = parambarh;
        if (parambarh == null) {
          parambari = "";
        }
        a(-1, 9311, (String)localObject1, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
      for (;;)
      {
        baxu.a(localbawo, localbaxd);
        return;
        localObject1 = MessageHandler.a(localFromServiceMsg);
        parambarh = localFromServiceMsg.getBusinessFailMsg();
        parambari = parambarh;
        if (parambarh == null) {
          parambari = "";
        }
        a(-1, 9044, (String)localObject1, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
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
        parambari = (cmd0x388.GetPttUrlRsp)localIterator.next();
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
      try
      {
        localObject1 = (baxj)localbaxd.jdField_a_of_type_JavaUtilList.get((int)parambari.uint64_file_id.get());
        if ((localObject1 != null) && (localFromServiceMsg != null)) {}
        try
        {
          ((baxj)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((baxj)localObject1).d);
          }
          i = parambari.uint32_result.get();
          if (i != 0) {
            break label714;
          }
          ((baxj)localObject1).jdField_a_of_type_JavaLangString = parambari.bytes_down_para.get().toStringUtf8();
          List localList = parambari.rpt_uint32_down_ip.get();
          Object localObject2 = parambari.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            basp localbasp = new basp();
            localbasp.jdField_a_of_type_JavaLangString = bdlr.a(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localbasp.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
            ((baxj)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbasp);
            i += 1;
            continue;
          }
          if ((parambari.rpt_msg_down_ip6.has()) && (parambari.rpt_msg_down_ip6.size() > 0))
          {
            localList = parambari.rpt_msg_down_ip6.get();
            i = 0;
            if (i < localList.size())
            {
              localObject2 = new basp();
              ((basp)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((basp)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((basp)localObject2).jdField_a_of_type_Boolean = true;
              ((baxj)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
              continue;
            }
          }
          if (parambari.rpt_str_domain.has()) {
            ((baxj)localObject1).jdField_b_of_type_JavaLangString = parambari.rpt_str_domain.get();
          }
          a(0, 0, "", "", localalsj, (baxq)localObject1);
        }
        catch (Exception parambari) {}
      }
      catch (Exception parambari)
      {
        localObject1 = null;
        continue;
      }
      a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, (baxq)localObject1);
      continue;
      break;
      label714:
      if (parambari.uint32_allow_retry.get() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp :group ptt server not allow retry");
        }
        ((baxj)localObject1).e = false;
      }
      if (bawg.a(i))
      {
        this.b += 1;
        if (this.b < 2)
        {
          localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambarh);
          return;
        }
      }
      a(-1, -9527, bamw.a(i), "", localalsj, (baxq)localObject1);
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      localbarh.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
    }
  }
  
  byte[] a(List<bawz> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bawz)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (baqx.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = baqx.a().a();
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
  
  void b(bawo parambawo)
  {
    baxd localbaxd = parambawo.jdField_a_of_type_Baxd;
    localbaxd.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambawo.jdField_a_of_type_JavaUtilList.size())
    {
      baxj localbaxj = new baxj();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, localbaxj);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawh
 * JD-Core Version:    0.7.0.1
 */