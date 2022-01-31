import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class aqec
  extends RecyclerView.OnScrollListener
{
  aqec(aqdz paramaqdz) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      aqdz.a(this.a).c();
    }
    while (!aqdz.a(this.a).a()) {
      return;
    }
    aqdz.a(this.a).b();
    aqdz.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqec
 * JD-Core Version:    0.7.0.1
 */