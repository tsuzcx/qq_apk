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

public class bfap
  extends bfae
{
  private byte[] a(List<bfbf> paramList)
  {
    subcmd0x501.ReqBody localReqBody = new subcmd0x501.ReqBody();
    subcmd0x501.SubCmd0x501ReqBody localSubCmd0x501ReqBody = new subcmd0x501.SubCmd0x501ReqBody();
    if ((paramList != null) && (paramList.size() == 1))
    {
      paramList = (bfbc)paramList.get(0);
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
  
  public void a(bevy parambevy, bevx parambevx)
  {
    Object localObject = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    parambevx = (bfau)parambevx.jdField_a_of_type_JavaLangObject;
    bfbj localbfbj = parambevx.jdField_a_of_type_Bfbj;
    aock localaock = parambevy.jdField_a_of_type_Aock;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      int i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
      for (;;)
      {
        bfca.a(parambevx, localbfbj);
        return;
        a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      try
      {
        parambevy = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)new subcmd0x501.RspBody().mergeFrom(arrayOfByte)).msg_subcmd_0x501_rsp_body.get()).bytes_httpconn_sig_session.get();
        if ((parambevy == null) || (parambevy.toByteArray().length <= 0)) {
          break label264;
        }
        parambevy = parambevy.toByteArray();
        localObject = (bfbu)localbfbj.jdField_a_of_type_JavaUtilList.get(0);
        ((bfbu)localObject).jdField_a_of_type_ArrayOfByte = parambevy;
        a(0, 0, "", "", localaock, (bfbw)localObject);
      }
      catch (Exception parambevy)
      {
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
      break;
      label264:
      parambevy = null;
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = "HttpConn.0x6ff_501";
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
  
  void b(bfau parambfau)
  {
    bfbj localbfbj = parambfau.jdField_a_of_type_Bfbj;
    localbfbj.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambfau.jdField_a_of_type_JavaUtilList.size())
    {
      bfbu localbfbu = new bfbu();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, localbfbu);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfap
 * JD-Core Version:    0.7.0.1
 */