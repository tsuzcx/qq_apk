import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import dov.com.tencent.biz.qqstory.takevideo.poilist.SearchPoiListLayout;
import java.util.ArrayList;

public class aolz
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public aolz(SearchPoiListLayout paramSearchPoiListLayout) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      InputMethodUtil.b(SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout));
    }
    while ((paramInt != 0) || (SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout) == null) || (this.jdField_a_of_type_Int < SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout).size())) {
      return;
    }
    SearchPoiListLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPoilistSearchPoiListLayout);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aolz
 * JD-Core Version:    0.7.0.1
 */