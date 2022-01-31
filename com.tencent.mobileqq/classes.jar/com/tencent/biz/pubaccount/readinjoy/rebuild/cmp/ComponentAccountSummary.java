package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajyc;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import bbcl;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import onk;
import pax;
import pqs;
import prb;
import pvb;
import pve;
import pvf;
import pvg;
import qcy;
import qdt;
import rap;

public class ComponentAccountSummary
  extends FrameLayout
  implements pqs
{
  ReadInJoyYAFolderTextView a;
  public pvb a;
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
    this.jdField_a_of_type_Pvb = new pvb();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559883, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131364590));
  }
  
  public void a(Object paramObject)
  {
    pax localpax;
    if ((paramObject instanceof pax))
    {
      localpax = (pax)paramObject;
      this.jdField_a_of_type_Pvb.a(localpax);
      if (localpax.a() != null) {}
    }
    else
    {
      return;
    }
    String str = localpax.a().mSubscribeName;
    paramObject = localpax.a().mSummary;
    if ((this.jdField_a_of_type_Pvb.c()) || (this.jdField_a_of_type_Pvb.g())) {
      paramObject = localpax.a().mTitle;
    }
    if (TextUtils.isEmpty(paramObject)) {
      if (localpax.a() == 33) {
        paramObject = ajyc.a(2131702318);
      }
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject;
      if ((localpax.a() == 33) && (localpax.a().mSocialFeedInfo != null) && (localpax.a().mSocialFeedInfo.jdField_a_of_type_Qdt != null)) {
        if (localpax.a().mSocialFeedInfo.jdField_a_of_type_Qdt.b == 0L)
        {
          localObject = localpax.a().mSocialFeedInfo.jdField_a_of_type_Qdt.a;
          label199:
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new pvg(this, (String)localObject, -3355444), 0, str.length(), 33);
          label229:
          localSpannableStringBuilder.append(": ");
          localObject = localpax.a();
          if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
            break label774;
          }
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy.a == null)) {
            break label755;
          }
          paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy.a);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy.a);
          }
          label352:
          str = ajyc.a(2131702280);
          paramObject.append(" ");
          paramObject.append(str);
          paramObject.setSpan(new pvf((ArticleInfo)localObject, -3355444, getContext(), getResources(), this.jdField_a_of_type_Pvb), paramObject.length() - str.length(), paramObject.length(), 33);
          paramObject.append(" ");
          localSpannableStringBuilder.append(paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajyc.a(2131702337));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pve(this, localpax.a(), -3355444));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
        b();
        return;
        if ((this.jdField_a_of_type_Pvb.b()) || (this.jdField_a_of_type_Pvb.d()) || (this.jdField_a_of_type_Pvb.e()))
        {
          paramObject = ajyc.a(2131702321);
          break;
        }
        if ((this.jdField_a_of_type_Pvb.c()) || (this.jdField_a_of_type_Pvb.g()))
        {
          paramObject = ajyc.a(2131702298);
          break;
        }
        if (this.jdField_a_of_type_Pvb.h())
        {
          paramObject = ajyc.a(2131702309);
          break;
        }
        paramObject = ajyc.a(2131702323);
        break;
        localObject = String.valueOf(localpax.a().mSocialFeedInfo.jdField_a_of_type_Qdt.b);
        if (onk.a())
        {
          str = bbcl.b((QQAppInterface)onk.a(), (String)localObject, true);
          break label199;
        }
        str = localpax.a().b(localpax.a().mSocialFeedInfo.jdField_a_of_type_Qdt.b);
        break label199;
        if (localpax.a().mAccountLess == 0)
        {
          localObject = localpax.a().mSubscribeID;
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new pvg(this, (String)localObject, -3355444), 0, str.length(), 33);
          break label229;
        }
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, str.length(), 33);
        break label229;
        label755:
        if (((ArticleInfo)localObject).mTitle == null) {
          break label352;
        }
        paramObject.append(((ArticleInfo)localObject).mTitle);
        break label352;
        label774:
        if (this.c)
        {
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy.a != null))
          {
            paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy.a);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcy.a);
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
  
  public void a(prb paramprb)
  {
    this.jdField_a_of_type_Pvb.a(paramprb);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */