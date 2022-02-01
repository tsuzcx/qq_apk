import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

class atny
  extends RecyclerView.OnScrollListener
{
  atny(atnv paramatnv) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      atnv.a(this.a).pause();
    }
    while (!atnv.a(this.a).isPausing()) {
      return;
    }
    atnv.a(this.a).resume();
    atnv.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atny
 * JD-Core Version:    0.7.0.1
 */