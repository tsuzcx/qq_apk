import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2;

public class bjtz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bjtz(EditProviderPart.2 param2) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if ((this.a.this$0.jdField_a_of_type_Bjyv == null) || (bjtx.a(this.a.this$0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditProviderPart", 2, "initTransitionRecommendView onGlobalLayout null");
      }
      return;
    }
    Object localObject = bjtx.a(this.a.this$0).getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
    }
    localObject = this.a.this$0.jdField_a_of_type_Bjxn.a();
    if (localObject != null)
    {
      int i = ((View)localObject).getLeft();
      int j = ((View)localObject).getWidth() / 2;
      int k = bjtx.a(this.a.this$0).getWidth() / 2;
      bjtx.a(this.a.this$0).setX(j + i - k);
    }
    localObject = (GridView)this.a.this$0.a(2131377658);
    ((GridView)localObject).setNumColumns(3);
    ((GridView)localObject).setSelector(new ColorDrawable(0));
    ((GridView)localObject).setClipToPadding(false);
    ((GridView)localObject).setVerticalScrollBarEnabled(false);
    ((GridView)localObject).setHorizontalScrollBarEnabled(false);
    ((GridView)localObject).setOverScrollMode(2);
    bjbm localbjbm = new bjbm(this.a.this$0.a(), this.a.this$0.b());
    localbjbm.a = true;
    localbjbm.a(this.a.a);
    ((GridView)localObject).setAdapter(localbjbm);
    ((GridView)localObject).setOnItemClickListener(new bjua(this, localbjbm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtz
 * JD-Core Version:    0.7.0.1
 */