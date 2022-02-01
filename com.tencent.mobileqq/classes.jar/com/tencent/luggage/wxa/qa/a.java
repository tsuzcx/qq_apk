package com.tencent.luggage.wxa.qa;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.util.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  public g a = new g();
  protected LinearLayout b;
  protected String c;
  protected int d;
  protected int e;
  protected LinkedList<a.a> f = new LinkedList();
  public LinkedList<Pair<e, e>> g = new LinkedList();
  private int h = 0;
  private a.b i;
  
  public a(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.b = new LinearLayout(paramContext);
    this.b.setOrientation(0);
    this.b.setGravity(16);
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.b);
  }
  
  private static int a(@NonNull Context paramContext, int paramInt)
  {
    return Math.round(paramContext.getResources().getDisplayMetrics().density * paramInt);
  }
  
  private void a(Animator paramAnimator, Runnable paramRunnable)
  {
    paramAnimator.addListener(new a.12(this, paramRunnable));
    paramAnimator.start();
  }
  
  private void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.d = com.tencent.luggage.wxa.pc.g.a(paramString1, Color.parseColor("#E6000000"));
    this.e = com.tencent.luggage.wxa.pc.g.a(paramString2, Color.parseColor("#07C160"));
  }
  
  private a.a b(String paramString)
  {
    paramString = m.b(paramString);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (m.b(locala.a).equals(paramString)) {
        return locala;
      }
    }
    return null;
  }
  
  private void b()
  {
    a(new a.13(this));
  }
  
  private void b(String paramString1, String paramString2)
  {
    float f1 = a(getContext(), 1) / 2.0F;
    int j;
    if (f1 > 1.0F) {
      j = (int)f1;
    } else {
      j = 1;
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(com.tencent.luggage.wxa.pc.g.a(paramString1, -1));
    paramString1 = new GradientDrawable();
    paramString1.setShape(0);
    paramString1.setColor(0);
    if ("white".equals(paramString2)) {
      paramString1.setStroke(j, 872415231);
    } else {
      paramString1.setStroke(j, 855638016);
    }
    paramString1 = new LayerDrawable(new Drawable[] { localGradientDrawable, paramString1 });
    if ("top".equals(this.c))
    {
      j = -j;
      paramString1.setLayerInset(1, j, j, j, j);
    }
    else
    {
      j = -j;
      paramString1.setLayerInset(1, j, 0, j, j);
    }
    setBackground(paramString1);
  }
  
  public int a(String paramString)
  {
    return this.f.indexOf(b(paramString));
  }
  
  protected void a()
  {
    a.b localb = this.i;
    if (localb != null)
    {
      int j = this.h;
      localb.a(j, ((a.a)this.f.get(j)).a);
    }
  }
  
  public void a(int paramInt)
  {
    ((a.a)this.f.get(this.h)).e = false;
    if ((paramInt > 0) && (paramInt < this.f.size())) {
      this.h = paramInt;
    } else {
      this.h = 0;
    }
    ((a.a)this.f.get(this.h)).e = true;
    b();
  }
  
  public void a(int paramInt, String paramString, e parame1, e parame2)
  {
    if (paramInt >= this.f.size()) {
      return;
    }
    a.a locala = (a.a)this.f.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = locala.d;
    }
    locala.d = str;
    if (parame1 != null)
    {
      paramString = parame1;
      if (parame1.d() == null) {
        paramString = locala.b;
      }
      locala.b = paramString;
    }
    if (parame2 != null)
    {
      paramString = parame2;
      if (parame2.d() == null) {
        paramString = locala.c;
      }
      locala.c = paramString;
    }
    b();
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int k = com.tencent.luggage.wxa.pc.g.a(paramString3, 0);
    int m = com.tencent.luggage.wxa.pc.g.a(paramString4, -1);
    int j = 0;
    while (j < this.f.size())
    {
      if (j == paramInt)
      {
        ((a.a)this.f.get(j)).a();
        if ("redDot".equals(paramString1))
        {
          ((a.a)this.f.get(j)).f = true;
        }
        else if ("text".equals(paramString1))
        {
          ((a.a)this.f.get(j)).g = paramString2;
          ((a.a)this.f.get(j)).h = k;
          ((a.a)this.f.get(j)).i = m;
        }
        else if ("none".equals(paramString1))
        {
          ((a.a)this.f.get(j)).f = false;
          ((a.a)this.f.get(j)).g = "";
        }
      }
      j += 1;
    }
    b();
  }
  
  protected void a(Bitmap paramBitmap, ImageView paramImageView)
  {
    paramImageView.post(new a.5(this, paramImageView, paramBitmap));
  }
  
  protected void a(View paramView, a.a parama)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131428594);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131428595);
    TextView localTextView1 = (TextView)paramView.findViewById(2131428593);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131428598);
    TextView localTextView2 = (TextView)paramView.findViewById(2131428599);
    View localView = paramView.findViewById(2131428597);
    boolean bool = "top".equals(this.c);
    int k = 0;
    if (bool)
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, a(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.e)
      {
        localView.setBackgroundColor(this.e);
        localView.setVisibility(0);
      }
      else
      {
        localView.setVisibility(4);
      }
    }
    else
    {
      if (parama.b.d() != null)
      {
        if ((parama.d != null) && (!parama.d.equals("")))
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, a(getContext(), 54), 1.0F));
          localImageView1.setVisibility(0);
          localImageView1.getLayoutParams().width = a(getContext(), 32);
          localImageView1.getLayoutParams().height = a(getContext(), 28);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(1, 12.0F);
        }
        else
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, a(getContext(), 48), 1.0F));
          localImageView1.setVisibility(0);
          localImageView1.getLayoutParams().width = a(getContext(), 32);
          localImageView1.getLayoutParams().height = a(getContext(), 28);
          localTextView2.setVisibility(8);
        }
      }
      else if ((parama.d != null) && (!parama.d.equals("")))
      {
        paramView.setLayoutParams(new LinearLayout.LayoutParams(0, a(getContext(), 49), 1.0F));
        localImageView1.setVisibility(8);
        localTextView2.setVisibility(0);
        localTextView2.setTextSize(1, 16.0F);
      }
      localView.setVisibility(4);
    }
    paramView = localTextView1.getBackground();
    if (paramView != null) {
      paramView.setColorFilter(parama.h, PorterDuff.Mode.SRC_ATOP);
    }
    int j;
    if (parama.g.isEmpty()) {
      j = 4;
    } else {
      j = 0;
    }
    localTextView1.setVisibility(j);
    localTextView1.setText(parama.g);
    localTextView1.setTextColor(parama.i);
    if (parama.f) {
      j = k;
    } else {
      j = 4;
    }
    localImageView2.setVisibility(j);
    if ((parama.e) && (parama.c.d() != null))
    {
      parama.c.a(new a.2(this, localImageView1));
      parama.c.a();
    }
    else
    {
      parama.b.a(new a.3(this, localImageView1));
      parama.b.a();
    }
    localTextView2.setText(parama.d);
    if (parama.e) {
      localTextView2.setTextColor(this.e);
    } else {
      localTextView2.setTextColor(this.d);
    }
    if (!"top".equals(this.c)) {
      localTextView2.post(new a.4(this, localTextView2, localImageView1, localTextView1, localRelativeLayout, localImageView2));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(new a.1(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, @Nullable b paramb)
  {
    a.a locala = new a.a();
    locala.b = new c(paramString3, new a.6(this));
    locala.c = new c(paramString4, new a.7(this));
    locala.d = paramString2;
    locala.a = paramString1;
    this.g.add(new Pair(locala.b, locala.c));
    if ((locala.d == null) && ((locala.b.d() == null) || (locala.c.d() == null)))
    {
      o.b("MicroMsg.AppBrandPageTabBar", "illegal data");
      return;
    }
    if (paramb == null) {
      paramb = new b(getContext());
    }
    a(paramb, locala);
    paramb.setOnClickListener(new a.8(this));
    this.f.add(locala);
    this.b.addView(paramb);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!t.a())
    {
      t.a(new a.9(this, paramBoolean));
      return;
    }
    int k = getHeight();
    int j;
    if ("top".equals(this.c)) {
      j = -1;
    } else {
      j = 1;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, k * j });
    long l;
    if (paramBoolean) {
      l = 250L;
    } else {
      l = 0L;
    }
    localObjectAnimator.setDuration(l);
    a(localObjectAnimator, new a.10(this));
  }
  
  public void b(boolean paramBoolean)
  {
    int k = getHeight();
    int j;
    if ("top".equals(this.c)) {
      j = -1;
    } else {
      j = 1;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { k * j, 0.0F });
    long l;
    if (paramBoolean) {
      l = 250L;
    } else {
      l = 0L;
    }
    localObjectAnimator.setDuration(l);
    post(new a.11(this, localObjectAnimator));
  }
  
  public String getPosition()
  {
    return this.c;
  }
  
  public void setClickListener(a.b paramb)
  {
    this.i = paramb;
  }
  
  public void setPosition(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.a
 * JD-Core Version:    0.7.0.1
 */