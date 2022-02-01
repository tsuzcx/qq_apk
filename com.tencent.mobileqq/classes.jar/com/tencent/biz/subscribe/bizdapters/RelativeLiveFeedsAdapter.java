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
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private int jdField_a_of_type_Int = ImmersiveUtils.dpToPx(16.0F);
  CertifiedAccountRead.GetSubscriptionRsp.Bottom jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetSubscriptionRsp$Bottom;
  protected RecyclerView.LayoutManager a;
  private FolderRecommendTabFragment.FolderRecommendHeadItemView jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  String jdField_a_of_type_JavaLangString;
  private int b = ImmersiveUtils.dpToPx(13.0F);
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int f = -1;
  private int g = 99;
  
  public RelativeLiveFeedsAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private RecyclerView.ViewHolder a(ViewGroup paramViewGroup)
  {
    Object localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559762, paramViewGroup, false);
    paramViewGroup = new RelativeLiveFeedsAdapter.RelativeLiveVH(this, (View)localObject);
    this.jdField_d_of_type_Int = ((View)localObject).getResources().getDisplayMetrics().widthPixels;
    int i = (int)(this.jdField_d_of_type_Int * 0.5F - ViewUtils.b(8.5F));
    this.jdField_e_of_type_Int = (i - ViewUtils.b(7.0F));
    int j = this.jdField_e_of_type_Int;
    int k = ViewUtils.b(54.0F);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = i;
    ((RelativeLayout.LayoutParams)localObject).height = (k + j);
    localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_e_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_e_of_type_Int;
    return paramViewGroup;
  }
  
  @NotNull
  private FrameLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextView(paramViewGroup.getContext());
    paramViewGroup.setTag("title");
    FrameLayout localFrameLayout = a(paramViewGroup);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramViewGroup.setLayoutParams(localLayoutParams);
    paramViewGroup.setTextSize(1, 16.0F);
    paramViewGroup.setMaxLines(1);
    paramViewGroup.setTextColor(Color.parseColor("#989eb4"));
    paramViewGroup.getPaint().setFakeBoldText(true);
    localLayoutParams.topMargin = ImmersiveUtils.dpToPx(10.0F);
    paramViewGroup.setText(HardCodeUtil.a(2131701581));
    return localFrameLayout;
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if ((paramBoolean) && ((paramObject instanceof CertifiedAccountRead.GetSubscriptionRsp)))
      {
        QLog.d("RelativeFeedsAdapter", 2, "isSuccess:" + paramBoolean + " updateFeedsData:");
        Object localObject = (CertifiedAccountRead.GetSubscriptionRsp)paramObject;
        paramObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject).room_lst.get();
        CertifiedAccountRead.GetSubscriptionRsp.Bottom localBottom = (CertifiedAccountRead.GetSubscriptionRsp.Bottom)((CertifiedAccountRead.GetSubscriptionRsp)localObject).bottom.get();
        localObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject).page_info.get();
        a().b((String)localObject);
        if (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView == null) {
          break;
        }
        if ((paramObject != null) && (paramObject.size() > 0))
        {
          paramBoolean = a(false, paramObject);
          if (paramBoolean)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.b(false);
            a(paramObject, localBottom, (String)localObject);
            if (localBottom != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(true, localBottom.desc.get(), localBottom.jump_url.get());
            }
          }
        }
        while (!paramBoolean)
        {
          a();
          this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.b(true);
          this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(false, null, null);
          return;
          paramBoolean = false;
        }
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    if (getItemViewType(paramInt) == 100000) {
      return 1;
    }
    return 2;
  }
  
  public String a()
  {
    return "RELATIVE_ADAPTER_UNIQUE_KEY";
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      FeedsItemInfo localFeedsItemInfo;
      if (localIterator.hasNext())
      {
        localFeedsItemInfo = (FeedsItemInfo)localIterator.next();
        if (localFeedsItemInfo.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetPortalRsp$RoomItem != null) {}
      }
      else
      {
        return localArrayList;
      }
      try
      {
        localArrayList.add(new String(localFeedsItemInfo.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetPortalRsp$RoomItem.toByteArray(), "ISO8859_1"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt, String paramString3)
  {
    paramContext = new IliveJumpParams(paramContext, "subscription", paramString1, paramString2, false, paramArrayList, "", paramInt);
    paramContext.d = paramString3;
    IliveEntranceUtil.a(paramContext);
  }
  
  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    if ((this.jdField_c_of_type_Boolean) && ((i == 0) || (i == 1)))
    {
      paramRect.bottom = this.b;
      return;
    }
    paramRect.bottom = this.jdField_a_of_type_Int;
  }
  
  public void a(Bundle paramBundle)
  {
    a().addOnScrollListener(new RelativeLiveFeedsAdapter.2(this));
  }
  
  public void a(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = paramFolderRecommendHeadItemView;
  }
  
  public void a(LoadInfo paramLoadInfo)
  {
    CertifiedAccountRead.GetSubscriptionReq localGetSubscriptionReq = new CertifiedAccountRead.GetSubscriptionReq();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!TextUtils.isEmpty(localQQAppInterface.getCurrentUin())) {
      localGetSubscriptionReq.uin.set(Long.valueOf(localQQAppInterface.getCurrentUin()).longValue());
    }
    localGetSubscriptionReq.page_id.set(2);
    if ((this.jdField_c_of_type_Int != -1) && ((paramLoadInfo.c()) || (paramLoadInfo.d()))) {
      localGetSubscriptionReq.page_info.set("");
    }
    for (;;)
    {
      PbProtocol.a("QQLive.GetSubscriptionData", localGetSubscriptionReq, CertifiedAccountRead.GetSubscriptionRsp.class, new RelativeLiveFeedsAdapter.1(this));
      return;
      if ((this.jdField_c_of_type_Int != -1) && (paramLoadInfo.e())) {
        if (!TextUtils.isEmpty(a().b())) {
          localGetSubscriptionReq.page_info.set(a().b());
        } else {
          localGetSubscriptionReq.page_info.set("");
        }
      }
    }
  }
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    super.a(paramString, paramShareData);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramShareData.jdField_a_of_type_JavaLangObject != null) && (paramShareData.jdField_a_of_type_Boolean)) {
      o();
    }
  }
  
  public void a(List<CertifiedAccountRead.GetPortalRsp.RoomLstItem> paramList, CertifiedAccountRead.GetSubscriptionRsp.Bottom paramBottom, String paramString)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetSubscriptionRsp$Bottom = paramBottom;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < paramList.size())
    {
      paramBottom = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).room_lst.get();
      if ((paramBottom == null) || (paramBottom.size() == 0))
      {
        i += 1;
      }
      else
      {
        if ((i == 0) && (this.f == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(new FeedsItemInfo(((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).tab_info.name.get(), null));
          int j = 0;
          while (j < paramBottom.size())
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(new FeedsItemInfo(null, (CertifiedAccountRead.GetPortalRsp.RoomItem)paramBottom.get(j), bool));
            j += 1;
          }
          break;
        }
      }
    }
    d(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(boolean paramBoolean, List<CertifiedAccountRead.GetPortalRsp.RoomLstItem> paramList)
  {
    int i = 0;
    for (;;)
    {
      boolean bool = paramBoolean;
      if (i < paramList.size())
      {
        if (((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).room_lst.size() > 0) {
          bool = true;
        }
      }
      else {
        return bool;
      }
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(List<CertifiedAccountRead.GetPortalRsp.RoomLstItem> paramList, CertifiedAccountRead.GetSubscriptionRsp.Bottom paramBottom, String paramString)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetSubscriptionRsp$Bottom = paramBottom;
    this.jdField_a_of_type_JavaLangString = paramString;
    int i = 0;
    while (i < paramList.size())
    {
      paramBottom = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).room_lst.get();
      if ((paramBottom == null) || (paramBottom.size() == 0))
      {
        i += 1;
      }
      else
      {
        if ((i == 0) && (this.f == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (i != 0)) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new FeedsItemInfo(((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(i)).tab_info.name.get(), null));
          }
          int j = 0;
          while (j < paramBottom.size())
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(new FeedsItemInfo(null, (CertifiedAccountRead.GetPortalRsp.RoomItem)paramBottom.get(j), bool));
            j += 1;
          }
          break;
        }
      }
    }
    d(true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((a() != null) && (a() != null))
    {
      a().a(4);
      a().setRefreshing(false);
      if (!f()) {
        break label53;
      }
      a().a(paramBoolean, a().a());
    }
    label53:
    while ((a() == null) || (b() == null) || (b().size() != 0)) {
      return;
    }
    a().a(paramBoolean, false);
  }
  
  public int getItemCount()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return 4;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return 100002;
    }
    if (((FeedsItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString != null) {
      return 100000;
    }
    if (((FeedsItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetPortalRsp$RoomItem != null) {
      return 100003;
    }
    return 100002;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = paramRecyclerView.getLayoutManager();
  }
  
  @SuppressLint({"WrongConstant"})
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_c_of_type_Boolean) {
      i = paramInt - 1;
    }
    if (ArrayUtils.a(i, b())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, i, getItemId(i));
      return;
      FeedsItemInfo localFeedsItemInfo;
      if ((paramViewHolder instanceof RelativeLiveFeedsAdapter.RelativeFeedVH))
      {
        localFeedsItemInfo = (FeedsItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((RelativeLiveFeedsAdapter.RelativeFeedVH)paramViewHolder).a(localFeedsItemInfo.jdField_a_of_type_JavaLangString);
      }
      if ((paramViewHolder instanceof RelativeLiveFeedsAdapter.RelativeLiveVH))
      {
        localFeedsItemInfo = (FeedsItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((RelativeLiveFeedsAdapter.RelativeLiveVH)paramViewHolder).a(localFeedsItemInfo);
        ((RelativeLiveFeedsAdapter.RelativeLiveVH)paramViewHolder).a((RelativeLiveFeedsAdapter.RelativeLiveVH)paramViewHolder, localFeedsItemInfo);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new RelativeLiveFeedsAdapter.RelativeFeedVH(this, a(paramViewGroup));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */