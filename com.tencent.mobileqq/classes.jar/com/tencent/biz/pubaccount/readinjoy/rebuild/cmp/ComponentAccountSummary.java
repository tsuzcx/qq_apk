package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajya;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import bbcz;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import onh;
import pau;
import pqp;
import pqy;
import puy;
import pvb;
import pvc;
import pvd;
import qcv;
import qdq;
import ram;

public class ComponentAccountSummary
  extends FrameLayout
  implements pqp
{
  ReadInJoyYAFolderTextView a;
  public puy a;
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
    this.jdField_a_of_type_Puy = new puy();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559883, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131364589));
  }
  
  public void a(Object paramObject)
  {
    pau localpau;
    if ((paramObject instanceof pau))
    {
      localpau = (pau)paramObject;
      this.jdField_a_of_type_Puy.a(localpau);
      if (localpau.a() != null) {}
    }
    else
    {
      return;
    }
    String str = localpau.a().mSubscribeName;
    paramObject = localpau.a().mSummary;
    if ((this.jdField_a_of_type_Puy.c()) || (this.jdField_a_of_type_Puy.g())) {
      paramObject = localpau.a().mTitle;
    }
    if (TextUtils.isEmpty(paramObject)) {
      if (localpau.a() == 33) {
        paramObject = ajya.a(2131702329);
      }
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject;
      if ((localpau.a() == 33) && (localpau.a().mSocialFeedInfo != null) && (localpau.a().mSocialFeedInfo.jdField_a_of_type_Qdq != null)) {
        if (localpau.a().mSocialFeedInfo.jdField_a_of_type_Qdq.b == 0L)
        {
          localObject = localpau.a().mSocialFeedInfo.jdField_a_of_type_Qdq.a;
          label199:
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new pvd(this, (String)localObject, -3355444), 0, str.length(), 33);
          label229:
          localSpannableStringBuilder.append(": ");
          localObject = localpau.a();
          if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
            break label774;
          }
          paramObject = new SpannableStringBuilder();
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv.a == null)) {
            break label755;
          }
          paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv.a);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv.a);
          }
          label352:
          str = ajya.a(2131702291);
          paramObject.append(" ");
          paramObject.append(str);
          paramObject.setSpan(new pvc((ArticleInfo)localObject, -3355444, getContext(), getResources(), this.jdField_a_of_type_Puy), paramObject.length() - str.length(), paramObject.length(), 33);
          paramObject.append(" ");
          localSpannableStringBuilder.append(paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.c = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setSpanText(ajya.a(2131702348));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new pvb(this, localpau.a(), -3355444));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
        b();
        return;
        if ((this.jdField_a_of_type_Puy.b()) || (this.jdField_a_of_type_Puy.d()) || (this.jdField_a_of_type_Puy.e()))
        {
          paramObject = ajya.a(2131702332);
          break;
        }
        if ((this.jdField_a_of_type_Puy.c()) || (this.jdField_a_of_type_Puy.g()))
        {
          paramObject = ajya.a(2131702309);
          break;
        }
        if (this.jdField_a_of_type_Puy.h())
        {
          paramObject = ajya.a(2131702320);
          break;
        }
        paramObject = ajya.a(2131702334);
        break;
        localObject = String.valueOf(localpau.a().mSocialFeedInfo.jdField_a_of_type_Qdq.b);
        if (onh.a())
        {
          str = bbcz.b((QQAppInterface)onh.a(), (String)localObject, true);
          break label199;
        }
        str = localpau.a().b(localpau.a().mSocialFeedInfo.jdField_a_of_type_Qdq.b);
        break label199;
        if (localpau.a().mAccountLess == 0)
        {
          localObject = localpau.a().mSubscribeID;
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(new pvd(this, (String)localObject, -3355444), 0, str.length(), 33);
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
          if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv.a != null))
          {
            paramObject.append(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv.a);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcv.a);
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
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */