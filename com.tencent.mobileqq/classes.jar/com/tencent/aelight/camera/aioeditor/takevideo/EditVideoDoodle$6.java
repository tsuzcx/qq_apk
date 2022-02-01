package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Handler;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Collections;
import java.util.List;

class EditVideoDoodle$6
  implements DoodleEmojiManager.POIPostersRequestCallback
{
  EditVideoDoodle$6(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a(int paramInt, List<POIPosterItem> paramList)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "onPOIPostersRequestResult callback");
    Object localObject = this.a;
    ((EditVideoDoodle)localObject).f = true;
    ((EditVideoDoodle)localObject).g.removeCallbacks(this.a.k);
    localObject = paramList;
    if (paramList == null) {
      localObject = Collections.EMPTY_LIST;
    }
    StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent(paramInt, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.6
 * JD-Core Version:    0.7.0.1
 */