package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleStickShareEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleTextUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowChangeListener;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleFeedItemHeadPresenter
  extends QCircleBaseFeedChildPresenter
  implements View.OnClickListener, LayoutPreLoader.RequestPreloadViewListener, QCircleFollowView.FollowChangeListener, SimpleEventReceiver
{
  public static final String PREFIX_LOCAL_ID = "Q_CIRCLE_LOCAL_ID";
  private static final String TAG = "QCircleFeedItemHeadPresenter";
  private QCircleAvatarView mAvatarImg;
  private View mBottomWrapper;
  private TextView mDesTxt;
  private ImageView mExplodeCard;
  private QCircleFollowView mFollowImg;
  private RFWDownloader.RFWDownloadListener mImageListener;
  private SquareImageView mIvAuth;
  private ImageView mMoreImg;
  private TextView mNickNameTxt;
  private QCircleFeedItemPicPresenter mPicPresenter;
  private TextView mTimeTxt;
  private QCircleFeedItemVideoPresenter mVideoPresenter;
  
  static {}
  
  private void initMoreImg()
  {
    if (QCircleConfigHelper.ao()) {
      this.mMoreImg.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845397));
    }
  }
  
  private void jumpMainPage()
  {
    if (!(this.mData instanceof FeedBlockData))
    {
      QLog.w("QCircleFeedItemHeadPresenter", 1, "[jumpMainPage] current data not instanceof FeedBlockData.");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
    if (localStFeed.isRecomFd.get())
    {
      launchPersonalDetailPage(localStFeed.recomForward.poster.id.get(), localStFeed);
      return;
    }
    launchPersonalDetailPage(localStFeed.poster.id.get(), localStFeed);
  }
  
  private void jumpNearbyPage()
  {
    if (!(this.mData instanceof FeedBlockData))
    {
      QLog.w("QCircleFeedItemHeadPresenter", 1, "[jumpLbsPage] invalid data");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.gpsInfo = localStFeed.poiInfo.gps;
    localQCirclePolymerizationBean.setFeedListBusiReqData(localStFeedListBusiReqData);
    localQCirclePolymerizationBean.setFromReportBean(getReportBean().clone());
    localQCirclePolymerizationBean.setPolymerizationType(16);
    localQCirclePolymerizationBean.setExt1From(1);
    localQCirclePolymerizationBean.setPoiInfo(localStFeed.poiInfo);
    QCircleLauncher.a(this.mContainer.getContext(), localQCirclePolymerizationBean);
  }
  
  private void launchPersonalDetailPage(String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    if (getParentView() == null) {
      localObject = null;
    } else {
      localObject = getParentView().getQCircleExtraTypeInfo();
    }
    if ((localObject != null) && (((QCircleExtraTypeInfo)localObject).pageType == 8) && (TextUtils.equals(paramString, ((QCircleExtraTypeInfo)localObject).mCurrentPersonalUin)))
    {
      QLog.d("QCircleFeedItemHeadPresenter", 1, "[launchPersonalDetailPage] call to personal detail repeat.");
      return;
    }
    Object localObject = new QCircleInitBean();
    ((QCircleInitBean)localObject).setUin(paramString);
    ((QCircleInitBean)localObject).setFeed(paramStFeed);
    ((QCircleInitBean)localObject).setFromReportBean(getReportBean().clone());
    QCircleLauncher.b(this.mContainer.getContext(), (QCircleInitBean)localObject);
  }
  
  private void reportClick(int paramInt)
  {
    if (this.mReportInfo != null) {
      localObject = this.mReportInfo.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(paramInt).setSubActionType(2);
    if ((this.mReportInfo != null) && (this.mReportInfo.mFeed != null)) {
      localObject = this.mReportInfo.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    if (this.mReportInfo != null) {
      paramInt = this.mReportInfo.mDataPosition;
    } else {
      paramInt = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(paramInt).setPageId(getPageId())));
  }
  
  private void reportUndoPush(QCircleShareInfo paramQCircleShareInfo)
  {
    if (paramQCircleShareInfo == null) {
      return;
    }
    Object localObject = paramQCircleShareInfo.c;
    QCircleLpReportDc05507.DataBuilder localDataBuilder = null;
    if (localObject != null) {
      localObject = paramQCircleShareInfo.c.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder1 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(122).setSubActionType(1).setPageId(getPageId());
    localObject = paramQCircleShareInfo.c;
    String str = "";
    if ((localObject != null) && (paramQCircleShareInfo.c.mFeed != null)) {
      localObject = paramQCircleShareInfo.c.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(localDataBuilder1.setToUin((String)localObject)));
    localObject = localDataBuilder;
    if (paramQCircleShareInfo.c != null) {
      localObject = paramQCircleShareInfo.c.mFeed;
    }
    localDataBuilder = QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject).setActionType(122).setSubActionType(1).setPageId(getPageId());
    localObject = str;
    if (paramQCircleShareInfo.c != null)
    {
      localObject = str;
      if (paramQCircleShareInfo.c.mFeed != null) {
        localObject = paramQCircleShareInfo.c.mFeed.poster.id.get();
      }
    }
    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(localDataBuilder.setToUin((String)localObject)));
  }
  
  private void setAuthIcon(FeedCloudMeta.StUser paramStUser)
  {
    if (this.mIvAuth == null) {
      return;
    }
    if (!QCirclePluginUtil.d(paramStUser))
    {
      this.mIvAuth.setVisibility(8);
      return;
    }
    if (QCirclePluginUtil.e(paramStUser) == 2) {
      paramStUser = QCircleConfigHelper.z();
    } else {
      paramStUser = QCircleConfigHelper.y();
    }
    QCircleFeedPicLoader.g().loadImage(new Option().setUrl(paramStUser).setTargetView(this.mIvAuth), null);
    this.mIvAuth.setVisibility(0);
  }
  
  private void setImageFilePath(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Object localObject = new ColorDrawable(this.mContainer.getContext().getResources().getColor(2131168376));
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = paramImageView.getLayoutParams();
      localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject).width;
      localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject).height;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("options.mRequestWidth =");
      ((StringBuilder)localObject).append(localURLDrawableOptions.mRequestWidth);
      ((StringBuilder)localObject).append("options.mRequestHeight =");
      ((StringBuilder)localObject).append(localURLDrawableOptions.mRequestHeight);
      QLog.d("QCircleFeedItemHeadPresenter", 1, ((StringBuilder)localObject).toString());
      paramImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
    }
  }
  
  private void setImageUrl(ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).getDefaultSavePath(paramString);
    if (RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).isFileDownLoading(paramString)) {
      return;
    }
    if (new File(str).exists())
    {
      setImageFilePath(paramImageView, str);
      return;
    }
    this.mImageListener = new QCircleFeedItemHeadPresenter.2(this, paramImageView);
    RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).download(paramString, this.mImageListener);
  }
  
  private void setShareBtn(FeedCloudMeta.StUser paramStUser)
  {
    this.mMoreImg.setVisibility(0);
  }
  
  private void updateFeedTime(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.isRecomFd == null) {
      return;
    }
    long l;
    if (paramStFeed.isRecomFd.get())
    {
      paramStFeed = paramStFeed.recomForward;
      if (paramStFeed == null) {
        l = 0L;
      } else {
        l = paramStFeed.createTime.get();
      }
    }
    else
    {
      l = paramStFeed.createTime.get();
    }
    paramStFeed = this.mTimeTxt;
    if ((paramStFeed != null) && (l > 0L)) {
      paramStFeed.setText(QCircleTextUtils.a(l * 1000L));
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    this.mReportInfo.mDataPosition = this.mPos;
    this.mReportInfo.mFeed = ((FeedBlockData)this.mData).b();
    this.mReportInfo.mPlayScene = 1;
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
    if (localStFeed.isRecomFd.get())
    {
      paramObject = localStFeed.recomForward.poster;
      this.mAvatarImg.setUser(localStFeed.recomForward.poster);
      this.mNickNameTxt.setText(localStFeed.recomForward.poster.nick.get());
      this.mFollowImg.setUserData((FeedCloudMeta.StUser)localStFeed.recomForward.poster.get(), localStFeed);
      setShareBtn(localStFeed.recomForward.poster);
    }
    else
    {
      FeedCloudMeta.StUser localStUser = localStFeed.poster;
      this.mAvatarImg.setUser(localStFeed.poster);
      if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.sourceType == 5))
      {
        long l = localStFeed.poiInfo.distance.get();
        this.mDesTxt.setVisibility(0);
        this.mDesTxt.setText(String.format(HardCodeUtil.a(2131895714), new Object[] { Float.valueOf((float)l / 1000.0F) }));
      }
      else
      {
        paramObject = ((FeedCloudMeta.StRecomInfo)localStFeed.recomInfo.get()).recomReason.get();
        if (TextUtils.isEmpty(paramObject))
        {
          this.mDesTxt.setVisibility(8);
        }
        else
        {
          this.mDesTxt.setVisibility(0);
          this.mDesTxt.setText(paramObject);
        }
      }
      Object localObject = localStFeed.poster.nick.get();
      paramObject = localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramObject = localObject;
        if (isFakeFeed())
        {
          paramObject = HostDataTransUtils.getAccountNickName(localStFeed.poster.id.get());
          QLog.d("QCircleFeedItemHeadPresenter", 1, "fake feed nick is empty ,get from native");
        }
      }
      localObject = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject = localStFeed.poster.id.get();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.mNickNameTxt.setText((CharSequence)localObject);
      }
      this.mFollowImg.setUserData((FeedCloudMeta.StUser)localStFeed.poster.get(), localStFeed);
      setShareBtn((FeedCloudMeta.StUser)localStFeed.poster.get());
      paramObject = localStUser;
    }
    setAuthIcon(paramObject);
    if (this.mTimeTxt == null) {
      return;
    }
    paramObject = localStFeed.opMask2.get();
    if ((paramObject != null) && (paramObject.contains(Integer.valueOf(9))))
    {
      this.mTimeTxt.setVisibility(8);
    }
    else
    {
      updateFeedTime(localStFeed);
      this.mTimeTxt.setVisibility(0);
    }
    if ((this.mTimeTxt.getVisibility() == 8) && (this.mDesTxt.getVisibility() == 8)) {
      this.mBottomWrapper.setVisibility(8);
    } else {
      this.mBottomWrapper.setVisibility(0);
    }
    if ((paramObject != null) && (paramObject.contains(Integer.valueOf(12))))
    {
      this.mExplodeCard.setVisibility(0);
      return;
    }
    this.mExplodeCard.setVisibility(8);
  }
  
  public void bindPicPresenter(QCircleFeedItemPicPresenter paramQCircleFeedItemPicPresenter)
  {
    this.mPicPresenter = paramQCircleFeedItemPicPresenter;
  }
  
  public void bindVideoPresenter(QCircleFeedItemVideoPresenter paramQCircleFeedItemVideoPresenter)
  {
    this.mVideoPresenter = paramQCircleFeedItemVideoPresenter;
  }
  
  public void doShare(int paramInt, boolean paramBoolean)
  {
    QCircleShareInfo localQCircleShareInfo;
    Object localObject1;
    Object localObject2;
    if ((this.mIntercator != null) && ((this.mData instanceof FeedBlockData)))
    {
      localQCircleShareInfo = new QCircleShareInfo();
      localQCircleShareInfo.d = 0;
      localQCircleShareInfo.b = ((FeedBlockData)this.mData).b();
      localQCircleShareInfo.j = (QCirclePluginUtil.d(localQCircleShareInfo.b) ^ true);
      localQCircleShareInfo.k = false;
      localQCircleShareInfo.i = QCirclePluginUtil.d(localQCircleShareInfo.b);
      localQCircleShareInfo.l = false;
      localObject1 = localQCircleShareInfo.b;
      if (localObject1 != null) {
        localObject2 = new QQCircleFeedBase.StFeedBusiReqData();
      }
    }
    for (;;)
    {
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject2).mergeFrom(((FeedCloudMeta.StFeed)localObject1).busiData.get().toByteArray());
        List localList2 = ((QQCircleFeedBase.StFeedBusiReqData)localObject2).uninterest_buttons.get();
        if ((localList2 == null) || (localList2.size() <= 0)) {
          break label486;
        }
        bool = true;
        localQCircleShareInfo.l = bool;
        localObject2 = ((QQCircleFeedBase.StFeedBusiReqData)localObject2).pushList;
        if ((localObject2 != null) && (((FeedCloudMeta.StPushList)localObject2).hasClickCount.get() > 0) && (QCirclePushInfoManager.a().d(((FeedCloudMeta.StFeed)localObject1).id.get())))
        {
          localQCircleShareInfo.n = true;
          reportUndoPush(localQCircleShareInfo);
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.e("QCircleFeedItemHeadPresenter", 1, "[doShare] error: ", localInvalidProtocolBufferMicroException);
      }
      List localList1 = ((FeedCloudMeta.StFeed)localObject1).opMask2.get();
      if (localList1 != null)
      {
        if ((!QCirclePluginUtil.b((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject1).poster.get())) && (localList1.contains(Integer.valueOf(1)))) {
          bool = true;
        } else {
          bool = false;
        }
        localQCircleShareInfo.m = bool;
        localQCircleShareInfo.p = localList1.contains(Integer.valueOf(10));
        localQCircleShareInfo.e = paramInt;
        bool = localQCircleShareInfo.m;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localQCircleShareInfo.p);
        ((StringBuilder)localObject1).append(" | picDownPos: ");
        QLog.d("QCircleFeedItemHeadPresenter", 1, new Object[] { "[Share-doShare] isShowHideThisWork: ", Boolean.valueOf(bool), " | isShowDownLoad: ", ((StringBuilder)localObject1).toString(), Integer.valueOf(localQCircleShareInfo.e) });
        if ((localList1.contains(Integer.valueOf(13))) && (QCircleApplication.isRDMVersion())) {
          localQCircleShareInfo.q = true;
        }
      }
      localObject1 = new QCircleExtraTypeInfo();
      ((QCircleExtraTypeInfo)localObject1).pageType = this.mExtraTypeInfo.pageType;
      ((QCircleExtraTypeInfo)localObject1).sourceType = this.mExtraTypeInfo.sourceType;
      ((QCircleExtraTypeInfo)localObject1).mDataPosition = this.mPos;
      localQCircleShareInfo.c = ((QCircleExtraTypeInfo)localObject1);
      localQCircleShareInfo.g = paramBoolean;
      this.mIntercator.a(localQCircleShareInfo);
      return;
      label486:
      boolean bool = false;
    }
  }
  
  public void doShare(QCircleStickShareEvent paramQCircleStickShareEvent)
  {
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.mData).b();
    if (localStFeed == null)
    {
      QLog.d("QCircleFeedItemHeadPresenter", 1, "[doShare] feed not is null.");
      return;
    }
    String str = paramQCircleStickShareEvent.mFeedId;
    QCircleReportBean localQCircleReportBean = paramQCircleStickShareEvent.mReportBean;
    if ((TextUtils.equals(str, localStFeed.id.get())) && (!paramQCircleStickShareEvent.mIsContentPage) && (localQCircleReportBean != null) && (localQCircleReportBean.getPageId() == getPageId())) {
      doShare(paramQCircleStickShareEvent.mPicPos, false);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleStickShareEvent.class);
    return localArrayList;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemHeadPresenter";
  }
  
  public void initView(View paramView)
  {
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440931), this);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
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
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onFollowStateChange(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    this.mMoreImg.setVisibility(0);
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mAvatarImg = ((QCircleAvatarView)this.mContainer.findViewById(2131441627));
    this.mNickNameTxt = ((TextView)this.mContainer.findViewById(2131441641));
    this.mIvAuth = ((SquareImageView)this.mContainer.findViewById(2131436263));
    this.mTimeTxt = ((TextView)this.mContainer.findViewById(2131441652));
    this.mDesTxt = ((TextView)this.mContainer.findViewById(2131441637));
    this.mMoreImg = ((ImageView)this.mContainer.findViewById(2131441649));
    this.mFollowImg = ((QCircleFollowView)this.mContainer.findViewById(2131441632));
    this.mBottomWrapper = this.mContainer.findViewById(2131441634);
    this.mExplodeCard = ((ImageView)this.mContainer.findViewById(2131441631));
    this.mContainer.findViewById(2131441635).setOnClickListener(this);
    this.mAvatarImg.setOnClickListener(this);
    this.mMoreImg.setOnClickListener(this);
    this.mAvatarImg.setOnClickListener(this);
    this.mFollowImg.setFollowedDismiss(true);
    this.mFollowImg.setFollowStateChangeListener(this);
    this.mFollowImg.setDtParentEmId("em_xsj_feed");
    this.mFollowImg.setItemReportListener(new QCircleFeedItemHeadPresenter.1(this));
    this.mNickNameTxt.setOnClickListener(this);
    setImageUrl(this.mExplodeCard, QCircleSkinHelper.getInstance().getUrl("feed_push_explode_card_deco"));
    initMoreImg();
    if (this.mData != null) {
      bindData(this.mData, this.mPos);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleStickShareEvent)) {
      doShare((QCircleStickShareEvent)paramSimpleBaseEvent);
    }
  }
  
  public void updateNickName(String paramString1, String paramString2)
  {
    if (((this.mData instanceof FeedBlockData)) && (((FeedBlockData)this.mData).b().poster.id.get().equals(paramString2))) {
      this.mNickNameTxt.setText(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemHeadPresenter
 * JD-Core Version:    0.7.0.1
 */