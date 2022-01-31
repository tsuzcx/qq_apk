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

public class ayyd
  extends ayyb
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void a(int paramInt, ayza paramayza, cmd0x352.ReqBody paramReqBody)
  {
    ayyy localayyy = (ayyy)paramayza;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(localayyy.jdField_c_of_type_JavaLangString).longValue());
    try
    {
      String str = localayyy.jdField_d_of_type_JavaLangString;
      paramayza = str;
      if (str.startsWith("+")) {
        paramayza = str.substring(1);
      }
      long l = Long.valueOf(paramayza).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception paramayza)
    {
      for (;;)
      {
        paramayza.printStackTrace();
      }
    }
    localTryUpImgReq.uint64_file_size.set(localayyy.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(localayyy.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(localayyy.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(localayyy.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    a(localTryUpImgReq);
    localTryUpImgReq.bool_pic_original.set(localayyy.jdField_b_of_type_Boolean);
    localTryUpImgReq.uint32_pic_width.set(localayyy.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(localayyy.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(localayyy.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayuk.a()));
    localTryUpImgReq.bool_reject_tryfast.set(false);
    localTryUpImgReq.uint32_srv_upload.set(localayyy.e);
    if (!TextUtils.isEmpty(localayyy.jdField_b_of_type_JavaLangString)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(localayyy.jdField_b_of_type_JavaLangString));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  protected void a(aytk paramaytk)
  {
    paramaytk.jdField_a_of_type_JavaLangString = "LongConn.OffPicUp";
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
      paramaytl = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramaytl.equals("conSucc")) || (paramaytl.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(localFromServiceMsg);
          paramaytk = localFromServiceMsg.getBusinessFailMsg();
          paramaytl = paramaytk;
          if (paramaytk == null) {
            paramaytl = "";
          }
          a(-1, 9311, (String)localObject, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      ayzv.a(localayyp, localayze);
      return;
      paramaytk = localFromServiceMsg.getBusinessFailMsg();
      paramaytl = paramaytk;
      if (paramaytk == null) {
        paramaytl = "";
      }
      a(-1, 9044, String.valueOf(i), paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, paramaytl, localFromServiceMsg.getBusinessFailMsg(), localakau, localayze.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaytl = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((paramaytl != null) && (paramaytl.size() != 0)) {
          break label314;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label314:
      Iterator localIterator = paramaytl.iterator();
      while (localIterator.hasNext())
      {
        paramaytl = (cmd0x352.TryUpImgRsp)localIterator.next();
        try
        {
          localObject = (ayzg)localayze.jdField_a_of_type_JavaUtilList.get((int)paramaytl.uint64_file_id.get());
          if (localObject == null) {
            continue;
          }
          try
          {
            if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              ((ayzg)localObject).jdField_d_of_type_Boolean = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramaytl.uint32_result.get();
            if (i != 0) {
              break label500;
            }
            a(paramaytl, (ayzg)localObject);
            a(0, 0, "", "", localakau, (ayzr)localObject);
          }
          catch (Exception paramaytl) {}
        }
        catch (Exception paramaytl)
        {
          for (;;)
          {
            localObject = null;
          }
        }
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, (ayzr)localObject);
        continue;
        label500:
        if (a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaytk);
            return;
          }
        }
        a(-1, -9527, aypb.a(i), "", localakau, (ayzr)localObject);
      }
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      a(localaytk);
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
    }
  }
  
  protected void a(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(1);
  }
  
  void a(cmd0x352.TryUpImgRsp paramTryUpImgRsp, ayzg paramayzg)
  {
    boolean bool = true;
    if (paramTryUpImgRsp.bytes_up_resid.has()) {
      paramayzg.jdField_a_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_resid.get().toStringUtf8();
    }
    if (paramTryUpImgRsp.bytes_up_uuid.has()) {
      paramayzg.jdField_b_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_uuid.get().toStringUtf8();
    }
    paramayzg.jdField_a_of_type_Long = paramTryUpImgRsp.uint64_up_offset.get();
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, " TryUpLoad : Offset:" + paramayzg.jdField_a_of_type_Long + " Value:" + paramTryUpImgRsp.uint64_up_offset.get());
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramayzg.jdField_a_of_type_Boolean = true;
      if (paramTryUpImgRsp.bytes_original_down_para.has()) {
        paramayzg.jdField_d_of_type_JavaLangString = paramTryUpImgRsp.bytes_original_down_para.get().toStringUtf8();
      }
      return;
    }
    paramayzg.jdField_c_of_type_JavaLangString = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
    paramayzg.jdField_a_of_type_Int = ((int)paramTryUpImgRsp.uint64_block_size.get());
    if (ayta.a().a() != this.jdField_a_of_type_Int) {}
    for (;;)
    {
      paramayzg.jdField_b_of_type_Boolean = bool;
      break;
      bool = false;
    }
  }
  
  byte[] a(List<ayza> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (ayza)paramList.get(i), localReqBody);
      i += 1;
    }
    i = ayta.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
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
      ayzg localayzg = new ayzg();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzg);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyd
 * JD-Core Version:    0.7.0.1
 */