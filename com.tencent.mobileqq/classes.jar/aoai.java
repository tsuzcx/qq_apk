import android.view.View;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import dov.com.qq.im.capture.adapter.TransitionProviderGridAdapter;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoTransfer;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.util.List;

class aoai
  implements AdapterView.OnItemClickListener
{
  aoai(aoah paramaoah, TransitionProviderGridAdapter paramTransitionProviderGridAdapter) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView == null) || (this.jdField_a_of_type_Aoah.a.jdField_a_of_type_JavaUtilList == null)) {}
    while (paramInt >= this.jdField_a_of_type_Aoah.a.jdField_a_of_type_JavaUtilList.size()) {
      return;
    }
    paramAdapterView = (TransitionCategoryItem)this.jdField_a_of_type_Aoah.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((paramAdapterView != null) && (!paramAdapterView.equals(VideoFilterTools.a().a())))
    {
      VideoFilterTools.a().a(paramAdapterView);
      this.jdField_a_of_type_DovComQqImCaptureAdapterTransitionProviderGridAdapter.a();
      paramInt = Integer.parseInt(paramAdapterView.a);
      this.jdField_a_of_type_Aoah.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.e(paramInt);
      StoryReportor.a("video_edit_transition", "clk_effects", EditVideoTransfer.a(this.jdField_a_of_type_Aoah.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.a.a.a("extra_transiton_src_from", -1)), 0, new String[] { paramAdapterView.i, paramAdapterView.l, paramAdapterView.j, paramAdapterView.k });
    }
    paramView.postDelayed(new aoaj(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoai
 * JD-Core Version:    0.7.0.1
 */