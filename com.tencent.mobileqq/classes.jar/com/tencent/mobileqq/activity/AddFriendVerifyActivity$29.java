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

class AddFriendVerifyActivity$29
  implements Runnable
{
  AddFriendVerifyActivity$29(AddFriendVerifyActivity paramAddFriendVerifyActivity, PobingDecoder.BitmapsCache paramBitmapsCache) {}
  
  public void run()
  {
    if (AddFriendVerifyActivity.a(this.this$0).a() == 2003) {
      AddFriendVerifyActivity.a(this.this$0, this.a);
    }
    while (this.a.jdField_a_of_type_Int != AddFriendVerifyActivity.a(this.this$0).a()) {
      return;
    }
    Object localObject = (Bitmap)this.a.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131381174));
    AddFriendVerifyActivity.b(this.this$0).setVisibility(0);
    AddFriendVerifyActivity.b(this.this$0).setBackgroundDrawable(new BitmapDrawable(this.this$0.getResources(), (Bitmap)localObject));
    localObject = (Bitmap)this.a.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2131381169));
    localObject = PobingUpdateCallback.createNinePatchDrawable(this.this$0.getResources(), (Bitmap)localObject);
    AddFriendVerifyActivity.a(this.this$0).setBackgroundDrawable((Drawable)localObject);
    AddFriendVerifyActivity.b(this.this$0).setTextColor(this.a.b);
    AddFriendVerifyActivity.a(this.this$0).setTextColor(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.29
 * JD-Core Version:    0.7.0.1
 */