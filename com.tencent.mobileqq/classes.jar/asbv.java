import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class asbv
  extends RecyclerView.OnScrollListener
{
  asbv(asbs paramasbs) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      asbs.a(this.a).c();
    }
    while (!asbs.a(this.a).a()) {
      return;
    }
    asbs.a(this.a).b();
    asbs.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbv
 * JD-Core Version:    0.7.0.1
 */