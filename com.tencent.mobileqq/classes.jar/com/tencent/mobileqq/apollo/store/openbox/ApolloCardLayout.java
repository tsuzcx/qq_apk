package com.tencent.mobileqq.apollo.store.openbox;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ApolloCardLayout
  extends RelativeLayout
{
  private int a;
  private int b;
  private Paint c;
  private Path d;
  private Path e;
  private Path f;
  private PorterDuffXfermode g;
  private int h;
  private ApolloBoxData.ApolloBoxDataItem i;
  private AnimationableProgressView j;
  private TextView k;
  private TextView l;
  private URLImageView m;
  private URLImageView n;
  private RelativeLayout o;
  private URLImageView p;
  private TextView q;
  private TextView r;
  private URLImageView s;
  private MultiURLImageView t;
  
  public ApolloCardLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ApolloCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setColor(-1);
    this.c.setStyle(Paint.Style.FILL);
    this.g = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  }
  
  private void a(int paramInt)
  {
    c();
    if (this.h == 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
      localLayoutParams.width = ((int)(paramInt * 0.78F));
      localLayoutParams.addRule(14);
      this.k.setVisibility(0);
      return;
    }
    this.k.setVisibility(8);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    b();
    if (this.h == 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
      float f1 = paramInt1;
      localLayoutParams.width = ((int)(0.535F * f1));
      localLayoutParams.height = ((int)(f1 * 0.113F));
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = ((int)(paramInt2 * 0.129F));
      this.j.setVisibility(0);
      return;
    }
    this.j.setVisibility(8);
  }
  
  private void b()
  {
    if (this.j == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.j = new AnimationableProgressView(getContext());
      addView(this.j, localLayoutParams);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.l == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(10);
      localLayoutParams.topMargin = ((int)(paramInt * 0.703F));
      this.l = new TextView(getContext());
      this.l.setTextSize(18.0F);
      this.l.setId(2131428436);
      this.l.setTextColor(-16777216);
      this.l.setEllipsize(TextUtils.TruncateAt.END);
      this.l.setSingleLine(true);
      addView(this.l, localLayoutParams);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    b(paramInt2);
    this.l.setMaxWidth((int)(paramInt1 * 0.8F));
    Object localObject = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
    if (this.i.t == 1)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramInt2 * 0.806F));
      this.l.setText(HardCodeUtil.a(2131898558));
      this.l.setTextSize(14.0F);
      this.l.setTextColor(-16777216);
      return;
    }
    StringBuilder localStringBuilder;
    if (this.i.t == 2)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramInt2 * 0.697F));
      localObject = this.l;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i.s);
      localStringBuilder.append(HardCodeUtil.a(2131898564));
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.l.setTextSize(18.0F);
      this.l.setTextColor(-1);
      return;
    }
    if (this.i.t == 3)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramInt2 * 0.697F));
      localObject = this.l;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i.s);
      localStringBuilder.append(HardCodeUtil.a(2131898559));
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.l.setTextSize(18.0F);
      this.l.setTextColor(-1);
      return;
    }
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramInt2 * 0.703F));
    this.l.setText(this.i.h);
    paramInt1 = getCardNameTextSize();
    this.l.setTextSize(paramInt1);
    this.l.setTextColor(-16777216);
  }
  
  private void c()
  {
    if (this.k == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(48.0F));
      localLayoutParams.addRule(3, 2131428436);
      localLayoutParams.topMargin = ViewUtils.dip2px(9.0F);
      this.k = new TextView(getContext());
      this.k.setTextColor(Color.parseColor("#777777"));
      this.k.setTextSize(1, 14.0F);
      this.k.setGravity(49);
      this.k.setMaxLines(2);
      this.k.setEllipsize(TextUtils.TruncateAt.END);
      addView(this.k, localLayoutParams);
    }
  }
  
  private void c(int paramInt)
  {
    f();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = ((int)(paramInt * 0.073F));
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    d();
    if (this.i.t == 1)
    {
      localObject = getContext().getResources().getDrawable(2130838475);
      f1 = getCardImageScale();
      paramInt1 = (int)(((Drawable)localObject).getIntrinsicWidth() * f1);
      int i1 = (int)(((Drawable)localObject).getIntrinsicHeight() * f1);
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, i1);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      localLayoutParams.bottomMargin = ((int)(paramInt2 * 0.588F) - i1 / 2);
      this.m.setImageDrawable((Drawable)localObject);
      this.m.setLayoutParams(localLayoutParams);
      return;
    }
    if (this.i.t == 2)
    {
      localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_gold_icon.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_gold_icon.png"));
      f1 = paramInt2;
      paramInt1 = (int)(0.38F * f1);
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      localLayoutParams.bottomMargin = ((int)(f1 * 0.574F) - paramInt1 / 2);
      this.m.setImageDrawable((Drawable)localObject);
      this.m.setLayoutParams(localLayoutParams);
      return;
    }
    if (this.i.t == 3)
    {
      localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_crystal_image.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_crystal_image.png"));
      ((URLDrawable)localObject).startDownload();
      f1 = paramInt2;
      paramInt1 = (int)(0.363F * f1);
      localLayoutParams = new RelativeLayout.LayoutParams((int)(0.3F * f1), paramInt1);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      localLayoutParams.bottomMargin = ((int)(f1 * 0.574F) - paramInt1 / 2);
      this.m.setImageDrawable((Drawable)localObject);
      this.m.setLayoutParams(localLayoutParams);
      return;
    }
    Object localObject = getBoxDrawable();
    float f1 = paramInt1;
    paramInt1 = (int)(0.488F * f1);
    float f2 = paramInt2;
    paramInt2 = (int)(0.531F * f2);
    if ((this.i.f == 3) || (this.i.x == 1))
    {
      paramInt1 = (int)(f1 * 0.714F);
      paramInt2 = (int)(0.497F * f2);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.bottomMargin = ((int)(f2 * 0.373F));
    this.m.setImageDrawable((Drawable)localObject);
  }
  
  private void d()
  {
    if (this.m == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.m = new URLImageView(getContext());
      this.m.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      addView(this.m, localLayoutParams);
    }
  }
  
  private void d(int paramInt)
  {
    g();
    Object localObject;
    if (this.h == 1)
    {
      localObject = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      paramInt = (int)(paramInt * 0.15F);
      ((RelativeLayout.LayoutParams)localObject).width = paramInt;
      ((RelativeLayout.LayoutParams)localObject).height = paramInt;
      this.p.setBackgroundResource(2130838498);
      this.p.setImageDrawable(null);
      this.p.setPadding(1, 1, 1, 1);
    }
    if ((!this.i.c) && (!TextUtils.isEmpty(this.i.l)))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ImageUtil.j();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      ApolloDrawableExtraInfo localApolloDrawableExtraInfo = new ApolloDrawableExtraInfo();
      localApolloDrawableExtraInfo.mDrawableType = ApolloConstant.ad;
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localApolloDrawableExtraInfo;
      localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.i.l), (URLDrawable.URLDrawableOptions)localObject, this.i.l);
      this.p.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    e();
    Object localObject = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    float f1 = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(0.103F * f1));
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramInt2 * 0.074F));
    paramInt1 = (int)(0.2F * f1);
    paramInt2 = (int)(f1 * 0.252F);
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    boolean bool = TextUtils.isEmpty(this.i.w);
    localObject = null;
    if (!bool)
    {
      localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.i.w), null, this.i.w);
    }
    else
    {
      String str = getVipLevelImageName();
      if (!TextUtils.isEmpty(str)) {
        localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(str, null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl(str));
      }
    }
    this.n.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void e()
  {
    if (this.n == null)
    {
      this.n = new URLImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.n.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      addView(this.n, localLayoutParams);
    }
  }
  
  private void e(int paramInt)
  {
    j();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    localLayoutParams.width = (paramInt * 130 / 760);
    localLayoutParams.height = (paramInt * 142 / 760);
    localLayoutParams.topMargin = ((int)(paramInt * 0.45F));
    localLayoutParams.rightMargin = (paramInt * 25 / 760);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    h();
    if (this.h == 1)
    {
      Object localObject = this.q;
      float f1 = paramInt1;
      ((TextView)localObject).setMaxWidth((int)(0.5F * f1));
      localObject = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramInt2 * 0.017F));
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(f1 * 0.2F));
    }
  }
  
  private void f()
  {
    if (this.o == null)
    {
      this.o = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      addView(this.o, localLayoutParams);
    }
  }
  
  private void f(int paramInt)
  {
    if (this.i.t == 1)
    {
      k();
      return;
    }
    if ((this.i.t != 2) && (this.i.t != 3))
    {
      l();
      return;
    }
    g(paramInt);
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    i();
    if (this.h == 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.r.getLayoutParams();
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      localLayoutParams.topMargin = ((int)(paramInt2 * 0.065F));
      localLayoutParams.leftMargin = ((int)(paramInt1 * 0.2F));
    }
  }
  
  private MultiURLImageView.ViewLayoutData g(int paramInt1, int paramInt2)
  {
    MultiURLImageView.ViewLayoutData localViewLayoutData = new MultiURLImageView.ViewLayoutData();
    if (paramInt2 == 1) {
      localViewLayoutData.a = (paramInt1 * 35 / 760);
    } else {
      localViewLayoutData.a = (paramInt1 * 55 / 760);
    }
    localViewLayoutData.b = (paramInt1 * 80 / 760);
    StringBuilder localStringBuilder;
    if (this.i.t == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_card_gold_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(".png");
      localViewLayoutData.f = localStringBuilder.toString();
    }
    else if (this.i.t == 3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_card_crystal_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(".png");
      localViewLayoutData.f = localStringBuilder.toString();
    }
    localViewLayoutData.c = (-paramInt1 * 4 / 760);
    localViewLayoutData.e = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl(localViewLayoutData.f);
    return localViewLayoutData;
  }
  
  private void g()
  {
    if (this.p == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.p = new URLImageView(getContext());
      this.p.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.o.addView(this.p, localLayoutParams);
    }
  }
  
  private void g(int paramInt)
  {
    this.j.setVisibility(8);
    this.n.setVisibility(8);
    this.k.setVisibility(8);
    this.s.setVisibility(0);
    Object localObject = getStolenGotDrawable();
    this.s.setBackgroundDrawable((Drawable)localObject);
    if (this.i.c)
    {
      if (this.h == 1) {
        this.l.setVisibility(0);
      } else {
        this.l.setVisibility(8);
      }
      this.m.setVisibility(0);
      this.o.setVisibility(8);
    }
    else
    {
      if (this.h == 1)
      {
        this.l.setVisibility(4);
        this.o.setVisibility(0);
        this.r.setText(TimeFormatterUtils.e(this.i.e * 1000L));
        TextView localTextView = this.q;
        if (TextUtils.isEmpty(this.i.j)) {
          localObject = String.valueOf(this.i.a);
        } else {
          localObject = this.i.j;
        }
        localTextView.setText((CharSequence)localObject);
      }
      else
      {
        this.l.setVisibility(8);
        this.o.setVisibility(8);
      }
      this.m.setVisibility(4);
    }
    i(paramInt);
  }
  
  private URLDrawable getBoxDrawable()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((3 != this.i.f) && ((this.i.u == null) || (!this.i.u.endsWith(".gif"))))
    {
      localURLDrawableOptions = null;
    }
    else
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
      localURLDrawableOptions.mExtraInfo = null;
      localURLDrawableOptions.mPlayGifImage = true;
    }
    if (!TextUtils.isEmpty(this.i.u))
    {
      localObject = localURLDrawableOptions;
      if (localURLDrawableOptions == null) {
        localObject = URLDrawable.URLDrawableOptions.obtain();
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
      }
      return URLDrawable.getDrawable(this.i.u, (URLDrawable.URLDrawableOptions)localObject);
    }
    Object localObject = (IApolloUtil)QRoute.api(IApolloUtil.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task_detail");
    localStringBuilder.append(String.valueOf(this.i.f));
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(this.i.g));
    return ((IApolloUtil)localObject).getDrawable(localStringBuilder.toString(), localURLDrawableOptions, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getBoxFloatUrl(this.i.f, this.i.g));
  }
  
  private float getCardImageScale()
  {
    int i1 = this.h;
    if (i1 == 2) {
      return 0.55F;
    }
    if (i1 == 3) {
      return 0.38F;
    }
    if (i1 == 4) {
      return 0.28F;
    }
    return 1.0F;
  }
  
  private int getCardNameTextSize()
  {
    int i1 = this.h;
    if (i1 == 1) {
      return 18;
    }
    if (i1 == 2) {
      return 14;
    }
    if (i1 == 3) {
      return 10;
    }
    return 8;
  }
  
  private URLDrawable getStolenGotDrawable()
  {
    if (this.i.c)
    {
      if (this.i.b != this.i.a) {
        return ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_self_stolen_got_2016_9_22.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_self_stolen_got_2016_9_22.png"));
      }
      return null;
    }
    return ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_other_stolen_got_2016_9_22.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_other_stolen_got_2016_9_22.png"));
  }
  
  private String getVipLevelImageName()
  {
    if ("A".equals(this.i.i)) {
      return "apollo_box_card_a_2016_09_20.png";
    }
    if ("B".equals(this.i.i)) {
      return "apollo_box_card_b_2016_09_20.png";
    }
    if ("C".equals(this.i.i)) {
      return "apollo_box_card_c_2016_09_20.png";
    }
    if ("S".equals(this.i.i)) {
      return "apollo_box_card_s_2016_09_20.png";
    }
    if ("V".equals(this.i.i)) {
      return "apollo_box_card_v_2017_11_03.png";
    }
    return null;
  }
  
  private MultiURLImageView.ViewLayoutData h(int paramInt)
  {
    MultiURLImageView.ViewLayoutData localViewLayoutData = new MultiURLImageView.ViewLayoutData();
    localViewLayoutData.a = (paramInt * 46 / 760);
    localViewLayoutData.b = (paramInt * 68 / 760);
    localViewLayoutData.d = ImageView.ScaleType.FIT_END;
    if (this.i.t == 2) {
      localViewLayoutData.f = "apollo_card_gold_add.png";
    } else if (this.i.t == 3) {
      localViewLayoutData.f = "apollo_card_crystal_add.png";
    }
    localViewLayoutData.e = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl(localViewLayoutData.f);
    return localViewLayoutData;
  }
  
  private void h()
  {
    if (this.q == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.q = new TextView(getContext());
      this.q.setTextSize(14.0F);
      this.q.setTextColor(-16777216);
      this.q.setSingleLine(true);
      this.q.setEllipsize(TextUtils.TruncateAt.END);
      this.q.setIncludeFontPadding(false);
      this.o.addView(this.q, localLayoutParams);
    }
  }
  
  private void i()
  {
    if (this.r == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.r = new TextView(getContext());
      this.r.setTextSize(10.0F);
      this.r.setIncludeFontPadding(false);
      this.r.setTextColor(-16777216);
      this.o.addView(this.r, localLayoutParams);
    }
  }
  
  private void i(int paramInt)
  {
    m();
    Object localObject = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = (paramInt * 155 / 760);
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = (paramInt * 320 / 760);
    localObject = new ArrayList();
    ((List)localObject).add(h(paramInt));
    if (this.i.s >= 10) {
      ((List)localObject).add(g(paramInt, this.i.s % 100 / 10));
    }
    ((List)localObject).add(g(paramInt, this.i.s % 10));
    this.t.setOrientation(0);
    this.t.setViewLayoutDatas((List)localObject);
    if (this.i.c)
    {
      this.t.setVisibility(0);
      return;
    }
    this.t.setVisibility(4);
  }
  
  private void j()
  {
    if (this.s == null)
    {
      this.s = new URLImageView(getContext());
      addView(this.s);
    }
  }
  
  private void k()
  {
    if (this.h == 1) {
      this.l.setVisibility(0);
    } else {
      this.l.setVisibility(8);
    }
    this.s.setVisibility(8);
    this.n.setVisibility(8);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
    this.o.setVisibility(8);
    MultiURLImageView localMultiURLImageView = this.t;
    if (localMultiURLImageView != null) {
      localMultiURLImageView.setVisibility(4);
    }
    this.m.setVisibility(0);
  }
  
  private void l()
  {
    this.m.setVisibility(0);
    this.l.setVisibility(0);
    this.n.setVisibility(0);
    this.s.setVisibility(0);
    Object localObject = getStolenGotDrawable();
    this.s.setBackgroundDrawable((Drawable)localObject);
    if (this.i.c)
    {
      if (this.h == 1)
      {
        this.j.setVisibility(0);
        this.j.a(this.i.o, this.i.n, this.i.q, this.i.r);
        if (!TextUtils.isEmpty(this.i.v))
        {
          this.j.setVisibility(8);
          this.k.setVisibility(0);
          this.k.setText(this.i.v);
        }
        else
        {
          this.j.setVisibility(0);
          this.k.setVisibility(8);
        }
      }
      this.o.setVisibility(8);
    }
    else
    {
      this.j.setVisibility(8);
      if (this.h == 1) {
        this.o.setVisibility(0);
      } else {
        this.o.setVisibility(8);
      }
      this.r.setText(TimeFormatterUtils.e(this.i.e * 1000L));
      TextView localTextView = this.q;
      if (TextUtils.isEmpty(this.i.j)) {
        localObject = String.valueOf(this.i.a);
      } else {
        localObject = this.i.j;
      }
      localTextView.setText((CharSequence)localObject);
    }
    localObject = this.t;
    if (localObject != null) {
      ((MultiURLImageView)localObject).setVisibility(4);
    }
  }
  
  private void m()
  {
    if (this.t == null)
    {
      this.t = new MultiURLImageView(getContext());
      addView(this.t);
    }
  }
  
  public void a(int paramInt1, ApolloBoxData.ApolloBoxDataItem paramApolloBoxDataItem, int paramInt2, int paramInt3)
  {
    this.h = paramInt1;
    this.i = paramApolloBoxDataItem;
    if (this.i == null)
    {
      QLog.e("[cmshow]ApolloCardLayout", 1, "updateView mDataItem null");
      return;
    }
    a(paramInt2, paramInt3);
    a(paramInt2);
    b(paramInt2, paramInt3);
    c(paramInt2, paramInt3);
    d(paramInt2, paramInt3);
    c(paramInt3);
    d(paramInt2);
    e(paramInt2, paramInt3);
    f(paramInt2, paramInt3);
    e(paramInt3);
    f(paramInt3);
  }
  
  @SuppressLint({"WrongConstant"})
  @TargetApi(21)
  protected void dispatchDraw(Canvas paramCanvas)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    if (Build.VERSION.SDK_INT >= 21) {
      i1 = paramCanvas.saveLayer(0.0F, 0.0F, this.a, this.b, null);
    } else {
      i1 = paramCanvas.saveLayer(0.0F, 0.0F, this.a, this.b, null, 1);
    }
    ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = this.i;
    if (localApolloBoxDataItem != null) {
      if ((localApolloBoxDataItem.t != 2) && (this.i.t != 3))
      {
        if (this.d != null)
        {
          this.c.setColor(-1);
          this.c.setXfermode(null);
          paramCanvas.drawPath(this.d, this.c);
        }
      }
      else if (this.i.c)
      {
        if (this.d != null)
        {
          this.c.setColor(-2147483648);
          this.c.setXfermode(null);
          paramCanvas.drawPath(this.d, this.c);
          this.c.setColor(654311423);
          this.c.setXfermode(null);
          paramCanvas.drawPath(this.d, this.c);
        }
      }
      else
      {
        super.drawChild(paramCanvas, this.m, getDrawingTime());
        super.drawChild(paramCanvas, this.l, getDrawingTime());
        super.drawChild(paramCanvas, this.t, getDrawingTime());
        if (this.e != null)
        {
          this.c.setColor(-1778384896);
          this.c.setXfermode(null);
          paramCanvas.drawPath(this.e, this.c);
        }
        if (this.f != null)
        {
          this.c.setColor(-1);
          this.c.setXfermode(null);
          paramCanvas.drawPath(this.f, this.c);
        }
      }
    }
    super.dispatchDraw(paramCanvas);
    localApolloBoxDataItem = this.i;
    if ((localApolloBoxDataItem != null) && (!localApolloBoxDataItem.c) && (this.i.t == 0))
    {
      this.c.setXfermode(this.g);
      if (this.i.p != -1) {
        this.c.setColor(this.i.p);
      } else {
        this.c.setColor(-1728053248);
      }
      if (this.h == 1) {
        paramCanvas.drawRect(0.0F, 0.0F, this.a, 0.78F * this.b, this.c);
      } else {
        paramCanvas.drawRect(0.0F, 0.0F, this.a, this.b, this.c);
      }
      super.drawChild(paramCanvas, this.s, getDrawingTime());
    }
    paramCanvas.restoreToCount(i1);
    if (QLog.isColorLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("ApolloCardLayout onDraw use");
      paramCanvas.append(System.currentTimeMillis() - l1);
      QLog.e("[cmshow]ApolloCardWindow", 2, paramCanvas.toString());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.a) || (paramInt2 != this.b))
    {
      this.a = paramInt1;
      this.b = paramInt2;
      if (this.d == null) {
        this.d = new Path();
      }
      paramInt1 = this.a;
      paramInt3 = (int)(paramInt1 * 0.037F);
      paramInt1 = (int)(paramInt1 * 0.047F);
      paramInt2 = (int)(this.b * 0.026F);
      this.d.reset();
      Path localPath = this.d;
      float f1 = paramInt1 + paramInt3;
      localPath.moveTo(f1, this.b - paramInt2);
      localPath = this.d;
      float f2 = paramInt1;
      paramInt4 = this.b;
      paramInt3 *= 2;
      float f4 = paramInt4 - paramInt3 - paramInt2;
      float f3 = paramInt1 + paramInt3;
      localPath.arcTo(new RectF(f2, f4, f3, paramInt4 - paramInt2), 90.0F, 90.0F);
      localPath = this.d;
      f4 = paramInt2;
      float f5 = paramInt2 + paramInt3;
      localPath.arcTo(new RectF(f2, f4, f3, f5), 180.0F, 90.0F);
      localPath = this.d;
      paramInt4 = this.a;
      localPath.arcTo(new RectF(paramInt4 - paramInt3 - paramInt1, f4, paramInt4 - paramInt1, f5), -90.0F, 90.0F);
      localPath = this.d;
      paramInt4 = this.a;
      float f6 = paramInt4 - paramInt3 - paramInt1;
      int i1 = this.b;
      localPath.arcTo(new RectF(f6, i1 - paramInt3 - paramInt2, paramInt4 - paramInt1, i1 - paramInt2), 0.0F, 90.0F);
      this.d.close();
      if (this.e == null) {
        this.e = new Path();
      }
      this.e.reset();
      paramInt4 = (int)(this.b * 0.78F);
      localPath = this.e;
      f6 = paramInt4;
      localPath.moveTo(f2, f6);
      this.e.arcTo(new RectF(f2, f4, f3, f5), 180.0F, 90.0F);
      localPath = this.e;
      paramInt4 = this.a;
      localPath.arcTo(new RectF(paramInt4 - paramInt3 - paramInt1, f4, paramInt4 - paramInt1, f5), -90.0F, 90.0F);
      this.e.lineTo(this.a - paramInt1, f6);
      this.e.close();
      if (this.f == null) {
        this.f = new Path();
      }
      this.f.reset();
      this.f.moveTo(f1, this.b - paramInt2);
      localPath = this.f;
      paramInt4 = this.b;
      localPath.arcTo(new RectF(f2, paramInt4 - paramInt3 - paramInt2, f3, paramInt4 - paramInt2), 90.0F, 90.0F);
      this.f.lineTo(f2, f6);
      this.f.lineTo(this.a - paramInt1, f6);
      localPath = this.f;
      paramInt4 = this.a;
      f1 = paramInt4 - paramInt3 - paramInt1;
      i1 = this.b;
      localPath.arcTo(new RectF(f1, i1 - paramInt3 - paramInt2, paramInt4 - paramInt1, i1 - paramInt2), 0.0F, 90.0F);
      this.f.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardLayout
 * JD-Core Version:    0.7.0.1
 */