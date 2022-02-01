package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class SlideShowViewController$1
  implements SlideShowAdapter.onItemClipClickListener
{
  SlideShowViewController$1(SlideShowViewController paramSlideShowViewController) {}
  
  public void a(int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)SlideShowPhotoListManager.a().f().get(paramInt);
    if (localSlideItemInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(SlideShowViewController.a(this.a), 2, "slideItem is null, do not jump");
      }
      return;
    }
    int i = SlideShowPhotoListManager.a().d();
    Intent localIntent = new Intent();
    localIntent.putExtra("media_info", localSlideItemInfo.a);
    localIntent.putExtra("file_send_duration", localSlideItemInfo.h);
    localIntent.putExtra("from_slideshow_to_share", true);
    localIntent.putExtra("video_index", paramInt);
    localIntent.putExtra("start_index", localSlideItemInfo.p);
    localIntent.putExtra("end_index", localSlideItemInfo.q);
    localIntent.putExtra("scroll_x", localSlideItemInfo.o);
    if (i == 11) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    localIntent.putExtra("entrance_type", paramInt);
    boolean bool = SlideShowViewController.b(this.a) instanceof NewPhotoListActivity;
    Object localObject2 = "0";
    Object localObject1;
    if (bool) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    localIntent.putExtra("op_entrance_type", (String)localObject1);
    localIntent.putExtra("start_time", localSlideItemInfo.i);
    localIntent.putExtra("end_time", localSlideItemInfo.j);
    localIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
    localIntent.setClass(SlideShowViewController.b(this.a), LocalVideoSelectActivity.class);
    SlideShowViewController.b(this.a).startActivityForResult(localIntent, 24747);
    if (i == 11) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if ((SlideShowViewController.b(this.a) instanceof NewPhotoListActivity)) {
      localObject1 = localObject2;
    } else {
      localObject1 = "1";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localSlideItemInfo.i);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(localSlideItemInfo.j);
    StoryReportor.a("pic_choose", "clk_cutVideo", paramInt, 0, new String[] { localObject1, ((StringBuilder)localObject2).toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController.1
 * JD-Core Version:    0.7.0.1
 */