package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

final class ChatAVHelper$15
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$15(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = UITools.b(this.a.a);
    if ((this.a.j != null) && (i == 1))
    {
      localObject = (String)this.a.j.get("MultiAVType");
      if (localObject != null)
      {
        paramInt = Integer.valueOf((String)localObject).intValue();
        break label64;
      }
    }
    paramInt = 0;
    label64:
    ChatActivityUtils.a(this.b, this.c, this.d, i, paramInt);
    Object localObject = this.a;
    ((ChatActivityUtils.VideoCheckFlag)localObject).k = false;
    ((ChatActivityUtils.VideoCheckFlag)localObject).l = false;
    ChatActivityUtils.a(this.b, this.c, this.d, this.e, (ChatActivityUtils.VideoCheckFlag)localObject);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.15
 * JD-Core Version:    0.7.0.1
 */