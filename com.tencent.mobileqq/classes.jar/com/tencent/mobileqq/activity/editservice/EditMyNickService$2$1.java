package com.tencent.mobileqq.activity.editservice;

import android.content.Intent;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.widget.QQToast;

class EditMyNickService$2$1
  implements Runnable
{
  EditMyNickService$2$1(EditMyNickService.2 param2, boolean paramBoolean, Card paramCard, int paramInt) {}
  
  public void run()
  {
    EditMyNickService.a(this.d.a).loadingProgress(false);
    if (this.a)
    {
      EditMyNickService.g(this.d.a).putExtra("result", this.b.strNick);
      EditMyNickService.a(this.d.a).onFinishForResult(-1, EditMyNickService.g(this.d.a));
      return;
    }
    if (this.c == 40) {
      QQToast.makeText(EditMyNickService.d(this.d.a), 1, 2131916320, 0).show();
    } else {
      QQToast.makeText(EditMyNickService.d(this.d.a), 2, 2131891837, 0).show();
    }
    EditMyNickService.a(this.d.a).onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditMyNickService.2.1
 * JD-Core Version:    0.7.0.1
 */