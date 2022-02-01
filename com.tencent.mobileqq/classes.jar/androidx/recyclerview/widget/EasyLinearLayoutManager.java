package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.HashMap;

public class EasyLinearLayoutManager
  extends LinearLayoutManager
{
  public static final int INVALID_HEIGHT = -1;
  private static final RecyclerView.LayoutParams a = new RecyclerView.LayoutParams(0, 0);
  protected HashMap<Integer, Integer> itemBottomMarginMaps = new HashMap();
  protected HashMap<Integer, Integer> itemHeightMaps = new HashMap();
  protected HashMap<Integer, Integer> itemTopMarginMaps = new HashMap();
  
  public EasyLinearLayoutManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public EasyLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public EasyLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private static void a()
  {
    RecyclerView.LayoutParams localLayoutParams = a;
    localLayoutParams.height = 0;
    localLayoutParams.topMargin = 0;
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    localLayoutParams.bottomMargin = 0;
  }
  
  private void a(int paramInt1, RecyclerView.LayoutParams paramLayoutParams, int paramInt2)
  {
    this.itemBottomMarginMaps.put(Integer.valueOf(paramInt2), Integer.valueOf(paramLayoutParams.bottomMargin));
    this.itemTopMarginMaps.put(Integer.valueOf(paramInt2), Integer.valueOf(paramLayoutParams.topMargin));
    this.itemHeightMaps.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
  }
  
  int a(int paramInt)
  {
    Object localObject = this.mRecyclerView.getAdapter();
    if ((localObject instanceof IItemLayoutParams))
    {
      localObject = (IItemLayoutParams)localObject;
      a();
      ((IItemLayoutParams)localObject).getItemLayoutParams(paramInt, a);
      if (a.height >= 0)
      {
        a(a.height, a, paramInt);
        return a.height + a.bottomMargin + a.topMargin;
      }
    }
    return -1;
  }
  
  int b(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i <= paramInt)
    {
      Integer localInteger2 = (Integer)this.itemHeightMaps.get(Integer.valueOf(i));
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null) {
        localInteger1 = Integer.valueOf(a(i));
      }
      if ((localInteger1 != null) && (localInteger1.intValue() != -1))
      {
        j += localInteger1.intValue();
        i += 1;
      }
      else
      {
        return -1;
      }
    }
    return j;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    if ((getChildCount() > 0) && (getItemCount() > 0))
    {
      int i = findFirstVisibleItemPosition();
      View localView = findViewByPosition(i);
      i = b(i);
      if ((localView != null) && (i != -1)) {
        return i - this.mOrientationHelper.getDecoratedEnd(localView);
      }
      return super.computeVerticalScrollOffset(paramState);
    }
    return 0;
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    int i = b(getItemCount() - 1);
    if (i != -1) {
      return i;
    }
    return super.computeVerticalScrollRange(paramState);
  }
  
  public void layoutDecoratedWithMargins(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layoutDecoratedWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt4 - paramInt2, (RecyclerView.LayoutParams)paramView.getLayoutParams(), getPosition(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.EasyLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */