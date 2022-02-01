import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class auiv
  extends RecyclerView.OnScrollListener
{
  auiv(auis paramauis) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      auis.a(this.a).c();
    }
    while (!auis.a(this.a).a()) {
      return;
    }
    auis.a(this.a).b();
    auis.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiv
 * JD-Core Version:    0.7.0.1
 */