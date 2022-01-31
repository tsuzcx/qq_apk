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

public class ayyb
  extends ayxz
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void a(int paramInt, ayyy paramayyy, cmd0x352.ReqBody paramReqBody)
  {
    ayyw localayyw = (ayyw)paramayyy;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(localayyw.jdField_c_of_type_JavaLangString).longValue());
    try
    {
      String str = localayyw.jdField_d_of_type_JavaLangString;
      paramayyy = str;
      if (str.startsWith("+")) {
        paramayyy = str.substring(1);
      }
      long l = Long.valueOf(paramayyy).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception paramayyy)
    {
      for (;;)
      {
        paramayyy.printStackTrace();
      }
    }
    localTryUpImgReq.uint64_file_size.set(localayyw.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(localayyw.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(localayyw.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(localayyw.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    a(localTryUpImgReq);
    localTryUpImgReq.bool_pic_original.set(localayyw.jdField_b_of_type_Boolean);
    localTryUpImgReq.uint32_pic_width.set(localayyw.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(localayyw.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(localayyw.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayui.a()));
    localTryUpImgReq.bool_reject_tryfast.set(false);
    localTryUpImgReq.uint32_srv_upload.set(localayyw.e);
    if (!TextUtils.isEmpty(localayyw.jdField_b_of_type_JavaLangString)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(localayyw.jdField_b_of_type_JavaLangString));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  protected void a(ayti paramayti)
  {
    paramayti.jdField_a_of_type_JavaLangString = "LongConn.OffPicUp";
  }
  
  public void a(aytj paramaytj, ayti paramayti)
  {
    FromServiceMsg localFromServiceMsg = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyn localayyn = (ayyn)paramayti.jdField_a_of_type_JavaLangObject;
    ayzc localayzc = localayyn.jdField_a_of_type_Ayzc;
    akaw localakaw = paramaytj.jdField_a_of_type_Akaw;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramaytj = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramaytj.equals("conSucc")) || (paramaytj.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(localFromServiceMsg);
          paramayti = localFromServiceMsg.getBusinessFailMsg();
          paramaytj = paramayti;
          if (paramayti == null) {
            paramaytj = "";
          }
          a(-1, 9311, (String)localObject, paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      ayzt.a(localayyn, localayzc);
      return;
      paramayti = localFromServiceMsg.getBusinessFailMsg();
      paramaytj = paramayti;
      if (paramayti == null) {
        paramaytj = "";
      }
      a(-1, 9044, String.valueOf(i), paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, paramaytj, localFromServiceMsg.getBusinessFailMsg(), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaytj = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((paramaytj != null) && (paramaytj.size() != 0)) {
          break label314;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaytj)
      {
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label314:
      Iterator localIterator = paramaytj.iterator();
      while (localIterator.hasNext())
      {
        paramaytj = (cmd0x352.TryUpImgRsp)localIterator.next();
        try
        {
          localObject = (ayze)localayzc.jdField_a_of_type_JavaUtilList.get((int)paramaytj.uint64_file_id.get());
          if (localObject == null) {
            continue;
          }
          try
          {
            if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              ((ayze)localObject).jdField_d_of_type_Boolean = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramaytj.uint32_result.get();
            if (i != 0) {
              break label500;
            }
            a(paramaytj, (ayze)localObject);
            a(0, 0, "", "", localakaw, (ayzp)localObject);
          }
          catch (Exception paramaytj) {}
        }
        catch (Exception paramaytj)
        {
          for (;;)
          {
            localObject = null;
          }
        }
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, (ayzp)localObject);
        continue;
        label500:
        if (a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramayti);
            return;
          }
        }
        a(-1, -9527, ayoz.a(i), "", localakaw, (ayzp)localObject);
      }
    }
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      a(localayti);
      localayti.jdField_a_of_type_ArrayOfByte = a(paramayyn.jdField_a_of_type_JavaUtilList);
      localayti.jdField_a_of_type_JavaLangObject = paramayyn;
      localayti.jdField_a_of_type_Ayth = this;
      a(paramayyn, localayti);
    }
  }
  
  protected void a(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(1);
  }
  
  void a(cmd0x352.TryUpImgRsp paramTryUpImgRsp, ayze paramayze)
  {
    boolean bool = true;
    if (paramTryUpImgRsp.bytes_up_resid.has()) {
      paramayze.jdField_a_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_resid.get().toStringUtf8();
    }
    if (paramTryUpImgRsp.bytes_up_uuid.has()) {
      paramayze.jdField_b_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_uuid.get().toStringUtf8();
    }
    paramayze.jdField_a_of_type_Long = paramTryUpImgRsp.uint64_up_offset.get();
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, " TryUpLoad : Offset:" + paramayze.jdField_a_of_type_Long + " Value:" + paramTryUpImgRsp.uint64_up_offset.get());
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramayze.jdField_a_of_type_Boolean = true;
      if (paramTryUpImgRsp.bytes_original_down_para.has()) {
        paramayze.jdField_d_of_type_JavaLangString = paramTryUpImgRsp.bytes_original_down_para.get().toStringUtf8();
      }
      return;
    }
    paramayze.jdField_c_of_type_JavaLangString = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
    paramayze.jdField_a_of_type_Int = ((int)paramTryUpImgRsp.uint64_block_size.get());
    if (aysy.a().a() != this.jdField_a_of_type_Int) {}
    for (;;)
    {
      paramayze.jdField_b_of_type_Boolean = bool;
      break;
      bool = false;
    }
  }
  
  byte[] a(List<ayyy> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (ayyy)paramList.get(i), localReqBody);
      i += 1;
    }
    i = aysy.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = aysy.a().a();
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
  
  void b(ayyn paramayyn)
  {
    ayzc localayzc = paramayyn.jdField_a_of_type_Ayzc;
    localayzc.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyn.jdField_a_of_type_JavaUtilList.size())
    {
      ayze localayze = new ayze();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayze);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyb
 * JD-Core Version:    0.7.0.1
 */