package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import njp;
import njq;
import njr;

public class MsgTabStoryNodeView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  public Rect a;
  public Handler a;
  LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  public RecyclerView a;
  public View a;
  public final TextView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new njp(this);
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  public boolean b;
  private int[] b;
  private boolean c;
  
  public MsgTabStoryNodeView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    inflate(paramContext, 2130970797, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131371799));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new MsgTabStoryNodeView.HorizontalSpaceItemDecoration(paramContext));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371912));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371910);
    findViewById(2131371909).setOnClickListener(new njq(this));
    int i = paramContext.getResources().getColor(2131494225);
    ((ImageView)findViewById(2131371913)).getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new njr(this, paramContext));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setAutoMeasureEnabled(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
  }
  
  public void a()
  {
    Drawable localDrawable = getContext().getResources().getDrawable(2130845888);
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "newDrawable %s", String.valueOf(localDrawable));
    if ((localDrawable instanceof SkinnableBitmapDrawable))
    {
      ImageView localImageView = (ImageView)findViewById(2131371907);
      Matrix localMatrix = localImageView.getImageMatrix();
      float f = localImageView.getWidth() * 1.0F / localDrawable.getIntrinsicWidth();
      localMatrix.setScale(f, f, 0.0F, 0.0F);
      localImageView.setImageMatrix(localMatrix);
      localImageView.setImageDrawable(localDrawable);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      setBackgroundDrawable(getResources().getDrawable(2130838593));
      return;
      ((ImageView)findViewById(2131371907)).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "updateRedPoint " + paramInt);
    if (paramInt > 99) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("99+");
    }
    while (paramInt <= 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeView", "interceptDrawer, x:%s, y:%s", Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      float f = paramMotionEvent.getRawY();
      if ((f < this.jdField_b_of_type_ArrayOfInt[1]) || (f >= this.jdField_b_of_type_ArrayOfInt[1] + getHeight())) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      if (this.c)
      {
        paramMotionEvent.offsetLocation(0.0F, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1]);
        dispatchTouchEvent(paramMotionEvent);
      }
      return this.c;
    }
  }
  
  public void b()
  {
    int i = getContext().getResources().getColor(2131494225);
    Object localObject = (ImageView)findViewById(2131371913);
    if (localObject != null)
    {
      ((ImageView)localObject).getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      ((ImageView)localObject).invalidate();
    }
    ((TextView)findViewById(2131371909)).setTextColor(i);
    ((TextView)findViewById(2131371911)).setTextColor(i);
    getContext().getResources().getColor(2131494261);
    getContext().getResources().getDrawable(2130845888);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundDrawable(null);
    for (localObject = this;; localObject = (View)localObject)
    {
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeViewVASH", "Debug %s -> back: %s", String.valueOf(localObject), String.valueOf(((View)localObject).getBackground()));
      localObject = ((View)localObject).getParent();
      if ((localObject == null) || (!(localObject instanceof View)))
      {
        a();
        return;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_b_of_type_Boolean = false;
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "onAttachedToWindow");
    a();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager().getChildCount() != this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount())
    {
      SLog.e("Q.qqstory.msgTab.MsgTabStoryNodeView", "onAttachedToWindow recyclerView count not match! reset!");
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setAutoMeasureEnabled(true);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter().notifyDataSetChanged();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_b_of_type_Boolean = true;
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "onDetachedFromWindow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView
 * JD-Core Version:    0.7.0.1
 */