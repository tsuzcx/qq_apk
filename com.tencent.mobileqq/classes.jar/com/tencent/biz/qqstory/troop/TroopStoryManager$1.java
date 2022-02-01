package com.tencent.biz.qqstory.troop;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupVideoDelete;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class TroopStoryManager$1
  extends ProtoUtils.StoryProtocolObserver
{
  TroopStoryManager$1(TroopStoryManager paramTroopStoryManager) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("troop story revoke result, code=");
      paramBundle.append(paramInt);
      QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new qqstory_group.RspGroupVideoDelete();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)paramBundle.result.get();
        if (paramArrayOfByte.error_code.has())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("revoke rsp.result.error_code=");
          paramBundle.append(paramArrayOfByte.error_code.get());
          QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, paramBundle.toString());
        }
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "parse RspGroupVideoDelete error", paramArrayOfByte);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.TroopStoryManager.1
 * JD-Core Version:    0.7.0.1
 */