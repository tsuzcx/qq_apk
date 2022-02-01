package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class Avatar2DRecyclerView
  extends MaterialRecyclerView
{
  public Avatar2DRecyclerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public Avatar2DRecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Avatar2DRecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(Context paramContext)
  {
    this.a = paramContext;
    int j = (int)paramContext.getResources().getDimension(2131298422);
    int i = AIOUtils.b(9.0F, this.a.getResources());
    int k = this.a.getResources().getDisplayMetrics().widthPixels;
    this.b = ((k - i) / (j + i));
    j = (k - j * this.b) / (this.b + 1);
    setPadding(0, 0, 0, (int)this.a.getResources().getDimension(2131298440));
    setClipToPadding(false);
    setLayoutManager(new GridLayoutManager(getContext(), this.b));
    addItemDecoration(new MaterialRecyclerView.SpacingItemDecoration(this.b, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.Avatar2DRecyclerView
 * JD-Core Version:    0.7.0.1
 */