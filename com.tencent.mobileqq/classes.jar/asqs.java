import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asqs
  implements View.OnClickListener
{
  public asqs(Face2FaceFriendDetailView paramFace2FaceFriendDetailView) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqs
 * JD-Core Version:    0.7.0.1
 */