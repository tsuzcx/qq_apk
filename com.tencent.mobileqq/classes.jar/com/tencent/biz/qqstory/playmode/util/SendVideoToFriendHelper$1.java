package com.tencent.biz.qqstory.playmode.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import bdda;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.io.IOException;
import uht;
import vhj;
import vhx;
import vhz;
import wsv;
import xod;
import xpc;

public class SendVideoToFriendHelper$1
  implements Runnable
{
  public SendVideoToFriendHelper$1(vhx paramvhx, long paramLong, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    wsv.d("SendVideoToFriendHelper", "generateShareThumb run start: %d.", new Object[] { Long.valueOf(l - this.jdField_a_of_type_Long) });
    vhx.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoLocalThumbnailPath)) {
      wsv.b("SendVideoToFriendHelper", "video thumbnail has existed.");
    }
    for (Object localObject1 = SafeBitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoLocalThumbnailPath);; localObject1 = xod.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels))
    {
      wsv.d("SendVideoToFriendHelper", "generate share thumbnail step first cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (localObject1 != null) {
        break;
      }
      localObject1 = new vhz(new ErrorMessage(-1, "generate thumbnail failed."), this.jdField_a_of_type_JavaLangString);
      uht.a().dispatch((Dispatcher.Dispatchable)localObject1);
      return;
    }
    l = System.currentTimeMillis();
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath)) {
      localObject2 = xpc.a((Bitmap)localObject1, SafeBitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath));
    }
    wsv.d("SendVideoToFriendHelper", "generate share thumbnail step second cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    Object localObject3 = xpc.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = xpc.a((Bitmap)localObject2, (Bitmap)localObject3);
    }
    wsv.d("SendVideoToFriendHelper", "generate share thumbnail step third cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    localObject3 = xpc.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = xpc.a((Bitmap)localObject1, (Bitmap)localObject3);
    }
    wsv.d("SendVideoToFriendHelper", "generate share thumbnail step forth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    wsv.d("SendVideoToFriendHelper", "generate share thumbnail step fifth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    localObject1 = vhj.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, true);
    localObject3 = new File((String)localObject1);
    for (;;)
    {
      try
      {
        bdda.a((Bitmap)localObject2, (File)localObject3);
        ((Bitmap)localObject2).recycle();
        wsv.c("SendVideoToFriendHelper", "generate thumbnail failed. e = %s.", localIOException1);
      }
      catch (IOException localIOException1)
      {
        try
        {
          wsv.a("SendVideoToFriendHelper", "generate thumbnail success. shareThumbPath = %s.", localObject1);
          wsv.d("SendVideoToFriendHelper", "generate share thumbnail step sixth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          localObject2 = new vhz(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
          ((vhz)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          ((vhz)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
          uht.a().dispatch((Dispatcher.Dispatchable)localObject2);
          return;
        }
        catch (IOException localIOException2)
        {
          vhz localvhz;
          break label503;
        }
        localIOException1 = localIOException1;
        localObject1 = null;
      }
      label503:
      localvhz = new vhz(new ErrorMessage(-1, "generate thumbnail failed." + localIOException1.getMessage()), this.jdField_a_of_type_JavaLangString);
      uht.a().dispatch(localvhz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */