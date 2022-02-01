package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.PobingTemplateAdapter;
import com.tencent.mobileqq.vas.quickupdate.PobingUpdateCallback;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.BitmapsCache;
import java.util.HashMap;

class AddFriendVerifyActivity$30
  implements Runnable
{
  AddFriendVerifyActivity$30(AddFriendVerifyActivity paramAddFriendVerifyActivity, PobingDecoder.BitmapsCache paramBitmapsCache) {}
  
  public void run()
  {
    if (AddFriendVerifyActivity.c(this.this$0).a() == 2003)
    {
      AddFriendVerifyActivity.a(this.this$0, this.a);
      return;
    }
    if (this.a.a == AddFriendVerifyActivity.c(this.this$0).a())
    {
      Object localObject = (Bitmap)this.a.c.get(Integer.valueOf(2131449382));
      AddFriendVerifyActivity.A(this.this$0).setVisibility(0);
      AddFriendVerifyActivity.A(this.this$0).setBackgroundDrawable(new BitmapDrawable(this.this$0.getResources(), (Bitmap)localObject));
      localObject = (Bitmap)this.a.c.get(Integer.valueOf(2131449377));
      localObject = PobingUpdateCallback.createNinePatchDrawable(this.this$0.getResources(), (Bitmap)localObject);
      AddFriendVerifyActivity.b(this.this$0).setBackgroundDrawable((Drawable)localObject);
      AddFriendVerifyActivity.l(this.this$0).setTextColor(this.a.b);
      AddFriendVerifyActivity.b(this.this$0).setTextColor(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.30
 * JD-Core Version:    0.7.0.1
 */