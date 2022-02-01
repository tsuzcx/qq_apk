package com.tencent.biz.TroopRedpoint;

import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ClearMessageResult;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.RspClearMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class TroopRedTouchHandler$6
  implements BusinessObserver
{
  TroopRedTouchHandler$6(TroopRedTouchHandler paramTroopRedTouchHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearStoryMessageRedPoint receive isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopRedTouchHandler", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = 0L;
    int i = -1;
    if (paramBoolean)
    {
      try
      {
        localObject = paramBundle.getByteArray("data");
        if (localObject != null)
        {
          paramBundle = new qqstory_710_message.RspClearMessage();
          paramBundle.mergeFrom((byte[])localObject);
          paramInt = paramBundle.remain_num.get();
          long l2 = l1;
          try
          {
            l1 = paramBundle.image_uid.get();
            l2 = l1;
            int j = paramBundle.last_time.get();
            try
            {
              localObject = (qqstory_710_message.ClearMessageResult)paramBundle.msg_tab.get();
              paramBundle = (qqstory_710_message.ClearMessageResult)paramBundle.msg_dynamic.get();
              paramBoolean = true;
              i = j;
            }
            catch (InvalidProtocolBufferMicroException paramBundle)
            {
              paramBoolean = true;
              i = j;
              break label180;
            }
            paramBoolean = false;
          }
          catch (InvalidProtocolBufferMicroException paramBundle)
          {
            l1 = l2;
            paramBoolean = false;
          }
        }
        else
        {
          paramInt = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        l1 = 0L;
        paramBoolean = false;
        paramInt = 0;
        label180:
        if (QLog.isColorLevel()) {
          QLog.d("TroopRedTouchHandler", 2, "parse RspClearMessage error", paramBundle);
        }
      }
    }
    else
    {
      l1 = 0L;
      paramBoolean = false;
      paramInt = 0;
      i = -1;
    }
    paramBundle = (TroopRedTouchManager)TroopRedTouchHandler.a(this.a).getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateStoryMessageFromSvr:succ=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" num=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" time=");
      ((StringBuilder)localObject).append(i);
      QLog.i("storyRedDotDebug", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if (paramInt > 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramBundle.a(paramBoolean, paramInt, l1, i, 52);
    }
    else
    {
      this.a.a(paramBundle, 52);
    }
    this.a.notifyUI(105, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.6
 * JD-Core Version:    0.7.0.1
 */