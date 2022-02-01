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
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyAdStarBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar;
  private ReadInJoyAdVideoGuide.AdGuideClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide$AdGuideClickListener;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  
  public ReadInJoyAdVideoGuide(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext);
  }
  
  public ReadInJoyAdVideoGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext);
  }
  
  public ReadInJoyAdVideoGuide(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext);
  }
  
  private int a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return 4;
    }
    if (this.jdField_a_of_type_Int != 12) {
      return 1;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (PackageUtil.a(getContext(), this.jdField_a_of_type_JavaLangString)) {
        return 3;
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkgExistSyn(((IRIJAdService)QRoute.api(IRIJAdService.class)).getContext(), this.jdField_a_of_type_JavaLangString)) {
        return 5;
      }
      return 2;
    }
    return 0;
  }
  
  private String a()
  {
    int i = a();
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return "";
            }
            return "立即安装";
          }
          return getResources().getText(2131717920).toString();
        }
        return getResources().getText(2131717918).toString();
      }
      return getResources().getText(2131717917).toString();
    }
    return getResources().getText(2131717969).toString();
  }
  
  private void a(float paramFloat)
  {
    ReadInJoyAdStarBar localReadInJoyAdStarBar = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar;
    if (localReadInJoyAdStarBar == null) {
      return;
    }
    localReadInJoyAdStarBar.setGrade(Float.valueOf(paramFloat));
    if (paramFloat > 0.0F)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar.setVisibility(8);
  }
  
  private void a(Context paramContext)
  {
    inflate(paramContext, 2131560072, this);
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    d();
  }
  
  private void a(String paramString)
  {
    Resources localResources;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentImageURLImageView != null))
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
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      Object localObject = paramString;
      if (paramString.length() > 12)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, 11));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      c();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376816));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365132));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131362839));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362851));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363912));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362158);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar = ((ReadInJoyAdStarBar)findViewById(2131362164));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  private void e()
  {
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(48.0F, getContext().getResources());
    ((LinearLayout.LayoutParams)localObject).height = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(48.0F, getContext().getResources());
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(4.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(62.0F, getContext().getResources());
    ((LinearLayout.LayoutParams)localObject).height = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(22.0F, getContext().getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(11.0F);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#00CAFC"));
    ((GradientDrawable)localObject).setCornerRadius(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(12.0F, getContext().getResources()));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).width = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(130.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setGradientType(0);
    int i = Color.parseColor("#00242424");
    int j = Color.parseColor("#B2242424");
    if (Build.VERSION.SDK_INT >= 16)
    {
      ((GradientDrawable)localObject).setColors(new int[] { i, j });
      ((GradientDrawable)localObject).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackground((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackground(null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#B2242424"));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.addRule(11, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackground(null);
    } else {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#80000000"));
  }
  
  public void c()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ReadInJoyAdVideoGuide.1(this));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131362839)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = 23;
      } else {
        i = 15;
      }
    }
    else if (i == 2131362851)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = 24;
      } else {
        i = 16;
      }
    }
    else if (i == 2131363912)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = 26;
      } else {
        i = 17;
      }
    }
    else if (i == 2131362158) {
      i = 21;
    } else if (i == 2131362164)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = 25;
      } else {
        i = 27;
      }
    }
    else {
      i = 1000;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide$AdGuideClickListener;
    if (localObject != null) {
      ((ReadInJoyAdVideoGuide.AdGuideClickListener)localObject).a(paramView, i);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick:");
      ((StringBuilder)localObject).append(i);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide$AdGuideClickListener = paramAdGuideClickListener;
  }
  
  public void setAppInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramString1);
    b(paramString2);
    c(paramString3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("setAppInfo:\n");
      localStringBuilder.append("type:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
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
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    a(paramString1);
    b(paramString2);
    c(paramString3);
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdExtInfo != null)) {
      try
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        if (paramAdvertisementInfo.has("video_guide")) {
          e();
        }
        a((float)paramAdvertisementInfo.optDouble("app_score_num"));
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
      paramAdvertisementInfo.append(this.jdField_a_of_type_Int);
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
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide
 * JD-Core Version:    0.7.0.1
 */