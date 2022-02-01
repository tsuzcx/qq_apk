package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.oidb.oidb_0xdea.PassThrough;

public class GeneralFlagsElemDecoder
  extends SimplePBElemDecoder
{
  private void a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      long l = MessageProtoCodec.a(paramMsg);
      if (l >= 0L)
      {
        if (!paramList.isEmpty()) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
        }
        if (QLog.isColorLevel()) {
          QLog.d("GeneralFlagsElemDecoder", 2, "old vip_font_id = " + l + " fontId = " + FontManager.a(l) + " type = " + FontManager.b(l));
        }
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool;
    if ((paramResvAttr.uint32_comment_flag.has()) && (paramResvAttr.uint64_comment_location.has()) && (!paramList.isEmpty()))
    {
      if (paramResvAttr.uint32_comment_flag.get() != 1) {
        break label184;
      }
      bool = true;
    }
    for (;;)
    {
      long l = paramResvAttr.uint64_comment_location.get();
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList instanceof MessageForReplyText))
      {
        paramList = (MessageForReplyText)paramList;
        paramList.isBarrageMsg = bool;
        paramList.barrageTimeLocation = l;
        if (paramList.isBarrageMsg) {
          paramList.saveExtInfoToExtStr("barrage_time_location", String.valueOf(paramList.barrageTimeLocation));
        }
      }
      try
      {
        oidb_0xdea.PassThrough localPassThrough = new oidb_0xdea.PassThrough();
        localPassThrough.mergeFrom(paramResvAttr.bytes_pass_through.get().toByteArray());
        paramList.barrageSourceMsgType = localPassThrough.entrance.get();
        if (QLog.isColorLevel()) {
          QLog.d("GeneralFlagsElemDecoder", 2, new Object[] { "receive replay msg, isBarrageMsg: ", Boolean.valueOf(bool), " timeLocation:", Long.valueOf(l) });
        }
        return;
        label184:
        bool = false;
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          QLog.i("GeneralFlagsElemDecoder", 1, "handleGeneralSettingFlags fail, " + paramList);
        }
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr, StringBuilder paramStringBuilder)
  {
    if (paramResvAttr.bytes_service_msg_name.has())
    {
      paramResvAttr = paramResvAttr.bytes_service_msg_name.get().toStringUtf8();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(MessageConstants.B, paramResvAttr);
      }
      paramStringBuilder.append("---bytes_service_msg_name = ").append(paramResvAttr).append("---");
    }
  }
  
  private void a(generalflags.ResvAttr paramResvAttr)
  {
    if ((paramResvAttr.uint32_tail_key.has()) && (2 == paramResvAttr.uint32_tail_key.get()) && (paramResvAttr.uint32_show_tail_flag.has()) && (1 != paramResvAttr.uint32_show_tail_flag.get()))
    {
      paramResvAttr.uint32_tail_key.clear();
      if (QLog.isColorLevel()) {
        QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_show_tail_flag != 1, uint32_tail_key been cleaned ");
      }
    }
  }
  
  private boolean a(List<MessageRecord> paramList, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool;
    if (paramResvAttr.uint32_mobile_custom_font.has())
    {
      long l = 0xFFFFFFFF & paramResvAttr.uint32_mobile_custom_font.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
      }
      if (QLog.isColorLevel()) {
        QLog.d("GeneralFlagsElemDecoder", 2, "vip_font_id = " + l + " fontId = " + FontManager.a(l) + " type = " + FontManager.b(l));
      }
      bool = true;
    }
    do
    {
      return bool;
      bool = paramBoolean;
    } while (!QLog.isColorLevel());
    QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags vip_font not has");
    return paramBoolean;
  }
  
  private void b(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    try
    {
      if (paramResvAttr.uint32_msg_info_flag.has())
      {
        int i = paramResvAttr.uint32_msg_info_flag.get();
        if (!paramList.isEmpty()) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i));
        }
        if (QLog.isColorLevel()) {
          QLog.i("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags: invoked.  flag: " + i + ", mr: " + paramList.get(0));
        }
      }
      return;
    }
    catch (Throwable paramList) {}
  }
  
  private void b(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr, StringBuilder paramStringBuilder)
  {
    if (paramResvAttr.uint32_service_msg_remind_type.has())
    {
      int i = paramResvAttr.uint32_service_msg_remind_type.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(MessageConstants.A, String.valueOf(i));
      }
      paramStringBuilder.append("---uint32_service_msg_remind_type = ").append(i).append("---");
    }
  }
  
  private void c(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint32_holiday_flag.has())
    {
      int i = paramResvAttr.uint32_holiday_flag.get();
      if ((i == 1) && (!paramList.isEmpty())) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(MessageConstants.c, String.valueOf(i));
      }
      if (QLog.isColorLevel()) {
        QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_holiday_flag = " + i);
      }
    }
  }
  
  private void c(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr, StringBuilder paramStringBuilder)
  {
    if (paramResvAttr.uint32_service_msg_type.has())
    {
      int i = paramResvAttr.uint32_service_msg_type.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(MessageConstants.z, String.valueOf(i));
      }
      paramStringBuilder.append("---uint32_service_msg_type = ").append(i).append("---");
    }
  }
  
  private void d(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint32_bot_message_class_id.has())
    {
      int i = paramResvAttr.uint32_bot_message_class_id.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("robot_news_class_id", String.valueOf(i));
      }
      if (QLog.isColorLevel()) {
        QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_bot_message_class_id = " + i);
      }
    }
  }
  
  private void e(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint32_diy_font_timestamp.has())
    {
      l = paramResvAttr.uint32_diy_font_timestamp.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("diy_timestamp", String.valueOf(l));
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "diy_font_timestamp = " + l);
      }
    }
    while (!QLog.isColorLevel())
    {
      long l;
      return;
    }
    QLog.d("VasFont", 2, "diy_font_timestamp not in message");
  }
  
  private void f(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint64_subfont_id.has())
    {
      long l = paramResvAttr.uint64_subfont_id.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(l));
      }
      if (QLog.isColorLevel()) {
        QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags: subFontId=" + l);
      }
    }
  }
  
  private void g(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    long l2 = 0L;
    float f2 = 0.0F;
    EmojiStickerManager.StickerInfo localStickerInfo;
    float f1;
    label79:
    int i;
    if (paramResvAttr.float_sticker_x.has())
    {
      localStickerInfo = new EmojiStickerManager.StickerInfo();
      localStickerInfo.x = paramResvAttr.float_sticker_x.get();
      if (!paramResvAttr.float_sticker_y.has()) {
        break label309;
      }
      f1 = paramResvAttr.float_sticker_y.get();
      localStickerInfo.y = f1;
      if (!paramResvAttr.float_sticker_width.has()) {
        break label314;
      }
      f1 = paramResvAttr.float_sticker_width.get();
      localStickerInfo.width = f1;
      f1 = f2;
      if (paramResvAttr.float_sticker_height.has()) {
        f1 = paramResvAttr.float_sticker_height.get();
      }
      localStickerInfo.height = f1;
      if (!paramResvAttr.uint32_sticker_rotate.has()) {
        break label319;
      }
      i = paramResvAttr.uint32_sticker_rotate.get();
      label131:
      localStickerInfo.rotate = i;
      if (!paramResvAttr.uint64_sticker_host_msgseq.has()) {
        break label325;
      }
      l1 = paramResvAttr.uint64_sticker_host_msgseq.get();
      label157:
      localStickerInfo.hostMsgSeq = l1;
      if (!paramResvAttr.uint64_sticker_host_msguid.has()) {
        break label331;
      }
    }
    label309:
    label314:
    label319:
    label325:
    label331:
    for (long l1 = paramResvAttr.uint64_sticker_host_msguid.get();; l1 = 0L)
    {
      localStickerInfo.hostMsgUid = l1;
      l1 = l2;
      if (paramResvAttr.uint64_sticker_host_time.has()) {
        l1 = paramResvAttr.uint64_sticker_host_time.get();
      }
      localStickerInfo.hostMsgTime = l1;
      if (QLog.isColorLevel()) {
        QLog.d("GeneralFlagsElemDecoder", 2, "decodeC2CMsgPkg_EmojSticker->" + localStickerInfo.toString());
      }
      if (!paramList.isEmpty())
      {
        paramList = (MessageRecord)paramList.get(0);
        if (paramList != null)
        {
          paramList.saveExtInfoToExtStr("sticker_info", localStickerInfo.toJsonString());
          EmojiStickerManager.a(paramList, localStickerInfo);
          paramList.saveExtInfoToExtStr("message_is_sticker", "true");
        }
      }
      return;
      f1 = 0.0F;
      break;
      f1 = 0.0F;
      break label79;
      i = 0;
      break label131;
      l1 = 0L;
      break label157;
    }
  }
  
  private void h(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint32_tail_key.has())
    {
      int i = paramResvAttr.uint32_tail_key.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("app_tail_id", String.valueOf(i));
      }
      if (QLog.isColorLevel()) {
        QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_tail_key = " + i);
      }
    }
  }
  
  private void i(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    try
    {
      if (paramResvAttr.bytes_yuheng_task_msg_buf.has())
      {
        paramResvAttr = new String(paramResvAttr.bytes_yuheng_task_msg_buf.get().toByteArray(), "ISO_8859_1");
        if (!paramList.isEmpty()) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("key_qcircle_extra_info", paramResvAttr);
        }
        if (QLog.isColorLevel()) {
          QLog.i("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags: decodeQCircleExtraInfo invoked.  extra: " + paramResvAttr + ", mr: " + paramList.get(0));
        }
      }
      return;
    }
    catch (Throwable paramList)
    {
      QLog.e("GeneralFlagsElemDecoder", 1, "handleGeneralSettingFlags: decodeQCircleExtraInfo failed!exception:" + paramList.toString());
    }
  }
  
  public int a()
  {
    return -1000;
  }
  
  protected void a(List<MessageRecord> paramList, StringBuilder paramStringBuilder, im_msg_body.Elem paramElem)
  {
    if ((paramElem.general_flags.has()) && (((im_msg_body.GeneralFlags)paramElem.general_flags.get()).uint32_olympic_torch.has()))
    {
      int i = paramElem.general_flags.uint32_olympic_torch.get();
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("has olympicTorch:").append(i).append(";");
      }
      if ((i > 0) && (!paramList.isEmpty())) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("olympic_torch_flg", i + "");
      }
    }
  }
  
  protected void a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.Elem paramElem)
  {
    generalflags.ResvAttr localResvAttr;
    if (paramElem.general_flags.has())
    {
      if (paramElem.general_flags.uint64_pendant_id.has())
      {
        long l = paramElem.general_flags.uint64_pendant_id.get();
        if (QLog.isColorLevel()) {
          QLog.d("GeneralFlagsElemDecoder", 2, "vip_pendant_id = " + l);
        }
        if ((l >= 0L) && (!paramList.isEmpty())) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_pendant_id", String.valueOf(l));
        }
      }
      if (!paramElem.general_flags.bytes_pb_reserve.has()) {
        break label304;
      }
      localResvAttr = new generalflags.ResvAttr();
    }
    for (;;)
    {
      try
      {
        localResvAttr.mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
        g(paramList, localResvAttr);
        bool = a(paramList, false, localResvAttr);
        paramElem.printStackTrace();
      }
      catch (InvalidProtocolBufferMicroException paramElem)
      {
        try
        {
          f(paramList, localResvAttr);
          e(paramList, localResvAttr);
          a(localResvAttr);
          h(paramList, localResvAttr);
          d(paramList, localResvAttr);
          c(paramList, localResvAttr);
          paramElem = new StringBuilder("<---decodeMiniProgramPBMsgElems:");
          c(paramList, localResvAttr, paramElem);
          b(paramList, localResvAttr, paramElem);
          a(paramList, localResvAttr, paramElem);
          if (QLog.isColorLevel()) {
            QLog.d("GeneralFlagsElemDecoder", 2, new Object[] { paramElem });
          }
          b(paramList, localResvAttr);
          a(paramList, localResvAttr);
          i(paramList, localResvAttr);
          a(paramList, paramMsg, bool);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramElem)
        {
          break label293;
        }
        paramElem = paramElem;
        bool = false;
      }
      label293:
      continue;
      label304:
      boolean bool = false;
    }
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramMessageInfo = (im_msg_body.Elem)paramList.next();
      a(paramList1, paramStringBuilder, paramMessageInfo);
      a(paramList1, paramMsg, paramMessageInfo);
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.general_flags.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.GeneralFlagsElemDecoder
 * JD-Core Version:    0.7.0.1
 */