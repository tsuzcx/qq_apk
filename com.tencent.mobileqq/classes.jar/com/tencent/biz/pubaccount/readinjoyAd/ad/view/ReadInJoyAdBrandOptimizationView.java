package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyAdBrandOptimizationView
  extends ViewBase
  implements View.OnClickListener
{
  private static final Drawable a = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private URLImageView F;
  private URLImageView G;
  private URLImageView H;
  private URLImageView I;
  private URLImageView J;
  private URLImageView K;
  private URLImageView L;
  private URLImageView M;
  private boolean N;
  private Context b;
  private View c;
  private AdvertisementInfo d;
  private IReadInJoyModel e;
  private NativeReadInjoyImageView f;
  private NativeReadInjoyImageView g;
  private NativeReadInjoyImageView h;
  private NativeReadInjoyImageView i;
  private RelativeLayout j;
  private NativeReadInjoyImageView k;
  private NativeReadInjoyImageView l;
  private RelativeLayout m;
  private ReadInJoyAdBrandOptimizationView.BrandGoodsInfo n;
  private ReadInJoyAdBrandOptimizationView.BrandGoodsInfo o;
  private boolean p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public ReadInJoyAdBrandOptimizationView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.b = paramVafContext.getContext();
    a(this.b);
    c();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 + paramInt2 - paramInt3 / 2;
  }
  
  private void a(Context paramContext)
  {
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131629126, null);
    this.f = ((NativeReadInjoyImageView)this.c.findViewById(2131449249));
    this.j = ((RelativeLayout)this.c.findViewById(2131435458));
    this.g = ((NativeReadInjoyImageView)this.c.findViewById(2131435573));
    this.h = ((NativeReadInjoyImageView)this.c.findViewById(2131435574));
    this.i = ((NativeReadInjoyImageView)this.c.findViewById(2131435575));
    this.q = ((TextView)this.c.findViewById(2131427674));
    this.k = ((NativeReadInjoyImageView)this.c.findViewById(2131434307));
    this.m = ((RelativeLayout)this.c.findViewById(2131434304));
    this.q = ((TextView)this.c.findViewById(2131427674));
    this.l = ((NativeReadInjoyImageView)this.c.findViewById(2131434302));
    this.r = ((TextView)this.c.findViewById(2131434305));
    this.s = ((TextView)this.c.findViewById(2131434311));
    this.t = ((TextView)this.c.findViewById(2131434303));
    this.u = ((TextView)this.c.findViewById(2131427750));
    this.v = ((TextView)this.c.findViewById(2131427745));
    this.F = ((URLImageView)this.c.findViewById(2131437134));
    this.G = ((URLImageView)this.c.findViewById(2131444857));
    this.H = ((URLImageView)this.c.findViewById(2131437087));
    this.I = ((URLImageView)this.c.findViewById(2131444805));
    this.J = ((URLImageView)this.c.findViewById(2131434309));
    this.K = ((URLImageView)this.c.findViewById(2131434313));
    this.L = ((URLImageView)this.c.findViewById(2131434308));
    this.M = ((URLImageView)this.c.findViewById(2131434312));
    this.f.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.c.setOnClickListener(new ReadInJoyAdBrandOptimizationView.1(this));
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    if (paramFloat1 < paramFloat2) {
      return;
    }
    paramFloat2 = (paramFloat1 - paramFloat2) * paramFloat3;
    paramFloat1 = paramFloat2;
    if (paramFloat2 > 1.0F) {
      paramFloat1 = 1.0F;
    }
    paramView.setTranslationY((paramFloat1 - 1.0F) * paramInt);
    paramView.setAlpha(paramFloat1);
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, float paramFloat, int paramInt)
  {
    if (paramFloat >= 0.33F)
    {
      paramLayoutParams.height = paramInt;
      return;
    }
    float f1 = paramFloat * 3.0F;
    paramFloat = f1;
    if (f1 > 1.0F) {
      paramFloat = 1.0F;
    }
    paramLayoutParams.height = ((int)(paramInt * paramFloat));
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, float paramFloat1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat2)
  {
    paramLayoutParams.leftMargin = (paramInt1 + (int)(paramInt3 * paramFloat1));
    paramLayoutParams.topMargin = (paramInt2 + (int)(paramInt4 * paramFloat1));
    float f1 = this.n.b - paramInt5 * paramFloat1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("angle = ");
    ((StringBuilder)localObject).append(f1);
    QLog.d("ANGLE_DEV", 4, ((StringBuilder)localObject).toString());
    this.k.setRotation(f1);
    localObject = this.k;
    f1 = this.n.a;
    paramFloat1 = paramFloat2 * paramFloat1;
    ((NativeReadInjoyImageView)localObject).setScaleX(f1 + paramFloat1);
    this.k.setScaleY(this.n.a + paramFloat1);
    this.k.setLayoutParams(paramLayoutParams);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("img_start_position");
    String str = paramJSONObject.optString("img_end_position");
    int i1 = paramJSONObject.optInt("img_start_size", 100);
    int i2 = paramJSONObject.optInt("img_end_size", 100);
    int i3 = paramJSONObject.optInt("img_start_angle", 0);
    int i4 = paramJSONObject.optInt("img_end_angle", 360);
    paramJSONObject = new int[2];
    JSONObject tmp65_64 = paramJSONObject;
    tmp65_64[0] = 0;
    JSONObject tmp69_65 = tmp65_64;
    tmp69_65[1] = 0;
    tmp69_65;
    a(paramJSONObject, (String)localObject);
    int i5 = paramJSONObject[0];
    int i6 = paramJSONObject[1];
    a(paramJSONObject, str);
    int i7 = paramJSONObject[0];
    int i8 = paramJSONObject[1];
    paramJSONObject = new ReadInJoyAdBrandOptimizationView.BrandGoodsInfo();
    paramJSONObject.a = (i1 / 100.0F);
    paramJSONObject.b = i3;
    paramJSONObject.c = AIOUtils.b(i5 / 2, this.b.getResources());
    paramJSONObject.d = AIOUtils.b(i6 / 2, this.b.getResources());
    localObject = new ReadInJoyAdBrandOptimizationView.BrandGoodsInfo();
    ((ReadInJoyAdBrandOptimizationView.BrandGoodsInfo)localObject).a = (i2 / 100.0F);
    ((ReadInJoyAdBrandOptimizationView.BrandGoodsInfo)localObject).b = i4;
    ((ReadInJoyAdBrandOptimizationView.BrandGoodsInfo)localObject).c = AIOUtils.b(i7 / 2, this.b.getResources());
    ((ReadInJoyAdBrandOptimizationView.BrandGoodsInfo)localObject).d = AIOUtils.b(i8 / 2, this.b.getResources());
    this.n = paramJSONObject;
    this.o = ((ReadInJoyAdBrandOptimizationView.BrandGoodsInfo)localObject);
  }
  
  private void a(int[] paramArrayOfInt, String paramString)
  {
    if (paramString.contains(","))
    {
      paramString = paramString.split(",");
      if (paramString.length < 2) {}
    }
    try
    {
      paramArrayOfInt[0] = Integer.parseInt(paramString[0]);
      paramArrayOfInt[1] = Integer.parseInt(paramString[1]);
      return;
    }
    catch (Exception paramArrayOfInt) {}
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.n != null) && (this.o != null))
    {
      if (this.N) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
      int i1 = localLayoutParams2.leftMargin;
      int i2 = localLayoutParams2.topMargin;
      int i3 = a(this.E, this.o.c, this.z);
      int i4 = a(this.D, this.o.d, this.A);
      i3 -= i1;
      i4 -= i2;
      int i5 = -this.o.b + this.n.b;
      float f1 = this.o.a - this.n.a;
      if (paramBoolean)
      {
        a(localLayoutParams2, 1.0F, i1, i2, i3, i4, i5, f1);
        a(localLayoutParams1, 1.0F, this.y);
        a(this.r, 1.0F, 0.2F, 1.7F, AIOUtils.b(34.0F, this.b.getResources()));
        a(this.s, 1.0F, 0.2F, 2.0F, AIOUtils.b(34.0F, this.b.getResources()));
        a(this.t, 1.0F, 0.2F, 2.0F, AIOUtils.b(34.0F, this.b.getResources()));
        return;
      }
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.addUpdateListener(new ReadInJoyAdBrandOptimizationView.2(this, localLayoutParams2, i1, i2, i3, i4, i5, f1, localLayoutParams1));
      localValueAnimator.addListener(new ReadInJoyAdBrandOptimizationView.3(this));
      localValueAnimator.setDuration(412L);
      localValueAnimator.start();
    }
  }
  
  private void c()
  {
    this.y = AIOUtils.b(84.0F, this.b.getResources());
    this.A = AIOUtils.b(60.0F, this.b.getResources());
    this.z = AIOUtils.b(60.0F, this.b.getResources());
    this.w = AIOUtils.b(52.0F, this.b.getResources());
    this.x = AIOUtils.b(135.0F, this.b.getResources());
  }
  
  private void d()
  {
    this.F.setVisibility(0);
    this.G.setVisibility(0);
    this.H.setVisibility(0);
    this.I.setVisibility(0);
    this.J.setVisibility(0);
    this.K.setVisibility(0);
    this.L.setVisibility(0);
    this.M.setVisibility(0);
  }
  
  private void e()
  {
    this.j.getLayoutParams().height = AIOUtils.b(128.0F, this.b.getResources());
    this.x = AIOUtils.b(128.0F, this.b.getResources());
    this.t.setTextColor(Color.parseColor("#40A0FF"));
    int i1 = AIOUtils.b(4.0F, this.b.getResources());
    this.l.setCorner(i1, i1, i1, i1);
  }
  
  private void f()
  {
    this.p = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    localLayoutParams.leftMargin = a(this.C, this.n.c, this.z);
    localLayoutParams.topMargin = a(this.B, this.n.d, this.A);
    this.k.setLayoutParams(localLayoutParams);
    this.k.setRotation(this.n.b);
    this.k.setScaleX(this.n.a);
    this.k.setScaleY(this.n.a);
    this.m.setVisibility(8);
    ((RelativeLayout.LayoutParams)this.m.getLayoutParams()).height = 0;
  }
  
  protected void a()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((AdvertisementInfo)localObject1).mAdImgList != null))
    {
      if (this.d.mAdImgList.size() < 3) {
        return;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = AIOUtils.b(28.0F, this.c.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = AIOUtils.b(28.0F, this.c.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "brand_user_icon";
      Object localObject2 = URLDrawable.getDrawable(this.d.mAdCorporateLogo, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight, AIOUtils.b(25.0F, this.c.getResources())));
      ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.j);
      this.f.setImageDrawable((Drawable)localObject2);
      this.u.setText(this.d.mSubscribeName);
      this.v.setText(this.d.mArticleSubscriptText);
      this.q.setText(this.d.mTitle);
      a(this.g, (String)this.d.mAdImgList.get(0), a);
      a(this.h, (String)this.d.mAdImgList.get(1), a);
      a(this.i, (String)this.d.mAdImgList.get(2), a);
      localObject1 = this.d.mAdExtInfo;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BrandOptimizationView", 2, "brand extJson is empty ");
        }
        return;
      }
      localObject2 = null;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
      }
      catch (JSONException localJSONException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("BrandOptimizationView", 2, localJSONException.getMessage());
          localObject1 = localObject2;
        }
      }
      if (localObject1 == null) {
        return;
      }
      localObject2 = ((JSONObject)localObject1).optString("goods_small_img");
      String str1 = ((JSONObject)localObject1).optString("goods_bottom_img");
      String str2 = ((JSONObject)localObject1).optString("goods_price");
      String str3 = ((JSONObject)localObject1).optString("goods_title");
      a(this.k, (String)localObject2, a);
      a(this.l, str1, a);
      a((JSONObject)localObject1);
      this.t.setText(this.d.mAdBtnTxt);
      this.r.setText(str3);
      this.s.setText(str2);
      this.d.isShowBrandAnimate = false;
      if (this.p) {
        f();
      }
    }
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadImage: path is ");
      localStringBuilder.append(paramString);
      QLog.d("BrandOptimizationView", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (!paramString.equals("-1"))) {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount")))
      {
        paramString = ImageCommon.getDrawableResourceId(paramString);
        if (paramString == null) {
          break label147;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BrandOptimizationView", 2, "loadImage: cant find in offline dir, try to load from resources");
        }
      }
    }
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      label121:
      break label121;
    }
    QLog.d("BrandOptimizationView", 2, "loadImage: cant find in resources dir, do nothing");
    return;
    if (paramDrawable != null) {
      paramNativeReadInjoyImageView.setImagePlaceHolder(paramDrawable);
    }
    paramNativeReadInjoyImageView.setImageSrc(paramString);
    label147:
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.e = paramIReadInJoyModel;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d();
      e();
    }
  }
  
  public void b()
  {
    if (this.d.isShowBrandAnimate) {
      return;
    }
    b(false);
    this.d.isShowBrandAnimate = true;
  }
  
  public int getComMeasuredHeight()
  {
    return this.c.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.c.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.c;
  }
  
  public void onClick(View paramView)
  {
    int i1;
    switch (paramView.getId())
    {
    default: 
      i1 = 0;
      break;
    case 2131449249: 
      i1 = 2;
      break;
    case 2131435573: 
    case 2131435574: 
    case 2131435575: 
      i1 = 5;
      break;
    case 2131434311: 
      i1 = 2003;
      break;
    case 2131434305: 
      i1 = 2002;
      break;
    case 2131434303: 
      i1 = 8;
      break;
    case 2131434302: 
      i1 = 2001;
      break;
    case 2131427750: 
      i1 = 3;
      break;
    case 2131427745: 
      i1 = 1;
      break;
    case 2131427674: 
      i1 = 4;
    }
    paramView = new AdJumpParams();
    if (i1 == 8) {
      paramView.c = true;
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(this.d, i1, null);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport((Activity)this.b, this.d, this.e.u(), this.e.m(), false, ReadInJoyAdSwitchUtil.e(this.d), paramView);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.c.measure(paramInt1, paramInt2);
    if ((!this.p) && (!this.d.isShowBrandAnimate) && (this.n != null) && (this.o != null))
    {
      paramInt1 = this.q.getMeasuredHeight();
      this.B = (this.w + paramInt1 + AIOUtils.b(8.0F, this.b.getResources()));
      this.C = 0;
      this.D = (this.w + paramInt1 + this.x + AIOUtils.b(12.0F, this.b.getResources()));
      this.E = AIOUtils.b(12.0F, this.b.getResources());
      f();
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    a();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.g.setImageSrc(null);
    this.g.setImageSrc(null);
    this.g.setImageSrc(null);
    this.d.isShowBrandAnimate = false;
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1042) {
      return super.setAttribute(paramInt, paramObject);
    }
    if (paramObject != null) {
      try
      {
        if ((paramObject instanceof AdvertisementInfo))
        {
          this.d = ((AdvertisementInfo)paramObject);
          return true;
        }
      }
      catch (Exception paramObject)
      {
        this.d = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute STR_ID_SET_AD_BANNER exception ");
        localStringBuilder.append(paramObject.toString());
        QLog.d("BrandOptimizationView", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView
 * JD-Core Version:    0.7.0.1
 */