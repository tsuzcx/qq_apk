import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import com.tencent.biz.qqstory.utils.UIUtils;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton;

public class aobf
  implements Runnable
{
  public aobf(EditVideoButton paramEditVideoButton) {}
  
  public void run()
  {
    Object localObject = new Rect();
    EditVideoButton.a(this.a).setEnabled(true);
    EditVideoButton.a(this.a).getHitRect((Rect)localObject);
    if (this.a.a != null)
    {
      ((Rect)localObject).top -= UIUtils.a(this.a.a(), 8.0F);
      ((Rect)localObject).bottom += UIUtils.a(this.a.a(), 8.0F);
    }
    localObject = new TouchDelegate((Rect)localObject, EditVideoButton.a(this.a));
    ((View)EditVideoButton.a(this.a).getParent()).setTouchDelegate((TouchDelegate)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobf
 * JD-Core Version:    0.7.0.1
 */