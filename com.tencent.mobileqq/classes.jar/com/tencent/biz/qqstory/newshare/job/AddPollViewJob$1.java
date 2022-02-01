package com.tencent.biz.qqstory.newshare.job;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.shareGroup.icon.UrlBitmapDownloader.Listener;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.net.URI;

class AddPollViewJob$1
  implements UrlBitmapDownloader.Listener
{
  AddPollViewJob$1(AddPollViewJob paramAddPollViewJob, StoryVideoItem.PollLayout paramPollLayout) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    paramString = new PollContainerLayout(localBaseApplication);
    paramString.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout, -1, null);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setBackgroundDrawable(new BitmapDrawable(localBaseApplication.getResources(), paramBitmap));
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight()));
    localFrameLayout.addView(paramString, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramBitmap.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramBitmap.getHeight(), 1073741824));
    localFrameLayout.layout(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramString.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout, -1, null);
    paramString = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    Canvas localCanvas = new Canvas(paramString);
    localCanvas.drawBitmap(paramBitmap, new Matrix(), null);
    localFrameLayout.draw(localCanvas);
    paramBitmap = new StringBuilder();
    paramBitmap.append(localBaseApplication.getCacheDir().getAbsolutePath());
    paramBitmap.append("/");
    paramBitmap.append(System.currentTimeMillis());
    paramBitmap.append(".png");
    paramBitmap = paramBitmap.toString();
    if (BitmapUtils.a(paramString, paramBitmap))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobAddPollViewJob.a("result", new File(paramBitmap).toURI().toString());
    }
    else
    {
      paramBitmap = this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobAddPollViewJob;
      paramBitmap.a("result", paramBitmap.a.mVideoThumbnailUrl);
    }
    paramString.recycle();
    AddPollViewJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobAddPollViewJob, true);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobAddPollViewJob;
    paramString.a("result", paramString.a.mVideoThumbnailUrl);
    AddPollViewJob.b(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobAddPollViewJob, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.AddPollViewJob.1
 * JD-Core Version:    0.7.0.1
 */