import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class apne
  extends RecyclerView.OnScrollListener
{
  apne(apnb paramapnb) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      apnb.a(this.a).c();
    }
    while (!apnb.a(this.a).a()) {
      return;
    }
    apnb.a(this.a).b();
    apnb.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apne
 * JD-Core Version:    0.7.0.1
 */