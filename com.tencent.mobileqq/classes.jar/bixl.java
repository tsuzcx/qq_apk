import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bixl
  implements View.OnClickListener
{
  public bixl(QUSDragFloatingScreenView paramQUSDragFloatingScreenView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "on empty click");
    }
    if (QUSDragFloatingScreenView.a(this.a) != null) {
      QUSDragFloatingScreenView.a(this.a).d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixl
 * JD-Core Version:    0.7.0.1
 */