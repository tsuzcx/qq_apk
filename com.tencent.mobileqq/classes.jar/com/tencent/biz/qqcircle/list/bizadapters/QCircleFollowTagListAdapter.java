package com.tencent.biz.qqcircle.list.bizadapters;

import alud;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleTopTagEvent;
import com.tencent.biz.qqcircle.events.QCircleTopTagListEvent;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleFollowTagListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleFollowTagListItemView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudRead.StGetFollowTagListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tra;
import tys;
import tyu;
import tyw;
import yii;
import yiw;
import yiy;

public class QCircleFollowTagListAdapter
  extends tys<FeedCloudMeta.StTagInfo, FeedCloudRead.StGetFollowTagListRsp>
  implements yiy
{
  private static final String TAG = "QCircleFollowTagListAdapter";
  private String mUin;
  
  public QCircleFollowTagListAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getDropFrameMonitorTag()
  {
    return "qcircle_follow_tag_list";
  }
  
  public String getEmptyHint()
  {
    return alud.a(2131698323);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTopTagEvent.class);
    return localArrayList;
  }
  
  public QCircleBaseRequest getRequest(yii paramyii)
  {
    if (paramyii.c())
    {
      paramyii = new QCircleFollowTagListRequest(null, this.mUin);
      paramyii.setEnableCache(true);
      return paramyii;
    }
    if (paramyii.d())
    {
      paramyii = new QCircleFollowTagListRequest(null, this.mUin);
      paramyii.setEnableCache(false);
      return paramyii;
    }
    if (paramyii.e()) {
      return new QCircleFollowTagListRequest(this.mLastRspInfo.a(), this.mUin);
    }
    return null;
  }
  
  public String getTitle()
  {
    return alud.a(2131698321);
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public tyw<FeedCloudMeta.StTagInfo> handleResponse(FeedCloudRead.StGetFollowTagListRsp paramStGetFollowTagListRsp)
  {
    boolean bool = true;
    tyw localtyw = new tyw();
    localtyw.a(paramStGetFollowTagListRsp.attachInfo.get());
    localtyw.a(paramStGetFollowTagListRsp.tagInfos.get());
    if (paramStGetFollowTagListRsp.hasNext.get() == 1) {}
    for (;;)
    {
      localtyw.a(bool);
      return localtyw;
      bool = false;
    }
  }
  
  public void initTitleBar(View paramView) {}
  
  public boolean isItemEqual(Object paramObject1, Object paramObject2)
  {
    return ((FeedCloudMeta.StTagInfo)paramObject1).tagName.equals(((FeedCloudMeta.StTagInfo)paramObject2).tagName);
  }
  
  public void loadData(yii paramyii) {}
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    yiw.a().a(this);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mDataList != null) {
      ((tyu)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
    }
    QLog.d("QCircleFollowTagListAdapter", 4, "onBindViewHolder:" + paramInt + "  " + paramViewHolder + "  " + this);
  }
  
  public tyu onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new tyu(new QCircleFollowTagListItemView(getParentFragment().getActivity(), tra.a(this.mExtraTypeInfo.getUserId())));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    yiw.a().b(this);
  }
  
  public void onPrepareParams(Bundle paramBundle)
  {
    QLog.d("QCircleFollowTagListAdapter", 1, "onPrepareParams");
    if ((this.mQCircleInitBean != null) && (this.mQCircleInitBean.getExtraTypeInfo() != null)) {
      this.mUin = this.mQCircleInitBean.getExtraTypeInfo().userId;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleTopTagEvent)) {
      updateFollowTagData(((QCircleTopTagEvent)paramSimpleBaseEvent).stTagInfo, ((QCircleTopTagEvent)paramSimpleBaseEvent).followState);
    }
  }
  
  public void setInitData(ArrayList<FeedCloudMeta.StTagInfo> paramArrayList) {}
  
  public void updateFollowTagData(Object paramObject, int paramInt)
  {
    if ((paramObject == null) || (this.mDataList == null)) {
      return;
    }
    Iterator localIterator = this.mDataList.iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!isItemEqual(localObject, paramObject));
    for (;;)
    {
      if (localObject != null) {
        this.mDataList.remove(localObject);
      }
      if (paramInt == 2)
      {
        this.mDataList.add(0, paramObject);
        paramObject = new ArrayList();
        if (this.mDataList.size() <= 4) {
          break label181;
        }
        paramObject = this.mDataList.subList(0, 4);
      }
      for (;;)
      {
        yiw.a().a(new QCircleTopTagListEvent(paramObject));
        notifyDataSetChanged();
        return;
        if (paramInt != 3) {
          break;
        }
        paramInt = 0;
        while (paramInt < this.mDataList.size())
        {
          if (((FeedCloudMeta.StTagInfo)this.mDataList.get(paramInt)).isTop.get() != 1) {
            break label169;
          }
          paramInt += 1;
        }
        break;
        label169:
        this.mDataList.add(paramInt, paramObject);
        break;
        label181:
        paramObject.addAll(this.mDataList);
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizadapters.QCircleFollowTagListAdapter
 * JD-Core Version:    0.7.0.1
 */