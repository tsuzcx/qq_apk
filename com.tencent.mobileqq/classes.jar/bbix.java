import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.FolderTextView;

public class bbix
  implements View.OnClickListener
{
  public bbix(FolderTextView paramFolderTextView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbix
 * JD-Core Version:    0.7.0.1
 */