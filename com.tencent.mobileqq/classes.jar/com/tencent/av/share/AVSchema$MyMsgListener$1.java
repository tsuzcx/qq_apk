package com.tencent.av.share;

import ajjy;
import android.text.TextUtils;
import com.tencent.av.ReqGroupVideo.RspShareBackflowVerify;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import kwo;
import lnr;
import mgc;

public class AVSchema$MyMsgListener$1
  implements Runnable
{
  public AVSchema$MyMsgListener$1(lnr paramlnr, ReqGroupVideo.RspShareBackflowVerify paramRspShareBackflowVerify, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached()) {}
    String str2;
    int i;
    do
    {
      int j;
      String str1;
      boolean bool;
      do
      {
        return;
        j = kwo.a(this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.result);
        localObject = kwo.a(this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.result);
        str2 = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint64_group_code.get() + "";
        long l = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint64_room_id.get();
        int k = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint32_room_create_time.get();
        i = 99;
        if (this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.enum_verify_status.has()) {
          i = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.enum_verify_status.get();
        }
        str1 = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.bytes_wording.get().toStringUtf8();
        bool = AVSchema.a(this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_Lnq, this.jdField_a_of_type_Lnr.jdField_a_of_type_Lnq);
        QLog.w(this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_JavaLangString, 1, "onReceiveResult.callback, result[" + j + "], errMsg[" + (String)localObject + "], enum_verify_status[" + i + "], group_uin[" + str2 + "], uint64_room_id[" + l + "], uint32_room_create_time[" + k + "], bytes_wording[" + str1 + "], isSameInfo[" + bool + "], Activity[" + this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.getActivity() + "], isResume[" + this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.isResumed() + "], seq[" + this.jdField_a_of_type_Long + "]");
      } while (!bool);
      this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.a(false);
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        if (j == 0)
        {
          localObject = str1;
          if (i != 0)
          {
            localObject = str1;
            if (j != 0) {}
          }
        }
        else
        {
          localObject = ajjy.a(2131635102);
        }
      }
      this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_Lnq.a = i;
      switch (i)
      {
      default: 
        this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.a(this.jdField_a_of_type_Long, (String)localObject);
      }
    } while (!AudioHelper.d());
    Object localObject = ajjy.a(2131635099) + i + "], bytes_wording[" + (String)localObject + "], seq[" + this.jdField_a_of_type_Long + "]";
    QLog.w(this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_JavaLangString, 1, (String)localObject);
    throw new RuntimeException((String)localObject);
    mgc.a(0);
    this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.c(str2);
    return;
    mgc.a(5);
    mgc.a(0);
    this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.c(str2);
    this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.a(this.jdField_a_of_type_Long, (String)localObject, str2);
    return;
    mgc.a(4);
    this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.b(this.jdField_a_of_type_Long, (String)localObject, str2);
    return;
    mgc.a(i);
    this.jdField_a_of_type_Lnr.jdField_a_of_type_ComTencentAvShareAVSchema.a(this.jdField_a_of_type_Long, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyMsgListener.1
 * JD-Core Version:    0.7.0.1
 */