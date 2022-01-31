import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import com.tencent.qphone.base.util.QLog;

public class aqiy
  extends LinearLayoutManager
{
  public aqiy(Context paramContext)
  {
    super(paramContext);
  }
  
  public aqiy(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    }
    catch (IndexOutOfBoundsException paramRecycler)
    {
      QLog.e("WrapContentLinearLayoutManager", 1, "onLayoutChildren fail!", paramRecycler);
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      paramInt = super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
      return paramInt;
    }
    catch (IndexOutOfBoundsException paramRecycler)
    {
      QLog.e("WrapContentLinearLayoutManager", 1, "scrollHorizontallyBy fail!", paramRecycler);
    }
    return 0;
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
      return paramInt;
    }
    catch (IndexOutOfBoundsException paramRecycler)
    {
      QLog.e("WrapContentLinearLayoutManager", 1, "scrollVerticallyBy fail!", paramRecycler);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqiy
 * JD-Core Version:    0.7.0.1
 */