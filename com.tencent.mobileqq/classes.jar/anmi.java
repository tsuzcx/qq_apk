import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.VideoFrameLoaderListener;
import java.lang.ref.WeakReference;
import java.util.List;

public class anmi
  implements Runnable
{
  public anmi(VideoFrameLoader paramVideoFrameLoader, List paramList) {}
  
  public void run()
  {
    VideoFrameLoader.VideoFrameLoaderListener localVideoFrameLoaderListener = null;
    if (VideoFrameLoader.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoFrameLoader) != null) {
      localVideoFrameLoaderListener = (VideoFrameLoader.VideoFrameLoaderListener)VideoFrameLoader.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoFrameLoader).get();
    }
    if (localVideoFrameLoaderListener != null) {
      localVideoFrameLoaderListener.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmi
 * JD-Core Version:    0.7.0.1
 */