package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCClient;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class EditVideoLimitRegion$1
  implements Runnable
{
  EditVideoLimitRegion$1(StoryGuideLineView paramStoryGuideLineView) {}
  
  public void run()
  {
    Object localObject1 = VideoPlayIPCClient.a().a("CMD_GET_CURRENT_NICK_NAME", null);
    Object localObject2 = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((Bundle)localObject1).getString("VALUE_GET_CURRENT_NICK_NAME");
    }
    Object localObject3 = VideoPlayIPCClient.a().a("CMD_GET_CURRENT_USER_HEAD", null);
    if (localObject3 != null) {
      localObject2 = ((Bundle)localObject3).getString("VALUE_GET_CURRENT_USER_HEAD");
    }
    try
    {
      localObject2 = SafeBitmapFactory.decodeFile((String)localObject2);
      localObject3 = ImageUtil.c((Bitmap)localObject2, 50, 50);
      GlobalImageCache.a.put("story_user_avatar", localObject3);
      ((Bitmap)localObject2).recycle();
      ThreadManager.getUIHandler().post(new EditVideoLimitRegion.1.1(this, (String)localObject1, (Bitmap)localObject3));
      return;
    }
    catch (Exception localException)
    {
      label100:
      break label100;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "user Head Path can't read");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion.1
 * JD-Core Version:    0.7.0.1
 */