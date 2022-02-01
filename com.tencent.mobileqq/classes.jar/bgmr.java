import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.qphone.base.util.QLog;

public class bgmr
  extends RecyclerView.OnScrollListener
{
  public bgmr(AddedRobotView paramAddedRobotView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("AddedRobotView", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      AddedRobotView.a(this.a).pause();
    }
    while (!AddedRobotView.a(this.a).isPausing()) {
      return;
    }
    AddedRobotView.a(this.a).resume();
    AddedRobotView.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgmr
 * JD-Core Version:    0.7.0.1
 */