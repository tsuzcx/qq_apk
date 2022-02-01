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
    int i;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg == null)
    {
      i = ((cmd0x346.RspBody)localObject2).msg_file_query_rsp.int32_ret_code.get();
      localObject1 = this.this$0.a.getMessageFacade().a(this.jdField_a_of_type_Int).a(this.jdField_a_of_type_Long);
      if (i != 0) {
        break label286;
      }
      ((cmd0x346.RspBody)localObject2).msg_file_query_rsp.msg_file_info.str_file_name.get();
      ((cmd0x346.RspBody)localObject2).msg_file_query_rsp.msg_file_info.uint64_file_size.get();
      localObject2 = ((cmd0x346.RspBody)localObject2).msg_file_query_rsp.msg_file_info.bytes_10m_md5.get().toByteArray();
      Object localObject3 = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("data");
      if ((localObject3 == null) || (!(localObject3 instanceof Bundle))) {
        break label236;
      }
      localObject3 = (Bundle)localObject3;
      if (!((Bundle)localObject3).getBoolean("newAssistant", false)) {
        break label236;
      }
      localObject1 = ((Bundle)localObject3).getString("fileKey");
      this.this$0.a.getFileTransferHandler().a(this.jdField_a_of_type_Long, (byte[])localObject2, (String)localObject1);
    }
    label236:
    do
    {
      do
      {
        for (;;)
        {
          return;
          localObject1 = null;
          if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer() != null)
          {
            i = this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer().length - 4;
            if (i < 0) {
              break;
            }
            localObject1 = new byte[i];
            PkgTools.copyData((byte[])localObject1, 0, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer(), 4, i);
          }
          if (localObject1 == null) {
            break;
          }
          try
          {
            ((cmd0x346.RspBody)localObject2).mergeFrom((byte[])localObject1);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
        break;
      } while (localInvalidProtocolBufferMicroException == null);
      localInvalidProtocolBufferMicroException.md5 = ((byte[])localObject2);
      this.this$0.a.getMessageFacade().a(this.jdField_a_of_type_Int).a(localInvalidProtocolBufferMicroException.msgId, localInvalidProtocolBufferMicroException.serverPath, localInvalidProtocolBufferMicroException.md5);
      this.this$0.a(localInvalidProtocolBufferMicroException);
      return;
      QLog.e("DatalineHandler<FileAssistant>", 1, "query file md5 return error:" + i);
    } while (localInvalidProtocolBufferMicroException == null);
    label286:
    DataLineHandler.a(this.this$0, localInvalidProtocolBufferMicroException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.7
 * JD-Core Version:    0.7.0.1
 */