package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.BaseEvent;
import java.io.File;

public class StoryPlayerGroupHolder$DownloadVideoResultEvent
  extends BaseEvent
{
  @Nullable
  public final File a;
  public final String a;
  public final boolean a;
  
  public StoryPlayerGroupHolder$DownloadVideoResultEvent(String paramString, boolean paramBoolean, File paramFile)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.DownloadVideoResultEvent
 * JD-Core Version:    0.7.0.1
 */