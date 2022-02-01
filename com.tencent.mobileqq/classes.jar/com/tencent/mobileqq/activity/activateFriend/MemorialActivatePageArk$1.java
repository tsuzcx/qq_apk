package com.tencent.mobileqq.activity.activateFriend;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.qphone.base.util.QLog;

class MemorialActivatePageArk$1
  implements ArkViewImplement.LoadCallback
{
  MemorialActivatePageArk$1(MemorialActivatePageArk paramMemorialActivatePageArk) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MemorialActivatePageArk", 1, "@arkgif  onLoadFinish  SUCCESS");
      }
    }
    else if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MemorialActivatePageArk", 1, "@arkgif  onLoadFinish  failed");
      }
      this.a.a(false);
      MemorialActivatePageArk.a(this.a).setText(this.a.getResources().getString(2131915668));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.MemorialActivatePageArk.1
 * JD-Core Version:    0.7.0.1
 */