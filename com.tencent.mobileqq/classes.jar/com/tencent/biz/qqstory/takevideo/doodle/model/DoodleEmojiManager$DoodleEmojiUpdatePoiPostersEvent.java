package com.tencent.biz.qqstory.takevideo.doodle.model;

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
  public final List<POIPosterItem> a;
  
  public DoodleEmojiManager$DoodleEmojiUpdatePoiPostersEvent(int paramInt, @NonNull List<POIPosterItem> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent
 * JD-Core Version:    0.7.0.1
 */