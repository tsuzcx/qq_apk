package com.tencent.biz.pubaccount.accountdetail.model;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

class AccountDetailVideoManager$3
  implements TVK_IMediaPlayer.OnErrorListener
{
  AccountDetailVideoManager$3(AccountDetailVideoManager paramAccountDetailVideoManager) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramObject = new StringBuilder();
      paramObject.append("video player error model=");
      paramObject.append(paramInt1);
      paramTVK_IMediaPlayer.append(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(",what=");
      paramObject.append(paramInt2);
      paramTVK_IMediaPlayer.append(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(",extra=");
      paramObject.append(paramInt3);
      paramTVK_IMediaPlayer.append(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(",detailInfo=");
      paramObject.append(paramString);
      paramTVK_IMediaPlayer.append(paramObject.toString());
      QLog.e("AccountDetailVideoManager", 2, paramTVK_IMediaPlayer.toString());
    }
    this.a.a.runOnUiThread(new AccountDetailVideoManager.3.1(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager.3
 * JD-Core Version:    0.7.0.1
 */