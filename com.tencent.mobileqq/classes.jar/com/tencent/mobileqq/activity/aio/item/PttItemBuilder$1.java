package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.widget.QfavMicroPhoneDialog.Listener;

class PttItemBuilder$1
  implements QfavMicroPhoneDialog.Listener
{
  PttItemBuilder$1(PttItemBuilder paramPttItemBuilder, MessageForPtt paramMessageForPtt) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QfavReport.a(this.b.d, 6, 0, this.a.istroop);
    QfavBuilder.a(paramString1, paramInt, paramString2).b(this.b.d, this.a).a((Activity)this.b.e, this.b.d.getAccount());
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.length() > 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    QfavReport.a(this.b.d, "User_AddFav", 4, 0, 6, paramInt, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */