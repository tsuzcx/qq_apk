import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

class aust
  extends RecyclerView.OnScrollListener
{
  aust(ausq paramausq) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      ausq.a(this.a).pause();
    }
    while (!ausq.a(this.a).isPausing()) {
      return;
    }
    ausq.a(this.a).resume();
    ausq.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aust
 * JD-Core Version:    0.7.0.1
 */