package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class GhostViewHolder
  extends FrameLayout
{
  private boolean mAttached;
  @NonNull
  private ViewGroup mParent;
  
  GhostViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup.getContext());
    setClipChildren(false);
    this.mParent = paramViewGroup;
    this.mParent.setTag(R.id.ghost_view_holder, this);
    ViewGroupUtils.getOverlay(this.mParent).add(this);
    this.mAttached = true;
  }
  
  static GhostViewHolder getHolder(@NonNull ViewGroup paramViewGroup)
  {
    return (GhostViewHolder)paramViewGroup.getTag(R.id.ghost_view_holder);
  }
  
  private int getInsertIndex(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = getChildCount() - 1;
    int j = 0;
    while (j <= i)
    {
      int k = (j + i) / 2;
      getParents(((GhostViewPort)getChildAt(k)).mView, localArrayList);
      if (isOnTop(paramArrayList, localArrayList)) {
        j = k + 1;
      } else {
        i = k - 1;
      }
      localArrayList.clear();
    }
    return j;
  }
  
  private static void getParents(View paramView, ArrayList<View> paramArrayList)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      getParents((View)localViewParent, paramArrayList);
    }
    paramArrayList.add(paramView);
  }
  
  private static boolean isOnTop(View paramView1, View paramView2)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView1.getParent();
    int j = localViewGroup.getChildCount();
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if ((i >= 21) && (paramView1.getZ() != paramView2.getZ()))
    {
      if (paramView1.getZ() > paramView2.getZ()) {
        bool = true;
      }
      return bool;
    }
    i = 0;
    while (i < j)
    {
      View localView = localViewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(localViewGroup, i));
      if (localView == paramView1) {
        return false;
      }
      if (localView == paramView2) {
        return true;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean isOnTop(ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    if ((!paramArrayList1.isEmpty()) && (!paramArrayList2.isEmpty()))
    {
      boolean bool = false;
      if (paramArrayList1.get(0) != paramArrayList2.get(0)) {
        return true;
      }
      int j = Math.min(paramArrayList1.size(), paramArrayList2.size());
      int i = 1;
      while (i < j)
      {
        View localView1 = (View)paramArrayList1.get(i);
        View localView2 = (View)paramArrayList2.get(i);
        if (localView1 != localView2) {
          return isOnTop(localView1, localView2);
        }
        i += 1;
      }
      if (paramArrayList2.size() == j) {
        bool = true;
      }
      return bool;
    }
    return true;
  }
  
  void addGhostView(GhostViewPort paramGhostViewPort)
  {
    ArrayList localArrayList = new ArrayList();
    getParents(paramGhostViewPort.mView, localArrayList);
    int i = getInsertIndex(localArrayList);
    if ((i >= 0) && (i < getChildCount()))
    {
      addView(paramGhostViewPort, i);
      return;
    }
    addView(paramGhostViewPort);
  }
  
  public void onViewAdded(View paramView)
  {
    if (this.mAttached)
    {
      super.onViewAdded(paramView);
      return;
    }
    throw new IllegalStateException("This GhostViewHolder is detached!");
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    if (((getChildCount() == 1) && (getChildAt(0) == paramView)) || (getChildCount() == 0))
    {
      this.mParent.setTag(R.id.ghost_view_holder, null);
      ViewGroupUtils.getOverlay(this.mParent).remove(this);
      this.mAttached = false;
    }
  }
  
  void popToOverlayTop()
  {
    if (this.mAttached)
    {
      ViewGroupUtils.getOverlay(this.mParent).remove(this);
      ViewGroupUtils.getOverlay(this.mParent).add(this);
      return;
    }
    throw new IllegalStateException("This GhostViewHolder is detached!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.GhostViewHolder
 * JD-Core Version:    0.7.0.1
 */