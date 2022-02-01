package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.SpecialFollowListResp;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowUserItemView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta.StRelationInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QCircleSpecialFollowListBlock
  extends QCircleBaseListBlock<FeedCloudMeta.StRelationInfo, QCircleSpecialFollowManager.SpecialFollowListResp>
  implements SimpleEventReceiver<SimpleBaseEvent>
{
  private static final String TAG = "QCircleSpecialFollowLis";
  private final QCircleSpecialFollowManager mSpecialFollowMgr = QCircleSpecialFollowManager.a();
  
  public QCircleSpecialFollowListBlock(Bundle paramBundle)
  {
    super(paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected QCircleStatusView createStatusView()
  {
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = new QCircleFullScreenStatusView(getContext());
    localQCircleFullScreenStatusView.setEmptyImageAndText(QCircleSkinHelper.getInstance().getUrl("img_emptystate_relationship"), HardCodeUtil.a(2131895918), QCircleConfigHelper.Q());
    localQCircleFullScreenStatusView.setOnRetryClickListener(new QCircleSpecialFollowListBlock.1(this, localQCircleFullScreenStatusView));
    return localQCircleFullScreenStatusView;
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StRelationInfo paramStRelationInfo)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(QCircleSpecialFollowManager.SpecialFollowListResp paramSpecialFollowListResp)
  {
    return null;
  }
  
  public List<Part> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_SPECIAL_FOLLOW_LIST();
  }
  
  public String getEmptyHint()
  {
    return HardCodeUtil.a(2131895917);
  }
  
  public ArrayList<Class<SimpleBaseEvent>> getEventClass()
  {
    return new ArrayList(Arrays.asList(new Class[] { QCircleSpecialFollowUpdateEvent.class, QCircleSpecialFollowListLoadEvent.class }));
  }
  
  public boolean getIsFinishFromRsp(QCircleSpecialFollowManager.SpecialFollowListResp paramSpecialFollowListResp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getIsFinishFromRsp: ");
    boolean bool;
    if (paramSpecialFollowListResp.b == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.i("QCircleSpecialFollowLis", 4, localStringBuilder.toString());
    return paramSpecialFollowListResp.b == null;
  }
  
  public void getListDataAsync(IDataCallBack<FeedCloudMeta.StRelationInfo> paramIDataCallBack, String paramString) {}
  
  public List<FeedCloudMeta.StRelationInfo> getListDataFromRsp(QCircleSpecialFollowManager.SpecialFollowListResp paramSpecialFollowListResp)
  {
    if (paramSpecialFollowListResp.a == null) {
      return Collections.emptyList();
    }
    return paramSpecialFollowListResp.a;
  }
  
  public String getLogTag()
  {
    return "QCircleSpecialFollowLis";
  }
  
  public int getPageCount()
  {
    return 0;
  }
  
  public BaseRequest getRequest(String paramString)
  {
    return null;
  }
  
  public String getTitle()
  {
    return HardCodeUtil.a(2131895916);
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
  
  public void loadData(LoadInfo paramLoadInfo)
  {
    if (paramLoadInfo.c())
    {
      getBlockContainer().getBlockMerger().b("");
      this.mSpecialFollowMgr.d();
      return;
    }
    if (paramLoadInfo.d())
    {
      this.mSpecialFollowMgr.d();
      return;
    }
    if (paramLoadInfo.e()) {
      this.mSpecialFollowMgr.e();
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    QLog.d("QCircleSpecialFollowLis", 4, "onActivityDestroyed");
    SimpleEventBus.getInstance().unRegisterReceiver(this);
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
    ((BaseListBlock.BaseListVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new BaseListBlock.BaseListVH(new QCircleSpecialFollowUserItemView(getParentFragment().getActivity()));
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    boolean bool2 = paramSimpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent;
    boolean bool1 = false;
    int k = 0;
    if (bool2)
    {
      paramSimpleBaseEvent = (QCircleSpecialFollowUpdateEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.isFollow)
      {
        getBlockContainer().getBlockMerger().t();
        return;
      }
      paramSimpleBaseEvent = paramSimpleBaseEvent.uin;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.mDataList.size()) {
          break;
        }
        if (paramSimpleBaseEvent.equals(((FeedCloudMeta.StRelationInfo)this.mDataList.get(i)).id.get()))
        {
          this.mDataList.remove(i);
          notifyDataSetChanged();
          if (this.mDataList.isEmpty()) {
            showEmptyView();
          }
          j = 1;
          break;
        }
        i += 1;
      }
      if ((j == 0) && (!this.mIsFinish)) {
        getBlockContainer().getBlockMerger().t();
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCircleSpecialFollowListLoadEvent))
    {
      paramSimpleBaseEvent = (QCircleSpecialFollowListLoadEvent)paramSimpleBaseEvent;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveEvent: load ");
      localStringBuilder.append(paramSimpleBaseEvent.isRefresh);
      localStringBuilder.append(" ");
      if (paramSimpleBaseEvent.resp != null) {
        bool1 = true;
      }
      localStringBuilder.append(bool1);
      QLog.i("QCircleSpecialFollowLis", 4, localStringBuilder.toString());
      if (paramSimpleBaseEvent.resp == null)
      {
        handleResponse(false, paramSimpleBaseEvent.isRefresh ^ true, -1L, "", "", null);
        return;
      }
      handleResponse(true, paramSimpleBaseEvent.isRefresh ^ true, 0L, "", "", paramSimpleBaseEvent.resp);
    }
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleSpecialFollowListBlock
 * JD-Core Version:    0.7.0.1
 */