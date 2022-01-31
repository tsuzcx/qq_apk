package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tla;
import urp;

public class CommentFloatDialogTopGestureLayout
  extends LinearLayout
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private StoryPlayerCommentListView jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView;
  private tla jdField_a_of_type_Tla;
  float b;
  
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
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidViewView.getScrollX();
    int j = this.jdField_a_of_type_AndroidViewView.getScrollY();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, j, paramInt1 - i, paramInt2 - j, paramInt3);
    invalidate();
  }
  
  private boolean a()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.getChildCount() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.getChildAt(0).getTop() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int i = Math.abs(this.jdField_a_of_type_AndroidViewView.getScrollY());
    if (i > 200)
    {
      if (this.jdField_a_of_type_AndroidWidgetScroller != null) {
        this.jdField_a_of_type_AndroidWidgetScroller.setFinalY(0);
      }
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialogTopGestureLayout.1(this, (View)localObject), 32L);
      this.jdField_a_of_type_Tla.a(i);
      if (this.jdField_a_of_type_Tla.a())
      {
        localObject = "2";
        if (!this.jdField_a_of_type_Tla.b()) {
          break label127;
        }
      }
      label127:
      for (String str = "2";; str = "1")
      {
        urp.a("play_video", "close_reply", 0, 2, new String[] { localObject, str });
        return;
        localObject = "1";
        break;
      }
    }
    a(0, 0, 200);
  }
  
  public void a(tla paramtla, StoryPlayerCommentListView paramStoryPlayerCommentListView, View paramView)
  {
    this.jdField_a_of_type_Tla = paramtla;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView = paramStoryPlayerCommentListView;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    while (!this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
    postInvalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b != 0.0F) {}
    for (float f = paramMotionEvent.getRawY() - this.b;; f = 0.0F)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
      if ((!a()) || (f <= 0.0F) || (paramMotionEvent.getAction() == 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f = 0.0F;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    if (this.b != 0.0F) {
      f = paramMotionEvent.getRawY() - this.b;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.b = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      b();
      return true;
    }
    int i = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - f);
    if (i <= 0) {
      a(0, i, 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */