package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;

class SpringHbVideoView$6
  implements Runnable
{
  SpringHbVideoView$6(SpringHbVideoView paramSpringHbVideoView, String paramString, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void run()
  {
    if (SpringHbVideoView.a(this.this$0) != null) {
      SpringHbVideoView.a(this.this$0).openMediaPlayerByUrl(this.this$0.getContext(), this.jdField_a_of_type_JavaLangString, 0L, 0L, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView.6
 * JD-Core Version:    0.7.0.1
 */