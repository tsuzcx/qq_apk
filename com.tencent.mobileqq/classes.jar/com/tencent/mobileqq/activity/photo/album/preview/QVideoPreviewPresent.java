package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class QVideoPreviewPresent
  extends VideoPreviewPresent
{
  public QVideoPreviewPresent(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  protected BaseVideoView generateVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    paramVideoPlayParam.mSceneId = 105;
    paramVideoPlayParam.mSceneName = SceneID.a(105);
    return (BaseVideoView)QQVideoViewFactory.b(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.QVideoPreviewPresent
 * JD-Core Version:    0.7.0.1
 */