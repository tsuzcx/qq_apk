package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import lvx;
import lvy;
import lvz;
import lwa;
import lwc;
import mqq.app.AppRuntime;

public class ComponentHeaderTopicRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private TopicRecommendFeedsInfo.TopicRecommendInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo;
  private KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  private ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private TextView b;
  
  public ComponentHeaderTopicRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderTopicRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(Bitmap paramBitmap)
  {
    try
    {
      localBitmap = ImageUtil.b(paramBitmap, AIOUtils.a(3.0F, getResources()), paramBitmap.getWidth(), paramBitmap.getHeight());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageBitmap(localBitmap);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Bitmap localBitmap = paramBitmap;
        if (QLog.isColorLevel())
        {
          QLog.d("ComponentHeaderTopicRecommend", 2, QLog.getStackTraceString(localOutOfMemoryError));
          localBitmap = paramBitmap;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (paramBoolean) {
        ReadInJoyLogicEngine.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.jdField_a_of_type_Int), true, new lwa(this), 3);
      }
    }
    else
    {
      return;
    }
    ReadInJoyLogicEngine.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.jdField_a_of_type_Int), false, new lwc(this), 3);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mTopicRecommendFeedsInfo.a.size() > 0);
  }
  
  private void e()
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mTopicRecommendFeedsInfo.a.get(0));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    h();
    i();
    j();
    if (ReadInJoyBaseAdapter.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      g();
      return;
    }
    f();
  }
  
  private void f()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderTopicRecommend", 2, "less =" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAccountLess + " title = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAccountLess == 0) {
      localSpannableStringBuilder.setSpan(new ComponentHeaderTopicRecommend.SubscribeClickSpan(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, -3355444), 0, localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append(": ");
    localSpannableStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9))
    {
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append("阅读原文");
      ComponentAccountSummary.ReadArticleSpan localReadArticleSpan = new ComponentAccountSummary.ReadArticleSpan(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt);
      localReadArticleSpan.jdField_a_of_type_Int = 17;
      localSpannableStringBuilder.setSpan(localReadArticleSpan, localSpannableStringBuilder.length() - "阅读原文".length(), localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(" ");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText("阅读原文");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new ComponentHeaderTopicRecommend.MoreSpan(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
  }
  
  private void g()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null))
    {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "Some ugc info is null. ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo });
      return;
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a;
    localSpannableStringBuilder.append(ReadInJoyUtils.e(ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l), true)));
    localSpannableStringBuilder.setSpan(new CommonBasicComponent.UserSpan(l, -3355444, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt), 0, localSpannableStringBuilder.length(), 33);
    localSpannableStringBuilder.append(": ");
    if ((CmpCtxt.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      localSpannableStringBuilder.append(((SocializeFeedsInfo.UGCVideoInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).e);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText("更多");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new ComponentHeaderTopicRecommend.MoreSpan(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
      return;
      UtilsForComponent.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt, localSpannableStringBuilder);
    }
  }
  
  private void h()
  {
    if (!b()) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((ReadInJoyUtils.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ReadInJoyUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTime > 0L) {
        localStringBuilder.append(ReadInJoyTimeUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendTime, true));
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      localStringBuilder.append(" ");
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.b)) {
        break label157;
      }
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.b);
    }
    for (;;)
    {
      this.b.setText(localStringBuilder);
      return;
      localStringBuilder.append("刚刚");
      break;
      label157:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0) != null) {
        localStringBuilder.append(ReadInJoyHelper.a(((TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b) + "人参与");
      }
    }
  }
  
  private void i()
  {
    Object localObject;
    if (b())
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessName;
      String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessNamePrefix;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str + (String)localObject);
      localObject = new ImageRequest();
    }
    try
    {
      ((ImageRequest)localObject).jdField_a_of_type_JavaNetURL = new URL(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.d);
      ((ImageRequest)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getWidth();
      ((ImageRequest)localObject).b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getHeight();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.a((ImageRequest)localObject, new lvx(this));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo != null)
    {
      if ((!ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a())) && (!ReadInJoyUtils.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()))) {
        break label150;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.c != 1) {
        break label105;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText("已关注");
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#bbbbbb"));
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    label105:
    while ((!ReadInJoyUtils.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a())) && (!ReadInJoyUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()))) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText("关注");
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#07D0B0"));
        this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
      }
    }
    label150:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderTopicRecommend", 2, "business url is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo == null)) {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, " topicRecommendInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo });
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl)) {
      return;
    }
    Object localObject = new Intent(getContext(), PublicAccountBrowser.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    getContext().startActivity((Intent)localObject);
    localObject = ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str = ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.jdField_a_of_type_Int + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    PublicAccountReportUtils.a(null, (String)localObject, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), str, false);
    ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a());
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().equals("已关注"))
    {
      d();
      return;
    }
    a(true);
    String str1 = ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str2 = ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e(), NetworkUtil.h(getContext()), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
    PublicAccountReportUtils.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
    ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969583, this, true);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131367045));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(AIOUtils.a(3.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131367027));
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367046));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)paramView.findViewById(2131367048));
    this.b = ((TextView)paramView.findViewById(2131367047));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367044));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      e();
    }
  }
  
  public void b()
  {
    super.b();
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (!a()) {
        break label62;
      }
      localLayoutParams.setMargins(ViewUtils.a(12.0F), 0, ViewUtils.a(15.0F), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      label62:
      localLayoutParams.setMargins(ViewUtils.a(12.0F), 0, ViewUtils.a(2.25F), 0);
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(getContext(), null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131430019, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new lvy(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new lvz(this));
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367027: 
      l();
      return;
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend
 * JD-Core Version:    0.7.0.1
 */