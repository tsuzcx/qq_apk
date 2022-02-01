package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.lang.ref.WeakReference;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

public class QCircleTimeLineFeedItemView$QCircleInnerPicItemViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Object mData;
  private ImageView mIvExtraInfo;
  private SquareImageView mIvFeedPic;
  private FeedCloudMeta.StFeed mParentFeed;
  private int mParentPos;
  private int mPos;
  private WeakReference<QCircleTimeLineFeedItemView> mTimeLineFeedItemViewWeak;
  private TextView mTvExtraInfo;
  
  static {}
  
  public QCircleTimeLineFeedItemView$QCircleInnerPicItemViewHolder(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView, View paramView)
  {
    super(paramView);
    this.mTimeLineFeedItemViewWeak = new WeakReference(paramQCircleTimeLineFeedItemView);
    this.mIvFeedPic = ((SquareImageView)paramView.findViewById(2131436376));
    this.mIvExtraInfo = ((ImageView)paramView.findViewById(2131436365));
    this.mTvExtraInfo = ((TextView)paramView.findViewById(2131448437));
    this.mIvFeedPic.setOnClickListener(this);
    this.mIvExtraInfo.setOnClickListener(this);
    this.mTvExtraInfo.setOnClickListener(this);
  }
  
  private void setFeedImage(FeedCloudMeta.StImage paramStImage)
  {
    if (paramStImage == null) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mIvFeedPic.getContext().getResources().getDrawable(2130845089);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mIvFeedPic.getContext().getResources().getDrawable(2130845199);
    if ((this.itemView.getTag(2131441759) instanceof String)) {
      localObject = (String)this.itemView.getTag(2131441759);
    } else {
      localObject = "";
    }
    this.itemView.setTag(2131441759, paramStImage.picUrl.get());
    if (!((String)localObject).equals(paramStImage.picUrl.get()))
    {
      paramStImage = new Option().setUrl(paramStImage.picUrl.get()).setTargetView(this.mIvFeedPic).setFromPreLoad(false).setPredecode(true).setRequestWidth(QCircleGridFeedItemView.PIC_LOAD_SIZE).setRequestHeight(QCircleGridFeedItemView.PIC_LOAD_SIZE);
      QCircleFeedPicLoader.g().loadImage(paramStImage, new QCircleTimeLineFeedItemView.QCircleInnerPicItemViewHolder.1(this));
    }
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    return this.mParentFeed;
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this, paramView);
    onClick_aroundBody1$advice(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    paramObject = this.mData;
    if (((paramObject instanceof QCircleTimeLineFeedItemView.QCircleTimeFlowFeedImageBean)) && (this.mIvFeedPic != null) && (this.mTvExtraInfo != null))
    {
      if (this.mIvExtraInfo == null) {
        return;
      }
      paramObject = (QCircleTimeLineFeedItemView.QCircleTimeFlowFeedImageBean)paramObject;
      Object localObject = paramObject.mImage;
      ViewGroup.LayoutParams localLayoutParams = this.mIvFeedPic.getLayoutParams();
      if (paramObject.mPicSizeType == 1002)
      {
        localLayoutParams.width = (QCircleTimeLineFeedItemView.FEED_PIC_ITEM_SIZE * 2);
        localLayoutParams.height = (QCircleTimeLineFeedItemView.FEED_PIC_ITEM_SIZE * 2);
      }
      else if (paramObject.mPicSizeType == 1001)
      {
        localLayoutParams.width = QCircleTimeLineFeedItemView.FEED_PIC_ITEM_SIZE;
        localLayoutParams.height = QCircleTimeLineFeedItemView.FEED_PIC_ITEM_SIZE;
      }
      this.mIvFeedPic.setLayoutParams(localLayoutParams);
      setFeedImage((FeedCloudMeta.StImage)localObject);
      localObject = this.mTvExtraInfo;
      paramInt = paramObject.mExtraCount;
      int i = 0;
      if (paramInt > 0) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      ((TextView)localObject).setVisibility(paramInt);
      this.mTvExtraInfo.setText(String.valueOf(paramObject.mExtraCount));
      localObject = this.mIvExtraInfo;
      if (paramObject.mType == 3) {
        paramInt = i;
      } else {
        paramInt = 8;
      }
      ((ImageView)localObject).setVisibility(paramInt);
    }
  }
  
  public void setParentData(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mParentFeed = paramStFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.QCircleInnerPicItemViewHolder
 * JD-Core Version:    0.7.0.1
 */