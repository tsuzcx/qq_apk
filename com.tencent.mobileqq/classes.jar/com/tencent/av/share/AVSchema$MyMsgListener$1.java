package com.tencent.av.share;

import alud;
import android.text.TextUtils;
import com.tencent.av.ReqGroupVideo.RspShareBackflowVerify;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import ljb;
import mat;
import mts;

public class AVSchema$MyMsgListener$1
  implements Runnable
{
  public AVSchema$MyMsgListener$1(mat parammat, ReqGroupVideo.RspShareBackflowVerify paramRspShareBackflowVerify, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached()) {}
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
        j = ljb.a(this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.result);
        localObject = ljb.a(this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.result);
        str2 = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint64_group_code.get() + "";
        long l = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint64_room_id.get();
        int k = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint32_room_create_time.get();
        i = 99;
        if (this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.enum_verify_status.has()) {
          i = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.enum_verify_status.get();
        }
        str1 = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.bytes_wording.get().toStringUtf8();
        bool = AVSchema.a(this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_Mas, this.jdField_a_of_type_Mat.jdField_a_of_type_Mas);
        QLog.w(this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_JavaLangString, 1, "onReceiveResult.callback, result[" + j + "], errMsg[" + (String)localObject + "], enum_verify_status[" + i + "], group_uin[" + str2 + "], uint64_room_id[" + l + "], uint32_room_create_time[" + k + "], bytes_wording[" + str1 + "], isSameInfo[" + bool + "], Activity[" + this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.getActivity() + "], isResume[" + this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.isResumed() + "], seq[" + this.jdField_a_of_type_Long + "]");
      } while (!bool);
      this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.a(false);
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
          localObject = alud.a(2131701278);
        }
      }
      this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_Mas.a = i;
      switch (i)
      {
      default: 
        this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.a(this.jdField_a_of_type_Long, (String)localObject);
      }
    } while (!AudioHelper.d());
    Object localObject = alud.a(2131701275) + i + "], bytes_wording[" + (String)localObject + "], seq[" + this.jdField_a_of_type_Long + "]";
    QLog.w(this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_JavaLangString, 1, (String)localObject);
    throw new RuntimeException((String)localObject);
    mts.a(0);
    this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.c(str2);
    return;
    mts.a(5);
    mts.a(0);
    this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.c(str2);
    this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.a(this.jdField_a_of_type_Long, (String)localObject, str2);
    return;
    mts.a(4);
    this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.b(this.jdField_a_of_type_Long, (String)localObject, str2);
    return;
    mts.a(i);
    this.jdField_a_of_type_Mat.jdField_a_of_type_ComTencentAvShareAVSchema.a(this.jdField_a_of_type_Long, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyMsgListener.1
 * JD-Core Version:    0.7.0.1
 */