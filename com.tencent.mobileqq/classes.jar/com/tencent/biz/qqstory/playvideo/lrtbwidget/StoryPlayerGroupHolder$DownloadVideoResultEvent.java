package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.BaseEvent;
import java.io.File;

public class StoryPlayerGroupHolder$DownloadVideoResultEvent
  extends BaseEvent
{
  public final boolean a;
  public final String b;
  @Nullable
  public final File c;
  
  public StoryPlayerGroupHolder$DownloadVideoResultEvent(String paramString, boolean paramBoolean, File paramFile)
  {
    this.b = paramString;
    this.a = paramBoolean;
    this.c = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.DownloadVideoResultEvent
 * JD-Core Version:    0.7.0.1
 */