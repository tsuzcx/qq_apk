import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import dov.com.tencent.mobileqq.shortvideo.filter.QQEncodeFilterRender;

public class aong
  implements HWEncodeListener
{
  public aong(MergeEditVideo paramMergeEditVideo, QQEncodeFilterRender paramQQEncodeFilterRender, int paramInt1, int paramInt2) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender.a(this.jdField_a_of_type_Int, this.b);
    }
  }
  
  public void a(String arg1)
  {
    synchronized (MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo))
    {
      MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo, true);
      MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo).notifyAll();
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender != null) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender.a();
      }
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    SLog.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + paramThrowable);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aong
 * JD-Core Version:    0.7.0.1
 */