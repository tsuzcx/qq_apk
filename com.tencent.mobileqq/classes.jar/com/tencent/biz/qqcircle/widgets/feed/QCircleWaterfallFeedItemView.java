package com.tencent.biz.qqcircle.widgets.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class QCircleWaterfallFeedItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener, SimpleEventReceiver
{
  private static final int FIRST_LINE_TOP_MARGIN = ViewUtils.a(9.0F);
  private static final int MAX_POI_INFO_WIDTH = ImmersiveUtils.b() / 2 - ViewUtils.a(46.0F);
  private static final String TAG = "QCircleWaterfallFeedItemView";
  private URLImageView mCover;
  private FeedCloudMeta.StFeed mFeed;
  private FrameLayout mFlRecomLayout;
  private LinearLayout mItemLayout;
  private SquareImageView mIvAvatar;
  private URLImageView mIvRecomIcon;
  private ImageView mIvVideoIcon;
  private LinearLayout mLlFuelLayout;
  private LinearLayout mLlRecomLayout;
  private int mPosition;
  private LinearLayout mRlUserLayout;
  private RoundCorneredRelativeLayout mRoundItem;
  private TextView mTvFuelNum;
  private TextView mTvNearbyText;
  private TextView mTvPicCount;
  private TextView mTvRecomText;
  private QCircleAsyncTextView mTvTitle;
  private TextView mTvUser;
  
  static {}
  
  public QCircleWaterfallFeedItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleWaterfallFeedItemView(@NonNull Context paramContext, Integer paramInteger)
  {
    super(paramContext, paramInteger.intValue());
  }
  
  private void adjustFirstLineTopMargin()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mItemLayout.getLayoutParams();
    int i = this.mPosition;
    if ((i != 0) && (i != 1)) {
      localLayoutParams.setMargins(0, 0, 0, 0);
    } else {
      localLayoutParams.setMargins(0, FIRST_LINE_TOP_MARGIN, 0, 0);
    }
    this.mItemLayout.setLayoutParams(localLayoutParams);
  }
  
  private void initOtherUIByViewType()
  {
    if (this.mFeed != null)
    {
      if (!(getData() instanceof FeedBlockData)) {
        return;
      }
      QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = (QQCircleFeedBase.StFeedBusiReqData)((FeedBlockData)getData()).a("DITTO_FEED_BUSI_REQ_DATA");
      FeedCloudMeta.StPushList localStPushList = QCirclePushInfoManager.a().a(this.mFeed.id.get());
      if ((localStPushList != null) && (localStFeedBusiReqData != null))
      {
        localStFeedBusiReqData.pushList.set(localStPushList);
        this.mFeed.busiData.set(ByteStringMicro.copyFrom(localStFeedBusiReqData.toByteArray()));
      }
      if (getViewType() == 0)
      {
        updateFuelLayoutData();
        return;
      }
      if (1 == getViewType())
      {
        this.mLlFuelLayout.setVisibility(8);
        initPoiUI();
        adjustFirstLineTopMargin();
        return;
      }
      if (2 == getViewType())
      {
        updateFuelLayoutData();
        updateRecomUIData();
        adjustFirstLineTopMargin();
      }
    }
  }
  
  private void initPoiUI()
  {
    boolean bool2 = this.mFeed.poiInfo.has();
    int i = 8;
    if (bool2)
    {
      Object localObject = ((FeedCloudMeta.StPoiInfoV2)this.mFeed.poiInfo.get()).distanceText.get();
      boolean bool1 = TextUtils.isEmpty((CharSequence)localObject) ^ true;
      if (bool1) {
        this.mTvNearbyText.setText((CharSequence)localObject);
      }
      localObject = this.mLlRecomLayout;
      if (bool1) {
        i = 0;
      }
      ((LinearLayout)localObject).setVisibility(i);
      return;
    }
    this.mLlRecomLayout.setVisibility(8);
  }
  
  private void launchFolderPage()
  {
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    localQCircleFolderBean.setAssignShowTabType(6);
    localQCircleFolderBean.setFromReportBean(getReportBean().clone());
    Object localObject = this.mFeed;
    if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StFeed)localObject).id.get())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchFolderPage");
      ((StringBuilder)localObject).append(this.mFeed.id.get());
      QLog.d("QCircleWaterfallFeedItemView", 1, ((StringBuilder)localObject).toString());
      localQCircleFolderBean.setFeed(this.mFeed);
    }
    localObject = null;
    if ((getContext() instanceof Activity)) {
      localObject = (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }
    if ((localObject != null) && (((QCircleInitBean)localObject).getSchemeAttrs() != null) && (((QCircleInitBean)localObject).getSchemeAttrs().containsKey("key_scheme")))
    {
      localObject = (String)((QCircleInitBean)localObject).getSchemeAttrs().get("key_scheme");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localQCircleFolderBean.setLastPageScheme((String)localObject);
      }
    }
    QCircleLauncher.a(getContext(), localQCircleFolderBean);
  }
  
  private void reportClickFeedInfo(String paramString)
  {
    Object localObject = this.mFeed;
    if (localObject == null) {
      return;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setToUin(this.mFeed.poster.id.get()).setActionType(97).setSubActionType(2).setIndex(this.mPosition);
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(localDataBuilder.setExt6((String)localObject).setPageId(getPageId())));
  }
  
  private void setUserAvatar(SquareImageView paramSquareImageView, FeedCloudMeta.StUser paramStUser)
  {
    String str = paramStUser.icon.iconUrl.get();
    if (!TextUtils.isEmpty(str))
    {
      QCircleFeedPicLoader.g().loadImage(new Option().setTargetView(paramSquareImageView).setUrl(str), null);
      return;
    }
    paramSquareImageView.setImageDrawable(HostFaceUtils.getFaceDrawable(1, 4, paramStUser.id.get()));
  }
  
  private void updateFeed(int paramInt1, int paramInt2, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    Object localObject = this.mFeed;
    if (localObject != null)
    {
      if (((FeedCloudMeta.StFeed)localObject).likeInfo == null) {
        return;
      }
      this.mFeed.likeInfo.count.set(paramInt2);
      new QQCircleFeedBase.StLikeBusiData();
      try
      {
        localObject = new QQCircleFeedBase.StLikeBusiData();
        ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(this.mFeed.likeInfo.busiData.get().toByteArray());
        if (paramInt1 == 0)
        {
          paramStPolyLike = new ArrayList();
          Iterator localIterator = ((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.get().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((TextUtils.equals(str, "206008")) || (TextUtils.equals(str, "205993"))) {
              paramStPolyLike.add(str);
            }
          }
          ((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.set(paramStPolyLike);
        }
        else
        {
          if (((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.get().contains(paramStPolyLike.polyLikeID.get())) {
            return;
          }
          ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo.set(paramStPolyLike);
          ((QQCircleFeedBase.StLikeBusiData)localObject).likeIDs.add(paramStPolyLike.polyLikeID.get());
        }
        this.mFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StLikeBusiData)localObject).toByteArray()));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramStPolyLike)
      {
        paramStPolyLike.printStackTrace();
      }
    }
  }
  
  private void updateFeedCover()
  {
    if (this.mFeed == null) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(QCircleSkinHelper.getInstance().getColor(2131167066));
    localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130845199);
    Object localObject1 = measureCoverWidthAndHeight(this.mFeed);
    Object localObject2 = this.mFeed;
    localObject2 = QCirclePreLoadPicUtil.a((FeedCloudMeta.StFeed)localObject2, ((FeedCloudMeta.StFeed)localObject2).cover.width.get(), this.mFeed.cover.height.get());
    if ((((Integer)((Pair)localObject1).first).intValue() != 0) && (((Integer)((Pair)localObject1).second).intValue() != 0) && (((Integer)((Pair)localObject2).first).intValue() != 0) && (((Integer)((Pair)localObject2).second).intValue() != 0))
    {
      Object localObject3 = this.mCover.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = ((Integer)((Pair)localObject1).first).intValue();
      ((ViewGroup.LayoutParams)localObject3).height = ((Integer)((Pair)localObject1).second).intValue();
      this.mCover.requestLayout();
      localURLDrawableOptions.mRequestWidth = ((Integer)((Pair)localObject2).first).intValue();
      localURLDrawableOptions.mRequestHeight = ((Integer)((Pair)localObject2).second).intValue();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mCover  measureCoverWidthAndHeight  params.width : ");
      ((StringBuilder)localObject3).append(((Pair)localObject1).first);
      ((StringBuilder)localObject3).append(" , params.height : ");
      ((StringBuilder)localObject3).append(((Pair)localObject1).second);
      ((StringBuilder)localObject3).append(" , requestResult.width:");
      ((StringBuilder)localObject3).append(((Pair)localObject2).first);
      ((StringBuilder)localObject3).append(" , requestResult.height:");
      ((StringBuilder)localObject3).append(((Pair)localObject2).second);
      QLog.i("QCircleWaterfallFeedItemView", 1, ((StringBuilder)localObject3).toString());
    }
    else if (this.mCover.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = this.mCover.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = this.mCover.getLayoutParams().height;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mCover width : ");
      ((StringBuilder)localObject1).append(this.mCover.getLayoutParams().width);
      ((StringBuilder)localObject1).append(" , height : ");
      ((StringBuilder)localObject1).append(this.mCover.getLayoutParams().height);
      QLog.i("QCircleWaterfallFeedItemView", 1, ((StringBuilder)localObject1).toString());
    }
    if ((this.mCover.getTag(2131449068) instanceof String)) {
      localObject1 = (String)this.mCover.getTag(2131449068);
    } else {
      localObject1 = "";
    }
    this.mCover.setTag(2131449068, this.mFeed.cover.picUrl.get());
    if (!((String)localObject1).equals(this.mFeed.cover.picUrl.get()))
    {
      localObject1 = new Option().setUrl(this.mFeed.cover.picUrl.get()).setTargetView(this.mCover).setFromPreLoad(false).setPredecode(true).setRequestWidth(localURLDrawableOptions.mRequestWidth).setRequestHeight(localURLDrawableOptions.mRequestHeight).setLoadingDrawable(localURLDrawableOptions.mLoadingDrawable).setFailDrawable(localURLDrawableOptions.mFailedDrawable);
      QCircleFeedPicLoader.g().loadImage((Option)localObject1, new QCircleWaterfallFeedItemView.4(this));
    }
  }
  
  private void updateFuelLayoutData()
  {
    Object localObject = this.mFlRecomLayout;
    int i = 8;
    ((FrameLayout)localObject).setVisibility(8);
    this.mLlRecomLayout.setVisibility(8);
    localObject = new QQCircleFeedBase.StFeedBusiReqData();
    for (;;)
    {
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(this.mFeed.busiData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList.has())
        {
          long l = ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList.totalClickCount.get();
          this.mTvFuelNum.setText(QCirclePluginUtil.d(l));
          localObject = this.mLlFuelLayout;
          if (l > 0L) {
            break label118;
          }
          ((LinearLayout)localObject).setVisibility(i);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label118:
      i = 0;
    }
  }
  
  private void updateRecomUIData()
  {
    this.mFlRecomLayout.setVisibility(8);
    Object localObject = this.mFeed;
    if (localObject != null)
    {
      if (!((FeedCloudMeta.StFeed)localObject).recomInfo.has()) {
        return;
      }
      if (!TextUtils.isEmpty(this.mFeed.recomInfo.recomReason.get()))
      {
        if (TextUtils.isEmpty(this.mFeed.recomInfo.iconUrl.get())) {
          return;
        }
        this.mTvRecomText.setText(this.mFeed.recomInfo.recomReason.get());
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130848395);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130845199);
        localURLDrawableOptions.mRequestWidth = this.mIvRecomIcon.getLayoutParams().width;
        localURLDrawableOptions.mRequestHeight = this.mIvRecomIcon.getLayoutParams().height;
        if ((this.mIvRecomIcon.getTag(2131436539) instanceof String)) {
          localObject = (String)this.mIvRecomIcon.getTag(2131436539);
        } else {
          localObject = "";
        }
        this.mIvRecomIcon.setTag(2131436539, this.mFeed.recomInfo.iconUrl.get());
        if (!((String)localObject).equals(this.mFeed.recomInfo.iconUrl.get()))
        {
          localObject = new Option().setUrl(this.mFeed.recomInfo.iconUrl.get()).setTargetView(this.mIvRecomIcon).setFromPreLoad(false).setPredecode(true).setRequestWidth(localURLDrawableOptions.mRequestWidth).setRequestHeight(localURLDrawableOptions.mRequestHeight);
          QCircleFeedPicLoader.g().loadImage((Option)localObject, new QCircleWaterfallFeedItemView.3(this));
        }
        this.mFlRecomLayout.setVisibility(0);
      }
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof FeedBlockData)) {
      return;
    }
    this.mPosition = paramInt;
    this.mFeed = ((FeedBlockData)paramObject).b();
    if (this.mFeed.type.get() == 3)
    {
      this.mTvPicCount.setVisibility(8);
      this.mIvVideoIcon.setVisibility(0);
    }
    else if (this.mFeed.type.get() == 2)
    {
      this.mIvVideoIcon.setVisibility(8);
      if (this.mFeed.images.get().size() > 1)
      {
        this.mTvPicCount.setText(String.valueOf(this.mFeed.images.get().size()));
        this.mTvPicCount.setVisibility(0);
      }
      else
      {
        this.mTvPicCount.setVisibility(8);
      }
    }
    updateFeedCover();
    setUserAvatar(this.mIvAvatar, this.mFeed.poster);
    if (!TextUtils.isEmpty(this.mFeed.content.get()))
    {
      this.mTvTitle.setNeedSpecialAreaBold(false);
      this.mTvTitle.setSpecialClickAreaColor(2131167084);
      this.mTvTitle.setOnClickAtTextListener(new QCircleWaterfallFeedItemView.1(this));
      this.mTvTitle.setOnClickHashTagTextListener(new QCircleWaterfallFeedItemView.2(this));
      this.mTvTitle.setText(this.mFeed.content.get());
      this.mTvTitle.setVisibility(0);
    }
    else
    {
      this.mTvTitle.setVisibility(8);
      paramObject = (RelativeLayout.LayoutParams)this.mRlUserLayout.getLayoutParams();
      paramObject.topMargin = ImmersiveUtils.a(10.0F);
      this.mRlUserLayout.setLayoutParams(paramObject);
    }
    this.mTvUser.setText(this.mFeed.poster.nick.get());
    initOtherUIByViewType();
  }
  
  public QCircleLayerBean getDetailInitBean()
  {
    if ((getExtraTypeInfo() != null) && ((getInteractor() instanceof QCircleInteractor)) && (this.mFeed != null))
    {
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      QCircleInitBean localQCircleInitBean = ((QCircleInteractor)getInteractor()).c();
      QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
      if (localQCircleInitBean != null)
      {
        localStFeedListBusiReqData.tagId.set(localQCircleInitBean.getTagInfo().tagId.get());
        localStFeedListBusiReqData.tagName.set(localQCircleInitBean.getTagInfo().tagName.get());
        if (this.mFeed.poiInfo.gps.has()) {
          localStFeedListBusiReqData.gpsInfo.set(this.mFeed.poiInfo.gps.get());
        }
        localStFeedListBusiReqData.simulateInfo.set(localQCircleInitBean.getSimulateData());
        localQCircleLayerBean.setSimulateData(localQCircleInitBean.getSimulateData());
      }
      localQCircleLayerBean.setFeed(this.mFeed);
      if ((this.mFeed.poiInfo.has()) && (getQCircleExtraTypeInfo() != null) && (getQCircleExtraTypeInfo().pageType == 12)) {
        localQCircleLayerBean.setPoiInfo((FeedCloudMeta.StPoiInfoV2)this.mFeed.poiInfo.get());
      }
      localQCircleLayerBean.setDataPosInList(getDataPosInList());
      localQCircleLayerBean.setFeedListBusiReqData(localStFeedListBusiReqData);
      localQCircleLayerBean.setUseLoadingPic(true);
      localQCircleLayerBean.setSourceType(getQCircleExtraTypeInfo().pageType);
      localQCircleLayerBean.setFromReportBean(getReportBean().clone());
      localQCircleLayerBean.setTransInitBean(localQCircleInitBean);
      localQCircleLayerBean.setGlobalViewModelKey(String.valueOf(getQCircleExtraTypeInfo().mGlobalViewModelKey));
      return localQCircleLayerBean;
    }
    return new QCircleLayerBean();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    return localArrayList;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    return this.mFeed;
  }
  
  public int getLayoutId()
  {
    return 2131626983;
  }
  
  protected String getLogTag()
  {
    return "QCircleWaterfallFeedItemView";
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public Pair<Integer, Integer> measureCoverWidthAndHeight(FeedCloudMeta.StFeed paramStFeed)
  {
    Integer localInteger = Integer.valueOf(0);
    if (paramStFeed == null) {
      return new Pair(localInteger, localInteger);
    }
    int i = ImmersiveUtils.b() / 2 - ViewUtils.a(4.0F);
    int j = paramStFeed.type.get();
    float f1 = 1.333333F;
    if (j == 3)
    {
      if (this.mFeed.video.width.get() >= this.mFeed.video.height.get()) {
        f1 = 0.75F;
      }
      return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * f1)));
    }
    if (this.mFeed.type.get() == 2)
    {
      float f2 = paramStFeed.cover.height.get() / paramStFeed.cover.width.get();
      f1 = f2;
      if (f2 > 1.333333F) {
        f1 = 1.333333F;
      }
      return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * f1)));
    }
    return new Pair(localInteger, localInteger);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    QLog.d("QCircleWaterfallFeedItemView", 4, "registerReceiver");
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this, paramView);
    onClick_aroundBody1$advice(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    QLog.d("QCircleWaterfallFeedItemView", 4, "unRegisterReceiver");
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.mItemLayout = ((LinearLayout)paramView.findViewById(2131437478));
    this.mRoundItem = ((RoundCorneredRelativeLayout)paramView.findViewById(2131445175));
    this.mCover = ((URLImageView)paramView.findViewById(2131449068));
    this.mTvPicCount = ((TextView)paramView.findViewById(2131448641));
    this.mIvVideoIcon = ((ImageView)paramView.findViewById(2131436652));
    this.mTvTitle = ((QCircleAsyncTextView)paramView.findViewById(2131448814));
    this.mIvAvatar = ((SquareImageView)paramView.findViewById(2131446047));
    this.mTvUser = ((TextView)paramView.findViewById(2131448851));
    this.mLlFuelLayout = ((LinearLayout)paramView.findViewById(2131437459));
    this.mTvFuelNum = ((TextView)paramView.findViewById(2131448480));
    this.mFlRecomLayout = ((FrameLayout)paramView.findViewById(2131433285));
    this.mLlRecomLayout = ((LinearLayout)paramView.findViewById(2131437505));
    this.mTvRecomText = ((TextView)paramView.findViewById(2131448693));
    this.mTvNearbyText = ((TextView)paramView.findViewById(2131448599));
    this.mIvRecomIcon = ((URLImageView)paramView.findViewById(2131436539));
    this.mRlUserLayout = ((LinearLayout)paramView.findViewById(2131437592));
    this.mIvAvatar.setOnClickListener(this);
    this.mTvUser.setOnClickListener(this);
    this.mRoundItem.setOnClickListener(this);
    this.mTvTitle.setOnClickListener(this);
    int i = ViewUtils.a(8.0F);
    paramContext = this.mRoundItem;
    float f = i;
    paramContext.setRadius(f, f, f, f);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    FeedCloudMeta.StFeed localStFeed = this.mFeed;
    if ((localStFeed != null) && ((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent;
      if (TextUtils.equals(localStFeed.id.get(), paramSimpleBaseEvent.mTargetFeedId)) {
        updateFeed(paramSimpleBaseEvent.mPraisedStatus, paramSimpleBaseEvent.mPraisedNum, paramSimpleBaseEvent.mNewStPolyLike);
      }
    }
    else if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
    {
      updatePushListChange((QCirclePushUpdateEvent)paramSimpleBaseEvent);
    }
  }
  
  public void updatePushListChange(QCirclePushUpdateEvent paramQCirclePushUpdateEvent)
  {
    Object localObject = this.mFeed;
    if ((localObject != null) && (paramQCirclePushUpdateEvent != null))
    {
      if (!TextUtils.equals(((FeedCloudMeta.StFeed)localObject).id.get(), paramQCirclePushUpdateEvent.mTargetFeedId)) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePushUserList feedId");
      ((StringBuilder)localObject).append(paramQCirclePushUpdateEvent.mTargetFeedId);
      ((StringBuilder)localObject).append(" allPushTimes:");
      ((StringBuilder)localObject).append(paramQCirclePushUpdateEvent.mAllPushTimes);
      QLog.d("QCircleWaterfallFeedItemView", 1, ((StringBuilder)localObject).toString());
      paramQCirclePushUpdateEvent = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        paramQCirclePushUpdateEvent.mergeFrom(this.mFeed.busiData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.e("QCircleWaterfallFeedItemView", 1, "[updatePushListChange] error: ", localInvalidProtocolBufferMicroException);
      }
      QCirclePushInfoManager.a().a(this.mFeed.id.get(), paramQCirclePushUpdateEvent.pushList);
      this.mFeed.busiData.set(ByteStringMicro.copyFrom(paramQCirclePushUpdateEvent.toByteArray()));
      if (1 != getViewType()) {
        updateFuelLayoutData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView
 * JD-Core Version:    0.7.0.1
 */