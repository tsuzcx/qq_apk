import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;

public class aosu
  implements View.OnClickListener
{
  public aosu(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void onClick(View paramView)
  {
    QfileLocalFilePicTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosu
 * JD-Core Version:    0.7.0.1
 */