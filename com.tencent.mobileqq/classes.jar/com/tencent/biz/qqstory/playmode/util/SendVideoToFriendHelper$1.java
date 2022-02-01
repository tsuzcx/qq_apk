package com.tencent.biz.qqstory.playmode.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.io.IOException;

class SendVideoToFriendHelper$1
  implements Runnable
{
  SendVideoToFriendHelper$1(SendVideoToFriendHelper paramSendVideoToFriendHelper, long paramLong, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    SLog.d("SendVideoToFriendHelper", "generateShareThumb run start: %d.", new Object[] { Long.valueOf(l - this.jdField_a_of_type_Long) });
    SendVideoToFriendHelper.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoLocalThumbnailPath)) {
      SLog.b("SendVideoToFriendHelper", "video thumbnail has existed.");
    }
    for (Object localObject1 = SafeBitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoLocalThumbnailPath);; localObject1 = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels))
    {
      SLog.d("SendVideoToFriendHelper", "generate share thumbnail step first cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (localObject1 != null) {
        break;
      }
      localObject1 = new SendVideoToFriendHelper.GenShareThumbEvent(new ErrorMessage(-1, "generate thumbnail failed."), this.jdField_a_of_type_JavaLangString);
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
      return;
    }
    l = System.currentTimeMillis();
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath)) {
      localObject2 = FFmpegUtils.combineTwoImg((Bitmap)localObject1, SafeBitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath));
    }
    SLog.d("SendVideoToFriendHelper", "generate share thumbnail step second cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    Object localObject3 = FFmpegUtils.generateVoteBitmap(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = FFmpegUtils.combineTwoImg((Bitmap)localObject2, (Bitmap)localObject3);
    }
    SLog.d("SendVideoToFriendHelper", "generate share thumbnail step third cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    localObject3 = FFmpegUtils.generateInteractBitmap(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = FFmpegUtils.combineTwoImg((Bitmap)localObject1, (Bitmap)localObject3);
    }
    SLog.d("SendVideoToFriendHelper", "generate share thumbnail step forth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    SLog.d("SendVideoToFriendHelper", "generate share thumbnail step fifth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    localObject1 = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, true);
    localObject3 = new File((String)localObject1);
    for (;;)
    {
      try
      {
        ImageUtil.a((Bitmap)localObject2, (File)localObject3);
        ((Bitmap)localObject2).recycle();
        SLog.c("SendVideoToFriendHelper", "generate thumbnail failed. e = %s.", localIOException1);
      }
      catch (IOException localIOException1)
      {
        try
        {
          SLog.a("SendVideoToFriendHelper", "generate thumbnail success. shareThumbPath = %s.", localObject1);
          SLog.d("SendVideoToFriendHelper", "generate share thumbnail step sixth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          localObject2 = new SendVideoToFriendHelper.GenShareThumbEvent(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
          ((SendVideoToFriendHelper.GenShareThumbEvent)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          ((SendVideoToFriendHelper.GenShareThumbEvent)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
          StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject2);
          return;
        }
        catch (IOException localIOException2)
        {
          SendVideoToFriendHelper.GenShareThumbEvent localGenShareThumbEvent;
          break label503;
        }
        localIOException1 = localIOException1;
        localObject1 = null;
      }
      label503:
      localGenShareThumbEvent = new SendVideoToFriendHelper.GenShareThumbEvent(new ErrorMessage(-1, "generate thumbnail failed." + localIOException1.getMessage()), this.jdField_a_of_type_JavaLangString);
      StoryDispatcher.a().dispatch(localGenShareThumbEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */