package com.tencent.biz.qqcircle.publish.preview.itemtouchhelper;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

class ItemTouchHelper$2
  implements RecyclerView.OnItemTouchListener
{
  ItemTouchHelper$2(ItemTouchHelper paramItemTouchHelper) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.a.u.a(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.a.k = paramMotionEvent.getPointerId(0);
      this.a.c = paramMotionEvent.getX();
      this.a.d = paramMotionEvent.getY();
      this.a.c();
      if (this.a.b == null)
      {
        paramRecyclerView = this.a.b(paramMotionEvent);
        if (paramRecyclerView != null)
        {
          ItemTouchHelper localItemTouchHelper = this.a;
          localItemTouchHelper.c -= paramRecyclerView.l;
          localItemTouchHelper = this.a;
          localItemTouchHelper.d -= paramRecyclerView.m;
          this.a.a(paramRecyclerView.h, true);
          if (this.a.a.remove(paramRecyclerView.h.itemView)) {
            this.a.l.b(this.a.p, paramRecyclerView.h);
          }
          this.a.a(paramRecyclerView.h, paramRecyclerView.i);
          paramRecyclerView = this.a;
          paramRecyclerView.a(paramMotionEvent, paramRecyclerView.n, 0);
        }
      }
    }
    else if ((i != 3) && (i != 1))
    {
      if (this.a.k != -1)
      {
        int j = paramMotionEvent.findPointerIndex(this.a.k);
        if (j >= 0) {
          this.a.a(i, paramMotionEvent, j);
        }
      }
    }
    else
    {
      paramRecyclerView = this.a;
      paramRecyclerView.k = -1;
      paramRecyclerView.a(null, 0);
    }
    if (this.a.r != null) {
      this.a.r.addMovement(paramMotionEvent);
    }
    return this.a.b != null;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.a.a(null, 0);
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.a.u.a(paramMotionEvent);
    if (this.a.r != null) {
      this.a.r.addMovement(paramMotionEvent);
    }
    if (this.a.k == -1) {
      return;
    }
    int j = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.findPointerIndex(this.a.k);
    if (k >= 0) {
      this.a.a(j, paramMotionEvent, k);
    }
    paramRecyclerView = this.a.b;
    if (paramRecyclerView == null) {
      return;
    }
    int i = 0;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 6) {
            return;
          }
          j = paramMotionEvent.getActionIndex();
          if (paramMotionEvent.getPointerId(j) != this.a.k) {
            return;
          }
          if (j == 0) {
            i = 1;
          }
          this.a.k = paramMotionEvent.getPointerId(i);
          paramRecyclerView = this.a;
          paramRecyclerView.a(paramMotionEvent, paramRecyclerView.n, j);
          return;
        }
        if (this.a.r != null) {
          this.a.r.clear();
        }
      }
      else
      {
        if (k < 0) {
          return;
        }
        ItemTouchHelper localItemTouchHelper = this.a;
        localItemTouchHelper.a(paramMotionEvent, localItemTouchHelper.n, k);
        this.a.a(paramRecyclerView);
        this.a.p.removeCallbacks(this.a.q);
        this.a.q.run();
        this.a.p.invalidate();
        return;
      }
    }
    this.a.a(null, 0);
    this.a.k = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.ItemTouchHelper.2
 * JD-Core Version:    0.7.0.1
 */