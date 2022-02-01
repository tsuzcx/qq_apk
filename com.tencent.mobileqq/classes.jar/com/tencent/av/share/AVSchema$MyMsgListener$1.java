package com.tencent.av.share;

import android.text.TextUtils;
import com.tencent.av.ReqGroupVideo.RspShareBackflowVerify;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

class AVSchema$MyMsgListener$1
  implements Runnable
{
  AVSchema$MyMsgListener$1(AVSchema.MyMsgListener paramMyMsgListener, ReqGroupVideo.RspShareBackflowVerify paramRspShareBackflowVerify, long paramLong) {}
  
  public void run()
  {
    if (this.c.b.isDetached()) {
      return;
    }
    int j = MessageHandler.a(this.a.result);
    Object localObject1 = MessageHandler.b(this.a.result);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.uint64_group_code.get());
    ((StringBuilder)localObject2).append("");
    String str1 = ((StringBuilder)localObject2).toString();
    long l = this.a.uint64_room_id.get();
    int k = this.a.uint32_room_create_time.get();
    int i;
    if (this.a.enum_verify_status.has()) {
      i = this.a.enum_verify_status.get();
    } else {
      i = 99;
    }
    localObject2 = this.a.bytes_wording.get().toStringUtf8();
    boolean bool = AVSchema.a(this.c.b.a, this.c.a);
    String str2 = AVSchema.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveResult.callback, result[");
    localStringBuilder.append(j);
    localStringBuilder.append("], errMsg[");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("], verifyStatus[");
    localStringBuilder.append(i);
    localStringBuilder.append("], groupUin[");
    localStringBuilder.append(str1);
    localStringBuilder.append("], roomId[");
    localStringBuilder.append(l);
    localStringBuilder.append("], roomCreateTime[");
    localStringBuilder.append(k);
    localStringBuilder.append("], warning[");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("], isSameInfo[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], Activity[");
    localStringBuilder.append(this.c.b.getBaseActivity());
    localStringBuilder.append("], isResume[");
    localStringBuilder.append(this.c.b.isResumed());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.w(str2, 1, localStringBuilder.toString());
    if (!bool) {
      return;
    }
    this.c.b.a(false);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      if (j == 0)
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          localObject1 = localObject2;
          if (j != 0) {}
        }
      }
      else
      {
        localObject1 = HardCodeUtil.a(2131899134);
      }
    }
    this.c.b.a.c = i;
    if (i != 99) {
      switch (i)
      {
      default: 
        this.c.b.a(this.b, (String)localObject1);
        if (!AudioHelper.a()) {
          return;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899131));
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("], warning[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("], seq[");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
        QLog.w(AVSchema.e(), 1, (String)localObject1);
        throw new RuntimeException((String)localObject1);
      case 5: 
        ShareChatReport.a(5);
        ShareChatReport.a(0);
        this.c.b.c(str1);
        this.c.b.a(this.b, (String)localObject1, str1);
        return;
      case 4: 
        ShareChatReport.a(4);
        this.c.b.b(this.b, (String)localObject1, str1);
        return;
      case 0: 
        ShareChatReport.a(0);
        this.c.b.c(str1);
        return;
      }
    }
    ShareChatReport.a(i);
    this.c.b.a(this.b, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyMsgListener.1
 * JD-Core Version:    0.7.0.1
 */