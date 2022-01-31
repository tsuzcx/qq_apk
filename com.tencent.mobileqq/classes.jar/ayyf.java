import android.text.TextUtils;
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

public class ayyf
  extends ayxz
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202);
  }
  
  void a(int paramInt, ayyy paramayyy, cmd0x388.ReqBody paramReqBody)
  {
    paramayyy = (ayyw)paramayyy;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramayyy.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(paramayyy.jdField_d_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(paramayyy.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayyy.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramayyy.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(paramayyy.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(paramayyy.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(paramayyy.jdField_a_of_type_Int);
    localTryUpImgReq.uint32_app_pic_type.set(paramayyy.jdField_b_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramayyy.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayui.a()));
      localTryUpImgReq.uint32_srv_upload.set(paramayyy.e);
      if (paramayyy.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      if (!TextUtils.isEmpty(paramayyy.jdField_b_of_type_JavaLangString)) {
        localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(paramayyy.jdField_b_of_type_JavaLangString));
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
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
          localObject1 = MessageHandler.b(localFromServiceMsg);
          paramayti = localFromServiceMsg.getBusinessFailMsg();
          paramaytj = paramayti;
          if (paramayti == null) {
            paramaytj = "";
          }
          a(-1, 9311, (String)localObject1, paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
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
        paramaytj = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
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
        paramaytj = (cmd0x388.TryUpImgRsp)localIterator.next();
        try
        {
          localObject1 = (ayzh)localayzc.jdField_a_of_type_JavaUtilList.get((int)paramaytj.uint64_file_id.get());
          if (localObject1 == null) {
            continue;
          }
          try
          {
            if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              ((ayzh)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramaytj.uint32_result.get();
            if (i != 0) {
              break label977;
            }
            ((ayzh)localObject1).jdField_a_of_type_Long = paramaytj.uint64_fileid.get();
            long l1;
            long l2;
            if ((paramaytj.bool_file_exit.has()) && (paramaytj.bool_file_exit.get()))
            {
              ((ayzh)localObject1).jdField_a_of_type_Boolean = true;
              localList = paramaytj.rpt_uint32_up_ip.get();
              paramaytj = paramaytj.rpt_uint32_up_port.get();
              if ((localList == null) || (localList.size() <= 0)) {
                break label960;
              }
              i = 0;
              while (i < localList.size())
              {
                l1 = ((Integer)localList.get(i)).intValue();
                l2 = ((Integer)paramaytj.get(i)).intValue();
                localObject2 = new ayuo();
                ((ayuo)localObject2).jdField_a_of_type_JavaLangString = bbmj.a(l1 & 0xFFFFFFFF);
                ((ayuo)localObject2).jdField_a_of_type_Int = ((int)l2);
                ((ayzh)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localObject2);
                i += 1;
              }
            }
            List localList = paramaytj.rpt_uint32_up_ip.get();
            localObject2 = paramaytj.rpt_uint32_up_port.get();
            if ((localList != null) && (localList.size() > 0))
            {
              i = 0;
              while (i < localList.size())
              {
                l1 = ((Integer)localList.get(i)).intValue();
                l2 = ((Integer)((List)localObject2).get(i)).intValue();
                ayuo localayuo = new ayuo();
                localayuo.jdField_a_of_type_JavaLangString = bbmj.a(l1 & 0xFFFFFFFF);
                localayuo.jdField_a_of_type_Int = ((int)l2);
                ((ayzh)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localayuo);
                i += 1;
              }
            }
            localObject2 = HexUtil.bytes2HexStr(paramaytj.bytes_up_ukey.get().toByteArray());
            if ((localObject2 != null) && (!((String)localObject2).equals("")) && (localList != null) && (localList.size() != 0)) {
              break label826;
            }
            throw new Exception("check ukey,iplist");
          }
          catch (Exception paramaytj) {}
        }
        catch (Exception paramaytj)
        {
          for (;;)
          {
            Object localObject2;
            localObject1 = null;
            continue;
            boolean bool = false;
          }
        }
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, (ayzp)localObject1);
        continue;
        label826:
        ((ayzh)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
        ((ayzh)localObject1).jdField_a_of_type_Int = ((int)paramaytj.uint64_block_size.get());
        ((ayzh)localObject1).jdField_b_of_type_Int = ((int)paramaytj.uint64_up_offset.get());
        if (aysy.a().a() == this.jdField_a_of_type_Int) {
          break label1041;
        }
        bool = true;
        ((ayzh)localObject1).jdField_b_of_type_Boolean = bool;
        ((ayzh)localObject1).jdField_b_of_type_Long = paramaytj.uint64_up_offset.get();
        if (QLog.isColorLevel()) {
          QLog.d("BDH_LOG", 2, " Channel:" + paramaytj.bool_new_big_chan.get());
        }
        if ((paramaytj.bool_new_big_chan.has()) && (paramaytj.bool_new_big_chan.get() == true)) {
          ((ayzh)localObject1).c = true;
        }
        label960:
        a(0, 0, "", "", localakaw, (ayzp)localObject1);
        continue;
        label977:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramayti);
            return;
          }
        }
        a(-1, -9527, ayoz.a(i), "", localakaw, (ayzp)localObject1);
      }
    }
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      localayti.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicUp";
      localayti.jdField_a_of_type_ArrayOfByte = a(paramayyn.jdField_a_of_type_JavaUtilList);
      localayti.jdField_a_of_type_JavaLangObject = paramayyn;
      localayti.jdField_a_of_type_Ayth = this;
      a(paramayyn, localayti);
    }
  }
  
  byte[] a(List<ayyy> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
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
      ayzh localayzh = new ayzh();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayzh);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyf
 * JD-Core Version:    0.7.0.1
 */