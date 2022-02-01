package com.tencent.avgame.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AVGameBackAction
{
  public final String a;
  public final int b;
  public final String c;
  public final long d;
  
  private AVGameBackAction(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramLong;
  }
  
  public static AVGameBackAction a(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("key_from");
    long l = paramIntent.getLongExtra("key_msg_seq", 0L);
    int i = paramIntent.getIntExtra("uintype", 0);
    paramIntent = paramIntent.getStringExtra("uin");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramIntent))) {
      paramIntent = new AVGameBackAction((String)localObject, i, paramIntent, l);
    } else {
      paramIntent = null;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseAction, action[");
      ((StringBuilder)localObject).append(paramIntent);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameBackAction", 4, ((StringBuilder)localObject).toString());
    }
    return paramIntent;
  }
  
  public static void a(Intent paramIntent, AVGameBackAction paramAVGameBackAction)
  {
    if ((paramIntent != null) && (paramAVGameBackAction != null))
    {
      paramIntent.putExtra("key_from", paramAVGameBackAction.a);
      paramIntent.putExtra("key_msg_seq", paramAVGameBackAction.d);
      paramIntent.putExtra("uintype", paramAVGameBackAction.b);
      paramIntent.putExtra("uin", paramAVGameBackAction.c);
      if (QLog.isDevelopLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("addAction, action[");
        paramIntent.append(paramAVGameBackAction);
        paramIntent.append("]");
        QLog.i("AVGameBackAction", 4, paramIntent.toString());
      }
    }
  }
  
  public static void a(Intent paramIntent, Message paramMessage)
  {
    if ((paramIntent != null) && (paramMessage != null))
    {
      paramIntent.putExtra("key_from", "MsgPush");
      paramIntent.putExtra("key_msg_seq", paramMessage.uniseq);
      paramIntent.putExtra("uintype", paramMessage.istroop);
      paramIntent.putExtra("uin", paramMessage.frienduin);
      if (QLog.isDevelopLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("addAction, action[MsgPush,");
        paramIntent.append(paramMessage.istroop);
        paramIntent.append(",");
        paramIntent.append(paramMessage.frienduin);
        paramIntent.append(",");
        paramIntent.append(paramMessage.uniseq);
        paramIntent.append("]");
        QLog.i("AVGameBackAction", 4, paramIntent.toString());
      }
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = MobileQQ.getContext();
    }
    paramContext = new Intent();
    if (this.b == 1024) {
      paramContext.putExtra("chat_subType", 1);
    }
    paramContext.putExtra("uin", this.c);
    paramContext.putExtra("uintype", this.b);
    paramContext = BaseAIOUtils.a(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
    RouteUtils.a((Context)localObject, paramContext, "/base/start/splash");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameBackAction
 * JD-Core Version:    0.7.0.1
 */