import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2;

public class bicl
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bicl(EditProviderPart.2 param2) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if ((this.a.this$0.jdField_a_of_type_Bihj == null) || (bicj.a(this.a.this$0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditProviderPart", 2, "initTransitionRecommendView onGlobalLayout null");
      }
      return;
    }
    Object localObject = bicj.a(this.a.this$0).getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
    }
    localObject = this.a.this$0.jdField_a_of_type_Bigb.a();
    if (localObject != null)
    {
      int i = ((View)localObject).getLeft();
      int j = ((View)localObject).getWidth() / 2;
      int k = bicj.a(this.a.this$0).getWidth() / 2;
      bicj.a(this.a.this$0).setX(j + i - k);
    }
    localObject = (GridView)this.a.this$0.a(2131311843);
    ((GridView)localObject).setNumColumns(3);
    ((GridView)localObject).setSelector(new ColorDrawable(0));
    ((GridView)localObject).setClipToPadding(false);
    ((GridView)localObject).setVerticalScrollBarEnabled(false);
    ((GridView)localObject).setHorizontalScrollBarEnabled(false);
    ((GridView)localObject).setOverScrollMode(2);
    bhgd localbhgd = new bhgd(this.a.this$0.a(), this.a.this$0.b());
    localbhgd.a = true;
    localbhgd.a(this.a.a);
    ((GridView)localObject).setAdapter(localbhgd);
    ((GridView)localObject).setOnItemClickListener(new bicm(this, localbhgd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bicl
 * JD-Core Version:    0.7.0.1
 */