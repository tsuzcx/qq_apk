package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;

public class GroupFileElemDecoder
  extends SimplePBElemDecoder
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = localQQAppInterface.getMsgHandler();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (im_msg_body.Elem)paramList.next();
      if (((im_msg_body.Elem)localObject2).group_file.has())
      {
        paramList = (im_msg_body.GroupFile)((im_msg_body.Elem)localObject2).group_file.get();
        break label73;
      }
    }
    paramList = null;
    label73:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:GroupFile;\n");
    }
    paramStringBuilder = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (paramStringBuilder.discuss_info.has()) {
      l1 = ((msg_comm.DiscussInfo)paramStringBuilder.discuss_info.get()).discuss_uin.get();
    } else {
      l1 = 0L;
    }
    long l3 = paramStringBuilder.from_uin.get();
    long l5 = paramStringBuilder.msg_time.get();
    long l6 = paramStringBuilder.msg_seq.get();
    long l4 = ((MessageHandler)localObject1).a.getLongAccountUin();
    if (MessageHandlerUtils.a(((MessageHandler)localObject1).a, 3000, String.valueOf(l1), String.valueOf(l3), l5, l6)) {
      return;
    }
    try
    {
      paramStringBuilder = new String(paramList.bytes_filename.get().toByteArray(), "UTF-8");
    }
    catch (UnsupportedEncodingException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
      paramStringBuilder = "";
    }
    if (paramMsg.msg_body.has())
    {
      paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
      if (paramMsg.rich_text.attr.has())
      {
        l2 = MessageUtils.a(((im_msg_body.Attr)paramMsg.rich_text.attr.get()).random.get());
        break label305;
      }
    }
    long l2 = 0L;
    label305:
    paramMsg = (MessageForFile)MessageRecordFactory.a(-2005);
    paramMsg.msgtype = -2005;
    if (paramList.bytes_pb_reserve.has())
    {
      localObject2 = new hummer_resv_21.ResvAttr();
      try
      {
        ((hummer_resv_21.ResvAttr)localObject2).mergeFrom(paramList.bytes_pb_reserve.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      if (((hummer_resv_21.ResvAttr)localObject2).file_image_info.has())
      {
        i = ((hummer_resv_21.ResvAttr)localObject2).file_image_info.uint32_file_height.get();
        j = ((hummer_resv_21.ResvAttr)localObject2).file_image_info.uint32_file_width.get();
        paramMsg.saveExtInfoToExtStr("file_pic_width", String.valueOf(j));
        paramMsg.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(i));
        break label439;
      }
    }
    int j = 0;
    int i = 0;
    label439:
    paramMsg.uniseq = ((MessageHandler)localObject1).a.getFileTransferHandler().a(paramMsg.uniseq, l1, l3, l6, l2, l5, paramList, j, i);
    long l1 = paramList.uint64_file_size.get();
    boolean bool;
    if (l3 == l4) {
      bool = true;
    } else {
      bool = false;
    }
    paramMsg.msg = TransfileUtile.makeTransFileProtocolData(paramStringBuilder, l1, 0, bool);
    paramMsg.doParse();
    try
    {
      paramMsg.fileName = FileManagerUtil.a(new String(paramList.bytes_filename.get().toByteArray(), "UTF-8"));
    }
    catch (UnsupportedEncodingException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("internalDiscOfflineFile: Exception is ");
      ((StringBuilder)localObject1).append(paramStringBuilder.toString());
      QLog.e("GroupFileElemDecoder", 1, ((StringBuilder)localObject1).toString());
    }
    paramList1.add(paramMsg);
    ((AIOMessageSpreadManager)localQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(paramMsg);
    if (QLog.isColorLevel())
    {
      paramList1 = new StringBuilder();
      paramList1.append("GroupDiscFile.msg: ");
      paramList1.append(paramList.bytes_filename.get());
      paramList1.append(";");
      QLog.d("GroupFileElemDecoder", 2, paramList1.toString());
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramList, paramList1, paramStringBuilder, paramMsg);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.group_file.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.GroupFileElemDecoder
 * JD-Core Version:    0.7.0.1
 */