package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.View;
import androidx.core.view.ViewCompat;

class ItemTouchUIUtilImpl
  implements ItemTouchUIUtil
{
  static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();
  
  private static float findMaxElevation(RecyclerView paramRecyclerView, View paramView)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    float f1 = 0.0F;
    if (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      float f2;
      if (localView == paramView) {
        f2 = f1;
      }
      for (;;)
      {
        i += 1;
        f1 = f2;
        break;
        float f3 = ViewCompat.getElevation(localView);
        f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
      }
    }
    return f1;
  }
  
  public void clearView(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramView.getTag(2131369436);
      if ((localObject instanceof Float)) {
        ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
      }
      paramView.setTag(2131369436, null);
    }
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean) && (paramView.getTag(2131369436) == null))
    {
      float f = ViewCompat.getElevation(paramView);
      ViewCompat.setElevation(paramView, 1.0F + findMaxElevation(paramRecyclerView, paramView));
      paramView.setTag(2131369436, Float.valueOf(f));
    }
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {}
  
  public void onSelected(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchUIUtilImpl
 * JD-Core Version:    0.7.0.1
 */