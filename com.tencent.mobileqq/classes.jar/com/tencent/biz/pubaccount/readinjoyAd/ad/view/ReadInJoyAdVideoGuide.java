package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public class ReadInJoyAdVideoGuide
  extends RelativeLayout
  implements View.OnClickListener
{
  public boolean a = false;
  private RelativeLayout b;
  private LinearLayout c;
  private URLImageView d;
  private TextView e;
  private TextView f;
  private View g;
  private ReadInJoyAdStarBar h;
  private URLImageView i;
  private RelativeLayout j;
  private int k;
  private String l;
  private ReadInJoyAdVideoGuide.AdGuideClickListener m;
  private boolean n = false;
  private String o;
  
  public ReadInJoyAdVideoGuide(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoyAdVideoGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoyAdVideoGuide(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    inflate(paramContext, 2131626119, this);
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    d();
  }
  
  private void d()
  {
    this.b = ((RelativeLayout)findViewById(2131445146));
    this.c = ((LinearLayout)findViewById(2131431280));
    this.d = ((URLImageView)findViewById(2131428619));
    this.e = ((TextView)findViewById(2131428632));
    this.f = ((TextView)findViewById(2131429866));
    this.g = findViewById(2131427737);
    this.h = ((ReadInJoyAdStarBar)findViewById(2131427744));
    this.j = ((RelativeLayout)findViewById(2131428517));
    this.i = ((URLImageView)findViewById(2131428518));
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  private void e()
  {
    Object localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(48.0F, getContext().getResources());
    ((LinearLayout.LayoutParams)localObject).height = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(48.0F, getContext().getResources());
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(4.0F, getContext().getResources());
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(62.0F, getContext().getResources());
    ((LinearLayout.LayoutParams)localObject).height = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(22.0F, getContext().getResources());
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.f.setTextSize(11.0F);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#00CAFC"));
    ((GradientDrawable)localObject).setCornerRadius(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(12.0F, getContext().getResources()));
    this.f.setBackgroundDrawable((Drawable)localObject);
  }
  
  private int getAdState()
  {
    if (this.n) {
      return 4;
    }
    if (this.k != 12) {
      return 1;
    }
    if (!TextUtils.isEmpty(this.l))
    {
      if (PackageUtil.a(getContext(), this.l)) {
        return 3;
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkgExistSyn(((IRIJAdService)QRoute.api(IRIJAdService.class)).getContext(), this.l)) {
        return 5;
      }
      return 2;
    }
    return 0;
  }
  
  private String getBtnText()
  {
    int i1 = getAdState();
    if ((i1 != 0) && (i1 != 1))
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return "";
            }
            return "立即安装";
          }
          return getResources().getText(2131915394).toString();
        }
        return getResources().getText(2131915392).toString();
      }
      return getResources().getText(2131915391).toString();
    }
    return getResources().getText(2131915449).toString();
  }
  
  private void setAppBackground(AdvertisementInfo paramAdvertisementInfo)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSmallVideo(paramAdvertisementInfo))
    {
      this.j.setVisibility(0);
      paramAdvertisementInfo = paramAdvertisementInfo.getVideoCoverUrlWithSmartCut(false);
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo = paramAdvertisementInfo.getFile();
      } else {
        paramAdvertisementInfo = null;
      }
      getResources();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.j.getWidth();
      localURLDrawableOptions.mRequestHeight = this.j.getHeight();
    }
    try
    {
      paramAdvertisementInfo = URLDrawable.getDrawable(new URL(paramAdvertisementInfo), localURLDrawableOptions);
      paramAdvertisementInfo.setDecodeHandler(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).getRoundCornerDecoder());
      this.i.setImageDrawable(paramAdvertisementInfo);
      return;
    }
    catch (MalformedURLException paramAdvertisementInfo) {}
  }
  
  private void setAppGrade(float paramFloat)
  {
    ReadInJoyAdStarBar localReadInJoyAdStarBar = this.h;
    if (localReadInJoyAdStarBar == null) {
      return;
    }
    localReadInJoyAdStarBar.setGrade(Float.valueOf(paramFloat));
    if (paramFloat > 0.0F)
    {
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(8);
  }
  
  private void setAppIcon(String paramString)
  {
    Resources localResources;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((!TextUtils.isEmpty(paramString)) && (this.d != null))
    {
      localResources = getResources();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(60.0F, localResources);
      localURLDrawableOptions.mRequestHeight = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(60.0F, localResources);
    }
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      paramString.setTag(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).builderDecoderParams(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(60.0F, localResources), ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(60.0F, localResources), ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(12.0F, localResources)));
      paramString.setDecodeHandler(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).getRoundCornerDecoder());
      this.d.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  private void setAppName(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.e != null))
    {
      Object localObject = paramString;
      if (paramString.length() > 12)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, 11));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.e.setText((CharSequence)localObject);
    }
  }
  
  private void setAppPkgName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.l = paramString;
      c();
    }
  }
  
  public void a()
  {
    this.g.setVisibility(8);
    Object localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).width = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(130.0F, getContext().getResources());
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setGradientType(0);
    int i1 = Color.parseColor("#00242424");
    int i2 = Color.parseColor("#B2242424");
    if (Build.VERSION.SDK_INT >= 16)
    {
      ((GradientDrawable)localObject).setColors(new int[] { i1, i2 });
      ((GradientDrawable)localObject).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
      this.c.setBackground((Drawable)localObject);
      this.b.setBackground(null);
      return;
    }
    this.c.setBackgroundColor(Color.parseColor("#B2242424"));
    this.b.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public void b()
  {
    this.g.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.addRule(11, 0);
    this.c.setLayoutParams(localLayoutParams);
    if (Build.VERSION.SDK_INT >= 16) {
      this.c.setBackground(null);
    } else {
      this.c.setBackgroundColor(Color.parseColor("#00000000"));
    }
    this.b.setBackgroundColor(Color.parseColor("#80000000"));
  }
  
  public void c()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ReadInJoyAdVideoGuide.1(this));
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131428619)
    {
      if (this.a) {
        i1 = 23;
      } else {
        i1 = 15;
      }
    }
    else if (i1 == 2131428632)
    {
      if (this.a) {
        i1 = 24;
      } else {
        i1 = 16;
      }
    }
    else if (i1 == 2131429866)
    {
      if (this.a) {
        i1 = 26;
      } else {
        i1 = 17;
      }
    }
    else if (i1 == 2131427737) {
      i1 = 21;
    } else if (i1 == 2131427744)
    {
      if (this.a) {
        i1 = 25;
      } else {
        i1 = 27;
      }
    }
    else {
      i1 = 1000;
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((ReadInJoyAdVideoGuide.AdGuideClickListener)localObject).a(paramView, i1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick:");
      ((StringBuilder)localObject).append(i1);
      QLog.d("ReadInJoyAdVideoGuide", 2, ((StringBuilder)localObject).toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVisibilityChanged:");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyAdVideoGuide", 2, localStringBuilder.toString());
    }
    super.onVisibilityChanged(paramView, paramInt);
    c();
  }
  
  public void setAdGuideClickListener(ReadInJoyAdVideoGuide.AdGuideClickListener paramAdGuideClickListener)
  {
    this.m = paramAdGuideClickListener;
  }
  
  public void setAppInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.k = paramInt;
    setAppIcon(paramString1);
    setAppName(paramString2);
    setAppPkgName(paramString3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("setAppInfo:\n");
      localStringBuilder.append("type:");
      localStringBuilder.append(this.k);
      localStringBuilder.append("\n");
      localStringBuilder.append("icon:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("\n");
      localStringBuilder.append("name:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("\n");
      localStringBuilder.append("pkgname:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("\n");
      QLog.d("ReadInJoyAdVideoGuide", 2, localStringBuilder.toString());
    }
  }
  
  public void setAppInfo(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo)
  {
    this.k = paramInt;
    this.n = paramBoolean;
    setAppIcon(paramString1);
    setAppName(paramString2);
    setAppPkgName(paramString3);
    setAppBackground(paramAdvertisementInfo);
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdExtInfo != null)) {
      try
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        if (paramAdvertisementInfo.has("video_guide")) {
          e();
        }
        setAppGrade((float)paramAdvertisementInfo.optDouble("app_score_num"));
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder("setAppInfo:\n");
      paramAdvertisementInfo.append("type:");
      paramAdvertisementInfo.append(this.k);
      paramAdvertisementInfo.append("\n");
      paramAdvertisementInfo.append("icon:");
      paramAdvertisementInfo.append(paramString1);
      paramAdvertisementInfo.append("\n");
      paramAdvertisementInfo.append("name:");
      paramAdvertisementInfo.append(paramString2);
      paramAdvertisementInfo.append("\n");
      paramAdvertisementInfo.append("pkgname:");
      paramAdvertisementInfo.append(paramString3);
      paramAdvertisementInfo.append("\n");
      paramAdvertisementInfo.append("isAmsSubscribeAd:");
      paramAdvertisementInfo.append(paramBoolean);
      paramAdvertisementInfo.append("\n");
      QLog.d("ReadInJoyAdVideoGuide", 2, paramAdvertisementInfo.toString());
    }
  }
  
  public void setBtnInfo(String paramString)
  {
    this.o = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide
 * JD-Core Version:    0.7.0.1
 */