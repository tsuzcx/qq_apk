import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common.Callbacks.Callback;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.ThumbnailResult;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;

public final class aowj
  implements Callbacks.Callback
{
  public aowj(Object paramObject) {}
  
  public Void a(Boolean arg1, MediaCodecThumbnailGenerator.ThumbnailResult paramThumbnailResult)
  {
    QLog.e(MediaUtil.a(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.a)
    {
      this.a.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aowj
 * JD-Core Version:    0.7.0.1
 */