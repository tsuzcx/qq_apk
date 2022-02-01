package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ryu;

public class BannerAdapter
  extends BannerView.BannerViewAdapter<DiscoveryBannerInfo, LinearLayout>
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = BannerAdapter.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ryu jdField_a_of_type_Ryu;
  private int b;
  
  private void a(LinearLayout paramLinearLayout, int paramInt, DiscoveryBannerInfo paramDiscoveryBannerInfo)
  {
    if ((paramDiscoveryBannerInfo == null) || (paramLinearLayout == null)) {}
    do
    {
      Object localObject;
      do
      {
        return;
        paramLinearLayout = (KandianUrlImageView)paramLinearLayout.findViewById(2131365600);
        localObject = paramLinearLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
        ((ViewGroup.LayoutParams)localObject).height = this.b;
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramLinearLayout.setTag(paramDiscoveryBannerInfo);
        paramLinearLayout.setOnClickListener(this);
        try
        {
          localObject = new ColorDrawable(Color.parseColor("#E8E8E7"));
          if (TextUtils.isEmpty(paramDiscoveryBannerInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
          localURLDrawableOptions.mRequestHeight = this.b;
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
          paramLinearLayout.setImageDrawable(URLDrawable.getDrawable(paramDiscoveryBannerInfo.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
          return;
        }
        catch (Exception paramLinearLayout) {}
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "轮播图的url格式有问题, " + paramDiscoveryBannerInfo.toString() + ", " + paramLinearLayout.getMessage());
      return;
      paramLinearLayout.setImageDrawable((Drawable)localObject);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "banner cover url is null, banner info: " + paramDiscoveryBannerInfo.toString());
  }
  
  public LinearLayout a(int paramInt, DiscoveryBannerInfo paramDiscoveryBannerInfo)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560308, null);
    a(localLinearLayout, paramInt, paramDiscoveryBannerInfo);
    return localLinearLayout;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof DiscoveryBannerInfo)) && (this.jdField_a_of_type_Ryu != null)) {
        this.jdField_a_of_type_Ryu.a(paramView, (DiscoveryBannerInfo)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */