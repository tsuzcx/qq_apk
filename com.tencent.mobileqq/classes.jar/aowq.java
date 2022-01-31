import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.List;

public class aowq
  implements Runnable
{
  public aowq(VideoFilterPlayView paramVideoFilterPlayView, int paramInt) {}
  
  public void run()
  {
    if (VideoFilterPlayView.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView) != null)
    {
      List localList = VideoFilterPlayView.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView).a(160);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQTransferFilter))) {
        ((QQTransferFilter)localList.get(0)).a(HWVideoDecoder.a(this.jdField_a_of_type_Int));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aowq
 * JD-Core Version:    0.7.0.1
 */