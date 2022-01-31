import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class apkp
  extends RecyclerView.OnScrollListener
{
  apkp(apkm paramapkm) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      apkm.a(this.a).c();
    }
    while (!apkm.a(this.a).a()) {
      return;
    }
    apkm.a(this.a).b();
    apkm.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apkp
 * JD-Core Version:    0.7.0.1
 */