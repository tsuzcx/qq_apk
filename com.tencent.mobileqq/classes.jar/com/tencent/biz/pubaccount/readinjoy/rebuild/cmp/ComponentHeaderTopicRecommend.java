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
import anvx;
import bheg;
import bkzi;
import bkzz;
import bmhv;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import olh;
import pkg;
import pkh;
import ppe;
import pqb;
import pqf;
import pqw;
import prg;
import pvj;
import qfw;
import qia;
import rfw;
import rfy;
import rga;
import rii;
import rij;
import rik;
import ril;
import rim;
import rin;
import rio;
import rjl;
import rqy;
import rrq;
import rrs;
import rsh;
import rsj;
import szd;
import tlw;

public class ComponentHeaderTopicRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = anvx.a(2131701807);
  private static final String jdField_b_of_type_JavaLangString = anvx.a(2131701830);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkzi jdField_a_of_type_Bkzi;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  private ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  private rsj jdField_a_of_type_Rsj;
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
      localBitmap = bheg.b(paramBitmap, AIOUtils.dp2px(3.0F, getResources()), paramBitmap.getWidth(), paramBitmap.getHeight());
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
    Object localObject = pkh.a();
    if (this.jdField_a_of_type_Rsj != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (paramBoolean) {
        pvj.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Rsj.jdField_a_of_type_Int), true, "", new ril(this), 3);
      }
    }
    else
    {
      return;
    }
    pvj.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Rsj.jdField_a_of_type_Int), false, "", new rim(this), 3);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Rfw.a != null) && (this.jdField_a_of_type_Rfw.a.a() != null) && (this.jdField_a_of_type_Rfw.a.a().mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_Rfw.a.a().mTopicRecommendFeedsInfo.a.size() > 0);
  }
  
  private void e()
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Rfw.a.a();
      this.jdField_a_of_type_Rsj = ((rsj)this.jdField_a_of_type_Rfw.a.a().mTopicRecommendFeedsInfo.a.get(0));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Rfw.a.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    h();
    i();
    j();
    if (ppe.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
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
      localSpannableStringBuilder.setSpan(new rio(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, -3355444), 0, localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append(": ");
    localSpannableStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9))
    {
      String str = anvx.a(2131701753);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(str);
      rga localrga = new rga(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Rfw);
      localrga.jdField_a_of_type_Int = 17;
      localSpannableStringBuilder.setSpan(localrga, localSpannableStringBuilder.length() - str.length(), localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(" ");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anvx.a(2131701790));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new rin(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
  }
  
  private void g()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null))
    {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "Some ugc info is null. ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo });
      return;
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.a;
    localSpannableStringBuilder.append(prg.a(ContactUtils.getBuddyName((QQAppInterface)pkh.a(), String.valueOf(l), true)));
    localSpannableStringBuilder.setSpan(new rfy(l, -3355444, this.jdField_a_of_type_Rfw), 0, localSpannableStringBuilder.length(), 33);
    localSpannableStringBuilder.append(": ");
    if ((rfw.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ppe.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      localSpannableStringBuilder.append(((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).e);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anvx.a(2131701756));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new rin(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
      return;
      rjl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView, this.jdField_a_of_type_Rfw, localSpannableStringBuilder);
    }
  }
  
  private void h()
  {
    if (!b()) {}
    while ((this.jdField_a_of_type_Rfw.a == null) || (this.jdField_a_of_type_Rfw.a.a() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((pqw.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (pqw.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTime > 0L) {
        localStringBuilder.append(pkg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendTime, true));
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
        localStringBuilder.append(bmhv.a(((rsj)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b) + jdField_b_of_type_JavaLangString);
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
      localObject = new tlw();
    }
    try
    {
      ((tlw)localObject).jdField_a_of_type_JavaNetURL = new URL(this.jdField_a_of_type_Rsj.d);
      ((tlw)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getWidth();
      ((tlw)localObject).b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getHeight();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageForImageCollection((tlw)localObject, new rii(this));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Rsj != null)
    {
      if ((!pqw.c(this.jdField_a_of_type_Rfw.a.a())) && (!pqw.f(this.jdField_a_of_type_Rfw.a.a()))) {
        break label153;
      }
      if (this.jdField_a_of_type_Rsj.c != 1) {
        break label108;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131701772));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#bbbbbb"));
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    label108:
    while ((!pqw.d(this.jdField_a_of_type_Rfw.a.a())) && (!pqw.g(this.jdField_a_of_type_Rfw.a.a()))) {
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Rsj == null)) {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, " topicRecommendInfo: ", this.jdField_a_of_type_Rsj });
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl)) {
      return;
    }
    Object localObject = new Intent(getContext(), PublicAccountBrowser.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    getContext().startActivity((Intent)localObject);
    localObject = pqw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str = pqf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_Rsj.jdField_a_of_type_Int + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    olh.a(null, (String)localObject, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), str, false);
    pqb.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Rfw.a.e());
    pqb.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Szd.a());
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().equals(anvx.a(2131701811)))
    {
      d();
      return;
    }
    a(true);
    String str1 = pqw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str2 = pqf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, pqw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), this.jdField_a_of_type_Rfw.a.e(), NetworkUtil.isWifiConnected(getContext()), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
    olh.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
    pqb.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Rfw.a.e());
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560183, this, true);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131379280));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(AIOUtils.dp2px(3.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363913));
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379282));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)paramView.findViewById(2131379279));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379281));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131379283));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof qfw)) {
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
      localLayoutParams.setMargins(ViewUtils.dip2px(12.0F), 0, ViewUtils.dip2px(15.0F), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      label62:
      localLayoutParams.setMargins(ViewUtils.dip2px(12.0F), 0, ViewUtils.dip2px(2.25F), 0);
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(getContext(), null));
    this.jdField_a_of_type_Bkzi.a(2131695029, 3);
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.setOnDismissListener(new rij(this));
    this.jdField_a_of_type_Bkzi.a(new rik(this));
    if (!this.jdField_a_of_type_Bkzi.isShowing()) {
      this.jdField_a_of_type_Bkzi.show();
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