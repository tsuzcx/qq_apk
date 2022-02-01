package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;

class CreateFaceToFaceDiscussionActivity$10
  implements Runnable
{
  CreateFaceToFaceDiscussionActivity$10(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity, int paramInt) {}
  
  public void run()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new CreateFaceToFaceDiscussionActivity.10.1(this, 0, true, false, 60000L, false, false, "CreateFaceToFaceDiscussionActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.10
 * JD-Core Version:    0.7.0.1
 */