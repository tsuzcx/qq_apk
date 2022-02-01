package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler.Companion;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.RIJXTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJXTabFrameUtils;", "", "()V", "tabFrame", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "getTabFrame", "()Ljava/lang/Class;", "addFragment2Info", "", "tabChannelCoverInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/TabChannelCoverInfo;", "fragment", "Landroid/support/v4/app/Fragment;", "createTabChannelCoverInfo", "channelID", "", "channelName", "", "jumpUrl", "isImmersive", "", "createTabFrame", "className", "frameFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "getAladdinConfigChannel", "", "getChannelBarMarginTop", "getChannelCoverList", "getChannelPaddingTop", "", "getDefaultConfigChannel", "getPreFrameClass", "kandianFrameStatus", "Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase$KandianFrameStatus;", "isKandianTabFrame", "frame", "isNowInKanDianTab", "onTabClickSelf", "updateFrameStatus", "isShowKandianTab", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrameUtils
{
  public static final RIJXTabFrameUtils a = new RIJXTabFrameUtils();
  
  private final float a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0.0F;
    }
    Object localObject = BaseApplicationImpl.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getContext()");
    localObject = (Context)localObject;
    float f2 = a();
    localObject = ((Context)localObject).getResources();
    if (localObject != null) {}
    for (float f1 = ((Resources)localObject).getDimension(2131298874);; f1 = 0.0F) {
      return f2 + f1;
    }
  }
  
  private final TabChannelCoverInfo a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo();
    localTabChannelCoverInfo.mChannelCoverId = paramInt;
    localTabChannelCoverInfo.mChannelCoverName = paramString1;
    localTabChannelCoverInfo.mChannelJumpUrl = paramString2;
    localTabChannelCoverInfo.isImmersive = paramBoolean;
    localTabChannelCoverInfo.isXTabMode = true;
    return localTabChannelCoverInfo;
  }
  
  @JvmStatic
  @NotNull
  public static final List<TabChannelCoverInfo> a()
  {
    List localList = a.c();
    if (!((Collection)localList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0) {
      return localList;
    }
    localList = a.b();
    QLog.d("ReadInJoyHelper", 1, "getChannelCoverList, use default config!");
    return localList;
  }
  
  private final List<TabChannelCoverInfo> b()
  {
    List localList = (List)new ArrayList();
    localList.add(a(this, 0, "推荐", null, false, 12, null));
    localList.add(a(this, 41726, "视频", null, true, 4, null));
    localList.add(a(this, 41655, "好友", "https://viola.qq.com/channel/kd_feeds_new.js?_rij_violaUrl=1&v_tid=11&v_bid=3704&v_bundleName=kd_feeds_new&channelID=41655&srcID=1&key=friend", false, 8, null));
    localList.add(a(this, 70, "关注", "https://viola.qq.com/channel/kd_feeds_new.js?_rij_violaUrl=1&v_tid=48&v_bid=4441&v_bundleName=followPage", false, 8, null));
    return localList;
  }
  
  private final List<TabChannelCoverInfo> c()
  {
    return RIJXTabConfigHandler.a.a().a();
  }
  
  public final int a()
  {
    int j = ImmersiveUtils.getStatusBarHeight((Context)BaseApplicationImpl.getContext());
    int i = j;
    if (j <= 0) {
      i = ImmersiveUtils.dpToPx(44.0F);
    }
    return i;
  }
  
  @NotNull
  public final Class<? extends Frame> a()
  {
    if (RIJXTabConfigHandler.a.a().a()) {
      return RIJXTabFrame.class;
    }
    return ReadinjoyTabFrame.class;
  }
  
  @NotNull
  public final Class<? extends Frame> a(@NotNull RIJTabFrameBase.KandianFrameStatus paramKandianFrameStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianFrameStatus, "kandianFrameStatus");
    paramKandianFrameStatus = paramKandianFrameStatus.a();
    if (paramKandianFrameStatus != null) {
      return paramKandianFrameStatus;
    }
    return ReadinjoyTabFrame.class;
  }
  
  public final void a(@NotNull RIJTabFrameBase.KandianFrameStatus paramKandianFrameStatus, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianFrameStatus, "kandianFrameStatus");
    paramKandianFrameStatus.a(paramBoolean);
    paramKandianFrameStatus.a(a());
    paramKandianFrameStatus.b(RIJXTabConfigHandler.a.a().a());
  }
  
  public final void a(@NotNull TabChannelCoverInfo paramTabChannelCoverInfo, @Nullable Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramTabChannelCoverInfo, "tabChannelCoverInfo");
    if ((paramFragment != null) && (paramTabChannelCoverInfo.isXTabMode))
    {
      Bundle localBundle2 = paramFragment.getArguments();
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = new Bundle();
      }
      localBundle1.putInt("channel_padding_top", (int)a.a(paramTabChannelCoverInfo.isImmersive));
      localBundle1.putBoolean("is_xtab_mode", true);
      paramFragment.setArguments(localBundle1);
    }
  }
  
  public final void a(@Nullable Frame paramFrame)
  {
    if ((paramFrame instanceof RIJTabFrameBase)) {
      ((RIJTabFrameBase)paramFrame).A_();
    }
  }
  
  public final boolean a()
  {
    return RIJTabFrameBase.a.a();
  }
  
  public final boolean a(@Nullable Frame paramFrame)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFrame != null) {
      if (!(paramFrame instanceof RIJXTabFrame))
      {
        bool1 = bool2;
        if (!(paramFrame instanceof ReadinjoyTabFrame)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean a(@Nullable String paramString)
  {
    return (!TextUtils.isEmpty((CharSequence)paramString)) && ((StringsKt.equals(paramString, ReadinjoyTabFrame.class.getName(), true)) || (StringsKt.equals(paramString, RIJXTabFrame.class.getName(), true)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils
 * JD-Core Version:    0.7.0.1
 */