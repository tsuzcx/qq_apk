import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.FolderTextView;

public class bepu
  implements View.OnClickListener
{
  public bepu(FolderTextView paramFolderTextView) {}
  
  public void onClick(View paramView)
  {
    if (FolderTextView.a(this.a) == 0) {
      FolderTextView.a(this.a, 1);
    }
    for (;;)
    {
      FolderTextView.a(this.a);
      return;
      FolderTextView.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepu
 * JD-Core Version:    0.7.0.1
 */