package com.tencent.mobileqq.activity.selectmember;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

class CreateFaceToFaceDiscussionActivity$10$1
  extends SosoInterfaceOnLocationListener
{
  CreateFaceToFaceDiscussionActivity$10$1(CreateFaceToFaceDiscussionActivity.10 param10, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt != 0) || (paramSosoLbsInfo == null))
    {
      paramSosoLbsInfo = this.a.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      paramSosoLbsInfo.arg1 = 1;
      paramSosoLbsInfo.arg2 = 2131698894;
      paramSosoLbsInfo.sendToTarget();
      return;
    }
    paramSosoLbsInfo = CreateFaceToFaceDiscussionActivity.a(this.a.this$0, paramSosoLbsInfo);
    NearFieldDiscussHandler localNearFieldDiscussHandler = (NearFieldDiscussHandler)this.a.this$0.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_DISCUSS_HANDLER);
    switch (this.a.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localNearFieldDiscussHandler.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo, this.a.this$0.b, this.a.this$0.h);
      return;
    case 1: 
      localNearFieldDiscussHandler.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo, 2, this.a.this$0.h);
      return;
    case 2: 
      localNearFieldDiscussHandler.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo, true);
      return;
    case 3: 
      localNearFieldDiscussHandler.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo, false);
      return;
    }
    localNearFieldDiscussHandler.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.10.1
 * JD-Core Version:    0.7.0.1
 */