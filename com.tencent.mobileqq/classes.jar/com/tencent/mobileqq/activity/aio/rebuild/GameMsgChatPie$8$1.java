package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

class GameMsgChatPie$8$1
  implements Runnable
{
  GameMsgChatPie$8$1(GameMsgChatPie.8 param8, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      QQToast.makeText(this.b.a.e, this.a, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.8.1
 * JD-Core Version:    0.7.0.1
 */