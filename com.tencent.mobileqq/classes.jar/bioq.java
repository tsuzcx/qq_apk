import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bioq
  implements View.OnClickListener
{
  public bioq(FolderTextView paramFolderTextView) {}
  
  public void onClick(View paramView)
  {
    if (FolderTextView.a(this.a) == 0) {
      FolderTextView.a(this.a, 1);
    }
    for (;;)
    {
      FolderTextView.a(this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FolderTextView.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bioq
 * JD-Core Version:    0.7.0.1
 */