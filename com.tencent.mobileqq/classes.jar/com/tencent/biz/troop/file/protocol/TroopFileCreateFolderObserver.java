package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.CreateFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RspBody;

public abstract class TroopFileCreateFolderObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, null);
      return;
    }
    paramBundle = new oidb_0x6d7.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d7.CreateFolderRspBody)paramBundle.create_folder_rsp.get();
      if (paramArrayOfByte.int32_ret_code.has())
      {
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0, new TroopFileInfo((group_file_common.FolderInfo)paramArrayOfByte.folder_info.get()));
          return;
        }
        a(false, paramArrayOfByte.int32_ret_code.get(), null);
        return;
      }
      a(false, -1, null);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label103:
      break label103;
    }
    a(false, -1, null);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, TroopFileInfo paramTroopFileInfo);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileCreateFolderObserver
 * JD-Core Version:    0.7.0.1
 */