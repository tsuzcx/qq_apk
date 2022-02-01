package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import amtj;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import pay;
import pvc;
import qpj;
import qps;
import qtr;
import qtu;
import qtv;
import qtw;
import rfe;
import rga;
import slt;

public class ComponentAccountSummary
  extends FrameLayout
  implements qpj
{
  ReadInJoyYAFolderTextView a;
  public qtr a;
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
  
  private String a(@NotNull pvc parampvc)
  {
    String str = parampvc.a().mSummary;
    if ((this.jdField_a_of_type_Qtr.c()) || (this.jdField_a_of_type_Qtr.g())) {
      str = parampvc.a().mTitle;
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    if (parampvc.a() == 33) {
      return amtj.a(2131701475);
    }
    if ((this.jdField_a_of_type_Qtr.b()) || (this.jdField_a_of_type_Qtr.d()) || (this.jdField_a_of_type_Qtr.e())) {
      return amtj.a(2131701478);
    }
    if ((this.jdField_a_of_type_Qtr.c()) || (this.jdField_a_of_type_Qtr.g())) {
      return amtj.a(2131701455);
    }
    if (this.jdField_a_of_type_Qtr.h()) {
      return amtj.a(2131701466);
    }
    return amtj.a(2131701480);
  }
  
  private void a(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a);
      QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a);
    }
    for (;;)
    {
      String str = amtj.a(2131701437);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.setSpan(new qtv(paramArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Qtr), localSpannableStringBuilder.length() - str.length(), localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(" ");
      paramSpannableStringBuilder.append(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
      return;
      if (paramArticleInfo.mTitle != null) {
        localSpannableStringBuilder.append(paramArticleInfo.mTitle);
      }
    }
  }
  
  private void a(@NotNull pvc parampvc, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    if ((parampvc.a() == 33) && (parampvc.a().mSocialFeedInfo != null) && (parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga != null)) {
      if (parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga.b == 0L)
      {
        parampvc = parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga.a;
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.setSpan(new qtw(this, parampvc, -3355444), 0, paramString.length(), 33);
      }
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(": ");
      return;
      paramString = String.valueOf(parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga.b);
      if (pay.a())
      {
        str = ContactUtils.getBuddyName((QQAppInterface)pay.a(), paramString, true);
        parampvc = paramString;
        paramString = str;
        break;
      }
      String str = parampvc.a().a(parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rga.b);
      parampvc = paramString;
      paramString = str;
      break;
      if (parampvc.a().mAccountLess == 0)
      {
        parampvc = parampvc.a().mSubscribeID;
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.setSpan(new qtw(this, parampvc, -3355444), 0, paramString.length(), 33);
      }
      else
      {
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramString.length(), 33);
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qtr = new qtr();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a);
      }
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(localSpannableStringBuilder);
      return;
      if (paramArticleInfo.mTitle != null) {
        localSpannableStringBuilder.append(paramArticleInfo.mTitle);
      }
    }
  }
  
  private void b(@NotNull pvc parampvc, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    parampvc = parampvc.a();
    if ((this.jdField_a_of_type_Boolean) || (this.b))
    {
      a(paramSpannableStringBuilder, parampvc);
      return;
    }
    if (this.c)
    {
      b(paramSpannableStringBuilder, parampvc);
      return;
    }
    paramSpannableStringBuilder.append(paramString);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560143, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131364957));
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof pvc)) {}
    do
    {
      return;
      paramObject = (pvc)paramObject;
      this.jdField_a_of_type_Qtr.a(paramObject);
    } while (paramObject.a() == null);
    String str1 = paramObject.a().mSubscribeName;
    String str2 = a(paramObject);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    a(paramObject, localSpannableStringBuilder, str1);
    b(paramObject, localSpannableStringBuilder, str2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(amtj.a(2131701494));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qtu(this, paramObject.a(), -3355444));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
    b();
  }
  
  public void a(qps paramqps)
  {
    this.jdField_a_of_type_Qtr.a(paramqps);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */