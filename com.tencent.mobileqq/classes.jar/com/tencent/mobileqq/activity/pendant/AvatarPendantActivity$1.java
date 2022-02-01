package com.tencent.mobileqq.activity.pendant;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQToast;

class AvatarPendantActivity$1
  extends CardObserver
{
  AvatarPendantActivity$1(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean)
    {
      int i = 2131719065;
      if (paramInt == 1503) {
        i = 2131699060;
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 1, i, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.1
 * JD-Core Version:    0.7.0.1
 */