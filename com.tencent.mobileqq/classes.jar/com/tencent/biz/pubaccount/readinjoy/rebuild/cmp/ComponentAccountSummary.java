package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import alpo;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import bdbt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ors;
import pgd;
import pxk;
import pxt;
import qbs;
import qbv;
import qbw;
import qbx;
import qmr;
import qnm;
import rqj;

public class ComponentAccountSummary
  extends FrameLayout
  implements pxk
{
  ReadInJoyYAFolderTextView a;
  public qbs a;
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
    this.jdField_a_of_type_Qbs = new qbs();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559978, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131364667));
  }
  
  public void a(Object paramObject)
  {
    pgd localpgd;
    if ((paramObject instanceof pgd))
    {
      localpgd = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(localpgd);
      if (localpgd.a() != null) {}
    }
    else
    {
      return;
    }
    String str = localpgd.a().mSubscribeName;
    paramObject = localpgd.a().mSummary;
    if ((this.jdField_a_of_type_Qbs.c()) || (this.jdField_a_of_type_Qbs.g())) {
      paramObject = localpgd.a().mTitle;
    }
    if (TextUtils.isEmpty(paramObject)) {
      if (localpgd.a() == 33) {
        paramObject = alpo.a(2131702701);
      }
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject;
      if ((localpgd.a() == 33) && (localpgd.a().mSocialFeedInfo != null) && (localpgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm != null)) {
        if (localpgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm.b == 0L)
        {
          localObject = localpgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm.a;
          label199:
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new qbx(this, (String)localObject, -3355444), 0, str.length(), 33);
          label229:
          localSpannableStringBuilder.append(": ");
          localObject = localpgd.a();
          if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
            break label774;
          }
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmr == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmr.a == null)) {
            break label755;
          }
          paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmr.a);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmr.a);
          }
          label352:
          str = alpo.a(2131702663);
          paramObject.append(" ");
          paramObject.append(str);
          paramObject.setSpan(new qbw((ArticleInfo)localObject, -3355444, getContext(), getResources(), this.jdField_a_of_type_Qbs), paramObject.length() - str.length(), paramObject.length(), 33);
          paramObject.append(" ");
          localSpannableStringBuilder.append(paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(alpo.a(2131702720));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qbv(this, localpgd.a(), -3355444));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
        b();
        return;
        if ((this.jdField_a_of_type_Qbs.b()) || (this.jdField_a_of_type_Qbs.d()) || (this.jdField_a_of_type_Qbs.e()))
        {
          paramObject = alpo.a(2131702704);
          break;
        }
        if ((this.jdField_a_of_type_Qbs.c()) || (this.jdField_a_of_type_Qbs.g()))
        {
          paramObject = alpo.a(2131702681);
          break;
        }
        if (this.jdField_a_of_type_Qbs.h())
        {
          paramObject = alpo.a(2131702692);
          break;
        }
        paramObject = alpo.a(2131702706);
        break;
        localObject = String.valueOf(localpgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm.b);
        if (ors.a())
        {
          str = bdbt.b((QQAppInterface)ors.a(), (String)localObject, true);
          break label199;
        }
        str = localpgd.a().b(localpgd.a().mSocialFeedInfo.jdField_a_of_type_Qnm.b);
        break label199;
        if (localpgd.a().mAccountLess == 0)
        {
          localObject = localpgd.a().mSubscribeID;
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new qbx(this, (String)localObject, -3355444), 0, str.length(), 33);
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
          if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmr.a != null))
          {
            paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmr.a);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qmr.a);
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
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */