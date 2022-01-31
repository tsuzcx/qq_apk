import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView;

public class aofp
  implements Animation.AnimationListener
{
  public aofp(ArtFilterItemView paramArtFilterItemView, EditVideoArtFilter paramEditVideoArtFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a = false;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.setVisibility(8);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.a(true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aofp
 * JD-Core Version:    0.7.0.1
 */