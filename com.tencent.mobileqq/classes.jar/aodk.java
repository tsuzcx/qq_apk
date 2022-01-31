import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer;

public class aodk
  implements Runnable
{
  public aodk(EditVideoPlayer paramEditVideoPlayer, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "setMosaic %d", Integer.valueOf(this.jdField_a_of_type_Int));
    VideoSourceHelper.nativeSetMosaic(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aodk
 * JD-Core Version:    0.7.0.1
 */