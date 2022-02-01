import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;

class bqyy
  implements View.OnClickListener
{
  bqyy(bqyx parambqyx) {}
  
  public void onClick(View paramView)
  {
    QZLog.d("QzoneEditPicturePartSav", 2, "onClick save button");
    this.a.a.a(19);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqyy
 * JD-Core Version:    0.7.0.1
 */