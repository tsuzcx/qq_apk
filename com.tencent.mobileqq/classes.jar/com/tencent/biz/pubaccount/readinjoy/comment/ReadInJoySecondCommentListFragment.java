package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lkk;

public class ReadInJoySecondCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CommentInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo;
  private ReadInJoyCommentListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoySecondCommentListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter = new ReadInJoySecondCommentListAdapter(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPositionFromTop(0, 0, 500);
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  public void a(Bundle paramBundle, View.OnClickListener paramOnClickListener, ReadInJoyCommentListAdapter paramReadInJoyCommentListAdapter)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter = paramReadInJoyCommentListAdapter;
    setArguments(paramBundle);
  }
  
  public void a(CommentInfo paramCommentInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a(paramCommentInfo, paramBoolean);
    this.jdField_a_of_type_JavaLangString = paramCommentInfo.authorNickName;
    this.b = paramCommentInfo.commentId;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("回复 " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo = paramCommentInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a(paramArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.b();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, CommentInfo paramCommentInfo)
  {
    int j = 0;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a.getCommentList() == null)) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.d("ReadInJoySecondCommentListFragment", 1, "commentId is null or empty, can not updateFirstCommentInfo.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySecondCommentListFragment", 2, new Object[] { "updateFirstCommentInfo \n commentId = ", paramString1, "\n", "commentInfo = ", paramCommentInfo, "\n", "operationType = ", Integer.valueOf(paramInt), "\n" });
      }
      List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a.getCommentList();
      int i = 0;
      while (i < localList.size())
      {
        if (paramString1.equalsIgnoreCase(((CommentInfo)localList.get(i)).commentId))
        {
          switch (paramInt)
          {
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.notifyDataSetChanged();
            return;
            paramString1 = (CommentInfo)localList.get(i);
            paramString1.sub_comments_total += 1;
            if ((((CommentInfo)localList.get(i)).mCommentItemLists.size() < 3) && (paramCommentInfo != null))
            {
              ((CommentInfo)localList.get(i)).mCommentItemLists.add(paramCommentInfo);
              continue;
              if (((CommentInfo)localList.get(i)).sub_comments_total > 0)
              {
                paramString1 = (CommentInfo)localList.get(i);
                paramString1.sub_comments_total -= 1;
              }
              paramString1 = ((CommentInfo)localList.get(i)).mCommentItemLists;
              paramInt = j;
              while (paramInt < paramString1.size())
              {
                if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equalsIgnoreCase(((CommentInfo)paramString1.get(paramInt)).commentId)))
                {
                  paramString1.remove(paramInt);
                  break;
                }
                paramInt += 1;
              }
              ((CommentInfo)localList.get(i)).liked = true;
              continue;
              ((CommentInfo)localList.get(i)).liked = false;
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 117) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("arg_result_json");
      ReadInJoyCommentUtils.a((QQAppInterface)getActivity().getAppRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2, this.b, paramIntent, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a, this.jdField_a_of_type_Int, new lkk(this, paramIntent));
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 4;
    int k = 2;
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label184:
    long l;
    switch (paramView.getId())
    {
    default: 
    case 2131362850: 
    case 2131363479: 
    case 2131366945: 
      label356:
      label362:
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_AndroidViewView$OnClickListener == null);
          this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
        boolean bool;
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
        {
          i = 2;
          paramView = getActivity();
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo;
          localObject3 = getActivity().getString(2131438899) + this.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_Boolean) {
            break label356;
          }
          bool = true;
          ReadInJoyCommentUtils.a(paramView, (ArticleInfo)localObject1, (CommentInfo)localObject2, i, (String)localObject3, "", false, null, bool);
          paramView = (QQAppInterface)getActivity().getAppInterface();
          localObject1 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
          i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
          localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          if (!this.jdField_a_of_type_Boolean) {
            break label362;
          }
        }
        for (;;)
        {
          PublicAccountReportUtils.a(paramView, (String)localObject1, "0X8009019", "0X8009019", 0, 0, String.valueOf(l), String.valueOf(i), (String)localObject2, ReadInJoyCommentUtils.a((ArticleInfo)localObject3, k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.commentId), false);
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
          bool = false;
          break label184;
          k = 1;
        }
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo == null));
      j = 19;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        j = 20;
        i = 2;
      }
      break;
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.commentContent;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.authorUin;
      paramView = ReadInJoyUtils.a(new Intent(getActivity(), ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, paramView, Long.valueOf((String)localObject1).longValue(), 0, j);
      getActivity().startActivity(paramView);
      getActivity().overridePendingTransition(0, 0);
      paramView = (QQAppInterface)getActivity().getAppInterface();
      localObject1 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        PublicAccountReportUtils.a(paramView, (String)localObject1, "0X800901A", "0X800901A", 0, 0, String.valueOf(l), String.valueOf(i), (String)localObject2, ReadInJoyCommentUtils.a((ArticleInfo)localObject3, k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.commentId), false);
        return;
        if ((!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int))) {
          break label665;
        }
        j = 20;
        i = 9;
        break;
        k = 1;
      }
      c();
      return;
      label665:
      i = 4;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969638, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131362850).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363479).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363360).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)paramLayoutInflater.findViewById(2131366942));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367220));
    getArguments();
    paramViewGroup = paramLayoutInflater.findViewById(2131366945);
    paramViewGroup.setVisibility(0);
    paramViewGroup.setOnClickListener(this);
    b();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      super.onDestroy();
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment
 * JD-Core Version:    0.7.0.1
 */