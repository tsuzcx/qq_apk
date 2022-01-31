import com.tencent.image.URLImageView;
import cooperation.qzone.widget.FastAnimationDrawable;
import dov.com.tencent.biz.qqstory.takevideo.EditGifImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class anau
  implements Runnable
{
  public anau(EditGifImage paramEditGifImage) {}
  
  public void run()
  {
    FastAnimationDrawable localFastAnimationDrawable = this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable;
    this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
    this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = this.a.b;
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
    this.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
    this.a.b = localFastAnimationDrawable;
    this.a.d = true;
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anau
 * JD-Core Version:    0.7.0.1
 */