package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;
import llx;
import llz;
import lma;
import lmb;

public class ReadInJoyCommentListAdapter
  extends BaseAdapter
  implements View.OnClickListener, ReadInJoyCommentListView.RefreshCallback, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArticleCommentModule.FetchCommentObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$FetchCommentObserver = new lma(this);
  public ArticleCommentModule a;
  ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private boolean jdField_a_of_type_Boolean;
  private final int b = 1;
  private int c;
  
  public ReadInJoyCommentListAdapter(FragmentActivity paramFragmentActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.c = 1;
      return;
    }
    this.c = 2;
  }
  
  private void a(lmb paramlmb, int paramInt)
  {
    CommentInfo localCommentInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule != null)
    {
      localCommentInfo = (CommentInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().get(paramInt);
      if (localCommentInfo != null) {}
    }
    else
    {
      return;
    }
    Object localObject;
    if (!TextUtils.isEmpty(localCommentInfo.commentContent))
    {
      localObject = new QQText(MessageUtils.b(localCommentInfo.commentContent), 7, 16);
      paramlmb.c.setText((CharSequence)localObject);
      label68:
      paramlmb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(localCommentInfo.authorUin);
      if (TextUtils.isEmpty(localCommentInfo.authorNickName)) {
        break label586;
      }
      paramlmb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(ReadInJoyUtils.e(localCommentInfo.authorNickName));
      label103:
      paramlmb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setTag(localCommentInfo);
      paramlmb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(localCommentInfo);
      if (TextUtils.isEmpty(localCommentInfo.authorComment)) {
        break label601;
      }
      localObject = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject).append("作者回复：");
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 0, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append(new QQText(MessageUtils.b(localCommentInfo.authorComment), 7, 16));
      paramlmb.d.setText((CharSequence)localObject);
      paramlmb.d.setVisibility(0);
      label212:
      if (localCommentInfo.mCommentItemLists.size() > 0)
      {
        paramlmb.e.setVisibility(8);
        paramlmb.f.setVisibility(8);
        paramInt = 0;
        label244:
        if ((paramInt < localCommentInfo.mCommentItemLists.size()) && (paramInt < 2)) {
          break label613;
        }
      }
      if ((!TextUtils.isEmpty(localCommentInfo.authorComment)) || (localCommentInfo.mCommentItemLists.size() != 0)) {
        break label833;
      }
      paramlmb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      label293:
      if (localCommentInfo.sub_comments_total <= 0) {
        break label877;
      }
      if (localCommentInfo.sub_comments_total <= 999) {
        break label844;
      }
      paramlmb.h.setText("999+回复");
      label319:
      paramlmb.h.setTag(localCommentInfo);
      if (ReadInJoyHelper.w(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime()) != 0) {
        break label890;
      }
      paramlmb.i.setVisibility(0);
      paramlmb.i.setOnClickListener(this);
      paramlmb.i.setTag(localCommentInfo);
      label364:
      if (!localCommentInfo.liked) {
        break label902;
      }
      paramlmb.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840767);
      paramlmb.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#07D0B0"));
      label393:
      if (localCommentInfo.likeCount <= 999) {
        break label928;
      }
      paramlmb.jdField_b_of_type_AndroidWidgetTextView.setText("999+");
      label413:
      paramlmb.jdField_b_of_type_AndroidWidgetTextView.setTag(2131362478, localCommentInfo);
      paramlmb.jdField_b_of_type_AndroidWidgetTextView.setTag(2131362479, paramlmb);
      paramlmb.jdField_b_of_type_AndroidWidgetImageView.setTag(2131362478, localCommentInfo);
      paramlmb.jdField_b_of_type_AndroidWidgetImageView.setTag(2131362479, paramlmb);
      paramlmb.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131362478, localCommentInfo);
      paramlmb.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131362479, paramlmb);
      paramlmb.g.setText(ReadInJoyTimeUtils.a(localCommentInfo.commentTime, true));
      if (!localCommentInfo.commentByMyself) {
        break label965;
      }
      paramlmb.j.setVisibility(0);
      paramlmb.h.setVisibility(8);
      paramlmb.j.setOnClickListener(this);
      paramlmb.j.setTag(localCommentInfo);
      label534:
      if (localCommentInfo.rank != 0) {
        break label985;
      }
      paramlmb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (localCommentInfo.author_selection != 1) {
        break label997;
      }
      paramlmb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (localCommentInfo.gift_list != null) {
        break label68;
      }
      paramlmb.c.setText("发布了图片");
      break label68;
      label586:
      paramlmb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(localCommentInfo.authorUin, true);
      break label103;
      label601:
      paramlmb.d.setVisibility(8);
      break label212;
      label613:
      localObject = (CommentInfo)localCommentInfo.mCommentItemLists.get(paramInt);
      if (localObject == null) {
        break;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(((CommentInfo)localObject).authorNickName))
      {
        localSpannableStringBuilder.append(((CommentInfo)localObject).authorNickName);
        localSpannableStringBuilder.append("：");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), 0, localSpannableStringBuilder.length(), 33);
      }
      if ((((CommentInfo)localObject).hasTarget) && (!TextUtils.isEmpty(((CommentInfo)localObject).toNickName)))
      {
        localSpannableStringBuilder.append("回复 ");
        localSpannableStringBuilder.append(((CommentInfo)localObject).toNickName);
        localSpannableStringBuilder.append("：");
      }
      if (!TextUtils.isEmpty(((CommentInfo)localObject).commentContent)) {
        localSpannableStringBuilder.append(new QQText(MessageUtils.b(((CommentInfo)localObject).commentContent), 7, 16));
      }
      if (paramInt == 0)
      {
        paramlmb.e.setText(localSpannableStringBuilder);
        paramlmb.e.setVisibility(0);
      }
      if (paramInt == 1)
      {
        paramlmb.f.setText(localSpannableStringBuilder);
        paramlmb.f.setVisibility(0);
      }
      paramInt += 1;
      break label244;
      label833:
      paramlmb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label293;
      label844:
      paramlmb.h.setText(localCommentInfo.sub_comments_total + "回复");
      break label319;
      label877:
      paramlmb.h.setText("回复");
      break label319;
      label890:
      paramlmb.i.setVisibility(8);
      break label364;
      label902:
      paramlmb.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840766);
      paramlmb.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#9D9D9D"));
      break label393;
      label928:
      if (localCommentInfo.likeCount < 0)
      {
        paramlmb.jdField_b_of_type_AndroidWidgetTextView.setText("0");
        break label413;
      }
      paramlmb.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localCommentInfo.likeCount));
      break label413;
      label965:
      paramlmb.j.setVisibility(8);
      paramlmb.h.setVisibility(0);
      break label534;
      label985:
      paramlmb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label997:
    paramlmb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    int i = 1;
    if ((paramArticleInfo == null) || (paramArticleInfo != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule = null;
      notifyDataSetChanged();
    }
    if (paramArticleInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule = new ArticleCommentModule(paramArticleInfo, 1, null, System.currentTimeMillis() + "");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.fetchNextCommentInfo((QQAppInterface)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime(), this.c);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.setCommentObsrver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$FetchCommentObserver);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str1 = ReadInJoyCommentUtils.a(paramArticleInfo);
      long l = paramArticleInfo.mArticleID;
      int j = paramArticleInfo.mStrategyId;
      String str2 = paramArticleInfo.innerUniqueID;
      if (this.jdField_a_of_type_Boolean) {
        i = 2;
      }
      PublicAccountReportUtils.a(localQQAppInterface, str1, "0X800901E", "0X800901E", 0, 0, String.valueOf(l), String.valueOf(j), str2, ReadInJoyCommentUtils.a(paramArticleInfo, i, ""), false);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(ListView paramListView)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.hasNextPage())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.hasNextPage());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.fetchNextCommentInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.setCommentObsrver(new llz(this));
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject = null;
    if (paramView != null) {
      switch (i)
      {
      default: 
        paramViewGroup = localObject;
      }
    }
    for (;;)
    {
      if (paramViewGroup != null) {
        a(paramViewGroup, paramInt);
      }
      if (paramViewGroup != null)
      {
        paramView.setOnClickListener(this);
        paramView.setTag(2131362480, Integer.valueOf(paramInt));
        paramViewGroup.h.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      }
      return paramView;
      paramViewGroup = (lmb)paramView.getTag();
      continue;
      switch (i)
      {
      default: 
        paramViewGroup = localObject;
        break;
      case 1: 
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969559, paramViewGroup, false);
        paramViewGroup = new lmb(this);
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131366989));
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131366991));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366992));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366993));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#28FF8444"));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366996));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366995));
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366994));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131366997));
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366998));
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramViewGroup.d = ((TextView)paramView.findViewById(2131366999));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131367000));
        paramViewGroup.f = ((TextView)paramView.findViewById(2131367001));
        paramViewGroup.g = ((TextView)paramView.findViewById(2131367003));
        paramViewGroup.h = ((TextView)paramView.findViewById(2131367004));
        paramViewGroup.i = ((TextView)paramView.findViewById(2131367005));
        paramViewGroup.j = ((TextView)paramView.findViewById(2131367006));
        paramView.setTag(paramViewGroup);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131366990: 
    case 2131366992: 
    case 2131366993: 
    case 2131366997: 
    case 2131366998: 
    case 2131366999: 
    case 2131367000: 
    case 2131367001: 
    case 2131367002: 
    case 2131367003: 
    default: 
      if (paramView.getTag() != null)
      {
        i = ((Integer)paramView.getTag(2131362480)).intValue();
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList();
        if ((paramView != null) && (paramView.size() > i)) {
          break label1248;
        }
      }
      break;
    }
    label355:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                            } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof CommentInfo)));
                            localObject1 = (CommentInfo)paramView.getTag();
                          } while (localObject1 == null);
                          if (((CommentInfo)localObject1).sub_comments_total > 0)
                          {
                            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(false, (CommentInfo)localObject1);
                            paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                            localObject2 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
                            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
                            j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
                            localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
                            localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                            if (this.jdField_a_of_type_Boolean) {}
                            for (i = 2;; i = 1)
                            {
                              PublicAccountReportUtils.a(paramView, (String)localObject2, "0X8009010", "0X8009010", 0, 0, String.valueOf(l1), String.valueOf(j), (String)localObject3, ReadInJoyCommentUtils.a(localArticleInfo, i, ((CommentInfo)localObject1).commentId, 0), false);
                              return;
                            }
                          }
                          j = 4;
                        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
                        boolean bool;
                        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
                        {
                          i = 2;
                          if (!TextUtils.isEmpty(((CommentInfo)localObject1).authorNickName)) {
                            break label569;
                          }
                          paramView = "";
                          paramView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131438951) + paramView;
                          localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
                          localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                          if (this.jdField_a_of_type_Boolean) {
                            break label578;
                          }
                          bool = true;
                          ReadInJoyCommentUtils.a((Activity)localObject2, (ArticleInfo)localObject3, (CommentInfo)localObject1, i, paramView, null, true, null, bool);
                          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                          localObject2 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
                          l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
                          j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
                          localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
                          localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                          if (!this.jdField_a_of_type_Boolean) {
                            break label584;
                          }
                        }
                        for (i = 2;; i = 1)
                        {
                          PublicAccountReportUtils.a(paramView, (String)localObject2, "0X8009010", "0X8009010", 0, 0, String.valueOf(l1), String.valueOf(j), (String)localObject3, ReadInJoyCommentUtils.a(localArticleInfo, i, ((CommentInfo)localObject1).commentId, 1), false);
                          return;
                          i = j;
                          if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
                            break;
                          }
                          i = j;
                          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
                            break;
                          }
                          i = j;
                          if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
                            break;
                          }
                          i = 9;
                          break;
                          paramView = ((CommentInfo)localObject1).authorNickName;
                          break label355;
                          bool = false;
                          break label405;
                        }
                      } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof CommentInfo)));
                      paramView = (CommentInfo)paramView.getTag();
                    } while (paramView == null);
                    localObject1 = ActionSheet.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
                    ((ActionSheet)localObject1).a(2131438899);
                    ((ActionSheet)localObject1).a(2131438898, 3);
                    ((ActionSheet)localObject1).c(2131433029);
                    if (!((ActionSheet)localObject1).isShowing()) {
                      ((ActionSheet)localObject1).show();
                    }
                    ((ActionSheet)localObject1).a(new llx(this, paramView, (ActionSheet)localObject1));
                    return;
                  } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof CommentInfo)));
                  paramView = (CommentInfo)paramView.getTag();
                } while (paramView == null);
                ReadInJoyCommentUtils.a(paramView.authorUin, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
              } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
              l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
              long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
              localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
              localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
              if (this.jdField_a_of_type_Boolean) {}
              for (i = 2;; i = 1)
              {
                PublicAccountReportUtils.a((QQAppInterface)localObject1, (String)localObject2, "0X800900D", "0X800900D", 0, 0, String.valueOf(l1), String.valueOf(l2), (String)localObject3, ReadInJoyCommentUtils.a(localArticleInfo, i, paramView.commentId), false);
                return;
              }
            } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof CommentInfo)));
            paramView = (CommentInfo)paramView.getTag();
          } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (paramView == null));
          int k = 4;
          int m = 19;
          if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
          {
            i = 2;
            j = 20;
            localObject1 = paramView.commentContent;
            localObject2 = paramView.authorUin;
            localObject1 = ReadInJoyUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, (String)localObject1, Long.valueOf((String)localObject2).longValue(), 0, j);
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject2 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
            j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
            localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
            localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
            if (!this.jdField_a_of_type_Boolean) {
              break label1152;
            }
          }
          for (i = 2;; i = 1)
          {
            PublicAccountReportUtils.a((QQAppInterface)localObject1, (String)localObject2, "0X8009011", "0X8009011", 0, 0, String.valueOf(l1), String.valueOf(j), (String)localObject3, ReadInJoyCommentUtils.a(localArticleInfo, i, paramView.commentId), false);
            return;
            i = k;
            j = m;
            if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
              break;
            }
            i = k;
            j = m;
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
              break;
            }
            i = k;
            j = m;
            if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
              break;
            }
            i = 9;
            j = 20;
            break;
          }
        } while (paramView.getTag(2131362478) == null);
        localObject1 = (CommentInfo)paramView.getTag(2131362478);
        paramView = (lmb)paramView.getTag(2131362479);
      } while ((localObject1 == null) || (paramView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null));
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule, (CommentInfo)localObject1, paramView.jdField_b_of_type_AndroidWidgetImageView, paramView.jdField_b_of_type_AndroidWidgetTextView, 1, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Boolean, ((CommentInfo)localObject1).authorUin, this.c, null);
      return;
      paramView = (CommentInfo)paramView.get(i);
    } while ((paramView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null));
    label405:
    label569:
    label578:
    label584:
    label1248:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(false, paramView);
    label1152:
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject2 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
    Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      PublicAccountReportUtils.a((QQAppInterface)localObject1, (String)localObject2, "0X8009012", "0X8009012", 0, 0, String.valueOf(l1), String.valueOf(j), (String)localObject3, ReadInJoyCommentUtils.a(localArticleInfo, i, paramView.commentId), false);
      return;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1);
      if ((paramString != null) && (paramString.getTag() != null) && ((paramString.getTag() instanceof lmb)))
      {
        paramString = (lmb)paramString.getTag();
        if (paramString == null) {}
      }
      try
      {
        if ((paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getTag() != null) && ((paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getTag() instanceof CommentInfo)))
        {
          paramBitmap = (CommentInfo)paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getTag();
          paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, paramBitmap.authorUin, 1));
        }
        paramInt1 += 1;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter
 * JD-Core Version:    0.7.0.1
 */