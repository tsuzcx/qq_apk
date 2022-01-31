import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpInfo4Busi;

public class bavz
  extends bawa
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202) && (paramInt != 120509) && (paramInt != 400010) && (paramInt != 400011);
  }
  
  void a(int paramInt, bawz parambawz, cmd0x388.ReqBody paramReqBody)
  {
    parambawz = (bawx)parambawz;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(parambawz.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(parambawz.jdField_d_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(parambawz.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambawz.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambawz.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(parambawz.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(parambawz.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(parambawz.jdField_a_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (parambawz.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(basj.a()));
      if (parambawz.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  public void a(bari parambari, barh parambarh)
  {
    FromServiceMsg localFromServiceMsg = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bawo localbawo = (bawo)parambarh.jdField_a_of_type_JavaLangObject;
    baxd localbaxd = localbawo.jdField_a_of_type_Baxd;
    alsj localalsj = parambari.jdField_a_of_type_Alsj;
    if (QLog.isColorLevel()) {
      QLog.e("BDHCommonUpHandler", 1, "onProtoResp: " + localFromServiceMsg.getResultCode());
    }
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      parambari = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((parambari.equals("conSucc")) || (parambari.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject1 = MessageHandler.b(localFromServiceMsg);
          parambarh = localFromServiceMsg.getBusinessFailMsg();
          parambari = parambarh;
          if (parambarh == null) {
            parambari = "";
          }
          a(-1, 9311, (String)localObject1, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
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
        parambari = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((parambari != null) && (parambari.size() != 0)) {
          break label349;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label349:
      Iterator localIterator = parambari.iterator();
      while (localIterator.hasNext())
      {
        parambari = (cmd0x388.TryUpImgRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (baxe)localbaxd.jdField_a_of_type_JavaUtilList.get((int)parambari.uint64_file_id.get());
              if (localObject1 == null) {
                break;
              }
              try
              {
                if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
                  ((baxe)localObject1).jdField_d_of_type_Boolean = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                }
                if (parambari.msg_info4busi.has())
                {
                  localObject2 = (cmd0x388.TryUpInfo4Busi)parambari.msg_info4busi.get();
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_down_domain.has()) {
                    ((baxe)localObject1).jdField_b_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_down_domain.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_big_down_url.has()) {
                    ((baxe)localObject1).jdField_d_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_big_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_original_down_url.has()) {
                    ((baxe)localObject1).e = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_original_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_thumb_down_url.has()) {
                    ((baxe)localObject1).jdField_c_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_thumb_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_file_resid.has()) {
                    ((baxe)localObject1).f = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_file_resid.get().toStringUtf8();
                  }
                }
                i = parambari.uint32_result.get();
                if (i != 0) {
                  break label1045;
                }
                ((baxe)localObject1).jdField_a_of_type_Long = parambari.uint64_fileid.get();
                localObject2 = parambari.rpt_uint32_up_ip.get();
                localObject3 = parambari.rpt_uint32_up_port.get();
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  i = 0;
                  while (i < ((List)localObject2).size())
                  {
                    long l1 = ((Integer)((List)localObject2).get(i)).intValue();
                    long l2 = ((Integer)((List)localObject3).get(i)).intValue();
                    basp localbasp = new basp();
                    localbasp.jdField_a_of_type_JavaLangString = bdlr.a(l1 & 0xFFFFFFFF);
                    localbasp.jdField_a_of_type_Int = ((int)l2);
                    ((baxe)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbasp);
                    i += 1;
                  }
                }
                if ((!parambari.bool_file_exit.has()) || (!parambari.bool_file_exit.get())) {
                  break label852;
                }
                ((baxe)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localalsj, (baxq)localObject1);
              }
              catch (Exception parambari) {}
            }
          }
          catch (Exception parambari)
          {
            Object localObject2;
            Object localObject3;
            label852:
            localObject1 = null;
            continue;
            boolean bool = false;
            continue;
          }
          a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, (baxq)localObject1);
          break;
          localObject3 = HexUtil.bytes2HexStr(parambari.bytes_up_ukey.get().toByteArray());
          if ((localObject3 == null) || (((String)localObject3).equals("")) || (localObject2 == null) || (((List)localObject2).size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((baxe)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
          ((baxe)localObject1).jdField_a_of_type_Int = ((int)parambari.uint64_block_size.get());
          ((baxe)localObject1).jdField_b_of_type_Int = ((int)parambari.uint64_up_offset.get());
          if (baqx.a().a() == this.jdField_a_of_type_Int) {
            continue;
          }
          bool = true;
          ((baxe)localObject1).jdField_b_of_type_Boolean = bool;
          ((baxe)localObject1).jdField_b_of_type_Long = parambari.uint64_up_offset.get();
          if (QLog.isColorLevel()) {
            QLog.d("BDH_LOG", 2, " Channel:" + parambari.bool_new_big_chan.get());
          }
          if ((parambari.bool_new_big_chan.has()) && (parambari.bool_new_big_chan.get() == true)) {
            ((baxe)localObject1).jdField_c_of_type_Boolean = true;
          }
        }
        label1045:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambarh);
            return;
          }
        }
        a(-1, -9527, bamw.a(i), "", localalsj, (baxq)localObject1);
      }
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      localbarh.jdField_a_of_type_JavaLangString = "ImgStore.BDHCommonUp";
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
    }
  }
  
  byte[] a(bawo parambawo)
  {
    if (parambawo == null) {
      return null;
    }
    List localList = parambawo.jdField_a_of_type_JavaUtilList;
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(parambawo.jdField_a_of_type_Int);
    if (parambawo.jdField_a_of_type_ArrayOfByte != null) {
      localReqBody.bytes_extension.set(ByteStringMicro.copyFrom(parambawo.jdField_a_of_type_ArrayOfByte));
    }
    int i = 0;
    while (i < localList.size())
    {
      a(i, (bawz)localList.get(i), localReqBody);
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
      parambawo = baqx.a().a();
      int j = i;
      if (parambawo != null)
      {
        j = i;
        if (parambawo.contains("wap")) {
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
      baxe localbaxe = new baxe();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, localbaxe);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavz
 * JD-Core Version:    0.7.0.1
 */