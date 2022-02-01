package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.FeedBackClickListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;

public abstract class IUIDelegate
  implements View.OnClickListener
{
  public int a;
  protected Context a;
  protected ViewGroup a;
  public AdvertisementInfo a;
  protected FeedBackClickListener a;
  public AdData a;
  public boolean a;
  public boolean b = false;
  
  public IUIDelegate(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(a(), this.jdField_a_of_type_AndroidViewViewGroup);
    a();
    b();
  }
  
  public abstract int a();
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public abstract void a();
  
  public void a(FeedBackClickListener paramFeedBackClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCallbackFeedBackClickListener = paramFeedBackClickListener;
  }
  
  public void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      i += 1;
    }
  }
  
  public abstract void b();
  
  public void b(AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData = paramAdData;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
  }
  
  public abstract void c();
  
  public void d()
  {
    this.b = true;
  }
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate
 * JD-Core Version:    0.7.0.1
 */