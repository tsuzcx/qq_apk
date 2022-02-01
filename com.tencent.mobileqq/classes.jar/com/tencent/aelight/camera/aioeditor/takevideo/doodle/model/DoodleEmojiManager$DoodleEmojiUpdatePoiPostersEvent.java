package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import java.util.ArrayList;
import java.util.List;

public class DoodleEmojiManager$DoodleEmojiUpdatePoiPostersEvent
  extends BaseEvent
{
  public final int a;
  @NonNull
  public final List<POIPosterItem> b;
  
  public DoodleEmojiManager$DoodleEmojiUpdatePoiPostersEvent(int paramInt, @NonNull List<POIPosterItem> paramList)
  {
    this.a = paramInt;
    this.b = new ArrayList(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent
 * JD-Core Version:    0.7.0.1
 */