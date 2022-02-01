package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import anzj;
import bhlg;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ozs;
import ppu;
import qjg;
import qjp;
import qno;
import qnr;
import qns;
import qnt;
import qyg;
import qzb;
import sel;

public class ComponentAccountSummary
  extends FrameLayout
  implements qjg
{
  ReadInJoyYAFolderTextView a;
  public qno a;
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
    this.jdField_a_of_type_Qno = new qno();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560136, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131364930));
  }
  
  public void a(Object paramObject)
  {
    ppu localppu;
    if ((paramObject instanceof ppu))
    {
      localppu = (ppu)paramObject;
      this.jdField_a_of_type_Qno.a(localppu);
      if (localppu.a() != null) {}
    }
    else
    {
      return;
    }
    String str = localppu.a().mSubscribeName;
    paramObject = localppu.a().mSummary;
    if ((this.jdField_a_of_type_Qno.c()) || (this.jdField_a_of_type_Qno.g())) {
      paramObject = localppu.a().mTitle;
    }
    if (TextUtils.isEmpty(paramObject)) {
      if (localppu.a() == 33) {
        paramObject = anzj.a(2131701240);
      }
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject;
      if ((localppu.a() == 33) && (localppu.a().mSocialFeedInfo != null) && (localppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb != null)) {
        if (localppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb.b == 0L)
        {
          localObject = localppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb.a;
          label199:
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new qnt(this, (String)localObject, -3355444), 0, str.length(), 33);
          label229:
          localSpannableStringBuilder.append(": ");
          localObject = localppu.a();
          if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
            break label774;
          }
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyg == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyg.a == null)) {
            break label755;
          }
          paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyg.a);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyg.a);
          }
          label352:
          str = anzj.a(2131701202);
          paramObject.append(" ");
          paramObject.append(str);
          paramObject.setSpan(new qns((ArticleInfo)localObject, -3355444, getContext(), getResources(), this.jdField_a_of_type_Qno), paramObject.length() - str.length(), paramObject.length(), 33);
          paramObject.append(" ");
          localSpannableStringBuilder.append(paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(anzj.a(2131701259));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new qnr(this, localppu.a(), -3355444));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
        b();
        return;
        if ((this.jdField_a_of_type_Qno.b()) || (this.jdField_a_of_type_Qno.d()) || (this.jdField_a_of_type_Qno.e()))
        {
          paramObject = anzj.a(2131701243);
          break;
        }
        if ((this.jdField_a_of_type_Qno.c()) || (this.jdField_a_of_type_Qno.g()))
        {
          paramObject = anzj.a(2131701220);
          break;
        }
        if (this.jdField_a_of_type_Qno.h())
        {
          paramObject = anzj.a(2131701231);
          break;
        }
        paramObject = anzj.a(2131701245);
        break;
        localObject = String.valueOf(localppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb.b);
        if (ozs.a())
        {
          str = bhlg.b((QQAppInterface)ozs.a(), (String)localObject, true);
          break label199;
        }
        str = localppu.a().b(localppu.a().mSocialFeedInfo.jdField_a_of_type_Qzb.b);
        break label199;
        if (localppu.a().mAccountLess == 0)
        {
          localObject = localppu.a().mSubscribeID;
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new qnt(this, (String)localObject, -3355444), 0, str.length(), 33);
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
          if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyg.a != null))
          {
            paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyg.a);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyg.a);
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
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */