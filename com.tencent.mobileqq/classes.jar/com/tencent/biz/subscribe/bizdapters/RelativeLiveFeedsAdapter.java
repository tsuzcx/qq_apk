package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomLstItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.TabItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionRsp.Bottom;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.bean.FeedsItemInfo;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.PbProtocol;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.util.IliveEntranceUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class RelativeLiveFeedsAdapter
  extends MultiViewBlock<FeedsItemInfo>
{
  private static Drawable d = new ColorDrawable(0);
  protected RecyclerView.LayoutManager a;
  CertifiedAccountRead.GetSubscriptionRsp.Bottom b;
  String c;
  private int e = ImmersiveUtils.dpToPx(16.0F);
  private int f = ImmersiveUtils.dpToPx(13.0F);
  private boolean g = true;
  private int k = -1;
  private boolean l = false;
  private boolean m = true;
  private int n;
  private int o;
  private FolderRecommendTabFragment.FolderRecommendHeadItemView p;
  private int q = -1;
  private int r = 99;
  
  public RelativeLiveFeedsAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RecyclerView.ViewHolder a(ViewGroup paramViewGroup)
  {
    Object localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625667, paramViewGroup, false);
    paramViewGroup = new RelativeLiveFeedsAdapter.RelativeLiveVH(this, (View)localObject);
    this.n = ((View)localObject).getResources().getDisplayMetrics().widthPixels;
    int i = (int)(this.n * 0.5F - ViewUtils.dpToPx(8.5F));
    this.o = (i - ViewUtils.dpToPx(7.0F));
    int j = this.o;
    int i1 = ViewUtils.dpToPx(54.0F);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.a.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = i;
    ((RelativeLayout.LayoutParams)localObject).height = (j + i1);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.c.getLayoutParams();
    i = this.o;
    ((RelativeLayout.LayoutParams)localObject).width = i;
    ((RelativeLayout.LayoutParams)localObject).height = i;
    return paramViewGroup;
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof CertifiedAccountRead.GetSubscriptionRsp)))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isSuccess:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" updateFeedsData:");
      QLog.d("RelativeFeedsAdapter", 2, ((StringBuilder)localObject1).toString());
      Object localObject2 = (CertifiedAccountRead.GetSubscriptionRsp)paramObject;
      paramObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).room_lst.get();
      localObject1 = (CertifiedAccountRead.GetSubscriptionRsp.Bottom)((CertifiedAccountRead.GetSubscriptionRsp)localObject2).bottom.get();
      localObject2 = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).page_info.get();
      D().b((String)localObject2);
      if (this.p != null)
      {
        if ((paramObject != null) && (paramObject.size() > 0))
        {
          boolean bool = a(false, paramObject);
          paramBoolean = bool;
          if (bool)
          {
            this.p.b(false);
            a(paramObject, (CertifiedAccountRead.GetSubscriptionRsp.Bottom)localObject1, (String)localObject2);
            paramBoolean = bool;
            if (localObject1 != null)
            {
              this.p.a(true, ((CertifiedAccountRead.GetSubscriptionRsp.Bottom)localObject1).desc.get(), ((CertifiedAccountRead.GetSubscriptionRsp.Bottom)localObject1).jump_url.get());
              paramBoolean = bool;
            }
          }
        }
        else
        {
          paramBoolean = false;
        }
        if (!paramBoolean)
        {
          b();
          this.p.b(true);
          this.p.a(false, null, null);
        }
      }
    }
  }
  
  @NotNull
  private FrameLayout b(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextView(paramViewGroup.getContext());
    paramViewGroup.setTag("title");
    FrameLayout localFrameLayout = c(paramViewGroup);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramViewGroup.setLayoutParams(localLayoutParams);
    paramViewGroup.setTextSize(1, 16.0F);
    paramViewGroup.setMaxLines(1);
    paramViewGroup.setTextColor(Color.parseColor("#989eb4"));
    paramViewGroup.getPaint().setFakeBoldText(true);
    localLayoutParams.topMargin = ImmersiveUtils.dpToPx(10.0F);
    paramViewGroup.setText(HardCodeUtil.a(2131899741));
    return localFrameLayout;
  }
  
  public int a(int paramInt)
  {
    if (getItemViewType(paramInt) == 100000) {
      return 1;
    }
    return 2;
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
    if ((this.g) && ((i == 0) || (i == 1)))
    {
      paramRect.bottom = this.f;
      return;
    }
    paramRect.bottom = this.e;
  }
  
  public void a(Bundle paramBundle)
  {
    J().addOnScrollListener(new RelativeLiveFeedsAdapter.2(this));
  }
  
  public void a(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView)
  {
    this.p = paramFolderRecommendHeadItemView;
  }
  
  public void a(LoadInfo paramLoadInfo)
  {
    CertifiedAccountRead.GetSubscriptionReq localGetSubscriptionReq = new CertifiedAccountRead.GetSubscriptionReq();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!TextUtils.isEmpty(localQQAppInterface.getCurrentUin())) {
      localGetSubscriptionReq.uin.set(Long.valueOf(localQQAppInterface.getCurrentUin()).longValue());
    }
    localGetSubscriptionReq.page_id.set(2);
    if ((this.k != -1) && ((paramLoadInfo.c()) || (paramLoadInfo.d()))) {
      localGetSubscriptionReq.page_info.set("");
    } else if ((this.k != -1) && (paramLoadInfo.e())) {
      if (!TextUtils.isEmpty(D().i())) {
        localGetSubscriptionReq.page_info.set(D().i());
      } else {
        localGetSubscriptionReq.page_info.set("");
      }
    }
    PbProtocol.a("QQLive.GetSubscriptionData", localGetSubscriptionReq, CertifiedAccountRead.GetSubscriptionRsp.class, new RelativeLiveFeedsAdapter.1(this));
  }
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    super.a(paramString, paramShareData);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramShareData.a != null) && (paramShareData.b)) {
      y();
    }
  }
  
  public void a(List<CertifiedAccountRead.GetPortalRsp.RoomLstItem> paramList, CertifiedAccountRead.GetSubscriptionRsp.Bottom paramBottom, String paramString)
  {
    if (paramList == null) {
      return;
    }
    this.b = paramBottom;
    this.c = paramString;
    this.j.clear();
    int i = 0;
    for (;;)
    {
      int j = paramList.size();
      boolean bool = true;
      if (i >= j) {
        break;
      }
      paramBottom = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).room_lst.get();
      if ((paramBottom != null) && (paramBottom.size() != 0))
      {
        if ((i != 0) || (this.q != 0)) {
          bool = false;
        }
        this.j.add(new FeedsItemInfo(((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).tab_info.name.get(), null));
        j = 0;
        while (j < paramBottom.size())
        {
          this.j.add(new FeedsItemInfo(null, (CertifiedAccountRead.GetPortalRsp.RoomItem)paramBottom.get(j), bool));
          j += 1;
        }
      }
      i += 1;
    }
    d(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(boolean paramBoolean, List<CertifiedAccountRead.GetPortalRsp.RoomLstItem> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).room_lst.size() > 0) {
        return true;
      }
      i += 1;
    }
    return paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void b(List<CertifiedAccountRead.GetPortalRsp.RoomLstItem> paramList, CertifiedAccountRead.GetSubscriptionRsp.Bottom paramBottom, String paramString)
  {
    if (paramList == null) {
      return;
    }
    this.b = paramBottom;
    this.c = paramString;
    int i = 0;
    for (;;)
    {
      int j = paramList.size();
      boolean bool = true;
      if (i >= j) {
        break;
      }
      paramBottom = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).room_lst.get();
      if ((paramBottom != null) && (paramBottom.size() != 0))
      {
        if ((i != 0) || (this.q != 0)) {
          bool = false;
        }
        if ((this.j.size() > 0) && (i != 0)) {
          this.j.add(new FeedsItemInfo(((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).tab_info.name.get(), null));
        }
        j = 0;
        while (j < paramBottom.size())
        {
          this.j.add(new FeedsItemInfo(null, (CertifiedAccountRead.GetPortalRsp.RoomItem)paramBottom.get(j), bool));
          j += 1;
        }
      }
      i += 1;
    }
    d(true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
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
    this.k = paramInt;
  }
  
  public ArrayList<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      FeedsItemInfo localFeedsItemInfo = (FeedsItemInfo)localIterator.next();
      if (localFeedsItemInfo.b == null) {
        return localArrayList;
      }
      try
      {
        localArrayList.add(new String(localFeedsItemInfo.b.toByteArray(), "ISO8859_1"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return localArrayList;
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
  
  public int getItemCount()
  {
    if (!this.h) {
      return 4;
    }
    return this.j.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= this.j.size()) {
      return 100002;
    }
    if (((FeedsItemInfo)this.j.get(paramInt)).a != null) {
      return 100000;
    }
    if (((FeedsItemInfo)this.j.get(paramInt)).b != null) {
      return 100003;
    }
    return 100002;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.a = paramRecyclerView.getLayoutManager();
  }
  
  @SuppressLint({"WrongConstant"})
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.g) {
      i = paramInt - 1;
    }
    if (!ArrayUtils.isOutOfArrayIndex(i, N()))
    {
      FeedsItemInfo localFeedsItemInfo;
      if ((paramViewHolder instanceof RelativeLiveFeedsAdapter.RelativeFeedVH))
      {
        localFeedsItemInfo = (FeedsItemInfo)this.j.get(i);
        ((RelativeLiveFeedsAdapter.RelativeFeedVH)paramViewHolder).a(localFeedsItemInfo.a);
      }
      if ((paramViewHolder instanceof RelativeLiveFeedsAdapter.RelativeLiveVH))
      {
        localFeedsItemInfo = (FeedsItemInfo)this.j.get(i);
        RelativeLiveFeedsAdapter.RelativeLiveVH localRelativeLiveVH = (RelativeLiveFeedsAdapter.RelativeLiveVH)paramViewHolder;
        localRelativeLiveVH.a(localFeedsItemInfo);
        localRelativeLiveVH.a(localRelativeLiveVH, localFeedsItemInfo);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, i, getItemId(i));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new RelativeLiveFeedsAdapter.RelativeFeedVH(this, b(paramViewGroup));
    }
    if (paramInt == 100003) {
      return a(paramViewGroup);
    }
    return new RelativeLiveFeedsAdapter.RelativeFeedVH(this, new RelativeFeedItemView(paramViewGroup.getContext()));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */