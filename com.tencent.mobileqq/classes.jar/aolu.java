import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import dov.com.qq.im.capture.poi.FacePoiManager;
import dov.com.tencent.biz.qqstory.takevideo.poilist.PoiListLayout;
import java.util.ArrayList;

public class aolu
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public aolu(PoiListLayout paramPoiListLayout) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (PoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout).a() != null) && (this.jdField_a_of_type_Int == PoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout).a().size() - 1)) {
      PoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistPoiListLayout).a();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aolu
 * JD-Core Version:    0.7.0.1
 */