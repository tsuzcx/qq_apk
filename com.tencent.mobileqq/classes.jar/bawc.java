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

public class bawc
  extends bawa
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void a(int paramInt, bawz parambawz, cmd0x352.ReqBody paramReqBody)
  {
    bawx localbawx = (bawx)parambawz;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(localbawx.jdField_c_of_type_JavaLangString).longValue());
    try
    {
      String str = localbawx.jdField_d_of_type_JavaLangString;
      parambawz = str;
      if (str.startsWith("+")) {
        parambawz = str.substring(1);
      }
      long l = Long.valueOf(parambawz).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception parambawz)
    {
      for (;;)
      {
        parambawz.printStackTrace();
      }
    }
    localTryUpImgReq.uint64_file_size.set(localbawx.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(localbawx.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(localbawx.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(localbawx.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    a(localTryUpImgReq);
    localTryUpImgReq.bool_pic_original.set(localbawx.jdField_b_of_type_Boolean);
    localTryUpImgReq.uint32_pic_width.set(localbawx.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(localbawx.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(localbawx.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(basj.a()));
    localTryUpImgReq.bool_reject_tryfast.set(false);
    localTryUpImgReq.uint32_srv_upload.set(localbawx.e);
    if (!TextUtils.isEmpty(localbawx.jdField_b_of_type_JavaLangString)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(localbawx.jdField_b_of_type_JavaLangString));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  protected void a(barh parambarh)
  {
    parambarh.jdField_a_of_type_JavaLangString = "LongConn.OffPicUp";
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
      parambari = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((parambari.equals("conSucc")) || (parambari.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(localFromServiceMsg);
          parambarh = localFromServiceMsg.getBusinessFailMsg();
          parambari = parambarh;
          if (parambarh == null) {
            parambari = "";
          }
          a(-1, 9311, (String)localObject, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      baxu.a(localbawo, localbaxd);
      return;
      parambarh = localFromServiceMsg.getBusinessFailMsg();
      parambari = parambarh;
      if (parambarh == null) {
        parambari = "";
      }
      a(-1, 9044, String.valueOf(i), parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, parambari, localFromServiceMsg.getBusinessFailMsg(), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambari = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((parambari != null) && (parambari.size() != 0)) {
          break label314;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label314:
      Iterator localIterator = parambari.iterator();
      while (localIterator.hasNext())
      {
        parambari = (cmd0x352.TryUpImgRsp)localIterator.next();
        try
        {
          localObject = (baxf)localbaxd.jdField_a_of_type_JavaUtilList.get((int)parambari.uint64_file_id.get());
          if (localObject == null) {
            continue;
          }
          try
          {
            if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              ((baxf)localObject).jdField_d_of_type_Boolean = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = parambari.uint32_result.get();
            if (i != 0) {
              break label500;
            }
            a(parambari, (baxf)localObject);
            a(0, 0, "", "", localalsj, (baxq)localObject);
          }
          catch (Exception parambari) {}
        }
        catch (Exception parambari)
        {
          for (;;)
          {
            localObject = null;
          }
        }
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, (baxq)localObject);
        continue;
        label500:
        if (a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambarh);
            return;
          }
        }
        a(-1, -9527, bamw.a(i), "", localalsj, (baxq)localObject);
      }
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      a(localbarh);
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
    }
  }
  
  protected void a(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(1);
  }
  
  void a(cmd0x352.TryUpImgRsp paramTryUpImgRsp, baxf parambaxf)
  {
    boolean bool = true;
    if (paramTryUpImgRsp.bytes_up_resid.has()) {
      parambaxf.jdField_a_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_resid.get().toStringUtf8();
    }
    if (paramTryUpImgRsp.bytes_up_uuid.has()) {
      parambaxf.jdField_b_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_uuid.get().toStringUtf8();
    }
    parambaxf.jdField_a_of_type_Long = paramTryUpImgRsp.uint64_up_offset.get();
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, " TryUpLoad : Offset:" + parambaxf.jdField_a_of_type_Long + " Value:" + paramTryUpImgRsp.uint64_up_offset.get());
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      parambaxf.jdField_a_of_type_Boolean = true;
      if (paramTryUpImgRsp.bytes_original_down_para.has()) {
        parambaxf.jdField_d_of_type_JavaLangString = paramTryUpImgRsp.bytes_original_down_para.get().toStringUtf8();
      }
      return;
    }
    parambaxf.jdField_c_of_type_JavaLangString = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
    parambaxf.jdField_a_of_type_Int = ((int)paramTryUpImgRsp.uint64_block_size.get());
    if (baqx.a().a() != this.jdField_a_of_type_Int) {}
    for (;;)
    {
      parambaxf.jdField_b_of_type_Boolean = bool;
      break;
      bool = false;
    }
  }
  
  byte[] a(List<bawz> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bawz)paramList.get(i), localReqBody);
      i += 1;
    }
    i = baqx.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
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
      baxf localbaxf = new baxf();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, localbaxf);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawc
 * JD-Core Version:    0.7.0.1
 */