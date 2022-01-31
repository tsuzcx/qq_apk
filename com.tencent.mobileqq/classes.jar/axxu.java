import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgRsp;

public class axxu
  extends axxs
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void a(int paramInt, axyr paramaxyr, cmd0x352.ReqBody paramReqBody)
  {
    axyp localaxyp = (axyp)paramaxyr;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(localaxyp.jdField_c_of_type_JavaLangString).longValue());
    try
    {
      String str = localaxyp.jdField_d_of_type_JavaLangString;
      paramaxyr = str;
      if (str.startsWith("+")) {
        paramaxyr = str.substring(1);
      }
      long l = Long.valueOf(paramaxyr).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception paramaxyr)
    {
      for (;;)
      {
        paramaxyr.printStackTrace();
      }
    }
    localTryUpImgReq.uint64_file_size.set(localaxyp.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(localaxyp.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(localaxyp.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(localaxyp.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    a(localTryUpImgReq);
    localTryUpImgReq.bool_pic_original.set(localaxyp.jdField_b_of_type_Boolean);
    localTryUpImgReq.uint32_pic_width.set(localaxyp.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(localaxyp.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(localaxyp.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(axub.a()));
    localTryUpImgReq.bool_reject_tryfast.set(false);
    localTryUpImgReq.uint32_srv_upload.set(localaxyp.e);
    if (!TextUtils.isEmpty(localaxyp.jdField_b_of_type_JavaLangString)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(localaxyp.jdField_b_of_type_JavaLangString));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  protected void a(axtb paramaxtb)
  {
    paramaxtb.jdField_a_of_type_JavaLangString = "LongConn.OffPicUp";
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
      paramaxtc = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramaxtc.equals("conSucc")) || (paramaxtc.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(localFromServiceMsg);
          paramaxtb = localFromServiceMsg.getBusinessFailMsg();
          paramaxtc = paramaxtb;
          if (paramaxtb == null) {
            paramaxtc = "";
          }
          a(-1, 9311, (String)localObject, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      axzm.a(localaxyg, localaxyv);
      return;
      paramaxtb = localFromServiceMsg.getBusinessFailMsg();
      paramaxtc = paramaxtb;
      if (paramaxtb == null) {
        paramaxtc = "";
      }
      a(-1, 9044, String.valueOf(i), paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, paramaxtc, localFromServiceMsg.getBusinessFailMsg(), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaxtc = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((paramaxtc != null) && (paramaxtc.size() != 0)) {
          break label314;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label314:
      Iterator localIterator = paramaxtc.iterator();
      while (localIterator.hasNext())
      {
        paramaxtc = (cmd0x352.TryUpImgRsp)localIterator.next();
        try
        {
          localObject = (axyx)localaxyv.jdField_a_of_type_JavaUtilList.get((int)paramaxtc.uint64_file_id.get());
          if (localObject == null) {
            continue;
          }
          try
          {
            if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              ((axyx)localObject).jdField_d_of_type_Boolean = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramaxtc.uint32_result.get();
            if (i != 0) {
              break label500;
            }
            a(paramaxtc, (axyx)localObject);
            a(0, 0, "", "", localajmn, (axzi)localObject);
          }
          catch (Exception paramaxtc) {}
        }
        catch (Exception paramaxtc)
        {
          for (;;)
          {
            localObject = null;
          }
        }
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, (axzi)localObject);
        continue;
        label500:
        if (a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaxtb);
            return;
          }
        }
        a(-1, -9527, axou.a(i), "", localajmn, (axzi)localObject);
      }
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      a(localaxtb);
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
    }
  }
  
  protected void a(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(1);
  }
  
  void a(cmd0x352.TryUpImgRsp paramTryUpImgRsp, axyx paramaxyx)
  {
    boolean bool = true;
    if (paramTryUpImgRsp.bytes_up_resid.has()) {
      paramaxyx.jdField_a_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_resid.get().toStringUtf8();
    }
    if (paramTryUpImgRsp.bytes_up_uuid.has()) {
      paramaxyx.jdField_b_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_uuid.get().toStringUtf8();
    }
    paramaxyx.jdField_a_of_type_Long = paramTryUpImgRsp.uint64_up_offset.get();
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, " TryUpLoad : Offset:" + paramaxyx.jdField_a_of_type_Long + " Value:" + paramTryUpImgRsp.uint64_up_offset.get());
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramaxyx.jdField_a_of_type_Boolean = true;
      if (paramTryUpImgRsp.bytes_original_down_para.has()) {
        paramaxyx.jdField_d_of_type_JavaLangString = paramTryUpImgRsp.bytes_original_down_para.get().toStringUtf8();
      }
      return;
    }
    paramaxyx.jdField_c_of_type_JavaLangString = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
    paramaxyx.jdField_a_of_type_Int = ((int)paramTryUpImgRsp.uint64_block_size.get());
    if (axsr.a().a() != this.jdField_a_of_type_Int) {}
    for (;;)
    {
      paramaxyx.jdField_b_of_type_Boolean = bool;
      break;
      bool = false;
    }
  }
  
  byte[] a(List<axyr> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (axyr)paramList.get(i), localReqBody);
      i += 1;
    }
    i = axsr.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
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
      axyx localaxyx = new axyx();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxyx);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxu
 * JD-Core Version:    0.7.0.1
 */