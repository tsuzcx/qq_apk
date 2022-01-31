import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import java.util.List;

public class aoag
  implements Runnable
{
  public aoag(EditProviderPart paramEditProviderPart, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) || (EditProviderPart.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditProviderPart", 2, "initTransitionRecommendView postDelayed null");
      }
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(41);
    EditProviderPart.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart).setVisibility(0);
    EditProviderPart.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart).getViewTreeObserver().addOnGlobalLayoutListener(new aoah(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoag
 * JD-Core Version:    0.7.0.1
 */