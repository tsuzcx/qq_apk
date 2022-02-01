package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper.ClickItemListener;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper.ResultListener;
import com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView.AdInnerClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.util.IliveEntranceUtil;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class RelativeFeedsAdapter
  extends FakerFeedsAdapter
  implements SimpleEventReceiver, RelativeAdFeedItemView.AdInnerClickListener
{
  private static Drawable t = new ColorDrawable(0);
  private CertifiedAccountMeta.StFeed b;
  private RelativeFeedsAdapter.ItemClickListener c;
  private int d = ImmersiveUtils.dpToPx(4.0F);
  private int e = ImmersiveUtils.dpToPx(16.0F);
  private int f = ImmersiveUtils.dpToPx(13.0F);
  private int g = ImmersiveUtils.dpToPx(3.0F);
  private boolean k = true;
  private int l;
  private int m = -1;
  private boolean n = false;
  private boolean o = true;
  private int p;
  private int q;
  private FolderRecommendTabFragment.FolderRecommendHeadItemView r;
  private int s = -1;
  private int u = 99;
  
  public RelativeFeedsAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RecyclerView.ViewHolder a(ViewGroup paramViewGroup)
  {
    Object localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625667, paramViewGroup, false);
    paramViewGroup = new RelativeFeedsAdapter.RelativeLiveVH(this, (View)localObject);
    this.p = ((View)localObject).getResources().getDisplayMetrics().widthPixels;
    int i = (int)(this.p * 0.5F - ViewUtils.dpToPx(8.5F));
    this.q = (i - ViewUtils.dpToPx(7.0F));
    int j = this.q;
    int i1 = ViewUtils.dpToPx(54.0F);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.a.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = i;
    ((RelativeLayout.LayoutParams)localObject).height = (j + i1);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.c.getLayoutParams();
    i = this.q;
    ((RelativeLayout.LayoutParams)localObject).width = i;
    ((RelativeLayout.LayoutParams)localObject).height = i;
    return paramViewGroup;
  }
  
  @NotNull
  private FrameLayout b(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextView(paramViewGroup.getContext());
    FrameLayout localFrameLayout = c(paramViewGroup);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramViewGroup.setLayoutParams(localLayoutParams);
    paramViewGroup.setTextSize(1, 16.0F);
    paramViewGroup.setMaxLines(1);
    paramViewGroup.setTextColor(Color.parseColor("#222222"));
    paramViewGroup.getPaint().setFakeBoldText(true);
    localLayoutParams.leftMargin = ImmersiveUtils.dpToPx(16.0F);
    localLayoutParams.rightMargin = ImmersiveUtils.dpToPx(16.0F);
    paramViewGroup.setText(HardCodeUtil.a(2131899741));
    return localFrameLayout;
  }
  
  private void b(String paramString)
  {
    int i = this.s;
    MobileReportManager localMobileReportManager;
    Object localObject;
    long l1;
    StringBuilder localStringBuilder;
    if (i == 0)
    {
      this.u = 6;
      localMobileReportManager = MobileReportManager.getInstance();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      l1 = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("");
      localMobileReportManager.reportActionLive((String)localObject, "25", "qq_live", "tab_page", "subscribe", 102, 1, l1, localStringBuilder.toString());
      return;
    }
    if (i == 1)
    {
      this.u = 5;
      localMobileReportManager = MobileReportManager.getInstance();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      l1 = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("");
      localMobileReportManager.reportActionLive((String)localObject, "25", "qq_live", "find_page", "hot_push", 102, 1, l1, localStringBuilder.toString());
      return;
    }
    if (i == 2)
    {
      this.u = 2;
      localMobileReportManager = MobileReportManager.getInstance();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      l1 = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("");
      localMobileReportManager.reportActionLive((String)localObject, "25", "qq_live", "shopcart_page", "hot_push", 102, 1, l1, localStringBuilder.toString());
    }
  }
  
  private void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    VSReporter.b(paramStFeed.poster.id.get(), "auth_follow", "press", 0, 0, new String[0]);
    SubscribeFollowUserUtil.b(H(), paramStFeed.poster.id.get(), new RelativeFeedsAdapter.2(this, paramStFeed));
  }
  
  private boolean e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return paramStFeed.live.liveUin.get() != 0L;
  }
  
  public int a(int paramInt)
  {
    if (getItemViewType(paramInt) == 100000) {
      return 1;
    }
    return 2;
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, FeedbackSheetHelper.ResultListener paramResultListener, FeedbackSheetHelper.ClickItemListener paramClickItemListener)
  {
    if (paramStFeed == null) {
      return;
    }
    FeedbackSheetHelper.a(H(), paramStFeed, paramResultListener, paramClickItemListener);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramContext = new IliveJumpParams(paramContext, "subscription", paramString1, paramString2, false, paramArrayList, "", paramInt);
    paramContext.e = paramString3;
    paramContext.m = paramString4;
    paramContext.n = paramString5;
    paramContext.o = paramString6;
    paramContext.p = paramString7;
    IliveEntranceUtil.a(paramContext);
  }
  
  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    if ((this.k) && ((i == 0) || (i == 1)))
    {
      paramRect.bottom = this.f;
      return;
    }
    paramRect.bottom = this.e;
  }
  
  public void a(Bundle paramBundle)
  {
    J().addOnScrollListener(new RelativeFeedsAdapter.3(this));
  }
  
  public void a(RelativeFeedsAdapter.ItemClickListener paramItemClickListener)
  {
    this.c = paramItemClickListener;
  }
  
  public void a(LoadInfo paramLoadInfo)
  {
    int i = this.m;
    Object localObject2 = null;
    Object localObject1;
    if ((i != -1) && ((paramLoadInfo.c()) || (paramLoadInfo.d())))
    {
      localObject1 = new GetSubscribeFeedListRequest(this.m, D().g(), D().h(), null);
    }
    else
    {
      localObject1 = localObject2;
      if (this.m != -1)
      {
        localObject1 = localObject2;
        if (paramLoadInfo.e()) {
          localObject1 = new GetSubscribeFeedListRequest(this.m, D().g(), D().h(), D().i());
        }
      }
    }
    if (localObject1 == null) {
      return;
    }
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject1, new RelativeFeedsAdapter.1(this, paramLoadInfo));
  }
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    super.a(paramString, paramShareData);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramShareData.a != null))
    {
      this.b = ((CertifiedAccountMeta.StFeed)paramShareData.a);
      if (paramShareData.b) {
        y();
      }
    }
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    a(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    this.l = -1;
    f();
    D().a(paramBoolean);
    D().a(paramStCommonExt);
    D().a(paramString);
    b((ArrayList)paramList);
    d(true);
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    a(paramStFeed);
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    b(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    D().a(paramBoolean);
    D().a(paramStCommonExt);
    D().a(paramString);
    if ((paramList != null) && (paramList.size() > 0)) {
      b(paramList);
    }
    d(true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
    notifyDataSetChanged();
  }
  
  public String bA_()
  {
    return "RELATIVE_ADAPTER_UNIQUE_KEY";
  }
  
  public int c()
  {
    return 3;
  }
  
  public void c(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((N() != null) && (N().size() != 0))
    {
      if (this.l > N().size()) {
        return;
      }
      int i = this.l;
      while (i >= 0)
      {
        CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)N().get(i);
        if ((localStFeed != null) && (SubscribeLaucher.a(localStFeed.type.get())) && (localStFeed.id.get().equals(paramStFeed.id.get())))
        {
          this.l = i;
          return;
        }
        i -= 1;
      }
      this.l = -1;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((I() != null) && (B() != null))
    {
      D().a(4);
      I().setRefreshing(false);
      if (L())
      {
        B().a(paramBoolean, D().a());
        return;
      }
      if ((B() != null) && (N() != null) && (N().size() == 0)) {
        B().a(paramBoolean, false);
      }
    }
  }
  
  public ArrayList<String> g()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)localIterator.next();
      try
      {
        localArrayList.add(new String(localStFeed.toByteArray(), "ISO8859_1"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public int getItemCount()
  {
    if (!this.h) {
      return 4;
    }
    int j = this.j.size();
    int i = j;
    if (j > 0)
    {
      i = j;
      if (this.k) {
        i = j + 1;
      }
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (this.k) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if (e((CertifiedAccountMeta.StFeed)N().get(i))) {
      return 100003;
    }
    if ((!ArrayUtils.isOutOfArrayIndex(i, N())) && (((CertifiedAccountMeta.StFeed)N().get(i)).type.get() == 4)) {
      return 1;
    }
    return 100002;
  }
  
  public CertifiedAccountMeta.StFeed j()
  {
    if (N() != null)
    {
      if (N().size() == 0) {
        return null;
      }
      int i = this.l;
      int j;
      CertifiedAccountMeta.StFeed localStFeed;
      do
      {
        do
        {
          j = i + 1;
          if (j >= N().size()) {
            break;
          }
          localStFeed = (CertifiedAccountMeta.StFeed)N().get(j);
          i = j;
        } while (localStFeed == null);
        i = j;
      } while (!SubscribeLaucher.a(localStFeed.type.get()));
      this.l = j;
      return localStFeed;
    }
    return null;
  }
  
  @SuppressLint({"WrongConstant"})
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.k) {
      i = paramInt - 1;
    }
    if (!ArrayUtils.isOutOfArrayIndex(i, N()))
    {
      CertifiedAccountMeta.StFeed localStFeed;
      if ((paramViewHolder instanceof RelativeFeedsAdapter.RelativeLiveVH))
      {
        localStFeed = (CertifiedAccountMeta.StFeed)this.j.get(i);
        RelativeFeedsAdapter.RelativeLiveVH localRelativeLiveVH = (RelativeFeedsAdapter.RelativeLiveVH)paramViewHolder;
        localRelativeLiveVH.a(localStFeed);
        localRelativeLiveVH.a(localRelativeLiveVH, localStFeed);
      }
      else
      {
        localStFeed = (CertifiedAccountMeta.StFeed)N().get(i);
        ((RelativeFeedsAdapter.RelativeFeedVH)paramViewHolder).a(localStFeed, K());
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, i, getItemId(i));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new RelativeFeedsAdapter.RelativeFeedVH(this, b(paramViewGroup));
    }
    if (paramInt == 1) {
      return new RelativeFeedsAdapter.RelativeFeedVH(this, new RelativeAdFeedItemView(paramViewGroup.getContext(), this));
    }
    if (paramInt == 100003) {
      return a(paramViewGroup);
    }
    return new RelativeFeedsAdapter.RelativeFeedVH(this, new RelativeFeedItemView(paramViewGroup.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */