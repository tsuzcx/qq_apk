package com.tencent.biz.qqcircle.fragments.person;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginInnerConstant;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailPushViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public class QCirclePersonalPushFragment
  extends QCirclePersonalBaseBottomFragment
  implements SimpleEventReceiver
{
  protected QCirclePersonalDetailPushViewModel h;
  
  private void H()
  {
    VideoReport.setElementId(this.D, "em_xsj_profile_push_tab");
  }
  
  public boolean E()
  {
    return false;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    D().p().a("personal_page_show_publish_guide", Boolean.valueOf(false));
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public String b()
  {
    return "QCirclePersonalPushFragment";
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
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      paramSimpleBaseEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      int i = paramSimpleBaseEvent.mState;
      if ((i != 3) && (i != 7)) {
        return;
      }
      paramSimpleBaseEvent = paramSimpleBaseEvent.mTargetId;
      if (TextUtils.isEmpty(paramSimpleBaseEvent)) {
        return;
      }
      if (this.e != null)
      {
        ArrayList localArrayList = this.e.getDataList();
        if (localArrayList != null)
        {
          int k = -1;
          i = 0;
          int m = localArrayList.size();
          int j;
          for (;;)
          {
            j = k;
            if (i >= m) {
              break;
            }
            if (paramSimpleBaseEvent.equals(((FeedBlockData)localArrayList.get(i)).b().id.get()))
            {
              j = i;
              break;
            }
            i += 1;
          }
          if (j >= 0) {
            try
            {
              this.e.delete(j);
              this.e.notifyItemRemoved(j);
              if (localArrayList.size() < QCirclePluginInnerConstant.b)
              {
                QLog.d("QCirclePersonalPushFragment", 4, "delete load more");
                w();
                return;
              }
            }
            catch (Throwable paramSimpleBaseEvent)
            {
              QLog.e("QCirclePersonalPushFragment", 1, "onReceiveEvent() delete local feed error!", paramSimpleBaseEvent);
            }
          }
        }
      }
    }
  }
  
  protected void u()
  {
    this.g = getString(2131895715);
    Object localObject = new QCirclePersonalBottomStatusView(getActivity());
    ((QCirclePersonalBottomStatusView)localObject).setDescAndActionText(QCircleConfigHelper.F(), QCircleConfigHelper.G(), QCircleConfigHelper.L(), QCircleConfigHelper.M());
    ((QCirclePersonalBottomStatusView)localObject).setReportBean(n());
    this.c.i().setStatusViewInterface((IStatusViewProvider)localObject);
    if ((this.e instanceof QCircleInsFeedAdapter))
    {
      localObject = new QCircleExtraTypeInfo();
      ((QCircleExtraTypeInfo)localObject).pageType = 9;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(9);
      localStringBuilder.append(this.f);
      ((QCircleExtraTypeInfo)localObject).mGlobalViewModelKey = localStringBuilder.toString();
      ((QCircleInsFeedAdapter)this.e).a(2);
      ((QCircleInsFeedAdapter)this.e).a((QCircleExtraTypeInfo)localObject);
    }
    if (D() != null)
    {
      this.h = ((QCirclePersonalDetailPushViewModel)getViewModel(D(), null, QCirclePersonalDetailPushViewModel.class));
      this.h.b().observe(D(), new QCirclePersonalPushFragment.1(this));
      this.d = ((QCirclePersonalDetailViewModel)getViewModel(D(), null, QCirclePersonalDetailViewModel.class));
      this.d.e().observe(D(), new QCirclePersonalPushFragment.2(this));
    }
    H();
  }
  
  protected void w()
  {
    QCirclePersonalDetailPushViewModel localQCirclePersonalDetailPushViewModel = this.h;
    if (localQCirclePersonalDetailPushViewModel != null) {
      localQCirclePersonalDetailPushViewModel.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalPushFragment
 * JD-Core Version:    0.7.0.1
 */