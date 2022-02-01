package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import anvx;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import pkh;
import pnn;
import qfw;
import rbo;
import rbx;
import rfw;
import rfz;
import rga;
import rgb;
import rrl;
import rsh;
import szd;

public class ComponentAccountSummary
  extends FrameLayout
  implements rbo
{
  ReadInJoyYAFolderTextView a;
  public rfw a;
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
  
  private String a(@NotNull qfw paramqfw)
  {
    String str = paramqfw.a().mSummary;
    if ((this.jdField_a_of_type_Rfw.c()) || (this.jdField_a_of_type_Rfw.g())) {
      str = paramqfw.a().mTitle;
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    if (paramqfw.a() == 33) {
      return anvx.a(2131701826);
    }
    if ((this.jdField_a_of_type_Rfw.b()) || (this.jdField_a_of_type_Rfw.d()) || (this.jdField_a_of_type_Rfw.e())) {
      return anvx.a(2131701829);
    }
    if ((this.jdField_a_of_type_Rfw.c()) || (this.jdField_a_of_type_Rfw.g())) {
      return anvx.a(2131701806);
    }
    if (this.jdField_a_of_type_Rfw.h()) {
      return anvx.a(2131701817);
    }
    return anvx.a(2131701831);
  }
  
  private void a(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a);
      QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a);
    }
    for (;;)
    {
      String str = anvx.a(2131701788);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.setSpan(new rga(paramArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Rfw), localSpannableStringBuilder.length() - str.length(), localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(" ");
      paramSpannableStringBuilder.append(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
      return;
      if (paramArticleInfo.mTitle != null) {
        localSpannableStringBuilder.append(paramArticleInfo.mTitle);
      }
    }
  }
  
  private void a(@NotNull qfw paramqfw, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    if ((paramqfw.a() == 33) && (paramqfw.a().mSocialFeedInfo != null) && (paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh != null)) {
      if (paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh.b == 0L)
      {
        paramqfw = paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh.a;
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.setSpan(new rgb(this, paramqfw, -3355444), 0, paramString.length(), 33);
      }
    }
    for (;;)
    {
      paramSpannableStringBuilder.append(": ");
      return;
      paramString = String.valueOf(paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh.b);
      if (pnn.a())
      {
        str = ContactUtils.getBuddyName((QQAppInterface)pkh.a(), paramString, true);
        paramqfw = paramString;
        paramString = str;
        break;
      }
      String str = paramqfw.a().a(paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rsh.b);
      paramqfw = paramString;
      paramString = str;
      break;
      if (paramqfw.a().mAccountLess == 0)
      {
        paramqfw = paramqfw.a().mSubscribeID;
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.setSpan(new rgb(this, paramqfw, -3355444), 0, paramString.length(), 33);
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
    this.jdField_a_of_type_Rfw = new rfw();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull ArticleInfo paramArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null))
    {
      localSpannableStringBuilder.append(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a);
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
  
  private void b(@NotNull qfw paramqfw, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    paramqfw = paramqfw.a();
    if ((this.jdField_a_of_type_Boolean) || (this.b))
    {
      a(paramSpannableStringBuilder, paramqfw);
      return;
    }
    if (this.c)
    {
      b(paramSpannableStringBuilder, paramqfw);
      return;
    }
    paramSpannableStringBuilder.append(paramString);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560190, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365041));
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof qfw)) {}
    do
    {
      return;
      paramObject = (qfw)paramObject;
      this.jdField_a_of_type_Rfw.a(paramObject);
    } while (paramObject.a() == null);
    String str1 = paramObject.a().mSubscribeName;
    String str2 = a(paramObject);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    a(paramObject, localSpannableStringBuilder, str1);
    b(paramObject, localSpannableStringBuilder, str2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anvx.a(2131701845));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new rfz(this, paramObject.a(), -3355444));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
    b();
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */