package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.VideoFile;
import msf.msgcomm.msg_comm.Msg;
import org.jetbrains.annotations.NotNull;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.VideoFile;

public class VideoFileElemDecoder
  extends SimplePBElemDecoder
{
  @NotNull
  private MessageForShortVideo a(im_msg_body.GeneralFlags paramGeneralFlags, RichMsg.VideoFile paramVideoFile)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)MessageRecordFactory.a(-2022);
    localMessageForShortVideo.msgtype = -2022;
    localMessageForShortVideo.msgData = paramVideoFile.toByteArray();
    if (paramVideoFile.uint32_busi_type.get() == 2) {
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
    } else {
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {
      try
      {
        babyq_cookie.BabyQCookie localBabyQCookie = new babyq_cookie.BabyQCookie();
        paramVideoFile = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
        localBabyQCookie = (babyq_cookie.BabyQCookie)localBabyQCookie.mergeFrom(paramVideoFile);
        if ((localBabyQCookie.uint32_need_not_report.has()) && (localBabyQCookie.uint32_need_not_report.get() == 0))
        {
          String str = Utils.a(paramVideoFile);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodePBMsgElems_VideoFile, guideMsgCookie: ");
            localStringBuilder.append(str);
            localStringBuilder.append(",bytes: ");
            localStringBuilder.append(Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
            QLog.d("VideoFileElemDecoder", 2, localStringBuilder.toString());
          }
          localMessageForShortVideo.saveExtInfoToExtStr("guide_msg_cookie", str);
        }
        if (localBabyQCookie.uint32_video_type.has())
        {
          int i = localBabyQCookie.uint32_video_type.get();
          if (QLog.isColorLevel())
          {
            paramGeneralFlags = new StringBuilder();
            paramGeneralFlags.append("decodePBMsgElems_VideoFile, video_type: ");
            paramGeneralFlags.append(i);
            QLog.d("VideoFileElemDecoder", 2, paramGeneralFlags.toString());
          }
          localMessageForShortVideo.saveExtInfoToExtStr("guide_video_type", String.valueOf(i));
        }
        ((BabyQHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(paramVideoFile);
      }
      catch (Exception paramGeneralFlags)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFileElemDecoder", 2, "get video guideMsgCookie error!", paramGeneralFlags);
        }
      }
    }
    localMessageForShortVideo.parse();
    return localMessageForShortVideo;
  }
  
  @NotNull
  private RichMsg.VideoFile a(im_msg_body.VideoFile paramVideoFile, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    localVideoFile.setHasFlag(true);
    localVideoFile.bytes_file_name.set(paramVideoFile.bytes_file_name.get());
    localVideoFile.bytes_file_md5.set(paramVideoFile.bytes_file_md5.get());
    localVideoFile.bytes_file_uuid.set(paramVideoFile.bytes_file_uuid.get());
    localVideoFile.uint32_file_format.set(paramVideoFile.uint32_file_format.get());
    localVideoFile.uint32_file_size.set(paramVideoFile.uint32_file_size.get());
    localVideoFile.uint32_file_time.set(paramVideoFile.uint32_file_time.get());
    localVideoFile.uint32_thumb_width.set(paramVideoFile.uint32_thumb_width.get());
    localVideoFile.uint32_thumb_height.set(paramVideoFile.uint32_thumb_height.get());
    localVideoFile.uint32_file_status.set(2008);
    localVideoFile.uint32_file_progress.set(0);
    localVideoFile.bytes_thumb_file_md5.set(paramVideoFile.bytes_thumb_file_md5.get());
    localVideoFile.bytes_source.set(paramVideoFile.bytes_source.get());
    localVideoFile.uint32_thumb_file_size.set(paramVideoFile.uint32_thumb_file_size.get());
    localVideoFile.uint32_busi_type.set(paramVideoFile.uint32_busi_type.get());
    localVideoFile.uin32_from_chat_type.set(paramVideoFile.uint32_from_chat_type.get());
    localVideoFile.uin32_to_chat_type.set(paramVideoFile.uint32_to_chat_type.get());
    localVideoFile.bool_support_progressive.set(paramVideoFile.bool_support_progressive.get());
    localVideoFile.uint32_file_width.set(paramVideoFile.uint32_file_width.get());
    localVideoFile.uint32_file_height.set(paramVideoFile.uint32_file_height.get());
    localVideoFile.uint32_sub_busi_type.set(paramVideoFile.uint32_sub_busi_type.get());
    localVideoFile.uint32_video_attr.set(paramVideoFile.uint32_video_attr.get());
    if (paramVideoFile.bytes_pb_reserve.has())
    {
      videoFile.ResvAttr localResvAttr = new videoFile.ResvAttr();
      try
      {
        localResvAttr.mergeFrom(paramVideoFile.bytes_pb_reserve.get().toByteArray());
        localVideoFile.bytes_hotvideo_icon.set(localResvAttr.bytes_hotvideo_icon.get());
        localVideoFile.bytes_hotvideo_icon_sub.set(localResvAttr.bytes_hotvideo_icon_sub.get());
        localVideoFile.bytes_hotvideo_title.set(localResvAttr.bytes_hotvideo_title.get());
        localVideoFile.bytes_hotvideo_url.set(localResvAttr.bytes_hotvideo_url.get());
        localVideoFile.uint32_special_video_type.set(localResvAttr.uint32_special_video_type.get());
        localVideoFile.uint32_msg_tail_type.set(localResvAttr.uint32_msg_tail_type.get());
        localVideoFile.uint32_long_video_kandian_type.set(localResvAttr.uint32_long_video_kandian_type.get());
        if (localResvAttr.bytes_camera_templateid.has()) {
          localVideoFile.bytes_camera_video_templateid.set(localResvAttr.bytes_camera_templateid.get());
        }
        if (localResvAttr.bytes_camera_templateName.has()) {
          localVideoFile.bytes_camera_video_templatename.set(localResvAttr.bytes_camera_templateName.get());
        }
      }
      catch (InvalidProtocolBufferMicroException paramVideoFile)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFileElemDecoder", 2, "ShortVideo doParse error!", paramVideoFile);
        }
      }
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has()))
    {
      paramVideoFile = new generalflags.ResvAttr();
      try
      {
        paramVideoFile.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        localVideoFile.uint32_red_envelope_type.set(paramVideoFile.uint32_red_envelope_type.get());
        localVideoFile.bytes_shortVideoId.set(paramVideoFile.bytes_shortVideoId.get());
        return localVideoFile;
      }
      catch (Exception paramVideoFile)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFileElemDecoder", 2, "ShortVideo doParse generalFlag error!", paramVideoFile);
        }
      }
    }
    return localVideoFile;
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    Object localObject1 = null;
    paramList = null;
    int k = 0;
    int i = -1;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      Object localObject2 = localObject1;
      if (localElem.video_file.has()) {
        localObject2 = (im_msg_body.VideoFile)localElem.video_file.get();
      }
      int m = k;
      int j = i;
      if (localElem.bless_msg.has())
      {
        m = k;
        j = i;
        if (localElem.bless_msg.uint32_msg_type.get() == 1)
        {
          if (localElem.bless_msg.uint32_ex_flag.has()) {
            i = localElem.bless_msg.uint32_ex_flag.get();
          }
          m = 1;
          j = i;
        }
      }
      localObject1 = localObject2;
      k = m;
      i = j;
      if (localElem.general_flags.has())
      {
        paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        localObject1 = localObject2;
        k = m;
        i = j;
      }
    }
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:video_file;\n");
    }
    paramList = a(paramList, a(localObject1, paramList));
    paramList1.add(paramList);
    if (k != 0)
    {
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("decodePBMsgElems, isBlessMsg: true ,updateFlag: ");
        paramList1.append(i);
        QLog.d("VideoFileElemDecoder", 2, paramList1.toString());
      }
      paramList.isBlessMsg = true;
      if (i > -1)
      {
        if ((i & 0x1) == 1) {
          bool = true;
        }
        paramList.needUpdateMsgTag = bool;
      }
    }
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append("ShortVideo.msg: ");
      paramList1 = new StringBuilder();
      paramList1.append(paramList.toString());
      paramList1.append("\n");
      paramList1.append(paramList.toLogString());
      paramStringBuilder.append(paramList1.toString());
      paramStringBuilder.append("\n");
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
    return paramElem.video_file.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.VideoFileElemDecoder
 * JD-Core Version:    0.7.0.1
 */