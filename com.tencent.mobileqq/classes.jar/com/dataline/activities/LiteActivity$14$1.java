package com.dataline.activities;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;

class LiteActivity$14$1
  implements Runnable
{
  LiteActivity$14$1(LiteActivity.14 param14, boolean paramBoolean, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject;
    if (this.a)
    {
      localObject = this.this$0.a.getResources().getDrawable(LiteActivity.B());
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_use_rect", true);
      localBundle.putBoolean("key_double_bitmap", true);
      localObject = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), this.this$0.b, "-chatBg-", (Drawable)localObject, new int[] { 0 }, "-chatBg-", localBundle);
    }
    else
    {
      localObject = new ChatBackgroundDrawable(this.this$0.a.getResources(), this.b);
    }
    this.this$0.c.setBackgroundDrawable((Drawable)localObject);
    this.this$0.c.setTag(2131427359, this.this$0.b);
    this.this$0.c.setTag(2131427358, localObject);
    LiteActivity.a(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.14.1
 * JD-Core Version:    0.7.0.1
 */