package com.tencent.luggage.wxa.di;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class a
  extends Preference
{
  private TextView A;
  private TextView B;
  private TextView C;
  private ImageView D;
  private int E = -1;
  private Context F;
  private boolean G = false;
  private boolean H = false;
  private int I = -1;
  private boolean J = false;
  protected int a = -1;
  protected ImageView b = null;
  RelativeLayout.LayoutParams c;
  private Drawable d;
  private String e = "";
  private int f = -1;
  private int g = 8;
  private int h = 8;
  private int i = 8;
  private String j = "";
  private String k = "";
  private int l = -1;
  private int m = 8;
  private int n = -1;
  private Bitmap o = null;
  private int p = 8;
  private int q = 8;
  private int r = 8;
  private int s = 8;
  private int t = 0;
  private ImageView u = null;
  private ViewGroup v = null;
  private View w = null;
  private View x = null;
  private ImageView y = null;
  private TextView z;
  
  public a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.F = paramContext;
    setLayoutResource(2131625201);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    this.o = null;
    ImageView localImageView = this.b;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.c.addRule(13);
    ImageView localImageView = this.b;
    if (localImageView == null) {
      return;
    }
    localImageView.setLayoutParams(this.c);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.o = paramBitmap;
    this.a = -1;
    ImageView localImageView = this.b;
    if (localImageView != null) {
      localImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void b(int paramInt)
  {
    this.p = paramInt;
    ImageView localImageView = this.b;
    if (localImageView != null) {
      localImageView.setVisibility(this.p);
    }
  }
  
  public void c(int paramInt)
  {
    this.q = paramInt;
    ViewGroup localViewGroup = this.v;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(this.q);
    }
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.D = ((ImageView)paramView.findViewById(2131435450));
    Object localObject = this.D;
    if (localObject != null)
    {
      Drawable localDrawable = this.d;
      if (localDrawable != null)
      {
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.D.setVisibility(0);
      }
      else if (getIcon() != null)
      {
        localObject = this.D;
        localDrawable = getIcon();
        this.d = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.D.setVisibility(0);
      }
      else
      {
        this.D.setVisibility(8);
      }
    }
    localObject = (LinearLayout)paramView.findViewById(2131438782);
    ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131296403));
    int i1 = this.E;
    if (i1 != -1) {
      ((LinearLayout)localObject).setMinimumHeight(i1);
    }
    this.C = ((TextView)paramView.findViewById(2131447240));
    localObject = this.C;
    if (localObject != null)
    {
      if (this.H)
      {
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130853407, 0, 0, 0);
        this.C.setCompoundDrawablePadding((int)this.F.getResources().getDimension(2131296404));
      }
      else
      {
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      this.C.setVisibility(this.g);
      this.C.setText(this.e);
      if (this.f != -1) {
        this.C.setBackgroundDrawable(this.F.getResources().getDrawable(this.f));
      }
    }
    this.B = ((TextView)paramView.findViewById(2131447241));
    localObject = this.B;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(this.m);
      this.B.setText(this.k);
      if (this.l != -1) {
        this.B.setBackgroundDrawable(this.F.getResources().getDrawable(this.l));
      }
      i1 = this.n;
      if (i1 != -1) {
        this.B.setTextColor(i1);
      }
      if (this.G)
      {
        this.B.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130853407, 0);
        this.B.setCompoundDrawablePadding((int)this.F.getResources().getDimension(2131296404));
      }
      else
      {
        this.B.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
    this.u = ((ImageView)paramView.findViewById(2131447200));
    this.u.setVisibility(this.h);
    i1 = this.I;
    if (i1 != -1) {
      this.u.setImageResource(i1);
    }
    this.b = ((ImageView)paramView.findViewById(2131435472));
    this.v = ((ViewGroup)paramView.findViewById(2131444849));
    this.x = paramView.findViewById(2131444815);
    this.x.setVisibility(this.s);
    this.w = paramView.findViewById(2131444846);
    this.w.setVisibility(this.r);
    this.y = ((ImageView)paramView.findViewById(2131444798));
    this.y.setVisibility(this.t);
    localObject = this.o;
    if (localObject != null)
    {
      this.b.setImageBitmap((Bitmap)localObject);
    }
    else
    {
      i1 = this.a;
      if (i1 != -1) {
        this.b.setImageResource(i1);
      }
    }
    this.b.setVisibility(this.p);
    this.v.setVisibility(this.q);
    localObject = this.c;
    if (localObject != null) {
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.z = ((TextView)paramView.findViewById(16908310));
    this.A = ((TextView)paramView.findViewById(2131431733));
    localObject = this.A;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(this.i);
      this.A.setText(this.j);
      if (this.J) {
        this.A.setTextColor(this.F.getResources().getColor(2131166006));
      } else {
        this.A.setTextColor(this.F.getResources().getColor(2131166291));
      }
    }
    localObject = this.z;
    if (localObject != null) {
      if (this.J) {
        ((TextView)localObject).setTextColor(this.F.getResources().getColor(2131166006));
      } else {
        ((TextView)localObject).setTextColor(this.F.getResources().getColor(2131166595));
      }
    }
    paramView.setEnabled(this.J ^ true);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131431322);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), 2131625202, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.di.a
 * JD-Core Version:    0.7.0.1
 */