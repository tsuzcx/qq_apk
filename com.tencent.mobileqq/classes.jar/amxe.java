import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import dov.com.qq.im.capture.poi.FacePoiManager;
import dov.com.qq.im.capture.poi.FacePoiUI;
import java.util.ArrayList;

public class amxe
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public amxe(FacePoiUI paramFacePoiUI) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (FacePoiUI.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI).a() != null) && (this.jdField_a_of_type_Int == FacePoiUI.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI).a().size() - 1)) {
      FacePoiUI.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI).a();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amxe
 * JD-Core Version:    0.7.0.1
 */