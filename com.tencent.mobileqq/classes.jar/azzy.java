import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView;

public class azzy
  extends RecyclerView.OnScrollListener
{
  public azzy(AnonymousView paramAnonymousView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      AnonymousView.a(this.a).cancelPendingRequests();
      AnonymousView.a(this.a).pause();
    }
    while (!AnonymousView.a(this.a).isPausing()) {
      return;
    }
    AnonymousView.a(this.a).resume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzy
 * JD-Core Version:    0.7.0.1
 */