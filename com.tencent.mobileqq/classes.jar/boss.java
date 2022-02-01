import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2;

public class boss
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public boss(EditProviderPart.2 param2) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if ((this.a.this$0.jdField_a_of_type_Bouo == null) || (bosq.a(this.a.this$0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditProviderPart", 2, "initTransitionRecommendView onGlobalLayout null");
      }
      return;
    }
    Object localObject = bosq.a(this.a.this$0).getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
    }
    localObject = this.a.this$0.jdField_a_of_type_Botw.a();
    if (localObject != null)
    {
      int i = ((View)localObject).getLeft();
      int j = ((View)localObject).getWidth() / 2;
      int k = bosq.a(this.a.this$0).getWidth() / 2;
      bosq.a(this.a.this$0).setX(j + i - k);
    }
    localObject = (GridView)this.a.this$0.a(2131379337);
    ((GridView)localObject).setNumColumns(3);
    ((GridView)localObject).setSelector(new ColorDrawable(0));
    ((GridView)localObject).setClipToPadding(false);
    ((GridView)localObject).setVerticalScrollBarEnabled(false);
    ((GridView)localObject).setHorizontalScrollBarEnabled(false);
    ((GridView)localObject).setOverScrollMode(2);
    bogu localbogu = new bogu(this.a.this$0.a(), this.a.this$0.b());
    localbogu.a = true;
    localbogu.a(this.a.a);
    ((GridView)localObject).setAdapter(localbogu);
    ((GridView)localObject).setOnItemClickListener(new bost(this, localbogu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boss
 * JD-Core Version:    0.7.0.1
 */