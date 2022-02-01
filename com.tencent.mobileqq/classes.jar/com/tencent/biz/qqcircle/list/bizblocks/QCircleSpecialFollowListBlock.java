package com.tencent.biz.qqcircle.list.bizblocks;

import aaak;
import aaam;
import aabe;
import aabj;
import aabu;
import aacv;
import aacw;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import anzj;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowListStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowUserItemView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StRelationInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import vqm;
import vqu;
import vrb;

public class QCircleSpecialFollowListBlock
  extends vqm<FeedCloudMeta.StRelationInfo, vrb>
  implements aaam<SimpleBaseEvent>
{
  private static final String TAG = "QCircleSpecialFollowLis";
  private final vqu mSpecialFollowMgr = vqu.a();
  
  public QCircleSpecialFollowListBlock(Bundle paramBundle)
  {
    super(paramBundle);
    aaak.a().a(this);
  }
  
  public QCircleStatusView createStatusView()
  {
    return new QCircleSpecialFollowListStatusView(getContext());
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StRelationInfo paramStRelationInfo)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(vrb paramvrb)
  {
    return null;
  }
  
  public List<aabe> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_special_follow_list";
  }
  
  public String getEmptyHint()
  {
    return anzj.a(2131697342);
  }
  
  public ArrayList<Class<SimpleBaseEvent>> getEventClass()
  {
    return new ArrayList(Arrays.asList(new Class[] { QCircleSpecialFollowUpdateEvent.class, QCircleSpecialFollowListLoadEvent.class }));
  }
  
  public boolean getIsFinishFromRsp(vrb paramvrb)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("getIsFinishFromRsp: ");
    if (paramvrb.jdField_a_of_type_Vra == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QCircleSpecialFollowLis", 4, bool);
      if (paramvrb.jdField_a_of_type_Vra != null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void getListDataAsync(aacw<FeedCloudMeta.StRelationInfo> paramaacw, String paramString) {}
  
  public List<FeedCloudMeta.StRelationInfo> getListDataFromRsp(vrb paramvrb)
  {
    if (paramvrb.jdField_a_of_type_JavaUtilList == null) {
      return Collections.emptyList();
    }
    return paramvrb.jdField_a_of_type_JavaUtilList;
  }
  
  public String getLogTag()
  {
    return "QCircleSpecialFollowLis";
  }
  
  public int getPageCount()
  {
    return 0;
  }
  
  public String getPageIdStr()
  {
    return "special_follow_list_page";
  }
  
  public VSBaseRequest getRequest(String paramString)
  {
    return null;
  }
  
  public String getTitle()
  {
    return anzj.a(2131697341);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void initTitleBar(View paramView) {}
  
  public void loadData(aabu paramaabu)
  {
    if (paramaabu.c())
    {
      getBlockContainer().a().a("");
      this.mSpecialFollowMgr.b();
    }
    do
    {
      return;
      if (paramaabu.d())
      {
        this.mSpecialFollowMgr.b();
        return;
      }
    } while (!paramaabu.e());
    this.mSpecialFollowMgr.c();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    QLog.d("QCircleSpecialFollowLis", 4, "onActivityDestroyed");
    aaak.a().b(this);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    QLog.d("QCircleSpecialFollowLis", 4, "onActivityPaused");
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    QLog.d("QCircleSpecialFollowLis", 4, "onActivityResumed");
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((aacv)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new aacv(new QCircleSpecialFollowUserItemView(getParentFragment().getActivity()));
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int j = 1;
    if ((paramSimpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleSpecialFollowUpdateEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.isFollow) {
        getBlockContainer().a().g();
      }
    }
    label281:
    for (;;)
    {
      return;
      paramSimpleBaseEvent = paramSimpleBaseEvent.uin;
      int i = 0;
      label39:
      if (i < this.mDataList.size()) {
        if (paramSimpleBaseEvent.equals(((FeedCloudMeta.StRelationInfo)this.mDataList.get(i)).id.get()))
        {
          this.mDataList.remove(i);
          notifyDataSetChanged();
          i = j;
          if (this.mDataList.isEmpty()) {
            showEmptyView();
          }
        }
      }
      for (i = j;; i = 0)
      {
        if ((i != 0) || (this.mIsFinish)) {
          break label281;
        }
        getBlockContainer().a().g();
        return;
        i += 1;
        break label39;
        if (!(paramSimpleBaseEvent instanceof QCircleSpecialFollowListLoadEvent)) {
          break;
        }
        paramSimpleBaseEvent = (QCircleSpecialFollowListLoadEvent)paramSimpleBaseEvent;
        StringBuilder localStringBuilder = new StringBuilder().append("onReceiveEvent: load ").append(paramSimpleBaseEvent.isRefresh).append(" ");
        if (paramSimpleBaseEvent.resp != null)
        {
          bool = true;
          QLog.i("QCircleSpecialFollowLis", 4, bool);
          if (paramSimpleBaseEvent.resp != null) {
            break label245;
          }
          if (paramSimpleBaseEvent.isRefresh) {
            break label239;
          }
        }
        label239:
        for (boolean bool = true;; bool = false)
        {
          handleResponse(false, bool, -1L, "", "", null);
          return;
          bool = false;
          break;
        }
        label245:
        if (!paramSimpleBaseEvent.isRefresh) {}
        for (bool = true;; bool = false)
        {
          handleResponse(true, bool, 0L, "", "", paramSimpleBaseEvent.resp);
          return;
        }
      }
    }
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleSpecialFollowListBlock
 * JD-Core Version:    0.7.0.1
 */