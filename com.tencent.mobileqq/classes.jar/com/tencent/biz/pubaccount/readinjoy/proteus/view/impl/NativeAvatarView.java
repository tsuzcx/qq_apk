package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.UiThread;
import bgku;
import bjda;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import oat;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import pgc;
import pha;
import pxk;
import pyb;
import qva;
import rha;
import rug;
import snh;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import ube;

public class NativeAvatarView
  extends RingAvatarView
  implements IView, pyb
{
  public static final String TAG = "NativeAvatarView";
  private ReadInJoyHeadImageView avatar;
  private ImageView background;
  private NativeReadInjoyImageView iconV;
  private boolean isLive;
  private long lastRefreshTime;
  private NativeReadInjoyImageView liveRing;
  private String liveRingUrl;
  private NativeReadInjoyImageView liveStatus;
  private String liveStatusUrl;
  private qva mCtxt = new qva();
  private long refreshMinInterval = 1000L;
  private long uin;
  private ReadInJoyUserInfo userInfo;
  
  public NativeAvatarView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  private void doReport(String paramString)
  {
    Object localObject2 = this.mCtxt.a.a();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = "1";
    if (snh.g((BaseArticleInfo)localObject2))
    {
      localObject1 = "3";
      String str = pha.a((String)localObject1, (ArticleInfo)localObject2, this.uin);
      if (!ube.a(((ArticleInfo)localObject2).mChannelID)) {
        break label213;
      }
      localObject1 = "0X800935C";
      label55:
      oat.a(null, String.valueOf(this.uin), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(((ArticleInfo)localObject2).mFeedId), String.valueOf(((ArticleInfo)localObject2).mArticleID), "" + ((ArticleInfo)localObject2).mStrategyId, str, false);
    }
    for (;;)
    {
      try
      {
        localObject1 = pha.a();
        ((JSONObject)localObject1).put("feeds_source", paramString);
        ((JSONObject)localObject1).put("kandian_mode", pha.e());
        localObject2 = pha.e(this.mCtxt.a.a());
        if (!ube.a(this.mCtxt.a.e())) {
          break label219;
        }
        paramString = "0X8009357";
        oat.a(null, "CliOper", "", "", paramString, paramString, 0, 0, (String)localObject2, "", "", ((JSONObject)localObject1).toString(), false);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (!snh.a((ArticleInfo)localObject2)) {
        break;
      }
      localObject1 = "4";
      break;
      label213:
      localObject1 = "0X8007BA3";
      break label55;
      label219:
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131560067, this);
    this.background = ((ImageView)paramContext.findViewById(2131363219));
    this.background.setImageResource(2130849469);
    this.background.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.background.setVisibility(8);
    this.liveRing = ((NativeReadInjoyImageView)paramContext.findViewById(2131376578));
    this.liveRing.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.liveRing.setVisibility(8);
    this.avatar = ((ReadInJoyHeadImageView)paramContext.findViewById(2131363088));
    this.avatar.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.iconV = ((NativeReadInjoyImageView)paramContext.findViewById(2131368189));
    this.iconV.setImageResource(2130842832);
    this.iconV.setVisibility(8);
    this.liveStatus = ((NativeReadInjoyImageView)paramContext.findViewById(2131370001));
    this.liveStatus.setVisibility(8);
    setClipChildren(false);
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
        break label75;
      }
    }
    label75:
    for (int i = 1; i != 0; i = 0)
    {
      this.liveRing.setVisibility(0);
      this.liveRing.setImageSrc(this.liveRingUrl);
      this.background.setVisibility(8);
      this.iconV.setVisibility(8);
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
  
  public void bindStarStyle(pxk parampxk)
  {
    if (parampxk == null) {}
    do
    {
      return;
      parampxk = parampxk.a();
    } while ((parampxk == null) || (parampxk.mSocialFeedInfo == null) || (parampxk.mSocialFeedInfo.a == null));
    if (parampxk.mSocialFeedInfo.a.a())
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
      pha.a = this.mCtxt.a.a();
      if (this.mCtxt.a.a() != 34) {
        break label119;
      }
      str = pgc.k + bgku.encodeToString(String.valueOf(this.uin).getBytes(), 2);
      pha.a(getContext(), str);
    }
    for (;;)
    {
      doReport(pha.d(this.mCtxt.a.a()));
      return;
      label119:
      str = pgc.g + bgku.encodeToString(String.valueOf(this.uin).getBytes(), 2);
      pha.a(getContext(), str);
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
    bjda.a().post(new NativeAvatarView.1(this));
  }
  
  public void refresh(boolean paramBoolean)
  {
    if (System.currentTimeMillis() - this.lastRefreshTime <= this.refreshMinInterval) {
      return;
    }
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
    bjda.a().post(new NativeAvatarView.2(this));
  }
  
  public void setLiveStatusUrl(String paramString)
  {
    this.liveStatusUrl = paramString;
    bjda.a().post(new NativeAvatarView.3(this));
  }
  
  public void setModel(pxk parampxk)
  {
    setModel(parampxk, true);
  }
  
  public void setModel(pxk parampxk, boolean paramBoolean)
  {
    this.mCtxt.a(parampxk);
    if (parampxk != null) {
      refresh(paramBoolean);
    }
  }
  
  public void setUin(long paramLong)
  {
    this.uin = paramLong;
    refresh(true);
  }
  
  @UiThread
  protected void showIconV()
  {
    ArticleInfo localArticleInfo;
    if ((this.mCtxt != null) && (this.mCtxt.a != null))
    {
      localArticleInfo = this.mCtxt.a.a();
      if (localArticleInfo == null)
      {
        this.iconV.setVisibility(8);
        return;
      }
      this.iconV.setImageResource(2130842832);
      if (!localArticleInfo.isAccountShown) {
        break label93;
      }
      setIConVUrl(getIConVUrl(localArticleInfo));
    }
    for (;;)
    {
      bindStarStyle(this.mCtxt.a);
      rug.a(this.userInfo, this.iconV);
      return;
      label93:
      if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.a != null)) {
        setIConVType(localArticleInfo);
      } else {
        this.iconV.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView
 * JD-Core Version:    0.7.0.1
 */