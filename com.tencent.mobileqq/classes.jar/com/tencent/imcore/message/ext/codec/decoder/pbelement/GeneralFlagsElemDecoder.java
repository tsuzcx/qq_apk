package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
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
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
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
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("old vip_font_id = ");
          paramList.append(l);
          paramList.append(" fontId = ");
          paramList.append(FontManagerConstants.parseFontId(l));
          paramList.append(" type = ");
          paramList.append(FontManagerConstants.parseFontType(l));
          QLog.d("GeneralFlagsElemDecoder", 2, paramList.toString());
        }
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    Object localObject;
    if (paramResvAttr.bytes_tag_name.has())
    {
      localObject = paramResvAttr.bytes_tag_name.get().toStringUtf8();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeOpenExtraInfo, bytes_tag_name= ");
        localStringBuilder.append((String)localObject);
        QLog.d("GeneralFlagsElemDecoder", 2, localStringBuilder.toString());
      }
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("key_open_game_tag_name", (String)localObject);
      }
    }
    if (paramResvAttr.bytes_message_ext.has())
    {
      paramResvAttr = paramResvAttr.bytes_message_ext.get().toStringUtf8();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeOpenExtraInfo, bytes_message_ext= ");
        ((StringBuilder)localObject).append(paramResvAttr);
        QLog.d("GeneralFlagsElemDecoder", 2, ((StringBuilder)localObject).toString());
      }
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("key_open_game_message_ext", paramResvAttr);
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
      paramStringBuilder.append("---bytes_service_msg_name = ");
      paramStringBuilder.append(paramResvAttr);
      paramStringBuilder.append("---");
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
    if (paramResvAttr.uint32_mobile_custom_font.has())
    {
      long l = paramResvAttr.uint32_mobile_custom_font.get() & 0xFFFFFFFF;
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("vip_font_id = ");
        paramList.append(l);
        paramList.append(" fontId = ");
        paramList.append(FontManagerConstants.parseFontId(l));
        paramList.append(" type = ");
        paramList.append(FontManagerConstants.parseFontType(l));
        QLog.d("GeneralFlagsElemDecoder", 2, paramList.toString());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags vip_font not has");
    }
    return paramBoolean;
  }
  
  private void b(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if ((paramResvAttr.uint32_comment_flag.has()) && (paramResvAttr.uint64_comment_location.has()) && (!paramList.isEmpty()))
    {
      boolean bool;
      if (paramResvAttr.uint32_comment_flag.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      long l = paramResvAttr.uint64_comment_location.get();
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList instanceof MessageForReplyText))
      {
        paramList = (MessageForReplyText)paramList;
        paramList.isBarrageMsg = bool;
        paramList.barrageTimeLocation = l;
        if (paramList.isBarrageMsg)
        {
          paramList.saveExtInfoToExtStr("barrage_time_location", String.valueOf(paramList.barrageTimeLocation));
          try
          {
            oidb_0xdea.PassThrough localPassThrough = new oidb_0xdea.PassThrough();
            localPassThrough.mergeFrom(paramResvAttr.bytes_pass_through.get().toByteArray());
            paramList.barrageSourceMsgType = localPassThrough.entrance.get();
          }
          catch (Exception paramList)
          {
            paramResvAttr = new StringBuilder();
            paramResvAttr.append("handleGeneralSettingFlags fail, ");
            paramResvAttr.append(paramList);
            QLog.i("GeneralFlagsElemDecoder", 1, paramResvAttr.toString());
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GeneralFlagsElemDecoder", 2, new Object[] { "receive replay msg, isBarrageMsg: ", Boolean.valueOf(bool), " timeLocation:", Long.valueOf(l) });
      }
    }
  }
  
  private void b(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr, StringBuilder paramStringBuilder)
  {
    if (paramResvAttr.uint32_service_msg_remind_type.has())
    {
      int i = paramResvAttr.uint32_service_msg_remind_type.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(MessageConstants.A, String.valueOf(i));
      }
      paramStringBuilder.append("---uint32_service_msg_remind_type = ");
      paramStringBuilder.append(i);
      paramStringBuilder.append("---");
    }
  }
  
  private void c(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    try
    {
      if (paramResvAttr.uint32_msg_info_flag.has())
      {
        int i = paramResvAttr.uint32_msg_info_flag.get();
        if (!paramList.isEmpty()) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i));
        }
        if (QLog.isColorLevel())
        {
          paramResvAttr = new StringBuilder();
          paramResvAttr.append("handleGeneralSettingFlags: invoked.  flag: ");
          paramResvAttr.append(i);
          paramResvAttr.append(", mr: ");
          paramResvAttr.append(paramList.get(0));
          QLog.i("GeneralFlagsElemDecoder", 2, paramResvAttr.toString());
        }
      }
      return;
    }
    catch (Throwable paramList) {}
  }
  
  private void c(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr, StringBuilder paramStringBuilder)
  {
    if (paramResvAttr.uint32_service_msg_type.has())
    {
      int i = paramResvAttr.uint32_service_msg_type.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(MessageConstants.z, String.valueOf(i));
      }
      paramStringBuilder.append("---uint32_service_msg_type = ");
      paramStringBuilder.append(i);
      paramStringBuilder.append("---");
    }
  }
  
  private void d(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint32_holiday_flag.has())
    {
      int i = paramResvAttr.uint32_holiday_flag.get();
      if ((i == 1) && (!paramList.isEmpty())) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(MessageConstants.c, String.valueOf(i));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("handleGeneralSettingFlags uint32_holiday_flag = ");
        paramList.append(i);
        QLog.d("GeneralFlagsElemDecoder", 2, paramList.toString());
      }
    }
  }
  
  private void e(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint32_bot_message_class_id.has())
    {
      int i = paramResvAttr.uint32_bot_message_class_id.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("robot_news_class_id", String.valueOf(i));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("handleGeneralSettingFlags uint32_bot_message_class_id = ");
        paramList.append(i);
        QLog.d("GeneralFlagsElemDecoder", 2, paramList.toString());
      }
    }
  }
  
  private void f(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint32_diy_font_timestamp.has())
    {
      long l = paramResvAttr.uint32_diy_font_timestamp.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("diy_timestamp", String.valueOf(l));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("diy_font_timestamp = ");
        paramList.append(l);
        QLog.d("FontManagerConstants", 2, paramList.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("FontManagerConstants", 2, "diy_font_timestamp not in message");
    }
  }
  
  private void g(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint64_subfont_id.has())
    {
      long l = paramResvAttr.uint64_subfont_id.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(l));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("handleGeneralSettingFlags: subFontId=");
        paramList.append(l);
        QLog.d("GeneralFlagsElemDecoder", 2, paramList.toString());
      }
    }
  }
  
  private void h(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.float_sticker_x.has())
    {
      StickerInfo localStickerInfo = new StickerInfo();
      localStickerInfo.x = paramResvAttr.float_sticker_x.get();
      boolean bool = paramResvAttr.float_sticker_y.has();
      float f2 = 0.0F;
      if (bool) {
        f1 = paramResvAttr.float_sticker_y.get();
      } else {
        f1 = 0.0F;
      }
      localStickerInfo.y = f1;
      if (paramResvAttr.float_sticker_width.has()) {
        f1 = paramResvAttr.float_sticker_width.get();
      } else {
        f1 = 0.0F;
      }
      localStickerInfo.width = f1;
      float f1 = f2;
      if (paramResvAttr.float_sticker_height.has()) {
        f1 = paramResvAttr.float_sticker_height.get();
      }
      localStickerInfo.height = f1;
      int i;
      if (paramResvAttr.uint32_sticker_rotate.has()) {
        i = paramResvAttr.uint32_sticker_rotate.get();
      } else {
        i = 0;
      }
      localStickerInfo.rotate = i;
      bool = paramResvAttr.uint64_sticker_host_msgseq.has();
      long l2 = 0L;
      if (bool) {
        l1 = paramResvAttr.uint64_sticker_host_msgseq.get();
      } else {
        l1 = 0L;
      }
      localStickerInfo.hostMsgSeq = l1;
      if (paramResvAttr.uint64_sticker_host_msguid.has()) {
        l1 = paramResvAttr.uint64_sticker_host_msguid.get();
      } else {
        l1 = 0L;
      }
      localStickerInfo.hostMsgUid = l1;
      long l1 = l2;
      if (paramResvAttr.uint64_sticker_host_time.has()) {
        l1 = paramResvAttr.uint64_sticker_host_time.get();
      }
      localStickerInfo.hostMsgTime = l1;
      if (QLog.isColorLevel())
      {
        paramResvAttr = new StringBuilder();
        paramResvAttr.append("decodeC2CMsgPkg_EmojSticker->");
        paramResvAttr.append(localStickerInfo.toString());
        QLog.d("GeneralFlagsElemDecoder", 2, paramResvAttr.toString());
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
    }
  }
  
  private void i(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    if (paramResvAttr.uint32_tail_key.has())
    {
      int i = paramResvAttr.uint32_tail_key.get();
      if (!paramList.isEmpty()) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("app_tail_id", String.valueOf(i));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("handleGeneralSettingFlags uint32_tail_key = ");
        paramList.append(i);
        QLog.d("GeneralFlagsElemDecoder", 2, paramList.toString());
      }
    }
  }
  
  private void j(List<MessageRecord> paramList, generalflags.ResvAttr paramResvAttr)
  {
    try
    {
      if (paramResvAttr.bytes_yuheng_task_msg_buf.has())
      {
        paramResvAttr = new String(paramResvAttr.bytes_yuheng_task_msg_buf.get().toByteArray(), "ISO_8859_1");
        if (!paramList.isEmpty()) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("key_qcircle_extra_info", paramResvAttr);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleGeneralSettingFlags: decodeQCircleExtraInfo invoked.  extra: ");
          localStringBuilder.append(paramResvAttr);
          localStringBuilder.append(", mr: ");
          localStringBuilder.append(paramList.get(0));
          QLog.i("GeneralFlagsElemDecoder", 2, localStringBuilder.toString());
          return;
        }
      }
    }
    catch (Throwable paramList)
    {
      paramResvAttr = new StringBuilder();
      paramResvAttr.append("handleGeneralSettingFlags: decodeQCircleExtraInfo failed!exception:");
      paramResvAttr.append(paramList.toString());
      QLog.e("GeneralFlagsElemDecoder", 1, paramResvAttr.toString());
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
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("has olympicTorch:");
        paramStringBuilder.append(i);
        paramStringBuilder.append(";");
      }
      if ((i > 0) && (!paramList.isEmpty()))
      {
        paramList = (MessageRecord)paramList.get(0);
        paramStringBuilder = new StringBuilder();
        paramStringBuilder.append(i);
        paramStringBuilder.append("");
        paramList.saveExtInfoToExtStr("olympic_torch_flg", paramStringBuilder.toString());
      }
    }
  }
  
  protected void a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.Elem paramElem)
  {
    if (paramElem.general_flags.has())
    {
      boolean bool3 = paramElem.general_flags.uint64_pendant_id.has();
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject;
      if (bool3)
      {
        long l = paramElem.general_flags.uint64_pendant_id.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("vip_pendant_id = ");
          ((StringBuilder)localObject).append(l);
          QLog.d("GeneralFlagsElemDecoder", 2, ((StringBuilder)localObject).toString());
        }
        if ((l >= 0L) && (!paramList.isEmpty())) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_pendant_id", String.valueOf(l));
        }
      }
      if (paramElem.general_flags.bytes_pb_reserve.has())
      {
        localObject = new generalflags.ResvAttr();
        try
        {
          ((generalflags.ResvAttr)localObject).mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
          h(paramList, (generalflags.ResvAttr)localObject);
          bool1 = a(paramList, false, (generalflags.ResvAttr)localObject);
          try
          {
            g(paramList, (generalflags.ResvAttr)localObject);
            f(paramList, (generalflags.ResvAttr)localObject);
            a((generalflags.ResvAttr)localObject);
            i(paramList, (generalflags.ResvAttr)localObject);
            e(paramList, (generalflags.ResvAttr)localObject);
            d(paramList, (generalflags.ResvAttr)localObject);
            paramElem = new StringBuilder("<---decodeMiniProgramPBMsgElems:");
            c(paramList, (generalflags.ResvAttr)localObject, paramElem);
            b(paramList, (generalflags.ResvAttr)localObject, paramElem);
            a(paramList, (generalflags.ResvAttr)localObject, paramElem);
            if (QLog.isColorLevel()) {
              QLog.d("GeneralFlagsElemDecoder", 2, new Object[] { paramElem });
            }
            c(paramList, (generalflags.ResvAttr)localObject);
            b(paramList, (generalflags.ResvAttr)localObject);
            j(paramList, (generalflags.ResvAttr)localObject);
            a(paramList, (generalflags.ResvAttr)localObject);
          }
          catch (InvalidProtocolBufferMicroException paramElem) {}
          paramElem.printStackTrace();
        }
        catch (InvalidProtocolBufferMicroException paramElem)
        {
          bool1 = bool2;
        }
      }
      a(paramList, paramMsg, bool1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.GeneralFlagsElemDecoder
 * JD-Core Version:    0.7.0.1
 */