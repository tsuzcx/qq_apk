package com.tencent.av.wtogether.handler;

import android.os.Bundle;
import com.tencent.av.wtogether.observer.WatchTogetherObserver;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody.Item;
import tencent.im.cs.cmd0x383.cmd0x383.ReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class WatchTogetherHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public WatchTogetherHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public void a(long paramLong, ByteStringMicro paramByteStringMicro)
  {
    Object localObject = new cmd0x383.ApplyFileSearchReqBody();
    ByteStringMicro localByteStringMicro = paramByteStringMicro;
    if (paramByteStringMicro == null) {
      localByteStringMicro = ByteStringMicro.copyFromUtf8("");
    }
    ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_sync_cookie.set(localByteStringMicro);
    ((cmd0x383.ApplyFileSearchReqBody)localObject).uint32_count.set(20);
    ((cmd0x383.ApplyFileSearchReqBody)localObject).uint32_search_type.set(2);
    ((cmd0x383.ApplyFileSearchReqBody)localObject).uint32_file_type.set(2);
    paramByteStringMicro = new cmd0x383.ReqBody();
    paramByteStringMicro.uint64_groupcode.set(paramLong);
    paramByteStringMicro.uint32_app_id.set(3);
    paramByteStringMicro.msg_file_search_req_body.set((MessageMicro)localObject);
    paramByteStringMicro.setHasFlag(true);
    localObject = createToServiceMsg("GroupFileAppSvr.GetFileSearch");
    ((ToServiceMsg)localObject).putWupBuffer(paramByteStringMicro.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("troopUin", paramLong);
    ((ToServiceMsg)localObject).extraData.putString("cookie", localByteStringMicro.toStringUtf8());
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("WatchTogetherHandler", 2, String.format("queryGroupAVFileList() troopUin=%d cookie=%s", new Object[] { Long.valueOf(paramLong), localByteStringMicro }));
    }
  }
  
  public void a(long paramLong, ByteStringMicro paramByteStringMicro, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return;
      }
      Object localObject = new cmd0x383.ApplyFileSearchReqBody();
      ByteStringMicro localByteStringMicro = paramByteStringMicro;
      if (paramByteStringMicro == null) {
        localByteStringMicro = ByteStringMicro.copyFromUtf8("");
      }
      ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_sync_cookie.set(localByteStringMicro);
      ((cmd0x383.ApplyFileSearchReqBody)localObject).uint32_count.set(20);
      ((cmd0x383.ApplyFileSearchReqBody)localObject).uint32_search_type.set(3);
      ((cmd0x383.ApplyFileSearchReqBody)localObject).bytes_key_word.set(ByteStringMicro.copyFromUtf8(paramString));
      paramByteStringMicro = new cmd0x383.ReqBody();
      paramByteStringMicro.uint64_groupcode.set(paramLong);
      paramByteStringMicro.uint32_app_id.set(3);
      paramByteStringMicro.msg_file_search_req_body.set((MessageMicro)localObject);
      paramByteStringMicro.setHasFlag(true);
      localObject = createToServiceMsg("GroupFileAppSvr.GetFileSearch");
      ((ToServiceMsg)localObject).putWupBuffer(paramByteStringMicro.toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("troopUin", paramLong);
      ((ToServiceMsg)localObject).extraData.putString("cookie", localByteStringMicro.toStringUtf8());
      ((ToServiceMsg)localObject).extraData.putString("keywords", paramString);
      sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("WatchTogetherHandler", 2, String.format("queryGroupAVFileListWithKeywords() troopUin=%d cookie=%s keywords=%s", new Object[] { Long.valueOf(paramLong), localByteStringMicro, paramString }));
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0)
    {
      paramFromServiceMsg = new cmd0x383.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGroupAVFileList(): ");
        paramObject.append(paramToServiceMsg);
        QLog.e("WatchTogetherHandler", 1, paramObject.toString());
        i = 0;
      }
      paramToServiceMsg = paramFromServiceMsg;
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.i("WatchTogetherHandler", 2, "handleGroupAVFileList receive success");
        paramToServiceMsg = paramFromServiceMsg;
        j = i;
      }
    }
    else
    {
      paramToServiceMsg = null;
      j = i;
    }
    if (j == 0)
    {
      notifyUI(1, false, null);
      QLog.e("WatchTogetherHandler", 2, "handleGroupAVFileList() failed");
      notifyUI(1, false, null);
      return;
    }
    if (paramToServiceMsg.int32_ret_code.get() >= 0)
    {
      paramObject = (cmd0x383.ApplyFileSearchRspBody)paramToServiceMsg.msg_file_search_rsp_body.get();
      if (paramObject == null)
      {
        QLog.e("WatchTogetherHandler", 2, "handleGroupAVFileList() empty respond");
        notifyUI(1, false, null);
        return;
      }
      paramToServiceMsg = paramObject.bytes_sync_cookie.get().toStringUtf8();
      paramFromServiceMsg = paramObject.bytes_key_word.get().toStringUtf8();
      j = paramObject.uint32_is_end.get();
      int k = paramObject.uint32_total_match_count.get();
      paramObject = paramObject.item_list.get();
      if ((paramObject != null) && (paramObject.size() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < paramObject.size())
        {
          TroopFileSearchItemData localTroopFileSearchItemData = new TroopFileSearchItemData(this.a, (cmd0x383.ApplyFileSearchRspBody.Item)paramObject.get(i));
          Object localObject;
          if (localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo != null)
          {
            localObject = TroopFileManager.a(this.a, localTroopFileSearchItemData.jdField_a_of_type_Long);
            TroopFileInfo localTroopFileInfo = ((TroopFileManager)localObject).a(localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b);
            if (localTroopFileInfo != null) {
              localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a = localTroopFileInfo.a;
            } else {
              localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a = UUID.randomUUID();
            }
            ((TroopFileManager)localObject).a(localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b, localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("fileList[");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append("]: ");
            ((StringBuilder)localObject).append(localTroopFileSearchItemData.toString());
            QLog.i("WatchTogetherHandler", 2, ((StringBuilder)localObject).toString());
          }
          localArrayList.add(localTroopFileSearchItemData);
          i += 1;
        }
        notifyUI(1, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k), localArrayList });
        if (QLog.isColorLevel()) {
          QLog.i("WatchTogetherHandler", 2, String.format("handleGroupAVFileList() success[cookie : %s, keywords : %s, isEnd : %d, totalMatchCount : %d]", new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k) }));
        }
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.d("WatchTogetherHandler", 2, "handleGroupAVFileList() empty file list");
        notifyUI(1, false, null);
      }
    }
    else
    {
      notifyUI(1, false, new Object[] { Integer.valueOf(paramToServiceMsg.int32_ret_code.get()), paramToServiceMsg.str_ret_msg.get() });
      QLog.e("WatchTogetherHandler", 2, String.format("handleGroupAVFileList(), errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramToServiceMsg.int32_ret_code.get()), paramToServiceMsg.str_ret_msg.get() }));
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("GroupFileAppSvr.GetFileSearch");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return WatchTogetherObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ("GroupFileAppSvr.GetFileSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.handler.WatchTogetherHandler
 * JD-Core Version:    0.7.0.1
 */