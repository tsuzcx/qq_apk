package com.tencent.mobileqq.activity.editservice;

import android.content.Intent;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.widget.QQToast;

class EditFriendRemarkService$2$1
  implements Runnable
{
  EditFriendRemarkService$2$1(EditFriendRemarkService.2 param2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    EditFriendRemarkService.a(this.c.a).loadingProgress(false);
    if (this.a)
    {
      EditFriendRemarkService.g(this.c.a).putExtra("result", this.b);
      EditFriendRemarkService.a(this.c.a).onFinishForResult(-1, EditFriendRemarkService.g(this.c.a));
      return;
    }
    QQToast.makeText(EditFriendRemarkService.b(this.c.a), 2, 2131891837, 0).show();
    EditFriendRemarkService.a(this.c.a).onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditFriendRemarkService.2.1
 * JD-Core Version:    0.7.0.1
 */