import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class aqgs
  extends RecyclerView.OnScrollListener
{
  aqgs(aqgp paramaqgp) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      aqgp.a(this.a).c();
    }
    while (!aqgp.a(this.a).a()) {
      return;
    }
    aqgp.a(this.a).b();
    aqgp.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgs
 * JD-Core Version:    0.7.0.1
 */