package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import anni;
import bglf;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import pha;
import pxk;
import qqs;
import qrb;
import qva;
import qvd;
import qve;
import qvf;
import rhn;
import rii;
import snh;

public class ComponentAccountSummary
  extends FrameLayout
  implements qqs
{
  ReadInJoyYAFolderTextView a;
  public qva a;
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
    this.jdField_a_of_type_Qva = new qva();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560124, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131364883));
  }
  
  public void a(Object paramObject)
  {
    pxk localpxk;
    if ((paramObject instanceof pxk))
    {
      localpxk = (pxk)paramObject;
      this.jdField_a_of_type_Qva.a(localpxk);
      if (localpxk.a() != null) {}
    }
    else
    {
      return;
    }
    String str = localpxk.a().mSubscribeName;
    paramObject = localpxk.a().mSummary;
    if ((this.jdField_a_of_type_Qva.c()) || (this.jdField_a_of_type_Qva.g())) {
      paramObject = localpxk.a().mTitle;
    }
    if (TextUtils.isEmpty(paramObject)) {
      if (localpxk.a() == 33) {
        paramObject = anni.a(2131701133);
      }
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject;
      if ((localpxk.a() == 33) && (localpxk.a().mSocialFeedInfo != null) && (localpxk.a().mSocialFeedInfo.jdField_a_of_type_Rii != null)) {
        if (localpxk.a().mSocialFeedInfo.jdField_a_of_type_Rii.b == 0L)
        {
          localObject = localpxk.a().mSocialFeedInfo.jdField_a_of_type_Rii.a;
          label199:
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new qvf(this, (String)localObject, -3355444), 0, str.length(), 33);
          label229:
          localSpannableStringBuilder.append(": ");
          localObject = localpxk.a();
          if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
            break label774;
          }
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.a == null)) {
            break label755;
          }
          paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.a);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.a);
          }
          label352:
          str = anni.a(2131701095);
          paramObject.append(" ");
          paramObject.append(str);
          paramObject.setSpan(new qve((ArticleInfo)localObject, -3355444, getContext(), getResources(), this.jdField_a_of_type_Qva), paramObject.length() - str.length(), paramObject.length(), 33);
          paramObject.append(" ");
          localSpannableStringBuilder.append(paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anni.a(2131701152));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qvd(this, localpxk.a(), -3355444));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
        b();
        return;
        if ((this.jdField_a_of_type_Qva.b()) || (this.jdField_a_of_type_Qva.d()) || (this.jdField_a_of_type_Qva.e()))
        {
          paramObject = anni.a(2131701136);
          break;
        }
        if ((this.jdField_a_of_type_Qva.c()) || (this.jdField_a_of_type_Qva.g()))
        {
          paramObject = anni.a(2131701113);
          break;
        }
        if (this.jdField_a_of_type_Qva.h())
        {
          paramObject = anni.a(2131701124);
          break;
        }
        paramObject = anni.a(2131701138);
        break;
        localObject = String.valueOf(localpxk.a().mSocialFeedInfo.jdField_a_of_type_Rii.b);
        if (pha.a())
        {
          str = bglf.b((QQAppInterface)pha.a(), (String)localObject, true);
          break label199;
        }
        str = localpxk.a().b(localpxk.a().mSocialFeedInfo.jdField_a_of_type_Rii.b);
        break label199;
        if (localpxk.a().mAccountLess == 0)
        {
          localObject = localpxk.a().mSubscribeID;
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new qvf(this, (String)localObject, -3355444), 0, str.length(), 33);
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
          if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.a != null))
          {
            paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.a);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.a);
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
  
  public void a(qrb paramqrb)
  {
    this.jdField_a_of_type_Qva.a(paramqrb);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */