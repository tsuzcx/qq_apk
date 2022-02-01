package com.tencent.biz.qqstory.takevideo;

import java.util.List;
import ykq;
import yog;
import ypq;

public class EditVideoPlayer$7
  implements Runnable
{
  public EditVideoPlayer$7(yog paramyog) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(true, 10000L, 6, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.getWidth(), this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.getHeight(), this.this$0.jdField_a_of_type_Float);
    ykq.a("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess getMultiVideoInfo find %d blocks", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()));
    if (this.this$0.jdField_a_of_type_JavaUtilList.size() > 0) {}
    try
    {
      ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((ypq)this.this$0.jdField_a_of_type_JavaUtilList.get(0));
      yog.a(this.this$0);
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        ykq.c("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.7
 * JD-Core Version:    0.7.0.1
 */