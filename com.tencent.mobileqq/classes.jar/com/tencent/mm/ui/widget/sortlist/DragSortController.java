package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class DragSortController
  extends SimpleFloatViewManager
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  public static final int CLICK_REMOVE = 0;
  public static final int FLING_REMOVE = 1;
  public static final int MISS = -1;
  public static final int ON_DOWN = 0;
  public static final int ON_DRAG = 1;
  public static final int ON_LONG_PRESS = 2;
  private int a = 0;
  private boolean b = true;
  private int c;
  private boolean d = false;
  private boolean e = false;
  private GestureDetector f;
  private GestureDetector g;
  private int h;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int[] l = new int[2];
  private int m;
  private int n;
  private int o;
  private int p;
  private boolean q = false;
  private float r = 500.0F;
  private int s;
  private int t;
  private int u;
  private boolean v;
  private DragSortListView w;
  private int x;
  private GestureDetector.OnGestureListener y = new DragSortController.1(this);
  
  public DragSortController(DragSortListView paramDragSortListView)
  {
    this(paramDragSortListView, 0, 0, 1);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.w = paramDragSortListView;
    this.f = new GestureDetector(paramDragSortListView.getContext(), this);
    this.g = new GestureDetector(paramDragSortListView.getContext(), this.y);
    this.g.setIsLongpressEnabled(false);
    this.h = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.s = paramInt1;
    this.t = paramInt4;
    this.u = paramInt5;
    setRemoveMode(paramInt3);
    setDragInitMode(paramInt2);
  }
  
  public int dragHandleHitPosition(MotionEvent paramMotionEvent)
  {
    return viewIdHitPosition(paramMotionEvent, this.s);
  }
  
  public int flingHandleHitPosition(MotionEvent paramMotionEvent)
  {
    return viewIdHitPosition(paramMotionEvent, this.u);
  }
  
  public int getDragInitMode()
  {
    return this.a;
  }
  
  public int getRemoveMode()
  {
    return this.c;
  }
  
  public boolean isRemoveEnabled()
  {
    return this.d;
  }
  
  public boolean isSortEnabled()
  {
    return this.b;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.d) && (this.c == 0)) {
      this.k = viewIdHitPosition(paramMotionEvent, this.t);
    }
    this.i = startDragPosition(paramMotionEvent);
    int i1 = this.i;
    if ((i1 != -1) && (this.a == 0)) {
      startDrag(i1, (int)paramMotionEvent.getX() - this.m, (int)paramMotionEvent.getY() - this.n);
    }
    this.e = false;
    this.v = true;
    this.x = 0;
    this.j = startFlingPosition(paramMotionEvent);
    return true;
  }
  
  public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.d) && (this.e)) {
      this.x = paramPoint1.x;
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.i != -1) && (this.a == 2))
    {
      this.w.performHapticFeedback(0);
      startDrag(this.i, this.o - this.m, this.p - this.n);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i1 = (int)paramMotionEvent1.getX();
    int i2 = (int)paramMotionEvent1.getY();
    int i3 = (int)paramMotionEvent2.getX();
    int i4 = (int)paramMotionEvent2.getY();
    int i5 = i3 - this.m;
    int i6 = i4 - this.n;
    if ((this.v) && (!this.q) && ((this.i != -1) || (this.j != -1))) {
      if (this.i != -1)
      {
        if ((this.a == 1) && (Math.abs(i4 - i2) > this.h) && (this.b))
        {
          startDrag(this.i, i5, i6);
          return false;
        }
        if ((this.a != 0) && (Math.abs(i3 - i1) > this.h) && (this.d))
        {
          this.e = true;
          startDrag(this.j, i5, i6);
          return false;
        }
      }
      else if (this.j != -1)
      {
        if ((Math.abs(i3 - i1) > this.h) && (this.d))
        {
          this.e = true;
          startDrag(this.j, i5, i6);
          return false;
        }
        if (Math.abs(i4 - i2) > this.h) {
          this.v = false;
        }
      }
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.d) && (this.c == 0))
    {
      int i1 = this.k;
      if (i1 != -1)
      {
        paramMotionEvent = this.w;
        paramMotionEvent.removeItem(i1 - paramMotionEvent.getHeaderViewsCount());
      }
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.w.isDragEnabled())
    {
      if (this.w.listViewIntercepted()) {
        return false;
      }
      this.f.onTouchEvent(paramMotionEvent);
      if ((this.d) && (this.q) && (this.c == 1)) {
        this.g.onTouchEvent(paramMotionEvent);
      }
      int i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 3) {
            return false;
          }
          this.e = false;
          this.q = false;
          return false;
        }
        if ((this.d) && (this.e))
        {
          i1 = this.x;
          if (i1 < 0) {
            i1 = -i1;
          }
          if (i1 > this.w.getWidth() / 2)
          {
            this.w.stopDragWithVelocity(true, 0.0F);
            return false;
          }
        }
      }
      else
      {
        this.o = ((int)paramMotionEvent.getX());
        this.p = ((int)paramMotionEvent.getY());
      }
    }
    return false;
  }
  
  public void setClickRemoveId(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setDragHandleId(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setDragInitMode(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setFlingHandleId(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void setRemoveEnabled(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setRemoveMode(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setSortEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean startDrag(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((this.b) && (!this.e)) {
      i1 = 12;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (this.d)
    {
      i2 = i1;
      if (this.e) {
        i2 = i1 | 0x1 | 0x2;
      }
    }
    DragSortListView localDragSortListView = this.w;
    this.q = localDragSortListView.startDrag(paramInt1 - localDragSortListView.getHeaderViewsCount(), i2, paramInt2, paramInt3);
    return this.q;
  }
  
  public int startDragPosition(MotionEvent paramMotionEvent)
  {
    return dragHandleHitPosition(paramMotionEvent);
  }
  
  public int startFlingPosition(MotionEvent paramMotionEvent)
  {
    if (this.c == 1) {
      return flingHandleHitPosition(paramMotionEvent);
    }
    return -1;
  }
  
  public int viewIdHitPosition(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    i1 = this.w.pointToPosition(i1, i2);
    i2 = this.w.getHeaderViewsCount();
    int i3 = this.w.getFooterViewsCount();
    int i4 = this.w.getCount();
    if ((i1 != -1) && (i1 >= i2) && (i1 < i4 - i3))
    {
      Object localObject = this.w;
      localObject = ((DragSortListView)localObject).getChildAt(i1 - ((DragSortListView)localObject).getFirstVisiblePosition());
      i2 = (int)paramMotionEvent.getRawX();
      i3 = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {
        paramMotionEvent = (MotionEvent)localObject;
      } else {
        paramMotionEvent = ((View)localObject).findViewById(paramInt);
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.getLocationOnScreen(this.l);
        int[] arrayOfInt = this.l;
        if ((i2 > arrayOfInt[0]) && (i3 > arrayOfInt[1]) && (i2 < arrayOfInt[0] + paramMotionEvent.getWidth()) && (i3 < this.l[1] + paramMotionEvent.getHeight()))
        {
          this.m = ((View)localObject).getLeft();
          this.n = ((View)localObject).getTop();
          return i1;
        }
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortController
 * JD-Core Version:    0.7.0.1
 */