import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;

class bmlu
  implements bmtn
{
  bmlu(bmlp parambmlp) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    if (this.a.jdField_a_of_type_Bmnj.a == 27) {
      this.a.jdField_a_of_type_Bmnj.a(0);
    }
    if (this.a.jdField_a_of_type_Bmnj.a == 36)
    {
      bmjf localbmjf = (bmjf)this.a.a(bmjf.class);
      if (localbmjf != null) {
        localbmjf.c();
      }
      this.a.jdField_a_of_type_Bmnj.a(0);
    }
  }
  
  public void a(bmyj parambmyj)
  {
    if ((this.a.jdField_a_of_type_Bmnj.h() != 0) && (bmnj.a(bmlp.a(this.a), 134217728)))
    {
      VideoSegmentPickerProviderView localVideoSegmentPickerProviderView = (VideoSegmentPickerProviderView)this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111);
      if (localVideoSegmentPickerProviderView != null)
      {
        bmjf localbmjf = (bmjf)this.a.a(bmjf.class);
        if (localbmjf != null)
        {
          localVideoSegmentPickerProviderView.setPlayMode(localbmjf.a());
          localbmjf.h_();
          localbmjf.b();
        }
      }
      this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111, new Object[] { parambmyj });
      if (this.a.jdField_a_of_type_Bmnj.a == 0) {
        this.a.jdField_a_of_type_Bmnj.a(36);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(103, new Object[] { parambmyj });
    } while (this.a.jdField_a_of_type_Bmnj.a != 0);
    this.a.jdField_a_of_type_Bmnj.a(27);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlu
 * JD-Core Version:    0.7.0.1
 */