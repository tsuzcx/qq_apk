import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;

public class bpvs
  extends RecyclerView.OnScrollListener
{
  private boolean jdField_a_of_type_Boolean;
  
  public bpvs(HorizontalAlumbListLayout paramHorizontalAlumbListLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 1) && (!this.jdField_a_of_type_Boolean))
    {
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a.getActivity() != null)) {
        yqu.a("video_edit_new", "swap_albumbar", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a.getActivity().getIntent(), new String[0]);
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpvs
 * JD-Core Version:    0.7.0.1
 */