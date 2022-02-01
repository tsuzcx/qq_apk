package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class CommentFloatDialogTopGestureLayout
  extends LinearLayout
  implements View.OnTouchListener
{
  float a;
  float b;
  private CommentFloatDialog c;
  private StoryPlayerCommentListView d;
  private View e;
  private Scroller f;
  
  public CommentFloatDialogTopGestureLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CommentFloatDialogTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CommentFloatDialogTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOnTouchListener(this);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.f == null) {
      this.f = new Scroller(getContext());
    }
    View localView = this.e;
    if (localView == null) {
      return;
    }
    int i = localView.getScrollX();
    int j = this.e.getScrollY();
    this.f.startScroll(i, j, paramInt1 - i, paramInt2 - j, paramInt3);
    invalidate();
  }
  
  private boolean b()
  {
    StoryPlayerCommentListView localStoryPlayerCommentListView = this.d;
    boolean bool = false;
    if ((localStoryPlayerCommentListView == null) || (localStoryPlayerCommentListView.getChildCount() == 0) || (this.d.getChildAt(0).getTop() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    int i = Math.abs(((View)localObject).getScrollY());
    if (i > 200)
    {
      localObject = this.f;
      if (localObject != null) {
        ((Scroller)localObject).setFinalY(0);
      }
      localObject = this.e;
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialogTopGestureLayout.1(this, (View)localObject), 32L);
      this.c.a(i);
      boolean bool = this.c.c();
      String str = "2";
      if (bool) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      if (!this.c.d()) {
        str = "1";
      }
      StoryReportor.a("play_video", "close_reply", 0, 2, new String[] { localObject, str });
      return;
    }
    a(0, 0, 200);
  }
  
  public void a(CommentFloatDialog paramCommentFloatDialog, StoryPlayerCommentListView paramStoryPlayerCommentListView, View paramView)
  {
    this.c = paramCommentFloatDialog;
    this.d = paramStoryPlayerCommentListView;
    this.e = paramView;
  }
  
  public void computeScroll()
  {
    if (this.f == null) {
      this.f = new Scroller(getContext());
    }
    if (this.e == null) {
      return;
    }
    if (this.f.computeScrollOffset())
    {
      this.e.scrollTo(this.f.getCurrX(), this.f.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1;
    if (this.b != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.b;
    } else {
      f1 = 0.0F;
    }
    this.a = paramMotionEvent.getRawX();
    this.b = paramMotionEvent.getRawY();
    return (b()) && (f1 > 0.0F) && (paramMotionEvent.getAction() != 0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      return false;
    }
    float f2 = this.b;
    float f1 = 0.0F;
    if (f2 != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.b;
    }
    this.a = paramMotionEvent.getRawX();
    this.b = paramMotionEvent.getRawY();
    if (paramMotionEvent.getAction() != 2)
    {
      c();
      return true;
    }
    int i = (int)(this.e.getScrollY() - f1);
    if (i <= 0) {
      a(0, i, 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */