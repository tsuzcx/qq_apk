package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RenameFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RspBody;

public abstract class TroopFileProtocol$RenameFolderObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    String str;
    if (paramBundle != null) {
      str = paramBundle.getString("folderId");
    }
    for (paramBundle = paramBundle.getString("folderName");; paramBundle = "")
    {
      if (paramInt != 0)
      {
        a(false, paramInt, str, paramBundle);
        return;
      }
      oidb_0x6d7.RspBody localRspBody = new oidb_0x6d7.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d7.RenameFolderRspBody)localRspBody.rename_folder_rsp.get();
        if (!paramArrayOfByte.int32_ret_code.has()) {
          break label118;
        }
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0, str, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, str, paramBundle);
        return;
      }
      a(false, paramArrayOfByte.int32_ret_code.get(), str, paramBundle);
      return;
      label118:
      a(false, -1, str, paramBundle);
      return;
      str = "";
    }
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol.RenameFolderObserver
 * JD-Core Version:    0.7.0.1
 */