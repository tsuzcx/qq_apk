import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.MultiOperateException;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.RecordVideoBlockInfo;
import java.util.List;

public class aodm
  implements Runnable
{
  public aodm(EditVideoPlayer paramEditVideoPlayer) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilList = ((MultiBlockVideoPlayer)this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(true, 10000L, 6, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b(), this.a.jdField_a_of_type_Float);
    SLog.a("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess getMultiVideoInfo find %d blocks", Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()));
    if (this.a.jdField_a_of_type_JavaUtilList.size() > 0) {}
    try
    {
      ((MultiBlockVideoPlayer)this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((MultiBlockVideoPlayer.RecordVideoBlockInfo)this.a.jdField_a_of_type_JavaUtilList.get(0));
      EditVideoPlayer.a(this.a);
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aodm
 * JD-Core Version:    0.7.0.1
 */