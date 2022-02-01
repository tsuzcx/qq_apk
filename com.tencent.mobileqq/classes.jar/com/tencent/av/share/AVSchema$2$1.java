package com.tencent.av.share;

import com.tencent.av.ReqGroupVideo.RspCheckGroupCanJoin;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

class AVSchema$2$1
  implements Runnable
{
  AVSchema$2$1(AVSchema.2 param2, ReqGroupVideo.RspCheckGroupCanJoin paramRspCheckGroupCanJoin, long paramLong) {}
  
  public void run()
  {
    if (this.c.a.isDetached()) {
      return;
    }
    boolean bool = this.a.is_can_join.get();
    if (bool)
    {
      ShareChatReport.h();
      str = this.a.join_wording.get().toStringUtf8();
      PopupDialog.a(this.c.a.getBaseActivity(), 230, null, str, 2131887648, 2131892267, new AVSchema.2.1.1(this), new AVSchema.2.1.2(this));
    }
    else
    {
      this.c.a.b(this.b, this.c.a.a);
    }
    String str = AVSchema.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("join group check[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.2.1
 * JD-Core Version:    0.7.0.1
 */