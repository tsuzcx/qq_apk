package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Iterator;

public class GdtAdWSVerticalCommonVideoHolder
  extends WSVerticalVideoHolder
{
  public AdExposureChecker.ExposureCallback a;
  public ArrayList<AdExposureChecker> a;
  
  public GdtAdWSVerticalCommonVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131560028, paramInt, paramWSVerticalPageFragment);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return -1;
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof GdtAdWSVerticalVideoItemView))
    {
      AbsWSVideoItemView localAbsWSVideoItemView = (AbsWSVideoItemView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
      if ((localAbsWSVideoItemView.a() instanceof WSVerticalItemVideoAreaController)) {
        return ((WSVerticalItemVideoAreaController)localAbsWSVideoItemView.a()).a();
      }
    }
    return null;
  }
  
  public IWSItemView<WSVerticalItemData> a(int paramInt)
  {
    return new GdtAdWSVerticalVideoItemView(getContext(), this);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AdExposureChecker)((Iterator)localObject).next()).onActivityResume();
      }
    }
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      localObject = ((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).a();
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null))
      {
        GdtAdUtil.b(BaseApplicationImpl.getContext(), ((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).a());
        ((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).a().isGdtAdVidoReport = false;
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.a(this.jdField_a_of_type_JavaLangObject);
      }
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AdExposureChecker)((Iterator)localObject).next()).onActivityPause();
      }
    }
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      localObject = ((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).a();
      if ((((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).a() != null) && (localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null))
      {
        if (((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).a().isGdtAdclicked)
        {
          GdtAdWsVideoReport.a((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false, 2);
          ((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).a().isGdtAdclicked = false;
        }
        else
        {
          GdtAdWsVideoReport.a((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false, 3);
        }
        ((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).a().isGdtAdVidoReport = true;
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.a();
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)((Iterator)localObject).next();
        localAdExposureChecker.onActivityDestroy();
        localAdExposureChecker.setCallback(null);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof NewGdtAdWSVerticalVideoItemView)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalCommonVideoHolder
 * JD-Core Version:    0.7.0.1
 */