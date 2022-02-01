package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BaseEvent;

public class DoodleEmojiManager$DoodleEmojiDownloadEvent
  extends BaseEvent
{
  @NonNull
  public final DoodleEmojiItem a;
  public final int b;
  public final boolean c;
  public boolean d;
  public final long e;
  public final long f;
  
  public DoodleEmojiManager$DoodleEmojiDownloadEvent(@NonNull DoodleEmojiItem paramDoodleEmojiItem, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.a = paramDoodleEmojiItem;
    this.b = paramInt;
    this.c = paramBoolean;
    this.e = paramLong1;
    this.f = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent
 * JD-Core Version:    0.7.0.1
 */