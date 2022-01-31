import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import java.util.List;

public class anwl
  implements Runnable
{
  public int a;
  public int b = 1;
  public int c;
  
  public anwl(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = 30;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt3;
  }
  
  @TargetApi(17)
  public void run()
  {
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "start convert i frame video. mVideoPath = " + HWEditLocalVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer));
    localObject1 = new MediaMetadataRetriever();
    try
    {
      ((MediaMetadataRetriever)localObject1).setDataSource(HWEditLocalVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer));
      str1 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
      str2 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
      localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(24);
      ((MediaMetadataRetriever)localObject1).release();
      i = 0;
    }
    catch (Exception localException)
    {
      String str1;
      String str2;
      Object localObject2;
      int i;
      int j;
      label96:
      long l1;
      long l2;
      SLog.c("Q.qqstory.record.HWEditLocalVideoPlayer", "setDataSource failed when convert i frame", localException);
      ((MediaMetadataRetriever)localObject1).release();
      return;
    }
    try
    {
      j = Integer.valueOf((String)localObject2).intValue();
      i = j;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      break label96;
    }
    HWEditLocalVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer, new Mp4ReEncoder());
    localObject1 = HWEditLocalVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer) + "_" + this.c + ".IFrames.mp4";
    if (this.b != 0) {
      HWEditLocalVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer).jdField_a_of_type_Int = (this.b * this.jdField_a_of_type_Int);
    }
    localObject2 = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a.get(this.c);
    l1 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject2);
    l2 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject2);
    HWEditLocalVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer).a(new DecodeConfig(HWEditLocalVideoPlayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer), 0, false, true, l1, l2), new EncodeConfig((String)localObject1, Integer.valueOf(str1).intValue(), Integer.valueOf(str2).intValue(), 12582912, this.b, this.jdField_a_of_type_Int, 0, false, i, null, null, null, false), new anwm(this, (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject2), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwl
 * JD-Core Version:    0.7.0.1
 */