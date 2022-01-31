import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoTag;
import dov.com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter;
import java.util.List;

public class aodx
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public aodx(EditVideoTag paramEditVideoTag) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == EditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag, EditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag)).a().size()) && (!EditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag, EditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag)).a()))
    {
      paramAbsListView = EditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag);
      EditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag, EditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag)).b(paramAbsListView);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aodx
 * JD-Core Version:    0.7.0.1
 */