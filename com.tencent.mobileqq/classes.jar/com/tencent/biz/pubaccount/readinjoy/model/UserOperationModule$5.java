package com.tencent.biz.pubaccount.readinjoy.model;

class UserOperationModule$5
  implements Runnable
{
  UserOperationModule$5(UserOperationModule paramUserOperationModule, boolean paramBoolean, UserOperationModule.BaseOx978RespCallBack paramBaseOx978RespCallBack, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ((UserOperationModule.BatchFollowCallBack)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule$BaseOx978RespCallBack).a(false, null, this.jdField_a_of_type_Int + "");
      return;
    }
    ((UserOperationModule.Ox978RespCallBack)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule$BaseOx978RespCallBack).a(false, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.5
 * JD-Core Version:    0.7.0.1
 */