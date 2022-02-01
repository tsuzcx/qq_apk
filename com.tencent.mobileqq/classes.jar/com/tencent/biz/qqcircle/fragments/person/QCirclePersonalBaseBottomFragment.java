package com.tencent.biz.qqcircle.fragments.person;

import aaak;
import aaam;
import aabd;
import aabe;
import aabg;
import aabp;
import aabu;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anzj;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
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
import uzg;
import uzt;
import vpm;
import vpn;
import vud;
import vuf;
import vws;
import vxe;
import vxq;

public abstract class QCirclePersonalBaseBottomFragment
  extends BasePartFragment
  implements aaam, aabg<QCircleReportBean>
{
  protected aabd a;
  public QCircleFakeAdapter a;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  public String a;
  protected vxe a;
  protected String b;
  
  public int a()
  {
    return 2131560763;
  }
  
  protected QCircleFakeAdapter a()
  {
    uzt localuzt = new uzt(new Bundle());
    localuzt.a(a());
    return localuzt;
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
  
  public List<aabe> a()
  {
    c();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Aabd = new aabd(2131365189, b(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Aabd);
    return localArrayList;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(paramInt);
      vud.a().a(new vuf().a("main").b("impression").a(a()).c(this.jdField_a_of_type_JavaLangString));
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
    aaak.a().a(this);
    d();
    a();
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.b();
    f();
    if ((this.jdField_a_of_type_Aabd.a() instanceof QCirclePersonalBottomStatusView))
    {
      ((QCirclePersonalBottomStatusView)this.jdField_a_of_type_Aabd.a()).setUser(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
      ((QCirclePersonalBottomStatusView)this.jdField_a_of_type_Aabd.a()).setHostParentFragment(a());
    }
    this.jdField_a_of_type_Aabd.a().setVisibility(8);
    this.jdField_a_of_type_Aabd.a().a().addOnScrollListener(new vpm(this));
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
    if ((this.jdField_a_of_type_Aabd.a() instanceof QCirclePersonalBottomStatusView)) {
      ((QCirclePersonalBottomStatusView)this.jdField_a_of_type_Aabd.a()).setUser(paramStUser);
    }
  }
  
  public void a(vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    if (paramvxq == null)
    {
      QLog.e("BasePartFragment", 1, "handleFeedDataRsp return unexpected data！");
      return;
    }
    boolean bool = paramvxq.a();
    int i;
    switch (paramvxq.a())
    {
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(true, bool);
      return;
      QLog.e("BasePartFragment", 1, "handleFeedDataRsp() return empty data");
      if ((paramvxq.b()) && (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getItemCount() > 0))
      {
        this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        QLog.i("BasePartFragment", 1, "handleFeedDataRsp");
        if ((this.jdField_a_of_type_Aabd != null) && (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null))
        {
          if (!this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a())
          {
            ((QCircleStatusView)this.jdField_a_of_type_Aabd.a().a()).a(this.b);
            this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.clearData();
            this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.notifyDataSetChanged();
            QLog.i("BasePartFragment", 1, "handleFeedDataRsp  StatusView = visible");
            i = 1;
            continue;
          }
          this.jdField_a_of_type_Aabd.a().a().setVisibility(8);
          QLog.i("BasePartFragment", 1, "handleFeedDataRsp  StatusView = gone");
          i = 1;
          continue;
          if (paramvxq.a() == null) {}
          for (Object localObject = anzj.a(2131718459);; localObject = paramvxq.a())
          {
            QLog.e("BasePartFragment", 1, "handleFeedDataRsp() return error！errMsg:" + (String)localObject);
            vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, (String)localObject, 1);
            if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter == null) || (this.jdField_a_of_type_Aabd == null)) {
              break label527;
            }
            if (paramvxq.a() != 10022L) {
              break label366;
            }
            ((QCircleStatusView)this.jdField_a_of_type_Aabd.a().a()).a(this.b);
            this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.clearData();
            this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.notifyDataSetChanged();
            i = 1;
            break;
          }
          label366:
          if (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getItemCount() <= 0)
          {
            ((QCircleStatusView)this.jdField_a_of_type_Aabd.a().a()).b((String)localObject);
            i = 1;
            continue;
          }
          this.jdField_a_of_type_Aabd.a().a().setVisibility(8);
          i = 1;
          continue;
          i = 0;
          continue;
          localObject = (ArrayList)paramvxq.a();
          if (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null)
          {
            if (this.jdField_a_of_type_Aabd != null)
            {
              this.jdField_a_of_type_Aabd.a().a().setVisibility(8);
              this.jdField_a_of_type_Aabd.a().a().setVisibility(0);
            }
            if (paramvxq.b()) {
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
        label527:
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
    return uzg.a();
  }
  
  protected List<aabp> b()
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
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.setOnLoadDataDelegate(new vpn(this));
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
  
  protected void d()
  {
    this.jdField_a_of_type_Aabd.a().a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Aabd.a().setEnableRefresh(false);
    this.jdField_a_of_type_Aabd.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Aabd.a().setParentFragment(this);
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
  
  public boolean f_()
  {
    return false;
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
    aaak.a().b(this);
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
    } while ((!uzg.a(this.jdField_a_of_type_JavaLangString)) || (((QCircleFeedEvent)paramSimpleBaseEvent).mState != 3));
    ThreadManager.getUIHandler().postDelayed(new QCirclePersonalBaseBottomFragment.5(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBaseBottomFragment
 * JD-Core Version:    0.7.0.1
 */