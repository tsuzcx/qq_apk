package com.tencent.mobileqq.activity.editservice;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.util.UiThreadUtil;

class EditFriendRemarkService$2
  extends FriendListObserver
{
  EditFriendRemarkService$2(EditFriendRemarkService paramEditFriendRemarkService) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (!EditFriendRemarkService.b(this.a).equals(paramString1)) {
      return;
    }
    if (!EditFriendRemarkService.a(this.a).booleanValue()) {
      return;
    }
    EditFriendRemarkService.a(this.a, Boolean.valueOf(false));
    UiThreadUtil.a(new EditFriendRemarkService.2.1(this, paramBoolean, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditFriendRemarkService.2
 * JD-Core Version:    0.7.0.1
 */