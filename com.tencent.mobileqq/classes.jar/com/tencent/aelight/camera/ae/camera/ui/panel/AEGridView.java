package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class AEGridView
  extends RecyclerView
{
  private Context a;
  private int b;
  private int c;
  private AEGridView.ItemOnExposeListener d;
  
  public AEGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEGridView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEGridView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    int i = AIOUtils.b(60.0F, this.a.getResources());
    int j = AIOUtils.b(12.0F, this.a.getResources());
    int k = AIOUtils.b(10.0F, this.a.getResources());
    int m = this.a.getResources().getDisplayMetrics().widthPixels;
    this.b = ((m - k) / (i + k));
    int n = this.b;
    setPadding((m - i * n) / (n + 1), 0, 0, j * 4);
    setClipToPadding(false);
    setLayoutManager(new GridLayoutManager(getContext(), this.b));
    addItemDecoration(new AEGridView.SpacingItemDecoration(this, this.b, k));
    addOnScrollListener(new AEGridView.1(this));
    this.c = i;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView != null) && (paramView.getVisibility() == 0) && (paramView.isShown()))
    {
      if (!paramView.getGlobalVisibleRect(new Rect())) {
        return;
      }
      if (this.d == null)
      {
        Log.e("dtexpose", "mExposeListener is null ");
        return;
      }
      Rect localRect = new Rect();
      boolean bool = paramView.getGlobalVisibleRect(localRect);
      if (paramInt2 == 1)
      {
        localRect.height();
        int i = paramView.getMeasuredHeight() / 2;
      }
      if (paramInt2 == 0)
      {
        localRect.width();
        paramInt2 = paramView.getMeasuredWidth() / 2;
      }
      if (bool)
      {
        this.d.a(true, paramInt1);
        return;
      }
      this.d.a(false, paramInt1);
    }
  }
  
  private int[] a(GridLayoutManager paramGridLayoutManager)
  {
    return new int[] { paramGridLayoutManager.findFirstVisibleItemPosition(), paramGridLayoutManager.findLastVisibleItemPosition() };
  }
  
  private int[] a(LinearLayoutManager paramLinearLayoutManager)
  {
    return new int[] { paramLinearLayoutManager.findFirstVisibleItemPosition(), paramLinearLayoutManager.findLastVisibleItemPosition() };
  }
  
  public void a(int paramInt)
  {
    int i = AIOUtils.b(10.0F, this.a.getResources());
    i = (paramInt / this.b - 1) * (this.c + i);
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    smoothScrollBy(0, paramInt);
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    Log.d("dtexpose", "handleCurrentVisibleItems-");
    if ((paramRecyclerView != null) && (paramRecyclerView.getVisibility() == 0) && (paramRecyclerView.isShown())) {
      if (!paramRecyclerView.getGlobalVisibleRect(new Rect())) {
        return;
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new int[2];
        RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
        if ((localLayoutManager instanceof LinearLayoutManager))
        {
          Log.d("dtexpose", "LinearLayoutManager-");
          localObject = (LinearLayoutManager)localLayoutManager;
          paramRecyclerView = a((LinearLayoutManager)localObject);
          i = ((LinearLayoutManager)localObject).getOrientation();
        }
        else
        {
          if (!(localLayoutManager instanceof GridLayoutManager)) {
            break label252;
          }
          Log.d("dtexpose", "GridLayoutManager-");
          localObject = (GridLayoutManager)localLayoutManager;
          paramRecyclerView = a((GridLayoutManager)localObject);
          i = ((GridLayoutManager)localObject).getOrientation();
        }
        if (paramRecyclerView != null)
        {
          if (paramRecyclerView.length < 2) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("屏幕内可见条目的起始位置：");
          ((StringBuilder)localObject).append(paramRecyclerView[0]);
          ((StringBuilder)localObject).append("---");
          ((StringBuilder)localObject).append(paramRecyclerView[1]);
          Log.d("dtexpose", ((StringBuilder)localObject).toString());
          this.d.a(paramRecyclerView);
          int j = paramRecyclerView[0];
          if (j <= paramRecyclerView[1])
          {
            a(localLayoutManager.findViewByPosition(j), j, i);
            j += 1;
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
        Log.d("dtexpose", paramRecyclerView.getMessage());
      }
      return;
      label252:
      paramRecyclerView = (RecyclerView)localObject;
      int i = -1;
    }
  }
  
  public void a(AEGridView.ItemOnExposeListener paramItemOnExposeListener)
  {
    this.d = paramItemOnExposeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView
 * JD-Core Version:    0.7.0.1
 */