import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class aqee
  extends RecyclerView.OnScrollListener
{
  aqee(aqeb paramaqeb) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      aqeb.a(this.a).c();
    }
    while (!aqeb.a(this.a).a()) {
      return;
    }
    aqeb.a(this.a).b();
    aqeb.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqee
 * JD-Core Version:    0.7.0.1
 */