import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;

public class aosy
  implements View.OnClickListener
{
  public aosy(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void onClick(View paramView)
  {
    QfileLocalFilePicTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosy
 * JD-Core Version:    0.7.0.1
 */