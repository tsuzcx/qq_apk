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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;
import ljo;
import ljq;
import ljr;
import ljs;

public class ReadInJoyCommentListAdapter
  extends BaseAdapter
  implements View.OnClickListener, ReadInJoyCommentListView.RefreshCallback, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArticleCommentModule.FetchCommentObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$FetchCommentObserver = new ljr(this);
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
  
  private void a(ljs paramljs, int paramInt)
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
      paramljs.d.setText((CharSequence)localObject);
      label68:
      paramljs.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, localCommentInfo.authorUin, 1));
      if (TextUtils.isEmpty(localCommentInfo.authorNickName)) {
        break label594;
      }
      paramljs.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyUtils.d(localCommentInfo.authorNickName));
      label111:
      paramljs.jdField_a_of_type_AndroidWidgetTextView.setTag(localCommentInfo);
      paramljs.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localCommentInfo);
      if (TextUtils.isEmpty(localCommentInfo.authorComment)) {
        break label611;
      }
      localObject = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject).append("作者回复：");
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 0, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append(new QQText(MessageUtils.b(localCommentInfo.authorComment), 7, 16));
      paramljs.e.setText((CharSequence)localObject);
      paramljs.e.setVisibility(0);
      label220:
      if (localCommentInfo.mCommentItemLists.size() > 0)
      {
        paramljs.f.setVisibility(8);
        paramljs.g.setVisibility(8);
        paramInt = 0;
        label252:
        if ((paramInt < localCommentInfo.mCommentItemLists.size()) && (paramInt < 2)) {
          break label623;
        }
      }
      if ((!TextUtils.isEmpty(localCommentInfo.authorComment)) || (localCommentInfo.mCommentItemLists.size() != 0)) {
        break label843;
      }
      paramljs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      label301:
      if (localCommentInfo.sub_comments_total <= 0) {
        break label887;
      }
      if (localCommentInfo.sub_comments_total <= 999) {
        break label854;
      }
      paramljs.i.setText("999+回复");
      label327:
      paramljs.i.setTag(localCommentInfo);
      if (ReadInJoyHelper.v(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime()) != 0) {
        break label900;
      }
      paramljs.j.setVisibility(0);
      paramljs.j.setOnClickListener(this);
      paramljs.j.setTag(localCommentInfo);
      label372:
      if (!localCommentInfo.liked) {
        break label912;
      }
      paramljs.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840726);
      paramljs.c.setTextColor(Color.parseColor("#07D0B0"));
      label401:
      if (localCommentInfo.likeCount <= 999) {
        break label938;
      }
      paramljs.c.setText("999+");
      label421:
      paramljs.c.setTag(2131362471, localCommentInfo);
      paramljs.c.setTag(2131362472, paramljs);
      paramljs.jdField_b_of_type_AndroidWidgetImageView.setTag(2131362471, localCommentInfo);
      paramljs.jdField_b_of_type_AndroidWidgetImageView.setTag(2131362472, paramljs);
      paramljs.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131362471, localCommentInfo);
      paramljs.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131362472, paramljs);
      paramljs.h.setText(ReadInJoyTimeUtils.a(localCommentInfo.commentTime, true));
      if (!localCommentInfo.commentByMyself) {
        break label975;
      }
      paramljs.k.setVisibility(0);
      paramljs.i.setVisibility(8);
      paramljs.k.setOnClickListener(this);
      paramljs.k.setTag(localCommentInfo);
      label542:
      if (localCommentInfo.rank != 0) {
        break label995;
      }
      paramljs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (localCommentInfo.author_selection != 1) {
        break label1007;
      }
      paramljs.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (localCommentInfo.gift_list != null) {
        break label68;
      }
      paramljs.d.setText("发布了图片");
      break label68;
      label594:
      paramljs.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyUtils.d(localCommentInfo.authorUin));
      break label111;
      label611:
      paramljs.e.setVisibility(8);
      break label220;
      label623:
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
        paramljs.f.setText(localSpannableStringBuilder);
        paramljs.f.setVisibility(0);
      }
      if (paramInt == 1)
      {
        paramljs.g.setText(localSpannableStringBuilder);
        paramljs.g.setVisibility(0);
      }
      paramInt += 1;
      break label252;
      label843:
      paramljs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label301;
      label854:
      paramljs.i.setText(localCommentInfo.sub_comments_total + "回复");
      break label327;
      label887:
      paramljs.i.setText("回复");
      break label327;
      label900:
      paramljs.j.setVisibility(8);
      break label372;
      label912:
      paramljs.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840725);
      paramljs.c.setTextColor(Color.parseColor("#9D9D9D"));
      break label401;
      label938:
      if (localCommentInfo.likeCount < 0)
      {
        paramljs.c.setText("0");
        break label421;
      }
      paramljs.c.setText(String.valueOf(localCommentInfo.likeCount));
      break label421;
      label975:
      paramljs.k.setVisibility(8);
      paramljs.i.setVisibility(0);
      break label542;
      label995:
      paramljs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label1007:
    paramljs.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.setCommentObsrver(new ljq(this));
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
        paramView.setTag(2131362473, Integer.valueOf(paramInt));
        paramViewGroup.i.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(this);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramViewGroup.c.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      }
      return paramView;
      paramViewGroup = (ljs)paramView.getTag();
      continue;
      switch (i)
      {
      default: 
        paramViewGroup = localObject;
        break;
      case 1: 
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969556, paramViewGroup, false);
        paramViewGroup = new ljs(this);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131366949));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366951));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366952));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366953));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#28FF8444"));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366956));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131366955));
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366954));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131366957));
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366958));
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramViewGroup.e = ((TextView)paramView.findViewById(2131366959));
        paramViewGroup.f = ((TextView)paramView.findViewById(2131366960));
        paramViewGroup.g = ((TextView)paramView.findViewById(2131366961));
        paramViewGroup.h = ((TextView)paramView.findViewById(2131366963));
        paramViewGroup.i = ((TextView)paramView.findViewById(2131366964));
        paramViewGroup.j = ((TextView)paramView.findViewById(2131366965));
        paramViewGroup.k = ((TextView)paramView.findViewById(2131366966));
        paramView.setTag(paramViewGroup);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131366950: 
    case 2131366952: 
    case 2131366953: 
    case 2131366957: 
    case 2131366958: 
    case 2131366959: 
    case 2131366960: 
    case 2131366961: 
    case 2131366962: 
    case 2131366963: 
    default: 
      if (paramView.getTag() != null)
      {
        i = ((Integer)paramView.getTag(2131362473)).intValue();
        paramView = (CommentInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().get(i);
        if ((paramView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
          break label1254;
        }
      }
      break;
    }
    label361:
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
                          break label575;
                        }
                        paramView = "";
                        paramView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131438899) + paramView;
                        localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
                        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                        if (this.jdField_a_of_type_Boolean) {
                          break label584;
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
                          break label590;
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
                        break label361;
                        bool = false;
                        break label411;
                      }
                    } while ((paramView.getTag() == null) || (!(paramView.getTag() instanceof CommentInfo)));
                    paramView = (CommentInfo)paramView.getTag();
                  } while (paramView == null);
                  localObject1 = ActionSheet.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
                  ((ActionSheet)localObject1).a(2131438857);
                  ((ActionSheet)localObject1).a(2131438856, 3);
                  ((ActionSheet)localObject1).c(2131432998);
                  if (!((ActionSheet)localObject1).isShowing()) {
                    ((ActionSheet)localObject1).show();
                  }
                  ((ActionSheet)localObject1).a(new ljo(this, paramView, (ActionSheet)localObject1));
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
            break label1158;
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
      } while (paramView.getTag(2131362471) == null);
      localObject1 = (CommentInfo)paramView.getTag(2131362471);
      paramView = (ljs)paramView.getTag(2131362472);
    } while ((localObject1 == null) || (paramView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null));
    label411:
    label575:
    label584:
    label590:
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule, (CommentInfo)localObject1, paramView.jdField_b_of_type_AndroidWidgetImageView, paramView.c, 1, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Boolean, ((CommentInfo)localObject1).authorUin, this.c, null);
    label1158:
    return;
    label1254:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(false, paramView);
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
      if ((paramString != null) && (paramString.getTag() != null) && ((paramString.getTag() instanceof ljs)))
      {
        paramString = (ljs)paramString.getTag();
        if (paramString == null) {}
      }
      try
      {
        if ((paramString.jdField_a_of_type_ComTencentWidgetFixSizeImageView.getTag() != null) && ((paramString.jdField_a_of_type_ComTencentWidgetFixSizeImageView.getTag() instanceof CommentInfo)))
        {
          paramBitmap = (CommentInfo)paramString.jdField_a_of_type_ComTencentWidgetFixSizeImageView.getTag();
          paramString.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, paramBitmap.authorUin, 1));
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