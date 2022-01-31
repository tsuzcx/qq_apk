package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.os.Message;
import auuy;
import bbki;
import bfob;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;

class FriendProfileCardActivity$47
  implements Runnable
{
  FriendProfileCardActivity$47(FriendProfileCardActivity paramFriendProfileCardActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a;
    Object localObject = localBitmap;
    if (localBitmap == null) {
      localObject = ((FriendProfileCardBgDrawable)FriendProfileCardActivity.a(this.this$0)).b();
    }
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localObject = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * 0.125F), (int)(((Bitmap)localObject).getHeight() * 0.125F), true);
      bbki.a((Bitmap)localObject, 2);
      if ((this.this$0.b != null) && (this.this$0.jdField_a_of_type_Auuy != null) && (this.this$0.jdField_a_of_type_Auuy.a != null))
      {
        localObject = this.this$0.b.obtainMessage(12, localObject);
        this.this$0.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo = ProfileShoppingPhotoInfo.getPhotoInfo(this.this$0.app, this.this$0.jdField_a_of_type_Auuy.a.a);
        this.this$0.b.sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.47
 * JD-Core Version:    0.7.0.1
 */