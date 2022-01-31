import android.view.ViewTreeObserver.OnScrollChangedListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton;

public class aobd
  implements ViewTreeObserver.OnScrollChangedListener
{
  public aobd(EditVideoButton paramEditVideoButton) {}
  
  public void onScrollChanged()
  {
    EditVideoButton.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobd
 * JD-Core Version:    0.7.0.1
 */