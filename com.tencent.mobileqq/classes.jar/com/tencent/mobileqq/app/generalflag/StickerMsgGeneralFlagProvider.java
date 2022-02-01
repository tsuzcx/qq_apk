package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class StickerMsgGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool = paramBoolean;
    if (paramMessageRecord.msgtype == -2058)
    {
      StickerInfo localStickerInfo = EmojiStickerManager.d(paramMessageRecord);
      bool = paramBoolean;
      if (localStickerInfo != null)
      {
        paramBoolean = true;
        paramResvAttr.float_sticker_x.set(localStickerInfo.x);
        paramResvAttr.float_sticker_y.set(localStickerInfo.y);
        paramResvAttr.float_sticker_width.set(localStickerInfo.width);
        paramResvAttr.float_sticker_height.set(localStickerInfo.height);
        paramResvAttr.uint32_sticker_rotate.set(localStickerInfo.rotate);
        if (paramMessageRecord.istroop == 0) {
          paramResvAttr.uint64_sticker_host_msgseq.set((short)(int)localStickerInfo.hostMsgSeq & 0xFFFF);
        } else {
          paramResvAttr.uint64_sticker_host_msgseq.set(localStickerInfo.hostMsgSeq);
        }
        paramResvAttr.uint64_sticker_host_msguid.set(localStickerInfo.hostMsgUid);
        paramResvAttr.uint64_sticker_host_time.set(localStickerInfo.hostMsgTime);
        bool = paramBoolean;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("set generalFlag for sticker info: ");
          paramMessageRecord.append(localStickerInfo.toString());
          QLog.i("Q.msg.MessageHandlerUtils", 2, paramMessageRecord.toString());
          bool = paramBoolean;
        }
      }
    }
    return bool;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { paramBoolean1, a(paramMessageRecord, paramBoolean2, paramResvAttr) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.StickerMsgGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */