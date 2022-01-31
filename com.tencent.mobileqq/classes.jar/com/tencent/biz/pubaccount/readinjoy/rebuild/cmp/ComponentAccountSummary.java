package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class ComponentAccountSummary
  extends FrameLayout
  implements ComponentView
{
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public ComponentAccountSummary(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2130969583, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131367010));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    IReadInJoyModel localIReadInJoyModel;
    if ((paramObject instanceof IReadInJoyModel))
    {
      localIReadInJoyModel = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(localIReadInJoyModel);
      if (localIReadInJoyModel.a() != null) {}
    }
    else
    {
      return;
    }
    String str = localIReadInJoyModel.a().mSubscribeName;
    paramObject = localIReadInJoyModel.a().mSummary;
    if (TextUtils.isEmpty(paramObject)) {
      if (localIReadInJoyModel.a() == 33) {
        paramObject = "发布了话题";
      }
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject;
      if ((localIReadInJoyModel.a() == 33) && (localIReadInJoyModel.a().mSocialFeedInfo != null) && (localIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null)) {
        if (localIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b == 0L)
        {
          localObject = localIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a;
          label165:
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new ComponentAccountSummary.UserSpan(this, (String)localObject, -3355444), 0, str.length(), 33);
          label195:
          localSpannableStringBuilder.append(": ");
          localObject = localIReadInJoyModel.a();
          if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
            break label721;
          }
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a == null)) {
            break label702;
          }
          paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
          }
          label318:
          paramObject.append(" ");
          paramObject.append("阅读原文");
          paramObject.setSpan(new ComponentAccountSummary.ReadArticleSpan((ArticleInfo)localObject, -3355444, getContext(), getResources(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt), paramObject.length() - "阅读原文".length(), paramObject.length(), 33);
          paramObject.append(" ");
          localSpannableStringBuilder.append(paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.jdField_a_of_type_Boolean = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText("更多");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new ComponentAccountSummary.MoreSpan(this, localIReadInJoyModel.a(), -3355444));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
        b();
        return;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.b()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.d()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.e()))
        {
          paramObject = "发布了文章";
          break;
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.c()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.g()))
        {
          paramObject = "发布了视频";
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.h())
        {
          paramObject = "发布了图集";
          break;
        }
        paramObject = "发布了文章";
        break;
        localObject = String.valueOf(localIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b);
        if (ReadInJoyUtils.a())
        {
          str = ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), (String)localObject, true);
          break label165;
        }
        str = localIReadInJoyModel.a().b(localIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b);
        break label165;
        if (localIReadInJoyModel.a().mAccountLess == 0)
        {
          localObject = localIReadInJoyModel.a().mSubscribeID;
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new ComponentAccountSummary.UserSpan(this, (String)localObject, -3355444), 0, str.length(), 33);
          break label195;
        }
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, str.length(), 33);
        break label195;
        label702:
        if (((ArticleInfo)localObject).mTitle == null) {
          break label318;
        }
        paramObject.append(((ArticleInfo)localObject).mTitle);
        break label318;
        label721:
        if (this.c)
        {
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null))
          {
            paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a);
            }
          }
          for (;;)
          {
            localSpannableStringBuilder.append(paramObject);
            break;
            if (((ArticleInfo)localObject).mTitle != null) {
              paramObject.append(((ArticleInfo)localObject).mTitle);
            }
          }
        }
        localSpannableStringBuilder.append(paramObject);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */