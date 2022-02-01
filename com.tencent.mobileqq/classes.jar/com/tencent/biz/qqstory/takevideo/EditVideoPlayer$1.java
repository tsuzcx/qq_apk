package com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import java.util.List;
import xvv;
import xzn;
import yax;

public class EditVideoPlayer$1
  implements Runnable
{
  public EditVideoPlayer$1(xzn paramxzn, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (this.a < localList.size())) {}
    try
    {
      ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((yax)localList.get(this.a));
      if (this.a > this.b) {
        this.this$0.b.post(new EditVideoPlayer.1.1(this));
      }
      if ((localList != null) && (this.b < localList.size())) {
        this.this$0.a((yax)localList.get(this.b));
      }
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        xvv.c("Q.qqstory.record.EditVideoPlayer", "setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */