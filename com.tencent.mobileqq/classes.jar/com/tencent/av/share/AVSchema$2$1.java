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
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema$2.a.isDetached()) {
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspCheckGroupCanJoin.is_can_join.get();
    if (bool)
    {
      ShareChatReport.h();
      str = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspCheckGroupCanJoin.join_wording.get().toStringUtf8();
      PopupDialog.a(this.jdField_a_of_type_ComTencentAvShareAVSchema$2.a.getBaseActivity(), 230, null, str, 2131690728, 2131694583, new AVSchema.2.1.1(this), new AVSchema.2.1.2(this));
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvShareAVSchema$2.a.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvShareAVSchema$2.a.a);
    }
    String str = AVSchema.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("join group check[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.2.1
 * JD-Core Version:    0.7.0.1
 */