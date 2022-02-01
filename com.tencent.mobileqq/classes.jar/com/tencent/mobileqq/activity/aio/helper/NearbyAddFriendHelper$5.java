package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyContext;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;

class NearbyAddFriendHelper$5
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyAddFriendHelper$5(NearbyAddFriendHelper paramNearbyAddFriendHelper) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], bundle = [");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("]");
      QLog.i("NearbyAddFriendHelper", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pb parse error: ");
        localStringBuilder.append(paramArrayOfByte);
        QLog.e("NearbyAddFriendHelper", 1, localStringBuilder.toString());
      }
      paramInt = paramBundle.ret_code.get();
      paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
      paramBundle = new StringBuilder();
      paramBundle.append("ret_code: ");
      paramBundle.append(paramInt);
      paramBundle.append(", err_msg: ");
      paramBundle.append(paramArrayOfByte);
      QLog.i("NearbyAddFriendHelper", 1, paramBundle.toString());
      if (paramInt != 0)
      {
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          QQToast.makeText(this.a.d, 1, paramArrayOfByte, 0).show(this.a.a.v());
          paramBundle = new StringBuilder();
          paramBundle.append("sendOperateFollowUser,targetUin:");
          paramBundle.append(this.a.e.b);
          paramBundle.append(", op:");
          paramBundle.append("1");
          paramBundle.append(", errMsg:");
          paramBundle.append(paramArrayOfByte);
          QLog.d("NearbyAddFriendHelperQ.nearby.follow", 2, paramBundle.toString());
          return;
        }
        QQToast.makeText(this.a.c, 1, HardCodeUtil.a(2131905117), 1).show();
      }
      else
      {
        QQToast.makeText(this.a.d, 2, this.a.d.getString(2131892070), 0).show(this.a.a.v());
        bool = true;
        break label365;
      }
    }
    boolean bool = false;
    label365:
    if (!bool) {
      QQToast.makeText(this.a.d, 1, this.a.d.getString(2131892069), 0).show(this.a.a.v());
    }
    if (((NearbyContext)this.a.a).R() != bool)
    {
      ((NearbyContext)this.a.a).d(bool);
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper.5
 * JD-Core Version:    0.7.0.1
 */