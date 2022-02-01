package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NearbyChatPie$11
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyChatPie$11(NearbyChatPie paramNearbyChatPie) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("errorCode = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], bundle = [");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("]");
      QLog.i("NearbyChatPie", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
      boolean bool = true;
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        localObject = this.a.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pb parse error: ");
        localStringBuilder.append(paramArrayOfByte);
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
      paramInt = paramBundle.ret_code.get();
      paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
      int i = paramBundle.status.get();
      paramBundle = new StringBuilder();
      paramBundle.append("ret_code: ");
      paramBundle.append(paramInt);
      paramBundle.append(", err_msg: ");
      paramBundle.append(paramArrayOfByte);
      paramBundle.append(", status: ");
      paramBundle.append(i);
      QLog.i("NearbyChatPie", 1, paramBundle.toString());
      if (paramInt == 0)
      {
        paramArrayOfByte = this.a;
        if (i == 0) {
          bool = false;
        }
        paramArrayOfByte.J = bool;
      }
    }
    this.a.b().post(new NearbyChatPie.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.11
 * JD-Core Version:    0.7.0.1
 */