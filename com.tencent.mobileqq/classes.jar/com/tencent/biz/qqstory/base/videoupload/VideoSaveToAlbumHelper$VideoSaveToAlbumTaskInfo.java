package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;

public class VideoSaveToAlbumHelper$VideoSaveToAlbumTaskInfo
{
  String a;
  String b;
  String c;
  int d;
  int e;
  public String f;
  public String g;
  boolean h;
  StoryVideoItem.PollLayout i;
  StoryVideoItem.InteractPasterLayout j;
  
  public VideoSaveToAlbumHelper$VideoSaveToAlbumTaskInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt1;
    this.e = paramInt2;
    this.h = paramBoolean;
    paramString2 = new StringBuilder();
    paramString2.append(QQStoryConstant.v);
    paramString2.append(paramString1);
    paramString2.append(".mp4");
    this.f = paramString2.toString();
    this.g = PlayModeUtils.a(paramString1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo
 * JD-Core Version:    0.7.0.1
 */