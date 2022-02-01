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
  public ArrayList<AdExposureChecker> a = new ArrayList();
  public AdExposureChecker.ExposureCallback b = null;
  
  public GdtAdWSVerticalCommonVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131626071, paramInt, paramWSVerticalPageFragment);
  }
  
  public int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return -1;
  }
  
  public IWSItemView<WSVerticalItemData> a(int paramInt)
  {
    return new GdtAdWSVerticalVideoItemView(getContext(), this);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public FrameLayout b()
  {
    if ((this.c instanceof GdtAdWSVerticalVideoItemView))
    {
      AbsWSVideoItemView localAbsWSVideoItemView = (AbsWSVideoItemView)this.c;
      if ((localAbsWSVideoItemView.g() instanceof WSVerticalItemVideoAreaController)) {
        return ((WSVerticalItemVideoAreaController)localAbsWSVideoItemView.g()).l();
      }
    }
    return null;
  }
  
  public void c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AdExposureChecker)((Iterator)localObject).next()).onActivityResume();
      }
    }
    if (this.e != null)
    {
      localObject = ((WSVerticalItemData)this.e).b();
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null))
      {
        GdtAdUtil.b(BaseApplicationImpl.getContext(), ((WSVerticalItemData)this.e).b());
        ((WSVerticalItemData)this.e).e().isGdtAdVidoReport = false;
        this.c.a(this.e);
      }
    }
  }
  
  public void d()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AdExposureChecker)((Iterator)localObject).next()).onActivityPause();
      }
    }
    if (this.e != null)
    {
      localObject = ((WSVerticalItemData)this.e).b();
      if ((((WSVerticalItemData)this.e).e() != null) && (localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null) && (this.f != null) && (this.f.d != null))
      {
        if (((WSVerticalItemData)this.e).e().isGdtAdclicked)
        {
          GdtAdWsVideoReport.a((WSVerticalItemData)this.e, this.f, false, 2);
          ((WSVerticalItemData)this.e).e().isGdtAdclicked = false;
        }
        else
        {
          GdtAdWsVideoReport.a((WSVerticalItemData)this.e, this.f, false, 3);
        }
        ((WSVerticalItemData)this.e).e().isGdtAdVidoReport = true;
        this.f.g = this.f.d.m();
      }
    }
  }
  
  public void e()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)((Iterator)localObject).next();
        localAdExposureChecker.onActivityDestroy();
        localAdExposureChecker.setCallback(null);
      }
      this.a.clear();
      this.b = null;
    }
    if ((this.c instanceof NewGdtAdWSVerticalVideoItemView)) {
      this.c.a();
    }
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalCommonVideoHolder
 * JD-Core Version:    0.7.0.1
 */