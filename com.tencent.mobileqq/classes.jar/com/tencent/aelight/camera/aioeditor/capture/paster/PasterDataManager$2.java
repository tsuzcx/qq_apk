package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.os.Handler;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Collections;
import java.util.List;

class PasterDataManager$2
  implements DoodleEmojiManager.POIPostersRequestCallback
{
  PasterDataManager$2(PasterDataManager paramPasterDataManager) {}
  
  public void a(int paramInt, List<POIPosterItem> paramList)
  {
    SLog.b("PasterDataManager", "onPOIPostersRequestResult callback");
    Object localObject = this.a;
    ((PasterDataManager)localObject).jdField_a_of_type_Boolean = true;
    ((PasterDataManager)localObject).jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    localObject = paramList;
    if (paramList == null) {
      localObject = Collections.EMPTY_LIST;
    }
    StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent(paramInt, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager.2
 * JD-Core Version:    0.7.0.1
 */