import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer;

public class aodl
  implements Runnable
{
  public aodl(EditVideoPlayer paramEditVideoPlayer, int paramInt) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.jdField_a_of_type_Int));
    VideoSourceHelper.nativeSetPlayMode(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aodl
 * JD-Core Version:    0.7.0.1
 */