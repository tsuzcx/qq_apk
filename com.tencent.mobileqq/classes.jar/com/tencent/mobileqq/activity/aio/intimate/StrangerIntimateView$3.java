package com.tencent.mobileqq.activity.aio.intimate;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class StrangerIntimateView$3
  extends AvatarObserver
{
  StrangerIntimateView$3(StrangerIntimateView paramStrangerIntimateView) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      paramString = this.a.a.getFaceBitmap(this.a.a.getCurrentAccountUin(), (byte)3, false);
      if ((paramString != null) && (StrangerIntimateView.a(this.a) != null)) {
        StrangerIntimateView.a(this.a).setImageBitmap(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.3
 * JD-Core Version:    0.7.0.1
 */