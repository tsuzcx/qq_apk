import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;

public class aowp
  implements Runnable
{
  public aowp(VideoFilterPlayView paramVideoFilterPlayView) {}
  
  public void run()
  {
    if (VideoFilterPlayView.b(this.a) != null)
    {
      VideoFilterPlayView.b(this.a).d();
      VideoFilterPlayView.a(this.a, null);
    }
    if (VideoFilterPlayView.a(this.a) != null)
    {
      VideoFilterPlayView.a(this.a).d();
      VideoFilterPlayView.b(this.a, null);
    }
    if (VideoFilterPlayView.a(this.a) != null)
    {
      VideoFilterPlayView.a(this.a).d();
      VideoFilterPlayView.a(this.a, null);
    }
    if (VideoFilterPlayView.a(this.a) != null)
    {
      VideoFilterPlayView.a(this.a).q();
      if (QLog.isColorLevel()) {
        QLog.w("VideoFilterPlayView", 2, "VideoPlay, surfaceDestroy success=");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aowp
 * JD-Core Version:    0.7.0.1
 */