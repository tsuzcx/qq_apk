package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupDynamicEntrancePicture;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

class TroopAssistantActivity$5
  extends ProtoUtils.StoryProtocolObserver
{
  TroopAssistantActivity$5(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      try
      {
        paramBundle = new qqstory_group.RspGetGroupDynamicEntrancePicture();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)paramBundle.result.get();
        if (paramBundle.cover_url.has())
        {
          paramBundle = paramBundle.cover_url.get().toStringUtf8();
          if (TextUtils.isEmpty(paramBundle))
          {
            if (!QLog.isColorLevel()) {
              break label237;
            }
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append(TroopAssistantActivity.a);
            paramArrayOfByte.append(": picUrl is Empty");
            QLog.i("TroopAssistantActivity", 2, paramArrayOfByte.toString());
            return null;
          }
          this.d.t.setVisibility(0);
          UIUtils.a(this.d.t, paramBundle, 68, 68, 4, UIUtils.h, "TroopStorySnap");
        }
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append(TroopAssistantActivity.a);
          paramBundle.append(" get exception:");
          paramBundle.append(paramArrayOfByte.getMessage());
          QLog.i("TroopAssistantActivity", 2, paramBundle.toString());
        }
        return null;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(TroopAssistantActivity.a);
        paramArrayOfByte.append(" get error:");
        paramArrayOfByte.append(paramInt);
        QLog.i("TroopAssistantActivity", 2, paramArrayOfByte.toString());
      }
      return null;
    }
    label237:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.5
 * JD-Core Version:    0.7.0.1
 */