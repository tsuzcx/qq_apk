package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.ImageView;

class CustomTitleView$2
  extends BroadcastReceiver
{
  CustomTitleView$2(CustomTitleView paramCustomTitleView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_decode_finish".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = (Bitmap)paramIntent.getParcelableExtra("bitmap");
      if ((CustomTitleView.a(this.a) != null) && (CustomTitleView.a(this.a).equals(paramContext)) && (paramIntent != null)) {
        CustomTitleView.a(this.a).setImageBitmap(paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTitleView.2
 * JD-Core Version:    0.7.0.1
 */