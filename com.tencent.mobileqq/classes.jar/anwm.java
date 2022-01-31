import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo;

class anwm
  implements HWEncodeListener
{
  anwm(anwl paramanwl, HWEditLocalVideoPlayer.Mp4VideoFragmentInfo paramMp4VideoFragmentInfo) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$Mp4VideoFragmentInfo.a = paramString;
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "onEncodeFinish  iframe file filePath = " + paramString);
    this.jdField_a_of_type_Anwl.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a(new anwn(this), 0L);
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "encode error errorCode = " + paramInt + " Exception = " + paramThrowable);
    if (this.jdField_a_of_type_Anwl.b == 0)
    {
      this.jdField_a_of_type_Anwl.b = 1;
      this.jdField_a_of_type_Anwl.jdField_a_of_type_Int = 3;
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video by mIFrameInterval = " + this.jdField_a_of_type_Anwl.b + " mFrameRate = " + this.jdField_a_of_type_Anwl.jdField_a_of_type_Int);
      this.jdField_a_of_type_Anwl.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a(this.jdField_a_of_type_Anwl, 1000L);
      return;
    }
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video failed");
    try
    {
      ShortVideoExceptionReporter.a(paramThrowable);
      this.jdField_a_of_type_Anwl.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a(new anwo(this), 0L);
      return;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        paramThrowable.printStackTrace();
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwm
 * JD-Core Version:    0.7.0.1
 */