package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.ISendMsgInterface;

class FriendProfileCardActivity$14
  implements ExtendFriendSendMsgHelper.ISendMsgInterface
{
  FriendProfileCardActivity$14(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void enterAio(String paramString1, String paramString2)
  {
    ExtendFriendSendMsgHelper.a(this.a, paramString1, paramString2);
  }
  
  public void showMatchCountDialog()
  {
    ExtendFriendSendMsgHelper.a(this.a);
  }
  
  public void showToast(int paramInt)
  {
    ExtendFriendSendMsgHelper.a(this.a, this.a.getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.14
 * JD-Core Version:    0.7.0.1
 */