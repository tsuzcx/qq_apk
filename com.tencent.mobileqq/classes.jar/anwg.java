import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class anwg
  implements Runnable
{
  anwg(anwf paramanwf) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      HWEditLocalVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(0);
      HWEditLocalVideoPlayer.a(this.a.a, localMp4VideoFragmentInfo);
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 8));
      HWEditLocalVideoPlayer.a(this.a.a, this.a.a.jdField_a_of_type_Int);
      HWEditLocalVideoPlayer.a(this.a.a).set(true);
      this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a(true);
      return;
      SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwg
 * JD-Core Version:    0.7.0.1
 */