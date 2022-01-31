import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.List;

public class aowr
  implements Runnable
{
  public aowr(VideoFilterPlayView paramVideoFilterPlayView, TransferData paramTransferData) {}
  
  public void run()
  {
    if (VideoFilterPlayView.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView) != null)
    {
      if (!VideoFilterPlayView.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView).b(160)) {
        VideoFilterPlayView.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView).a();
      }
      Object localObject = VideoFilterPlayView.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView).a(160);
      if ((localObject != null) && (((List)localObject).size() > 0) && ((((List)localObject).get(0) instanceof QQTransferFilter)))
      {
        localObject = (QQTransferFilter)((List)localObject).get(0);
        ((QQTransferFilter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData);
        ((QQTransferFilter)localObject).a(HWVideoDecoder.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aowr
 * JD-Core Version:    0.7.0.1
 */