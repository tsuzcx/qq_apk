package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import agej;
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
import anzj;
import bhlg;
import bhmq;
import bhnv;
import bhtq;
import blir;
import blji;
import bnrf;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import ocd;
import ozr;
import ozs;
import pfa;
import ppu;
import pra;
import qno;
import qnq;
import qns;
import qqa;
import qqb;
import qqc;
import qqd;
import qqe;
import qqf;
import qqg;
import qrc;
import qxt;
import qyl;
import qyn;
import qzb;
import qzd;
import sel;
import suo;

public class ComponentHeaderTopicRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = anzj.a(2131701221);
  private static final String jdField_b_of_type_JavaLangString = anzj.a(2131701244);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blir jdField_a_of_type_Blir;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  private ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  private qzd jdField_a_of_type_Qzd;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
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
      localBitmap = bhmq.b(paramBitmap, agej.a(3.0F, getResources()), paramBitmap.getWidth(), paramBitmap.getHeight());
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
    Object localObject = ozs.a();
    if (this.jdField_a_of_type_Qzd != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (paramBoolean) {
        pfa.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qzd.jdField_a_of_type_Int), true, "", new qqd(this), 3);
      }
    }
    else
    {
      return;
    }
    pfa.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qzd.jdField_a_of_type_Int), false, "", new qqe(this), 3);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Qno.a != null) && (this.jdField_a_of_type_Qno.a.a() != null) && (this.jdField_a_of_type_Qno.a.a().mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_Qno.a.a().mTopicRecommendFeedsInfo.a.size() > 0);
  }
  
  private void e()
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Qno.a.a();
      this.jdField_a_of_type_Qzd = ((qzd)this.jdField_a_of_type_Qno.a.a().mTopicRecommendFeedsInfo.a.get(0));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Qno.a.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    h();
    i();
    j();
    if (sel.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
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
      localSpannableStringBuilder.setSpan(new qqg(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, -3355444), 0, localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append(": ");
    localSpannableStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9))
    {
      String str = anzj.a(2131701167);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(str);
      qns localqns = new qns(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Qno);
      localqns.jdField_a_of_type_Int = 17;
      localSpannableStringBuilder.setSpan(localqns, localSpannableStringBuilder.length() - str.length(), localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(" ");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anzj.a(2131701204));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qqf(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
  }
  
  private void g()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null))
    {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "Some ugc info is null. ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo });
      return;
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.a;
    localSpannableStringBuilder.append(ozs.e(bhlg.b((QQAppInterface)ozs.a(), String.valueOf(l), true)));
    localSpannableStringBuilder.setSpan(new qnq(l, -3355444, this.jdField_a_of_type_Qno), 0, localSpannableStringBuilder.length(), 33);
    localSpannableStringBuilder.append(": ");
    if ((qno.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!sel.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      localSpannableStringBuilder.append(((qyn)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).e);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anzj.a(2131701170));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qqf(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
      return;
      qrc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView, this.jdField_a_of_type_Qno, localSpannableStringBuilder);
    }
  }
  
  private void h()
  {
    if (!b()) {}
    while ((this.jdField_a_of_type_Qno.a == null) || (this.jdField_a_of_type_Qno.a.a() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((ozs.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ozs.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTime > 0L) {
        localStringBuilder.append(ozr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendTime, true));
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      localStringBuilder.append(" ");
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString)) {
        break label158;
      }
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      return;
      localStringBuilder.append("刚刚");
      break;
      label158:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0) != null) {
        localStringBuilder.append(bnrf.a(((qzd)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b) + jdField_b_of_type_JavaLangString);
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
      localObject = new suo();
    }
    try
    {
      ((suo)localObject).jdField_a_of_type_JavaNetURL = new URL(this.jdField_a_of_type_Qzd.d);
      ((suo)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getWidth();
      ((suo)localObject).b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getHeight();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageForImageCollection((suo)localObject, new qqa(this));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Qzd != null)
    {
      if ((!ozs.b(this.jdField_a_of_type_Qno.a.a())) && (!ozs.e(this.jdField_a_of_type_Qno.a.a()))) {
        break label153;
      }
      if (this.jdField_a_of_type_Qzd.c != 1) {
        break label108;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131701186));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#bbbbbb"));
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    label108:
    while ((!ozs.c(this.jdField_a_of_type_Qno.a.a())) && (!ozs.f(this.jdField_a_of_type_Qno.a.a()))) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#07D0B0"));
        this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
      }
    }
    label153:
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderTopicRecommend", 2, "business url is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Qzd == null)) {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, " topicRecommendInfo: ", this.jdField_a_of_type_Qzd });
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl)) {
      return;
    }
    Object localObject = new Intent(getContext(), PublicAccountBrowser.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    getContext().startActivity((Intent)localObject);
    localObject = ozs.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str = ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_Qzd.jdField_a_of_type_Int + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ocd.a(null, (String)localObject, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), str, false);
    sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Qno.a.e());
    ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Sel.a());
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().equals(anzj.a(2131701225)))
    {
      d();
      return;
    }
    a(true);
    String str1 = ozs.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str2 = ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), this.jdField_a_of_type_Qno.a.e(), bhnv.h(getContext()), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
    ocd.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
    sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Qno.a.e());
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560129, this, true);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131379217));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(agej.a(3.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363812));
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379219));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)paramView.findViewById(2131379216));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379218));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131379220));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof ppu)) {
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
      localLayoutParams.setMargins(bhtq.a(12.0F), 0, bhtq.a(15.0F), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      label62:
      localLayoutParams.setMargins(bhtq.a(12.0F), 0, bhtq.a(2.25F), 0);
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Blir = ((blir)blji.a(getContext(), null));
    this.jdField_a_of_type_Blir.a(2131694702, 3);
    this.jdField_a_of_type_Blir.c(2131690580);
    this.jdField_a_of_type_Blir.setOnDismissListener(new qqb(this));
    this.jdField_a_of_type_Blir.a(new qqc(this));
    if (!this.jdField_a_of_type_Blir.isShowing()) {
      this.jdField_a_of_type_Blir.show();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      l();
      continue;
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend
 * JD-Core Version:    0.7.0.1
 */