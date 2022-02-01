package com.tencent.ilivesdk.domain.usecase;

import com.tencent.ilivesdk.minicardservice_interface.OnUserInfoUpdateCallback;

class GetFollowStateCase$1
  implements OnUserInfoUpdateCallback
{
  GetFollowStateCase$1(GetFollowStateCase paramGetFollowStateCase) {}
  
  public void onFollowUpdate(boolean paramBoolean)
  {
    GetFollowStateCase.access$000(this.this$0, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetFollowStateCase.1
 * JD-Core Version:    0.7.0.1
 */