package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import bbmy;
import java.util.ArrayList;

public class KanDianVideoUploadBrocast
  extends BroadcastReceiver
{
  ArrayList<String> a = new ArrayList();
  
  private void a(Context paramContext, int paramInt, CharSequence paramCharSequence)
  {
    if (paramContext == null) {
      return;
    }
    bbmy.a(paramContext, paramInt, paramCharSequence, 0).b(paramContext.getResources().getDimensionPixelSize(2131167766));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("mTaskID");
    int i = 0;
    try
    {
      int j = Integer.valueOf(paramIntent.getStringExtra("mState")).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("KandianVideoUpload", "解析广播状态异常" + localException.toString());
      }
      switch (i)
      {
      default: 
        return;
      }
    }
    Log.d("KandianVideoUpload", "收到广播taskID  " + str + "  state:" + i + " 当前的taskiD list大小" + this.a.size());
    if ((!this.a.isEmpty()) && (!this.a.contains(str))) {
      return;
    }
    a(paramContext, 2, paramContext.getString(2131652776));
    return;
    str = paramIntent.getStringExtra("mfaileMessage");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = paramContext.getString(2131652595);
    }
    a(paramContext, 1, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.KanDianVideoUploadBrocast
 * JD-Core Version:    0.7.0.1
 */