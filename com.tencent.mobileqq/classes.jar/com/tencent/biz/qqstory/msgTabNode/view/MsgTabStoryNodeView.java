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
import com.tencent.theme.SkinnableBitmapDrawable;
import vbh;
import vbi;
import vbj;
import wxe;

public class MsgTabStoryNodeView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  public RecyclerView a;
  public View a;
  public final TextView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new MsgTabStoryNodeView.1(this);
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private boolean c;
  
  public MsgTabStoryNodeView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    inflate(paramContext, 2131561508, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131375542));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new vbj(paramContext));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377729));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369284);
    findViewById(2131377726).setOnClickListener(new vbh(this));
    int i = paramContext.getResources().getColor(2131166910);
    ((ImageView)findViewById(2131367961)).getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vbi(this, paramContext));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setAutoMeasureEnabled(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
  }
  
  public void a()
  {
    Drawable localDrawable = getContext().getResources().getDrawable(2130845638);
    wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "newDrawable %s", String.valueOf(localDrawable));
    if ((localDrawable instanceof SkinnableBitmapDrawable))
    {
      ImageView localImageView = (ImageView)findViewById(2131368026);
      Matrix localMatrix = localImageView.getImageMatrix();
      float f = localImageView.getWidth() * 1.0F / localDrawable.getIntrinsicWidth();
      localMatrix.setScale(f, f, 0.0F, 0.0F);
      localImageView.setImageMatrix(localMatrix);
      localImageView.setImageDrawable(localDrawable);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      setBackgroundDrawable(getResources().getDrawable(2130839217));
      return;
      ((ImageView)findViewById(2131368026)).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "updateRedPoint " + paramInt);
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
    int i = paramMotionEvent.getAction();
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      if (this.c)
      {
        paramMotionEvent.offsetLocation(0.0F, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1]);
        dispatchTouchEvent(paramMotionEvent);
      }
      return this.c;
      getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      if ((f1 >= this.jdField_b_of_type_ArrayOfInt[1]) && (f1 < this.jdField_b_of_type_ArrayOfInt[1] + getHeight())) {}
      for (boolean bool = true;; bool = false)
      {
        this.c = bool;
        this.jdField_a_of_type_Float = f2;
        this.jdField_b_of_type_Float = f1;
        this.jdField_b_of_type_Int = 0;
        break;
      }
      f2 = Math.abs(this.jdField_a_of_type_Float - f2);
      f1 = Math.abs(this.jdField_b_of_type_Float - f1);
      if ((this.jdField_b_of_type_Int == 0) && (f2 > this.jdField_a_of_type_Int)) {
        this.jdField_b_of_type_Int = 1;
      }
      if ((this.jdField_b_of_type_Int == 0) && (f1 > this.jdField_a_of_type_Int)) {
        this.jdField_b_of_type_Int = 2;
      }
      if ((this.jdField_b_of_type_Int == 2) && (this.c))
      {
        this.c = false;
        paramMotionEvent.setAction(3);
        dispatchTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void b()
  {
    int i = getContext().getResources().getColor(2131166910);
    Object localObject = (ImageView)findViewById(2131367961);
    if (localObject != null)
    {
      ((ImageView)localObject).getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      ((ImageView)localObject).invalidate();
    }
    ((TextView)findViewById(2131377726)).setTextColor(i);
    ((TextView)findViewById(2131377725)).setTextColor(i);
    getContext().getResources().getColor(2131166961);
    getContext().getResources().getDrawable(2130849463);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setBackgroundDrawable(null);
    for (localObject = this;; localObject = (View)localObject)
    {
      wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeViewVASH", "Debug %s -> back: %s", String.valueOf(localObject), String.valueOf(((View)localObject).getBackground()));
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
    wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "onAttachedToWindow");
    a();
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager().getChildCount() != this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount())
    {
      wxe.e("Q.qqstory.msgTab.MsgTabStoryNodeView", "onAttachedToWindow recyclerView count not match! reset!");
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
    wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "onDetachedFromWindow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView
 * JD-Core Version:    0.7.0.1
 */