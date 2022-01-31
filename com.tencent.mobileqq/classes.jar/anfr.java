import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.Mp4VideoFragmentInfo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class anfr
  implements Runnable
{
  anfr(anfq paramanfq) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo localMp4VideoFragmentInfo = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.a.a.jdField_a_of_type_JavaUtilList.get(0);
      HWEditImportVideoPlayer.a(this.a.a, localMp4VideoFragmentInfo);
    }
    for (;;)
    {
      this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 8));
      HWEditImportVideoPlayer.a(this.a.a).set(true);
      return;
      SLog.e("Q.qqstory.record.HWEditImportVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anfr
 * JD-Core Version:    0.7.0.1
 */