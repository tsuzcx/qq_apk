package com.tencent.biz.pubaccount.accountdetail.model;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

class AccountDetailVideoManager$1
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  AccountDetailVideoManager$1(AccountDetailVideoManager paramAccountDetailVideoManager) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.g.start();
    new Thread(new AccountDetailVideoManager.1.1(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager.1
 * JD-Core Version:    0.7.0.1
 */