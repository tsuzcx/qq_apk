import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2;

public class bmfj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bmfj(EditProviderPart.2 param2) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if ((this.a.this$0.jdField_a_of_type_Bmkf == null) || (bmfh.a(this.a.this$0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditProviderPart", 2, "initTransitionRecommendView onGlobalLayout null");
      }
      return;
    }
    Object localObject = bmfh.a(this.a.this$0).getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
    }
    localObject = this.a.this$0.jdField_a_of_type_Bmix.a();
    if (localObject != null)
    {
      int i = ((View)localObject).getLeft();
      int j = ((View)localObject).getWidth() / 2;
      int k = bmfh.a(this.a.this$0).getWidth() / 2;
      bmfh.a(this.a.this$0).setX(j + i - k);
    }
    localObject = (GridView)this.a.this$0.a(2131378199);
    ((GridView)localObject).setNumColumns(3);
    ((GridView)localObject).setSelector(new ColorDrawable(0));
    ((GridView)localObject).setClipToPadding(false);
    ((GridView)localObject).setVerticalScrollBarEnabled(false);
    ((GridView)localObject).setHorizontalScrollBarEnabled(false);
    ((GridView)localObject).setOverScrollMode(2);
    blmw localblmw = new blmw(this.a.this$0.a(), this.a.this$0.b());
    localblmw.a = true;
    localblmw.a(this.a.a);
    ((GridView)localObject).setAdapter(localblmw);
    ((GridView)localObject).setOnItemClickListener(new bmfk(this, localblmw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfj
 * JD-Core Version:    0.7.0.1
 */