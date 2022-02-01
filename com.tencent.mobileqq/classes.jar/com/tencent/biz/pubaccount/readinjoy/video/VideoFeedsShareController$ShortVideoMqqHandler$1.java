package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import mqq.os.MqqHandler;

class VideoFeedsShareController$ShortVideoMqqHandler$1
  implements DialogInterface.OnClickListener
{
  VideoFeedsShareController$ShortVideoMqqHandler$1(VideoFeedsShareController.ShortVideoMqqHandler paramShortVideoMqqHandler, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ShortVideoMqqHandler, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ShortVideoMqqHandler.a).getIntent().getExtras().getString("thumbfile_md5") + ".mp4", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.ShortVideoMqqHandler.1
 * JD-Core Version:    0.7.0.1
 */