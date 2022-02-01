import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class avde
  extends RecyclerView.OnScrollListener
{
  avde(avdb paramavdb) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      avdb.a(this.a).c();
    }
    while (!avdb.a(this.a).a()) {
      return;
    }
    avdb.a(this.a).b();
    avdb.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avde
 * JD-Core Version:    0.7.0.1
 */