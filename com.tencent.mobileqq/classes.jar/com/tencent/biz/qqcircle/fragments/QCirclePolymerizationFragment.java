package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.adapter.QCircleLbsPolymerizationHeadBlock;
import com.tencent.biz.qqcircle.adapter.QCirclePatSamePolymerizationHeadBlock;
import com.tencent.biz.qqcircle.adapter.QCircleTagPolymerizationHeadBlock;
import com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationBodyPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationClipPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleSplashTransitionPart;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class QCirclePolymerizationFragment
  extends QCircleBaseFragment
{
  private List<Part> c;
  private QCirclePolymerizationBean d;
  private int e;
  private int f = 71;
  private String g;
  private QCirclePublishFeedPart h;
  
  private void u()
  {
    if (getActivity() == null) {
      return;
    }
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean")))
    {
      this.d = ((QCirclePolymerizationBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
      x();
    }
  }
  
  private QCircleBaseSingleViewBlock w()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return null;
    }
    int i = ((QCirclePolymerizationBean)localObject1).getPolymerizationType();
    if (i != 7)
    {
      if (i != 16)
      {
        if (i != 20) {
          localObject1 = null;
        } else {
          localObject1 = new QCirclePatSamePolymerizationHeadBlock(null);
        }
      }
      else {
        localObject1 = new QCircleLbsPolymerizationHeadBlock(null);
      }
    }
    else
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putSerializable("key_block_bundle_bean", this.d);
      localObject1 = new QCircleTagPolymerizationHeadBlock((Bundle)localObject1);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new QCircleTagPolymerizationHeadBlock(null);
    }
    ((QCircleBaseSingleViewBlock)localObject2).a(n());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("generateHeaderBlock  polymerizationType : ");
    ((StringBuilder)localObject1).append(this.d.getPolymerizationType());
    QLog.i("QCirclePolymerizationFragment", 1, ((StringBuilder)localObject1).toString());
    return localObject2;
  }
  
  private void x()
  {
    QCirclePolymerizationBean localQCirclePolymerizationBean = this.d;
    if (localQCirclePolymerizationBean == null) {
      return;
    }
    int i = 0;
    int j = localQCirclePolymerizationBean.getPolymerizationType();
    if (j != 7)
    {
      if (j != 16)
      {
        if (j == 20)
        {
          if (this.d.getSimulateData() != null)
          {
            localQCirclePolymerizationBean = this.d;
            localQCirclePolymerizationBean.setPolymerizationName(localQCirclePolymerizationBean.getSimulateData().simulate_name.get());
          }
          this.e = 9;
          i = 47;
          this.f = 72;
          this.g = "pg_xsj_portfolio_filter";
        }
      }
      else
      {
        if (this.d.getPoiInfo() != null)
        {
          localQCirclePolymerizationBean = this.d;
          localQCirclePolymerizationBean.setPolymerizationName(localQCirclePolymerizationBean.getPoiInfo().name.get());
        }
        i = 48;
        this.f = 73;
        this.g = "pg_xsj_portfolio_poi";
      }
    }
    else
    {
      if (this.d.getTagInfo() != null)
      {
        localQCirclePolymerizationBean = this.d;
        localQCirclePolymerizationBean.setPolymerizationName(localQCirclePolymerizationBean.getTagInfo().tagName.get());
      }
      this.e = 8;
      i = 46;
      this.f = 71;
      this.g = "pg_xsj_portfolio_hashtag";
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(i).setSubActionType(1).setThrActionType(1).setExt1(String.valueOf(this.d.getExt1From())).setExt6(String.valueOf(this.d.getPolymerizationName())).setPageId(a()));
  }
  
  public int a()
  {
    return this.f;
  }
  
  public String b()
  {
    return "QCirclePolymerizationFragment";
  }
  
  protected int c()
  {
    return 2131626908;
  }
  
  protected List<Part> d()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      Object localObject1 = new ArrayList();
      Object localObject2 = w();
      if (localObject2 != null)
      {
        ((QCircleBaseSingleViewBlock)localObject2).a(n());
        ((List)localObject1).add(localObject2);
      }
      localObject2 = new QCircleWaterfallFeedsBlock(new Bundle()).c(0);
      ((QCircleWaterfallFeedsBlock)localObject2).setReportBean(n());
      ((List)localObject1).add(localObject2);
      this.c.add(new QCirclePolymerizationClipPart(this.d));
      localObject1 = new QCirclePolymerizationBodyPart((List)localObject1, 3, 2);
      ((QCirclePolymerizationBodyPart)localObject1).a(this.d);
      ((QCirclePolymerizationBodyPart)localObject1).a(n());
      this.c.add(localObject1);
      localObject1 = new QCircleSharePartV2();
      ((QCircleSharePartV2)localObject1).a(n());
      this.c.add(localObject1);
      localObject1 = this.d;
      if ((localObject1 != null) && (((QCirclePolymerizationBean)localObject1).getPolymerizationType() != 16))
      {
        this.h = new QCirclePublishFeedPart(QCirclePluginGlobalInfo.c());
        this.h.a(n());
        if (this.d.getTagInfo() != null) {
          this.h.a(this.d.getTagInfo());
        }
        this.h.a(this.d);
        this.h.a(this.e);
        this.c.add(this.h);
      }
      localObject1 = new QCircleGoHomeButtonPart();
      this.c.add(localObject1);
      localObject1 = new QCircleSplashTransitionPart();
      ((QCircleSplashTransitionPart)localObject1).a(n());
      this.c.add(localObject1);
    }
    return this.c;
  }
  
  protected String f()
  {
    return this.g;
  }
  
  protected int j()
  {
    return getResources().getColor(2131168376);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
    ((QCirclePolymerizationViewModel)a(QCirclePolymerizationViewModel.class)).d.observe(this, new QCirclePolymerizationFragment.1(this));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    u();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    QCircleReportHelper.getInstance().recordPageEndShow(a(), g());
  }
  
  public void onResume()
  {
    super.onResume();
    QCircleReportHelper.getInstance().recordPageStartShow(a());
  }
  
  public boolean s()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment
 * JD-Core Version:    0.7.0.1
 */