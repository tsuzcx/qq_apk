package com.tencent.av.share;

import com.tencent.av.ReqGroupVideo.RspCheckGroupCanJoin;
import com.tencent.av.utils.DataReport.ShareChat;
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
      DataReport.ShareChat.h();
      String str = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspCheckGroupCanJoin.join_wording.get().toStringUtf8();
      PopupDialog.a(this.jdField_a_of_type_ComTencentAvShareAVSchema$2.a.getActivity(), 230, null, str, 2131690800, 2131694615, new AVSchema.2.1.1(this), new AVSchema.2.1.2(this));
    }
    for (;;)
    {
      QLog.d(this.jdField_a_of_type_ComTencentAvShareAVSchema$2.a.jdField_a_of_type_JavaLangString, 1, "join group check[" + bool + "]");
      return;
      this.jdField_a_of_type_ComTencentAvShareAVSchema$2.a.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvShareAVSchema$2.a.jdField_a_of_type_ComTencentAvShareAVSchema$Info);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.2.1
 * JD-Core Version:    0.7.0.1
 */