package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class IntimateInfoView$10
  extends AvatarObserver
{
  IntimateInfoView$10(IntimateInfoView paramIntimateInfoView) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      Bitmap localBitmap = this.a.a.getFaceBitmap(this.a.a.getCurrentAccountUin(), (byte)3, false);
      if (localBitmap != null) {
        IntimateInfoView.a(this.a).a(localBitmap, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.10
 * JD-Core Version:    0.7.0.1
 */