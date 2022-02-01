package com.tencent.biz.qqstory.playmode.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.io.IOException;

final class PlayModeUtils$5
  implements Runnable
{
  PlayModeUtils$5(StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void run()
  {
    String str = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, true);
    File localFile = new File(str);
    Object localObject1 = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, PlayModeUtils.a().getResources().getDisplayMetrics().widthPixels, PlayModeUtils.a().getResources().getDisplayMetrics().heightPixels);
    if ((FileUtils.c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath)) && (localObject1 != null))
    {
      Object localObject3 = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, PlayModeUtils.a().getResources().getDisplayMetrics().widthPixels, PlayModeUtils.a().getResources().getDisplayMetrics().heightPixels);
      if (localObject3 == null)
      {
        localObject1 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "getLocalVideoThumbnail failed");
        return;
      }
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(null))
      {
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(null);
        localObject1 = BitmapUtils.c((Bitmap)localObject3, localBitmap);
        ((Bitmap)localObject3).recycle();
        localBitmap.recycle();
      }
      try
      {
        ImageUtil.a((Bitmap)localObject1, new File(str));
        ((Bitmap)localObject1).recycle();
        FileUtils.b(PlayModeUtils.a(), localFile);
        localObject1 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((PlayModeUtils.DownloadStatusChangeEvent)localObject1).b = str;
        StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
        return;
      }
      catch (IOException localIOException)
      {
        localObject3 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("FFmpegUtils combineTwoImg IOException ");
          ((StringBuilder)localObject3).append(localIOException.getMessage());
          QLog.e("FFmpegCmd", 2, ((StringBuilder)localObject3).toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("storyVideoItem.mLocalVideoPath: ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath);
      ((StringBuilder)localObject2).append(" or retriever.getFrameAtTime == null");
      QLog.e("FFmpegCmd", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.5
 * JD-Core Version:    0.7.0.1
 */