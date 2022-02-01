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
  float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private CommentFloatDialog jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog;
  private StoryPlayerCommentListView jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView;
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
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      return;
    }
    int i = localView.getScrollX();
    int j = this.jdField_a_of_type_AndroidViewView.getScrollY();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, j, paramInt1 - i, paramInt2 - j, paramInt3);
    invalidate();
  }
  
  private boolean a()
  {
    StoryPlayerCommentListView localStoryPlayerCommentListView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView;
    boolean bool = false;
    if ((localStoryPlayerCommentListView == null) || (localStoryPlayerCommentListView.getChildCount() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.getChildAt(0).getTop() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    int i = Math.abs(((View)localObject).getScrollY());
    if (i > 200)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetScroller;
      if (localObject != null) {
        ((Scroller)localObject).setFinalY(0);
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialogTopGestureLayout.1(this, (View)localObject), 32L);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog.a(i);
      boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog.a();
      String str = "2";
      if (bool) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog.b()) {
        str = "1";
      }
      StoryReportor.a("play_video", "close_reply", 0, 2, new String[] { localObject, str });
      return;
    }
    a(0, 0, 200);
  }
  
  public void a(CommentFloatDialog paramCommentFloatDialog, StoryPlayerCommentListView paramStoryPlayerCommentListView, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialog = paramCommentFloatDialog;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView = paramStoryPlayerCommentListView;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f;
    if (this.b != 0.0F) {
      f = paramMotionEvent.getRawY() - this.b;
    } else {
      f = 0.0F;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.b = paramMotionEvent.getRawY();
    return (a()) && (f > 0.0F) && (paramMotionEvent.getAction() != 0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    float f2 = this.b;
    float f1 = 0.0F;
    if (f2 != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.b;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.b = paramMotionEvent.getRawY();
    if (paramMotionEvent.getAction() != 2)
    {
      b();
      return true;
    }
    int i = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - f1);
    if (i <= 0) {
      a(0, i, 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */