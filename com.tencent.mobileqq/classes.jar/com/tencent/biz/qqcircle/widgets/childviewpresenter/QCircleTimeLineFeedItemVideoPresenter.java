package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

public class QCircleTimeLineFeedItemVideoPresenter
  extends QCircleFeedItemBaseVideoPresenter
  implements View.OnClickListener, SimpleEventReceiver
{
  private static final String TAG = "QCircleTimeLineFeedItemVideoPresenter";
  public FrameLayout mVideoContainer;
  
  static {}
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData instanceof FeedBlockData))
    {
      this.mReportInfo.mDataPosition = this.mPos;
      this.mReportInfo.mFeed = ((FeedBlockData)this.mData).b();
      this.mReportInfo.mPlayScene = 1;
      this.mVideoContainer.getLayoutParams().width = (QCircleTimeLineFeedItemView.FEED_PIC_ITEM_SIZE * 2);
      this.mVideoContainer.getLayoutParams().height = (QCircleTimeLineFeedItemView.FEED_PIC_ITEM_SIZE * 2);
      paramObject = this.mVideoContainer;
      paramObject.setLayoutParams(paramObject.getLayoutParams());
      this.mVideoCoverImg.getLayoutParams().width = (QCircleTimeLineFeedItemView.FEED_PIC_ITEM_SIZE * 2);
      this.mVideoCoverImg.getLayoutParams().height = (QCircleTimeLineFeedItemView.FEED_PIC_ITEM_SIZE * 2);
      this.mVideoCoverImg.setLayoutParams(this.mVideoCoverImg.getLayoutParams());
      this.mVideoCoverImg.setVisibility(0);
      bindCover(((FeedBlockData)this.mData).b());
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedVideoPositionLinkEvent.class);
    return localArrayList;
  }
  
  protected String getLogTag()
  {
    return "QCircleTimeLineFeedItemVideoPresenter";
  }
  
  public void initView(View paramView)
  {
    this.mContainer = LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131449856));
    this.mVideoContainer = ((FrameLayout)this.mContainer.findViewById(2131441653));
    this.mPlayerContainer = ((FrameLayout)this.mContainer.findViewById(2131441642));
    this.mPlayerContainer.setOnClickListener(this);
    this.mVideoCoverImg = ((URLImageView)this.mContainer.findViewById(2131441643));
    this.mVideoCoverImg.setOnClickListener(this);
    this.mPlayIconImg = ((ImageView)this.mContainer.findViewById(2131436365));
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this, paramView);
    onClick_aroundBody1$advice(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedVideoPositionLinkEvent)) && (this.mPlayerHelper != null))
    {
      QCircleFeedPlayerScroller localQCircleFeedPlayerScroller = this.mPlayerHelper;
      paramSimpleBaseEvent = (QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent;
      localQCircleFeedPlayerScroller.a(paramSimpleBaseEvent.mFeedUrl, paramSimpleBaseEvent.mCurrentPlayPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleTimeLineFeedItemVideoPresenter
 * JD-Core Version:    0.7.0.1
 */