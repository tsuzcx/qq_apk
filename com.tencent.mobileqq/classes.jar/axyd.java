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

public class axyd
  extends axxs
{
  private byte[] a(List<axyr> paramList)
  {
    subcmd0x501.ReqBody localReqBody = new subcmd0x501.ReqBody();
    subcmd0x501.SubCmd0x501ReqBody localSubCmd0x501ReqBody = new subcmd0x501.SubCmd0x501ReqBody();
    if ((paramList != null) && (paramList.size() == 1))
    {
      paramList = (axyo)paramList.get(0);
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
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    Object localObject = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    paramaxtb = (axyg)paramaxtb.jdField_a_of_type_JavaLangObject;
    axyv localaxyv = paramaxtb.jdField_a_of_type_Axyv;
    ajmn localajmn = paramaxtc.jdField_a_of_type_Ajmn;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      int i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      for (;;)
      {
        axzm.a(paramaxtb, localaxyv);
        return;
        a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      try
      {
        paramaxtc = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)new subcmd0x501.RspBody().mergeFrom(arrayOfByte)).msg_subcmd_0x501_rsp_body.get()).bytes_httpconn_sig_session.get();
        if ((paramaxtc == null) || (paramaxtc.toByteArray().length <= 0)) {
          break label264;
        }
        paramaxtc = paramaxtc.toByteArray();
        localObject = (axzg)localaxyv.jdField_a_of_type_JavaUtilList.get(0);
        ((axzg)localObject).jdField_a_of_type_ArrayOfByte = paramaxtc;
        a(0, 0, "", "", localajmn, (axzi)localObject);
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      break;
      label264:
      paramaxtc = null;
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "HttpConn.0x6ff_501";
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
      axzg localaxzg = new axzg();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxzg);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axyd
 * JD-Core Version:    0.7.0.1
 */