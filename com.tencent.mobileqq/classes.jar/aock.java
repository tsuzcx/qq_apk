import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.VideoFrameLoaderListener;
import java.lang.ref.WeakReference;
import java.util.List;

public class aock
  implements Runnable
{
  public aock(VideoFrameLoader paramVideoFrameLoader, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != VideoFrameLoader.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoFrameLoader).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    VideoFrameLoader.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoFrameLoader).add(this.jdField_a_of_type_AndroidGraphicsBitmap);
    VideoFrameLoader.VideoFrameLoaderListener localVideoFrameLoaderListener = null;
    if (VideoFrameLoader.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoFrameLoader) != null) {
      localVideoFrameLoaderListener = (VideoFrameLoader.VideoFrameLoaderListener)VideoFrameLoader.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoVideoFrameLoader).get();
    }
    if (localVideoFrameLoaderListener != null) {
      localVideoFrameLoaderListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aock
 * JD-Core Version:    0.7.0.1
 */