package com.tencent.mobileqq.app.qqdaily;

import com.tencent.ark.ArkViewImplement.LoadCallback;

class QQDailyArkView$1
  implements ArkViewImplement.LoadCallback
{
  QQDailyArkView$1(QQDailyArkView paramQQDailyArkView) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    if (paramInt != 1) {
      QQDailyArkView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyArkView.1
 * JD-Core Version:    0.7.0.1
 */