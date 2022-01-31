import android.view.View;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.State;

public abstract interface antn<V extends View>
{
  public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     antn
 * JD-Core Version:    0.7.0.1
 */