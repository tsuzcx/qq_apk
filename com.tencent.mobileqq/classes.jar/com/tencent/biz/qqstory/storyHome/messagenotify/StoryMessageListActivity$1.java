package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_del_message.RspDelAllMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class StoryMessageListActivity$1
  extends ProtoUtils.StoryProtocolObserver
{
  StoryMessageListActivity$1(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new qqstory_struct.ErrorInfo();
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      qqstory_710_del_message.RspDelAllMessage localRspDelAllMessage = new qqstory_710_del_message.RspDelAllMessage();
      int j;
      int i;
      try
      {
        localRspDelAllMessage.mergeFrom(paramArrayOfByte);
        if (!localRspDelAllMessage.errinfo.error_code.has()) {
          break label165;
        }
        j = localRspDelAllMessage.errinfo.error_code.get();
        if (j == 0) {
          i = 1;
        } else {
          i = 0;
        }
        try
        {
          paramBundle.error_code.set(localRspDelAllMessage.errinfo.error_code.get());
          paramBundle.error_desc.set(localRspDelAllMessage.errinfo.error_desc.get());
          k = i;
          m = j;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        k = i;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        j = -1;
        i = 0;
      }
      m = j;
      if (!QLog.isColorLevel()) {
        break label171;
      }
      QLog.i("Q.qqstory.msgList", 2, "error parse RspDelAllMessage", paramArrayOfByte);
      k = i;
      m = j;
      break label171;
    }
    label165:
    int m = -1;
    int k = 0;
    label171:
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("receive delete all msg, code=");
      paramArrayOfByte.append(paramInt);
      paramArrayOfByte.append(" bizCode=");
      paramArrayOfByte.append(m);
      QLog.i("Q.qqstory.msgList", 2, paramArrayOfByte.toString());
    }
    if (k == 0) {
      QQToast.makeText(this.d.getApplicationContext(), 1, HardCodeUtil.a(2131911825), 0).show();
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.1
 * JD-Core Version:    0.7.0.1
 */