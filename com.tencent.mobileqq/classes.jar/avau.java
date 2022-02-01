import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class avau
  extends RecyclerView.OnScrollListener
{
  avau(avar paramavar) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      avar.a(this.a).c();
    }
    while (!avar.a(this.a).a()) {
      return;
    }
    avar.a(this.a).b();
    avar.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avau
 * JD-Core Version:    0.7.0.1
 */