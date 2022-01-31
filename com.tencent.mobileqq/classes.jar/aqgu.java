import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class aqgu
  extends RecyclerView.OnScrollListener
{
  aqgu(aqgr paramaqgr) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      aqgr.a(this.a).c();
    }
    while (!aqgr.a(this.a).a()) {
      return;
    }
    aqgr.a(this.a).b();
    aqgr.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgu
 * JD-Core Version:    0.7.0.1
 */