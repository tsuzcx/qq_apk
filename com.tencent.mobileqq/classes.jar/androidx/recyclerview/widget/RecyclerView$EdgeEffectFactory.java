package androidx.recyclerview.widget;

import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

public class RecyclerView$EdgeEffectFactory
{
  public static final int DIRECTION_BOTTOM = 3;
  public static final int DIRECTION_LEFT = 0;
  public static final int DIRECTION_RIGHT = 2;
  public static final int DIRECTION_TOP = 1;
  
  @NonNull
  protected EdgeEffect createEdgeEffect(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    return new EdgeEffect(paramRecyclerView.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
 * JD-Core Version:    0.7.0.1
 */