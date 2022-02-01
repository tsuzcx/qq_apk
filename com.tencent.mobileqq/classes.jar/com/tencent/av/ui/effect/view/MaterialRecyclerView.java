package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class MaterialRecyclerView
  extends RecyclerView
{
  protected Context a;
  protected int b;
  
  public MaterialRecyclerView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MaterialRecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MaterialRecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    this.a = paramContext;
    int i = AIOUtils.b(60.0F, this.a.getResources());
    int j = AIOUtils.b(9.0F, this.a.getResources());
    this.b = ((this.a.getResources().getDisplayMetrics().widthPixels - j) / (i + j));
    setPadding(0, 0, 0, (int)this.a.getResources().getDimension(2131298440));
    setClipToPadding(false);
    setLayoutManager(new GridLayoutManager(getContext(), this.b));
    addItemDecoration(new MaterialRecyclerView.SpacingItemDecoration(this.b, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.MaterialRecyclerView
 * JD-Core Version:    0.7.0.1
 */