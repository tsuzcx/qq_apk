package com.tencent.biz.qqstory.playmode.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import bheg;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.io.IOException;
import vzh;
import wad;
import wzk;
import wzt;
import zdr;
import zeb;

public final class PlayModeUtils$5
  implements Runnable
{
  public PlayModeUtils$5(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt) {}
  
  public void run()
  {
    String str2 = wzk.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, true);
    File localFile = new File(str2);
    Object localObject1 = UIUtils.getLocalVideoThumbnail(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, wzk.a().getResources().getDisplayMetrics().widthPixels, wzk.a().getResources().getDisplayMetrics().heightPixels);
    if ((!zeb.c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath)) || (localObject1 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "storyVideoItem.mLocalVideoPath: " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath + " or retriever.getFrameAtTime == null");
      }
      localObject1 = new wzt(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      wad.a().dispatch((Dispatcher.Dispatchable)localObject1);
      return;
    }
    Object localObject2 = FFmpegUtils.getVideoDownloadWatermarkPath(wzk.a(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight, this.jdField_a_of_type_Int);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "download water mark failed");
    }
    Object localObject3 = FFmpegUtils.getVideoMaxMaskPath(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    localObject1 = FFmpegUtils.getVideoVoteWidgetPath(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    String str1 = FFmpegUtils.generateInteractWidgetImage(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    while ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      str1 = vzh.u;
      str1 = str1 + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
      if (!FFmpegUtils.combineTwoImg((String)localObject3, (String)localObject1, str1))
      {
        localObject1 = new wzt(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        wad.a().dispatch((Dispatcher.Dispatchable)localObject1);
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
        return;
        localObject1 = str1;
      }
      else
      {
        localObject1 = str1;
      }
    }
    while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject3 = localObject2;
      if (FFmpegUtils.combineTwoImg((String)localObject1, (String)localObject2, (String)localObject2)) {
        break label433;
      }
      localObject1 = new wzt(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      wad.a().dispatch((Dispatcher.Dispatchable)localObject1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg failed");
      return;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject3 = localObject1;
      label433:
      localObject1 = UIUtils.getLocalVideoThumbnail(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, wzk.a().getResources().getDisplayMetrics().widthPixels, wzk.a().getResources().getDisplayMetrics().heightPixels);
      if (localObject1 != null) {
        break;
      }
      localObject1 = new wzt(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      wad.a().dispatch((Dispatcher.Dispatchable)localObject1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "getLocalVideoThumbnail failed");
      return;
      localObject1 = localObject2;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = SafeBitmapFactory.decodeFile((String)localObject3);
      localObject2 = zdr.c((Bitmap)localObject1, (Bitmap)localObject3);
      ((Bitmap)localObject1).recycle();
      ((Bitmap)localObject3).recycle();
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        bheg.a((Bitmap)localObject1, new File(str2));
        ((Bitmap)localObject1).recycle();
        zeb.b(wzk.a(), localFile);
        localObject1 = new wzt(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((wzt)localObject1).b = str2;
        wad.a().dispatch((Dispatcher.Dispatchable)localObject1);
        return;
      }
      catch (IOException localIOException)
      {
        localObject2 = new wzt(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        wad.a().dispatch((Dispatcher.Dispatchable)localObject2);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg IOException " + localIOException.getMessage());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.5
 * JD-Core Version:    0.7.0.1
 */