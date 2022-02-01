package com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Collections;
import java.util.List;

class EditVideoDoodle$5
  implements DoodleEmojiManager.POIPostersRequestCallback
{
  EditVideoDoodle$5(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a(int paramInt, List<POIPosterItem> paramList)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "onPOIPostersRequestResult callback");
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.EMPTY_LIST;
    }
    StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent(paramInt, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoDoodle.5
 * JD-Core Version:    0.7.0.1
 */