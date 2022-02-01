package com.tencent.biz.qqstory.base.videoupload;

import java.util.ArrayList;

class VideoSaveToAlbumHelper$2
  extends ArrayList<Object>
{
  VideoSaveToAlbumHelper$2(VideoSaveToAlbumHelper paramVideoSaveToAlbumHelper, VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo paramVideoSaveToAlbumTaskInfo, int paramInt, String paramString)
  {
    add(this.val$taskInfo.c);
    paramInt = this.val$rotation;
    if ((paramInt != 0) && (paramInt != -1)) {
      paramVideoSaveToAlbumHelper = this.val$hflipPath;
    } else {
      paramVideoSaveToAlbumHelper = this.val$taskInfo.b;
    }
    add(paramVideoSaveToAlbumHelper);
    add(this.val$taskInfo.f);
    add(Integer.valueOf(this.val$taskInfo.d));
    add(Integer.valueOf(this.val$taskInfo.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.2
 * JD-Core Version:    0.7.0.1
 */