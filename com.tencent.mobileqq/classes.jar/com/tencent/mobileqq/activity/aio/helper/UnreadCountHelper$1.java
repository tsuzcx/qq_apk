package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import com.tencent.imcore.message.facade.unread.count.UnreadCountUtil;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcall.QCallFacade;

class UnreadCountHelper$1
  implements Runnable
{
  UnreadCountHelper$1(UnreadCountHelper paramUnreadCountHelper) {}
  
  public void run()
  {
    int i = QCallFacade.a(UnreadCountHelper.a(this.this$0));
    int j = UnreadCountUtil.a(UnreadCountHelper.a(this.this$0), UnreadCountHelper.a(this.this$0)) + i;
    Object localObject1 = (TempMsgBoxAIOHelper)UnreadCountHelper.a(this.this$0).a(95);
    i = j;
    if (localObject1 != null) {
      i = ((TempMsgBoxAIOHelper)localObject1).a(j);
    }
    localObject1 = "";
    Object localObject2;
    String str;
    if (i > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (i > 99) {
        localObject1 = "99+";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(UnreadCountHelper.a(this.this$0).getString(2131719442));
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      str = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701193));
      ((StringBuilder)localObject2).append(UnreadCountHelper.a(this.this$0).getString(2131719442));
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("条未读");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      str = UnreadCountHelper.a(this.this$0).getString(2131719442);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701198));
      ((StringBuilder)localObject2).append(UnreadCountHelper.a(this.this$0).getString(2131719442));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    UnreadCountHelper.a(this.this$0).a(str, (String)localObject2, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.UnreadCountHelper.1
 * JD-Core Version:    0.7.0.1
 */