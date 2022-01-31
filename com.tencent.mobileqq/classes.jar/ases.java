import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class ases
  extends RecyclerView.OnScrollListener
{
  ases(asep paramasep) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      asep.a(this.a).c();
    }
    while (!asep.a(this.a).a()) {
      return;
    }
    asep.a(this.a).b();
    asep.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ases
 * JD-Core Version:    0.7.0.1
 */