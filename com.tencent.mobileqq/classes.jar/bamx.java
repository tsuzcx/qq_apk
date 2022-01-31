import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.qphone.base.util.QLog;

public class bamx
  extends RecyclerView.OnScrollListener
{
  public bamx(AddedRobotView paramAddedRobotView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("AddedRobotView", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      AddedRobotView.a(this.a).c();
    }
    while (!AddedRobotView.a(this.a).a()) {
      return;
    }
    AddedRobotView.a(this.a).b();
    AddedRobotView.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bamx
 * JD-Core Version:    0.7.0.1
 */