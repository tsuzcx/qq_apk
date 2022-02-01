package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;

class NearbyChatPie$5
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyChatPie$5(NearbyChatPie paramNearbyChatPie) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.b, 2, "errorCode = [" + paramInt + "], bundle = [" + paramBundle + "]");
    }
    boolean bool;
    if (paramInt == 0)
    {
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.ret_code.get();
        paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
        QLog.i(this.a.b, 1, "ret_code: " + paramInt + ", err_msg: " + paramArrayOfByte);
        if (paramInt != 0) {
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramArrayOfByte, 0).b(this.a.a());
            QLog.d(this.a.b + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + ", op:" + "1" + ", errMsg:" + paramArrayOfByte);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          QLog.e(this.a.b, 1, "pb parse error: " + paramArrayOfByte);
        }
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, HardCodeUtil.a(2131707267), 1).a();
        bool = false;
      }
    }
    for (;;)
    {
      if (!bool) {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, this.a.jdField_a_of_type_AndroidContentContext.getString(2131694425), 0).b(this.a.a());
      }
      if (this.a.T == bool) {
        break;
      }
      this.a.T = bool;
      this.a.p();
      return;
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, this.a.jdField_a_of_type_AndroidContentContext.getString(2131694426), 0).b(this.a.a());
      bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.5
 * JD-Core Version:    0.7.0.1
 */