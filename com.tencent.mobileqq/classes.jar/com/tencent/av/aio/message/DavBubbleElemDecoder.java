package com.tencent.av.aio.message;

import android.text.TextUtils;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.SimplePBElemDecoder;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.cs.longconn.c2c_av_terminate_msg_ext.C2CAVTerminateMsgExt;
import tencent.im.msg.hummer.resv.generalflags.PassThrough;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class DavBubbleElemDecoder
  extends SimplePBElemDecoder
{
  private MessageForVideo a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord, c2c_av_terminate_msg_ext.C2CAVTerminateMsgExt paramC2CAVTerminateMsgExt)
  {
    paramElem = new MessageForVideo();
    MessageRecord.copyMessageRecordBaseField(paramElem, paramMessageRecord);
    int i;
    if (paramC2CAVTerminateMsgExt.has_switched.get() == true) {
      i = 1;
    } else {
      i = 0;
    }
    a(paramElem, paramC2CAVTerminateMsgExt.room_id.get(), paramC2CAVTerminateMsgExt.reason.get(), paramC2CAVTerminateMsgExt.logout_ts.get(), paramC2CAVTerminateMsgExt.buss_flag.get(), i);
    return paramElem;
  }
  
  private void a(MessageForVideo paramMessageForVideo, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    paramMessageForVideo.roomId = paramLong1;
    paramMessageForVideo.hungUpReason = paramLong2;
    paramMessageForVideo.hungUpMs = paramLong3;
    paramMessageForVideo.businessFlag = paramLong4;
    paramMessageForVideo.switchFlag = paramInt;
    paramMessageForVideo.saveExtInfoToExtStr("dav_bubble_room_id", String.valueOf(paramLong1));
    paramMessageForVideo.saveExtInfoToExtStr("dav_bubble_hung_up_reason", String.valueOf(paramLong2));
    paramMessageForVideo.saveExtInfoToExtStr("dav_bubble_hung_up_time", String.valueOf(paramLong3));
    paramMessageForVideo.saveExtInfoToExtStr("dav_bubble_business_flag", String.valueOf(paramLong4));
    paramMessageForVideo.saveExtInfoToExtStr("dav_bubble_switch_flag", String.valueOf(paramInt));
    paramMessageForVideo.msgtype = -2009;
    paramMessageForVideo.extraflag = 3;
    paramMessageForVideo.isread = true;
    boolean bool2 = TextUtils.equals(paramMessageForVideo.selfuin, paramMessageForVideo.senderuin);
    boolean bool1 = false;
    int i;
    if (bool2) {
      i = 0;
    } else {
      i = 2;
    }
    Object localObject = paramMessageForVideo.msg;
    paramLong1 = i;
    if (paramLong4 == 2L) {
      bool1 = true;
    }
    paramMessageForVideo.msg = TransfileUtile.makeTransFileProtocolData((String)localObject, paramLong1, 3, bool1);
    if ((QLog.isColorLevel()) || (QLog.isDebugVersion()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[decodeDavBubbleMsg] ");
      ((StringBuilder)localObject).append(paramMessageForVideo.msg);
      ((StringBuilder)localObject).append("[msg.business flag]");
      ((StringBuilder)localObject).append(paramLong4);
      ((StringBuilder)localObject).append("[switchFlag flag]");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("[msg.selfuin ]");
      ((StringBuilder)localObject).append(paramMessageForVideo.selfuin);
      ((StringBuilder)localObject).append("[msg.senderuin ]");
      ((StringBuilder)localObject).append(paramMessageForVideo.senderuin);
      QLog.d("DavBubbleElemDecoder", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean a(im_msg_body.Elem paramElem, List<MessageRecord> paramList, c2c_av_terminate_msg_ext.C2CAVTerminateMsgExt paramC2CAVTerminateMsgExt)
  {
    if ((paramElem != null) && (paramList != null) && (paramList.size() != 0))
    {
      if ((QLog.isColorLevel()) && (paramList.size() != 1))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[decodeDavBubbleMsg] ");
          localStringBuilder.append(localMessageRecord.toString());
          QLog.d("DavBubbleElemDecoder", 1, localStringBuilder.toString());
        }
      }
      paramList.set(0, a(paramElem, (MessageRecord)paramList.get(0), paramC2CAVTerminateMsgExt));
      return true;
    }
    paramC2CAVTerminateMsgExt = new StringBuilder();
    paramC2CAVTerminateMsgExt.append("[decodeDavBubbleMsg] elem: ");
    paramC2CAVTerminateMsgExt.append(paramElem);
    paramC2CAVTerminateMsgExt.append(", message: ");
    paramC2CAVTerminateMsgExt.append(paramList);
    QLog.e("DavBubbleElemDecoder", 1, paramC2CAVTerminateMsgExt.toString());
    return false;
  }
  
  public static boolean a(im_msg_body.Elem paramElem, c2c_av_terminate_msg_ext.C2CAVTerminateMsgExt paramC2CAVTerminateMsgExt)
  {
    int i;
    if ((paramElem.general_flags.has()) && (paramElem.general_flags.bytes_pb_reserve.has())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
    try
    {
      localResvAttr.mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
      if (!localResvAttr.pass_through.has()) {
        return false;
      }
      if (!localResvAttr.pass_through.bytes_av_terminate_ext.has()) {
        return false;
      }
      if (paramC2CAVTerminateMsgExt == null) {
        paramC2CAVTerminateMsgExt = new c2c_av_terminate_msg_ext.C2CAVTerminateMsgExt();
      }
      if (paramC2CAVTerminateMsgExt != null) {
        try
        {
          paramC2CAVTerminateMsgExt.mergeFrom(localResvAttr.pass_through.bytes_av_terminate_ext.get().toByteArray());
          return true;
        }
        catch (InvalidProtocolBufferMicroException paramElem)
        {
          paramElem.printStackTrace();
        }
      }
      return false;
    }
    catch (InvalidProtocolBufferMicroException paramElem)
    {
      paramElem.printStackTrace();
    }
    return false;
  }
  
  public int a()
  {
    return -1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (paramList1 == null) {
      return false;
    }
    paramMsg = new c2c_av_terminate_msg_ext.C2CAVTerminateMsgExt();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
      if ((a(paramStringBuilder, paramMsg)) && (a(paramStringBuilder, paramList1, paramMsg))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return a(paramElem, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.aio.message.DavBubbleElemDecoder
 * JD-Core Version:    0.7.0.1
 */