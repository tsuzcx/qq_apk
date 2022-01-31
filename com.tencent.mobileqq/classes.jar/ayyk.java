import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;

public class ayyk
  extends ayxz
{
  private byte[] a(List<ayyy> paramList)
  {
    subcmd0x501.ReqBody localReqBody = new subcmd0x501.ReqBody();
    subcmd0x501.SubCmd0x501ReqBody localSubCmd0x501ReqBody = new subcmd0x501.SubCmd0x501ReqBody();
    if ((paramList != null) && (paramList.size() == 1))
    {
      paramList = (ayyv)paramList.get(0);
      localSubCmd0x501ReqBody.uint64_uin.set(Long.parseLong(paramList.jdField_a_of_type_JavaLangString));
      localSubCmd0x501ReqBody.uint32_idc_id.set(0);
      localSubCmd0x501ReqBody.uint32_appid.set(16);
      localSubCmd0x501ReqBody.uint32_login_sig_type.set(1);
      localSubCmd0x501ReqBody.uint32_request_flag.set(3);
      paramList = new ArrayList();
      paramList.add(Integer.valueOf(5));
      localSubCmd0x501ReqBody.rpt_uint32_service_types.set(paramList);
      localReqBody.msg_subcmd_0x501_req_body.set(localSubCmd0x501ReqBody);
      return localReqBody.toByteArray();
    }
    throw new RuntimeException("only support one request");
  }
  
  public void a(aytj paramaytj, ayti paramayti)
  {
    Object localObject = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    paramayti = (ayyn)paramayti.jdField_a_of_type_JavaLangObject;
    ayzc localayzc = paramayti.jdField_a_of_type_Ayzc;
    akaw localakaw = paramaytj.jdField_a_of_type_Akaw;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      int i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
      for (;;)
      {
        ayzt.a(paramayti, localayzc);
        return;
        a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      try
      {
        paramaytj = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)new subcmd0x501.RspBody().mergeFrom(arrayOfByte)).msg_subcmd_0x501_rsp_body.get()).bytes_httpconn_sig_session.get();
        if ((paramaytj == null) || (paramaytj.toByteArray().length <= 0)) {
          break label264;
        }
        paramaytj = paramaytj.toByteArray();
        localObject = (ayzn)localayzc.jdField_a_of_type_JavaUtilList.get(0);
        ((ayzn)localObject).jdField_a_of_type_ArrayOfByte = paramaytj;
        a(0, 0, "", "", localakaw, (ayzp)localObject);
      }
      catch (Exception paramaytj)
      {
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
      break;
      label264:
      paramaytj = null;
    }
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      localayti.jdField_a_of_type_JavaLangString = "HttpConn.0x6ff_501";
      localayti.jdField_a_of_type_ArrayOfByte = a(paramayyn.jdField_a_of_type_JavaUtilList);
      localayti.jdField_a_of_type_JavaLangObject = paramayyn;
      localayti.jdField_a_of_type_Ayth = this;
      a(paramayyn, localayti);
    }
  }
  
  void b(ayyn paramayyn)
  {
    ayzc localayzc = paramayyn.jdField_a_of_type_Ayzc;
    localayzc.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyn.jdField_a_of_type_JavaUtilList.size())
    {
      ayzn localayzn = new ayzn();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayzn);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyk
 * JD-Core Version:    0.7.0.1
 */