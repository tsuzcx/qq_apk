import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common.Callbacks.Callback;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.ThumbnailProgress;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil.FrameWithoutBlackResult;

public final class anxp
  implements Callbacks.Callback
{
  public anxp(MediaUtil.FrameWithoutBlackResult paramFrameWithoutBlackResult) {}
  
  public Void a(Boolean paramBoolean, MediaCodecThumbnailGenerator.ThumbnailProgress paramThumbnailProgress)
  {
    if (paramThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = paramThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap;
      this.a.jdField_a_of_type_Long = paramThumbnailProgress.jdField_a_of_type_Long;
      QLog.e(MediaUtil.a(), 2, "MediaCodecThumbnailGenerator progress " + paramThumbnailProgress.jdField_a_of_type_Long);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxp
 * JD-Core Version:    0.7.0.1
 */