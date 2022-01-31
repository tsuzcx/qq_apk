package com.tencent.biz.qqstory.playmode.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import bbef;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.io.IOException;
import stb;
import tsr;
import ttf;
import tth;
import ved;
import vzl;
import wak;

public class SendVideoToFriendHelper$1
  implements Runnable
{
  public SendVideoToFriendHelper$1(ttf paramttf, long paramLong, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    ved.d("SendVideoToFriendHelper", "generateShareThumb run start: %d.", new Object[] { Long.valueOf(l - this.jdField_a_of_type_Long) });
    ttf.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoLocalThumbnailPath)) {
      ved.b("SendVideoToFriendHelper", "video thumbnail has existed.");
    }
    for (Object localObject1 = SafeBitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoLocalThumbnailPath);; localObject1 = vzl.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels))
    {
      ved.d("SendVideoToFriendHelper", "generate share thumbnail step first cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (localObject1 != null) {
        break;
      }
      localObject1 = new tth(new ErrorMessage(-1, "generate thumbnail failed."), this.jdField_a_of_type_JavaLangString);
      stb.a().dispatch((Dispatcher.Dispatchable)localObject1);
      return;
    }
    l = System.currentTimeMillis();
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath)) {
      localObject2 = wak.a((Bitmap)localObject1, SafeBitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath));
    }
    ved.d("SendVideoToFriendHelper", "generate share thumbnail step second cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    Object localObject3 = wak.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = wak.a((Bitmap)localObject2, (Bitmap)localObject3);
    }
    ved.d("SendVideoToFriendHelper", "generate share thumbnail step third cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    localObject3 = wak.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = wak.a((Bitmap)localObject1, (Bitmap)localObject3);
    }
    ved.d("SendVideoToFriendHelper", "generate share thumbnail step forth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    ved.d("SendVideoToFriendHelper", "generate share thumbnail step fifth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    localObject1 = tsr.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, true);
    localObject3 = new File((String)localObject1);
    for (;;)
    {
      try
      {
        bbef.a((Bitmap)localObject2, (File)localObject3);
        ((Bitmap)localObject2).recycle();
        ved.c("SendVideoToFriendHelper", "generate thumbnail failed. e = %s.", localIOException1);
      }
      catch (IOException localIOException1)
      {
        try
        {
          ved.a("SendVideoToFriendHelper", "generate thumbnail success. shareThumbPath = %s.", localObject1);
          ved.d("SendVideoToFriendHelper", "generate share thumbnail step sixth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          localObject2 = new tth(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
          ((tth)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          ((tth)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
          stb.a().dispatch((Dispatcher.Dispatchable)localObject2);
          return;
        }
        catch (IOException localIOException2)
        {
          tth localtth;
          break label503;
        }
        localIOException1 = localIOException1;
        localObject1 = null;
      }
      label503:
      localtth = new tth(new ErrorMessage(-1, "generate thumbnail failed." + localIOException1.getMessage()), this.jdField_a_of_type_JavaLangString);
      stb.a().dispatch(localtth);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */