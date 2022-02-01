package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationResult;

class UserOperationModule$4
  implements Runnable
{
  UserOperationModule$4(UserOperationModule paramUserOperationModule, UserOperationModule.BaseOx978RespCallBack paramBaseOx978RespCallBack, String paramString, oidb_cmd0x978.OneFollowOperationResult paramOneFollowOperationResult) {}
  
  public void run()
  {
    ((UserOperationModule.Ox978RespCallBack)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule$BaseOx978RespCallBack).a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_TencentImOidbCmd0x978Oidb_cmd0x978$OneFollowOperationResult.enum_follow_status.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.4
 * JD-Core Version:    0.7.0.1
 */