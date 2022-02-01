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
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
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
      if (ADBaseAppDownloadManager.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString)) {
        return 5;
      }
      return 2;
    }
    return 0;
  }
  
  private String a()
  {
    switch (a())
    {
    default: 
      return "";
    case 4: 
      return getResources().getText(2131718255).toString();
    case 2: 
      return getResources().getText(2131718252).toString();
    case 3: 
      return getResources().getText(2131718253).toString();
    case 5: 
      return "立即安装";
    }
    return getResources().getText(2131718304).toString();
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar.setGrade(Float.valueOf(paramFloat));
    if (paramFloat > 0.0F)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar.setVisibility(8);
  }
  
  private void a(Context paramContext)
  {
    inflate(paramContext, 2131560185, this);
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
      localURLDrawableOptions.mRequestWidth = AIOUtils.a(60.0F, localResources);
      localURLDrawableOptions.mRequestHeight = AIOUtils.a(60.0F, localResources);
    }
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      paramString.setTag(URLDrawableDecodeHandler.b(AIOUtils.a(60.0F, localResources), AIOUtils.a(60.0F, localResources), AIOUtils.a(12.0F, localResources)));
      paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      String str = paramString;
      if (paramString.length() > 12) {
        str = paramString.substring(0, 11) + "…";
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377364));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365255));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131362887));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362899));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363985));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362129);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdStarBar = ((ReadInJoyAdStarBar)findViewById(2131362135));
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
    ((LinearLayout.LayoutParams)localObject).width = AIOUtils.a(48.0F, getContext().getResources());
    ((LinearLayout.LayoutParams)localObject).height = AIOUtils.a(48.0F, getContext().getResources());
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(4.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = AIOUtils.a(62.0F, getContext().getResources());
    ((LinearLayout.LayoutParams)localObject).height = AIOUtils.a(22.0F, getContext().getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(11.0F);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#00CAFC"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(12.0F, getContext().getResources()));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(130.0F, getContext().getResources());
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
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#80000000"));
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
    }
  }
  
  public void c()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ReadInJoyAdVideoGuide.1(this));
  }
  
  public void onClick(View paramView)
  {
    int i = 1000;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide$AdGuideClickListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide$AdGuideClickListener.a(paramView, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdVideoGuide", 2, "onClick:" + i);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 23;
      }
      else
      {
        i = 15;
        continue;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 24;
        }
        else
        {
          i = 16;
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            i = 26;
          }
          else
          {
            i = 17;
            continue;
            i = 21;
            continue;
            if (this.jdField_a_of_type_Boolean) {
              i = 25;
            } else {
              i = 27;
            }
          }
        }
      }
    }
  }
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdVideoGuide", 2, "onVisibilityChanged:" + paramInt);
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
      localStringBuilder.append("type:").append(this.jdField_a_of_type_Int).append("\n");
      localStringBuilder.append("icon:").append(paramString1).append("\n");
      localStringBuilder.append("name:").append(paramString2).append("\n");
      localStringBuilder.append("pkgname:").append(paramString3).append("\n");
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
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdExtInfo != null)) {}
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
      for (;;)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      paramAdvertisementInfo = new StringBuilder("setAppInfo:\n");
      paramAdvertisementInfo.append("type:").append(this.jdField_a_of_type_Int).append("\n");
      paramAdvertisementInfo.append("icon:").append(paramString1).append("\n");
      paramAdvertisementInfo.append("name:").append(paramString2).append("\n");
      paramAdvertisementInfo.append("pkgname:").append(paramString3).append("\n");
      paramAdvertisementInfo.append("isAmsSubscribeAd:").append(paramBoolean).append("\n");
      QLog.d("ReadInJoyAdVideoGuide", 2, paramAdvertisementInfo.toString());
    }
  }
  
  public void setBtnInfo(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide
 * JD-Core Version:    0.7.0.1
 */