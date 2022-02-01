package com.tencent.biz.qqcircle.fragments.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anni;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.SystemBarCompact;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import uxx;
import uyk;
import vnh;
import vni;
import vrr;
import vrt;
import vtt;
import vuf;
import vup;
import zwp;
import zwr;
import zxi;
import zxj;
import zxl;
import zxu;
import zxz;

public abstract class QCirclePersonalBaseBottomFragment
  extends BasePartFragment
  implements zwr, zxl<QCircleReportBean>
{
  public QCircleFakeAdapter a;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  public String a;
  protected vuf a;
  protected zxi a;
  protected String b;
  
  public int a()
  {
    return 2131560740;
  }
  
  protected QCircleFakeAdapter a()
  {
    uyk localuyk = new uyk(new Bundle());
    localuyk.a(a());
    return localuyk;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean == null) {
      this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = new QCircleReportBean();
    }
    return this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean.setPageId(32).setPageIdStr(a());
  }
  
  public BasePartFragment a()
  {
    if ((getActivity() != null) && ((getActivity() instanceof PublicFragmentActivity)) && (getActivity().getSupportFragmentManager().getFragments() != null) && (getActivity().getSupportFragmentManager().getFragments().size() > 0) && ((getActivity().getSupportFragmentManager().getFragments().get(0) instanceof BasePartFragment))) {
      return (BasePartFragment)getActivity().getSupportFragmentManager().getFragments().get(0);
    }
    return null;
  }
  
  public abstract String a();
  
  public List<zxj> a()
  {
    c();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Zxi = new zxi(2131365145, b(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Zxi);
    return localArrayList;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(paramInt);
      vrr.a().a(new vrt().a("main").b("impression").a(a()).c(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(a());
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getActivity().mSystemBarComp;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.init();
      paramLayoutInflater.setStatusBarVisible(2, 0);
    }
    zwp.a().a(this);
    d();
    a();
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.b();
    f();
    if ((this.jdField_a_of_type_Zxi.a() instanceof QCirclePersonalBottomStatusView))
    {
      ((QCirclePersonalBottomStatusView)this.jdField_a_of_type_Zxi.a()).setUser(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      ((QCirclePersonalBottomStatusView)this.jdField_a_of_type_Zxi.a()).setHostParentFragment(a());
    }
    this.jdField_a_of_type_Zxi.a().setVisibility(8);
    this.jdField_a_of_type_Zxi.a().a().addOnScrollListener(new vnh(this));
  }
  
  public void a(vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    if (paramvup == null)
    {
      QLog.e("BasePartFragment", 1, "handleFeedDataRsp return unexpected data！");
      return;
    }
    boolean bool = paramvup.a();
    int i;
    switch (paramvup.a())
    {
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(true, bool);
      return;
      QLog.e("BasePartFragment", 1, "handleFeedDataRsp() return empty data");
      if ((paramvup.b()) && (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getItemCount() > 0))
      {
        this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        QLog.i("BasePartFragment", 1, "handleFeedDataRsp");
        if ((this.jdField_a_of_type_Zxi != null) && (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null))
        {
          if (!this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a())
          {
            ((QCircleStatusView)this.jdField_a_of_type_Zxi.a().a()).a(this.b);
            this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.clearData();
            this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.notifyDataSetChanged();
            QLog.i("BasePartFragment", 1, "handleFeedDataRsp  StatusView = visible");
            i = 1;
            continue;
          }
          this.jdField_a_of_type_Zxi.a().a().setVisibility(8);
          QLog.i("BasePartFragment", 1, "handleFeedDataRsp  StatusView = gone");
          i = 1;
          continue;
          if (paramvup.a() == null) {}
          for (Object localObject = anni.a(2131718323);; localObject = paramvup.a())
          {
            QLog.e("BasePartFragment", 1, "handleFeedDataRsp() return error！errMsg:" + (String)localObject);
            vtt.a(paramvup.a(), BaseApplicationImpl.getContext(), 1, (String)localObject, 1);
            if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter == null) || (this.jdField_a_of_type_Zxi == null)) {
              break label477;
            }
            if (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getItemCount() > 0) {
              break label349;
            }
            ((QCircleStatusView)this.jdField_a_of_type_Zxi.a().a()).b((String)localObject);
            i = 1;
            break;
          }
          label349:
          this.jdField_a_of_type_Zxi.a().a().setVisibility(8);
          i = 1;
          continue;
          i = 0;
          continue;
          localObject = (ArrayList)paramvup.a();
          if (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null)
          {
            if (this.jdField_a_of_type_Zxi != null)
            {
              this.jdField_a_of_type_Zxi.a().a().setVisibility(8);
              this.jdField_a_of_type_Zxi.a().a().setVisibility(0);
            }
            if (paramvup.b()) {
              this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.addAll((List)localObject);
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getLoadInfo().a(bool);
              i = 1;
              break;
              this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.setDatas((ArrayList)localObject);
              this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.b();
            }
          }
        }
        label477:
        i = 1;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return uxx.a();
  }
  
  protected List<zxu> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter = a();
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(d());
    if (((a() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)a()).a() != null) && (((QCirclePersonalDetailFragment)a()).a().a() != null) && (((QCirclePersonalDetailFragment)a()).a().a().a() != null))
    {
      int j = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(i);
        if ((localView instanceof QCirclePersonalBottomView)) {
          this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.setInteractor(((QCirclePersonalBottomView)localView).a());
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.setOnLoadDataDelegate(new vni(this));
    localArrayList.add(this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter);
    return localArrayList;
  }
  
  public abstract void b();
  
  protected void c()
  {
    if (getActivity() == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getActivity().getIntent();
      } while ((localObject == null) || (!((Intent)localObject).hasExtra("key_bundle_common_init_bean")));
      localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
    } while ((((QCircleInitBean)localObject).getUser() == null) || (TextUtils.isEmpty(((QCircleInitBean)localObject).getUser().id.get())));
    this.jdField_a_of_type_JavaLangString = ((QCircleInitBean)localObject).getUser().id.get();
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = ((QCircleInitBean)localObject).getUser();
  }
  
  public boolean c()
  {
    return false;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Zxi.a().a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Zxi.a().setEnableRefresh(false);
    this.jdField_a_of_type_Zxi.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Zxi.a().setParentFragment(this);
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a();
    }
  }
  
  protected void f()
  {
    try
    {
      if (((a() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)a()).a() != null) && (((QCirclePersonalDetailFragment)a()).a().a() != null) && (((QCirclePersonalDetailFragment)a()).a().a().a() != null))
      {
        int j = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(i);
          if ((localView instanceof QCirclePersonInfoWidget)) {
            ThreadManager.getUIHandler().post(new QCirclePersonalBaseBottomFragment.3(this, localView));
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("BasePartFragment", 0, "adjustEmptyViewHeight()  e.getMessage : " + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof QCircleFeedEvent)) || (!d())) {}
    do
    {
      return;
      if (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 1)
      {
        ThreadManager.getUIHandler().postDelayed(new QCirclePersonalBaseBottomFragment.4(this), 200L);
        return;
      }
    } while ((!uxx.a(this.jdField_a_of_type_JavaLangString)) || (((QCircleFeedEvent)paramSimpleBaseEvent).mState != 3));
    ThreadManager.getUIHandler().postDelayed(new QCirclePersonalBaseBottomFragment.5(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment
 * JD-Core Version:    0.7.0.1
 */