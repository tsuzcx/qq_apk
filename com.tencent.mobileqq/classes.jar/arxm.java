import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class arxm
  extends RecyclerView.OnScrollListener
{
  arxm(arxj paramarxj) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      arxj.a(this.a).c();
    }
    while (!arxj.a(this.a).a()) {
      return;
    }
    arxj.a(this.a).b();
    arxj.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxm
 * JD-Core Version:    0.7.0.1
 */