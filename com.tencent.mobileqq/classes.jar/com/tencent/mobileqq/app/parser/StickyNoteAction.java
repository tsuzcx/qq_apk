package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.app.AppRuntime;

public class StickyNoteAction
  extends JumpAction
{
  public StickyNoteAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("fromTranslucent", 1);
    try
    {
      long l1 = Long.parseLong(b("uin"));
      int i = Integer.parseInt(b("appid"));
      Object localObject2 = b("cellid");
      Object localObject3 = b("subid");
      long l2 = Long.parseLong(b("time"));
      ((Bundle)localObject1).putLong("targetuin", Long.valueOf(l1).longValue());
      ((Bundle)localObject1).putInt("appid", i);
      ((Bundle)localObject1).putString("cellid", (String)localObject2);
      ((Bundle)localObject1).putString("subid", (String)localObject3);
      ((Bundle)localObject1).putLong("feedtime", l2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject2, "com.qzone.detail.ui.activity.StickyNoteDetailActivity");
      if ((this.a instanceof QBaseActivity))
      {
        localObject3 = (QBaseActivity)this.a;
        localObject1 = null;
        if (((QBaseActivity)localObject3).getAppRuntime() != null) {
          localObject1 = ((QBaseActivity)localObject3).getAppRuntime().getCurrentUin();
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("action_open_sticky_note_feed_detail  error! get currentUin failed! ");
          ((StringBuilder)localObject1).append(((QBaseActivity)localObject3).getAppRuntime());
          QLog.e("StickyNoteAction", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        QzonePluginProxyActivity.launchPluingActivityForResult((Activity)localObject3, (String)localObject1, (Intent)localObject2, 7, true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("StickyNoteAction", 1, "action_open_sticky_note_feed_detail  error!", localThrowable);
    }
  }
  
  public boolean a()
  {
    try
    {
      if ("feeddetail".equals(this.c))
      {
        a();
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("StickyNoteAction", 1, localStringBuilder.toString());
      b_("StickyNoteAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.StickyNoteAction
 * JD-Core Version:    0.7.0.1
 */