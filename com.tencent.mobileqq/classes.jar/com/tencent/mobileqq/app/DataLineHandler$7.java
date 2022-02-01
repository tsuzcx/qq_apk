package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

class DataLineHandler$7
  implements Runnable
{
  DataLineHandler$7(DataLineHandler paramDataLineHandler, FromServiceMsg paramFromServiceMsg, int paramInt, long paramLong, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    Object localObject2 = new cmd0x346.RspBody();
    Object localObject3 = this.a;
    if (localObject3 != null)
    {
      byte[] arrayOfByte = null;
      if (((FromServiceMsg)localObject3).getWupBuffer() != null)
      {
        i = this.a.getWupBuffer().length - 4;
        if (i >= 0)
        {
          arrayOfByte = new byte[i];
          PkgTools.copyData(arrayOfByte, 0, this.a.getWupBuffer(), 4, i);
        }
      }
      else if (arrayOfByte != null)
      {
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(arrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
    int i = ((cmd0x346.RspBody)localObject2).msg_file_query_rsp.int32_ret_code.get();
    Object localObject1 = this.this$0.i.getMessageFacade().d(this.b).a(this.c);
    if (i == 0)
    {
      ((cmd0x346.RspBody)localObject2).msg_file_query_rsp.msg_file_info.str_file_name.get();
      ((cmd0x346.RspBody)localObject2).msg_file_query_rsp.msg_file_info.uint64_file_size.get();
      localObject2 = ((cmd0x346.RspBody)localObject2).msg_file_query_rsp.msg_file_info.bytes_10m_md5.get().toByteArray();
      localObject3 = this.d.getAttribute("data");
      if ((localObject3 != null) && ((localObject3 instanceof Bundle)))
      {
        localObject3 = (Bundle)localObject3;
        if (((Bundle)localObject3).getBoolean("newAssistant", false))
        {
          localObject1 = ((Bundle)localObject3).getString("fileKey");
          this.this$0.i.getFileTransferHandler().a(this.c, (byte[])localObject2, (String)localObject1);
          return;
        }
      }
      if (localObject1 == null) {
        return;
      }
      ((DataLineMsgRecord)localObject1).md5 = ((byte[])localObject2);
      this.this$0.i.getMessageFacade().d(this.b).a(((DataLineMsgRecord)localObject1).msgId, ((DataLineMsgRecord)localObject1).serverPath, ((DataLineMsgRecord)localObject1).md5);
      this.this$0.b((DataLineMsgRecord)localObject1);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("query file md5 return error:");
    ((StringBuilder)localObject2).append(i);
    QLog.e("DatalineHandler<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    if (localObject1 == null) {
      return;
    }
    DataLineHandler.a(this.this$0, (DataLineMsgRecord)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.7
 * JD-Core Version:    0.7.0.1
 */