import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;

class bpda
  implements bpkt
{
  bpda(bpcv parambpcv) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    if (this.a.jdField_a_of_type_Bpep.a == 27) {
      this.a.jdField_a_of_type_Bpep.a(0);
    }
    if (this.a.jdField_a_of_type_Bpep.a == 36)
    {
      bpal localbpal = (bpal)this.a.a(bpal.class);
      if (localbpal != null) {
        localbpal.c();
      }
      this.a.jdField_a_of_type_Bpep.a(0);
    }
  }
  
  public void a(bppp parambppp)
  {
    if ((this.a.jdField_a_of_type_Bpep.h() != 0) && (bpep.a(bpcv.a(this.a), 134217728)))
    {
      VideoSegmentPickerProviderView localVideoSegmentPickerProviderView = (VideoSegmentPickerProviderView)this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111);
      if (localVideoSegmentPickerProviderView != null)
      {
        bpal localbpal = (bpal)this.a.a(bpal.class);
        if (localbpal != null)
        {
          localVideoSegmentPickerProviderView.setPlayMode(localbpal.a());
          localbpal.m_();
          localbpal.b();
        }
      }
      this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111, new Object[] { parambppp });
      if (this.a.jdField_a_of_type_Bpep.a == 0) {
        this.a.jdField_a_of_type_Bpep.a(36);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(103, new Object[] { parambppp });
    } while (this.a.jdField_a_of_type_Bpep.a != 0);
    this.a.jdField_a_of_type_Bpep.a(27);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpda
 * JD-Core Version:    0.7.0.1
 */