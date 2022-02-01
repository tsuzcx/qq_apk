package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.base.libapi.login.LoginObserver;

class GetFollowStateCase$2
  implements LoginObserver
{
  GetFollowStateCase$2(GetFollowStateCase paramGetFollowStateCase) {}
  
  public void onLoginFail() {}
  
  public void onLoginSuccess()
  {
    this.this$0.queryFollowStatus(GetFollowStateCase.access$100(this.this$0), GetFollowStateCase.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetFollowStateCase.2
 * JD-Core Version:    0.7.0.1
 */