package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.BaseListVH;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
import com.tencent.biz.qqcircle.widgets.QCircleSimpleTextView;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReportHelper.LaunchParam;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QCircleLikeListBlock
  extends QCircleBaseListBlock<FeedCloudMeta.StLightInteractInfo, FeedCloudRead.StGetLightInteractListRsp>
{
  private static final String TAG = "QCircleLikeListBlock";
  public static final int TYPE_CONTENT1 = 3;
  public static final int TYPE_CONTENT2 = 4;
  public static final int TYPE_CONTENT3 = 5;
  public static final int TYPE_TITLE1 = 1;
  public static final int TYPE_TITLE2 = 2;
  private View mBottomLine;
  private int mCount;
  private FeedCloudMeta.StFeed mCurrentFeed = new FeedCloudMeta.StFeed();
  private String mId;
  private int mLightInteractType;
  private long mTime;
  private TextView mTvTitle;
  private TextView mTvUnReadNum;
  
  public QCircleLikeListBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getAttachInfoFromItemData(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
  {
    return null;
  }
  
  public String getAttachInfoFromRsp(FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    return paramStGetLightInteractListRsp.attachInfo.get();
  }
  
  public List<Part> getCustomParts()
  {
    return null;
  }
  
  public String getDropFrameMonitorTag()
  {
    return QCircleHostDropFrameMonitorHelper._Constants.QCIRLE_LIKE_LIST_PAGE();
  }
  
  public String getEmptyHint()
  {
    return HardCodeUtil.a(2131895792);
  }
  
  public boolean getIsFinishFromRsp(FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    return paramStGetLightInteractListRsp.isFinish.get() == 1;
  }
  
  public int getItemCount()
  {
    if (this.mCount == 0) {
      return this.mDataList.size();
    }
    if (this.mDataList.size() > this.mCount) {
      return this.mDataList.size() + 2;
    }
    return this.mDataList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = this.mCount;
    if (i == 0) {
      return 3;
    }
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt < i + 1) {
      return 4;
    }
    if (paramInt == i + 1) {
      return 2;
    }
    return 5;
  }
  
  public void getListDataAsync(IDataCallBack<FeedCloudMeta.StLightInteractInfo> paramIDataCallBack, String paramString) {}
  
  public List<FeedCloudMeta.StLightInteractInfo> getListDataFromRsp(FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    return paramStGetLightInteractListRsp.listInfo.get();
  }
  
  public String getLogTag()
  {
    return "QCircleLikeListBlock";
  }
  
  public int getPageCount()
  {
    return 0;
  }
  
  public BaseRequest getRequest(String paramString)
  {
    return new QCircleGetLightInteractRequest(this.mCurrentFeed, paramString, this.mLightInteractType, this.mId, this.mTime, 2);
  }
  
  public String getTitle()
  {
    return HardCodeUtil.a(2131895774);
  }
  
  public View getTitleTabView(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626884, paramViewGroup, false);
    this.mTvTitle = ((TextView)paramViewGroup.findViewById(2131448792));
    this.mBottomLine = paramViewGroup.findViewById(2131449321);
    this.mTvUnReadNum = ((TextView)paramViewGroup.findViewById(2131448696));
    this.mTvTitle.setText(getTitle());
    this.mBottomLine.setVisibility(8);
    this.mTvUnReadNum.setVisibility(8);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  protected void handleResponse(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    super.handleResponse(paramBoolean1, paramBoolean2, paramLong, paramString1, paramString2, paramStGetLightInteractListRsp);
  }
  
  public void initTitleBar(View paramView)
  {
    if (paramView != null)
    {
      this.mTvTitle = ((TextView)paramView.findViewById(2131448814));
      paramView = this.mTvTitle;
      if (paramView != null) {
        paramView.setTypeface(Typeface.DEFAULT_BOLD);
      }
    }
  }
  
  public void loadData(LoadInfo paramLoadInfo)
  {
    super.loadData(paramLoadInfo);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (QCircleReportHelper.getInstance().isPageStackEmpty())
    {
      paramActivity = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      QCircleReportHelper.getInstance().setLaunchParms(QCircleReportHelper.LaunchParam.wrap(paramActivity.getLaunchFrom(), paramActivity.getLaunchId(), paramActivity.getUin(), getPageId(), paramActivity.getSchemeAttrs()));
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(17).setSubActionType(13).setThrActionType(1));
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    paramActivity = QCircleReportHelper.getInstance();
    int i = getPageId();
    boolean bool;
    if ((getHostFragment() != null) && (getHostFragment().g())) {
      bool = true;
    } else {
      bool = false;
    }
    paramActivity.recordPageEndShow(i, bool);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    QCircleReportHelper.getInstance().recordPageStartShow(59);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(17).setSubActionType(1));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    try
    {
      int i = getItemViewType(paramInt);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                ((QCircleBaseLightInteractWidget)paramViewHolder.itemView).a(this.mCurrentFeed, new QCircleExtraTypeInfo(), 0);
                if (this.mDataList != null) {
                  ((BaseListBlock.BaseListVH)paramViewHolder).a(this.mDataList.get(paramInt - 2), paramInt, this.mExtraTypeInfo);
                }
              }
            }
            else
            {
              ((QCircleBaseLightInteractWidget)paramViewHolder.itemView).a(this.mCurrentFeed, new QCircleExtraTypeInfo(), 0);
              if (this.mDataList != null) {
                ((BaseListBlock.BaseListVH)paramViewHolder).a(this.mDataList.get(paramInt - 1), paramInt, this.mExtraTypeInfo);
              }
            }
          }
          else
          {
            ((QCircleBaseLightInteractWidget)paramViewHolder.itemView).a(this.mCurrentFeed, new QCircleExtraTypeInfo(), 0);
            if (this.mDataList != null) {
              ((BaseListBlock.BaseListVH)paramViewHolder).a(this.mDataList.get(paramInt), paramInt, this.mExtraTypeInfo);
            }
          }
        }
        else {
          ((BaseListBlock.BaseListVH)paramViewHolder).a(HardCodeUtil.a(2131895775), paramInt, this.mExtraTypeInfo);
        }
      }
      else
      {
        localObject = (BaseListBlock.BaseListVH)paramViewHolder;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mCount);
        localStringBuilder.append(HardCodeUtil.a(2131895776));
        ((BaseListBlock.BaseListVH)localObject).a(localStringBuilder.toString(), paramInt, this.mExtraTypeInfo);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBindViewHolder:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramViewHolder);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this);
      QLog.d("QCircleLikeListBlock", 4, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramViewHolder)
    {
      QLog.e("QCircleLikeListBlock", 1, "onBindViewHolder error", paramViewHolder);
    }
  }
  
  public BaseListBlock.BaseListVH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramViewGroup = new QCircleLightInteractPolyLikeWidget(getContext(), paramInt);
      paramViewGroup.setReportBeanAgent(this);
      return new BaseListBlock.BaseListVH(paramViewGroup);
    }
    return new BaseListBlock.BaseListVH(new QCircleSimpleTextView(getContext()));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    QLog.d("QCircleLikeListBlock", 1, "onPrepareParams");
    super.onInitBlock(paramBundle);
    getBlockMerger().b("");
  }
  
  public void onTitleTabSelectedChanged(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = this.mBottomLine;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      paramView.setVisibility(i);
      Object localObject = this.mTvTitle;
      if (paramBoolean) {
        paramView = Typeface.DEFAULT_BOLD;
      } else {
        paramView = Typeface.DEFAULT;
      }
      ((TextView)localObject).setTypeface(paramView);
      paramView = this.mTvTitle;
      localObject = QCircleSkinHelper.getInstance();
      if (paramBoolean) {
        i = 2131167084;
      } else {
        i = 2131167085;
      }
      paramView.setTextColor(((QCircleSkinHelper)localObject).getColor(i));
    }
  }
  
  public void setInitBean(Serializable paramSerializable)
  {
    super.setInitBean(paramSerializable);
    try
    {
      if ((this.mInitBean instanceof QCircleLikeBean))
      {
        paramSerializable = (QCircleLikeBean)this.mInitBean;
        this.mCurrentFeed = paramSerializable.getFeed();
        this.mId = paramSerializable.getLikeId();
        this.mLightInteractType = paramSerializable.getRequestType();
        this.mCount = paramSerializable.getCount();
        this.mTime = paramSerializable.getTime();
        return;
      }
    }
    catch (Exception paramSerializable)
    {
      QLog.e("QCircleLikeListBlock", 1, paramSerializable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleLikeListBlock
 * JD-Core Version:    0.7.0.1
 */