package com.tencent.biz.pubaccount.readinjoy.capture;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ImageUtil.ScalingLogic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lkr;
import lks;

public class ReadInJoyVideoCompositeManager
{
  private ReadInJoyVideoCompositeManager.OnVideoCompositeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener;
  private VideoCompositeHelper jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper = new VideoCompositeHelper();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, Context paramContext, String paramString)
  {
    if (a(paramPublishVideoEntry))
    {
      a(paramString, paramPublishVideoEntry);
      if (paramPublishVideoEntry.doodlePath != null)
      {
        a(paramPublishVideoEntry, paramContext, paramPublishVideoEntry.doodlePath, paramString);
        return;
      }
      a(paramPublishVideoEntry, paramString);
      return;
    }
    a(paramPublishVideoEntry, paramString);
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      ImageUtil.a(ImageUtil.a(ImageUtil.a(paramPublishVideoEntry.doodlePath, null), paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, ImageUtil.ScalingLogic.SCALE_CROP), new File(paramPublishVideoEntry.doodlePath));
      FFmpegUtils.a(paramContext, paramString2, paramString1, paramString2 + ".doodle.mp4", new lks(this, paramPublishVideoEntry, paramString2));
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, "compositeVideo: " + QLog.getStackTraceString(paramContext));
      }
      a(paramPublishVideoEntry, 999, "本地视频合成涂鸦是出错！");
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, "compositeVideo: " + QLog.getStackTraceString(paramContext));
      }
      a(paramPublishVideoEntry, 999, "本地视频合成涂鸦是出错！");
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener.a(paramPublishVideoEntry, paramString);
    }
  }
  
  private void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    QLog.d("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, "setLocalVideoInfo : outputPath:" + paramString);
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.getFrameAtTime();
    int i = paramString.getWidth();
    int j = paramString.getHeight();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, "setLocalVideoInfo: local_width : " + i + ", local_height : " + j + ", entry_width : " + paramPublishVideoEntry.videoWidth + "entry_height : " + paramPublishVideoEntry.videoHeight);
    }
    paramPublishVideoEntry.videoHeight = j;
    paramPublishVideoEntry.videoWidth = i;
    paramPublishVideoEntry.videoDuration = (paramPublishVideoEntry.videoRangeEnd - paramPublishVideoEntry.videoRangeStart);
    localMediaMetadataRetriever.release();
  }
  
  private boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    return paramPublishVideoEntry.isLocalPublish;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = VideoCompositeHelper.a(paramString1);
    if (!a(paramString1)) {
      paramString1.videoNeedRotate = true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper.a(paramString1, paramString2 + ".tmp.mp4", false, false, new lkr(this, paramString1, paramContext));
  }
  
  public void a(ReadInJoyVideoCompositeManager.OnVideoCompositeListener paramOnVideoCompositeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoCompositeManager$OnVideoCompositeListener = paramOnVideoCompositeListener;
  }
  
  public void a(String paramString)
  {
    VideoCompositeHelper.a(VideoCompositeHelper.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager
 * JD-Core Version:    0.7.0.1
 */