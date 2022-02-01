import android.os.Bundle;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import java.util.ArrayList;

public class bova
  implements aang
{
  public bova(LocalVideoSelectActivity paramLocalVideoSelectActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, FrameVideoHelper paramFrameVideoHelper) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity.isFinishing())
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity.b();
      Bundle localBundle = new Bundle();
      if (paramArrayList != null)
      {
        localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", paramArrayList);
        localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", paramLong);
      }
      bpij.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity, LocalVideoSelectActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity), LocalVideoSelectActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity), this.jdField_a_of_type_Int, this.b, this.c, this.d, 0, "", "", false, LocalVideoSelectActivity.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity), this.e, localBundle);
      this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bova
 * JD-Core Version:    0.7.0.1
 */