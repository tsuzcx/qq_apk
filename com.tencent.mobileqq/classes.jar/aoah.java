import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.TransitionProviderGridAdapter;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

class aoah
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aoah(aoag paramaoag) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) || (EditProviderPart.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditProviderPart", 2, "initTransitionRecommendView onGlobalLayout null");
      }
      return;
    }
    Object localObject = EditProviderPart.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart).getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
    }
    localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if (localObject != null)
    {
      int i = ((View)localObject).getLeft();
      int j = ((View)localObject).getWidth() / 2;
      int k = EditProviderPart.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart).getWidth() / 2;
      EditProviderPart.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart).setX(j + i - k);
    }
    localObject = (GridView)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.a(2131364502);
    ((GridView)localObject).setNumColumns(3);
    ((GridView)localObject).setSelector(new ColorDrawable(0));
    ((GridView)localObject).setClipToPadding(false);
    ((GridView)localObject).setVerticalScrollBarEnabled(false);
    ((GridView)localObject).setHorizontalScrollBarEnabled(false);
    ((GridView)localObject).setOverScrollMode(2);
    TransitionProviderGridAdapter localTransitionProviderGridAdapter = new TransitionProviderGridAdapter(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.a(), this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditProviderPart.b());
    localTransitionProviderGridAdapter.a = true;
    localTransitionProviderGridAdapter.a(this.a.jdField_a_of_type_JavaUtilList);
    ((GridView)localObject).setAdapter(localTransitionProviderGridAdapter);
    ((GridView)localObject).setOnItemClickListener(new aoai(this, localTransitionProviderGridAdapter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoah
 * JD-Core Version:    0.7.0.1
 */