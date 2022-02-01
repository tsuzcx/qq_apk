package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.vicon.ReadInJoyVIconHelper;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class NativeAvatarView
  extends RingAvatarView
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack, IView
{
  public static final String TAG = "NativeAvatarView";
  private ReadInJoyHeadImageView avatar;
  private ImageView background;
  private NativeReadInjoyImageView iconV;
  private Drawable iconVPlaceHolder = new ColorDrawable(0);
  private boolean isLive;
  private long lastRefreshTime;
  private NativeReadInjoyImageView liveRing;
  private Drawable liveRingPlaceHolder = new ColorDrawable(0);
  private String liveRingUrl;
  private NativeReadInjoyImageView liveStatus;
  private Drawable liveStatusPlaceHolder = new ColorDrawable(0);
  private String liveStatusUrl;
  private CmpCtxt mCtxt = new CmpCtxt();
  private long refreshMinInterval = 1000L;
  private long uin;
  private ReadInJoyUserInfo userInfo;
  
  public NativeAvatarView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public NativeAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  private void adjustRingMargin()
  {
    if (this.liveRing != null)
    {
      int i = -(int)(0.076F * getWidth());
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.liveRing.getLayoutParams();
      localLayoutParams.bottomMargin = i;
      localLayoutParams.topMargin = i;
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      this.liveRing.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean canRefreshInTimeLimit()
  {
    return System.currentTimeMillis() - this.lastRefreshTime > this.refreshMinInterval;
  }
  
  private void doReport(String paramString)
  {
    Object localObject2 = this.mCtxt.a.a();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = "1";
    if (RIJItemViewType.g((BaseArticleInfo)localObject2))
    {
      localObject1 = "3";
      String str = RIJTransMergeKanDianReport.a((String)localObject1, (ArticleInfo)localObject2, this.uin);
      if (!ReadinjoyReportUtils.a(((ArticleInfo)localObject2).mChannelID)) {
        break label233;
      }
      localObject1 = "0X800935C";
      label55:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(this.uin), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(((ArticleInfo)localObject2).mFeedId), String.valueOf(((ArticleInfo)localObject2).mArticleID), "" + ((ArticleInfo)localObject2).mStrategyId, str, false);
    }
    for (;;)
    {
      try
      {
        localObject1 = RIJTransMergeKanDianReport.a();
        ((JSONObject)localObject1).put("feeds_source", paramString);
        ((JSONObject)localObject1).put("kandian_mode", RIJAppSetting.a());
        localObject2 = RIJFeedsType.c(this.mCtxt.a.a());
        if (!ReadinjoyReportUtils.a(this.mCtxt.a.e())) {
          break label239;
        }
        paramString = "0X8009357";
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramString, paramString, 0, 0, (String)localObject2, "", "", ((JSONObject)localObject1).toString(), false);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (!RIJItemViewType.a((ArticleInfo)localObject2)) {
        break;
      }
      localObject1 = "4";
      break;
      label233:
      localObject1 = "0X8007BA3";
      break label55;
      label239:
      paramString = "0X800744D";
    }
  }
  
  @NotNull
  private String getIConVUrl(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mPartnerAccountInfo != null) {
      return paramArticleInfo.mPartnerAccountInfo.bytes_v_icon_url.get().toStringUtf8();
    }
    return "";
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560211, this);
    this.background = ((ImageView)paramContext.findViewById(2131363419));
    this.background.setImageResource(2130849865);
    this.background.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.background.setVisibility(8);
    this.liveRing = ((NativeReadInjoyImageView)paramContext.findViewById(2131377130));
    this.liveRing.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.liveRing.setImagePlaceHolder(this.liveRingPlaceHolder);
    this.liveRing.setVisibility(8);
    this.avatar = ((ReadInJoyHeadImageView)paramContext.findViewById(2131363196));
    this.avatar.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.iconV = ((NativeReadInjoyImageView)paramContext.findViewById(2131368656));
    this.iconV.setImageResource(2130843088);
    this.iconV.setVisibility(8);
    this.iconV.setImagePlaceHolder(this.iconVPlaceHolder);
    this.liveStatus = ((NativeReadInjoyImageView)paramContext.findViewById(2131370542));
    this.liveStatus.setImagePlaceHolder(this.liveStatusPlaceHolder);
    this.liveStatus.setVisibility(8);
    setLayerType(1, null);
  }
  
  private void setIConVType(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mSocialFeedInfo.a.a == 1)
    {
      this.iconV.setVisibility(0);
      return;
    }
    this.iconV.setVisibility(8);
  }
  
  private void setIConVUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.iconV.setVisibility(0);
      try
      {
        this.iconV.setImage(new URL(paramString));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("NativeAvatarView", 2, paramString, new Object[0]);
        return;
      }
    }
    this.iconV.setVisibility(8);
  }
  
  private void showLive()
  {
    QLog.d("NativeAvatarView", 1, "isLive: " + this.isLive + " liveCircle:  liveStatus: " + this.liveStatusUrl);
    showLiveRing();
    showLiveStatus();
  }
  
  @UiThread
  private void showLiveRing()
  {
    if ((this.liveRing != null) && (this.background != null) && (this.iconV != null)) {
      if (TextUtils.isEmpty(this.liveRingUrl)) {
        break label79;
      }
    }
    label79:
    for (int i = 1; i != 0; i = 0)
    {
      this.liveRing.setVisibility(0);
      this.liveRing.setImageSrc(this.liveRingUrl);
      this.background.setVisibility(8);
      this.iconV.setVisibility(8);
      adjustRingMargin();
      return;
    }
    this.liveRing.setVisibility(8);
  }
  
  @UiThread
  private void showLiveStatus()
  {
    if ((this.liveStatus != null) && (this.background != null) && (this.iconV != null)) {
      if (TextUtils.isEmpty(this.liveStatusUrl)) {
        break label75;
      }
    }
    label75:
    for (int i = 1; i != 0; i = 0)
    {
      this.liveStatus.setVisibility(0);
      this.liveStatus.setImageSrc(this.liveStatusUrl);
      this.background.setVisibility(8);
      this.iconV.setVisibility(8);
      return;
    }
    this.liveStatus.setVisibility(8);
  }
  
  public void bindStarStyle(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel == null) {}
    do
    {
      return;
      paramIReadInJoyModel = paramIReadInJoyModel.a();
    } while ((paramIReadInJoyModel == null) || (paramIReadInJoyModel.mSocialFeedInfo == null) || (paramIReadInJoyModel.mSocialFeedInfo.a == null));
    if (paramIReadInJoyModel.mSocialFeedInfo.a.a())
    {
      this.background.setVisibility(0);
      return;
    }
    this.background.setVisibility(8);
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onHeadClick()
  {
    String str;
    if ((this.mCtxt.a != null) && (this.mCtxt.a.a() != null))
    {
      com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.a = this.mCtxt.a.a();
      if (this.mCtxt.a.a() != 34) {
        break label120;
      }
      str = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(this.uin).getBytes(), 2);
      ReadInJoyUtils.a(getContext(), str);
    }
    for (;;)
    {
      doReport(RIJFeedsType.b(this.mCtxt.a.a()));
      return;
      label120:
      str = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(this.uin).getBytes(), 2);
      ReadInJoyUtils.a(getContext(), str);
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("NativeAvatarView", 1, "onLoadUserInfoFailed: " + paramString1 + " " + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    this.userInfo = paramReadInJoyUserInfo;
    QLog.d("NativeAvatarView", 1, "load uin success: " + paramString + " " + paramReadInJoyUserInfo);
    if (paramReadInJoyUserInfo != null) {
      this.isLive = paramReadInJoyUserInfo.isLiving();
    }
    ThreadManager.a().post(new NativeAvatarView.1(this));
  }
  
  public void refresh(boolean paramBoolean)
  {
    this.lastRefreshTime = System.currentTimeMillis();
    this.avatar.setHeadImgByUin(this.uin, paramBoolean, this);
  }
  
  public void setAvatarDrawable(Drawable paramDrawable)
  {
    this.avatar.setImageDrawable(paramDrawable);
    this.iconV.setVisibility(8);
  }
  
  public void setLiveRingUrl(String paramString)
  {
    this.liveRingUrl = paramString;
    ThreadManager.a().post(new NativeAvatarView.2(this));
  }
  
  public void setLiveStatusUrl(String paramString)
  {
    this.liveStatusUrl = paramString;
    ThreadManager.a().post(new NativeAvatarView.3(this));
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    setModel(paramIReadInJoyModel, true);
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel, boolean paramBoolean)
  {
    this.mCtxt.a(paramIReadInJoyModel);
    if ((paramIReadInJoyModel != null) && (canRefreshInTimeLimit())) {
      refresh(paramBoolean);
    }
  }
  
  public void setUin(long paramLong)
  {
    if ((!canRefreshInTimeLimit()) && (paramLong == this.uin)) {
      return;
    }
    this.uin = paramLong;
    refresh(true);
  }
  
  @UiThread
  protected void showIconV()
  {
    ArticleInfo localArticleInfo;
    if ((TextUtils.isEmpty(this.liveStatusUrl)) && (TextUtils.isEmpty(this.liveRingUrl)))
    {
      if ((this.mCtxt == null) || (this.mCtxt.a == null)) {
        break label101;
      }
      localArticleInfo = this.mCtxt.a.a();
      if (localArticleInfo == null) {
        this.iconV.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.iconV.setImageResource(2130843088);
    if (localArticleInfo.isAccountShown) {
      setIConVUrl(getIConVUrl(localArticleInfo));
    }
    for (;;)
    {
      bindStarStyle(this.mCtxt.a);
      label101:
      ReadInJoyVIconHelper.a(this.userInfo, this.iconV);
      return;
      if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.a != null)) {
        setIConVType(localArticleInfo);
      } else {
        this.iconV.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView
 * JD-Core Version:    0.7.0.1
 */