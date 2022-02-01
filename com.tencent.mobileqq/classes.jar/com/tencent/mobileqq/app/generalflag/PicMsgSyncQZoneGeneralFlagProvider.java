package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.qzone.album.UploadParam;

public class PicMsgSyncQZoneGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private void a(MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr)
  {
    if (((paramMessageRecord instanceof MessageForPic)) && (paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_is_sync_qzone").equals("1"))) {
      paramResvAttr.uint32_upload_image_to_qzone_flag.set(1);
    }
    try
    {
      UploadParam localUploadParam = new UploadParam();
      localUploadParam.bytes_qzone_albumid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_album_id")));
      localUploadParam.uint64_batchid.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_id")).longValue());
      localUploadParam.uint32_full_image.set(Integer.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_is_raw")).intValue());
      localUploadParam.uint64_image_number.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_count")).longValue());
      localUploadParam.uint64_image_number_index.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_photo_index")).longValue());
      paramResvAttr.bytes_upload_image_to_qzone_param.set(ByteStringMicro.copyFrom(localUploadParam.toByteArray()));
      if (QLog.isColorLevel())
      {
        paramResvAttr = new StringBuilder();
        paramResvAttr.append("general syncQzoneAlbum : albumid = ");
        paramResvAttr.append(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_album_id"));
        paramResvAttr.append(", batchid = ");
        paramResvAttr.append(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_id"));
        paramResvAttr.append(", isRaw = ");
        paramResvAttr.append(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_is_raw"));
        paramResvAttr.append(", imgCount = ");
        paramResvAttr.append(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_count"));
        paramResvAttr.append(", imgIndex = ");
        paramResvAttr.append(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_photo_index"));
        QLog.d("Q.msg.MessageHandlerUtils", 2, paramResvAttr.toString());
      }
      return;
    }
    catch (Exception paramMessageRecord) {}
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    a(paramMessageRecord, paramResvAttr);
    return new boolean[] { paramBoolean1, paramBoolean2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.PicMsgSyncQZoneGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */