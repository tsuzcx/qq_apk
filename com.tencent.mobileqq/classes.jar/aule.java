import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class aule
  extends RecyclerView.OnScrollListener
{
  aule(aulb paramaulb) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      aulb.a(this.a).c();
    }
    while (!aulb.a(this.a).a()) {
      return;
    }
    aulb.a(this.a).b();
    aulb.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aule
 * JD-Core Version:    0.7.0.1
 */