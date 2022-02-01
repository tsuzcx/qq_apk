package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class PullDownListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private float A = 0.0F;
  private boolean B = false;
  private boolean C = true;
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private float G;
  private float H = 0.0F;
  private int I = 0;
  private int J = 0;
  private boolean K = false;
  private float L = 0.0F;
  private int M = -1;
  private int N = 0;
  private int O = 0;
  private boolean P = false;
  private long Q = 0L;
  private long R = 0L;
  private AdapterView.OnItemClickListener S;
  private AdapterView.OnItemLongClickListener T;
  private AdapterView.OnItemSelectedListener U;
  private boolean a = false;
  private float b = 0.05F;
  private float c = 0.05F;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private float g = 0.0F;
  private float h = 0.0F;
  private Vibrator i;
  private boolean j = true;
  private View k;
  private float l;
  private View m;
  private Rect n = new Rect();
  private int o = 0;
  private int p = 0;
  private PullDownListView.IPullDownCallback q;
  private boolean r = false;
  private float s;
  private float t;
  private final int u = 1;
  private final int v = 2;
  private final int w = 200;
  private View x;
  private View y;
  private float z = 0.0F;
  
  public PullDownListView(Context paramContext)
  {
    this(paramContext, null);
    a(paramContext);
  }
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a()
  {
    if (this.d == 0) {
      this.d = ((int)(this.f * this.b));
    }
    return this.d;
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt / 2.0F);
  }
  
  private ValueAnimator a(int paramInt1, int paramInt2)
  {
    f.b("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new PullDownListView.5(this));
    return localValueAnimator;
  }
  
  private void a(float paramFloat)
  {
    View localView = this.m;
    if (localView != null)
    {
      localView.setTranslationX(Math.min(this.g + paramFloat, 0.0F));
      this.m.setTranslationY(Math.max(this.h - paramFloat, 0.0F));
      this.m.setVisibility(0);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    f.c("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.n.left), Integer.valueOf(this.n.top), Integer.valueOf(this.n.right), Integer.valueOf(this.n.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(a()), Integer.valueOf(b()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    float f1 = paramInt1;
    float f2 = paramInt2;
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { f1, f2 }));
    if ((this.x != null) && (paramInt1 > a()) && (paramInt1 < b())) {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.x, "translationY", new float[] { f1, f2 }));
      } else {
        localArrayList.add(ObjectAnimator.ofFloat(this.x, "translationY", new float[] { f1, paramInt2 - this.p }));
      }
    }
    if (this.y != null) {
      if (paramInt2 >= getBottom()) {
        localArrayList.add(a(((ViewGroup.MarginLayoutParams)this.y.getLayoutParams()).topMargin, 0));
      } else {
        localArrayList.add(a(((ViewGroup.MarginLayoutParams)this.y.getLayoutParams()).topMargin, this.I));
      }
    }
    localAnimatorSet.addListener(new PullDownListView.4(this, paramInt1, paramInt2, paramBoolean));
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.start();
    resetLayout();
  }
  
  private void a(Context paramContext)
  {
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    if (h.c(paramContext) != null) {
      this.f = h.c(paramContext).y;
    }
    this.i = ((Vibrator)getContext().getSystemService("vibrator"));
    post(new PullDownListView.2(this));
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.M)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.l = ((int)paramMotionEvent.getY(i1));
      this.M = paramMotionEvent.getPointerId(i1);
    }
  }
  
  private int b()
  {
    if (this.e == 0) {
      this.e = ((int)((this.f - this.J) * (1.0F - this.c)));
    }
    return this.e;
  }
  
  private int b(int paramInt)
  {
    return (int)(paramInt * 3.0F);
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.m != null)
    {
      if ((paramMotionEvent.getActionMasked() == 1) && (this.R < 200L)) {
        return false;
      }
      if (this.t < this.m.getRight())
      {
        if ((f1 <= this.m.getLeft()) || (f1 >= this.m.getRight()) || (f2 <= this.m.getTop() - this.m.getHeight() / 2) || (f2 >= this.m.getBottom() + this.p)) {}
      }
      else {
        while ((f1 > this.m.getLeft()) && (f1 < this.m.getRight()) && (f2 > this.m.getTop()) && (f2 < this.m.getBottom() + this.p)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private int c(int paramInt)
  {
    float f1 = paramInt;
    int i1 = (int)Math.abs(f1 / this.f * this.I);
    f.b("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(f1 / this.f), Integer.valueOf(Math.abs(this.I)), Integer.valueOf(i1) });
    return i1;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    float f1 = this.L;
    if (f1 != 0.0F)
    {
      int i1 = b((int)(this.N - f1));
      if ((this.C) && (i1 > 0) && (this.q != null))
      {
        a(i1);
        if ((!this.F) && (b(paramMotionEvent)))
        {
          this.i.vibrate(20L);
          this.F = true;
        }
        else if (!b(paramMotionEvent))
        {
          this.F = false;
        }
        if (this.F)
        {
          this.q.onMuteIn();
          return;
        }
        this.q.onMuteOut();
        return;
      }
      g();
    }
  }
  
  private boolean c()
  {
    return this.N - this.H < 0.0F;
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      int i1 = this.I;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = Math.max(i1, Math.min(0, paramInt + i1));
      f.b("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).bottomMargin) });
      this.y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private boolean d()
  {
    return this.N - this.H > 0.0F;
  }
  
  private void e()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      float f1 = ((View)localObject).getTranslationX();
      float f2 = this.m.getTranslationY();
      localObject = ObjectAnimator.ofFloat(this.m, "translationX", new float[] { f1, this.g });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.m, "translationY", new float[] { f2, this.h });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
      localAnimatorSet.addListener(new PullDownListView.3(this));
      localAnimatorSet.start();
    }
  }
  
  private void e(int paramInt)
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = Math.min(0, Math.max(this.I, -paramInt));
      f.b("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).bottomMargin) });
      this.y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private boolean f()
  {
    return (!this.n.isEmpty()) && (Math.abs(this.o) > 0);
  }
  
  private void g()
  {
    View localView = this.m;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  private void h()
  {
    View localView = this.m;
    if (localView != null)
    {
      localView.setTranslationX(this.g);
      this.m.setTranslationY(this.h);
      this.m.setVisibility(8);
    }
  }
  
  private void i()
  {
    PullDownListView.IPullDownCallback localIPullDownCallback;
    if (this.C)
    {
      d(c(Math.max(this.o - (int)this.H, 0)));
      localIPullDownCallback = this.q;
      if (localIPullDownCallback != null) {
        localIPullDownCallback.onCoordinationViewOpening(c(Math.max(this.o - a() - (int)this.H, 0)));
      }
    }
    else
    {
      e(c(Math.max((int)this.H - this.o, 0)));
      localIPullDownCallback = this.q;
      if (localIPullDownCallback != null) {
        localIPullDownCallback.onCoordinationViewClosing(c(Math.max(b() - this.o, 0)));
      }
    }
  }
  
  private boolean j()
  {
    int i1 = getChildCount();
    if ((i1 > 0) && (this.C))
    {
      int i2 = this.O;
      if (i2 == 2)
      {
        if (getChildAt(0).getTop() >= getPaddingTop() + 0) {}
      }
      else {
        while ((i2 == 1) && (getChildAt(i1 - 1).getBottom() >= getHeight() - getPaddingBottom())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void addOverScrollCallback(PullDownListView.IPullDownCallback paramIPullDownCallback)
  {
    this.q = paramIPullDownCallback;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean isVisible()
  {
    return this.C;
  }
  
  @TargetApi(11)
  protected void onFinishInflate()
  {
    this.k = this;
    this.G = getTranslationY();
    f.b("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.k.getLeft()), Integer.valueOf(this.k.getTop()), Integer.valueOf(this.k.getRight()), Integer.valueOf(this.k.getBottom()) });
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemClickListener localOnItemClickListener = this.S;
    if ((localOnItemClickListener != null) && (!this.B) && (this.C))
    {
      this.r = true;
      localOnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemLongClickListener localOnItemLongClickListener = this.T;
    if ((localOnItemLongClickListener != null) && (!this.B) && (this.C))
    {
      this.r = true;
      return localOnItemLongClickListener.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.U;
    if ((localOnItemSelectedListener != null) && (!this.B) && (this.C))
    {
      this.r = true;
      localOnItemSelectedListener.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.U;
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.onNothingSelected(paramAdapterView);
    }
  }
  
  public void onPause()
  {
    f.c("MicroMsg.PullDownListView", "onPause", new Object[0]);
    this.j = false;
  }
  
  public void onResume()
  {
    f.c("MicroMsg.PullDownListView", "onResume", new Object[0]);
    this.j = true;
  }
  
  @TargetApi(11)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    f.b("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.a), Integer.valueOf(getScrollY()) });
    if ((this.a) && (this.k != null) && (!this.D))
    {
      int i2 = paramMotionEvent.getActionMasked();
      f.b("MicroMsg.PullDownListView", "onTouchEvent %s", new Object[] { Integer.valueOf(i2) });
      int i1;
      float f1;
      if (i2 != 0)
      {
        if (i2 != 1)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 5)
              {
                if (i2 == 6)
                {
                  a(paramMotionEvent);
                  i1 = paramMotionEvent.getActionIndex();
                  if (i1 != -1) {
                    this.l = ((int)paramMotionEvent.getY(i1));
                  }
                }
              }
              else
              {
                i1 = paramMotionEvent.getActionIndex();
                if (i1 != -1)
                {
                  this.l = ((int)paramMotionEvent.getY(i1));
                  this.M = paramMotionEvent.getPointerId(i1);
                }
              }
            }
            else
            {
              e();
              this.K = false;
              this.r = false;
              this.l = 0.0F;
              this.L = 0.0F;
              this.E = false;
              if (this.q != null) {
                resetLayout();
              }
              this.N = 0;
              this.M = -1;
              this.P = false;
              this.R = 0L;
              this.Q = 0L;
            }
          }
          else
          {
            this.B = true;
            if (!this.K) {
              if (!this.C)
              {
                this.M = paramMotionEvent.getPointerId(0);
                this.l = paramMotionEvent.getY(0);
                this.s = paramMotionEvent.getY(0);
                this.H = (this.f - this.J);
                this.N = ((int)this.H);
                this.K = true;
              }
              else
              {
                this.M = paramMotionEvent.getPointerId(0);
                g();
                this.r = false;
                f1 = paramMotionEvent.getY(0);
                this.l = f1;
                this.z = f1;
                this.A = paramMotionEvent.getX(0);
                this.n.setEmpty();
                this.s = paramMotionEvent.getY(0);
                this.t = paramMotionEvent.getX(0);
                this.H = 0.0F;
                this.N = ((int)this.H);
                this.K = true;
                h();
              }
            }
            i1 = paramMotionEvent.findPointerIndex(this.M);
            if (i1 != -1)
            {
              this.z = paramMotionEvent.getY(i1);
              this.A = paramMotionEvent.getX(i1);
              if (this.z - this.s >= 0.0F) {
                this.O = 2;
              } else {
                this.O = 1;
              }
              if (j()) {
                this.P = true;
              }
              if (!this.P)
              {
                f.b("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(i1)), Float.valueOf(paramMotionEvent.getX(i1)) });
                f.b("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.l - this.z)), Boolean.valueOf(this.D), Integer.valueOf(this.o), Boolean.valueOf(this.r), Float.valueOf(this.H) });
                if ((!this.r) && (!this.D))
                {
                  if (this.n.isEmpty())
                  {
                    this.G = getTranslationY();
                    this.n.set(this.k.getLeft(), this.k.getTop(), this.k.getRight(), this.k.getBottom());
                    f.b("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.k.getLeft()), Integer.valueOf(this.k.getTop()), Integer.valueOf(this.k.getRight()), Integer.valueOf(this.k.getBottom()) });
                  }
                  f.b("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(i1), Float.valueOf(paramMotionEvent.getY(i1)), Float.valueOf(this.s), Float.valueOf(paramMotionEvent.getY(i1) - this.s) });
                  this.N += a((int)(this.z - this.l));
                  this.o = Math.max(0, this.N);
                  f.b("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.k.getTop()), Integer.valueOf(this.k.getBottom()), Integer.valueOf(this.o), Integer.valueOf(this.N) });
                  if (Math.abs(this.N) > 50)
                  {
                    if ((!this.E) && (this.o >= a()) && (this.o <= b()))
                    {
                      this.i.vibrate(10L);
                      this.E = true;
                      this.L = this.N;
                    }
                    f.b("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.n.top + this.o), Boolean.valueOf(this.r), Boolean.valueOf(this.C) });
                    bool1 = true;
                  }
                  else
                  {
                    bool1 = false;
                  }
                  this.k.setTranslationY(this.o);
                  i();
                  c(paramMotionEvent);
                  f.b("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.k.getLeft()), Integer.valueOf(this.k.getTop()), Integer.valueOf(this.k.getRight()), Integer.valueOf(this.k.getBottom()) });
                  break label1117;
                }
              }
              bool1 = false;
              label1117:
              this.l = this.z;
              break label1615;
            }
          }
        }
        else
        {
          i1 = paramMotionEvent.findPointerIndex(this.M);
          if (i1 != -1)
          {
            this.z = paramMotionEvent.getY(i1);
            this.A = paramMotionEvent.getX(i1);
            e();
            this.l = 0.0F;
            this.L = 0.0F;
            this.E = false;
            this.R = (System.currentTimeMillis() - this.Q);
            f.b("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.o), Integer.valueOf(b()), Integer.valueOf(this.k.getBottom()), Long.valueOf(this.R) });
            if ((f()) && (this.q != null) && (!this.D) && (this.j) && (!this.P))
            {
              f.b("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.N), Float.valueOf(this.H) });
              if (d())
              {
                if (((this.C) && (this.o >= a())) || ((!this.C) && (this.o >= b()))) {
                  i1 = this.k.getBottom() + this.p;
                } else {
                  i1 = 0;
                }
                a(this.o, i1, b(paramMotionEvent));
              }
              else if (c())
              {
                i1 = this.o;
                if ((i1 >= 0) && (i1 >= b())) {
                  i1 = this.k.getBottom();
                } else {
                  i1 = 0;
                }
                a(this.o, i1, false);
              }
            }
            else if (!f())
            {
              this.B = false;
            }
            this.r = false;
            this.K = false;
            this.N = 0;
            this.M = -1;
            this.P = false;
            this.R = 0L;
            this.Q = 0L;
          }
        }
      }
      else if (!this.K)
      {
        this.M = paramMotionEvent.getPointerId(0);
        g();
        this.r = false;
        f1 = paramMotionEvent.getY(0);
        this.l = f1;
        this.z = f1;
        this.A = paramMotionEvent.getX(0);
        this.n.setEmpty();
        this.s = paramMotionEvent.getY(0);
        this.t = paramMotionEvent.getX(0);
        this.H = 0.0F;
        this.N = ((int)this.H);
        this.K = true;
        this.P = false;
        this.Q = System.currentTimeMillis();
        this.R = 0L;
        h();
      }
      boolean bool1 = false;
      label1615:
      f.b("MicroMsg.PullDownListView", "consumed: %b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1) {
        paramMotionEvent.setAction(3);
      }
      if (bool1) {
        return true;
      }
      try
      {
        boolean bool2 = super.onTouchEvent(paramMotionEvent);
        f.b("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", new Object[] { Boolean.valueOf(bool2) });
        if ((this.q != null) && (getChildCount() > 0))
        {
          i1 = getChildAt(0).getTop();
          f.b("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i1) });
          this.q.onListInnerScroll(i1);
        }
        return bool2;
      }
      catch (Exception paramMotionEvent)
      {
        f.a("MicroMsg.PullDownListView", paramMotionEvent, "%b, %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i2) });
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(11)
  public void resetLayout()
  {
    this.o = 0;
    f.b("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.k.getLeft()), Integer.valueOf(this.k.getTop()), Integer.valueOf(this.k.getRight()), Integer.valueOf(this.k.getBottom()) });
  }
  
  public void setCoordinationView(View paramView, int paramInt)
  {
    setCoordinationView(paramView, paramInt, this.f / 3);
  }
  
  public void setCoordinationView(View paramView, int paramInt1, int paramInt2)
  {
    this.y = paramView;
    this.J = paramInt1;
    this.I = paramInt2;
    this.e = 0;
    this.d = 0;
  }
  
  public void setMuteView(View paramView)
  {
    if (paramView != null)
    {
      post(new PullDownListView.1(this, paramView));
    }
    else
    {
      this.g = 0.0F;
      this.h = 0.0F;
    }
    this.m = paramView;
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    f.c("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.p = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.S = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.T = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.U = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.x = paramView;
  }
  
  public void switchNormalStatus()
  {
    f.c("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.C) {
      a(b() - 1, 0, false);
    }
  }
  
  public void switchPullDownStatus()
  {
    f.c("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.C) {
      a(a() + 1, this.k.getBottom() + this.p, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */