package com.tencent.mobileqq.activity.qwallet.emoj;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import mqq.os.MqqHandler;

class EmojiRedPackPreviewFragment$3
  implements Runnable
{
  EmojiRedPackPreviewFragment$3(EmojiRedPackPreviewFragment paramEmojiRedPackPreviewFragment) {}
  
  public void run()
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(EmojiRedPackPreviewFragment.access$100(this.this$0).videoMp4FilePath);
    Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime(1L, 2);
    localMediaMetadataRetriever.release();
    ThreadManager.getUIHandler().post(new EmojiRedPackPreviewFragment.3.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedPackPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */