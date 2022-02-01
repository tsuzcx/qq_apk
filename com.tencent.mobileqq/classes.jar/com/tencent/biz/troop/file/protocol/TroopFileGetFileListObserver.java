package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody.Item;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.RspBody;

public abstract class TroopFileGetFileListObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject1;
    boolean bool;
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localObject1 = new oidb_0x6d8.RspBody();
      try
      {
        ((oidb_0x6d8.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        if (!((oidb_0x6d8.RspBody)localObject1).file_list_info_rsp.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileProtocol", 2, "no FileList rsp.");
          }
          a(false, false, 0, 0, 0, null, null, paramBundle);
          return;
        }
        localObject1 = (oidb_0x6d8.GetFileListRspBody)((oidb_0x6d8.RspBody)localObject1).file_list_info_rsp.get();
        if (((oidb_0x6d8.GetFileListRspBody)localObject1).int32_ret_code.has())
        {
          int i = ((oidb_0x6d8.GetFileListRspBody)localObject1).int32_ret_code.get();
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("GetFileListObserver, retCode=");
            paramArrayOfByte.append(i);
            QLog.i("TroopFileProtocol", 2, paramArrayOfByte.toString());
          }
          if (i < 0)
          {
            if (i == -1000)
            {
              a(true, false, 0, i, 0, null, null, paramBundle);
              return;
            }
            a(false, false, 0, 0, 0, null, null, paramBundle);
            return;
          }
          i = ((oidb_0x6d8.GetFileListRspBody)localObject1).uint32_all_file_count.get();
          bool = ((oidb_0x6d8.GetFileListRspBody)localObject1).bool_is_end.get();
          int j = ((oidb_0x6d8.GetFileListRspBody)localObject1).uint32_next_index.get();
          paramArrayOfByte = ((oidb_0x6d8.GetFileListRspBody)localObject1).bytes_context.get();
          Object localObject2 = ((oidb_0x6d8.GetFileListRspBody)localObject1).rpt_item_list.get();
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((List)localObject1).add(new TroopFileInfo((oidb_0x6d8.GetFileListRspBody.Item)((Iterator)localObject2).next()));
          }
          a(true, bool, i, paramInt, j, paramArrayOfByte, (List)localObject1, paramBundle);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileProtocol", 2, "GetFileListObserver, has not redCode");
        }
        a(false, false, 0, 0, 0, null, null, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("merge data exception,");
          ((StringBuilder)localObject1).append(paramArrayOfByte.toString());
          QLog.i("TroopFileProtocol", 2, ((StringBuilder)localObject1).toString());
        }
        a(false, false, 0, 0, 0, null, null, paramBundle);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("GetFileListObserver, errorCode=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", has data=");
      if (paramArrayOfByte != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.i("TroopFileProtocol", 2, ((StringBuilder)localObject1).toString());
    }
    a(false, false, 0, 0, 0, null, null, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, ByteStringMicro paramByteStringMicro, List<TroopFileInfo> paramList, Bundle paramBundle);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileGetFileListObserver
 * JD-Core Version:    0.7.0.1
 */