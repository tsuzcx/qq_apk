import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import dov.com.qq.im.capture.poi.FacePoiSearchUI;
import java.util.ArrayList;

public class annf
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public annf(FacePoiSearchUI paramFacePoiSearchUI) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      InputMethodUtil.b(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.h);
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a.size())) {
      return;
    }
    FacePoiSearchUI.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     annf
 * JD-Core Version:    0.7.0.1
 */