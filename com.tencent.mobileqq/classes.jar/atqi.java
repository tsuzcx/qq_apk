import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

class atqi
  extends RecyclerView.OnScrollListener
{
  atqi(atqf paramatqf) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      atqf.a(this.a).pause();
    }
    while (!atqf.a(this.a).isPausing()) {
      return;
    }
    atqf.a(this.a).resume();
    atqf.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqi
 * JD-Core Version:    0.7.0.1
 */