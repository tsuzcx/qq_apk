package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class GesturePWDUnlockActivity$6
  extends AvatarObserver
{
  GesturePWDUnlockActivity$6(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      if (!paramString.equals(this.a.app.getCurrentAccountUin())) {
        return;
      }
      if (this.a.mFaceImageView != null)
      {
        paramString = this.a.app.getFaceBitmap(this.a.app.getCurrentAccountUin(), (byte)3, false);
        this.a.mFaceImageView.setImageBitmap(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity.6
 * JD-Core Version:    0.7.0.1
 */