import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.MultiOperateException;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.RecordVideoBlockInfo;
import java.util.List;

public class aodf
  implements Runnable
{
  public aodf(EditVideoPlayer paramEditVideoPlayer, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayer.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (this.jdField_a_of_type_Int < localList.size())) {}
    try
    {
      ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayer.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((MultiBlockVideoPlayer.RecordVideoBlockInfo)localList.get(this.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_Int > this.b) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayer.b.post(new aodg(this));
      }
      if ((localList != null) && (this.b < localList.size())) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPlayer.a((MultiBlockVideoPlayer.RecordVideoBlockInfo)localList.get(this.b));
      }
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.record.EditVideoPlayer", "setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aodf
 * JD-Core Version:    0.7.0.1
 */