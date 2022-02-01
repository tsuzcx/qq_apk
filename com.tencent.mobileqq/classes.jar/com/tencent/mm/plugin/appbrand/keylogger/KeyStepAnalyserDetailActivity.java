package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.nk.c.c;
import com.tencent.luggage.wxa.nk.l;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KeyStepAnalyserDetailActivity
  extends b
{
  private static int b = 3;
  private static SimpleDateFormat c = new SimpleDateFormat("HH:mm:ss");
  private View d;
  private View e;
  private LinearLayout f;
  private ScaleGestureDetector g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l = 1.0F;
  private float m = 1.0F;
  private Class n;
  private boolean o;
  private Map<String, c> p;
  private Map<String, Boolean> q;
  private ScaleGestureDetector.OnScaleGestureListener r = new KeyStepAnalyserDetailActivity.5(this);
  
  private c a(com.tencent.luggage.wxa.nk.b paramb, c.c paramc)
  {
    int i1;
    if (paramc == null)
    {
      if (paramb.d()) {
        i1 = -2;
      } else {
        i1 = -1;
      }
      if (af.c(paramb.e())) {
        paramb = paramb.b();
      } else {
        paramb = paramb.e();
      }
      paramb = new SpannableString(paramb);
    }
    else
    {
      boolean bool = paramc.e.equals("ok");
      int i2 = 0;
      if (!bool)
      {
        if (paramb.c()) {
          i1 = 1;
        } else {
          i1 = 2;
        }
      }
      else {
        i1 = 0;
      }
      String str = c.format(Long.valueOf(paramc.a));
      if (af.c(paramb.e())) {
        paramb = paramb.b();
      } else {
        paramb = paramb.e();
      }
      str = String.format("%s %s:%s %s", new Object[] { str, paramb, paramc.e, paramc.f });
      int i3 = str.length();
      paramb = str;
      if (paramc.g > 0L)
      {
        paramb = String.format(" cost:%d ms", new Object[] { Long.valueOf(paramc.g) });
        i2 = paramb.length();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(paramb);
        paramb = localStringBuilder.toString();
      }
      paramb = new SpannableString(paramb);
      if (this.q.containsKey(paramc.c)) {
        paramb.setSpan(new ForegroundColorSpan(-65536), i3, i2 + i3, 33);
      }
    }
    return new c(paramb, i1);
  }
  
  private void d()
  {
    TextView localTextView = (TextView)findViewById(2131436781);
    View localView = findViewById(2131431829);
    localTextView.setText(getIntent().getStringExtra("key_info"));
    f();
    localView.setOnClickListener(new KeyStepAnalyserDetailActivity.1(this));
  }
  
  private void e()
  {
    Object localObject2 = getIntent().getParcelableArrayListExtra("steps");
    Object localObject1 = new LinkedList((Collection)localObject2);
    Collections.sort((List)localObject1, new KeyStepAnalyserDetailActivity.2(this));
    this.q = new HashMap();
    int i2 = 0;
    int i1 = 0;
    while ((i1 < ((List)localObject1).size()) && (i1 <= b))
    {
      localObject3 = (c.c)((List)localObject1).get(i1);
      if ((((c.c)localObject3).g > 0L) && (!((c.c)localObject3).b())) {
        this.q.put(((c.c)((List)localObject1).get(i1)).c, Boolean.valueOf(true));
      }
      i1 += 1;
    }
    localObject1 = new HashMap();
    i1 = 0;
    while (i1 < ((List)localObject2).size())
    {
      localObject3 = (c.c)((List)localObject2).get(i1);
      ((Map)localObject1).put(((c.c)localObject3).c, localObject3);
      i1 += 1;
    }
    localObject2 = g.b(this.n);
    this.p = new HashMap();
    Object localObject3 = new ArrayList();
    i1 = i2;
    while (i1 < ((List)localObject2).size())
    {
      com.tencent.luggage.wxa.nk.b localb = ((l)((List)localObject2).get(i1)).a();
      c localc = a(localb, (c.c)((Map)localObject1).get(localb.b()));
      ((ArrayList)localObject3).add(localc);
      this.p.put(localb.b(), localc);
      i1 += 1;
    }
    ((VerticalStepView)findViewById(2131446352)).a((List)localObject3);
  }
  
  private void f()
  {
    int i1 = getResources().getDimensionPixelSize(2131296363);
    TextView localTextView = (TextView)findViewById(2131435237);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getString(2131891092));
    ((StringBuilder)localObject1).append(" ");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getString(2131891090));
    ((StringBuilder)localObject2).append(" ");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(getString(2131891091));
    ((StringBuilder)localObject3).append(" ");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = getString(2131891093);
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append((String)localObject2);
    ((StringBuilder)localObject5).append((String)localObject3);
    ((StringBuilder)localObject5).append((String)localObject4);
    localObject4 = new SpannableString(((StringBuilder)localObject5).toString());
    localObject5 = ContextCompat.getDrawable(this, 2130852652);
    ((Drawable)localObject5).setBounds(0, 0, i1, i1);
    ((SpannableString)localObject4).setSpan(new ImageSpan((Drawable)localObject5, 0), 0, 1, 17);
    int i2 = ((String)localObject1).length() + 0;
    localObject1 = ContextCompat.getDrawable(this, 2130852651);
    ((Drawable)localObject1).setBounds(0, 0, i1, i1);
    ((SpannableString)localObject4).setSpan(new ImageSpan((Drawable)localObject1, 0), i2, i2 + 1, 17);
    i2 += ((String)localObject2).length();
    localObject1 = ContextCompat.getDrawable(this, 2130852649);
    ((Drawable)localObject1).setBounds(0, 0, i1, i1);
    ((SpannableString)localObject4).setSpan(new ImageSpan((Drawable)localObject1, 0), i2, i2 + 1, 17);
    i2 += ((String)localObject3).length();
    localObject1 = ContextCompat.getDrawable(this, 2130852653);
    ((Drawable)localObject1).setBounds(0, 0, i1, i1);
    ((SpannableString)localObject4).setSpan(new ImageSpan((Drawable)localObject1, 0), i2, i2 + 1, 17);
    localTextView.setText((CharSequence)localObject4);
  }
  
  private void g()
  {
    if (this.d.getVisibility() == 0)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    if (!this.o)
    {
      this.f = ((LinearLayout)findViewById(2131431827));
      this.g = new ScaleGestureDetector(this, this.r);
      HashMap localHashMap = new HashMap();
      com.tencent.mm.plugin.appbrand.keylogger.stepview.b localb = new com.tencent.mm.plugin.appbrand.keylogger.stepview.b(this, false);
      localb.getViewTreeObserver().addOnGlobalLayoutListener(new KeyStepAnalyserDetailActivity.3(this, localb, this));
      g.a(this.n, new KeyStepAnalyserDetailActivity.4(this, localHashMap, localb, this));
      this.f.addView(localb);
      this.o = true;
    }
    this.d.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  protected int a()
  {
    return 2131624028;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool;
    if ((this.g != null) && (this.d.getVisibility() == 0))
    {
      super.dispatchTouchEvent(paramMotionEvent);
      bool = this.g.onTouchEvent(paramMotionEvent);
    }
    else
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = findViewById(2131431828);
    this.e = findViewById(2131447388);
    this.n = ((Class)getIntent().getSerializableExtra("key_process_class"));
    a(getString(2131891086));
    d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity
 * JD-Core Version:    0.7.0.1
 */