package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class PokeMsgElemDecoder
  extends SimplePBElemDecoder
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
    }
    paramStringBuilder = null;
    Object localObject = paramList.iterator();
    do
    {
      paramList = paramStringBuilder;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList.common_elem.has());
    paramList = (im_msg_body.CommonElem)paramList.common_elem.get();
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
      }
      return;
    }
    paramStringBuilder = new MessageForPoke();
    paramStringBuilder.msgtype = -5012;
    if (paramList.uint32_business_type.has()) {
      paramStringBuilder.interactType = paramList.uint32_business_type.get();
    }
    if (paramList.bytes_pb_elem.has()) {
      localObject = new hummer_commelem.MsgElemInfo_servtype2();
    }
    for (;;)
    {
      try
      {
        ((hummer_commelem.MsgElemInfo_servtype2)localObject).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        paramStringBuilder.msg = ((hummer_commelem.MsgElemInfo_servtype2)localObject).bytes_poke_summary.get().toStringUtf8();
        paramStringBuilder.doubleHitState = ((hummer_commelem.MsgElemInfo_servtype2)localObject).uint32_double_hit.get();
        if (!((hummer_commelem.MsgElemInfo_servtype2)localObject).uint32_vaspoke_id.has()) {
          break label448;
        }
        i = ((hummer_commelem.MsgElemInfo_servtype2)localObject).uint32_vaspoke_id.get();
        paramStringBuilder.subId = i;
        if (((hummer_commelem.MsgElemInfo_servtype2)localObject).bytes_vaspoke_name.has()) {
          paramList = ((hummer_commelem.MsgElemInfo_servtype2)localObject).bytes_vaspoke_name.get().toStringUtf8();
        } else {
          paramList = HardCodeUtil.a(2131904540);
        }
        paramStringBuilder.name = paramList;
        if (!((hummer_commelem.MsgElemInfo_servtype2)localObject).bytes_vaspoke_minver.has()) {
          break label454;
        }
        paramList = ((hummer_commelem.MsgElemInfo_servtype2)localObject).bytes_vaspoke_minver.get().toStringUtf8();
        paramStringBuilder.minVersion = paramList;
        paramStringBuilder.strength = ((hummer_commelem.MsgElemInfo_servtype2)localObject).uint32_poke_strength.get();
        if (!((hummer_commelem.MsgElemInfo_servtype2)localObject).uint32_poke_flag.has()) {
          break label460;
        }
        i = ((hummer_commelem.MsgElemInfo_servtype2)localObject).uint32_poke_flag.get();
        paramStringBuilder.flag = i;
        if (paramStringBuilder.interactType == 126) {
          VasWebviewUtil.a("", "poke", "receive", "", 0, 0, 0, "", String.valueOf(paramStringBuilder.subId), "none", "", "", "", "", 0, 0, 0, 0);
        }
      }
      catch (Exception paramList)
      {
        QLog.d("PokeMsg", 1, "decodePBMsgElems_PokeMsg exception!", paramList);
      }
      paramList1.add(paramStringBuilder);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("decodePbElems, common_elem type 2, interactType:");
        paramList.append(paramStringBuilder.interactType);
        paramList.append(" ,doubleHitState:");
        paramList.append(paramStringBuilder.doubleHitState);
        QLog.d("PokeMsg", 2, paramList.toString());
      }
      return;
      label448:
      int i = -1;
      continue;
      label454:
      paramList = "";
      continue;
      label460:
      i = 0;
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramList, paramList1, paramStringBuilder);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (2 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.PokeMsgElemDecoder
 * JD-Core Version:    0.7.0.1
 */