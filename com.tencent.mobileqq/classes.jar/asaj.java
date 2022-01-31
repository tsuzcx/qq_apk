import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class asaj
  extends RecyclerView.OnScrollListener
{
  asaj(asag paramasag) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      asag.a(this.a).c();
    }
    while (!asag.a(this.a).a()) {
      return;
    }
    asag.a(this.a).b();
    asag.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaj
 * JD-Core Version:    0.7.0.1
 */