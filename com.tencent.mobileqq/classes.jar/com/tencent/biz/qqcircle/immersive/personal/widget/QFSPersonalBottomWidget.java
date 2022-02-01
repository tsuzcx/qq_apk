package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.QFSPersonalFeedFragment;
import com.tencent.biz.qqcircle.immersive.QFSPersonalProductFeedFragment;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedVpAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTab;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import com.tencent.biz.qqcircle.immersive.personal.widget.viewindicator.ViewIndicator.TextItemClickListener;
import com.tencent.biz.qqcircle.immersive.utils.QFSDrawableUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QFSPersonalBottomWidget
  extends QCircleBaseWidgetView<ArrayList<QFSPersonalTab>>
  implements LifecycleOwner, ViewIndicator.TextItemClickListener
{
  private final QFSPersonalDetailsFragment a;
  private final LifecycleRegistry b = new LifecycleRegistry(this);
  private QFSPersonalViewModel c;
  private LinearLayout d;
  private ViewPager2 e;
  private QFSPersonalFeedVpAdapter f;
  private boolean g = false;
  private final int h;
  private final float i;
  private final double j;
  private boolean k = true;
  private float l;
  private float m;
  private RadioGroup n;
  private RadioButton o;
  private RadioButton p;
  private RadioButton q;
  private List<QFSPersonalTab> r;
  private int s = 0;
  
  public QFSPersonalBottomWidget(@NonNull Context paramContext, QFSPersonalDetailsFragment paramQFSPersonalDetailsFragment)
  {
    super(paramContext);
    this.b.setCurrentState(Lifecycle.State.CREATED);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.h = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.i = ImmersiveUtils.getScreenWidth();
    this.j = Math.tan(0.5235987755982988D);
    this.a = paramQFSPersonalDetailsFragment;
    a();
    b();
  }
  
  private void a()
  {
    this.c = ((QFSPersonalViewModel)getViewModel(this.a, QFSPersonalViewModel.class));
    this.c.d().observe(this, new QFSPersonalBottomWidget.1(this));
    this.c.e().observe(this, new QFSPersonalBottomWidget.2(this));
    this.c.b().observe(this, new QFSPersonalBottomWidget.3(this));
  }
  
  private void a(View paramView)
  {
    this.n = ((RadioGroup)paramView.findViewById(2131444765));
    this.o = ((RadioButton)paramView.findViewById(2131444189));
    this.p = ((RadioButton)paramView.findViewById(2131444191));
    this.q = ((RadioButton)paramView.findViewById(2131444188));
    this.n.setOnCheckedChangeListener(new QFSPersonalBottomWidget.4(this));
    b(20101);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130845809, 0);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return;
    }
    Object localObject = getContext();
    if (this.s == 2) {
      i1 = 2130848859;
    } else {
      i1 = 2130848860;
    }
    localObject = ContextCompat.getDrawable((Context)localObject, i1);
    int i1 = ViewUtils.a(45.0F);
    this.q.setCompoundDrawablesWithIntrinsicBounds(null, null, QFSDrawableUtils.a((Drawable)localObject, i1, i1), null);
  }
  
  private void b()
  {
    if (this.a.D()) {
      this.e.registerOnPageChangeCallback(new QFSPersonalBottomWidget.5(this));
    } else {
      this.k = false;
    }
    this.f = new QFSPersonalFeedVpAdapter(this.a);
    this.f.a(Arrays.asList(new QFSPersonalFeedFragment[] { c(), QFSPersonalFeedFragment.a(20103), QFSPersonalFeedFragment.a(20102) }));
    this.e.setAdapter(this.f);
    this.e.registerOnPageChangeCallback(new QFSPersonalBottomWidget.6(this));
  }
  
  private void b(int paramInt)
  {
    TextPaint localTextPaint1 = this.o.getPaint();
    TextPaint localTextPaint2 = this.p.getPaint();
    TextPaint localTextPaint3 = this.q.getPaint();
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 20101) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localTextPaint1.setFakeBoldText(bool1);
    if (paramInt == 20103) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localTextPaint2.setFakeBoldText(bool1);
    if (paramInt == 20102) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localTextPaint3.setFakeBoldText(bool1);
  }
  
  private QFSPersonalFeedFragment c()
  {
    QFSPersonalFeedFragment localQFSPersonalFeedFragment = QFSPersonalFeedFragment.a(20101);
    if ((localQFSPersonalFeedFragment instanceof QFSPersonalProductFeedFragment))
    {
      QFSPersonalProductFeedFragment localQFSPersonalProductFeedFragment = (QFSPersonalProductFeedFragment)localQFSPersonalFeedFragment;
      this.d.setOnClickListener(new QFSPersonalBottomWidget.7(this, localQFSPersonalProductFeedFragment));
      localQFSPersonalProductFeedFragment.a(new QFSPersonalBottomWidget.8(this));
    }
    return localQFSPersonalFeedFragment;
  }
  
  private void setPrivateButton(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      a(paramBoolean);
      return;
    }
    this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130845809, 0);
  }
  
  public void a(int paramInt) {}
  
  protected void a(ArrayList<QFSPersonalTab> paramArrayList, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131627156;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.b;
  }
  
  protected String getLogTag()
  {
    return "QFSPersonalBottomWidget";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b.setCurrentState(Lifecycle.State.STARTED);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.e = ((ViewPager2)findViewById(2131450001));
    this.d = ((LinearLayout)paramView.findViewById(2131437480));
    VideoReport.setElementId(this.d, "em_xsj_product_look_finished_tab");
    paramContext = new QCircleDTParamBuilder().buildElementParams();
    VideoReport.setElementParams(this.d, paramContext);
    a(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.k)
    {
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if (i1 == 2)
        {
          float f1 = paramMotionEvent.getX();
          float f3 = paramMotionEvent.getY();
          float f2 = Math.abs(this.l - f1);
          f3 = Math.abs(this.m - f3);
          if (f1 - this.l > this.h)
          {
            double d1 = f2;
            double d2 = this.j;
            Double.isNaN(d1);
            if (d1 * d2 > f3) {
              return true;
            }
          }
        }
      }
      else
      {
        this.l = paramMotionEvent.getX();
        this.m = paramMotionEvent.getY();
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.k) && (paramMotionEvent.getAction() == 1))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = this.l;
      if ((f1 - f2 > 0.0F) && (f1 - f2 >= this.i / 4.0F) && ((getContext() instanceof Activity))) {
        ((Activity)getContext()).onBackPressed();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget
 * JD-Core Version:    0.7.0.1
 */