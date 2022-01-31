package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CornerTextImageView
  extends ImageBase
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  
  public CornerTextImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext.a());
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramContext);
    paramContext = new FrameLayout.LayoutParams(Utils.b(30.0D), Utils.b(18.0D));
    paramContext.gravity = 85;
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#80000000"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(this.o, this.q, this.p, this.r);
    a(this.e);
    f();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(paramInt1, paramInt2);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramIReadInJoyModel);
    b();
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(new URL(paramString));
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected boolean a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight();
  }
  
  public void b()
  {
    Resources localResources = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a().getResources();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CornerTextImageView", 2, "info is null");
      }
      return;
    }
    int j = localResources.getDisplayMetrics().widthPixels - AIOUtils.a(24.0F, localResources);
    int k = (int)(j * 0.598F);
    float f1 = localResources.getDisplayMetrics().density;
    int i;
    float f2;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a.a.size() > 0)
    {
      i = ((SocializeFeedsInfo.UGCPicInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a.a.get(0)).a;
      int m = ((SocializeFeedsInfo.UGCPicInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a.a.get(0)).b;
      f2 = AIOUtils.a(i / 2, localResources);
      f1 = AIOUtils.a(m / 2, localResources);
      i = ((SocializeFeedsInfo.UGCPicInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a.a.get(0)).c;
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      if ((f2 >= j) || (f1 >= k)) {
        break label402;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if (i == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131428502);
      }
      localLayoutParams.width = ((int)f2);
      localLayoutParams.height = ((int)f1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setPadding(0, 0, 0, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CornerTextImageView", 2, "ugc pic info is null");
      }
      f2 = 115.0F * f1;
      f1 *= 1037.0F;
      i = 0;
      break;
      label402:
      if ((f2 < j) && (f1 > k))
      {
        if (f1 / f2 > 4.0F)
        {
          f1 = k;
          f2 = AIOUtils.a(150.0F, localResources);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131428500);
        }
        else
        {
          f2 *= k / f1;
          f1 = k;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      else if ((f2 > j) && (f1 < k))
      {
        if (f2 / f1 > 4.0F)
        {
          f2 = j;
          f1 = AIOUtils.a(150.0F, localResources);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131428501);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else
        {
          f1 *= j / f2;
          f2 = j;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      else if (f1 / f2 > 4.0F)
      {
        f1 = k;
        f2 = AIOUtils.a(150.0F, localResources);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131428500);
      }
      else if (f2 / f1 > 4.0F)
      {
        f2 = j;
        f1 = AIOUtils.a(150.0F, localResources);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131428501);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        float f3 = j;
        if ((f1 - k) / (f2 - f3) < 0.598F)
        {
          f1 *= j / f2;
          f2 = j;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          f2 *= k / f1;
          f1 = k;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.CornerTextImageView
 * JD-Core Version:    0.7.0.1
 */