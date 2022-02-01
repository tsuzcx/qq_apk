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

public class MsgTabStoryNodeView
  extends FrameLayout
{
  int a;
  boolean b = false;
  RecyclerView c;
  LinearLayoutManager d;
  public final TextView e;
  public View f;
  boolean g = true;
  Handler h = new Handler();
  Rect i = new Rect();
  Runnable j = new MsgTabStoryNodeView.1(this);
  private int[] k = new int[2];
  private int[] l = new int[2];
  private int m;
  private boolean n = false;
  private float o;
  private float p;
  
  public MsgTabStoryNodeView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.a = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    inflate(paramContext, 2131628092, this);
    this.c = ((RecyclerView)findViewById(2131444517));
    this.c.addItemDecoration(new MsgTabStoryNodeView.HorizontalSpaceItemDecoration(paramContext));
    this.c.setItemAnimator(null);
    this.e = ((TextView)findViewById(2131447205));
    this.f = findViewById(2131437001);
    findViewById(2131447202).setOnClickListener(new MsgTabStoryNodeView.2(this));
    int i1 = paramContext.getResources().getColor(2131168001);
    ((ImageView)findViewById(2131435403)).getDrawable().setColorFilter(i1, PorterDuff.Mode.SRC_ATOP);
    this.f.setOnClickListener(new MsgTabStoryNodeView.3(this, paramContext));
    this.d = new LinearLayoutManager(paramContext, 0, false);
    this.d.setAutoMeasureEnabled(true);
    this.c.setLayoutManager(this.d);
  }
  
  public void a()
  {
    Drawable localDrawable = getContext().getResources().getDrawable(2130847705);
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "newDrawable %s", String.valueOf(localDrawable));
    if ((localDrawable instanceof SkinnableBitmapDrawable))
    {
      ImageView localImageView = (ImageView)findViewById(2131435473);
      Matrix localMatrix = localImageView.getImageMatrix();
      float f1 = localImageView.getWidth() * 1.0F / localDrawable.getIntrinsicWidth();
      localMatrix.setScale(f1, f1, 0.0F, 0.0F);
      localImageView.setImageMatrix(localMatrix);
      localImageView.setImageDrawable(localDrawable);
      localImageView.setVisibility(0);
    }
    else
    {
      ((ImageView)findViewById(2131435473)).setVisibility(8);
    }
    setBackgroundDrawable(getResources().getDrawable(2130839577));
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateRedPoint ");
    localStringBuilder.append(paramInt);
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView", localStringBuilder.toString());
    if (paramInt > 99) {
      this.e.setText("99+");
    } else {
      this.e.setText(String.valueOf(paramInt));
    }
    if (paramInt <= 0)
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if (i1 != 0)
    {
      if (i1 == 2)
      {
        f2 = Math.abs(this.o - f2);
        f1 = Math.abs(this.p - f1);
        if ((this.m == 0) && (f2 > this.a)) {
          this.m = 1;
        }
        if ((this.m == 0) && (f1 > this.a)) {
          this.m = 2;
        }
        if ((this.m == 2) && (this.n))
        {
          this.n = false;
          paramMotionEvent.setAction(3);
          dispatchTouchEvent(paramMotionEvent);
        }
      }
    }
    else
    {
      getLocationInWindow(this.l);
      paramView.getLocationInWindow(this.k);
      paramView = this.l;
      boolean bool;
      if ((f1 >= paramView[1]) && (f1 < paramView[1] + getHeight())) {
        bool = true;
      } else {
        bool = false;
      }
      this.n = bool;
      this.o = f2;
      this.p = f1;
      this.m = 0;
    }
    if (this.n)
    {
      paramMotionEvent.offsetLocation(0.0F, this.k[1] - this.l[1]);
      dispatchTouchEvent(paramMotionEvent);
    }
    return this.n;
  }
  
  public void b()
  {
    int i1 = getContext().getResources().getColor(2131168001);
    Object localObject = (ImageView)findViewById(2131435403);
    if (localObject != null)
    {
      ((ImageView)localObject).getDrawable().setColorFilter(i1, PorterDuff.Mode.SRC_ATOP);
      ((ImageView)localObject).invalidate();
    }
    ((TextView)findViewById(2131447202)).setTextColor(i1);
    ((TextView)findViewById(2131447201)).setTextColor(i1);
    getContext().getResources().getColor(2131168094);
    getContext().getResources().getDrawable(2130852152);
    this.c.setBackgroundDrawable(null);
    for (localObject = this;; localObject = (View)localObject)
    {
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeViewVASH", "Debug %s -> back: %s", String.valueOf(localObject), String.valueOf(((View)localObject).getBackground()));
      localObject = ((View)localObject).getParent();
      if ((localObject == null) || (!(localObject instanceof View))) {
        break;
      }
    }
    a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.g = false;
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "onAttachedToWindow");
    a();
    if (this.c.getLayoutManager().getChildCount() != this.c.getChildCount())
    {
      SLog.e("Q.qqstory.msgTab.MsgTabStoryNodeView", "onAttachedToWindow recyclerView count not match! reset!");
      this.d = new LinearLayoutManager(getContext(), 0, false);
      this.d.setAutoMeasureEnabled(true);
      this.c.setLayoutManager(this.d);
      this.c.getAdapter().notifyDataSetChanged();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g = true;
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeView", "onDetachedFromWindow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView
 * JD-Core Version:    0.7.0.1
 */