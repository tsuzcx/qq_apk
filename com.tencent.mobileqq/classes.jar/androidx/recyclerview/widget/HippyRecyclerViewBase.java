package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HippyRecyclerViewBase
  extends EasyRecyclerView
{
  public HippyRecyclerViewBase(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public HippyRecyclerViewBase(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HippyRecyclerViewBase(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  String exceptionLabel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.exceptionLabel());
    localStringBuilder.append(",state:");
    localStringBuilder.append(getStateInfo());
    return localStringBuilder.toString();
  }
  
  public String getStateInfo()
  {
    if (this.mState != null) {
      return this.mState.toString();
    }
    return null;
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    if (this.mLayoutSuppressed) {
      return;
    }
    stopScroll();
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager instanceof LinearLayoutManager)) {
      ((LinearLayoutManager)localLayoutManager).scrollToPositionWithOffset(paramInt1, paramInt2);
    } else {
      this.mLayout.scrollToPosition(paramInt1);
    }
    awakenScrollBars();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.HippyRecyclerViewBase
 * JD-Core Version:    0.7.0.1
 */