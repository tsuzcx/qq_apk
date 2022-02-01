import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

class auvd
  extends RecyclerView.OnScrollListener
{
  auvd(auva paramauva) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      auva.a(this.a).pause();
    }
    while (!auva.a(this.a).isPausing()) {
      return;
    }
    auva.a(this.a).resume();
    auva.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvd
 * JD-Core Version:    0.7.0.1
 */