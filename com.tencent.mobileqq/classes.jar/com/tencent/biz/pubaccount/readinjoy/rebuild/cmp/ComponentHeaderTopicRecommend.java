package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
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
import bbcz;
import bbef;
import bbfj;
import bbll;
import bfpc;
import bfpp;
import bhvy;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import nol;
import ong;
import onh;
import osg;
import pau;
import pbu;
import puy;
import pva;
import pvc;
import pxk;
import pxl;
import pxm;
import pxn;
import pxo;
import pxp;
import pxq;
import pym;
import qci;
import qda;
import qdc;
import qdq;
import qds;
import ram;
import rph;

public class ComponentHeaderTopicRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = ajya.a(2131702310);
  private static final String jdField_b_of_type_JavaLangString = ajya.a(2131702333);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfpc jdField_a_of_type_Bfpc;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  private ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView;
  private qds jdField_a_of_type_Qds;
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
      localBitmap = bbef.b(paramBitmap, actj.a(3.0F, getResources()), paramBitmap.getWidth(), paramBitmap.getHeight());
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
    Object localObject = onh.a();
    if (this.jdField_a_of_type_Qds != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (paramBoolean) {
        osg.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qds.jdField_a_of_type_Int), true, new pxn(this), 3);
      }
    }
    else
    {
      return;
    }
    osg.a().a().a((String)localObject, Long.toString(this.jdField_a_of_type_Qds.jdField_a_of_type_Int), false, new pxo(this), 3);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Puy.a != null) && (this.jdField_a_of_type_Puy.a.a() != null) && (this.jdField_a_of_type_Puy.a.a().mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_Puy.a.a().mTopicRecommendFeedsInfo.a.size() > 0);
  }
  
  private void e()
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Puy.a.a();
      this.jdField_a_of_type_Qds = ((qds)this.jdField_a_of_type_Puy.a.a().mTopicRecommendFeedsInfo.a.get(0));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Puy.a.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    h();
    i();
    j();
    if (ram.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
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
      localSpannableStringBuilder.setSpan(new pxq(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, -3355444), 0, localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append(": ");
    localSpannableStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9))
    {
      String str = ajya.a(2131702256);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(str);
      pvc localpvc = new pvc(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Puy);
      localpvc.jdField_a_of_type_Int = 17;
      localSpannableStringBuilder.setSpan(localpvc, localSpannableStringBuilder.length() - str.length(), localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(" ");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajya.a(2131702293));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pxp(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
  }
  
  private void g()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null))
    {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "Some ugc info is null. ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo });
      return;
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.a;
    localSpannableStringBuilder.append(onh.d(bbcz.b((QQAppInterface)onh.a(), String.valueOf(l), true)));
    localSpannableStringBuilder.setSpan(new pva(l, -3355444, this.jdField_a_of_type_Puy), 0, localSpannableStringBuilder.length(), 33);
    localSpannableStringBuilder.append(": ");
    if ((puy.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ram.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      localSpannableStringBuilder.append(((qdc)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.b.get(0)).e);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajya.a(2131702259));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pxp(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
      return;
      pym.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView, this.jdField_a_of_type_Puy, localSpannableStringBuilder);
    }
  }
  
  private void h()
  {
    if (!b()) {}
    while ((this.jdField_a_of_type_Puy.a == null) || (this.jdField_a_of_type_Puy.a.a() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((onh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (onh.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTime > 0L) {
        localStringBuilder.append(ong.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendTime, true));
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
        localStringBuilder.append(bhvy.a(((qds)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b) + jdField_b_of_type_JavaLangString);
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
      localObject = new rph();
    }
    try
    {
      ((rph)localObject).jdField_a_of_type_JavaNetURL = new URL(this.jdField_a_of_type_Qds.d);
      ((rph)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getWidth();
      ((rph)localObject).b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getHeight();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.a((rph)localObject, new pxk(this));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Qds != null)
    {
      if ((!onh.b(this.jdField_a_of_type_Puy.a.a())) && (!onh.e(this.jdField_a_of_type_Puy.a.a()))) {
        break label153;
      }
      if (this.jdField_a_of_type_Qds.c != 1) {
        break label108;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131702275));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#bbbbbb"));
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    label108:
    while ((!onh.c(this.jdField_a_of_type_Puy.a.a())) && (!onh.f(this.jdField_a_of_type_Puy.a.a()))) {
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Qds == null)) {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, " topicRecommendInfo: ", this.jdField_a_of_type_Qds });
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl)) {
      return;
    }
    Object localObject = new Intent(getContext(), PublicAccountBrowser.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    getContext().startActivity((Intent)localObject);
    localObject = onh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str = onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_Qds.jdField_a_of_type_Int + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    nol.a(null, (String)localObject, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), str, false);
    ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Puy.a.e());
    onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Ram.a());
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().equals(ajya.a(2131702314)))
    {
      d();
      return;
    }
    a(true);
    String str1 = onh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str2 = onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), this.jdField_a_of_type_Puy.a.e(), bbfj.h(getContext()), str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId + "");
    nol.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID), str2, false);
    ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Puy.a.e());
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559876, this, true);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131377606));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(actj.a(3.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363544));
    this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377608));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)paramView.findViewById(2131377605));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377607));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377609));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pau)) {
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
      localLayoutParams.setMargins(bbll.a(12.0F), 0, bbll.a(15.0F), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      label62:
      localLayoutParams.setMargins(bbll.a(12.0F), 0, bbll.a(2.25F), 0);
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(getContext(), null));
    this.jdField_a_of_type_Bfpc.a(2131695617, 3);
    this.jdField_a_of_type_Bfpc.c(2131690596);
    this.jdField_a_of_type_Bfpc.setOnDismissListener(new pxl(this));
    this.jdField_a_of_type_Bfpc.a(new pxm(this));
    if (!this.jdField_a_of_type_Bfpc.isShowing()) {
      this.jdField_a_of_type_Bfpc.show();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363544: 
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