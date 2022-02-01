package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.base.libapi.login.LoginObserver;

class GetFollowStateCase$2
  implements LoginObserver
{
  GetFollowStateCase$2(GetFollowStateCase paramGetFollowStateCase) {}
  
  public void onLoginFail() {}
  
  public void onLoginSuccess()
  {
    GetFollowStateCase localGetFollowStateCase = this.this$0;
    localGetFollowStateCase.queryFollowStatus(GetFollowStateCase.access$100(localGetFollowStateCase), GetFollowStateCase.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetFollowStateCase.2
 * JD-Core Version:    0.7.0.1
 */