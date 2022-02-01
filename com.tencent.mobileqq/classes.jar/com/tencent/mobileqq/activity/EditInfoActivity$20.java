package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;

class EditInfoActivity$20
  extends FriendListObserver
{
  EditInfoActivity$20(EditInfoActivity paramEditInfoActivity) {}
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (!this.a.f.equals(paramString1)) {}
    while (!this.a.j) {
      return;
    }
    this.a.j = false;
    this.a.runOnUiThread(new EditInfoActivity.20.1(this, paramBoolean, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.20
 * JD-Core Version:    0.7.0.1
 */