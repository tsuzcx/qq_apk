package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RenameFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RspBody;

public abstract class TroopFileRenameFolderObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject2 = "";
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("folderId");
      localObject2 = paramBundle.getString("folderName");
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = "";
      paramBundle = (Bundle)localObject2;
    }
    if (paramInt != 0)
    {
      a(false, paramInt, paramBundle, (String)localObject1);
      return;
    }
    localObject2 = new oidb_0x6d7.RspBody();
    try
    {
      ((oidb_0x6d7.RspBody)localObject2).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d7.RenameFolderRspBody)((oidb_0x6d7.RspBody)localObject2).rename_folder_rsp.get();
      if (paramArrayOfByte.int32_ret_code.has())
      {
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0, paramBundle, (String)localObject1);
          return;
        }
        a(false, paramArrayOfByte.int32_ret_code.get(), paramBundle, (String)localObject1);
        return;
      }
      a(false, -1, paramBundle, (String)localObject1);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label139:
      break label139;
    }
    a(false, -1, paramBundle, (String)localObject1);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileRenameFolderObserver
 * JD-Core Version:    0.7.0.1
 */